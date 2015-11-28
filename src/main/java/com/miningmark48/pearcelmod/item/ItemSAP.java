package com.miningmark48.pearcelmod.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

import java.util.List;

public class ItemSAP extends ItemPearcelMod{

    public ItemSAP(){
        super();
    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        int itemDurability = par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage();

        par3List.add(EnumChatFormatting.GOLD + StatCollector.translateToLocal("tooltip.item.sap.line1") + " " + EnumChatFormatting.AQUA + itemDurability);
        par3List.add(StatCollector.translateToLocal("tooltip.item.sap.line2"));
        par3List.add(StatCollector.translateToLocal("tooltip.item.sap.line3"));
        par3List.add(StatCollector.translateToLocal("tooltip.item.sap.line4"));
        par3List.add(StatCollector.translateToLocal("tooltip.item.sap.line5"));
    }

}
