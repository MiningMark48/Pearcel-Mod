package com.miningmark48.pearcelmod.block;

import com.miningmark48.pearcelmod.init.ModItems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import java.util.Random;

public class BlockFoolsPearcelOre extends BlockPearcelMod{

    public BlockFoolsPearcelOre(){
        super();
    }

    public void onBlockDestroyedByPlayer(World world, BlockPos pos, IBlockState state){
        Random rand = new Random();
        int randNum = rand.nextInt(4) + 1;
        if (!world.isRemote){
            if (randNum == 1) {
                if (world.getBlockState(pos).getBlock() == Blocks.AIR) {
                    world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 3F, true);
                }
            }
        }
    }

    public void onBlockDestroyedByExplosion(World world, BlockPos pos, Explosion explosionIn){
        Random rand = new Random();
        int randNum = rand.nextInt(4) + 1;
        if (!world.isRemote){
            if (randNum == 1) {
                if (world.getBlockState(pos).getBlock() == Blocks.AIR) {
                    world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 3F, true);
                }
            }
        }
    }

    public Item getItemDropped(int meta, Random random, int fortune) {
        return ModItems.pearcel_ingot;
    }

}
