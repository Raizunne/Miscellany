/**
Code made by Raizunne as a part of Raizunne's Miscellany  
Source code found at github.com/Raizunne
 */
package com.raizunne.miscellany.client.render;

import org.lwjgl.opengl.GL11;

import com.raizunne.miscellany.Miscellany;
import com.raizunne.miscellany.client.model.ModelFoodPackager;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderFoodPackager extends TileEntitySpecialRenderer{

private static final ResourceLocation texture = new ResourceLocation(Miscellany.MODID + ":" + "textures/model/FoodPackager.png");
	
	private ModelFoodPackager model; 
	
	public RenderFoodPackager() {
		this.model = new ModelFoodPackager();
	}
		
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y +1.5F, (float)z + 0.5F);
//		GL11.glScalef(0.9F, 0.9F, 0.9F);
			GL11.glRotatef(180, 0F, 0F, 1F);
			this.bindTexture(texture);
			GL11.glPushMatrix();
				this.model.renderModel(0.0625F);
			GL11.glPopMatrix();
		GL11.glPopMatrix();
		
	}
	
}
