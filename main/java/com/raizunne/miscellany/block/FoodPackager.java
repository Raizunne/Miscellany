/**
Code made by Raizunne as a part of Raizunne's Miscellany  
Source code found at github.com/Raizunne
 */
package com.raizunne.miscellany.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.raizunne.miscellany.Miscellany;
import com.raizunne.miscellany.tileentities.TileEntityFoodPackager;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;

public class FoodPackager extends BlockContainer{

	TileEntityFoodPackager packager;
	
	public FoodPackager(Material material) {
		super(material);
		setBlockName("foodpackager");
		setCreativeTab(Miscellany.miscTab);
		setHarvestLevel("pickaxe", 2);
		setHardness(1.0F);
		setBlockTextureName("miscellany:FoodPackager");
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
	public void randomDisplayTick(World world, int x, int y, int z, Random random) {
		TileEntityFoodPackager tileentity = (TileEntityFoodPackager)world.getTileEntity(x, y, z);
		this.packager = tileentity;
		tileentity.getWorldObj().scheduleBlockUpdate(tileentity.xCoord, tileentity.yCoord, tileentity.zCoord, tileentity.getWorldObj().getBlock(tileentity.xCoord, tileentity.yCoord, tileentity.zCoord), 400);
		if(tileentity.getConvertingProgress()>=78){
			if(world.isRemote){
//				world.playSound((double)x, (double)y, (double)z, "mob.irongolem.hit", 0.5F, 2F, true);
//				world.playSound((double)x, (double)y, (double)z, "mob.irongolem.hit", 0.5F, -1F, true);
			}else{
			}
		}
		
	}
	
	@Override
	public void updateTick(World world, int z, int y, int x, Random random) {
		TileEntityFoodPackager tileentity = (TileEntityFoodPackager)world.getTileEntity(x, y, z);
		
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityFoodPackager();
	}
	
	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		TileEntityFoodPackager tile = (TileEntityFoodPackager)world.getTileEntity(x, y, z);
		EntityItem item;
		for(int i=0; i<tile.getSizeInventory(); i++){
			if(tile.getStackInSlot(i)!=null){
				item = new EntityItem(world, x, y, z, tile.getStackInSlot(i));
				
				world.spawnEntityInWorld(item);
			}
		}
		super.breakBlock(world, x, y, z, block, meta);
	}
	
	 @Override
	 public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLiving, ItemStack itemstack)	 {
		int direction = MathHelper.floor_double((double) (entityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		world.setBlockMetadataWithNotify(x, y, z, direction, 0);
//		System.out.println(world.getBlockMetadata(x, y, z));
	 }
	 
	 @Override
	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player) {
//		System.out.println(world.getBlockMetadata(x, y, z));
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
