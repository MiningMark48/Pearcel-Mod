package com.miningmark48.pearcelmod.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemFlight extends ItemPearcelMod{

    public ItemFlight(){
        super();
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5){
        super.onUpdate(stack, world, entity, par4, par5);
        {
            EntityPlayer player = (EntityPlayer) entity;
            ItemStack equipped = player.getCurrentEquippedItem();
            if (equipped == stack){
                player.capabilities.allowFlying = true;
            }

            try {
                Thread.sleep(1000);
                player.capabilities.allowFlying = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
