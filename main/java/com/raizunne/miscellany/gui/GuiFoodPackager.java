/**
Code made by Raizunne as a part of Raizunne's Miscellany  
Source code found at github.com/Raizunne
 */
package com.raizunne.miscellany.gui;

import java.util.ArrayList;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.raizunne.miscellany.Miscellany;
import com.raizunne.miscellany.gui.button.ButtonMenu;
import com.raizunne.miscellany.gui.button.ButtonNormal;
import com.raizunne.miscellany.tileentities.TileEntityFoodPackager;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.FMLNetworkEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
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
		GL11.glColor4f(1F, 1F, 1F, 1F);
		mc.renderEngine.bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		drawTexturedModalRect(guiLeft+102, guiTop+33, 176, 14, this.packager.getScaledProgress(24), 17);
		drawTexturedModalRect(guiLeft+132, guiTop+32, 176, 31, 18, this.packager.getConvertingScaledProgress(18));
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y) {
		int dispx;
		fontRendererObj.drawString("Food Packager", 55, 8, 0x404040);
		fontRendererObj.drawString("Calories", 120, 52, 0x404040);
		if(packager.calories()>1000){
			dispx = 130;
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
	}	
	
	@Override
	public void initGui() {
		super.initGui();
		ButtonNormal button = new ButtonNormal(0, guiLeft + 20, guiTop + 50, 90, 12, "HAEHRIEHIER", true);
		buttonList.add(button);
	}
	
	@Override
	protected void actionPerformed(GuiButton button) {
		super.actionPerformed(button);
		switch(button.id){
		case 0:
			playerino.playSound("miscellany:pageflip1", 1.0F, 1.0F);
			FMLNetworkHandler.openGui(playerino, Miscellany.instance, 6, playerino.worldObj, (int)playerino.posX, (int)playerino.posY, (int)playerino.posZ);
		break;
		}
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}

}
