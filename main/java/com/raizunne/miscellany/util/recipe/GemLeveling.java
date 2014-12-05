/**
Code made by Raizunne as a part of Raizunne's Miscellany  
Source code found at github.com/Raizunne
 */
package com.raizunne.miscellany.util.recipe;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import com.raizunne.miscellany.MiscItems;
import com.raizunne.miscellany.item.KnowledgeGem;

public class GemLeveling implements IRecipe {

	InventoryCrafting inv;
	
	@Override
	public boolean matches(InventoryCrafting inv, World p_77569_2_) {
		this.inv = inv;
		ItemStack emerald = new ItemStack(Items.emerald);
		if(slot(4)!=null && slot(1)!=null && slot(3)!=null && slot(5)!=null && slot(7)!=null){
			if(item(4) instanceof KnowledgeGem && item(1).equals(Items.emerald) && item(3).equals(Items.emerald) && item(5).equals(Items.emerald) && item(7).equals(Items.emerald)){
					return true;					
			}
		}
		return false;
	}
	
	public ItemStack slot(int slot){
		return inv.getStackInSlot(slot);
	}
	
	public Item item(int slot){
		return inv.getStackInSlot(slot).getItem();
	}
	
	public boolean checkSlots(InventoryCrafting inv, int slot, Item item){
		System.out.println(slot);
		if(inv.getStackInSlot(slot)!=null){
			if(inv.getStackInSlot(slot)==new ItemStack(item)){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public ItemStack getCraftingResult(InventoryCrafting inv) {
		ItemStack knowledge = new ItemStack(MiscItems.knowledgegem);
		if(knowledge.stackTagCompound==null){
			knowledge.stackTagCompound = new NBTTagCompound();
			knowledge.stackTagCompound.setInteger("xp", inv.getStackInSlot(4).stackTagCompound.getInteger("xp"));
			knowledge.stackTagCompound.setBoolean("creative", false);
			knowledge.stackTagCompound.setInteger("max", inv.getStackInSlot(4).stackTagCompound.getInteger("max")+10);
		}else{
			knowledge.stackTagCompound.setInteger("max", inv.getStackInSlot(4).stackTagCompound.getInteger("max")+10);
		}
		return knowledge;
	}

	@Override
	public int getRecipeSize() {
		return 0;
	}

	@Override
	public ItemStack getRecipeOutput() {
		return null;
	}

}
