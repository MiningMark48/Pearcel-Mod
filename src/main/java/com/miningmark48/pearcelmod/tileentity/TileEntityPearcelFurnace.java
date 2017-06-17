package com.miningmark48.pearcelmod.tileentity;

import com.miningmark48.pearcelmod.block.BlockPearcelFurnace;
import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import com.miningmark48.pearcelmod.init.ModBlocks;
import com.miningmark48.pearcelmod.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.datafix.FixTypes;
import net.minecraft.util.datafix.walkers.ItemStackDataLists;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class TileEntityPearcelFurnace extends TileEntityLockable implements ITickable, ISidedInventory{

    private static final int[] SLOTS_TOP = new int[] {0};
    private static final int[] SLOTS_BOTTOM = new int[] {2, 1};
    private static final int[] SLOTS_SIDES = new int[] {1};
//    private ItemStack[] furnaceItemStacks = new ItemStack[3];
private NonNullList<ItemStack> furnaceItemStacks = NonNullList.<ItemStack>withSize(3, ItemStack.EMPTY);
    private int furnaceBurnTime;
    private int currentItemBurnTime;
    private int cookTime;
    private int totalCookTime;
    private String furnaceCustomName;

    private static int speedMultiplier = ConfigurationHandler.pearcelFurnace_speedMultiplier;
    private static int effiency = ConfigurationHandler.pearcelFurnace_efficiency;

    public int getSizeInventory()
    {
        return this.furnaceItemStacks.size();
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack itemstack : this.furnaceItemStacks)
        {
            if (!itemstack.isEmpty())
            {
                return false;
            }
        }

        return true;
    }

    @Nullable
    public ItemStack getStackInSlot(int index)
    {
        return this.furnaceItemStacks.get(index);
    }

    @Nullable
    public ItemStack decrStackSize(int index, int count)
    {
        return ItemStackHelper.getAndSplit(this.furnaceItemStacks, index, count);
    }

    @Nullable
    public ItemStack removeStackFromSlot(int index)
    {
        return ItemStackHelper.getAndRemove(this.furnaceItemStacks, index);
    }

    public void setInventorySlotContents(int index, @Nullable ItemStack stack)
    {
        boolean flag = stack != null && stack.isItemEqual(this.furnaceItemStacks.get(index)) && ItemStack.areItemStackTagsEqual(stack, this.furnaceItemStacks.get(index));
        this.furnaceItemStacks.set(index, stack);

        if (stack != ItemStack.EMPTY && stack.getCount() > this.getInventoryStackLimit())
        {
            stack.setCount(this.getInventoryStackLimit());
        }

        if (index == 0 && !flag)
        {
            this.totalCookTime = this.getCookTime(stack);
            this.cookTime = 0;
            this.markDirty();
        }
    }

    public String getName()
    {
        return this.hasCustomName() ? this.furnaceCustomName : ModBlocks.pearcel_furnace.getLocalizedName();
    }

    public boolean hasCustomName()
    {
        return this.furnaceCustomName != null && !this.furnaceCustomName.isEmpty();
    }

    public void setCustomInventoryName(String p_145951_1_)
    {
        this.furnaceCustomName = p_145951_1_;
    }

