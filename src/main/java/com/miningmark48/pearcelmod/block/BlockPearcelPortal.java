package com.miningmark48.pearcelmod.block;

import com.miningmark48.pearcelmod.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.Random;

public class BlockPearcelPortal extends BlockPortal {

    public BlockPearcelPortal(){
        super();
    }

    /*public void updateTick(World world, int x, int y, int z, Random rand){

    }*/

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z){
        return null;
    }

    public boolean renderAsNormalBlock(){
        return false;
    }

    public void onNeighborBlockChange(World world, int x, int y, int z, Block block){
        byte b0 = 0;
        byte b1 = 1;

        //Might change Pearcel Block to a special portal block
        if (world.getBlock(x - 1, y, z) == ModBlocks.pearcelBlock || world.getBlock(x + 1, y, z) == ModBlocks.pearcelBlock){
            b0 = 1;
            b1 = 0;
        }

        int i1;

        for (i1 = y; world.getBlock(x, i1 - 1, z) == this; --i1){

        }
        if (world.getBlock(x, i1 - 1, z) != ModBlocks.pearcelBlock){
            world.setBlockToAir(x, y, z);
        }else{
            int j1;

            for (j1 = 1; j1 < 4 && world.getBlock(x, i1 + j1, z) == this; ++j1){

            }
            if (j1 == 3 && world.getBlock(x, i1 + j1, z) == ModBlocks.pearcelBlock){
                boolean flag = world.getBlock(x - 1, y, z) == this || world.getBlock(x + 1, y, z) == this;
                boolean flag1 = world.getBlock(x, y, z - 1) == this || world.getBlock(x, y, z + 1) == this;

                if (flag && flag1){
                    world.setBlockToAir(x, y, z);
                }else{
                    if ((world.getBlock(x + b0, y, z + b1) != ModBlocks.pearcelBlock || world.getBlock(x - b0, y, z - b1) != this) && (world.getBlock(x - b0, y, z - b1) != ModBlocks.pearcelBlock || world.getBlock(x + b0, y, z + b1) != this)){
                        world.setBlockToAir(x, y, z);
                    }
                }
            }else{
                world.setBlockToAir(x, y, z);
            }
        }
    }
}
