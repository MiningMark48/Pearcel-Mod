package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ItemGlowingPearcel extends ItemPearcelFood{

    public ItemGlowingPearcel() {
        super(3, 1.2F, false);
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
    {

        double x = entityLiving.posX;
        double y = entityLiving.posY;
        double z = entityLiving.posZ;

        int range = ConfigurationHandler.glowingPearcelRange;

        List<EntityLiving> items = entityLiving.worldObj.getEntitiesWithinAABB(EntityLiving.class, new AxisAlignedBB(x - range, y - range, z - range, x + range, y + range, z + range));
        for (EntityLiving e: items){
            e.addPotionEffect(new PotionEffect(MobEffects.GLOWING, 1500, 0));
        }

        if (entityLiving instanceof EntityPlayer)
        {
            EntityPlayer entityplayer = (EntityPlayer)entityLiving;
            entityplayer.getFoodStats().addStats(this, stack);
            worldIn.playSound((EntityPlayer)null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 0.5F, worldIn.rand.nextFloat() * 0.1F + 0.9F);
            this.onFoodEaten(stack, worldIn, entityplayer);
            entityplayer.addStat(StatList.getObjectUseStats(this));

            entityplayer.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 1500, 0));

            if(!entityplayer.isCreative()) {
                --stack.stackSize;
            }

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
