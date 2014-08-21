package com.raizunne.miscellany.gui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.raizunne.miscellany.Miscellany;
import com.raizunne.miscellany.gui.button.buttonLeft;
import com.raizunne.miscellany.gui.button.buttonMenu;
import com.raizunne.miscellany.gui.button.buttonNormal;
import com.raizunne.miscellany.gui.button.buttonRight;
import com.raizunne.miscellany.util.bookResources;

public class GuiManualBooks extends GuiScreen{
	
	public static final ResourceLocation texture = new ResourceLocation("miscellany", "textures/gui/bookTemplate.png");
	public static final ResourceLocation resources1 = new ResourceLocation("miscellany", "textures/gui/bookResources1.png");
	public static final ResourceLocation craftingGrid = new ResourceLocation ("miscellany", "textures/gui/craftingGrid.png");
	
	public final int xSizeofTexture = 228;
	public final int ySizeofTexture = 166;
	
	public String currentSection;
	public int subSection;
	public boolean entry;
	public int maxPages;
	

	
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
		
//		drawCrafting(Item slot1, Item slot2, Item slot3, Item slot4, Item slot5, Item slot6, Item slot7, Item slot8,
//				Item slot9, Item product, int xPos, int yPos, int mousex, int mousey)
		
		if(!entry){
		mc.renderEngine.bindTexture(resources1);
		drawTexturedModalRect(posX + 7, posY + 7, 0, 0, 99,84);
		fontrenderer.drawSplitString("Raizunne's Miscellany is still a very work in progress, the mod has a few items and other "
				+ "miscellaneous stuff in it." , posX+7, posY+90, 100, 0);
		}
		
		if(entry && currentSection=="sacredChalice" && subSection==0){
			fontrenderer.drawString("Sacred Chalice", posX + 10, posY + 8, 0x000000, false);
			fontrenderer.drawSplitString(bookResources.chalice1, posX + 10, posY + 80, 98, 0);
			fontrenderer.drawSplitString(bookResources.chalice2, posX + 121, posY + 17, 98, 0);
			Item goldBlock = Blocks.gold_block.getItemDropped(Blocks.gold_block.getIdFromBlock(Blocks.gold_block), new Random(), 1);
			drawCrafting(Items.gold_ingot, Items.water_bucket, Items.gold_ingot, null, Items.gold_ingot, null, goldBlock, goldBlock, goldBlock, Miscellany.sacredChalice, 20, 20, x, y);
			
		}
		
		super.drawScreen(x, y, f);
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
	@Override
	public void initGui() {
		buttonList = new ArrayList();
		int posX = (width - xSizeofTexture) / 2;
		int posY = (height - ySizeofTexture) / 2;	
//		System.out.println(currentSection);
		
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
		buttonMenu alchemy3 = new buttonMenu(14, posX + 124, posY + 42, 90, 12, "Flight Potion", color1, color2);
			
		if(currentSection=="index"|| currentSection==null || currentSection=="0"){
			buttonList.removeAll(buttonList);
			buttonList.add(menu0);
//			buttonList.add(menu1);
//			buttonList.add(menu2);
//			buttonList.add(menu3);
//			buttonList.add(menu4);
		}else if(entry){
			buttonList.removeAll(buttonList);
			if(maxPages!=subSection){
				buttonList.add(nextButton);
			}
			if(maxPages != 0){
				buttonList.add(prevButton);
			}
			buttonList.add(returnIndex);
		}else if(!entry&&currentSection=="index"&&currentSection==null || currentSection=="0"){
			buttonList.remove(returnIndex);
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
			buttonList.add(alchemy3);
		}
	}
		
