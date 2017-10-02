package com.miningmark48.pearcelmod.init;

import com.miningmark48.mininglib.base.item.ModItemBlock;
import com.miningmark48.pearcelmod.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.LinkedList;
import java.util.List;

public class ModRegistry {

    private static List<Item> itemsToRegister = new LinkedList<>();
    private static List<Block> blocksToRegister = new LinkedList<>();

    public static void init(){
        registerItems();
        registerBlocks();
    }

    private static void registerItems(){
        registerItem(ModItems.pearcel_manual);
        registerItem(ModItems.pearcel_item);
        registerItem(ModItems.pearcel_ingot);
        registerItem(ModItems.tier_1_crafting_component);
        registerItem(ModItems.tier_2_crafting_component);
        registerItem(ModItems.tier_3_crafting_component);
        registerItem(ModItems.tier_4_crafting_component);
        registerItem(ModItems.armor_plating);
        registerItem(ModItems.pearcel_flour);
        registerItem(ModItems.pearcel_stick);
        registerItem(ModItems.pearcel_charcoal);
        registerItem(ModItems.pearcel_matter);
        registerItem(ModItems.neutral_pearcel_matter);
        registerItem(ModItems.pearcel_arrow);
        registerItem(ModItems.pearcel_star);
        registerItem(ModItems.blood_drop);

        registerItem(ModItems.pearcel_bread);
        registerItem(ModItems.pearcel_pie);
        registerItem(ModItems.pearcel_beef);
        registerItem(ModItems.pearcel_steak);
        registerItem(ModItems.pearcel_cookie);
        registerItem(ModItems.pearcel_sandwich);
        registerItem(ModItems.pearcel_juice_bottle);
        registerItem(ModItems.pearcel_infinifood);
        registerItem(ModItems.golden_pearcel);
        registerItem(ModItems.jeweled_pearcel);
        registerItem(ModItems.glowing_pearcel);
        registerItem(ModItems.guardian_food);

        registerItem(ModItems.pearcel_sword);
        registerItem(ModItems.pearcel_pickaxe);
        registerItem(ModItems.pearcel_axe);
        registerItem(ModItems.pearcel_shovel);
        registerItem(ModItems.pearcel_hoe);
        registerItem(ModItems.pearcel_shears);
        registerItem(ModItems.experience_pearcel);
        registerItem(ModItems.tp_pearcel);
        registerItem(ModItems.sap);
        registerItem(ModItems.pepc);
        registerItem(ModItems.pearcel_helmet);
        registerItem(ModItems.pearcel_chestplate);
        registerItem(ModItems.pearcel_leggings);
        registerItem(ModItems.pearcel_boots);
        registerItem(ModItems.pearcel_staff);
        registerItem(ModItems.guardian_pearcel_staff);
        registerItem(ModItems.pcp);
        registerItem(ModItems.ender_pearcel);
        registerItem(ModItems.pearcel_bow);
        registerItem(ModItems.pearcel_stone_placer);
        registerItem(ModItems.reinforced_pearcel_pickaxe);
        registerItem(ModItems.reinforced_pearcel_shovel);
        registerItem(ModItems.pearcel_crook);
        registerItem(ModItems.matter_fabricator);
        registerItem(ModItems.stimulation_pearcel);
        registerItem(ModItems.rif_pearcel_helmet);
        registerItem(ModItems.rif_pearcel_chestplate);
        registerItem(ModItems.rif_pearcel_leggings);
        registerItem(ModItems.rif_pearcel_boots);
        registerItem(ModItems.pearcel_backpack);
        registerItem(ModItems.enlarged_pearcel_backpack);
        registerItem(ModItems.bindle);
        registerItem(ModItems.nullification_pearcel);
        registerItem(ModItems.pearcel_magnet);
        registerItem(ModItems.pearcel_magnet_advanced);
        registerItem(ModItems.living_magnet);
        registerItem(ModItems.sacrificial_pearcel);
        registerItem(ModItems.pearcel_blood_dagger);
        registerItem(ModItems.charmed_pearcel);
        registerItem(ModItems.charm_bag);
        registerItem(ModItems.slimey_pearcel);
        registerItem(ModItems.throw_pearcel_explosive);
        registerItem(ModItems.throw_pearcel_entity_tp);
        registerItem(ModItems.throw_pearcel_entity_firework);
        registerItem(ModItems.throw_pearcel_entity_mount);
        registerItem(ModItems.throw_pearcel_scatter);
    }

