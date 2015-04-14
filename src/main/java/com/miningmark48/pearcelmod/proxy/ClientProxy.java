package com.miningmark48.pearcelmod.proxy;

import com.miningmark48.pearcelmod.init.ModBlocks;
import com.miningmark48.pearcelmod.mob.*;
import com.miningmark48.pearcelmod.model.ModelPearcelMob;
import com.miningmark48.pearcelmod.renderer.RenderItemPearcelPainting;
import com.miningmark48.pearcelmod.renderer.RenderPearcelPainting;
import com.miningmark48.pearcelmod.tileentity.TileEntityPearcelPainting;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelCow;
import net.minecraft.client.model.ModelSquid;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.MinecraftForgeClient;

import java.io.File;

public class ClientProxy extends ServerProxy{

    public void registerRenderThings(){
    //Mobs
        //Pearcel Cow
        RenderingRegistry.registerEntityRenderingHandler(EntityPearcelCow.class, new RenderPearcelCow(new ModelCow(), 0));
        //Pearcel Squid
        RenderingRegistry.registerEntityRenderingHandler(EntityPearcelSquid.class, new RenderPearcelSquid(new ModelSquid(), 0));
        //Pearcel Mob
        RenderingRegistry.registerEntityRenderingHandler(EntityPearcelMob.class, new RenderPearcelMob(new ModelPearcelMob(), 0));
    //Blocks
        //Pearcel Painting
        TileEntitySpecialRenderer render = new RenderPearcelPainting();
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPearcelPainting.class, render);
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.pearcelPainting), new RenderItemPearcelPainting(render, new TileEntityPearcelPainting()));
    }

    public void registerTileEntitySpecialRenderer(){

    }

    public static void addCapes(){
        String capeURL = "http://www.miningmark48.ml/pearcelCape.png";
        String[] owners = {"MiningMark48", "Codyrule040"};

        ThreadDownloadImageData image = new ThreadDownloadImageData(null, capeURL, null, null);

        for (String username : owners){
            Minecraft.getMinecraft().renderEngine.loadTexture(new ResourceLocation("cloaks/" + username), (ITextureObject)image);
        }
    }

}
