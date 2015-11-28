package com.miningmark48.pearcelmod.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

public class ItemAngelDust extends ItemFood {

    public ItemAngelDust(int healAmount, float saturationModifier, boolean isWolfFood)
    {
        super(healAmount, saturationModifier, isWolfFood);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean isHeld) {
        list.add(StatCollector.translateToLocal("tooltip.item.angelDust.line1"));
    }

    public ItemStack onEaten(ItemStack item, World world, EntityPlayer player)
    {
        player.addVelocity(0, 10.0, 0);
        player.addPotionEffect(new PotionEffect(Potion.wither.id, 5000, 1));
        player.addPotionEffect(new PotionEffect(Potion.blindness.id, 15000, 2));
        return item;
    }
}
