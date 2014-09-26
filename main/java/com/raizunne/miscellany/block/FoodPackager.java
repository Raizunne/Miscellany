package com.raizunne.miscellany.block;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.raizunne.miscellany.MiscItems;
import com.raizunne.miscellany.Miscellany;
import com.raizunne.miscellany.proxies.ClientProxy;
import com.raizunne.miscellany.tileentities.TileEntityFoodPackager;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;

public class FoodPackager extends BlockContainer{

	public FoodPackager(Material material) {
		super(material);
		isBlockContainer = true;
		setBlockName("foodPackager");
		setStepSound(soundTypeMetal);
		setCreativeTab(Miscellany.miscTab);
		setHardness(2.0F);
		setResistance(5.0F);
		setBlockTextureName("miscellany:foodPackager");
		setBlockBounds(0.1875F, 0F, 0.1875F, 0.8125F, 1F, 0.8125F);
	}
	
	public boolean isActive;
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int h, float f1, float f2, float f3) {
		if(!world.isRemote){
			if(player.isSneaking() == true && player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == MiscItems.packagedFood){
				world.setBlockToAir(x, y, z);
			}
			
			if(player.isSneaking()==false){
				FMLNetworkHandler.openGui(player, Miscellany.instance, 0, world, x, y, z);
			}
			return true;
		}
		return true;
	}

	@Override
	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);
		
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack itemstack) {
		int dir = MathHelper.floor_double((double)((player.rotationYaw * 4F) / 360F) + 0.5D) & 3;
        world.setBlockMetadataWithNotify(x, y, z, dir, 0);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int p_149915_2_) {
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
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random random) {
		if(isActive==true){
			world.spawnParticle("portal", 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
		}
	}

}
