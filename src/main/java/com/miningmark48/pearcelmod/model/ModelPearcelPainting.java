package com.miningmark48.pearcelmod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPearcelPainting extends ModelBase
{
  //fields
    ModelRenderer Back;
    ModelRenderer Frame1;
    ModelRenderer Frame2;
    ModelRenderer Frame3;
    ModelRenderer Frame4;
  
  public ModelPearcelPainting()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      Back = new ModelRenderer(this, 0, 0);
      Back.addBox(0F, 0F, 0F, 16, 12, 1);
      Back.setRotationPoint(-8F, 12F, 7F);
      Back.setTextureSize(64, 64);
      Back.mirror = true;
      setRotation(Back, 0F, 0F, 0F);
      Frame1 = new ModelRenderer(this, 0, 0);
      Frame1.addBox(0F, 0F, 0F, 16, 1, 1);
      Frame1.setRotationPoint(-8F, 12F, 6F);
      Frame1.setTextureSize(64, 64);
      Frame1.mirror = true;
      setRotation(Frame1, 0F, 0F, 0F);
      Frame2 = new ModelRenderer(this, 0, 0);
      Frame2.addBox(0F, 0F, 0F, 16, 1, 1);
      Frame2.setRotationPoint(-8F, 23F, 6F);
      Frame2.setTextureSize(64, 64);
      Frame2.mirror = true;
      setRotation(Frame2, 0F, 0F, 0F);
      Frame3 = new ModelRenderer(this, 0, 0);
      Frame3.addBox(0F, 0F, 0F, 12, 1, 1);
      Frame3.setRotationPoint(-7F, 12F, 6F);
      Frame3.setTextureSize(64, 64);
      Frame3.mirror = true;
      setRotation(Frame3, 0F, 0F, 1.570796F);
      Frame4 = new ModelRenderer(this, 0, 0);
      Frame4.addBox(0F, 0F, 0F, 12, 1, 1);
      Frame4.setRotationPoint(8F, 12F, 6F);
      Frame4.setTextureSize(64, 64);
      Frame4.mirror = true;
      setRotation(Frame4, 0F, 0F, 1.570796F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Back.render(f5);
    Frame1.render(f5);
    Frame2.render(f5);
    Frame3.render(f5);
    Frame4.render(f5);
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

  public void renderModel(float f){
      Back.render(f);
      Frame1.render(f);
      Frame2.render(f);
      Frame3.render(f);
      Frame4.render(f);
  }
}
