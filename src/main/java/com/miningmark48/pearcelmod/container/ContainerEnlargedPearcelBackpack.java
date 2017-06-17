package com.miningmark48.pearcelmod.container;

import com.miningmark48.pearcelmod.inventory.InventoryEnlargedPearcelBackpack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;


public class ContainerEnlargedPearcelBackpack extends Container {

    public final InventoryEnlargedPearcelBackpack inventory;
    private static final int INV_START = InventoryEnlargedPearcelBackpack.INV_SIZE, INV_END = INV_START + 26, HOTBAR_START = INV_END + 1, HOTBAR_END = HOTBAR_START + 8;

    public ContainerEnlargedPearcelBackpack(EntityPlayer player, InventoryPlayer invPlayer, InventoryEnlargedPearcelBackpack item){
        this.inventory = item;

        int i;
        for (i = 0; i < InventoryEnlargedPearcelBackpack.INV_SIZE; i++){
            this.addSlotToContainer(new Slot(this.inventory, i, 8 + (18 * (int)(i%9)), 17 + (18 * (int)(i/9))));
        }

        for (i = 0; i < 3; i++){
            for (int j = 0; j < 9; j++){
                this.addSlotToContainer(new Slot(invPlayer, j + i * 9 + 9, 8 + j * 18, 165 + i * 18));
            }
        }

        for (i = 0; i < 9; i++){
            this.addSlotToContainer(new Slot(invPlayer, i, 8 + i * 18, 223));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return inventory.isUsableByPlayer(playerIn);
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

            if (itemstack1.isEmpty()){
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

    @Override
    public ItemStack slotClick(int slot, int button, ClickType flag, EntityPlayer player){
        if (slot >= 0 && getSlot(slot) != null && getSlot(slot).getStack() == player.getHeldItem(EnumHand.MAIN_HAND)){
            return ItemStack.EMPTY;
        }
        return super.slotClick(slot, button, flag, player);
    }

}
