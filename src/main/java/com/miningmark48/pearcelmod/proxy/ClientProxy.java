package com.miningmark48.pearcelmod.proxy;

import com.miningmark48.pearcelmod.entity.EntityThrowPearcel;
import com.miningmark48.pearcelmod.gui.manual.GuiManual;
import com.miningmark48.pearcelmod.handler.KeyHandler;
import com.miningmark48.pearcelmod.init.ModBlocks;
import com.miningmark48.pearcelmod.init.ModEntities;
import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.reference.Reference;
import com.miningmark48.pearcelmod.renderer.RenderThrowPearcel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy{

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        OBJLoader.INSTANCE.addDomain(Reference.MOD_ID);

        registerModel(ModItems.pearcel_staff);
    }

    @Override
    public void registerModel(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }

    @Override
    public void init(){
        MinecraftForge.EVENT_BUS.register(new KeyHandler());
    }

    @Override
    public void registerRenders(){
        ModItems.registerRenders();
        ModBlocks.registerRenders();
        ModEntities.registerRenders();

        //RenderingRegistry.registerEntityRenderingHandler(EntityEnderPearcel.class, new RenderEnderPearcel(Minecraft.getMinecraft().getRenderManager(), ModItems.ender_pearcel, null));

        RenderingRegistry.registerEntityRenderingHandler(EntityThrowPearcel.class, new RenderThrowPearcel(Minecraft.getMinecraft().getRenderManager(), ModItems.pearcel_item, Minecraft.getMinecraft().getRenderItem()));

    }

    @Override
    public void openManualGuiClient(){
        Minecraft.getMinecraft().displayGuiScreen(new GuiManual(0));
    }
}
