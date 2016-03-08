package com.miningmark48.pearcelmod.biome;

import net.minecraft.util.StatCollector;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;

public class BiomeGen {

    public static BiomeGenBase biomePearcel;
    public static int biomePearcelID = 100;
    public static BiomeGenBase biomePDesert;
    public static int biomePDesertID = 101;

    public static void init(){
        registerBiomes();
    }

    private static void registerBiomes() {
        biomePearcel = new BiomePearcel(biomePearcelID).setBiomeName(StatCollector.translateToLocal("biome.pearcelPlains.name"));
        BiomeDictionary.registerBiomeType(biomePearcel, BiomeDictionary.Type.PLAINS);
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(biomePearcel, 10));

        biomePDesert = new BiomePDesert(biomePDesertID).setBiomeName(StatCollector.translateToLocal("biome.pearcelDesert.name"));
        BiomeDictionary.registerBiomeType(biomePDesert, BiomeDictionary.Type.HOT);
        BiomeManager.addBiome(BiomeManager.BiomeType.DESERT, new BiomeManager.BiomeEntry(biomePDesert, 10));

        removeSpawnBiomes();

        //BiomeManager.addSpawnBiome(biomePearcel);
        BiomeManager.addSpawnBiome(biomePDesert);

    }

    private static void removeSpawnBiomes(){
        BiomeManager.removeSpawnBiome(BiomeGenBase.beach);
        BiomeManager.removeSpawnBiome(BiomeGenBase.birchForest);
        BiomeManager.removeSpawnBiome(BiomeGenBase.birchForestHills);
        BiomeManager.removeSpawnBiome(BiomeGenBase.coldBeach);
        BiomeManager.removeSpawnBiome(BiomeGenBase.coldTaiga);
        BiomeManager.removeSpawnBiome(BiomeGenBase.coldTaigaHills);
        BiomeManager.removeSpawnBiome(BiomeGenBase.deepOcean);
        BiomeManager.removeSpawnBiome(BiomeGenBase.desert);
        BiomeManager.removeSpawnBiome(BiomeGenBase.desertHills);
        BiomeManager.removeSpawnBiome(BiomeGenBase.extremeHills);
        BiomeManager.removeSpawnBiome(BiomeGenBase.extremeHillsEdge);
        BiomeManager.removeSpawnBiome(BiomeGenBase.extremeHillsPlus);
        BiomeManager.removeSpawnBiome(BiomeGenBase.forest);
        BiomeManager.removeSpawnBiome(BiomeGenBase.forestHills);
        BiomeManager.removeSpawnBiome(BiomeGenBase.frozenOcean);
        BiomeManager.removeSpawnBiome(BiomeGenBase.frozenRiver);
        BiomeManager.removeSpawnBiome(BiomeGenBase.hell);
        BiomeManager.removeSpawnBiome(BiomeGenBase.iceMountains);
        BiomeManager.removeSpawnBiome(BiomeGenBase.icePlains);
        BiomeManager.removeSpawnBiome(BiomeGenBase.jungle);
        BiomeManager.removeSpawnBiome(BiomeGenBase.jungleEdge);
        BiomeManager.removeSpawnBiome(BiomeGenBase.jungleHills);
        BiomeManager.removeSpawnBiome(BiomeGenBase.megaTaiga);
        BiomeManager.removeSpawnBiome(BiomeGenBase.megaTaigaHills);
        BiomeManager.removeSpawnBiome(BiomeGenBase.mesa);
        BiomeManager.removeSpawnBiome(BiomeGenBase.mesaPlateau);
        BiomeManager.removeSpawnBiome(BiomeGenBase.mushroomIsland);
        BiomeManager.removeSpawnBiome(BiomeGenBase.mushroomIslandShore);
        BiomeManager.removeSpawnBiome(BiomeGenBase.ocean);
        BiomeManager.removeSpawnBiome(BiomeGenBase.plains);
        BiomeManager.removeSpawnBiome(BiomeGenBase.river);
        BiomeManager.removeSpawnBiome(BiomeGenBase.roofedForest);
        BiomeManager.removeSpawnBiome(BiomeGenBase.savanna);
        BiomeManager.removeSpawnBiome(BiomeGenBase.savannaPlateau);
        BiomeManager.removeSpawnBiome(BiomeGenBase.sky);
        BiomeManager.removeSpawnBiome(BiomeGenBase.stoneBeach);
        BiomeManager.removeSpawnBiome(BiomeGenBase.swampland);
        BiomeManager.removeSpawnBiome(BiomeGenBase.taiga);
        BiomeManager.removeSpawnBiome(BiomeGenBase.taigaHills);
    }

}
