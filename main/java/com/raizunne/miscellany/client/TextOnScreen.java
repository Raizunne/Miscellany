/**
Code made by Raizunne as a part of Raizunne's Miscellany  
Source code found at github.com/Raizunne
 */
package com.raizunne.miscellany.client;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import com.raizunne.miscellany.MiscItems;
import com.raizunne.miscellany.block.Present;
import com.raizunne.miscellany.proxies.ClientProxy;
import com.raizunne.miscellany.tileentities.TileEntityPresent;
import com.raizunne.miscellany.util.Config;

public class TextOnScreen {

	public static void items(RenderGameOverlayEvent event){ 		
		if(Minecraft.getMinecraft().thePlayer.worldObj.isRemote){
			Minecraft minecraft = Minecraft.getMinecraft();
			if(minecraft.thePlayer.inventory.getCurrentItem()!=null){
				ItemStack item = minecraft.thePlayer.inventory.getCurrentItem();
				EntityPlayer player = minecraft.thePlayer;
					
				//KNOWLEDGE GEM
				if(Config.gemText){
					if(item.isItemEqual(new ItemStack(MiscItems.knowledgegem))){
						ItemStack itemerino = minecraft.thePlayer.inventory.getCurrentItem();
						if (event.isCancelable() || event.type != ElementType.TEXT) {
				               return;          
				        }
						
						String level;
						String xp;
						if(minecraft.thePlayer.isPotionActive(MiscItems.knowledgePotion)){
							level = "§kGem Level";
							xp = "§k" + itemerino.stackTagCompound.getInteger("xp") + "/" + itemerino.stackTagCompound.getInteger("max"); 
						}else{
							level = "Gem Level";
							xp = "" + itemerino.stackTagCompound.getInteger("xp") + "/" + itemerino.stackTagCompound.getInteger("max"); 
						}
					if(ClientProxy.donors!= null && ClientProxy.donors.contains(player.getDisplayName())){
						minecraft.fontRenderer.drawStringWithShadow("Donor! <3", (event.resolution.getScaledWidth()/2)+93, event.resolution.getScaledHeight() - 29, 0xFF0000);
					}
						minecraft.fontRenderer.drawStringWithShadow(level, (event.resolution.getScaledWidth()/2)+93, event.resolution.getScaledHeight() - 20, 0x33CC33);
						minecraft.fontRenderer.drawStringWithShadow(xp, (event.resolution.getScaledWidth()/2)+103, event.resolution.getScaledHeight() - 11, 0xCC00FF);
						return;
					}
				}
				
				//EXPLOSIVE CATALYST
				if(Config.explosiveText){
					if(item.stackTagCompound!=null && item.stackTagCompound.getBoolean("isthistheexplosivecatalyst")){
						ItemStack itemerino = minecraft.thePlayer.inventory.getCurrentItem();
						if (event.isCancelable() || event.type != ElementType.TEXT) {
				               return;          
				        }
						if(!item.stackTagCompound.getBoolean("enabled")){
							minecraft.fontRenderer.drawStringWithShadow("CATALYST ENABLED - CAREFUL", (event.resolution.getScaledWidth()/2)-75, event.resolution.getScaledHeight() -50, 0xFF3300);
						}
						minecraft.fontRenderer.drawStringWithShadow("Expl. Left", (event.resolution.getScaledWidth()/2)+93, event.resolution.getScaledHeight() - 20, 0xFF3300);
						if(!itemerino.stackTagCompound.getBoolean("creative")){
							minecraft.fontRenderer.drawStringWithShadow("" + itemerino.stackTagCompound.getInteger("uses"), (event.resolution.getScaledWidth()/2)+115, event.resolution.getScaledHeight() - 11, 0xCC00FF);
						}else{
							minecraft.fontRenderer.drawStringWithShadow("CREATIVE", (event.resolution.getScaledWidth()/2)+112, event.resolution.getScaledHeight() - 11, 0xCC00FF);
						}
						return;
					}
				}
				
				//THE FLUTE
				if(Config.fluteText){
					if(item.isItemEqual(new ItemStack(MiscItems.theflute))){
						ItemStack itemerino = minecraft.thePlayer.inventory.getCurrentItem();
						if (event.isCancelable() || event.type != ElementType.TEXT) {
				               return;          
				        }
						minecraft.fontRenderer.drawStringWithShadow("Flute Mode", (event.resolution.getScaledWidth()/2)+93, event.resolution.getScaledHeight() - 20, 0x33CC33);
						minecraft.fontRenderer.drawStringWithShadow(itemerino.stackTagCompound.getString("mode"), (event.resolution.getScaledWidth()/2)+98, event.resolution.getScaledHeight() - 11, 0xCC00FF);
						return;
					}
				}
				
				//PACKAGE
				if(item.isItemEqual(new ItemStack(MiscItems.pack))){
					ItemStack itemstack = minecraft.thePlayer.inventory.getCurrentItem();
					if (event.isCancelable() || event.type != ElementType.TEXT) {
			               return;          
			        }
					int id = itemstack.stackTagCompound.getInteger("item");
					int count = itemstack.stackTagCompound.getInteger("count");
					int meta = itemstack.stackTagCompound.getInteger("meta");
					String type = itemstack.stackTagCompound.getString("type");
					ItemStack stack;
					if(id!=0){
						if(type.equals("item")){
							stack = new ItemStack(Item.getItemById(id));
						}else{
							stack = new ItemStack(Block.getBlockById(id));
						}
						String name = stack.getDisplayName();					
						minecraft.fontRenderer.drawStringWithShadow("Contains:", (event.resolution.getScaledWidth()/2)+93, event.resolution.getScaledHeight() - 20, 0x33CC33);
						minecraft.fontRenderer.drawStringWithShadow("" + count + EnumChatFormatting.WHITE + " of " + EnumChatFormatting.BLUE + name, (event.resolution.getScaledWidth()/2)+93, event.resolution.getScaledHeight() - 11, 0xCC00FF);
					}else{
						minecraft.fontRenderer.drawStringWithShadow("Contains:", (event.resolution.getScaledWidth()/2)+93, event.resolution.getScaledHeight() - 20, 0x33CC33);
						minecraft.fontRenderer.drawStringWithShadow(EnumChatFormatting.GRAY + "Empty", (event.resolution.getScaledWidth()/2)+93, event.resolution.getScaledHeight() - 11, 0xCC00FF);
					}
					return;
				}
			}
		}
	}
	
