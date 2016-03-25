package com.miningmark48.pearcelmod;

import com.miningmark48.pearcelmod.achievements.Achievements;
import com.miningmark48.pearcelmod.biome.BiomeGen;
import com.miningmark48.pearcelmod.client.gui.GuiHandler;
import com.miningmark48.pearcelmod.entity.EntityPearcelPearl;
import com.miningmark48.pearcelmod.event.EventCraftingTable;
import com.miningmark48.pearcelmod.event.EventFillBucket;
import com.miningmark48.pearcelmod.event.EventFlight;
import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import com.miningmark48.pearcelmod.handler.TradeHandler;
import com.miningmark48.pearcelmod.init.*;
import com.miningmark48.pearcelmod.item.ItemPearcelFuel;
import com.miningmark48.pearcelmod.proxy.ClientProxy;
import com.miningmark48.pearcelmod.proxy.IProxy;
import com.miningmark48.pearcelmod.reference.Reference;
import com.miningmark48.pearcelmod.utility.LogHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid=Reference.MOD_ID, name=Reference.MOD_NAME, version=Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class PearcelMod {

	@Mod.Instance(Reference.MOD_ID)
	public static PearcelMod instance;
	
	@SidedProxy(clientSide=Reference.CLIENT_PROXY_CLASS, serverSide=Reference.SERVER_PROXY_CLASS)
	public static IProxy proxy;
    public static ClientProxy cProxy;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event){
		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(new ConfigurationHandler());

        ModFluids.init();
        ModMaterials.init();
        ModBlocks.init();
		ModItems.init();
        EntityPearcelMod.init();
        BiomeGen.init();
        DungeonLoot.init();

        //Entities.init();

        EntityRegistry.registerModEntity(EntityPearcelPearl.class, "PearcelPearl", 10, this, 350, 50, true);


        for (int i = 0; i < 5; ++i) {
            VillagerRegistry.instance().registerVillageTradeHandler(i, new TradeHandler());
        }

        proxy.registerRenderThings();

        GameRegistry.registerWorldGenerator(new WorldGen(), 0);
        GameRegistry.registerFuelHandler(new ItemPearcelFuel());

        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());

		LogHelper.info(StatCollector.translateToLocal("log.info.preinit"));
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event){
        MinecraftForge.EVENT_BUS.register(new EventFillBucket());
        FMLCommonHandler.instance().bus().register(new EventFlight());
        MinecraftForge.EVENT_BUS.register(new EventCraftingTable());

        OreDict.init();
        Recipes.init();
        Achievements.init();
        LogHelper.info(StatCollector.translateToLocal( "log.info.init"));
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event){

        ModFluidContainer.init();

        LogHelper.info(StatCollector.translateToLocal("log.info.postinit"));
	}

    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event){
        Commands.init(event);
    }

}
