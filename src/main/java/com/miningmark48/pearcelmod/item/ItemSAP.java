package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.handler.ConfigurationHandler;

public class ItemSAP extends ItemPearcelMod{

    public ItemSAP(){
        setMaxDamage(ConfigurationHandler.sapDurability);
    }

}
