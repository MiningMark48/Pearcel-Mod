package com.miningmark48.pearcelmod.item;

import com.miningmark48.mininglib.utility.KeyChecker;
import com.miningmark48.mininglib.utility.ModTranslate;
import com.miningmark48.pearcelmod.handler.IGeneratorFuelHandler;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemJeweledPearcel extends ItemPearcelFood implements IGeneratorFuelHandler{

    public ItemJeweledPearcel() {
        super(10, 6.0F, false);
        setAlwaysEdible();
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World playerIn, List<String> par3List, ITooltipFlag advanced) {
        if (KeyChecker.isHoldingShift()) {
            par3List.add(ModTranslate.toLocal("tooltip.item.jeweled_pearcel.line1"));
        }else{
            par3List.add(ModTranslate.toLocal("tooltip.item.hold") + " " + TextFormatting.AQUA + TextFormatting.ITALIC + ModTranslate.toLocal("tooltip.item.shift"));
        }
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
    {
        if (entityLiving instanceof EntityPlayer)
        {
            EntityPlayer entityplayer = (EntityPlayer)entityLiving;
            if(!entityplayer.isCreative()) {
                stack.shrink(1);
            }

            entityplayer.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 1500, 1));
            entityplayer.addPotionEffect(new PotionEffect(MobEffects.HASTE, 2000, 3));
            entityplayer.addPotionEffect(new PotionEffect(MobEffects.SATURATION, 3500, 0));
            entityplayer.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 5000, 3));
            entityplayer.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 5000, 2));
            entityplayer.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 7000, 0));
            entityplayer.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 7000, 5));

        }
        return stack;
    }

    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
        playerIn.setActiveHand(hand);
        return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
        return true;
    }

}
