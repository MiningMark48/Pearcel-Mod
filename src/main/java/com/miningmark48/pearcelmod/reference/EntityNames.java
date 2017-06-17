package com.miningmark48.pearcelmod.reference;

import net.minecraft.util.ResourceLocation;

public class EntityNames {

    public static String Pearcel_Boss = "pearcel_boss";
    public static String Throw_Pearcel = "throw_pearcel";
    public static String Ender_Pearcel = "ender_pearcel";

    public static ResourceLocation getResouce(String res){
        return new ResourceLocation(Reference.MOD_ID, res);
    }

}
