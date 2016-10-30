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

        //Blacklist
        jeiHelpers.getItemBlacklist().addItemToBlacklist(new ItemStack(ModBlocks.lit_pearcel_lamp));

        //Descriptions
        registry.addDescription(new ItemStack(ModItems.pearcel_item), Translate.toLocal("desc.item.pearcel_item"));
        registry.addDescription(new ItemStack(ModItems.matter_fabricator), Translate.toLocal("desc.item.matter_fabricator"));
        registry.addDescription(backpacks, Translate.toLocal("desc.item.backpack"));
        registry.addDescription(new ItemStack(ModBlocks.torcher), Translate.toLocal("desc.item.torcher"));
        registry.addDescription(new ItemStack(ModItems.pearcel_bow), Translate.toLocal("desc.item.pearcel_bow"));

        //Other
        registry.addRecipeCategoryCraftingItem(new ItemStack(ModBlocks.pearcel_workbench), "minecraft.crafting");
        registry.addRecipeCategoryCraftingItem(new ItemStack(ModItems.pcp), "minecraft.crafting");

    }

    @Override
    public void onRuntimeAvailable(IJeiRuntime iJeiRuntime) {

    }
}
