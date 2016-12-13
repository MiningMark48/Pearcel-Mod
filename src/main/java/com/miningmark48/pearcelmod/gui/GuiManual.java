package com.miningmark48.pearcelmod.gui;

import com.miningmark48.pearcelmod.reference.Reference;
import com.miningmark48.pearcelmod.utility.LogHelper;
import com.miningmark48.pearcelmod.utility.Translate;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import scala.Int;

import java.io.IOException;

public class GuiManual extends GuiScreen{

    private final int textureHeight = 192;
    private final int textureWidth = 192;
    private int currentPage = 0;
    private static final int bookTotalPages = 4;
    private static ResourceLocation[] bookPageTextures = new ResourceLocation[bookTotalPages];
    private static String[] stringPageText = new String[bookTotalPages];
    private GuiButton buttonDone;
    private NextPageButton buttonNextPage;
    private NextPageButton buttonPreviousPage;

    public GuiManual(){
        bookPageTextures[0] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/manual_cover.png");
        bookPageTextures[1] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/manual_page.png");

        stringPageText[0] = "";
        stringPageText[1] = "This is the first page of the Pearcel Manual";
        stringPageText[2] = "This is page 2";
        stringPageText[3] = "This is page 3";

        for (int i = 0; i < bookTotalPages; i++){
            stringPageText[i] = Translate.toLocal("gui.manual.page.text." + Integer.valueOf(i));
        }

    }

    @Override
    public void onGuiClosed(){
        super.onGuiClosed();
        Keyboard.enableRepeatEvents(false);
    }

    @Override
    public void initGui(){
        super.initGui();
        //Debug
        LogHelper.info("Gui Initialized!");
        buttonList.clear();
        Keyboard.enableRepeatEvents(true);

        buttonDone = new GuiButton(0, width / 2 + 2, 4 + textureHeight, 98, 20, Translate.toLocal("gui.manual.button.done"));
        buttonList.add(buttonDone);
        int offsetFromScreenLeft = (width - textureWidth) / 2;
        buttonList.add(buttonNextPage = new NextPageButton(1, offsetFromScreenLeft + 120, 156, true));
        buttonList.add(buttonPreviousPage = new NextPageButton(1, offsetFromScreenLeft + 38, 156, false));
    }

    @Override
    public void updateScreen(){
        super.updateScreen();
        buttonDone.visible = (currentPage == bookTotalPages - 1);
        buttonNextPage.visible = (currentPage < bookTotalPages - 1);
        buttonPreviousPage.visible = currentPage > 0;
    }

    @Override
    public void drawScreen(int parWidth, int parHeight, float par3){
        super.drawScreen(parWidth, parHeight, par3);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        if (currentPage == 0){
            mc.getTextureManager().bindTexture(bookPageTextures[0]);
        }else{
            mc.getTextureManager().bindTexture(bookPageTextures[1]);
        }
        int offsetFromScreenLeft = (width - textureWidth) / 2;
        drawTexturedModalRect(offsetFromScreenLeft, 2, 0, 0, textureWidth, textureHeight);
        int widthOfString;
        String stringPageIndicator = Translate.toLocal("gui.manual.text.pageIndicator") + " " + Integer.valueOf(currentPage + 1) + "/" + bookTotalPages;
        widthOfString = fontRendererObj.getStringWidth(stringPageIndicator);
        fontRendererObj.drawString(stringPageIndicator, offsetFromScreenLeft - widthOfString + textureWidth - 44, 18, 0);
        fontRendererObj.drawSplitString(stringPageText[currentPage], offsetFromScreenLeft + 36, 34, 116, 0);
    }

    @Override
    protected void mouseClickMove(int parMouseX, int parMouseY, int parLastButtonClicked, long parTimeSinceMouseClick){
        super.mouseClickMove(parMouseX, parMouseY, parLastButtonClicked, parTimeSinceMouseClick);
    }

    @Override
    protected void actionPerformed(GuiButton parButton){
        try {
            super.actionPerformed(parButton);
        } catch (IOException e) {
            LogHelper.error(e.getStackTrace().toString());
        }
        if (parButton == buttonDone){
            //Can send packet here to server
            mc.displayGuiScreen((GuiScreen)null);
        }else if (parButton == buttonNextPage){
            if (currentPage < bookTotalPages - 1){
                ++currentPage;
            }
        }else if (parButton == buttonPreviousPage){
            if (currentPage > 0){
                --currentPage;
            }
        }
    }

    @Override
    public boolean doesGuiPauseGame(){
        return true;
    }

    @SideOnly(Side.CLIENT)
    static class NextPageButton extends GuiButton{
        private final boolean isNextButton;

        public NextPageButton(int parButtonId, int parPosX, int parPosY, boolean parIsNextButton){
            super(parButtonId, parPosX, parPosY, 23, 13, "");
            isNextButton = parIsNextButton;
        }

        @Override
        public void drawButton(Minecraft mc, int parX, int parY){
            if (visible){
                boolean isButtonPressed = (parX >= xPosition && parY >= yPosition && parX < xPosition + width && parY < yPosition + height);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                mc.getTextureManager().bindTexture(bookPageTextures[1]);
                int textureX = 0;
                int textureY = 192;

                if (isButtonPressed){
                    textureX += 23;
                }
                if (!isNextButton){
                    textureY +=13;
                }

                drawTexturedModalRect(xPosition, yPosition, textureX, textureY, 23, 13);
            }
        }
    }

}
