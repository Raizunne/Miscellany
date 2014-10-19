package com.raizunne.miscellany.block;

import java.util.Random;

import com.raizunne.miscellany.Miscellany;
import com.raizunne.miscellany.tileentities.TileEntityPresent;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class Present extends BlockContainer{

	public Present(Material material) {
		super(material);
		setBlockName("present");
		setStepSound(soundTypeCloth);
		setBlockTextureName("miscellany:foodPackager");
		setHarvestLevel("axe", 0);
		setHardness(1.0F);
		setCreativeTab(Miscellany.miscTab);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player,	
			int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		if(!world.isRemote){
			player.openGui(Miscellany.instance, 4, world, x, y, z);
			TileEntity te = world.getTileEntity(x, y, z);
			if(te != null && te instanceof TileEntityPresent){
				TileEntityPresent present = (TileEntityPresent) te;
				if(present.userSender==null){
					present.userSender=player.getDisplayName();
				}
			}
			return true;
		}
		return true;
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random random) {

	}
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);
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
