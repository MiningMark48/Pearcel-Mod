package com.miningmark48.pearcelmod.utility;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

public class WorldTools {

    @SuppressWarnings("deprecation")
    public static int findEmptySpot(World world, int x, int z) {
        int y = world.getTopSolidOrLiquidBlock(new BlockPos(x, 0, z)).getY();
        if (y == -1) {
            return -1;
        }
        y--;
        if (y > world.getHeight() - 5) {
            y = world.getHeight() / 2;
        }


        Block block = world.getBlockState(new BlockPos(x, y + 1, z)).getBlock();
        while (block.getMaterial(block.getDefaultState()).isLiquid() || world.isAirBlock(new BlockPos(x, y - 1, z))) {
            y++;
            if (y > world.getHeight() - 10) {
                return -1;
            }
            block = world.getBlockState(new BlockPos(x, y + 1, z)).getBlock();
        }

        return y;
    }

    public static boolean isSlimeChunk(World world, int x, int z){
        Chunk chunk = world.getChunkFromBlockCoords(new BlockPos(x, 0, z));
        return chunk.getRandomWithSeed(987234911L).nextInt(10) == 0;
    }

}
