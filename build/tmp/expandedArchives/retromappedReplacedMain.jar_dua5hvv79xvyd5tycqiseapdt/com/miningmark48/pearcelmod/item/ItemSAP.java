package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

import java.util.List;

public class ItemSAP extends ItemPearcelMod{

    public ItemSAP(){
        func_77656_e(ConfigurationHandler.sapDurability);
    }

    @Override
    public void func_77624_a(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        int itemDurability = par1ItemStack.func_77958_k() - par1ItemStack.func_77952_i();

        par3List.add(EnumChatFormatting.GOLD + StatCollector.func_74838_a("tooltip.item.sap.line1") + " " + EnumChatFormatting.AQUA + itemDurability);
        par3List.add(StatCollector.func_74838_a("tooltip.item.sap.line2"));
        par3List.add(StatCollector.func_74838_a("tooltip.item.sap.line3"));
        par3List.add(StatCollector.func_74838_a("tooltip.item.sap.line4"));
        par3List.add(StatCollector.func_74838_a("tooltip.item.sap.line5"));
    }

}
