package com.raizunne.miscellany.client.render;

import net.minecraft.block.Block;
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
import com.raizunne.miscellany.client.model.ModelPackage;
import com.raizunne.miscellany.tileentities.TileEntityPackage;

public class RenderPackage extends TileEntitySpecialRenderer{

	private static final ResourceLocation texture = new ResourceLocation(Miscellany.MODID + ":" + "textures/model/Packager/Package.png");
	private static final ResourceLocation texture2 = new ResourceLocation(Miscellany.MODID + ":" + "textures/model/Packager/Package2.png");
	
	private ModelPackage model;
	
	public RenderPackage() {
		this.model = new ModelPackage();
	}
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
		TileEntityPackage pack = (TileEntityPackage)tileentity;
		int metadata;
		if(pack.hasWorldObj()==true){
			metadata = pack.getBlockMetadata();
		}else{
			metadata = 1;
		}
		
		ItemStack item = pack.getStackInSlot(4);
		
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		switch(metadata){
			case 0: GL11.glRotatef(0, 0F, 0F, 0F);
				break;
			case 1: GL11.glRotatef(-90, 0F, 180F, 1F);
				if(pack.hasWorldObj()==false){
					GL11.glRotatef(270F, 0F, 1F, 0F);
				}
				break;
			case 2: GL11.glRotatef(180, 0F, 180F, 0F);
				break;
			case 3: GL11.glRotatef(90, 0F, 180F, 0F);
				break;
		}	
		GL11.glRotatef(180, 0F, 0F, 1F);
		if(pack.getProgress()==0){
			this.bindTexture(texture);
		}else{
			this.bindTexture(texture2);
		}
			GL11.glPushMatrix();
				this.model.renderModel(0.0625F);
			GL11.glPopMatrix();
		GL11.glPopMatrix();
		
		for(int i=0; i<pack.getSizeInventory(); i++){
			if(item!=null){
				GL11.glPushMatrix();
				EntityItem entItem = new EntityItem(Minecraft.getMinecraft().thePlayer.getEntityWorld(), 0D, 0D, 0D, item);
				entItem.hoverStart = 0.0F;
				switch(metadata){
				case 0:
					RenderItem.renderInFrame = true;
					if(item.getItem() instanceof ItemBlock){
						GL11.glTranslatef((float)x + 0.5F, (float)y + 0.25F, (float)z + 0.5F);
						GL11.glRotatef(45, 0, -45, 0);
						GL11.glScalef(0.7F, 0.7F, 0.7F);
					}else if(item.getItem() instanceof Item){
						GL11.glTranslatef((float)x + 0.51F, (float)y + 0.27F, (float)z + 0.28F);
						GL11.glRotatef(180F, 0F, 1F, 1F);
						GL11.glScalef(0.8F, 0.8F, 0.8F);
					}
					break;				
				case 1: 
					RenderItem.renderInFrame = true;
					if(item.getItem() instanceof ItemBlock){
						GL11.glTranslatef((float)x + 0.5F, (float)y + 0.25F, (float)z + 0.5F);
						GL11.glRotatef(45, 0, -45, 0);
						GL11.glScalef(0.7F, 0.7F, 0.7F);
					}else if(item.getItem() instanceof Item){
						GL11.glTranslatef((float)x + 0.705F, (float)y + 0.27F, (float)z + 0.50F); //0.27
						GL11.glRotatef(90F, 0F, 0F, 1F);
						GL11.glRotatef(90F, 0F, 1F, 0F);
						GL11.glScalef(0.8F, 0.8F, 0.8F);
					}
					break;
				case 2:
					RenderItem.renderInFrame = true;
					if(item.getItem() instanceof ItemBlock){
						GL11.glTranslatef((float)x + 0.5F, (float)y + 0.25F, (float)z + 0.5F);
						GL11.glRotatef(45, 0, -45, 0);
						GL11.glScalef(0.7F, 0.7F, 0.7F);
					}else if(item.getItem() instanceof Item){
						GL11.glTranslatef((float)x + 0.51F, (float)y + 0.27F, (float)z + 0.71F);
						GL11.glRotatef(1F, 0F, 0F, 0F);
						GL11.glRotatef(90F, -360F, 0F, 0F);
						GL11.glScalef(0.8F, 0.8F, 0.8F);
					}
					break;
				case 3:
					RenderItem.renderInFrame = true;
					if(item.getItem() instanceof ItemBlock){
						GL11.glTranslatef((float)x + 0.5F, (float)y + 0.25F, (float)z + 0.5F);
						GL11.glRotatef(45, 0, -45, 0);
						GL11.glScalef(0.7F, 0.7F, 0.7F);
					}else if(item.getItem() instanceof Item){
						GL11.glTranslatef((float)x + 0.42F, (float)y + 0.26F, (float)z + 0.35F);
						GL11.glRotatef(1F, 0F, 0F, 0F);
						GL11.glRotatef(90F, 360F, 0F, 0F);
						GL11.glScalef(0.8F, 0.8F, 0.8F);
					}
					break;
				}
				RenderManager.instance.renderEntityWithPosYaw(entItem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
				RenderItem.renderInFrame = true;
				GL11.glPopMatrix();
			}
		}
	}
}