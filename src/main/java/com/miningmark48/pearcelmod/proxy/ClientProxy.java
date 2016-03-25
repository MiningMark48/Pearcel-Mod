package com.miningmark48.pearcelmod.proxy;

import com.miningmark48.pearcelmod.entity.EntityPTNT;
import com.miningmark48.pearcelmod.entity.EntityPearcelPearl;
import com.miningmark48.pearcelmod.init.ModBlocks;
import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.mob.*;
import com.miningmark48.pearcelmod.model.ModelPearcelMob;
import com.miningmark48.pearcelmod.model.ModelPearson;
import com.miningmark48.pearcelmod.renderer.*;
import com.miningmark48.pearcelmod.tileentity.TileEntityIVET;
import com.miningmark48.pearcelmod.tileentity.TileEntityPearcelPlush;
import com.miningmark48.pearcelmod.tileentity.TileEntityTorcher;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.model.ModelCow;
import net.minecraft.client.model.ModelSquid;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

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
        //Pearcel Plush
        TileEntitySpecialRenderer renderPPlush = new RenderPearcelPlush();
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPearcelPlush.class, renderPPlush);
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.pearcelPlush), new RenderItemPearcelPlush());
        //IVET
        TileEntitySpecialRenderer renderIVET = new RenderIVET();
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityIVET.class, renderIVET);
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.ivet), new RenderItemIVET());
        //TNT
        RenderingRegistry.registerEntityRenderingHandler(EntityPTNT.class, new RenderPTNT());
        //Torcher
        TileEntitySpecialRenderer renderTorcher = new RenderTorcher();
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTorcher.class, renderTorcher);
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.torcher), new RenderItemTorcher());
    //Items
        MinecraftForgeClient.registerItemRenderer(ModItems.pearcelStaff, new RenderItemPearcelStaff());
        RenderingRegistry.registerEntityRenderingHandler(EntityPearcelPearl.class, new RenderPearcelPearl(ModItems.pearcelPearl));

        //MinecraftForgeClient.registerItemRenderer(ModItems.pearcel, new RenderItemPearcel());
    }
    //Armor
    public int addArmor(String armor){
        return RenderingRegistry.addNewArmourRendererPrefix(armor);
    }

    public void registerTileEntitySpecialRenderer(){

    }
}
