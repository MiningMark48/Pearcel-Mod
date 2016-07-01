package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

import java.util.List;

public class ItemSAP extends ItemPearcelMod{

    public ItemSAP(){
        setMaxDamage(ConfigurationHandler.sapDurability);
    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        int itemDurability = par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage();

        par3List.add(TextFormatting.GOLD + new TextComponentString("tooltip.item.sap.line1").toString() + " " + TextFormatting.AQUA + itemDurability);
        par3List.add(new TextComponentString("tooltip.item.sap.line2"));
        par3List.add(new TextComponentString("tooltip.item.sap.line3"));
        par3List.add(new TextComponentString("tooltip.item.sap.line4"));
        par3List.add(new TextComponentString("tooltip.item.sap.line5"));
    }

}
