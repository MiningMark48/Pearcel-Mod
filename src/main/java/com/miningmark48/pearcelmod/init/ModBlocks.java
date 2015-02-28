package com.miningmark48.pearcelmod.init;

import com.miningmark48.pearcelmod.block.*;
import com.miningmark48.pearcelmod.creativetab.CreativeTabPearcelMod;
import com.miningmark48.pearcelmod.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class ModBlocks {

    //Plants
    public static final Block pearcelPlant = new BlockPearcelPlant().setBlockName("pearcelPlant").setBlockTextureName(Reference.MOD_ID + ":pearcelPlant");
    public static final Block compressedSugarCanePlant = new BlockCompressedSugarCanePlant().setBlockName("compressedSugarCanePlant").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setBlockTextureName(Reference.MOD_ID + ":compressedSugarCanePlant");

    //General blocks
	public static final Block meBlock = new BlockMEBlock().setBlockName("meBlock").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setLightLevel(0.5f).setBlockTextureName(Reference.MOD_ID + ":meBlock").setHardness(1.6F).setResistance(1.6F);
	public static final Block pearcelOre = new BlockPearcelOre().setBlockName("pearcelOre").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setBlockTextureName(Reference.MOD_ID + ":pearcelOre").setHardness(1.2F).setResistance(1.2F);
    public static final Block netherPearcelOre = new BlockPearcelOre().setBlockName("netherPearcelOre").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setBlockTextureName(Reference.MOD_ID + ":netherPearcelOre").setHardness(1.0F).setResistance(1.0F);
	public static final Block meGlass = new BlockMEGlass().setBlockName("meGlass").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setLightLevel(0.2f).setBlockTextureName(Reference.MOD_ID + ":meGlass").setHardness(0.5F).setResistance(2000.0F);
    public static final Block meLamp = new BlockMELamp().setBlockName("meLamp").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setLightLevel(2.0F).setBlockTextureName(Reference.MOD_ID + ":meLamp").setHardness(0.5F).setResistance(0.5F);
    public static final Block meWorkbench = new BlockMEWorkbench().setBlockName("meWorkbench").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setBlockTextureName(Reference.MOD_ID + ":meWorkbench").setHardness(2.5F).setResistance(5.0F);
    public static final Block pearcelTorch = new BlockPearcelTorch().setBlockName("pearcelTorch").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setBlockTextureName(Reference.MOD_ID + ":pearcelTorch").setHardness(0.0F).setResistance(10.0F).setLightLevel(1.0F);
    public static final Block pearcelBlock = new BlockPearcelBlock().setBlockName("pearcelBlock").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setBlockTextureName(Reference.MOD_ID + ":pearcelBlock").setHardness(1.5F).setResistance(1.0F);

    //Compressed Blocks
    public static final Block compressedSugarCaneBlock = new BlockCompressedSugarCaneBlock().setBlockName("compressedSugarCaneBlock").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setBlockTextureName(Reference.MOD_ID + ":compressedSugarCaneBlock").setHardness(1.0F).setResistance(1.0F);
    public static final Block compressedSugarCaneBlock2 = new BlockCompressedSugarCaneBlock().setBlockName("compressedSugarCaneBlock2").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setBlockTextureName(Reference.MOD_ID + ":compressedSugarCaneBlock2").setHardness(1.2F).setResistance(1.1F);
    public static final Block compressedSugarCaneBlock3 = new BlockCompressedSugarCaneBlock().setBlockName("compressedSugarCaneBlock3").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setBlockTextureName(Reference.MOD_ID + ":compressedSugarCaneBlock3").setHardness(1.4F).setResistance(1.2F);
    public static final Block compressedSugarCaneBlock4 = new BlockCompressedSugarCaneBlock().setBlockName("compressedSugarCaneBlock4").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setBlockTextureName(Reference.MOD_ID + ":compressedSugarCaneBlock4").setHardness(1.6F).setResistance(1.3F);
    public static final Block compressedSugarCaneBlock5 = new BlockCompressedSugarCaneBlock().setBlockName("compressedSugarCaneBlock5").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setBlockTextureName(Reference.MOD_ID + ":compressedSugarCaneBlock5").setHardness(1.8F).setResistance(1.4F);
    public static final Block compressedSugarCaneBlock6 = new BlockCompressedSugarCaneBlock().setBlockName("compressedSugarCaneBlock6").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setBlockTextureName(Reference.MOD_ID + ":compressedSugarCaneBlock6").setHardness(2.0F).setResistance(1.5F);
    public static final Block compressedSugarCaneBlock7 = new BlockCompressedSugarCaneBlock().setBlockName("compressedSugarCaneBlock7").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setBlockTextureName(Reference.MOD_ID + ":compressedSugarCaneBlock7").setHardness(2.2F).setResistance(1.6F);
    public static final Block compressedSugarCaneBlock8 = new BlockCompressedSugarCaneBlock().setBlockName("compressedSugarCaneBlock8").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setBlockTextureName(Reference.MOD_ID + ":compressedSugarCaneBlock8").setHardness(2.4F).setResistance(1.7F);


	public static void init(){
		
		GameRegistry.registerBlock(meBlock, "meBlock");
        GameRegistry.registerBlock(pearcelBlock, "pearcelBlock");
		GameRegistry.registerBlock(pearcelOre, "pearcelOre");
        GameRegistry.registerBlock(netherPearcelOre, "netherPearcelOre");
		GameRegistry.registerBlock(meGlass, "meGlass");
        GameRegistry.registerBlock(meLamp, "meLamp");
        GameRegistry.registerBlock(meWorkbench, "meWorkbench");
        GameRegistry.registerBlock(pearcelTorch, "pearcelTorch");
        GameRegistry.registerBlock(pearcelPlant, "pearcelPlant");
        GameRegistry.registerBlock(compressedSugarCanePlant, "compressedSugarCanePlant");
        GameRegistry.registerBlock(compressedSugarCaneBlock, "compressedSugarCaneBlock");
        GameRegistry.registerBlock(compressedSugarCaneBlock2, "compressedSugarCaneBlock2");
        GameRegistry.registerBlock(compressedSugarCaneBlock3, "compressedSugarCaneBlock3");
        GameRegistry.registerBlock(compressedSugarCaneBlock4, "compressedSugarCaneBlock4");
        GameRegistry.registerBlock(compressedSugarCaneBlock5, "compressedSugarCaneBlock5");
        GameRegistry.registerBlock(compressedSugarCaneBlock6, "compressedSugarCaneBlock6");
        GameRegistry.registerBlock(compressedSugarCaneBlock7, "compressedSugarCaneBlock7");
        GameRegistry.registerBlock(compressedSugarCaneBlock8, "compressedSugarCaneBlock8");
		
	}
	
}
