package com.miningmark48.pearcelmod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPearcelStaff extends ModelBase
{
  //fields
    ModelRenderer Shaft;
    ModelRenderer Pearcel1;
    ModelRenderer Pearcel2;
    ModelRenderer Pearcel3;
    ModelRenderer Pearcel4;
    ModelRenderer Pearcel5;
    ModelRenderer Pearcel6;
    ModelRenderer Stem1;
    ModelRenderer Stem2;
  
  public ModelPearcelStaff()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      Shaft = new ModelRenderer(this, 0, 44);
      Shaft.addBox(0F, 0F, 0F, 3, 17, 3);
      Shaft.setRotationPoint(-2F, 7F, -2F);
      Shaft.setTextureSize(64, 64);
      Shaft.mirror = true;
      setRotation(Shaft, 0F, 0F, 0F);
      Pearcel1 = new ModelRenderer(this, 0, 38);
      Pearcel1.addBox(0F, 0F, 0F, 5, 1, 5);
      Pearcel1.setRotationPoint(-3F, 6F, -3F);
      Pearcel1.setTextureSize(64, 64);
      Pearcel1.mirror = true;
      setRotation(Pearcel1, 0F, 0F, 0F);
      Pearcel2 = new ModelRenderer(this, 0, 30);
      Pearcel2.addBox(0F, 0F, 0F, 7, 1, 7);
      Pearcel2.setRotationPoint(-4F, 5F, -4F);
      Pearcel2.setTextureSize(64, 64);
      Pearcel2.mirror = true;
      setRotation(Pearcel2, 0F, 0F, 0F);
      Pearcel3 = new ModelRenderer(this, 0, 17);
      Pearcel3.addBox(0F, 0F, 0F, 9, 4, 9);
      Pearcel3.setRotationPoint(-5F, 1F, -5F);
      Pearcel3.setTextureSize(64, 64);
      Pearcel3.mirror = true;
      setRotation(Pearcel3, 0F, 0F, 0F);
      Pearcel4 = new ModelRenderer(this, 0, 9);
      Pearcel4.addBox(0F, 0F, 0F, 7, 1, 7);
      Pearcel4.setRotationPoint(-4F, 0F, -4F);
      Pearcel4.setTextureSize(64, 64);
      Pearcel4.mirror = true;
      setRotation(Pearcel4, 0F, 0F, 0F);
      Pearcel5 = new ModelRenderer(this, 0, 3);
      Pearcel5.addBox(0F, 0F, 0F, 5, 1, 5);
      Pearcel5.setRotationPoint(-3F, -1F, -3F);
      Pearcel5.setTextureSize(64, 64);
      Pearcel5.mirror = true;
      setRotation(Pearcel5, 0F, 0F, 0F);
      Pearcel6 = new ModelRenderer(this, 23, 0);
      Pearcel6.addBox(0F, 0F, 0F, 3, 1, 3);
      Pearcel6.setRotationPoint(-2F, -2F, -2F);
      Pearcel6.setTextureSize(64, 64);
      Pearcel6.mirror = true;
      setRotation(Pearcel6, 0F, 0F, 0F);
      Stem1 = new ModelRenderer(this, 40, 0);
      Stem1.addBox(0F, 0F, 0F, 1, 2, 1);
      Stem1.setRotationPoint(-1F, -4F, -1F);
      Stem1.setTextureSize(64, 64);
      Stem1.mirror = true;
      setRotation(Stem1, 0F, 0F, 0F);
      Stem2 = new ModelRenderer(this, 44, 0);
      Stem2.addBox(0F, 0F, 0F, 1, 2, 1);
      Stem2.setRotationPoint(0F, -5F, -1F);
      Stem2.setTextureSize(64, 64);
      Stem2.mirror = true;
      setRotation(Stem2, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shaft.render(f5);
    Pearcel1.render(f5);
    Pearcel2.render(f5);
    Pearcel3.render(f5);
    Pearcel4.render(f5);
    Pearcel5.render(f5);
    Pearcel6.render(f5);
    Stem1.render(f5);
    Stem2.render(f5);
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
