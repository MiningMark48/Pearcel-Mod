package com.miningmark48.pearcelmod.proxy;

import com.miningmark48.pearcelmod.handler.KeyHandler;
import com.miningmark48.pearcelmod.init.ModBlocks;
import com.miningmark48.pearcelmod.init.ModItems;
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

        //RenderingRegistry.registerEntityRenderingHandler(EntityEnderPearcel.class, new RenderEnderPearcel(Minecraft.getMinecraft().getRenderManager(), ModItems.ender_pearcel, null));

    }
}
