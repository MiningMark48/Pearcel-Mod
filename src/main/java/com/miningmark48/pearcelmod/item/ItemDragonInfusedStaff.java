package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

public class ItemDragonInfusedStaff extends ItemSword{

    Float entDamageBy;

    public ItemDragonInfusedStaff(ToolMaterial material)
    {
        super(material);
        this.setFull3D();
        setMaxDamage(-1);
    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        par3List.add(EnumChatFormatting.GOLD + StatCollector.translateToLocal("tooltip.item.dragonInfusedStaff.line1"));
        par3List.add(StatCollector.translateToLocal("tooltip.item.dragonInfusedStaff.line2"));
        par3List.add(StatCollector.translateToLocal("tooltip.item.dragonInfusedStaff.line3"));
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
        World world = hitEntity.worldObj;
        world.spawnParticle("hugeexplosion", hitEntity.posX, hitEntity.posY, hitEntity.posZ, 1.0D, 0.0D, 0.0D);
        return true;
    }

}
