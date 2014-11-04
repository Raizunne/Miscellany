package com.raizunne.miscellany.gui.hud;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiIngame;
import net.minecraftforge.client.GuiIngameForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class KnowledgeGemHUD extends Gui{
	private Minecraft minecraft;
	
	public KnowledgeGemHUD(Minecraft minecraft){
		super();
		this.minecraft = minecraft;
	}
	
	@SubscribeEvent
    public void renderScreen(RenderGameOverlayEvent.Post event) {
          if (event.isCancelable() || event.type != ElementType.TEXT) {
               return;          
         }
         
         render(minecraft);
    }

    public void render(Minecraft minecraft) {
         minecraft.fontRenderer.drawString("Hey", 20, 20, 0x404040);
    }
}