	public static void blocks(RenderGameOverlayEvent event){
		Minecraft minecraft = Minecraft.getMinecraft();
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		if(player.worldObj.isRemote){
			MovingObjectPosition mop = player.rayTrace(200, 1.0F);
			Block block = player.worldObj.getBlock(mop.blockX, mop.blockY, mop.blockZ);
			if(block instanceof Present){
				if (event.isCancelable() || event.type != ElementType.TEXT) {
		               return;          
		        }
				if(player.getDistanceSq(mop.blockX + 0.5, mop.blockY + 0.5, mop.blockZ + 0.5) <= 25){
					TileEntityPresent present = (TileEntityPresent)player.worldObj.getTileEntity(mop.blockX, mop.blockY, mop.blockZ);
					int posx = event.resolution.getScaledWidth()/2;
					int posy = event.resolution.getScaledHeight()/2;
					minecraft.fontRenderer.drawStringWithShadow(EnumChatFormatting.RED + "From:" + EnumChatFormatting.RESET, posx+10, posy-8, 0x404040);
					minecraft.fontRenderer.drawStringWithShadow(EnumChatFormatting.RED + "To:" + EnumChatFormatting.RESET, posx+10, posy+2, 0x404040);
					if(present.getFrom()!=""){
						minecraft.fontRenderer.drawStringWithShadow(EnumChatFormatting.AQUA + present.getFrom() + EnumChatFormatting.RESET, posx+40, posy-8, 0x404040);
					}else{
						minecraft.fontRenderer.drawStringWithShadow(EnumChatFormatting.LIGHT_PURPLE  + "Set name by right clicking." + EnumChatFormatting.RESET , posx+40, posy-8, 0x404040);
					}
					if(present.getFor()!=""){
						minecraft.fontRenderer.drawStringWithShadow(EnumChatFormatting.GREEN + present.getFor() + EnumChatFormatting.RESET, posx+28, posy+2, 0x404040);
					}else{
						minecraft.fontRenderer.drawStringWithShadow(EnumChatFormatting.LIGHT_PURPLE + "Set name with a renamed paper." + EnumChatFormatting.RESET, posx+28, posy+2, 0x404040);
					}
				}
			}
		}
	}
}
