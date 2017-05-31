package com.miningmark48.pearcelmod.plugin.jei.generator;

import com.miningmark48.pearcelmod.init.GeneratorRegistry;
import com.miningmark48.pearcelmod.tileentity.TileEntityPearcelGenerator;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.ingredients.IIngredientRegistry;
import mezz.jei.api.recipe.IStackHelper;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class GeneratorFuelRecipeMaker {

    private GeneratorFuelRecipeMaker(){

    }

    public static List<GeneratorFuelRecipe> getFuelRecipes(IJeiHelpers helpers){
        IGuiHelper guiHelper = helpers.getGuiHelper();
        IStackHelper stackHelper = helpers.getStackHelper();
        List<ItemStack> fuelStacks = GeneratorRegistry.getFuels();
        List<GeneratorFuelRecipe> fuelRecipes = new ArrayList<GeneratorFuelRecipe>(fuelStacks.size());

        for (ItemStack fuelStack : fuelStacks){
            if (fuelStack == null){
                continue;
            }

            List<ItemStack> fuels = stackHelper.getSubtypes(fuelStack);
            if (fuels.isEmpty()){
                continue;
            }
            int cooldownTime = getBurnTime(fuels.get(0));
            int rfPerTick = getRFPerTick(fuels.get(0));
            fuelRecipes.add(new GeneratorFuelRecipe(guiHelper, fuels, cooldownTime, rfPerTick));
        }

        return fuelRecipes;

    }

    private static int getBurnTime(ItemStack stack){
        return TileEntityPearcelGenerator.getCooldownTime(stack);
    }

    private static int getRFPerTick(ItemStack stack){
        return TileEntityPearcelGenerator.getRFPerTick(stack);
    }

}
