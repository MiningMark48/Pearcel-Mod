package com.miningmark48.pearcelmod.proxy;

import com.miningmark48.pearcelmod.PearcelMod;
import com.miningmark48.pearcelmod.handler.ModPacketHandler;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.PacketLoggingHandler;

public class CommonProxy{

    public void preInit(FMLPreInitializationEvent event){

    }

    public void registerModel(Item item){

    }

    public void registerRenders(){

    }

    public void init(FMLInitializationEvent event){
        PearcelMod.packetHandler = new ModPacketHandler();
    }

    public void openManualGuiClient(){

    }


}
