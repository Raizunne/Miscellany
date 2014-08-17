package com.raizunne.miscellany.block;

import com.raizunne.miscellany.Miscellany;
import com.raizunne.miscellany.tileentities.TileEntityPresent;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class Present extends BlockContainer{

	public Present(Material material) {
		super(material);
		isBlockContainer = true;
		setBlockName("present");
		setStepSound(soundTypeCloth);
		setBlockTextureName("miscellany:foodPackager");
		setCreativeTab(Miscellany.miscTab);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityPresent();
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
