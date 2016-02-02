package com.miningmark48.pearcelmod.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
public class ItemPearcelJuiceBottle extends ItemPearcelMod{

    public ItemPearcelJuiceBottle(){
        setMaxStackSize(1);
    }

    public ItemStack onEaten(ItemStack item, World world, EntityPlayer player)
    {
        if (!player.capabilities.isCreativeMode)
        {
            --item.stackSize;
        }

        if (!world.isRemote)
        {
            player.addPotionEffect(new PotionEffect(Potion.jump.getId(), 1500, 1));
            player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 1500, 0));
        }

        return item.stackSize <= 0 ? new ItemStack(Items.glass_bottle) : item;
    }
    public int getMaxItemUseDuration(ItemStack p_77626_1_)
    {
        return 32;
    }

    public EnumAction getItemUseAction(ItemStack p_77661_1_)
    {
        return EnumAction.drink;
    }

    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player)
    {
        player.setItemInUse(item, this.getMaxItemUseDuration(item));
        return item;
    }

}
