package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

import java.util.List;

public class ItemFlight extends ItemPearcelMod{

    public ItemFlight(){
        super();
    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        if (!ConfigurationHandler.flightItemDisable) {
            par3List.add(StatCollector.translateToLocal("tooltip.item.itemFlight.line1"));
        }else{
            par3List.add(EnumChatFormatting.DARK_RED + StatCollector.translateToLocal("tooltip.item.itemFlight.disabled"));
        }

    }
}
