/**
Code made by Raizunne as a part of Raizunne's Miscellany  
Source code found at github.com/Raizunne
 */
package com.raizunne.miscellany.item;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.EntityInteractEvent;

import com.raizunne.miscellany.Miscellany;

public class Whip extends Item{
	
	int timer;
	
	public Whip(){
		setUnlocalizedName("whiperino");
		setMaxStackSize(1);
		setCreativeTab(Miscellany.miscTab); 
		setMaxDamage(3);
		setTextureName("miscellany:whip");
	}
	
	@Override
	public void onCreated(ItemStack itemstack, World world, EntityPlayer player) {
		if(itemstack.stackTagCompound==null){
			itemstack.stackTagCompound = new NBTTagCompound();
			itemstack.stackTagCompound.setInteger("timer", 0);
		}
	}
	
	@Override
	public void onUpdate(ItemStack itemstack, World p_77663_2_, Entity player, int p_77663_4_, boolean p_77663_5_) {
		if(itemstack.stackTagCompound==null){
			itemstack.stackTagCompound = new NBTTagCompound();
			itemstack.stackTagCompound.setInteger("timer", 0);
		}
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		MovingObjectPosition pos = this.getMovingObjectPositionFromPlayer(world, player, true);
		player.setItemInUse(itemstack, getMaxItemUseDuration(itemstack));
		return itemstack;
	}
	
	@Override
	public void onPlayerStoppedUsing(ItemStack itemstack, World world, EntityPlayer player, int what) {
		MovingObjectPosition pos = this.getMovingObjectPositionFromPlayer(world, player, true);
		world.playSound((double)player.posX, (double)player.posY, (double)player.posZ, "miscellany:Whip", 1.0F, 1.0F, true);
		if(pos!=null && pos.typeOfHit==MovingObjectType.ENTITY){
			System.out.println("HEYS");
			pos.entityHit.setDead();
		}
		timer=0;
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack p_77661_1_) {
		return EnumAction.bow;
	}
	@Override
	public int getMaxItemUseDuration(ItemStack p_77626_1_) {
		// TODO Auto-generated method stub
		return 80;
	}
	
	
	
	
}
