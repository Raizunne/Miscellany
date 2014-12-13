package com.raizunne.miscellany.block;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.FakePlayer;

import com.raizunne.miscellany.Miscellany;
import com.raizunne.miscellany.tileentities.TileEntityPresent;

public class Present extends BlockContainer{

	public Present(Material material) {
		super(material);
		setBlockName("present");
		setStepSound(soundTypeCloth);
		setBlockTextureName("miscellany:Present");
		setHarvestLevel("axe", 0);
		setHardness(1.0F);
		setCreativeTab(Miscellany.miscTab);
		setBlockBounds(0.1875F, 0, 0.1875F, 0.8125F, 0.6F, 0.8125F);
	}
	
	@Override
	public void randomDisplayTick(World world, int x, int y, int z, Random random) {
		TileEntityPresent tileentity = (TileEntityPresent)world.getTileEntity(x, y, z);
		tileentity.getWorldObj().scheduleBlockUpdate(tileentity.xCoord, tileentity.yCoord, tileentity.zCoord, tileentity.getWorldObj().getBlock(tileentity.xCoord, tileentity.yCoord, tileentity.zCoord), 400);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		TileEntityPresent present = (TileEntityPresent)world.getTileEntity(x, y, z);
		ItemStack stack = player.getCurrentEquippedItem();
		if(stack!=null && stack.getItem().equals(Items.paper)){
			if(stack.hasDisplayName() && stack.getDisplayName()!="Paper" && present.getFor()==""){
				present.setFor(stack.getDisplayName());
				present.getWorldObj().scheduleBlockUpdate(present.xCoord, present.yCoord, present.zCoord, present.getWorldObj().getBlock(present.xCoord, present.yCoord, present.zCoord), 400);
			}
		}else{
			player.openGui(Miscellany.instance, 4, world, x, y, z);
			if(!(player instanceof FakePlayer)){
				if(present.getFrom()==null || present.getFrom() == ""){
					present.setFrom(player.getDisplayName());
				}
			}
		}
		return true;
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity,	ItemStack itemstack) {
		TileEntity te = world.getTileEntity(x, y, z);
		if(te != null && te instanceof TileEntityPresent){
			TileEntityPresent present = (TileEntityPresent)te;
		}
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
