package com.raizunne.miscellany.handler;

import com.raizunne.miscellany.Miscellany;
import com.raizunne.miscellany.gui.ContainerAdvReactBrewer;
import com.raizunne.miscellany.gui.ContainerFoodPackager;
import com.raizunne.miscellany.gui.GuiAdvReactBrewer;
import com.raizunne.miscellany.gui.GuiFoodPackager;
import com.raizunne.miscellany.gui.GuiManualBooks;
import com.raizunne.miscellany.gui.GuiPamphlet;
import com.raizunne.miscellany.gui.GuiTest;
import com.raizunne.miscellany.tileentities.TileEntityAdvReactBrewer;
import com.raizunne.miscellany.tileentities.TileEntityFoodPackager;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class GUIHandler implements IGuiHandler {

	public GUIHandler(){
		NetworkRegistry.INSTANCE.registerGuiHandler(Miscellany.instance, this);
	}
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		switch(ID){
			case 0: if(te != null && te instanceof TileEntityFoodPackager){
				return new ContainerFoodPackager(player.inventory, (TileEntityFoodPackager)te);
			}
			break;
			case 1: if(te != null && te instanceof TileEntityAdvReactBrewer){
				return new ContainerAdvReactBrewer(player.inventory, (TileEntityAdvReactBrewer)te);
			}
			break;
			case 2: return null;
			default: return null;
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		switch(ID){
			case 0: if(te != null && te instanceof TileEntityFoodPackager){
				return new GuiFoodPackager(player.inventory, (TileEntityFoodPackager)te);
			}
			break;	
			case 1: if(te != null && te instanceof TileEntityAdvReactBrewer){
				return new GuiAdvReactBrewer(player.inventory,  (TileEntityAdvReactBrewer)te);
			}
			break;
			case 2: return new GuiManualBooks(player);
			case 3: return new GuiPamphlet();
			default: return null;
		}
		return null;
	}

}
