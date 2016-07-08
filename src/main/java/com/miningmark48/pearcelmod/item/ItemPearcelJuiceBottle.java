package com.miningmark48.pearcelmod.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemPearcelJuiceBottle extends ItemPearcelMod{

    public ItemPearcelJuiceBottle(){
        setMaxStackSize(1);
    }

    public ItemStack onItemUseFinish(ItemStack item, World world, EntityLivingBase entityLiving) {
        if (entityLiving instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entityLiving;
            if (!player.capabilities.isCreativeMode) {
                --item.stackSize;
            }

            if (!world.isRemote) {
                player.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 1500, 1));
                player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 1500, 0));
                player.heal(3.0F);
            }
        }
        return item.stackSize <= 0 ? new ItemStack((Items.GLASS_BOTTLE)) : item;
    }

    public int getMaxItemUseDuration(ItemStack item){
        return 16;
    }

    public EnumAction getItemUseAction(ItemStack item){
        return EnumAction.DRINK;
    }

    @Override
    public ActionResult onItemRightClick(ItemStack item, World world, EntityPlayer player, EnumHand hand){
        player.setHeldItem(hand, item);
        return new ActionResult(EnumActionResult.PASS, item);
    }

}
