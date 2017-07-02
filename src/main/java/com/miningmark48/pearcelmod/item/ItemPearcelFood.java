package com.miningmark48.pearcelmod.item;

import com.miningmark48.mininglib.utility.KeyChecker;
import com.miningmark48.mininglib.utility.ModTranslate;
import com.miningmark48.pearcelmod.handler.IGeneratorFuelHandler;
import com.miningmark48.pearcelmod.init.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;

import java.util.List;

public class ItemPearcelFood extends ItemFood implements IGeneratorFuelHandler {

    public ItemPearcelFood(int amount, float saturation, boolean isWolfFood) {
        super(amount, saturation, isWolfFood);
    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        if(par1ItemStack.getItem() == ModItems.pearcel_item) {
            if (KeyChecker.isHoldingShift()) {
                par3List.add(ModTranslate.toLocal("tooltip.item.pearcel_item.line1"));
                par3List.add(ModTranslate.toLocal("tooltip.item.pearcel_item.line2"));
            } else {
                par3List.add(ModTranslate.toLocal("tooltip.item.hold") + " " + TextFormatting.AQUA + TextFormatting.ITALIC + ModTranslate.toLocal("tooltip.item.shift"));
            }
        }
    }

    @Override
    public int getCooldownTime(ItemStack fuel) {
        if (fuel.isItemEqual(new ItemStack(ModItems.pearcel_item))){
            return 60;
        }else if(fuel.isItemEqual(new ItemStack(ModItems.pearcel_bread))){
            return 120;
        }else if(fuel.isItemEqual(new ItemStack(ModItems.pearcel_sandwich))){
            return 60;
        }else if(fuel.isItemEqual(new ItemStack(ModItems.pearcel_cookie))){
            return 40;
        }else if(fuel.isItemEqual(new ItemStack(ModItems.pearcel_pie))){
            return 250;
        }else if(fuel.isItemEqual(new ItemStack(ModItems.golden_pearcel))){
            return 100;
        }else if(fuel.isItemEqual(new ItemStack(ModItems.jeweled_pearcel))){
            return 250;
        }else if(fuel.isItemEqual(new ItemStack(ModItems.glowing_pearcel))){
            return 120;
        }
        return 0;
    }

    @Override
    public int getRFPerTick(ItemStack fuel) {
        if (fuel.isItemEqual(new ItemStack(ModItems.pearcel_item))){
            return 10;
        }else if(fuel.isItemEqual(new ItemStack(ModItems.pearcel_bread))){
            return 20;
        }else if (fuel.isItemEqual(new ItemStack(ModItems.pearcel_sandwich))){
            return 40;
        }else if(fuel.isItemEqual(new ItemStack(ModItems.pearcel_cookie))){
            return 50;
        }else if(fuel.isItemEqual(new ItemStack(ModItems.pearcel_pie))){
            return 20;
        }else if(fuel.isItemEqual(new ItemStack(ModItems.golden_pearcel))){
            return 100;
        }else if(fuel.isItemEqual(new ItemStack(ModItems.jeweled_pearcel))){
            return 75;
        }else if(fuel.isItemEqual(new ItemStack(ModItems.glowing_pearcel))){
            return 10;
        }
        return 0;
    }
}
