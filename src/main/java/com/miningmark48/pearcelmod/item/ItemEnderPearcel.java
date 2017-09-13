package com.miningmark48.pearcelmod.item;

import cofh.redstoneflux.impl.ItemEnergyContainer;
import com.miningmark48.mininglib.utility.KeyChecker;
import com.miningmark48.mininglib.utility.ModTranslate;
import com.miningmark48.pearcelmod.entity.EntityEnderPearcel;
import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import com.miningmark48.pearcelmod.handler.IGeneratorFuelHandler;
import com.miningmark48.pearcelmod.init.ModItems;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemEnderPearcel extends ItemEnergyContainer implements IGeneratorFuelHandler{

    public ItemEnderPearcel(){
        super(ConfigurationHandler.rfStorage_enderPearcel, ConfigurationHandler.rfTransferPerTick_enderPearcel);
        setMaxDamage(128);
        setMaxStackSize(1);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World playerIn, List<String> list, ITooltipFlag advanced) {
        if (KeyChecker.isHoldingShift()) {
            list.add(ModTranslate.toLocal("tooltip.item.pearcelPearl.line1"));
            if (ConfigurationHandler.rfUseEnabled_enderPearcel) list.add(TextFormatting.GREEN + ModTranslate.toLocal("tooltip.item.rfUse") + " " + ConfigurationHandler.rfPerUse_enderPearcel + " RF/Use");
            if (ConfigurationHandler.rfUseEnabled_enderPearcel) list.add(TextFormatting.RED + ModTranslate.toLocal("tooltip.item.rf")+ " " + TextFormatting.GREEN + getEnergyStored(stack) + " / " + getMaxEnergyStored(stack));
        }else{
            list.add(ModTranslate.toLocal("tooltip.item.hold") + " " + TextFormatting.AQUA + TextFormatting.ITALIC + ModTranslate.toLocal("tooltip.item.shift"));
        }

    }

    @Override
    public ActionResult onItemRightClick(World world, EntityPlayer player, EnumHand hand)
    {
        ItemStack stack = player.getHeldItem(hand);
        float velocity = ConfigurationHandler.enderPearcelVelocity;

        if (!player.isCreative()) {
            if (hasEnoughEnergy(stack, ConfigurationHandler.rfPerUse_enderPearcel, player)){
                useEnergy(stack, ConfigurationHandler.rfPerUse_enderPearcel, false, player);
            }else{
                stack.damageItem(1, player);
            }

        }

        if (ConfigurationHandler.doEnderPearcelCooldown) {
            player.getCooldownTracker().setCooldown(this, ConfigurationHandler.enderPearcelCooldownTime * 20);
        }

        world.playSound(player, player.getPosition(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 0.5F, 0.4F);
        if (!world.isRemote) {
            EntityEnderPearcel pearl = new EntityEnderPearcel(world, player);
            pearl.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0.0F, velocity, 0.0F);
            world.spawnEntity(pearl);
        }

        return new ActionResult(EnumActionResult.SUCCESS, stack);
    }

    private static boolean hasEnoughEnergy(ItemStack stack, int energyPerUse, EntityPlayer player){

        if (!ConfigurationHandler.rfUseEnabled_enderPearcel){
            return true;
        }

        if (!player.isCreative()) {
            ItemEnderPearcel stack1 = new ItemEnderPearcel();
            if (energyPerUse <= stack1.getEnergyStored(stack)) {
                return true;
            }
        }

        return false;

    }

    public static void useEnergy(ItemStack stack, int useAmount, boolean simulate, EntityPlayer player){
        if (!player.isCreative() && ConfigurationHandler.rfUseEnabled_enderPearcel) {
            ItemEnderPearcel stack1 = new ItemEnderPearcel();
            stack1.extractEnergy(stack, useAmount, simulate);
        }
    }

    @Override
    public int getCooldownTime(ItemStack fuel) {
        if (fuel.isItemEqual(new ItemStack(ModItems.ender_pearcel))) {
            return 500;
        }
        return 0;
    }

    @Override
    public int getRFPerTick(ItemStack fuel) {
        if (fuel.isItemEqual(new ItemStack(ModItems.ender_pearcel))) {
            return 25;
        }
        return 0;
    }
}
