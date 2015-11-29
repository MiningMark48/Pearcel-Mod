package com.miningmark48.pearcelmod.renderer;

import com.miningmark48.pearcelmod.entity.EntityPTNT;
import com.miningmark48.pearcelmod.init.ModBlocks;
import com.miningmark48.pearcelmod.reference.Reference;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderTNTPrimed;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderPTNT extends RenderTNTPrimed{

    public RenderBlocks blockRenderer = new RenderBlocks();

    public ResourceLocation getEntityTexture(EntityPTNT par1)
    {
        return new ResourceLocation(Reference.MOD_ID + ":textures/blocks/pearcelBlock.png");
    }

    public void doRender(EntityPTNT p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)p_76986_2_, (float)p_76986_4_, (float)p_76986_6_);
        float f2;

        if ((float)p_76986_1_.fuse - p_76986_9_ + 1.0F < 10.0F)
        {
            f2 = 1.0F - ((float)p_76986_1_.fuse - p_76986_9_ + 1.0F) / 10.0F;

            if (f2 < 0.0F)
            {
                f2 = 0.0F;
            }

            if (f2 > 1.0F)
            {
                f2 = 1.0F;
            }

            f2 *= f2;
            f2 *= f2;
            float f3 = 1.0F + f2 * 0.3F;
            GL11.glScalef(f3, f3, f3);
        }

        f2 = (1.0F - ((float)p_76986_1_.fuse - p_76986_9_ + 1.0F) / 100.0F) * 0.8F;
        this.bindEntityTexture(p_76986_1_);
        this.blockRenderer.renderBlockAsItem(ModBlocks.pearcelBlock, 0, p_76986_1_.getBrightness(p_76986_9_));

        if (p_76986_1_.fuse / 5 % 2 == 0)
        {
            GL11.glDisable(GL11.GL_TEXTURE_2D);
            GL11.glDisable(GL11.GL_LIGHTING);
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_DST_ALPHA);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, f2);
            this.blockRenderer.renderBlockAsItem(ModBlocks.pearcelBlock, 0, 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glDisable(GL11.GL_BLEND);
            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glEnable(GL11.GL_TEXTURE_2D);
        }

        GL11.glPopMatrix();
    }

    @Override
    public ResourceLocation getEntityTexture(Entity par1)
    {
        return this.getEntityTexture((EntityPTNT)par1);
    }

    @Override
    public void doRender(Entity entity, double par2, double par3, double par4, float par5, float par6)
    {
        this.doRender((EntityPTNT)entity, par2, par3, par4, par5, par6);
    }

}
