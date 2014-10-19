package com.raizunne.miscellany;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.MinecraftForge;

import com.raizunne.miscellany.handler.CraftingHandler;
import com.raizunne.miscellany.handler.GUIHandler;
import com.raizunne.miscellany.handler.MiscMessage;
import com.raizunne.miscellany.handler.MiscellanyEventHandler;
import com.raizunne.miscellany.handler.PacketHandler;
import com.raizunne.miscellany.handler.PlayerTracker;
import com.raizunne.miscellany.handler.PotionHandler;
import com.raizunne.miscellany.proxies.CommonProxy;
import com.raizunne.miscellany.server.debugHunger;
import com.raizunne.miscellany.tileentities.TileEntityAdvReactBrewer;
import com.raizunne.miscellany.tileentities.TileEntityPackage;
import com.raizunne.miscellany.tileentities.TileEntityPresent;

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

@Mod(modid = Miscellany.MODID, version = Miscellany.VERSION)
public class Miscellany
{
    public static final String MODID = "Miscellany";
    public static final String VERSION = "0.3a";
    
    @Instance
    public static Miscellany instance;
    public static SimpleNetworkWrapper network;
    @SidedProxy(clientSide = "com.raizunne.miscellany.proxies.ClientProxy", serverSide = "com.raizunne.miscellany.proxies.CommonProxy")
    public static CommonProxy proxy;
    
    public static CreativeTabs miscTab = new CreativeTabs("Miscellany"){
		@Override
		public Item getTabIconItem() {
			return MiscItems.sacredChalice;
		}
    };
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent e){
    	network = NetworkRegistry.INSTANCE.newSimpleChannel("Miscellany");
    	network.registerMessage(PacketHandler.class, MiscMessage.class, 0, Side.CLIENT);
   	 	
   	 	MiscItems.init();
   	 	MiscBlocks.init();
   		MiscRecipes.init();
   		proxy.initRenderers();
   		
   	 	GameRegistry.registerTileEntity(TileEntityAdvReactBrewer.class, "advreactbrewer");
   	 	GameRegistry.registerTileEntity(TileEntityPresent.class, "present");
   	 	GameRegistry.registerTileEntity(TileEntityPackage.class, "package");
   	 	
   	 	
   	 	MinecraftForge.EVENT_BUS.register(new MiscellanyEventHandler());
   	 	MinecraftForge.EVENT_BUS.register(new CraftingHandler());
   	 	
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	NetworkRegistry.INSTANCE.registerGuiHandler(this, new GUIHandler());
    }
    
    public void load(FMLInitializationEvent event){
    	new GUIHandler();
    	new PotionHandler();
    }
    
    @EventHandler
    public void serverLoad(FMLServerStartingEvent event)
    {
      event.registerServerCommand(new debugHunger());
    }
    

}
