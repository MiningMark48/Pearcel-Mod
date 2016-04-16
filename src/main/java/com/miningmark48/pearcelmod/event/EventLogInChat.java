package com.miningmark48.pearcelmod.event;

import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import com.miningmark48.pearcelmod.reference.Reference;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

public class EventLogInChat {

    @SubscribeEvent
    public void onJoin(PlayerEvent.PlayerLoggedInEvent e){

        if (!e.player.getEntityWorld().isRemote) {

            NBTTagCompound tag = e.player.getEntityData();

            if(tag.getString(Reference.MOD_ID + "doChatMessage") == "") {
                tag.setString(Reference.MOD_ID + "doChatMessage", "send");
            }
            if (tag.getString(Reference.MOD_ID + "doChatMessage") == "send") {
                e.player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GREEN + StatCollector.translateToLocal("chat.event.logIn.thanksUse")));
                tag.setString(Reference.MOD_ID + "doChatMessage", "noSend");
            }

        }
    }

}
