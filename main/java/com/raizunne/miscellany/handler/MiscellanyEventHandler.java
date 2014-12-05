package com.raizunne.miscellany.handler;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

import com.raizunne.miscellany.MiscItems;
import com.raizunne.miscellany.Miscellany;
import com.raizunne.miscellany.client.model.ModelVeneer;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class MiscellanyEventHandler {

	private static EntityPlayer player;
	@SubscribeEvent
	public void onLivingUpdateEntity(LivingUpdateEvent event){
		
		Minecraft minecraft = Minecraft.getMinecraft();
		boolean kghudRegistered = false;
		
		if(event.entity instanceof EntityPlayer){
			player = (EntityPlayer)event.entity;
		}
		//REDSTONIC JETBOOTS
		if(event.entity instanceof EntityPlayer){
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
	
	public void onPlayerLogin(EntityPlayer player){
		
	}
	
	@SubscribeEvent
	public void render(RenderGameOverlayEvent event){
		TextOnScreen.init(event);
	}
	
	ModelVeneer veneer = new ModelVeneer();
	
//	@SubscribeEvent
//	public void onPlayerRender(RenderPlayerEvent.Post event){
//		EntityPlayer player = event.entityPlayer;
//		
//		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Miscellany.MODID + ":" + "textures/model/Veneer.png"));
//		
//		veneer.render(player, (float)player.posX, (float)player.posY, (float)player.posZ, 0F, 0F, 0F);
//	}
	
	@SubscribeEvent
	public void onRenderLiving(RenderLivingEvent.Pre event){
		if(event.entity instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer)event.entity;
			
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Miscellany.MODID + ":" + "textures/model/Veneer.png"));
			
			veneer.render(player, (float)player.posX, (float)player.posY, (float)player.posZ, 0F, 0F, 0F);
		}
	}
}


