package com.miningmark48.pearcelmod.block;

import com.miningmark48.pearcelmod.init.ModFluids;
import com.miningmark48.pearcelmod.init.ModMaterials;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.BlockFluidClassic;

public class BlockPearcelFluid extends BlockFluidClassic{

    public BlockPearcelFluid(){
        super(ModFluids.fluidPearcel, ModMaterials.materialFluidPearcel);
    }

}
