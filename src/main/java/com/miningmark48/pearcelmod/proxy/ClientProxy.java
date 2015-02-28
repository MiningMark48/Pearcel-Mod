package com.miningmark48.pearcelmod.proxy;

import com.miningmark48.pearcelmod.init.ModBlocks;
import com.miningmark48.pearcelmod.mob.EntityPearcelCow;
import com.miningmark48.pearcelmod.mob.RenderPearcelCow;
import com.miningmark48.pearcelmod.renderer.RenderItemPearcelPainting;
import com.miningmark48.pearcelmod.renderer.RenderPearcelPainting;
import com.miningmark48.pearcelmod.tileentity.TileEntityPearcelPainting;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.model.ModelCow;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends ServerProxy{

    public void registerRenderThings(){
    //Mobs
        //Pearcel Cow
        RenderingRegistry.registerEntityRenderingHandler(EntityPearcelCow.class, new RenderPearcelCow(new ModelCow(), 0));
    //Blocks
        //Pearcel Painting
        TileEntitySpecialRenderer render = new RenderPearcelPainting();
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPearcelPainting.class, render);
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.pearcelPainting), new RenderItemPearcelPainting(render, new TileEntityPearcelPainting()));
    }

    public void registerTileEntitySpecialRenderer(){

    }

}
