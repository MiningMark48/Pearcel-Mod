package com.miningmark48.pearcelmod.init;

import com.miningmark48.pearcelmod.block.*;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks {

	public static final BlockPearcelMod meBlock = new BlockMEBlock();
	public static final BlockPearcelMod pearcelOre = new BlockPearcelOre();
	public static final BlockPearcelMod meGlass = new BlockMEGlass();
	
	public static void init(){
		
		GameRegistry.registerBlock(meBlock, "meBlock");
		GameRegistry.registerBlock(pearcelOre, "pearcelOre");
		GameRegistry.registerBlock(meGlass, "meGlass");
		
	}
	
}
