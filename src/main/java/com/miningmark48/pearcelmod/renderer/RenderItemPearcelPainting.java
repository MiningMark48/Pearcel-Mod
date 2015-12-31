package com.miningmark48.pearcelmod.renderer;

import com.miningmark48.pearcelmod.model.ModelPearcelPainting;
import com.miningmark48.pearcelmod.tileentity.TileEntityPearcelPainting;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class RenderItemPearcelPainting implements IItemRenderer{

    private final ModelPearcelPainting model;

    public RenderItemPearcelPainting(){
        model = new ModelPearcelPainting();
    }

    @Override
    public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type) {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper) {
        return true;
    }

    @Override
    public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data) {

        if(type != type.ENTITY && type != type.EQUIPPED){
            GL11.glPushMatrix();
            GL11.glScalef(1.0f, 1.0f, 1.0f);
            TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityPearcelPainting(), 0.0D, -0.125D, 0.0D, 0.0F);
            GL11.glPopMatrix();
        }else if(type == type.ENTITY && !(item.getItem() instanceof ItemBlock)){
            GL11.glPushMatrix();
            GL11.glScalef(1.5f, 1.5f, 1.5f);
            TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityPearcelPainting(), 0.0D, -0.15D, 0.0D, 0.0F);
            GL11.glPopMatrix();
        }else if(type == type.ENTITY && item.getItem() instanceof ItemBlock){
            GL11.glPushMatrix();
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityPearcelPainting(), 0.0D, 0.0D, 0.0D, 0.0F);
            GL11.glPopMatrix();
        }else if(type == type.EQUIPPED){
            GL11.glPushMatrix();
            GL11.glScalef(1.1f, 1.1f, 1.1f);
            GL11.glRotatef(45, -1, 0, 0);
            TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityPearcelPainting(), 0.2D, -0.3D, 0.35D, 0.0F);
            GL11.glRotatef(45, -1, 0, 0);
            GL11.glPopMatrix();
        }


    }
}
