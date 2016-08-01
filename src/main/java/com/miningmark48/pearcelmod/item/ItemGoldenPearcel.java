package com.miningmark48.pearcelmod.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.AchievementList;
import net.minecraft.world.World;

public class ItemGoldenPearcel extends ItemPearcelFood{

    public ItemGoldenPearcel() {
        super(8, 5.0F, false);
    }

    public void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
        if (!worldIn.isRemote)
        {
            player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 4000, 2));
            player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 6000, 1));
            player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 6000, 0));
            player.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 8000, 4));
        }
    }

}
