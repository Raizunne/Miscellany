/**
Code made by Raizunne as a part of Raizunne's Miscellany  
Source code found at github.com/Raizunne
 */
package com.raizunne.miscellany.tileentities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

import com.raizunne.miscellany.MiscItems;
import com.raizunne.miscellany.util.PackagerValues;

public class TileEntityFoodPackager extends TileEntity implements IInventory{

	private ItemStack[] items;
	private boolean packing;
	private int calories; 
	private int timer;
	private int convertingTimer;
	
	public TileEntityFoodPackager(){
		items = new ItemStack[7];
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
	public void updateEntity() {
		super.updateEntity();
		if(getStackInSlot(6)!=null && getStackInSlot(6).stackSize==64){
			return;
		}		
		if(calories>=1000){
			if(convertingTimer!=80){
				convertingTimer++;
			}else{
				if(getStackInSlot(6)==null){
					setInventorySlotContents(6, new ItemStack(MiscItems.PackagedFood));
					convertingTimer=0;
					calories = calories-1000;
					return;
				}else if(getStackInSlot(6).isItemEqual(stack(MiscItems.PackagedFood))){
					items[6].stackSize++;
					convertingTimer=0;
					calories = calories-1000;
					return;
				}
			}
		}
		if(getStackInSlot(0)!=null && getStackInSlot(0).getItem() instanceof ItemFood && !getStackInSlot(0).isItemEqual(stack(MiscItems.PackagedFood))){
			doProgress(0);
		}else if(getStackInSlot(1)!=null && getStackInSlot(1).getItem() instanceof ItemFood && !getStackInSlot(1).isItemEqual(stack(MiscItems.PackagedFood))){
			doProgress(1);
		}else if(getStackInSlot(2)!=null && getStackInSlot(2).getItem() instanceof ItemFood && !getStackInSlot(2).isItemEqual(stack(MiscItems.PackagedFood))){
			doProgress(2);
		}else if(getStackInSlot(3)!=null && getStackInSlot(3).getItem() instanceof ItemFood && !getStackInSlot(3).isItemEqual(stack(MiscItems.PackagedFood))){
			doProgress(3);
		}else if(getStackInSlot(4)!=null && getStackInSlot(4).getItem() instanceof ItemFood && !getStackInSlot(4).isItemEqual(stack(MiscItems.PackagedFood))){
			doProgress(4);
		}else if(getStackInSlot(5)!=null && getStackInSlot(5).getItem() instanceof ItemFood && !getStackInSlot(5).isItemEqual(stack(MiscItems.PackagedFood))){
			doProgress(5);
		}
	}	
	
	public void doProgress(int i) {
		if(timer!=40 && getStackInSlot(i)!=null && checkIfCool(i)){
			timer++;
		}else{
			calories = calories + checkCalories(i);
			decrStackSize(i, 1);
			timer=0;
		}
	}
	
	public boolean checkIfCool(int i){
		if(getStackInSlot(i)!=null && (getStackInSlot(i).getItem() instanceof ItemFood || getStackInSlot(i).getItem() == Items.cake)){
			return true;
		}else{
			return false;
		}
	}
	
	public int checkCalories(int i){
		for(int r=0; r<PackagerValues.ten.length; r++){
			if(getStackInSlot(i).isItemEqual(PackagerValues.ten[r])){
				return 10;
			}
		}
		for(int r=0; r<PackagerValues.fifty.length; r++){
			if(getStackInSlot(i).isItemEqual(PackagerValues.fifty[r])){
				return 50;
			}
		}
		for(int r=0; r<PackagerValues.hundred.length; r++){
			if(getStackInSlot(i).isItemEqual(PackagerValues.hundred[r])){
				return 100;
			}
		}
		for(int r=0; r<PackagerValues.hundredfifty.length; r++){
			if(getStackInSlot(i).isItemEqual(PackagerValues.hundredfifty[r])){
				return 150;
			}
		}
		for(int r=0; r<PackagerValues.twohundred.length; r++){
			if(getStackInSlot(i).isItemEqual(PackagerValues.twohundred[r])){
				return 200;
			}
		}
		for(int r=0; r<PackagerValues.twofifty.length; r++){
			if(getStackInSlot(i).isItemEqual(PackagerValues.twofifty[r])){
				return 250;
			}
		}
		for(int r=0; r<PackagerValues.threehundo.length; r++){
			if(getStackInSlot(i).isItemEqual(PackagerValues.threehundo[r])){
				return 300;
			}
		}
		for(int r=0; r<PackagerValues.fivehundo.length; r++){
			if(getStackInSlot(i).isItemEqual(PackagerValues.fivehundo[r])){
				return 500;
			}
		}
		if(getStackInSlot(i).isItemEqual(new ItemStack(Items.golden_apple, 1))){
			return 5000;
		}if(getStackInSlot(i).isItemEqual(new ItemStack(Items.rotten_flesh))){
			return 5;
		}
		return 100;
		
	}
	
	public int getProgress(){
		return timer;
	} 
	
	public int getConvertingProgress(){
		return convertingTimer;
	}
	
	public void setCalories(int i){
		calories = i;
	}
	
	public int getScaledProgress(int i){
		if(getProgress()!=0){
			return getProgress() * i / 40;
		}else{
			return 0;
		}
	}
	
	public int getConvertingScaledProgress(int i){
		if(getProgress()!=0){
			return getConvertingProgress() * i / 80;
		}else{
			return 0;
		}
	}
	
	public boolean status(){
		return packing;
	}
	
	public int calories(){
		return calories; 
	}
	
	public int getCaloriesFromSlot(int i){
		return 100;
	}
	
	public static ItemStack stack(Item item){
		return new ItemStack(item);
	}
	
	public void startPacking(){
		packing = true;
	}
	
	public void stopPackaging(){
		packing = false;
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
		return "Food Packager";
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
		if(i==6){
			return false;
		}
		return true;
	}
	
	public boolean canInsertItem(int i, ItemStack itemstack, int j){
		return false;
	}
	
	public boolean canExtractItem(int i, ItemStack itemstack, int j){
		return false;		
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		NBTTagList items = new NBTTagList();
		for (int i = 0; i < getSizeInventory(); i++) {		
			ItemStack stack = getStackInSlot(i);

			if (stack != null) {
				NBTTagCompound item = new NBTTagCompound();
				item.setByte("Slot", (byte)i);
				stack.writeToNBT(item);
				items.appendTag(item);
			}
		compound.setTag("Items", items);
		compound.setBoolean("status", this.packing);
		compound.setInteger("calories", this.calories);
		compound.setInteger("timer", this.timer);
		compound.setInteger("conversion", this.convertingTimer);
		}
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		NBTTagList items = compound.getTagList("Items", 10);

		for (int i = 0; i < items.tagCount(); i++) {
			NBTTagCompound item = (NBTTagCompound)items.getCompoundTagAt(i);
			int slot = item.getByte("Slot");

			if (slot >= 0 && slot < getSizeInventory()) {
				setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(item));
			}
		}
		this.packing = compound.getBoolean("status");
		setCalories(compound.getInteger("calories"));
		this.timer = compound.getInteger("timer");
		this.convertingTimer = compound.getInteger("conversion");
	}
	
	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		NBTTagCompound tag = pkt.func_148857_g();
		this.readFromNBT(tag);		
	}
	
	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound tag = new NBTTagCompound();
		this.writeToNBT(tag);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, this.blockMetadata, tag);
	}
}
