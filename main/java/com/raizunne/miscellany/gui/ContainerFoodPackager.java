package com.raizunne.miscellany.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.raizunne.miscellany.tileentities.TileEntityFoodPackager;

public class ContainerFoodPackager extends Container{
	
	private TileEntityFoodPackager foodpackager;
	
	public ContainerFoodPackager(InventoryPlayer invPlayer, TileEntityFoodPackager foodpackager){
		this.foodpackager = foodpackager;
		
		for(int x=0; x < 9; x++){
			addSlotToContainer(new Slot(invPlayer, x, 8 + 18 * x, 142));
		}
		
		for(int y = 0; y < 3; y++){
			for(int x = 0; x < 9; x++){
				addSlotToContainer(new Slot(invPlayer, x + y * 9 + 9, 8 + 18 * x, 84 + y * 18));
			}
		}
		for(int x = 0; x<3; x++){
			addSlotToContainer(new Slot(foodpackager, x, 44 + 18 * x, 24));
		}
		
		for(int x = 0; x<3; x++){
			addSlotToContainer(new Slot(foodpackager, x + 3, 44 + 18 * x, 42));
		}
		
		
		addSlotToContainer(new Slot(foodpackager, 6, 8, 63));
		
		addSlotToContainer(new Slot(foodpackager, 7, 133, 33));
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		
		return foodpackager.isUseableByPlayer(player);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int i) {
		return null;
	}
	
}
