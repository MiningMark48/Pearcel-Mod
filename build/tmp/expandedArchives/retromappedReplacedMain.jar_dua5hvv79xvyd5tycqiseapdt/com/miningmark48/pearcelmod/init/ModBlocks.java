package com.miningmark48.pearcelmod.init;

import com.miningmark48.pearcelmod.block.*;
import com.miningmark48.pearcelmod.creativetabs.CreativeTabPearcelMod;
import com.miningmark48.pearcelmod.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
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
    public static Block pearcel_glass_pane;

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

    //Crops
    public static Block pearcel_crops;

    public static void init(){
        //General
        pearcel_block = new BlockPearcelMod().func_149663_c("pearcel_block").func_149647_a(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_sand = new BlockPearcelModGravity().func_149663_c("pearcel_sand").func_149647_a(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_sandstone = new BlockPearcelMod().func_149663_c("pearcel_sandstone").func_149647_a(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_matter_block = new BlockPearcelMod().func_149663_c("pearcel_matter_block").func_149647_a(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_bricks = new BlockPearcelMod().func_149663_c("pearcel_bricks").func_149647_a(CreativeTabPearcelMod.PearcelMod_TAB);
        packed_pearcel_bricks = new BlockPearcelMod().func_149663_c("packed_pearcel_bricks").func_149647_a(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_stone = new BlockPearcelMod().func_149663_c("pearcel_stone").func_149647_a(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_glass = new BlockPearcelModTransparent().func_149663_c("pearcel_glass").func_149647_a(CreativeTabPearcelMod.PearcelMod_TAB);
        distressed_pearcel_stone = new BlockPearcelMod().func_149663_c("distressed_pearcel_stone").func_149647_a(CreativeTabPearcelMod.PearcelMod_TAB);
        irradiated_pearcel_block = new BlockPearcelModLightEmit(5.0F).func_149663_c("irradiated_pearcel_block").func_149647_a(CreativeTabPearcelMod.PearcelMod_TAB);
        polished_pearcel_stone = new BlockPearcelMod().func_149663_c("polished_pearcel_stone").func_149647_a(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_stonebricks = new BlockPearcelMod().func_149663_c("pearcel_stonebricks").func_149647_a(CreativeTabPearcelMod.PearcelMod_TAB);
        tainted_pearcel = new BlockPearcelMod().func_149663_c("tainted_pearcel").func_149647_a(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_torch = new BlockPearcelTorch().func_149663_c("pearcel_torch").func_149647_a(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_planks = new BlockPearcelModWood().func_149663_c("pearcel_planks").func_149647_a(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_end_stone = new BlockPearcelMod().func_149663_c("pearcel_end_stone").func_149647_a(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_charcoal_block = new BlockPearcelMod().func_149663_c("pearcel_charcoal_block").func_149647_a(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_glass_pane = new BlockPearcelPane(Material.field_151592_s, true).func_149663_c("pearcel_glass_pane").func_149647_a(CreativeTabPearcelMod.PearcelMod_TAB);

        //Ores
        pearcel_ore = new BlockPearcelMod().func_149663_c("pearcel_ore").func_149647_a(CreativeTabPearcelMod.PearcelMod_TAB);
        nether_pearcel_ore = new BlockPearcelMod().func_149663_c("nether_pearcel_ore").func_149647_a(CreativeTabPearcelMod.PearcelMod_TAB);
        ender_pearcel_ore = new BlockPearcelMod().func_149663_c("ender_pearcel_ore").func_149647_a(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_matter_ore = new BlockPearcelMod().func_149663_c("pearcel_matter_ore").func_149647_a(CreativeTabPearcelMod.PearcelMod_TAB);
        dense_pearcel_ore = new BlockPearcelMod().func_149663_c("dense_pearcel_ore").func_149647_a(CreativeTabPearcelMod.PearcelMod_TAB);
        dense_pearcel_matter_ore = new BlockPearcelMod().func_149663_c("dense_pearcel_matter_ore").func_149647_a(CreativeTabPearcelMod.PearcelMod_TAB);
        fools_pearcel_ore = new BlockFoolsPearcelOre().func_149663_c("fools_pearcel_ore").func_149647_a(CreativeTabPearcelMod.PearcelMod_TAB);

        //Functional
        pearcel_workbench = new BlockPearcelWorkbench().func_149663_c("pearcel_workbench").func_149647_a(CreativeTabPearcelMod.PearcelMod_TAB);
        torcher = new BlockTorcher().func_149663_c("torcher").func_149647_a(CreativeTabPearcelMod.PearcelMod_TAB);
        summoner = new BlockSummoner().func_149663_c("summoner").func_149647_a(CreativeTabPearcelMod.PearcelMod_TAB);

        //Plants
        pearcel_crops = new BlockPearcelCrops().func_149663_c("pearcel_crops");

    }

    public static void register(){
        //General
        GameRegistry.registerBlock(pearcel_block, pearcel_block.func_149739_a().substring(5));
        GameRegistry.registerBlock(pearcel_sand, pearcel_sand.func_149739_a().substring(5));
        GameRegistry.registerBlock(pearcel_sandstone, pearcel_sandstone.func_149739_a().substring(5));
        GameRegistry.registerBlock(pearcel_matter_block, pearcel_matter_block.func_149739_a().substring(5));
        GameRegistry.registerBlock(pearcel_bricks, pearcel_bricks.func_149739_a().substring(5));
        GameRegistry.registerBlock(packed_pearcel_bricks, packed_pearcel_bricks.func_149739_a().substring(5));
        GameRegistry.registerBlock(pearcel_stone, pearcel_stone.func_149739_a().substring(5));
        GameRegistry.registerBlock(pearcel_glass, pearcel_glass.func_149739_a().substring(5));
        GameRegistry.registerBlock(distressed_pearcel_stone, distressed_pearcel_stone.func_149739_a().substring(5));
        GameRegistry.registerBlock(irradiated_pearcel_block, irradiated_pearcel_block.func_149739_a().substring(5));
        GameRegistry.registerBlock(polished_pearcel_stone, polished_pearcel_stone.func_149739_a().substring(5));
        GameRegistry.registerBlock(pearcel_stonebricks, pearcel_stonebricks.func_149739_a().substring(5));
        GameRegistry.registerBlock(tainted_pearcel, tainted_pearcel.func_149739_a().substring(5));
        GameRegistry.registerBlock(pearcel_torch, pearcel_torch.func_149739_a().substring(5));
        GameRegistry.registerBlock(pearcel_planks, pearcel_planks.func_149739_a().substring(5));
        GameRegistry.registerBlock(pearcel_end_stone, pearcel_end_stone.func_149739_a().substring(5));
        GameRegistry.registerBlock(pearcel_charcoal_block, pearcel_charcoal_block.func_149739_a().substring(5));
        GameRegistry.registerBlock(pearcel_glass_pane, pearcel_glass_pane.func_149739_a().substring(5));

        //Ores
        GameRegistry.registerBlock(pearcel_ore, pearcel_ore.func_149739_a().substring(5));
        GameRegistry.registerBlock(nether_pearcel_ore, nether_pearcel_ore.func_149739_a().substring(5));
        GameRegistry.registerBlock(ender_pearcel_ore, ender_pearcel_ore.func_149739_a().substring(5));
        GameRegistry.registerBlock(pearcel_matter_ore, pearcel_matter_ore.func_149739_a().substring(5));
        GameRegistry.registerBlock(dense_pearcel_ore, dense_pearcel_ore.func_149739_a().substring(5));
        GameRegistry.registerBlock(dense_pearcel_matter_ore, dense_pearcel_matter_ore.func_149739_a().substring(5));
        GameRegistry.registerBlock(fools_pearcel_ore, fools_pearcel_ore.func_149739_a().substring(5));

        //Functional
        GameRegistry.registerBlock(pearcel_workbench, pearcel_workbench.func_149739_a().substring(5));
        GameRegistry.registerBlock(torcher, torcher.func_149739_a().substring(5));
        GameRegistry.registerBlock(summoner, summoner.func_149739_a().substring(5));

        //Plant
        GameRegistry.registerBlock(pearcel_crops, pearcel_crops.func_149739_a().substring(5));

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
        registerRender(pearcel_glass_pane);

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

        //Plants
        registerRender(pearcel_crops);

    }

    public static void registerRender(Block block){
        Item item = Item.func_150898_a(block);
        Minecraft.func_71410_x().func_175599_af().func_175037_a().func_178086_a(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.func_77658_a().substring(5), "inventory"));
    }

}
