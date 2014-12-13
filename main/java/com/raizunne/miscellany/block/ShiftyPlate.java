/**
Code made by Raizunne as a part of Raizunne's Miscellany  
Source code found at github.com/Raizunne
 */
package com.raizunne.miscellany.block;

import java.util.Random;

import com.raizunne.miscellany.Miscellany;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ShiftyPlate extends Block{
	
	public ShiftyPlate(Material material) {
		super(material);
		setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.03125F, 0.9375F);
		setCreativeTab(Miscellany.miscTab);
		setBlockName("shiftyplate");
	}
	
	@Override
	public boolean onBlockActivated(World world, int x,	int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_,
			float p_149727_9_) {
		return true;
	}	
	
	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity player) {
		world.scheduleBlockUpdate(x, y, z, world.getBlock(x, y, z), 10);
		if(player.isSneaking()){
			world.setBlockMetadataWithNotify(x, y, z, 1, 0);
		}else{
			world.setBlockMetadataWithNotify(x, y, z, 0, 0);
		}
		this.isProvidingWeakPower((IBlockAccess)world, x, y, z, 15);
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random p_149674_5_) {
		isProvidingWeakPower((IBlockAccess)world, x, y, z, 15);
	}
	
//	public void setBlockBoundsForItemRender()
//    {
//        float f = 0.5F;
//        float f1 = 0.125F;
//        float f2 = 0.5F;
//        this.setBlockBounds(0.5F - f, 0.5F - f1, 0.5F - f2, 0.5F + f, 0.5F + f1, 0.5F + f2);
//    }
	
	@Override
	public int isProvidingWeakPower(IBlockAccess access, int x, int y, int z, int p_149748_5_) {
		if(access.getBlockMetadata(x, y, z)==0){
			return 0;
		}else{
			return 15;
		}
	}
	
	@Override
	public boolean canProvidePower() {
		return true;
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
	public boolean canConnectRedstone(IBlockAccess world, int x, int y, int z, int side) {
		return true;
	}
	
	@Override
	public int tickRate(World p_149738_1_) {
		// TODO Auto-generated method stub
		return 10;
	}
	
}
