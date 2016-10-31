package com.miningmark48.pearcelmod.jei;

import com.miningmark48.pearcelmod.init.ModBlocks;
import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.utility.Translate;
import mezz.jei.api.*;
import mezz.jei.api.ingredients.IModIngredientRegistration;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.*;

@JEIPlugin
public class PMPlugin implements IModPlugin{

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

        //Blacklist
        jeiHelpers.getItemBlacklist().addItemToBlacklist(new ItemStack(ModBlocks.lit_pearcel_lamp));

        //Descriptions
        registry.addDescription(new ItemStack(ModItems.pearcel_item), Translate.toLocal("desc.item.pearcel_item"));
        registry.addDescription(new ItemStack(ModItems.matter_fabricator), Translate.toLocal("desc.item.matter_fabricator"));
        registry.addDescription(new ItemStack(ModBlocks.torcher), Translate.toLocal("desc.item.torcher"));
        registry.addDescription(new ItemStack(ModItems.pearcel_bow), Translate.toLocal("desc.item.pearcel_bow"));
        registry.addDescription(new ItemStack(ModItems.pcp), Translate.toLocal("desc.item.pcp"));
        registry.addDescription(new ItemStack(ModItems.experience_pearcel), Translate.toLocal("desc.item.experience_pearcel"));
        registry.addDescription(new ItemStack(ModItems.stimulation_pearcel), Translate.toLocal("desc.item.stimulation_pearcel"));
        registry.addDescription(new ItemStack(ModItems.nullification_pearcel), Translate.toLocal("desc.item.nullification_pearcel"));

            //Lists
        registry.addDescription(backpacks, Translate.toLocal("desc.item.backpack"));
        registry.addDescription(rif_armor, Translate.toLocal("desc.item.rif_armor"));

        //Other
        registry.addRecipeCategoryCraftingItem(new ItemStack(ModBlocks.pearcel_workbench), "minecraft.crafting");
        registry.addRecipeCategoryCraftingItem(new ItemStack(ModItems.pcp), "minecraft.crafting");

    }

    @Override
    public void onRuntimeAvailable(IJeiRuntime iJeiRuntime) {

    }

}
