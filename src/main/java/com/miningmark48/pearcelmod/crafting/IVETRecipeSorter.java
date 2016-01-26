package com.miningmark48.pearcelmod.crafting;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;

public class IVETRecipeSorter implements Comparator {

    final IVETCraftingManager IVET;

    public IVETRecipeSorter(IVETCraftingManager IVETCM){
        this.IVET = IVETCM;
    }

    public int compareRecipes(IRecipe irecipe1, IRecipe irecipe2){
        return irecipe1 instanceof IVETShapelessRecipes && irecipe2 instanceof IVETShapedRecipes ? 1: (irecipe2 instanceof IVETShapelessRecipes && irecipe1 instanceof IVETShapedRecipes ? -1 : (irecipe2.getRecipeSize() < irecipe1.getRecipeSize() ? -1 : (irecipe2.getRecipeSize() > irecipe1.getRecipeSize() ? 1 : 0)));
    }

    @Override
    public int compare(Object o1, Object o2) {
        return this.compareRecipes((IRecipe)o1, (IRecipe)o2);
    }
}
