package com.miningmark48.pearcelmod.block;

import com.miningmark48.pearcelmod.init.ModItems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import java.util.Random;

public class BlockFoolsPearcelOre extends BlockPearcelMod{

    public BlockFoolsPearcelOre(){
        super();
    }

    public void func_176206_d(World world, BlockPos pos, IBlockState state){
        Random rand = new Random();
        int randNum = rand.nextInt(4) + 1;
        if (!world.field_72995_K){
            if (randNum == 1) {
                if (world.func_180495_p(pos).func_177230_c() == Blocks.field_150350_a) {
                    world.func_72876_a(null, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p(), 3F, true);
                }
            }
        }
    }

    public void func_180652_a(World world, BlockPos pos, Explosion explosionIn){
        Random rand = new Random();
        int randNum = rand.nextInt(4) + 1;
        if (!world.field_72995_K){
            if (randNum == 1) {
                if (world.func_180495_p(pos).func_177230_c() == Blocks.field_150350_a) {
                    world.func_72876_a(null, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p(), 3F, true);
                }
            }
        }
    }

    public Item getItemDropped(int meta, Random random, int fortune) {
        return ModItems.pearcel_ingot;
    }

}
