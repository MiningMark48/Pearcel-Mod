package com.miningmark48.pearcelmod.renderer;

import com.miningmark48.pearcelmod.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderPearcelBoss extends RenderLiving{

    protected ResourceLocation texture;

    public RenderPearcelBoss(ModelBase model, float shadowSize){
        super(Minecraft.getMinecraft().getRenderManager(), model, shadowSize);
        setEntityTexture();
    }

    protected void setEntityTexture(){
        texture = new ResourceLocation(Reference.MOD_ID + ":textures/models/pearcel_boss.png");
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return texture;
    }

}
