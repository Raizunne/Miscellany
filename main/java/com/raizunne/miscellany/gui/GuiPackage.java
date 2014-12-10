package com.raizunne.miscellany.gui;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.raizunne.miscellany.MiscItems;
import com.raizunne.miscellany.gui.button.ButtonMenu;
import com.raizunne.miscellany.gui.button.ButtonWidget;
import com.raizunne.miscellany.tileentities.TileEntityPackage;

public class GuiPackage extends GuiContainer{

	private TileEntityPackage pack;
	boolean widget;
	int timer;
	
	public GuiPackage(InventoryPlayer invplayer, TileEntityPackage pack) {
		super(new ContainerPackage(invplayer, pack));
		this.pack = (TileEntityPackage) pack;
		xSize = 176;
		ySize = 166;
		timer = 0;
	}

	public static final ResourceLocation texture = new ResourceLocation("miscellany", "textures/gui/thepackage.png");
	public static final ResourceLocation widgete = new ResourceLocation("miscellany", "textures/gui/widgets.png");
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float f,	int x, int y) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		mc.renderEngine.bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		drawTexturedModalRect(guiLeft+103, guiTop+35, 176, 0, this.pack.getScaledProgress(23), 14);
		drawTexturedModalRect(guiLeft+8, guiTop+8+51-pack.getPowerScaled(51), 177, 51, 16, pack.getPowerScaled(51));
		if(widget){
			mc.renderEngine.bindTexture(widgete);
			if(timer!=100){
				timer+=10;
			}
			drawTexturedModalRect(guiLeft-100, guiTop+54, 0, 42, timer, timer);
		}
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y) {
		fontRendererObj.drawString("Packager", 70, 6, 0x404040);
		mc.renderEngine.bindTexture(texture);
		int posX = (width - 176) / 2;
		int posY = (height - 166) / 2;
		RenderHelper.disableStandardItemLighting();
		if(x>posX+7 && x<posX+25 && y>posY+7 && y<posY+60){
			List list = new ArrayList<String>();
			list.add(""+pack.getEnergyStored(null)+" / "+pack.getMaxEnergyStored(null) + " RF");
			drawHoveringText(list, x-posX-5, y-posY, fontRendererObj);
		}
		if(x>posX-21 && x<posX && y>posY+10 && y<posY+30){
			List list = new ArrayList<String>();
			list.add("User Guide");
			drawHoveringText(list, x-posX-5, y-posY, fontRendererObj);
		}
		if(x>posX-21 && x<posX && y>posY+32 && y<posY+52){
			List list = new ArrayList<String>();
			list.add("What is a Package?");
			drawHoveringText(list, x-posX-5, y-posY, fontRendererObj);
		}
		RenderHelper.enableGUIStandardItemLighting();
		
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
	@Override
	public void initGui() {
		super.initGui();
		ButtonWidget widget1 = new ButtonWidget(0, guiLeft-21, guiTop+10, "HEY", "left", 0, MiscItems.pamphlet, itemRender);
		ButtonWidget widget2 = new ButtonWidget(1, guiLeft -21 , guiTop + 32, "Manual", "left", 2, MiscItems.pack, itemRender);
		buttonList.add(widget1);
		buttonList.add(widget2);
	}
	
	@Override
	protected void actionPerformed(GuiButton button) {
		super.actionPerformed(button);
		switch(button.id){
		case 0:
//			this.pack.pack = true;
//			button.enabled = false;
			break;
		case 1:
			if(widget){
				widget=false;
				timer=0;
			}else{
				widget=true;
			}
		break;
		}
	}

}

