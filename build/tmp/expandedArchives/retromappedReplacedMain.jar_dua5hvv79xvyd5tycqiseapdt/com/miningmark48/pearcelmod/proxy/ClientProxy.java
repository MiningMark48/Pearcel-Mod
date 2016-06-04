package com.miningmark48.pearcelmod.proxy;

import com.miningmark48.pearcelmod.init.ModBlocks;
import com.miningmark48.pearcelmod.init.ModItems;

public class ClientProxy extends CommonProxy{

    @Override
    public void registerRenders(){
        ModItems.registerRenders();
        ModBlocks.registerRenders();
    }
}
