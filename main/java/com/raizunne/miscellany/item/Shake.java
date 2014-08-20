package com.raizunne.miscellany.item;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import com.raizunne.miscellany.Miscellany;

public class Shake extends Item{

	public Shake(){
		setUnlocalizedName("shake");
		setTextureName("miscellany:shake");
		setCreativeTab(Miscellany.miscTab);
	}
	
	@Override
	public void onCreated(ItemStack itemstack, World world, EntityPlayer player) {
		if(itemstack.stackTagCompound==null){
			itemstack.stackTagCompound = new NBTTagCompound();
			itemstack.stackTagCompound.setInteger("uses", 100);
		}
	}
	
	@Override
	public void onUpdate(ItemStack itemstack, World p_77663_2_, Entity player, int p_77663_4_, boolean p_77663_5_) {
		if(itemstack.stackTagCompound==null){
			itemstack.stackTagCompound = new NBTTagCompound();
			itemstack.stackTagCompound.setInteger("uses", 100);
		}
	}
	
	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean bool) {
		if(itemstack.stackTagCompound!=null){
			list.add("Shakes left: " + itemstack.stackTagCompound.getInteger("uses"));
		}
	}
	
	
	@Override
	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack itemstack) {
		if(entityLiving instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer)entityLiving;
			if(itemstack.stackTagCompound!=null){
				if(itemstack.stackTagCompound.getInteger("uses")!=0){
					if(player.getFoodStats().needFood()){
						player.setItemInUse(itemstack, 1);
						player.getFoodStats().addStats(1, 6);
					}
				}
			}
		}
		return true;
	}	
	
	@Override
	public EnumAction getItemUseAction(ItemStack p_77661_1_) {
		// TODO Auto-generated method stub
		return EnumAction.block;
	}
}
