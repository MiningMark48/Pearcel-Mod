package com.miningmark48.pearcelmod.renderer;

import com.miningmark48.pearcelmod.model.ModelPearcelPainting;
import com.miningmark48.pearcelmod.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

public class RenderPearcelPainting extends TileEntitySpecialRenderer{

    private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID + ":textures/model/pearcelPainting.png");
    private ModelPearcelPainting model;

    public RenderPearcelPainting(){
        this.model = new ModelPearcelPainting();
    }

    @Override
    public void renderTileEntityAt(TileEntity entity, double x, double y, double z, float f) {
        GL11.glPushMatrix();
            GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
            GL11.glRotatef(180, 0F, 0F, 1F);
            this.bindTexture(texture);
            GL11.glPushMatrix();
                this.model.renderModel(0.0625F);
            GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

}
