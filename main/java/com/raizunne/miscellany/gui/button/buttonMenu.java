package com.raizunne.miscellany.gui.button;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.ResourceLocation;

public class buttonMenu extends GuiButton {
	
	public int width;
	public int height;
	public int posX;
	public int posY;
	public int id;
	public String text;
	public boolean enabled;
	public boolean visible;
	public int colors;
	public int colors2;
	public int color;
	public int color2;
	public boolean page;
	public boolean page2;
	
	public buttonMenu(int id, int posX, int posY, String text, int colors, int colors2, boolean page)
    {
        this(id, posX, posY, 200, 12, text, colors, colors2, page);
    }

	public buttonMenu(int id2, int posX2, int posY2, int i, int j, String text2, int color, int color2, boolean page2) {
		super(id2, posX2, posY2, i, j, text2);
		this.width = 200;
        this.height = 12;
        this.enabled = true;
        this.visible = true;
        this.id = id2;
        this.xPosition = posX2;
        this.yPosition = posY2;
        this.width = i;
        this.height = j;
        this.displayString = text2;
        boolean h1 = true;
        this.colors = color;
        this.colors2 = color2;
        this.page2 = page;
        
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
        	FontRenderer fontrenderer = p_146112_1_.fontRenderer;
        	/*Color used when not hovered*/
            int l = this.colors;
            this.field_146123_n = p_146112_2_ >= this.xPosition && p_146112_3_ >= this.yPosition && p_146112_2_ < this.xPosition + this.width && p_146112_3_ < this.yPosition + this.height;
            int hover = this.getHoverState(this.field_146123_n);
            boolean hovering = false;
          
            if (hover==2)
            {
            	/*Color used when WHEN hovered*/
                l = this.colors2;
                
            }
                            
			this.drawString(fontrenderer, this.displayString, this.xPosition + (hover == 2 ? 2 : 0), this.yPosition + (this.height - 8) / 2, l);
        }
    }
	
	public void func_146113_a(SoundHandler p_146113_1_)
    {
		ResourceLocation page1 = new ResourceLocation("miscellany:pageflip1");
		ResourceLocation page2 = new ResourceLocation("miscellany:pageflip2");
		ResourceLocation page3 = new ResourceLocation("miscellany:pageflip3");
		ResourceLocation page4 = new ResourceLocation("miscellany:pageflip4");
		ResourceLocation page5 = new ResourceLocation("miscellany:pageflip5");
		ResourceLocation page6 = new ResourceLocation("miscellany:pageflip6");
		ResourceLocation page7 = new ResourceLocation("miscellany:pageflip7");
		ResourceLocation page8 = new ResourceLocation("miscellany:pageflip8");
		ResourceLocation page9 = new ResourceLocation("miscellany:pageflip9");
		ResourceLocation page10 = new ResourceLocation("miscellany:pageflip10");
		
		Random r = new Random();
		int n = r.nextInt(10) + 1;
		if(page){
			if(n==1){
				p_146113_1_.playSound(PositionedSoundRecord.func_147674_a(page1, 1.0F));
			}else if(n==2){
				p_146113_1_.playSound(PositionedSoundRecord.func_147674_a(page2, 1.0F));
			}else if(n==3){
				p_146113_1_.playSound(PositionedSoundRecord.func_147674_a(page3, 1.0F));
			}else if(n==4){
				p_146113_1_.playSound(PositionedSoundRecord.func_147674_a(page4, 1.0F));
			}else if(n==5){
				p_146113_1_.playSound(PositionedSoundRecord.func_147674_a(page5, 1.0F));
			}else if(n==6){
				p_146113_1_.playSound(PositionedSoundRecord.func_147674_a(page6, 1.0F));
			}else if(n==7){
				p_146113_1_.playSound(PositionedSoundRecord.func_147674_a(page7, 1.0F));
			}else if(n==8){
				p_146113_1_.playSound(PositionedSoundRecord.func_147674_a(page8, 1.0F));
			}else if(n==9){
				p_146113_1_.playSound(PositionedSoundRecord.func_147674_a(page9, 1.0F));
			}else if(n==10){
				p_146113_1_.playSound(PositionedSoundRecord.func_147674_a(page10, 1.0F));
			}
		}else{
			p_146113_1_.playSound(PositionedSoundRecord.func_147674_a(new ResourceLocation("gui.button.press"), 1.0F));
		}
    }
}