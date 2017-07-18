package com.miningmark48.pearcelmod.proxy;

import com.google.common.util.concurrent.ListenableFuture;
import com.miningmark48.pearcelmod.entity.EntityThrowPearcel;
import com.miningmark48.pearcelmod.gui.manual.GuiManual;
import com.miningmark48.pearcelmod.handler.KeyHandler;
import com.miningmark48.pearcelmod.init.ModBlocks;
import com.miningmark48.pearcelmod.init.ModEntities;
import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.init.ModRegistry;
import com.miningmark48.pearcelmod.reference.Reference;
import com.miningmark48.pearcelmod.renderer.RenderThrowPearcel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy{

    @Override
    public void preInit(FMLPreInitializationEvent event) {
    }

    @Override
    public void init(FMLInitializationEvent event){
        MinecraftForge.EVENT_BUS.register(new KeyHandler());
    }

    @Override
    public void registerRenders(){
        ModRegistry.registerRenderItems();
        ModRegistry.registerRenderBlocks();
        ModEntities.registerRenders();

        //RenderingRegistry.registerEntityRenderingHandler(EntityEnderPearcel.class, new RenderEnderPearcel(Minecraft.getMinecraft().getRenderManager(), ModItems.ender_pearcel, null));

        RenderingRegistry.registerEntityRenderingHandler(EntityThrowPearcel.class, new RenderThrowPearcel(Minecraft.getMinecraft().getRenderManager(), ModItems.pearcel_item, Minecraft.getMinecraft().getRenderItem()));

    }

    @Override
    public void openManualGuiClient(){
        Minecraft.getMinecraft().displayGuiScreen(new GuiManual(0));
    }

}
