package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.init.ModBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

public class ItemOreChecker extends ItemPearcelMod{


    public ItemOreChecker(){
        super();
    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        int itemDurability = par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage();

        par3List.add(EnumChatFormatting.GOLD + StatCollector.translateToLocal("tooltip.item.oreChecker.line1") + " " + EnumChatFormatting.AQUA + itemDurability);
        par3List.add(StatCollector.translateToLocal("tooltip.item.oreChecker.line2"));
    }

    @Override
    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player){
        int x = Minecraft.getMinecraft().objectMouseOver.blockX;
        int y = Minecraft.getMinecraft().objectMouseOver.blockY;
        int z = Minecraft.getMinecraft().objectMouseOver.blockZ;

        if (!world.isRemote){
            if (world.getBlock(x, y, z) == ModBlocks.pearcelOre){
                player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.DARK_GREEN + StatCollector.translateToLocal("chat.oreChecker.success")));
            }else if(world.getBlock(x, y, z) == ModBlocks.foolsPearcelOre){
                player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.DARK_RED + StatCollector.translateToLocal("chat.oreChecker.fail")));
            }else{
                player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.DARK_RED + StatCollector.translateToLocal("chat.oreChecker.null")));
            }
            player.getHeldItem().damageItem(1, player);
        }

        return item;
    }
}
