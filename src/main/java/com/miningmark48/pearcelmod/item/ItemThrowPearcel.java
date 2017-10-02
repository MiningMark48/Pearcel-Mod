package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.entity.EntityThrowPearcel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemSnowball;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class ItemThrowPearcel extends ItemSnowball{

    public final ItemThrowPearcel.TYPE type;

    public ItemThrowPearcel(ItemThrowPearcel.TYPE type, int stackSize){
        setMaxStackSize(stackSize);
        this.type = type;
    }

    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand) {
        ItemStack itemStackIn = playerIn.getHeldItem(hand);
        if(!playerIn.capabilities.isCreativeMode) {
            itemStackIn.shrink(1);
        }

        worldIn.playSound(null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if(!worldIn.isRemote) {
            launchThrowball(worldIn, playerIn);
        }

        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStackIn);
    }

    private void launchThrowball(World world, EntityPlayer player) {
        EntityThrowPearcel entity = new EntityThrowPearcel(world, player, type);
        entity.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0.0F, 2.1F, 0.5F);
        world.spawnEntity(entity);
    }

    public enum TYPE{
        EXPLOSIVE,
        SCATTER,
        ENTITY_TP,
        ENTITY_LAUNCH,
        ENTITY_MOUNT
    }

}
