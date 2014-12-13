/**
Code made by Raizunne as a part of Raizunne's Miscellany  
Source code found at github.com/Raizunne
 */
package com.raizunne.miscellany.handler;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MovingObjectPosition;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

import com.raizunne.miscellany.MiscItems;
import com.raizunne.miscellany.block.ThePackage;
import com.raizunne.miscellany.client.TextOnScreen;
import com.raizunne.miscellany.client.render.RenderOnPlayer;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MiscellanyEventHandler {

	private static EntityPlayer player;
	@SubscribeEvent
	public void onLivingUpdateEntity(LivingUpdateEvent event){
		//REDSTONIC JETBOOTS
		if(event.entity instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer)event.entity;
			ItemStack boots = player.getCurrentArmor(0);
			if(boots!=null && boots.equals(MiscItems.redstonicBoots)){
				
			}else{
				
			}
		}
		//FLIGHT POTION
		if(event.entity instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer)event.entity;
			boolean world = event.entity.worldObj.isRemote;
			boolean flying = false;
			if(player.isPotionActive(MiscItems.flightPotion.getId())){
				player.capabilities.allowFlying=true;
				flying=true;
				if(player.getActivePotionEffect(MiscItems.flightPotion).getDuration()==200){
					if(!world){
						player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.YELLOW + "Flight about to end! Floor it!"));
					}
				}
				if(player.getActivePotionEffect(MiscItems.flightPotion).getDuration()==1){
					if(!player.capabilities.isCreativeMode){
						player.capabilities.isFlying=false;
						player.capabilities.allowFlying=false;
						player.sendPlayerAbilities();
					}
				}
			}
		}
		
		//KNOWLEDGE POTION
		if(event.entity instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer)event.entity;
			boolean world = event.entity.worldObj.isRemote;
			boolean active;
			if(player.isPotionActive(MiscItems.knowledgePotion.getId())){
				active=true;
				player.addExperience(5);
				if(player.getActivePotionEffect(MiscItems.knowledgePotion).getDuration()==1){
					player.experienceLevel=0;
					player.removePotionEffect(MiscItems.knowledgePotion.getId());
				}
			}
		}
	}
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void render(RenderGameOverlayEvent event){
		TextOnScreen.items(event);
		TextOnScreen.blocks(event);
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void playerRender(RenderPlayerEvent.Specials.Pre event){
		if(event.entityPlayer.worldObj.isRemote){
			RenderOnPlayer.renderForRaizunne(event);
		}
	}
	
}


