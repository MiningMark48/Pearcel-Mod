package com.miningmark48.pearcelmod;

import com.miningmark48.pearcelmod.achievements.Achievements;
import com.miningmark48.pearcelmod.commands.CommandSpawnStructure;
import com.miningmark48.pearcelmod.entity.EntityEnderPearcel;
import com.miningmark48.pearcelmod.event.*;
import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import com.miningmark48.pearcelmod.handler.GuiHandler;
import com.miningmark48.pearcelmod.init.*;
import com.miningmark48.pearcelmod.item.ItemPearcelFuel;
import com.miningmark48.pearcelmod.proxy.CommonProxy;
import com.miningmark48.pearcelmod.reference.Reference;
import com.miningmark48.pearcelmod.utility.LogHelper;
import com.miningmark48.pearcelmod.utility.Translate;
import com.miningmark48.pearcelmod.utility.VersionChecker;
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
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid=Reference.MOD_ID, name=Reference.MOD_NAME, version=Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class PearcelMod {

	// Version checking instance
	public static VersionChecker versionChecker;
	public static boolean haveWarnedVersionOutOfDate = false;

	@Mod.Instance(Reference.MOD_ID)
	public static PearcelMod instance;
	
	@SidedProxy(clientSide=Reference.CLIENT_PROXY_CLASS, serverSide=Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event){

		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
		MinecraftForge.EVENT_BUS.register(new ConfigurationHandler());

		ModItems.init();
		ModItems.register();
		ModBlocks.init();
		ModBlocks.register();
		ModTileEntities.init();
		ModEntities.init();
		ModLoots.init();
		ModSoundEvents.registerSounds();

		EntityRegistry.registerModEntity(EntityEnderPearcel.class, "EnderPearcel", 10, this, 350, 50, true);

		GameRegistry.registerFuelHandler(new ItemPearcelFuel());

		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());

	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event){

		proxy.registerRenders();
		proxy.init();

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

		Achievements.init();

        LogHelper.info(Translate.toLocal("log.info.init"));

	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event){

		LogHelper.info(Translate.toLocal("log.info.postinit"));

		versionChecker = new VersionChecker();
		Thread versionCheckThread = new Thread(versionChecker, "Pearcel Mod Version Check");
		versionCheckThread.start();

	}

	@Mod.EventHandler
	public void serverLoad(FMLServerStartingEvent event){
		event.registerServerCommand(new CommandSpawnStructure());
	}


}
