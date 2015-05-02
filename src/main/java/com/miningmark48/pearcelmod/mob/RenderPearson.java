package com.miningmark48.pearcelmod.mob;

import com.miningmark48.pearcelmod.reference.Reference;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderPearson extends RenderLiving{

    private static final ResourceLocation mobTextures = new ResourceLocation(Reference.MOD_ID + ":textures/entity/pearson.png");

    public RenderPearson(ModelBase par1ModelBase, float par2){
        super(par1ModelBase, par2);
    }

    protected ResourceLocation getEntityTexture(EntityPearson entity){
        return mobTextures;
    }

    protected ResourceLocation getEntityTexture(Entity entity){
        return this.getEntityTexture((EntityPearson)entity);
    }

}
