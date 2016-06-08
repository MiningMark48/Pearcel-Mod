package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.init.ModItems;
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
    public String infItemName = StatCollector.translateToLocal(infItem.getUnlocalizedName() + ".name");
    public Item powItem = new ItemStack(Items.diamond_sword).getItem();
    public String powItemName = StatCollector.translateToLocal(powItem.getUnlocalizedName() + ".name");
    public Item knockItem = new ItemStack(Blocks.piston).getItem();
    public String knockItemName = StatCollector.translateToLocal(knockItem.getUnlocalizedName() + ".name");
    public Item zoomItem = new ItemStack(Blocks.glass_pane).getItem();
    public String zoomItemName = StatCollector.translateToLocal(zoomItem.getUnlocalizedName() + ".name");

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
        if(player.inventory.hasItem(knockItem)) {
            if (!stack.hasTagCompound()) {
                stack.setTagCompound(new NBTTagCompound());
                stack.getTagCompound().setBoolean("knock", true);
                player.inventory.consumeInventoryItem(knockItem);
                player.playSound("random.levelup", 2.0F, rand.nextFloat() * 2.5F);
                if(!world.isRemote){
                    player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GOLD + StatCollector.translateToLocal("chat.item.pearcel_arrow.upgraded.knock")));
                }
            } else {
                stack.getTagCompound().setBoolean("knock", true);
                player.inventory.consumeInventoryItem(knockItem);
                player.playSound("random.levelup", 2.0F, rand.nextFloat() * 2.5F);
                if(!world.isRemote){
                    player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GOLD + StatCollector.translateToLocal("chat.item.pearcel_arrow.upgraded.knock")));
                }
            }

        }
        if(player.inventory.hasItem(zoomItem)) {
            if (!stack.hasTagCompound()) {
                stack.setTagCompound(new NBTTagCompound());
                stack.getTagCompound().setBoolean("zoom", true);
                player.inventory.consumeInventoryItem(zoomItem);
                player.playSound("random.levelup", 2.0F, rand.nextFloat() * 2.5F);
                if(!world.isRemote){
                    player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GOLD + StatCollector.translateToLocal("chat.item.pearcel_arrow.upgraded.zoom")));
                }
            } else {
                stack.getTagCompound().setBoolean("zoom", true);
                player.inventory.consumeInventoryItem(zoomItem);
                player.playSound("random.levelup", 2.0F, rand.nextFloat() * 2.5F);
                if(!world.isRemote){
                    player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GOLD + StatCollector.translateToLocal("chat.item.pearcel_arrow.upgraded.zoom")));
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
                list.add(EnumChatFormatting.DARK_AQUA + knockItemName + " " + StatCollector.translateToLocal("tooltip.item.pearcel_arrow.line2.no_upgrade.knock"));
                list.add(EnumChatFormatting.DARK_AQUA + zoomItemName + " " + StatCollector.translateToLocal("tooltip.item.pearcel_arrow.line2.no_upgrade.zoom"));
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
                if(stack.getTagCompound().getBoolean("knock")) {
                    list.add(EnumChatFormatting.GRAY + StatCollector.translateToLocal("tooltip.item.pearcel_arrow.line2.upgrade.knock"));
                }else{
                    list.add(EnumChatFormatting.DARK_AQUA + knockItemName + " " + StatCollector.translateToLocal("tooltip.item.pearcel_arrow.line2.no_upgrade.knock"));
                }
                if(stack.getTagCompound().getBoolean("zoom")) {
                    list.add(EnumChatFormatting.GRAY + StatCollector.translateToLocal("tooltip.item.pearcel_arrow.line2.upgrade.zoom"));
                }else{
                    list.add(EnumChatFormatting.DARK_AQUA + zoomItemName + " " + StatCollector.translateToLocal("tooltip.item.pearcel_arrow.line2.no_upgrade.zoom"));
                }
            }
        }else{
            list.add(EnumChatFormatting.AQUA + StatCollector.translateToLocal("tooltip.item.pearcel_arrow.line1.no_upgrade"));
            list.add(EnumChatFormatting.DARK_AQUA + infItemName + " " + StatCollector.translateToLocal("tooltip.item.pearcel_arrow.line2.no_upgrade.inf"));
            list.add(EnumChatFormatting.DARK_AQUA + powItemName + " " + StatCollector.translateToLocal("tooltip.item.pearcel_arrow.line2.no_upgrade.pow"));
            list.add(EnumChatFormatting.DARK_AQUA + knockItemName + " " + StatCollector.translateToLocal("tooltip.item.pearcel_arrow.line2.no_upgrade.knock"));
            list.add(EnumChatFormatting.DARK_AQUA + zoomItemName + " " + StatCollector.translateToLocal("tooltip.item.pearcel_arrow.line2.no_upgrade.zoom"));
        }

    }

}
