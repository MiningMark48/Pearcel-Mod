package com.miningmark48.pearcelmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

public class BlockPStairs extends BlockStairs{

    public BlockPStairs(Block block, int par2) {
        super(block, par2);
        this.useNeighborBrightness = true;
        this.setHardness(2.0F);
        this.setResistance(1.0F);
    }

}
