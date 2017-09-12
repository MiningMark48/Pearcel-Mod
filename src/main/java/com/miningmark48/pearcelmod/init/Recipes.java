package com.miningmark48.pearcelmod.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Recipes {
    
    public static void init(){
        //Smelting
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
            //Blocks
        GameRegistry.addSmelting(new ItemStack(ModBlocks.pearcel_sand), new ItemStack(ModBlocks.pearcel_glass), 5F);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.pearcel_cobblestone), new ItemStack(ModBlocks.pearcel_stone), 2f);
    }
    
}
