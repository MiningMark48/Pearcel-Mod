package com.miningmark48.pearcelmod.client.gui;

import com.miningmark48.pearcelmod.client.container.ContainerMEWorkbench;
import com.miningmark48.pearcelmod.init.ModBlocks;
import com.miningmark48.pearcelmod.reference.GUIs;
import com.miningmark48.pearcelmod.reference.Reference;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;


public class GuiHandler implements IGuiHandler {
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == GUIs.guiIDMEWorkbench){
            return ID == GUIs.guiIDMEWorkbench && world.getBlock(x, y, z) == ModBlocks.meWorkbench ? new ContainerMEWorkbench(player.inventory, world, x, y, z) : null;
        }
        return null;
    }


    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == GUIs.guiIDMEWorkbench){
            return ID == GUIs.guiIDMEWorkbench && world.getBlock(x, y, z) == ModBlocks.meWorkbench ? new GuiMEWorkbench(player.inventory, world, x, y, z) : null;
        }
        return null;
    }
}
