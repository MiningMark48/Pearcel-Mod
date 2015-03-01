package com.miningmark48.pearcelmod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPearcelMob extends ModelBase
{
  //fields
    ModelRenderer Leg1;
    ModelRenderer Leg2;
    ModelRenderer Body1;
    ModelRenderer Body2;
    ModelRenderer Body3;
    ModelRenderer Body5;
    ModelRenderer Body6;
    ModelRenderer Body7;
    ModelRenderer Body8;
    ModelRenderer Stem1;
    ModelRenderer Stem2;
    ModelRenderer Stem3;
  
  public ModelPearcelMob()
  {
    textureWidth = 64;
    textureHeight = 128;
    
      Leg1 = new ModelRenderer(this, 0, 122);
      Leg1.addBox(0F, 0F, 0F, 1, 5, 1);
      Leg1.setRotationPoint(-4F, 19F, 0F);
      Leg1.setTextureSize(64, 128);
      Leg1.mirror = true;
      setRotation(Leg1, 0F, 0F, 0F);
      Leg2 = new ModelRenderer(this, 4, 121);
      Leg2.addBox(0F, 0F, 0F, 1, 5, 1);
      Leg2.setRotationPoint(2F, 19F, 0F);
      Leg2.setTextureSize(64, 128);
      Leg2.mirror = true;
      setRotation(Leg2, 0F, 0F, 0F);
      Body1 = new ModelRenderer(this, 36, 102);
      Body1.addBox(0F, 0F, 0F, 7, 1, 7);
      Body1.setRotationPoint(-4F, 18F, -3F);
      Body1.setTextureSize(64, 128);
      Body1.mirror = true;
      setRotation(Body1, 0F, 0F, 0F);
      Body2 = new ModelRenderer(this, 28, 90);
      Body2.addBox(0F, 0F, 0F, 9, 1, 9);
      Body2.setRotationPoint(-5F, 17F, -4F);
      Body2.setTextureSize(64, 128);
      Body2.mirror = true;
      setRotation(Body2, 0F, 0F, 0F);
      Body3 = new ModelRenderer(this, 20, 112);
      Body3.addBox(0F, 0F, 0F, 11, 5, 11);
      Body3.setRotationPoint(-6F, 12F, -5F);
      Body3.setTextureSize(64, 128);
      Body3.mirror = true;
      setRotation(Body3, 0F, 0F, 0F);
      Body5 = new ModelRenderer(this, 28, 78);
      Body5.addBox(0F, 0F, 0F, 9, 1, 9);
      Body5.setRotationPoint(-5F, 11F, -4F);
      Body5.setTextureSize(64, 128);
      Body5.mirror = true;
      setRotation(Body5, 0F, 0F, 0F);
      Body6 = new ModelRenderer(this, 36, 68);
      Body6.addBox(0F, 0F, 0F, 7, 1, 7);
      Body6.setRotationPoint(-4F, 10F, -3F);
      Body6.setTextureSize(64, 128);
      Body6.mirror = true;
      setRotation(Body6, 0F, 0F, 0F);
      Body7 = new ModelRenderer(this, 44, 58);
      Body7.addBox(0F, 0F, 0F, 5, 2, 5);
      Body7.setRotationPoint(-3F, 8F, -2F);
      Body7.setTextureSize(64, 128);
      Body7.mirror = true;
      setRotation(Body7, 0F, 0F, 0F);
      Body8 = new ModelRenderer(this, 52, 52);
      Body8.addBox(0F, 0F, 0F, 3, 1, 3);
      Body8.setRotationPoint(-2F, 7F, -1F);
      Body8.setTextureSize(64, 128);
      Body8.mirror = true;
      setRotation(Body8, 0F, 0F, 0F);
      Stem1 = new ModelRenderer(this, 60, 0);
      Stem1.addBox(0F, 0F, 0F, 1, 1, 1);
      Stem1.setRotationPoint(-1F, 6F, 0F);
      Stem1.setTextureSize(64, 128);
      Stem1.mirror = true;
      setRotation(Stem1, 0F, 0F, 0F);
      Stem2 = new ModelRenderer(this, 55, 0);
      Stem2.addBox(0F, 0F, 0F, 1, 3, 1);
      Stem2.setRotationPoint(0F, 4F, 0F);
      Stem2.setTextureSize(64, 128);
      Stem2.mirror = true;
      setRotation(Stem2, 0F, 0F, 0F);
      Stem3 = new ModelRenderer(this, 50, 0);
      Stem3.addBox(0F, 0F, 0F, 1, 1, 1);
      Stem3.setRotationPoint(1F, 4F, 0F);
      Stem3.setTextureSize(64, 128);
      Stem3.mirror = true;
      setRotation(Stem3, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Leg1.render(f5);
    Leg2.render(f5);
    Body1.render(f5);
    Body2.render(f5);
    Body3.render(f5);
    Body5.render(f5);
    Body6.render(f5);
    Body7.render(f5);
    Body8.render(f5);
    Stem1.render(f5);
    Stem2.render(f5);
    Stem3.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
