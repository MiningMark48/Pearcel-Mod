package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.utility.KeyCheck;
import com.miningmark48.pearcelmod.utility.Translate;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class ItemPearcelArrow extends ItemPearcelMod{

    public ItemStack infItem = new ItemStack(Blocks.DIAMOND_BLOCK);
    public String infItemName = Translate.toLocal(infItem.getUnlocalizedName() + ".name");
    public ItemStack powItem = new ItemStack(Items.DIAMOND_SWORD);
    public String powItemName = Translate.toLocal(powItem.getUnlocalizedName() + ".name");
    public ItemStack knockItem = new ItemStack(Blocks.PISTON);
    public String knockItemName = Translate.toLocal(knockItem.getUnlocalizedName() + ".name");
    public ItemStack zoomItem = new ItemStack(Blocks.GLASS_PANE);
    public String zoomItemName = Translate.toLocal(zoomItem.getUnlocalizedName() + ".name");

    public ItemPearcelArrow(){
        setMaxDamage(128);
        setMaxStackSize(1);
    }

    @Override
    public ActionResult onItemRightClick(World world, EntityPlayer player, EnumHand hand){

        ItemStack stack = player.getHeldItem(hand);
        Random rand = new Random();

        if(player.inventory.hasItemStack(infItem)) {
            if (!stack.hasTagCompound()) {
                stack.setTagCompound(new NBTTagCompound());
                stack.getTagCompound().setBoolean("inf", true);
                player.inventory.clearMatchingItems(infItem.getItem(), 0, 1, null);
                player.playSound(SoundEvents.ENTITY_PLAYER_LEVELUP, 2.0F, rand.nextFloat() * 2.5F);
                if(!world.isRemote){
                    player.sendMessage(new TextComponentString(TextFormatting.GOLD + Translate.toLocal("chat.item.pearcel_arrow.upgraded.inf")));
                }
            } else {
                stack.getTagCompound().setBoolean("inf", true);
                player.inventory.clearMatchingItems(infItem.getItem(), 0, 1, null);
                player.playSound(SoundEvents.ENTITY_PLAYER_LEVELUP, 2.0F, rand.nextFloat() * 2.5F);
                if(!world.isRemote){
                    player.sendMessage(new TextComponentString(TextFormatting.GOLD + Translate.toLocal("chat.item.pearcel_arrow.upgraded.inf")));
                }
            }

        }
        if(player.inventory.hasItemStack(powItem)) {
            if (!stack.hasTagCompound()) {
                stack.setTagCompound(new NBTTagCompound());
                stack.getTagCompound().setBoolean("pow", true);
                player.inventory.clearMatchingItems(powItem.getItem(), 0, 1, null);
                player.playSound(SoundEvents.ENTITY_PLAYER_LEVELUP, 2.0F, rand.nextFloat() * 2.5F);
                if(!world.isRemote){
                    player.sendMessage(new TextComponentString(TextFormatting.GOLD + Translate.toLocal("chat.item.pearcel_arrow.upgraded.pow")));
                }
            } else {
                stack.getTagCompound().setBoolean("pow", true);
                player.inventory.clearMatchingItems(powItem.getItem(), 0, 1, null);
                player.playSound(SoundEvents.ENTITY_PLAYER_LEVELUP, 2.0F, rand.nextFloat() * 2.5F);
                if(!world.isRemote){
                    player.sendMessage(new TextComponentString(TextFormatting.GOLD + Translate.toLocal("chat.item.pearcel_arrow.upgraded.pow")));
                }
            }

        }
        if(player.inventory.hasItemStack(knockItem)) {
            if (!stack.hasTagCompound()) {
                stack.setTagCompound(new NBTTagCompound());
                stack.getTagCompound().setBoolean("knock", true);
                player.inventory.clearMatchingItems(knockItem.getItem(), 0, 1, null);
                player.playSound(SoundEvents.ENTITY_PLAYER_LEVELUP, 2.0F, rand.nextFloat() * 2.5F);
                if(!world.isRemote){
                    player.sendMessage(new TextComponentString(TextFormatting.GOLD + Translate.toLocal("chat.item.pearcel_arrow.upgraded.knock")));
                }
            } else {
                stack.getTagCompound().setBoolean("knock", true);
                player.inventory.clearMatchingItems(knockItem.getItem(), 0, 1, null);
                player.playSound(SoundEvents.ENTITY_PLAYER_LEVELUP, 2.0F, rand.nextFloat() * 2.5F);
                if(!world.isRemote){
                    player.sendMessage(new TextComponentString(TextFormatting.GOLD + Translate.toLocal("chat.item.pearcel_arrow.upgraded.knock")));
                }
            }

        }
        if(player.inventory.hasItemStack(zoomItem)) {
            if (!stack.hasTagCompound()) {
                stack.setTagCompound(new NBTTagCompound());
                stack.getTagCompound().setBoolean("zoom", true);
                player.inventory.clearMatchingItems(zoomItem.getItem(), 0, 1, null);
                player.playSound(SoundEvents.ENTITY_PLAYER_LEVELUP, 2.0F, rand.nextFloat() * 2.5F);
                if(!world.isRemote){
                    player.sendMessage(new TextComponentString(TextFormatting.GOLD + Translate.toLocal("chat.item.pearcel_arrow.upgraded.zoom")));
                }
            } else {
                stack.getTagCompound().setBoolean("zoom", true);
                player.inventory.clearMatchingItems(zoomItem.getItem(), 0, 1, null);
                player.playSound(SoundEvents.ENTITY_PLAYER_LEVELUP, 2.0F, rand.nextFloat() * 2.5F);
                if(!world.isRemote){
                    player.sendMessage(new TextComponentString(TextFormatting.GOLD + Translate.toLocal("chat.item.pearcel_arrow.upgraded.zoom")));
                }
            }

        }

        return new ActionResult(EnumActionResult.PASS, stack);
    }

//    public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.entity.player.EntityPlayer player)
//    {
//        if (stack.hasTagCompound()){
//            if (stack.getTagCompound().getBoolean("inf")){
//                return true;
//            }else{
//                return false;
//            }
//        }else{
//            return false;
//        }
//    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {

        if (KeyCheck.isHoldingShift()) {

            if (stack.hasTagCompound()) {
                if (!stack.getTagCompound().getBoolean("inf") && !stack.getTagCompound().getBoolean("pow") && !stack.getTagCompound().getBoolean("knock") && !stack.getTagCompound().getBoolean("zoom")) {
                    list.add(TextFormatting.AQUA + Translate.toLocal("tooltip.item.pearcel_arrow.line1.no_upgrade"));
                    list.add(TextFormatting.DARK_AQUA + infItemName + " " + Translate.toLocal("tooltip.item.pearcel_arrow.line2.no_upgrade.inf"));
                    list.add(TextFormatting.DARK_AQUA + powItemName + " " + Translate.toLocal("tooltip.item.pearcel_arrow.line2.no_upgrade.pow"));
                    list.add(TextFormatting.DARK_AQUA + knockItemName + " " + Translate.toLocal("tooltip.item.pearcel_arrow.line2.no_upgrade.knock"));
                    list.add(TextFormatting.DARK_AQUA + zoomItemName + " " + Translate.toLocal("tooltip.item.pearcel_arrow.line2.no_upgrade.zoom"));
                } else {
                    list.add(TextFormatting.GOLD + Translate.toLocal("tooltip.item.pearcel_arrow.line1.upgrade"));
                    if (stack.getTagCompound().getBoolean("inf")) {
                        list.add(TextFormatting.GRAY + Translate.toLocal("tooltip.item.pearcel_arrow.line2.upgrade.inf"));
                    } else {
                        list.add(TextFormatting.DARK_AQUA + infItemName + " " + Translate.toLocal("tooltip.item.pearcel_arrow.line2.no_upgrade.inf"));
                    }
                    if (stack.getTagCompound().getBoolean("pow")) {
                        list.add(TextFormatting.GRAY + Translate.toLocal("tooltip.item.pearcel_arrow.line2.upgrade.pow"));
                    } else {
                        list.add(TextFormatting.DARK_AQUA + powItemName + " " + Translate.toLocal("tooltip.item.pearcel_arrow.line2.no_upgrade.pow"));
                    }
                    if (stack.getTagCompound().getBoolean("knock")) {
                        list.add(TextFormatting.GRAY + Translate.toLocal("tooltip.item.pearcel_arrow.line2.upgrade.knock"));
                    } else {
                        list.add(TextFormatting.DARK_AQUA + knockItemName + " " + Translate.toLocal("tooltip.item.pearcel_arrow.line2.no_upgrade.knock"));
                    }
                    if (stack.getTagCompound().getBoolean("zoom")) {
                        list.add(TextFormatting.GRAY + Translate.toLocal("tooltip.item.pearcel_arrow.line2.upgrade.zoom"));
                    } else {
                        list.add(TextFormatting.DARK_AQUA + zoomItemName + " " + Translate.toLocal("tooltip.item.pearcel_arrow.line2.no_upgrade.zoom"));
                    }
                }
            } else {
                list.add(TextFormatting.AQUA + Translate.toLocal("tooltip.item.pearcel_arrow.line1.no_upgrade"));
                list.add(TextFormatting.DARK_AQUA + infItemName + " " + Translate.toLocal("tooltip.item.pearcel_arrow.line2.no_upgrade.inf"));
                list.add(TextFormatting.DARK_AQUA + powItemName + " " + Translate.toLocal("tooltip.item.pearcel_arrow.line2.no_upgrade.pow"));
                list.add(TextFormatting.DARK_AQUA + knockItemName + " " + Translate.toLocal("tooltip.item.pearcel_arrow.line2.no_upgrade.knock"));
                list.add(TextFormatting.DARK_AQUA + zoomItemName + " " + Translate.toLocal("tooltip.item.pearcel_arrow.line2.no_upgrade.zoom"));
            }
        }else{
            list.add(Translate.toLocal("tooltip.item.hold") + " " + TextFormatting.AQUA + TextFormatting.ITALIC + Translate.toLocal("tooltip.item.shift"));
        }

    }

    public EntityArrow createArrow(World worldIn, ItemStack stack, EntityLivingBase shooter)
    {
        EntityTippedArrow entitytippedarrow = new EntityTippedArrow(worldIn, shooter);
        entitytippedarrow.setPotionEffect(stack);
        return entitytippedarrow;
    }

}
