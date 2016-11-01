package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.utility.KeyCheck;
import com.miningmark48.pearcelmod.utility.Translate;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.util.List;

public class ItemPearcelMagnet extends ItemPearcelMod{

    //TODO: Add config settings for range and pullSpeed

    public int range = 9;
    public double pullSpeed = 0.035D;

    public ItemPearcelMagnet(){
        setMaxStackSize(1);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
        if (KeyCheck.isHoldingShift()) {
            if (!stack.hasTagCompound()) {
                stack.setTagCompound(new NBTTagCompound());
                stack.getTagCompound().setBoolean("enabled", false);
            }
            list.add(TextFormatting.YELLOW + Translate.toLocal("tooltip.item.pearcel_magnet.line1") + " " + TextFormatting.AQUA + stack.getTagCompound().getBoolean("enabled"));
            list.add(Translate.toLocal("tooltip.item.pearcel_magnet.line2.p1") + " " + range + " " + Translate.toLocal("tooltip.item.pearcel_magnet.line2.p2"));
            list.add(Translate.toLocal("tooltip.item.pearcel_magnet.line3"));
        }else{
            list.add(Translate.toLocal("tooltip.item.hold") + " " + TextFormatting.AQUA + TextFormatting.ITALIC + Translate.toLocal("tooltip.item.shift"));
        }

    }

    @Override
    public ActionResult onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand) {
        if (!stack.hasTagCompound()){
            stack.setTagCompound(new NBTTagCompound());
            stack.getTagCompound().setBoolean("enabled", false);
        }

        if (!world.isRemote) {
            if (stack.getTagCompound().getBoolean("enabled")) {
                stack.getTagCompound().setBoolean("enabled", false);
                player.addChatComponentMessage(new TextComponentString(TextFormatting.GOLD + Translate.toLocal("chat.item.pearcel_magnet.disabled")));
            } else {
                stack.getTagCompound().setBoolean("enabled", true);
                player.addChatComponentMessage(new TextComponentString(TextFormatting.GOLD + Translate.toLocal("chat.item.pearcel_magnet.enabled")));
            }
        }

        return new ActionResult(EnumActionResult.SUCCESS, stack);

    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected){
        if (!stack.hasTagCompound()){
            stack.setTagCompound(new NBTTagCompound());
            stack.getTagCompound().setBoolean("enabled", false);
        }

        if(entity instanceof EntityPlayer){
            EntityPlayer player = (EntityPlayer) entity;

            if (stack.getTagCompound().getBoolean("enabled")){
                double x = player.posX;
                double y = player.posY;
                double z = player.posZ;

                List<EntityItem> items = entity.worldObj.getEntitiesWithinAABB(EntityItem.class, new AxisAlignedBB(x - range, y - range, z - range, x + range, y + range, z + range));
                for (EntityItem e: items){
                    if (!player.isSneaking()){
                        e.addVelocity((x - e.posX) * pullSpeed, (y - e.posY) * pullSpeed, (z - e.posZ) * pullSpeed); //Attracts
                        //e.addVelocity((e.posX - x) * pullSpeed, (e.posY - y) * pullSpeed, (e.posZ - z) * pullSpeed); //Repels

                        world.spawnParticle(EnumParticleTypes.SPELL_INSTANT, e.posX, e.posY + 0.3, e.posZ, 0.0D, 0.0D, 0.0D);

                    }
                }

            }

        }
    }

}
