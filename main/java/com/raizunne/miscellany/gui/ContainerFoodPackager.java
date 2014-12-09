/**
Code made by Raizunne as a part of Raizunne's Miscellany  
Source code found at github.com/Raizunne
 */
package com.raizunne.miscellany.gui;

import net.minecraft.client.gui.inventory.GuiFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.ForgeDirection;

import com.raizunne.miscellany.tileentities.TileEntityAdvReactBrewer;
import com.raizunne.miscellany.tileentities.TileEntityFoodPackager;

public class ContainerFoodPackager extends Container{

	private TileEntityFoodPackager packager;
	int lastEnergy;
	
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
	public void detectAndSendChanges() {
		super.detectAndSendChanges();
		for (int i = 0; i < this.crafters.size(); ++i){
			ICrafting icrafting = (ICrafting)this.crafters.get(i);
			if(this.lastEnergy!=this.packager.getEnergyStored(ForgeDirection.UP)){
				icrafting.sendProgressBarUpdate(this, 0, this.packager.getEnergyStored(ForgeDirection.UP));
			}
		}
		this.lastEnergy = this.packager.getEnergyStored(ForgeDirection.UP);
	}
	
	@Override
	public void updateProgressBar(int par1, int par2) {
		super.updateProgressBar(par1, par2);
		if(par1==0){
			this.packager.setEnergy(par2);
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return packager.isUseableByPlayer(player);
	}
	
	@Override
	public void addCraftingToCrafters(ICrafting icrafting) {
		super.addCraftingToCrafters(icrafting); 
		icrafting.sendProgressBarUpdate(this, 0, this.packager.getEnergyStored(ForgeDirection.UP));
	}

	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {
	    ItemStack itemstack = null;
	    Slot slot = (Slot) this.inventorySlots.get(par2);

	    if(slot != null && slot.getHasStack()) {
	      ItemStack itemstack1 = slot.getStack();
	      itemstack = itemstack1.copy();

	      if(par2 < 35){
	    	  if(!mergeItemStack(itemstack1, 36, 42, false)){
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
	      slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
	    }
	    return itemstack;
	 }
	
}
