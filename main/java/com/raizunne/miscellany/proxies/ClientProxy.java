package com.raizunne.miscellany.proxies;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

import com.raizunne.miscellany.Miscellany;
import com.raizunne.miscellany.block.render.ItemAdvReactBrewer;
import com.raizunne.miscellany.block.render.ItemFoodPackager;
import com.raizunne.miscellany.block.render.ItemPresent;
import com.raizunne.miscellany.block.render.RenderAdvReactBrewer;
import com.raizunne.miscellany.block.render.RenderFoodPackager;
import com.raizunne.miscellany.block.render.RenderPresent;
import com.raizunne.miscellany.item.model.render.ItemChaliceRender;
import com.raizunne.miscellany.tileentities.TileEntityAdvReactBrewer;
import com.raizunne.miscellany.tileentities.TileEntityFoodPackager;
import com.raizunne.miscellany.tileentities.TileEntityPresent;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ClientProxy extends CommonProxy
{		
	public void initRenderers(){
		//FoodPackager
		TileEntitySpecialRenderer foodPackager = new RenderFoodPackager();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFoodPackager.class, foodPackager);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Miscellany.foodPackager), new ItemFoodPackager(foodPackager, new TileEntityFoodPackager()));
		
		//Present
		TileEntitySpecialRenderer present = new RenderPresent();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPresent.class, present);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Miscellany.present), new ItemPresent(present, new TileEntityPresent()));
		
		//AdvReactBrewer
		TileEntitySpecialRenderer brewer = new RenderAdvReactBrewer();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAdvReactBrewer.class, brewer);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Miscellany.brewer), new ItemAdvReactBrewer(brewer, new TileEntityAdvReactBrewer()));
		
		MinecraftForgeClient.registerItemRenderer(Miscellany.sacredChalice, new ItemChaliceRender());
		
	}
}
