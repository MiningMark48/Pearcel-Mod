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
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel_pie), new ItemStack(ModItems.pearcel_flour), new ItemStack(ModItems.pearcel_item), new ItemStack(Items.EGG));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel_sandwich), new ItemStack(ModItems.pearcel_item), new ItemStack(ModItems.pearcel_bread), new ItemStack(Items.SUGAR));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel_item, 9), new ItemStack(ModBlocks.pearcel_block));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel_juice_bottle), new ItemStack(Items.GLASS_BOTTLE), new ItemStack(ModItems.pearcel_item), new ItemStack(Items.SUGAR));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel_cookie, 12), new ItemStack(Items.EGG), new ItemStack(ModItems.pearcel_flour), new ItemStack(Items.SUGAR), new ItemStack(Items.MILK_BUCKET));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel_beef, 2), new ItemStack(ModItems.pearcel_item), new ItemStack(Items.BEEF));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel_ingot), new ItemStack(ModItems.pearcel_item), new ItemStack(Items.IRON_INGOT));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_stick, 6), "x", "x", 'x', new ItemStack(ModItems.pearcel_item));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_stick, 4), "x", "x", 'x', new ItemStack(ModBlocks.pearcel_planks));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_flour, 6), "xyx", 'x', new ItemStack(ModItems.pearcel_item), 'y', new ItemStack(Items.BREAD));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_bread, 3), "xxx", 'x', new ItemStack(ModItems.pearcel_flour));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_cookie, 4), " x ", "xyx", " x ", 'x', new ItemStack(ModItems.pearcel_item), 'y', new ItemStack(Items.COOKIE));
        GameRegistry.addRecipe(new ItemStack(ModItems.armor_plating, 8), "xyx", "yzy", "xyx", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(Items.IRON_INGOT), 'z', new ItemStack(ModItems.tier_2_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.tier_1_crafting_component, 4), "xyx", "yzy", "xyx", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(Items.REDSTONE), 'z', new ItemStack(ModItems.pearcel_item));
        GameRegistry.addRecipe(new ItemStack(ModItems.tier_2_crafting_component, 4), "xyx", "yzy", "xyx", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(Items.IRON_INGOT), 'z', new ItemStack(ModItems.pearcel_item));
        GameRegistry.addRecipe(new ItemStack(ModItems.tier_3_crafting_component, 4), "xyx", "yzy", "xyx", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(Items.DIAMOND), 'z', new ItemStack(ModItems.pearcel_item));
        GameRegistry.addRecipe(new ItemStack(ModItems.tier_4_crafting_component, 4), "xyx", "yzy", "xyx", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(Items.NETHER_STAR), 'z', new ItemStack(ModItems.pearcel_item));
        GameRegistry.addRecipe(new ItemStack(ModItems.tier_4_crafting_component, 1), "xyx", "aza", "xax", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(Items.NETHER_STAR), 'z', new ItemStack(ModItems.pearcel_item), 'a', new ItemStack(ModItems.tier_3_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.tier_3_crafting_component, 1), "xyx", "aza", "xax", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(Items.DIAMOND), 'z', new ItemStack(Items.PAPER), 'a', new ItemStack(ModItems.tier_2_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.tier_2_crafting_component, 1), "xyx", "aza", "xax", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(Items.IRON_INGOT), 'z', new ItemStack(Items.PAPER), 'a', new ItemStack(ModItems.tier_1_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.neutral_pearcel_matter, 4), "xyx", "yzy", "xyx", 'x', new ItemStack(Items.DIAMOND), 'y', new ItemStack(ModItems.pearcel_ingot), 'z', new ItemStack(ModItems.tier_2_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.neutral_pearcel_matter, 8), "xyx", "yzy", "xyx", 'x', new ItemStack(Items.DIAMOND), 'y', new ItemStack(ModItems.pearcel_ingot), 'z', new ItemStack(ModItems.tier_3_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.neutral_pearcel_matter, 16), "xyx", "yzy", "xyx", 'x', new ItemStack(Items.DIAMOND), 'y', new ItemStack(ModItems.pearcel_ingot), 'z', new ItemStack(ModItems.tier_4_crafting_component));

        //Tools and Weapons, Armor
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_sword), "x", "z", "y", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(ModItems.pearcel_stick), 'z', new ItemStack(ModItems.tier_2_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_pickaxe), "xzx", " y ", " y ", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(ModItems.pearcel_stick), 'z', new ItemStack(ModItems.tier_2_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_axe), "zx", "xy", " y", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(ModItems.pearcel_stick), 'z', new ItemStack(ModItems.tier_2_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_shovel), "x", "y", "z", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(ModItems.pearcel_stick), 'z', new ItemStack(ModItems.tier_2_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_hoe), "xz", " y", " y", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(ModItems.pearcel_stick), 'z', new ItemStack(ModItems.tier_2_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_shears), "  x", "yx ", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(ModItems.tier_1_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_bow), " xy", "z y", " xy", 'x', new ItemStack(ModItems.pearcel_stick), 'y', new ItemStack(Items.STRING), 'z', new ItemStack(ModItems.tier_3_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_arrow), "x", "y", "z", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(ModItems.pearcel_stick), 'z', new ItemStack(ModItems.tier_3_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.pcp), "zxa", "xyx", "axz", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(ModBlocks.pearcel_workbench), 'z', new ItemStack(ModItems.tier_1_crafting_component), 'a', new ItemStack(ModItems.pearcel_item));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_staff), "  x", "zy ", "bz ", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(ModItems.pearcel_stick), 'z', new ItemStack(ModItems.pearcel_matter), 'b', new ItemStack(ModItems.tier_3_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_helmet), "xyx", "y y", 'x', new ItemStack(ModItems.armor_plating), 'y', new ItemStack(ModItems.tier_2_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_chestplate), "y y", "xyx", "xxx", 'x', new ItemStack(ModItems.armor_plating), 'y', new ItemStack(ModItems.tier_2_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_leggings), "xyx", "x x", "y y", 'x', new ItemStack(ModItems.armor_plating), 'y', new ItemStack(ModItems.tier_2_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_boots), "y y", "xyx", 'x', new ItemStack(ModItems.armor_plating), 'y', new ItemStack(ModItems.tier_2_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.sap), "xab", "yzy", "bax", 'x', new ItemStack(Items.DIAMOND), 'y', new ItemStack(Items.EMERALD), 'z', new ItemStack(ModItems.tier_3_crafting_component), 'a', new ItemStack(Items.GOLD_INGOT), 'b', new ItemStack(ModItems.pearcel_item));
        GameRegistry.addRecipe(new ItemStack(ModItems.ender_pearcel, 6), "xyx", "yzy", "xyx", 'x', new ItemStack(ModItems.pearcel_item), 'y', new ItemStack(Items.ENDER_PEARL), 'z', new ItemStack(ModItems.tier_3_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.tp_pearcel), "xyx", "yzy", "xyx", 'x', new ItemStack(ModItems.pearcel_item), 'y', new ItemStack(Items.DIAMOND), 'z', new ItemStack(ModItems.ender_pearcel));
        GameRegistry.addRecipe(new ItemStack(ModItems.dragon_pearcel_staff), "xbx", "xyx", "zaz", 'x', new ItemStack(ModItems.tier_4_crafting_component), 'y', new ItemStack(ModItems.pearcel_staff), 'z', new ItemStack(ModItems.tier_3_crafting_component), 'a', new ItemStack(Blocks.DRAGON_EGG), 'b', new ItemStack(ModBlocks.tainted_pearcel));
        GameRegistry.addRecipe(new ItemStack(ModItems.pepc), "xyx", "aza", "yby", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(ModItems.tier_3_crafting_component), 'z', new ItemStack(Blocks.ENDER_CHEST), 'a', new ItemStack(ModItems.pearcel_item), 'b', new ItemStack(ModItems.ender_pearcel));
        GameRegistry.addRecipe(new ItemStack(ModItems.experience_pearcel), "xyx", "aba", "xzx", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(ModItems.tier_3_crafting_component), 'z', new ItemStack(Items.EMERALD), 'a', new ItemStack(Items.DIAMOND), 'b', new ItemStack(ModItems.pearcel_item));

        //Blocks
        GameRegistry.addSmelting(new ItemStack(ModBlocks.pearcel_sand), new ItemStack(ModBlocks.pearcel_glass), 5F);
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.distressed_pearcel_stone), new ItemStack(ModBlocks.pearcel_stone));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcel_torch, 4), "x", "y", 'x', new ItemStack(ModItems.pearcel_charcoal), 'y', new ItemStack(ModItems.pearcel_stick));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcel_block), "xxx", "xxx", "xxx", 'x', new ItemStack(ModItems.pearcel_item));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcel_workbench), "xx", "xx", 'x', new ItemStack(ModBlocks.pearcel_planks));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.torcher, 4), "xyx", "yzy", "xyx", 'x', new ItemStack(Blocks.TNT), 'y', new ItemStack(Blocks.TORCH), 'z', new ItemStack(ModItems.tier_2_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.torcher, 4), "xyx", "yzy", "xyx", 'y', new ItemStack(Blocks.TNT), 'x', new ItemStack(Blocks.TORCH), 'z', new ItemStack(ModItems.tier_2_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.summoner), "xyx", "yzy", "aba", 'x', new ItemStack(Items.DIAMOND), 'y', new ItemStack(Items.EMERALD), 'z', new ItemStack(ModItems.tier_3_crafting_component), 'a', new ItemStack(Items.GOLD_INGOT), 'b', new ItemStack(ModItems.pearcel_ingot));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcel_stonebricks, 4), "xx", "xx", 'x', new ItemStack(ModBlocks.polished_pearcel_stone));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcel_glass_pane, 16), "xxx", "xxx", 'x', new ItemStack(ModBlocks.pearcel_glass));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.polished_pearcel_stone, 8), "xx", "xx", 'x', new ItemStack(ModBlocks.pearcel_stone));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.packed_pearcel_bricks, 4), "xx", "xx", 'x', new ItemStack(ModBlocks.pearcel_stonebricks));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcel_bricks, 16), "xx", "xx", 'x', new ItemStack(ModBlocks.pearcel_block));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.irradiated_pearcel_block, 8), " x ", "xyx", " x ", 'x', new ItemStack(Items.GLOWSTONE_DUST), 'y', new ItemStack(ModBlocks.pearcel_block));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.tainted_pearcel, 16), " x ", "xyx", " x ", 'x', new ItemStack(Items.NETHER_WART), 'y', new ItemStack(ModBlocks.pearcel_stone));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcel_planks, 8), "xxx", "xyx", "xxx", 'x', new ItemStack(Blocks.PLANKS, 1, OreDictionary.WILDCARD_VALUE), 'y', new ItemStack(ModItems.pearcel_item));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcel_sand), " x ", "xyx", " x ", 'x', new ItemStack(Blocks.SAND, 4), 'y', new ItemStack(ModItems.pearcel_item));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcel_sandstone, 4), "xx", "xx", 'x', new ItemStack(ModBlocks.pearcel_sand));

        //Compressed Blocks/Items
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel_charcoal, 9), new ItemStack(ModBlocks.pearcel_charcoal_block));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcel_charcoal_block), "xxx", "xxx", "xxx", 'x', new ItemStack(ModItems.pearcel_charcoal));

        //Pearcel Matter Recipes
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel_matter, 2), new ItemStack(ModItems.neutral_pearcel_matter), new ItemStack(ModItems.tier_1_crafting_component));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel_matter, 4), new ItemStack(ModItems.neutral_pearcel_matter), new ItemStack(ModItems.tier_2_crafting_component));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel_matter, 6), new ItemStack(ModItems.neutral_pearcel_matter), new ItemStack(ModItems.tier_3_crafting_component));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel_matter, 8), new ItemStack(ModItems.neutral_pearcel_matter), new ItemStack(ModItems.tier_4_crafting_component));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel_matter, 9), new ItemStack(ModBlocks.pearcel_matter_block));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcel_matter_block), "xxx", "xxx", "xxx", 'x', new ItemStack(ModItems.pearcel_matter));

        GameRegistry.addRecipe(new ItemStack(Items.NETHER_STAR), " x ", "xyx", " x ", 'x', new ItemStack(ModItems.pearcel_matter), 'y', new ItemStack(ModBlocks.pearcel_matter_block));
        GameRegistry.addRecipe(new ItemStack(Items.COAL, 32), "x  ", " x ", " x ", 'x', new ItemStack(ModItems.pearcel_matter));
        GameRegistry.addRecipe(new ItemStack(Items.IRON_INGOT, 24), " x ", "x  ", "x  ", 'x', new ItemStack(ModItems.pearcel_matter));
        GameRegistry.addRecipe(new ItemStack(Items.GOLD_INGOT, 16), "x  ", "x  ", "  x", 'x', new ItemStack(ModItems.pearcel_matter));
        GameRegistry.addRecipe(new ItemStack(Items.DIAMOND, 8), "x  ", "x x", 'x', new ItemStack(ModItems.pearcel_matter));
        GameRegistry.addRecipe(new ItemStack(Items.EMERALD, 4), " xx", " x ", 'x', new ItemStack(ModItems.pearcel_matter));
        GameRegistry.addRecipe(new ItemStack(Items.REDSTONE, 16), "x x", "x x", 'x', new ItemStack(ModItems.pearcel_matter));
        GameRegistry.addRecipe(new ItemStack(Items.QUARTZ, 16), "x x", "x x", " x ", 'x', new ItemStack(ModItems.pearcel_matter));
        GameRegistry.addRecipe(new ItemStack(Items.BLAZE_ROD, 16), "x  ", " x ", "  x", 'x', new ItemStack(ModItems.pearcel_matter));
        GameRegistry.addRecipe(new ItemStack(Items.SLIME_BALL, 32), " x ", "x x", " x ", 'x', new ItemStack(ModItems.pearcel_matter));
        GameRegistry.addRecipe(new ItemStack(Items.EXPERIENCE_BOTTLE, 32), "xx ", "x  ", 'x', new ItemStack(ModItems.pearcel_matter));
        GameRegistry.addRecipe(new ItemStack(Items.GLOWSTONE_DUST, 32), "xx ", "  x", 'x', new ItemStack(ModItems.pearcel_matter));

        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.COAL_ORE, 8), new ItemStack(ModItems.pearcel_matter), new ItemStack(Items.SLIME_BALL), new ItemStack(Blocks.COAL_BLOCK));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.IRON_ORE, 8), new ItemStack(ModItems.pearcel_matter), new ItemStack(Items.SLIME_BALL), new ItemStack(Blocks.IRON_BLOCK));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.GOLD_ORE, 8), new ItemStack(ModItems.pearcel_matter), new ItemStack(Items.SLIME_BALL), new ItemStack(Blocks.GOLD_BLOCK));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.DIAMOND_ORE, 8), new ItemStack(ModItems.pearcel_matter), new ItemStack(Items.SLIME_BALL), new ItemStack(Blocks.DIAMOND_BLOCK));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.REDSTONE_ORE, 8), new ItemStack(ModItems.pearcel_matter), new ItemStack(Items.SLIME_BALL), new ItemStack(Blocks.REDSTONE_BLOCK));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.STONE, 64), new ItemStack(ModItems.pearcel_matter), new ItemStack(Blocks.COBBLESTONE));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.STONEBRICK, 64), new ItemStack(ModItems.pearcel_matter), new ItemStack(Blocks.STONE));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.COBBLESTONE, 111), new ItemStack(ModItems.pearcel_matter), new ItemStack(Items.WATER_BUCKET), new ItemStack(Items.LAVA_BUCKET), new ItemStack(Blocks.COBBLESTONE));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.SOUL_SAND, 48), new ItemStack(ModItems.pearcel_matter), new ItemStack(Items.GHAST_TEAR), new ItemStack(Blocks.NETHERRACK));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.SADDLE), new ItemStack(ModItems.pearcel_matter), new ItemStack(Items.LEATHER), new ItemStack(Items.LEATHER), new ItemStack(Items.IRON_INGOT));
    }
    
}
