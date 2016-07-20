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
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.datafix.fixes.PotionItems;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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
            ItemStack equippedMain = player.getHeldItemMainhand();
            ItemStack equippedOffhand = player.getHeldItemOffhand();
            if (equippedMain == stack || equippedOffhand == stack){
                player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 20, 2));
                player.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 20, 0));
            }
        }
    }

    @Override
    public ActionResult onItemRightClick(ItemStack item, World world, EntityPlayer player, EnumHand hand)
    {
        if (player.isSneaking()){
            player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 5000, 1));
            return new ActionResult(EnumActionResult.PASS, item);
        }else{
            player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 2500, 1));
            return new ActionResult(EnumActionResult.PASS, item);
        }
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase hitEntity, EntityLivingBase attackEntity){
        hitEntity.setHealth(0);
        return true;
    }
}
