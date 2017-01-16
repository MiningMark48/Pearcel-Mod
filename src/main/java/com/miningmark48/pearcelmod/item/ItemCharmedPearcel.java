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
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

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
                }else if (stack.getTagCompound().getString("type").equalsIgnoreCase("water")){
                    list.add(TextFormatting.YELLOW + Translate.toLocal("tooltip.item.charmed_pearcel.line1.type.water"));
                }else if (stack.getTagCompound().getString("type").equalsIgnoreCase("saturation")){
                    list.add(TextFormatting.YELLOW + Translate.toLocal("tooltip.item.charmed_pearcel.line1.type.saturation"));
                }else if (stack.getTagCompound().getString("type").equalsIgnoreCase("step_assist")){
                    list.add(TextFormatting.YELLOW + Translate.toLocal("tooltip.item.charmed_pearcel.line1.type.step_assist"));
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
            }
        }

    }
}
