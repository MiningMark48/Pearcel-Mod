package com.miningmark48.pearcelmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockPearcelModWood extends Block {

    public BlockPearcelModWood(){
        super(Material.wood);
        setStepSound(soundTypeWood);
        setHardness(1.0F);
        setResistance(1.0F);
    }

}
