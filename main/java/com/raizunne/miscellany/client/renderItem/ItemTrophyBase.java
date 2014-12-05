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

public class ItemTrophyBase implements IItemRenderer{

	TileEntitySpecialRenderer render;
	private TileEntity entity;
	
	public ItemTrophyBase(TileEntitySpecialRenderer render, TileEntity entity){
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
			GL11.glScalef(1.5F, 1.5F, 1.5F);
			GL11.glTranslatef(0.05F, 0F, 1F);
			GL11.glRotatef(30, 0F, 1F, 1F);
			GL11.glRotatef(90, 0F, 1F, 0F);
			break;
		case EQUIPPED_FIRST_PERSON:
			GL11.glTranslatef(0.15F, 0.9F, 1.3F);
			GL11.glRotatef(150, 0, 1F, 0);
			break;
		case ENTITY:
			GL11.glTranslatef(-0.05F, -0.7F, -0.05F);
			GL11.glRotatef(240, 0F, 1F, 0);
			GL11.glScalef(1.5F, 1.5F, 1.5F);
			break;
		case INVENTORY:
			GL11.glTranslatef(1.9F, 2.2F, 1.9F);
			GL11.glScalef(1.8F, 1.8F, 1.8F);
			break;
		default:
			break;
		}
		this.render.renderTileEntityAt(this.entity, 0.0D, -0.1D, 0.0D, 0.0F);
	}

	
}
