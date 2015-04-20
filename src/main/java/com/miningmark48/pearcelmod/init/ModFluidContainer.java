package com.miningmark48.pearcelmod.init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;

public class ModFluidContainer {

    public static void init(){
        FluidContainerRegistry.registerFluidContainer(new FluidContainerRegistry.FluidContainerData(FluidRegistry.getFluidStack(ModFluids.fluidPearcel.getName(), FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(ModItems.pearcelJuice), new ItemStack(Items.bucket)));
    }

}
