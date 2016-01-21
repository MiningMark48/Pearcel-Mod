package com.miningmark48.pearcelmod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelPearcel - MiningMark48
 * Created using Tabula 5.1.0
 */
public class ModelPearcel extends ModelBase {
    public ModelRenderer shape1;
    public ModelRenderer shape2;
    public ModelRenderer shape3;
    public ModelRenderer shape4;
    public ModelRenderer shape5;
    public ModelRenderer shape6;
    public ModelRenderer shape7;
    public ModelRenderer shape8;
    public ModelRenderer shape9;
    public ModelRenderer shape10;

    public ModelPearcel() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.shape3 = new ModelRenderer(this, 0, 0);
        this.shape3.setRotationPoint(-5.0F, 21.0F, -5.0F);
        this.shape3.addBox(0.0F, 0.0F, 0.0F, 10, 1, 10, 0.0F);
        this.shape6 = new ModelRenderer(this, 0, 0);
        this.shape6.setRotationPoint(-4.0F, 11.0F, -4.0F);
        this.shape6.addBox(0.0F, 0.0F, 0.0F, 8, 2, 8, 0.0F);
        this.shape5 = new ModelRenderer(this, 0, 0);
        this.shape5.setRotationPoint(-5.0F, 13.0F, -5.0F);
        this.shape5.addBox(0.0F, 0.0F, 0.0F, 10, 2, 10, 0.0F);
        this.shape1 = new ModelRenderer(this, 0, 0);
        this.shape1.setRotationPoint(-3.0F, 23.0F, -3.0F);
        this.shape1.addBox(0.0F, 0.0F, 0.0F, 6, 1, 6, 0.0F);
        this.shape9 = new ModelRenderer(this, 0, 30);
        this.shape9.setRotationPoint(-3.0F, 8.0F, 0.0F);
        this.shape9.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
        this.shape10 = new ModelRenderer(this, 0, 30);
        this.shape10.setRotationPoint(-3.0F, 7.0F, 0.0F);
        this.shape10.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.shape4 = new ModelRenderer(this, 0, 0);
        this.shape4.setRotationPoint(-6.0F, 15.0F, -6.0F);
        this.shape4.addBox(0.0F, 0.0F, 0.0F, 12, 6, 12, 0.0F);
        this.shape2 = new ModelRenderer(this, 0, 0);
        this.shape2.setRotationPoint(-4.0F, 22.0F, -4.0F);
        this.shape2.addBox(0.0F, 0.0F, 0.0F, 8, 1, 8, 0.0F);
        this.shape8 = new ModelRenderer(this, 0, 30);
        this.shape8.setRotationPoint(-2.0F, 9.0F, 0.0F);
        this.shape8.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.shape7 = new ModelRenderer(this, 0, 0);
        this.shape7.setRotationPoint(-3.0F, 10.0F, -3.0F);
        this.shape7.addBox(0.0F, 0.0F, 0.0F, 6, 1, 6, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.shape3.render(f5);
        this.shape6.render(f5);
        this.shape5.render(f5);
        this.shape1.render(f5);
        this.shape9.render(f5);
        this.shape10.render(f5);
        this.shape4.render(f5);
        this.shape2.render(f5);
        this.shape8.render(f5);
        this.shape7.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
