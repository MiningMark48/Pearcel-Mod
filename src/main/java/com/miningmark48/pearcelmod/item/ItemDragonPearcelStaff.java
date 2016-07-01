package com.miningmark48.pearcelmod.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionAttackDamage;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.util.EnumHand;
import net.minecraft.util.datafix.fixes.PotionItems;
import net.minecraft.world.World;

public class ItemDragonPearcelStaff extends ItemPearcelSword{

    public ItemDragonPearcelStaff(ToolMaterial material) {
        super(material);
        setMaxDamage(-1);
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5){
        super.onUpdate(stack, world, entity, par4, par5);
        {
            EntityPlayer player = (EntityPlayer) entity;
            ItemStack equipped = player.getHeldItem(EnumHand.MAIN_HAND);
            if (equipped == stack){
                player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 20, 2));
                player.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 20, 0));
            }
        }
    }

    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player)
    {
        if (player.isSneaking()){
            player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 5000, 1));
            return item;
        }else{
            player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 2500, 1));
            return item;
        }
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase hitEntity, EntityLivingBase attackEntity){
        hitEntity.setHealth(0);
        return true;
    }
}
