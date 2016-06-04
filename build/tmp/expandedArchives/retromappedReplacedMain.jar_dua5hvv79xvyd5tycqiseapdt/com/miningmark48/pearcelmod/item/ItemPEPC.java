package com.miningmark48.pearcelmod.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemPEPC extends ItemPearcelMod{

    public ItemPEPC(){

    }

    public ItemStack func_77659_a(ItemStack item, World world, EntityPlayer player)
    {
        if (!player.func_70093_af()){
            player.func_71007_a(player.func_71005_bN());
            player.func_85030_a("random.chestopen", 0.5F, world.field_73012_v.nextFloat() * 0.1F + 0.9F);
            return item;
        }else{
            return item;
        }
    }

}
