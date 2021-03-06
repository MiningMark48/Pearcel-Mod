package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.init.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemPearcelSword extends ItemSword{
    public ItemPearcelSword(ToolMaterial material) {
        super(material);
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
