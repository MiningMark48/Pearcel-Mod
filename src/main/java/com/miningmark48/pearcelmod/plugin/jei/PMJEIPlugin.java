package com.miningmark48.pearcelmod.plugin.jei;

import com.miningmark48.mininglib.utility.ModTranslate;
import com.miningmark48.pearcelmod.gui.GuiPCP;
import com.miningmark48.pearcelmod.gui.GuiPearcelFurnace;
import com.miningmark48.pearcelmod.gui.GuiPearcelGenerator;
import com.miningmark48.pearcelmod.gui.GuiPearcelWorkbench;
import com.miningmark48.pearcelmod.init.ModBlocks;
import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.plugin.jei.generator.GeneratorFuelCategory;
import com.miningmark48.pearcelmod.plugin.jei.generator.GeneratorFuelHandler;
import com.miningmark48.pearcelmod.plugin.jei.generator.GeneratorFuelRecipeMaker;
import com.miningmark48.pearcelmod.reference.Reference;
import mezz.jei.api.*;
import mezz.jei.api.ingredients.IModIngredientRegistration;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
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
    public void registerCategories(IRecipeCategoryRegistration iRecipeCategoryRegistration) {

    }

    @Override
    public void register(IModRegistry registry) {

        jeiHelpers = registry.getJeiHelpers();
        final IGuiHelper guiHelper = jeiHelpers.getGuiHelper();

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
        //jeiHelpers.getItemBlacklist().addItemToBlacklist(new ItemStack(ModBlocks.lit_pearcel_lamp));
        jeiHelpers.getIngredientBlacklist().addIngredientToBlacklist(new ItemStack(ModBlocks.lit_pearcel_lamp));
        jeiHelpers.getIngredientBlacklist().addIngredientToBlacklist(new ItemStack(ModBlocks.pearcel_furnace_lit));

        //Descriptions
        registry.addDescription(new ItemStack(ModItems.pearcel_item), ModTranslate.toLocal("desc.item.pearcel_item"));
        registry.addDescription(new ItemStack(ModItems.matter_fabricator), ModTranslate.toLocal("desc.item.matter_fabricator"));
        registry.addDescription(new ItemStack(ModItems.pearcel_bow), ModTranslate.toLocal("desc.item.pearcel_bow"));
        registry.addDescription(new ItemStack(ModItems.pcp), ModTranslate.toLocal("desc.item.pcp"));
        registry.addDescription(new ItemStack(ModItems.experience_pearcel), ModTranslate.toLocal("desc.item.experience_pearcel"));
        registry.addDescription(new ItemStack(ModItems.stimulation_pearcel), ModTranslate.toLocal("desc.item.stimulation_pearcel"));
        registry.addDescription(new ItemStack(ModItems.nullification_pearcel), ModTranslate.toLocal("desc.item.nullification_pearcel"));
        registry.addDescription(new ItemStack(ModItems.pearcel_magnet), ModTranslate.toLocal("desc.item.pearcel_magnet"));
        registry.addDescription(new ItemStack(ModItems.pearcel_magnet_advanced), ModTranslate.toLocal("desc.item.pearcel_magnet_advanced"));
        registry.addDescription(new ItemStack(ModItems.living_magnet), ModTranslate.toLocal("desc.item.living_magnet"));
        registry.addDescription(new ItemStack(ModItems.glowing_pearcel), ModTranslate.toLocal("desc.item.glowing_pearcel"));
        registry.addDescription(new ItemStack(ModItems.pearcel_infinifood), ModTranslate.toLocal("desc.item.pearcel_infinifood"));
        registry.addDescription(new ItemStack(ModItems.pearcel_staff), ModTranslate.toLocal("desc.item.pearcel_staff"));
        registry.addDescription(new ItemStack(ModItems.guardian_pearcel_staff), ModTranslate.toLocal("desc.item.guardian_pearcel_staff"));
        registry.addDescription(new ItemStack(ModItems.pepc), ModTranslate.toLocal("desc.item.pepc"));
        registry.addDescription(new ItemStack(ModItems.pearcel_crook), ModTranslate.toLocal("desc.item.pearcel_crook"));
        registry.addDescription(new ItemStack(ModItems.tp_pearcel), ModTranslate.toLocal("desc.item.tp_pearcel"));
        registry.addDescription(new ItemStack(ModItems.pearcel_stone_placer), ModTranslate.toLocal("desc.item.pbp"));
        registry.addDescription(new ItemStack(ModItems.pearcel_juice_bottle), ModTranslate.toLocal("desc.item.pearcel_juice"));
        registry.addDescription(new ItemStack(ModItems.guardian_food), ModTranslate.toLocal("desc.item.guardian_food"));
        registry.addDescription(new ItemStack(ModItems.pearcel_star), ModTranslate.toLocal("desc.item.pearcel_star"));
        registry.addDescription(new ItemStack(ModItems.sacrificial_pearcel), ModTranslate.toLocal("desc.item.sacrificial_pearcel"));
        registry.addDescription(new ItemStack(ModItems.blood_drop), ModTranslate.toLocal("desc.item.blood_drop"));
        registry.addDescription(new ItemStack(ModItems.pearcel_blood_dagger), ModTranslate.toLocal("desc.item.pearcel_blood_dagger"));
        registry.addDescription(new ItemStack(ModItems.charmed_pearcel), ModTranslate.toLocal("desc.item.charmed_pearcel"));
        registry.addDescription(new ItemStack(ModItems.charm_bag), ModTranslate.toLocal("desc.item.charm_bag"));
        registry.addDescription(new ItemStack(ModItems.slimey_pearcel), ModTranslate.toLocal("desc.item.slimey_pearcel"));

        registry.addDescription(new ItemStack(ModBlocks.torcher), ModTranslate.toLocal("desc.block.torcher"));
        registry.addDescription(new ItemStack(ModBlocks.pearcel_torch), ModTranslate.toLocal("desc.block.pearcel_torch"));
        registry.addDescription(new ItemStack(ModBlocks.summoner), ModTranslate.toLocal("desc.block.summoner"));
        registry.addDescription(new ItemStack(ModBlocks.pedestal), ModTranslate.toLocal("desc.block.pedestal"));
        registry.addDescription(new ItemStack(ModBlocks.pearcel_beacon), ModTranslate.toLocal("desc.block.pearcel_beacon"));
        registry.addDescription(new ItemStack(ModBlocks.pearcel_storage_crate), ModTranslate.toLocal("desc.block.pearcel_storage_crate"));
        registry.addDescription(new ItemStack(ModBlocks.pearcel_workbench), ModTranslate.toLocal("desc.block.pearcel_workbench"));
        registry.addDescription(new ItemStack(ModBlocks.pearcel_pressure_plate), ModTranslate.toLocal("desc.block.pearcel_pressure_plate"));
        registry.addDescription(new ItemStack(ModBlocks.pearcel_spike_guardian), ModTranslate.toLocal("desc.block.pearcel_spike_guardian"));
        registry.addDescription(new ItemStack(ModBlocks.pearcel_furnace), ModTranslate.toLocal("desc.block.pearcel_furnace"));

        //Descriptions - Lists
        registry.addDescription(backpacks, ModTranslate.toLocal("desc.item.backpack"));
        registry.addDescription(rif_armor, ModTranslate.toLocal("desc.item.rif_armor"));
        registry.addDescription(pearcel_tools, ModTranslate.toLocal("desc.item.pearcel_tools"));
        registry.addDescription(spikes, ModTranslate.toLocal("desc.block.pearcel_spike"));
        registry.addDescription(throwing_pearcels, ModTranslate.toLocal("desc.item.throwing_pearcel"));

        //Categories
        registry.addRecipeCategoryCraftingItem(new ItemStack(ModBlocks.pearcel_workbench), "minecraft.crafting");
        registry.addRecipeCategoryCraftingItem(new ItemStack(ModItems.pcp), "minecraft.crafting");
        registry.addRecipeCategoryCraftingItem(new ItemStack(ModBlocks.pearcel_furnace), "minecraft.smelting");

        //Recipe Click Areas
        registry.addRecipeClickArea(GuiPearcelWorkbench.class, 90, 35, 20, 20, "minecraft.crafting");
        registry.addRecipeClickArea(GuiPCP.class, 90, 35, 20, 20, "minecraft.crafting");
        registry.addRecipeClickArea(GuiPearcelFurnace.class, 90, 35, 20, 20, "minecraft.smelting");


        //Custom Recipes
        //Generator
        registry.addRecipeCategories(
                new GeneratorFuelCategory(guiHelper)
        );
        registry.addRecipeHandlers(
                new GeneratorFuelHandler()
        );
        registry.addRecipeCategoryCraftingItem(new ItemStack(ModBlocks.pearcel_generator), Reference.MOD_ID + ".generator_fuel");
        registry.addRecipes(GeneratorFuelRecipeMaker.getFuelRecipes(jeiHelpers));
        registry.addRecipeClickArea(GuiPearcelGenerator.class, 34, 19, 100, 27, Reference.MOD_ID + ".generator_fuel");

    }

    @Override
    public void onRuntimeAvailable(IJeiRuntime iJeiRuntime) {

    }

}
