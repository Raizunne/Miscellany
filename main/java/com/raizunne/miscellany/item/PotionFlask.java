package com.raizunne.miscellany.item;

import java.util.List;
import java.util.Random;

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
	
	@Override
	public void onUpdate(ItemStack itemstack, World world, Entity entity, int p_77663_4_, boolean p_77663_5_) {
		if(itemstack.stackTagCompound == null){
			itemstack.stackTagCompound = new NBTTagCompound();
			itemstack.stackTagCompound.setString("potionType", "empty");
		}else{
			itemstack.stackTagCompound.setInteger("damage", itemstack.getItemDamage());
			itemstack.setItemDamage(itemstack.stackTagCompound.getInteger("damage"));
		}
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		if(itemstack.stackTagCompound==null){
			return "emptyPotionFlask";
		}else if(itemstack.stackTagCompound.getString("potionType").equals("flight")){
			return "flightPotionFlask";
		}else{
			return "emptyPotionFlask";
		}
	}
	
	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean bool) {
		if(itemstack.stackTagCompound==null){
			list.add("Empty");
		}else if(itemstack.stackTagCompound.getString("potionType").equals("empty")){
			list.removeAll(list);
			list.add("Empty Potion Flask");
			list.add("Empty");
		}else if(itemstack.stackTagCompound.getString("potionType").equals("flight")){
			list.removeAll(list);
			list.add("Potion of Flight");
			list.add("Flight");
		}else if(itemstack.stackTagCompound.getString("potionType").equals("knowledge")){
			list.removeAll(list);
			list.add("§aPotion of Knowledge");
			list.add("Knowledge");
		}
	}
	
	@Override
	public void onCreated(ItemStack itemstack, World world, EntityPlayer player) {
		
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack p_77626_1_) {
		return 32;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		if(!player.isSneaking()){
			player.setItemInUse(itemstack, this.getMaxItemUseDuration(itemstack));	
		}
		if(player.isSneaking()){
			String potionType = itemstack.stackTagCompound.getString("potionType");
			if(potionType.equals("empty")){
				if(world.isRemote){
					player.addChatMessage(new ChatComponentText("Potion Type: Flight"));
				}
				itemstack.stackTagCompound.setString("potionType", "flight");
			}else if(potionType.equals("flight")){
				if(world.isRemote){
					player.addChatMessage(new ChatComponentText("Potion Type: Knowledge"));
				}
				itemstack.stackTagCompound.setString("potionType", "knowledge");
			}else if(potionType.equals("knowledge")){
				if(world.isRemote){
					player.addChatMessage(new ChatComponentText("Potion Type: Empty"));
				}
				itemstack.stackTagCompound.setString("potionType", "empty");
			}
		}
		return itemstack;
	}
	
	@Override
	public ItemStack onEaten(ItemStack itemstack, World world, EntityPlayer player) {
		String potionType = itemstack.stackTagCompound.getString("potionType");
		if(potionType.equals("empty")){
			Random random = new Random();
			int numb = random.nextInt(30);
			if(numb==29){
				if(world.isRemote){
					player.addExperience(50);
					player.addChatComponentMessage(new ChatComponentText("Something goes down your throat..."));
				}
			}
			if(world.isRemote && numb!=29){
				player.addChatMessage(new ChatComponentText("Flask seems to be empty..."));
			}
		}else if(potionType.equals("flight")){
			if(world.isRemote){
				player.addPotionEffect(new PotionEffect(Miscellany.flightPotion.getId(), 90));
			}
		}
		return itemstack;
	}

	
	@Override
	public boolean doesSneakBypassUse(World world, int x, int y, int z,
			EntityPlayer player) {
		return false;
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack p_77661_1_) {
		return EnumAction.drink;
	}
	
	@Override
	public boolean hasEffect(ItemStack itemstack) {
		if(itemstack.stackTagCompound!=null){
			if(itemstack.stackTagCompound.getString("PotionType")!="Empty"){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
}
