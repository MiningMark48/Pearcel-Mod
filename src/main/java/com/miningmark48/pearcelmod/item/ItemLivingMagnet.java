package com.miningmark48.pearcelmod.item;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import cofh.api.energy.ItemEnergyContainer;
import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import com.miningmark48.pearcelmod.utility.KeyCheck;
import com.miningmark48.pearcelmod.utility.Translate;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
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

public class ItemLivingMagnet extends ItemEnergyContainer implements IBauble{

    public ItemLivingMagnet(){
        super(ConfigurationHandler.rfStorage_livingMagnet, ConfigurationHandler.rfTransferPerTick_livingMagnet);
        setMaxStackSize(1);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
        if (KeyCheck.isHoldingShift()) {
            if (!stack.hasTagCompound()) {
                stack.setTagCompound(new NBTTagCompound());
                stack.getTagCompound().setBoolean("enabled", false);
                stack.getTagCompound().setString("mode", "Attracts");
            }
            list.add(TextFormatting.YELLOW + Translate.toLocal("tooltip.item.living_magnet.line1") + " " + TextFormatting.AQUA + stack.getTagCompound().getBoolean("enabled"));
            list.add(TextFormatting.GREEN + Translate.toLocal("tooltip.item.living_magnet.line4") + " " + TextFormatting.AQUA + stack.getTagCompound().getString("mode"));
            list.add(Translate.toLocal("tooltip.item.living_magnet.line2.p1") + " " + ConfigurationHandler.pearcelMagnetRange + " " + Translate.toLocal("tooltip.item.living_magnet.line2.p2"));
            list.add(Translate.toLocal("tooltip.item.living_magnet.line3"));
            if (ConfigurationHandler.rfUseEnabled_livingMagnet) list.add(TextFormatting.GREEN + Translate.toLocal("tooltip.item.rfUse") + " " + ConfigurationHandler.rfPerTick_livingMagnet + " RF/T");
            if (ConfigurationHandler.rfUseEnabled_livingMagnet) list.add(TextFormatting.RED + Translate.toLocal("tooltip.item.rf")+ " " + TextFormatting.GREEN + getEnergyStored(stack) + " / " + getMaxEnergyStored(stack));
        }else{
            list.add(Translate.toLocal("tooltip.item.hold") + " " + TextFormatting.AQUA + TextFormatting.ITALIC + Translate.toLocal("tooltip.item.shift"));
        }

    }

    @Override
    public ActionResult onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand) {
        if (!stack.hasTagCompound()){
            stack.setTagCompound(new NBTTagCompound());
            stack.getTagCompound().setBoolean("enabled", false);
            stack.getTagCompound().setString("mode", "Attracts");
        }

        if (!world.isRemote) {
            if(!player.isSneaking()) {
                if (stack.getTagCompound().getBoolean("enabled")) {
                    stack.getTagCompound().setBoolean("enabled", false);
                    player.sendMessage(new TextComponentString(TextFormatting.DARK_RED + Translate.toLocal("chat.item.living_magnet.disabled")));
                } else {
                    stack.getTagCompound().setBoolean("enabled", true);
                    player.sendMessage(new TextComponentString(TextFormatting.GOLD + Translate.toLocal("chat.item.living_magnet.enabled")));
                }
            }else{
                if (stack.getTagCompound().getString("mode").equalsIgnoreCase("attracts")) {
                    stack.getTagCompound().setString("mode", "Repels");
                    player.sendMessage(new TextComponentString(TextFormatting.RED + Translate.toLocal("chat.item.living_magnet.repels")));
                } else {
                    stack.getTagCompound().setString("mode", "Attracts");
                    player.sendMessage(new TextComponentString(TextFormatting.GREEN + Translate.toLocal("chat.item.living_magnet.attracts")));
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

            if (stack.getTagCompound().getBoolean("enabled") && hasEnoughEnergy(stack, ConfigurationHandler.rfPerTick_livingMagnet, player)){
                double x = player.posX;
                double y = player.posY;
                double z = player.posZ;

                List<EntityLiving> entities = entity.world.getEntitiesWithinAABB(EntityLiving.class, new AxisAlignedBB(x - range, y - range, z - range, x + range, y + range, z + range));
                for (EntityLiving e: entities){
                    if (!player.isSneaking()){

                        if (stack.getTagCompound().getString("mode").equalsIgnoreCase("attracts")) {
                            e.addVelocity((x - e.posX) * pullSpeed, (y - e.posY) * pullSpeed, (z - e.posZ) * pullSpeed); //Attracts
                        }else {
                            e.addVelocity((e.posX - x) * pullSpeed, (e.posY - y) * pullSpeed, (e.posZ - z) * pullSpeed); //Repels
                        }

                        if (ConfigurationHandler.pearcelMagnetParticles){
                            world.spawnParticle(EnumParticleTypes.SPELL_INSTANT, e.posX, e.posY + 0.3, e.posZ, 0.0D, 0.0D, 0.0D);
                        }

                    }

                    useEnergy(stack, ConfigurationHandler.rfPerTick_livingMagnet, false, player);

                }
            }

        }
    }

    @Override
    public int receiveEnergy(ItemStack container, int maxReceive, boolean simulate) {
        if (!ConfigurationHandler.rfUseEnabled_livingMagnet){
            return 0;
        }
        return super.receiveEnergy(container, maxReceive, simulate);
    }

    private static boolean hasEnoughEnergy(ItemStack stack, int energyPerUse, EntityPlayer player){

        if (!ConfigurationHandler.rfUseEnabled_livingMagnet){
            return true;
        }

        if (!player.isCreative()) {
            ItemLivingMagnet stack1 = new ItemLivingMagnet();
            if (energyPerUse <= stack1.getEnergyStored(stack)) {
                return true;
            }
        }

        return false;

    }

    public static void useEnergy(ItemStack stack, int useAmount, boolean simulate, EntityPlayer player){
        if (!player.isCreative() && ConfigurationHandler.rfUseEnabled_livingMagnet) {
            ItemLivingMagnet stack1 = new ItemLivingMagnet();
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
