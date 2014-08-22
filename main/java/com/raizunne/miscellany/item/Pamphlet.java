package com.raizunne.miscellany.item;

import com.raizunne.miscellany.Miscellany;

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
		player.playSound("random.successful_hit", 0.0F, 0.0F);
		return itemstack;
	}
	
}
