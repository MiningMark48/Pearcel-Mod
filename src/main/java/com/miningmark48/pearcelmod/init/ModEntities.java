package com.miningmark48.pearcelmod.init;

import com.miningmark48.pearcelmod.PearcelMod;
import com.miningmark48.pearcelmod.entity.EntityEnderPearcel;
import com.miningmark48.pearcelmod.entity.EntityPearcelBoss;
import com.miningmark48.pearcelmod.entity.EntityThrowPearcel;
import com.miningmark48.pearcelmod.model.ModelPearcelBoss;
import com.miningmark48.pearcelmod.reference.EntityNames;
import com.miningmark48.pearcelmod.renderer.RenderEnderPearcel;
import com.miningmark48.pearcelmod.renderer.RenderPearcelBoss;
import com.miningmark48.pearcelmod.renderer.RenderThrowPearcel;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModEntities {

    private static int entId = 0;

    public static void init(){
        registerEntities();
    }

    private static void registerEntities() {
        createEntity(EntityNames.getResouce(EntityNames.Pearcel_Boss), EntityPearcelBoss.class, EntityNames.Pearcel_Boss, entId++, 5882444, 4959550);
        EntityRegistry.registerModEntity(EntityNames.getResouce(EntityNames.Throw_Pearcel), EntityThrowPearcel.class, EntityNames.Throw_Pearcel, entId++, PearcelMod.instance, 64, 1, false);
        EntityRegistry.registerModEntity(EntityNames.getResouce(EntityNames.Ender_Pearcel), EntityEnderPearcel.class, EntityNames.Ender_Pearcel, 10, PearcelMod.instance, 350, 50, true);
        //addSpawns(EntityPearcelBoss.class, 2, 0, 1, EnumCreatureType.MONSTER, new Biome[]{Biomes.PLAINS});
    }

    private static void createEntity(ResourceLocation resourceLocation, Class entityClass, String entityName, int id, int solidColor, int spotColor){
        EntityRegistry.registerModEntity(resourceLocation, entityClass, entityName, id, PearcelMod.instance, 64, 3, true, solidColor, spotColor);
    }

    private static void createEntity(ResourceLocation resourceLocation, Class entityClass, String entityName, int id, int trackindRange, int updateFreq, int solidColor, int spotColor){
        EntityRegistry.registerModEntity(resourceLocation, entityClass, entityName, id, PearcelMod.instance, trackindRange, updateFreq, true, solidColor, spotColor);
    }

    private static void addSpawns(Class entityClass, int i, int j, int k, EnumCreatureType type, Biome[] biome){
        EntityRegistry.addSpawn(entityClass, i, j, k, type, biome);
    }

    @SideOnly(Side.CLIENT)
    @SuppressWarnings("deprecation")
    public static void registerRenders(){
        RenderingRegistry.registerEntityRenderingHandler(EntityPearcelBoss.class, new RenderPearcelBoss(new ModelPearcelBoss(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityEnderPearcel.class, new RenderEnderPearcel(Minecraft.getMinecraft().getRenderManager(), ModItems.ender_pearcel, null));
        RenderingRegistry.registerEntityRenderingHandler(EntityThrowPearcel.class, new RenderThrowPearcel(Minecraft.getMinecraft().getRenderManager(), ModItems.pearcel_item, Minecraft.getMinecraft().getRenderItem()));
    }

}
