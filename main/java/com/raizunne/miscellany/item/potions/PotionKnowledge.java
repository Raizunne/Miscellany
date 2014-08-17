package com.raizunne.miscellany.item.potions;

import com.raizunne.miscellany.Miscellany;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;

public class PotionKnowledge extends Potion{

	public PotionKnowledge(int id, boolean bad, int color) {
		super(id, bad, color);
		setPotionName("knowledgePotion");

	}

	@Override
	public void performEffect(EntityLivingBase entity, int p_76394_2_) {
			if(entity instanceof EntityPlayer){
				System.out.println("ENTITY IS PLAYER");
				((EntityPlayer) entity).experienceTotal = 30;
			}
	}

	
}
