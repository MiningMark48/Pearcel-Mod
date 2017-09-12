package com.miningmark48.pearcelmod.gui.manual;

import com.miningmark48.mininglib.utility.ModTranslate;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.lang3.StringEscapeUtils;
import org.lwjgl.opengl.GL11;

public class GuiCatArmor extends GuiScreen{

    private final int textureHeight = 192;
    private final int textureWidth = 192;
    private int currentPage = 0;
    public static final int bookTotalPages = 2;
    public static ResourceLocation[] bookPageTextures = new ResourceLocation[bookTotalPages];
    private static String[] stringPageText = new String[bookTotalPages];
    private ComponentNextPageButton buttonNextPage;
    private ComponentNextPageButton buttonPreviousPage;
    private GuiButton buttonHome;

    public GuiCatArmor(){

        bookPageTextures[0] = GuiReference.manual_page;

        for (int i = 0; i < bookTotalPages; i++){
            stringPageText[i] = StringEscapeUtils.unescapeJava(ModTranslate.toLocal("gui.manual.armor.text." + Integer.valueOf(i)));
        }

    }

    @Override
    public void initGui(){
        super.initGui();
        buttonList.clear();

        int offsetFromScreenLeft = (width - textureWidth) / 2;
        buttonList.add(buttonNextPage = new ComponentNextPageButton(1, offsetFromScreenLeft + 120, 158, true));
        buttonList.add(buttonPreviousPage = new ComponentNextPageButton(1, offsetFromScreenLeft + 38, 158, false));

        buttonHome = new GuiButton(2, (width / 2) - 20, textureHeight, 40, 20, ModTranslate.toLocal("gui.manual.button.home"));
        buttonList.add(buttonHome);

        for (GuiButton e : buttonList){
            e.visible = false;
        }

    }

    @Override
    public void updateScreen(){
        super.updateScreen();
        buttonNextPage.visible = (currentPage < bookTotalPages - 1);
        buttonPreviousPage.visible = currentPage > 0;
        buttonHome.visible = true;
    }

    @Override
    public void drawScreen(int parWidth, int parHeight, float par3){
        this.drawDefaultBackground();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

        //Textures
        switch (currentPage){
            default:
                mc.getTextureManager().bindTexture(bookPageTextures[0]);
                break;
        }

        int offsetFromScreenLeft = (width - textureWidth) / 2;
        drawTexturedModalRect(offsetFromScreenLeft, 2, 0, 0, textureWidth, textureHeight);

        int widthOfString;
        String stringPageIndicator = ModTranslate.toLocal("gui.manual.text.pageIndicator") + " " + Integer.valueOf(currentPage + 1) + "/" + (bookTotalPages);
        widthOfString = fontRenderer.getStringWidth(stringPageIndicator);

        fontRenderer.drawString(stringPageIndicator, offsetFromScreenLeft - widthOfString + textureWidth - 44, 18, 0);
        fontRenderer.drawSplitString(stringPageText[currentPage], offsetFromScreenLeft + 36, 34, 116, 0);

        super.drawScreen(parWidth, parHeight, par3);

    }

    @Override
    protected void mouseClickMove(int parMouseX, int parMouseY, int parLastButtonClicked, long parTimeSinceMouseClick){
        super.mouseClickMove(parMouseX, parMouseY, parLastButtonClicked, parTimeSinceMouseClick);
    }

    @Override
    protected void actionPerformed(GuiButton parButton){
        if (parButton == buttonNextPage){
            if (currentPage < bookTotalPages - 1){
                ++currentPage;
            }
        }else if (parButton == buttonPreviousPage){
            if (currentPage > 0){
                --currentPage;
            }
        }else if (parButton == buttonHome){
               Minecraft.getMinecraft().displayGuiScreen(new GuiManual(1));
        }
    }

    @Override
    public void onGuiClosed(){
        //super.onGuiClosed();
        currentPage = 0;
    }

    @Override
    public boolean doesGuiPauseGame(){
        return true;
    }

}
