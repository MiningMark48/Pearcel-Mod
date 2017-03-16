package com.miningmark48.pearcelmod.item;
import com.miningmark48.pearcelmod.init.ModItems;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;

public class ItemPearcelShears extends ItemShears{

    public ItemPearcelShears(){
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
        if (repair.isItemEqual(new ItemStack(ModItems.pearcel_ingot))){
            return true;
        }
        return false;
    }

}
