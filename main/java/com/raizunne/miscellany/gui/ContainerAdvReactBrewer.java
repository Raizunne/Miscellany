package com.raizunne.miscellany.gui;

import com.raizunne.miscellany.tileentities.TileEntityAdvReactBrewer;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerAdvReactBrewer extends Container{

	private TileEntityAdvReactBrewer advbrewer;
	
	public ContainerAdvReactBrewer(InventoryPlayer invplayer, TileEntityAdvReactBrewer advbrewer){
		this.advbrewer = advbrewer;
		
		for(int x=0; x < 9; x++){
			addSlotToContainer(new Slot(invplayer, x, 8 + 18 * x, 142));
		}
		
		for(int y = 0; y < 3; y++){
			for(int x = 0; x < 9; x++){
				addSlotToContainer(new Slot(invplayer, x + y * 9 + 9, 8 + 18 * x, 84 + y * 18));
			}
		}
		
		addSlotToContainer(new Slot(advbrewer, 0, 54, 26));
		addSlotToContainer(new Slot(advbrewer, 1, 80, 16));
		addSlotToContainer(new Slot(advbrewer, 2, 106, 26));
		addSlotToContainer(new Slot(advbrewer, 3, 80, 59));	
		
	}
	
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return advbrewer.isUseableByPlayer(player);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int i) {
		return null;
	}

}
