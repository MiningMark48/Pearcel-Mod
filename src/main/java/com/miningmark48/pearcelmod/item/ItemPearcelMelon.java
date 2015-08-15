package com.miningmark48.pearcelmod.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

public class ItemPearcelMelon extends ItemFood {

    public ItemPearcelMelon(int healAmount, float saturationModifier, boolean isWolfFood)
    {
        super(healAmount, saturationModifier, isWolfFood);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean isHeld) {
        list.add("This is simply a " + EnumChatFormatting.STRIKETHROUGH + "Pearcel"+ EnumChatFormatting.RESET + " Scrub Melon...");
    }

}
