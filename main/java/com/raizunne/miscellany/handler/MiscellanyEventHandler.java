package com.raizunne.miscellany.handler;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

import com.raizunne.miscellany.MiscItems;
import com.raizunne.miscellany.Miscellany;

import cpw.mods.fml.common.eventhandler.Event;
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
			boolean equipped = false;
			ItemStack boots = player.inventory.armorInventory[0];
			if(boots!=null){
				if(boots.getItem() == MiscItems.redstonicBoots){	
					player.stepHeight = 1;
					player.capabilities.setPlayerWalkSpeed(0.15F);
					player.jumpMovementFactor = 0.05F;
					equipped=true;	
				}
			}
			if(equipped==true && boots.getItem()!=MiscItems.redstonicBoots){
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
		if(!player.getEntityData().getBoolean("hasPamphlet")){
			if(!player.worldObj.isRemote){
				player.inventory.addItemStackToInventory(new ItemStack(MiscItems.pamphlet));
				player.getEntityData().setBoolean("hasPamphlet", true);
				player.addChatComponentMessage(new ChatComponentText("Miscellany welcomes you to a new world of Minecraft"));
				player.addChatComponentMessage(new ChatComponentText("Have a nice stay."));
			}			
		}else{
			player.addChatComponentMessage(new ChatComponentText("Welcome Back!"));
		}
		player.addChatComponentMessage(new ChatComponentText("Welcome Back!"));
	}
	
	@SubscribeEvent
	public void render(RenderGameOverlayEvent event){
		Minecraft minecraft = Minecraft.getMinecraft();
		if(minecraft.thePlayer.inventory.getCurrentItem()!=null){
			ItemStack item = minecraft.thePlayer.inventory.getCurrentItem();
			//KNOWLEDGE GEM
			if(item.isItemEqual(new ItemStack(MiscItems.knowledgegem))){
				ItemStack itemerino = minecraft.thePlayer.inventory.getCurrentItem();
				if (event.isCancelable() || event.type != ElementType.TEXT) {
		               return;          
		        }
				
				String level;
				String xp;
				if(minecraft.thePlayer.isPotionActive(MiscItems.knowledgePotion)){
					level = "§kGem Level";
					xp = "§k" + itemerino.stackTagCompound.getInteger("xp"); 
				}else{
					level = "Gem Level";
					xp = "" + itemerino.stackTagCompound.getInteger("xp"); 
				}
				
				minecraft.fontRenderer.drawStringWithShadow(level, (event.resolution.getScaledWidth()/2)+93, event.resolution.getScaledHeight() - 20, 0x33CC33);
				minecraft.fontRenderer.drawStringWithShadow(xp, (event.resolution.getScaledWidth()/2)+112, event.resolution.getScaledHeight() - 11, 0xCC00FF);
				return;
			}
			//EXPLOSIVE CATALYST
			if(item.stackTagCompound!=null && item.stackTagCompound.getBoolean("isthistheexplosivecatalyst")){
				ItemStack itemerino = minecraft.thePlayer.inventory.getCurrentItem();
				if (event.isCancelable() || event.type != ElementType.TEXT) {
		               return;          
		        }
				if(!item.stackTagCompound.getBoolean("enabled")){
					minecraft.fontRenderer.drawStringWithShadow("CATALYST ENABLED - CAREFUL", (event.resolution.getScaledWidth()/2)-75, event.resolution.getScaledHeight() -50, 0xFF3300);
				}
				minecraft.fontRenderer.drawStringWithShadow("Expl. Left", (event.resolution.getScaledWidth()/2)+93, event.resolution.getScaledHeight() - 20, 0xFF3300);
				if(!itemerino.stackTagCompound.getBoolean("creative")){
					minecraft.fontRenderer.drawStringWithShadow("" + itemerino.stackTagCompound.getInteger("uses"), (event.resolution.getScaledWidth()/2)+115, event.resolution.getScaledHeight() - 11, 0xCC00FF);
				}else{
					minecraft.fontRenderer.drawStringWithShadow("CREATIVE", (event.resolution.getScaledWidth()/2)+112, event.resolution.getScaledHeight() - 11, 0xCC00FF);
				}
				return;
			}
			//THE FLUTE
			if(item.isItemEqual(new ItemStack(MiscItems.theflute))){
				ItemStack itemerino = minecraft.thePlayer.inventory.getCurrentItem();
				if (event.isCancelable() || event.type != ElementType.TEXT) {
		               return;          
		        }
				minecraft.fontRenderer.drawStringWithShadow("Flute Mode", (event.resolution.getScaledWidth()/2)+93, event.resolution.getScaledHeight() - 20, 0x33CC33);
				minecraft.fontRenderer.drawStringWithShadow(itemerino.stackTagCompound.getString("mode"), (event.resolution.getScaledWidth()/2)+98, event.resolution.getScaledHeight() - 11, 0xCC00FF);
				return;
			}
		}
	}
}


