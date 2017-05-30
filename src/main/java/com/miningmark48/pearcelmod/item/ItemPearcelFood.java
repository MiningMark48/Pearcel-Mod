package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.handler.IGeneratorHandler;
import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.utility.KeyCheck;
import com.miningmark48.pearcelmod.utility.Translate;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;

import java.util.List;

public class ItemPearcelFood extends ItemFood implements IGeneratorHandler{

    public ItemPearcelFood(int amount, float saturation, boolean isWolfFood) {
        super(amount, saturation, isWolfFood);
    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        if(par1ItemStack.getItem() == ModItems.pearcel_item) {
            if (KeyCheck.isHoldingShift()) {
                par3List.add(Translate.toLocal("tooltip.item.pearcel_item.line1"));
                par3List.add(Translate.toLocal("tooltip.item.pearcel_item.line2"));
            } else {
                par3List.add(Translate.toLocal("tooltip.item.hold") + " " + TextFormatting.AQUA + TextFormatting.ITALIC + Translate.toLocal("tooltip.item.shift"));
            }
        }
    }

    @Override
    public int getCooldownTime(ItemStack fuel) {
        if (fuel.isItemEqual(new ItemStack(ModItems.pearcel_item))){
            return 60;
        }else if(fuel.isItemEqual(new ItemStack(ModItems.pearcel_bread))){
            return 120;
        }
        return 0;
    }

    @Override
    public int getRFPetTick(ItemStack fuel) {
        if (fuel.isItemEqual(new ItemStack(ModItems.pearcel_item))){
            return 10;
        }else if(fuel.isItemEqual(new ItemStack(ModItems.pearcel_bread))){
            return 30;
        }
        return 0;
    }
}
