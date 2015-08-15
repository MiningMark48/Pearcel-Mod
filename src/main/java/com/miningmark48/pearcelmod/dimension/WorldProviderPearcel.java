package com.miningmark48.pearcelmod.dimension;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenRiver;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderPearcel extends WorldProvider{

    public void registerWorldChunkManager(){
        this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenRiver.mesa, 1.2f); //TOBE CHANGED LATER!
        this.dimensionId = DimensionRegistry.dimensionID;
    }

    public IChunkProvider createChunkGeneration(){
        return null;
    }

    @Override
    public String getDimensionName() {
        return "Pearcel Dimension";
    }
}
