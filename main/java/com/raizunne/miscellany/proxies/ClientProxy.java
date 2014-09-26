package com.raizunne.miscellany.proxies;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

import com.raizunne.miscellany.MiscBlocks;
import com.raizunne.miscellany.MiscItems;
import com.raizunne.miscellany.block.render.ItemAdvReactBrewer;
import com.raizunne.miscellany.block.render.ItemFoodPackager;
import com.raizunne.miscellany.block.render.ItemPackage;
import com.raizunne.miscellany.block.render.ItemPresent;
import com.raizunne.miscellany.block.render.RenderAdvReactBrewer;
import com.raizunne.miscellany.block.render.RenderFoodPackager;
import com.raizunne.miscellany.block.render.RenderPackage;
import com.raizunne.miscellany.block.render.RenderPresent;
import com.raizunne.miscellany.item.model.render.ItemChaliceRender;
import com.raizunne.miscellany.tileentities.TileEntityAdvReactBrewer;
import com.raizunne.miscellany.tileentities.TileEntityFoodPackager;
import com.raizunne.miscellany.tileentities.TileEntityPackage;
import com.raizunne.miscellany.tileentities.TileEntityPresent;

import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy
{		
	public void initRenderers(){
		//FoodPackager
		TileEntitySpecialRenderer foodPackager = new RenderFoodPackager();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFoodPackager.class, foodPackager);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(MiscBlocks.foodPackager), new ItemFoodPackager(foodPackager, new TileEntityFoodPackager()));
		
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
		
		
		
	}
}
