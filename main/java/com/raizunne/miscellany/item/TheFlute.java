package com.raizunne.miscellany.item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.BonemealEvent;

import com.raizunne.miscellany.MiscItems;
import com.raizunne.miscellany.Miscellany;
import com.raizunne.miscellany.util.StringResources;

public class TheFlute extends Item{

	public TheFlute(){
		setCreativeTab(Miscellany.miscTab);
		setUnlocalizedName("theflute");
		setMaxStackSize(1);
		setMaxDamage(128);
		setTextureName("miscellany:theflute");
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		if(player.isSneaking()){
			switch(itemstack.stackTagCompound.getInteger("mode")){
			case 0:
				itemstack.stackTagCompound.setInteger("mode", 1);
				player.playSound("random.burp", 0.5F, 2.0F);
				if(world.isRemote){player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "Mode now set on " + EnumChatFormatting.GREEN + "Wacky" + EnumChatFormatting.LIGHT_PURPLE + " mode."));}
			break;
			case 1:
				itemstack.stackTagCompound.setInteger("mode", 0);
				player.playSound("random.burp", 0.5F, 2.0F);
				if(world.isRemote){player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "Mode now set on " + EnumChatFormatting.GREEN + "Soothing" + EnumChatFormatting.LIGHT_PURPLE + " mode."));}
			}
