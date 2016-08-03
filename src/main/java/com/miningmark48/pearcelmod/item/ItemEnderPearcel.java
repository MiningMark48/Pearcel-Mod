package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.achievements.Achievements;
import com.miningmark48.pearcelmod.entity.EntityEnderPearcel;
import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import com.miningmark48.pearcelmod.utility.KeyCheck;
import com.miningmark48.pearcelmod.utility.Translate;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.util.List;

public class ItemEnderPearcel extends ItemPearcelMod{

    public ItemEnderPearcel(){
        setMaxDamage(128);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
        if (KeyCheck.isHoldingShift()) {
            list.add(Translate.toLocal("tooltip.item.pearcelPearl.line1"));
        }else{
            list.add(Translate.toLocal("tooltip.item.hold") + " " + TextFormatting.AQUA + TextFormatting.ITALIC + Translate.toLocal("tooltip.item.shift"));
        }

    }

    @Override
    public ActionResult onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand)
    {
        float velocity = ConfigurationHandler.enderPearcelVelocity;

        if (!player.isCreative()) {
            stack.damageItem(1, player);
        }

        if (ConfigurationHandler.doEnderPearcelCooldown) {
            player.getCooldownTracker().setCooldown(this, ConfigurationHandler.enderPearcelCooldownTime * 20);
        }

        world.playSound(player, player.getPosition(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 0.5F, 0.4F);
        if (!world.isRemote) {
            EntityEnderPearcel pearl = new EntityEnderPearcel(world, player);
            pearl.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0.0F, velocity, 0.0F);
            world.spawnEntityInWorld(pearl);
        }

        return new ActionResult(EnumActionResult.SUCCESS, stack);
    }

}
