package com.miningmark48.pearcelmod.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

import java.util.List;

public class ItemSugarCookie extends ItemFood {

    public ItemSugarCookie(int healAmount, float saturationModifier, boolean isWolfFood)
    {
        super(healAmount, saturationModifier, isWolfFood);
        setPotionEffect(Potion.moveSpeed.id, 15, 1, 0.5F);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean isHeld) {
        list.add(EnumChatFormatting.ITALIC + StatCollector.translateToLocal("tooltip.pearcel." + getUnlocalizedName().substring(9) + ".desc.0"));
    }
}
