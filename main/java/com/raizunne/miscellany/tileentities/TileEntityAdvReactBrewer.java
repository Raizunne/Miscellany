package com.raizunne.miscellany.tileentities;

import com.raizunne.miscellany.MiscItems;
import com.raizunne.miscellany.util.RecipeUtil;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityAdvReactBrewer extends TileEntity implements IInventory{

	private ItemStack[] items;
	private int progress;
	boolean sendUpdate;
	
	public TileEntityAdvReactBrewer(){
		items = new ItemStack[4];
		
	}
	
	@Override
	public void updateEntity() {
		super.updateEntity();
		ItemStack slot1 = getStackInSlot(0);
		ItemStack slot2 = getStackInSlot(1);
		ItemStack slot3 = getStackInSlot(2);
		ItemStack slot4 = getStackInSlot(3);
		
		if(slot1!=null && slot2!=null && slot3!=null && slot4!=null){
			switch(RecipeUtil.advBrew(slot1.getItem(), slot2.getItem(), slot3.getItem(), slot4.getItem())){
				case 1: doProcess(new ItemStack(MiscItems.knowledgeFlask));
				break;
				case 2: doProcess(new ItemStack(MiscItems.flightFlask));
				break;
				case 3: doProcess(new ItemStack(MiscItems.WitherAnti));
				break;
				case 4: doProcess(new ItemStack(MiscItems.theheart));
				break;
				case 5: doProcess(new ItemStack(MiscItems.Shake));
				break;
			}
		}
	}
	
	public void doProcess(ItemStack itemstack){
		if(itemstack!=null){
			progress++;
		}
		if(progress==200){
			setInventorySlotContents(3, itemstack);
			for(int i=0; i<3; i++){
				decrStackSize(i, 1);
			}
			progress=0;
		}
	}
	
	public int getProgress(){
		return progress;
	}
	
	public int getScaledProgress(int i){
		if(getProgress()!=0){
			return getProgress() * i / 200;
		}else{
			return 0;
		}
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
		}
		compound.setTag("Items", items);
		compound.setInteger("progress", this.progress);
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
		this.progress = compound.getInteger("progress");		
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
