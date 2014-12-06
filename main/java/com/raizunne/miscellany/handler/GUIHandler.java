package com.raizunne.miscellany.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.raizunne.miscellany.Miscellany;
import com.raizunne.miscellany.gui.ContainerAdvReactBrewer;
import com.raizunne.miscellany.gui.ContainerFoodPackager;
import com.raizunne.miscellany.gui.ContainerPackage;
import com.raizunne.miscellany.gui.ContainerPresent;
import com.raizunne.miscellany.gui.GuiAdvReactBrewer;
import com.raizunne.miscellany.gui.GuiFoodPackager;
import com.raizunne.miscellany.gui.GuiManualBooks;
import com.raizunne.miscellany.gui.GuiPackage;
import com.raizunne.miscellany.gui.GuiPamphlet;
import com.raizunne.miscellany.gui.GuiPresent;
import com.raizunne.miscellany.tileentities.TileEntityAdvReactBrewer;
import com.raizunne.miscellany.tileentities.TileEntityFoodPackager;
import com.raizunne.miscellany.tileentities.TileEntityPackage;
import com.raizunne.miscellany.tileentities.TileEntityPresent;

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
			case 4: if(te != null && te instanceof TileEntityPresent){
				return new ContainerPresent(player.inventory, (TileEntityPresent)te);
			}
			break;
			case 5: if(te != null && te instanceof TileEntityPackage){
				return new ContainerPackage(player.inventory, (TileEntityPackage)te);
			}
			break;
			default: return null;
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		switch(ID){
			case 0: if(te != null && te instanceof TileEntityFoodPackager){
				return new GuiFoodPackager(player.inventory,  (TileEntityFoodPackager)te);
			}
			break;	
			case 1: if(te != null && te instanceof TileEntityAdvReactBrewer){
				return new GuiAdvReactBrewer(player.inventory,  (TileEntityAdvReactBrewer)te);
			}
			break;
			case 2: return new GuiManualBooks(player);
			case 3: return new GuiPamphlet();
			case 4: if(te != null && te instanceof TileEntityPresent){
				return new GuiPresent(player.inventory, (TileEntityPresent)te);
			}
			break;
			case 5: if(te != null && te instanceof TileEntityPackage){
				return new GuiPackage(player.inventory, (TileEntityPackage)te);
			}
			break;
			default: return null;
		}
		return null;
	}

}
