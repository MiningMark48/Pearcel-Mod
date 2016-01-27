package com.miningmark48.pearcelmod.block;

public class BlockPearcelGlass extends BlockPearcelMod {
	
	public BlockPearcelGlass(){
		super();
        this.setStepSound(soundTypeGlass);
	}
	
	@Override
	public boolean isOpaqueCube(){
		return false;
	}
	
}
