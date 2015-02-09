package com.miningmark48.pearcelmod.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes {
	
	public static void init(){
		
		//Items
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel, 9), new ItemStack(ModBlocks.meBlock));
		//GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel), new ItemStack(Items.apple));
		GameRegistry.addRecipe(new ItemStack(ModItems.pearcel), "xxx", "x x", "xxx", 'x', new ItemStack(ModItems.pearcelNugget));
		GameRegistry.addSmelting(new ItemStack(ModBlocks.pearcelOre), new ItemStack(ModItems.pearcelNugget),  10f);
		GameRegistry.addRecipe(new ItemStack(ModItems.pearcelSword), "x", "x", "y", 'x', new ItemStack(ModItems.pearcel), 'y', new ItemStack(Items.stick));

		    //Compressed Sugar Cane (Items)
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.compressedSugarCaneItem), new ItemStack(ModBlocks.compressedSugarCaneBlock), new ItemStack(Items.wheat_seeds));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.compressedSugarCaneItem2), new ItemStack(ModBlocks.compressedSugarCaneBlock2), new ItemStack(Items.wheat_seeds));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.compressedSugarCaneItem3), new ItemStack(ModBlocks.compressedSugarCaneBlock3), new ItemStack(Items.wheat_seeds));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.compressedSugarCaneItem4), new ItemStack(ModBlocks.compressedSugarCaneBlock4), new ItemStack(Items.wheat_seeds));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.compressedSugarCaneItem5), new ItemStack(ModBlocks.compressedSugarCaneBlock5), new ItemStack(Items.wheat_seeds));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.compressedSugarCaneItem6), new ItemStack(ModBlocks.compressedSugarCaneBlock6), new ItemStack(Items.wheat_seeds));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.compressedSugarCaneItem7), new ItemStack(ModBlocks.compressedSugarCaneBlock7), new ItemStack(Items.wheat_seeds));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.compressedSugarCaneItem8), new ItemStack(ModBlocks.compressedSugarCaneBlock8), new ItemStack(Items.wheat_seeds));
        GameRegistry.addRecipe(new ItemStack(ModItems.sugarCookie, 4), "xyx", 'x', new ItemStack(Items.sugar), 'y', new ItemStack(Items.wheat));


		//Blocks
		GameRegistry.addRecipe(new ItemStack(ModBlocks.meBlock), "xxx", "xxx", "xxx", 'x', new ItemStack(ModItems.pearcel));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.meGlass, 8), "xxx", "xyx", "xxx", 'x', new ItemStack(Blocks.glass), 'y', new ItemStack(ModItems.pearcel));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.compressedSugarCaneBlock), "xxx", "xxx", "xxx", 'x', new ItemStack(Items.reeds));
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



	}

}
