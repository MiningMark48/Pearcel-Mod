package com.miningmark48.pearcelmod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class ModelPearcelBoss extends ModelBase {
    public ModelRenderer bipedRightArm;
    public ModelRenderer bipedRightLeg;
    public ModelRenderer bipedLeftLeg;
    public ModelRenderer bipedLeftArm;
    public ModelRenderer bipedBody;
    public ModelRenderer bipedHead;

    public ModelPearcelBoss() {
        this.textureWidth = 64;
        this.textureHeight = 64;

        this.bipedRightArm = new ModelRenderer(this, 0, 32);
        this.bipedRightArm.setRotationPoint(-5.0F, -12.0F, 0.0F);
        this.bipedRightArm.addBox(-1.0F, -2.0F, -1.0F, 2, 30, 2);
        this.setRotationAngles(this.bipedRightArm, 0.0F, 0.0F, 0.0125F);
        this.bipedRightLeg = new ModelRenderer(this, 56, 17);
        this.bipedRightLeg.setRotationPoint(-2.0F, 10.0F, 0.0F);
        this.bipedRightLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 15, 2);
        this.bipedLeftLeg = new ModelRenderer(this, 56, 0);
        this.bipedLeftLeg.setRotationPoint(2.0F, 10.0F, 0.0F);
        this.bipedLeftLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 15, 2);
        this.bipedLeftLeg.mirror = true;
        this.bipedLeftArm = new ModelRenderer(this, 0, 32);
        this.bipedLeftArm.setRotationPoint(5.0F, -12.0F, 0.0F);
        this.bipedLeftArm.addBox(-1.0F, -2.0F, -1.0F, 2, 30, 2);
        this.bipedLeftArm.mirror = true;
        this.setRotationAngles(this.bipedLeftArm, 0.0F, 0.0F, -0.0125F);
        this.bipedBody = new ModelRenderer(this, 32, 3);
        this.bipedBody.setRotationPoint(0.0F, -14.0F, -0.0F);
        this.bipedBody.addBox(-4.0F, 0.0F, -2.0F, 8, 25, 4);
        this.bipedHead = new ModelRenderer(this, 0, 0);
        this.bipedHead.setRotationPoint(0.0F, -14.0F, -0.0F);
        this.bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8);

        this.bipedRightArm.showModel = true;
        this.bipedLeftArm.showModel = true;
        this.bipedRightArm.showModel = true;
        this.bipedLeftLeg.showModel = true;
        this.bipedBody.showModel = true;
        this.bipedHead.showModel = true;

    }

    @Override
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float rotationYaw, float rotationPitch, float scale) {
        setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, rotationYaw, rotationPitch, scale, entity);
        this.bipedRightArm.render(scale);
        this.bipedRightLeg.render(scale);
        this.bipedLeftLeg.render(scale);
        this.bipedLeftArm.render(scale);
        this.bipedBody.render(scale);
        this.bipedHead.render(scale);
    }

    public void setRotationAngles(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        this.bipedHead.rotateAngleX = (f3 / 57.295776F);
        this.bipedHead.rotateAngleZ = (f4 / 57.295776F);
    }

    @Override
    public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float par2, float par3, float partialTickTime) {
        super.setLivingAnimations(entitylivingbaseIn, par2, par3, partialTickTime);

        this.bipedRightLeg.rotateAngleX = MathHelper.cos(par2 * 0.6662F) * 1.4F * par3;
        this.bipedLeftLeg.rotateAngleX = MathHelper.cos(par2 * 0.6662F + (float) Math.PI) * 1.4F * par3;
        this.bipedRightArm.rotateAngleX = MathHelper.cos(par2 * 0.6662F) * 1.4F * par3;
        this.bipedLeftArm.rotateAngleX = MathHelper.cos(par2 * 0.6662F + (float) Math.PI) * 1.4F * par3;

    }

    protected float degToRad(float degrees)
    {
        return degrees * (float)Math.PI / 180 ;
    }

}
