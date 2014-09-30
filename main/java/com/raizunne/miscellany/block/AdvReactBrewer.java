package com.raizunne.miscellany.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import com.raizunne.miscellany.Miscellany;
import com.raizunne.miscellany.tileentities.TileEntityAdvReactBrewer;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;

public class AdvReactBrewer extends BlockContainer{
	
	public AdvReactBrewer(Material material) {
		super(material);
		setBlockName("advBrew");
		setCreativeTab(Miscellany.miscTab);
		setBlockTextureName("miscellany:purpleColor");
		setHarvestLevel("pickaxe", 0);
		setHardness(1.0F);
		setBlockBounds(0.1875F, 0F, 0.1875F, 0.8125F, 1F, 0.8125F);
	}

	@Override
	public void randomDisplayTick(World world, int x, int y, int z, Random random) {
		TileEntityAdvReactBrewer tileentity = (TileEntityAdvReactBrewer)world.getTileEntity(x, y, z);
		if(tileentity.getProgress()!=0){
			world.spawnParticle("smoke", (float)x + 0.83F, (float)y + 0.87F, (float)z + 0.15F, 0, 0, 0);
			world.spawnParticle("smoke", (float)x + 0.05F, (float)y + 0.87F, (float)z + 0.5F, 0, 0, 0);
			world.spawnParticle("smoke", (float)x + 0.83F, (float)y + 0.87F, (float)z + 0.83F, 0, 0, 0);
			world.spawnParticle("smoke", (float)x + 0.5F, (float)y + 1.1F, (float)z + 0.5F, 0, 0, 0);
		}
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		if(!world.isRemote){
			if(player.isSneaking()==false){
				FMLNetworkHandler.openGui(player, Miscellany.instance, 1, world, x, y, z);
			}
			return true;
		}
		return true;
	}	
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z) {
	}
	
	public void addInformation(ItemStack p_77624_1_, EntityPlayer player, List list, boolean p_77624_4_) {
		list.add(EnumChatFormatting.LIGHT_PURPLE + "Infuse different");
	}
	
	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		TileEntityAdvReactBrewer tile = (TileEntityAdvReactBrewer)world.getTileEntity(x, y, z);
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
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityAdvReactBrewer();
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
