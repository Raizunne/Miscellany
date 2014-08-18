package com.raizunne.miscellany.item;

import java.util.List;

import com.raizunne.miscellany.Miscellany;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

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
			list.add("Potion of Knowledge");
			list.add("Knowledge");
		}
	}
	
	@Override
	public void onCreated(ItemStack itemstack, World world, EntityPlayer player) {
		super.onCreated(itemstack, world, player);
		itemstack.stackTagCompound = new NBTTagCompound();
		itemstack.stackTagCompound.setString("potionType", "empty");
	}
	
	@Override
	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack itemstack) {
		if(itemstack.stackTagCompound == null){
			itemstack.stackTagCompound = new NBTTagCompound();
			itemstack.stackTagCompound.setString("potionType", "empty");
		}
		return super.onEntitySwing(entityLiving, itemstack);
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack p_77626_1_) {
		return 32;
	}
	
	//WRITE TO NBT ITS DAMAGE ----------------TODO-----------TODO----------TODO DONT FORGET DAMN IT!
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		if(player.isSneaking()){
			if(itemstack.stackTagCompound != null){
				String type = itemstack.stackTagCompound.getString("potionType");
				if(type.equals("empty")){
					getUnlocalizedName();
					if(world.isRemote){
						player.addChatMessage(new ChatComponentText("Potion Type: Flight"));
						itemstack.setItemDamage(itemstack.getItemDamage());
					}
					itemstack.stackTagCompound.setString("potionType", "flight");
				}else if(type.equals("flight")){
					getUnlocalizedName();
					if(world.isRemote){
						player.addChatMessage(new ChatComponentText("Potion Type: Knowledge"));
						itemstack.setItemDamage(itemstack.getItemDamage());
					}
					itemstack.stackTagCompound.setString("potionType", "knowledge");
				}else if(type.equals("knowledge")){
					getUnlocalizedName();
					if(world.isRemote){
						player.addChatMessage(new ChatComponentText("Potion Type: Empty"));
						itemstack.setItemDamage(itemstack.getItemDamage());
					}
					itemstack.stackTagCompound.setString("potionType", "empty");
				}
			}
		}
		player.setItemInUse(itemstack, this.getMaxItemUseDuration(itemstack));
		return itemstack;
	}
	
	@Override
	public ItemStack onEaten(ItemStack itemstack, World world, EntityPlayer player) {
		if(itemstack.stackTagCompound.getString("potionType").equals("flight")){		
			player.addPotionEffect(new PotionEffect(Miscellany.flightPotion.getId(), 200, 0));
		}else if(itemstack.stackTagCompound.getString("potionType").equals("empty")){	
			if(world.isRemote){
				player.addChatComponentMessage(new ChatComponentText("§dPotion seems to be empty..."));
			}
			return itemstack;
		}else if(itemstack.stackTagCompound.getString("potionType").equals("knowledge")){
			player.addPotionEffect(new PotionEffect(Miscellany.knowledgePotion.getId(), 200, 0));
		}
		if(itemstack.getItemDamage()==2){
			return null;
		
		}else{
			if(world.isRemote){
				itemstack.damageItem(1, player);
			}
			return itemstack;
		}	
		
	}

	
	@Override
	public boolean doesSneakBypassUse(World world, int x, int y, int z,
			EntityPlayer player) {
		return true;
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
