package com.miningmark48.pearcelmod.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;

import java.util.ArrayList;
import java.util.List;

public class commandSubscribe extends CommandBase {

    private List aliases;

    public commandSubscribe() {
        this.aliases = new ArrayList();
        this.aliases.add("pm-subscribe");
        this.aliases.add("pmsubscribe");
    }

    @Override
    public String getCommandName(){
        return "pm-subscribe";
    }

    @Override
    public String getCommandUsage(ICommandSender p_71518_1_){
        return "/pm-subscribe";
    }

    @Override
    public List getCommandAliases(){
        return this.aliases;
    }

    @Override
    public void processCommand(ICommandSender icommandsender, String[] astring){
        icommandsender.addChatMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + "To subscribe to Pearcel Mod, go to: " + EnumChatFormatting.RESET + "https://www.links.ml/FAED"));
        icommandsender.addChatMessage(new ChatComponentTranslation("Subscribing gives you the ability to find out what is going on with Pearcel Mod via email or text message."));
        return;
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender icommandsender){
        return true;
    }

    @Override
    public List addTabCompletionOptions(ICommandSender icommandsender, String[] astring){
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] astring, int i){
        return false;
    }

    @Override
    public int compareTo(Object o){
        return 0;
    }

}
