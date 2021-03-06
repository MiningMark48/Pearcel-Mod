package com.miningmark48.pearcelmod.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.world.World;

public class ContainerPCP extends Container{

    public InventoryCrafting craftMatrix;
    public IInventory craftResult;
    private World worldObj;
    private int posX;
    private int posY;
    private int posZ;

    public ContainerPCP(InventoryPlayer player, World world, int x, int y, int z){
        craftMatrix = new InventoryCrafting(this, 3, 3);
        craftResult = new InventoryCraftResult();
        worldObj = world;
        this.posX = x;
        this.posY = y;
        this.posZ = z;

        this.addSlotToContainer(new SlotCrafting(player.player, craftMatrix, craftResult, 0, 124, 35));

        for (int i = 0; i < 3; i++){
            for (int k = 0; k < 3; k++){
                this.addSlotToContainer(new Slot(craftMatrix, k + i * 3, 30 + k * 18, 17 + i * 18));
            }
        }

        for (int i = 0; i < 3; i++){
            for (int k = 0; k < 9; k++){
                this.addSlotToContainer(new Slot(player, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
            }
        }

        for (int i = 0; i < 9; i++){
            this.addSlotToContainer(new Slot(player, i, 8 + i * 18, 142));
        }

        this.onCraftMatrixChanged(this.craftMatrix);
    }

    public void onCraftMatrixChanged(IInventory player)
    {
        this.craftResult.setInventorySlotContents(0, CraftingManager.findMatchingRecipe(this.craftMatrix, this.worldObj));
    }

    @Override
    public boolean canInteractWith(EntityPlayer player){
        return true;
    }

    public void onContainerClosed(EntityPlayer player)
    {
        super.onContainerClosed(player);

        if (!this.worldObj.isRemote)
        {
            for (int i = 0; i < 9; ++i)
            {
                ItemStack itemstack = this.craftMatrix.getStackInSlot(i);

                if (itemstack != null)
                {
                    player.dropItem(itemstack, false);
                }
            }
        }
    }

    public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_)
    {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = (Slot)this.inventorySlots.get(p_82846_2_);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (p_82846_2_ == 0)
            {
                if (!this.mergeItemStack(itemstack1, 10, 46, true))
                {
                    return ItemStack.EMPTY;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (p_82846_2_ >= 10 && p_82846_2_ < 37)
            {
                if (!this.mergeItemStack(itemstack1, 37, 46, false))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if (p_82846_2_ >= 37 && p_82846_2_ < 46)
            {
                if (!this.mergeItemStack(itemstack1, 10, 37, false))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 10, 46, false))
            {
                return ItemStack.EMPTY;
            }

            if (itemstack1.getCount() == 0)
            {
                slot.putStack(ItemStack.EMPTY);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount())
            {
                return ItemStack.EMPTY;
            }

            slot.onTake(p_82846_1_, itemstack1);
        }

        return itemstack;
    }

}
