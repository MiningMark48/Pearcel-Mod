package com.miningmark48.pearcelmod.proxy;

import com.miningmark48.pearcelmod.entity.EntityEnderPearcel;
import com.miningmark48.pearcelmod.entity.EntityPearcelBoss;
import com.miningmark48.pearcelmod.handler.KeyHandler;
import com.miningmark48.pearcelmod.init.ModBlocks;
import com.miningmark48.pearcelmod.init.ModEntities;
import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.model.ModelPearcelBoss;
import com.miningmark48.pearcelmod.renderer.RenderPearcelBoss;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy{

    @Override
    public void init(){
        MinecraftForge.EVENT_BUS.register(new KeyHandler());
    }

    @Override
    public void registerRenders(){
        ModItems.registerRenders();
        ModBlocks.registerRenders();
        ModEntities.registerRenders();

        //RenderingRegistry.registerEntityRenderingHandler(EntityEnderPearcel.class, new RenderEnderPearcel(Minecraft.getMinecraft().getRenderManager(), ModItems.ender_pearcel, null));

    }

    @Override
    public void openMyGuiClient(GuiScreen screen){
        Minecraft.getMinecraft().displayGuiScreen(screen);
    }
}
