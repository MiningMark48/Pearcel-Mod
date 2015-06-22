package com.miningmark48.pearcelmod.block;

import net.minecraft.block.material.Material;

public class BlockPearcelEndStone extends BlockPearcelMod {

    public BlockPearcelEndStone(){
        super(Material.rock);
        setStepSound(soundTypeStone);
        setHardness(1.0f);
    }

}
