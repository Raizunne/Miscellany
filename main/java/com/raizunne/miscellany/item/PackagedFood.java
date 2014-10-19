package com.raizunne.miscellany.item;

import java.util.List;

import com.raizunne.miscellany.Miscellany;
import com.raizunne.miscellany.util.StringResources;

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
        if(!world.isRemote){
        	itemstack.stackSize--;
        }
        return itemstack;
    }
	
	@Override
	public int getMaxItemUseDuration(ItemStack p_77626_1_) {
		// TODO Auto-generated method stub
		return 48;
	}	

	@Override
	public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_,
			List list, boolean p_77624_4_) {
		list.add(StringResources.packagedFood);
	}
}
