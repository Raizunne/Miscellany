package com.raizunne.miscellany.proxies;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

import com.raizunne.miscellany.MiscBlocks;
import com.raizunne.miscellany.MiscItems;
import com.raizunne.miscellany.client.render.RenderAdvReactBrewer;
import com.raizunne.miscellany.client.render.RenderHeart;
import com.raizunne.miscellany.client.render.RenderPackage;
import com.raizunne.miscellany.client.render.RenderPresent;
import com.raizunne.miscellany.client.render.RenderTrophyBase;
import com.raizunne.miscellany.client.renderItem.ItemAdvReactBrewer;
import com.raizunne.miscellany.client.renderItem.ItemChaliceRender;
import com.raizunne.miscellany.client.renderItem.ItemFoodPackager;
import com.raizunne.miscellany.client.renderItem.ItemHeart;
import com.raizunne.miscellany.client.renderItem.ItemPackage;
import com.raizunne.miscellany.client.renderItem.ItemPresent;
import com.raizunne.miscellany.client.renderItem.ItemTrophyBase;
import com.raizunne.miscellany.tileentities.TileEntityAdvReactBrewer;
import com.raizunne.miscellany.tileentities.TileEntityHeart;
import com.raizunne.miscellany.tileentities.TileEntityPackage;
import com.raizunne.miscellany.tileentities.TileEntityPresent;
import com.raizunne.miscellany.tileentities.TileEntityTrophyBase;

import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy
{		
	public void initRenderers(){
		//Present
		TileEntitySpecialRenderer present = new RenderPresent();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPresent.class, present);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(MiscBlocks.present), new ItemPresent(present, new TileEntityPresent()));
		
		//Package
		TileEntitySpecialRenderer pack = new RenderPackage();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPackage.class, pack);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(MiscBlocks.thepackage), new ItemPackage(pack, new TileEntityPackage()));
		
		//AdvReactBrewer
		TileEntitySpecialRenderer brewer = new RenderAdvReactBrewer();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAdvReactBrewer.class, brewer);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(MiscBlocks.brewer), new ItemAdvReactBrewer(brewer, new TileEntityAdvReactBrewer()));
		
		//Chalice
		MinecraftForgeClient.registerItemRenderer(MiscItems.sacredChalice, new ItemChaliceRender());
		
		//Heart
		TileEntitySpecialRenderer heart = new RenderHeart();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHeart.class, heart);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(MiscBlocks.heart), new ItemHeart(heart, new TileEntityHeart()));
		
		//Trophy
		TileEntitySpecialRenderer trophy = new RenderTrophyBase();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTrophyBase.class, trophy);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(MiscBlocks.trophybase), new ItemTrophyBase(trophy, new TileEntityTrophyBase()));
	}
	
}
