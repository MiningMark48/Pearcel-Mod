package com.miningmark48.pearcelmod.dimension;

import net.minecraftforge.common.DimensionManager;

public class DimensionRegistry {

    public static void mainRegistry(){
        registerDimension();
    }

    public static final int dimensionID = 77;

    public static void registerDimension(){

        DimensionManager.registerProviderType(dimensionID, WorldProviderPearcel.class, false);
        DimensionManager.registerDimension(dimensionID, dimensionID);

    }

}
