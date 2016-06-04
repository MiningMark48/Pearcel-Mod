package com.miningmark48.pearcelmod.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import net.minecraft.item.Item.ToolMaterial;
public class ItemDragonPearcelStaff extends ItemPearcelSword{

    public ItemDragonPearcelStaff(ToolMaterial material) {
        super(material);
        func_77656_e(-1);
    }

    @Override
    public void func_77663_a(ItemStack stack, World world, Entity entity, int par4, boolean par5){
        super.func_77663_a(stack, world, entity, par4, par5);
        {
            EntityPlayer player = (EntityPlayer) entity;
            ItemStack equipped = player.func_71045_bC();
            if (equipped == stack){
                player.func_70690_d(new PotionEffect(Potion.field_76424_c.func_76396_c(), 20, 2));
                player.func_70690_d(new PotionEffect(Potion.field_76430_j.func_76396_c(), 20, 0));
            }
        }
    }

    public ItemStack func_77659_a(ItemStack item, World world, EntityPlayer player)
    {
        if (player.func_70093_af()){
            player.func_70690_d(new PotionEffect(Potion.field_76428_l.field_76415_H, 5000, 1));
            return item;
        }else{
            player.func_70690_d(new PotionEffect(Potion.field_76429_m.field_76415_H, 2500, 1));
            return item;
        }
    }

    @Override
    public boolean func_77644_a(ItemStack stack, EntityLivingBase hitEntity, EntityLivingBase attackEntity){
        hitEntity.func_70606_j(0);
        return true;
    }
}
