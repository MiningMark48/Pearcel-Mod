package com.miningmark48.pearcelmod.gui.manual;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class ComponentNextPageButton extends GuiButton{

    private final boolean isNextButton;

    public ComponentNextPageButton(int parButtonId, int parPosX, int parPosY, boolean parIsNextButton){
        super(parButtonId, parPosX, parPosY, 23, 13, "");
        isNextButton = parIsNextButton;
    }

    @Override
    public void drawButton(Minecraft mc, int parX, int parY){
        if (visible){
            boolean isButtonPressed = (parX >= x && parY >= y && parX < x + width && parY < y + height);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            mc.getTextureManager().bindTexture(GuiManual.bookPageTextures[1]);
            int textureX = 0;
            int textureY = 192;

            if (isButtonPressed){
                textureX += 23;
            }
            if (!isNextButton){
                textureY +=13;
            }

            drawTexturedModalRect(x, y, textureX, textureY, 23, 13);
        }
    }

}
