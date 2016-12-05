package com.miningmark48.pearcelmod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelPearcelBoss extends ModelBase{

    ModelRenderer Leg1;
    ModelRenderer Leg2;
    ModelRenderer Body1;
    ModelRenderer Arm1;
    ModelRenderer Arm2;
    ModelRenderer Head;

    public ModelPearcelBoss()
    {
        this.textureWidth = 128;
        this.textureHeight = 128;

        this.Leg1 = new ModelRenderer(this, 2, 52);
        this.Leg1.addBox(0.0F, 0.0F, 0.0F, 2, 17, 2);
        this.Leg1.setRotationPoint(-5.0F, 7.0F, -1.0F);
        this.Leg1.setTextureSize(128, 128);
        this.Leg1.showModel = true;
        setRotation(this.Leg1, 0.0F, 0.0F, 0.0F);
        this.Leg2 = new ModelRenderer(this, 2, 52);
        this.Leg2.addBox(0.0F, 0.0F, 0.0F, 2, 17, 2);
        this.Leg2.setRotationPoint(2.0F, 7.0F, -1.0F);
        this.Leg2.setTextureSize(128, 128);
        this.Leg2.showModel = true;
        setRotation(this.Leg2, 0.0F, 0.0F, 0.0F);
        this.Body1 = new ModelRenderer(this, 0, 32);
        this.Body1.addBox(0.0F, 0.0F, 0.0F, 11, 13, 4);
        this.Body1.setRotationPoint(-6.0F, -6.0F, -2.0F);
        this.Body1.setTextureSize(128, 128);
        this.Body1.showModel = true;
        setRotation(this.Body1, 0.0F, 0.0F, 0.0F);
        this.Arm1 = new ModelRenderer(this, 32, 32);
        this.Arm1.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2);
        this.Arm1.setRotationPoint(-8.0F, -6.0F, -1.0F);
        this.Arm1.setTextureSize(128, 128);
        this.Arm1.showModel = true;
        setRotation(this.Arm1, 0.0F, 0.0F, 0.0F);
        this.Arm2 = new ModelRenderer(this, 32, 32);
        this.Arm2.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2);
        this.Arm2.setRotationPoint(5.0F, -6.0F, -1.0F);
        this.Arm2.setTextureSize(128, 128);
        this.Arm2.showModel = true;
        setRotation(this.Arm2, 0.0F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.addBox(0.0F, 0.0F, 0.0F, 9, 9, 9);
        this.Head.setRotationPoint(-5.0F, -15.0F, -5.0F);
        this.Head.setTextureSize(128, 128);
        this.Head.showModel = true;
        setRotation(this.Head, 0.0F, 0.0F, 0.0F);
    }

    @Override
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        super.render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);
        this.Leg1.render(scale);
        this.Leg2.render(scale);
        this.Body1.render(scale);
        this.Arm1.render(scale);
        this.Arm2.render(scale);
        this.Head.render(scale);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.offsetX = x;
        model.offsetY = y;
        model.offsetZ = z;
    }



    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        this.Head.rotationPointX = (f3 / 57.295776F);
        this.Head.rotationPointZ = (f4 / 57.295776F);
        this.Leg1.rotationPointZ = (MathHelper.floor_float(f * 0.5F + 3.1415927F) * 1.5F * f1);
        this.Leg2.rotationPointZ = (MathHelper.floor_float(f * 0.5F + 3.1415927F) * 1.5F * f1 * -1.0F);
        this.Arm1.rotationPointZ = (MathHelper.floor_float(f * 0.5F + 3.1415927F) * 1.5F * f1);
        this.Arm2.rotationPointY = (MathHelper.floor_float(f * 0.5F + 3.1415927F) * 1.5F * f1 * -1.0F);
    }


}
