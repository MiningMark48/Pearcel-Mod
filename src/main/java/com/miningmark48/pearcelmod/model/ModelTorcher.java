package com.miningmark48.pearcelmod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTorcher extends ModelBase {
    public ModelRenderer base;
    public ModelRenderer top;

    public ModelTorcher() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.base = new ModelRenderer(this, 0, 0);
        this.base.setRotationPoint(-2.0F, 12.0F, -2.0F);
        this.base.addBox(0.0F, 0.0F, 0.0F, 4, 12, 4, 0.0F);
        this.top = new ModelRenderer(this, 19, 0);
        this.top.setRotationPoint(-2.0F, 8.0F, -2.0F);
        this.top.addBox(0.0F, 0.0F, 0.0F, 4, 4, 4, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.base.render(f5);
        this.top.render(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
