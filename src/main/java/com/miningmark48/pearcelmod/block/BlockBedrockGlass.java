package com.miningmark48.pearcelmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBedrockGlass extends Block {
    public BlockBedrockGlass(){
        super(Material.glass);
        setStepSound(soundTypeGlass);
    }
    @Override
    public boolean isOpaqueCube(){
        return false;
    }
}
