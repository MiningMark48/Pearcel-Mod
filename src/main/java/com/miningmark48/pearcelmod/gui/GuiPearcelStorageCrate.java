package com.miningmark48.pearcelmod.gui;

import com.miningmark48.mininglib.utility.GuiUtil;
import com.miningmark48.pearcelmod.container.ContainerPearcelStorageCrate;
import com.miningmark48.pearcelmod.reference.Reference;
import com.miningmark48.pearcelmod.tileentity.TileEntityPearcelStorageCrate;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiPearcelStorageCrate extends GuiContainer{

    private IInventory playerInv;
    private TileEntityPearcelStorageCrate te;

    private static String texture = Reference.MOD_ID + ":textures/gui/gui_pearcel_backpack.png";

    public GuiPearcelStorageCrate(IInventory playerInv, TileEntityPearcelStorageCrate te, EntityPlayer player) {
        super(new ContainerPearcelStorageCrate(playerInv, te, player));

        this.playerInv = playerInv;
        this.te = te;

        this.xSize = 176;
        this.ySize = 174;

    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GL11.glColor4f(1F, 1F, 1F, 1F);
        this.mc.getTextureManager().bindTexture(new ResourceLocation(texture));
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
    }

    @Override
    protected  void drawGuiContainerForegroundLayer(int mouseX, int mouseY){
        this.mc.getTextureManager().bindTexture(new ResourceLocation(texture));
        this.drawTexturedModalRect(-24, 12, 0, 176, 27, 79);
        this.mc.getTextureManager().bindTexture(new ResourceLocation(texture));
        this.drawTexturedModalRect(-24, 146, 31, 176, 27, 25);

        String s = this.te.getDisplayName().getUnformattedComponentText();
        //this.fontRendererObj.drawString(s, 88 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
        int x = GuiUtil.getXCenter(s, this.fontRenderer, xSize);
        this.fontRenderer.drawString(s, x, 5, 0x404040);
    }


}
