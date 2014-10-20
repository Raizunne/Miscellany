package com.raizunne.miscellany.item;

import java.util.List;

import com.raizunne.miscellany.Miscellany;
import com.raizunne.miscellany.util.StringResources;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class debugHunger extends Item{
	
	public debugHunger(){
		setUnlocalizedName("debugHunger");
		setCreativeTab(Miscellany.miscTab).setMaxStackSize(1);
		setTextureName(Miscellany.MODID + ":" + "debugHunger");
		setMaxStackSize(1);
	}
	
	@Override
	public void onCreated(ItemStack itemstack, World world, EntityPlayer player) {
		if(itemstack.stackTagCompound==null){
			itemstack.stackTagCompound = new NBTTagCompound();
			itemstack.stackTagCompound.setInteger("type", 0);
		}
	}
	
	@Override
	public void onUpdate(ItemStack itemstack, World p_77663_2_, Entity player, int p_77663_4_, boolean p_77663_5_) {
		if(itemstack.stackTagCompound==null){
			itemstack.stackTagCompound = new NBTTagCompound();
			itemstack.stackTagCompound.setInteger("type", 0);
		}
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		if(player.isSneaking() && itemstack.stackTagCompound!=null){
			switch(itemstack.stackTagCompound.getInteger("type")){
			case 0:
				itemstack.stackTagCompound.setInteger("type", 1);
				if(!world.isRemote){
					player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "Now in " + EnumChatFormatting.GREEN + "Health" + EnumChatFormatting.LIGHT_PURPLE +  " removal mode"));
				}
			break;
			case 1:
				itemstack.stackTagCompound.setInteger("type", 0);
				if(!world.isRemote){
					player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "Now in " + EnumChatFormatting.GREEN + "Hunger" + EnumChatFormatting.LIGHT_PURPLE +  " removal mode"));
				}
			}
		}
		
		if(!world.isRemote && !player.isSneaking()){
			switch(itemstack.stackTagCompound.getInteger("type")){
			case 0:
				player.getFoodStats().addStats(-5, -10);
				world.playSoundAtEntity(player, "note.pling", 0.5F, 1.0F);
			break;
			case 1:
				player.setHealth(player.getHealth()-2);
				world.playSoundAtEntity(player, "random.burp", 0.5F, 1.0F);
			}
		}
		return itemstack;
	}
	
	@Override
	public boolean hasEffect(ItemStack par1ItemStack, int pass) {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_,
			List list, boolean p_77624_4_) {
		list.add(StringResources.debugHunger);
	}
}
