/**
Code made by Raizunne as a part of Raizunne's Miscellany  
Source code found at github.com/Raizunne
 */
package com.raizunne.miscellany.handler;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import com.raizunne.miscellany.MiscItems;
import com.raizunne.miscellany.proxies.ClientProxy;
import com.raizunne.miscellany.util.Config;

import cpw.mods.fml.common.FMLLog;

public class TextOnScreen {

	public static void init(RenderGameOverlayEvent event){ 
		Minecraft minecraft = Minecraft.getMinecraft();
		if(minecraft.thePlayer.inventory.getCurrentItem()!=null){
			ItemStack item = minecraft.thePlayer.inventory.getCurrentItem();
			EntityPlayer player = minecraft.thePlayer;
			
			//KNOWLEDGE GEM
			if(Config.gemText){
				if(item.isItemEqual(new ItemStack(MiscItems.knowledgegem))){
					ItemStack itemerino = minecraft.thePlayer.inventory.getCurrentItem();
					if (event.isCancelable() || event.type != ElementType.TEXT) {
			               return;          
			        }
					
					String level;
					String xp;
					if(minecraft.thePlayer.isPotionActive(MiscItems.knowledgePotion)){
						level = "§kGem Level";
						xp = "§k" + itemerino.stackTagCompound.getInteger("xp") + "/" + itemerino.stackTagCompound.getInteger("max"); 
					}else{
						level = "Gem Level";
						xp = "" + itemerino.stackTagCompound.getInteger("xp") + "/" + itemerino.stackTagCompound.getInteger("max"); 
					}
				if(ClientProxy.donors.contains(player.getDisplayName())){
					minecraft.fontRenderer.drawStringWithShadow("Donor! <3", (event.resolution.getScaledWidth()/2)+93, event.resolution.getScaledHeight() - 29, 0xFF0000);
				}
					minecraft.fontRenderer.drawStringWithShadow(level, (event.resolution.getScaledWidth()/2)+93, event.resolution.getScaledHeight() - 20, 0x33CC33);
					minecraft.fontRenderer.drawStringWithShadow(xp, (event.resolution.getScaledWidth()/2)+103, event.resolution.getScaledHeight() - 11, 0xCC00FF);
					return;
				}
			}
			
			//EXPLOSIVE CATALYST
			if(Config.explosiveText){
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
			}
			
			//THE FLUTE
			if(Config.fluteText){
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
}
