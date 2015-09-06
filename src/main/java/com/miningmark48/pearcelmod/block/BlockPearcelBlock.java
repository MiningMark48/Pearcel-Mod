package com.miningmark48.pearcelmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class BlockPearcelBlock extends Block {

    public BlockPearcelBlock(){
        super(Material.rock);
        setStepSound(soundTypeStone);
    }

}
