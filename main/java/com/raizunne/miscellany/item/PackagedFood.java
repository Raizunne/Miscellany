package com.raizunne.miscellany.item;

import com.raizunne.miscellany.Miscellany;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class PackagedFood extends ItemFood{


    public PackagedFood(int p_i45339_1_, float p_i45339_2_, boolean p_i45339_3_) {
    	super(p_i45339_1_, p_i45339_2_, p_i45339_3_);
    	setMaxStackSize(16);
    	setUnlocalizedName("packagedFood");
    	setCreativeTab(Miscellany.miscTab);
    	setTextureName("miscellany:packagedFood");
	}

	public ItemStack onEaten(ItemStack itemstack, World world, EntityPlayer player)
    {
        super.onEaten(itemstack, world, player);
        player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 50, 0));
        player.addPotionEffect(new PotionEffect(Potion.wither.id, 25, 2));
        itemstack.stackSize--;
        return itemstack;
    }
	
}
