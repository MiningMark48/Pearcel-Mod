package com.miningmark48.pearcelmod.gui;

import com.miningmark48.pearcelmod.container.ContainerPearcelGenerator;
import com.miningmark48.pearcelmod.reference.Reference;
import com.miningmark48.pearcelmod.tileentity.TileEntityPearcelGenerator;
import com.miningmark48.pearcelmod.utility.LogHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class GuiPearcelGenerator extends GuiContainer{

    private TileEntityPearcelGenerator te;
    private IInventory playerInv;

    public GuiPearcelGenerator(IInventory playerInv, TileEntityPearcelGenerator te) {
        super(new ContainerPearcelGenerator(playerInv, te));

        this.te = te;
        this.playerInv = playerInv;

        this.xSize = 176;
        this.ySize = 168;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID + ":textures/gui/gui_pearcel_generator.png"));
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {

        //Energy Bar
        this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID + ":textures/gui/gui_pearcel_generator.png"));
        this.drawTexturedModalRect(145, 72 - getProgressLevel(51), 180, 21, 21, getProgressLevel(51));

        String s = this.te.getDisplayName().getUnformattedText();
        this.fontRenderer.drawString(s, 88 - this.fontRenderer.getStringWidth(s) / 2, 6, 4210752);
        this.fontRenderer.drawString(this.playerInv.getDisplayName().getUnformattedText(), 8, 75, 4210752);

        if (this.te.getField(2) != 0) {
            this.fontRenderer.drawString("Time Left: " + (this.te.getField(2) / 20) + "s", 36, 36, 4210752);
        }

        if (this.te.getField(0) >= this.te.getField(1)){
            this.fontRenderer.drawString("Energy Buffer Full", 36, 23, 4210752);
        }else if(this.te.getField(0) < this.te.getField(1) && this.te.getField(2) > 0) {
            NumberFormat format = NumberFormat.getInstance();
            this.fontRenderer.drawString("RF/T: " + format.format(this.te.getField(3)), 36, 23, 4210752);
        }else if(this.te.inventory.get(0) == null){
            this.fontRenderer.drawString("Insert Fuel", 36, 23, 4210752);
        }

//        Debug Code
//        int actualX = mouseX - ((this.width - this.xSize) / 2);
//        int actualY = mouseY - ((this.height - this.ySize) / 2);
//        LogHelper.info(actualX + ", " + actualY);

        if (this.isMouseOver(mouseX, mouseY, 144, 19, 166, 72)){
            Minecraft mc = Minecraft.getMinecraft();

            List<String> text = new ArrayList<String>();
            text.add(this.getOverlayText());
            net.minecraftforge.fml.client.config.GuiUtils.drawHoveringText(text, mouseX - ((this.width - this.xSize) / 2), mouseY - ((this.height - this.ySize) / 2), mc.displayWidth, mc.displayHeight, -1, mc.fontRenderer);
        }

    }

    private boolean isMouseOver(int mouseX, int mouseY, int minX, int minY, int maxX, int maxY){
        int actualX = mouseX - ((this.width - this.xSize) / 2);
        int actualY = mouseY - ((this.height - this.ySize) / 2);
        return (actualX >= minX) && (actualX <= maxX) && (actualY >= minY) && (actualY <= maxY);
    }

    private String getOverlayText(){
        NumberFormat format = NumberFormat.getInstance();
        return String.format("%s/%s RF", format.format(this.te.getField(0)), format.format(this.te.getField(1)));
    }

    private int getProgressLevel(int pixels) {
        int rf = this.te.getField(0);
        int maxRF = this.te.getField(1);
        return maxRF != 0 && rf != 0 ? (rf * pixels) / maxRF : 0;

    }

}
