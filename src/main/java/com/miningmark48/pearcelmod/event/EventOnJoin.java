package com.miningmark48.pearcelmod.event;

import com.miningmark48.pearcelmod.PearcelMod;
import com.miningmark48.pearcelmod.utility.Translate;
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

        if(!PearcelMod.haveWarnedVersionOutOfDate && e.player.world.isRemote) {
            if(!PearcelMod.versionChecker.isLatestVersion()) {
                ClickEvent versionCheckClickEvent = new ClickEvent(ClickEvent.Action.OPEN_URL, "https://minecraft.curseforge.com/projects/pearcel-mod");

                e.player.sendMessage(new TextComponentString(TextFormatting.YELLOW + Translate.toLocal("chat.versionChecker.outOfDate") + TextFormatting.AQUA + " v" + PearcelMod.versionChecker.getLatestVersion()).setStyle(new Style().setClickEvent(versionCheckClickEvent)));

                PearcelMod.haveWarnedVersionOutOfDate = true;
            }
        }

        if (!JoinMessageWikiSent && e.player.world.isRemote){ //TODO: Make config setting for message
            ClickEvent versionCheckClickEvent = new ClickEvent(ClickEvent.Action.OPEN_URL, "http://miningmark48.xyz/pearcelmod");

            e.player.sendMessage(new TextComponentString(TextFormatting.GREEN + Translate.toLocal("chat.joinMessage.wiki")).setStyle(new Style().setClickEvent(versionCheckClickEvent)));

            JoinMessageWikiSent = true;

        }

    }

}
