/**
Code made by Raizunne as a part of Raizunne's Miscellany  
Source code found at github.com/Raizunne
 */
package com.raizunne.miscellany.item;

import java.util.List;

import com.raizunne.miscellany.Miscellany;
import com.raizunne.miscellany.util.StringResources;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class PackagedFood extends ItemFood{

	/**
	 * @param p_i45339_1_
	 * @param p_i45339_2_
	 * @param p_i45339_3_
	 */
	public PackagedFood(int hunger, float sat, boolean wolf) {
		super(hunger, sat, wolf);
		setCreativeTab(Miscellany.miscTab);
		setMaxStackSize(64);
		setTextureName("miscellany:PackagedFood");
		setUnlocalizedName("PackagedFood");
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack p_77661_1_) {
		// TODO Auto-generated method stub
		return EnumAction.eat;
	}
	
	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean what) {
		list.add(StringResources.packagedFood);
	}
}
