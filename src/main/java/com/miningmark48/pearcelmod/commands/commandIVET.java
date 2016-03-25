package com.miningmark48.pearcelmod.commands;

import com.miningmark48.pearcelmod.init.ModBlocks;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

import java.util.ArrayList;
import java.util.List;

public class commandIVET extends CommandBase {

    private List aliases;

    public commandIVET() {
        this.aliases = new ArrayList();
        this.aliases.add("pm-ivet");
        this.aliases.add("pmivet");
    }

    @Override
    public String getCommandName(){
        return "pm-ivet";
    }

    @Override
    public String getCommandUsage(ICommandSender p_71518_1_){
        return "/pm-ivet";
    }

    @Override
    public List getCommandAliases(){
        return this.aliases;
    }

    @Override
    public void processCommand(ICommandSender icommandsender, String[] astring){
        icommandsender.addChatMessage(new ChatComponentTranslation(StatCollector.translateToLocal("command.ivet.info")));
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
