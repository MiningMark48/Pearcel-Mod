package com.miningmark48.pearcelmod.gui;

import com.miningmark48.mininglib.utility.GuiUtil;
import com.miningmark48.mininglib.utility.ModTranslate;
import com.miningmark48.pearcelmod.container.ContainerEnlargedPearcelBackpack;
import com.miningmark48.pearcelmod.inventory.InventoryEnlargedPearcelBackpack;
import com.miningmark48.pearcelmod.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiEnlargedPearcelBackpack extends GuiContainer{

    private ResourceLocation texture = new ResourceLocation(Reference.MOD_ID + ":textures/gui/gui_enlarged_pearcel_backpack.png");

    private final InventoryEnlargedPearcelBackpack inventory;

    public GuiEnlargedPearcelBackpack(ContainerEnlargedPearcelBackpack containerItem){
        super(containerItem);
        this.inventory = containerItem.inventory;

        this.xSize = 176;
        this.ySize = 246;
    }

    public void onGuiClosed(){
        super.onGuiClosed();
    }

    protected void drawGuiContainerForegroundLayer(int i, int j){
        String text = ModTranslate.toLocal("gui.enlarged_pearcel_backpack.name");
        int x = GuiUtil.getXCenter(text, this.fontRenderer, xSize);
        this.fontRenderer.drawString(text, x, 5, 0x404040);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {

        GL11.glColor4f(1F, 1F, 1F, 1F);
        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);

        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.func_191948_b(mouseX, mouseY);
    }

}
