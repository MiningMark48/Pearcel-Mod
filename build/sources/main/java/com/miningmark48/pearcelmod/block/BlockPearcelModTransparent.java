package com.miningmark48.pearcelmod.block;

import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockPearcelModTransparent extends BlockPearcelMod{

    public BlockPearcelModTransparent(){
        setStepSound(soundTypeGlass);
    }

    @Override
    public boolean isOpaqueCube(){
        return false;
    }

    @SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.CUTOUT;
    }

}
