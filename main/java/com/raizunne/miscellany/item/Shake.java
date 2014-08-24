package com.raizunne.miscellany.item;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import com.raizunne.miscellany.Miscellany;
import com.raizunne.miscellany.util.StringResources;

public class Shake extends Item{

	public Shake(){
		setUnlocalizedName("shake");
		setTextureName("miscellany:shake");
		setCreativeTab(Miscellany.miscTab);
		setMaxStackSize(1);
		setMaxDamage(100);
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
		if(itemstack.getItemDamage()==100){
		}
	}
	
	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean bool) {
		list.add(StringResources.shake);
		if(itemstack.stackTagCompound!=null){
			list.add("Shakes left: " + itemstack.stackTagCompound.getInteger("uses"));
		}
	}
	
	
	@Override
	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack itemstack) {
		if(entityLiving instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer)entityLiving;
			World world = player.worldObj;
			if(player.getFoodStats().needFood()){
				player.getFoodStats().addStats(4, 6);
				world.playSoundAtEntity(player, "mob.enderdragon.hit", 0.5F, 1.3F);
				if(!player.capabilities.isCreativeMode){
					itemstack.stackTagCompound.setInteger("uses", itemstack.stackTagCompound.getInteger("uses")-1);
					itemstack.damageItem(1, entityLiving);
					
				}
				if(player.inventory.getCurrentItem().getItemDamage()==100){
					player.inventory.decrStackSize(player.inventory.currentItem, 1);
					world.playSoundAtEntity(player, "mob.endermen.hit", 0.5F, 1F);
				}
			}
		}
		return false;
	}	
		
	@Override
	public EnumAction getItemUseAction(ItemStack p_77661_1_) {
		// TODO Auto-generated method stub
		return EnumAction.block;
	}
}
