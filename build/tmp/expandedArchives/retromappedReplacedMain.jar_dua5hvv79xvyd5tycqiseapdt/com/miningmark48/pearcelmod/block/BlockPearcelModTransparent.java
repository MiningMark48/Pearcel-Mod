package com.miningmark48.pearcelmod.block;

import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockPearcelModTransparent extends BlockPearcelMod{

    public BlockPearcelModTransparent(){
        func_149672_a(field_149778_k);
    }

    @Override
    public boolean func_149662_c(){
        return false;
    }

    @SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer func_180664_k()
    {
        return EnumWorldBlockLayer.CUTOUT;
    }

}
