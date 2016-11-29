package com.miningmark48.pearcelmod.container;

import com.miningmark48.pearcelmod.inventory.InventoryPearcelBackpack;
import com.miningmark48.pearcelmod.tileentity.TileEntityPearcelStorageCrate;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;

public class ContainerPearcelStorageCrate extends Container {

    private TileEntityPearcelStorageCrate te;
    private static int INV_START = 0;
    private static int INV_END = INV_START + 26, HOTBAR_START = INV_END + 1, HOTBAR_END = HOTBAR_START + 8;

    public ContainerPearcelStorageCrate(IInventory playerInv, TileEntityPearcelStorageCrate te){
        this.te = te;

        INV_START = te.getSizeInventory();

        int i;
        for (i = 0; i < te.getSizeInventory(); i++){
            this.addSlotToContainer(new Slot(te, i, 8 + (18 * (int)(i%9)), 17 + (18 * (int)(i/9))));
        }

        for (i = 0; i < 3; i++){
            for (int j = 0; j < 9; j++){
                this.addSlotToContainer(new Slot(playerInv, j + i * 9 + 9, 8 + j * 18, 93 + i * 18));
            }
        }

        for (i = 0; i < 9; i++){
            this.addSlotToContainer(new Slot(playerInv, i, 8 + i * 18, 151));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return te.isUseableByPlayer(playerIn);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int index){
        ItemStack stack = null;
        Slot slot = (Slot) this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()){
            ItemStack itemstack1 = slot.getStack();
            stack = itemstack1.copy();

            if (index < INV_START){
                if (!this.mergeItemStack(itemstack1, INV_START, HOTBAR_END + 1, true)){
                    return null;
                }

                slot.onSlotChange(itemstack1, stack);
            }else{
                if(!this.mergeItemStack(itemstack1, 0, INV_START, false)){
                    return null;
                }
            }

            if (itemstack1.stackSize == 0){
                slot.putStack((ItemStack) null);
            }else{
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == stack.stackSize){
                return null;
            }

            slot.onPickupFromSlot(player, itemstack1);

        }

        return stack;

    }

}
