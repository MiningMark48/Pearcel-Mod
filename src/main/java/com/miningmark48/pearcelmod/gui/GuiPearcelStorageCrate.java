package com.miningmark48.pearcelmod.gui;

import com.miningmark48.pearcelmod.container.ContainerPearcelStorageCrate;
import com.miningmark48.pearcelmod.reference.Reference;
import com.miningmark48.pearcelmod.tileentity.TileEntityPearcelStorageCrate;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiPearcelStorageCrate extends GuiContainer{

    private IInventory playerInv;
    private TileEntityPearcelStorageCrate te;

    public GuiPearcelStorageCrate(IInventory playerInv, TileEntityPearcelStorageCrate te) {
        super(new ContainerPearcelStorageCrate(playerInv, te));

        this.playerInv = playerInv;
        this.te = te;

        this.xSize = 176;
        this.ySize = 174;

    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID + ":textures/gui/gui_pearcel_backpack.png"));
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
    }

    @Override
    protected  void drawGuiContainerForegroundLayer(int mouseX, int mouseY){
        String s = this.te.getDisplayName().getUnformattedComponentText();
        this.fontRendererObj.drawString(s, 88 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
    }


}
