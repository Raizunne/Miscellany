package com.raizunne.miscellany.block.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.IItemRenderer;

public class ItemFoodPackager implements IItemRenderer{

	TileEntitySpecialRenderer render;
	private TileEntity entity;
	
	public ItemFoodPackager(TileEntitySpecialRenderer render, TileEntity entity){
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
			GL11.glTranslatef(-0.5F, 0.0F, -0.5F);
			break;
		case EQUIPPED_FIRST_PERSON:
			GL11.glTranslatef(0.25F, 0.5F, 1F);
			GL11.glRotatef(180, 0, 1F, 0);
			break;
		default:
			break;
			
		}
		this.render.renderTileEntityAt(this.entity, 0.0D, -0.1D, 0.0D, 0.0F);
	}

}
