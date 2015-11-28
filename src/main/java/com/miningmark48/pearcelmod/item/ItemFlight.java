package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.utility.LogHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

public class ItemFlight extends ItemPearcelMod{

    public ItemFlight(){
        super();
    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        par3List.add(StatCollector.translateToLocal("tooltip.item.itemFlight.line1"));
    }
}
