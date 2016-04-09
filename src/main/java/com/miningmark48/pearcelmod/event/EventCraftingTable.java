package com.miningmark48.pearcelmod.event;

import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import com.miningmark48.pearcelmod.init.ModBlocks;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.init.Blocks;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class EventCraftingTable {

    @SubscribeEvent
    public void playerInteract(PlayerInteractEvent event){
        if (ConfigurationHandler.craftingTables) {
            if (event.action.equals(PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK)) {
                if (event.world.getBlock(event.x, event.y, event.z).equals(ModBlocks.pearcelWorkbench)) {
                    event.setCanceled(true);
                    event.entityPlayer.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.DARK_RED  + StatCollector.translateToLocal("chat.event.noWorkbench")));
                }
            }
        }
    }

}
