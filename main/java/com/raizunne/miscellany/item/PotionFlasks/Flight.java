package com.raizunne.miscellany.item.PotionFlasks;

import java.util.List;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.raizunne.miscellany.Miscellany;

public class Flight extends Item{

	public Flight() {
		setUnlocalizedName("flightFlask");
		setMaxStackSize(1);
		setMaxDamage(3);
		setCreativeTab(Miscellany.miscTab);
		setNoRepair();
	}
	public static IIcon icons;
	
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		player.setItemInUse(itemstack, getMaxItemUseDuration(itemstack));
		return itemstack;
	}
	
	@Override
	public ItemStack onEaten(ItemStack itemstack, World world, EntityPlayer player) {
		player.addPotionEffect(new PotionEffect(Miscellany.flightPotion.getId(), 3000, 0));
		itemstack.damageItem(1, player);
		if(itemstack.getItemDamage()==3){
			return null;
		}else{
			return itemstack;
		}
	}
	
	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer p_77624_2_,
			List list, boolean p_77624_4_) {
		list.add(EnumChatFormatting.LIGHT_PURPLE + "Invisible wings...");
		switch(getDamage(itemstack)){
		case 0:
			list.add(EnumChatFormatting.GRAY + "Potations Left: 3");
			break;
		case 1:
			list.add(EnumChatFormatting.GRAY + "Potations Left: 2");
			break;
		case 2:
			list.add(EnumChatFormatting.GRAY + "Potations Left: 3");
			break;
		}
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack itemstack) {
		return 32;
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack itemstack) {
		return EnumAction.drink;
	}
	
	@Override
	public boolean hasEffect(ItemStack par1ItemStack, int pass) {
		return true;
	}
	
	@Override
	public void registerIcons(IIconRegister register) {
		icons = register.registerIcon("miscellany:flightFlask");
	}
	
	@Override
	public IIcon getIcon(ItemStack stack, int pass) {
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glEnable(GL11.GL_BLEND);
		return icons;
	}
	
	@Override
	public IIcon getIconIndex(ItemStack itemstack) {
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glEnable(GL11.GL_BLEND);
		return icons;
	}
}
