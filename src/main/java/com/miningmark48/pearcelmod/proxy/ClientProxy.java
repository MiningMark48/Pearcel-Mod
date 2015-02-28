package com.miningmark48.pearcelmod.proxy;

import com.miningmark48.pearcelmod.mob.EntityPearcelCow;
import com.miningmark48.pearcelmod.mob.RenderPearcelCow;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.model.ModelCow;

public class ClientProxy extends ServerProxy{

    public void registerRenderThings(){
        RenderingRegistry.registerEntityRenderingHandler(EntityPearcelCow.class, new RenderPearcelCow(new ModelCow(), 0));
    }

}
