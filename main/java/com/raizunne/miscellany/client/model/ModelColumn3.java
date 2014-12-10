package com.raizunne.miscellany.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Column1 - Raizunne
 * Created using Tabula 4.0.2
 */
public class ModelColumn3 extends ModelBase {
    public ModelRenderer shape1;

    public ModelColumn3() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.shape1 = new ModelRenderer(this, 0, 0);
        this.shape1.setRotationPoint(-5.0F, 8.0F, -5.0F);
        this.shape1.addBox(0.0F, 0.0F, 0.0F, 10, 16, 10);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.shape1.render(f5);
    }
    
    public void renderModel(float f5){
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
