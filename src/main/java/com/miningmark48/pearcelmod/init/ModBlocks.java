package com.miningmark48.pearcelmod.init;

import com.miningmark48.pearcelmod.biome.PMLeaf;
import com.miningmark48.pearcelmod.biome.PMLog;
import com.miningmark48.pearcelmod.biome.PMSapling;
import com.miningmark48.pearcelmod.block.*;
import com.miningmark48.pearcelmod.creativetab.CreativeTabPearcelMod;
import com.miningmark48.pearcelmod.item.ItemLeafBlocks;
import com.miningmark48.pearcelmod.item.ItemLogBlocks;
import com.miningmark48.pearcelmod.item.ItemSaplingBlocks;
import com.miningmark48.pearcelmod.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;

public class ModBlocks {

    //Plants
    public static final Block pearcelPlant = new BlockPearcelPlant().setBlockName("pearcelPlant").setBlockTextureName(Reference.MOD_ID + ":pearcelPlant");
    public static final Block blockLog = new PMLog().setBlockName("blockLog").setBlockTextureName(Reference.MOD_ID + ":blockLog").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Block blockLeaf = new PMLeaf().setBlockName("blockLeaf").setBlockTextureName(Reference.MOD_ID + ":blockLeaf").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Block blockSapling = new PMSapling().setBlockName("blockSapling").setBlockTextureName(Reference.MOD_ID + ":blockSapling").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    //Ore
    public static final Block pearcelOre = new BlockPearcelOre().setBlockName("pearcelOre").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setBlockTextureName(Reference.MOD_ID + ":pearcelOre").setHardness(1.2F).setResistance(1.2F);
    public static final Block netherPearcelOre = new BlockPearcelOre().setBlockName("netherPearcelOre").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setBlockTextureName(Reference.MOD_ID + ":netherPearcelOre").setHardness(1.0F).setResistance(1.0F);
    //Models
    public static final Block pearcelPainting = new BlockPearcelPainting(Material.cloth).setBlockName("pearcelPainting").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setHardness(0.2F).setResistance(0.1F);
    //General blocks
	public static final Block meBlock = new BlockMEBlock().setBlockName("meBlock").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setLightLevel(0.5f).setBlockTextureName(Reference.MOD_ID + ":meBlock").setHardness(1.6F).setResistance(1.6F);
	public static final Block meGlass = new BlockMEGlass().setBlockName("meGlass").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setLightLevel(0.2f).setBlockTextureName(Reference.MOD_ID + ":meGlass").setHardness(0.5F).setResistance(99999.9F);
    public static final Block meLamp = new BlockMELamp().setBlockName("meLamp").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setLightLevel(2.0F).setBlockTextureName(Reference.MOD_ID + ":meLamp").setHardness(0.5F).setResistance(99999.9F);
    public static final Block meWorkbench = new BlockMEWorkbench().setBlockName("meWorkbench").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setBlockTextureName(Reference.MOD_ID + ":meWorkbench").setHardness(2.5F).setResistance(5.0F);
    public static final Block ivet = new BlockIVET().setBlockName("ivet").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setBlockTextureName(Reference.MOD_ID + ":ivet").setHardness(1.0F).setResistance(1000.0F);
    public static final Block pearcelTorch = new BlockPearcelTorch().setBlockName("pearcelTorch").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setBlockTextureName(Reference.MOD_ID + ":pearcelTorch").setHardness(0.0F).setResistance(10.0F).setLightLevel(1.0F);
    public static final Block pearcelBlock = new BlockPearcelBlock().setBlockName("pearcelBlock").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setBlockTextureName(Reference.MOD_ID + ":pearcelBlock").setHardness(1.5F).setResistance(10.0F);
    public static final Block bedrockGlass = new BlockBedrockGlass().setBlockName("bedrockGlass").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setBlockTextureName(Reference.MOD_ID + ":bedrockGlass").setBlockUnbreakable().setResistance(99999.9F);
    public static final Block meMatterBlock = new BlockMEMatter().setBlockName("meMatterBlock").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setBlockTextureName(Reference.MOD_ID + ":meMatterBlock").setHardness(0.6F).setResistance(1.0F);
    public static final Block pearcelTNT = new BlockPearcelTNT().setBlockName("pearcelTNT").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setBlockTextureName(Reference.MOD_ID + ":pearcelTNT").setHardness(0.3F).setResistance(1.5F);
    public static final Block barrier = new BlockBarrier().setBlockName("barrier").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setBlockTextureName(Reference.MOD_ID + ":barrier").setBlockUnbreakable().setResistance(99999.9F);
    public static final Block pearcelMelonBlock = new BlockPearcelMelon().setBlockName("pearcelMelonBlock").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setBlockTextureName(Reference.MOD_ID + ":pearcelMelon_Side").setHardness(0.5F).setResistance(1.5F);
    public static final Block pearcelEndStone = new BlockPearcelEndStone().setBlockName("pearcelEndStone").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setBlockTextureName(Reference.MOD_ID + ":pearcelEndStone");
    public static final Block pearcelPortal = new BlockPearcelPortal();
    public static final Block torcher = new BlockTorcher().setBlockName("torcher").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setBlockTextureName(Reference.MOD_ID + ":torcher");
    public static final Block summoner = new BlockSummoner().setBlockName("summoner").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setBlockTextureName(Reference.MOD_ID + ":summoner");
    public static final Block dragonInfusedPearcel = new BlockDragonInfusedPearcel().setBlockName("dragonInfusedPearcel").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setBlockTextureName(Reference.MOD_ID + ":dragonInfusedPearcel").setResistance(5.0F);
    public static final Block enderInfusedPearcel = new BlockPearcelMod(Material.rock).setBlockName("enderInfusedPearcel").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setBlockTextureName(Reference.MOD_ID + ":enderInfusedPearcel");
    public static final Block corruptedPearcelBlock = new BlockCorruptedPearcelBlock().setBlockName("corruptedPearcelBlock").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setBlockTextureName(Reference.MOD_ID + ":corruptedPearcelBlock").setResistance(2.0F);
    public static final Block netherInfusedPearcel = new BlockPearcelMod(Material.rock).setBlockName("netherInfusedPearcel").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setBlockTextureName(Reference.MOD_ID + ":netherInfusedPearcel");
    public static final Block witherInfusedPearcel = new BlockWitherInfusedPearcel().setBlockName("witherInfusedPearcel").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setBlockTextureName(Reference.MOD_ID + ":witherInfusedPearcel").setResistance(5.0F);
    public static final Block pearcelStone = new BlockPearcelMod().setBlockName("pearcelStone").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setBlockTextureName(Reference.MOD_ID + ":pearcelStone");
    public static final Block pearcelStonebricks = new BlockPearcelMod().setBlockName("pearcelStonebricks").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setBlockTextureName(Reference.MOD_ID + ":pearcelStonebricks");
    public static final Block pearcelPlanks = new BlockPlanks().setBlockName("pearcelPlanks").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setBlockTextureName(Reference.MOD_ID + ":pearcelPlanks");
    public static final Block pearcelCharcoalBlock = new BlockPearcelMod().setBlockName("pearcelCharcoalBlock").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setBlockTextureName(Reference.MOD_ID + ":pearcelCharcoalBlock");
    public static final Block mePlanks = new BlockPlanks().setBlockName("mePlanks").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setBlockTextureName(Reference.MOD_ID + ":mePlanks");
    public static final Block pearcelFence = new BlockFence(Reference.MOD_ID + ":pearcelPlanks", Material.wood).setHardness(2.0F).setResistance(5.5F).setBlockName("pearcelFence").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Block meGlassPane = new BlockPearcelPane(Reference.MOD_ID + ":meGlass", Reference.MOD_ID + ":meGlass", Material.glass, true).setBlockName("meGlassPane").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setResistance(9999.9F).setStepSound(Block.soundTypeGlass);
    public static final Block pearcelStairs = new BlockPStairs(ModBlocks.pearcelBlock, 0).setBlockName("pearcelStairs").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setBlockTextureName(Reference.MOD_ID + ":pearcelStairs");
    public static final Block pearcelWoodStairs = new BlockPStairs(ModBlocks.pearcelPlanks, 1).setBlockName("pearcelWoodStairs").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setBlockTextureName(Reference.MOD_ID + ":pearcelWoodStairs");

