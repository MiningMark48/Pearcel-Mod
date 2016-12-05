package com.miningmark48.pearcelmod.init;

import com.miningmark48.pearcelmod.PearcelMod;
import com.miningmark48.pearcelmod.entity.EntityPearcelBoss;
import com.miningmark48.pearcelmod.model.ModelPearcelBoss;
import com.miningmark48.pearcelmod.renderer.RenderPearcelBoss;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModEntities {

    private static int entId = 0;

    public static void init(){
        registerEntities();
    }

    private static void registerEntities() {
        createEntity(EntityPearcelBoss.class, "Pearcel Boss", entId++, 5882444, 4959550);
        //addSpawns(EntityPearcelBoss.class, 2, 0, 1, EnumCreatureType.MONSTER, new Biome[]{Biomes.PLAINS});
    }

    private static void createEntity(Class entityClass, String entityName, int id, int solidColor, int spotColor){
        EntityRegistry.registerModEntity(entityClass, entityName, id, PearcelMod.instance, 64, 1, true);

        createEgg(entityName, solidColor, spotColor);
    }

    private static void createEgg(String entityName, int solidColor, int spotColor) {
        EntityList.ENTITY_EGGS.put(entityName, new EntityList.EntityEggInfo(entityName, solidColor, spotColor));
    }

    private static void addSpawns(Class entityClass, int i, int j, int k, EnumCreatureType type, Biome[] biome){
        EntityRegistry.addSpawn(entityClass, i, j, k, type, biome);
    }

    public static void registerRenders(){
        RenderingRegistry.registerEntityRenderingHandler(EntityPearcelBoss.class, new RenderPearcelBoss(new ModelPearcelBoss(), 0.5F));
    }

}
