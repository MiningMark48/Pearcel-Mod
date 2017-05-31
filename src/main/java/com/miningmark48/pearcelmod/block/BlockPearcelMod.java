package com.miningmark48.pearcelmod.block;

import com.miningmark48.pearcelmod.handler.IGeneratorFuelHandler;
import com.miningmark48.pearcelmod.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;

public class BlockPearcelMod extends Block implements IGeneratorFuelHandler {
    public BlockPearcelMod() {
        super(Material.ROCK);
        setHardness(2.0F);
        setResistance(0.5F);
    }

    @Override
    public int getCooldownTime(ItemStack fuel) {
        if (fuel.isItemEqual(new ItemStack(ModBlocks.pearcel_matter_block))){
            return 600;
        }else if (fuel.isItemEqual(new ItemStack(ModBlocks.pearcel_charcoal_block))){
            return 300;
        }
        return 0;
    }

    @Override
    public int getRFPerTick(ItemStack fuel) {
        if (fuel.isItemEqual(new ItemStack(ModBlocks.pearcel_matter_block))){
            return 60;
        }else if (fuel.isItemEqual(new ItemStack(ModBlocks.pearcel_charcoal_block))){
            return 20;
        }
        return 0;
    }

}
