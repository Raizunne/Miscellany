package com.raizunne.miscellany;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;

import com.raizunne.miscellany.util.recipe.GemLeveling;

import cpw.mods.fml.common.registry.GameRegistry;

public class MiscRecipes {

	public static void init(){
		GameRegistry.addRecipe(new ItemStack(MiscItems.sacredChalice), new Object[]{
   	 		"IWI",
   	 		" G ",
   	 		"III",
   	 		'I', Items.gold_ingot, 'W', Items.water_bucket, 'G', Blocks.gold_block});
   	 	
   	 	GameRegistry.addRecipe(new ItemStack(MiscBlocks.brewer), new Object[]{
   	 		"SSS",
   	 		" C ",
   	 		"CCC",
   	 		'S', Blocks.stone_slab, 'C', Blocks.hardened_clay});
   	 	
   	 	GameRegistry.addRecipe(new ItemStack(MiscItems.potionFlask), new Object[]{
   	 		"I",
   	 		"W",
   	 		"B",'I', Items.iron_ingot, 'W', Blocks.log, 'B', Items.glass_bottle});
   	 	
   	 	GameRegistry.addRecipe(new ItemStack(MiscItems.ExplosiveCatalyst), new Object[]{
   	 		"TTT",
   	 		"TCT",
   	 		"TTT", 'T', Blocks.tnt, 'C', Items.coal});
   	 	
   	 	GameRegistry.addRecipe(new ItemStack(MiscItems.knowledgegem), new Object[]{
   	 		" E ",
   	 		"EDE",
   	 		" E ", 'E', Items.emerald, 'D', Items.diamond});
   	 	
   	 	GameRegistry.addRecipe(new ItemStack(MiscBlocks.trophybase), new Object[]{
   	 		"   ",
   	 		" I ",
   	 		"WWW", 'I', Items.iron_ingot, 'W', Blocks.planks});
   	 	
   	 	IRecipe gem = new GemLeveling();
   	 	
   	 	GameRegistry.addRecipe(gem);
   	 	
   	 	
   	 	
   	 	GameRegistry.addShapelessRecipe(new ItemStack(MiscItems.manualBook), Items.book, Items.flint);
   	 	GameRegistry.addShapelessRecipe(new ItemStack(MiscItems.pamphlet), Items.paper, Items.flint);
   	 	
	}
	
}
