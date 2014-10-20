package com.raizunne.miscellany.item;

import java.util.List;

import com.raizunne.miscellany.MiscItems;
import com.raizunne.miscellany.Miscellany;
import com.raizunne.miscellany.util.StringResources;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class TheFlute extends Item{

	public TheFlute(){
		setCreativeTab(Miscellany.miscTab);
		setUnlocalizedName("theflute");
		setMaxStackSize(1);
		setTextureName("miscellany:theflute");
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		if(player.isSneaking()){
			switch(itemstack.stackTagCompound.getInteger("mode")){
			case 0:
				itemstack.stackTagCompound.setInteger("mode", 1);
				if(world.isRemote){player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "Mode now set on " + EnumChatFormatting.GREEN + "Wacky" + EnumChatFormatting.LIGHT_PURPLE + " mode."));}
			break;
			case 1:
				itemstack.stackTagCompound.setInteger("mode", 0);
				if(world.isRemote){player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "Mode now set on " + EnumChatFormatting.GREEN + "Soothing" + EnumChatFormatting.LIGHT_PURPLE + " mode."));}
			}
		}else{
			player.setItemInUse(itemstack, getMaxItemUseDuration(itemstack));
		}
		return itemstack;
	}
	
	@Override
	public void onUpdate(ItemStack itemstack, World world, Entity entity, int p_77663_4_, boolean p_77663_5_) {
		if(itemstack.stackTagCompound==null){
			itemstack.stackTagCompound = new NBTTagCompound();
			itemstack.stackTagCompound.setInteger("mode", 0);
		}
		
		if(entity instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer)entity;
			if(player.getItemInUse() == new ItemStack(MiscItems.theflute)){
				
			}
		}
	}

	@Override
	public void onUsingTick(ItemStack itemstack, EntityPlayer player, int count) {
		super.onUsingTick(itemstack, player, count);
		World world = player.worldObj;
		world.spawnParticle("instantSpell", (double)player.posX, (double)player.posY-1.5, (double)player.posZ, 0.0D, 1.0D, 0.0D);
		world.spawnParticle("witchMagic", (double)player.posX+1, (double)player.posY-1.5, (double)player.posZ, 0.0D, 1.0D, 0.0D);
		world.spawnParticle("witchMagic", (double)player.posX, (double)player.posY-1.5, (double)player.posZ+1, 0.0D, 1.0D, 0.0D);
		world.spawnParticle("witchMagic", (double)player.posX, (double)player.posY-1.5, (double)player.posZ, 0.0D, 1.0D, 0.0D);
		world.spawnParticle("witchMagic", (double)player.posX, (double)player.posY-1.5, (double)player.posZ, 0.0D, 1.0D, 0.0D);
		world.spawnParticle("witchMagic", (double)player.posX, (double)player.posY-1.5, (double)player.posZ, 0.0D, 1.0D, 0.0D);
		world.spawnParticle("witchMagic", (double)player.posX, (double)player.posY-1.5, (double)player.posZ, 0.0D, 1.0D, 0.0D);
		world.spawnParticle("witchMagic", (double)player.posX, (double)player.posY-1.5, (double)player.posZ, 0.0D, 1.0D, 0.0D);
		world.spawnParticle("witchMagic", (double)player.posX, (double)player.posY-1.5, (double)player.posZ, 0.0D, 1.0D, 0.0D);
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack p_77661_1_) {
		return EnumAction.block;
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack p_77626_1_) {
		return 100000;
	}
	
	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean donteventryanymore) {
		list.add(StringResources.theflute);
		if(itemstack.stackTagCompound!=null){
			switch(itemstack.stackTagCompound.getInteger("mode")){
			case 0:
				list.add("Mode: " + EnumChatFormatting.GREEN + "Soothing");
			break;
			case 1:
				list.add("Mode: " + EnumChatFormatting.GREEN + "Wacky");
			break;
			}
		}
	}
	
	@Override
	public void onCreated(ItemStack itemstack, World world, EntityPlayer player) {
		if(itemstack.stackTagCompound==null){
			itemstack.stackTagCompound = new NBTTagCompound();
			itemstack.stackTagCompound.setInteger("mode", 0);
		}
	}
}
