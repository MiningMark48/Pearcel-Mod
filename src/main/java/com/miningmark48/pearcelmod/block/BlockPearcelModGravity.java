package com.miningmark48.pearcelmod.block;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockPearcelModGravity extends BlockFalling{

    public BlockPearcelModGravity(Type type){
        super(Material.SAND);

        switch (type){
            default:
                setSoundType(SoundType.STONE);
                setHardness(1.0F);
                setResistance(1.0F);
                break;
            case SAND:
                setSoundType(SoundType.SAND);
                setHardness(0.25F);
                setResistance(0.15F);
                break;
        }

    }

    public enum Type{
        SAND
    }

}
