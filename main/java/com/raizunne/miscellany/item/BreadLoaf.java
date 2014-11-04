package com.raizunne.miscellany.item;

import java.util.List;

import com.raizunne.miscellany.Miscellany;
import com.raizunne.miscellany.util.StringResources;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BreadLoaf extends ItemFood {

	public BreadLoaf(int p_i45339_1_, float p_i45339_2_, boolean p_i45339_3_) {
    	super(p_i45339_1_, p_i45339_2_, p_i45339_3_);
    	setMaxStackSize(64);
    	setUnlocalizedName("breadLoaf");
    	setCreativeTab(Miscellany.miscTab);
    	setTextureName("miscellany:breadLoaf");
	}	
	
	@Override
	public ItemStack onEaten(ItemStack p_77654_1_, World p_77654_2_,
			EntityPlayer p_77654_3_) {
		// TODO Auto-generated method stub
		return super.onEaten(p_77654_1_, p_77654_2_, p_77654_3_);
	}
	
	@Override
	public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_,
			List list, boolean p_77624_4_) {
		// TODO Auto-generated method stub
		list.add(StringResources.loaf);
	}
}
