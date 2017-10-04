package com.miningmark48.pearcelmod.event;

import com.miningmark48.mininglib.utility.ModTranslate;
import com.miningmark48.pearcelmod.PearcelMod;
import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class EventOnJoin{

    private Boolean JoinMessageWikiSent = false;

    @SubscribeEvent
    public void onJoin(TickEvent.PlayerTickEvent e){

        if (ConfigurationHandler.enableWikiJoinMessage && !JoinMessageWikiSent && e.player.world.isRemote){
            ClickEvent versionCheckClickEvent = new ClickEvent(ClickEvent.Action.OPEN_URL, "http://miningmark48.xyz/pearcelmod");

            e.player.sendMessage(new TextComponentString(TextFormatting.GREEN + ModTranslate.toLocal("chat.joinMessage.wiki")).setStyle(new Style().setClickEvent(versionCheckClickEvent)));

            JoinMessageWikiSent = true;

        }

    }

}
