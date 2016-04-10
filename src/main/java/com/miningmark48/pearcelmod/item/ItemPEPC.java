package com.miningmark48.pearcelmod.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

public class ItemPEPC extends ItemPearcelMod{

    public ItemPEPC(){

    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        par3List.add(StatCollector.translateToLocal("tooltip.item.pepc.line1"));
        par3List.add(StatCollector.translateToLocal("tooltip.item.pepc.line2"));
    }

    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player)
    {
        if (!player.isSneaking()){
            player.displayGUIChest(player.getInventoryEnderChest());
            player.playSound("random.chestopen", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
            return item;
        }else{
            return item;
        }
    }

}
