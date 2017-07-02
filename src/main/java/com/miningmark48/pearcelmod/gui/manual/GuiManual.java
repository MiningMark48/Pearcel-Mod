package com.miningmark48.pearcelmod.gui.manual;

import com.miningmark48.mininglib.utility.ModLogger;
import com.miningmark48.mininglib.utility.ModTranslate;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.lang3.StringEscapeUtils;
import org.lwjgl.opengl.GL11;

public class GuiManual extends GuiScreen{

    private final int textureHeight = 192;
    private final int textureWidth = 192;
    private int currentPage = 0;
    public static final int bookTotalPages = 4;
    public static ResourceLocation[] bookPageTextures = new ResourceLocation[bookTotalPages];
    private static String[] stringPageText = new String[bookTotalPages];
    private ComponentNextPageButton buttonNextPage;
    private ComponentNextPageButton buttonPreviousPage;
    public static GuiButton buttonHome;
    public static GuiButton buttonTools;
    public static GuiButton buttonArmor;
    public static GuiButton buttonItems;
    public static GuiButton buttonBlocks;
    public static GuiButton buttonSummoning;
    public static GuiButton buttonMobs;
    public static GuiButton buttonCredits;

    public GuiManual(int page){

        bookPageTextures[0] = GuiReference.manual_cover;
        bookPageTextures[1] = GuiReference.manual_page;

        currentPage = page;

        for (int i = 0; i < bookTotalPages; i++){
            stringPageText[i] = StringEscapeUtils.unescapeJava(ModTranslate.toLocal("gui.manual.intro.text." + Integer.valueOf(i)));
        }

    }

    @Override
    public void initGui(){
        super.initGui();
        //Debug
        ModLogger.info("Gui Initialized!");
        buttonList.clear();

        int offsetFromScreenLeft = (width - textureWidth) / 2;
        buttonList.add(buttonNextPage = new ComponentNextPageButton(1, offsetFromScreenLeft + 120, 158, true));
        buttonList.add(buttonPreviousPage = new ComponentNextPageButton(1, offsetFromScreenLeft + 38, 158, false));

        buttonHome = new GuiButton(2, (width / 2) - 20, textureHeight, 40, 20, ModTranslate.toLocal("gui.manual.button.home"));
        buttonList.add(buttonHome);

        //Glossary
        buttonTools = new GuiButton(3, width / 2 - 145, 2 + 30, 65, 20, ModTranslate.toLocal("gui.manual.button.glossary.tools"));
        buttonArmor = new GuiButton(3, width / 2 - 145, 2 + 55, 65, 20, ModTranslate.toLocal("gui.manual.button.glossary.armor"));
        buttonItems = new GuiButton(3, width / 2 - 145, 2 + 80, 65, 20, ModTranslate.toLocal("gui.manual.button.glossary.items"));
        buttonBlocks = new GuiButton(3, width / 2 - 145, 2 + 105, 65, 20, ModTranslate.toLocal("gui.manual.button.glossary.blocks"));
        buttonSummoning = new GuiButton(3, width / 2 - 145, 2 + 130, 65, 20, ModTranslate.toLocal("gui.manual.button.glossary.summoning"));
        buttonMobs = new GuiButton(3, width / 2 + 75, 2 + 30, 65, 20, ModTranslate.toLocal("gui.manual.button.glossary.mobs"));
        buttonCredits = new GuiButton(3, width / 2 + 75, 2 + 55, 65, 20, ModTranslate.toLocal("gui.manual.button.glossary.credits"));

        buttonList.add(buttonTools);
        buttonList.add(buttonArmor);
        buttonList.add(buttonItems);
        buttonList.add(buttonBlocks);
        buttonList.add(buttonSummoning);
        buttonList.add(buttonMobs);
        buttonList.add(buttonCredits);

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
        buttonTools.visible = currentPage >= 1;
        buttonArmor.visible = currentPage >= 1;
        buttonItems.visible = currentPage >= 1;
        buttonBlocks.visible = currentPage >= 1;
        buttonSummoning.visible = currentPage >= 1;
        buttonMobs.visible = currentPage >= 1;
        buttonCredits.visible = currentPage >= 1;

        buttonSummoning.enabled = false;
        buttonMobs.enabled = false;
        buttonCredits.enabled = false;
        buttonBlocks.enabled = false;
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
                mc.getTextureManager().bindTexture(bookPageTextures[1]);
                break;
        }

        int offsetFromScreenLeft = (width - textureWidth) / 2;
        drawTexturedModalRect(offsetFromScreenLeft, 2, 0, 0, textureWidth, textureHeight);

        int widthOfString;
        String stringPageIndicator = ModTranslate.toLocal("gui.manual.text.pageIndicator") + " " + Integer.valueOf(currentPage) + "/" + (bookTotalPages - 1);
        widthOfString = fontRenderer.getStringWidth(stringPageIndicator);

        //Pages
        if (currentPage >= 1) {
            fontRenderer.drawString(stringPageIndicator, offsetFromScreenLeft - widthOfString + textureWidth - 44, 18, 0);
            fontRenderer.drawSplitString(stringPageText[currentPage], offsetFromScreenLeft + 36, 34, 116, 0);
        }else if (currentPage == 1){
            fontRenderer.drawSplitString(stringPageText[currentPage], offsetFromScreenLeft + 36, 24, 116, 0);
        }else if (currentPage == 0){
            fontRenderer.drawSplitString(stringPageText[currentPage], offsetFromScreenLeft + 36, 24, 116, 0);
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
            Minecraft.getMinecraft().displayGuiScreen(new GuiManual(0));
        }else if (parButton == buttonTools){
            Minecraft.getMinecraft().displayGuiScreen(new GuiCatTools());
        }else if (parButton == buttonArmor){
            Minecraft.getMinecraft().displayGuiScreen(new GuiCatArmor());
        }else if (parButton == buttonItems){
            Minecraft.getMinecraft().displayGuiScreen(new GuiCatItems());
        }else if (parButton == buttonBlocks){
            Minecraft.getMinecraft().displayGuiScreen(new GuiCatBlocks());
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