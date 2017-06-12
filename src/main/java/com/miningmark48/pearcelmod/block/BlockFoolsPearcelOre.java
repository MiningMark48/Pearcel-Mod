package com.miningmark48.pearcelmod.block;

import com.miningmark48.pearcelmod.init.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class BlockFoolsPearcelOre extends BlockPearcelMod {

    private float explosionStrength;
    private int explosionChance;
    private ItemStack itemDrop;

    public BlockFoolsPearcelOre(float explosionStrength, int explosionChance, ItemStack itemDrop){
        super();
        this.explosionStrength = explosionStrength;
        this.explosionChance = explosionChance;
        this.itemDrop = itemDrop;
    }

    @Override
    public void onBlockDestroyedByPlayer(World world, BlockPos pos, IBlockState state){
        Random rand = new Random();
        int randNum = rand.nextInt(explosionChance) + 1;
        if (!world.isRemote){
            if (randNum == 1) {
                if (world.getBlockState(pos).getBlock() == Blocks.AIR) {
                    world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), explosionStrength, true);
                }
            }
        }
    }

    @Override
    public void onBlockDestroyedByExplosion(World world, BlockPos pos, Explosion explosionIn){
        Random rand = new Random();
        int randNum = rand.nextInt(explosionChance) + 1;
        if (!world.isRemote){
            if (randNum == 1) {
                if (world.getBlockState(pos).getBlock() == Blocks.AIR) {
                    world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), explosionStrength, true);
                }
            }
        }
    }

    @Nullable
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return itemDrop.getItem();
    }
}
