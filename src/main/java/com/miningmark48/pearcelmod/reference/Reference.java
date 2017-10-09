package com.miningmark48.pearcelmod.reference;

import cofh.redstoneflux.RedstoneFlux;

public class Reference {

    public static final String MOD_ID = "pearcelmod";
    public static final String MOD_NAME = "PearcelMod";
    public static final String MOD_VERSION = "4.1.1";
    public static final String GAME_VERSION = "1.12.1";
    public static final String VERSION = GAME_VERSION + "-" + MOD_VERSION;
    public static final String MOD_DEPENDENCIES = "required-after:mininglib@[1.1.0,); " + RedstoneFlux.VERSION_GROUP;
    public static final String CLIENT_PROXY_CLASS = "com.miningmark48.pearcelmod.proxy.ClientProxy";
    public static final String SERVER_PROXY_CLASS = "com.miningmark48.pearcelmod.proxy.CommonProxy";
    public static final String GUI_FACTORY_CLASS = "com.miningmark48.pearcelmod.gui.GuiFactory";

}