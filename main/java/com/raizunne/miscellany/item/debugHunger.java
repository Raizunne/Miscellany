package com.raizunne.miscellany.item;

import java.util.List;

import com.raizunne.miscellany.Miscellany;
import com.raizunne.miscellany.util.StringResources;

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
		if(!world.isRemote){
			player.getFoodStats().addStats(-5, -10);
			world.playSoundAtEntity(player, "note.pling", 0.5F, 1.0F);
			
		}
		return itemstack;
	}
	
	@Override
	public boolean hasEffect(ItemStack par1ItemStack, int pass) {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_,
			List list, boolean p_77624_4_) {
		list.add(StringResources.debugHunger);
	}
}
