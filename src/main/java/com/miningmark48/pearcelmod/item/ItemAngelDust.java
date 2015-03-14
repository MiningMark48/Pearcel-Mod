package com.miningmark48.pearcelmod.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
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
        list.add("Got to love some PCP...");
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5){
        super.onUpdate(stack, world, entity, par4, par5);
        {
            EntityPlayer player = (EntityPlayer) entity;
            ItemStack equipped = player.getCurrentEquippedItem();
            if (equipped == stack){
                if (player.isEating()){
                    player.addPotionEffect(new PotionEffect(Potion.confusion.getId(), 100, 1));
                    player.addPotionEffect(new PotionEffect(Potion.blindness.getId(), 100, 0));
                    player.addPotionEffect(new PotionEffect(Potion.digSlowdown.getId(), 100, 0));
                    player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.getId(), 100, 0));
                    player.addPotionEffect(new PotionEffect(Potion.hunger.getId(), 200, 1));
                }
            }
        }
    }

}