    private static void registerBlocks(){
        //General
        registerBlock(ModBlocks.pearcel_block);
        registerBlock(ModBlocks.pearcel_sand);
        registerBlock(ModBlocks.pearcel_sandstone);
        registerBlock(ModBlocks.pearcel_matter_block);
        registerBlock(ModBlocks.pearcel_bricks);
        registerBlock(ModBlocks.packed_pearcel_bricks);
        registerBlock(ModBlocks.pearcel_stone);
        registerBlock(ModBlocks.pearcel_cobblestone);
        registerBlock(ModBlocks.pearcel_glass);
        registerBlock(ModBlocks.distressed_pearcel_stone);
        registerBlock(ModBlocks.irradiated_pearcel_block);
        registerBlock(ModBlocks.polished_pearcel_stone);
        registerBlock(ModBlocks.pearcel_stonebricks);
        registerBlock(ModBlocks.tainted_pearcel);
        registerBlock(ModBlocks.pearcel_torch);
        registerBlock(ModBlocks.pearcel_planks);
        registerBlock(ModBlocks.pearcel_end_stone);
        registerBlock(ModBlocks.pearcel_charcoal_block);
        registerBlock(ModBlocks.pearcel_glass_pane);
        registerBlock(ModBlocks.pedestal);
        registerBlock(ModBlocks.pearcel_ladder);
        registerBlock(ModBlocks.pearcel_lamp);
        registerBlock(ModBlocks.lit_pearcel_lamp);
        registerBlock(ModBlocks.ender_pearcel_block);
        registerBlock(ModBlocks.pearcel_ingot_block);
        registerBlock(ModBlocks.pearcel_plush);
        registerBlock(ModBlocks.pearcel_fence);
        registerBlock(ModBlocks.pearcel_fence2);

        //Ores
        registerBlock(ModBlocks.pearcel_ore);
        registerBlock(ModBlocks.nether_pearcel_ore);
        registerBlock(ModBlocks.ender_pearcel_ore);
        registerBlock(ModBlocks.pearcel_matter_ore);
        registerBlock(ModBlocks.dense_pearcel_ore);
        registerBlock(ModBlocks.dense_pearcel_matter_ore);
        registerBlock(ModBlocks.fools_pearcel_ore);
        registerBlock(ModBlocks.dense_fools_pearcel_ore);

        //Functional
        registerBlock(ModBlocks.pearcel_workbench);
        registerBlock(ModBlocks.torcher);
        registerBlock(ModBlocks.summoner);
        registerBlock(ModBlocks.pearcel_beacon);
        registerBlock(ModBlocks.pearcel_storage_crate);
        registerBlock(ModBlocks.pearcel_pressure_plate);
        registerBlock(ModBlocks.pearcel_spike);
        registerBlock(ModBlocks.pearcel_spike_ender);
        registerBlock(ModBlocks.pearcel_spike_guardian);
        registerBlock(ModBlocks.pearcel_furnace);
        registerBlock(ModBlocks.pearcel_furnace_lit);
        registerBlock(ModBlocks.pearcel_generator);
    }

