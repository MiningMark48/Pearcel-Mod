package com.miningmark48.pearcelmod.plugin.jei.generator;

import com.miningmark48.pearcelmod.init.ModBlocks;
import com.miningmark48.pearcelmod.reference.Reference;
import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.*;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.BlankRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.util.ResourceLocation;

public class GeneratorFuelCategory<T extends IRecipeWrapper> extends BlankRecipeCategory<T>{

    private final IDrawable background;
    private final IDrawable flame;
    private final String localizedName;

    protected final ResourceLocation backgroundLocation = new ResourceLocation("minecraft", "textures/gui/container/furnace.png");

    public GeneratorFuelCategory(IGuiHelper guiHelper){
        background = guiHelper.createDrawable(backgroundLocation, 55, 38, 18, 32, 0, 0, 0, 80);

        IDrawableStatic flameDrawable = guiHelper.createDrawable(backgroundLocation, 176, 0, 14, 14);
        flame = guiHelper.createAnimatedDrawable(flameDrawable, 300, IDrawableAnimated.StartDirection.TOP, true);
        localizedName = ModBlocks.pearcel_generator.getLocalizedName() + " Fuel";
    }

    @Override
    public String getUid() {
        return Reference.MOD_ID + ".generator_fuel";
    }

    @Override
    public String getTitle() {
        return localizedName;
    }

    @Override
    public String getModName() {
        return Reference.MOD_NAME;
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public void setRecipe(IRecipeLayout iRecipeLayout, T t, IIngredients iIngredients) {
        IGuiItemStackGroup guiItemStacks = iRecipeLayout.getItemStacks();

        guiItemStacks.init(0, true, 0, 14);
        guiItemStacks.set(iIngredients);
    }

}
