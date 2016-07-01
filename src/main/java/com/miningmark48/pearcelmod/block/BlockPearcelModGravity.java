package com.miningmark48.pearcelmod.block;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.SoundType;

public class BlockPearcelModGravity extends BlockFalling{

    public BlockPearcelModGravity(){
        setSoundType(SoundType.SAND);
        setHardness(0.5F);
        setResistance(0.1F);
    }

}
