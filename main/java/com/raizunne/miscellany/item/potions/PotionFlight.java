package com.raizunne.miscellany.item.potions;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;

public class PotionFlight extends Potion{

	public PotionFlight(int id, boolean bad, int color) {
		super(id, bad, color);
		setPotionName("flightPotion");
		setIconIndex(0, 0);
	}

	@Override
	public void performEffect(EntityLivingBase entity, int p_76394_2_) {
	}

	@Override
	protected Potion setIconIndex(int p_76399_1_, int p_76399_2_) {
		return super.setIconIndex(1,0);
	}

	@Override
	public int getStatusIconIndex() {
		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("miscellany", "textures/gui/widgets.png"));
		return super.getStatusIconIndex();
	}

}
