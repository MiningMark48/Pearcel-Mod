package com.miningmark48.pearcelmod.init;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class ModFluids {

    public static Fluid fluidPearcel;

    public static void init(){

        fluidPearcel = new Fluid("pearcelFluid");

        FluidRegistry.registerFluid(fluidPearcel);

    }

}
