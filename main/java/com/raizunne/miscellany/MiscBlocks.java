package com.raizunne.miscellany;

import com.raizunne.miscellany.block.AdvReactBrewer;
import com.raizunne.miscellany.block.FoodPackager;
import com.raizunne.miscellany.block.NoNite;
import com.raizunne.miscellany.block.Present;
import com.raizunne.miscellany.block.ThePackage;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class MiscBlocks {

	public static Block foodPackager;
    public static Block present;
    public static Block brewer;
    public static Block noNite;
    public static Block thepackage;
    
	public static void init(){
		foodPackager = new FoodPackager(Material.ground);
   	 	present = new Present(Material.ground);
   	 	brewer = new AdvReactBrewer(Material.ground);
   	 	noNite = new NoNite(Material.ground);
   	 	thepackage = new ThePackage(Material.ground);
   	 	
   	 	GameRegistry.registerBlock(noNite, "nonite");
   	 	GameRegistry.registerBlock(thepackage, "thepackage");
	 	GameRegistry.registerBlock(brewer, "advBrew");
	 	GameRegistry.registerBlock(foodPackager, "foodPackager");
	 	GameRegistry.registerBlock(present, "present");
	 	
	}
	
}
