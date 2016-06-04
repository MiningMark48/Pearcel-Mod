package com.miningmark48.pearcelmod.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
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
            ItemStack equipped = player.getCurrentEquippedItem();
            if (equipped == stack){
                player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 20, 2));
                player.addPotionEffect(new PotionEffect(Potion.jump.getId(), 20, 0));
            }
        }
    }

    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player)
    {
        if (player.isSneaking()){
            player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 5000, 1));
            return item;
        }else{
            player.addPotionEffect(new PotionEffect(Potion.resistance.id, 2500, 1));
            return item;
        }
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase hitEntity, EntityLivingBase attackEntity){
        hitEntity.setHealth(0);
        return true;
    }
}
