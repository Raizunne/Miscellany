package com.raizunne.miscellany.item;

import com.raizunne.miscellany.Miscellany;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class debugHunger extends Item{
	
	public debugHunger(){
		setUnlocalizedName("debugHunger");
		setCreativeTab(Miscellany.miscTab).setMaxStackSize(1);
		setTextureName(Miscellany.MODID + ":" + "debugHunger");
	}
	
	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
		player.addPotionEffect(new PotionEffect(Potion.hunger.id, 100, 2));
        return false;
    }
}
