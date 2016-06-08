package com.miningmark48.pearcelmod.proxy;

import com.miningmark48.pearcelmod.entity.EntityEnderPearcel;
import com.miningmark48.pearcelmod.init.ModBlocks;
import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.renderer.RenderEnderPearcel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy{

    @Override
    public void registerRenders(){
        ModItems.registerRenders();
        ModBlocks.registerRenders();

        //RenderingRegistry.registerEntityRenderingHandler(EntityEnderPearcel.class, new RenderEnderPearcel(Minecraft.getMinecraft().getRenderManager(), ModItems.ender_pearcel, null));

    }
}
