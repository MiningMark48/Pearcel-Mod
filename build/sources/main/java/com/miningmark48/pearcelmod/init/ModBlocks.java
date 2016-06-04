package com.miningmark48.pearcelmod.init;

import com.miningmark48.pearcelmod.block.*;
import com.miningmark48.pearcelmod.creativetabs.CreativeTabPearcelMod;
import com.miningmark48.pearcelmod.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {

    //General
    public static Block pearcel_block;
    public static Block pearcel_sand;
    public static Block pearcel_sandstone;
    public static Block pearcel_matter_block;
    public static Block pearcel_bricks;
    public static Block packed_pearcel_bricks;
    public static Block pearcel_stone;
    public static Block pearcel_glass;
    public static Block distressed_pearcel_stone;
    public static Block irradiated_pearcel_block;
    public static Block polished_pearcel_stone;
    public static Block pearcel_stonebricks;
    public static Block tainted_pearcel;
    public static Block pearcel_torch;
    public static Block pearcel_planks;
    public static Block pearcel_end_stone;
    public static Block pearcel_charcoal_block;

    //Ores
    public static Block pearcel_ore;
    public static Block nether_pearcel_ore;
    public static Block ender_pearcel_ore;
    public static Block pearcel_matter_ore;
    public static Block dense_pearcel_ore;
    public static Block dense_pearcel_matter_ore;
    public static Block fools_pearcel_ore;

    //Functional
    public static Block pearcel_workbench;
    public static Block torcher;
    public static Block summoner;

    public static void init(){
        //General
        pearcel_block = new BlockPearcelMod().setUnlocalizedName("pearcel_block").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_sand = new BlockPearcelModGravity().setUnlocalizedName("pearcel_sand").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_sandstone = new BlockPearcelMod().setUnlocalizedName("pearcel_sandstone").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_matter_block = new BlockPearcelMod().setUnlocalizedName("pearcel_matter_block").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_bricks = new BlockPearcelMod().setUnlocalizedName("pearcel_bricks").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        packed_pearcel_bricks = new BlockPearcelMod().setUnlocalizedName("packed_pearcel_bricks").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_stone = new BlockPearcelMod().setUnlocalizedName("pearcel_stone").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_glass = new BlockPearcelModTransparent().setUnlocalizedName("pearcel_glass").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        distressed_pearcel_stone = new BlockPearcelMod().setUnlocalizedName("distressed_pearcel_stone").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        irradiated_pearcel_block = new BlockPearcelModLightEmit(5.0F).setUnlocalizedName("irradiated_pearcel_block").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        polished_pearcel_stone = new BlockPearcelMod().setUnlocalizedName("polished_pearcel_stone").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_stonebricks = new BlockPearcelMod().setUnlocalizedName("pearcel_stonebricks").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        tainted_pearcel = new BlockPearcelMod().setUnlocalizedName("tainted_pearcel").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_torch = new BlockPearcelTorch().setUnlocalizedName("pearcel_torch").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_planks = new BlockPearcelModWood().setUnlocalizedName("pearcel_planks").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_end_stone = new BlockPearcelMod().setUnlocalizedName("pearcel_end_stone").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_charcoal_block = new BlockPearcelMod().setUnlocalizedName("pearcel_charcoal_block").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);

        //Ores
        pearcel_ore = new BlockPearcelMod().setUnlocalizedName("pearcel_ore").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        nether_pearcel_ore = new BlockPearcelMod().setUnlocalizedName("nether_pearcel_ore").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        ender_pearcel_ore = new BlockPearcelMod().setUnlocalizedName("ender_pearcel_ore").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_matter_ore = new BlockPearcelMod().setUnlocalizedName("pearcel_matter_ore").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        dense_pearcel_ore = new BlockPearcelMod().setUnlocalizedName("dense_pearcel_ore").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        dense_pearcel_matter_ore = new BlockPearcelMod().setUnlocalizedName("dense_pearcel_matter_ore").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        fools_pearcel_ore = new BlockFoolsPearcelOre().setUnlocalizedName("fools_pearcel_ore").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);

        //Functional
        pearcel_workbench = new BlockPearcelWorkbench().setUnlocalizedName("pearcel_workbench").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        torcher = new BlockTorcher().setUnlocalizedName("torcher").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        summoner = new BlockSummoner().setUnlocalizedName("summoner").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);

    }

    public static void register(){
        //General
        GameRegistry.registerBlock(pearcel_block, pearcel_block.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(pearcel_sand, pearcel_sand.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(pearcel_sandstone, pearcel_sandstone.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(pearcel_matter_block, pearcel_matter_block.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(pearcel_bricks, pearcel_bricks.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(packed_pearcel_bricks, packed_pearcel_bricks.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(pearcel_stone, pearcel_stone.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(pearcel_glass, pearcel_glass.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(distressed_pearcel_stone, distressed_pearcel_stone.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(irradiated_pearcel_block, irradiated_pearcel_block.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(polished_pearcel_stone, polished_pearcel_stone.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(pearcel_stonebricks, pearcel_stonebricks.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(tainted_pearcel, tainted_pearcel.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(pearcel_torch, pearcel_torch.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(pearcel_planks, pearcel_planks.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(pearcel_end_stone, pearcel_end_stone.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(pearcel_charcoal_block, pearcel_charcoal_block.getUnlocalizedName().substring(5));

        //Ores
        GameRegistry.registerBlock(pearcel_ore, pearcel_ore.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(nether_pearcel_ore, nether_pearcel_ore.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(ender_pearcel_ore, ender_pearcel_ore.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(pearcel_matter_ore, pearcel_matter_ore.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(dense_pearcel_ore, dense_pearcel_ore.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(dense_pearcel_matter_ore, dense_pearcel_matter_ore.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(fools_pearcel_ore, fools_pearcel_ore.getUnlocalizedName().substring(5));

        //Functional
        GameRegistry.registerBlock(pearcel_workbench, pearcel_workbench.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(torcher, torcher.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(summoner, summoner.getUnlocalizedName().substring(5));

    }

    public static void registerRenders(){
        //General
        registerRender(pearcel_block);
        registerRender(pearcel_sand);
        registerRender(pearcel_sandstone);
        registerRender(pearcel_matter_block);
        registerRender(pearcel_bricks);
        registerRender(packed_pearcel_bricks);
        registerRender(pearcel_stone);
        registerRender(pearcel_glass);
        registerRender(distressed_pearcel_stone);
        registerRender(irradiated_pearcel_block);
        registerRender(polished_pearcel_stone);
        registerRender(pearcel_stonebricks);
        registerRender(tainted_pearcel);
        registerRender(pearcel_torch);
        registerRender(pearcel_planks);
        registerRender(pearcel_end_stone);
        registerRender(pearcel_charcoal_block);

        //Ores
        registerRender(pearcel_ore);
        registerRender(nether_pearcel_ore);
        registerRender(ender_pearcel_ore);
        registerRender(pearcel_matter_ore);
        registerRender(dense_pearcel_ore);
        registerRender(dense_pearcel_matter_ore);
        registerRender(fools_pearcel_ore);

        //Functional
        registerRender(pearcel_workbench);
        registerRender(torcher);
        registerRender(summoner);

    }

    public static void registerRender(Block block){
        Item item = Item.getItemFromBlock(block);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }

}
