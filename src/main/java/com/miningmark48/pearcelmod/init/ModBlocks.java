package com.miningmark48.pearcelmod.init;

import com.miningmark48.pearcelmod.block.*;
import com.miningmark48.pearcelmod.creativetabs.CreativeTabPearcelMod;
import com.miningmark48.pearcelmod.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockPressurePlate;
import net.minecraft.block.material.MapColor;
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
    public static Block pearcel_cobblestone;
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
    public static Block pearcel_lamp;
    public static Block lit_pearcel_lamp;
    public static Block ender_pearcel_block;
    public static Block pearcel_ingot_block;
    public static Block pearcel_plush;
    public static Block pearcel_fence;
    public static Block pearcel_fence2;

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
    public static Block pearcel_furnace;
    public static Block pearcel_furnace_lit;
    public static Block pearcel_beacon;
    public static Block pearcel_storage_crate;
    public static Block pearcel_pressure_plate;
    public static Block pearcel_spike;
    public static Block pearcel_spike_ender;
    public static Block pearcel_spike_guardian;

    public static void init(){
        //General
        pearcel_block = new BlockPearcelMod().setUnlocalizedName("pearcel_block").setRegistryName("pearcel_block").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_sand = new BlockPearcelModGravity(BlockPearcelModGravity.Type.SAND).setUnlocalizedName("pearcel_sand").setRegistryName("pearcel_sand").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_sandstone = new BlockPearcelMod().setUnlocalizedName("pearcel_sandstone").setRegistryName("pearcel_sandstone").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_matter_block = new BlockPearcelMod().setUnlocalizedName("pearcel_matter_block").setRegistryName("pearcel_matter_block").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_bricks = new BlockPearcelMod().setUnlocalizedName("pearcel_bricks").setRegistryName("pearcel_bricks").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        packed_pearcel_bricks = new BlockPearcelMod().setUnlocalizedName("packed_pearcel_bricks").setRegistryName("packed_pearcel_bricks").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_stone = new BlockPearcelStone().setUnlocalizedName("pearcel_stone").setRegistryName("pearcel_stone").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_cobblestone = new BlockPearcelStone().setUnlocalizedName("pearcel_cobblestone").setRegistryName("pearcel_cobblestone").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
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
        pearcel_lamp = new BlockPearcelLamp(false).setUnlocalizedName("pearcel_lamp").setRegistryName("pearcel_lamp").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        lit_pearcel_lamp = new BlockPearcelLamp(true).setUnlocalizedName("lit_pearcel_lamp").setRegistryName("lit_pearcel_lamp");
        ender_pearcel_block = new BlockPearcelMod().setUnlocalizedName("ender_pearcel_block").setRegistryName("ender_pearcel_block").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_ingot_block = new BlockPearcelBeaconBase().setUnlocalizedName("pearcel_ingot_block").setRegistryName("pearcel_ingot_block").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_plush = new BlockPearcelPlush().setUnlocalizedName("pearcel_plush").setRegistryName("pearcel_plush").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_fence = new BlockFence(Material.WOOD, MapColor.GREEN).setUnlocalizedName("pearcel_fence").setRegistryName("pearcel_fence").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_fence2 = new BlockFence(Material.ROCK, MapColor.GREEN).setUnlocalizedName("pearcel_fence2").setRegistryName("pearcel_fence2").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);

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
        pearcel_furnace = new BlockPearcelFurnace(false).setUnlocalizedName("pearcel_furnace").setRegistryName("pearcel_furnace");
        pearcel_furnace_lit = new BlockPearcelFurnace(true).setUnlocalizedName("pearcel_furnace_lit").setRegistryName("pearcel_furnace_lit");
        pearcel_beacon = new BlockPearcelBeacon().setUnlocalizedName("pearcel_beacon").setRegistryName("pearcel_beacon").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_storage_crate = new BlockPearcelStorageCrate().setUnlocalizedName("pearcel_storage_crate").setRegistryName("pearcel_storage_crate").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_pressure_plate = new BlockPearcelPressurePlate().setUnlocalizedName("pearcel_pressure_plate").setRegistryName("pearcel_pressure_plate").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_spike = new BlockPearcelSpike(2.0F).setUnlocalizedName("pearcel_spike").setRegistryName("pearcel_spike").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_spike_ender = new BlockPearcelSpike(6.25F).setUnlocalizedName("pearcel_spike_ender").setRegistryName("pearcel_spike_ender").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_spike_guardian = new BlockPearcelSpike(Float.MAX_VALUE).setUnlocalizedName("pearcel_spike_guardian").setRegistryName("pearcel_spike_guardian").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);

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
        registerBlock(pearcel_cobblestone);
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
        registerBlock(pearcel_lamp);
        registerBlock(lit_pearcel_lamp);
        registerBlock(ender_pearcel_block);
        registerBlock(pearcel_ingot_block);
        registerBlock(pearcel_plush);
        registerBlock(pearcel_fence);
        registerBlock(pearcel_fence2);

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
        registerBlock(pearcel_beacon);
        registerBlock(pearcel_storage_crate);
        registerBlock(pearcel_pressure_plate);
        registerBlock(pearcel_spike);
        registerBlock(pearcel_spike_ender);
        registerBlock(pearcel_spike_guardian);
        registerBlock(pearcel_furnace);
        registerBlock(pearcel_furnace_lit);

    }

    public static void registerRenders(){
        //General
        registerRender(pearcel_block);
        registerRender(pearcel_sand);
        registerRender(pearcel_sandstone);
        registerRender(pearcel_matter_block);
        registerRender(pearcel_bricks);
        registerRender(packed_pearcel_bricks);
        registerRender(pearcel_cobblestone);
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
        registerRender(pearcel_lamp);
        registerRender(lit_pearcel_lamp);
        registerRender(ender_pearcel_block);
        registerRender(pearcel_ingot_block);
        registerRender(pearcel_plush);
        registerRender(pearcel_fence);
        registerRender(pearcel_fence2);

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
        registerRender(pearcel_furnace);
        registerRender(pearcel_furnace_lit);
        registerRender(pearcel_beacon);
        registerRender(pearcel_storage_crate);
        registerRender(pearcel_pressure_plate);
        registerRender(pearcel_spike);
        registerRender(pearcel_spike_ender);
        registerRender(pearcel_spike_guardian);

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
