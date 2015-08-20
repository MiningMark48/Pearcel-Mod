package com.miningmark48.pearcelmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;


public class BlockBarrier extends Block {


    public BlockBarrier(){
        super(Material.iron);
        setStepSound(soundTypeMetal);
    }

    public boolean canPlaceBlockAt(World world, int x, int y, int z){
        return false;
    }

}