//    public static void registerFixesFurnace(DataFixer fixer)
//    {
//        fixer.registerWalker(FixTypes.BLOCK_ENTITY, new ItemStackDataLists("Furnace", new String[] {"Items"}));
//    }

    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        NBTTagList nbttaglist = compound.getTagList("Items", 10);
        this.furnaceItemStacks = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);

        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound = nbttaglist.getCompoundTagAt(i);
            int j = nbttagcompound.getByte("Slot");

            if (j >= 0 && j < this.furnaceItemStacks.size())
            {
                this.furnaceItemStacks.set(j, new ItemStack(nbttagcompound));
            }
        }

        this.furnaceBurnTime = compound.getInteger("BurnTime");
        this.cookTime = compound.getInteger("CookTime");
        this.totalCookTime = compound.getInteger("CookTimeTotal");
        this.currentItemBurnTime = getItemBurnTime(this.furnaceItemStacks.get(1));

        if (compound.hasKey("CustomName", 8))
        {
            this.furnaceCustomName = compound.getString("CustomName");
        }
    }

    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        compound.setInteger("BurnTime", this.furnaceBurnTime);
        compound.setInteger("CookTime", this.cookTime);
        compound.setInteger("CookTimeTotal", this.totalCookTime);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.furnaceItemStacks.size(); ++i)
        {
            if (this.furnaceItemStacks.get(i) != ItemStack.EMPTY)
            {
                NBTTagCompound nbttagcompound = new NBTTagCompound();
                nbttagcompound.setByte("Slot", (byte)i);
                this.furnaceItemStacks.get(i).writeToNBT(nbttagcompound);
                nbttaglist.appendTag(nbttagcompound);
            }
        }

        compound.setTag("Items", nbttaglist);

        if (this.hasCustomName())
        {
            compound.setString("CustomName", this.furnaceCustomName);
        }

        return compound;
    }

    public int getInventoryStackLimit()
    {
        return 64;
    }

    public boolean isBurning()
    {
        return this.furnaceBurnTime > 0;
    }

    @SideOnly(Side.CLIENT)
    public static boolean isBurning(IInventory inventory)
    {
        return inventory.getField(0) > 0;
    }

    public void update()
    {
        boolean flag = this.isBurning();
        boolean flag1 = false;

        if (this.isBurning())
        {
            --this.furnaceBurnTime;
        }

        if (!this.world.isRemote)
        {
            ItemStack itemstack = (ItemStack)this.furnaceItemStacks.get(1);

            if (this.isBurning() || !itemstack.isEmpty() && !((ItemStack)this.furnaceItemStacks.get(0)).isEmpty())
            {
                if (!this.isBurning() && this.canSmelt())
                {
                    this.furnaceBurnTime = getItemBurnTime(itemstack);
                    this.currentItemBurnTime = this.furnaceBurnTime;

                    if (this.isBurning())
                    {
                        flag1 = true;

                        if (!itemstack.isEmpty())
                        {
                            Item item = itemstack.getItem();
                            itemstack.shrink(1);

                            if (itemstack.isEmpty())
                            {
                                ItemStack item1 = item.getContainerItem(itemstack);
                                this.furnaceItemStacks.set(1, item1);
                            }
                        }
                    }
                }

                if (this.isBurning() && this.canSmelt())
                {
                    ++this.cookTime;

                    if (this.cookTime == this.totalCookTime)
                    {
                        this.cookTime = 0;
                        this.totalCookTime = this.getCookTime((ItemStack)this.furnaceItemStacks.get(0));
                        this.smeltItem();
                        flag1 = true;
                    }
                }
                else
                {
                    this.cookTime = 0;
                }
            }
            else if (!this.isBurning() && this.cookTime > 0)
            {
                this.cookTime = MathHelper.clamp(this.cookTime - 2, 0, this.totalCookTime);
            }

            if (flag != this.isBurning())
            {
                flag1 = true;
                BlockPearcelFurnace.setState(this.isBurning(), this.world, this.pos);
            }
        }

        if (flag1)
        {
            this.markDirty();
        }

    }

    public int getCookTime(@Nullable ItemStack stack)
    {
        return (200) / speedMultiplier;
    }

    private boolean canSmelt()
    {
        if (((ItemStack)this.furnaceItemStacks.get(0)).isEmpty())
        {
            return false;
        }
        else
        {
            ItemStack itemstack = FurnaceRecipes.instance().getSmeltingResult((ItemStack)this.furnaceItemStacks.get(0));

            if (itemstack.isEmpty())
            {
                return false;
            }
            else
            {
                ItemStack itemstack1 = (ItemStack)this.furnaceItemStacks.get(2);
                if (itemstack1.isEmpty()) return true;
                if (!itemstack1.isItemEqual(itemstack)) return false;
                int result = itemstack1.getCount() + itemstack.getCount();
                return result <= getInventoryStackLimit() && result <= itemstack1.getMaxStackSize(); // Forge fix: make furnace respect stack sizes in furnace recipes
            }
        }
    }

    public void smeltItem()
    {
        if (this.canSmelt())
        {
            ItemStack itemstack = (ItemStack)this.furnaceItemStacks.get(0);
            ItemStack itemstack1 = FurnaceRecipes.instance().getSmeltingResult(itemstack);
            ItemStack itemstack2 = (ItemStack)this.furnaceItemStacks.get(2);

            if (itemstack2.isEmpty())
            {
                this.furnaceItemStacks.set(2, itemstack1.copy());
            }
            else if (itemstack2.getItem() == itemstack1.getItem())
            {
                itemstack2.grow(itemstack1.getCount());
            }

            if (itemstack.getItem() == Item.getItemFromBlock(Blocks.SPONGE) && itemstack.getMetadata() == 1 && !((ItemStack)this.furnaceItemStacks.get(1)).isEmpty() && ((ItemStack)this.furnaceItemStacks.get(1)).getItem() == Items.BUCKET)
            {
                this.furnaceItemStacks.set(1, new ItemStack(Items.WATER_BUCKET));
            }

            itemstack.shrink(1);
        }
    }

    public static int getItemBurnTime(ItemStack stack)
    {

        if (stack == ItemStack.EMPTY)
        {
            return 0;
        }
        else
        {
            Item item = stack.getItem();

            if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.AIR)
            {
                Block block = Block.getBlockFromItem(item);

                if (block == Blocks.WOODEN_SLAB)
                {
                    return 150*effiency;
                }

                if (block.getDefaultState().getMaterial() == Material.WOOD)
                {
                    return 300*effiency;
                }

                if (block == Blocks.COAL_BLOCK)
                {
                    return 16000*effiency;
                }
            }

            if (item instanceof ItemTool && "WOOD".equals(((ItemTool)item).getToolMaterialName())) return 200*effiency;
            if (item instanceof ItemSword && "WOOD".equals(((ItemSword)item).getToolMaterialName())) return 200*effiency;
            if (item instanceof ItemHoe && "WOOD".equals(((ItemHoe)item).getMaterialName())) return 200*effiency;
            if (item == Items.STICK) return 100*effiency;
            if (item == Items.COAL) return 1600*effiency;
            if (item == Items.LAVA_BUCKET) return 20000*effiency;
            if (item == Item.getItemFromBlock(Blocks.SAPLING)) return 100*effiency;
            if (item == Items.BLAZE_ROD) return 2400*effiency;
            return net.minecraftforge.fml.common.registry.GameRegistry.getFuelValue(stack) * effiency;
        }
    }

    public static boolean isItemFuel(ItemStack stack)
    {
        return getItemBurnTime(stack) > 0;
    }

    public boolean isUsableByPlayer(EntityPlayer player)
    {
        return this.world.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
    }

    public void openInventory(EntityPlayer player)
    {
    }

    public void closeInventory(EntityPlayer player)
    {
    }

    public boolean isItemValidForSlot(int index, ItemStack stack)
    {
        if (index == 2)
        {
            return false;
        }
        else if (index != 1)
        {
            return true;
        }
        else
        {
            ItemStack itemstack = this.furnaceItemStacks.get(1);
            return isItemFuel(stack) || SlotFurnaceFuel.isBucket(stack) && (itemstack == ItemStack.EMPTY || itemstack.getItem() != Items.BUCKET);
        }
    }

    public int[] getSlotsForFace(EnumFacing side)
    {
        return side == EnumFacing.DOWN ? SLOTS_BOTTOM : (side == EnumFacing.UP ? SLOTS_TOP : SLOTS_SIDES);
    }

    public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction)
    {
        return this.isItemValidForSlot(index, itemStackIn);
    }

    public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction)
    {
        if (direction == EnumFacing.DOWN && index == 1)
        {
            Item item = stack.getItem();

            if (item != Items.WATER_BUCKET && item != Items.BUCKET)
            {
                return false;
            }
        }

        return true;
    }

    public String getGuiID()
    {
        return "pearcelmod:pearcel_furnace";
    }

    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn)
    {
        return new ContainerFurnace(playerInventory, this);
    }

    public int getField(int id)
    {
        switch (id)
        {
            case 0:
                return this.furnaceBurnTime;
            case 1:
                return this.currentItemBurnTime;
            case 2:
                return this.cookTime;
            case 3:
                return this.totalCookTime;
            default:
                return 0;
        }
    }

    public void setField(int id, int value)
    {
        switch (id)
        {
            case 0:
                this.furnaceBurnTime = value;
                break;
            case 1:
                this.currentItemBurnTime = value;
                break;
            case 2:
                this.cookTime = value;
                break;
            case 3:
                this.totalCookTime = value;
        }
    }

    public int getFieldCount()
    {
        return 4;
    }

    public void clear()
    {
        for (int i = 0; i < this.furnaceItemStacks.size(); ++i)
        {
            this.furnaceItemStacks.set(i, ItemStack.EMPTY);
        }
    }

    net.minecraftforge.items.IItemHandler handlerTop = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.UP);
    net.minecraftforge.items.IItemHandler handlerBottom = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.DOWN);
    net.minecraftforge.items.IItemHandler handlerSide = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.WEST);

    @SuppressWarnings("unchecked")
    @Override
    public <T> T getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, net.minecraft.util.EnumFacing facing)
    {
        if (facing != null && capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
            if (facing == EnumFacing.DOWN)
                return (T) handlerBottom;
            else if (facing == EnumFacing.UP)
                return (T) handlerTop;
            else
                return (T) handlerSide;
        return super.getCapability(capability, facing);
    }
}
