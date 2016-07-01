package com.miningmark48.pearcelmod.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemPearcelJuiceBottle extends ItemPearcelMod{

    public ItemPearcelJuiceBottle(){
        setMaxStackSize(1);
    }

    public ItemStack onItemUseFinish(ItemStack item, World world, EntityPlayer player){
        if (!player.capabilities.isCreativeMode){
            --item.stackSize;
        }

        if (!world.isRemote){
            player.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 1500, 1));
            player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 1500, 0));
            player.heal(3.0F);
        }

        return item.stackSize <= 0 ? new ItemStack((Items.GLASS_BOTTLE)) : item;
    }

    public int getMaxItemUseDuration(ItemStack item){
        return 16;
    }

    public EnumAction getItemUseAction(ItemStack item){
        return EnumAction.DRINK;
    }

//    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player){
//        player.setItemInUse(item, this.getMaxItemUseDuration(item));
//        return item;
//    }

}
