package com.raizunne.miscellany.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

/**
 * Present - Raizunne
 * Created using Tabula 4.0.2
 */
public class ModelPresent extends ModelBase {
    public ModelRenderer shape1;
    public ModelRenderer shape1_1;
    public ModelRenderer shape1_2;
    public ModelRenderer shape1_3;
    public ModelRenderer shape1_4;
    public ModelRenderer shape1_5;
    public ModelRenderer shape1_6;
    public ModelRenderer shape1_7;
    public ModelRenderer shape1_8;
    public ModelRenderer shape1_9;
    public ModelRenderer shape13;
    public ModelRenderer shape13_1;

    public ModelPresent() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.shape1_7 = new ModelRenderer(this, 43, 0);
        this.shape1_7.setRotationPoint(4.6F, 14.0F, -1.0F);
        this.shape1_7.addBox(0.0F, 0.0F, 0.0F, 1, 5, 2);
        this.shape1_6 = new ModelRenderer(this, 0, 0);
        this.shape1_6.setRotationPoint(-1.0F, 18.0F, -5.3F);
        this.shape1_6.addBox(0.0F, 0.0F, 0.0F, 2, 6, 1);
        this.shape13 = new ModelRenderer(this, 38, 6);
        this.shape13.setRotationPoint(-1.0F, 13.8F, -5.6F);
        this.shape13.addBox(0.0F, 0.0F, 0.0F, 2, 1, 11);
        this.shape1_1 = new ModelRenderer(this, 0, 0);
        this.shape1_1.setRotationPoint(-5.4F, 14.0F, -5.4F);
        this.shape1_1.addBox(0.0F, 0.0F, 0.0F, 12, 4, 12);
        this.shape1_8 = new ModelRenderer(this, 36, 0);
        this.shape1_8.setRotationPoint(-1.0F, 14.0F, -5.6F);
        this.shape1_8.addBox(0.0F, 0.0F, 0.0F, 2, 5, 1);
        this.shape1_9 = new ModelRenderer(this, 43, 0);
        this.shape1_9.setRotationPoint(-5.6F, 14.0F, -1.0F);
        this.shape1_9.addBox(0.0F, 0.0F, 0.0F, 1, 5, 2);
        this.shape13_1 = new ModelRenderer(this, 38, 19);
        this.shape13_1.setRotationPoint(-5.6F, 13.8F, -1.0F);
        this.shape13_1.addBox(0.0F, 0.0F, 0.0F, 11, 1, 2);
        this.shape1_5 = new ModelRenderer(this, 0, 17);
        this.shape1_5.setRotationPoint(-5.3F, 18.0F, -1.0F);
        this.shape1_5.addBox(0.0F, 0.0F, 0.0F, 1, 6, 2);
        this.shape1 = new ModelRenderer(this, 0, 16);
        this.shape1.setRotationPoint(-5.0F, 18.0F, -5.0F);
        this.shape1.addBox(0.0F, 0.0F, 0.0F, 10, 6, 10);
        this.shape1_4 = new ModelRenderer(this, 0, 17);
        this.shape1_4.setRotationPoint(4.3F, 18.0F, -1.0F);
        this.shape1_4.addBox(0.0F, 0.0F, 0.0F, 1, 6, 2);
        this.shape1_2 = new ModelRenderer(this, 0, 0);
        this.shape1_2.setRotationPoint(-1.0F, 18.0F, 4.3F);
        this.shape1_2.addBox(0.0F, 0.0F, 0.0F, 2, 6, 1);
        this.shape1_3 = new ModelRenderer(this, 36, 0);
        this.shape1_3.setRotationPoint(-1.0F, 14.0F, 4.6F);
        this.shape1_3.addBox(0.0F, 0.0F, 0.0F, 2, 5, 1);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        GL11.glPushMatrix();
        GL11.glTranslatef(this.shape1_7.offsetX, this.shape1_7.offsetY, this.shape1_7.offsetZ);
        GL11.glTranslatef(this.shape1_7.rotationPointX * f5, this.shape1_7.rotationPointY * f5, this.shape1_7.rotationPointZ * f5);
        GL11.glScaled(1.0D, 0.85D, 1.0D);
        GL11.glTranslatef(-this.shape1_7.offsetX, -this.shape1_7.offsetY, -this.shape1_7.offsetZ);
        GL11.glTranslatef(-this.shape1_7.rotationPointX * f5, -this.shape1_7.rotationPointY * f5, -this.shape1_7.rotationPointZ * f5);
        this.shape1_7.render(f5);
        GL11.glPopMatrix();
        this.shape1_6.render(f5);
        GL11.glPushMatrix();
        GL11.glTranslatef(this.shape13.offsetX, this.shape13.offsetY, this.shape13.offsetZ);
        GL11.glTranslatef(this.shape13.rotationPointX * f5, this.shape13.rotationPointY * f5, this.shape13.rotationPointZ * f5);
        GL11.glScaled(1.0D, 1.0D, 1.02D);
        GL11.glTranslatef(-this.shape13.offsetX, -this.shape13.offsetY, -this.shape13.offsetZ);
        GL11.glTranslatef(-this.shape13.rotationPointX * f5, -this.shape13.rotationPointY * f5, -this.shape13.rotationPointZ * f5);
        this.shape13.render(f5);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.shape1_1.offsetX, this.shape1_1.offsetY, this.shape1_1.offsetZ);
        GL11.glTranslatef(this.shape1_1.rotationPointX * f5, this.shape1_1.rotationPointY * f5, this.shape1_1.rotationPointZ * f5);
        GL11.glScaled(0.9D, 1.0D, 0.9D);
        GL11.glTranslatef(-this.shape1_1.offsetX, -this.shape1_1.offsetY, -this.shape1_1.offsetZ);
        GL11.glTranslatef(-this.shape1_1.rotationPointX * f5, -this.shape1_1.rotationPointY * f5, -this.shape1_1.rotationPointZ * f5);
        this.shape1_1.render(f5);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.shape1_8.offsetX, this.shape1_8.offsetY, this.shape1_8.offsetZ);
        GL11.glTranslatef(this.shape1_8.rotationPointX * f5, this.shape1_8.rotationPointY * f5, this.shape1_8.rotationPointZ * f5);
        GL11.glScaled(1.0D, 0.85D, 1.0D);
        GL11.glTranslatef(-this.shape1_8.offsetX, -this.shape1_8.offsetY, -this.shape1_8.offsetZ);
        GL11.glTranslatef(-this.shape1_8.rotationPointX * f5, -this.shape1_8.rotationPointY * f5, -this.shape1_8.rotationPointZ * f5);
        this.shape1_8.render(f5);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.shape1_9.offsetX, this.shape1_9.offsetY, this.shape1_9.offsetZ);
        GL11.glTranslatef(this.shape1_9.rotationPointX * f5, this.shape1_9.rotationPointY * f5, this.shape1_9.rotationPointZ * f5);
        GL11.glScaled(1.0D, 0.85D, 1.0D);
        GL11.glTranslatef(-this.shape1_9.offsetX, -this.shape1_9.offsetY, -this.shape1_9.offsetZ);
        GL11.glTranslatef(-this.shape1_9.rotationPointX * f5, -this.shape1_9.rotationPointY * f5, -this.shape1_9.rotationPointZ * f5);
        this.shape1_9.render(f5);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.shape13_1.offsetX, this.shape13_1.offsetY, this.shape13_1.offsetZ);
        GL11.glTranslatef(this.shape13_1.rotationPointX * f5, this.shape13_1.rotationPointY * f5, this.shape13_1.rotationPointZ * f5);
        GL11.glScaled(1.02D, 1.0D, 1.0D);
        GL11.glTranslatef(-this.shape13_1.offsetX, -this.shape13_1.offsetY, -this.shape13_1.offsetZ);
        GL11.glTranslatef(-this.shape13_1.rotationPointX * f5, -this.shape13_1.rotationPointY * f5, -this.shape13_1.rotationPointZ * f5);
        this.shape13_1.render(f5);
        GL11.glPopMatrix();
        this.shape1_5.render(f5);
        this.shape1.render(f5);
        this.shape1_4.render(f5);
        this.shape1_2.render(f5);
        GL11.glPushMatrix();
        GL11.glTranslatef(this.shape1_3.offsetX, this.shape1_3.offsetY, this.shape1_3.offsetZ);
        GL11.glTranslatef(this.shape1_3.rotationPointX * f5, this.shape1_3.rotationPointY * f5, this.shape1_3.rotationPointZ * f5);
        GL11.glScaled(1.0D, 0.85D, 1.0D);
        GL11.glTranslatef(-this.shape1_3.offsetX, -this.shape1_3.offsetY, -this.shape1_3.offsetZ);
        GL11.glTranslatef(-this.shape1_3.rotationPointX * f5, -this.shape1_3.rotationPointY * f5, -this.shape1_3.rotationPointZ * f5);
        this.shape1_3.render(f5);
        GL11.glPopMatrix();
    }
    
    public void renderModel(float f5){
    	GL11.glPushMatrix();
        GL11.glTranslatef(this.shape1_7.offsetX, this.shape1_7.offsetY, this.shape1_7.offsetZ);
        GL11.glTranslatef(this.shape1_7.rotationPointX * f5, this.shape1_7.rotationPointY * f5, this.shape1_7.rotationPointZ * f5);
        GL11.glScaled(1.0D, 0.85D, 1.0D);
        GL11.glTranslatef(-this.shape1_7.offsetX, -this.shape1_7.offsetY, -this.shape1_7.offsetZ);
        GL11.glTranslatef(-this.shape1_7.rotationPointX * f5, -this.shape1_7.rotationPointY * f5, -this.shape1_7.rotationPointZ * f5);
        this.shape1_7.render(f5);
        GL11.glPopMatrix();
        this.shape1_6.render(f5);
        GL11.glPushMatrix();
        GL11.glTranslatef(this.shape13.offsetX, this.shape13.offsetY, this.shape13.offsetZ);
        GL11.glTranslatef(this.shape13.rotationPointX * f5, this.shape13.rotationPointY * f5, this.shape13.rotationPointZ * f5);
        GL11.glScaled(1.0D, 1.0D, 1.02D);
        GL11.glTranslatef(-this.shape13.offsetX, -this.shape13.offsetY, -this.shape13.offsetZ);
        GL11.glTranslatef(-this.shape13.rotationPointX * f5, -this.shape13.rotationPointY * f5, -this.shape13.rotationPointZ * f5);
        this.shape13.render(f5);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.shape1_1.offsetX, this.shape1_1.offsetY, this.shape1_1.offsetZ);
        GL11.glTranslatef(this.shape1_1.rotationPointX * f5, this.shape1_1.rotationPointY * f5, this.shape1_1.rotationPointZ * f5);
        GL11.glScaled(0.9D, 1.0D, 0.9D);
        GL11.glTranslatef(-this.shape1_1.offsetX, -this.shape1_1.offsetY, -this.shape1_1.offsetZ);
        GL11.glTranslatef(-this.shape1_1.rotationPointX * f5, -this.shape1_1.rotationPointY * f5, -this.shape1_1.rotationPointZ * f5);
        this.shape1_1.render(f5);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.shape1_8.offsetX, this.shape1_8.offsetY, this.shape1_8.offsetZ);
        GL11.glTranslatef(this.shape1_8.rotationPointX * f5, this.shape1_8.rotationPointY * f5, this.shape1_8.rotationPointZ * f5);
        GL11.glScaled(1.0D, 0.85D, 1.0D);
        GL11.glTranslatef(-this.shape1_8.offsetX, -this.shape1_8.offsetY, -this.shape1_8.offsetZ);
        GL11.glTranslatef(-this.shape1_8.rotationPointX * f5, -this.shape1_8.rotationPointY * f5, -this.shape1_8.rotationPointZ * f5);
        this.shape1_8.render(f5);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.shape1_9.offsetX, this.shape1_9.offsetY, this.shape1_9.offsetZ);
        GL11.glTranslatef(this.shape1_9.rotationPointX * f5, this.shape1_9.rotationPointY * f5, this.shape1_9.rotationPointZ * f5);
        GL11.glScaled(1.0D, 0.85D, 1.0D);
        GL11.glTranslatef(-this.shape1_9.offsetX, -this.shape1_9.offsetY, -this.shape1_9.offsetZ);
        GL11.glTranslatef(-this.shape1_9.rotationPointX * f5, -this.shape1_9.rotationPointY * f5, -this.shape1_9.rotationPointZ * f5);
        this.shape1_9.render(f5);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.shape13_1.offsetX, this.shape13_1.offsetY, this.shape13_1.offsetZ);
        GL11.glTranslatef(this.shape13_1.rotationPointX * f5, this.shape13_1.rotationPointY * f5, this.shape13_1.rotationPointZ * f5);
        GL11.glScaled(1.02D, 1.0D, 1.0D);
        GL11.glTranslatef(-this.shape13_1.offsetX, -this.shape13_1.offsetY, -this.shape13_1.offsetZ);
        GL11.glTranslatef(-this.shape13_1.rotationPointX * f5, -this.shape13_1.rotationPointY * f5, -this.shape13_1.rotationPointZ * f5);
        this.shape13_1.render(f5);
        GL11.glPopMatrix();
        this.shape1_5.render(f5);
        this.shape1.render(f5);
        this.shape1_4.render(f5);
        this.shape1_2.render(f5);
        GL11.glPushMatrix();
        GL11.glTranslatef(this.shape1_3.offsetX, this.shape1_3.offsetY, this.shape1_3.offsetZ);
        GL11.glTranslatef(this.shape1_3.rotationPointX * f5, this.shape1_3.rotationPointY * f5, this.shape1_3.rotationPointZ * f5);
        GL11.glScaled(1.0D, 0.85D, 1.0D);
        GL11.glTranslatef(-this.shape1_3.offsetX, -this.shape1_3.offsetY, -this.shape1_3.offsetZ);
        GL11.glTranslatef(-this.shape1_3.rotationPointX * f5, -this.shape1_3.rotationPointY * f5, -this.shape1_3.rotationPointZ * f5);
        this.shape1_3.render(f5);
        GL11.glPopMatrix();

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
