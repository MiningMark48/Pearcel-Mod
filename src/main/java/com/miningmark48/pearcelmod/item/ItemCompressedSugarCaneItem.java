package com.miningmark48.pearcelmod.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

import java.util.List;

public class ItemCompressedSugarCaneItem extends Item {

    public ItemCompressedSugarCaneItem()
    {
        super();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean isHeld) {
        list.add(EnumChatFormatting.ITALIC + StatCollector.translateToLocal("tooltip.pearcel." + getUnlocalizedName().substring(9) + ".desc.0"));
    }
}
