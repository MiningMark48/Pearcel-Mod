package com.miningmark48.pearcelmod.init;

import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes {
	
	public static void init(){
		
		//Items
        GameRegistry.addSmelting(new ItemStack(ModBlocks.enderPearcelOre), new ItemStack(ModItems.pearcelIngot, 4), 15f);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.netherPearcelOre), new ItemStack(ModItems.pearcelIngot, 2), 10f);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.pearcelOre), new ItemStack(ModItems.pearcelIngot, 1), 5f);
        GameRegistry.addSmelting(new ItemStack(ModItems.pearcelBeef), new ItemStack(ModItems.pearcelSteak), 10f);
        GameRegistry.addSmelting(new ItemStack(ModItems.pearcelFlour), new ItemStack(ModItems.pearcelBread), 10f);
        GameRegistry.addSmelting(new ItemStack(ModItems.pearcel), new ItemStack(ModItems.pearcelCharcoal), 10f);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.pearcelBlock), new ItemStack(ModBlocks.pearcelCharcoalBlock, 1), 5f);
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcelPie), new ItemStack(ModItems.pearcelFlour), new ItemStack(ModItems.pearcel), new ItemStack(Items.egg));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcelJuice), new ItemStack(ModItems.pearcel), new ItemStack(Items.bucket), new ItemStack(Items.sugar));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcelSandwich), new ItemStack(ModItems.pearcel), new ItemStack(ModItems.pearcelBread), new ItemStack(ModItems.pearcelJuice), new ItemStack(Items.sugar));
	    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel, 9), new ItemStack(ModBlocks.pearcelBlock));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcelSeeds, 1), new ItemStack(ModItems.pearcel));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcelJuiceBottle), new ItemStack(Items.glass_bottle), new ItemStack(ModItems.pearcelJuice));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcelSeeds, 4), new ItemStack(ModItems.pearcelIngot), new ItemStack(Items.wheat_seeds));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcelStick, 4), "x", "x", 'x', new ItemStack(ModItems.pearcel));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcelStick, 4), "x", "x", 'x', new ItemStack(ModBlocks.pearcelPlanks));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcelFlour, 6), "xyx", 'x', new ItemStack(ModItems.pearcel), 'y', new ItemStack(Items.bread));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcelBread, 3), "xxx", 'x', new ItemStack(ModItems.pearcelFlour));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcelCookie), " x ", "xyx", " x ", 'x', new ItemStack(ModItems.pearcel), 'y', new ItemStack(Items.cookie));
        GameRegistry.addRecipe(new ItemStack(ModItems.armorPlating, 4), "xyx", "yzy", "xyx", 'x', new ItemStack(ModItems.pearcelIngot), 'y', new ItemStack(Items.iron_ingot), 'z', new ItemStack(ModItems.tier2Craft));
        GameRegistry.addRecipe(new ItemStack(ModItems.tier1Craft, 2), "xyx", "yzy", "xyx", 'x', new ItemStack(ModItems.pearcelIngot), 'y', new ItemStack(Items.redstone), 'z', new ItemStack(Items.paper));
        GameRegistry.addRecipe(new ItemStack(ModItems.tier2Craft, 2), "xyx", "yzy", "xyx", 'x', new ItemStack(ModItems.pearcelIngot), 'y', new ItemStack(Items.iron_ingot), 'z', new ItemStack(Items.paper));
        GameRegistry.addRecipe(new ItemStack(ModItems.tier3Craft, 2), "xyx", "yzy", "xyx", 'x', new ItemStack(ModItems.pearcelIngot), 'y', new ItemStack(Items.diamond), 'z', new ItemStack(Items.paper));
        GameRegistry.addRecipe(new ItemStack(ModItems.tier4Craft, 4), "xyx", "yzy", "xyx", 'x', new ItemStack(ModItems.pearcelIngot), 'y', new ItemStack(Items.nether_star), 'z', new ItemStack(Items.paper));
        GameRegistry.addRecipe(new ItemStack(ModItems.tier4Craft, 1), "xyx", "aza", "xax", 'x', new ItemStack(ModItems.pearcelIngot), 'y', new ItemStack(Items.nether_star), 'z', new ItemStack(Items.paper), 'a', new ItemStack(ModItems.tier3Craft));
        GameRegistry.addRecipe(new ItemStack(ModItems.tier3Craft, 1), "xyx", "aza", "xax", 'x', new ItemStack(ModItems.pearcelIngot), 'y', new ItemStack(Items.diamond), 'z', new ItemStack(Items.paper), 'a', new ItemStack(ModItems.tier2Craft));
        GameRegistry.addRecipe(new ItemStack(ModItems.tier2Craft, 1), "xyx", "aza", "xax", 'x', new ItemStack(ModItems.pearcelIngot), 'y', new ItemStack(Items.iron_ingot), 'z', new ItemStack(Items.paper), 'a', new ItemStack(ModItems.tier1Craft));

        //Tools and Weapons, Armor
		GameRegistry.addRecipe(new ItemStack(ModItems.pearcelSword), "x", "z", "y", 'x', new ItemStack(ModItems.pearcelIngot), 'y', new ItemStack(ModItems.pearcelStick), 'z', new ItemStack(ModItems.tier2Craft));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcelPickaxe), "xzx", " y ", " y ", 'x', new ItemStack(ModItems.pearcelIngot), 'y', new ItemStack(ModItems.pearcelStick), 'z', new ItemStack(ModItems.tier2Craft));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcelAxe), "zx", "xy", " y", 'x', new ItemStack(ModItems.pearcelIngot), 'y', new ItemStack(ModItems.pearcelStick), 'z', new ItemStack(ModItems.tier2Craft));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcelShovel), "x", "y", "z", 'x', new ItemStack(ModItems.pearcelIngot), 'y', new ItemStack(ModItems.pearcelStick), 'z', new ItemStack(ModItems.tier2Craft));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcelHoe), "xz", " y", " y", 'x', new ItemStack(ModItems.pearcelIngot), 'y', new ItemStack(ModItems.pearcelStick), 'z', new ItemStack(ModItems.tier2Craft));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcelShears), "  x", "yx ", 'x', new ItemStack(ModItems.pearcelIngot), 'y', new ItemStack(ModItems.tier1Craft));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcelBow), " xy", "z y", " xy", 'x', new ItemStack(ModItems.pearcelStick), 'y', new ItemStack(Items.string), 'z', new ItemStack(ModItems.tier3Craft));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcelArrow), "x", "y", "z", 'x', new ItemStack(ModItems.pearcelIngot), 'y', new ItemStack(ModItems.pearcelStick), 'z', new ItemStack(ModItems.tier2Craft));
        GameRegistry.addRecipe(new ItemStack(ModItems.pcp), "zxa", "xyx", "axz", 'x', new ItemStack(ModItems.pearcelIngot), 'y', new ItemStack(ModBlocks.pearcelWorkbench), 'z', new ItemStack(ModItems.tier1Craft), 'a', new ItemStack(ModItems.pearcel));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcelStaff), "  x", "zy ", "bz ", 'x', new ItemStack(ModItems.pearcelIngot), 'y', new ItemStack(ModItems.pearcelStick), 'z', new ItemStack(ModItems.pearcelMatter), 'b', new ItemStack(ModItems.tier3Craft));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcelHelmet), "xyx", "y y", 'x', new ItemStack(ModItems.armorPlating), 'y', new ItemStack(ModItems.tier2Craft));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcelChestplate), "y y", "xyx", "xxx", 'x', new ItemStack(ModItems.armorPlating), 'y', new ItemStack(ModItems.tier2Craft));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcelLeggings), "xyx", "x x", "y y", 'x', new ItemStack(ModItems.armorPlating), 'y', new ItemStack(ModItems.tier2Craft));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcelBoots), "y y", "xyx", 'x', new ItemStack(ModItems.armorPlating), 'y', new ItemStack(ModItems.tier2Craft));
        GameRegistry.addRecipe(new ItemStack(ModItems.chargedPearcelHelmet), "xzx", "zyz", "xzx", 'x', new ItemStack(Blocks.redstone_block), 'y', new ItemStack(ModItems.pearcelHelmet), 'z', new ItemStack(ModItems.armorPlating));
        GameRegistry.addRecipe(new ItemStack(ModItems.chargedPearcelChestplate), "xzx", "zyz", "xzx", 'x', new ItemStack(Blocks.redstone_block), 'y', new ItemStack(ModItems.pearcelChestplate), 'z', new ItemStack(ModItems.armorPlating));
        GameRegistry.addRecipe(new ItemStack(ModItems.chargedPearcelLeggings), "xzx", "zyz", "xzx", 'x', new ItemStack(Blocks.redstone_block), 'y', new ItemStack(ModItems.pearcelLeggings), 'z', new ItemStack(ModItems.armorPlating));
        GameRegistry.addRecipe(new ItemStack(ModItems.chargedPearcelBoots), "xzx", "zyz", "xzx", 'x', new ItemStack(Blocks.redstone_block), 'y', new ItemStack(ModItems.pearcelBoots), 'z', new ItemStack(ModItems.armorPlating));
        GameRegistry.addRecipe(new ItemStack(ModItems.sap), "xab", "yzy", "bax", 'x', new ItemStack(Items.diamond), 'y', new ItemStack(Items.emerald), 'z', new ItemStack(ModItems.tier3Craft), 'a', new ItemStack(Items.gold_ingot), 'b', new ItemStack(ModItems.pearcel));
        GameRegistry.addRecipe(new ItemStack(ModItems.flightItem), "aba", "cdc", "aba", 'a', new ItemStack(ModItems.pearcel), 'b', new ItemStack(Items.feather), 'c', new ItemStack(ModItems.pearcelMatter), 'd', new ItemStack(ModItems.tier4Craft));
        GameRegistry.addRecipe(new ItemStack(ModItems.chargedPearcelSword), "xzx", "zyz", "xzx", 'x', new ItemStack(Blocks.redstone_block), 'y', new ItemStack(ModItems.pearcelSword), 'z', new ItemStack(ModItems.pearcelIngot));
        GameRegistry.addRecipe(new ItemStack(ModItems.ivep), "zxa", "xyx", "axz", 'x', new ItemStack(ModItems.pearcelIngot), 'y', new ItemStack(ModBlocks.ivet), 'z', new ItemStack(ModItems.tier2Craft), 'a', new ItemStack(ModItems.pearcel));

		//Blocks
        GameRegistry.addSmelting(new ItemStack(ModBlocks.pearcelSand), new ItemStack(ModBlocks.pearcelGlass), 5F);
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcelTorch, 4), "x", "y", 'x', new ItemStack(ModItems.pearcelCharcoal), 'y', new ItemStack(ModItems.pearcelStick));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcelBlock), "xxx", "xxx", "xxx", 'x', new ItemStack(ModItems.pearcel));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcelWorkbench), "xx", "xx", 'x', new ItemStack(ModBlocks.pearcelPlanks));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.ivet), "cyc", "axa", "bzb", 'a', new ItemStack(Blocks.obsidian), 'b', new ItemStack(ModItems.tier3Craft), 'c', new ItemStack(Items.iron_ingot), 'x', new ItemStack(ModBlocks.pearcelWorkbench), 'y', new ItemStack(Items.book), 'z', new ItemStack(Items.diamond));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.torcher, 4), "xyx", "yzy", "xyx", 'x', new ItemStack(Blocks.tnt), 'y', new ItemStack(Blocks.torch), 'z', new ItemStack(ModItems.tier2Craft));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.summoner), "xyx", "yzy", "aba", 'x', new ItemStack(Items.diamond), 'y', new ItemStack(Items.emerald), 'z', new ItemStack(ModItems.tier3Craft), 'a', new ItemStack(Items.gold_ingot), 'b', new ItemStack(ModItems.pearcelIngot));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.enderInfusedPearcel), "xax", "yzy", "xax", 'x', new ItemStack(ModBlocks.pearcelBlock), 'y', new ItemStack(Items.ender_pearl), 'z', new ItemStack(ModItems.tier3Craft), 'a', new ItemStack(Blocks.end_stone));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.netherInfusedPearcel), "xax", "yzy", "xax", 'x', new ItemStack(ModBlocks.pearcelBlock), 'y', new ItemStack(Items.lava_bucket), 'z', new ItemStack(ModItems.tier3Craft), 'a', new ItemStack(Blocks.netherrack));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcelStonebricks, 4), "xx", "xx", 'x', new ItemStack(ModBlocks.pearcelStone));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcelFence, 2), "yxy", "yxy", 'x', new ItemStack(ModItems.pearcelStick), 'y', new ItemStack(ModBlocks.pearcelPlanks));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcelGlassPane, 16), "xxx", "xxx", 'x', new ItemStack(ModBlocks.pearcelGlass));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcelStairs, 4), "x  ", "xx ", "xxx", 'x', new ItemStack(ModBlocks.pearcelBlock));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcelWoodStairs, 4), "x  ", "xx ", "xxx", 'x', new ItemStack(ModBlocks.pearcelPlanks));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcelPlush), " x ", "xyx", "z z", 'x', new ItemStack(ModItems.pearcel), 'y', new ItemStack(ModBlocks.pearcelBlock), 'z', new ItemStack(ModItems.pearcelStick));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.foolsPearcelOre, 4), "xyx", "yzy", "xyx", 'x', new ItemStack(ModItems.pearcelIngot), 'y', new ItemStack(Items.gunpowder), 'z', new ItemStack(ModItems.tier2Craft));

        //Compressed Blocks/Items
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcelCookie), new ItemStack(Items.egg), new ItemStack(ModItems.pearcelFlour), new ItemStack(Items.sugar), new ItemStack(Items.milk_bucket));
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.blockSapling, 1, 0), new ItemStack(ModItems.pearcel), new ItemStack(Blocks.sapling));
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.pearcelPlanks, 4), new ItemStack(ModBlocks.blockLog, 1, 0));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcelCharcoal, 9), new ItemStack(ModBlocks.pearcelCharcoalBlock));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcelCharcoalBlock), "xxx", "xxx", "xxx", 'x', new ItemStack(ModItems.pearcelCharcoal));

        //ME^Matter Recipes
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcelMatter, 9), new ItemStack(ModBlocks.pearcelMatterBlock));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcelMatterBlock), "xxx", "xxx", "xxx", 'x', new ItemStack(ModItems.pearcelMatter));

        GameRegistry.addRecipe(new ItemStack(Items.coal, 32), "x  ", " x ", " x ", 'x', new ItemStack(ModItems.pearcelMatter));
        GameRegistry.addRecipe(new ItemStack(Items.iron_ingot, 16), " x ", "x  ", "x  ", 'x', new ItemStack(ModItems.pearcelMatter));
        GameRegistry.addRecipe(new ItemStack(Items.gold_ingot, 8), "x  ", "x  ", "  x", 'x', new ItemStack(ModItems.pearcelMatter));
        GameRegistry.addRecipe(new ItemStack(Items.diamond, 4), "x  ", "x x", 'x', new ItemStack(ModItems.pearcelMatter));
        GameRegistry.addRecipe(new ItemStack(Items.emerald, 2), " xx", " x ", 'x', new ItemStack(ModItems.pearcelMatter));
        GameRegistry.addRecipe(new ItemStack(Items.redstone, 32), "x x", "x x", 'x', new ItemStack(ModItems.pearcelMatter));
        GameRegistry.addRecipe(new ItemStack(Items.quartz, 32), "x x", "x x", " x ", 'x', new ItemStack(ModItems.pearcelMatter));
        GameRegistry.addRecipe(new ItemStack(Items.blaze_rod, 8), "x  ", " x ", "  x", 'x', new ItemStack(ModItems.pearcelMatter));
        GameRegistry.addRecipe(new ItemStack(Items.slime_ball, 32), " x ", "x x", " x ", 'x', new ItemStack(ModItems.pearcelMatter));
        GameRegistry.addRecipe(new ItemStack(Items.experience_bottle, 16), "xx ", "x  ", 'x', new ItemStack(ModItems.pearcelMatter));
        GameRegistry.addRecipe(new ItemStack(Items.glowstone_dust, 32), "xx ", "  x", 'x', new ItemStack(ModItems.pearcelMatter));

        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.coal_ore, 16), new ItemStack(ModItems.pearcelMatter), new ItemStack(Items.slime_ball), new ItemStack(Blocks.coal_block));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.iron_ore, 16), new ItemStack(ModItems.pearcelMatter), new ItemStack(Items.slime_ball), new ItemStack(Blocks.iron_block));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.gold_ore, 16), new ItemStack(ModItems.pearcelMatter), new ItemStack(Items.slime_ball), new ItemStack(Blocks.gold_block));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.diamond_ore, 16), new ItemStack(ModItems.pearcelMatter), new ItemStack(Items.slime_ball), new ItemStack(Blocks.diamond_block));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.redstone_ore, 16), new ItemStack(ModItems.pearcelMatter), new ItemStack(Items.slime_ball), new ItemStack(Blocks.redstone_block));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stone, 64), new ItemStack(ModItems.pearcelMatter), new ItemStack(Blocks.cobblestone));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stonebrick, 64), new ItemStack(ModItems.pearcelMatter), new ItemStack(Blocks.stone));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.cobblestone, 111), new ItemStack(ModItems.pearcelMatter), new ItemStack(Items.water_bucket), new ItemStack(Items.lava_bucket), new ItemStack(Blocks.cobblestone));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.soul_sand, 64), new ItemStack(ModItems.pearcelMatter), new ItemStack(Items.ghast_tear), new ItemStack(Blocks.netherrack));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.saddle), new ItemStack(ModItems.pearcelMatter), new ItemStack(Items.leather), new ItemStack(Items.leather), new ItemStack(Items.iron_ingot));

	}

}
