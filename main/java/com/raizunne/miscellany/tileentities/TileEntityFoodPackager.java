package com.raizunne.miscellany.tileentities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

import com.raizunne.miscellany.MiscItems;

public class TileEntityFoodPackager extends TileEntity implements IInventory{

	private ItemStack[] items;
	
	public TileEntityFoodPackager(){
		items = new ItemStack[8];
		
	}
	
	@Override
	public void updateEntity() {
		super.updateEntity();
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
		markDirty();
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeInventory() {
		// TODO Auto-generated method stub
		
	}
	
	public static int getCalories(ItemStack itemstack){
		
		Item item = itemstack.getItem();
		
		if(itemstack.getUnlocalizedName() == Items.cooked_beef.getUnlocalizedName()) return 800;
		if(itemstack.getUnlocalizedName() == Items.cooked_beef.getUnlocalizedName()) return 800;
		if(itemstack.getUnlocalizedName() == Items.cooked_fished.getUnlocalizedName()) return 700;
		if(itemstack.getUnlocalizedName() == Items.cooked_porkchop.getUnlocalizedName()) return 800;
		
		if(itemstack.getUnlocalizedName() == Items.cake.getUnlocalizedName()) return 2000;
		if(itemstack.getUnlocalizedName() == Items.pumpkin_pie.getUnlocalizedName()) return 1000;
		if(itemstack.getUnlocalizedName() == Items.golden_apple.getUnlocalizedName()) return 5000;
		
		
		
		return 200;
	}
	
	public static boolean isFood(ItemStack itemstack){
		if(itemstack != null && itemstack.getItem() instanceof ItemFood){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return i != 7;
	}
	
	public boolean canInsertItem(int i, ItemStack itemstack, int j){
		return i <= 5;
	}
	
	public boolean canExtractItem(int i, ItemStack itemstack, int j){
		return j != 0 || i != 7 || itemstack.getItem() == MiscItems.packagedFood;		
	}
	
}
