package com.miningmark48.pearcelmod.gui;

import com.miningmark48.pearcelmod.container.ContainerBindle;
import com.miningmark48.pearcelmod.inventory.InventoryBindle;
import com.miningmark48.pearcelmod.reference.Reference;
import com.miningmark48.pearcelmod.utility.GuiUtils;
import com.miningmark48.pearcelmod.utility.Translate;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiBindle extends GuiContainer{

    private ResourceLocation texture = new ResourceLocation(Reference.MOD_ID + ":textures/gui/gui_bindle.png");

    private final InventoryBindle inventory;

    public GuiBindle(ContainerBindle containerItem){
        super(containerItem);
        this.inventory = containerItem.inventory;

        this.xSize = 176;
        this.ySize = 120;
    }

    public void onGuiClosed(){
        super.onGuiClosed();
    }

    protected void drawGuiContainerForegroundLayer(int i, int j){
        String text = Translate.toLocal("gui.bindle.name");
        int x = GuiUtils.getXCenter(text, this.fontRenderer, xSize);
        this.fontRenderer.drawString(text, x, 5, 0x404040);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {

        GL11.glColor4f(1F, 1F, 1F, 1F);
        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);

        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

    }

}
