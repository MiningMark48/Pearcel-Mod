package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.init.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class ItemPearcelArrow extends ItemPearcelMod{

    public Item consumtionItem = ModItems.tier_3_crafting_component;

    public ItemPearcelArrow(){
        setMaxDamage(128);
        setMaxStackSize(1);
    }

    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){

        Random rand = new Random();

        if(player.inventory.hasItem(consumtionItem)) {
            if (!stack.hasTagCompound()) {
                stack.setTagCompound(new NBTTagCompound());
                stack.getTagCompound().setBoolean("inf", true);
                player.inventory.consumeInventoryItem(consumtionItem);
                player.playSound("random.levelup", 2.0F, rand.nextFloat() * 2.5F);
            } else {
                stack.getTagCompound().setBoolean("inf", true);
                if(!stack.getTagCompound().getBoolean("inf")) {
                    player.inventory.consumeInventoryItem(consumtionItem);
                    player.playSound("random.levelup", 2.0F, rand.nextFloat() * 2.5F);
                }
            }

        }

        return stack;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {

        if (stack.hasTagCompound()) {
            if (!stack.getTagCompound().getBoolean("inf")) {
                list.add(EnumChatFormatting.AQUA + StatCollector.translateToLocal("tooltip.item.pearcel_arrow.line1.no_upgrade"));
                list.add(EnumChatFormatting.AQUA + StatCollector.translateToLocal("tooltip.item.pearcel_arrow.line2.no_upgrade"));
            }else{
                list.add(EnumChatFormatting.GOLD + StatCollector.translateToLocal("tooltip.item.pearcel_arrow.line1.upgrade"));
            }
        }else{
            list.add(EnumChatFormatting.AQUA + StatCollector.translateToLocal("tooltip.item.pearcel_arrow.line1.no_upgrade"));
            list.add(EnumChatFormatting.AQUA + StatCollector.translateToLocal("tooltip.item.pearcel_arrow.line2.no_upgrade"));
        }

    }

}
