package com.miningmark48.pearcelmod.item;

import com.miningmark48.mininglib.utility.KeyChecker;
import com.miningmark48.mininglib.utility.ModTranslate;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;

import java.util.List;

public class ItemSAP extends ItemPearcelMod{

    public ItemSAP(){
        setMaxDamage(64);
        setMaxStackSize(1);
    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        int itemDurability = par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage();

        if (KeyChecker.isHoldingShift()) {

            par3List.add(TextFormatting.GOLD + ModTranslate.toLocal("tooltip.item.sap.line1") + " " + TextFormatting.AQUA + itemDurability);
            par3List.add(ModTranslate.toLocal("tooltip.item.sap.line2"));
            par3List.add(ModTranslate.toLocal("tooltip.item.sap.line3"));
            par3List.add(ModTranslate.toLocal("tooltip.item.sap.line4"));
            par3List.add(ModTranslate.toLocal("tooltip.item.sap.line5"));
        }else{
            par3List.add(ModTranslate.toLocal("tooltip.item.hold") + " " + TextFormatting.AQUA + TextFormatting.ITALIC + ModTranslate.toLocal("tooltip.item.shift"));
        }
    }

}
