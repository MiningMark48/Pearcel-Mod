package com.miningmark48.pearcelmod.handler;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigurationHandler {

	public static Configuration configuration;
	
	public static void init(File configFile){
		//create the config file
		Configuration configuration = new Configuration(configFile);
		boolean configValue = false;
		
		try {
			
			//load the config file
			configuration.load();
			
			//read config file properties
			configValue = configuration.get(Configuration.CATEGORY_GENERAL, "configValue", true, "This is an example config value that does nothing.").getBoolean(true);
		}catch(Exception e){
			//Log the exception
		}finally{
			//save the config file
			if (configuration.hasChanged()){
				configuration.save();
			}
		}
		System.out.println(configValue);
	}
	
}
