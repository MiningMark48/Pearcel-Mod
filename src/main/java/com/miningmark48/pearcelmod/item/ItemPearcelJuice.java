package com.miningmark48.pearcelmod.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucketMilk;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemPearcelJuice extends ItemBucketMilk{

    @Override
    public ItemStack onEaten(ItemStack item, World world, EntityPlayer player)
    {
        if (!player.capabilities.isCreativeMode)
        {
            --item.stackSize;
        }

        if (!world.isRemote)
        {
            player.addPotionEffect(new PotionEffect(Potion.jump.getId(), 1000, 1));
        }

        return item.stackSize <= 0 ? new ItemStack(Items.bucket) : item;
    }

}
