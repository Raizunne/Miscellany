package com.raizunne.miscellany.gui;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.raizunne.miscellany.gui.button.ButtonMenu;
import com.raizunne.miscellany.gui.button.ButtonWidget;
import com.raizunne.miscellany.gui.container.ContainerPresent;
import com.raizunne.miscellany.tileentities.TileEntityPresent;

public class GuiPresent extends GuiContainer{

	private TileEntityPresent present;
	boolean widget;
	int timer;
	
	public GuiPresent(InventoryPlayer invplayer, TileEntityPresent present) {
		super(new ContainerPresent(invplayer, present));
		this.present = (TileEntityPresent) present;
		xSize = 176;
		ySize = 166;
	}
	
	public static final ResourceLocation texture = new ResourceLocation("miscellany", "textures/gui/presentGUI.png");
	public static final ResourceLocation widgete = new ResourceLocation("miscellany", "textures/gui/widgets.png");
	GuiTextField textfield;
	boolean set;
		
	@Override
	protected void drawGuiContainerBackgroundLayer(float f,	int x, int y) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		mc.renderEngine.bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		if(widget){
			mc.renderEngine.bindTexture(widgete);
			if(timer!=100){
				timer+=10;
			}
			drawTexturedModalRect(guiLeft-100, guiTop+32, 0, 42, timer, timer);
		}
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y) {
		super.drawGuiContainerForegroundLayer(x, y);
		int posX = (width - 176) / 2;
		int posY = (height - 166) / 2;
		fontRendererObj.drawString("Present", 15, 6, 0x404040);
		fontRendererObj.drawString("From:", 22, 20, 0x404040);
		fontRendererObj.drawString("To:", 22, 36, 0x404040);
		fontRendererObj.drawString(present.getFrom(), 55, 20, 0x336699);
		if(present.getFor()!=null || set || present.getFor()!=""){
			fontRendererObj.drawString(present.getFor(), 40, 36, 0x009933);
		}
		
		if(widget){
			if(timer==100){
				fontRendererObj.drawString(EnumChatFormatting.BOLD + "Presents!", -93, 38, 0x00000, false);
				fontRendererObj.drawSplitString("To set the receiver of the present, rename a paper with the name of the receiver in an anvil and then right click the present with it.", -93, 47, 90, 0);
			}
		}
		if(present.getFor()=="" || present.getFor()==" " || present.getFor()==null){
			RenderHelper.disableStandardItemLighting();
			if(x>posX-21 && x<posX && y>posY+10 && y<posY+30){
				List list = new ArrayList<String>();
				list.add("Set receiver");
				drawHoveringText(list, x-posX-5, y-posY, fontRendererObj);
			}
			RenderHelper.enableGUIStandardItemLighting();
		}
		
	}
	
	@Override
	public void initGui() {
		super.initGui();
		ButtonWidget widget1 = new ButtonWidget(0, guiLeft-21, guiTop+10, "Receiver", "left", 0, Items.paper, itemRender);
		buttonList.add(widget1);
		if(present.getFor()!=""){
			buttonList.remove(widget1);
		}
    }
	
	@Override
	protected void actionPerformed(GuiButton button) {
		super.actionPerformed(button);
		switch(button.id){
		case 0:
			if(widget){
				widget=false;
			}else{
				widget=true;
				timer=0;
			}
		break;
		}
	}
}
