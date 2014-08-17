package com.raizunne.miscellany.item.model.render;

import org.lwjgl.opengl.GL11;

import com.raizunne.miscellany.Miscellany;
import com.raizunne.miscellany.item.model.Chalice;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.IItemRenderer;

public class ItemChaliceRender implements IItemRenderer{
	protected Chalice chaliceModel;
	private static final ResourceLocation texture = new ResourceLocation(Miscellany.MODID + ":" + "textures/model/Chalice.png");
	public ItemChaliceRender(){
		chaliceModel = new Chalice();
	}
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type){
		if(type==ItemRenderType.INVENTORY || type==ItemRenderType.ENTITY){
			return false;
		}else{
			return true;
		}
	}
	
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper){
		return true;
	}
	
	public void renderItem(ItemRenderType type, ItemStack item, Object... data){
		switch(type){
		case EQUIPPED:
			float scale = 0.20F;
			GL11.glScalef(scale, scale, scale);
			GL11.glRotatef(-225F, 1.0F, 0F, 0F);
			GL11.glRotatef(-10F, 10.0F, 0F, 20F);
			GL11.glRotatef(-10F, 20.0F, 0F, 20F);
			GL11.glTranslatef(2F, -5F, -2F);
			break;
		case EQUIPPED_FIRST_PERSON:
			float scale2 = 0.4F;
			GL11.glScalef(scale2, scale2, scale2);
			GL11.glTranslatef(5F, 6F, 0.0F);
			GL11.glRotatef(-180F, 10.0F, 0F, 0F);
			break;
		case ENTITY:
			float scale3 = 0.2F;
			GL11.glScalef(scale3, scale3, scale3);
			GL11.glRotatef(-180F, 0F, 0F, 0F);
			GL11.glTranslatef(0F, -10F, 0F);
		break;
		default:
			break;
		}
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		chaliceModel.render((Entity)data[1], 0F, 0F, 0F, 0F, 0F, 0.625F);
	}
}
