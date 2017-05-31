package com.miningmark48.pearcelmod.container;

import com.miningmark48.pearcelmod.handler.IGeneratorFuelHandler;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;

public class SlotGeneratorFuel extends Slot {

    public SlotGeneratorFuel(IInventory inventoryIn, int index, int xPosition, int yPosition) {
        super(inventoryIn, index, xPosition, yPosition);
    }

    @Override
    public boolean isItemValid(@Nullable ItemStack stack) {
        if (stack.getItem() instanceof IGeneratorFuelHandler){
            return true;
        }
        return false;
    }

}
