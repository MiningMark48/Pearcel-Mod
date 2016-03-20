package com.miningmark48.pearcelmod.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreDict {

    public static void init(){
        OreDictionary.registerOre("plankWood", new ItemStack(ModBlocks.pearcelPlanks));
        OreDictionary.registerOre("stickWood", new ItemStack(ModItems.pearcelStick));
        OreDictionary.registerOre("logWood", new ItemStack(ModBlocks.blockLog));
        OreDictionary.registerOre("treeLeaves", new ItemStack(ModBlocks.blockLeaf));
        OreDictionary.registerOre("blockGlass", new ItemStack(ModBlocks.pearcelGlass));
        OreDictionary.registerOre("paneGlass", new ItemStack(ModBlocks.pearcelGlassPane));
        OreDictionary.registerOre("blockEndStone", new ItemStack(ModBlocks.pearcelEndStone));
    }

}
