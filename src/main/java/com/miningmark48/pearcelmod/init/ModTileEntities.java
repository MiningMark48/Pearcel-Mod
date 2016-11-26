package com.miningmark48.pearcelmod.init;

import com.miningmark48.pearcelmod.tileentity.TileEntityPedestal;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModTileEntities {

    public static void init(){
        GameRegistry.registerTileEntity(TileEntityPedestal.class, "te_pedestal");
    }

}
