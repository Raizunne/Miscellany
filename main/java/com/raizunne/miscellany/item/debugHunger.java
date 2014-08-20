package com.raizunne.miscellany.item;

import com.raizunne.miscellany.Miscellany;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class debugHunger extends Item{
	
	public debugHunger(){
		setUnlocalizedName("debugHunger");
		setCreativeTab(Miscellany.miscTab).setMaxStackSize(1);
		setTextureName(Miscellany.MODID + ":" + "debugHunger");
		setMaxStackSize(1);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		if(world.isRemote){
			player.getFoodStats().addStats(-5, -10);
			
		}
		return itemstack;
	}
}
