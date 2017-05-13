package com.miningmark48.pearcelmod.item;

import cofh.api.energy.ItemEnergyContainer;
import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.utility.KeyCheck;
import com.miningmark48.pearcelmod.utility.LogHelper;
import com.miningmark48.pearcelmod.utility.Translate;
import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.entity.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import sun.rmi.log.LogHandler;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class ItemCharmedPearcel extends ItemEnergyContainer{

    public ItemCharmedPearcel(){
        super(ConfigurationHandler.rfStorage_charmedPearcel, ConfigurationHandler.rfTransferPerTick_charmedPeacel); //TODO: Config
        setMaxStackSize(1);

        this.addPropertyOverride(new ResourceLocation("type"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                if (!stack.hasTagCompound()){
                    stack.setTagCompound(new NBTTagCompound());
                    stack.getTagCompound().setString("type", "none");
                    stack.getTagCompound().setBoolean("active", true);
                }

                if (stack.getTagCompound().getString("type").equalsIgnoreCase("fire")){
                    return 1;
                }else if (stack.getTagCompound().getString("type").equalsIgnoreCase("water")){
                    return 2;
                }else if (stack.getTagCompound().getString("type").equalsIgnoreCase("saturation")){
                    return 3;
                }else if (stack.getTagCompound().getString("type").equalsIgnoreCase("step_assist")){
                    return 4;
                }else if (stack.getTagCompound().getString("type").equalsIgnoreCase("fall")){
                    return 5;
                }else if (stack.getTagCompound().getString("type").equalsIgnoreCase("gravity")){
                    return 6;
                }else if (stack.getTagCompound().getString("type").equalsIgnoreCase("adrenaline")){
                    return 7;
                }else if (stack.getTagCompound().getString("type").equalsIgnoreCase("cloaking")){
                    return 8;
                }else if (stack.getTagCompound().getString("type").equalsIgnoreCase("hearty")){
                    return 9;
                }else if (stack.getTagCompound().getString("type").equalsIgnoreCase("repair")){
                    return 10;
                }else if (stack.getTagCompound().getString("type").equalsIgnoreCase("physco")){
                    return 11;
                }else if (stack.getTagCompound().getString("type").equalsIgnoreCase("third_eye")){
                    return 12;
                }else{
                    return 0;
                }

            }
        });

    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {

        //if (KeyCheck.isHoldingShift()) {
            if (stack.hasTagCompound()) {

                if (!stack.getTagCompound().getString("type").equalsIgnoreCase("none")) {
                    list.add(TextFormatting.DARK_AQUA + Translate.toLocal("tooltip.item.charmed_pearcel.line2.mode") + " " + (stack.getTagCompound().getBoolean("active") ? TextFormatting.GREEN + Translate.toLocal("tooltip.item.charmed_pearcel.line2.mode.active") : TextFormatting.RED + Translate.toLocal("tooltip.item.charmed_pearcel.line2.mode.not_active")));
                }

                if (stack.getTagCompound().getString("type").equalsIgnoreCase("fire")){
                    list.add(TextFormatting.YELLOW + Translate.toLocal("tooltip.item.charmed_pearcel.line1.type.fire"));
                    list.add(TextFormatting.AQUA + Translate.toLocal("tooltip.item.charmed_pearcel.line1.type.fire.desc"));
                    list.add(TextFormatting.GREEN + "Uses " + ConfigurationHandler.rfPerTick_charmedPearcel_fire + " RF/T");
                }else if (stack.getTagCompound().getString("type").equalsIgnoreCase("water")){
                    list.add(TextFormatting.YELLOW + Translate.toLocal("tooltip.item.charmed_pearcel.line1.type.water"));
                    list.add(TextFormatting.AQUA + Translate.toLocal("tooltip.item.charmed_pearcel.line1.type.water.desc"));
                    list.add(TextFormatting.GREEN + "Uses " + ConfigurationHandler.rfPerTick_charmedPearcel_water + " RF/T");
                }else if (stack.getTagCompound().getString("type").equalsIgnoreCase("saturation")){
                    list.add(TextFormatting.YELLOW + Translate.toLocal("tooltip.item.charmed_pearcel.line1.type.saturation"));
                    list.add(TextFormatting.AQUA + Translate.toLocal("tooltip.item.charmed_pearcel.line1.type.saturation.desc"));
                    list.add(TextFormatting.GREEN + "Uses " + ConfigurationHandler.rfPerTick_charmedPearcel_saturation + " RF/T");
                }else if (stack.getTagCompound().getString("type").equalsIgnoreCase("step_assist")){
                    list.add(TextFormatting.YELLOW + Translate.toLocal("tooltip.item.charmed_pearcel.line1.type.step_assist"));
                    list.add(TextFormatting.AQUA + Translate.toLocal("tooltip.item.charmed_pearcel.line1.type.step_assist.desc"));
                    list.add(TextFormatting.GREEN + "Uses " + ConfigurationHandler.rfPerTick_charmedPearcel_stepAssist + " RF/T");
                }else if (stack.getTagCompound().getString("type").equalsIgnoreCase("fall")){
                    list.add(TextFormatting.YELLOW + Translate.toLocal("tooltip.item.charmed_pearcel.line1.type.fall"));
                    list.add(TextFormatting.AQUA + Translate.toLocal("tooltip.item.charmed_pearcel.line1.type.fall.desc"));
                    list.add(TextFormatting.GREEN + "Uses " + ConfigurationHandler.rfPerTick_charmedPearcel_fall + " RF/T");
                }else if (stack.getTagCompound().getString("type").equalsIgnoreCase("gravity")){
                    list.add(TextFormatting.YELLOW + Translate.toLocal("tooltip.item.charmed_pearcel.line1.type.gravity"));
                    list.add(TextFormatting.AQUA + Translate.toLocal("tooltip.item.charmed_pearcel.line1.type.gravity.desc"));
                    list.add(TextFormatting.GREEN + "Uses " + ConfigurationHandler.rfPerTick_charmedPearcel_gravity + " RF/T");
                }else if (stack.getTagCompound().getString("type").equalsIgnoreCase("adrenaline")){
                    list.add(TextFormatting.YELLOW + Translate.toLocal("tooltip.item.charmed_pearcel.line1.type.adrenaline"));
                    list.add(TextFormatting.AQUA + Translate.toLocal("tooltip.item.charmed_pearcel.line1.type.adrenaline.desc"));
                    list.add(TextFormatting.GREEN + "Uses " + ConfigurationHandler.rfPerTick_charmedPearcel_adrenaline + " RF/T");
                }else if (stack.getTagCompound().getString("type").equalsIgnoreCase("cloaking")){
                    list.add(TextFormatting.YELLOW + Translate.toLocal("tooltip.item.charmed_pearcel.line1.type.cloaking"));
                    list.add(TextFormatting.AQUA + Translate.toLocal("tooltip.item.charmed_pearcel.line1.type.cloaking.desc"));
                    list.add(TextFormatting.GREEN + "Uses " + ConfigurationHandler.rfPerTick_charmedPearcel_cloaking + " RF/T");
                }else if (stack.getTagCompound().getString("type").equalsIgnoreCase("hearty")){
                    list.add(TextFormatting.YELLOW + Translate.toLocal("tooltip.item.charmed_pearcel.line1.type.hearty"));
                    list.add(TextFormatting.AQUA + Translate.toLocal("tooltip.item.charmed_pearcel.line1.type.hearty.desc"));
                    list.add(TextFormatting.GREEN + "Uses " + ConfigurationHandler.rfPerTick_charmedPearcel_hearty + " RF/T");
                }else if (stack.getTagCompound().getString("type").equalsIgnoreCase("repair")){
                    list.add(TextFormatting.YELLOW + Translate.toLocal("tooltip.item.charmed_pearcel.line1.type.repair"));
                    list.add(TextFormatting.AQUA + Translate.toLocal("tooltip.item.charmed_pearcel.line1.type.repair.desc"));
                    list.add(TextFormatting.GREEN + "Uses " + ConfigurationHandler.rfPerTick_charmedPearcel_repair + " RF/T");
                }else if (stack.getTagCompound().getString("type").equalsIgnoreCase("physco")){
                    list.add(TextFormatting.YELLOW + Translate.toLocal("tooltip.item.charmed_pearcel.line1.type.physco"));
                    list.add(TextFormatting.AQUA + Translate.toLocal("tooltip.item.charmed_pearcel.line1.type.physco.desc"));
                    list.add(TextFormatting.GREEN + "Uses " + ConfigurationHandler.rfPerTick_charmedPearcel_physco + " RF/T");
                }else if (stack.getTagCompound().getString("type").equalsIgnoreCase("third_eye")){
                    list.add(TextFormatting.YELLOW + Translate.toLocal("tooltip.item.charmed_pearcel.line1.type.third_eye"));
                    list.add(TextFormatting.AQUA + Translate.toLocal("tooltip.item.charmed_pearcel.line1.type.third_eye.desc"));
                    list.add(TextFormatting.GREEN + "Uses " + ConfigurationHandler.rfPerTick_charmedPearcel_thirdEye + " RF/T");
                }else {
                    list.add(TextFormatting.RED + (Translate.toLocal("tooltip.item.charmed_pearcel.line1.no_charm")));
                }

                list.add(TextFormatting.RED + "RF: " + TextFormatting.GREEN + getEnergyStored(stack) + " / " + getMaxEnergyStored(stack));


            } else {
                list.add(TextFormatting.RED + (Translate.toLocal("tooltip.item.charmed_pearcel.line1.no_charm")));
            }

        //}else{
        //    list.add(Translate.toLocal("tooltip.item.hold") + " " + TextFormatting.AQUA + TextFormatting.ITALIC + Translate.toLocal("tooltip.item.shift"));
        //}
    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {

        if (stack.hasTagCompound()){
            if (entityIn instanceof EntityPlayer){
                EntityPlayer player = (EntityPlayer) entityIn;
                player.stepHeight = 0.6F;
                if (stack.getTagCompound().getBoolean("active")) {
                    doEffects(player, stack);
                }
            }
        }
    }

    public static void doEffects(EntityPlayer player, ItemStack stack){
        if (stack.getTagCompound().getString("type").equalsIgnoreCase("fire") && (hasEnoughEnergy(stack, ConfigurationHandler.rfPerTick_charmedPearcel_fire, player) || player.isCreative())){
            player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 25, 0, true, false));
            player.extinguish();
            useEnergy(stack, ConfigurationHandler.rfPerTick_charmedPearcel_fire, false, player);
        }
        if (stack.getTagCompound().getString("type").equalsIgnoreCase("water") && (hasEnoughEnergy(stack, ConfigurationHandler.rfPerTick_charmedPearcel_water, player) || player.isCreative())){
            player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 25, 5, true, false));
            useEnergy(stack, ConfigurationHandler.rfPerTick_charmedPearcel_water, false, player);
        }
        if (stack.getTagCompound().getString("type").equalsIgnoreCase("saturation") && (hasEnoughEnergy(stack, ConfigurationHandler.rfPerTick_charmedPearcel_saturation, player) || player.isCreative())){
            player.addPotionEffect(new PotionEffect(MobEffects.SATURATION, 25, 5, true, false));
            useEnergy(stack, ConfigurationHandler.rfPerTick_charmedPearcel_saturation, false, player);
        }
        if (stack.getTagCompound().getString("type").equalsIgnoreCase("step_assist") && (hasEnoughEnergy(stack, ConfigurationHandler.rfPerTick_charmedPearcel_stepAssist, player) || player.isCreative())){
            ItemStack s = new ItemStack(ModItems.charmed_pearcel);
            if (!s.hasTagCompound()){
                s.setTagCompound(new NBTTagCompound());
            }
            s.getTagCompound().setString("type", "step_assist");
            if (player.inventory.hasItemStack(s)){
                player.stepHeight = 1.25F;
            }
            useEnergy(stack, ConfigurationHandler.rfPerTick_charmedPearcel_stepAssist, false, player);
        }
        if (stack.getTagCompound().getString("type").equalsIgnoreCase("gravity")  && (hasEnoughEnergy(stack, ConfigurationHandler.rfPerTick_charmedPearcel_gravity, player) || player.isCreative())){
            if (player.isSneaking()) {
                player.addVelocity(0D, -0.125D, 0D);
            }
            useEnergy(stack, ConfigurationHandler.rfPerTick_charmedPearcel_gravity, false, player);
        }
        if (stack.getTagCompound().getString("type").equalsIgnoreCase("adrenaline") && (hasEnoughEnergy(stack, ConfigurationHandler.rfPerTick_charmedPearcel_adrenaline, player) || player.isCreative())){
            player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 25, 1, true, false));
            player.addPotionEffect(new PotionEffect(MobEffects.HASTE, 25, 0, true, false));
            player.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 25, 1, true, false));
            useEnergy(stack, ConfigurationHandler.rfPerTick_charmedPearcel_adrenaline, false, player);
        }
        if (stack.getTagCompound().getString("type").equalsIgnoreCase("cloaking") && (hasEnoughEnergy(stack, ConfigurationHandler.rfPerTick_charmedPearcel_cloaking, player) || player.isCreative())){
            player.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 25, 0, true, false));
            useEnergy(stack, ConfigurationHandler.rfPerTick_charmedPearcel_cloaking, false, player);
        }
        if (stack.getTagCompound().getString("type").equalsIgnoreCase("hearty") && (hasEnoughEnergy(stack, ConfigurationHandler.rfPerTick_charmedPearcel_hearty, player) || player.isCreative())){
            player.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 25, 0, true, false));
            player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 25, 0, true, false));
            useEnergy(stack, ConfigurationHandler.rfPerTick_charmedPearcel_hearty, false, player);
        }
        if (stack.getTagCompound().getString("type").equalsIgnoreCase("repair") && (hasEnoughEnergy(stack, ConfigurationHandler.rfPerTick_charmedPearcel_repair, player) || player.isCreative())){
            if (player.getHeldItemMainhand() != null){
                if (player.getHeldItemMainhand().getItem().isDamageable() && player.getHeldItemMainhand().getItem().isDamaged(player.getHeldItemMainhand())) {
                    Random rand = new Random();
                    int num = rand.nextInt(100);
                    if (num == 0) {
                        player.getHeldItemMainhand().getItem().setDamage(player.getHeldItemMainhand(), player.getHeldItemMainhand().getItemDamage() - 1);
                    }
                }
            }
            useEnergy(stack, ConfigurationHandler.rfPerTick_charmedPearcel_repair, false, player);
        }
        if (stack.getTagCompound().getString("type").equalsIgnoreCase("physco") && (hasEnoughEnergy(stack, ConfigurationHandler.rfPerTick_charmedPearcel_physco, player) || player.isCreative())){
            int x = (int) player.posX;
            int y = (int) player.posY;
            int z = (int) player.posZ;
            int range = 15;
            List<EntityCreature> creatureList = player.world.getEntitiesWithinAABB(EntityCreature.class, new AxisAlignedBB(x - range, y - range, z - range, x + range, y + range, z + range));
            for (EntityCreature creature : creatureList){
                if (creature.isCreatureType(EnumCreatureType.MONSTER, false)) {
                    List<EntityCreature> creatureList2 = creature.world.getEntitiesWithinAABB(EntityCreature.class, new AxisAlignedBB(x - range, y - range, z - range, x + range, y + range, z + range));
                    for (EntityCreature creature2 : creatureList2) {
                        creature.setAttackTarget(creature2);
                    }
                }
            }
            useEnergy(stack, ConfigurationHandler.rfPerTick_charmedPearcel_physco, false, player);
        }
        if (stack.getTagCompound().getString("type").equalsIgnoreCase("third_eye") && (hasEnoughEnergy(stack, ConfigurationHandler.rfPerTick_charmedPearcel_thirdEye, player) || player.isCreative())){
            int x = (int) player.posX;
            int y = (int) player.posY;
            int z = (int) player.posZ;
            int range = 15;
            List<EntityLiving> entities = player.world.getEntitiesWithinAABB(EntityLiving.class, new AxisAlignedBB(x - range, y - range, z - range, x + range, y + range, z + range));
            for (EntityLiving e : entities){
                e.addPotionEffect(new PotionEffect(MobEffects.GLOWING, 25, 0, true, false));
            }
            player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 25, 0, true, false));
            useEnergy(stack, ConfigurationHandler.rfPerTick_charmedPearcel_thirdEye, false, player);
        }
        if (stack.getTagCompound().getString("type").equalsIgnoreCase("fall") && (hasEnoughEnergy(stack, ConfigurationHandler.rfPerTick_charmedPearcel_fall, player) || player.isCreative())){
            useEnergy(stack, ConfigurationHandler.rfPerTick_charmedPearcel_fall, false, player);
        }
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand) {

        if (!stack.hasTagCompound()){
            stack.setTagCompound(new NBTTagCompound());
        }

        if (player.isSneaking() && !world.isRemote) {
            if (!stack.getTagCompound().getBoolean("active")) {
                stack.getTagCompound().setBoolean("active", true);
                player.sendMessage(new TextComponentString(ChatFormatting.GREEN + Translate.toLocal("chat.item.charmed_pearcel.activated")));
            } else {
                stack.getTagCompound().setBoolean("active", false);
                player.sendMessage(new TextComponentString(ChatFormatting.RED + Translate.toLocal("chat.item.charmed_pearcel.deactivated")));
            }
        }

        return new ActionResult(EnumActionResult.SUCCESS, stack);
    }

    @Override
    public int receiveEnergy(ItemStack container, int maxReceive, boolean simulate) {
        return super.receiveEnergy(container, maxReceive, simulate);
    }

    private static boolean hasEnoughEnergy(ItemStack stack, int energyPerUse, EntityPlayer player){
        if (!player.isCreative()) {
            ItemCharmedPearcel stack1 = new ItemCharmedPearcel();
            if (energyPerUse <= stack1.getEnergyStored(stack)) {
                return true;
            }
        }

        return false;

    }

    public static void useEnergy(ItemStack stack, int useAmount, boolean simulate, EntityPlayer player){
        if (!player.isCreative()) {
            ItemCharmedPearcel stack1 = new ItemCharmedPearcel();
            stack1.extractEnergy(stack, useAmount, simulate);
        }
    }

}
