package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.utility.KeyCheck;
import com.miningmark48.pearcelmod.utility.Translate;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.util.List;

public class ItemNullificationPearcel extends ItemPearcelMod{

    public ItemNullificationPearcel(){
        setMaxStackSize(1);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {

        if (KeyCheck.isHoldingShift()) {

            if (stack.hasTagCompound()) {
                String txt = stack.getTagCompound().getString("nullBlock");
                txt = txt.replace("Block{", "");
                txt = txt.replace("}", "");

                list.add(TextFormatting.GREEN + Translate.toLocal("tooltip.item.nullification_pearcel.line1") + " " + TextFormatting.AQUA + txt);
            } else {
                list.add(TextFormatting.YELLOW + Translate.toLocal("tooltip.item.nullification_pearcel.line2"));
            }

            list.add(TextFormatting.AQUA + Translate.toLocal("tooltip.item.nullification_pearcel.line3"));
        }else{
            list.add(Translate.toLocal("tooltip.item.hold") + " " + TextFormatting.AQUA + TextFormatting.ITALIC + Translate.toLocal("tooltip.item.shift"));
        }

    }

    @Override
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

        if(!worldIn.isRemote) {
            if (!stack.hasTagCompound()) {
                stack.setTagCompound(new NBTTagCompound());
            }
            stack.getTagCompound().setString("nullBlock", worldIn.getBlockState(pos).getBlock().toString());
            playerIn.addChatComponentMessage(new TextComponentString(Translate.toLocal("chat.item.nullification_pearcel.set") + " " + TextFormatting.GOLD + new ItemStack(worldIn.getBlockState(pos).getBlock()).getDisplayName()));
        }
        return EnumActionResult.SUCCESS;
    }
}
