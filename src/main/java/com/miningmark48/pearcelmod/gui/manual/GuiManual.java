package com.miningmark48.pearcelmod.gui.manual;

import com.miningmark48.pearcelmod.reference.Reference;
import com.miningmark48.pearcelmod.utility.LogHelper;
import com.miningmark48.pearcelmod.utility.Translate;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.lang3.StringEscapeUtils;
import org.lwjgl.opengl.GL11;
import scala.Predef;

import java.util.Arrays;
import java.util.List;

public class GuiManual extends GuiScreen{

    private final int textureHeight = 192;
    private final int textureWidth = 192;
    private int currentPage = 0;
    public static final int bookTotalPages = 51;
    public static ResourceLocation[] bookPageTextures = new ResourceLocation[bookTotalPages];
    private static String[] stringPageText = new String[bookTotalPages];
    private ComponentNextPageButton buttonNextPage;
    private ComponentNextPageButton buttonPreviousPage;
    private GuiButton buttonHome;
    private GuiButton buttonIntro;
    private GuiButton buttonTools;
    private GuiButton buttonArmor;
    private GuiButton buttonItems;
    private GuiButton buttonBlocks;
    private GuiTextField textFieldGoToPage;

    public GuiManual(){

        bookPageTextures[0] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/manual_cover.png");
        bookPageTextures[1] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/manual_page.png");

        for (int i = 0; i < bookTotalPages; i++){
            stringPageText[i] = StringEscapeUtils.unescapeJava(Translate.toLocal("gui.manual.page.text." + Integer.valueOf(i)));
        }

    }

    @Override
    public void initGui(){
        super.initGui();
        //Debug
        LogHelper.info("Gui Initialized!");
        buttonList.clear();

        int offsetFromScreenLeft = (width - textureWidth) / 2;
        buttonList.add(buttonNextPage = new ComponentNextPageButton(1, offsetFromScreenLeft + 120, 158, true));
        buttonList.add(buttonPreviousPage = new ComponentNextPageButton(1, offsetFromScreenLeft + 38, 158, false));

        buttonHome = new GuiButton(2, (width / 2) - 20, textureHeight, 40, 20, Translate.toLocal("gui.manual.button.home"));
        buttonList.add(buttonHome);

        //Glossary
        buttonIntro = new GuiButton(3, width / 2 - 140, 2 + 30, 60, 20, Translate.toLocal("gui.manual.button.glossary.intro"));
        buttonTools = new GuiButton(3, width / 2 - 140, 2 + 55, 60, 20, Translate.toLocal("gui.manual.button.glossary.tools"));
        buttonArmor = new GuiButton(3, width / 2 - 140, 2 + 80, 60, 20, Translate.toLocal("gui.manual.button.glossary.armor"));
        buttonItems = new GuiButton(3, width / 2 - 140, 2 + 105, 60, 20, Translate.toLocal("gui.manual.button.glossary.items"));
        buttonBlocks = new GuiButton(3, width / 2 - 140, 2 + 130, 60, 20, Translate.toLocal("gui.manual.button.glossary.blocks"));

        buttonList.add(buttonIntro);
        buttonList.add(buttonTools);
        buttonList.add(buttonArmor);
        buttonList.add(buttonItems);
        buttonList.add(buttonBlocks);

        //Text Fields
        //textFieldGoToPage = new GuiTextField(4, fontRendererObj, width / 2 - 20, textureHeight + 15, 60, 20);

        for (GuiButton e : buttonList){
            e.visible = false;
        }

    }

    @Override
    public void updateScreen(){
        super.updateScreen();
        buttonNextPage.visible = (currentPage < bookTotalPages - 1);
        buttonPreviousPage.visible = currentPage > 0;
        buttonHome.visible = currentPage > 0;
        buttonIntro.visible = currentPage >= 1;
        buttonTools.visible = currentPage >= 1;
        buttonArmor.visible = currentPage >= 1;
        buttonItems.visible = currentPage >= 1;
        buttonBlocks.visible = currentPage >= 1;
        //textFieldGoToPage.setVisible(currentPage >= 1);
    }

    @Override
    public void drawScreen(int parWidth, int parHeight, float par3){
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

        //Textures
        switch (currentPage){
            case 0:
                mc.getTextureManager().bindTexture(bookPageTextures[0]);
                break;
            default:
            case 1:
                mc.getTextureManager().bindTexture(bookPageTextures[1]);
                break;
        }

        int offsetFromScreenLeft = (width - textureWidth) / 2;
        drawTexturedModalRect(offsetFromScreenLeft, 2, 0, 0, textureWidth, textureHeight);

        int widthOfString;
        String stringPageIndicator = Translate.toLocal("gui.manual.text.pageIndicator") + " " + Integer.valueOf(currentPage) + "/" + (bookTotalPages - 1);
        widthOfString = fontRendererObj.getStringWidth(stringPageIndicator);

        //Pages
        if (currentPage >= 1) {
            fontRendererObj.drawString(stringPageIndicator, offsetFromScreenLeft - widthOfString + textureWidth - 44, 18, 0);
            fontRendererObj.drawSplitString(stringPageText[currentPage], offsetFromScreenLeft + 36, 34, 116, 0);
        }else if (currentPage == 1){
            fontRendererObj.drawSplitString(stringPageText[currentPage], offsetFromScreenLeft + 36, 24, 116, 0);
        }else if (currentPage == 0){
            fontRendererObj.drawSplitString(stringPageText[currentPage], offsetFromScreenLeft + 36, 24, 116, 0);
        }

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
               currentPage = 0;
        }else if (parButton == buttonIntro){
            currentPage = 1;
        }else if (parButton == buttonTools){
            currentPage = 4;
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