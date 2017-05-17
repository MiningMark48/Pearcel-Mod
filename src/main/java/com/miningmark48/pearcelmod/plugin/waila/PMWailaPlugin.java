package com.miningmark48.pearcelmod.plugin.waila;

import com.miningmark48.pearcelmod.block.BlockFoolsPearcelOre;
import com.miningmark48.pearcelmod.block.BlockPearcelBeacon;
import com.miningmark48.pearcelmod.block.BlockPearcelPressurePlate;
import com.miningmark48.pearcelmod.block.BlockSummoner;
import mcp.mobius.waila.api.IWailaPlugin;
import mcp.mobius.waila.api.IWailaRegistrar;
import mcp.mobius.waila.api.WailaPlugin;

@WailaPlugin
public class PMWailaPlugin implements IWailaPlugin{

    @Override
    public void register(IWailaRegistrar registrar) {
        registrar.registerStackProvider(new BlockFoolsPearcelOre(), BlockFoolsPearcelOre.class);

        registrar.registerBodyProvider(new BlockPearcelPressurePlate(), BlockPearcelPressurePlate.class);
        registrar.registerBodyProvider(new BlockSummoner(), BlockSummoner.class);
        registrar.registerBodyProvider(new BlockPearcelBeacon(), BlockPearcelBeacon.class);
    }
}
