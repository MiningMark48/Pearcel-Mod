package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.handler.IGeneratorFuelHandler;
import com.miningmark48.pearcelmod.init.ModBlocks;
import com.miningmark48.pearcelmod.init.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class ItemPearcelFuel extends Item implements IFuelHandler, IGeneratorFuelHandler {

    @Override
    public int getBurnTime(ItemStack fuel) {
        Item item = fuel.getItem();

        if(item == ModItems.pearcel_charcoal){
            return 2500;
        }else if(fuel.isItemEqual(new ItemStack(ModBlocks.pearcel_charcoal_block))){
            return 22500;
        }else if(item == ModItems.pearcel_matter){
            return 30000;
        }else if(fuel.isItemEqual(new ItemStack(ModBlocks.pearcel_matter_block))){
            return 270000;
        }
        else{
            return 0;
        }
    }

    @Override
    public int getCooldownTime(ItemStack fuel) {
        if (fuel.isItemEqual(new ItemStack(ModItems.pearcel_charcoal))){
            return 80;
        }else if (fuel.isItemEqual(new ItemStack(ModBlocks.pearcel_charcoal_block))){
            return 300;
        }else if (fuel.isItemEqual(new ItemStack(ModItems.pearcel_matter))){
            return 160;
        }else if (fuel.isItemEqual(new ItemStack(ModBlocks.pearcel_matter_block))){
            return 600;
        }
        return 0;
    }

    @Override
    public int getRFPerTick(ItemStack fuel) {
        if (fuel.isItemEqual(new ItemStack(ModItems.pearcel_charcoal))){
            return 40;
        }else if (fuel.isItemEqual(new ItemStack(ModBlocks.pearcel_charcoal_block))){
            return 20;
        }else if (fuel.isItemEqual(new ItemStack(ModItems.pearcel_matter))){
            return 120;
        }else if (fuel.isItemEqual(new ItemStack(ModBlocks.pearcel_matter_block))){
            return 60;
        }
        return 0;
    }
}
