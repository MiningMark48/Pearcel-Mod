package com.miningmark48.pearcelmod.item;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import cofh.redstoneflux.impl.ItemEnergyContainer;
import com.miningmark48.mininglib.utility.KeyChecker;
import com.miningmark48.mininglib.utility.ModTranslate;
import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
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

import javax.annotation.Nullable;
import java.util.List;

public class ItemPearcelMagnet extends ItemEnergyContainer implements IBauble{

    public ItemPearcelMagnet(){
        super(ConfigurationHandler.rfStorage_magnet, ConfigurationHandler.rfTransferPerTick_magnet);
        setMaxStackSize(1);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World playerIn, List<String> list, ITooltipFlag advanced) {
        if (KeyChecker.isHoldingShift()) {
            if (!stack.hasTagCompound()) {
                stack.setTagCompound(new NBTTagCompound());
                stack.getTagCompound().setBoolean("enabled", false);
                stack.getTagCompound().setString("mode", "Attracts");
            }
            list.add(TextFormatting.YELLOW + ModTranslate.toLocal("tooltip.item.pearcel_magnet.line1") + " " + TextFormatting.AQUA + stack.getTagCompound().getBoolean("enabled"));
            list.add(TextFormatting.GREEN + ModTranslate.toLocal("tooltip.item.pearcel_magnet.line4") + " " + TextFormatting.AQUA + stack.getTagCompound().getString("mode"));
            list.add(ModTranslate.toLocal("tooltip.item.pearcel_magnet.line2.p1") + " " + ConfigurationHandler.pearcelMagnetRange + " " + ModTranslate.toLocal("tooltip.item.pearcel_magnet.line2.p2"));
            list.add(ModTranslate.toLocal("tooltip.item.pearcel_magnet.line3"));
            if (ConfigurationHandler.rfUseEnabled_magnet) list.add(TextFormatting.GREEN + ModTranslate.toLocal("tooltip.item.rfUse") + " " + ConfigurationHandler.rfPerTick_magnet + " RF/T");
            if (ConfigurationHandler.rfUseEnabled_magnet) list.add(TextFormatting.RED + ModTranslate.toLocal("tooltip.item.rf")+ " " + TextFormatting.GREEN + getEnergyStored(stack) + " / " + getMaxEnergyStored(stack));

        }else{
            list.add(ModTranslate.toLocal("tooltip.item.hold") + " " + TextFormatting.AQUA + TextFormatting.ITALIC + ModTranslate.toLocal("tooltip.item.shift"));
        }

    }

    @Override
    public ActionResult onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack stack = player.getHeldItem(hand);
        if (!stack.hasTagCompound()){
            stack.setTagCompound(new NBTTagCompound());
            stack.getTagCompound().setBoolean("enabled", false);
            stack.getTagCompound().setString("mode", "Attracts");
        }

        if (!world.isRemote) {
            if(!player.isSneaking()) {
                if (stack.getTagCompound().getBoolean("enabled")) {
                    stack.getTagCompound().setBoolean("enabled", false);
                    player.sendMessage(new TextComponentString(TextFormatting.DARK_RED + ModTranslate.toLocal("chat.item.pearcel_magnet.disabled")));
                } else {
                    stack.getTagCompound().setBoolean("enabled", true);
                    player.sendMessage(new TextComponentString(TextFormatting.GOLD + ModTranslate.toLocal("chat.item.pearcel_magnet.enabled")));
                }
            }else{
                if (stack.getTagCompound().getString("mode").equalsIgnoreCase("attracts")) {
                    stack.getTagCompound().setString("mode", "Repels");
                    player.sendMessage(new TextComponentString(TextFormatting.RED + ModTranslate.toLocal("chat.item.pearcel_magnet.repels")));
                } else {
                    stack.getTagCompound().setString("mode", "Attracts");
                    player.sendMessage(new TextComponentString(TextFormatting.GREEN + ModTranslate.toLocal("chat.item.pearcel_magnet.attracts")));
                }
            }
        }

