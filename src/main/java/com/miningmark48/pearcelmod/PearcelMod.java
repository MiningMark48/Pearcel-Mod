package com.miningmark48.pearcelmod;

import com.miningmark48.pearcelmod.achievements.Achievements;
import com.miningmark48.pearcelmod.entity.EntityEnderPearcel;
import com.miningmark48.pearcelmod.event.EventBreakForPearcel;
import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import com.miningmark48.pearcelmod.handler.GuiHandler;
import com.miningmark48.pearcelmod.init.*;
import com.miningmark48.pearcelmod.item.ItemPearcelFuel;
import com.miningmark48.pearcelmod.proxy.CommonProxy;
import com.miningmark48.pearcelmod.reference.Reference;
import com.miningmark48.pearcelmod.utility.LogHelper;
import com.miningmark48.pearcelmod.utility.Translate;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid=Reference.MOD_ID, name=Reference.MOD_NAME, version=Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
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
		ModItems.register();
		ModBlocks.init();
		ModBlocks.register();
		ModEntities.init();

		EntityRegistry.registerModEntity(EntityEnderPearcel.class, "EnderPearcel", 10, this, 350, 50, true);

		GameRegistry.registerFuelHandler(new ItemPearcelFuel());

		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());

		LogHelper.info(Translate.toLocal("log.info.preinit"));
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event){

		proxy.registerRenders();

		GameRegistry.registerWorldGenerator(new WorldGen(), 0);

		MinecraftForge.EVENT_BUS.register(new EventBreakForPearcel());

		Recipes.init();

		Achievements.init();

        LogHelper.info(Translate.toLocal("log.info.init"));

	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event){

		LogHelper.info(Translate.toLocal("log.info.postinit"));
	}


}
