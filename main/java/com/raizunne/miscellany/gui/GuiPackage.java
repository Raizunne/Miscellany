package com.raizunne.miscellany.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.raizunne.miscellany.gui.button.buttonMenu;
import com.raizunne.miscellany.tileentities.TileEntityPackage;

public class GuiPackage extends GuiContainer{

	private TileEntityPackage pack;
	
	public GuiPackage(InventoryPlayer invplayer, TileEntityPackage pack) {
		super(new ContainerPackage(invplayer, pack));
		this.pack = (TileEntityPackage) pack;
		xSize = 176;
		ySize = 166;
	}

	public static final ResourceLocation texture = new ResourceLocation("miscellany", "textures/gui/thepackage.png");
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float f,	int x, int y) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		mc.renderEngine.bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y) {
		fontRendererObj.drawString("Packager", 70, 6, 0x404040);
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
	@Override
	public void initGui() {
		super.initGui();

		GuiButton ready = new buttonMenu(0, guiLeft + 133, guiTop + 53, 44, 14, "Pack", 0xFFFFFF, 0x999999, false);
		buttonList.add(ready);
		
		
	}
	
	@Override
	protected void mouseClicked(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
		// TODO Auto-generated method stub
		super.mouseClicked(p_73864_1_, p_73864_2_, p_73864_3_);
		initGui();
	}
	
	@Override
	protected void actionPerformed(GuiButton button) {
		switch(button.id){
		case 0:
			this.pack.pack = true;
			button.enabled = false;
			break;
		
		}
	}

}
