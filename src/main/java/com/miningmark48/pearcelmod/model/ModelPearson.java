
package com.miningmark48.pearcelmod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelPearson extends ModelBase
{
  //fields
    ModelRenderer Leg1;
    ModelRenderer Leg2;
    ModelRenderer Body1;
    ModelRenderer Arm1;
    ModelRenderer Arm2;
    ModelRenderer Head;
  
  public ModelPearson()
  {
    textureWidth = 128;
    textureHeight = 128;
    
      Leg1 = new ModelRenderer(this, 2, 52);
      Leg1.addBox(0F, 0F, 0F, 2, 17, 2);
      Leg1.setRotationPoint(-5F, 7F, -1F);
      Leg1.setTextureSize(128, 128);
      Leg1.mirror = true;
      setRotation(Leg1, 0F, 0F, 0F);
      Leg2 = new ModelRenderer(this, 2, 52);
      Leg2.addBox(0F, 0F, 0F, 2, 17, 2);
      Leg2.setRotationPoint(2F, 7F, -1F);
      Leg2.setTextureSize(128, 128);
      Leg2.mirror = true;
      setRotation(Leg2, 0F, 0F, 0F);
      Body1 = new ModelRenderer(this, 0, 32);
      Body1.addBox(0F, 0F, 0F, 11, 13, 4);
      Body1.setRotationPoint(-6F, -6F, -2F);
      Body1.setTextureSize(128, 128);
      Body1.mirror = true;
      setRotation(Body1, 0F, 0F, 0F);
      Arm1 = new ModelRenderer(this, 32, 32);
      Arm1.addBox(0F, 0F, 0F, 2, 8, 2);
      Arm1.setRotationPoint(-8F, -6F, -1F);
      Arm1.setTextureSize(128, 128);
      Arm1.mirror = true;
      setRotation(Arm1, 0F, 0F, 0F);
      Arm2 = new ModelRenderer(this, 32, 32);
      Arm2.addBox(0F, 0F, 0F, 2, 8, 2);
      Arm2.setRotationPoint(5F, -6F, -1F);
      Arm2.setTextureSize(128, 128);
      Arm2.mirror = true;
      setRotation(Arm2, 0F, 0F, 0F);
      Head = new ModelRenderer(this, 0, 0);
      Head.addBox(0F, 0F, 0F, 9, 9, 9);
      Head.setRotationPoint(-5F, -15F, -5F);
      Head.setTextureSize(128, 128);
      Head.mirror = true;
      setRotation(Head, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Leg1.render(f5);
    Leg2.render(f5);
    Body1.render(f5);
    Arm1.render(f5);
    Arm2.render(f5);
    Head.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
      //super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      this.Head.rotateAngleY = f3 / (180F / (float)Math.PI);
      this.Head.rotateAngleX = f4 / (180F / (float)Math.PI);
      this.Leg1.rotateAngleX = MathHelper.cos(f * 0.5F + (float)Math.PI) * 1.5F * f1;
      this.Leg2.rotateAngleX = (MathHelper.cos(f * 0.5F + (float)Math.PI) * 1.5F * f1) * -1;
      this.Arm1.rotateAngleX = MathHelper.cos(f * 0.5F + (float)Math.PI) * 1.5F * f1;
      this.Arm2.rotateAngleX = (MathHelper.cos(f * 0.5F + (float)Math.PI) * 1.5F * f1) * -1;
  }

}
