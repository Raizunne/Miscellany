/**
Code made by Raizunne as a part of Raizunne's Miscellany  
Source code found at github.com/Raizunne
 */
package com.raizunne.miscellany.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.raizunne.miscellany.Miscellany;
import com.raizunne.miscellany.tileentities.TileEntityTrophyBase;

public class TrophyBase extends BlockContainer{
 
	public TrophyBase(Material material) {
		super(material);
		setBlockName("trophybase");
		setCreativeTab(Miscellany.miscTab);
		setHarvestLevel("pickaxe", 0);
		setHardness(1.0F);
		setBlockTextureName("miscellany:TrophyBase");
		setBlockBounds(0.21875F, 0F, 0.225F, 0.775F, 0.25F, 0.78125F);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int hey, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		TileEntityTrophyBase te = (TileEntityTrophyBase)world.getTileEntity(x, y, z);		
		if(player.getCurrentEquippedItem()!=null){
			if(te.getStackInSlot(0)==null){
				ItemStack item = ItemStack.copyItemStack(player.getCurrentEquippedItem());
				item.stackSize = 1;
				te.setInventorySlotContents(0, item);
				player.inventory.decrStackSize(player.inventory.currentItem, 1);
			}
		}else{
			if(player.isSneaking()){
				if(te.getStackInSlot(0)!=null){
					EntityItem item;
					item = new EntityItem(world, x+0.5F, y, z+0.5F, ItemStack.copyItemStack(te.getStackInSlot(0)));
					if(!world.isRemote){
						world.spawnEntityInWorld(item);
					}
					
					te.setInventorySlotContents(0, null);
				}
			}
		}
		return true;		
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int p_149664_5_) {
		TileEntityTrophyBase te = (TileEntityTrophyBase)world.getTileEntity(x, y, z);
		EntityItem item;
		item = new EntityItem(world, x+0.5F, y, z+0.5F, ItemStack.copyItemStack(te.getStackInSlot(0)));
		if(!world.isRemote){
			world.spawnEntityInWorld(item);
		}
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int what) {
		return new TileEntityTrophyBase();
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
