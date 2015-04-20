package com.miningmark48.pearcelmod.init;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraftforge.common.util.EnumHelper;

public class ModMaterials {

    public static Material materialFluidPearcel;

    public static void init(){

        materialFluidPearcel = new MaterialLiquid(MapColor.goldColor);

    }

}
