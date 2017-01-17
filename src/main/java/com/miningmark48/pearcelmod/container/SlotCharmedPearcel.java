package com.miningmark48.pearcelmod.container;

import com.miningmark48.pearcelmod.init.ModItems;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;

public class SlotCharmedPearcel extends Slot {

    public SlotCharmedPearcel(IInventory inventoryIn, int index, int xPosition, int yPosition) {
        super(inventoryIn, index, xPosition, yPosition);
    }

    @Override
    public boolean isItemValid(@Nullable ItemStack stack) {
        if (stack.getItem() == ModItems.charmed_pearcel){
            return true;
        }
        return false;
    }
}
