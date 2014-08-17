package com.raizunne.miscellany.proxies;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;

import com.raizunne.miscellany.Miscellany;
import com.raizunne.miscellany.block.render.ItemFoodPackager;
import com.raizunne.miscellany.block.render.RenderFoodPackager;
import com.raizunne.miscellany.tileentities.TileEntityFoodPackager;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {

		return null;
	}
	
	public void initRenderers(){
	}
	
	

}
