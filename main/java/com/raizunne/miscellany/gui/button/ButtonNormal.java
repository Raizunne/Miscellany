package com.raizunne.miscellany.gui.button;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.util.ResourceLocation;

public class ButtonNormal extends GuiButton {
	
	public int width;
	public int height;
	public int posX;
	public int posY;
	public int id;
	public String text;
	public boolean enabled;
	public boolean visible;
	public boolean alt;
	
	public ButtonNormal(int id, int posX, int posY, int i, int j, String text, boolean bool) {
		super(id, posX, posY, i, j, text);
		this.width = 200;
        this.height = 14;
        this.enabled = true;
        this.visible = true;
        this.id = id;
        this.xPosition = posX;
        this.yPosition = posY;
        this.width = i;
        this.height = j;
        this.displayString = text;
        boolean h1 = true;
        this.alt = bool;
	}
	
	public int getHoverState(boolean p_146114_1_)
    {
        byte b0 = 1;

        if (!this.enabled)
        {
            b0 = 0;
        }
        else if (p_146114_1_)
        {
            b0 = 2;
        }

        return b0;
    }
	
	
	
	public void drawButton(Minecraft p_146112_1_, int p_146112_2_, int p_146112_3_)
    {
        if (this.visible)
        {
        	
            int xTexture = 187;
        	int yTexture = 190;
        	ResourceLocation texture = new ResourceLocation("miscellany", "textures/gui/bookTemplate.png");
        	ResourceLocation tex = new ResourceLocation("miscellany", "textures/gui/FoodPackagerManual.png");
        	
        	FontRenderer fontrenderer = p_146112_1_.fontRenderer;
        	if(!alt){
        		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
        	}else{
        		Minecraft.getMinecraft().renderEngine.bindTexture(tex);
        	}
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glEnable(GL11.GL_BLEND);
            OpenGlHelper.glBlendFunc(770, 771, 1, 0);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            /*
             * drawTexturedModalRect(xPosition, yPosition, 0, 0, width, height);
             */           
            this.field_146123_n = p_146112_2_ >= this.xPosition && p_146112_3_ >= this.yPosition && p_146112_2_ < this.xPosition + this.width && p_146112_3_ < this.yPosition + this.height;
        	int hover = this.getHoverState(this.field_146123_n);
            int l = 9408399;
            
        	                      
            if (hover==2)
            {
            	/*Color used when WHEN hovered*/
            	xTexture = 0;
            	yTexture = 205;
            	l = 14935011;
            	
                
            }
            this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, yTexture, this.width / 2, this.height);
            this.drawTexturedModalRect(this.xPosition + this.width / 2, this.yPosition, 200 - this.width / 2, yTexture, this.width / 2, this.height);
            this.drawCenteredString(fontrenderer, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, l);                
        }
    }
	public void func_146113_a(SoundHandler p_146113_1_)
    {
		ResourceLocation page1 = new ResourceLocation("miscellany:pageflip1");
		ResourceLocation page2 = new ResourceLocation("miscellany:pageflip2");
		ResourceLocation page3 = new ResourceLocation("miscellany:pageflip3");
		ResourceLocation page4 = new ResourceLocation("miscellany:pageflip4");
		
		Random r = new Random();
		int n = r.nextInt(4) + 1;
		if(n==1){
			p_146113_1_.playSound(PositionedSoundRecord.func_147674_a(page1, 1.0F));
		}else if(n==2){
			p_146113_1_.playSound(PositionedSoundRecord.func_147674_a(page2, 1.0F));
		}else if(n==3){
			p_146113_1_.playSound(PositionedSoundRecord.func_147674_a(page3, 1.0F));
		}else if(n==4){
			p_146113_1_.playSound(PositionedSoundRecord.func_147674_a(page4, 1.0F));
		}
    }
}
