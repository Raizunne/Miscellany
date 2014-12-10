/**
Code made by Raizunne as a part of Raizunne's Miscellany  
Source code found at github.com/Raizunne
 */
package com.raizunne.miscellany.client.renderItem;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;

public class ItemColumn implements IItemRenderer{

	TileEntitySpecialRenderer render;
	private TileEntity entity;
	
	public ItemColumn(TileEntitySpecialRenderer render, TileEntity entity){
		this.entity = entity;
		this.render = render;
	}
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		switch(type){
		case EQUIPPED:
			GL11.glTranslatef(0F, 0.1F, 0F);
			break;
		case EQUIPPED_FIRST_PERSON:
			GL11.glScalef(1.5F, 1.5F, 1.5F);
			GL11.glTranslatef(0.2F, -0.3F, 0.8F);
			GL11.glRotatef(180, 0, 1, 0);
			GL11.glRotatef(270, 0, 1, 0);
			break;
		case ENTITY:
//			GL11.glScalef(0.75F, 0.75F, 0.75F);
			GL11.glTranslatef(-0.5F, -0.3F, -0.5F);
			break;
		case INVENTORY:
//			GL11.glScalef(0.75F, 0.75F, 0.75F);
			GL11.glRotatef(180, 0F, 1F, 0F);
			GL11.glTranslatef(0F, -0.85F, 0F);
			break;
		default:
			break;
			
		}
		this.render.renderTileEntityAt(this.entity, 0.0D, -0.1D, 0.0D, 0.0F);
	}

}
