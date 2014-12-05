/**
Code made by Raizunne as a part of Raizunne's Miscellany  
Source code found at github.com/Raizunne
 */
package com.raizunne.miscellany.client.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.raizunne.miscellany.Miscellany;
import com.raizunne.miscellany.client.model.modelTrophyBase;
import com.raizunne.miscellany.tileentities.TileEntityTrophyBase;

public class RenderTrophyBase extends TileEntitySpecialRenderer{

private static final ResourceLocation texture = new ResourceLocation(Miscellany.MODID + ":" + "textures/model/TrophyBase.png");
	
	private modelTrophyBase model;
	
	public RenderTrophyBase() {
		this.model = new modelTrophyBase();
	}
		
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.718F, (float)y+0.12F, (float)z+0.28F);
			GL11.glRotatef(180, 0F, 0F, 1F);
			this.bindTexture(texture);
			GL11.glPushMatrix();
				this.model.renderModel(0.0625F);
			GL11.glPopMatrix();
		GL11.glPopMatrix();
		
		TileEntityTrophyBase trophy = (TileEntityTrophyBase)tileentity;
		ItemStack item = trophy.getStackInSlot(0);
		if(item!=null){
			GL11.glPushMatrix();
			EntityItem entItem = new EntityItem(Minecraft.getMinecraft().thePlayer.getEntityWorld(), 0D, 0D, 0D, item);
			entItem.hoverStart = 0.0F;
			RenderItem.renderInFrame = true;
			if(item.getItem() instanceof ItemBlock){
				GL11.glTranslatef((float)x + 0.5F, (float)y + 0.3F, (float)z + 0.5F);
				GL11.glRotatef(90, 0, 1, 0);
				GL11.glScalef(0.8F, 0.8F, 0.8F);
			}else if(item.getItem() instanceof Item){
				GL11.glTranslatef((float)x + 0.5F, (float)y + 0.25F, (float)z + 0.5F);
				GL11.glRotatef(90, 0, 1, 0);
				GL11.glScalef(0.8F, 0.8F, 0.8F);
			}
			//WAYOFTIME ROCKS (code example for this)
			float rotationAngle = (float) (720.0 * (System.currentTimeMillis() & 0x3FFFL) / 0x3FFFL);
			GL11.glRotatef(rotationAngle, 0F, 1F, 0F);
			//WAYOFTIME ROCKS ENDS
			
			
			RenderManager.instance.renderEntityWithPosYaw(entItem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
			RenderItem.renderInFrame = true;
			GL11.glPopMatrix();
		}
		
	}

}
