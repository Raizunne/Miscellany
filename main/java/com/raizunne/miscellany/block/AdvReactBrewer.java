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
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import com.raizunne.miscellany.MiscItems;
import com.raizunne.miscellany.Miscellany;
import com.raizunne.miscellany.tileentities.TileEntityAdvReactBrewer;
import com.raizunne.miscellany.util.StringResources;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;

public class AdvReactBrewer extends BlockContainer{
	
	TileEntityAdvReactBrewer brewer;
	
	public AdvReactBrewer(Material material) {
		super(material);
		setBlockName("advBrew");
		setCreativeTab(Miscellany.miscTab);
		setBlockTextureName("miscellany:purpleColor");
		setHarvestLevel("pickaxe", 0);
		setHardness(1.0F);
		setBlockBounds(0.3125F, 0F, 0.3125F, 0.6875F, 0.875F, 0.6875F);
	}

	@Override
	public void randomDisplayTick(World world, int x, int y, int z, Random random) {
		TileEntityAdvReactBrewer tileentity = (TileEntityAdvReactBrewer)world.getTileEntity(x, y, z);
		this.brewer = tileentity;
		tileentity.getWorldObj().scheduleBlockUpdate(tileentity.xCoord, tileentity.yCoord, tileentity.zCoord, tileentity.getWorldObj().getBlock(tileentity.xCoord, tileentity.yCoord, tileentity.zCoord), 400);
		if(tileentity.getProgress()!=0){
			String particle = "smoke"; 
			switch(random.nextInt(3)){
			case 0:
				particle = "smoke";
				break;
			case 1:
				particle = "witchMagic";
				break;
			case 2:
				particle = "smoke";
				break;
			}
			if(world.isRemote){
				world.spawnParticle(particle, (float)x + 0.5F, (float)y + 0.87F, (float)z + 0.15F, 0, 0, 0);
				world.spawnParticle(particle, (float)x + 0.22F, (float)y + 0.87F, (float)z + 0.75F, 0, 0, 0);
				world.spawnParticle(particle, (float)x + 0.80F, (float)y + 0.87F, (float)z + 0.80F, 0, 0, 0);
				world.spawnParticle(particle, (float)x + 0.5F, (float)y + 1.1F, (float)z + 0.5F, 0, 0, 0);
				
				double i = random.nextDouble();
				double n = random.nextDouble();
				double r = random.nextDouble();
				double e = random.nextDouble();
				
				String particle2 = "magicCrit";
				
				world.spawnParticle(particle2, (double)x+i-n, (double)y+i-n, (double)z+i-n, 0.0D, 0.1D, 0.0D);
				world.spawnParticle(particle2, (double)x+1+i-n, (double)y+i-n, (double)z+i-n, 0.0D, 0.1D, 0.0D);
				world.spawnParticle(particle2, (double)x+i-n, (double)y+i-n, (double)z+1+i-n, 0.0D, 0.1D, 0.0D);
				world.spawnParticle(particle2, (double)x-1+i-n, (double)y+i-n, (double)z+i-n, 0.0D, 0.1D, 0.0D);
				world.spawnParticle(particle2, (double)x+i-n, (double)y+i-n, (double)z-1+i-n, 0.0D, 0.1D, 0.0D);
				world.spawnParticle(particle2, (double)x+1+i-n, (double)y+i-n, (double)z+1+i-n, 0.0D, 0.0D, 0.0D);
				world.spawnParticle(particle2, (double)x+1+i-n, (double)y+i-n, (double)z-1+i-n, 0.0D, 0.0D, 0.0D);
				world.spawnParticle(particle2, (double)x-1+i-n, (double)y+i-n, (double)z-1+i-n, 0.0D, 0.0D, 0.0D);
				world.spawnParticle(particle2, (double)x-1+i-n, (double)y+i-n, (double)z+1+i-n, 0.0D, 0.0D, 0.0D);
			}
		}
		if(tileentity.getProgress()!=0){
			int r = random.nextInt(6);
			if(r==4){
				EntityPlayer player = world.getClosestPlayer((double)x, (double)y, (double)z, 2);
				if(player!=null){
					if(player.getHealth()>=2){
						player.setHealth(player.getHealth()-1);
					}
					player.performHurtAnimation();
					player.playSound("mob.zombie.remedy", 1.0F, 1.0F);
				}
			}
		}
		if(world.isRemote){
			Item[] items = {MiscItems.flightFlask, MiscItems.knowledgeFlask, MiscItems.WitherAnti, MiscItems.Shake, MiscItems.theheart};
			for(int p=0; p<items.length; p++){
				if(checkslot(new ItemStack(items[p])) && tileentity.getProgress()==0){
					world.spawnParticle("reddust", (float)x + 0.5F, (float)y + 1.1F, (float)z + 0.5F, 0, 0, 0);
//					System.out.println("HEY");
				}
			}
		}
	}
	
	public boolean checkslot(ItemStack stack){
		if(brewer.getStackInSlot(3)!=null){
			if(brewer.getStackInSlot(3).isItemEqual(stack)){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
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
	public void updateTick(World world, int x, int y, int z, Random random) {
		TileEntityAdvReactBrewer tileentity = (TileEntityAdvReactBrewer)world.getTileEntity(x, y, z);
		int r = random.nextInt(10);
//		System.out.println(r);
		if(tileentity.getProgress()!=0){
			if(r==4){
				EntityPlayer player = world.getClosestPlayer((double)x, (double)y, (double)z, 2);
				player.setHealth(player.getHealth()-2);
			}
		}
	}
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z) {
	}
	
	public void addInformation(ItemStack p_77624_1_, EntityPlayer player, List list, boolean p_77624_4_) {
		list.add(StringResources.advbrew);
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
