/**
Code made by Raizunne as a part of Raizunne's Miscellany  
Source code found at github.com/Raizunne
 */
package com.raizunne.miscellany.client.render;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.raizunne.miscellany.Miscellany;
import com.raizunne.miscellany.client.model.modelHeart;

public class RenderHeart extends TileEntitySpecialRenderer{
	private static final ResourceLocation texture = new ResourceLocation(Miscellany.MODID + ":" + "textures/model/Heart.png");
	
	private modelHeart model;
	
	public RenderHeart() {
		this.model = new modelHeart();
	}
		
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.4F, (float)y +0.06F, (float)z + 0.6F);
		GL11.glScalef(0.9F, 0.9F, 0.9F);
			GL11.glRotatef(180, 0F, 0F, 1F);
			this.bindTexture(texture);
			GL11.glPushMatrix();
				this.model.renderModel(0.0625F);
			GL11.glPopMatrix();
		GL11.glPopMatrix();
		
	}
}
