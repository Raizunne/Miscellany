/**
Code made by Raizunne as a part of Raizunne's Miscellany  
Source code found at github.com/Raizunne
 */
package com.raizunne.miscellany.client.render;

import java.util.ArrayList;
import java.util.Collection;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderPlayerEvent;

import org.lwjgl.opengl.GL11;

import scala.actors.threadpool.Arrays;

import com.raizunne.miscellany.client.model.ModelShotgun;
import com.raizunne.miscellany.proxies.ClientProxy;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RenderOnPlayer {
		
	public static void renderForRaizunne(RenderPlayerEvent.Specials.Pre event){
		if(event.entityPlayer.worldObj.isRemote){
//			System.out.println(ClientProxy.authors);
			if(ClientProxy.authors==null){
				try {
					ClientProxy.checkAuthors();
					System.out.println("<MISCELLANY> - Reloaded people to render.");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(ClientProxy.authors.contains(event.entityPlayer.getCommandSenderName())){
				if(event.entityPlayer.getHideCape()==false){
					if(!event.entityPlayer.isInvisible()){
						GL11.glPushMatrix();
//						GL11.glRotatef(-(event.entityPlayer.renderYawOffset), 0, 1, 0);
//						GL11.glRotatef(180, 1F, 0F, 0F);			
						GL11.glRotatef(90, 0, 0, 1);
						GL11.glRotatef(45, 0, 0, 1);
						GL11.glRotatef(180, 1, 0, 0);
						GL11.glTranslatef(0F, -0.2F, 0F);
						
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
			}else{
				return;
			}
		}
		
	}

}

