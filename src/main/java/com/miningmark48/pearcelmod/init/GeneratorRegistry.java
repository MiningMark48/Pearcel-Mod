package com.miningmark48.pearcelmod.init;

import com.google.common.collect.Lists;
import com.miningmark48.pearcelmod.block.BlockPearcelMod;
import com.miningmark48.pearcelmod.handler.IGeneratorFuelHandler;
import com.miningmark48.pearcelmod.item.ItemPearcelFood;
import com.miningmark48.pearcelmod.item.ItemPearcelFuel;
import com.miningmark48.pearcelmod.item.ItemPearcelModEffect;
import com.miningmark48.pearcelmod.utility.LogHelper;
import net.minecraft.item.ItemStack;

import java.util.List;

public class GeneratorRegistry {

    private static List<IGeneratorFuelHandler> fuelHandlers = Lists.newArrayList();

    public static void registerGeneratorFuels(){
        fuelHandlers.clear();

        registerGeneratorFuel(new ItemPearcelFood(0, 0.0F, false));
        registerGeneratorFuel(new ItemPearcelFuel());
        registerGeneratorFuel(new ItemPearcelModEffect());
        registerGeneratorFuel(new BlockPearcelMod());

        LogHelper.info("Registered Generator Fuels");
    }

    public static void registerGeneratorFuel(IGeneratorFuelHandler handler){
        fuelHandlers.add(handler);
    }

    public static int getCooldownTime(ItemStack itemStack)
    {
        int cooldown = 0;
        for (IGeneratorFuelHandler handler : fuelHandlers)
        {
            cooldown = Math.max(cooldown, handler.getCooldownTime(itemStack));
        }
        return cooldown;
    }

    public static int getRFPerTick(ItemStack itemStack)
    {
        int rfPerTick = 0;
        for (IGeneratorFuelHandler handler : fuelHandlers)
        {
            rfPerTick = Math.max(rfPerTick, handler.getRFPerTick(itemStack));
        }
        return rfPerTick;
    }

}
