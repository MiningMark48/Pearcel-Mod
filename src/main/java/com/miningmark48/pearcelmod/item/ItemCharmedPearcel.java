package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.utility.KeyCheck;
import com.miningmark48.pearcelmod.utility.Translate;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class ItemCharmedPearcel extends ItemPearcelMod{

    public ItemCharmedPearcel(){
        setMaxStackSize(1);

        this.addPropertyOverride(new ResourceLocation("type"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                if (!stack.hasTagCompound()){
                    stack.setTagCompound(new NBTTagCompound());
                    stack.getTagCompound().setString("type", "none");
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
                }else{
                    return 0;
                }

            }
        });

    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {

        if (KeyCheck.isHoldingShift()) {
            if (stack.hasTagCompound()) {

                if (stack.getTagCompound().getString("type").equalsIgnoreCase("fire")){
                    list.add(TextFormatting.YELLOW + Translate.toLocal("tooltip.item.charmed_pearcel.line1.type.fire"));
                    list.add(TextFormatting.AQUA + Translate.toLocal("tooltip.item.charmed_pearcel.line1.type.fire.desc"));
                }else if (stack.getTagCompound().getString("type").equalsIgnoreCase("water")){
                    list.add(TextFormatting.YELLOW + Translate.toLocal("tooltip.item.charmed_pearcel.line1.type.water"));
                    list.add(TextFormatting.AQUA + Translate.toLocal("tooltip.item.charmed_pearcel.line1.type.water.desc"));
                }else if (stack.getTagCompound().getString("type").equalsIgnoreCase("saturation")){
                    list.add(TextFormatting.YELLOW + Translate.toLocal("tooltip.item.charmed_pearcel.line1.type.saturation"));
                    list.add(TextFormatting.AQUA + Translate.toLocal("tooltip.item.charmed_pearcel.line1.type.saturation.desc"));
                }else if (stack.getTagCompound().getString("type").equalsIgnoreCase("step_assist")){
                    list.add(TextFormatting.YELLOW + Translate.toLocal("tooltip.item.charmed_pearcel.line1.type.step_assist"));
                    list.add(TextFormatting.AQUA + Translate.toLocal("tooltip.item.charmed_pearcel.line1.type.step_assist.desc"));
                }else if (stack.getTagCompound().getString("type").equalsIgnoreCase("fall")){
                    list.add(TextFormatting.YELLOW + Translate.toLocal("tooltip.item.charmed_pearcel.line1.type.fall"));
                    list.add(TextFormatting.AQUA + Translate.toLocal("tooltip.item.charmed_pearcel.line1.type.fall.desc"));
                }else if (stack.getTagCompound().getString("type").equalsIgnoreCase("gravity")){
                    list.add(TextFormatting.YELLOW + Translate.toLocal("tooltip.item.charmed_pearcel.line1.type.gravity"));
                    list.add(TextFormatting.AQUA + Translate.toLocal("tooltip.item.charmed_pearcel.line1.type.gravity.desc"));
                }else if (stack.getTagCompound().getString("type").equalsIgnoreCase("adrenaline")){
                    list.add(TextFormatting.YELLOW + Translate.toLocal("tooltip.item.charmed_pearcel.line1.type.adrenaline"));
                    list.add(TextFormatting.AQUA + Translate.toLocal("tooltip.item.charmed_pearcel.line1.type.adrenaline.desc"));
                }else if (stack.getTagCompound().getString("type").equalsIgnoreCase("cloaking")){
                    list.add(TextFormatting.YELLOW + Translate.toLocal("tooltip.item.charmed_pearcel.line1.type.cloaking"));
                    list.add(TextFormatting.AQUA + Translate.toLocal("tooltip.item.charmed_pearcel.line1.type.cloaking.desc"));
                }else if (stack.getTagCompound().getString("type").equalsIgnoreCase("hearty")){
                    list.add(TextFormatting.YELLOW + Translate.toLocal("tooltip.item.charmed_pearcel.line1.type.hearty"));
                    list.add(TextFormatting.AQUA + Translate.toLocal("tooltip.item.charmed_pearcel.line1.type.hearty.desc"));
                }else if (stack.getTagCompound().getString("type").equalsIgnoreCase("repair")){
                    list.add(TextFormatting.YELLOW + Translate.toLocal("tooltip.item.charmed_pearcel.line1.type.repair"));
                    list.add(TextFormatting.AQUA + Translate.toLocal("tooltip.item.charmed_pearcel.line1.type.repair.desc"));
                }else {
                    list.add(TextFormatting.RED + (Translate.toLocal("tooltip.item.charmed_pearcel.line1.no_charm")));
                }


            } else {
                list.add(TextFormatting.RED + (Translate.toLocal("tooltip.item.charmed_pearcel.line1.no_charm")));
            }

        }else{
            list.add(Translate.toLocal("tooltip.item.hold") + " " + TextFormatting.AQUA + TextFormatting.ITALIC + Translate.toLocal("tooltip.item.shift"));
        }
    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {

        if (stack.hasTagCompound()){
            if (entityIn instanceof EntityPlayer){
                EntityPlayer player = (EntityPlayer) entityIn;
                player.stepHeight = 0.6F;
                doEffects(player, stack);
            }
        }
    }

    public static void doEffects(EntityPlayer player, ItemStack stack){
        if (stack.getTagCompound().getString("type").equalsIgnoreCase("fire")){
            player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 25, 0, true, false));
            player.extinguish();
        }
        if (stack.getTagCompound().getString("type").equalsIgnoreCase("water")){
            player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 25, 5, true, false));
        }
        if (stack.getTagCompound().getString("type").equalsIgnoreCase("saturation")){
            player.addPotionEffect(new PotionEffect(MobEffects.SATURATION, 25, 5, true, false));
        }
        if (stack.getTagCompound().getString("type").equalsIgnoreCase("step_assist")){
            ItemStack s = new ItemStack(ModItems.charmed_pearcel);
            if (!s.hasTagCompound()){
                s.setTagCompound(new NBTTagCompound());
            }
            s.getTagCompound().setString("type", "step_assist");
            if (player.inventory.hasItemStack(s)){
                player.stepHeight = 1.25F;
            }
        }
        if (stack.getTagCompound().getString("type").equalsIgnoreCase("gravity")){
            if (player.isSneaking()) {
                player.addVelocity(0D, -0.125D, 0D);
            }
        }
        if (stack.getTagCompound().getString("type").equalsIgnoreCase("adrenaline")){
            player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 25, 1, true, false));
            player.addPotionEffect(new PotionEffect(MobEffects.HASTE, 25, 0, true, false));
            player.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 25, 1, true, false));
        }
        if (stack.getTagCompound().getString("type").equalsIgnoreCase("cloaking")){
            player.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 25, 0, true, false));
        }
        if (stack.getTagCompound().getString("type").equalsIgnoreCase("hearty")){
            player.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 25, 0, true, false));
            player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 25, 0, true, false));
        }
        if (stack.getTagCompound().getString("type").equalsIgnoreCase("repair")){
            if (player.getHeldItemMainhand() != null){
                if (player.getHeldItemMainhand().getItem().isDamageable() && player.getHeldItemMainhand().getItem().isDamaged(player.getHeldItemMainhand())) {
                    Random rand = new Random();
                    int num = rand.nextInt(100);
                    if (num == 0) {
                        player.getHeldItemMainhand().getItem().setDamage(player.getHeldItemMainhand(), player.getHeldItemMainhand().getItemDamage() - 1);
                    }
                }
            }
        }
    }

}