    public static void registerRenderItems(){
        registerItemRender(ModItems.pearcel_manual);
        registerItemRender(ModItems.pearcel_item);
        registerItemRender(ModItems.pearcel_ingot);
        registerItemRender(ModItems.tier_1_crafting_component);
        registerItemRender(ModItems.tier_2_crafting_component);
        registerItemRender(ModItems.tier_3_crafting_component);
        registerItemRender(ModItems.tier_4_crafting_component);
        registerItemRender(ModItems.armor_plating);
        registerItemRender(ModItems.pearcel_flour);
        registerItemRender(ModItems.pearcel_stick);
        registerItemRender(ModItems.pearcel_charcoal);
        registerItemRender(ModItems.pearcel_matter);
        registerItemRender(ModItems.neutral_pearcel_matter);
        registerItemRender(ModItems.pearcel_arrow);
        registerItemRender(ModItems.pearcel_star);
        registerItemRender(ModItems.blood_drop);

        registerItemRender(ModItems.pearcel_bread);
        registerItemRender(ModItems.pearcel_pie);
        registerItemRender(ModItems.pearcel_beef);
        registerItemRender(ModItems.pearcel_steak);
        registerItemRender(ModItems.pearcel_cookie);
        registerItemRender(ModItems.pearcel_sandwich);
        registerItemRender(ModItems.pearcel_juice_bottle);
        registerItemRender(ModItems.pearcel_infinifood);
        registerItemRender(ModItems.golden_pearcel);
        registerItemRender(ModItems.jeweled_pearcel);
        registerItemRender(ModItems.glowing_pearcel);
        registerItemRender(ModItems.guardian_food);

        registerItemRender(ModItems.pearcel_sword);
        registerItemRender(ModItems.pearcel_pickaxe);
        registerItemRender(ModItems.pearcel_axe);
        registerItemRender(ModItems.pearcel_shovel);
        registerItemRender(ModItems.pearcel_hoe);
        registerItemRender(ModItems.pearcel_shears);
        registerItemRender(ModItems.experience_pearcel);
        registerItemRender(ModItems.tp_pearcel);
        registerItemRender(ModItems.sap);
        registerItemRender(ModItems.pepc);
        registerItemRender(ModItems.pearcel_helmet);
        registerItemRender(ModItems.pearcel_chestplate);
        registerItemRender(ModItems.pearcel_leggings);
        registerItemRender(ModItems.pearcel_boots);
        registerItemRender(ModItems.pearcel_staff);
        registerItemRender(ModItems.guardian_pearcel_staff);
        registerItemRender(ModItems.pcp);
        registerItemRender(ModItems.ender_pearcel);
        registerItemRender(ModItems.pearcel_bow);
        registerItemRender(ModItems.pearcel_stone_placer);
        registerItemRender(ModItems.reinforced_pearcel_pickaxe);
        registerItemRender(ModItems.reinforced_pearcel_shovel);
        registerItemRender(ModItems.pearcel_crook);
        registerItemRender(ModItems.matter_fabricator);
        registerItemRender(ModItems.stimulation_pearcel);
        registerItemRender(ModItems.rif_pearcel_helmet);
        registerItemRender(ModItems.rif_pearcel_chestplate);
        registerItemRender(ModItems.rif_pearcel_leggings);
        registerItemRender(ModItems.rif_pearcel_boots);
        registerItemRender(ModItems.pearcel_backpack);
        registerItemRender(ModItems.enlarged_pearcel_backpack);
        registerItemRender(ModItems.bindle);
        registerItemRender(ModItems.nullification_pearcel);
        registerItemRender(ModItems.pearcel_magnet);
        registerItemRender(ModItems.pearcel_magnet_advanced);
        registerItemRender(ModItems.living_magnet);
        registerItemRender(ModItems.sacrificial_pearcel);
        registerItemRender(ModItems.pearcel_blood_dagger);
        registerItemRender(ModItems.charmed_pearcel);
        registerItemRender(ModItems.charm_bag);
        registerItemRender(ModItems.slimey_pearcel);
        registerItemRender(ModItems.throw_pearcel_explosive);
        registerItemRender(ModItems.throw_pearcel_entity_tp);
        registerItemRender(ModItems.throw_pearcel_entity_firework);
        registerItemRender(ModItems.throw_pearcel_entity_mount);
        registerItemRender(ModItems.throw_pearcel_scatter);
    }

