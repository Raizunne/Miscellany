package com.raizunne.miscellany.gui.button;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class widgetRight extends GuiButton {
	
	public int width;
	public int height;
	public int posX;
	public int posY;
	public int id;
	public String text;
	public boolean enabled;
	public boolean visible;
	
	public widgetRight(int id, int posX, int posY, String text)
    {
        this(id, posX, posY, 33, 22, text);
    }

	public widgetRight(int id2, int posX2, int posY2, int i, int j, String text2) {
		super(id2, posX2, posY2, i, j, text2);
		this.width = 33;
        this.height = 22;
        this.enabled = true;
        this.visible = true;
        this.id = id2;
        this.xPosition = posX2;
        this.yPosition = posY2;
        this.width = i;
        this.height = j;
        this.displayString = text2;
        boolean h1 = true;
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
        	GL11.glColor4f(58F, 158F, 255F, 1.0F);
        	GL11.glEnable(GL11.GL_BLEND);
            OpenGlHelper.glBlendFunc(770, 771, 1, 0);
        	ResourceLocation texture = new ResourceLocation("miscellany", "textures/gui/widgets.png");
        	/*Color used when not hovered*/
        	Minecraft.getMinecraft().renderEngine.bindTexture(texture);

            this.field_146123_n = p_146112_2_ >= this.xPosition && p_146112_3_ >= this.yPosition && p_146112_2_ < this.xPosition + this.width && p_146112_3_ < this.yPosition + this.height;
            int hover = this.getHoverState(this.field_146123_n);
          
            if (hover==2)
            {
            	/*Color used when WHEN hovered*/
                
            }
            this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 0, 33, 22);

        }
    }
	public void func_146113_a(SoundHandler p_146113_1_)
    {
		 p_146113_1_.playSound(PositionedSoundRecord.func_147674_a(new ResourceLocation("gui.button.press"), 1.0F));
    }
}
