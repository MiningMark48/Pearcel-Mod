package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import com.miningmark48.pearcelmod.utility.Translate;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;

import java.util.List;

public class ItemSAP extends ItemPearcelMod{

    public ItemSAP(){
        setMaxDamage(32);
        setMaxStackSize(1);
    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        int itemDurability = par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage();

        par3List.add(TextFormatting.GOLD + Translate.toLocal("tooltip.item.sap.line1") + " " + TextFormatting.AQUA + itemDurability);
        par3List.add(Translate.toLocal("tooltip.item.sap.line2"));
        par3List.add(Translate.toLocal("tooltip.item.sap.line3"));
        par3List.add(Translate.toLocal("tooltip.item.sap.line4"));
        par3List.add(Translate.toLocal("tooltip.item.sap.line5"));
    }

}
