package com.raizunne.miscellany.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.raizunne.miscellany.tileentities.TileEntityAdvReactBrewer;
import com.raizunne.miscellany.tileentities.TileEntityPresent;

public class ContainerPresent extends Container{

	private TileEntityPresent present;
	
	public ContainerPresent(InventoryPlayer invplayer, TileEntityPresent present){
		this.present = present;
		
		for(int x=0; x < 9; x++){
			addSlotToContainer(new Slot(invplayer, x, 8 + 18 * x, 142));
		}
		
		for(int y = 0; y < 3; y++){
			for(int x = 0; x < 9; x++){
				addSlotToContainer(new Slot(invplayer, x + y * 9 + 9, 8 + 18 * x, 84 + y * 18));
			}
		}
		
		for(int x=0; x<7; x++){
			addSlotToContainer(new Slot(present, x, 26 + 18*x, 58));
		}	
		
	}
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return present.isUseableByPlayer(player);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int i) {
		return null;
	}

}
