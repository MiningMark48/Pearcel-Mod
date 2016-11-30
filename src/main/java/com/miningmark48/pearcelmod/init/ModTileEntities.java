package com.miningmark48.pearcelmod.init;

import com.miningmark48.pearcelmod.tileentity.TileEntityPearcelBeacon;
import com.miningmark48.pearcelmod.tileentity.TileEntityPearcelFurnace;
import com.miningmark48.pearcelmod.tileentity.TileEntityPearcelStorageCrate;
import com.miningmark48.pearcelmod.tileentity.TileEntityPedestal;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModTileEntities {

    public static void init(){
        GameRegistry.registerTileEntity(TileEntityPearcelFurnace.class, "te_pearcel_furnace");
        GameRegistry.registerTileEntity(TileEntityPedestal.class, "te_pedestal");
        GameRegistry.registerTileEntity(TileEntityPearcelBeacon.class, "te_pearcel_beacon");
        GameRegistry.registerTileEntity(TileEntityPearcelStorageCrate.class, "te_pearcel_storage_crate");
    }

}
