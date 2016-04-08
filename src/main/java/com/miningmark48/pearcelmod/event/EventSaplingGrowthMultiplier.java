package com.miningmark48.pearcelmod.event;

import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import com.miningmark48.pearcelmod.utility.LogHelper;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;

public class EventSaplingGrowthMultiplier {

    @SubscribeEvent
    public void onSaplingGrow(SaplingGrowTreeEvent event)
    {
        if (ConfigurationHandler.saplingGrowthMultiplier > 1)
            if (event.rand.nextInt(ConfigurationHandler.saplingGrowthMultiplier) != 0){
                event.setResult(Event.Result.DENY);
            }
    }

}
