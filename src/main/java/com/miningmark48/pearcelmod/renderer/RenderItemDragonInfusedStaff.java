package com.miningmark48.pearcelmod.renderer;

import com.miningmark48.pearcelmod.model.ModelPearcelStaff;
import com.miningmark48.pearcelmod.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class RenderItemDragonInfusedStaff implements IItemRenderer{

    protected ModelPearcelStaff model;

    public RenderItemDragonInfusedStaff(){

        model = new ModelPearcelStaff();

    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        switch(type){
            case EQUIPPED:
            case EQUIPPED_FIRST_PERSON:
                return true;
            default: return false;
        }
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return false;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {

        switch(type){
            case EQUIPPED:
            case EQUIPPED_FIRST_PERSON:
                GL11.glPushMatrix();

                Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/model/dragonInfusedStaff.png"));

                GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
                GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(45.0F, 0.0F, 0.0F, 1.0F);

                GL11.glTranslatef(1.0F, -0.5F, 0.0F);

                GL11.glScalef(0.65F, 0.9F, 0.65F);

                model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);

                GL11.glPopMatrix();
            default:
                break;

        }

    }

}
