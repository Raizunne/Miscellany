package com.raizunne.miscellany.gui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
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
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.raizunne.miscellany.MiscBlocks;
import com.raizunne.miscellany.MiscItems;
import com.raizunne.miscellany.Miscellany;
import com.raizunne.miscellany.gui.button.ButtonLeft;
import com.raizunne.miscellany.gui.button.ButtonMenu;
import com.raizunne.miscellany.gui.button.ButtonNormal;
import com.raizunne.miscellany.gui.button.ButtonRight;
import com.raizunne.miscellany.gui.button.ButtonWidget;
import com.raizunne.miscellany.util.BookResources;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;

public class GuiManualBooks extends GuiScreen{
	
	public static final ResourceLocation texture = new ResourceLocation("miscellany", "textures/gui/bookTemplate.png");
	public static final ResourceLocation resources1 = new ResourceLocation("miscellany", "textures/gui/bookResources1.png");
	public static final ResourceLocation craftingGrid = new ResourceLocation ("miscellany", "textures/gui/craftingGrid.png");
	
	public final int xSizeofTexture = 228;
	public final int ySizeofTexture = 166;
	public EntityPlayer player;
	
	public String currentSection;
	public int subSection;
	public boolean entry;
	public int maxPages;
	public String prevSection;
	public boolean brew;
	
	public GuiManualBooks(){
		super();
		currentSection="index";
		subSection=1;
		entry=false;
	}
	
