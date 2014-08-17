package com.raizunne.miscellany.item;

import java.util.List;

import com.raizunne.miscellany.Miscellany;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class manualBook extends Item{
	public manualBook(){
		setMaxStackSize(1);
		setUnlocalizedName("manualBook");
		setCreativeTab(Miscellany.miscTab);
		setTextureName("miscellany:manualBook");
	}
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		player.openGui(com.raizunne.miscellany.Miscellany.instance, 2, world, (int)player.posX, (int)player.posY, (int)player.posZ);
		return itemstack;
	}
	
	@Override
	public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_,
			List list, boolean p_77624_4_) {
		list.add(EnumChatFormatting.LIGHT_PURPLE + "Manual for Raizunne's Miscellany");
	}
}
