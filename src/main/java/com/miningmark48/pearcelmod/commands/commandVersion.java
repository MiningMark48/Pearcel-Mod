package com.miningmark48.pearcelmod.commands;

import com.miningmark48.pearcelmod.reference.Reference;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

import java.util.ArrayList;
import java.util.List;

public class commandVersion extends CommandBase {

    private List aliases;

    public commandVersion() {
        this.aliases = new ArrayList();
        this.aliases.add("pm-version");
        this.aliases.add("pmversion");
    }

    @Override
    public String getCommandName(){
        return "pm-version";
    }

    @Override
    public String getCommandUsage(ICommandSender p_71518_1_){
        return "/pm-version";
    }

    @Override
    public List getCommandAliases(){
        return this.aliases;
    }

    @Override
    public void processCommand(ICommandSender icommandsender, String[] astring){
        icommandsender.addChatMessage(new ChatComponentTranslation(StatCollector.translateToLocal("command.version.info") + EnumChatFormatting.DARK_GREEN + Reference.VERSION));
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
