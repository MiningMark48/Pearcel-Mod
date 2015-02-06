package com.miningmark48.pearcelmod.achievements;

import com.miningmark48.pearcelmod.init.ModBlocks;
import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.utility.LogHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class FindPearcelOre {

    @SubscribeEvent
    public void onFoundPearcelOre(PlayerEvent.ItemPickupEvent e) {
        if (e.pickedUp.getEntityItem().equals(ModBlocks.pearcelOre)) {
            e.player.addStat(Achievements.achievementPearcelOre, 1);

        }
    }

}
