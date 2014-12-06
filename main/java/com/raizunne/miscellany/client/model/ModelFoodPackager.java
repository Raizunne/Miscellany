package com.raizunne.miscellany.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

/**
 * FoodPackager - Raizunne
 * Created using Tabula 4.0.2
 */
public class ModelFoodPackager extends ModelBase {
    public ModelRenderer shape1;
    public ModelRenderer shape2;
    public ModelRenderer shape3;
    public ModelRenderer shape3_1;
    public ModelRenderer shape3_2;
    public ModelRenderer shape3_3;
    public ModelRenderer shape3_4;

    public ModelFoodPackager() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.shape2 = new ModelRenderer(this, 0, 29);
        this.shape2.setRotationPoint(-8.0F, 8.0F, -2.0F);
        this.shape2.addBox(0.0F, 0.0F, 0.0F, 16, 4, 10);
        this.shape3_4 = new ModelRenderer(this, 32, 60);
        this.shape3_4.setRotationPoint(-5.0F, 12.0F, -8.0F);
        this.shape3_4.addBox(2.0F, -0.5F, 4.4F, 1, 1, 1);
        this.setRotateAngle(shape3_4, 0.593411945678072F, 0.0F, 0.0F);
        this.shape3_2 = new ModelRenderer(this, 0, 57);
        this.shape3_2.setRotationPoint(-6.0F, 12.0F, -8.0F);
        this.shape3_2.addBox(5.0F, -0.5F, 2.0F, 7, 1, 4);
        this.setRotateAngle(shape3_2, 0.593411945678072F, 0.0F, 0.0F);
        this.shape3_3 = new ModelRenderer(this, 23, 59);
        this.shape3_3.setRotationPoint(-5.0F, 12.0F, -8.0F);
        this.shape3_3.addBox(-1.0F, -0.5F, 3.0F, 2, 1, 2);
        this.setRotateAngle(shape3_3, 0.593411945678072F, 0.0F, 0.0F);
        this.shape3 = new ModelRenderer(this, 37, 60);
        this.shape3.setRotationPoint(-5.0F, 12.0F, -8.0F);
        this.shape3.addBox(2.0F, -0.5F, 2.6F, 1, 1, 1);
        this.setRotateAngle(shape3, 0.593411945678072F, 0.0F, 0.0F);
        this.shape3_1 = new ModelRenderer(this, 0, 44);
        this.shape3_1.setRotationPoint(-8.0F, 12.0F, -8.0F);
        this.shape3_1.addBox(0.0F, 0.0F, 0.0F, 16, 4, 8);
        this.setRotateAngle(shape3_1, 0.593411945678072F, 0.0F, 0.0F);
        this.shape1 = new ModelRenderer(this, 0, 0);
        this.shape1.setRotationPoint(-8.0F, 12.0F, -8.0F);
        this.shape1.addBox(0.0F, 0.0F, 0.0F, 16, 12, 16);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.shape2.render(f5);
        GL11.glPushMatrix();
        GL11.glTranslatef(this.shape3_4.offsetX, this.shape3_4.offsetY, this.shape3_4.offsetZ);
        GL11.glTranslatef(this.shape3_4.rotationPointX * f5, this.shape3_4.rotationPointY * f5, this.shape3_4.rotationPointZ * f5);
        GL11.glScaled(1.0D, 0.9D, 0.9D);
        GL11.glTranslatef(-this.shape3_4.offsetX, -this.shape3_4.offsetY, -this.shape3_4.offsetZ);
        GL11.glTranslatef(-this.shape3_4.rotationPointX * f5, -this.shape3_4.rotationPointY * f5, -this.shape3_4.rotationPointZ * f5);
        this.shape3_4.render(f5);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.shape3_2.offsetX, this.shape3_2.offsetY, this.shape3_2.offsetZ);
        GL11.glTranslatef(this.shape3_2.rotationPointX * f5, this.shape3_2.rotationPointY * f5, this.shape3_2.rotationPointZ * f5);
        GL11.glScaled(1.0D, 0.9D, 0.9D);
        GL11.glTranslatef(-this.shape3_2.offsetX, -this.shape3_2.offsetY, -this.shape3_2.offsetZ);
        GL11.glTranslatef(-this.shape3_2.rotationPointX * f5, -this.shape3_2.rotationPointY * f5, -this.shape3_2.rotationPointZ * f5);
        this.shape3_2.render(f5);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.shape3_3.offsetX, this.shape3_3.offsetY, this.shape3_3.offsetZ);
        GL11.glTranslatef(this.shape3_3.rotationPointX * f5, this.shape3_3.rotationPointY * f5, this.shape3_3.rotationPointZ * f5);
        GL11.glScaled(1.0D, 0.9D, 0.9D);
        GL11.glTranslatef(-this.shape3_3.offsetX, -this.shape3_3.offsetY, -this.shape3_3.offsetZ);
        GL11.glTranslatef(-this.shape3_3.rotationPointX * f5, -this.shape3_3.rotationPointY * f5, -this.shape3_3.rotationPointZ * f5);
        this.shape3_3.render(f5);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.shape3.offsetX, this.shape3.offsetY, this.shape3.offsetZ);
        GL11.glTranslatef(this.shape3.rotationPointX * f5, this.shape3.rotationPointY * f5, this.shape3.rotationPointZ * f5);
        GL11.glScaled(1.0D, 0.9D, 0.9D);
        GL11.glTranslatef(-this.shape3.offsetX, -this.shape3.offsetY, -this.shape3.offsetZ);
        GL11.glTranslatef(-this.shape3.rotationPointX * f5, -this.shape3.rotationPointY * f5, -this.shape3.rotationPointZ * f5);
        this.shape3.render(f5);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.shape3_1.offsetX, this.shape3_1.offsetY, this.shape3_1.offsetZ);
        GL11.glTranslatef(this.shape3_1.rotationPointX * f5, this.shape3_1.rotationPointY * f5, this.shape3_1.rotationPointZ * f5);
        GL11.glScaled(1.0D, 0.9D, 0.9D);
        GL11.glTranslatef(-this.shape3_1.offsetX, -this.shape3_1.offsetY, -this.shape3_1.offsetZ);
        GL11.glTranslatef(-this.shape3_1.rotationPointX * f5, -this.shape3_1.rotationPointY * f5, -this.shape3_1.rotationPointZ * f5);
        this.shape3_1.render(f5);
        GL11.glPopMatrix();
        this.shape1.render(f5);
    }
    
    public void renderModel(float f5){
    	this.shape2.render(f5);
        GL11.glPushMatrix();
        GL11.glTranslatef(this.shape3_4.offsetX, this.shape3_4.offsetY, this.shape3_4.offsetZ);
        GL11.glTranslatef(this.shape3_4.rotationPointX * f5, this.shape3_4.rotationPointY * f5, this.shape3_4.rotationPointZ * f5);
        GL11.glScaled(1.0D, 0.9D, 0.9D);
        GL11.glTranslatef(-this.shape3_4.offsetX, -this.shape3_4.offsetY, -this.shape3_4.offsetZ);
        GL11.glTranslatef(-this.shape3_4.rotationPointX * f5, -this.shape3_4.rotationPointY * f5, -this.shape3_4.rotationPointZ * f5);
        this.shape3_4.render(f5);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.shape3_2.offsetX, this.shape3_2.offsetY, this.shape3_2.offsetZ);
        GL11.glTranslatef(this.shape3_2.rotationPointX * f5, this.shape3_2.rotationPointY * f5, this.shape3_2.rotationPointZ * f5);
        GL11.glScaled(1.0D, 0.9D, 0.9D);
        GL11.glTranslatef(-this.shape3_2.offsetX, -this.shape3_2.offsetY, -this.shape3_2.offsetZ);
        GL11.glTranslatef(-this.shape3_2.rotationPointX * f5, -this.shape3_2.rotationPointY * f5, -this.shape3_2.rotationPointZ * f5);
        this.shape3_2.render(f5);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.shape3_3.offsetX, this.shape3_3.offsetY, this.shape3_3.offsetZ);
        GL11.glTranslatef(this.shape3_3.rotationPointX * f5, this.shape3_3.rotationPointY * f5, this.shape3_3.rotationPointZ * f5);
        GL11.glScaled(1.0D, 0.9D, 0.9D);
        GL11.glTranslatef(-this.shape3_3.offsetX, -this.shape3_3.offsetY, -this.shape3_3.offsetZ);
        GL11.glTranslatef(-this.shape3_3.rotationPointX * f5, -this.shape3_3.rotationPointY * f5, -this.shape3_3.rotationPointZ * f5);
        this.shape3_3.render(f5);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.shape3.offsetX, this.shape3.offsetY, this.shape3.offsetZ);
        GL11.glTranslatef(this.shape3.rotationPointX * f5, this.shape3.rotationPointY * f5, this.shape3.rotationPointZ * f5);
        GL11.glScaled(1.0D, 0.9D, 0.9D);
        GL11.glTranslatef(-this.shape3.offsetX, -this.shape3.offsetY, -this.shape3.offsetZ);
        GL11.glTranslatef(-this.shape3.rotationPointX * f5, -this.shape3.rotationPointY * f5, -this.shape3.rotationPointZ * f5);
        this.shape3.render(f5);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.shape3_1.offsetX, this.shape3_1.offsetY, this.shape3_1.offsetZ);
        GL11.glTranslatef(this.shape3_1.rotationPointX * f5, this.shape3_1.rotationPointY * f5, this.shape3_1.rotationPointZ * f5);
        GL11.glScaled(1.0D, 0.9D, 0.9D);
        GL11.glTranslatef(-this.shape3_1.offsetX, -this.shape3_1.offsetY, -this.shape3_1.offsetZ);
        GL11.glTranslatef(-this.shape3_1.rotationPointX * f5, -this.shape3_1.rotationPointY * f5, -this.shape3_1.rotationPointZ * f5);
        this.shape3_1.render(f5);
        GL11.glPopMatrix();
        this.shape1.render(f5);
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
