package com.raizunne.miscellany.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class modelAdvReactBrewer extends ModelBase
{
  //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Pedestal11;
    ModelRenderer Pedestal12;
    ModelRenderer Pedestal13;
    ModelRenderer Pedestal21;
    ModelRenderer Pedestal22;
    ModelRenderer Pedestal23;
    ModelRenderer Pedestal31;
    ModelRenderer Pedestal32;
    ModelRenderer Pedestal33;
    ModelRenderer Pedestal_Top;
    ModelRenderer Pedestal_Bottom;
  
  public modelAdvReactBrewer()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      Shape1 = new ModelRenderer(this, 0, 0);
      Shape1.addBox(0F, 2F, 0F, 8, 1, 8);
      Shape1.setRotationPoint(-4F, 0F, -4F);
      Shape1.setTextureSize(64, 32);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 0, 10);
      Shape2.addBox(-1F, 0F, -1F, 4, 7, 4);
      Shape2.setRotationPoint(-1F, -5F, -1F);
      Shape2.setTextureSize(64, 32);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Pedestal11 = new ModelRenderer(this, 0, 22);
      Pedestal11.addBox(0F, 0F, -0.4F, 1, 1, 4);
      Pedestal11.setRotationPoint(0.5F, -5F, -1.8F);
      Pedestal11.setTextureSize(64, 32);
      Pedestal11.mirror = true;
      setRotation(Pedestal11, 0F, -3.141593F, 0F);
      Pedestal12 = new ModelRenderer(this, 11, 22);
      Pedestal12.addBox(0F, -1F, 2.6F, 1, 1, 1);
      Pedestal12.setRotationPoint(0.5F, -5F, -1.8F);
      Pedestal12.setTextureSize(64, 32);
      Pedestal12.mirror = true;
      setRotation(Pedestal12, 0F, -3.141593F, 0F);
      Pedestal13 = new ModelRenderer(this, 16, 22);
      Pedestal13.addBox(-1F, -1F, 1.6F, 3, 1, 3);
      Pedestal13.setRotationPoint(0.5F, -6F, -1.8F);
      Pedestal13.setTextureSize(64, 32);
      Pedestal13.mirror = true;
      setRotation(Pedestal13, 0F, -3.141593F, 0F);
      Pedestal21 = new ModelRenderer(this, 0, 22);
      Pedestal21.addBox(-0.5F, 0F, 0F, 1, 1, 4);
      Pedestal21.setRotationPoint(1F, -5F, 1F);
      Pedestal21.setTextureSize(64, 32);
      Pedestal21.mirror = true;
      setRotation(Pedestal21, 0F, 0.7853982F, 0F);
      Pedestal22 = new ModelRenderer(this, 11, 22);
      Pedestal22.addBox(-0.5F, -1F, 3F, 1, 1, 1);
      Pedestal22.setRotationPoint(1F, -5F, 1F);
      Pedestal22.setTextureSize(64, 32);
      Pedestal22.mirror = true;
      setRotation(Pedestal22, 0F, 0.7853982F, 0F);
      Pedestal23 = new ModelRenderer(this, 16, 22);
      Pedestal23.addBox(-1.5F, -1F, 2F, 3, 1, 3);
      Pedestal23.setRotationPoint(1F, -6F, 1F);
      Pedestal23.setTextureSize(64, 32);
      Pedestal23.mirror = true;
      setRotation(Pedestal23, 0F, 0.7853982F, 0F);
      Pedestal31 = new ModelRenderer(this, 0, 22);
      Pedestal31.addBox(0F, 0F, -0.4F, 1, 1, 4);
      Pedestal31.setRotationPoint(-2F, -5F, 1F);
      Pedestal31.setTextureSize(64, 32);
      Pedestal31.mirror = true;
      setRotation(Pedestal31, 0F, -0.7853982F, 0F);
      Pedestal32 = new ModelRenderer(this, 11, 22);
      Pedestal32.addBox(0F, -1F, 2.6F, 1, 1, 1);
      Pedestal32.setRotationPoint(-2F, -5F, 1F);
      Pedestal32.setTextureSize(64, 32);
      Pedestal32.mirror = true;
      setRotation(Pedestal32, 0F, -0.7853982F, 0F);
      Pedestal33 = new ModelRenderer(this, 16, 22);
      Pedestal33.addBox(-1F, -1F, 1.6F, 3, 1, 3);
      Pedestal33.setRotationPoint(-2F, -6F, 1F);
      Pedestal33.setTextureSize(64, 32);
      Pedestal33.mirror = true;
      setRotation(Pedestal33, 0F, -0.7853982F, 0F);
      Pedestal_Top = new ModelRenderer(this, 0, 28);
      Pedestal_Top.addBox(-1F, 0F, -1F, 3, 1, 3);
      Pedestal_Top.setRotationPoint(-0.5F, -8F, -0.5F);
      Pedestal_Top.setTextureSize(64, 32);
      Pedestal_Top.mirror = true;
      setRotation(Pedestal_Top, 0F, 0F, 0F);
      Pedestal_Bottom = new ModelRenderer(this, 13, 28);
      Pedestal_Bottom.addBox(0F, 0F, 0F, 2, 2, 2);
      Pedestal_Bottom.setRotationPoint(-1F, -7F, -1F);
      Pedestal_Bottom.setTextureSize(64, 32);
      Pedestal_Bottom.mirror = true;
      setRotation(Pedestal_Bottom, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape1.render(f5);
    Shape2.render(f5);
    Pedestal11.render(f5);
    Pedestal12.render(f5);
    Pedestal13.render(f5);
    Pedestal21.render(f5);
    Pedestal22.render(f5);
    Pedestal23.render(f5);
    Pedestal31.render(f5);
    Pedestal32.render(f5);
    Pedestal33.render(f5);
    Pedestal_Top.render(f5);
    Pedestal_Bottom.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void renderModel(float f5){
	  Shape1.render(f5);
	    Shape2.render(f5);
	    Pedestal11.render(f5);
	    Pedestal12.render(f5);
	    Pedestal13.render(f5);
	    Pedestal21.render(f5);
	    Pedestal22.render(f5);
	    Pedestal23.render(f5);
	    Pedestal31.render(f5);
	    Pedestal32.render(f5);
	    Pedestal33.render(f5);
	    Pedestal_Top.render(f5);
	    Pedestal_Bottom.render(f5);
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
