package com.raizunne.miscellany.gui.button;

import org.lwjgl.opengl.GL11;

import com.sun.prism.paint.Color;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.FontRenderer;

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
	
	public buttonMenu(int id, int posX, int posY, String text, int colors, int colors2)
    {
        this(id, posX, posY, 200, 12, text, colors, colors2);
    }

	public buttonMenu(int id2, int posX2, int posY2, int i, int j, String text2, int color, int color2) {
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
}