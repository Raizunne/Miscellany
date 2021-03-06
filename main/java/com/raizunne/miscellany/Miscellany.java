/**
Code made by Raizunne as a part of Raizunne's Miscellany  
Source code found at github.com/Raizunne
 */
package com.raizunne.miscellany;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPressurePlate;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

import com.raizunne.miscellany.client.render.RenderOnPlayer;
import com.raizunne.miscellany.handler.GUIHandler;
import com.raizunne.miscellany.handler.MiscellanyEventHandler;
import com.raizunne.miscellany.handler.PotionHandler;
import com.raizunne.miscellany.proxies.ClientProxy;
import com.raizunne.miscellany.proxies.CommonProxy;
import com.raizunne.miscellany.tileentities.TileEntityAdvReactBrewer;
import com.raizunne.miscellany.tileentities.TileEntityColumn;
import com.raizunne.miscellany.tileentities.TileEntityFoodPackager;
import com.raizunne.miscellany.tileentities.TileEntityHeart;
import com.raizunne.miscellany.tileentities.TileEntityPackage;
import com.raizunne.miscellany.tileentities.TileEntityPresent;
import com.raizunne.miscellany.tileentities.TileEntityTrophyBase;
import com.raizunne.miscellany.util.Config;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = Miscellany.MODID, version = Miscellany.VERSION, dependencies = "required-after:CoFHCore")
public class Miscellany
{
    public static final String MODID = "Miscellany";
    public static final String VERSION = "0.5.1";
    
    @Instance
    public static Miscellany instance;
    public static SimpleNetworkWrapper network;
    @SidedProxy(clientSide = "com.raizunne.miscellany.proxies.ClientProxy", serverSide = "com.raizunne.miscellany.proxies.CommonProxy")
    public static CommonProxy proxy;
    
    public static Configuration configFile;    
    public static DamageSource KnowledgeOverdose = new DamageSource("KnowledgeOverdose");
    
    public static CreativeTabs miscTab = new CreativeTabs("Miscellany"){
		@Override
		public Item getTabIconItem() {
			return MiscItems.sacredChalice;
		}
    };
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent e){
    	network = NetworkRegistry.INSTANCE.newSimpleChannel("Miscellany");
   	 	
   	 	MiscItems.init();
   	 	MiscBlocks.init();
   		MiscRecipes.init();
   		proxy.initRenderers();
   		
   	 	GameRegistry.registerTileEntity(TileEntityAdvReactBrewer.class, "advreactbrewer");
   	 	GameRegistry.registerTileEntity(TileEntityPresent.class, "present");
   	 	GameRegistry.registerTileEntity(TileEntityPackage.class, "package");
   	 	GameRegistry.registerTileEntity(TileEntityHeart.class, "heart");
   	 	GameRegistry.registerTileEntity(TileEntityTrophyBase.class, "trophy");
   	 	GameRegistry.registerTileEntity(TileEntityFoodPackager.class, "foodpackager");
   	 	GameRegistry.registerTileEntity(TileEntityColumn.class, "column");   
   	 	
   	 	MinecraftForge.EVENT_BUS.register(new MiscellanyEventHandler());
   	 	MinecraftForge.EVENT_BUS.register(new Config());
   	 	
   	 	configFile = new Configuration(e.getSuggestedConfigurationFile());
   	 	configFile.load();
   	 	Config.MiscConfig(configFile);
   	 	
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event){
    	NetworkRegistry.INSTANCE.registerGuiHandler(this, new GUIHandler());
    }
    
    public void load(FMLInitializationEvent event){
    	new GUIHandler();
    	new PotionHandler();
    }

}
