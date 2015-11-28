package com.miningmark48.pearcelmod.item;

import java.util.List;

import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import com.miningmark48.pearcelmod.utility.LogHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemPearcelStaff extends ItemSword{

    Float entDamageBy;

    public ItemPearcelStaff(ToolMaterial material)
    {
        super(material);
        this.setFull3D();
    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        par3List.add("Does a quarter damage of the entity's health...");
        par3List.add("Right Click = Boost Up (-1 Durability)");
        par3List.add("Sneak + Right Click = Regen (-50 Durability)");
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5){
        super.onUpdate(stack, world, entity, par4, par5);
        {
            EntityPlayer player = (EntityPlayer) entity;
            ItemStack equipped = player.getCurrentEquippedItem();
            if (equipped == stack){
                player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 20, 2));
            }
        }
    }

    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player)
    {
        if (player.isSneaking()){
            player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 5000, 1));
            item.damageItem(50, player);
            return item;
        }else{
            if (player.posY <= ConfigurationHandler.maxStaffFlyHeight){
                player.addVelocity(0, 0.5, 0);
            }else if (!world.isRemote){
                player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.DARK_RED + StatCollector.translateToLocal("chat.pearcelStaff.weaken")));
                item.damageItem(1, player);
            }
            item.damageItem(1, player);
            return item;
        }
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase hitEntity, EntityLivingBase attackEntity){
        Float entHealth = hitEntity.getHealth();
        if (hitEntity instanceof EntityDragon || hitEntity instanceof EntityWither){
            entDamageBy = entHealth / 8;
        }else{
            entDamageBy = entHealth / 4;
            hitEntity.addPotionEffect(new PotionEffect(Potion.weakness.id, 2000, 2));
            hitEntity.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 5000, 1));
        }
        hitEntity.setHealth(entHealth - entDamageBy);

        return true;
    }

}
