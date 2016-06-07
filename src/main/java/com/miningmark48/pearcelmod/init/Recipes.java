package com.miningmark48.pearcelmod.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class Recipes {
    
    public static void init(){
        //Items
        GameRegistry.addSmelting(new ItemStack(ModBlocks.ender_pearcel_ore), new ItemStack(ModItems.pearcel_ingot, 4), 15f);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.nether_pearcel_ore), new ItemStack(ModItems.pearcel_ingot, 2), 10f);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.pearcel_ore), new ItemStack(ModItems.pearcel_ingot, 1), 5f);
        GameRegistry.addSmelting(new ItemStack(ModItems.pearcel_beef), new ItemStack(ModItems.pearcel_steak), 10f);
        GameRegistry.addSmelting(new ItemStack(ModItems.pearcel_flour), new ItemStack(ModItems.pearcel_bread), 10f);
        GameRegistry.addSmelting(new ItemStack(ModItems.pearcel_item), new ItemStack(ModItems.pearcel_charcoal), 10f);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.pearcel_block), new ItemStack(ModBlocks.pearcel_charcoal_block, 1), 5f);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.pearcel_matter_ore), new ItemStack(ModItems.neutral_pearcel_matter, 1), 50F);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.dense_pearcel_ore), new ItemStack(ModItems.pearcel_ingot, 4), 20F);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.dense_pearcel_matter_ore), new ItemStack(ModItems.neutral_pearcel_matter, 4), 100F);
        //GameRegistry.addSmelting(new ItemStack(ModBlocks.blockLog), new ItemStack(ModItems.pearcel_charcoal), 5F);
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel_pie), new ItemStack(ModItems.pearcel_flour), new ItemStack(ModItems.pearcel_item), new ItemStack(Items.egg));
        //GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel_juice), new ItemStack(ModItems.pearcel), new ItemStack(Items.bucket), new ItemStack(Items.sugar));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel_sandwich), new ItemStack(ModItems.pearcel_item), new ItemStack(ModItems.pearcel_bread), new ItemStack(Items.sugar));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel_item, 9), new ItemStack(ModBlocks.pearcel_block));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel_seeds, 1), new ItemStack(ModItems.pearcel_item));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel_juice_bottle), new ItemStack(Items.glass_bottle), new ItemStack(ModItems.pearcel_item), new ItemStack(Items.sugar));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel_seeds, 4), new ItemStack(ModItems.pearcel_ingot), new ItemStack(Items.wheat_seeds));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel_seeds, 4), new ItemStack(ModItems.pearcel_ingot), new ItemStack(Items.pumpkin_seeds));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel_seeds, 4), new ItemStack(ModItems.pearcel_ingot), new ItemStack(Items.melon_seeds));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel_ingot), new ItemStack(ModItems.pearcel_item), new ItemStack(Items.iron_ingot));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel_cookie, 12), new ItemStack(Items.egg), new ItemStack(ModItems.pearcel_flour), new ItemStack(Items.sugar), new ItemStack(Items.milk_bucket));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_stick, 6), "x", "x", 'x', new ItemStack(ModItems.pearcel_item));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_stick, 4), "x", "x", 'x', new ItemStack(ModBlocks.pearcel_planks));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_flour, 6), "xyx", 'x', new ItemStack(ModItems.pearcel_item), 'y', new ItemStack(Items.bread));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_bread, 3), "xxx", 'x', new ItemStack(ModItems.pearcel_flour));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_cookie, 4), " x ", "xyx", " x ", 'x', new ItemStack(ModItems.pearcel_item), 'y', new ItemStack(Items.cookie));
        GameRegistry.addRecipe(new ItemStack(ModItems.armor_plating, 8), "xyx", "yzy", "xyx", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(Items.iron_ingot), 'z', new ItemStack(ModItems.tier_2_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.tier_1_crafting_component, 2), "xyx", "yzy", "xyx", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(Items.redstone), 'z', new ItemStack(Items.paper));
        GameRegistry.addRecipe(new ItemStack(ModItems.tier_2_crafting_component, 2), "xyx", "yzy", "xyx", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(Items.iron_ingot), 'z', new ItemStack(Items.paper));
        GameRegistry.addRecipe(new ItemStack(ModItems.tier_3_crafting_component, 2), "xyx", "yzy", "xyx", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(Items.diamond), 'z', new ItemStack(Items.paper));
        GameRegistry.addRecipe(new ItemStack(ModItems.tier_4_crafting_component, 4), "xyx", "yzy", "xyx", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(Items.nether_star), 'z', new ItemStack(Items.paper));
        GameRegistry.addRecipe(new ItemStack(ModItems.tier_4_crafting_component, 1), "xyx", "aza", "xax", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(Items.nether_star), 'z', new ItemStack(Items.paper), 'a', new ItemStack(ModItems.tier_3_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.tier_3_crafting_component, 1), "xyx", "aza", "xax", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(Items.diamond), 'z', new ItemStack(Items.paper), 'a', new ItemStack(ModItems.tier_2_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.tier_2_crafting_component, 1), "xyx", "aza", "xax", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(Items.iron_ingot), 'z', new ItemStack(Items.paper), 'a', new ItemStack(ModItems.tier_1_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.neutral_pearcel_matter, 4), "xyx", "yzy", "xyx", 'x', new ItemStack(Items.diamond), 'y', new ItemStack(ModItems.pearcel_ingot), 'z', new ItemStack(ModItems.tier_2_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.neutral_pearcel_matter, 8), "xyx", "yzy", "xyx", 'x', new ItemStack(Items.diamond), 'y', new ItemStack(ModItems.pearcel_ingot), 'z', new ItemStack(ModItems.tier_3_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.neutral_pearcel_matter, 16), "xyx", "yzy", "xyx", 'x', new ItemStack(Items.diamond), 'y', new ItemStack(ModItems.pearcel_ingot), 'z', new ItemStack(ModItems.tier_4_crafting_component));

        //Tools and Weapons, Armor
        //GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel_and_steel), new ItemStack(ModItems.pearcel), new ItemStack(Items.iron_ingot), new ItemStack(Items.flint));
        //GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel_and_steel), new ItemStack(ModItems.pearcel), new ItemStack(Items.flint_and_steel));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_sword), "x", "z", "y", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(ModItems.pearcel_stick), 'z', new ItemStack(ModItems.tier_2_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_pickaxe), "xzx", " y ", " y ", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(ModItems.pearcel_stick), 'z', new ItemStack(ModItems.tier_2_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_axe), "zx", "xy", " y", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(ModItems.pearcel_stick), 'z', new ItemStack(ModItems.tier_2_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_shovel), "x", "z", "y", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(ModItems.pearcel_stick), 'z', new ItemStack(ModItems.tier_2_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_hoe), "xz", " y", " y", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(ModItems.pearcel_stick), 'z', new ItemStack(ModItems.tier_2_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_shears), "  x", "yx ", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(ModItems.tier_1_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_bow), " xy", "z y", " xy", 'x', new ItemStack(ModItems.pearcel_stick), 'y', new ItemStack(Items.string), 'z', new ItemStack(ModItems.tier_3_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_arrow), "x", "y", "z", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(ModItems.pearcel_stick), 'z', new ItemStack(ModItems.tier_3_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.pcp), "zxa", "xyx", "axz", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(ModBlocks.pearcel_workbench), 'z', new ItemStack(ModItems.tier_1_crafting_component), 'a', new ItemStack(ModItems.pearcel_item));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_staff), "  x", "zy ", "bz ", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(ModItems.pearcel_stick), 'z', new ItemStack(ModItems.pearcel_matter), 'b', new ItemStack(ModItems.tier_3_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_helmet), "xyx", "y y", 'x', new ItemStack(ModItems.armor_plating), 'y', new ItemStack(ModItems.tier_2_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_chestplate), "y y", "xyx", "xxx", 'x', new ItemStack(ModItems.armor_plating), 'y', new ItemStack(ModItems.tier_2_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_leggings), "xyx", "x x", "y y", 'x', new ItemStack(ModItems.armor_plating), 'y', new ItemStack(ModItems.tier_2_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_boots), "y y", "xyx", 'x', new ItemStack(ModItems.armor_plating), 'y', new ItemStack(ModItems.tier_2_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.sap), "xab", "yzy", "bax", 'x', new ItemStack(Items.diamond), 'y', new ItemStack(Items.emerald), 'z', new ItemStack(ModItems.tier_3_crafting_component), 'a', new ItemStack(Items.gold_ingot), 'b', new ItemStack(ModItems.pearcel_item));
        GameRegistry.addRecipe(new ItemStack(ModItems.ender_pearcel, 6), "xyx", "yzy", "xyx", 'x', new ItemStack(ModItems.pearcel_item), 'y', new ItemStack(Items.ender_pearl), 'z', new ItemStack(ModItems.tier_3_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.tp_pearcel), "xyx", "yzy", "xyx", 'x', new ItemStack(ModItems.pearcel_item), 'y', new ItemStack(Items.diamond), 'z', new ItemStack(ModItems.ender_pearcel));
        GameRegistry.addRecipe(new ItemStack(ModItems.dragon_pearcel_staff), "xbx", "xyx", "zaz", 'x', new ItemStack(ModItems.tier_4_crafting_component), 'y', new ItemStack(ModItems.pearcel_staff), 'z', new ItemStack(ModItems.tier_3_crafting_component), 'a', new ItemStack(Blocks.dragon_egg), 'b', new ItemStack(ModBlocks.tainted_pearcel));
        GameRegistry.addRecipe(new ItemStack(ModItems.pepc), "xyx", "aza", "yby", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(ModItems.tier_3_crafting_component), 'z', new ItemStack(Blocks.ender_chest), 'a', new ItemStack(ModItems.pearcel_item), 'b', new ItemStack(ModItems.ender_pearcel));
        GameRegistry.addRecipe(new ItemStack(ModItems.experience_pearcel), "xyx", "aba", "xzx", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(ModItems.tier_3_crafting_component), 'z', new ItemStack(Items.emerald), 'a', new ItemStack(Items.diamond), 'b', new ItemStack(ModItems.pearcel_item));

        //Blocks
        GameRegistry.addSmelting(new ItemStack(ModBlocks.pearcel_sand), new ItemStack(ModBlocks.pearcel_glass), 5F);
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcel_torch, 4), "x", "y", 'x', new ItemStack(ModItems.pearcel_charcoal), 'y', new ItemStack(ModItems.pearcel_stick));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcel_block), "xxx", "xxx", "xxx", 'x', new ItemStack(ModItems.pearcel_item));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcel_workbench), "xx", "xx", 'x', new ItemStack(ModBlocks.pearcel_planks));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.torcher, 4), "xyx", "yzy", "xyx", 'x', new ItemStack(Items.gunpowder), 'y', new ItemStack(Blocks.torch), 'z', new ItemStack(ModItems.tier_2_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.torcher, 4), "xyx", "yzy", "xyx", 'y', new ItemStack(Items.gunpowder), 'x', new ItemStack(Blocks.torch), 'z', new ItemStack(ModItems.tier_2_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.summoner), "xyx", "yzy", "aba", 'x', new ItemStack(Items.diamond), 'y', new ItemStack(Items.emerald), 'z', new ItemStack(ModItems.tier_3_crafting_component), 'a', new ItemStack(Items.gold_ingot), 'b', new ItemStack(ModItems.pearcel_ingot));
        //GameRegistry.addRecipe(new ItemStack(ModBlocks.enderInfusedPearcel), "xax", "yzy", "xax", 'x', new ItemStack(ModBlocks.pearcel_block), 'y', new ItemStack(Items.ender_pearl), 'z', new ItemStack(ModItems.tier3Craft), 'a', new ItemStack(Blocks.end_stone));
        //GameRegistry.addRecipe(new ItemStack(ModBlocks.netherInfusedPearcel), "xax", "yzy", "xax", 'x', new ItemStack(ModBlocks.pearcel_block), 'y', new ItemStack(Items.lava_bucket), 'z', new ItemStack(ModItems.tier3Craft), 'a', new ItemStack(Blocks.netherrack));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcel_stonebricks, 4), "xx", "xx", 'x', new ItemStack(ModBlocks.polished_pearcel_stone));
        //GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcel_fence, 2), "yxy", "yxy", 'x', new ItemStack(ModItems.pearcelStick), 'y', new ItemStack(ModBlocks.pearcelPlanks));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcel_glass_pane, 16), "xxx", "xxx", 'x', new ItemStack(ModBlocks.pearcel_glass));
        //GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcel_stairs, 4), "x  ", "xx ", "xxx", 'x', new ItemStack(ModBlocks.pearcel_block));
        //GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcel_wood_stairs, 4), "x  ", "xx ", "xxx", 'x', new ItemStack(ModBlocks.pearcelPlanks));
        //GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcel_plush), " x ", "xyx", "z z", 'x', new ItemStack(ModItems.pearcel), 'y', new ItemStack(ModBlocks.pearcel_block), 'z', new ItemStack(ModItems.pearcelStick));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.polished_pearcel_stone, 8), "xx", "xx", 'x', new ItemStack(ModBlocks.pearcel_stone));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.packed_pearcel_bricks, 4), "xx", "xx", 'x', new ItemStack(ModBlocks.pearcel_stonebricks));
        //GameRegistry.addRecipe(new ItemStack(ModBlocks.chiseled_pearcel_stone, 4), "xx", "xx", 'x', new ItemStack(ModBlocks.packedPearcelStonebricks));
        //GameRegistry.addRecipe(new ItemStack(ModBlocks.distressed_pearcel_stone, 4), "xx", "xx", 'x', new ItemStack(ModBlocks.chiseled_pearcel_stone));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcel_bricks, 16), "xx", "xx", 'x', new ItemStack(ModBlocks.pearcel_block));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.irradiated_pearcel_block, 8), " x ", "xyx", " x ", 'x', new ItemStack(Items.glowstone_dust), 'y', new ItemStack(ModBlocks.pearcel_block));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.tainted_pearcel, 16), " x ", "xyx", " x ", 'x', new ItemStack(Items.nether_wart), 'y', new ItemStack(ModBlocks.pearcel_stone));
        //GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.blockSapling, 1, 0), new ItemStack(ModItems.pearcel), new ItemStack(Blocks.sapling));
        //GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.pearcel_planks, 4), new ItemStack(ModBlocks.blockLog, 1, 0));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcel_planks, 8), "xxx", "xyx", "xxx", 'x', new ItemStack(Blocks.planks, 1, OreDictionary.WILDCARD_VALUE), 'y', new ItemStack(ModItems.pearcel_item));

        //Compressed Blocks/Items
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel_charcoal, 9), new ItemStack(ModBlocks.pearcel_charcoal_block));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcel_charcoal_block), "xxx", "xxx", "xxx", 'x', new ItemStack(ModItems.pearcel_charcoal));

        //ME^Matter Recipes
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel_matter, 9), new ItemStack(ModBlocks.pearcel_matter_block));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcel_matter_block), "xxx", "xxx", "xxx", 'x', new ItemStack(ModItems.pearcel_matter));

        GameRegistry.addRecipe(new ItemStack(Items.nether_star), " x ", "xyx", " x ", 'x', new ItemStack(ModItems.pearcel_matter), 'y', new ItemStack(ModBlocks.pearcel_matter_block));
        GameRegistry.addRecipe(new ItemStack(Items.coal, 64), "x  ", " x ", " x ", 'x', new ItemStack(ModItems.pearcel_matter));
        GameRegistry.addRecipe(new ItemStack(Items.iron_ingot, 48), " x ", "x  ", "x  ", 'x', new ItemStack(ModItems.pearcel_matter));
        GameRegistry.addRecipe(new ItemStack(Items.gold_ingot, 32), "x  ", "x  ", "  x", 'x', new ItemStack(ModItems.pearcel_matter));
        GameRegistry.addRecipe(new ItemStack(Items.diamond, 16), "x  ", "x x", 'x', new ItemStack(ModItems.pearcel_matter));
        GameRegistry.addRecipe(new ItemStack(Items.emerald, 8), " xx", " x ", 'x', new ItemStack(ModItems.pearcel_matter));
        GameRegistry.addRecipe(new ItemStack(Items.redstone, 32), "x x", "x x", 'x', new ItemStack(ModItems.pearcel_matter));
        GameRegistry.addRecipe(new ItemStack(Items.quartz, 32), "x x", "x x", " x ", 'x', new ItemStack(ModItems.pearcel_matter));
        GameRegistry.addRecipe(new ItemStack(Items.blaze_rod, 16), "x  ", " x ", "  x", 'x', new ItemStack(ModItems.pearcel_matter));
        GameRegistry.addRecipe(new ItemStack(Items.slime_ball, 32), " x ", "x x", " x ", 'x', new ItemStack(ModItems.pearcel_matter));
        GameRegistry.addRecipe(new ItemStack(Items.experience_bottle, 32), "xx ", "x  ", 'x', new ItemStack(ModItems.pearcel_matter));
        GameRegistry.addRecipe(new ItemStack(Items.glowstone_dust, 32), "xx ", "  x", 'x', new ItemStack(ModItems.pearcel_matter));

        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.coal_ore, 16), new ItemStack(ModItems.pearcel_matter), new ItemStack(Items.slime_ball), new ItemStack(Blocks.coal_block));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.iron_ore, 16), new ItemStack(ModItems.pearcel_matter), new ItemStack(Items.slime_ball), new ItemStack(Blocks.iron_block));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.gold_ore, 16), new ItemStack(ModItems.pearcel_matter), new ItemStack(Items.slime_ball), new ItemStack(Blocks.gold_block));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.diamond_ore, 16), new ItemStack(ModItems.pearcel_matter), new ItemStack(Items.slime_ball), new ItemStack(Blocks.diamond_block));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.redstone_ore, 16), new ItemStack(ModItems.pearcel_matter), new ItemStack(Items.slime_ball), new ItemStack(Blocks.redstone_block));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stone, 64), new ItemStack(ModItems.pearcel_matter), new ItemStack(Blocks.cobblestone));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stonebrick, 64), new ItemStack(ModItems.pearcel_matter), new ItemStack(Blocks.stone));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.cobblestone, 111), new ItemStack(ModItems.pearcel_matter), new ItemStack(Items.water_bucket), new ItemStack(Items.lava_bucket), new ItemStack(Blocks.cobblestone));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.soul_sand, 64), new ItemStack(ModItems.pearcel_matter), new ItemStack(Items.ghast_tear), new ItemStack(Blocks.netherrack));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.saddle), new ItemStack(ModItems.pearcel_matter), new ItemStack(Items.leather), new ItemStack(Items.leather), new ItemStack(Items.iron_ingot));
    }
    
}
