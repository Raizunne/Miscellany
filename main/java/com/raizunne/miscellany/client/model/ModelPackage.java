package com.raizunne.miscellany.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

/**
 * Packager - Raizunne
 * Created using Tabula 4.0.2
 */
public class ModelPackage extends ModelBase {
    public ModelRenderer shape1;
    public ModelRenderer shape2;
    public ModelRenderer shape1_1;
    public ModelRenderer shape2_1;
    public ModelRenderer shape7;
    public ModelRenderer shape7_1;
    public ModelRenderer shape9;
    public ModelRenderer shape9_1;
    public ModelRenderer shape7_2;
    public ModelRenderer shape7_3;

    public ModelPackage() {
        this.textureWidth = 64;
        this.textureHeight = 80;
        this.shape7_2 = new ModelRenderer(this, 0, 0);
        this.shape7_2.setRotationPoint(-6.0F, 14.05F, -5.46F);
        this.shape7_2.addBox(0.0F, -0.01F, -2.1F, 12, 4, 6);
        this.setRotateAngle(shape7_2, 0.7853981633974483F, 0.0F, 0.0F);
        this.shape7_3 = new ModelRenderer(this, 0, 71);
        this.shape7_3.setRotationPoint(-6.0F, 14.05F, -5.46F);
        this.shape7_3.addBox(12.0F, -1.0F, -1.5F, 13, 1, 8);
        this.setRotateAngle(shape7_3, 0.7853981633974483F, 0.0F, 0.0F);
        this.shape9 = new ModelRenderer(this, 0, 51);
        this.shape9.setRotationPoint(-3.0F, 20.0F, -4.5F);
        this.shape9.addBox(0.0F, 0.0F, 0.0F, 6, 1, 6);
        this.shape7_1 = new ModelRenderer(this, 44, 6);
        this.shape7_1.setRotationPoint(-6.0F, 14.05F, -5.46F);
        this.shape7_1.addBox(2.0F, -0.5F, 0.0F, 2, 1, 2);
        this.setRotateAngle(shape7_1, 0.7853981633974483F, 0.0F, 0.0F);
        this.shape1 = new ModelRenderer(this, 0, 58);
        this.shape1.setRotationPoint(-4.0F, 22.0F, -6.0F);
        this.shape1.addBox(0.0F, 0.0F, 0.0F, 8, 2, 10);
        this.shape1_1 = new ModelRenderer(this, 0, 11);
        this.shape1_1.setRotationPoint(-6.0F, 16.0F, 2.0F);
        this.shape1_1.addBox(0.0F, 0.0F, 0.0F, 12, 8, 4);
        this.shape7 = new ModelRenderer(this, 0, 39);
        this.shape7.setRotationPoint(-6.0F, 13.0F, -2.0F);
        this.shape7.addBox(0.0F, -1.0F, 0.0F, 12, 4, 8);
        this.shape2 = new ModelRenderer(this, 0, 23);
        this.shape2.setRotationPoint(-6.0F, 16.0F, -6.0F);
        this.shape2.addBox(0.0F, 0.0F, 0.0F, 2, 8, 8);
        this.shape9_1 = new ModelRenderer(this, 25, 55);
        this.shape9_1.setRotationPoint(-1.0F, 21.0F, -2.5F);
        this.shape9_1.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2);
        this.shape2_1 = new ModelRenderer(this, 21, 23);
        this.shape2_1.setRotationPoint(4.0F, 16.0F, -6.0F);
        this.shape2_1.addBox(0.0F, 0.0F, 0.0F, 2, 8, 8);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
    	this.shape7_2.render(f5);
        GL11.glPushMatrix();
        GL11.glTranslatef(this.shape7_3.offsetX, this.shape7_3.offsetY, this.shape7_3.offsetZ);
        GL11.glTranslatef(this.shape7_3.rotationPointX * f5, this.shape7_3.rotationPointY * f5, this.shape7_3.rotationPointZ * f5);
        GL11.glScaled(0.4D, 0.4D, 0.4D);
        GL11.glTranslatef(-this.shape7_3.offsetX, -this.shape7_3.offsetY, -this.shape7_3.offsetZ);
        GL11.glTranslatef(-this.shape7_3.rotationPointX * f5, -this.shape7_3.rotationPointY * f5, -this.shape7_3.rotationPointZ * f5);
        this.shape7_3.render(f5);
        GL11.glPopMatrix();
        this.shape9.render(f5);
        this.shape7_1.render(f5);
        this.shape1.render(f5);
        this.shape1_1.render(f5);
        this.shape7.render(f5);
        this.shape2.render(f5);
        this.shape9_1.render(f5);
        this.shape2_1.render(f5);
    }
    
    public void renderModel(float f5){
    	this.shape7_2.render(f5);
        GL11.glPushMatrix();
        GL11.glTranslatef(this.shape7_3.offsetX, this.shape7_3.offsetY, this.shape7_3.offsetZ);
        GL11.glTranslatef(this.shape7_3.rotationPointX * f5, this.shape7_3.rotationPointY * f5, this.shape7_3.rotationPointZ * f5);
        GL11.glScaled(0.4D, 0.4D, 0.4D);
        GL11.glTranslatef(-this.shape7_3.offsetX, -this.shape7_3.offsetY, -this.shape7_3.offsetZ);
        GL11.glTranslatef(-this.shape7_3.rotationPointX * f5, -this.shape7_3.rotationPointY * f5, -this.shape7_3.rotationPointZ * f5);
        this.shape7_3.render(f5);
        GL11.glPopMatrix();
        this.shape9.render(f5);
        this.shape7_1.render(f5);
        this.shape1.render(f5);
        this.shape1_1.render(f5);
        this.shape7.render(f5);
        this.shape2.render(f5);
        this.shape9_1.render(f5);
        this.shape2_1.render(f5);
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
