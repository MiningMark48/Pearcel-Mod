package com.miningmark48.pearcelmod.crafting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import com.miningmark48.pearcelmod.init.ModBlocks;
import com.miningmark48.pearcelmod.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.item.crafting.IRecipe;

public class IVETCraftingManager
{
    /** The static instance of this class */
    private static final IVETCraftingManager instance = new IVETCraftingManager();
    /** A list of all the recipes added */
    private List recipes = new ArrayList();
    private static final String __OBFID = "CL_00000090";

    /**
     * Returns the static instance of this class
     */
    public static final IVETCraftingManager getInstance()
    {
        /** The static instance of this class */
        return instance;
    }

    private IVETCraftingManager()
    {

        recipes = new ArrayList();

        //Add Recipes Here
        //this.addShapelessRecipe(new ItemStack(BLOCK/ITEM TO GET, #), FROM THIS BLOCK/ITEM);

        this.addShapelessRecipe(new ItemStack(Blocks.mossy_cobblestone), Blocks.cobblestone);
        this.addShapelessRecipe(new ItemStack(Blocks.cobblestone), Blocks.mossy_cobblestone);
        this.addShapelessRecipe(new ItemStack(ModBlocks.meWorkbench), Blocks.crafting_table);
        this.addShapelessRecipe(new ItemStack(Blocks.sand), Blocks.soul_sand);
        this.addShapelessRecipe(new ItemStack(Blocks.soul_sand), Blocks.sand);
        this.addShapelessRecipe(new ItemStack(Items.redstone, 2), Blocks.piston);
        this.addShapelessRecipe(new ItemStack(Blocks.piston), Blocks.sticky_piston);
        this.addShapelessRecipe(new ItemStack(Blocks.sticky_piston), Blocks.piston);
        this.addShapelessRecipe(new ItemStack(Items.diamond, 2), Items.emerald);
        this.addShapelessRecipe(new ItemStack(Items.apple), ModItems.pearcel);
        this.addShapelessRecipe(new ItemStack(Items.iron_ingot, 2), Items.gold_ingot);
        this.addShapelessRecipe(new ItemStack(Blocks.obsidian), Items.lava_bucket);
        this.addShapelessRecipe(new ItemStack(Items.writable_book), Items.written_book);
        this.addShapelessRecipe(new ItemStack(Items.book, 2), Items.written_book);
        this.addShapelessRecipe(new ItemStack(Items.book, 4), Blocks.bookshelf);
        this.addShapelessRecipe(new ItemStack(Items.wheat_seeds), ModItems.pearcelSeeds);
        this.addShapelessRecipe(new ItemStack(ModItems.pearcelSeeds), Items.wheat_seeds);
        this.addShapelessRecipe(new ItemStack(Items.iron_ingot, 2), ModBlocks.meBlock);
        this.addShapelessRecipe(new ItemStack(Items.glass_bottle, 16), Items.bucket);
        this.addShapelessRecipe(new ItemStack(ModBlocks.pearcelPainting), Items.painting);
        this.addShapelessRecipe(new ItemStack(ModBlocks.pearcelTorch), Blocks.torch);
        this.addShapelessRecipe(new ItemStack(Blocks.torch), ModBlocks.pearcelTorch);
        this.addShapelessRecipe(new ItemStack(Items.diamond), Blocks.coal_block);
        this.addShapelessRecipe(new ItemStack(ModItems.meMatter), ModItems.meMatterNeutral);
        this.addShapelessRecipe(new ItemStack(Items.brick), Items.netherbrick);
        this.addShapelessRecipe(new ItemStack(Items.netherbrick), Items.brick);
        this.addShapelessRecipe(new ItemStack(Items.record_11), Items.record_ward);
        this.addShapelessRecipe(new ItemStack(Items.record_13), Items.record_11);
        this.addShapelessRecipe(new ItemStack(Items.record_blocks), Items.record_13);
        this.addShapelessRecipe(new ItemStack(Items.record_cat), Items.record_blocks);
        this.addShapelessRecipe(new ItemStack(Items.record_chirp), Items.record_cat);
        this.addShapelessRecipe(new ItemStack(Items.record_far), Items.record_chirp);
        this.addShapelessRecipe(new ItemStack(Items.record_mall), Items.record_far);
        this.addShapelessRecipe(new ItemStack(Items.record_mellohi), Items.record_mall);
        this.addShapelessRecipe(new ItemStack(Items.record_stal), Items.record_mellohi);
        this.addShapelessRecipe(new ItemStack(Items.record_strad), Items.record_stal);
        this.addShapelessRecipe(new ItemStack(Items.record_wait), Items.record_strad);
        this.addShapelessRecipe(new ItemStack(Items.record_ward), Items.record_wait);


        Collections.sort(this.recipes, new IVETRecipeSorter(this));
    }

