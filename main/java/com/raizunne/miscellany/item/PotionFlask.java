package com.raizunne.miscellany.item;

import java.util.List;
import java.util.Random;

import net.minecraft.creativetab.CreativeTabs;
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

import com.raizunne.miscellany.Miscellany;

public class PotionFlask extends Item{
		
	public PotionFlask(String name, String textureName) {
		setUnlocalizedName(name);
		setTextureName("miscellany:" + textureName);
		setMaxStackSize(1);
		setMaxDamage(3);
		setCreativeTab(Miscellany.miscTab);
		setNoRepair();
	}
	
	public static NBTTagCompound nbt = new NBTTagCompound();
	public static String potionType = nbt.getString("potionType");
	public static int itemdamage = nbt.getInteger("damage");
	public static String typeofpotion;
	
	@Override
	public void onUpdate(ItemStack itemstack, World world, Entity player, int inte, boolean bool) {
		nbt.setString("potionType", typeofpotion);
	}
	
	public void setEffect(EntityPlayer player, int potion, int duration){
		player.addPotionEffect(new PotionEffect(potion, 0, duration));
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		Boolean remote = world.isRemote;
		System.out.println(typeofpotion);
		player.setItemInUse(itemstack, this.getMaxItemUseDuration(itemstack));
		return itemstack;
	}
	
	@Override
	public ItemStack onEaten(ItemStack itemstack, World world, EntityPlayer player) {
		if(potionType.equals("empty")){
			if(!world.isRemote){
				player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "Something goes down your throat..."));
			}
		}else if(potionType.equals("flight")){
			setEffect(player, Miscellany.flightPotion.getId(), 6000);
		}
		
		return itemstack;
	}

	@Override
	public boolean doesSneakBypassUse(World world, int x, int y, int z,
			EntityPlayer player) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack p_77661_1_) {
		// TODO Auto-generated method stub
		return EnumAction.drink;
	}
	@Override
	public int getMaxItemUseDuration(ItemStack p_77626_1_) {
		// TODO Auto-generated method stub
		return 32;
	}
	
}
