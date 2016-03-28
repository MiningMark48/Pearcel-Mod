package com.miningmark48.pearcelmod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSummoner extends ModelBase {
    public ModelRenderer shape1;
    public ModelRenderer shape2;
    public ModelRenderer shape3;
    public ModelRenderer shape4;
    public ModelRenderer shape6;
    public ModelRenderer shape7;
    public ModelRenderer shape8;
    public ModelRenderer shape9;
    public ModelRenderer shape10;
    public ModelRenderer shape11;
    public ModelRenderer shape12;
    public ModelRenderer shape13;
    public ModelRenderer shape14;
    public ModelRenderer shape15;

    public ModelSummoner() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.shape6 = new ModelRenderer(this, 1, 0);
        this.shape6.setRotationPoint(-1.0F, 9.0F, -1.0F);
        this.shape6.addBox(0.0F, 0.0F, 0.0F, 2, 15, 2, 0.0F);
        this.shape7 = new ModelRenderer(this, 30, 30);
        this.shape7.setRotationPoint(-2.0F, 8.0F, -2.0F);
        this.shape7.addBox(0.0F, 0.0F, 0.0F, 4, 1, 4, 0.0F);
        this.shape12 = new ModelRenderer(this, 0, 20);
        this.shape12.setRotationPoint(-1.0F, 8.0F, -9.0F);
        this.shape12.addBox(0.0F, 0.0F, 0.0F, 2, 1, 7, 0.0F);
        this.shape10 = new ModelRenderer(this, 0, 30);
        this.shape10.setRotationPoint(-9.0F, 8.0F, -1.0F);
        this.shape10.addBox(0.0F, 0.0F, 0.0F, 7, 1, 2, 0.0F);
        this.shape9 = new ModelRenderer(this, 15, 20);
        this.shape9.setRotationPoint(-1.0F, 7.0F, 8.0F);
        this.shape9.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
        this.shape4 = new ModelRenderer(this, 15, 0);
        this.shape4.setRotationPoint(-1.0F, 23.0F, 1.0F);
        this.shape4.addBox(0.0F, 0.0F, 0.0F, 2, 1, 7, 0.0F);
        this.shape15 = new ModelRenderer(this, 25, 20);
        this.shape15.setRotationPoint(8.0F, 7.0F, -1.0F);
        this.shape15.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.shape3 = new ModelRenderer(this, 30, 10);
        this.shape3.setRotationPoint(-8.0F, 23.0F, -1.0F);
        this.shape3.addBox(0.0F, 0.0F, 0.0F, 7, 1, 2, 0.0F);
        this.shape2 = new ModelRenderer(this, 30, 10);
        this.shape2.setRotationPoint(1.0F, 23.0F, -1.0F);
        this.shape2.addBox(0.0F, 0.0F, 0.0F, 7, 1, 2, 0.0F);
        this.shape8 = new ModelRenderer(this, 0, 20);
        this.shape8.setRotationPoint(-1.0F, 8.0F, 2.0F);
        this.shape8.addBox(0.0F, 0.0F, 0.0F, 2, 1, 7, 0.0F);
        this.shape13 = new ModelRenderer(this, 15, 20);
        this.shape13.setRotationPoint(-1.0F, 7.0F, -9.0F);
        this.shape13.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
        this.shape14 = new ModelRenderer(this, 0, 30);
        this.shape14.setRotationPoint(2.0F, 8.0F, -1.0F);
        this.shape14.addBox(0.0F, 0.0F, 0.0F, 7, 1, 2, 0.0F);
        this.shape1 = new ModelRenderer(this, 15, 0);
        this.shape1.setRotationPoint(-1.0F, 23.0F, -8.0F);
        this.shape1.addBox(0.0F, 0.0F, 0.0F, 2, 1, 7, 0.0F);
        this.shape11 = new ModelRenderer(this, 25, 20);
        this.shape11.setRotationPoint(-9.0F, 7.0F, -1.0F);
        this.shape11.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.shape6.render(f5);
        this.shape7.render(f5);
        this.shape12.render(f5);
        this.shape10.render(f5);
        this.shape9.render(f5);
        this.shape4.render(f5);
        this.shape15.render(f5);
        this.shape3.render(f5);
        this.shape2.render(f5);
        this.shape8.render(f5);
        this.shape13.render(f5);
        this.shape14.render(f5);
        this.shape1.render(f5);
        this.shape11.render(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
