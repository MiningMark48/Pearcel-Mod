package com.miningmark48.pearcelmod.renderer;

import com.miningmark48.pearcelmod.entity.EntityThrowPearcel;
import com.miningmark48.pearcelmod.init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nonnull;

public class RenderThrowPearcel extends RenderSnowball<EntityThrowPearcel>{

    public static final IRenderFactory<EntityThrowPearcel> FACTORY = new Factory();

    public RenderThrowPearcel(RenderManager renderManagerIn, Item itemIn, RenderItem itemRendererIn) {
        super(renderManagerIn, itemIn, itemRendererIn);
    }

    @Nonnull
    @Override
    public ItemStack getStackToRender(EntityThrowPearcel entityIn) {
        if (entityIn.type != null){
            return new ItemStack(item, 1, entityIn.type.ordinal());
        }
        return null;
    }

    private static class Factory implements IRenderFactory<EntityThrowPearcel>{

        @Override
        public Render<? super EntityThrowPearcel> createRenderFor(RenderManager manager) {
            return new RenderThrowPearcel(manager, ModItems.pearcel_item, Minecraft.getMinecraft().getRenderItem());
    }
    }

}
