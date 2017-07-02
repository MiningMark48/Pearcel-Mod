package com.miningmark48.pearcelmod.gui;

import com.miningmark48.mininglib.utility.ModTranslate;
import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import com.miningmark48.pearcelmod.reference.Reference;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;
import scala.actors.threadpool.Arrays;

public class GuiModConfig extends GuiConfig {
    public GuiModConfig(GuiScreen guiScreen){
        super(guiScreen,
                Arrays.asList(new IConfigElement[]{
                        new ConfigElement(ConfigurationHandler.configuration.getCategory(Configuration.CATEGORY_GENERAL)),
                        new ConfigElement(ConfigurationHandler.configuration.getCategory(ModTranslate.toLocal("config.category.enderPearcel.title").toLowerCase())),
                        new ConfigElement(ConfigurationHandler.configuration.getCategory(ModTranslate.toLocal("config.category.torcher.title").toLowerCase())),
                        new ConfigElement(ConfigurationHandler.configuration.getCategory(ModTranslate.toLocal("config.category.worldGen.title").toLowerCase())),
                        new ConfigElement(ConfigurationHandler.configuration.getCategory(ModTranslate.toLocal("config.category.rifPearcelPickaxe.title").toLowerCase())),
                        new ConfigElement(ConfigurationHandler.configuration.getCategory(ModTranslate.toLocal("config.category.pearcelMagnet.title").toLowerCase())),
                        new ConfigElement(ConfigurationHandler.configuration.getCategory(ModTranslate.toLocal("config.category.pearcelBeacon.title").toLowerCase())),
                        new ConfigElement(ConfigurationHandler.configuration.getCategory(ModTranslate.toLocal("config.category.structures.title").toLowerCase())),
                        new ConfigElement(ConfigurationHandler.configuration.getCategory(ModTranslate.toLocal("config.category.powerUsage.title").toLowerCase()))
                }),
                Reference.MOD_ID,
                false,
                false,
                GuiConfig.getAbridgedConfigPath(ConfigurationHandler.configuration.toString()));
    }
}
