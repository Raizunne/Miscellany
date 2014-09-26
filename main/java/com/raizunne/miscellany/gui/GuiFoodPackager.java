package com.raizunne.miscellany.gui;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.raizunne.miscellany.gui.button.widgetRight;
import com.raizunne.miscellany.tileentities.TileEntityFoodPackager;

public class GuiFoodPackager extends GuiContainer{

	public GuiFoodPackager(InventoryPlayer invplayer, TileEntityFoodPackager foodpackager) {
		super(new ContainerFoodPackager(invplayer, foodpackager));
		xSize = 176;
		ySize = 166;
	}

	public static final ResourceLocation texture = new ResourceLocation("miscellany", "textures/gui/foodPackagerGUI.png");	
	
	@Override
	public void drawGuiContainerBackgroundLayer(float f, int x, int y){
		FontRenderer fontrenderer = Minecraft.getMinecraft().fontRenderer;
		GL11.glColor4f(1F, 1F, 1F, 1F);		
		mc.renderEngine.bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}
	
	public void drawGuiContainerForegroundLayer(int x, int y){
		FontRenderer fontrenderer = Minecraft.getMinecraft().fontRenderer;
		fontrenderer.drawString("Food Packager", 54, 8, 0x282828, false);
	}
	
	public void initGui(){
		super.initGui();
		buttonList.clear();
		widgetRight widget1 = new widgetRight(0, guiLeft + 176, guiTop + 6, "Tier 1");
		buttonList.add(widget1);
	}
	
	public void actionPerformed(GuiButton button){
		switch(button.id){
		case 0: 
			System.out.println("BUTTON PRESSED");
			
		}
		initGui();
	}
	
}