	public GuiManualBooks(EntityPlayer player){
		checkIfClient(player);
		this.player = player;
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
		
		if(!entry || currentSection=="index" || currentSection=="items" || currentSection=="machines" || currentSection=="alchemy" ||
				currentSection=="Blocks" || currentSection=="equipment"){
		mc.renderEngine.bindTexture(resources1);
		drawTexturedModalRect(posX + 7, posY + 7, 0, 0, 99,84);
		fontrenderer.drawSplitString("Raizunne's Miscellany is still a very work in progress, the mod has a few items and other "
				+ "miscellaneous stuff in it." , posX+7, posY+90, 100, 0);
		}
				
		if(entry && currentSection=="sacredChalice" && subSection==0){
			//CHALICE
			fontrenderer.drawString("Sacred Chalice", posX + 10, posY + 8, 0x000000, false);
			fontrenderer.drawSplitString(BookResources.chalice1, posX + 10, posY + 80, 98, 0);
			fontrenderer.drawSplitString(BookResources.chalice2, posX + 121, posY + 17, 98, 0);
			drawCrafting(Items.gold_ingot, Items.water_bucket, Items.gold_ingot, null, Blocks.gold_block, null, Items.gold_ingot, Items.gold_ingot, Items.gold_ingot, MiscItems.sacredChalice, 20, 20, x, y);	
		}else if(entry && currentSection=="shake" && subSection==0){
			//SHAKE
			fontrenderer.drawString("Flight Flask", posX + 10, posY + 8, 0x000000, false);
			fontrenderer.drawSplitString(BookResources.shake1, posX + 10, posY + 93, 98, 0);
			fontrenderer.drawSplitString(BookResources.shake2, posX + 121, posY + 17, 98, 0);
			drawAlchemy(Items.speckled_melon, Items.bread, Items.sugar, MiscItems.potionFlask, MiscItems.Shake, 20, 20, x, y);
		}else if(entry && currentSection=="brewer" && subSection==0){
			//BREWER
			fontrenderer.drawString("Reactive Brewer", posX + 10, posY + 8, 0x000000, false);
			fontrenderer.drawSplitString(BookResources.brewer1, posX + 10, posY + 80, 98, 0);
			fontrenderer.drawSplitString(BookResources.brewer2, posX + 121, posY + 17, 98, 0);
			drawCrafting(Blocks.stone_slab, Blocks.stone_slab, Blocks.stone_slab, null, Blocks.hardened_clay, null, Blocks.hardened_clay, Blocks.hardened_clay, Blocks.hardened_clay, MiscBlocks.brewer, 20, 20, x, y);
		}else if(entry && currentSection=="knowledge" && subSection==0){
			//KNOWLEDGE
			fontrenderer.drawString("Knowledge Flask", posX + 10, posY + 8, 0x000000, false);
			fontrenderer.drawSplitString(BookResources.knowledge1, posX + 10, posY + 93, 98, 0);
			fontrenderer.drawSplitString(BookResources.knowledge2, posX + 121, posY + 17, 98, 0);
			drawAlchemy(Blocks.emerald_block, Items.book, Blocks.emerald_block, MiscItems.potionFlask, MiscItems.knowledgeFlask, 20, 20, x, y);
		}else if(entry && currentSection=="flight" && subSection==0){
			//FLIGHT
			fontrenderer.drawString("Flight Flask", posX + 10, posY + 8, 0x000000, false);
			fontrenderer.drawSplitString(BookResources.flight1, posX + 10, posY + 93, 98, 0);
			fontrenderer.drawSplitString(BookResources.flight2, posX + 121, posY + 17, 98, 0);
			drawAlchemy(Items.diamond, Items.feather, Items.diamond, MiscItems.potionFlask, MiscItems.flightFlask, 20, 20, x, y);
		}else if(entry && currentSection=="anit-wither" && subSection==0){
			//ANTIWITHER
			fontrenderer.drawString("Anti-Wither Flask", posX + 10, posY + 8, 0x000000, false);
			fontrenderer.drawSplitString(BookResources.wither1, posX + 10, posY + 93, 98, 0);
			fontrenderer.drawSplitString(BookResources.wither2, posX + 121, posY + 17, 98, 0);
			drawAlchemy(Items.diamond, Items.skull, Blocks.red_flower, MiscItems.potionFlask, MiscItems.WitherAnti, 20, 20, x, y);
		}else if(entry && currentSection=="heart" && subSection==0){
			//Heart Flask
			fontrenderer.drawString("Heart Flask", posX + 10, posY + 8, 0x000000, false);
			fontrenderer.drawSplitString(BookResources.heart1, posX + 10, posY + 93, 98, 0);
			fontrenderer.drawSplitString(BookResources.heart2, posX + 121, posY + 17, 98, 0);
			drawAlchemy(Items.speckled_melon, Items.blaze_powder, Items.speckled_melon, MiscItems.potionFlask, MiscItems.theheart, 20, 20, x, y);
		}else if(entry && currentSection=="gem" && subSection==0){
			//KNOWLEDGE GEM
			fontrenderer.drawString("Knowledge Gem", posX + 10, posY + 8, 0x000000, false);
			fontrenderer.drawSplitString(BookResources.gem1, posX + 10, posY + 80, 98, 0);
			fontrenderer.drawSplitString(BookResources.gem2, posX + 121, posY + 17, 98, 0);
			fontrenderer.drawSplitString(BookResources.gem3, posX + 121, posY + 105, 98, 0);
			drawCrafting(null, Items.emerald, null, Items.emerald, Items.diamond, Items.emerald, null, Items.emerald, null, MiscItems.knowledgegem, 20, 20, x, y);	
		}else if(entry && currentSection=="gem" && subSection==1){
			//KNOWLEDGE GEM PAGE 2
			fontrenderer.drawString("Knowledge Gem", posX + 10, posY + 8, 0x000000, false);
			fontrenderer.drawSplitString(EnumChatFormatting.DARK_PURPLE + "Upgrades", posX + 10, posY + 80, 98, 0);
			fontrenderer.drawSplitString(BookResources.gemLevel1, posX + 10, posY + 92, 98, 0);
			fontrenderer.drawSplitString(BookResources.gemLevel2, posX + 121, posY + 17, 98, 0);
			fontrenderer.drawSplitString(BookResources.gemLevel3, posX + 121, posY + 95, 98, 0);
			drawCrafting(null, Items.emerald, null, Items.emerald, MiscItems.knowledgegem, Items.emerald, null, Items.emerald, null, MiscItems.knowledgegem, 20, 20, x, y);	
		}else if(entry && currentSection=="foodpackager" && subSection==0){
			fontrenderer.drawString("Food Packager", posX + 10, posY + 8, 0x000000, false);
			fontrenderer.drawSplitString(BookResources.foodpackager1, posX + 10, posY + 80, 98, 0);
			fontrenderer.drawSplitString(BookResources.foodpackager2, posX + 121, posY + 17, 98, 0);
			drawCrafting(Items.iron_ingot, Items.iron_ingot, Items.iron_ingot, Items.iron_ingot, Blocks.furnace, Items.iron_ingot, Blocks.cobblestone, Blocks.cobblestone, Blocks.cobblestone, MiscBlocks.packager, 20, 20, x, y);	
		}else if(entry && currentSection=="packager" && subSection==0){
			fontrenderer.drawString("Packager", posX + 10, posY + 8, 0x000000, false);
			fontrenderer.drawSplitString(BookResources.packager1, posX + 10, posY + 80, 98, 0);
			fontrenderer.drawSplitString(BookResources.packager2, posX + 121, posY + 17, 98, 0);
			drawCrafting(Items.iron_ingot, Items.iron_ingot, Items.iron_ingot, Items.iron_ingot, Blocks.chest, Items.iron_ingot, Items.iron_ingot, Blocks.iron_block, Items.iron_ingot, MiscBlocks.packager, 20, 20, x, y);	
		}else if(entry && currentSection=="packager" && subSection==1){
			fontrenderer.drawString("Package", posX + 10, posY + 8, 0x000000, false);
			fontrenderer.drawSplitString(BookResources.packager3, posX + 10, posY + 80, 98, 0);
			fontrenderer.drawSplitString(BookResources.packager4, posX + 121, posY + 17, 98, 0);
			drawCrafting(null, Items.paper, null, Items.paper, Blocks.chest, Items.paper, null, Items.paper, null, MiscItems.pack, 20, 20, x, y);	
		}
		
		
		if(brew){
			RenderHelper.disableStandardItemLighting();
			fontrenderer.drawString("Brewer Recipe", posX+21, posY+80, 0x939393, false);
			if(x > posX + 12 && x < posX + 104 && y > posY + 80 && y < posY + 86){
				String[] desc = { "Put the top three", "items inside of the", "Brewer and a Potion", "Flask on the bottom slot." };
	            @SuppressWarnings("rawtypes")
	            List temp = Arrays.asList(desc);
	            zLevel = 2;
	            drawHoveringText(temp, x, y, fontrenderer);
	            RenderHelper.enableGUIStandardItemLighting();
			}
		}
		if(currentSection=="foodpackager"){
			RenderHelper.disableStandardItemLighting();
			if(x > posX + 226 && x < posX + 248 && y > posY + 10 && y < posY + 30){
				String[] desc = { "Packager Values" };
	            @SuppressWarnings("rawtypes")
	            List temp = Arrays.asList(desc);
	            zLevel = 2;
	            drawHoveringText(temp, x, y, fontrenderer);
			}
			RenderHelper.enableGUIStandardItemLighting();
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
		
		int color1 = 0xA3007A;
		int color2 = 0x720056;
		
		ButtonLeft prevButton = new ButtonLeft(0, posX + 0, posY + 167, 18, 12, "Prev", true);
		ButtonRight nextButton = new ButtonRight(1, posX + 210, posY + 167, 18, 12, "Next", true);
		ButtonNormal returnIndex = new ButtonNormal(2, posX + 87, posY + 167, 50, 14, "Return", true);
		
		ButtonMenu items = new ButtonMenu(11, posX + 124, posY + 18, 90, 12, "Items", color1, color2, true);
		ButtonMenu machines = new ButtonMenu(12, posX + 124, posY + 42, 90, 12, "Machines", color1, color2, true);
		ButtonMenu alchemy = new ButtonMenu(13, posX + 124, posY + 30, 90, 12, "Advanced Alchemy", color1, color2, true);
		ButtonMenu blocks = new ButtonMenu(14, posX + 124, posY + 54, 90, 12, "Blocks", color1, color2, true);
		ButtonMenu equipment = new ButtonMenu(15, posX + 124, posY + 66, 90, 12, "Equipment", color1, color2, true);

		ButtonMenu items1 = new ButtonMenu(31, posX + 124, posY + 18, 90, 12, "Sacred Chalice", color1, color2, true);
		ButtonMenu items2 = new ButtonMenu(32, posX + 124, posY + 30, 90, 12, "Shake", color1, color2, true);
		ButtonMenu items3 = new ButtonMenu(33, posX + 124, posY + 42, 90, 12, "Knowledge Gem", color1, color2, true);
		
		ButtonMenu blocks1 = new ButtonMenu(51, posX + 124, posY + 18, 90, 12, "Present", color1, color2, true);
		
		ButtonMenu machines1 = new ButtonMenu(71, posX + 124, posY + 18, 90, 12, "Food Packager", color1, color2, true);
		ButtonMenu machines2 = new ButtonMenu(72, posX + 124, posY + 30, 90, 12, "Packager", color1, color2, true);
		
		ButtonMenu equipment1 = new ButtonMenu(91, posX + 124, posY + 18, 90, 12, "Redstonic JetBoots", color1, color2, true);
		
		ButtonMenu alchemy1 = new ButtonMenu(112, posX + 124, posY + 18, 90, 12, "Reactive Brewer", color1, color2, true);
		ButtonMenu alchemy2 = new ButtonMenu(113, posX + 124, posY + 30, 90, 12, "Knowledge Potion", color1, color2, true);
		ButtonMenu alchemy3 = new ButtonMenu(114, posX + 124, posY + 42, 90, 12, "Flight Potion", color1, color2, true);
		ButtonMenu alchemy4 = new ButtonMenu(115, posX + 124, posY + 54, 90, 12, "Anti-Wither Potion", color1, color2, true);
		ButtonMenu alchemy5 = new ButtonMenu(116, posX + 124, posY + 66, 90, 12, "Heart Potion", color1, color2, true);
		
		ButtonWidget widget1 = new ButtonWidget(200, posX+228, posY+10, "FoodValues", "right", 0, MiscItems.PackagedFood, itemRender);
			
		if(currentSection=="index"|| currentSection==null || currentSection=="0"){
			buttonList.removeAll(buttonList);
			buttonList.add(items);
			buttonList.add(machines);
			buttonList.add(alchemy);
		}else if(entry){
			buttonList.removeAll(buttonList);
			if(maxPages!=subSection){
				buttonList.add(nextButton);
			}
			if(subSection != 0){
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
			buttonList.add(items2);
			buttonList.add(items3);
			
		}else if(currentSection=="blocks"){
			buttonList.removeAll(buttonList);
			buttonList.add(returnIndex);
			buttonList.add(blocks1);
			
		}else if(currentSection=="machines"){
			buttonList.removeAll(buttonList);
			buttonList.add(returnIndex);
			buttonList.add(machines1);
			buttonList.add(machines2);
			
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
			buttonList.add(alchemy4);
			buttonList.add(alchemy5);
		}
		
		if(currentSection=="foodpackager"){
			buttonList.add(widget1);
		}
	}
		
	@Override
	protected void actionPerformed(GuiButton button){
		switch(button.id){
		case 0: 
			if(currentSection!="index" && maxPages==subSection){
				subSection=subSection-1;
			}
		break;
		case 1:
			if(currentSection!="index" && subSection!=maxPages){
				subSection=subSection+1;
			}
		break;
		case 2:
			String s = currentSection;
			if(s=="items" || s=="blocks" || s=="machines" || s=="alchemy" || s=="equipment"){
				currentSection="index";
			}else{
				currentSection=prevSection;
			}
			subSection=0;
			entry=false;
			brew=false;
		break;
		
		//MENUS
		case 11:
			currentSection="items";
			subSection=0;
			entry=false;
		break;
		case 12:
			currentSection="machines";
			subSection=0;
			entry=false;
		break;
		case 13:
			currentSection="alchemy";
			subSection=0;
			entry=false;
		break;
		case 14:
			currentSection="blocks";
			subSection=0;
			entry=false;
		break;
		case 15:
			currentSection="equipment";
			subSection=0;
			entry=false;
		break;
		
		//ITEMS
		case 31:
			currentSection="sacredChalice";
			subSection=0;
			entry=true;
			maxPages=0;
			prevSection="items";
		break;
		case 32:
			currentSection="shake";
			prevSection="items";
			subSection=0;
			entry=true;
			maxPages=0;
			brew = true;
		break;
		case 33:
			currentSection="gem";
			prevSection="items";
			subSection=0;
			entry=true;
			maxPages=1;
		break;	
			
		//MACHINES
		case 71:
			currentSection="foodpackager";
			prevSection="machines";
			subSection=0;
			entry=true;
			maxPages=0;
		break;
		case 72:
			currentSection="packager";
			prevSection="machines";
			subSection=0;
			entry=true;
			maxPages=1;
		break;
		
		//ALCHEMY
		case 112:
			currentSection="brewer";
			subSection=0;
			entry=true;
			maxPages=0;
			prevSection="alchemy";
		break;
		case 113:
			currentSection="knowledge";
			subSection=0;
			entry=true;
			maxPages=0;
			prevSection="alchemy";
			brew=true;
		break;
		case 114:
			currentSection="flight";
			subSection=0;
			entry=true;
			maxPages=0;
			prevSection="alchemy";
			brew=true;
		break;
		case 115:
			currentSection="anit-wither";
			prevSection="alchemy";
			subSection=0;
			entry=true;
			maxPages=0;
			brew=true;
		break;
		case 116:
			currentSection="heart";
			prevSection="alchemy";
			subSection=0;
			entry=true;
			maxPages=0;
			brew=true;
		break;
		
		//WIDGETS
		case 200:
			FMLNetworkHandler.openGui(player, Miscellany.instance, 6, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
		break;
		}
	}
	@Override
	protected void mouseClicked(int x, int y, int mouseId) {
		int posX = (width - xSizeofTexture) / 2;
		int posY = (height - ySizeofTexture) / 2;
		int totalx = x - posX;
		int totaly = y - posY;
		super.mouseClicked(x, y, mouseId);
		this.initGui();
	}
	
	public void drawCrafting(Object i1, Object i2, Object i3, Object i4, Object i5, Object i6, Object i7, Object i8, Object i9, Object pro,int xPos, int yPos, int mousex, int mousey){
		FontRenderer itemsInGrid = Minecraft.getMinecraft().fontRenderer;
		RenderHelper.disableStandardItemLighting();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    	GL11.glEnable(GL11.GL_BLEND);
		int posX = (this.width - xSizeofTexture) / 2;
		int posY = (this.height - ySizeofTexture) / 2;
		int xPosCrafting = posX + yPos;
		int yPosCrafting = posY + xPos;
		
		ItemStack slot1 = null, slot2 = null, slot3 = null, slot4 = null, slot5 = null, slot6 = null, slot7 = null, slot8 = null, slot9 = null, product = null;
		if(i1 instanceof Item){
			slot1 = new ItemStack((Item)i1);
		}else if(i1 instanceof Block){
			slot1 = new ItemStack((Block)i1);
		}
		if(i2 instanceof Item){
			slot2 = new ItemStack((Item)i2);
		}else if(i2 instanceof Block){
			slot2 = new ItemStack((Block)i2);
		}
		if(i3 instanceof Item){
			slot3 = new ItemStack((Item)i3);
		}else if(i3 instanceof Block){
			slot3 = new ItemStack((Block)i3);
		}
		if(i4 instanceof Item){
			slot4 = new ItemStack((Item)i4);
		}else if(i4 instanceof Block){
			slot4 = new ItemStack((Block)i4);
		}
		if(i5 instanceof Item){
			slot5 = new ItemStack((Item)i5);
		}else if(i5 instanceof Block){
			slot5 = new ItemStack((Block)i5);
		}
		if(i6 instanceof Item){
			slot6 = new ItemStack((Item)i6);
		}else if(i6 instanceof Block){
			slot6 = new ItemStack((Block)i6);
		}
		if(i7 instanceof Item){
			slot7 = new ItemStack((Item)i7);
		}else if(i7 instanceof Block){
			slot7 = new ItemStack((Block)i7);
		}
		if(i8 instanceof Item){
			slot8 = new ItemStack((Item)i8);
		}else if(i8 instanceof Block){
			slot8 = new ItemStack((Block)i8);
		}
		if(i9 instanceof Item){
			slot9 = new ItemStack((Item)i9);
		}else if(i9 instanceof Block){
			slot9 = new ItemStack((Block)i9);
		}
		if(pro instanceof Item){
			product = new ItemStack((Item)pro);
		}else if(pro instanceof Block){
			product = new ItemStack((Block)pro);
		}
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(craftingGrid);
		drawTexturedModalRect(xPosCrafting, yPosCrafting, 0, 0, 76, 56);		
		
		if(slot1!=null){
			RenderHelper.disableStandardItemLighting();
			itemRender.renderItemAndEffectIntoGUI(itemsInGrid, Minecraft.getMinecraft().getTextureManager(), 
					slot1, xPosCrafting + 1, yPosCrafting + 1);	
		}
		if(slot2!=null){
			RenderHelper.disableStandardItemLighting();
			itemRender.renderItemAndEffectIntoGUI(itemsInGrid, Minecraft.getMinecraft().getTextureManager(), 
					slot2, xPosCrafting + 20, yPosCrafting + 1);	
		}
		if(slot3!=null){
			RenderHelper.disableStandardItemLighting();
			itemRender.renderItemAndEffectIntoGUI(itemsInGrid, Minecraft.getMinecraft().getTextureManager(), 
					slot3, xPosCrafting + 39, yPosCrafting + 1);	
		}
		if(slot4!=null){
			RenderHelper.disableStandardItemLighting();
			itemRender.renderItemAndEffectIntoGUI(itemsInGrid, Minecraft.getMinecraft().getTextureManager(), 
					slot4, xPosCrafting + 1, yPosCrafting + 20);	
		}
		if(slot5!=null){
			RenderHelper.disableStandardItemLighting();
			itemRender.renderItemAndEffectIntoGUI(itemsInGrid, Minecraft.getMinecraft().getTextureManager(), 
					slot5, xPosCrafting + 20, yPosCrafting + 20);	
		}
		if(slot6!=null){
			RenderHelper.disableStandardItemLighting();
			itemRender.renderItemAndEffectIntoGUI(itemsInGrid, Minecraft.getMinecraft().getTextureManager(), 
					slot6, xPosCrafting + 39, yPosCrafting + 20);	
		}
		if(slot7!=null){
			RenderHelper.disableStandardItemLighting();
			itemRender.renderItemAndEffectIntoGUI(itemsInGrid, Minecraft.getMinecraft().getTextureManager(), 
					slot7, xPosCrafting + 1, yPosCrafting + 39);	
		}
		if(slot8!=null){
			RenderHelper.disableStandardItemLighting();
			itemRender.renderItemAndEffectIntoGUI(itemsInGrid, Minecraft.getMinecraft().getTextureManager(), 
					slot8, xPosCrafting + 20, yPosCrafting + 39);	
		}
		if(slot9!=null){
			RenderHelper.disableStandardItemLighting();
			itemRender.renderItemAndEffectIntoGUI(itemsInGrid, Minecraft.getMinecraft().getTextureManager(), 
					slot9, xPosCrafting + 39, yPosCrafting + 39);	
		}	
		
		RenderHelper.disableStandardItemLighting();
			itemRender.renderItemAndEffectIntoGUI(itemsInGrid, Minecraft.getMinecraft().getTextureManager(), 
					product, xPosCrafting + 59, yPosCrafting + 8);
			RenderHelper.disableStandardItemLighting();
		
		if(slot1!=null){
			if(mousex>xPosCrafting+2 && mousex<xPosCrafting+16 && mousey>yPosCrafting+2 && mousey<yPosCrafting+16){
				renderToolTip(slot1, mousex, mousey);
			}
		}
		if(slot2!=null){
			if(mousex>xPosCrafting+21 && mousex<xPosCrafting+35 && mousey>yPosCrafting+2 && mousey<yPosCrafting+16){
				renderToolTip(slot2, mousex, mousey);
			}
		}
		if(slot3!=null){
			if(mousex>xPosCrafting+40 && mousex<xPosCrafting+54 && mousey>yPosCrafting+2 && mousey<yPosCrafting+16){
				renderToolTip(slot3, mousex, mousey);
			}
		}
		if(slot4!=null){
			if(mousex>xPosCrafting+2 && mousex<xPosCrafting+16 && mousey>yPosCrafting+21 && mousey<yPosCrafting+35){
				renderToolTip(slot4, mousex, mousey);
			}
		}
		if(slot5!=null){
			if(mousex>xPosCrafting+21 && mousex<xPosCrafting+35 && mousey>yPosCrafting+21 && mousey<yPosCrafting+35){
				renderToolTip(slot5, mousex, mousey);
			}
		}
		if(slot6!=null){
			if(mousex>xPosCrafting+40 && mousex<xPosCrafting+54 && mousey>yPosCrafting+21 && mousey<yPosCrafting+35){
				renderToolTip(slot6, mousex, mousey);
			}
		}
		if(slot7!=null){
			if(mousex>xPosCrafting+2 && mousex<xPosCrafting+16 && mousey>yPosCrafting+40 && mousey<yPosCrafting+54){
				renderToolTip(slot7, mousex, mousey);
				
			}
		}
		if(slot8!=null){
			if(mousex>xPosCrafting+21 && mousex<xPosCrafting+35 && mousey>yPosCrafting+40 && mousey<yPosCrafting+54){
				renderToolTip(slot8, mousex, mousey);
			}
		}
		if(slot9!=null){
			if(mousex>xPosCrafting+40 && mousex<xPosCrafting+54 && mousey>yPosCrafting+40 && mousey<yPosCrafting+54){
				renderToolTip(slot9, mousex, mousey);
			}
		}	
		
		if(mousex>xPosCrafting+58 && mousex<xPosCrafting+67 && mousey>yPosCrafting+38 && mousey<yPosCrafting+42 
				|| mousex>xPosCrafting+63 && mousex<xPosCrafting+69 && mousey>yPosCrafting+33 && mousey<yPosCrafting+68
				|| mousex>xPosCrafting+62 && mousex<xPosCrafting+72 && mousey>yPosCrafting+26 && mousey<yPosCrafting+33){
			String[] desc = { "Crafting" };
            @SuppressWarnings("rawtypes")
            List temp = Arrays.asList(desc);
            drawHoveringText(temp, mousex, mousey, itemsInGrid);
		}
			RenderHelper.disableStandardItemLighting();
			GL11.glEnable(GL11.GL_DEPTH_TEST);
		if(mousex>xPosCrafting+60 && mousex<xPosCrafting+74 && mousey>yPosCrafting+9 && mousey<yPosCrafting+23){
			renderToolTip(product, mousex, mousey);
			GL11.glDisable(GL11.GL_DEPTH_TEST);
			GL11.glDisable(GL11.GL_LIGHTING);
		}
	}
	
	
	public void drawAlchemy(Object i1, Object i2, Object i3, Object i4, Object pro, int xPos, int yPos, int mousex, int mousey){
		FontRenderer itemsInGrid = Minecraft.getMinecraft().fontRenderer;
		RenderHelper.disableStandardItemLighting();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    	GL11.glEnable(GL11.GL_BLEND);
		int posX = (this.width - xSizeofTexture) / 2;
		int posY = (this.height - ySizeofTexture) / 2;
		int xPosCrafting = posX + yPos;
		int yPosCrafting = posY + xPos;
		
		ItemStack slot1 = null, slot2 = null, slot3 = null, slot4 = null, product = null;
	
		if(i1 instanceof Item){
			slot1 = new ItemStack((Item)i1);
		}else if(i1 instanceof Block){
			slot1 = new ItemStack((Block)i1);
		}
		if(i2 instanceof Item){
			slot2 = new ItemStack((Item)i2);
		}else if(i2 instanceof Block){
			slot2 = new ItemStack((Block)i2);
		}
		if(i3 instanceof Item){
			slot3 = new ItemStack((Item)i3);
		}else if(i3 instanceof Block){
			slot3 = new ItemStack((Block)i3);
		}
		if(i4 instanceof Item){
			slot4 = new ItemStack((Item)i4);
		}else if(i4 instanceof Block){
			slot4 = new ItemStack((Block)i4);
		}
		if(pro instanceof Item){
			product = new ItemStack((Item)pro);
		}else if(pro instanceof Block){
			product = new ItemStack((Block)pro);
		}
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(craftingGrid);
		drawTexturedModalRect(xPosCrafting, yPosCrafting, 97, 0, 81, 56);		
		
		if(slot1!=null){
			RenderHelper.disableStandardItemLighting();
			itemRender.renderItemAndEffectIntoGUI(itemsInGrid, Minecraft.getMinecraft().getTextureManager(), 
					slot1, xPosCrafting + 1, yPosCrafting + 7);	
		}
		if(slot2!=null){
			RenderHelper.disableStandardItemLighting();
			itemRender.renderItemAndEffectIntoGUI(itemsInGrid, Minecraft.getMinecraft().getTextureManager(), 
					slot2, xPosCrafting + 27, yPosCrafting + 1);	
		}
		if(slot3!=null){
			RenderHelper.disableStandardItemLighting();
			itemRender.renderItemAndEffectIntoGUI(itemsInGrid, Minecraft.getMinecraft().getTextureManager(), 
					slot3, xPosCrafting + 53, yPosCrafting + 7);	
		}
		if(slot4!=null){
			RenderHelper.disableStandardItemLighting();
			itemRender.renderItemAndEffectIntoGUI(itemsInGrid, Minecraft.getMinecraft().getTextureManager(), 
					slot4, xPosCrafting + 27, yPosCrafting + 39);	
		}
		if(product!=null){
			RenderHelper.disableStandardItemLighting();
			itemRender.renderItemAndEffectIntoGUI(itemsInGrid, Minecraft.getMinecraft().getTextureManager(), 
					product, xPosCrafting + 64, yPosCrafting + 29);	
		}
		
		if(slot1!=null){
			if(mousex>xPosCrafting+1 && mousex<xPosCrafting+17 && mousey>yPosCrafting+7 && mousey<yPosCrafting+23){
				renderToolTip(slot1, mousex, mousey);
			}
		}
		if(slot2!=null){
			if(mousex>xPosCrafting+27 && mousex<xPosCrafting+43 && mousey>yPosCrafting+1 && mousey<yPosCrafting+17){
				renderToolTip(slot2, mousex, mousey);
			}
		}
		if(slot3!=null){
			if(mousex>xPosCrafting+53 && mousex<xPosCrafting+69 && mousey>yPosCrafting+7 && mousey<yPosCrafting+23){
				renderToolTip(slot3, mousex, mousey);
			}
		}
		if(slot4!=null){
			if(mousex>xPosCrafting+27 && mousex<xPosCrafting+43 && mousey>yPosCrafting+39 && mousey<yPosCrafting+55){
				renderToolTip(slot4, mousex, mousey);
			}
		}
		if(product!=null){
			if(mousex>xPosCrafting+64 && mousex<xPosCrafting+80 && mousey>yPosCrafting+29 && mousey<yPosCrafting+45){
				renderToolTip(product, mousex, mousey);
			}
		}
		
		if(mousex>xPosCrafting+30 && mousex<xPosCrafting+18 && mousey>yPosCrafting+40 && mousey<yPosCrafting+38){
			String[] desc = { "Brews" };
            @SuppressWarnings("rawtypes")
            List temp = Arrays.asList(desc);
            drawHoveringText(temp, mousex, mousey, itemsInGrid);
		}
		RenderHelper.disableStandardItemLighting();
		GL11.glEnable(GL11.GL_DEPTH_TEST);
	}
}
