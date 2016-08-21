package com.miningmark48.pearcelmod.init;

import com.miningmark48.pearcelmod.block.*;
import com.miningmark48.pearcelmod.creativetabs.CreativeTabPearcelMod;
import com.miningmark48.pearcelmod.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
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
    public static Block pedestal;
    public static Block pearcel_ladder;

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
        pearcel_block = new BlockPearcelMod().setUnlocalizedName("pearcel_block").setRegistryName("pearcel_block").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_sand = new BlockPearcelModGravity().setUnlocalizedName("pearcel_sand").setRegistryName("pearcel_sand").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_sandstone = new BlockPearcelMod().setUnlocalizedName("pearcel_sandstone").setRegistryName("pearcel_sandstone").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_matter_block = new BlockPearcelMod().setUnlocalizedName("pearcel_matter_block").setRegistryName("pearcel_matter_block").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_bricks = new BlockPearcelMod().setUnlocalizedName("pearcel_bricks").setRegistryName("pearcel_bricks").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        packed_pearcel_bricks = new BlockPearcelMod().setUnlocalizedName("packed_pearcel_bricks").setRegistryName("packed_pearcel_bricks").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_stone = new BlockPearcelMod().setUnlocalizedName("pearcel_stone").setRegistryName("pearcel_stone").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_glass = new BlockPearcelModTransparent().setUnlocalizedName("pearcel_glass").setRegistryName("pearcel_glass").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        distressed_pearcel_stone = new BlockPearcelMod().setUnlocalizedName("distressed_pearcel_stone").setRegistryName("distressed_pearcel_stone").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        irradiated_pearcel_block = new BlockPearcelModLightEmit(5.0F).setUnlocalizedName("irradiated_pearcel_block").setRegistryName("irradiated_pearcel_block").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        polished_pearcel_stone = new BlockPearcelMod().setUnlocalizedName("polished_pearcel_stone").setRegistryName("polished_pearcel_stone").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_stonebricks = new BlockPearcelMod().setUnlocalizedName("pearcel_stonebricks").setRegistryName("pearcel_stonebricks").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        tainted_pearcel = new BlockPearcelMod().setUnlocalizedName("tainted_pearcel").setRegistryName("tainted_pearcel").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_torch = new BlockPearcelTorch().setUnlocalizedName("pearcel_torch").setRegistryName("pearcel_torch").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_planks = new BlockPearcelModWood().setUnlocalizedName("pearcel_planks").setRegistryName("pearcel_planks").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_end_stone = new BlockPearcelMod().setUnlocalizedName("pearcel_end_stone").setRegistryName("pearcel_end_stone").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_charcoal_block = new BlockPearcelMod().setUnlocalizedName("pearcel_charcoal_block").setRegistryName("pearcel_charcoal_block").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_glass_pane = new BlockPearcelPane(Material.GLASS, true).setUnlocalizedName("pearcel_glass_pane").setRegistryName("pearcel_glass_pane").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pedestal = new BlockPedestal().setUnlocalizedName("pedestal").setRegistryName("pedestal").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_ladder = new BlockPearceLadder().setUnlocalizedName("pearcel_ladder").setRegistryName("pearcel_ladder").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);

        //Ores
        pearcel_ore = new BlockPearcelMod().setUnlocalizedName("pearcel_ore").setRegistryName("pearcel_ore").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        nether_pearcel_ore = new BlockPearcelMod().setUnlocalizedName("nether_pearcel_ore").setRegistryName("nether_pearcel_ore").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        ender_pearcel_ore = new BlockPearcelMod().setUnlocalizedName("ender_pearcel_ore").setRegistryName("ender_pearcel_ore").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_matter_ore = new BlockPearcelMod().setUnlocalizedName("pearcel_matter_ore").setRegistryName("pearcel_matter_ore").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        dense_pearcel_ore = new BlockPearcelMod().setUnlocalizedName("dense_pearcel_ore").setRegistryName("dense_pearcel_ore").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        dense_pearcel_matter_ore = new BlockPearcelMod().setUnlocalizedName("dense_pearcel_matter_ore").setRegistryName("dense_pearcel_matter_ore").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        fools_pearcel_ore = new BlockFoolsPearcelOre().setUnlocalizedName("fools_pearcel_ore").setRegistryName("fools_pearcel_ore").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);

        //Functional
        pearcel_workbench = new BlockPearcelWorkbench().setUnlocalizedName("pearcel_workbench").setRegistryName("pearcel_workbench").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        torcher = new BlockTorcher().setUnlocalizedName("torcher").setRegistryName("torcher").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        summoner = new BlockSummoner().setUnlocalizedName("summoner").setRegistryName("summoner").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);


    }

    public static void register(){
        //General
        registerBlock(pearcel_block);
        registerBlock(pearcel_sand);
        registerBlock(pearcel_sandstone);
        registerBlock(pearcel_matter_block);
        registerBlock(pearcel_bricks);
        registerBlock(packed_pearcel_bricks);
        registerBlock(pearcel_stone);
        registerBlock(pearcel_glass);
        registerBlock(distressed_pearcel_stone);
        registerBlock(irradiated_pearcel_block);
        registerBlock(polished_pearcel_stone);
        registerBlock(pearcel_stonebricks);
        registerBlock(tainted_pearcel);
        registerBlock(pearcel_torch);
        registerBlock(pearcel_planks);
        registerBlock(pearcel_end_stone);
        registerBlock(pearcel_charcoal_block);
        registerBlock(pearcel_glass_pane);
        registerBlock(pedestal);
        registerBlock(pearcel_ladder);

        //Ores
        registerBlock(pearcel_ore);
        registerBlock(nether_pearcel_ore);
        registerBlock(ender_pearcel_ore);
        registerBlock(pearcel_matter_ore);
        registerBlock(dense_pearcel_ore);
        registerBlock(dense_pearcel_matter_ore);
        registerBlock(fools_pearcel_ore);

        //Functional
        registerBlock(pearcel_workbench);
        registerBlock(torcher);
        registerBlock(summoner);

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
        registerRender(pedestal);
        registerRender(pearcel_ladder);

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
    
    private static void registerBlock(Block block){
        GameRegistry.register(block);
        ItemBlock item = new ItemBlock(block);
        item.setRegistryName(block.getRegistryName());
        GameRegistry.register(item);
    }

    public static void registerRender(Block block){
        Item item = Item.getItemFromBlock(block);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + block.getUnlocalizedName().substring(5), "inventory"));
    }

}
