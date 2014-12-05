/**
Code made by Raizunne as a part of Raizunne's Miscellany  
Source code found at github.com/Raizunne
 */
package com.raizunne.miscellany.block;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.raizunne.miscellany.MiscItems;
import com.raizunne.miscellany.Miscellany;
import com.raizunne.miscellany.tileentities.TileEntityHeart;

public class Heart extends BlockContainer{

	public Heart(Material material) {
		super(material);
		setBlockName("hearthealer");
		setCreativeTab(Miscellany.miscTab);
		setBlockTextureName("miscellany:heartColor");
		setHarvestLevel("pickaxe", 0);
		setHardness(1.0F);
		setBlockBounds(0.29F, 0F, 0.32F, 0.68F, 0.875F, 0.71F);
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random random) {
		
	}
	
	@Override
	public void randomDisplayTick(World world, int x, int y, int z, Random random) {
		int r = random.nextInt(15);
//		System.out.println(r);
		EntityPlayer player = world.getClosestPlayer((double)x, (double)y, (double)z, 3);
		if(player!=null){
			double i = random.nextDouble();
			double n = random.nextDouble();
			world.spawnParticle("heart", (double)player.posX+i-n, (double)player.posY-1.5+i-n, (double)player.posZ+i-n, 0.0D, 1.0D, 0.0D);
		}
		if((r==4 || r==5) && player!=null){
			if(player.shouldHeal()){
				if(!player.worldObj.isRemote){player.setHealth(player.getHealth()+1);}
				System.out.println("HEALED 1");
				player.playSound("mob.wither.shoot", 1F, 2F);
			}
		}
		if(r==1 && player!=null){
			if(player.shouldHeal()){
				if(!player.worldObj.isRemote){player.setHealth(player.getHealth()+2);}
				System.out.println("HEALED 2");
				player.playSound("mob.wither.shoot", 1F, 2F);
			}
		}
	}
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityHeart();
	}
	
	@Override
	public boolean isOpaqueCube(){
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public int getRenderType() {
		return -1;
	}
	
}
