package com.miningmark48.pearcelmod.init;

import com.miningmark48.pearcelmod.commands.*;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

public class Commands {

    public static void init(FMLServerStartingEvent event){
        event.registerServerCommand(new commandVersion());
        event.registerServerCommand(new commandCredit());
        event.registerServerCommand(new commandIVET());
    }

}
