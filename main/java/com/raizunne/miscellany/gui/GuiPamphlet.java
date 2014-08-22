package com.raizunne.miscellany.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class GuiPamphlet extends GuiScreen{

	public static final ResourceLocation texture = new ResourceLocation("miscellany", "textures/gui/Panflet.png"); 
	public static final int xSizeofTexture = 153;
	public static final int ySizeofTexture = 177;
	
	@Override
	public void drawScreen(int x, int y, float z) {
		FontRenderer fontrenderer = Minecraft.getMinecraft().fontRenderer;
		RenderItem itemRenderer = new RenderItem();
//		drawDefaultBackground();
		GL11.glColor4f(1F, 1F, 1F, 1F);
		mc.renderEngine.bindTexture(texture);
		int posX = (width - xSizeofTexture) / 2;
		int posY = (height - ySizeofTexture) / 2;
		drawTexturedModalRect(posX, posY, 0, 0, xSizeofTexture, ySizeofTexture);
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		// TODO Auto-generated method stub
		return false;
	}
}
