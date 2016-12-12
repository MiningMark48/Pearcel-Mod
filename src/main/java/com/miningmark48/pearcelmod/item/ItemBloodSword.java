package com.miningmark48.pearcelmod.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class ItemBloodSword extends ItemPearcelSword{

    public ItemBloodSword(ToolMaterial material){
        super(material);
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

}
