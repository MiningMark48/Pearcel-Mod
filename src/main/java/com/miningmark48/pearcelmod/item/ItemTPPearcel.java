package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.init.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

public class ItemTPPearcel extends ItemPearcelMod{

    double tpX = 0;
    double tpY = 0;
    double tpZ = 0;

    public ItemTPPearcel(){
        this.setMaxStackSize(1);
        this.setMaxDamage(128);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {

        list.add(StatCollector.translateToLocal("tooltip.item.tpPearcel.line1"));
        list.add("");

        if (stack.stackTagCompound != null) {
            if (stack.stackTagCompound.getDouble("tpX") == 0D && stack.stackTagCompound.getDouble("tpY") == 0D && stack.stackTagCompound.getDouble("tpZ") == 0D) {
                list.add(EnumChatFormatting.RED + StatCollector.translateToLocal("tooltip.item.tpPearcel.line2.notBound"));
            }else{
                list.add(EnumChatFormatting.GREEN + StatCollector.translateToLocal("tooltip.item.tpPearcel.line2.bound") + " " + EnumChatFormatting.AQUA + Math.round(stack.stackTagCompound.getDouble("tpX")) + " " + Math.round(stack.stackTagCompound.getDouble("tpY")) + " " + Math.round(stack.stackTagCompound.getDouble("tpZ")));
            }
        }else{
            list.add(EnumChatFormatting.RED + StatCollector.translateToLocal("tooltip.item.tpPearcel.line2.notBound"));
        }

    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
        if (stack.stackTagCompound == null){
            stack.stackTagCompound = new NBTTagCompound();
            stack.stackTagCompound.setDouble("tpX", 0D);
            stack.stackTagCompound.setDouble("tpY", 0D);
            stack.stackTagCompound.setDouble("tpZ", 0D);
        }
        if (player.isSneaking()) {
            stack.stackTagCompound.setDouble("tpX", player.posX);
            stack.stackTagCompound.setDouble("tpY", player.posY);
            stack.stackTagCompound.setDouble("tpZ", player.posZ);
            if(!world.isRemote) {
                player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.DARK_GREEN + StatCollector.translateToLocal("chat.tpPearcel.location.set")));
            }
        }else{
            tpX = stack.stackTagCompound.getDouble("tpX");
            tpY = stack.stackTagCompound.getDouble("tpY");
            tpZ = stack.stackTagCompound.getDouble("tpZ");
            if (tpX == 0D && tpY == 0D && tpZ == 0D) {
                if (!world.isRemote) {
                    player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.RED + StatCollector.translateToLocal("chat.tpPearcel.location.notSet")));
                }
            } else {
                player.setPositionAndUpdate(tpX, tpY, tpZ);
                if(!world.isRemote){
                    player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + StatCollector.translateToLocal("chat.tpPearcel.tp")));
                }
                if (!player.capabilities.isCreativeMode) {
                    if (player.inventory.hasItemStack(new ItemStack(ModItems.pearcel))) {
                        player.inventory.consumeInventoryItem(ModItems.pearcel);
                    } else {
                        stack.damageItem(1, player);
                    }
                }
            }
        }
        return stack;
    }



}
