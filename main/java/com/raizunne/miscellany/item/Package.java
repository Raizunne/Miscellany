package com.raizunne.miscellany.item;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

import com.raizunne.miscellany.Miscellany;
import com.raizunne.miscellany.util.StringResources;

public class Package extends Item{

	public NBTTagCompound nbt = new NBTTagCompound();	
	
	public Package(){
		setMaxStackSize(1);
		setUnlocalizedName("package");
		setTextureName("miscellany:thepackage");
		setCreativeTab(Miscellany.miscTab);
		setMaxDamage(1);
		nbt.setInteger("item", 24);
		nbt.setInteger("number", 300);
	}
	
	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean what) {
		super.addInformation(itemstack, player, list, what);
		list.add(StringResources.pack);
		if(nbt.getInteger("item")!=0){
			Item thisitem = getItemById(nbt.getInteger("item"));
			list.add("Currently Contains: " + nbt.getInteger("number") + " of " + getItemStackDisplayName(new ItemStack(thisitem)));
		}else{
			list.add("Currently Empty");
		}
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		if(nbt.getInteger("item")==0){
			if(!world.isRemote){
				player.addChatComponentMessage(new ChatComponentText("Package is empty"));
			} 
			return itemstack;
		}else{
			for(int i=0; i < nbt.getInteger("number"); i++ ){
				player.inventory.addItemStackToInventory(new ItemStack(getItemById(nbt.getInteger("item"))));		
			}
			player.inventory.decrStackSize(player.inventory.currentItem, 1);
		}
		return itemstack;
		
	}
}
