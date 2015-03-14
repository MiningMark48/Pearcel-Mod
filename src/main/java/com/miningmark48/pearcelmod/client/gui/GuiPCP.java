package com.miningmark48.pearcelmod.client.gui;

import com.miningmark48.pearcelmod.client.container.ContainerMEWorkbench;
import com.miningmark48.pearcelmod.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class GuiPCP extends GuiContainer {
    //int guiWidth = 148;
    //int guiHeight = 80;
    private ResourceLocation texture = new ResourceLocation(Reference.MOD_ID + ":textures/gui/meWorkbenchGui.png");
    public static final int GUI_ID = 153;

    public GuiPCP(InventoryPlayer player, World world, int x, int y, int z){
        super(new ContainerMEWorkbench(player, world, x, y, z));

        this.xSize = 176;
        this.ySize = 166;
    }

    public void onGuiClosed(){
        super.onGuiClosed();
    }

    protected void drawGuiContainerForegroundLayer(int i, int j){
        this.fontRendererObj.drawString(StatCollector.translateToLocal("Portable Crafting Pearcel"), 20, 5, 0x404040);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {

        GL11.glColor4f(1F, 1F, 1F, 1F);
        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);

        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

    }


    /*@Override
    public void drawScreen(int x, int y, float ticks) {
        int guiX = (width - guiWidth) / 2;
        int guiY = (height - guiHeight) / 2;
        GL11.glColor4f(1, 1, 1, 1);
        drawDefaultBackground();
        mc.renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID + ":textures/gui/meWorkbenchGui.png"));
        drawTexturedModalRect(guiX, guiY, 0, 0, guiWidth, guiHeight);
        fontRendererObj.drawString(EnumChatFormatting.BOLD + "ME^Workbench [WIP]", guiX + 22, guiY + 5, 0x404040);
        fontRendererObj.drawSplitString("ME^Workbench is a WIP and will be finished soon.", guiX + 5, guiY + 20, guiWidth - 5, 0x404040);

        super.drawScreen(x, y, ticks);
    }*/
}
