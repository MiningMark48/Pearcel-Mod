package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.init.ModBlocks;
import com.miningmark48.pearcelmod.utility.KeyCheck;
import com.miningmark48.pearcelmod.utility.Translate;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.util.List;

public class ItemPearcelBlockPlacer extends ItemPearcelMod{

    public ItemPearcelBlockPlacer(){
        setMaxStackSize(1);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {

        if (KeyCheck.isHoldingShift()) {

            if (stack.hasTagCompound()) {
                list.add(TextFormatting.GREEN + Translate.toLocal("tooltip.item.pbp.line1") + " " + stack.getTagCompound().getInteger("mode"));
            } else {
                stack.setTagCompound(new NBTTagCompound());
                stack.getTagCompound().setInteger("mode", 1);
                list.add(TextFormatting.GREEN + Translate.toLocal("tooltip.item.pbp.line1") + " " + stack.getTagCompound().getInteger("mode"));
            }

            list.add(TextFormatting.AQUA + Translate.toLocal("tooltip.item.pbp.line2"));
        }else{
            list.add(Translate.toLocal("tooltip.item.hold") + " " + TextFormatting.AQUA + TextFormatting.ITALIC + Translate.toLocal("tooltip.item.shift"));
        }

    }

    @Override
    public EnumActionResult onItemUse(ItemStack item, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (!world.isRemote)
        {
            if (!item.hasTagCompound()){
                item.setTagCompound(new NBTTagCompound());
                item.getTagCompound().setInteger("mode", 1);
            }
            if (item.getTagCompound().getInteger("mode") == 1){
                world.setBlockState(pos.offset(side), ModBlocks.pearcel_stone.getDefaultState());
            }else{
                world.setBlockState(pos.offset(side), Blocks.COBBLESTONE.getDefaultState());
            }
        }
        return EnumActionResult.SUCCESS;
    }

    @Override
    public ActionResult onItemRightClick(ItemStack item, World world, EntityPlayer player, EnumHand hand)
    {
        if (player.isSneaking()){
            if (!item.hasTagCompound()){
                item.setTagCompound(new NBTTagCompound());
                item.getTagCompound().setInteger("mode", 1);
            }else{
                if (item.getTagCompound().getInteger("mode") == 1){
                    item.getTagCompound().setInteger("mode", 2);
                    if (!world.isRemote) {
                        player.addChatComponentMessage(new TextComponentTranslation(TextFormatting.GOLD + (Translate.toLocal("chat.item.pbp.modeChange"))));
                    }
                }else{
                    item.getTagCompound().setInteger("mode", 1);
                    if (!world.isRemote) {
                        player.addChatComponentMessage(new TextComponentTranslation(TextFormatting.GOLD + (Translate.toLocal("chat.item.pbp.modeChange"))));
                    }
                }
            }
            return new ActionResult(EnumActionResult.PASS, item);
        }else{
            return new ActionResult(EnumActionResult.PASS, item);
        }
    }

}
