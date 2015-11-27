package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.init.ModItems;
import cpw.mods.fml.common.IFuelHandler;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemPearcelFuel extends Item implements IFuelHandler{

    @Override
     public int getBurnTime(ItemStack fuel) {
        Item item = fuel.getItem();

        if(item == ModItems.pearcelCharcoal){
            return 2500;
        }else if(item == ModItems.pearcelStick) {
            return 150;
        }else if(item == ModItems.redMatter || item == ModItems.greenMatter || item == ModItems.meMatter) {
            return 15000;
        }
        else{
            return 0;
        }
    }
}
