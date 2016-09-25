package com.miningmark48.pearcelmod.gui;

import com.miningmark48.pearcelmod.container.ContainerPearcelBackpack;
import com.miningmark48.pearcelmod.container.ContainerPearcelWorkbench;
import com.miningmark48.pearcelmod.inventory.InventoryPearcelBackpack;
import com.miningmark48.pearcelmod.item.ItemPearcelBackpack;
import com.miningmark48.pearcelmod.reference.Reference;
import com.miningmark48.pearcelmod.utility.Translate;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class GuiPearcelBackpack extends GuiContainer{

    private ResourceLocation texture = new ResourceLocation(Reference.MOD_ID + ":textures/gui/gui_pearcel_backpack.png");

    private final InventoryPearcelBackpack inventory;

    public GuiPearcelBackpack(ContainerPearcelBackpack containerItem){
        super(containerItem);
        this.inventory = containerItem.inventory;

        this.xSize = 176;
        this.ySize = 166;
    }

    public void onGuiClosed(){
        super.onGuiClosed();
    }

    protected void drawGuiContainerForegroundLayer(int i, int j){
        //this.fontRendererObj.drawString(Translate.toLocal("gui.pearcel_backpack.name").toString(), 40, 5, 0x404040);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {

        GL11.glColor4f(1F, 1F, 1F, 1F);
        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);

        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

    }
}
