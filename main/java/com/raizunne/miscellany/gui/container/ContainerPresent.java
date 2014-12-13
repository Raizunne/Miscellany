package com.raizunne.miscellany.gui.container;

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
	public ItemStack transferStackInSlot(EntityPlayer player, int par2) {
		System.out.println(par2);
		ItemStack itemstack = null;
	    Slot slot = (Slot) this.inventorySlots.get(par2);

	    if(slot != null && slot.getHasStack()) {
	      ItemStack itemstack1 = slot.getStack();
	      itemstack = itemstack1.copy();

	      if(par2 < 35){
	    	  if(!mergeItemStack(itemstack1, 36, 43, false)){
	    		  if(!mergeItemStack(itemstack1, 9, 35, false)){
	    			  return null;
	    		  }
	    	  }
	      }else if(par2<9){
	    	 if(!mergeItemStack(itemstack1, 0, 9, false)){
	    		 return null;
	    	 }
	      }else if(!mergeItemStack(itemstack1, 0, 35, false)){
	    	  return null;
	      }

	      if(itemstack1.stackSize == 0) {
	        slot.putStack((ItemStack) null);
	      } else {
	        slot.onSlotChanged();
	      }
	      
	      if (itemstack1.stackSize == itemstack.stackSize) {
              return null;
	      }
	      slot.onPickupFromSlot(player, itemstack1);
	    }
	    return itemstack;
	}

}
