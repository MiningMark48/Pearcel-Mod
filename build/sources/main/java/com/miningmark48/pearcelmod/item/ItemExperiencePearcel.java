package com.miningmark48.pearcelmod.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class ItemExperiencePearcel extends ItemPearcelMod{

    public ItemExperiencePearcel(){
        setMaxStackSize(1);
    }

    Random rand = new Random();

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {

        list.add(new TextComponentString("tooltip.item.experiencePearcel.line1"));
        list.add("");

        if (stack.hasTagCompound()) {
            if (stack.getTagCompound().getInteger("playerXP") == 0) {
                list.add(TextFormatting.RED + new TextComponentString("tooltip.item.experiencePearcel.line2.noXP").toString());
            }else{
                list.add(TextFormatting.GOLD + new TextComponentString("tooltip.item.experiencePearcel.line2.XP").toString() + " " + TextFormatting.AQUA + stack.getTagCompound().getInteger("playerXP"));
            }
        }else{
            list.add(TextFormatting.RED + new TextComponentString("tooltip.item.experiencePearcel.line2.noXP").toString());
        }

    }

    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player)
    {
        if(!item.hasTagCompound()){
            item.setTagCompound(new NBTTagCompound());
            item.getTagCompound().setInteger("playerXP", 0);
        }
        if (!player.isSneaking()){
            int xpToGather = player.experienceLevel + item.getTagCompound().getInteger("playerXP");
            player.experienceLevel = xpToGather;
            item.getTagCompound().setInteger("playerXP", 0);
            player.playSound(SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, 0.2F, rand.nextFloat() * 2.5F);
            return item;
        }else{
            int xpToStore = player.experienceLevel + item.getTagCompound().getInteger("playerXP");
            item.getTagCompound().setInteger("playerXP", xpToStore);
            player.experienceLevel = 0;
            player.playSound(SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, 0.2F, rand.nextFloat() * 2.5F);
            return item;
        }
    }

}
