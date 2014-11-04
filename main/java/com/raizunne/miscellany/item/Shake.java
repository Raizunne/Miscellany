package com.raizunne.miscellany.item;

import java.util.List;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import com.raizunne.miscellany.Miscellany;
import com.raizunne.miscellany.util.StringResources;

public class Shake extends Item{

	public Shake(){
		setUnlocalizedName("shake");
		setCreativeTab(Miscellany.miscTab);
		setMaxStackSize(1);
		setMaxDamage(50);
	}
	
	public static IIcon icons;
	
	@Override
	public void onCreated(ItemStack itemstack, World world, EntityPlayer player) {
		if(itemstack.stackTagCompound==null){
			itemstack.stackTagCompound = new NBTTagCompound();
			itemstack.stackTagCompound.setInteger("uses", 50);
		}
	}
	
	@Override
	public void onUpdate(ItemStack itemstack, World p_77663_2_, Entity player, int p_77663_4_, boolean p_77663_5_) {
		if(itemstack.stackTagCompound==null){
			itemstack.stackTagCompound = new NBTTagCompound();
			itemstack.stackTagCompound.setInteger("uses", 50);
		}
		if(itemstack.getItemDamage()==50){
		}
	}
	
	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean bool) {
		list.add(StringResources.shake);
		if(itemstack.stackTagCompound!=null){
			list.add("Shakes left: " + itemstack.stackTagCompound.getInteger("uses"));
		}
	}
	
	
	@Override
	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack itemstack) {
		if(entityLiving instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer) entityLiving;		
			MovingObjectPosition pos = this.getMovingObjectPositionFromPlayer(player.worldObj, player, true);
				World world = player.worldObj;
				if(player.getFoodStats().needFood() && pos==null){
					player.getFoodStats().addStats(4, 6);
					world.playSoundAtEntity(player, "mob.enderdragon.hit", 0.5F, 1.3F);
					if(!player.capabilities.isCreativeMode){
						itemstack.stackTagCompound.setInteger("uses", itemstack.stackTagCompound.getInteger("uses")-1);
						itemstack.damageItem(1, entityLiving);
					}
					if(player.inventory.getCurrentItem().getItemDamage()==50){
						player.inventory.decrStackSize(player.inventory.currentItem, 1);
						world.playSoundAtEntity(player, "mob.endermen.hit", 0.5F, 1F);
					}
				}
			}
		return false;
	}	
		
	@Override
	public EnumAction getItemUseAction(ItemStack p_77661_1_) {
		// TODO Auto-generated method stub
		return EnumAction.block;
	}
	
	@Override
	public void registerIcons(IIconRegister register) {
		icons = register.registerIcon("miscellany:FlaskShake");
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
