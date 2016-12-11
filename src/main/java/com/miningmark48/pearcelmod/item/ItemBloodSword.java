package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.utility.Translate;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class ItemBloodSword extends ItemPearcelMod{

    public ItemBloodSword(){
        setMaxStackSize(1);

        this.addPropertyOverride(new ResourceLocation("level"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                if (!stack.hasTagCompound()){
                    stack.setTagCompound(new NBTTagCompound());
                    stack.getTagCompound().setInteger("level", 0);
                }
                return stack.getTagCompound().getInteger("level");
            }
        });

    }

    @Override
    public ActionResult onItemRightClick(ItemStack item, World world, EntityPlayer player, EnumHand hand)
    {
        if (player.isSneaking()){
            if (!item.hasTagCompound()){
                item.setTagCompound(new NBTTagCompound());
                item.getTagCompound().setInteger("level", 0);
            }else{
                if (item.getTagCompound().getInteger("level") <= 8){
                    item.getTagCompound().setInteger("level", item.getTagCompound().getInteger("level") + 1);
                }else{
                    item.getTagCompound().setInteger("level", 0);
                }

            }
            return new ActionResult(EnumActionResult.PASS, item);
        }else{
            return new ActionResult(EnumActionResult.PASS, item);
        }
    }

}
