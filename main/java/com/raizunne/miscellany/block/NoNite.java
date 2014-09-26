package com.raizunne.miscellany.block;

import java.util.Random;

import com.raizunne.miscellany.Miscellany;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class NoNite extends Block {

	public NoNite(Material material) {
		super(material);
		setBlockName("nonite");
		setStepSound(soundTypePiston);
		setBlockTextureName("miscellany:nonite");
		setCreativeTab(Miscellany.miscTab);
	}
	
	@Override
	public void updateTick(World world, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
		if(world.getWorldTime()>13000){
			if(!world.isRemote){
				world.setWorldTime(1);
			}
		}
	}
	
	@Override
	public boolean onBlockActivated(World world, int x,	int y, int z, EntityPlayer player,
			int p_149727_6_, float p_149727_7_, float p_149727_8_,
			float p_149727_9_) {
		if(!world.isRemote){
			player.addChatMessage(new ChatComponentText("Changed the time from " + world.getWorldTime() + " to 1"));
			player.addChatMessage(new ChatComponentText("from NoNite at " + x + ", " + y + ", " + z));
		}
		if(!world.isRemote){
			world.setWorldTime(1);
		}
		return true;
	}
	
	
}
