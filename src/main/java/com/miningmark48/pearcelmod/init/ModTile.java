package com.miningmark48.pearcelmod.init;

import com.miningmark48.pearcelmod.tileentity.TileEntityIVET;
import com.miningmark48.pearcelmod.tileentity.TileEntityPearcelPlush;
import com.miningmark48.pearcelmod.tileentity.TileEntitySummoner;
import com.miningmark48.pearcelmod.tileentity.TileEntityTorcher;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModTile {

    public static void init(){
        GameRegistry.registerTileEntity(TileEntityIVET.class, "TileEntityIVET");
        GameRegistry.registerTileEntity(TileEntityTorcher.class, "TitleEntityTorcher");
        GameRegistry.registerTileEntity(TileEntityPearcelPlush.class, "TileEntityPearcelPlush");
        GameRegistry.registerTileEntity(TileEntitySummoner.class, "TileEntitySummoner");
    }

}
