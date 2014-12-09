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
import com.raizunne.miscellany.util.BookResources;

public class GuiPackageValues extends GuiScreen{
	
	public static final ResourceLocation texture = new ResourceLocation("miscellany", "textures/gui/FoodPackagerManual.png");
	
	public final int xSizeofTexture = 153;
	public final int ySizeofTexture = 177;
	
	public int page;
	public int maxPages = 2;
	public EntityPlayer playerino;
	
	public GuiPackageValues(){
		super();
		page=0;
		maxPages=2;
	}
	
	public GuiPackageValues(EntityPlayer player){
		checkIfClient(player);
		this.playerino = player;
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
		
		if(page==0){
			fontrenderer.drawSplitString(EnumChatFormatting.BLUE + "Packaged Food " + EnumChatFormatting.BLACK + "is generated with the use of calories that are accquiered from buring other food. "
					+ "Different foods have different amounts of caloreis. "+ EnumChatFormatting.BOLD + "500 calories " + EnumChatFormatting.RESET + "are required for a " + EnumChatFormatting.BLUE + "Packaged Food" + 
					EnumChatFormatting.BLACK + ". Here are the amount of calories generated from different foods. If a food is not listed, "
					+ "it generates 100 calories.", posX + 8, posY + 46, 138, 0);
			drawItems(MiscItems.PackagedFood, null,  null, null, 30, x, y, 37);
		}else if(page==1){
			drawSeparator(59);
			drawSeparator(108);
			drawSeparator(153);
			fontrenderer.drawString(EnumChatFormatting.BLACK + "Calories - 10", posX + 41, posY + 35, 120, false); //ADD 8 TO GET Y VALUE OF DISPLAY ITEMS
			drawItems(Items.potato, Items.cookie, Items.melon, Items.spider_eye, 43, x, y, 0);
			fontrenderer.drawString(EnumChatFormatting.BLACK + "Calories - 50", posX + 41, posY + 67, 120, false); //ADD 16 TO GET VALUE OF SEPARATOR
			drawItems(Items.fish, Items.chicken, Items.porkchop, Items.beef, 75, x, y, 0);	
			drawItems(Items.apple, null,  null, null, 90, x, y, 37);
			fontrenderer.drawString(EnumChatFormatting.BLACK + "Calories - 200", posX + 38, posY + 114, 120, false);
			drawItems(Items.cooked_fished, Items.mushroom_stew, Items.baked_potato, null, 122, x, y, 13); //ADD 15 FOR DOUBLE ROWS
			drawItems(null, Items.carrot, Items.bread, null, 137, x, y, 0);
		}else if(page==2){
			drawSeparator(59);
			drawSeparator(91);
			drawSeparator(125);
			fontrenderer.drawString(EnumChatFormatting.BLACK + "Calories - 250", posX + 38, posY + 35, 120, false); //ADD 8 TO GET Y VALUE OF DISPLAY ITEMS
			drawItems(Items.golden_carrot, Items.cooked_chicken, Items.cooked_beef, Items.cooked_porkchop, 43, x, y, 0);
			fontrenderer.drawString(EnumChatFormatting.BLACK + "Calories - 300", posX + 38, posY + 67, 120, false);
			drawItems(null, Items.cake, Items.pumpkin_pie, null, 75, x, y, 0);
			fontrenderer.drawString(EnumChatFormatting.BLACK + "Calories - 2000", posX + 35, posY + 99, 120, false);
			drawItems(Items.golden_apple, null, null, null, 107, x, y, 37);
		}
		super.drawScreen(x, y, f);
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
	public void drawSeparator(int y){
		mc.renderEngine.bindTexture(texture);
		int posX = (width - xSizeofTexture) / 2;
		int posY = (height - ySizeofTexture) / 2;
		drawTexturedModalRect(posX + 8, posY + y, 0, 221, 138, 5);
	}
	
	@Override
	public void initGui() {
		buttonList = new ArrayList();
		int posX = (width - xSizeofTexture) / 2;
		int posY = (height - ySizeofTexture) / 2;
		
		int color1 = 0xA3007A;
		int color2 = 0x720056;
		
		ButtonLeft prevButton = new ButtonLeft(0, posX + 0, posY + 178, 18, 12, "Prev", true);
		ButtonRight nextButton = new ButtonRight(1, posX + 135, posY + 178, 18, 12, "Next", true);
		ButtonNormal returnIndex = new ButtonNormal(2, posX + 51, posY + 178, 50, 14, "Return", true);
		
		if(page==0){
			buttonList.add(returnIndex);
			buttonList.add(nextButton);
		}else if(page!=maxPages && page!=0){
			buttonList.add(prevButton);
			buttonList.add(returnIndex);
			buttonList.add(nextButton);
		}else if(page==maxPages){
			buttonList.add(prevButton);
			buttonList.add(returnIndex);
		}
		
		
	}
		
	@Override
	protected void actionPerformed(GuiButton button){
		switch(button.id){
		case 0: 
			if(page!=0){
				page--;
			}
		break;
		case 1:
			if(page!=maxPages){
				page++;
			}
		break;
		case 2:
			playerino.closeScreen();
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
	
	public void drawItems(Item item1, Item item2, Item item3, Item item4, int y, int mousex, int mousey, int mod){
		FontRenderer itemsInGrid = Minecraft.getMinecraft().fontRenderer;
		RenderHelper.disableStandardItemLighting();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    	GL11.glEnable(GL11.GL_BLEND);
		int posX = (this.width - xSizeofTexture) / 2;
		int posY = (this.height - ySizeofTexture) / 2;
		
		if(item1!=null){
			RenderHelper.disableStandardItemLighting();
			itemRender.renderItemAndEffectIntoGUI(itemsInGrid, Minecraft.getMinecraft().getTextureManager(), new ItemStack(item1), posX + 32 + mod, posY + y);	
			RenderHelper.enableGUIStandardItemLighting();
			RenderHelper.enableStandardItemLighting();
		}
		if(item2!=null){
			RenderHelper.disableStandardItemLighting();
			itemRender.renderItemAndEffectIntoGUI(itemsInGrid, Minecraft.getMinecraft().getTextureManager(), new ItemStack(item2), posX + 56 + mod, posY + y);	
			RenderHelper.enableGUIStandardItemLighting();
			RenderHelper.enableStandardItemLighting();
		}
		if(item3!=null){
			RenderHelper.disableStandardItemLighting();
			itemRender.renderItemAndEffectIntoGUI(itemsInGrid, Minecraft.getMinecraft().getTextureManager(), new ItemStack(item3), posX + 80 + mod, posY + y);	
			RenderHelper.enableGUIStandardItemLighting();
			RenderHelper.enableStandardItemLighting();
		}
		if(item4!=null){
			RenderHelper.disableStandardItemLighting();
			itemRender.renderItemAndEffectIntoGUI(itemsInGrid, Minecraft.getMinecraft().getTextureManager(), new ItemStack(item4), posX + 104 + mod, posY + y);	
			RenderHelper.enableGUIStandardItemLighting();
			RenderHelper.enableStandardItemLighting();
		}
		
		if(item1!=null){
			if(mousex>posX+32 + mod && mousex<posX+48 + mod && mousey>posY + y && mousey<posY + y+16){
				renderToolTip(new ItemStack(item1), mousex, mousey);
			}
		}
		if(item2!=null){
			if(mousex>posX+56 + mod && mousex<posX+72 + mod && mousey>posY + y && mousey<posY + y+16){
				renderToolTip(new ItemStack(item2), mousex, mousey);
			}
		}
		if(item3!=null){
			if(mousex>posX+80 + mod && mousex<posX+96 + mod && mousey>posY + y && mousey<posY + y+16){
				renderToolTip(new ItemStack(item3), mousex, mousey);
			}
		}
		if(item4!=null){
			if(mousex>posX+104 + mod && mousex<posX+120 + mod && mousey>posY + y && mousey<posY + y+16){
				renderToolTip(new ItemStack(item4), mousex, mousey);
			}
		}
		RenderHelper.disableStandardItemLighting();
		GL11.glEnable(GL11.GL_DEPTH_TEST);
	}
	
}