    //Fluids
    public static final Block pearcelFluid = new BlockPearcelFluid().setBlockName("pearcelFluid").setBlockTextureName(Reference.MOD_ID + ":pearcelFluid").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);


	public static void init(){

        //General Blocks
		GameRegistry.registerBlock(meBlock, "meBlock");
        GameRegistry.registerBlock(pearcelBlock, "pearcelBlock");
		GameRegistry.registerBlock(meGlass, "meGlass");
        GameRegistry.registerBlock(meLamp, "meLamp");
        GameRegistry.registerBlock(meWorkbench, "meWorkbench");
        GameRegistry.registerBlock(ivet, "ivet");
        GameRegistry.registerBlock(pearcelTorch, "pearcelTorch");
        GameRegistry.registerBlock(bedrockGlass, "bedrockGlass");
        GameRegistry.registerBlock(meMatterBlock, "meMatterBlock");
        GameRegistry.registerBlock(pearcelEndStone, "pearcelEndStone");
        GameRegistry.registerBlock(pearcelPortal, "pearcelPortal");
        GameRegistry.registerBlock(torcher, "torcher");
        GameRegistry.registerBlock(summoner, "summoner");
        GameRegistry.registerBlock(dragonInfusedPearcel, "dragonInfusedPearcel");
        GameRegistry.registerBlock(enderInfusedPearcel, "enderInfusedPearcel");
        //GameRegistry.registerBlock(pearcelTNT, "pearcelTNT");
        GameRegistry.registerBlock(barrier, "barrier");
        GameRegistry.registerBlock(pearcelMelonBlock, "pearcelMelonBlock");
        GameRegistry.registerBlock(corruptedPearcelBlock, "corruptedPearcelBlock");
        GameRegistry.registerBlock(netherInfusedPearcel, "netherInfusedPearcel");
        GameRegistry.registerBlock(witherInfusedPearcel, "witherInfusedPearcel");
        GameRegistry.registerBlock(pearcelStone, "pearcelStone");
        GameRegistry.registerBlock(pearcelStonebricks, "pearcelStonebricks");
        GameRegistry.registerBlock(pearcelPlanks, "pearcelPlanks");
        GameRegistry.registerBlock(pearcelCharcoalBlock, "pearcelCharcoalBlock");
        GameRegistry.registerBlock(mePlanks, "mePlanks");
        GameRegistry.registerBlock(pearcelFence, "pearcelFence");
        GameRegistry.registerBlock(meGlassPane, "meGlassPane");
        GameRegistry.registerBlock(pearcelStairs, "pearcelStairs");
        GameRegistry.registerBlock(pearcelWoodStairs, "pearcelWoodStairs");
        //Ores
        GameRegistry.registerBlock(pearcelOre, "pearcelOre");
        GameRegistry.registerBlock(netherPearcelOre, "netherPearcelOre");
        //Plants
        GameRegistry.registerBlock(pearcelPlant, "pearcelPlant");
        GameRegistry.registerBlock(blockLog, ItemLogBlocks.class, blockLog.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(blockLeaf, ItemLeafBlocks.class, blockLeaf.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(blockSapling, ItemSaplingBlocks.class, blockSapling.getUnlocalizedName().substring(5));
        //Models
        GameRegistry.registerBlock(pearcelPainting, "pearcelPainting");
        //Fluid
        GameRegistry.registerBlock(pearcelFluid, "pearcelFluid");
		
	}
	
}
