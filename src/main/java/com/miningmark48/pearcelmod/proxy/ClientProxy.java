package com.miningmark48.pearcelmod.proxy;

import com.miningmark48.pearcelmod.client.settings.Keybindings;
import com.miningmark48.pearcelmod.init.ModBlocks;
import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.mob.*;
import com.miningmark48.pearcelmod.model.ModelPearcelMob;
import com.miningmark48.pearcelmod.model.ModelPearson;
import com.miningmark48.pearcelmod.renderer.RenderItemPearcelPainting;
import com.miningmark48.pearcelmod.renderer.RenderItemPearcelStaff;
import com.miningmark48.pearcelmod.renderer.RenderPearcelPainting;
import com.miningmark48.pearcelmod.tileentity.TileEntityPearcelPainting;
import com.miningmark48.pearcelmod.utility.LogHelper;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelCow;
import net.minecraft.client.model.ModelSquid;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.MinecraftForgeClient;

import java.io.File;

public class ClientProxy extends CommonProxy{

    public void registerRenderThings(){
    //Mobs
        //Pearcel Cow
        RenderingRegistry.registerEntityRenderingHandler(EntityPearcelCow.class, new RenderPearcelCow(new ModelCow(), 0));
        //Pearcel Squid
        RenderingRegistry.registerEntityRenderingHandler(EntityPearcelSquid.class, new RenderPearcelSquid(new ModelSquid(), 0));
        //Pearcel Mob
        RenderingRegistry.registerEntityRenderingHandler(EntityPearcelMob.class, new RenderPearcelMob(new ModelPearcelMob(), 0));
        //Pearson
        RenderingRegistry.registerEntityRenderingHandler(EntityPearson.class, new RenderPearson(new ModelPearson(), 0));
    //Blocks
        //Pearcel Painting
        TileEntitySpecialRenderer render = new RenderPearcelPainting();
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPearcelPainting.class, render);
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.pearcelPainting), new RenderItemPearcelPainting(render, new TileEntityPearcelPainting()));
    //Items
        MinecraftForgeClient.registerItemRenderer(ModItems.pearcelStaff, new RenderItemPearcelStaff());
    }

    public void registerTileEntitySpecialRenderer(){

    }
}
