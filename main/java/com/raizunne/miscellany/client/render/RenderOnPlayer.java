/**
Code made by Raizunne as a part of Raizunne's Miscellany  
Source code found at github.com/Raizunne
 */
package com.raizunne.miscellany.client.render;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderPlayerEvent;

import org.lwjgl.opengl.GL11;

import com.raizunne.miscellany.client.model.ModelShotgun;
import com.raizunne.miscellany.proxies.ClientProxy;

public class RenderOnPlayer {
	
	public static void renderForRaizunne(RenderPlayerEvent.Pre event){
		if(ClientProxy.authors.contains(event.entityPlayer.getCommandSenderName())){
			System.out.println(event.entityPlayer.getHideCape());
			if(event.entityPlayer.getHideCape()==false){
				if(!event.entityPlayer.isInvisible()){
					GL11.glPushMatrix();
					GL11.glRotatef(-(event.entityPlayer.renderYawOffset), 0, 1, 0);
					GL11.glRotatef(180, 1F, 0F, 0F);			
					GL11.glRotatef(90, 0, 0, 1);
					GL11.glRotatef(45, 0, 0, 1);
					GL11.glRotatef(180, 1, 0, 0);
					
					if(event.entityPlayer.isSprinting()){
		//				GL11.glTranslatef(0.0F, 0.0F, 0.0F);
		//				GL11.glRotatef(-30, 1, 0, 0);
					}
					if(event.entityPlayer.isSneaking()){
						GL11.glRotatef(-40, 1, 0, 0);
						GL11.glRotatef(20, 0, 1, 0);
						GL11.glTranslatef(0F, 0.00F, 0.25F);
						
					}
					GL11.glTranslatef(0.2F, -0.4F, -0.25F);
					Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("miscellany:textures/model/Shotgun.png"));
					
					new ModelShotgun().renderModel(0.0625F);
					GL11.glPopMatrix();
				}
			}
		}
		
	}

}

