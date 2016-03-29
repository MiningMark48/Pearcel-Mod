package com.miningmark48.pearcelmod.achievements;

import com.miningmark48.pearcelmod.init.ModItems;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class CraftTPPearcel {

    @SubscribeEvent
    public void onCraftTPPearcel(PlayerEvent.ItemCraftedEvent e) {
        if (e.crafting.getItem().equals(ModItems.tpPearcel)) {
            e.player.addStat(Achievements.achievementTPPearcel, 1);
        }
    }

}
