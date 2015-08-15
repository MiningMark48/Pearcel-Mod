package com.miningmark48.pearcelmod.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;

import java.util.ArrayList;
import java.util.List;

public class commandPatreon extends CommandBase {

    String patreon = "Watermelooaan";

    private List aliases;

    public commandPatreon() {
        this.aliases = new ArrayList();
        this.aliases.add("pm-patreon");
        this.aliases.add("pmpatreon");
    }

    @Override
    public String getCommandName(){
        return "pm-patreon";
    }

    @Override
    public String getCommandUsage(ICommandSender p_71518_1_){
        return "/pm-patreon";
    }

    @Override
    public List getCommandAliases(){
        return this.aliases;
    }

    @Override
    public void processCommand(ICommandSender icommandsender, String[] astring){
        icommandsender.addChatMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + "Huge thanks to my Patreons: " + EnumChatFormatting.GREEN + patreon));
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
