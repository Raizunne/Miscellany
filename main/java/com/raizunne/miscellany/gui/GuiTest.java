package com.raizunne.miscellany.gui;

import net.minecraft.client.gui.GuiScreen;

public class GuiTest extends GuiScreen{
	
	@Override
	public void drawScreen(int x, int y, float z) {
		drawDefaultBackground();
		drawString(fontRendererObj, "TEST GUI", 300, 300, 0x404040);
		
		super.drawScreen(x, y, z);
	}
	
}
