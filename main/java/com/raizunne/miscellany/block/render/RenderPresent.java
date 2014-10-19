package com.raizunne.miscellany.block.render;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.raizunne.miscellany.Miscellany;
import com.raizunne.miscellany.block.model.ModelFoodPackager;
import com.raizunne.miscellany.block.model.modelPresent;

public class RenderPresent extends TileEntitySpecialRenderer{

	private static final ResourceLocation texture = new ResourceLocation(Miscellany.MODID + ":" + "textures/model/present.png");
	
	private modelPresent model;
	
	public RenderPresent() {
		this.model = new modelPresent();
	}
	
	
	
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5675F, (float)y + 0.75F, (float)z + 0.4325F);
			GL11.glRotatef(180, 0F, 0F, 1F);
			this.bindTexture(texture);
			GL11.glPushMatrix();
				this.model.renderModel(0.0625F);
			GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
}