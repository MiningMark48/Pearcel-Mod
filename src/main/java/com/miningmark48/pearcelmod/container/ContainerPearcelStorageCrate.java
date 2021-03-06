package com.miningmark48.pearcelmod.container;

import com.miningmark48.pearcelmod.tileentity.TileEntityPearcelStorageCrate;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class ContainerPearcelStorageCrate extends Container {

    private TileEntityPearcelStorageCrate te;
    private static final int INV_START = TileEntityPearcelStorageCrate.INV_SIZE, INV_END = INV_START + 26, HOTBAR_START = INV_END + 1, HOTBAR_END = HOTBAR_START + 8;
    private static final EntityEquipmentSlot[] VALID_EQUIPMENT_SLOTS = new EntityEquipmentSlot[] {EntityEquipmentSlot.HEAD, EntityEquipmentSlot.CHEST, EntityEquipmentSlot.LEGS, EntityEquipmentSlot.FEET};

    public ContainerPearcelStorageCrate(final IInventory playerInv, TileEntityPearcelStorageCrate te, final EntityPlayer player){
        this.te = te;

        //Tile Entity
        int i;
        for (i = 0; i < te.getSizeInventory(); i++){
            this.addSlotToContainer(new Slot(te, i, 8 + (18 * (int)(i%9)), 17 + (18 * (int)(i/9))));
        }

        //Player Inventory
        for (i = 0; i < 3; i++){
            for (int j = 0; j < 9; j++){
                this.addSlotToContainer(new Slot(playerInv, j + i * 9 + 9, 8 + j * 18, 93 + i * 18));
            }
        }

        //Hotbar
        for (i = 0; i < 9; i++){
            this.addSlotToContainer(new Slot(playerInv, i, 8 + i * 18, 151));
        }

        //Armor
        for (int k = 0; k < 4; ++k)
        {
            final EntityEquipmentSlot entityequipmentslot = VALID_EQUIPMENT_SLOTS[k];
            this.addSlotToContainer(new Slot(playerInv, 36 + (3 - k), -16, 17 + k * 18)
            {
                public int getSlotStackLimit()
                {
                    return 1;
                }
                public boolean isItemValid(@Nullable ItemStack stack)
                {
                    if (stack == ItemStack.EMPTY)
                    {
                        return false;
                    }
                    else
                    {
                        return stack.getItem().isValidArmor(stack, entityequipmentslot, player);
                    }
                }
                @Nullable
                @SideOnly(Side.CLIENT)
                public String getSlotTexture()
                {
                    return ItemArmor.EMPTY_SLOT_NAMES[entityequipmentslot.getIndex()];
                }
            });
        }

        //Offhand
        this.addSlotToContainer(new Slot(playerInv, 40, -16, 151)
        {
            public boolean isItemValid(@Nullable ItemStack stack)
            {
                return super.isItemValid(stack);
            }
            @Nullable
            @SideOnly(Side.CLIENT)
            public String getSlotTexture()
            {
                return "minecraft:items/empty_armor_slot_shield";
            }
        });

    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return te.isUsableByPlayer(playerIn);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int index){
        ItemStack stack = ItemStack.EMPTY;
        Slot slot = (Slot) this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()){
            ItemStack itemstack1 = slot.getStack();
            stack = itemstack1.copy();

            if (index < INV_START){
                if (!this.mergeItemStack(itemstack1, INV_START, HOTBAR_END + 1, true)){
                    return ItemStack.EMPTY;
                }

                slot.onSlotChange(itemstack1, stack);
            }else{
                if(!this.mergeItemStack(itemstack1, 0, INV_START, false)){
                    return ItemStack.EMPTY;
                }
            }

            if (itemstack1.getCount() == 0){
                slot.putStack(ItemStack.EMPTY);
            }else{
                slot.onSlotChanged();
            }

            if (itemstack1.getCount() == stack.getCount()){
                return ItemStack.EMPTY;
            }

            slot.onTake(player, itemstack1);

        }

        return stack;

    }

//    @Override
//    public ItemStack slotClick(int slot, int button, ClickType flag, EntityPlayer player){
//        if (slot >= 0 && getSlot(slot) != null)
//        {
//            return null;
//        }
//        return super.slotClick(slot, button, flag, player);
//    }
}
