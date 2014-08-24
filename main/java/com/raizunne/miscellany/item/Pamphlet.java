package com.raizunne.miscellany.item;

import java.util.List;

import com.raizunne.miscellany.Miscellany;
import com.raizunne.miscellany.util.StringResources;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Pamphlet extends Item{

	public Pamphlet(){
		setUnlocalizedName("pamphlet");
		setCreativeTab(Miscellany.miscTab);
		setMaxStackSize(1);
		setTextureName("miscellany:pamphlet");
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world,
			EntityPlayer player) {
		player.openGui(com.raizunne.miscellany.Miscellany.instance, 3, world, (int)player.posX, (int)player.posY, (int)player.posZ);
		player.playSound("Miscellany:pageflip1", 1F, 1F);
		return itemstack;
	}
	@Override
	public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_,
			List list, boolean p_77624_4_) {
		list.add(StringResources.pamphlet);
	}
}
