package com.miningmark48.pearcelmod.plugin.jei;

import com.miningmark48.pearcelmod.gui.GuiPCP;
import com.miningmark48.pearcelmod.gui.GuiPearcelWorkbench;
import com.miningmark48.pearcelmod.init.ModBlocks;
import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.utility.Translate;
import mezz.jei.api.*;
import mezz.jei.api.ingredients.IModIngredientRegistration;
import net.minecraft.item.ItemStack;

import java.util.*;

@JEIPlugin
public class PMJEIPlugin implements IModPlugin{

    public static IJeiHelpers jeiHelpers;

    @Override
    public void registerItemSubtypes(ISubtypeRegistry iSubtypeRegistry) {

    }

    @Override
    public void registerIngredients(IModIngredientRegistration iModIngredientRegistration) {

    }

    @Override
    public void register(IModRegistry registry) {

        jeiHelpers = registry.getJeiHelpers();

        List<ItemStack> backpacks = new ArrayList<ItemStack>();
        backpacks.add(new ItemStack(ModItems.bindle));
        backpacks.add(new ItemStack(ModItems.pearcel_backpack));
        backpacks.add(new ItemStack(ModItems.enlarged_pearcel_backpack));
        List<ItemStack> rif_armor = new ArrayList<ItemStack>();
        rif_armor.add(new ItemStack(ModItems.rif_pearcel_helmet));
        rif_armor.add(new ItemStack(ModItems.rif_pearcel_chestplate));
        rif_armor.add(new ItemStack(ModItems.rif_pearcel_leggings));
        rif_armor.add(new ItemStack(ModItems.rif_pearcel_boots));
        List<ItemStack> pearcel_tools = new ArrayList<ItemStack>();
        pearcel_tools.add(new ItemStack(ModItems.pearcel_sword));
        pearcel_tools.add(new ItemStack(ModItems.pearcel_pickaxe));
        pearcel_tools.add(new ItemStack(ModItems.pearcel_axe));
        pearcel_tools.add(new ItemStack(ModItems.pearcel_shovel));
        pearcel_tools.add(new ItemStack(ModItems.pearcel_hoe));
        pearcel_tools.add(new ItemStack(ModItems.pearcel_shears));
        List<ItemStack> throwing_pearcels = new ArrayList<ItemStack>();
        throwing_pearcels.add(new ItemStack(ModItems.throw_pearcel_explosive));
        throwing_pearcels.add(new ItemStack(ModItems.throw_pearcel_entity_mount));
        throwing_pearcels.add(new ItemStack(ModItems.throw_pearcel_entity_firework));
        throwing_pearcels.add(new ItemStack(ModItems.throw_pearcel_entity_tp));
        List<ItemStack> spikes = new ArrayList<ItemStack>();
        spikes.add(new ItemStack(ModBlocks.pearcel_spike));
        spikes.add(new ItemStack(ModBlocks.pearcel_spike_ender));

        //Blacklist
        jeiHelpers.getItemBlacklist().addItemToBlacklist(new ItemStack(ModBlocks.lit_pearcel_lamp));

        //Descriptions
        registry.addDescription(new ItemStack(ModItems.pearcel_item), Translate.toLocal("desc.item.pearcel_item"));
        registry.addDescription(new ItemStack(ModItems.matter_fabricator), Translate.toLocal("desc.item.matter_fabricator"));
        registry.addDescription(new ItemStack(ModItems.pearcel_bow), Translate.toLocal("desc.item.pearcel_bow"));
        registry.addDescription(new ItemStack(ModItems.pcp), Translate.toLocal("desc.item.pcp"));
        registry.addDescription(new ItemStack(ModItems.experience_pearcel), Translate.toLocal("desc.item.experience_pearcel"));
        registry.addDescription(new ItemStack(ModItems.stimulation_pearcel), Translate.toLocal("desc.item.stimulation_pearcel"));
        registry.addDescription(new ItemStack(ModItems.nullification_pearcel), Translate.toLocal("desc.item.nullification_pearcel"));
        registry.addDescription(new ItemStack(ModItems.pearcel_magnet), Translate.toLocal("desc.item.pearcel_magnet"));
        registry.addDescription(new ItemStack(ModItems.living_magnet), Translate.toLocal("desc.item.living_magnet"));
        registry.addDescription(new ItemStack(ModItems.glowing_pearcel), Translate.toLocal("desc.item.glowing_pearcel"));
        registry.addDescription(new ItemStack(ModItems.pearcel_infinifood), Translate.toLocal("desc.item.pearcel_infinifood"));
        registry.addDescription(new ItemStack(ModItems.pearcel_staff), Translate.toLocal("desc.item.pearcel_staff"));
        registry.addDescription(new ItemStack(ModItems.dragon_pearcel_staff), Translate.toLocal("desc.item.dragon_pearcel_staff"));
        registry.addDescription(new ItemStack(ModItems.pepc), Translate.toLocal("desc.item.pepc"));
        registry.addDescription(new ItemStack(ModItems.pearcel_crook), Translate.toLocal("desc.item.pearcel_crook"));
        registry.addDescription(new ItemStack(ModItems.tp_pearcel), Translate.toLocal("desc.item.tp_pearcel"));
        registry.addDescription(new ItemStack(ModItems.pearcel_stone_placer), Translate.toLocal("desc.item.pbp"));
        registry.addDescription(new ItemStack(ModItems.pearcel_juice_bottle), Translate.toLocal("desc.item.pearcel_juice"));
        registry.addDescription(new ItemStack(ModItems.guardian_food), Translate.toLocal("desc.item.guardian_food"));
        registry.addDescription(new ItemStack(ModItems.pearcel_star), Translate.toLocal("desc.item.pearcel_star"));
        registry.addDescription(new ItemStack(ModItems.sacrificial_pearcel), Translate.toLocal("desc.item.sacrificial_pearcel"));
        registry.addDescription(new ItemStack(ModItems.blood_drop), Translate.toLocal("desc.item.blood_drop"));
        registry.addDescription(new ItemStack(ModItems.pearcel_blood_dagger), Translate.toLocal("desc.item.pearcel_blood_dagger"));
        registry.addDescription(new ItemStack(ModItems.charmed_pearcel), Translate.toLocal("desc.item.charmed_pearcel"));
        registry.addDescription(new ItemStack(ModItems.charm_bag), Translate.toLocal("desc.item.charm_bag"));
        registry.addDescription(new ItemStack(ModItems.slimey_pearcel), Translate.toLocal("desc.item.slimey_pearcel"));

        registry.addDescription(new ItemStack(ModBlocks.torcher), Translate.toLocal("desc.block.torcher"));
        registry.addDescription(new ItemStack(ModBlocks.pearcel_torch), Translate.toLocal("desc.block.pearcel_torch"));
        registry.addDescription(new ItemStack(ModBlocks.summoner), Translate.toLocal("desc.block.summoner"));
        registry.addDescription(new ItemStack(ModBlocks.pedestal), Translate.toLocal("desc.block.pedestal"));
        registry.addDescription(new ItemStack(ModBlocks.pearcel_beacon), Translate.toLocal("desc.block.pearcel_beacon"));
        registry.addDescription(new ItemStack(ModBlocks.pearcel_storage_crate), Translate.toLocal("desc.block.pearcel_storage_crate"));
        registry.addDescription(new ItemStack(ModBlocks.pearcel_workbench), Translate.toLocal("desc.block.pearcel_workbench"));
        registry.addDescription(new ItemStack(ModBlocks.pearcel_pressure_plate), Translate.toLocal("desc.block.pearcel_pressure_plate"));
        registry.addDescription(new ItemStack(ModBlocks.pearcel_spike_guardian), Translate.toLocal("desc.block.pearcel_spike_guardian"));

        //Descriptions - Lists
        registry.addDescription(backpacks, Translate.toLocal("desc.item.backpack"));
        registry.addDescription(rif_armor, Translate.toLocal("desc.item.rif_armor"));
        registry.addDescription(pearcel_tools, Translate.toLocal("desc.item.pearcel_tools"));
        registry.addDescription(spikes, Translate.toLocal("desc.block.pearcel_spike"));
        registry.addDescription(throwing_pearcels, Translate.toLocal("desc.item.throwing_pearcel"));

        //Categories
        registry.addRecipeCategoryCraftingItem(new ItemStack(ModBlocks.pearcel_workbench), "minecraft.crafting");
        registry.addRecipeCategoryCraftingItem(new ItemStack(ModItems.pcp), "minecraft.crafting");

        //Recipe Click Areas
        registry.addRecipeClickArea(GuiPearcelWorkbench.class, 90, 35, 20, 20, "minecraft.crafting");
        registry.addRecipeClickArea(GuiPCP.class, 90, 35, 20, 20, "minecraft.crafting");

    }

    @Override
    public void onRuntimeAvailable(IJeiRuntime iJeiRuntime) {

    }

}