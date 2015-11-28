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
        this.fontRendererObj.drawString(StatCollector.translateToLocal("gui.pcp.name"), 20, 5, 0x404040);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {

        GL11.glColor4f(1F, 1F, 1F, 1F);
        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);

        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

    }
}
