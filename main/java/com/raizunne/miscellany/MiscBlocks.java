package com.raizunne.miscellany;

import com.raizunne.miscellany.block.AdvReactBrewer;
import com.raizunne.miscellany.block.Column;
import com.raizunne.miscellany.block.FoodPackager;
import com.raizunne.miscellany.block.Heart;
import com.raizunne.miscellany.block.NoNite;
import com.raizunne.miscellany.block.Present;
import com.raizunne.miscellany.block.ShiftyPlate;
import com.raizunne.miscellany.block.ThePackage;
import com.raizunne.miscellany.block.TrophyBase;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class MiscBlocks {

	public static Block packager;
    public static Block present;
    public static Block brewer;
    public static Block noNite;
    public static Block thepackage;
    public static Block heart;
    public static Block trophybase;
    public static Block column;
    public static Block shifty;
    
	public static void init(){
   	 	present = new Present(Material.ground);
   	 	brewer = new AdvReactBrewer(Material.ground);
   	 	noNite = new NoNite(Material.ground);
   	 	heart = new Heart(Material.ground);
   	 	thepackage = new ThePackage(Material.ground);
   	 	trophybase = new TrophyBase(Material.ground);
   	 	packager = new FoodPackager(Material.ground);
   	 	column = new Column(Material.ground);
   	 	shifty = new ShiftyPlate(Material.ground);
   	 	
//   	 	GameRegistry.registerBlock(noNite, "nonite");
   	 	GameRegistry.registerBlock(thepackage, "thepackage");
	 	GameRegistry.registerBlock(brewer, "advBrew");
	 	GameRegistry.registerBlock(trophybase, "trophybase");
	 	GameRegistry.registerBlock(packager, "foodpackager");
	 	GameRegistry.registerBlock(column, "misccolumn");
//	 	GameRegistry.registerBlock(shifty, "shiftyplate");
//	 	GameRegistry.registerBlock(heart, "hearthealer");
	 	GameRegistry.registerBlock(present, "present");
	 	
	}
	
}
