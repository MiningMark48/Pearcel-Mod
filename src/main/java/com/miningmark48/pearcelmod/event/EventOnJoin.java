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

    @SubscribeEvent
    public void onJoin(TickEvent.PlayerTickEvent e){

        if(!PearcelMod.haveWarnedVersionOutOfDate && e.player.worldObj.isRemote) {
            if(!PearcelMod.versionChecker.isLatestVersion()) {
                ClickEvent versionCheckClickEvent = new ClickEvent(ClickEvent.Action.OPEN_URL, "https://minecraft.curseforge.com/projects/pearcel-mod");

                e.player.addChatComponentMessage(new TextComponentString(TextFormatting.YELLOW + Translate.toLocal("chat.versionChecker.outOfDate") + TextFormatting.AQUA + " v" + PearcelMod.versionChecker.getLatestVersion()).setStyle(new Style().setClickEvent(versionCheckClickEvent)));

                PearcelMod.haveWarnedVersionOutOfDate = true;
            }

        }

    }

}