    public IVETShapedRecipes addRecipe(ItemStack p_92103_1_, Object ... p_92103_2_)
    {
        String s = "";
        int i = 0;
        int j = 0;
        int k = 0;

        if (p_92103_2_[i] instanceof String[])
        {
            String[] astring = (String[])((String[])p_92103_2_[i++]);

            for (int l = 0; l < astring.length; ++l)
            {
                String s1 = astring[l];
                ++k;
                j = s1.length();
                s = s + s1;
            }
        }
        else
        {
            while (p_92103_2_[i] instanceof String)
            {
                String s2 = (String)p_92103_2_[i++];
                ++k;
                j = s2.length();
                s = s + s2;
            }
        }

        HashMap hashmap;

        for (hashmap = new HashMap(); i < p_92103_2_.length; i += 2)
        {
            Character character = (Character)p_92103_2_[i];
            ItemStack itemstack1 = null;

            if (p_92103_2_[i + 1] instanceof Item)
            {
                itemstack1 = new ItemStack((Item)p_92103_2_[i + 1]);
            }
            else if (p_92103_2_[i + 1] instanceof Block)
            {
                itemstack1 = new ItemStack((Block)p_92103_2_[i + 1], 1, 32767);
            }
            else if (p_92103_2_[i + 1] instanceof ItemStack)
            {
                itemstack1 = (ItemStack)p_92103_2_[i + 1];
            }

            hashmap.put(character, itemstack1);
        }

        ItemStack[] aitemstack = new ItemStack[j * k];

        for (int i1 = 0; i1 < j * k; ++i1)
        {
            char c0 = s.charAt(i1);

            if (hashmap.containsKey(Character.valueOf(c0)))
            {
                aitemstack[i1] = ((ItemStack)hashmap.get(Character.valueOf(c0))).copy();
            }
            else
            {
                aitemstack[i1] = null;
            }
        }

        IVETShapedRecipes shapedrecipes = new IVETShapedRecipes(j, k, aitemstack, p_92103_1_);
        this.recipes.add(shapedrecipes);
        return shapedrecipes;
    }

    public void addShapelessRecipe(ItemStack p_77596_1_, Object ... p_77596_2_)
    {
        ArrayList arraylist = new ArrayList();
        Object[] aobject = p_77596_2_;
        int i = p_77596_2_.length;

        for (int j = 0; j < i; ++j)
        {
            Object object1 = aobject[j];

            if (object1 instanceof ItemStack)
            {
                arraylist.add(((ItemStack)object1).copy());
            }
            else if (object1 instanceof Item)
            {
                arraylist.add(new ItemStack((Item)object1));
            }
            else
            {
                if (!(object1 instanceof Block))
                {
                    throw new RuntimeException("Invalid shapeless recipe!");
                }

                arraylist.add(new ItemStack((Block)object1));
            }
        }

        this.recipes.add(new IVETShapelessRecipes(p_77596_1_, arraylist));
    }

    public ItemStack findMatchingRecipe(InventoryCrafting p_82787_1_, World p_82787_2_)
    {
        int i = 0;
        ItemStack itemstack = null;
        ItemStack itemstack1 = null;
        int j;

        for (j = 0; j < p_82787_1_.getSizeInventory(); ++j)
        {
            ItemStack itemstack2 = p_82787_1_.getStackInSlot(j);

            if (itemstack2 != null)
            {
                if (i == 0)
                {
                    itemstack = itemstack2;
                }

                if (i == 1)
                {
                    itemstack1 = itemstack2;
                }

                ++i;
            }
        }

        if (i == 2 && itemstack.getItem() == itemstack1.getItem() && itemstack.stackSize == 1 && itemstack1.stackSize == 1 && itemstack.getItem().isRepairable())
        {
            Item item = itemstack.getItem();
            int j1 = item.getMaxDamage() - itemstack.getItemDamageForDisplay();
            int k = item.getMaxDamage() - itemstack1.getItemDamageForDisplay();
            int l = j1 + k + item.getMaxDamage() * 5 / 100;
            int i1 = item.getMaxDamage() - l;

            if (i1 < 0)
            {
                i1 = 0;
            }

            return new ItemStack(itemstack.getItem(), 1, i1);
        }
        else
        {
            for (j = 0; j < this.recipes.size(); ++j)
            {
                IRecipe irecipe = (IRecipe)this.recipes.get(j);

                if (irecipe.matches(p_82787_1_, p_82787_2_))
                {
                    return irecipe.getCraftingResult(p_82787_1_);
                }
            }

            return null;
        }
    }

    /**
     * returns the List<> of all recipes
     */
    public List getRecipeList()
    {
        return this.recipes;
    }
}