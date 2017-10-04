package com.miningmark48.pearcelmod;

import com.miningmark48.mininglib.utility.ModLogger;
import com.miningmark48.mininglib.utility.ModTranslate;
import com.miningmark48.pearcelmod.commands.CommandSpawnStructure;
import com.miningmark48.pearcelmod.event.*;
import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import com.miningmark48.pearcelmod.handler.GuiHandler;
import com.miningmark48.pearcelmod.init.*;
import com.miningmark48.pearcelmod.item.ItemPearcelFuel;
import com.miningmark48.pearcelmod.proxy.CommonProxy;
import com.miningmark48.pearcelmod.reference.Reference;
import com.miningmark48.pearcelmod.world.StructureGenPearcel1;
import com.miningmark48.pearcelmod.world.StructureGenPearcel2;
import com.miningmark48.pearcelmod.world.StructureGenPearcel3;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid=Reference.MOD_ID, name=Reference.MOD_NAME, version=Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS, dependencies = Reference.MOD_DEPENDENCIES, acceptedMinecraftVersions = Reference.GAME_VERSION)
public class PearcelMod {

	@Mod.Instance(Reference.MOD_ID)
	public static PearcelMod instance;
	
	@SidedProxy(clientSide=Reference.CLIENT_PROXY_CLASS, serverSide=Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event){

		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
		MinecraftForge.EVENT_BUS.register(new ConfigurationHandler());

		ModItems.init();
		ModBlocks.init();
		ModRegistry.init();

		MinecraftForge.EVENT_BUS.register(new ModRegistry());

		ModTileEntities.init();
		ModEntities.init();
		ModLoots.init();
		ModSoundEvents.registerSounds();

		MinecraftForge.EVENT_BUS.register(new ModSoundEvents());

		GameRegistry.registerFuelHandler(new ItemPearcelFuel());
		GeneratorRegistry.registerGeneratorFuels();

		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());

		proxy.preInit(event);

	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event){

		proxy.registerRenders();
		proxy.init(event);

		GameRegistry.registerWorldGenerator(new WorldGen(), 0);
		GameRegistry.registerWorldGenerator(new StructureGenPearcel1(), 1);
		GameRegistry.registerWorldGenerator(new StructureGenPearcel2(), 2);
		GameRegistry.registerWorldGenerator(new StructureGenPearcel3(), 3);

		MinecraftForge.EVENT_BUS.register(new EventBreakForPearcel());
		MinecraftForge.EVENT_BUS.register(new EventOnBreakMF());
		MinecraftForge.EVENT_BUS.register(new EventOnJoin());
		MinecraftForge.EVENT_BUS.register(new EventOnBreakNP());
		MinecraftForge.EVENT_BUS.register(new EventOnHurt());
		MinecraftForge.EVENT_BUS.register(new EventOnPlayerAttack());
		MinecraftForge.EVENT_BUS.register(new EventCharms());

		Recipes.init();

		ModLogger.info(ModTranslate.toLocal("log.info.init"));

	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event){

		ModLogger.info(ModTranslate.toLocal("log.info.postinit"));

	}

	@Mod.EventHandler
	public void serverLoad(FMLServerStartingEvent event){
		event.registerServerCommand(new CommandSpawnStructure());
	}

}
