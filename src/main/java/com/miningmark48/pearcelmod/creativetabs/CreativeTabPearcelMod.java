package com.miningmark48.pearcelmod.creativetabs;

import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.item.ItemSAP;
import com.miningmark48.pearcelmod.item.ItemStimulationPearcel;
import com.miningmark48.pearcelmod.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTabPearcelMod{

    public static final CreativeTabs PearcelMod_TAB = new CreativeTabs(Reference.MOD_ID) {

        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ModItems.pearcel_item);
        }

        @Override
        public boolean hasSearchBar() {
            return ConfigurationHandler.creativeTabSearchBar;
        }
    };

}
