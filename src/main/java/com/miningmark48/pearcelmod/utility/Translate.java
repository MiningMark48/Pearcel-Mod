package com.miningmark48.pearcelmod.utility;

public class Translate {

    public static String toLocal(String key){
        return net.minecraft.util.text.translation.I18n.translateToLocal(key);
    }

    public static String toLocal(){
        return "Error: Missing key, report to mod author.";
    }

}
