package com.miningmark48.pearcelmod.block;

import net.minecraft.block.SoundType;
//import net.minecraft.util.EnumWordBlockLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockPearcelModTransparent extends BlockPearcelMod{

    public BlockPearcelModTransparent(){
        setSoundType(SoundType.GLASS);
    }

//    @Override
//    public boolean isOpaqueCube(){
//        return false;
//    }
//
//    @SideOnly(Side.CLIENT)
//    public EnumWorldBlockLayer getBlockLayer()
//    {
//        return EnumWorldBlockLayer.CUTOUT;
//    }

}
