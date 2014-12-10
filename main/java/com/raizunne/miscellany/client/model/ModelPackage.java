package com.raizunne.miscellany.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Package.tcn - TechneToTabulaImporter
 * Created using Tabula 4.0.2
 */
public class ModelPackage extends ModelBase {
    public ModelRenderer Base;
    public ModelRenderer TopHalf1;
    public ModelRenderer TopHalf2;
    public ModelRenderer LeftSide;
    public ModelRenderer RightSide;
    public ModelRenderer BackSide;
    public ModelRenderer TopSide;
    public ModelRenderer BaseTop;
    public ModelRenderer BaseBottom;
    public ModelRenderer Controls;
    public ModelRenderer Controls_1;

    public ModelPackage() {
        this.textureWidth = 80;
        this.textureHeight = 64;
        this.Controls = new ModelRenderer(this, 22, 59);
        this.Controls.setRotationPoint(-1.0F, 13.0F, -7.0F);
        this.Controls.addBox(0.0F, -4.0F, -0.5F, 6, 3, 1);
        this.setRotateAngle(Controls, -0.6457718232379019F, -0.0F, 0.0F);
        this.Controls_1 = new ModelRenderer(this, 0, 34);
        this.Controls_1.setRotationPoint(-1.0F, 13.0F, -7.0F);
        this.Controls_1.addBox(-3.2F, -3.5F, -0.5F, 2, 2, 1);
        this.setRotateAngle(Controls_1, -0.6457718232379019F, -0.0F, 0.0F);
        this.BaseTop = new ModelRenderer(this, 0, 43);
        this.BaseTop.setRotationPoint(-3.0F, 20.0F, -4.0F);
        this.BaseTop.addBox(0.0F, 0.0F, 0.0F, 6, 1, 6);
        this.BackSide = new ModelRenderer(this, 0, 51);
        this.BackSide.setRotationPoint(2.0F, 15.0F, 11.0F);
        this.BackSide.addBox(-6.0F, 0.0F, -6.0F, 8, 7, 2);
        this.LeftSide = new ModelRenderer(this, 31, 13);
        this.LeftSide.setRotationPoint(-1.0F, 13.0F, -1.0F);
        this.LeftSide.addBox(-6.0F, 0.0F, -6.0F, 3, 11, 14);
        this.Base = new ModelRenderer(this, 0, 0);
        this.Base.setRotationPoint(2.0F, 22.0F, -1.0F);
        this.Base.addBox(-6.0F, 0.0F, -6.0F, 8, 2, 14);
        this.TopHalf1 = new ModelRenderer(this, 21, 43);
        this.TopHalf1.setRotationPoint(-7.0F, 9.0F, -4.0F);
        this.TopHalf1.addBox(0.0F, 0.0F, 0.0F, 14, 4, 11);
        this.BaseBottom = new ModelRenderer(this, 0, 30);
        this.BaseBottom.setRotationPoint(-1.0F, 21.0F, -2.0F);
        this.BaseBottom.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2);
        this.TopSide = new ModelRenderer(this, 0, 26);
        this.TopSide.setRotationPoint(2.0F, 13.0F, -1.0F);
        this.TopSide.addBox(-6.0F, 0.0F, -6.0F, 8, 2, 14);
        this.RightSide = new ModelRenderer(this, 31, 13);
        this.RightSide.mirror = true;
        this.RightSide.setRotationPoint(10.0F, 13.0F, -1.0F);
        this.RightSide.addBox(-6.0F, 0.0F, -6.0F, 3, 11, 14);
        this.TopHalf2 = new ModelRenderer(this, 0, 17);
        this.TopHalf2.setRotationPoint(-7.0F, 13.0F, -7.0F);
        this.TopHalf2.addBox(0.0F, -5.0F, 0.0F, 14, 5, 3);
        this.setRotateAngle(TopHalf2, -0.6457718014717102F, -0.0F, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Controls.render(f5);
        this.Controls_1.render(f5);
        this.BaseTop.render(f5);
        this.BackSide.render(f5);
        this.LeftSide.render(f5);
        this.Base.render(f5);
        this.TopHalf1.render(f5);
        this.BaseBottom.render(f5);
        this.TopSide.render(f5);
        this.RightSide.render(f5);
        this.TopHalf2.render(f5);
    }
    
    public void renderModel(float f5){
    	 this.Controls.render(f5);
         this.Controls_1.render(f5);
         this.BaseTop.render(f5);
         this.BackSide.render(f5);
         this.LeftSide.render(f5);
         this.Base.render(f5);
         this.TopHalf1.render(f5);
         this.BaseBottom.render(f5);
         this.TopSide.render(f5);
         this.RightSide.render(f5);
         this.TopHalf2.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
