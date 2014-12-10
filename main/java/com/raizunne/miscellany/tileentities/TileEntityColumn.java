/**
Code made by Raizunne as a part of Raizunne's Miscellany  
Source code found at github.com/Raizunne
 */
package com.raizunne.miscellany.tileentities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityColumn extends TileEntity{

	private int state;
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.state = compound.getInteger("state");
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setInteger("state", this.state);
	}
	
	public void setState(int i){
		this.state = i;
	}
	
	public int getState(){
		return this.state;
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
