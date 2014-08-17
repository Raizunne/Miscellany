package com.raizunne.miscellany.tileentities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

import com.raizunne.miscellany.Miscellany;

public class TileEntityAdvReactBrewer extends TileEntity implements IInventory{

	private ItemStack[] items;
	private int progress;
	
	public TileEntityAdvReactBrewer(){
		items = new ItemStack[8];
		
	}
	
	public ItemStack checkSlots(ItemStack top, ItemStack right, ItemStack bottom, ItemStack left, ItemStack center){
		if(top==new ItemStack(Items.apple)&& right==null && bottom==null && left==null && center==new ItemStack(Items.glass_bottle)){
			return new ItemStack(Items.apple);
		}else{
			return null;
		}
		
		
	}
	
	@Override
	public void updateEntity() {
		if(items[1]== new ItemStack(Items.apple)){
			setInventorySlotContents(4, new ItemStack(Items.arrow));
			markDirty();
		}
			
			
		
		if(progress == 0 && !worldObj.isRemote){
			
		}
	}
	
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
	
	}

	@Override
	public int getSizeInventory() {
		return items.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return items[i];
	}

	@Override
	public ItemStack decrStackSize(int i, int count) {
		ItemStack itemstack = getStackInSlot(i);
		
		if(itemstack != null){
			if(itemstack.stackSize <= count){
				setInventorySlotContents(i, null);
			}else{
				itemstack = itemstack.splitStack(count);
				markDirty();
			}
		}	
		return itemstack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		ItemStack item = getStackInSlot(i);
		setInventorySlotContents(i, null);
		return item;
		
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		items[i] = itemstack;
	}

	@Override
	public String getInventoryName() {
		return "FoodPackager";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) <= 64;
	}

	@Override
	public void openInventory() {
	}

	@Override
	public void closeInventory() {
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return true;
	}
	
	public boolean canInsertItem(int i, ItemStack itemstack, int j){
		return false;
	}
	
	public boolean canExtractItem(int i, ItemStack itemstack, int j){
		return false;		
	}
	
}
