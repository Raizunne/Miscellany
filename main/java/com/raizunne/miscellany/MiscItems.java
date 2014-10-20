package com.raizunne.miscellany;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.Potion;

import com.raizunne.miscellany.handler.PotionHandler;
import com.raizunne.miscellany.item.ExplosiveCatalyst;
import com.raizunne.miscellany.item.Package;
import com.raizunne.miscellany.item.Pamphlet;
import com.raizunne.miscellany.item.PotionFlask;
import com.raizunne.miscellany.item.Shake;
import com.raizunne.miscellany.item.TheFlute;
import com.raizunne.miscellany.item.TheHeart;
import com.raizunne.miscellany.item.breadLoaf;
import com.raizunne.miscellany.item.manualBook;
import com.raizunne.miscellany.item.redstonicJetBoots;
import com.raizunne.miscellany.item.sacredChalice;
import com.raizunne.miscellany.item.PotionFlasks.AntiWither;
import com.raizunne.miscellany.item.PotionFlasks.Flight;
import com.raizunne.miscellany.item.PotionFlasks.Knowledge;
import com.raizunne.miscellany.item.potions.PotionFlight;
import com.raizunne.miscellany.item.potions.PotionKnowledge;

import cpw.mods.fml.common.registry.GameRegistry;

public class MiscItems {
	public static Item debugHunger;
	public static Item redstonicBoots;
	public static Item sacredChalice;
	public static Item manualBook;
	public static Item Shake;
	public static Item pamphlet;
	public static Item breadLoaf;
	public static Item pack;
	public static Item ExplosiveCatalyst;
	public static Item theflute;
	public static Item theheart;
	
	public static Item potionFlask;
	public static Item flightFlask;
	public static Item knowledgeFlask;
	public static Item WitherAnti;
	
	public static Potion knowledgePotion;
    public static Potion flightPotion;
	
	public static void init(){
   	 	debugHunger = new com.raizunne.miscellany.item.debugHunger();
   	 	redstonicBoots = new redstonicJetBoots(ArmorMaterial.DIAMOND, 2, 3);
   	 	sacredChalice = new sacredChalice();
   	 	manualBook = new manualBook();
   	 	Shake = new Shake();
   	 	pamphlet = new Pamphlet();
   	 	breadLoaf = new breadLoaf(6, 6, false);
   	 	pack = new Package();
   	 	ExplosiveCatalyst = new ExplosiveCatalyst();
   	 	theheart = new TheHeart();
   	 	theflute = new TheFlute();
   	 	
   	 	potionFlask = new PotionFlask();
   	 	flightFlask = new Flight();
   	 	knowledgeFlask = new Knowledge();
   	 	WitherAnti = new AntiWither();
   	 	
//	 	GameRegistry.registerItem(pack, pack.getUnlocalizedName().substring(5));
//	 	GameRegistry.registerItem(redstonicBoots, redstonicBoots.getUnlocalizedName().substring(5));
//	 	GameRegistry.registerItem(packagedFood, packagedFood.getUnlocalizedName().substring(5));
	 	GameRegistry.registerItem(debugHunger, debugHunger.getUnlocalizedName().substring(5));
	 	GameRegistry.registerItem(sacredChalice, sacredChalice.getUnlocalizedName().substring(5));
	 	GameRegistry.registerItem(manualBook, manualBook.getUnlocalizedName().substring(5));
	 	GameRegistry.registerItem(Shake, Shake.getUnlocalizedName().substring(5));
	 	GameRegistry.registerItem(pamphlet, pamphlet.getUnlocalizedName().substring(5));
	 	GameRegistry.registerItem(breadLoaf, breadLoaf.getUnlocalizedName().substring(5));
	 	GameRegistry.registerItem(ExplosiveCatalyst, ExplosiveCatalyst.getUnlocalizedName().substring(5));
	 	GameRegistry.registerItem(theheart, theheart.getUnlocalizedName().substring(5));
	 	GameRegistry.registerItem(theflute, theflute.getUnlocalizedName().substring(5));

	 	//Potions
	 	PotionHandler.initPotions();
   	 	knowledgePotion = (new PotionKnowledge(45, false, 0));
   	 	flightPotion = (new PotionFlight(46, false, 0));
	 	GameRegistry.registerItem(potionFlask, potionFlask.getUnlocalizedName().substring(5));
	 	GameRegistry.registerItem(flightFlask, flightFlask.getUnlocalizedName().substring(5));
	 	GameRegistry.registerItem(knowledgeFlask, knowledgeFlask.getUnlocalizedName().substring(5));
	 	GameRegistry.registerItem(WitherAnti, WitherAnti.getUnlocalizedName().substring(5));
	}
}