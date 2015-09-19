package com.miningmark48.pearcelmod.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

public class ItemSAP extends ItemPearcelMod{

    public ItemSAP(){
        super();
    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        int itemDurability = par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage();

        par3List.add(EnumChatFormatting.GOLD + "Uses Left: " + EnumChatFormatting.AQUA + itemDurability);
        par3List.add("Right click upon the Summoner ");
        par3List.add("to activate the dark Pearcel magic, ");
        par3List.add("in which a creature will spawn ");
        par3List.add("from the depths of the surrounding summoner blocks.");
    }

}
