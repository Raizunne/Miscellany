package com.raizunne.miscellany.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
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
		setBlockTextureName("miscellany:advBrewer");
		setBlockBounds(0.1875F, 0F, 0.1875F, 0.8125F, 0.75F, 0.8125F);
	}

	@Override
	public void randomDisplayTick(World world, int x, int y, int z, Random random) {
		
		world.spawnParticle("smoke", (double)x + 1F, (double)y+0.7F, (double)z+0.5F, 0, 0, 0);
		world.spawnParticle("smoke", (double)x + 0.5F, (double)y+0.7F, (double)z+1F, 0, 0, 0);
		world.spawnParticle("smoke", (double)x + 0.5F, (double)y+0.7F, (double)z+0F, 0, 0, 0);
		world.spawnParticle("smoke", (double)x + 0F, (double)y+0.7F, (double)z+0.5F, 0, 0, 0);
		
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
