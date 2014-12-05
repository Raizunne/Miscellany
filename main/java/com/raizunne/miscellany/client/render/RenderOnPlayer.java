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
		if(ClientProxy.donors.contains(event.entityPlayer.getCommandSenderName())){
			GL11.glPushMatrix();
			GL11.glRotatef(180, 1F, 0F, 0F);
			GL11.glRotatef(45, 1F, 0F, 0F);
			GL11.glRotatef((event.entityPlayer.renderYawOffset), 0, 1, 0);
			if(event.entityPlayer.isSprinting()){
				GL11.glTranslatef(0F, 0.1F, -0.1F);
				GL11.glRotatef(30, 1, 0, 0);
			}
			if(event.entityPlayer.isSneaking()){
				GL11.glRotatef(30, 1, 0, 0);
				GL11.glTranslatef(0F, 0.00F, -0.18F);
				
			}
			GL11.glTranslatef(0F, 0.2F, 0.15F);
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("miscellany:textures/model/Shotgun.png"));
			new ModelShotgun().renderModel(0.0625F);
			GL11.glPopMatrix();
		}
		
	}

}
