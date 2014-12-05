package com.raizunne.miscellany.util;

import net.minecraftforge.common.config.Configuration;

import com.raizunne.miscellany.Miscellany;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class Config {	
	public static boolean gemText = true; 
	public static boolean explosiveText = true;
	public static boolean fluteText = true;
	public static boolean gemShake = false;
	
	public static void MiscConfig(Configuration config){
		gemText = config.getBoolean("Knowledge Gem text on screen", "Text on screen", gemText, "Display text on screen for Knowledge Gem");
		explosiveText = config.getBoolean("Explosive Catalyst text on screen", "Text on screen", explosiveText, "Display text on screen for Explosive Catalyst");
		fluteText = config.getBoolean("The Flute text on screen", "Text on screen", fluteText, "Display text on screen for The Flute");
		gemShake = config.getBoolean("Shake screen on use", "General", gemShake, "Should the screen shake when the Knowledge Gem is used?");
		if(config.hasChanged()){
			config.save();
		}
	}
	
	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event){
		if(event.modID.equals(Miscellany.MODID)){
			MiscConfig(Miscellany.configFile);
		}
	}
	
}
