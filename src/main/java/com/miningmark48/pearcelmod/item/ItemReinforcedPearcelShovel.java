package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.utility.KeyCheck;
import com.miningmark48.pearcelmod.utility.Translate;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;

import java.util.List;

public class ItemReinforcedPearcelShovel extends ItemSpade{

    public ItemReinforcedPearcelShovel(Item.ToolMaterial material) {
        super(material);
    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        if (KeyCheck.isHoldingShift()) {
            par3List.add(Translate.toLocal("tooltip.item.reinforced_pearcel_shovel.line1"));
        }else{
            par3List.add(Translate.toLocal("tooltip.item.hold") + " " + TextFormatting.AQUA + TextFormatting.ITALIC + Translate.toLocal("tooltip.item.shift"));
        }

        if(!par1ItemStack.isItemEnchanted()) {
            par1ItemStack.addEnchantment(Enchantments.SILK_TOUCH, 1);
        }

    }

}
