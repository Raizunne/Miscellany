package com.raizunne.miscellany.item;

import java.util.List;

import com.jcraft.jorbis.Block;
import com.raizunne.miscellany.Miscellany;
import com.raizunne.miscellany.util.StringResources;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;
	
public class sacredChalice extends Item {

	IIcon emptyChalice;
	IIcon fullChalice;
	public static boolean empty;
	Item cobbleItem;
	public static int itemsNeeded;
	
	public sacredChalice(){
		setUnlocalizedName("sacredChalice");
		setCreativeTab(Miscellany.miscTab);
		setMaxStackSize(1);
		empty = false;
		itemsNeeded = 1;
		setTextureName("miscellany:sacredChalice");
		
	}
	
	@Override
	public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_,
			List list, boolean p_77624_4_) {
		list.add(StringResources.chalice);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		MovingObjectPosition pos = this.getMovingObjectPositionFromPlayer(world, player, true);
			if(player.inventory.hasItemStack(new ItemStack(Blocks.cobblestone)) || player.capabilities.isCreativeMode==true){	
				if(pos==null){
					return itemstack;
				}
				if(player.isClientWorld()){
					player.swingItem();
				}
				if(pos.typeOfHit == MovingObjectType.BLOCK){
						int posX = pos.blockX;
						int posY = pos.blockY;
						int posZ = pos.blockZ;
						
						if(!player.capabilities.isCreativeMode){
							player.inventory.consumeInventoryItem(new ItemStack(Blocks.cobblestone).getItem());
						}
						
						if(pos.sideHit==1){
							world.spawnParticle("magicCrit", (float)posX+0.2, (float)posY+2, (float)posZ+0.2, 0, 0, 0);
							world.spawnParticle("magicCrit", (float)posX+0.4, (float)posY+2, (float)posZ+0.4, 0, 0, 0);
							world.spawnParticle("magicCrit", (float)posX+0.6, (float)posY+2, (float)posZ+0.6, 0, 0, 0);
							world.spawnParticle("magicCrit", (float)posX+0.8, (float)posY+2, (float)posZ+0.8, 0, 0, 0);
							world.spawnParticle("magicCrit", (float)posX+0.2, (float)posY+2, (float)posZ+0.8, 0, 0, 0);
							world.spawnParticle("magicCrit", (float)posX+0.4, (float)posY+2, (float)posZ+0.6, 0, 0, 0);
							world.spawnParticle("magicCrit", (float)posX+0.6, (float)posY+2, (float)posZ+0.4, 0, 0, 0);
							world.spawnParticle("magicCrit", (float)posX+0.8, (float)posY+2, (float)posZ+0.2, 0, 0, 0);
						}
							world.playSoundAtEntity(player, "liquid.lavapop", 1, -2F);
						
						switch(pos.sideHit){
						case 0: 
							if(world.getBlock(posX, posY, posZ)!=Blocks.water || world.getBlockMetadata(posX, posY, posZ)!=0){
							world.setBlock(posX, posY-1, posZ, Blocks.flowing_water, 0, 3);
							world.setBlockMetadataWithNotify(posX, posY-1, posZ, 0, 1);
							}
							break;
						case 1: 
							if(world.getBlock(posX, posY, posZ)!=Blocks.water || world.getBlockMetadata(posX, posY, posZ)!=0){
							world.setBlock(posX, posY+1, posZ, Blocks.flowing_water, 0, 3);
							world.setBlockMetadataWithNotify(posX, posY+1, posZ, 0, 1);
							}
							break;
						case 2:
							if(world.getBlock(posX, posY, posZ)!=Blocks.water || world.getBlockMetadata(posX, posY, posZ)!=0){
							world.setBlock(posX, posY, posZ-1, Blocks.flowing_water, 0, 3);
							world.setBlockMetadataWithNotify(posX, posY, posZ-1, 0, 1);
							}
							break;
						case 3:
							if(world.getBlock(posX, posY, posZ)!=Blocks.water || world.getBlockMetadata(posX, posY, posZ)!=0){
							world.setBlock(posX, posY, posZ+1, Blocks.flowing_water, 0, 3);
							world.setBlockMetadataWithNotify(posX, posY, posZ+1, 0, 1);
							}
							break;
						case 4:
							if(world.getBlock(posX, posY, posZ)!=Blocks.water || world.getBlockMetadata(posX, posY, posZ)!=0){
							world.setBlock(posX-1, posY, posZ, Blocks.flowing_water, 0, 3);
							world.setBlockMetadataWithNotify(posX-1, posY, posZ, 0, 1);
							}
							break;
						case 5:
							if(world.getBlock(posX, posY, posZ)!=Blocks.water || world.getBlockMetadata(posX, posY, posZ)!=0){
							world.setBlock(posX+1, posY, posZ, Blocks.flowing_water, 0, 3);
							world.setBlockMetadataWithNotify(posX+1, posY, posZ, 0, 1);
							}
							break;
						}
					}
			}else{
				if(world.isRemote){
					player.addChatMessage(new ChatComponentText("No cobblestone found"));
					world.playSoundAtEntity(player, "liquid.lavapop", 1, 3F);
				}
			}
		return itemstack;
	}	
}
