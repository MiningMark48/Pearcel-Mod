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
    int dim = 0;

    public ItemTPPearcel(){
        setMaxStackSize(1);
        setMaxDamage(128);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {

        list.add(StatCollector.translateToLocal("tooltip.item.tpPearcel.line1"));
        list.add("");

        if (stack.hasTagCompound()) {
            if (stack.getTagCompound().getDouble("tpX") == 0D && stack.getTagCompound().getDouble("tpY") == 0D && stack.getTagCompound().getDouble("tpZ") == 0D) {
                list.add(EnumChatFormatting.RED + StatCollector.translateToLocal("tooltip.item.tpPearcel.line2.notBound"));
            }else{
                list.add(EnumChatFormatting.GREEN + StatCollector.translateToLocal("tooltip.item.tpPearcel.line2.bound") + " " + EnumChatFormatting.AQUA + Math.round(stack.getTagCompound().getDouble("tpX")) + " " + Math.round(stack.getTagCompound().getDouble("tpY")) + " " + Math.round(stack.getTagCompound().getDouble("tpZ")));
            }
        }else{
            list.add(EnumChatFormatting.RED + StatCollector.translateToLocal("tooltip.item.tpPearcel.line2.notBound"));
        }

    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
        if (!stack.hasTagCompound()){
            stack.setTagCompound(new NBTTagCompound());
            stack.getTagCompound().setDouble("tpX", 0D);
            stack.getTagCompound().setDouble("tpY", 0D);
            stack.getTagCompound().setDouble("tpZ", 0D);
            stack.getTagCompound().setInteger("dim", 0);
        }
        if (player.isSneaking()) {
            stack.getTagCompound().setDouble("tpX", player.posX);
            stack.getTagCompound().setDouble("tpY", player.posY);
            stack.getTagCompound().setDouble("tpZ", player.posZ);
            stack.getTagCompound().setInteger("dim", player.dimension);
            if(!world.isRemote) {
                player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.DARK_GREEN + StatCollector.translateToLocal("chat.tpPearcel.location.set")));
            }
        }else{
            tpX = stack.getTagCompound().getDouble("tpX");
            tpY = stack.getTagCompound().getDouble("tpY");
            tpZ = stack.getTagCompound().getDouble("tpZ");
            dim = stack.getTagCompound().getInteger("dim");
            if (tpX == 0D && tpY == 0D && tpZ == 0D) {
                if (!world.isRemote) {
                    player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.RED + StatCollector.translateToLocal("chat.tpPearcel.location.notSet")));
                }
            } else {
                if (player.dimension == dim) {
                    player.setPositionAndUpdate(tpX, tpY, tpZ);
                    if (!world.isRemote) {
                        player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + StatCollector.translateToLocal("chat.tpPearcel.tp")));
                    }
                    if (!player.capabilities.isCreativeMode) {
                        if (player.inventory.hasItemStack(new ItemStack(ModItems.pearcel_item))) {
                            player.inventory.consumeInventoryItem(ModItems.pearcel_item);
                        } else {
                            stack.damageItem(1, player);
                        }
                    }
                }else{
                    if(!world.isRemote){
                        player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.RED + StatCollector.translateToLocal("chat.tpPearcel.wrongDim")));
                    }
                }
            }
        }
        return stack;
    }

}
