package com.miningmark48.pearcelmod.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreDict {

    public static void init(){
        OreDictionary.registerOre("plankWood", new ItemStack(ModBlocks.pearcelPlanks));
        OreDictionary.registerOre("stickWood", new ItemStack(ModItems.pearcelStick));
        OreDictionary.registerOre("logWood", new ItemStack(ModBlocks.blockLog));
    }

}
