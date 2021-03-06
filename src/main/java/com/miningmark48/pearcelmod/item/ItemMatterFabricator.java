package com.miningmark48.pearcelmod.item;

import com.miningmark48.mininglib.utility.KeyChecker;
import com.miningmark48.mininglib.utility.ModTranslate;
import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemMatterFabricator extends ItemPickaxe{

    public ItemMatterFabricator(ToolMaterial material){
        super(material);

    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World playerIn, List<String> list, ITooltipFlag advanced) {

        if (KeyChecker.isHoldingShift()) {

            if (stack.hasTagCompound()) {
                if(stack.getTagCompound().getInteger("mode") == 1) {
                    list.add(TextFormatting.GREEN + ModTranslate.toLocal("tooltip.item.mf.line1") + " " + TextFormatting.AQUA + "Junk Blocks");
                }else{
                    list.add(TextFormatting.GREEN + ModTranslate.toLocal("tooltip.item.mf.line1") + " " + TextFormatting.AQUA + "All Blocks");
                }
                list.add(TextFormatting.GREEN + ModTranslate.toLocal("tooltip.item.mf.line2") + " " + TextFormatting.AQUA + stack.getTagCompound().getInteger("mp") + "/" + ConfigurationHandler.matterFabricatorMPAmount);
            } else {
                stack.setTagCompound(new NBTTagCompound());
                stack.getTagCompound().setInteger("mode", 1);
                stack.getTagCompound().setInteger("mf", 0);
                if(stack.getTagCompound().getInteger("mode") == 1) {
                    list.add(TextFormatting.GREEN + ModTranslate.toLocal("tooltip.item.mf.line1") + " " + TextFormatting.AQUA + "Trash Blocks");
                }else{
                    list.add(TextFormatting.GREEN + ModTranslate.toLocal("tooltip.item.mf.line1") + " " + TextFormatting.AQUA + "All Blocks");
                }
                list.add(TextFormatting.GREEN + ModTranslate.toLocal("tooltip.item.mf.line2") + " " + TextFormatting.AQUA + stack.getTagCompound().getInteger("mp") + "/128");
            }

            list.add(TextFormatting.AQUA + ModTranslate.toLocal("tooltip.item.mf.line3"));
            list.add(ModTranslate.toLocal("tooltip.item.mf.line4"));
        }else{
            list.add(ModTranslate.toLocal("tooltip.item.hold") + " " + TextFormatting.AQUA + TextFormatting.ITALIC + ModTranslate.toLocal("tooltip.item.shift"));
        }

    }

    @Override
    public ActionResult onItemRightClick(World world, EntityPlayer player, EnumHand hand)
    {
        ItemStack item = player.getHeldItem(hand);
        if (player.isSneaking()){
            if (!item.hasTagCompound()){
                item.setTagCompound(new NBTTagCompound());
                item.getTagCompound().setInteger("mode", 1);
            }else{
                if (item.getTagCompound().getInteger("mode") == 1){
                    item.getTagCompound().setInteger("mode", 2);
                    if (!world.isRemote) {
                        player.sendMessage(new TextComponentTranslation(TextFormatting.GOLD + (ModTranslate.toLocal("chat.item.mf.modeChange"))));
                    }
                }else{
                    item.getTagCompound().setInteger("mode", 1);
                    if (!world.isRemote) {
                        player.sendMessage(new TextComponentTranslation(TextFormatting.GOLD + (ModTranslate.toLocal("chat.item.mf.modeChange"))));
                    }
                }
            }
            return new ActionResult(EnumActionResult.PASS, item);
        }else{
            return new ActionResult(EnumActionResult.PASS, item);
        }
    }


}
