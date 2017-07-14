package com.miningmark48.pearcelmod.item;

import com.miningmark48.mininglib.utility.KeyChecker;
import com.miningmark48.mininglib.utility.ModTranslate;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class ItemExperiencePearcel extends ItemPearcelMod{

    public ItemExperiencePearcel(){
        setMaxStackSize(1);
    }

    Random rand = new Random();

    @Override
    public void addInformation(ItemStack stack, @Nullable World playerIn, List<String> list, ITooltipFlag advanced) {
        if (KeyChecker.isHoldingShift()) {
            list.add(ModTranslate.toLocal("tooltip.item.experiencePearcel.line1"));
            list.add("");

            if (stack.hasTagCompound()) {
                if (stack.getTagCompound().getInteger("playerXP") == 0) {
                    list.add(TextFormatting.RED + ModTranslate.toLocal("tooltip.item.experiencePearcel.line2.noXP"));
                } else {
                    list.add(TextFormatting.GOLD + ModTranslate.toLocal("tooltip.item.experiencePearcel.line2.XP") + " " + TextFormatting.AQUA + stack.getTagCompound().getInteger("playerXP"));
                }
            } else {
                list.add(TextFormatting.RED + ModTranslate.toLocal("tooltip.item.experiencePearcel.line2.noXP"));
            }
        }else{
            list.add(ModTranslate.toLocal("tooltip.item.hold") + " " + TextFormatting.AQUA + TextFormatting.ITALIC + ModTranslate.toLocal("tooltip.item.shift"));
        }

    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
        return true;
    }

    @Override
    public ActionResult onItemRightClick(World world, EntityPlayer player, EnumHand hand)
    {
        ItemStack item = player.getHeldItem(hand);

        if(!item.hasTagCompound()){
            item.setTagCompound(new NBTTagCompound());
            item.getTagCompound().setInteger("playerXP", 0);
        }
        if (!player.isSneaking()){
            int xpToGather = player.experienceLevel + item.getTagCompound().getInteger("playerXP");
            player.experienceLevel = xpToGather;
            item.getTagCompound().setInteger("playerXP", 0);
            player.playSound(SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, 0.2F, rand.nextFloat() * 2.5F);
            return new ActionResult(EnumActionResult.PASS, item);
        }else{
            int xpToStore = player.experienceLevel + item.getTagCompound().getInteger("playerXP");
            item.getTagCompound().setInteger("playerXP", xpToStore);
            player.experienceLevel = 0;
            player.playSound(SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, 0.2F, rand.nextFloat() * 2.5F);
            return new ActionResult(EnumActionResult.PASS, item);
        }
    }

}
