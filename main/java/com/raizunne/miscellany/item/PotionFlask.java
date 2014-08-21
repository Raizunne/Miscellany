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
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

import com.raizunne.miscellany.Miscellany;

public class PotionFlask extends Item{
		
	public PotionFlask() {
		setUnlocalizedName("emptyPotionFlask");
		setTextureName("miscellany:emptyPotionFlask");
		setMaxStackSize(1);
		setMaxDamage(3);
		setCreativeTab(Miscellany.miscTab);
		setHasSubtypes(true);
		setNoRepair();
	}
	
	public static NBTTagCompound nbt = new NBTTagCompound();
	public static String potionType = nbt.getString("potionType");
	public static int itemdamage = nbt.getInteger("damage");
	
	@Override
	public void onUpdate(ItemStack itemstack, World world, Entity player, int inte, boolean bool) {
//		System.out.println(nbt.getString("potionType"));
		if(nbt.getString("potionType").equals("")){
			nbt.setString("potionType", "empty");
		
		}
	}
	
	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean p_77624_4_) {
		switch(nbt.getString("potionType")){
		case "flight":
			list.removeAll(list);
			list.add("Potion of Flight");
			list.add("Flight");
			break;
		case "knowledge":
			list.removeAll(list);
			list.add("Potion of Knowledge");
			list.add("Knowledge");
			break;
		case "empty":
			list.removeAll(list);
			list.add("Empty Potion Flask");
			list.add("Empty");
			break;
		}
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		Boolean remote = world.isRemote;
		if(player.isSneaking()){
			switch(nbt.getString("potionType")){
			case "flight":
				nbt.setString("potionType", "knowledge");
				if(remote){
					player.addChatComponentMessage(new ChatComponentText("Potion Type: Empty"));
				}
				break;
			case "knowledge":
				nbt.setString("potionType", "empty");
				if(remote){
					player.addChatComponentMessage(new ChatComponentText("Potion Type: Flight"));
				}
				break;
			case "empty":
				nbt.setString("potionType", "flight");
				if(remote){
					player.addChatComponentMessage(new ChatComponentText("Potion Type: Knowledge"));
				}
				break;
			}
		}
		player.setItemInUse(itemstack, this.getMaxItemUseDuration(itemstack));
		return itemstack;
	}
	
	@Override
	public ItemStack onEaten(ItemStack itemstack, World world, EntityPlayer player) {
		switch(nbt.getString("potionType")){
		case "flight":
			player.addPotionEffect(new PotionEffect(Miscellany.flightPotion.getId(), 400));
			break;
		case "knowledge":
			player.addPotionEffect(new PotionEffect(Miscellany.knowledgePotion.getId(), 200));
			break;
		case "empty":
			if(world.isRemote){
				player.addChatComponentMessage(new ChatComponentText("§dSeems to be empty..."));
			}
			break;
		}		
		if(itemstack.getItemDamage()==2){
			return null;
		}else{
			return itemstack;
		}
	}
	
	@Override
	public boolean hasEffect(ItemStack par1ItemStack, int pass) {
		switch(nbt.getString("potionType")){
		case "flight":
			return true;
		case "knowledge":
			return true;
		case "empty":
			return false;
		default: return false;
		}
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

