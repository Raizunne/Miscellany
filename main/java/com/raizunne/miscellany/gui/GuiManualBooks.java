package com.raizunne.miscellany.gui;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.raizunne.miscellany.gui.button.buttonLeft;
import com.raizunne.miscellany.gui.button.buttonMenu;
import com.raizunne.miscellany.gui.button.buttonNormal;
import com.raizunne.miscellany.gui.button.buttonRight;

public class GuiManualBooks extends GuiScreen{
	
	public static final ResourceLocation texture = new ResourceLocation("miscellany", "textures/gui/bookTemplate.png");
	public static final ResourceLocation logoTexture = new ResourceLocation("miscellany", "textures/gui/bookResources1.png");
	
	public final int xSizeofTexture = 228;
	public final int ySizeofTexture = 166;
	
	public String currentSection;
	public int subSection;
	public boolean entry;
	

	
	public GuiManualBooks(){
		super();
		currentSection="index";
		subSection=1;
		entry=false;
	}
	
	public GuiManualBooks(EntityPlayer player){
		checkIfClient(player);
	}
	
	public boolean checkIfClient(EntityPlayer player){
		if(player.isClientWorld()){
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public void drawScreen(int x, int y, float f) {
		FontRenderer fontrenderer = Minecraft.getMinecraft().fontRenderer;
		RenderItem itemRenderer = new RenderItem();
		drawDefaultBackground();
		GL11.glColor4f(1F, 1F, 1F, 1F);
		mc.renderEngine.bindTexture(texture);
		int posX = (width - xSizeofTexture) / 2;
		int posY = (height - ySizeofTexture) / 2;
		drawTexturedModalRect(posX, posY, 0, 0, xSizeofTexture, ySizeofTexture);
		
		if(!entry){
		mc.renderEngine.bindTexture(logoTexture);
		drawTexturedModalRect(posX + 7, posY + 7, 0, 0, 99,84);
		fontrenderer.drawSplitString("Raizunne's Miscellany is still a very work in progress, the mod has a few items and other "
				+ "miscellaneous stuff in it." , posX+7, posY+90, 100, 0);
		}
		super.drawScreen(x, y, f);
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
	@Override
	public void initGui() {
		super.initGui();
		buttonList = new ArrayList();
		int posX = (width - xSizeofTexture) / 2;
		int posY = (height - ySizeofTexture) / 2;	
		System.out.println(currentSection);
		
		int color1 = 0xCC66FF;
		int color2 = 0xCC6699;
		
		buttonLeft prevButton = new buttonLeft(0, posX + 0, posY + 167, 18, 12, "Prev");
		buttonRight nextButton = new buttonRight(1, posX + 210, posY + 167, 18, 12, "Next");
		buttonNormal returnIndex = new buttonNormal(2, posX + 87, posY + 167, 50, 14, "Index");
		buttonMenu menu0 = new buttonMenu(3, posX + 124, posY + 18, 90, 12, "Items", color1, color2);
		buttonMenu menu1 = new buttonMenu(4, posX + 124, posY + 30, 90, 12, "Blocks", color1, color2);
		buttonMenu menu2 = new buttonMenu(5, posX + 124, posY + 42, 90, 12, "Machines", color1, color2);
		buttonMenu menu3 = new buttonMenu(6, posX + 124, posY + 54, 90, 12, "Equipment", color1, color2);
		buttonMenu menu4 = new buttonMenu(7, posX + 124, posY + 66, 90, 12, "Advanced Alchemy", color1, color2);

		buttonMenu items1 = new buttonMenu(8, posX + 124, posY + 18, 90, 12, "Sacred Chalice", color1, color2);
		
		buttonMenu blocks1 = new buttonMenu(9, posX + 124, posY + 18, 90, 12, "Present", color1, color2);
		
		buttonMenu machines1 = new buttonMenu(10, posX + 124, posY + 18, 90, 12, "Food Packager", color1, color2);
		
		buttonMenu equipment1 = new buttonMenu(11, posX + 124, posY + 18, 90, 12, "Redstonic JetBoots", color1, color2);
		
		buttonMenu alchemy1 = new buttonMenu(12, posX + 124, posY + 18, 90, 12, "Reactive Brewer", color1, color2);
		buttonMenu alchemy2 = new buttonMenu(13, posX + 124, posY + 30, 90, 12, "Knowledge Potion", color1, color2);
		
//		buttonList.add(menu0);
//		buttonList.add(menu1);
//		buttonList.add(menu2);
//		buttonList.add(menu3);
//		buttonList.add(menu4);
//		
		if(currentSection=="index"|| currentSection==null){
			buttonList.removeAll(buttonList);
			buttonList.add(menu0);
			buttonList.add(menu1);
			buttonList.add(menu2);
			buttonList.add(menu3);
			buttonList.add(menu4);
		}else if(entry){
			buttonList.removeAll(buttonList);
			buttonList.add(prevButton);
			buttonList.add(nextButton);
			buttonList.add(returnIndex);
		}
		
		if(currentSection=="items"){
			buttonList.removeAll(buttonList);
			buttonList.add(returnIndex);
			buttonList.add(items1);
		}else if(currentSection=="blocks"){
			buttonList.removeAll(buttonList);
			buttonList.add(returnIndex);
			buttonList.add(blocks1);
		}else if(currentSection=="machines"){
			buttonList.removeAll(buttonList);
			buttonList.add(returnIndex);
			buttonList.add(machines1);
		}else if(currentSection=="equipment"){
			buttonList.removeAll(buttonList);
			buttonList.add(returnIndex);
			buttonList.add(equipment1);
		}else if(currentSection=="alchemy"){
			buttonList.removeAll(buttonList);
			buttonList.add(returnIndex);
			buttonList.add(alchemy1);
			buttonList.add(alchemy2);
		}
		
	}
	
	@Override
	protected void actionPerformed(GuiButton button) {
		switch(button.id){
		case 0: 
			if(currentSection!="index"){
				subSection=+1;
			}
		break;
		case 1:
			if(currentSection!="index" && subSection!=0){
				subSection=-1;
			}
		break;
		case 2:
			currentSection="index";
			subSection=1;
			entry=false;
		break;
		case 3:
			currentSection="items";
			subSection=1;
		break;
		case 4:
			currentSection="blocks";
			subSection=1;
		break;
		case 5:
			currentSection="machines";
			subSection=1;
		break;
		case 6:
			currentSection="equipment";
			subSection=1;
		break;
		case 7:
			currentSection="alchemy";
			subSection=1;
		break;
		case 8:
			currentSection="sacredChalice";
			subSection=1;
			entry=true;
		break;
		case 9:
			
		break;	
		case 10:
			
		break;	
		case 11:
			
		break;	
		}
		initGui();
	}
}
