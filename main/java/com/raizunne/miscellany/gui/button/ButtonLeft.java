package com.raizunne.miscellany.gui.button;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class ButtonLeft extends GuiButton {
	
	public int width;
	public int height;
	public int posX;
	public int posY;
	public int id;
	public String text;
	public boolean enabled;
	public boolean visible;
	public boolean alt;
	
	public ButtonLeft(int id, int posX, int posY, String text, boolean bool){
        this(id, posX, posY, 18, 10, text, bool);
    }

	public ButtonLeft(int id2, int posX2, int posY2, int i, int j, String text2, boolean bool) {
		super(id2, posX2, posY2, i, j, text2);
		this.width = 18;
        this.height = 10;
        this.enabled = true;
        this.visible = true;
        this.id = id2;
        this.xPosition = posX2;
        this.yPosition = posY2;
        this.width = i;
        this.height = j;
        this.displayString = text2;
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
        	int xTexture;
        	int yTexture;
        	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        	GL11.glEnable(GL11.GL_BLEND);
            OpenGlHelper.glBlendFunc(770, 771, 1, 0);
        	ResourceLocation texture = new ResourceLocation("miscellany", "textures/gui/bookTemplate.png");
        	ResourceLocation tex = new ResourceLocation("miscellany", "textures/gui/FoodPackagerManual.png");
        	/*Color used when not hovered*/
        	if(!alt){
        		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
        	}else{
        		Minecraft.getMinecraft().renderEngine.bindTexture(tex);
        	}
        	if(!alt){
        		xTexture = 187;
        		yTexture = 179;
        	}else{
        		xTexture = 153;
        		yTexture = 13;
        	}
            this.field_146123_n = p_146112_2_ >= this.xPosition && p_146112_3_ >= this.yPosition && p_146112_2_ < this.xPosition + this.width && p_146112_3_ < this.yPosition + this.height;
            int hover = this.getHoverState(this.field_146123_n);
          
            if (hover==2)
            {
            	/*Color used when WHEN hovered*/
            	if(!alt){
            		xTexture = 210;
            		yTexture = 179;
            	}else{
            		xTexture = 176;
            		yTexture = 13;
            	}
                
            }
            this.drawTexturedModalRect(this.xPosition, this.yPosition, xTexture, yTexture, 18, 10);
            
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
