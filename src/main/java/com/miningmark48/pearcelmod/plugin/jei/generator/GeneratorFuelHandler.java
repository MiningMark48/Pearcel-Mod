package com.miningmark48.pearcelmod.plugin.jei.generator;

import com.miningmark48.pearcelmod.reference.Reference;
import com.miningmark48.pearcelmod.utility.LogHelper;
import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;
import sun.rmi.runtime.Log;

public class GeneratorFuelHandler implements IRecipeHandler<GeneratorFuelRecipe>{

    @Override
    public Class<GeneratorFuelRecipe> getRecipeClass() {
        return GeneratorFuelRecipe.class;
    }

    @Override
    public String getRecipeCategoryUid(GeneratorFuelRecipe generatorFuelRecipe) {
        return Reference.MOD_ID + ".generator_fuel";
    }

    @Override
    public IRecipeWrapper getRecipeWrapper(GeneratorFuelRecipe generatorFuelRecipe) {
        return generatorFuelRecipe;
    }

    @Override
    public boolean isRecipeValid(GeneratorFuelRecipe generatorFuelRecipe) {
        return true;
    }
}