//			System.out.println(world.getBlock((int)player.posX, (int)player.posY-1, (int)player.posZ));
		}else{
			if(itemstack.getItemDamage()<1){
				player.setItemInUse(itemstack, getMaxItemUseDuration(itemstack));
			}
		}
		return itemstack;
	}
	
	@Override
	public void onUpdate(ItemStack itemstack, World world, Entity entity, int p_77663_4_, boolean p_77663_5_) {
		if(itemstack.stackTagCompound==null){
			itemstack.stackTagCompound = new NBTTagCompound();
			itemstack.stackTagCompound.setInteger("mode", 0);
		}
		
		if(entity instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer)entity;
			if(player.getItemInUse() != new ItemStack(MiscItems.theflute)){
				itemstack.setItemDamage(itemstack.getItemDamage()-1);
			}
		}
	}

	@Override
	public void onUsingTick(ItemStack itemstack, EntityPlayer player, int count) {
		super.onUsingTick(itemstack, player, count);
		
		Random random = new Random();
		int number = random.nextInt(5);
		if(number == 0){
			itemstack.damageItem(1, player);
		}
		
		
		double i = random.nextDouble();
		double n = random.nextDouble();
		double r = random.nextDouble();
		double e = random.nextDouble();
		
		player.worldObj.spawnParticle("witchMagic", (double)player.posX+i-n, (double)player.posY-2+i-n, (double)player.posZ+i-n, 0.0D, 1.0D, 0.0D);
		player.worldObj.spawnParticle("witchMagic", (double)player.posX+1+i-n, (double)player.posY-2+i-n, (double)player.posZ+i-n, 0.0D, 1.0D, 0.0D);
		player.worldObj.spawnParticle("witchMagic", (double)player.posX+i-n, (double)player.posY-2+i-n, (double)player.posZ+1+i-n, 0.0D, 1.0D, 0.0D);
		player.worldObj.spawnParticle("witchMagic", (double)player.posX-1+i-n, (double)player.posY-2+i-n, (double)player.posZ+i-n, 0.0D, 1.0D, 0.0D);
		player.worldObj.spawnParticle("witchMagic", (double)player.posX+i-n, (double)player.posY-2+i-n, (double)player.posZ-1+i-n, 0.0D, 1.0D, 0.0D);
		player.worldObj.spawnParticle("witchMagic", (double)player.posX+1+i-n, (double)player.posY-2+i-n, (double)player.posZ+1+i-n, 0.0D, 1.0D, 0.0D);
		player.worldObj.spawnParticle("witchMagic", (double)player.posX+1+i-n, (double)player.posY-2+i-n, (double)player.posZ-1+i-n, 0.0D, 1.0D, 0.0D);
		player.worldObj.spawnParticle("witchMagic", (double)player.posX-1+i-n, (double)player.posY-2+i-n, (double)player.posZ-1+i-n, 0.0D, 1.0D, 0.0D);
		player.worldObj.spawnParticle("witchMagic", (double)player.posX-1+i-n, (double)player.posY-2+i-n, (double)player.posZ+1+i-n, 0.0D, 1.0D, 0.0D);
		
		int x = (int)player.posX;
		int y = (int)player.posY;
		int z = (int)player.posZ;
		
		Block block1 = player.worldObj.getBlock(x, y-1, z);
		Block block2 = player.worldObj.getBlock(x+1, y-1, z);
		Block block3 = player.worldObj.getBlock(x, y-1, z+1);
		Block block4 = player.worldObj.getBlock(x+1, y-1, z+1);
		Block block5 = player.worldObj.getBlock(x+1, y-1, z-1);
		Block block6 = player.worldObj.getBlock(x-1, y-1, z+1);
		Block block7 = player.worldObj.getBlock(x-1, y-1, z-1);
		Block block8 = player.worldObj.getBlock(x-1, y-1, z);
		Block block9 = player.worldObj.getBlock(x, y-1, z-1);
		switch(itemstack.stackTagCompound.getInteger("mode")){
		case 0:
			updateThisBlock(block1, player.worldObj, x, y, z);
			updateThisBlock(block2, player.worldObj, x+1, y, z);
			updateThisBlock(block3, player.worldObj, x, y, z+1);
			updateThisBlock(block4, player.worldObj, x+1, y, z+1);
			updateThisBlock(block5, player.worldObj, x+1, y, z-1);
			updateThisBlock(block6, player.worldObj, x-1, y, z-1);
			updateThisBlock(block7, player.worldObj, x-1, y, z+1);
			updateThisBlock(block8, player.worldObj, x-1, y, z);
			updateThisBlock(block9, player.worldObj, x, y, z-1);
		break;
		
		case 1:
			breakThisBlock(block1, player.worldObj, x, y, z);
			breakThisBlock(block2, player.worldObj, x+1, y, z);
			breakThisBlock(block3, player.worldObj, x, y, z+1);
			breakThisBlock(block4, player.worldObj, x+1, y, z+1);
			breakThisBlock(block5, player.worldObj, x+1, y, z-1);
			breakThisBlock(block6, player.worldObj, x-1, y, z-1);
			breakThisBlock(block7, player.worldObj, x-1, y, z+1);
			breakThisBlock(block8, player.worldObj, x-1, y, z);
			breakThisBlock(block9, player.worldObj, x, y, z-1);	
		}
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack p_77661_1_) {
		return EnumAction.block;
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack p_77626_1_) {
		return 100000;
	}
	
	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean donteventryanymore) {
		list.add(StringResources.theflute);
		if(itemstack.stackTagCompound!=null){
			switch(itemstack.stackTagCompound.getInteger("mode")){
			case 0:
				list.add("Mode: " + EnumChatFormatting.GREEN + "Soothing");
			break;
			case 1:
				list.add("Mode: " + EnumChatFormatting.GREEN + "Wacky");
			break;
			}
		}
	}
	
	@Override
	public void onCreated(ItemStack itemstack, World world, EntityPlayer player) {
		if(itemstack.stackTagCompound==null){
			itemstack.stackTagCompound = new NBTTagCompound();
			itemstack.stackTagCompound.setInteger("mode", 0);
		}
	}
	
	public void updateThisBlock(Block block, World world, int x, int y, int z){
		int r = world.rand.nextInt(4);
		if(block instanceof IPlantable && r == 3){
			System.out.println("Updated");
			block.updateTick(world, x, y-1, z, world.rand);
		}
	}
	
	public void breakThisBlock(Block block, World world, int x, int y, int z){
		Random random = new Random();
		int r = random.nextInt(1);
		List<ItemStack> items = new ArrayList();
		if(block instanceof IPlantable && r==0){
			items.addAll(block.getDrops(world, x, y-1, z, world.getBlockMetadata(x, y-1, z), 1));
			world.func_147480_a(x, y-1, z, true);
			for(ItemStack stackerino : items){
				world.spawnEntityInWorld(new EntityItem(world, x, y, z, stackerino));
			}
		}
	}
}
