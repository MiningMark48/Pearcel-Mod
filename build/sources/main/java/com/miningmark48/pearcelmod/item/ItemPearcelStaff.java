package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemPearcelStaff extends ItemPearcelSword{

    public ItemPearcelStaff(ToolMaterial material) {
        super(material);
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
            if (player.posY <= ConfigurationHandler.maxStaffFlyHeight || player.capabilities.isCreativeMode){
                player.addVelocity(0, 0.5, 0);
            }else{
                if (!world.isRemote) {
                    player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.DARK_RED + StatCollector.translateToLocal("chat.pearcel_staff.weaken")));
                    item.damageItem(10, player);
                }
            }
            item.damageItem(1, player);
            return item;
        }
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase hitEntity, EntityLivingBase attackEntity){
        hitEntity.addPotionEffect(new PotionEffect(Potion.weakness.id, 2000, 2));
        hitEntity.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 5000, 2));
        return true;
    }
}