	@Override
	protected void actionPerformed(GuiButton button) {
		switch(button.id){
		case 0: 
			if(currentSection!="index" && maxPages!=subSection){
				subSection=-1;
			}
		break;
		case 1:
			if(currentSection!="index" && subSection!=0){
				subSection=+1;
			}
		break;
		case 2:
			currentSection="index";
			subSection=0;
			entry=false;
		break;
		case 3:
			currentSection="items";
			subSection=0;
			entry=false;
		break;
		case 4:
			currentSection="blocks";
			subSection=0;
			entry=false;
		break;
		case 5:
			currentSection="machines";
			subSection=0;
			entry=false;
		break;
		case 6:
			currentSection="equipment";
			subSection=0;
			entry=false;
		break;
		case 7:
			currentSection="alchemy";
			subSection=0;
			entry=false;
		break;
		case 8:
			currentSection="sacredChalice";
			subSection=0;
			entry=true;
			maxPages=0;
		break;
		case 9:
			
		break;	
		case 10:
			
		break;	
		case 11:
			
		break;	
		
		}
		
	}
	@Override
		protected void mouseClicked(int x, int y, int mouseId) {
			super.mouseClicked(x, y, mouseId);
			this.initGui();
		}
	
	
	
	
	public void drawCrafting(Item slot1, Item slot2, Item slot3, Item slot4, Item slot5, Item slot6, Item slot7, Item slot8,
			Item slot9, Item product, int xPos, int yPos, int mousex, int mousey){
		FontRenderer itemsInGrid = Minecraft.getMinecraft().fontRenderer;
		RenderHelper.disableStandardItemLighting();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    	GL11.glEnable(GL11.GL_BLEND);
		int posX = (this.width - xSizeofTexture) / 2;
		int posY = (this.height - ySizeofTexture) / 2;
		int xPosCrafting = posX + yPos;
		int yPosCrafting = posY + xPos;
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(craftingGrid);
		drawTexturedModalRect(xPosCrafting, yPosCrafting, 0, 0, 76, 56);		
		
		if(slot1!=null){
			RenderHelper.disableStandardItemLighting();
			itemRender.renderItemAndEffectIntoGUI(itemsInGrid, Minecraft.getMinecraft().getTextureManager(), 
					new ItemStack(slot1), xPosCrafting + 1, yPosCrafting + 1);	
		}
		if(slot2!=null){
			RenderHelper.disableStandardItemLighting();
			itemRender.renderItemAndEffectIntoGUI(itemsInGrid, Minecraft.getMinecraft().getTextureManager(), 
					new ItemStack(slot2), xPosCrafting + 20, yPosCrafting + 1);	
		}
		if(slot3!=null){
			RenderHelper.disableStandardItemLighting();
			itemRender.renderItemAndEffectIntoGUI(itemsInGrid, Minecraft.getMinecraft().getTextureManager(), 
					new ItemStack(slot3), xPosCrafting + 39, yPosCrafting + 1);	
		}
		if(slot4!=null){
			RenderHelper.disableStandardItemLighting();
			itemRender.renderItemAndEffectIntoGUI(itemsInGrid, Minecraft.getMinecraft().getTextureManager(), 
					new ItemStack(slot4), xPosCrafting + 1, yPosCrafting + 20);	
		}
		if(slot5!=null){
			RenderHelper.disableStandardItemLighting();
			itemRender.renderItemAndEffectIntoGUI(itemsInGrid, Minecraft.getMinecraft().getTextureManager(), 
					new ItemStack(slot5), xPosCrafting + 20, yPosCrafting + 20);	
		}
		if(slot6!=null){
			RenderHelper.disableStandardItemLighting();
			itemRender.renderItemAndEffectIntoGUI(itemsInGrid, Minecraft.getMinecraft().getTextureManager(), 
					new ItemStack(slot6), xPosCrafting + 39, yPosCrafting + 20);	
		}
		if(slot7!=null){
			RenderHelper.disableStandardItemLighting();
			itemRender.renderItemAndEffectIntoGUI(itemsInGrid, Minecraft.getMinecraft().getTextureManager(), 
					new ItemStack(slot7), xPosCrafting + 1, yPosCrafting + 39);	
		}
		if(slot8!=null){
			RenderHelper.disableStandardItemLighting();
			itemRender.renderItemAndEffectIntoGUI(itemsInGrid, Minecraft.getMinecraft().getTextureManager(), 
					new ItemStack(slot8), xPosCrafting + 20, yPosCrafting + 39);	
		}
		if(slot9!=null){
			RenderHelper.disableStandardItemLighting();
			itemRender.renderItemAndEffectIntoGUI(itemsInGrid, Minecraft.getMinecraft().getTextureManager(), 
					new ItemStack(slot9), xPosCrafting + 39, yPosCrafting + 39);	
		}	
		
		RenderHelper.disableStandardItemLighting();
			itemRender.renderItemAndEffectIntoGUI(itemsInGrid, Minecraft.getMinecraft().getTextureManager(), 
					new ItemStack(product), xPosCrafting + 59, yPosCrafting + 8);
			RenderHelper.disableStandardItemLighting();
		
		if(slot1!=null){
			if(mousex>xPosCrafting+2 && mousex<xPosCrafting+16 && mousey>yPosCrafting+2 && mousey<yPosCrafting+16){
				renderToolTip(new ItemStack(slot1), mousex, mousey);
			}
		}
		if(slot2!=null){
			if(mousex>xPosCrafting+21 && mousex<xPosCrafting+35 && mousey>yPosCrafting+2 && mousey<yPosCrafting+16){
				renderToolTip(new ItemStack(slot2), mousex, mousey);
			}
		}
		if(slot3!=null){
			if(mousex>xPosCrafting+40 && mousex<xPosCrafting+54 && mousey>yPosCrafting+2 && mousey<yPosCrafting+16){
				renderToolTip(new ItemStack(slot3), mousex, mousey);
			}
		}
		if(slot4!=null){
			if(mousex>xPosCrafting+2 && mousex<xPosCrafting+16 && mousey>yPosCrafting+21 && mousey<yPosCrafting+35){
				renderToolTip(new ItemStack(slot4), mousex, mousey);
			}
		}
		if(slot5!=null){
			if(mousex>xPosCrafting+21 && mousex<xPosCrafting+35 && mousey>yPosCrafting+21 && mousey<yPosCrafting+35){
				renderToolTip(new ItemStack(slot5), mousex, mousey);
			}
		}
		if(slot6!=null){
			if(mousex>xPosCrafting+40 && mousex<xPosCrafting+54 && mousey>yPosCrafting+21 && mousey<yPosCrafting+35){
				renderToolTip(new ItemStack(slot6), mousex, mousey);
			}
		}
		if(slot7!=null){
			if(mousex>xPosCrafting+2 && mousex<xPosCrafting+16 && mousey>yPosCrafting+40 && mousey<yPosCrafting+54){
				renderToolTip(new ItemStack(slot7), mousex, mousey);
				
			}
		}
		if(slot8!=null){
			if(mousex>xPosCrafting+21 && mousex<xPosCrafting+35 && mousey>yPosCrafting+40 && mousey<yPosCrafting+54){
				renderToolTip(new ItemStack(slot8), mousex, mousey);
			}
		}
		if(slot9!=null){
			if(mousex>xPosCrafting+40 && mousex<xPosCrafting+54 && mousey>yPosCrafting+40 && mousey<yPosCrafting+54){
				renderToolTip(new ItemStack(slot9), mousex, mousey);
			}
		}	
		
		if(mousex>xPosCrafting+58 && mousex<xPosCrafting+67 && mousey>yPosCrafting+38 && mousey<yPosCrafting+42 
				|| mousex>xPosCrafting+63 && mousex<xPosCrafting+69 && mousey>yPosCrafting+33 && mousey<yPosCrafting+68
				|| mousex>xPosCrafting+62 && mousex<xPosCrafting+72 && mousey>yPosCrafting+26 && mousey<yPosCrafting+33){
			String[] desc = { "Produces" };
            @SuppressWarnings("rawtypes")
            List temp = Arrays.asList(desc);
            drawHoveringText(temp, mousex, mousey, itemsInGrid);
		}
			RenderHelper.disableStandardItemLighting();
			GL11.glEnable(GL11.GL_DEPTH_TEST);
		if(mousex>xPosCrafting+60 && mousex<xPosCrafting+74 && mousey>yPosCrafting+9 && mousey<yPosCrafting+23){
			renderToolTip(new ItemStack(product), mousex, mousey);
			GL11.glDisable(GL11.GL_DEPTH_TEST);
			GL11.glDisable(GL11.GL_LIGHTING);
		}
	}
	
}
