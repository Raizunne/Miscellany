package com.raizunne.miscellany.util;

import com.raizunne.miscellany.MiscItems;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RecipeUtil {
	 
	private Item witherSkull;
	/**
     * 1 = Knowledge, 2 = Flight, 3 = Anti-Wither, 4 = Heart Potion, 5=Shake
     */
	public static int advBrew(Item slot1, Item slot2, Item slot3, Item slot4){		
		if(slot1==getItems(Blocks.emerald_block)&& slot2==Items.book && slot3==getItems(Blocks.emerald_block) && slot4==MiscItems.potionFlask){
			return 1;
		}else if(slot1==Items.diamond && slot2==Items.feather && slot3==Items.diamond && slot4==MiscItems.potionFlask){
			return 2;
		}else if(slot1==Items.diamond && slot2==Items.skull && slot3==getItems(Blocks.red_flower) && slot4==MiscItems.potionFlask){
			return 3;
		}else if(slot1==Items.speckled_melon && slot2==Items.blaze_powder && slot3 == Items.speckled_melon && slot4==MiscItems.potionFlask){
			return 4;
		}else if(slot1==Items.speckled_melon && slot2==Items.bread && slot3==Items.sugar && slot4==MiscItems.potionFlask){
			return 5;
		}
		return 0;
	}
	
	public static Item getItems(Block block){
		return new ItemStack(block).getItem();
	}
	
	public static boolean checkMetadata(Item what, int meta){
		if(what.getMetadata(0)==meta){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean checkItemdamage(Item what, int dmg){
		if(what.getDamage(new ItemStack(what))==dmg){
			return true;
		}else{
			return false;
		}
	}
}
