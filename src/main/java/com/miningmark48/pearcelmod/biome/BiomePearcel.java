package com.miningmark48.pearcelmod.biome;

import com.miningmark48.pearcelmod.init.ModBlocks;
import com.miningmark48.pearcelmod.mob.EntityPearcelCow;
import com.miningmark48.pearcelmod.mob.EntityPearcelMob;
import com.miningmark48.pearcelmod.mob.EntityPearcelSquid;
import com.miningmark48.pearcelmod.mob.EntityPearson;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class BiomePearcel extends BiomeGenBase{
    private static final Height biomeHeight = new Height(0.1F, 0.2F);
    private WorldGenerator theWorldGenerator;

    public BiomePearcel(int id) {
        super(id);

        this.setHeight(biomeHeight);
        this.setColor(65280);
        this.setTemperatureRainfall(0.9F, 1.0F);
        this.waterColorMultiplier = 1221450;
        this.topBlock = Blocks.grass;
        this.fillerBlock = ModBlocks.pearcelStone;
        theWorldGenerator = new WorldGenMinable(ModBlocks.pearcelOre, 10);
        this.theBiomeDecorator.treesPerChunk = 1;
        this.theBiomeDecorator.clayPerChunk = 2;
        this.theBiomeDecorator.flowersPerChunk = 5;
        this.enableRain = false;

        this.spawnableCreatureList.clear();
        this.spawnableCreatureList.add(new SpawnListEntry(EntityPearcelMob.class, 50, 2, 10));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityPearcelCow.class, 20, 2, 3));
        this.spawnableCaveCreatureList.clear();
        this.spawnableCaveCreatureList.add(new SpawnListEntry(EntityPearson.class, 5, 1, 5));
        this.spawnableWaterCreatureList.clear();
        this.spawnableWaterCreatureList.add(new SpawnListEntry(EntityPearcelSquid.class, 10, 1, 3));
    }

    @Override
    public int getBiomeGrassColor(int x, int y, int z){
        return 65280;
    }

    @Override
    public int getBiomeFoliageColor(int x, int y, int z){
        return 65280;
    }

    @Override
    public int getSkyColorByTemp(float par1){
        return 65280;
    }

    @Override
    public void decorate(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_)
    {
        super.decorate(p_76728_1_, p_76728_2_, p_76728_3_, p_76728_4_);
        int k = 3 + p_76728_2_.nextInt(6);
        int l;
        int i1;
        int j1;

        for (k = 0; k < 7; ++k)
        {
            l = p_76728_3_ + p_76728_2_.nextInt(16);
            i1 = p_76728_2_.nextInt(64);
            j1 = p_76728_4_ + p_76728_2_.nextInt(16);
            this.theWorldGenerator.generate(p_76728_1_, p_76728_2_, l, i1, j1);
        }
    }

}
