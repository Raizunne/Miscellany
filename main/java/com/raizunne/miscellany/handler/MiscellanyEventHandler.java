package com.raizunne.miscellany.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

import com.raizunne.miscellany.Miscellany;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class MiscellanyEventHandler {

	private static EntityPlayer player;

	@SubscribeEvent
	public void onLivingUpdateEntity(LivingUpdateEvent event){
		if(event.entity instanceof EntityPlayer){
			player = (EntityPlayer)event.entity;
		}
		//REDSTONIC JETBOOTS
		if(event.entity instanceof EntityPlayer){
			boolean equipped = false;
			ItemStack boots = player.inventory.armorInventory[0];
			if(boots!=null){
				if(boots.getItem() == Miscellany.redstonicBoots){	
					player.stepHeight = 1;
					player.capabilities.setPlayerWalkSpeed(0.15F);
					player.jumpMovementFactor = 0.05F;
					equipped=true;	
				}
			}
			if(equipped==true && boots.getItem()!=Miscellany.redstonicBoots){
				player.stepHeight=player.stepHeight-1F;
				player.capabilities.setPlayerWalkSpeed(player.capabilities.getWalkSpeed()-0.15F);
				player.jumpMovementFactor = player.jumpMovementFactor - 0.05F;
				equipped=false;
			}	
		}
		//FLIGHT POTION
		if(event.entity instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer)event.entity;
			boolean world = event.entity.worldObj.isRemote;
			if(player.isPotionActive(Miscellany.flightPotion.getId())){
				player.capabilities.allowFlying=true;
				if(player.getActivePotionEffect(Miscellany.flightPotion).getDuration()==1){
					player.capabilities.allowFlying=false;
					player.removePotionEffect(Miscellany.flightPotion.getId());
				}
			}
		}
		
		//KNOWLEDGE POTION
		if(event.entity instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer)event.entity;
			boolean world = event.entity.worldObj.isRemote;
			if(player.isPotionActive(Miscellany.knowledgePotion.getId())){
				player.addExperience(6);
				if(player.getActivePotionEffect(Miscellany.knowledgePotion).getDuration()==1){
					player.experienceLevel=0;
					player.removePotionEffect(Miscellany.knowledgePotion.getId());
				}
			}
		}
	}
	
	
	@SubscribeEvent
	public void livingFall(LivingFallEvent event){
		if(event.entity instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer)event.entity;
			boolean world = event.entity.worldObj.isRemote;
			if(player.isPotionActive(Miscellany.flightPotion)){
				if(player.getActivePotionEffect(Miscellany.flightPotion).getDuration()==0){
					if(player.onGround){
						event.distance=0F;
					}
				}
			}
		}
	}
}


