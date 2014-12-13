/**
Code made by Raizunne as a part of Raizunne's Miscellany  
Source code found at github.com/Raizunne
 */
package com.raizunne.miscellany.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.raizunne.miscellany.MiscBlocks;
import com.raizunne.miscellany.Miscellany;
import com.raizunne.miscellany.tileentities.TileEntityColumn;

public class Column extends BlockContainer{

	
	public Column(Material material) {
		super(material);
		setBlockName("misccolumn");
		setBlockTextureName("miscellany:Column");
		setHarvestLevel("pickaxe", 2);
		setHardness(1.0F);
		setBlockBounds(0.0625F, 0, 0.0625F, 0.9375F, 1, 0.9375F);
		setCreativeTab(Miscellany.miscTab);
	}
	
	@Override
	public void randomDisplayTick(World world, int x, int y, int z, Random random) {
		Block c = MiscBlocks.column;
		Block b = world.getBlock(x, y-1, z);
		Block t = world.getBlock(x, y+1, z);		
		boolean top = t==c;
		boolean bottom = b==c;
		
		TileEntityColumn te = (TileEntityColumn)world.getTileEntity(x, y, z);
		te.getWorldObj().scheduleBlockUpdate(te.xCoord, te.yCoord, te.zCoord, te.getWorldObj().getBlock(te.xCoord, te.yCoord, te.zCoord), 400);
		
		if(!top && !bottom){
			te.setState(0);
		}else if(top && !bottom){
			te.setState(1);
		}else if(top && bottom){
			te.setState(2);
		}else if(!top && bottom){
			te.setState(3);
		}
		
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileEntityColumn();
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
