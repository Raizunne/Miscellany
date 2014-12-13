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
   	 		"WIW",
   	 		"WWW", 'I', Items.iron_ingot, 'W', Blocks.planks});
   	 	
   	 	GameRegistry.addRecipe(new ItemStack(MiscBlocks.packager), new Object[]{
	 		"III",
	 		"IFI",
	 		"CCC", 'I', Items.iron_ingot, 'F', Blocks.furnace, 'C', Blocks.cobblestone});
   	 	
   	 GameRegistry.addRecipe(new ItemStack(MiscBlocks.thepackage), new Object[]{
	 		"III",
	 		"ICI",
	 		"IBI", 'I', Items.iron_ingot, 'C', Blocks.chest, 'B', Blocks.iron_block});
   	 	
   	 	GameRegistry.addRecipe(new ItemStack(MiscBlocks.column, 7), new Object[]{
	 		"QQQ",
	 		" Q ",
	 		"QQQ", 'Q', Blocks.quartz_block});
   	 	
   	 	GameRegistry.addRecipe(new ItemStack(MiscItems.pack), new Object[]{
	 		" P ",
	 		"PCP",
	 		" P ", 'P', Items.paper, 'C', Blocks.chest});
   	 	
   	 	GameRegistry.addRecipe(new ItemStack(MiscBlocks.present), new Object[]{
	 		"PPP",
	 		"PCP",
	 		"PPP", 'P', Items.paper, 'C', Blocks.chest});
   	 	
   	 	IRecipe gem = new GemLeveling();
   	 	
   	 	GameRegistry.addRecipe(gem);
   	 	
   	 	
   	 	
   	 	GameRegistry.addShapelessRecipe(new ItemStack(MiscItems.manualBook), Items.book, Items.flint);
   	 	GameRegistry.addShapelessRecipe(new ItemStack(MiscItems.pamphlet), Items.paper, Items.flint);
   	 	
	}
	
}
