package com.raizunne.miscellany.item;

import java.util.List;

import com.raizunne.miscellany.MiscItems;
import com.raizunne.miscellany.Miscellany;
import com.raizunne.miscellany.util.StringResources;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class KnowledgeGem extends Item{
	
	public KnowledgeGem(){
		setCreativeTab(Miscellany.miscTab);
		setUnlocalizedName("knowledgegem");
		setMaxStackSize(1);
		setMaxDamage(1);
		setTextureName("miscellany:KnowledgeGem");
	}
	
	int timer;
	
	@Override
	public void onCreated(ItemStack itemstack, World world, EntityPlayer player) {
		if(itemstack.stackTagCompound==null){
			itemstack.stackTagCompound = new NBTTagCompound();
			itemstack.stackTagCompound.setInteger("xp", 0);
			itemstack.stackTagCompound.setBoolean("creative", false);
			timer = 0;
		}
	}
	
	@Override
	public void onUpdate(ItemStack itemstack, World world, Entity entity, int lol, boolean what) {
		if(itemstack.stackTagCompound==null){
			itemstack.stackTagCompound = new NBTTagCompound();
			itemstack.stackTagCompound.setInteger("xp", 0);
			itemstack.stackTagCompound.setBoolean("creative", false);
			timer = 0;
		}
		if(entity instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer)entity;
			if(player.inventory.getCurrentItem()!=null && player.inventory.getCurrentItem().isItemEqual(new ItemStack(MiscItems.knowledgegem)))
			if(timer!=10 && player.getHealth()<8){
				timer++;
				if(timer==9){
					player.playSound("note.harp", 1.0F, 1.0F);
					timer=0;
				}
			}
		}
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		if(player.experienceLevel>0 && !player.isPotionActive(MiscItems.knowledgePotion)){
			player.experienceLevel=player.experienceLevel-1;
			if(!player.capabilities.isCreativeMode){
				player.setHealth(player.getHealth()-1);
			}
//			player.attackEntityFrom(new DamageSource("KnowledgeOverdose"), 2);
			itemstack.stackTagCompound.setInteger("xp", itemstack.stackTagCompound.getInteger("xp")+1);
			player.playSound("note.bd", 3.0F, 2.0F);
			player.playSound("random.burp", 1.0F, 0.5F);
		}
		if(player.getHealth()<=0.001f){
			player.onDeath(DamageSource.anvil);
		}
		if(player.isPotionActive(MiscItems.knowledgePotion)){
			if(!world.isRemote){
				player.addChatComponentMessage(new ChatComponentText("Too much knowledge, might " + EnumChatFormatting.RED + "overdose" + EnumChatFormatting.WHITE + "."));
			}
		}
		return itemstack;
	}
	
	@Override
	public boolean onEntitySwing(EntityLivingBase entity, ItemStack itemstack) {
		if(entity instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer) entity;
			MovingObjectPosition pos = this.getMovingObjectPositionFromPlayer(player.worldObj, player, true);
			if(itemstack.stackTagCompound.getInteger("xp")>0 && pos==null){
				itemstack.stackTagCompound.setInteger("xp", itemstack.stackTagCompound.getInteger("xp")-1);
				player.experienceLevel=player.experienceLevel+1;
				if(!player.capabilities.isCreativeMode){
					player.setHealth(player.getHealth()-2);
				}
				player.playSound("random.bow", 3.0F, 2.0F);
				player.playSound("random.burp", 1.0F, 2F);
			}
		}
		return false;
	}
	
	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean p_77624_4_) {
		list.add(StringResources.knowledgegemerino);
		if(itemstack.stackTagCompound!=null){
			if(!itemstack.stackTagCompound.getBoolean("creative")){
				String obs;
				if(player.isPotionActive(MiscItems.knowledgePotion)){
					obs = "§k";
				}else{
					obs = "";
				}
				list.add(obs + "Wisdom Stored: " + itemstack.stackTagCompound.getInteger("xp"));
			}else{
				list.add("CREATIVE");
			}
		}
	}
}
