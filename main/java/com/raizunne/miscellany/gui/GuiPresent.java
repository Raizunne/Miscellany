package com.raizunne.miscellany.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.raizunne.miscellany.gui.button.buttonMenu;
import com.raizunne.miscellany.tileentities.TileEntityPresent;

public class GuiPresent extends GuiContainer{

	private TileEntityPresent present;
	
	public GuiPresent(InventoryPlayer invplayer, TileEntityPresent present) {
		super(new ContainerPresent(invplayer, present));
		this.present = (TileEntityPresent) present;
		xSize = 176;
		ySize = 166;
	}
	
	public static final ResourceLocation texture = new ResourceLocation("miscellany", "textures/gui/presentGUI.png");
	GuiTextField textfield;
	boolean set;
		
	@Override
	protected void drawGuiContainerBackgroundLayer(float f,	int x, int y) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		mc.renderEngine.bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		if(present.userFor==null){
			mc.renderEngine.bindTexture(texture);
			drawTexturedModalRect(guiLeft + 38, guiTop + 33, 0, 166, 100, 16);
		}
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y) {
		super.drawGuiContainerForegroundLayer(x, y);
		fontRendererObj.drawString("Present", 15, 6, 0x404040);
		fontRendererObj.drawString("From:", 22, 20, 0x404040);
		fontRendererObj.drawString("To:", 22, 36, 0x404040);
		fontRendererObj.drawString(present.userSender, 55, 20, 0x404040);
		if(present.userFor==null){
			this.textfield.drawTextBox();
		}
		if(present.userFor!=null || set){
			fontRendererObj.drawString(present.userFor, 40, 36, 0x404040);
		}
	}
	
	@Override
	public void initGui() {
		super.initGui();
		textfield = new GuiTextField(fontRendererObj, 42, 36, 85, 16);
		textfield.setTextColor(0xE65C5C);
		textfield.setEnableBackgroundDrawing(true);
    	textfield.setFocused(true);
    	textfield.setMaxStringLength(15);
    	textfield.setEnableBackgroundDrawing(false);    	
    	buttonMenu menu0 = new buttonMenu(0, guiLeft + 140, guiTop + 34, 90, 12, "Done", 0x999999, 0x565656, false);
    	buttonMenu test = new buttonMenu(1, guiLeft + 50, guiTop + 10, 90, 12, "Hey", 0x999999, 0x565656, false);
    	buttonList.add(test);
    	if(present.userFor==null){
    		buttonList.add(menu0);
    	}
    	if(present.userFor!=null || set){
    		buttonList.remove(menu0);
    	}
    	
    }
	
	@Override
	protected void actionPerformed(GuiButton button) {
		super.actionPerformed(button);
		switch(button.id){
		case 0: 
			if(textfield.getText()!=""){
				present.userFor=textfield.getText();
			}
		break;
		case 1:
			System.out.println("For:" + present.userFor);
			System.out.println("From" + present.userSender);
		}
	}

	@Override
    public void updateScreen(){
        super.updateScreen();
		textfield.updateCursorCounter();
    }
	
	protected void keyTyped(char par1, int par2){
        super.keyTyped(par1, par2);
        this.textfield.textboxKeyTyped(par1, par2);
    }
	
	@Override
	protected void mouseClicked(int x, int y, int btn){
        super.mouseClicked(x, y, btn);
        this.textfield.mouseClicked(x-guiLeft, y-guiTop, btn);
        this.initGui();
    }
}
