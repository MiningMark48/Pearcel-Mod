package com.miningmark48.pearcelmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBedrockGlass extends BlockPearcelMod {
    public BlockBedrockGlass(){
        super();
    }

    @Override
    public boolean isOpaqueCube(){
        return false;
    }
}
