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

import com.raizunne.miscellany.block.AdvReactBrewer;
import com.raizunne.miscellany.block.FoodPackager;
import com.raizunne.miscellany.block.Present;
import com.raizunne.miscellany.handler.GUIHandler;
import com.raizunne.miscellany.handler.MiscellanyEventHandler;
import com.raizunne.miscellany.handler.PotionHandler;
import com.raizunne.miscellany.item.PackagedFood;
import com.raizunne.miscellany.item.manualBook;
import com.raizunne.miscellany.item.redstonicJetBoots;
import com.raizunne.miscellany.item.sacredChalice;
import com.raizunne.miscellany.item.potions.PotionKnowledge;
import com.raizunne.miscellany.item.PotionFlask;
import com.raizunne.miscellany.proxies.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Miscellany.MODID, version = Miscellany.VERSION)
//@NetworkMod(clientSideRequired=true, serverSideRequired=true, channels={"RaizunnesMiscellany"}, packetHandler = handler.PacketHandler.class);
public class Miscellany
{
    public static final String MODID = "Miscellany";
    public static final String VERSION = "a1";
    
    @Instance
    public static Miscellany instance;
    
    public static CreativeTabs miscTab = new CreativeTabs("Miscellany"){
		@Override
		public Item getTabIconItem() {
			return Miscellany.sacredChalice;
		}
    };
    
    public static SimpleNetworkWrapper network;
    
    @SidedProxy(clientSide = "com.raizunne.miscellany.proxies.ClientProxy", serverSide = "com.raizunne.miscellany.proxies.CommonProxy")
    public static CommonProxy proxy;
        
    public static Item packagedFood;
    public static Item debugHunger;
    public static Item redstonicBoots;
    public static Item sacredChalice;
    public static Item manualBook;
    public static Item potionFlask;
    
    public static Block foodPackager;
    public static Block present;
    public static Block brewer;
    
    public static Potion knowledgePotion;
    public static Potion flightPotion;
        
    @EventHandler
    public void preInit(FMLPreInitializationEvent e){

    	network = NetworkRegistry.INSTANCE.newSimpleChannel("Miscellany");
    	    	
    	packagedFood = new PackagedFood(10, 0, false);
   	 	debugHunger = new com.raizunne.miscellany.item.debugHunger();
   	 	redstonicBoots = new redstonicJetBoots(ArmorMaterial.DIAMOND, 2, 3);
   	 	sacredChalice = new sacredChalice();
   	 	manualBook = new manualBook();
   	 	potionFlask = new PotionFlask();
   	 	
   	 	foodPackager = new FoodPackager(Material.ground);
   	 	present = new Present(Material.ground);
   	 	brewer = new AdvReactBrewer(Material.ground);
   	 	
   	 	
   	 	PotionHandler.initPotions();
   	 	knowledgePotion = (new PotionKnowledge(45, false, 0));
   	 	flightPotion = (new PotionKnowledge(46, false, 0));
  	 	   	 
   	 	GameRegistry.registerItem(packagedFood, packagedFood.getUnlocalizedName().substring(5));
   	 	GameRegistry.registerItem(debugHunger, debugHunger.getUnlocalizedName().substring(5));
   	 	GameRegistry.registerItem(redstonicBoots, redstonicBoots.getUnlocalizedName().substring(5));
   	 	GameRegistry.registerItem(sacredChalice, sacredChalice.getUnlocalizedName().substring(5));
   	 	GameRegistry.registerItem(manualBook, manualBook.getUnlocalizedName().substring(5));
   	 	GameRegistry.registerItem(potionFlask, potionFlask.getUnlocalizedName().substring(5));
   	 	
   	 	GameRegistry.registerBlock(foodPackager, "foodPackager");
   	 	GameRegistry.registerBlock(present, "present");
   	 	GameRegistry.registerBlock(brewer, "advBrew");
   	 	

   	 	GameRegistry.addRecipe(new ItemStack(Miscellany.redstonicBoots), new Object[] { 
   	 		"RLR",
   	 		"LBL",
   	 		"RGR",
   	 		'R', Blocks.redstone_block, 'L', Items.leather, 'B', Items.leather_boots, 'G', Items.gold_ingot});
   	 	
   	 	GameRegistry.addRecipe(new ItemStack(Miscellany.sacredChalice), new Object[]{
   	 		"IWI",
   	 		" I ",
   	 		"GGG",
   	 		'I', Items.gold_ingot, 'W', Items.water_bucket, 'G', Blocks.gold_block});
   	 	
   	 	GameRegistry.addShapelessRecipe(new ItemStack(Miscellany.manualBook), Items.book, Items.flint_and_steel);
   	 	proxy.initRenderers();
   	 	MinecraftForge.EVENT_BUS.register(new MiscellanyEventHandler());
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
    

}
