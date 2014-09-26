package com.raizunne.miscellany.gui;

import com.raizunne.miscellany.tileentities.TileEntityPackage;
import com.raizunne.miscellany.tileentities.TileEntityPresent;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerPackage extends Container{

	private TileEntityPackage pack;
	
	public ContainerPackage(InventoryPlayer invplayer, TileEntityPackage pack){
		this.pack = pack;
		
		for(int x=0; x < 9; x++){
			addSlotToContainer(new Slot(invplayer, x, 8 + 18 * x, 142));
		}
		
		for(int y = 0; y < 3; y++){
			for(int x = 0; x < 9; x++){
				addSlotToContainer(new Slot(invplayer, x + y * 9 + 9, 8 + 18 * x, 84 + y * 18));
			}
		}
		
		for(int x = 0; x < 3; x++){
			addSlotToContainer(new Slot(pack, x , 41 + 18 * x, 18));
		}
		for(int x = 0; x < 3; x++){
			addSlotToContainer(new Slot(pack, x + 3 , 41 + 18 * x, 36));
		}
		for(int x = 0; x < 3; x++){
			addSlotToContainer(new Slot(pack, x + 6 , 41 + 18 * x, 54));
		}
		addSlotToContainer(new Slot(pack, 9, 137, 36));
		addSlotToContainer(new Slot(pack, 10, 8, 63));
		
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		// TODO Auto-generated method stub
		return pack.isUseableByPlayer(player);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int i) {
		return null;
	}

}
