package com.raizunne.miscellany.handler;

import com.raizunne.miscellany.Miscellany;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class MiscellanyEventHandler {

	@SubscribeEvent
	public void onLivingUpdateEntity(LivingUpdateEvent event){
		if(event.entity instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer)event.entity;
			ItemStack boots = player.inventory.armorInventory[0];
			if(boots!=null){
				if(boots.getItem() == Miscellany.redstonicBoots){	
					player.stepHeight = 1;
					player.capabilities.setPlayerWalkSpeed(0.15F);
					player.jumpMovementFactor = 0.05F;
				}			
			}
		}
	}
	
}
