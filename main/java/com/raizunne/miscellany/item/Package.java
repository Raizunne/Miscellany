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
	private int itemid;
	private int count;
	
	public Package(int id, int count){
		setMaxStackSize(1);
		setUnlocalizedName("package");
		setTextureName("miscellany:thepackage");
		setCreativeTab(Miscellany.miscTab);
		setMaxDamage(1);
		this.itemid = id;
	}
	
	@Override
	public void onCreated(ItemStack itemstack, World p_77622_2_,
			EntityPlayer p_77622_3_) {
		if(itemstack.stackTagCompound==null){
			itemstack.stackTagCompound = new NBTTagCompound();
		}
	}
	
	@Override
	public void onUpdate(ItemStack itemstack, World p_77663_2_, Entity p_77663_3_, int p_77663_4_, boolean p_77663_5_) {
		if(itemstack.stackTagCompound==null){
			itemstack.stackTagCompound = new NBTTagCompound();
		}
		if(itemstack.stackTagCompound!=null){
			itemstack.stackTagCompound.setInteger("item", itemid);
			itemstack.stackTagCompound.setInteger("count", count);
		}
	}
	
	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean what) {
		super.addInformation(itemstack, player, list, what);
		
		list.add(StringResources.pack);
		if(itemstack.stackTagCompound!=null){
			if(itemstack.stackTagCompound.getInteger("item")!=0){
				Item thisitem = getItemById(itemid);
				list.add("Currently Contains: " + count + " of " + getItemStackDisplayName(new ItemStack(thisitem)));
			}else{
				list.add("Currently Empty");
			}
		}else{
			list.add("Currently Empty");
		}
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		if(itemstack.stackTagCompound!=null || itemstack.stackTagCompound.getInteger("item")==0){
			if(!world.isRemote){
				player.addChatComponentMessage(new ChatComponentText("Package is empty"));
			} 
			return itemstack;
		}else{
			
			int id = itemstack.stackTagCompound.getInteger("item");
			int count = itemstack.stackTagCompound.getInteger("number");
			
			for(int i=0; i < count; i++ ){
				player.inventory.addItemStackToInventory(new ItemStack(getItemById(id)));		
			}
			player.inventory.decrStackSize(player.inventory.currentItem, 1);
		}
		return itemstack;	
	}
	
	@Override
	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
		if(!entityLiving.worldObj.isRemote){
			System.out.println(stack.stackTagCompound.getInteger("item"));
			System.out.println(stack.stackTagCompound.getInteger("number"));
		}
		
		return false;
	}
}
