package com.miningmark48.pearcelmod.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

import java.util.ArrayList;
import java.util.List;

public class commandCredit extends CommandBase {

    String credit = StatCollector.translateToLocal("command.credit.info");

    private List aliases;

    public commandCredit() {
        this.aliases = new ArrayList();
        this.aliases.add("pm-credit");
        this.aliases.add("pmcredit");
    }

    @Override
    public String getCommandName(){
        return "pm-credit";
    }

    @Override
    public String getCommandUsage(ICommandSender p_71518_1_){
        return "/pm-credit";
    }

    @Override
    public List getCommandAliases(){
        return this.aliases;
    }

    @Override
    public void processCommand(ICommandSender icommandsender, String[] astring){
        icommandsender.addChatMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + "Credit to: " + EnumChatFormatting.RESET + credit));
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
