package com.raizunne.miscellany.gui.container;

import com.raizunne.miscellany.MiscItems;
import com.raizunne.miscellany.tileentities.TileEntityPackage;
import com.raizunne.miscellany.tileentities.TileEntityPresent;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.ForgeDirection;

public class ContainerPackage extends Container{

	private TileEntityPackage pack;
	int lastEnergy;
	
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
	public void detectAndSendChanges() {
		super.detectAndSendChanges();
		for (int i = 0; i < this.crafters.size(); ++i){
			ICrafting icrafting = (ICrafting)this.crafters.get(i);
			if(this.lastEnergy!=this.pack.getEnergyStored(ForgeDirection.UP)){
				icrafting.sendProgressBarUpdate(this, 0, this.pack.getEnergyStored(ForgeDirection.UP));
			}
		}
		this.lastEnergy = this.pack.getEnergyStored(ForgeDirection.UP);
	}
	
	@Override
	public void updateProgressBar(int par1, int par2) {
		super.updateProgressBar(par1, par2);
		if(par1==0){
			this.pack.setEnergy(par2);
		}
	}
	
	@Override
	public void addCraftingToCrafters(ICrafting icrafting) {
		super.addCraftingToCrafters(icrafting); 
		icrafting.sendProgressBarUpdate(this, 0, this.pack.getEnergyStored(ForgeDirection.UP));
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return pack.isUseableByPlayer(player);
	}
	
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {
	    ItemStack itemstack = null;
	    Slot slot = (Slot) this.inventorySlots.get(par2);

	    if(slot != null && slot.getHasStack()) {
	      ItemStack itemstack1 = slot.getStack();
	      itemstack = itemstack1.copy();

	      if(par2 < 35){
	    	  if(itemstack1.isItemEqual(new ItemStack(MiscItems.pack))){
	    		  if(!mergeItemStack(itemstack1, 44, 46, false)){
	    			  if(!mergeItemStack(itemstack1, 9, 35, false)){
	    				  return null;
	    			  }
	    		  }
	    	  }else{
	    		  if(!mergeItemStack(itemstack1, 36, 45, false)){
	    			  if(!mergeItemStack(itemstack1, 9, 35, false)){
	    				  return null;
	    			  }
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
