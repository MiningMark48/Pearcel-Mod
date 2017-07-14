package com.miningmark48.pearcelmod.item;

import com.miningmark48.mininglib.utility.KeyChecker;
import com.miningmark48.mininglib.utility.ModTranslate;
import com.miningmark48.mininglib.utility.WorldUtil;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemSlimeyPearcel extends ItemPearcelMod{

    private static boolean playedSound = false;

    public ItemSlimeyPearcel(){
        setMaxStackSize(1);

        this.addPropertyOverride(new ResourceLocation("isChunk"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                if (!stack.hasTagCompound()){
                    stack.setTagCompound(new NBTTagCompound());
                }

                if (stack.getTagCompound().getBoolean("isChunk")){
                    return 1;
                }else{
                    return 0;
                }

            }
        });

    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World playerIn, List<String> tooltip, ITooltipFlag advanced) {
        if (KeyChecker.isHoldingShift()) {
            tooltip.add(ModTranslate.toLocal("tooltip.item.slimey_pearcel.line1"));
        }else{
            tooltip.add(ModTranslate.toLocal("tooltip.item.hold") + " " + TextFormatting.AQUA + TextFormatting.ITALIC + ModTranslate.toLocal("tooltip.item.shift"));
        }
    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {

        if (!stack.hasTagCompound()){
            stack.setTagCompound(new NBTTagCompound());
        }

        if (entityIn instanceof EntityPlayer){
            EntityPlayer player = (EntityPlayer) entityIn;
            playAlert(player, stack);
        }

        if (!worldIn.isRemote) {
            if (WorldUtil.isSlimeChunk(worldIn, MathHelper.floor(entityIn.posX), MathHelper.floor(entityIn.posZ))) {
                stack.getTagCompound().setBoolean("isChunk", true);
                stack.getTagCompound().setBoolean("playSound", false);
            } else {
                stack.getTagCompound().setBoolean("isChunk", false);

            }
        }

    }

    private static void playAlert(EntityPlayer player, ItemStack stack){
        if (!stack.getTagCompound().getBoolean("playSound")){
            player.playSound(SoundEvents.ENTITY_SLIME_JUMP, 5.0F, 1.0F);
            stack.getTagCompound().setBoolean("playSound", true);
        }
    }
}
