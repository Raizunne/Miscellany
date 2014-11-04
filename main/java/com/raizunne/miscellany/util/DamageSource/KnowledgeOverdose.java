package com.raizunne.miscellany.util.DamageSource;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;

public class KnowledgeOverdose extends DamageSource {

	public KnowledgeOverdose(String string) {
		super(string);
		
	}
	@Override
	public IChatComponent func_151519_b(EntityLivingBase entityLiving) {
		return new ChatComponentText(entityLiving.getCommandSenderName() + " overdosed in " + EnumChatFormatting.GREEN + "Knowledge");
	}
}
