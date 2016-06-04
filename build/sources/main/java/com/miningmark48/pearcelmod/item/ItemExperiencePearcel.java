package com.miningmark48.pearcelmod.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
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

        list.add(StatCollector.translateToLocal("tooltip.item.experiencePearcel.line1"));
        list.add("");

        if (stack.hasTagCompound()) {
            if (stack.getTagCompound().getInteger("playerXP") == 0) {
                list.add(EnumChatFormatting.RED + StatCollector.translateToLocal("tooltip.item.experiencePearcel.line2.noXP"));
            }else{
                list.add(EnumChatFormatting.GOLD + StatCollector.translateToLocal("tooltip.item.experiencePearcel.line2.XP") + " " + EnumChatFormatting.AQUA + stack.getTagCompound().getInteger("playerXP"));
            }
        }else{
            list.add(EnumChatFormatting.RED + StatCollector.translateToLocal("tooltip.item.experiencePearcel.line2.noXP"));
        }

    }

    @Override
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
            player.playSound("random.orb", 0.2F, rand.nextFloat() * 2.5F);
            return item;
        }else{
            int xpToStore = player.experienceLevel + item.getTagCompound().getInteger("playerXP");
            item.getTagCompound().setInteger("playerXP", xpToStore);
            player.experienceLevel = 0;
            player.playSound("random.orb", 0.2F, rand.nextFloat() * 2.5F);
            return item;
        }
    }

}
