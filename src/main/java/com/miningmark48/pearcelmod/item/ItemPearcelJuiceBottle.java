package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.handler.IGeneratorFuelHandler;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class ItemPearcelJuiceBottle extends ItemPearcelMod implements IGeneratorFuelHandler{

    public ItemPearcelJuiceBottle(){
        setMaxStackSize(1);
    }

    @Nullable
    public ItemStack onItemUseFinish(ItemStack item, World world, EntityLivingBase entityLiving)
    {
        if (entityLiving instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entityLiving;
            if (!player.capabilities.isCreativeMode) {
                item.shrink(1);
            }

            if (!world.isRemote) {
                player.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 1500, 3));
                player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 1500, 2));
                player.heal(5.0F);
            }
        }
        return item.getCount() <= 0 ? new ItemStack((Items.GLASS_BOTTLE)) : item;
    }

    public int getMaxItemUseDuration(ItemStack stack)
    {
        return 16;
    }

    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.DRINK;
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
