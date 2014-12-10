/**
Code made by Raizunne as a part of Raizunne's Miscellany  
Source code found at github.com/Raizunne
 */
package com.raizunne.miscellany.util;

import java.util.HashSet;
import java.util.Set;

import scala.actors.threadpool.Arrays;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class PackagerValues {
	
	public static final ItemStack[] allposibleitems = {
		stack(Items.potato), stack(Items.cookie), stack(Items.melon), stack(Items.fish), stack(Items.chicken), stack(Items.porkchop), stack(Items.beef),
		stack(Items.apple), stack(Items.carrot), stack(Items.bread), stack(Items.cooked_fished), stack(Items.mushroom_stew), stack(Items.baked_potato), stack(Items.golden_carrot),
		stack(Items.cooked_chicken), stack(Items.cooked_beef), stack(Items.cooked_porkchop), stack(Items.pumpkin_pie), stack(Items.cake)
	};	
	public static final ItemStack[] ten = {
		stack(Items.potato), stack(Items.cookie), stack(Items.melon), stack(Items.spider_eye)
	};
	public static final ItemStack[] fifty = {
		stack(Items.fish), stack(Items.chicken), stack(Items.porkchop), stack(Items.beef), stack(Items.apple)
	};
	public static final ItemStack[] hundred = {
		stack(Items.carrot)
	};	
	public static final ItemStack[] hundredfifty = {
		
	};
	public static final ItemStack[] twohundred = {
		stack(Items.cooked_fished), stack(Items.mushroom_stew), stack(Items.baked_potato), stack(Items.bread)
	};
	public static final ItemStack[] twofifty = {
		stack(Items.cooked_chicken), stack(Items.cooked_beef), stack(Items.cooked_porkchop), stack(Items.golden_carrot) 
	};
	public static final ItemStack[] threehundo = {
		new ItemStack(Items.cake), stack(Items.pumpkin_pie)
	};
	public static final ItemStack[] fivehundo = {
		meta(Items.golden_apple, 0)
	};
	public static final ItemStack stack(Item item){
		return new ItemStack(item);
	}
	
	public static final ItemStack meta(Item item, int i){
		return new ItemStack(item, i);
	}
	
	
}

