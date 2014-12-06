/**
Code made by Raizunne as a part of Raizunne's Miscellany  
Source code found at github.com/Raizunne
 */
package com.raizunne.miscellany.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.raizunne.miscellany.gui.button.buttonMenu;
import com.raizunne.miscellany.gui.button.buttonNormal;
import com.raizunne.miscellany.tileentities.TileEntityFoodPackager;

public class GuiFoodPackager extends GuiContainer{

	TileEntityFoodPackager packager; 
	String buttonText;
	
	public GuiFoodPackager(InventoryPlayer invplayer, TileEntityFoodPackager te) {
		super(new ContainerFoodPackager(invplayer, te));
		this.packager = te;
		xSize = 176;
		ySize = 166;
		buttonText="Start";
	}

	public static final ResourceLocation texture = new ResourceLocation("miscellany", "textures/gui/FoodPackagerGUI.png");
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float f,	int x, int y) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		mc.renderEngine.bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
//		drawTexturedModalRect(guiLeft+70, guiTop+32, 176, 0, 36, this.packager.getScaledProgress(27));
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y) {
		fontRendererObj.drawString("Food Packager", 55, 8, 0x404040);
		mc.renderEngine.bindTexture(texture);
	}	
	
	@Override
	public void initGui() {
		buttonMenu start = new buttonMenu(0, guiLeft+50, guiTop+50, 80, 12, "buttonText", 0x404040, 0x333333, false);
		buttonList.add(start);
		super.initGui();
	}
	
	@Override
	protected void actionPerformed(GuiButton button) {
		super.actionPerformed(button);
		System.out.println(packager.status());
		switch(button.id){
		case 0:
			if(!packager.status()){
				packager.startPacking();
				buttonText="Stop";
			}else{
				packager.stopPackaging();
				buttonText="Start";
			}
		break;
		}
	}

}
