package com.miningmark48.pearcelmod.init;

import com.miningmark48.pearcelmod.PearcelMod;
import com.miningmark48.pearcelmod.entity.EntityPearcelPearl;
import cpw.mods.fml.common.registry.EntityRegistry;

public class Entities {

    public static void init(){
        EntityRegistry.registerModEntity(EntityPearcelPearl.class, "PearcelPearl", 10, PearcelMod.instance, 350, 5, false);
    }

}
