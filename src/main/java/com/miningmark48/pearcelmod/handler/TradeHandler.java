package com.miningmark48.pearcelmod.handler;

import com.miningmark48.pearcelmod.init.ModItems;
import cpw.mods.fml.common.registry.VillagerRegistry;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;

import java.util.Random;

public class TradeHandler implements VillagerRegistry.IVillageTradeHandler{

    @Override
    public void manipulateTradesForVillager(EntityVillager villager, MerchantRecipeList recipeList, Random random)
    {
        switch(villager.getProfession()) {
            case 0: // FARMER
                recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 1), new ItemStack(ModItems.pearcelSeeds, 16)));
                recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 2), new ItemStack(ModItems.pearcel, 32)));
                recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 4), new ItemStack(ModItems.pearcelBread, 64)));
                break;
            case 1: // LIBRARIAN
                recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 1), new ItemStack(ModItems.pcp, 1)));
                break;
            case 2: // PRIEST
                break;
            case 3: // BLACKSMITH
                recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 1), new ItemStack(ModItems.pearcelSword, 1)));
                recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 5), new ItemStack(ModItems.chargedPearcelSword, 1)));
                recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 15), new ItemStack(ModItems.pearcelStaff, 1)));
                break;
            case 4: // BUTCHER
                recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 2), new ItemStack(ModItems.pearcelSteak, 16)));
                break;
            default:
                break;
        }
    }

}
