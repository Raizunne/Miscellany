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
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.raizunne.miscellany.Miscellany;
import com.raizunne.miscellany.tileentities.TileEntityAdvReactBrewer;
import com.raizunne.miscellany.tileentities.TileEntityPackage;
import com.raizunne.miscellany.tileentities.TileEntityPresent;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;

public class ThePackage extends BlockContainer{

	public ThePackage(Material material) {
		super(material);
		setBlockName("thepackage");
		setStepSound(soundTypeStone);
		setBlockTextureName("miscellany:Present");
		setHarvestLevel("pickaxe", 0);
		setHardness(1.0F);
		setCreativeTab(Miscellany.miscTab);
		setBlockBounds(0.125F, 0F, 0.125F, 0.875F, 0.75F, 0.875F);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		if(!world.isRemote){
			if(player.isSneaking()==false){
				FMLNetworkHandler.openGui(player, Miscellany.instance, 5, world, x, y, z);
			}
			return true;
		}
		return true;
	}	
	
	@Override
	public void randomDisplayTick(World world, int x, int y, int z, Random random) {
		TileEntityPackage tileentity = (TileEntityPackage)world.getTileEntity(x, y, z);
		tileentity.getWorldObj().scheduleBlockUpdate(tileentity.xCoord, tileentity.yCoord, tileentity.zCoord, tileentity.getWorldObj().getBlock(tileentity.xCoord, tileentity.yCoord, tileentity.zCoord), 400);
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack itemstack) {
		int dir = MathHelper.floor_double((double)((player.rotationYaw * 4F) / 360F) + 0.5D) & 3;
        world.setBlockMetadataWithNotify(x, y, z, dir, 0);
	}
	
	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		TileEntityPackage tile = (TileEntityPackage)world.getTileEntity(x, y, z);
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
	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityPackage();
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
