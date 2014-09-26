package com.raizunne.miscellany.block.render;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.raizunne.miscellany.Miscellany;
import com.raizunne.miscellany.block.model.ModelFoodPackager;
import com.raizunne.miscellany.tileentities.TileEntityFoodPackager;

public class RenderFoodPackager extends TileEntitySpecialRenderer{

	private static final ResourceLocation texture = new ResourceLocation(Miscellany.MODID + ":" + "textures/model/foodPackager.png");
	
	private ModelFoodPackager model;
	
	public RenderFoodPackager() {
		this.model = new ModelFoodPackager();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
		TileEntityFoodPackager te = (TileEntityFoodPackager)tileentity;
		int metadata;
		if(te.hasWorldObj()==true){
			metadata = te.getBlockMetadata();
		}else{
			metadata = 1;
		}

		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1F, (float)z + 0.5F);
		
			switch(metadata){
				case 0: GL11.glRotatef(0, 0F, 0F, 1F);
					break;
				case 1: GL11.glRotatef(-90, 0F, 180F, 1F);
					break;
				case 2: GL11.glRotatef(180, 0F, 180F, 1F);
					break;
				case 3: GL11.glRotatef(90, 0F, 180F, 1F);
					break;
		}
			GL11.glRotatef(180, 0F, 0F, 1F);
			this.bindTexture(texture);
			GL11.glPushMatrix();
				this.model.renderModel(0.0625F);
			GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
}
