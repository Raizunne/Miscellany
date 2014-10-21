package com.raizunne.miscellany.item;

import java.util.List;

import com.raizunne.miscellany.Miscellany;
import com.raizunne.miscellany.util.StringResources;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;

public class ExplosiveCatalyst extends Item{

	public ExplosiveCatalyst(){
		setCreativeTab(Miscellany.miscTab);	
		setMaxDamage(7);
		setMaxStackSize(1);
		setUnlocalizedName("explosivecatalyst");
		setTextureName("miscellany:catalyst");
	}
	
	@Override
	public void onCreated(ItemStack itemstack, World world, EntityPlayer player) {
		if(itemstack.stackTagCompound == null){
			itemstack.stackTagCompound = new NBTTagCompound();
			itemstack.stackTagCompound.setBoolean("enabled", true);
			itemstack.stackTagCompound.setInteger("uses", 8);
		}
	}
	
	@Override
	public void onUpdate(ItemStack itemstack, World world, Entity entity, int p_77663_4_, boolean p_77663_5_) {
		if(itemstack.stackTagCompound==null){
			itemstack.stackTagCompound = new NBTTagCompound();
			itemstack.stackTagCompound.setBoolean("enabled", true);
			itemstack.stackTagCompound.setInteger("uses", 8);
		}
		if(itemstack.stackTagCompound!=null){
			if(entity instanceof EntityPlayer){
				EntityPlayer player = (EntityPlayer)entity;
				if(!itemstack.stackTagCompound.getBoolean("enabled")){
					itemstack.stackTagCompound.setInteger("timer", itemstack.stackTagCompound.getInteger("timer")+1);
					if(itemstack.stackTagCompound.getInteger("timer")==100 || itemstack.stackTagCompound.getInteger("timer")==200 || itemstack.stackTagCompound.getInteger("timer")==300){
						player.playSound("note.harp", 0.5F, 1.0F);
					}
					if(itemstack.stackTagCompound.getInteger("timer")==400){
						itemstack.stackTagCompound.setBoolean("enabled", true);
						if(!world.isRemote){
							player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "Catalyst now disabled"));
						}
						player.playSound("fire.ignite", 2.0F, 1.0F);
						itemstack.stackTagCompound.setInteger("timer", 0);
					}
				}
			}
		}
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		if(player.isSneaking()){
			if(itemstack.stackTagCompound!=null){
				if(itemstack.stackTagCompound.getBoolean("enabled")){
					if(!world.isRemote){
						player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "Catalyst now ENABLED for 20 seconds, " + EnumChatFormatting.YELLOW + "BE CAREFUL"));
					}
					player.playSound("mob.enderdragon.wings", 2.0F, 2.0F);
					itemstack.stackTagCompound.setBoolean("enabled", false);
				}else{
					if(!world.isRemote){
						player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "Catalyst now disabled"));
					}
					player.playSound("mob.irongolem.death", 0.1F, 1.0F);
					itemstack.stackTagCompound.setBoolean("enabled", true);
					itemstack.stackTagCompound.setInteger("timer", 0);
				}
			}
		}else{
			MovingObjectPosition pos = this.getMovingObjectPositionFromPlayer(world, player, true);
			if(pos==null){
				return itemstack;
			}
			if(player.isClientWorld()){
				player.swingItem();
			}
			
			if(!itemstack.stackTagCompound.getBoolean("enabled") && pos.typeOfHit == MovingObjectType.BLOCK){
				if(pos.typeOfHit == MovingObjectType.BLOCK && pos.sideHit!=1 && pos.sideHit!=0){
					itemstack.damageItem(1, player);
					itemstack.stackTagCompound.setInteger("uses", itemstack.stackTagCompound.getInteger("uses")-1);
					player.playSound("mob.enderdragon.hit", 1.0F, 1.0F);
				}
				
				EntityTNTPrimed tnt;
				
				int x = pos.blockX;
				int y = pos.blockY;
				int z = pos.blockZ;
				
				switch(pos.sideHit){
				case 2:
					tnt = new EntityTNTPrimed(world, (double)x, (double)y, (double)z+1, player);
					tnt.fuse = 3;
					if(!world.isRemote){
						world.spawnEntityInWorld(tnt);
					}
					break;
				case 3:
					tnt = new EntityTNTPrimed(world, (double)x, (double)y, (double)z-1, player);
					tnt.fuse = 3;
					if(!world.isRemote){
						world.spawnEntityInWorld(tnt);
					}
					break;
				case 4:
					tnt = new EntityTNTPrimed(world, (double)x+1, (double)y, (double)z, player);
					tnt.fuse = 3;
					if(!world.isRemote){
						world.spawnEntityInWorld(tnt);
					}
					break;
				case 5:
					tnt = new EntityTNTPrimed(world, (double)x-1, (double)y, (double)z, player);
					tnt.fuse = 3;
					if(!world.isRemote){
						world.spawnEntityInWorld(tnt);
					}
					break;
				}
			}
		}
		return itemstack;
	}
	
	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean whatthehellisthisreallyplssomeonetellme) {
		list.add(StringResources.explcatalyst);
		if(itemstack.stackTagCompound !=null){
			list.add("Explotations left: " + itemstack.stackTagCompound.getInteger("uses"));
			if(!itemstack.stackTagCompound.getBoolean("enabled")){
				list.add(EnumChatFormatting.YELLOW + "ENABLED");
			}else{
				list.add("Disabled");
			}
		}
	}
	
	@Override
	public boolean hasEffect(ItemStack itemstack, int pass) {
		if(itemstack.stackTagCompound !=null){
			if(itemstack.stackTagCompound.getBoolean("enabled")){
				return false;
			}else{
				return true;
			}
		}else{
			return false;
		}
	}
}
