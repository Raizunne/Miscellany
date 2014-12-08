/**
Code made by Raizunne as a part of Raizunne's Miscellany  
Source code found at github.com/Raizunne
 */
package com.raizunne.miscellany.client.render;

import java.util.Random;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.raizunne.miscellany.Miscellany;
import com.raizunne.miscellany.client.model.ModelFoodPackager;
import com.raizunne.miscellany.tileentities.TileEntityFoodPackager;

public class RenderFoodPackager extends TileEntitySpecialRenderer{

	private static final ResourceLocation tex1 = new ResourceLocation(Miscellany.MODID + ":" + "textures/model/FoodPackager/1.png");
	private static final ResourceLocation tex2 = new ResourceLocation(Miscellany.MODID + ":" + "textures/model/FoodPackager/2.png");
	private static final ResourceLocation tex3 = new ResourceLocation(Miscellany.MODID + ":" + "textures/model/FoodPackager/3.png");
	private static final ResourceLocation tex4 = new ResourceLocation(Miscellany.MODID + ":" + "textures/model/FoodPackager/4.png");
	int meta;
	
	private ModelFoodPackager model; 
	Random random;
	
	public RenderFoodPackager() {
		this.model = new ModelFoodPackager();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
		
		TileEntityFoodPackager te = (TileEntityFoodPackager)tileentity;
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y +1.5F, (float)z + 0.5F);
		GL11.glRotatef(180, 0F, 0F, 1F);
		if(tileentity.getWorldObj()!=null){
			meta = tileentity.getWorldObj().getBlockMetadata(tileentity.xCoord, tileentity.yCoord, tileentity.zCoord);
			switch(meta){
			case 1:
				GL11.glRotatef(90, 0, 1, 0);
			break;
			case 2:
				GL11.glRotatef(180, 0, 1, 0);
			break;
			case 3:
				GL11.glRotatef(-90, 0, 1, 0);
			break;
			}
		}
		if(te.calories()>=1000){
			this.bindTexture(tex4);
		}else{
			this.bindTexture(tex1);
		}
		GL11.glPushMatrix();
			this.model.renderModel(0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		
	}
	
}
