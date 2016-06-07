package com.miningmark48.pearcelmod.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class ItemPearcelArrow extends ItemPearcelMod{

    public Item infItem = new ItemStack(Blocks.diamond_block).getItem();
    public Item powItem = new ItemStack(Items.diamond_sword).getItem();
    public String infItemName = StatCollector.translateToLocal(infItem.getUnlocalizedName() + ".name");
    public String powItemName = StatCollector.translateToLocal(powItem.getUnlocalizedName() + ".name");

    public ItemPearcelArrow(){
        setMaxDamage(128);
        setMaxStackSize(1);
    }

    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){

        Random rand = new Random();

        if(player.inventory.hasItem(infItem)) {
            if (!stack.hasTagCompound()) {
                stack.setTagCompound(new NBTTagCompound());
                stack.getTagCompound().setBoolean("inf", true);
                player.inventory.consumeInventoryItem(infItem);
                player.playSound("random.levelup", 2.0F, rand.nextFloat() * 2.5F);
                if(!world.isRemote){
                    player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GOLD + StatCollector.translateToLocal("chat.item.pearcel_arrow.upgraded.inf")));
                }
            } else {
                stack.getTagCompound().setBoolean("inf", true);
                player.inventory.consumeInventoryItem(infItem);
                player.playSound("random.levelup", 2.0F, rand.nextFloat() * 2.5F);
                if(!world.isRemote){
                    player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GOLD + StatCollector.translateToLocal("chat.item.pearcel_arrow.upgraded.inf")));
                }
            }

        }
        if(player.inventory.hasItem(powItem)) {
            if (!stack.hasTagCompound()) {
                stack.setTagCompound(new NBTTagCompound());
                stack.getTagCompound().setBoolean("pow", true);
                player.inventory.consumeInventoryItem(powItem);
                player.playSound("random.levelup", 2.0F, rand.nextFloat() * 2.5F);
                if(!world.isRemote){
                    player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GOLD + StatCollector.translateToLocal("chat.item.pearcel_arrow.upgraded.pow")));
                }
            } else {
                stack.getTagCompound().setBoolean("pow", true);
                player.inventory.consumeInventoryItem(powItem);
                player.playSound("random.levelup", 2.0F, rand.nextFloat() * 2.5F);
                if(!world.isRemote){
                    player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GOLD + StatCollector.translateToLocal("chat.item.pearcel_arrow.upgraded.pow")));
                }
            }

        }

        return stack;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {

        if (stack.hasTagCompound()) {
            if (!stack.getTagCompound().getBoolean("inf") && !stack.getTagCompound().getBoolean("pow")) {
                list.add(EnumChatFormatting.AQUA + StatCollector.translateToLocal("tooltip.item.pearcel_arrow.line1.no_upgrade"));
                list.add(EnumChatFormatting.DARK_AQUA + infItemName + " " + StatCollector.translateToLocal("tooltip.item.pearcel_arrow.line2.no_upgrade.inf"));
                list.add(EnumChatFormatting.DARK_AQUA + powItemName + " " + StatCollector.translateToLocal("tooltip.item.pearcel_arrow.line2.no_upgrade.pow"));
            }else{
                list.add(EnumChatFormatting.GOLD + StatCollector.translateToLocal("tooltip.item.pearcel_arrow.line1.upgrade"));
                if(stack.getTagCompound().getBoolean("inf")) {
                    list.add(EnumChatFormatting.GRAY + StatCollector.translateToLocal("tooltip.item.pearcel_arrow.line2.upgrade.inf"));
                }else{
                    list.add(EnumChatFormatting.DARK_AQUA + infItemName + " " + StatCollector.translateToLocal("tooltip.item.pearcel_arrow.line2.no_upgrade.inf"));
                }
                if(stack.getTagCompound().getBoolean("pow")) {
                    list.add(EnumChatFormatting.GRAY + StatCollector.translateToLocal("tooltip.item.pearcel_arrow.line2.upgrade.pow"));
                }else{
                    list.add(EnumChatFormatting.DARK_AQUA + powItemName + " " + StatCollector.translateToLocal("tooltip.item.pearcel_arrow.line2.no_upgrade.pow"));
                }
            }
        }else{
            list.add(EnumChatFormatting.AQUA + StatCollector.translateToLocal("tooltip.item.pearcel_arrow.line1.no_upgrade"));
            list.add(EnumChatFormatting.DARK_AQUA + infItemName + " " + StatCollector.translateToLocal("tooltip.item.pearcel_arrow.line2.no_upgrade.inf"));
            list.add(EnumChatFormatting.DARK_AQUA + powItemName + " " + StatCollector.translateToLocal("tooltip.item.pearcel_arrow.line2.no_upgrade.pow"));
        }

    }

}
