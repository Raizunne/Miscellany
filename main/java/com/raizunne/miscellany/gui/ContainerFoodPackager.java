/**
Code made by Raizunne as a part of Raizunne's Miscellany  
Source code found at github.com/Raizunne
 */
package com.raizunne.miscellany.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

import com.raizunne.miscellany.tileentities.TileEntityAdvReactBrewer;
import com.raizunne.miscellany.tileentities.TileEntityFoodPackager;

public class ContainerFoodPackager extends Container{

	private TileEntityFoodPackager packager;
	
	public ContainerFoodPackager(InventoryPlayer invplayer, TileEntityFoodPackager te){
		this.packager = te;
		
		for(int x=0; x < 9; x++){
			addSlotToContainer(new Slot(invplayer, x, 8 + 18 * x, 142));
		}
		
		for(int y = 0; y < 3; y++){
			for(int x = 0; x < 9; x++){
				addSlotToContainer(new Slot(invplayer, x + y * 9 + 9, 8 + 18 * x, 84 + y * 18));
			}
		}
		addSlotToContainer(new Slot(te, 0, 44, 24));
		addSlotToContainer(new Slot(te, 1, 62, 24));
		addSlotToContainer(new Slot(te, 2, 80, 24));
		addSlotToContainer(new Slot(te, 3, 44, 42));
		addSlotToContainer(new Slot(te, 4, 62, 42));
		addSlotToContainer(new Slot(te, 5, 80, 42));
		addSlotToContainer(new Slot(te, 6, 133, 33));
		
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return packager.isUseableByPlayer(player);
	}

}
