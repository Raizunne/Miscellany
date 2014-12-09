/**
Code made by Raizunne as a part of Raizunne's Miscellany  
Source code found at github.com/Raizunne
 */
package com.raizunne.miscellany.gui.button;

import org.lwjgl.opengl.GL11;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ButtonWidget extends GuiButton{

	int x;
	int y;
	int id;
	String text;
	String direction;
	boolean enabled;
	int type;
	RenderItem itemRender;
	ItemStack item;
	
	public ButtonWidget(int id, int x, int y, String text, String direction, int type, Object item, RenderItem itemRender) {
		super(id, x, y, text);
		this.x = x;
		this.y = y;
		this.id = id;
		this.text = text;
		this.direction = direction;
		this.enabled = true;
		this.type = type;
		this.itemRender = itemRender;
		this.width = 22;
		this.height = 20;
		if(item instanceof Item){
			Item i = (Item)item;
			this.item = new ItemStack(i);
		}else if(item instanceof Block){
			Block i = (Block)item;
			this.item = new ItemStack(i);
		}
	}
	
	public int getHoverState(boolean bool){
        byte b0 = 1;
        if (!this.enabled){
            b0 = 0;
        }else if (bool){
            b0 = 2;
        }
        return b0;
    }
	
	public void drawButton(Minecraft p_146112_1_, int p_146112_2_, int p_146112_3_){
        if (this.visible){
        	int xTexture;
        	int yTexture;
        	int xItem;
        	int yItem;
        	ResourceLocation tex = new ResourceLocation("miscellany", "textures/gui/widgets.png");
        	FontRenderer fontrenderer = p_146112_1_.fontRenderer;
            this.field_146123_n = p_146112_2_ >= this.xPosition && p_146112_3_ >= this.yPosition && p_146112_2_ < this.xPosition + this.width && p_146112_3_ < this.yPosition + this.height;
            int hover = this.getHoverState(this.field_146123_n);
            Minecraft.getMinecraft().renderEngine.bindTexture(tex);
            boolean hovering = false;
            if (hover==2){
                if(direction.equals("left")){
                	if(type==1){
                		xTexture = 0;
                		yTexture = 0;
                	}else{
                		xTexture = 0;
                		yTexture = 21;
                	}
                	
                }else{
                	if(type==1){
                		xTexture = 69;
                		yTexture = 0;
                	}else{
                		xTexture = 69;
                		yTexture = 21;
                	}
                }
            }else{
            	if(direction.equals("left")){
            		if(type==1){
                		xTexture = 23;
                		yTexture = 0;
                	}else{
                		xTexture = 23;
                		yTexture = 21;
                	}
                }else{
                	if(type==1){
                		xTexture = 46;
                		yTexture = 0;
                	}else{
                		xTexture = 46;
                		yTexture = 21;
                	}
                }
            }
            
            if(direction.equals("left")){xItem = 4; yItem = 2;}else{xItem = 2; yItem = 2;}
            drawTexturedModalRect(this.x, this.y, xTexture, yTexture, 22, 20);
            RenderHelper.disableStandardItemLighting();
            itemRender.renderItemAndEffectIntoGUI(fontrenderer, Minecraft.getMinecraft().getTextureManager(), item, this.x + xItem, this.y + yItem);	
            RenderHelper.enableGUIStandardItemLighting();
			RenderHelper.enableStandardItemLighting();
            RenderHelper.disableStandardItemLighting();
    		GL11.glEnable(GL11.GL_DEPTH_TEST);
    		
        }
    }
	
	public void func_146113_a(SoundHandler p_146113_1_){
        p_146113_1_.playSound(PositionedSoundRecord.func_147674_a(new ResourceLocation("gui.button.press"), 1.0F));
    }
}
