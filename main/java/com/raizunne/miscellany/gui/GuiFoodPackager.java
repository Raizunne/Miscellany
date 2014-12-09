/**
Code made by Raizunne as a part of Raizunne's Miscellany  
Source code found at github.com/Raizunne
 */
package com.raizunne.miscellany.gui;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.opengl.GL11;

import com.raizunne.miscellany.MiscItems;
import com.raizunne.miscellany.Miscellany;
import com.raizunne.miscellany.gui.button.ButtonWidget;
import com.raizunne.miscellany.tileentities.TileEntityFoodPackager;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;

public class GuiFoodPackager extends GuiContainer{

	TileEntityFoodPackager packager; 
	String buttonText;
	EntityPlayer playerino;
	
	public GuiFoodPackager(InventoryPlayer invplayer, TileEntityFoodPackager te, EntityPlayer player) {
		super(new ContainerFoodPackager(invplayer, te));
		this.packager = te;
		this.playerino = player;
		xSize = 176;
		ySize = 166;
		buttonText="Start";
	}

	public static final ResourceLocation texture = new ResourceLocation("miscellany", "textures/gui/FoodPackagerGUI.png");
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float f,	int x, int y) {
		RenderHelper.disableStandardItemLighting();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    	GL11.glEnable(GL11.GL_BLEND);
		mc.renderEngine.bindTexture(texture);
//		System.out.println(packager.getEnergyStored(null));
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		drawTexturedModalRect(guiLeft+102, guiTop+33, 176, 14, this.packager.getScaledProgress(24), 17);
		drawTexturedModalRect(guiLeft+132, guiTop+32, 176, 31, this.packager.getConvertingScaledProgress(18), 18);
		drawTexturedModalRect(guiLeft+8, guiTop+8+51-packager.getPowerScaledProgress(51), 177, 51, 16, packager.getPowerScaledProgress(51));
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y) {
		int dispx;
		int posX = (width - 176) / 2;
		int posY = (height - 166) / 2;
		fontRendererObj.drawString("Food Packager", 55, 8, 0x404040);
		fontRendererObj.drawString("Calories", 120, 52, 0x404040);
		if(packager.calories()>=1000){
			dispx = 129;
		}else if(packager.calories()<10){
			dispx = 138;
		}else if(packager.calories()>=100){
			dispx = 132;
		}else if(packager.calories()>=10){
			dispx = 135;
		}else{
			dispx = 132;
		}
		
		fontRendererObj.drawString("" + packager.calories(), dispx, 62, 0x404040);
		mc.renderEngine.bindTexture(texture);
		RenderHelper.disableStandardItemLighting();
		if(x>posX+7 && x<posX+25 && y>posY+7 && y<posY+60){
			List list = new ArrayList<String>();
			list.add(""+packager.getEnergyStored(null)+" / "+packager.getMaxEnergyStored(null) + " RF");
			drawHoveringText(list, x-posX-5, y-posY, fontRendererObj);
		}
		if(x>posX-21 && x<posX && y>posY+10 && y<posY+30){
			List list = new ArrayList<String>();
			list.add("User Guide");
			drawHoveringText(list, x-posX-5, y-posY, fontRendererObj);
		}
		RenderHelper.enableGUIStandardItemLighting();
		
	}	
	
	@Override
	public void initGui() {
		super.initGui();
		ButtonWidget manual = new ButtonWidget(1, guiLeft -21 , guiTop + 10, "Manual", "left", 2, MiscItems.pamphlet, itemRender);
		buttonList.add(manual);
	}
	
	@Override
	protected void actionPerformed(GuiButton button) {
		super.actionPerformed(button);
		switch(button.id){
		case 1:
			FMLNetworkHandler.openGui(playerino, Miscellany.instance, 6, playerino.worldObj, (int)playerino.posX, (int)playerino.posY, (int)playerino.posZ);
		break;
		}
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}

}
