package com.raizunne.miscellany.util;

import java.util.Arrays;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import org.lwjgl.opengl.GL11;

public class renderCrafting extends GuiScreen{
	
	public static int yPos;
	public static int xPos;
	public static Item item1;
	public static Item item2;
	public static Item item3;
	public static Item item4;
	public static Item item5;
	public static Item item6;
	public static Item item7;
	public static Item item8;
	public static Item item9;
	public static Item product;
	
	
//	public void drawScreen(int x, int y, float f) {
//		public final int xSizeofTexture = 228;
//		public final int ySizeofTexture = 166;
//		FontRenderer itemsInGrid = Minecraft.getMinecraft().fontRenderer;
//		RenderHelper.disableStandardItemLighting();
//		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
//    	GL11.glEnable(GL11.GL_BLEND);
//		int posX = (this.width - xSizeofTexture) / 2;
//		int posY = (this.height - ySizeofTexture) / 2;
//		int xPosCrafting = posX + yPos;
//		int yPosCrafting = posY + xPos;
//		
//		Minecraft.getMinecraft().getTextureManager().bindTexture(craftingGrid);
//		drawTexturedModalRect(xPosCrafting, yPosCrafting, 0, 0, 76, 56);		
//		
//		if(item1!=null){
//			RenderHelper.disableStandardItemLighting();
//			itemRender.renderItemAndEffectIntoGUI(itemsInGrid, Minecraft.getMinecraft().getTextureManager(), 
//					new ItemStack(item1), xPosCrafting + 1, yPosCrafting + 1);	
//		}
//		if(item2!=null){
//			RenderHelper.disableStandardItemLighting();
//			itemRender.renderItemAndEffectIntoGUI(itemsInGrid, Minecraft.getMinecraft().getTextureManager(), 
//					new ItemStack(item2), xPosCrafting + 20, yPosCrafting + 1);	
//		}
//		if(item3!=null){
//			RenderHelper.disableStandardItemLighting();
//			itemRender.renderItemAndEffectIntoGUI(itemsInGrid, Minecraft.getMinecraft().getTextureManager(), 
//					new ItemStack(item3), xPosCrafting + 39, yPosCrafting + 1);	
//		}
//		if(item4!=null){
//			RenderHelper.disableStandardItemLighting();
//			itemRender.renderItemAndEffectIntoGUI(itemsInGrid, Minecraft.getMinecraft().getTextureManager(), 
//					new ItemStack(item4), xPosCrafting + 1, yPosCrafting + 20);	
//		}
//		if(item5!=null){
//			RenderHelper.disableStandardItemLighting();
//			itemRender.renderItemAndEffectIntoGUI(itemsInGrid, Minecraft.getMinecraft().getTextureManager(), 
//					new ItemStack(item5), xPosCrafting + 20, yPosCrafting + 20);	
//		}
//		if(item6!=null){
//			RenderHelper.disableStandardItemLighting();
//			itemRender.renderItemAndEffectIntoGUI(itemsInGrid, Minecraft.getMinecraft().getTextureManager(), 
//					new ItemStack(item6), xPosCrafting + 39, yPosCrafting + 20);	
//		}
//		if(item7!=null){
//			RenderHelper.disableStandardItemLighting();
//			itemRender.renderItemAndEffectIntoGUI(itemsInGrid, Minecraft.getMinecraft().getTextureManager(), 
//					new ItemStack(item7), xPosCrafting + 1, yPosCrafting + 39);	
//		}
//		if(item8!=null){
//			RenderHelper.disableStandardItemLighting();
//			itemRender.renderItemAndEffectIntoGUI(itemsInGrid, Minecraft.getMinecraft().getTextureManager(), 
//					new ItemStack(item8), xPosCrafting + 20, yPosCrafting + 39);	
//		}
//		if(item9!=null){
//			RenderHelper.disableStandardItemLighting();
//			itemRender.renderItemAndEffectIntoGUI(itemsInGrid, Minecraft.getMinecraft().getTextureManager(), 
//					new ItemStack(item9), xPosCrafting + 39, yPosCrafting + 39);	
//		}	
//		
//		RenderHelper.disableStandardItemLighting();
//			itemRender.renderItemAndEffectIntoGUI(itemsInGrid, Minecraft.getMinecraft().getTextureManager(), 
//				product, xPosCrafting + 59, yPosCrafting + 8);
//			RenderHelper.disableStandardItemLighting();
//		
//		if(item1!=null){
//			if(mousex>xPosCrafting+2 && mousex<xPosCrafting+16 && mousey>yPosCrafting+2 && mousey<yPosCrafting+16){
//				renderToolTip(item1, mousex, mousey);
//			}
//		}
//		if(item2!=null){
//			if(mousex>xPosCrafting+21 && mousex<xPosCrafting+35 && mousey>yPosCrafting+2 && mousey<yPosCrafting+16){
//				renderToolTip(item2, mousex, mousey);
//			}
//		}
//		if(item3!=null){
//			if(mousex>xPosCrafting+40 && mousex<xPosCrafting+54 && mousey>yPosCrafting+2 && mousey<yPosCrafting+16){
//				renderToolTip(item3, mousex, mousey);
//			}
//		}
//		if(item4!=null){
//			if(mousex>xPosCrafting+2 && mousex<xPosCrafting+16 && mousey>yPosCrafting+21 && mousey<yPosCrafting+35){
//				renderToolTip(item4, mousex, mousey);
//			}
//		}
//		if(item5!=null){
//			if(mousex>xPosCrafting+21 && mousex<xPosCrafting+35 && mousey>yPosCrafting+21 && mousey<yPosCrafting+35){
//				renderToolTip(item5, mousex, mousey);
//			}
//		}
//		if(item6!=null){
//			if(mousex>xPosCrafting+40 && mousex<xPosCrafting+54 && mousey>yPosCrafting+21 && mousey<yPosCrafting+35){
//				renderToolTip(item6, mousex, mousey);
//			}
//		}
//		if(item7!=null){
//			if(mousex>xPosCrafting+2 && mousex<xPosCrafting+16 && mousey>yPosCrafting+40 && mousey<yPosCrafting+54){
//				renderToolTip(item7, mousex, mousey);
//				
//			}
//		}
//		if(item8!=null){
//			if(mousex>xPosCrafting+21 && mousex<xPosCrafting+35 && mousey>yPosCrafting+40 && mousey<yPosCrafting+54){
//				renderToolTip(item8, mousex, mousey);
//			}
//		}
//		if(item9!=null){
//			if(mousex>xPosCrafting+40 && mousex<xPosCrafting+54 && mousey>yPosCrafting+40 && mousey<yPosCrafting+54){
//				renderToolTip(item9, mousex, mousey);
//			}
//		}	
//		
//		if(mousex>xPosCrafting+58 && mousex<xPosCrafting+67 && mousey>yPosCrafting+38 && mousey<yPosCrafting+42 
//				|| mousex>xPosCrafting+63 && mousex<xPosCrafting+69 && mousey>yPosCrafting+33 && mousey<yPosCrafting+68
//				|| mousex>xPosCrafting+62 && mousex<xPosCrafting+72 && mousey>yPosCrafting+26 && mousey<yPosCrafting+33){
//			String[] desc = { "Produces" };
//            @SuppressWarnings("rawtypes")
//            List temp = Arrays.asList(desc);
//            drawHoveringText(temp, mousex, mousey, itemsInGrid);
//		}
//			RenderHelper.disableStandardItemLighting();
//			GL11.glEnable(GL11.GL_DEPTH_TEST);
//		if(mousex>xPosCrafting+60 && mousex<xPosCrafting+74 && mousey>yPosCrafting+9 && mousey<yPosCrafting+23){
//			renderToolTip(product, mousex, mousey);
//			GL11.glDisable(GL11.GL_DEPTH_TEST);
//			GL11.glDisable(GL11.GL_LIGHTING);
//		}		
//		
//		super.drawScreen(x, y, f);
//	}
}