    public static void registerRenderBlocks(){
        //General
        registerBlockRender(ModBlocks.pearcel_block);
        registerBlockRender(ModBlocks.pearcel_sand);
        registerBlockRender(ModBlocks.pearcel_sandstone);
        registerBlockRender(ModBlocks.pearcel_matter_block);
        registerBlockRender(ModBlocks.pearcel_bricks);
        registerBlockRender(ModBlocks.packed_pearcel_bricks);
        registerBlockRender(ModBlocks.pearcel_stone);
        registerBlockRender(ModBlocks.pearcel_cobblestone);
        registerBlockRender(ModBlocks.pearcel_glass);
        registerBlockRender(ModBlocks.distressed_pearcel_stone);
        registerBlockRender(ModBlocks.irradiated_pearcel_block);
        registerBlockRender(ModBlocks.polished_pearcel_stone);
        registerBlockRender(ModBlocks.pearcel_stonebricks);
        registerBlockRender(ModBlocks.tainted_pearcel);
        registerBlockRender(ModBlocks.pearcel_torch);
        registerBlockRender(ModBlocks.pearcel_planks);
        registerBlockRender(ModBlocks.pearcel_end_stone);
        registerBlockRender(ModBlocks.pearcel_charcoal_block);
        registerBlockRender(ModBlocks.pearcel_glass_pane);
        registerBlockRender(ModBlocks.pedestal);
        registerBlockRender(ModBlocks.pearcel_ladder);
        registerBlockRender(ModBlocks.pearcel_lamp);
        registerBlockRender(ModBlocks.lit_pearcel_lamp);
        registerBlockRender(ModBlocks.ender_pearcel_block);
        registerBlockRender(ModBlocks.pearcel_ingot_block);
        registerBlockRender(ModBlocks.pearcel_plush);
        registerBlockRender(ModBlocks.pearcel_fence);
        registerBlockRender(ModBlocks.pearcel_fence2);

        //Ores
        registerBlockRender(ModBlocks.pearcel_ore);
        registerBlockRender(ModBlocks.nether_pearcel_ore);
        registerBlockRender(ModBlocks.ender_pearcel_ore);
        registerBlockRender(ModBlocks.pearcel_matter_ore);
        registerBlockRender(ModBlocks.dense_pearcel_ore);
        registerBlockRender(ModBlocks.dense_pearcel_matter_ore);
        registerBlockRender(ModBlocks.fools_pearcel_ore);
        registerBlockRender(ModBlocks.dense_fools_pearcel_ore);

        //Functional
        registerBlockRender(ModBlocks.pearcel_workbench);
        registerBlockRender(ModBlocks.torcher);
        registerBlockRender(ModBlocks.summoner);
        registerBlockRender(ModBlocks.pearcel_beacon);
        registerBlockRender(ModBlocks.pearcel_storage_crate);
        registerBlockRender(ModBlocks.pearcel_pressure_plate);
        registerBlockRender(ModBlocks.pearcel_spike);
        registerBlockRender(ModBlocks.pearcel_spike_ender);
        registerBlockRender(ModBlocks.pearcel_spike_guardian);
        registerBlockRender(ModBlocks.pearcel_furnace);
        registerBlockRender(ModBlocks.pearcel_furnace_lit);
        registerBlockRender(ModBlocks.pearcel_generator);
    }

    //Registry
    @SubscribeEvent
    public void onItemRegistry(RegistryEvent.Register<Item> event){
        itemsToRegister.forEach(event.getRegistry()::register);
    }

    @SubscribeEvent
    public void onBlockRegistry(RegistryEvent.Register<Block> event){
        blocksToRegister.forEach(event.getRegistry()::register);
    }

    private static void registerBlock(Block block){
        blocksToRegister.add(block);
        registerItem(new ModItemBlock(block));
    }

    private static void registerItem(Item item){
        itemsToRegister.add(item);
    }

    private static void registerBlockRender(Block block){
        Item item = Item.getItemFromBlock(block);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + block.getUnlocalizedName().substring(5), "inventory"));
    }

    public static void registerItemRender(Item item){
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }

    public static void registerItemRender(Item item, int meta, String name){
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(Reference.MOD_ID + ":" + name, "inventory"));
    }

}
