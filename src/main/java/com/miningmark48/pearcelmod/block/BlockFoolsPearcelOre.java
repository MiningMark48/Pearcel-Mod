package com.miningmark48.pearcelmod.block;

import com.miningmark48.pearcelmod.init.ModBlocks;
import com.miningmark48.pearcelmod.init.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import java.util.Random;

public class BlockFoolsPearcelOre extends BlockPearcelMod{

    public BlockFoolsPearcelOre(){
        super();
    }

    @Override
    public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int meta) {
        Random rand = new Random();
        int randNum = rand.nextInt(4) + 1;
        if (!world.isRemote){
            if (randNum == 1) {
                if (world.getBlock(x, y, z) == Blocks.air) {
                    world.createExplosion(null, ((double) x), ((double) y), ((double) z), 3F, true);
                }
            }
        }
    }

    @Override
    public void onBlockDestroyedByExplosion(World world, int x, int y, int z, Explosion explosion) {
        Random rand = new Random();
        int randNum = rand.nextInt(4) + 1;
        if (!world.isRemote){
            if (randNum == 1) {
                if (world.getBlock(x, y, z) == Blocks.air) {
                    world.createExplosion(null, ((double) x), ((double) y), ((double) z), 3F, true);
                }
            }
        }
    }

    @Override
    public Item getItemDropped(int meta, Random random, int fortune) {
        return ModItems.pearcelIngot;
    }



}
