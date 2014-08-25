package com.raizunne.miscellany.item.PotionFlasks;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.raizunne.miscellany.Miscellany;

public class Knowledge extends Item{

	public Knowledge() {
		setUnlocalizedName("knowledgeFlask");
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
		player.addPotionEffect(new PotionEffect(Miscellany.knowledgePotion.getId(), 200, 0));
		itemstack.damageItem(1, player);
		if(itemstack.getItemDamage()==3){
			return null;
		}else{
			return itemstack;
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
		icons = register.registerIcon("miscellany:knowledgeFlask");
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
