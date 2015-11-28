package com.miningmark48.pearcelmod.init;

import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes {
	
	public static void init(){
		
		//Items
	    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel, 9), new ItemStack(ModBlocks.pearcelBlock));
		GameRegistry.addRecipe(new ItemStack(ModItems.pearcel), "xxx", "x x", "xxx", 'x', new ItemStack(ModItems.pearcelNugget));
		GameRegistry.addSmelting(new ItemStack(ModBlocks.pearcelOre), new ItemStack(ModItems.pearcel, 1),  10f);
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcelSeeds, 2), new ItemStack(ModItems.pearcel), new ItemStack(Items.wheat_seeds));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcelNugget, 9), new ItemStack(ModItems.pearcel));
        GameRegistry.addSmelting(new ItemStack(ModBlocks.netherPearcelOre), new ItemStack(ModItems.pearcel, 2), 10f);
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcelStick, 4), "x", "x", 'x', new ItemStack(ModItems.pearcel));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcelStick, 4), "x", "x", 'x', new ItemStack(ModBlocks.pearcelPlanks));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcelFlour, 6), "xyx", 'x', new ItemStack(ModItems.pearcel), 'y', new ItemStack(Items.bread));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcelBread, 3), "xxx", 'x', new ItemStack(ModItems.pearcelFlour));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcelPie), new ItemStack(ModItems.pearcelFlour), new ItemStack(ModItems.pearcel), new ItemStack(Items.egg));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcelJuice), new ItemStack(ModItems.pearcel), new ItemStack(Items.bucket), new ItemStack(Items.sugar));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.angelDust), new ItemStack(Items.feather), new ItemStack(Items.sugar), new ItemStack(Items.rotten_flesh), new ItemStack(Items.spider_eye));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcelMelon, 2), new ItemStack(Items.melon), new ItemStack(ModItems.pearcel));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcelSandwich), new ItemStack(ModItems.pearcel), new ItemStack(ModItems.pearcelBread), new ItemStack(ModItems.pearcelJelly), new ItemStack(Items.sugar));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.melonSandwich), new ItemStack(ModItems.pearcelMelon), new ItemStack(ModItems.pearcelBread), new ItemStack(ModItems.melonJelly), new ItemStack(Items.sugar));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcelJar, 3), "x x", "x x", " y ", 'x', new ItemStack(Blocks.glass), 'y', new ItemStack(ModBlocks.meGlass));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcelJelly), new ItemStack(ModItems.pearcelJar), new ItemStack(ModItems.pearcel));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.melonJelly), new ItemStack(ModItems.pearcelJar), new ItemStack(ModItems.pearcelMelon));
        GameRegistry.addSmelting(new ItemStack(ModItems.pearcelBeef), new ItemStack(ModItems.pearcelSteak), 10f);
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcelMelon, 4), new ItemStack(ModBlocks.pearcelMelonBlock));
        GameRegistry.addSmelting(new ItemStack(ModItems.pearcelFlour), new ItemStack(ModItems.pearcelBread), 10f);
        GameRegistry.addSmelting(new ItemStack(ModItems.pearcel), new ItemStack(ModItems.pearcelCharcoal), 10f);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.pearcelBlock), new ItemStack(ModItems.pearcelCharcoal, 9), 100f);
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcelCharcoal, 2), " x ", "xyx", " x ", 'x', new ItemStack(ModItems.pearcelNugget), 'y', new ItemStack(Items.coal));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcelNugget, 10), new ItemStack(ModItems.pearcel), new ItemStack(Items.gunpowder));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcelCookie), " x ", "xyx", " x ", 'x', new ItemStack(ModItems.pearcelNugget), 'y', new ItemStack(Items.cookie));
        //GameRegistry.addRecipe(new ItemStack(ModItems.dice), "xyx", "yzy", "xyx", 'x', new ItemStack(Blocks.stone), 'y', new ItemStack(Items.redstone), 'z', new ItemStack(ModItems.tier2Craft));
        GameRegistry.addRecipe(new ItemStack(ModItems.armorPlating, 4), "xyx", "yzy", "xyx", 'x', new ItemStack(ModItems.pearcel), 'y', new ItemStack(Items.iron_ingot), 'z', new ItemStack(ModItems.tier2Craft));
        GameRegistry.addRecipe(new ItemStack(ModItems.tier1Craft, 2), "xyx", "yzy", "xyx", 'x', new ItemStack(ModItems.pearcelNugget), 'y', new ItemStack(Items.redstone), 'z', new ItemStack(Items.paper));
        GameRegistry.addRecipe(new ItemStack(ModItems.tier2Craft, 2), "xyx", "yzy", "xyx", 'x', new ItemStack(ModItems.pearcelNugget), 'y', new ItemStack(Items.iron_ingot), 'z', new ItemStack(Items.paper));
        GameRegistry.addRecipe(new ItemStack(ModItems.tier3Craft, 2), "xyx", "yzy", "xyx", 'x', new ItemStack(ModItems.pearcel), 'y', new ItemStack(Items.diamond), 'z', new ItemStack(Items.paper));
        GameRegistry.addRecipe(new ItemStack(ModItems.tier4Craft, 4), "xyx", "yzy", "xyx", 'x', new ItemStack(ModItems.pearcel), 'y', new ItemStack(Items.nether_star), 'z', new ItemStack(Items.paper));
        GameRegistry.addRecipe(new ItemStack(ModItems.tier4Craft, 1), "xyx", "aza", "xax", 'x', new ItemStack(ModItems.pearcel), 'y', new ItemStack(Items.nether_star), 'z', new ItemStack(Items.paper), 'a', new ItemStack(ModItems.tier3Craft));
        GameRegistry.addRecipe(new ItemStack(ModItems.tier3Craft, 1), "xyx", "aza", "xax", 'x', new ItemStack(ModItems.pearcel), 'y', new ItemStack(Items.diamond), 'z', new ItemStack(Items.paper), 'a', new ItemStack(ModItems.tier2Craft));
        GameRegistry.addRecipe(new ItemStack(ModItems.tier2Craft, 1), "xyx", "aza", "xax", 'x', new ItemStack(ModItems.pearcelNugget), 'y', new ItemStack(Items.iron_ingot), 'z', new ItemStack(Items.paper), 'a', new ItemStack(ModItems.tier1Craft));

        //Tools and Weapons, Armor
		GameRegistry.addRecipe(new ItemStack(ModItems.pearcelSword), "x", "z", "y", 'x', new ItemStack(ModItems.pearcel), 'y', new ItemStack(ModItems.pearcelStick), 'z', new ItemStack(ModItems.tier2Craft));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcelPickaxe), "xzx", " y ", " y ", 'x', new ItemStack(ModItems.pearcel), 'y', new ItemStack(ModItems.pearcelStick), 'z', new ItemStack(ModItems.tier2Craft));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcelAxe), "zx", "xy", " y", 'x', new ItemStack(ModItems.pearcel), 'y', new ItemStack(ModItems.pearcelStick), 'z', new ItemStack(ModItems.tier2Craft));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcelShovel), "x", "y", "z", 'x', new ItemStack(ModItems.pearcel), 'y', new ItemStack(ModItems.pearcelStick), 'z', new ItemStack(ModItems.tier2Craft));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcelHoe), "xz", " y", " y", 'x', new ItemStack(ModItems.pearcel), 'y', new ItemStack(ModItems.pearcelStick), 'z', new ItemStack(ModItems.tier2Craft));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcelShears), "  x", "yx ", 'x', new ItemStack(ModItems.pearcel), 'y', new ItemStack(ModItems.tier1Craft));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcelBow), " xy", "z y", " xy", 'x', new ItemStack(ModItems.pearcelStick), 'y', new ItemStack(Items.string), 'z', new ItemStack(ModItems.tier3Craft));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcelArrow), "x", "y", "z", 'x', new ItemStack(ModItems.pearcel), 'y', new ItemStack(ModItems.pearcelStick), 'z', new ItemStack(ModItems.tier2Craft));
        GameRegistry.addRecipe(new ItemStack(ModItems.pcp), "zx ", "xyx", " x ", 'x', new ItemStack(ModItems.pearcel), 'y', new ItemStack(ModBlocks.meWorkbench), 'z', new ItemStack(ModItems.tier1Craft));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcelStaff), "  x", "ay ", "bz ", 'x', new ItemStack(ModItems.pearcel), 'y', new ItemStack(ModItems.pearcelStick), 'z', new ItemStack(ModItems.redMatter), 'a', new ItemStack(ModItems.greenMatter), 'b', new ItemStack(ModItems.tier4Craft));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcelHelmet), "xyx", "y y", 'x', new ItemStack(ModItems.armorPlating), 'y', new ItemStack(ModItems.tier3Craft));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcelChestplate), "y y", "xyx", "xxx", 'x', new ItemStack(ModItems.armorPlating), 'y', new ItemStack(ModItems.tier3Craft));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcelLeggings), "xyx", "x x", "y y", 'x', new ItemStack(ModItems.armorPlating), 'y', new ItemStack(ModItems.tier3Craft));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcelBoots), "y y", "xyx", 'x', new ItemStack(ModItems.armorPlating), 'y', new ItemStack(ModItems.tier3Craft));
        GameRegistry.addRecipe(new ItemStack(ModItems.sap), "xab", "yzy", "bax", 'x', new ItemStack(Items.diamond), 'y', new ItemStack(Items.emerald), 'z', new ItemStack(ModItems.tier3Craft), 'a', new ItemStack(Items.gold_ingot), 'b', new ItemStack(ModItems.pearcel));
        GameRegistry.addRecipe(new ItemStack(ModItems.flightItem), "aba", "cdc", "aba", 'a', new ItemStack(ModItems.pearcel), 'b', new ItemStack(Items.feather), 'c', new ItemStack(ModItems.meMatter), 'd', new ItemStack(ModItems.tier3Craft));
		//Blocks
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcelTorch, 4), "x", "y", 'x', new ItemStack(ModItems.pearcelCharcoal), 'y', new ItemStack(ModItems.pearcelStick));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.meBlock), "xxx", "xyx", "xxx", 'x', new ItemStack(ModItems.pearcel), 'y', new ItemStack(Items.iron_ingot));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcelBlock), "xxx", "xxx", "xxx", 'x', new ItemStack(ModItems.pearcel));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.meGlass, 8), "zxz", "xyx", "zxz", 'x', new ItemStack(Blocks.glass), 'y', new ItemStack(ModItems.tier2Craft), 'z', new ItemStack(Blocks.obsidian));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.meLamp, 8), "zxz", "xyx", "zxz", 'x', new ItemStack(Blocks.glowstone), 'y', new ItemStack(ModItems.tier1Craft), 'z', new ItemStack(Items.glowstone_dust));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.meWorkbench), "xy", "yx", 'x', new ItemStack(ModItems.pearcel), 'y', new ItemStack(Blocks.planks));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.ivet), "cyc", "axa", "bzb", 'a', new ItemStack(Blocks.obsidian), 'b', new ItemStack(ModItems.tier3Craft), 'c', new ItemStack(Items.iron_ingot), 'x', new ItemStack(ModBlocks.meWorkbench), 'y', new ItemStack(Items.book), 'z', new ItemStack(Items.diamond));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcelMelonBlock), "xxx", "xyx", "xxx", 'x', new ItemStack(ModItems.pearcel), 'y', new ItemStack(Items.melon));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcelMelonBlock), "xx", "xx", 'x', new ItemStack(ModItems.pearcelMelon));
        GameRegistry.addRecipe(new ItemStack(Blocks.double_stone_slab), "x", "x", 'x', new ItemStack(Blocks.stone_slab));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.torcher, 4), "xyx", "yzy", "xyx", 'x', new ItemStack(Blocks.torch), 'y', new ItemStack(Blocks.tnt), 'z', new ItemStack(ModItems.tier3Craft));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.summoner), "xyx", "yzy", "aaa", 'x', new ItemStack(Items.diamond), 'y', new ItemStack(Items.emerald), 'z', new ItemStack(ModItems.tier3Craft), 'a', new ItemStack(Items.gold_ingot));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.enderInfusedPearcel), "xax", "yzy", "xax", 'x', new ItemStack(ModBlocks.pearcelBlock), 'y', new ItemStack(Items.ender_pearl), 'z', new ItemStack(ModItems.tier3Craft), 'a', new ItemStack(Blocks.end_stone));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.netherInfusedPearcel), "xax", "yzy", "xax", 'x', new ItemStack(ModBlocks.pearcelBlock), 'y', new ItemStack(Items.lava_bucket), 'z', new ItemStack(ModItems.tier3Craft), 'a', new ItemStack(Blocks.netherrack));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcelStonebricks, 4), "xx", "xx", 'x', new ItemStack(ModBlocks.pearcelStone));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcelFence, 2), "xxx", "xxx", 'x', new ItemStack(ModItems.pearcelStick));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.meGlassPane, 16), "xxx", "xxx", 'x', new ItemStack(ModBlocks.meGlass));
        //Compressed Blocks/Items
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcelCookie), new ItemStack(Items.egg), new ItemStack(ModItems.pearcelFlour), new ItemStack(Items.sugar), new ItemStack(Items.milk_bucket));
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.pearcelCookie2), "xxx", "xxx", "xxx", 'x', new ItemStack(ModItems.pearcelCookie));
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.pearcelCookie3), "xxx", "xxx", "xxx", 'x', new ItemStack(ModItems.pearcelCookie2));
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.pearcelCookie4), "xxx", "xxx", "xxx", 'x', new ItemStack(ModItems.pearcelCookie3));
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.pearcelCookie5), "xxx", "xxx", "xxx", 'x', new ItemStack(ModItems.pearcelCookie4));
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.pearcelCookie6), "xxx", "xxx", "xxx", 'x', new ItemStack(ModItems.pearcelCookie5));
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.pearcelCookie7), "xxx", "xxx", "xxx", 'x', new ItemStack(ModItems.pearcelCookie6));
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.pearcelCookie8), "xxx", "xxx", "xxx", 'x', new ItemStack(ModItems.pearcelCookie7));
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.pearcelCookie9), "xxx", "xxx", "xxx", 'x', new ItemStack(ModItems.pearcelCookie8));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcelCookie, 9), new ItemStack(ModItems.pearcelCookie2));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcelCookie2, 9), new ItemStack(ModItems.pearcelCookie3));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcelCookie3, 9), new ItemStack(ModItems.pearcelCookie4));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcelCookie4, 9), new ItemStack(ModItems.pearcelCookie5));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcelCookie5, 9), new ItemStack(ModItems.pearcelCookie6));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcelCookie6, 9), new ItemStack(ModItems.pearcelCookie7));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcelCookie7, 9), new ItemStack(ModItems.pearcelCookie8));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcelCookie8, 9), new ItemStack(ModItems.pearcelCookie9));
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.blockSapling, 1, 0), new ItemStack(ModItems.pearcel), new ItemStack(Blocks.sapling));
        //GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.blockSapling, 2, 1), new ItemStack(ModBlocks.meBlock), new ItemStack(Blocks.sapling));
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.pearcelPlanks, 4), new ItemStack(ModBlocks.blockLog, 1, 0));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcelCharcoal, 9), new ItemStack(ModBlocks.pearcelCharcoalBlock));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcelCharcoalBlock), "xxx", "xxx", "xxx", 'x', new ItemStack(ModItems.pearcelCharcoal));

        //ME^Matter Recipes
        GameRegistry.addRecipe(new ItemStack(ModBlocks.meMatterBlock), "xxx", "xxx", "xxx", 'x', new ItemStack(ModItems.meMatter));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.meMatter, 9), new ItemStack(ModBlocks.meMatterBlock));
        GameRegistry.addRecipe(new ItemStack(ModItems.meMatterNeutral, 8), "aba", "bcb", "aba", 'a', new ItemStack(Blocks.diamond_block), 'b', new ItemStack(Blocks.gold_block), 'c', new ItemStack(ModItems.tier3Craft));
        GameRegistry.addRecipe(new ItemStack(ModItems.meMatterNeutral, 16), "aba", "bcb", "aba", 'a', new ItemStack(Blocks.diamond_block), 'b', new ItemStack(Blocks.emerald_block), 'c', new ItemStack(ModItems.tier3Craft));
        GameRegistry.addRecipe(new ItemStack(ModItems.meMatterNeutral, 64), "aba", "bcb", "aba", 'a', new ItemStack(Blocks.diamond_block), 'b', new ItemStack(Blocks.emerald_block), 'c', new ItemStack(ModItems.tier4Craft));

        if (ConfigurationHandler.useMEMatter){
            GameRegistry.addRecipe(new ItemStack(Items.coal, 32), "x  ", " x ", " x ", 'x', new ItemStack(ModItems.meMatter));
            GameRegistry.addRecipe(new ItemStack(Items.iron_ingot, 16), " x ", "x  ", "x  ", 'x', new ItemStack(ModItems.meMatter));
            GameRegistry.addRecipe(new ItemStack(Items.gold_ingot, 8), "x  ", "x  ", "  x", 'x', new ItemStack(ModItems.meMatter));
            GameRegistry.addRecipe(new ItemStack(Items.diamond, 4), "x  ", "x x", 'x', new ItemStack(ModItems.meMatter));
            GameRegistry.addRecipe(new ItemStack(Items.emerald, 2), " xx", " x ", 'x', new ItemStack(ModItems.meMatter));
            GameRegistry.addRecipe(new ItemStack(Items.redstone, 32), "x x", "x x", 'x', new ItemStack(ModItems.meMatter));
            GameRegistry.addRecipe(new ItemStack(Items.quartz, 32), "x x", "x x", " x ", 'x', new ItemStack(ModItems.meMatter));
            GameRegistry.addRecipe(new ItemStack(Items.blaze_rod, 8), "x  ", " x ", "  x", 'x', new ItemStack(ModItems.meMatter));
            GameRegistry.addRecipe(new ItemStack(Items.slime_ball, 32), " x ", "x x", " x ", 'x', new ItemStack(ModItems.meMatter));
            GameRegistry.addRecipe(new ItemStack(Items.experience_bottle, 16), "xx ", "x  ", 'x', new ItemStack(ModItems.meMatter));
            GameRegistry.addRecipe(new ItemStack(Items.glowstone_dust, 32), "xx ", "  x", 'x', new ItemStack(ModItems.meMatter));
            


            GameRegistry.addShapelessRecipe(new ItemStack(Blocks.coal_ore, 16), new ItemStack(ModItems.meMatter), new ItemStack(Items.slime_ball), new ItemStack(Blocks.coal_block));
            GameRegistry.addShapelessRecipe(new ItemStack(Blocks.iron_ore, 16), new ItemStack(ModItems.meMatter), new ItemStack(Items.slime_ball), new ItemStack(Blocks.iron_block));
            GameRegistry.addShapelessRecipe(new ItemStack(Blocks.gold_ore, 16), new ItemStack(ModItems.meMatter), new ItemStack(Items.slime_ball), new ItemStack(Blocks.gold_block));
            GameRegistry.addShapelessRecipe(new ItemStack(Blocks.diamond_ore, 16), new ItemStack(ModItems.meMatter), new ItemStack(Items.slime_ball), new ItemStack(Blocks.diamond_block));
            GameRegistry.addShapelessRecipe(new ItemStack(Blocks.redstone_ore, 16), new ItemStack(ModItems.meMatter), new ItemStack(Items.slime_ball), new ItemStack(Blocks.redstone_block));
            GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stone, 64), new ItemStack(ModItems.meMatter), new ItemStack(Blocks.cobblestone));
            GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stonebrick, 64), new ItemStack(ModItems.meMatter), new ItemStack(Blocks.stone));
            GameRegistry.addShapelessRecipe(new ItemStack(Blocks.cobblestone, 111), new ItemStack(ModItems.meMatter), new ItemStack(Items.water_bucket), new ItemStack(Items.lava_bucket), new ItemStack(Blocks.cobblestone));
            GameRegistry.addShapelessRecipe(new ItemStack(Blocks.soul_sand, 64), new ItemStack(ModItems.meMatter), new ItemStack(Items.ghast_tear), new ItemStack(Blocks.netherrack));
        }

        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.redMatter, 4), new ItemStack(ModItems.meMatter), new ItemStack(Items.dye, 1, 1), new ItemStack(ModItems.tier3Craft));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.greenMatter, 4), new ItemStack(ModItems.meMatter), new ItemStack(Items.dye, 1, 2), new ItemStack(ModItems.tier3Craft));


        //Recipes based on config settigns
        if (ConfigurationHandler.specialDice){
            GameRegistry.addRecipe(new ItemStack(ModItems.dice), "xyx", "yzy", "xyx", 'x', new ItemStack(Blocks.stone), 'y', new ItemStack(Items.redstone), 'z', new ItemStack(ModItems.tier4Craft));
        }else if(!ConfigurationHandler.specialDice){
            GameRegistry.addRecipe(new ItemStack(ModItems.dice), "xyx", "yzy", "xyx", 'x', new ItemStack(Blocks.stone), 'y', new ItemStack(Items.redstone), 'z', new ItemStack(ModItems.tier1Craft));
        }


	}

}