        return new ActionResult(EnumActionResult.SUCCESS, stack);

    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected){
        doUpdate(stack, world, entity);
    }



    private void doUpdate(ItemStack stack, World world, Entity entity){

        int range = ConfigurationHandler.pearcelMagnetRange;
        float pullSpeed = ConfigurationHandler.pearcelMagnetPullSpeed;

        if (!stack.hasTagCompound()){
            stack.setTagCompound(new NBTTagCompound());
            stack.getTagCompound().setBoolean("enabled", false);
            stack.getTagCompound().setString("mode", "Attracts");
        }

        if(entity instanceof EntityPlayer){
            EntityPlayer player = (EntityPlayer) entity;

            if (stack.getTagCompound().getBoolean("enabled") && hasEnoughEnergy(stack, ConfigurationHandler.rfPerTick_magnet, player)){
                double x = player.posX;
                double y = player.posY;
                double z = player.posZ;

                List<EntityItem> items = entity.world.getEntitiesWithinAABB(EntityItem.class, new AxisAlignedBB(x - range, y - range, z - range, x + range, y + range, z + range));
                List<EntityXPOrb> xp = entity.world.getEntitiesWithinAABB(EntityXPOrb.class, new AxisAlignedBB(x - range, y - range, z - range, x + range, y + range, z + range));
                for (EntityItem e: items){
                    if (!player.isSneaking()){

                        if (stack.getTagCompound().getString("mode").equalsIgnoreCase("attracts")) {
                            e.addVelocity((x - e.posX) * pullSpeed, (y - e.posY) * pullSpeed, (z - e.posZ) * pullSpeed); //Attracts
                        }else {
                            e.addVelocity((e.posX - x) * pullSpeed, (e.posY - y) * pullSpeed, (e.posZ - z) * pullSpeed); //Repels
                        }

                        if (ConfigurationHandler.pearcelMagnetParticles) {
                            world.spawnParticle(EnumParticleTypes.SPELL_INSTANT, e.posX, e.posY + 0.3, e.posZ, 0.0D, 0.0D, 0.0D);
                        }

                        useEnergy(stack, ConfigurationHandler.rfPerTick_magnet, false, player);

                    }
                }
                for (EntityXPOrb e: xp){
                    if (!player.isSneaking()){
                        if (stack.getTagCompound().getString("mode").equalsIgnoreCase("attracts")) {
                            e.addVelocity((x - e.posX) * pullSpeed, (y - e.posY) * pullSpeed, (z - e.posZ) * pullSpeed); //Attracts
                        }else {
                            e.addVelocity((e.posX - x) * pullSpeed, (e.posY - y) * pullSpeed, (e.posZ - z) * pullSpeed); //Repels
                        }

                        useEnergy(stack, ConfigurationHandler.rfPerTick_magnet, false, player);

                    }
                }

            }

        }
    }

    @Override
    public int receiveEnergy(ItemStack container, int maxReceive, boolean simulate) {
        if (!ConfigurationHandler.rfUseEnabled_magnet){
            return 0;
        }
        return super.receiveEnergy(container, maxReceive, simulate);
    }

    private static boolean hasEnoughEnergy(ItemStack stack, int energyPerUse, EntityPlayer player){

        if (!ConfigurationHandler.rfUseEnabled_magnet){
            return true;
        }

        if (!player.isCreative()) {
            ItemPearcelMagnet stack1 = new ItemPearcelMagnet();
            if (energyPerUse <= stack1.getEnergyStored(stack)) {
                return true;
            }
        }else {
            return true;
        }

        return false;

    }

    public static void useEnergy(ItemStack stack, int useAmount, boolean simulate, EntityPlayer player){
        if (!player.isCreative() && ConfigurationHandler.rfUseEnabled_magnet) {
            ItemPearcelMagnet stack1 = new ItemPearcelMagnet();
            stack1.extractEnergy(stack, useAmount, simulate);
        }
    }

    //Baubles

    @Override
    public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
        if (player instanceof EntityPlayer) {
            doUpdate(itemstack, player.getEntityWorld(), player);
        }
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemstack) {
        return BaubleType.AMULET;
    }


}
