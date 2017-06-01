package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.handler.IGeneratorFuelHandler;
import com.miningmark48.pearcelmod.init.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemPearcelMod extends Item implements IGeneratorFuelHandler{

    public ItemPearcelMod(){
    }

    @Override
    public int getCooldownTime(ItemStack fuel) {
        if (fuel.isItemEqual(new ItemStack(ModItems.tier_1_crafting_component))){
            return 50;
        }else if (fuel.isItemEqual(new ItemStack(ModItems.tier_2_crafting_component))){
            return 50;
        }else if (fuel.isItemEqual(new ItemStack(ModItems.tier_3_crafting_component))){
            return 340;
        }else if (fuel.isItemEqual(new ItemStack(ModItems.pearcel_juice_bottle))){
            return 30;
        }
        return 0;
    }

    @Override
    public int getRFPerTick(ItemStack fuel) {
        if (fuel.isItemEqual(new ItemStack(ModItems.tier_1_crafting_component))){
            return 50;
        }else if (fuel.isItemEqual(new ItemStack(ModItems.tier_2_crafting_component))){
            return 150;
        }else if (fuel.isItemEqual(new ItemStack(ModItems.tier_3_crafting_component))){
            return 70;
        }else if (fuel.isItemEqual(new ItemStack(ModItems.pearcel_juice_bottle))){
            return 30;
        }
        return 0;
    }
}
