package com.miningmark48.pearcelmod.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemPEPC extends ItemPearcelMod{

    public ItemPEPC(){

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
