package com.miningmark48.pearcelmod.init;

import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import com.miningmark48.pearcelmod.utility.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class WorldGen implements IWorldGenerator{

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch(world.provider.getDimension()){
            case -1: //Nether
                generateNether(world, random, chunkX, chunkZ);
                break;
            case 0: //Overworld
                generateSurface(world, random, chunkX, chunkZ);
                break;
            case 1: //End
                generateEnd(world, random, chunkX, chunkZ);
                break;
        }

    }

    private void generateNether(World world, Random rand, int x, int z)
    {
        if (ConfigurationHandler.doWorldGen) {
            generateOre(ModBlocks.nether_pearcel_ore, world, rand, x, z, 3, 6, 15, 10, 60, Blocks.NETHERRACK);
        }
    }

    private void generateSurface(World world, Random rand, int x, int z)
    {
        if (ConfigurationHandler.doWorldGen) {
            generateOre(ModBlocks.pearcel_ore, world, rand, x, z, 3, 12, 15, 10, 70, Blocks.STONE);
            generateOre(ModBlocks.fools_pearcel_ore, world, rand, x, z, 3, 5, 10, 10, 50, ModBlocks.pearcel_ore);
            generateOre(ModBlocks.pearcel_matter_ore, world, rand, x, z, 1, 2, 10, 10, 40, Blocks.STONE);
            generateOre(ModBlocks.dense_pearcel_ore, world, rand, x, z, 5, 20, 5, 5, 70, Blocks.STONE);
            generateOre(ModBlocks.dense_pearcel_matter_ore, world, rand, x, z, 5, 20, 5, 5, 70, Blocks.STONE);
            generateOre(ModBlocks.pearcel_stone, world, rand, x, z, 1, 50, 30, 10, 64, Blocks.STONE);
            generateOre(ModBlocks.pearcel_sand, world, rand, x, z, 1, 50, 30, 10, 64, Blocks.SAND);
        }

    }


    private void generateEnd(World world, Random rand, int x, int z)
    {
        if (ConfigurationHandler.doWorldGen) {
            //generateOre(ModBlocks.pearcelEndStone, world, rand, x, z, 2, 10, 15, 0, 60, Blocks.end_stone);
            generateOre(ModBlocks.ender_pearcel_ore, world, rand, x, z, 3, 12, 10, 10, 60, Blocks.END_STONE);
        }
    }

    /*
     * Adds an Ore Spawn to Minecraft. Simply register all Ores to spawn with this method in your Generation method in your IWorldGeneration extending Class
     *
     * @param The Block to spawn
     * @param The World to spawn in
     * @param A Random object for retrieving random positions within the world to spawn the Block
     * @param An int for passing the X-Coordinate for the Generation method
     * @param An int for passing the Z-Coordinate for the Generation method
     * @param An int for setting the maximum X-Coordinate values for spawning on the X-Axis on a Per-Chunk basis
     * @param An int for setting the maximum Z-Coordinate values for spawning on the Z-Axis on a Per-Chunk basis
     * @param An int for setting the maximum size of a vein
     * @param An int for the Number of chances available for the Block to spawn per-chunk
     * @param An int for the minimum Y-Coordinate height at which this block may spawn
     * @param An int for the maximum Y-Coordinate height at which this block may spawn
     **/
    public void generateOre(Block block, World world, Random random, int chunkX, int chunkZ, int minVeinSize, int maxVeinSize, int chance, int minY, int maxY, Block generateIn)
    {
        int veinSize = minVeinSize + random.nextInt(maxVeinSize - minVeinSize);
        int heightRange = maxY - minY;
        WorldGenMinable gen = new WorldGenMinable(block.getDefaultState(), veinSize, BlockMatcher.forBlock(generateIn));
        for (int i = 0; i < chance; i++){
            int xRand = chunkX * 16 + random.nextInt(16);
            int yRand = random.nextInt(heightRange) + minY;
            int zRand = chunkZ * 16 + random.nextInt(16);
            gen.generate(world, random, new BlockPos(xRand, yRand, zRand));
            LogHelper.info("Ore at " + xRand + " " + yRand + " " + zRand);
        }
    }
}
