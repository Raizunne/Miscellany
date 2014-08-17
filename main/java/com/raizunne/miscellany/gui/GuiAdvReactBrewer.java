package com.raizunne.miscellany.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.raizunne.miscellany.tileentities.TileEntityAdvReactBrewer;

public class GuiAdvReactBrewer extends GuiContainer{

	public GuiAdvReactBrewer(InventoryPlayer invplayer, TileEntityAdvReactBrewer advbrewer) {
		super(new ContainerAdvReactBrewer(invplayer, advbrewer));
		xSize = 177;
		ySize = 218;
	}

	public static final ResourceLocation texture = new ResourceLocation("miscellany", "textures/gui/brewerGUI.png");
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float f,	int x, int y) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		mc.renderEngine.bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y) {
		fontRendererObj.drawString("Advanced Reactive Brewer", 22, 6, 0x404040);
	}

}
