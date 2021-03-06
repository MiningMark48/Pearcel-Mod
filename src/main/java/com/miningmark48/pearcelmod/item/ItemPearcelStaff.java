package com.miningmark48.pearcelmod.item;

import com.miningmark48.mininglib.utility.ModTranslate;
import com.miningmark48.pearcelmod.entity.EntityPearcelBoss;
import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import com.miningmark48.pearcelmod.init.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
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
            ItemStack equippedMain = player.getHeldItemMainhand();
            ItemStack equippedOffhand = player.getHeldItemOffhand();
            if (equippedMain == stack || equippedOffhand == stack){
                player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 20, 2));
            }
        }
    }

    @Override
    public ActionResult onItemRightClick(World world, EntityPlayer player, EnumHand hand)
    {
        ItemStack item = player.getHeldItem(hand);
        if (player.isSneaking()){
            player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 5000, 1));
            item.damageItem(50, player);
            return new ActionResult(EnumActionResult.PASS, item);
        }else{
            if (player.posY <= ConfigurationHandler.maxStaffFlyHeight || player.capabilities.isCreativeMode){
                player.addVelocity(0, 0.5, 0);
            }else{
                if (!world.isRemote) {
                    player.sendMessage(new TextComponentTranslation(TextFormatting.DARK_RED + ModTranslate.toLocal("chat.pearcel_staff.weaken")));
                    item.damageItem(10, player);
                }
            }
            item.damageItem(1, player);
            return new ActionResult(EnumActionResult.PASS, item);
        }
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase hitEntity, EntityLivingBase attackEntity){
        if (hitEntity instanceof EntityPearcelBoss) {
            return false;
        }else{
            hitEntity.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 2000, 2, true, false));
            hitEntity.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 5000, 2, true, false));
            return true;
        }
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
        if (repair.isItemEqual(new ItemStack(ModItems.pearcel_ingot))){
            return true;
        }
        return false;
    }

}
