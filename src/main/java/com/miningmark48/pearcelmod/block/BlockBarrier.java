package com.miningmark48.pearcelmod.block;

import net.minecraft.world.World;

public class BlockBarrier extends BlockPearcelMod {

    public BlockBarrier(){
        super();
    }

    public boolean canPlaceBlockAt(World world, int x, int y, int z){
        return false;
    }

}
