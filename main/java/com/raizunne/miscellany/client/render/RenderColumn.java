/**
Code made by Raizunne as a part of Raizunne's Miscellany  
Source code found at github.com/Raizunne
 */
package com.raizunne.miscellany.client.render;

import org.lwjgl.opengl.GL11;

import com.raizunne.miscellany.Miscellany;
import com.raizunne.miscellany.client.model.ModelColumn1;
import com.raizunne.miscellany.client.model.ModelColumn2;
import com.raizunne.miscellany.client.model.ModelColumn3;
import com.raizunne.miscellany.client.model.ModelColumn4;
import com.raizunne.miscellany.client.model.modelAdvReactBrewer;
import com.raizunne.miscellany.tileentities.TileEntityColumn;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderColumn extends TileEntitySpecialRenderer{

	private static final ResourceLocation texture1 = new ResourceLocation(Miscellany.MODID + ":" + "textures/model/Column/Column1.png");
	private static final ResourceLocation texture2 = new ResourceLocation(Miscellany.MODID + ":" + "textures/model/Column/Column2.png");
	private static final ResourceLocation texture3 = new ResourceLocation(Miscellany.MODID + ":" + "textures/model/Column/Column3.png");
	private static final ResourceLocation texture4 = new ResourceLocation(Miscellany.MODID + ":" + "textures/model/Column/Column4.png");
	
	private ModelColumn1 state1;
	private ModelColumn2 state2;
	private ModelColumn3 state3;
	private ModelColumn4 state4;
	
	public RenderColumn() {
		this.state1 = new ModelColumn1();
		this.state2 = new ModelColumn2();
		this.state3 = new ModelColumn3();
		this.state4 = new ModelColumn4();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
//			GL11.glScalef(1.25F, 1.25F, 1.25F);
			GL11.glRotatef(180, 0F, 0F, 1F);
			TileEntityColumn te = (TileEntityColumn)tileentity;
			GL11.glPushMatrix();
			if(tileentity.getWorldObj()!=null){
				switch(te.getState()){
				case 0:
					this.bindTexture(texture1);
					this.state1.renderModel(0.0625F);
				break;
				case 1:
					this.bindTexture(texture2);
					this.state2.renderModel(0.0625F);
				break;
				case 2:
					this.bindTexture(texture3);
					this.state3.renderModel(0.0625F);
				break;
				case 3:
					this.bindTexture(texture4);
					this.state4.renderModel(0.0625F);
				break;
				default:
					this.bindTexture(texture1);
					this.state1.renderModel(0.0625F);
				break;
				}
			}else{
				this.bindTexture(texture1);
				this.state1.renderModel(0.0625F);
				
			}
			GL11.glPopMatrix();
		GL11.glPopMatrix();
		
	}

}
