package com.miningmark48.pearcelmod.block;

import com.miningmark48.pearcelmod.init.ModBlocks;
import com.miningmark48.pearcelmod.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockPearcelOre extends Block {
	
	public BlockPearcelOre(){
        super(Material.rock);
        setStepSound(soundTypeStone);
	}


}
