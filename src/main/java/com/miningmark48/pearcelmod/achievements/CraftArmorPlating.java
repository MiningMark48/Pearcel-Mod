package com.miningmark48.pearcelmod.achievements;

import com.miningmark48.pearcelmod.init.ModItems;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class CraftArmorPlating {

    @SubscribeEvent
    public void onCraftArmorPlating(PlayerEvent.ItemCraftedEvent e) {
        if (e.crafting.getItem().equals(ModItems.armorPlating)) {
            e.player.addStat(Achievements.achievementArmorPlating, 1);
        }
    }

}
