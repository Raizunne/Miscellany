package com.raizunne.miscellany.item;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.util.FakePlayerFactory;

import com.raizunne.miscellany.MiscItems;
import com.raizunne.miscellany.Miscellany;
import com.raizunne.miscellany.util.StringResources;

public class Package extends Item{

	public NBTTagCompound nbt = new NBTTagCompound();	
	private int itemid;
	private int count;
	
	public Package(){
		setMaxStackSize(1);
		setUnlocalizedName("package");
		setTextureName("miscellany:Package");
		setCreativeTab(Miscellany.miscTab);
		setMaxDamage(0);
	}
	
	@Override
	public void onCreated(ItemStack itemstack, World p_77622_2_, EntityPlayer p_77622_3_) {
		if(itemstack.stackTagCompound==null){
			itemstack.stackTagCompound = new NBTTagCompound();
		}
	}
	
	@Override
	public void onUpdate(ItemStack itemstack, World p_77663_2_, Entity p_77663_3_, int p_77663_4_, boolean p_77663_5_) {
		if(itemstack.stackTagCompound==null){
			itemstack.stackTagCompound = new NBTTagCompound();
		}
		if(itemstack.stackTagCompound!=null){
		}
	}
	
	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean what) {
		super.addInformation(itemstack, player, list, what);
		list.add(StringResources.pack);
		if(itemstack.stackTagCompound!=null){
			int id = itemstack.stackTagCompound.getInteger("item");
			int count = itemstack.stackTagCompound.getInteger("count");
			int meta = itemstack.stackTagCompound.getInteger("meta");
			if(itemstack.stackTagCompound.getInteger("item")!=0){
				ItemStack stack = new ItemStack(getItemById(id), 1, meta);
				String name = stack.getDisplayName();
				list.add("Contains: " + itemstack.stackTagCompound.getInteger("count") + " of " + EnumChatFormatting.BLUE + name);
			}else{
				list.add("Empty");
			}
		}else{
			list.add("Empty");
		}
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		if(itemstack.stackTagCompound.getInteger("item")!=0 && itemstack.stackTagCompound.getInteger("count")!=0){
			player.setItemInUse(itemstack, getMaxItemUseDuration(itemstack));
		}else{
			if(world.isRemote){
				player.addChatComponentMessage(new ChatComponentText("Package is empty..."));
			}
		}
		return itemstack;
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack p_77626_1_) {
		return 32;
	}
	
	@Override
	public ItemStack onEaten(ItemStack itemstack, World world, EntityPlayer player) {
		int id = itemstack.stackTagCompound.getInteger("item");
		int count = itemstack.stackTagCompound.getInteger("count");
		int meta = itemstack.stackTagCompound.getInteger("meta");
		EntityItem item;
		
		itemstack.setItemDamage(1);
		
		if(player instanceof FakePlayer){
			return null;
		}
		
		ItemStack stack = new ItemStack(getItemById(id), count, meta);
		String name = stack.getDisplayName();
		if(player.inventory.addItemStackToInventory(stack)){
			player.inventory.addItemStackToInventory(stack);
		}else{
			item = new EntityItem(world, player.posX, player.posY, player.posZ, stack);
			if(!world.isRemote){
				world.spawnEntityInWorld(item);
			}	
		}
		if(world.isRemote){
			player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "<Package> " + EnumChatFormatting.WHITE + "Added " + 
			EnumChatFormatting.BLUE + count + EnumChatFormatting.WHITE + " of " + EnumChatFormatting.BLUE + name));
		}
		player.playSound("miscellany:openbox", 1F, 1F);
		return null;
	}
	
	@Override
	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
		if(stack.isItemEqual(new ItemStack(MiscItems.pack))){
		}
		return false;
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack itemstack) {
		return EnumAction.bow;
	}
	
	
}
