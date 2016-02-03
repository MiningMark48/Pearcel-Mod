package com.miningmark48.pearcelmod.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

import java.util.List;

public class ItemPearcelMatterNeutral extends ItemPearcelMod{

    public ItemPearcelMatterNeutral(){
        super();
    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        par3List.add(EnumChatFormatting.YELLOW + StatCollector.translateToLocal("tooltip.item.pearcelMatterNeutral.line1"));
    }

}
