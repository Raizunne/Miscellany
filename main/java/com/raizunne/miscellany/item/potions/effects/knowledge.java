package com.raizunne.miscellany.item.potions.effects;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;

public class knowledge extends net.minecraft.potion.PotionEffect{

	public static int potionid;
	public static int potionduration;
	
	public knowledge(int id, int duration) {
		super(id, duration);
		this.potionid = id;
		this.potionduration = duration;
	}
	
}
	
