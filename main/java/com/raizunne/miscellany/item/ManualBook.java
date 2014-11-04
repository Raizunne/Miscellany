package com.raizunne.miscellany.item;

import java.util.List;

import com.raizunne.miscellany.Miscellany;
import com.raizunne.miscellany.util.StringResources;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ManualBook extends Item{
	public ManualBook(){
		setMaxStackSize(1);
		setUnlocalizedName("manualBook");
		setCreativeTab(Miscellany.miscTab);
		setTextureName("miscellany:manualBook");
	}
	
	String page1 = "miscellany:pageflip1";
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		player.openGui(com.raizunne.miscellany.Miscellany.instance, 2, world, (int)player.posX, (int)player.posY, (int)player.posZ);
		player.playSound("miscellany:pageflip1", 0.2F, 1F); 
		
		return itemstack;
	}
	
	@Override
	public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_,
			List list, boolean p_77624_4_) {
		list.add(StringResources.manualBook);
	}
}
