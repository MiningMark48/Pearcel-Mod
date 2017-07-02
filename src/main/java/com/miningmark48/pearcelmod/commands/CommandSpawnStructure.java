package com.miningmark48.pearcelmod.commands;

import com.miningmark48.mininglib.utility.ModTranslate;
import com.miningmark48.pearcelmod.world.*;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CommandSpawnStructure extends CommandBase{

    private final List aliases;
    private final List structures;

    private final String prefix = "pm";

    public CommandSpawnStructure(){
        aliases = new ArrayList();
        aliases.add(String.format("%s_structure", prefix));

        structures = new ArrayList();
        for (int i = 1; i <= 3; i++) {
            structures.add(String.valueOf(i));
        }
    }

    @Override
    public String getName() {
        return String.format("%s_structure", prefix);
    }



    @Override
    public String getUsage(ICommandSender sender) {
        return String.format("%s_structure <arg-int>", prefix);
    }

    @Override
    public List<String> getAliases() {
        return this.aliases;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        World world = sender.getEntityWorld();

        if (!world.isRemote){
            if (args.length == 0){
                sender.sendMessage(new TextComponentString(TextFormatting.RED + ModTranslate.toLocal("command.spawn_structure.no_args")));
                return;
            }

            Random rand = new Random();
            if (!(world instanceof WorldServer))
                return;
            WorldServer worldServer = (WorldServer) world;

            try {
                switch (Integer.valueOf(args[0])) {
                    default:
                    case 1:
                        StructureGenPearcel1.generateStructure(worldServer, sender.getPosition().add(1, 0, 1), rand);
                        break;
                    case 2:
                        StructureGenPearcel2.generateStructure(worldServer, sender.getPosition().add(1, 0, 1), rand);
                        break;
                    case 3:
                        StructureGenPearcel3.generateStructure(worldServer, sender.getPosition().add(1, 0, 1), rand);
                        break;
                }
                sender.sendMessage(new TextComponentString(TextFormatting.GREEN + ModTranslate.toLocal("command.spawn_structure.spawned")));
            }catch (NumberFormatException e){
                sender.sendMessage(new TextComponentString(TextFormatting.RED + ModTranslate.toLocal("command.spawn_structure.invalid")));
            }

        }
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos pos) {
        return structures;
    }

    @Override
    public boolean isUsernameIndex(String[] args, int index) {
        return false;
    }

    @Override
    public int compareTo(ICommand o) {
        return 0;
    }

}
