package com.raizunne.miscellany.item.PotionFlasks;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.raizunne.miscellany.item.PotionFlask;

public class Flight extends PotionFlask{

	public Flight(String name, String textureName) {
		super(name, textureName);
	}
	
	@Override
	public void onUpdate(ItemStack itemstack, World world, Entity entity, int inte, boolean bool) {
		
	}
}
