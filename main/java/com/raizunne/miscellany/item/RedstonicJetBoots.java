package com.raizunne.miscellany.item;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;

import com.raizunne.miscellany.MiscItems;
import com.raizunne.miscellany.Miscellany;
import com.raizunne.miscellany.util.StringResources;

public class RedstonicJetBoots extends ItemArmor implements ISpecialArmor{

	private String texture = "miscellany:textures/model/redstonicBoots.png";
	
	public RedstonicJetBoots(ArmorMaterial material, int renderindex, int armortype) {
		super(material, renderindex, armortype);
		armortype = 3;
		maxStackSize = 1;
		setUnlocalizedName("redstonicBoots");
		setCreativeTab(Miscellany.miscTab);
		setTextureName("miscellany:redstonicBoots");
	}
	@Override
	public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_,
			List list, boolean p_77624_4_) {
		list.add(StringResources.redstonicJetBoots);
	}
	
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
			
	}
	
	@Override
	public void onUpdate(ItemStack itemstack, World world, Entity entity, int what, boolean isthis) {
		
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot,
			String type) {
		return texture;
	}
	@Override
	public ArmorProperties getProperties(EntityLivingBase player,
			ItemStack armor, DamageSource source, double damage, int slot) {
		return new ArmorProperties(0, damageReduceAmount / 15D, armor.getMaxDamage() + 1 - armor.getItemDamage());
	}
	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {
		return damageReduceAmount;
	}
	@Override
	public void damageArmor(EntityLivingBase entity, ItemStack stack,DamageSource source, int damage, int slot) {
		stack.damageItem(damage * 2, entity);
	}
}
