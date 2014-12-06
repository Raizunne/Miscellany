/**
Code made by Raizunne as a part of Raizunne's Miscellany  
Source code found at github.com/Raizunne
 */
package com.raizunne.miscellany.block;

import com.raizunne.miscellany.Miscellany;
import com.raizunne.miscellany.tileentities.TileEntityAdvReactBrewer;
import com.raizunne.miscellany.tileentities.TileEntityFoodPackager;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class FoodPackager extends BlockContainer{

	public FoodPackager(Material material) {
		super(material);
		setBlockName("foodpackager");
		setCreativeTab(Miscellany.miscTab);
		setHarvestLevel("pickaxe", 2);
		setHardness(1.0F);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		if(!world.isRemote){
			if(player.isSneaking()==false){
				FMLNetworkHandler.openGui(player, Miscellany.instance, 0, world, x, y, z);
			}
			return true;
		}
		return true;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityFoodPackager();
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
