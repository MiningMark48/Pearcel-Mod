package com.miningmark48.pearcelmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockPearcelModWood extends Block {

    public BlockPearcelModWood(){
        super(Material.WOOD);
        setSoundType(SoundType.WOOD);
        setHardness(1.0F);
        setResistance(1.0F);
    }

}
