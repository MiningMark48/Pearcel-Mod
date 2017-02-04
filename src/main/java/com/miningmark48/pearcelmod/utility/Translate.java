package com.miningmark48.pearcelmod.utility;

import net.minecraft.client.resources.I18n;

public class Translate {

    public static String toLocal(String key){
        return I18n.format(key);
    }

    public static String toLocal(){
        return "Error: Missing key, report to mod author.";
    }

}
