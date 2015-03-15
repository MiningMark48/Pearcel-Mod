package com.miningmark48.pearcelmod.init;

import cpw.mods.fml.common.Mod;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes {
	
	public static void init(){
		
		//Items
	    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel, 9), new ItemStack(ModBlocks.pearcelBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.compressedSugarCanePlant), new ItemStack(ModItems.compressedSugarCaneItem), new ItemStack(Items.wheat_seeds)); //temporary
		GameRegistry.addRecipe(new ItemStack(ModItems.pearcel), "xxx", "x x", "xxx", 'x', new ItemStack(ModItems.pearcelNugget));
		GameRegistry.addSmelting(new ItemStack(ModBlocks.pearcelOre), new ItemStack(ModItems.pearcelNugget),  10f);
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcelSeeds), new ItemStack(ModItems.pearcel));
        GameRegistry.addSmelting(new ItemStack(ModBlocks.netherPearcelOre), new ItemStack(ModItems.pearcelNugget, 2),  10f);
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcelStick, 4), "x", "x", 'x', new ItemStack(ModItems.pearcel));
        GameRegistry.addSmelting(new ItemStack(ModItems.pearcel, 4), new ItemStack(ModItems.pearcelFlour), 10f);
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcelBread, 3), "xxx", 'x', new ItemStack(ModItems.pearcelFlour));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcelPie), new ItemStack(ModItems.pearcelFlour), new ItemStack(ModItems.pearcel), new ItemStack(Items.egg));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcelJuice), new ItemStack(ModItems.pearcel), new ItemStack(Items.bucket), new ItemStack(Items.sugar));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.sugar, 9), new ItemStack(ModItems.compressedSugarCaneItem));
        GameRegistry.addRecipe(new ItemStack(ModItems.sugarCookie, 4), "xyx", 'x', new ItemStack(Items.sugar), 'y', new ItemStack(Items.wheat));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.angelDust), new ItemStack(Items.feather), new ItemStack(Items.sugar), new ItemStack(Items.rotten_flesh), new ItemStack(Items.spider_eye));
        //Tools and Weapons
		GameRegistry.addRecipe(new ItemStack(ModItems.pearcelSword), "x", "x", "y", 'x', new ItemStack(ModItems.pearcel), 'y', new ItemStack(ModItems.pearcelStick));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcelPickaxe), "xxx", " y ", " y ", 'x', new ItemStack(ModItems.pearcel), 'y', new ItemStack(ModItems.pearcelStick));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcelAxe), "xx", "xy", " y", 'x', new ItemStack(ModItems.pearcel), 'y', new ItemStack(ModItems.pearcelStick));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcelShovel), "x", "y", "y", 'x', new ItemStack(ModItems.pearcel), 'y', new ItemStack(ModItems.pearcelStick));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcelHoe), "xx", " y", " y", 'x', new ItemStack(ModItems.pearcel), 'y', new ItemStack(ModItems.pearcelStick));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcelShears), " x", "x ", 'x', new ItemStack(ModItems.pearcel));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcelBow), " xy", "x y", " xy", 'x', new ItemStack(ModItems.pearcelStick), 'y', new ItemStack(Items.string));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcelArrow, 4), "x", "y", "z", 'x', new ItemStack(ModItems.pearcel), 'y', new ItemStack(ModItems.pearcelStick), 'z', new ItemStack(Items.feather));
        GameRegistry.addRecipe(new ItemStack(ModItems.pcp), " x ", "xyx", " x ", 'x', new ItemStack(ModItems.pearcel), 'y', new ItemStack(ModBlocks.meWorkbench));
        GameRegistry.addRecipe(new ItemStack(ModItems.pcp), "xxx", "xyx", "xxx", 'x', new ItemStack(ModItems.pearcel), 'y', new ItemStack(Blocks.crafting_table));
		//Compressed Sugar Cane (Items)
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.compressedSugarCaneItem), new ItemStack(ModBlocks.compressedSugarCaneBlock), new ItemStack(Items.wheat_seeds));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.compressedSugarCaneItem2), new ItemStack(ModBlocks.compressedSugarCaneBlock2), new ItemStack(Items.wheat_seeds));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.compressedSugarCaneItem3), new ItemStack(ModBlocks.compressedSugarCaneBlock3), new ItemStack(Items.wheat_seeds));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.compressedSugarCaneItem4), new ItemStack(ModBlocks.compressedSugarCaneBlock4), new ItemStack(Items.wheat_seeds));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.compressedSugarCaneItem5), new ItemStack(ModBlocks.compressedSugarCaneBlock5), new ItemStack(Items.wheat_seeds));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.compressedSugarCaneItem6), new ItemStack(ModBlocks.compressedSugarCaneBlock6), new ItemStack(Items.wheat_seeds));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.compressedSugarCaneItem7), new ItemStack(ModBlocks.compressedSugarCaneBlock7), new ItemStack(Items.wheat_seeds));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.compressedSugarCaneItem8), new ItemStack(ModBlocks.compressedSugarCaneBlock8), new ItemStack(Items.wheat_seeds));
		//Blocks
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcelTorch, 4), "x", "y", 'x', new ItemStack(ModItems.pearcel), 'y', new ItemStack(ModItems.pearcelStick));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.meBlock), "xxx", "xyx", "xxx", 'x', new ItemStack(ModItems.pearcel), 'y', new ItemStack(Items.iron_ingot));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcelBlock), "xxx", "xxx", "xxx", 'x', new ItemStack(ModItems.pearcel));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.meGlass, 8), "zxz", "xyx", "zxz", 'x', new ItemStack(Blocks.glass), 'y', new ItemStack(ModItems.pearcel), 'z', new ItemStack(Blocks.obsidian));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.meLamp, 8), "zxz", "xyx", "zxz", 'x', new ItemStack(Blocks.glowstone), 'y', new ItemStack(ModItems.pearcel), 'z', new ItemStack(Items.glowstone_dust));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.compressedSugarCaneBlock), "xxx", "xxx", "xxx", 'x', new ItemStack(Items.reeds));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.meWorkbench), "xy", "yx", 'x', new ItemStack(ModItems.pearcel), 'y', new ItemStack(Blocks.planks));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.ivet), "cyc", "axa", "bzb", 'a', new ItemStack(Blocks.obsidian), 'b', new ItemStack(ModItems.pearcel), 'c', new ItemStack(Items.iron_ingot), 'x', new ItemStack(ModBlocks.meWorkbench), 'y', new ItemStack(Items.book), 'z', new ItemStack(Items.diamond));
        //Compressed Blocks/Items
        GameRegistry.addRecipe(new ItemStack(ModBlocks.compressedSugarCaneBlock2), "xxx", "xxx", "xxx", 'x', new ItemStack(ModBlocks.compressedSugarCaneBlock));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.compressedSugarCaneBlock3), "xxx", "xxx", "xxx", 'x', new ItemStack(ModBlocks.compressedSugarCaneBlock2));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.compressedSugarCaneBlock4), "xxx", "xxx", "xxx", 'x', new ItemStack(ModBlocks.compressedSugarCaneBlock3));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.compressedSugarCaneBlock5), "xxx", "xxx", "xxx", 'x', new ItemStack(ModBlocks.compressedSugarCaneBlock4));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.compressedSugarCaneBlock6), "xxx", "xxx", "xxx", 'x', new ItemStack(ModBlocks.compressedSugarCaneBlock5));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.compressedSugarCaneBlock7), "xxx", "xxx", "xxx", 'x', new ItemStack(ModBlocks.compressedSugarCaneBlock6));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.compressedSugarCaneBlock8), "xxx", "xxx", "xxx", 'x', new ItemStack(ModBlocks.compressedSugarCaneBlock7));
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.compressedSugarCaneBlock8), new ItemStack(ModItems.compressedSugarCaneItem8));
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.compressedSugarCaneBlock7), new ItemStack(ModItems.compressedSugarCaneItem7));
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.compressedSugarCaneBlock6), new ItemStack(ModItems.compressedSugarCaneItem6));
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.compressedSugarCaneBlock5), new ItemStack(ModItems.compressedSugarCaneItem5));
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.compressedSugarCaneBlock4), new ItemStack(ModItems.compressedSugarCaneItem4));
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.compressedSugarCaneBlock3), new ItemStack(ModItems.compressedSugarCaneItem3));
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.compressedSugarCaneBlock2), new ItemStack(ModItems.compressedSugarCaneItem2));
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.compressedSugarCaneBlock), new ItemStack(ModItems.compressedSugarCaneItem));
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.compressedSugarCaneBlock7, 9), new ItemStack(ModBlocks.compressedSugarCaneBlock8));
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.compressedSugarCaneBlock6, 9), new ItemStack(ModBlocks.compressedSugarCaneBlock7));
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.compressedSugarCaneBlock5, 9), new ItemStack(ModBlocks.compressedSugarCaneBlock6));
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.compressedSugarCaneBlock4, 9), new ItemStack(ModBlocks.compressedSugarCaneBlock5));
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.compressedSugarCaneBlock3, 9), new ItemStack(ModBlocks.compressedSugarCaneBlock4));
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.compressedSugarCaneBlock2, 9), new ItemStack(ModBlocks.compressedSugarCaneBlock3));
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.compressedSugarCaneBlock, 9), new ItemStack(ModBlocks.compressedSugarCaneBlock2));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.reeds, 9), new ItemStack(ModBlocks.compressedSugarCaneBlock));

        //ME^Matter Recipes
        GameRegistry.addRecipe(new ItemStack(ModBlocks.meMatterBlock), "xxx", "xxx", "xxx", 'x', new ItemStack(ModItems.meMatter));
        GameRegistry.addRecipe(new ItemStack(ModItems.meMatterNeutral, 8), "xyx", "yzy", "xyx", 'x', new ItemStack(Items.emerald), 'y', new ItemStack(Items.diamond), 'z', new ItemStack(Items.nether_star));
        GameRegistry.addRecipe(new ItemStack(Items.diamond), " x ", "xxx", " x ", 'x', new ItemStack(ModItems.meMatter));
        GameRegistry.addRecipe(new ItemStack(Items.blaze_rod, 2), "x  ", " x ", "  x", 'x', new ItemStack((ModItems.meMatter)));
        GameRegistry.addRecipe(new ItemStack(Items.nether_star), "xyx", "y y", "xyx", 'x', new ItemStack(ModItems.meMatter), 'y', new ItemStack(ModBlocks.meMatterBlock));
        GameRegistry.addRecipe(new ItemStack(Items.clay_ball, 4), "x ", " x", 'x', new ItemStack(ModItems.meMatter));
        GameRegistry.addRecipe(new ItemStack(Items.ender_pearl, 4), "xxx", 'x', new ItemStack(ModItems.meMatter));
        GameRegistry.addRecipe(new ItemStack(Items.iron_ingot, 8), "xx", 'x', new ItemStack(ModItems.meMatter));
        GameRegistry.addRecipe(new ItemStack(Items.bucket), " x ", "x x", 'x', new ItemStack(ModItems.meMatter));
        GameRegistry.addRecipe(new ItemStack(Items.flint, 4), "x x", "x x", new ItemStack(ModItems.meMatter));

	}

}
