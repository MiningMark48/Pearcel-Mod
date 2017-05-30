package com.miningmark48.pearcelmod.init;

import com.google.common.collect.Lists;
import com.miningmark48.pearcelmod.handler.IGeneratorHandler;
import com.miningmark48.pearcelmod.item.ItemPearcelFood;
import com.miningmark48.pearcelmod.utility.LogHelper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

import java.util.List;

public class GeneratorRegistry {

    private static List<IGeneratorHandler> fuelHandlers = Lists.newArrayList();

    public static void registerGeneratorFuels(){
        registerGeneratorFuel(new ItemPearcelFood(0, 0.0F, false));
    }

    public static void registerGeneratorFuel(IGeneratorHandler handler){
        fuelHandlers.add(handler);
    }

    public static int getCooldownTime(ItemStack itemStack)
    {
        int cooldown = 0;
        for (IGeneratorHandler handler : fuelHandlers)
        {
            cooldown = Math.max(cooldown, handler.getCooldownTime(itemStack));
        }
        return cooldown;
    }

    public static int getRFPerTick(ItemStack itemStack)
    {
        int rfPerTick = 0;
        for (IGeneratorHandler handler : fuelHandlers)
        {
            rfPerTick = Math.max(rfPerTick, handler.getRFPetTick(itemStack));
        }
        return rfPerTick;
    }

}
