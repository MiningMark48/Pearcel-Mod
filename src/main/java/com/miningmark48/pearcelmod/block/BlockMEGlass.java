package com.miningmark48.pearcelmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockMEGlass extends Block {
	
	public BlockMEGlass(){
		super(Material.glass);
        setStepSound(soundTypeGlass);
	}
	
	@Override
	public boolean isOpaqueCube(){
		return false;
	}
	
}
