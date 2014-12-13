package com.raizunne.miscellany.tileentities;

import net.minecraft.entity.player.EntityPlayer;
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
import net.minecraftforge.common.util.ForgeDirection;
import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyHandler;

import com.raizunne.miscellany.MiscItems;

public class TileEntityPackage extends TileEntity implements IInventory, IEnergyHandler{

	private ItemStack[] items;
	public boolean pack;
	private int timer;
	private int totaltime = 200;
	EnergyStorage storage = new EnergyStorage(25600);
	
	public TileEntityPackage(){
		items = new ItemStack[11];
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
		if(checkIfCool() && checkProduct() && checkNBT(9) && storage.getEnergyStored()>=16000){
			if(getStackInSlot(0).getItem() == MiscItems.pack){
				return;
			}
			if(timer!=60){
				timer++;
			}else{
				doProcess();
			}
		}else{
			timer = 0;
		}
	}
	
	public void doProcess(){
		int count = getStackInSlot(0).stackSize + getStackInSlot(1).stackSize + getStackInSlot(2).stackSize + getStackInSlot(3).stackSize + 
				getStackInSlot(4).stackSize + getStackInSlot(5).stackSize + getStackInSlot(6).stackSize + getStackInSlot(7).stackSize + getStackInSlot(8).stackSize; 
		int id = Item.getIdFromItem(getStackInSlot(0).getItem());
		int meta = getStackInSlot(0).getItemDamage();
		String type;
		if(getStackInSlot(0).getItem() instanceof Item){
			type = "item";
		}else{
			type = "block";
		}
		storage.setEnergyStored(storage.getEnergyStored()-16000);
		getStackInSlot(9).stackTagCompound.setInteger("count", count);
		getStackInSlot(9).stackTagCompound.setInteger("item", id);
		getStackInSlot(9).stackTagCompound.setInteger("meta", meta);
		getStackInSlot(9).stackTagCompound.setString("type", type);
		for(int i=0; i<9; i++){
			setInventorySlotContents(i, null);
		}
		timer=0;
		pack=false;
	}
	
	public void startPackaging(){
		if(!pack){
			this.pack = true;
		}
	}
	
	public int getProgress(){
		return timer;
	} 
	
	public int getScaledProgress(int i){
		if(getProgress()!=0){
			return getProgress() * i / 60;
		}else{
			return 0;
		}
	}
	
	public int getPowerScaled(int i){
		return getEnergyStored(null) *  i / getMaxEnergyStored(null);
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
		return "Package";
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
	
	public boolean checkIfCool(){
		if(getStackInSlot(0)!=null && getStackInSlot(1)!=null && getStackInSlot(2)!=null &&  getStackInSlot(3)!=null &&  getStackInSlot(4)!=null &&  getStackInSlot(5)!=null && 
				getStackInSlot(6)!=null &&  getStackInSlot(7)!=null &&  getStackInSlot(8)!=null){
			if(getStackInSlot(0).isItemEqual(getStackInSlot(1)) && getStackInSlot(1).isItemEqual(getStackInSlot(2)) && getStackInSlot(2).isItemEqual(getStackInSlot(3)) && getStackInSlot(3).isItemEqual(getStackInSlot(4)) &&
					getStackInSlot(4).isItemEqual(getStackInSlot(5)) && getStackInSlot(5).isItemEqual(getStackInSlot(6)) && getStackInSlot(7).isItemEqual(getStackInSlot(8))){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	public boolean checkProduct(){
		if(getStackInSlot(9)!=null && getStackInSlot(9).isItemEqual(new ItemStack(MiscItems.pack))){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean checkNBT(int stack){
		if(getStackInSlot(stack).stackTagCompound.getInteger("item")!=0){
			return false;
		}
		return true;
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
		compound.setInteger("timer", this.timer);
		storage.writeToNBT(compound);
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
		this.timer = compound.getInteger("timer");
		storage.readFromNBT(compound);
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

	@Override
	public boolean canConnectEnergy(ForgeDirection from) {
		return !(from==ForgeDirection.UP);
	}

	@Override
	public int receiveEnergy(ForgeDirection from, int maxReceive,
			boolean simulate) {
		return storage.receiveEnergy(maxReceive, simulate);
	}

	@Override
	public int extractEnergy(ForgeDirection from, int maxExtract,
			boolean simulate) {
		return storage.extractEnergy(maxExtract, simulate);
	}

	@Override
	public int getEnergyStored(ForgeDirection from) {
		return storage.getEnergyStored();
	}

	@Override
	public int getMaxEnergyStored(ForgeDirection from) {
		return storage.getMaxEnergyStored();
	}
	
	public void setEnergy(int i){
		storage.setEnergyStored(i);
	}
}
