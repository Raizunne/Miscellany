package com.raizunne.miscellany.item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;

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
			String mode = itemstack.stackTagCompound.getString("mode");
			if(mode.equals("Wacky")){
				itemstack.stackTagCompound.setString("mode", "Soothing");
				player.playSound("random.burp", 0.5F, 2.0F);
			}else if(mode.equals("Soothing")){
				itemstack.stackTagCompound.setString("mode", "Wacky");
				player.playSound("random.burp", 0.5F, 2.0F);
			}
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
			itemstack.stackTagCompound.setString("mode", "Soothing");
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
		if(itemstack.stackTagCompound.getString("mode").equals("Soothing")){
			updateThisBlock(block1, player.worldObj, x, y, z);
			updateThisBlock(block2, player.worldObj, x+1, y, z);
			updateThisBlock(block3, player.worldObj, x, y, z+1);
			updateThisBlock(block4, player.worldObj, x+1, y, z+1);
			updateThisBlock(block5, player.worldObj, x+1, y, z-1);
			updateThisBlock(block6, player.worldObj, x-1, y, z-1);
			updateThisBlock(block7, player.worldObj, x-1, y, z+1);
			updateThisBlock(block8, player.worldObj, x-1, y, z);
			updateThisBlock(block9, player.worldObj, x, y, z-1);
		}else if(itemstack.stackTagCompound.getString("mode").equals("Wacky")){
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
			if(itemstack.stackTagCompound.getString("mode").equals("Soothing")){
				list.add("Mode: " + EnumChatFormatting.GREEN + "Soothing");;
			}else if(itemstack.stackTagCompound.getString("mode").equals("Wacky")){
				list.add("Mode: " + EnumChatFormatting.GREEN + "Wacky");
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
		Random random = new Random();
		Block blockerino = world.getBlock(x, y-1, z);
		if(block instanceof IPlantable && r == 3){
			if(!world.isRemote){
				world.scheduleBlockUpdate(x, y-1, z, blockerino, 20);
				block.updateTick(world, x, y-1, z, world.rand);
			}
		}
	}
	
	public void breakThisBlock(Block block, World world, int x, int y, int z){
		Random random = new Random();
		int r = random.nextInt(1);
		List<ItemStack> items = new ArrayList();
		if(!world.isRemote){
			if(block instanceof IPlantable && r==0){
				items.addAll(block.getDrops(world, x, y-1, z, world.getBlockMetadata(x, y-1, z), 1));
				world.func_147480_a(x, y-1, z, true);
				for(ItemStack stackerino : items){
					world.spawnEntityInWorld(new EntityItem(world, x, y, z, stackerino));
				}
			}
		}	
	}
}
