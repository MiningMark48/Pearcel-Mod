package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.handler.IGeneratorFuelHandler;
import com.miningmark48.pearcelmod.init.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemPearcelModEffect extends ItemPearcelMod implements IGeneratorFuelHandler {

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
        return true;
    }

    @Override
    public int getCooldownTime(ItemStack fuel) {
        if (fuel.isItemEqual(new ItemStack(ModItems.pearcel_matter))){
            return 160;
        }else if (fuel.isItemEqual(new ItemStack(ModItems.pearcel_star))){
            return 300;
        }else if (fuel.isItemEqual(new ItemStack(ModItems.tier_4_crafting_component))){
            return 340;
        }
        return 0;
    }

    @Override
    public int getRFPerTick(ItemStack fuel) {
        if (fuel.isItemEqual(new ItemStack(ModItems.pearcel_matter))){
            return 120;
        }else if (fuel.isItemEqual(new ItemStack(ModItems.pearcel_star))){
            return 175;
        }else if (fuel.isItemEqual(new ItemStack(ModItems.tier_4_crafting_component))){
            return 475;
        }
        return 0;
    }

}
