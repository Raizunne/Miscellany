package com.raizunne.miscellany.block.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class modelAdvReactBrewer extends ModelBase
{
  //fields
    ModelRenderer Middle_Pole;
    ModelRenderer Base_Top;
    ModelRenderer Base_Bottom;
    ModelRenderer Bar1;
    ModelRenderer Bar2;
    ModelRenderer Bar3;
    ModelRenderer Platform1;
    ModelRenderer Platform2;
    ModelRenderer Platform3;
  
  public modelAdvReactBrewer()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      Middle_Pole = new ModelRenderer(this, 0, 32);
      Middle_Pole.addBox(0F, 0F, 0F, 4, 7, 4);
      Middle_Pole.setRotationPoint(-2F, 15F, -2F);
      Middle_Pole.setTextureSize(64, 32);
      Middle_Pole.mirror = true;
      setRotation(Middle_Pole, 0F, 0F, 0F);
      Base_Top = new ModelRenderer(this, 0, 13);
      Base_Top.addBox(0F, 0F, 0F, 10, 1, 10);
      Base_Top.setRotationPoint(-5F, 22F, -5F);
      Base_Top.setTextureSize(64, 32);
      Base_Top.mirror = true;
      setRotation(Base_Top, 0F, 0F, 0F);
      Base_Bottom = new ModelRenderer(this, 0, 0);
      Base_Bottom.addBox(0F, 0F, 0F, 12, 1, 12);
      Base_Bottom.setRotationPoint(-6F, 23F, -6F);
      Base_Bottom.setTextureSize(64, 32);
      Base_Bottom.mirror = true;
      setRotation(Base_Bottom, 0F, 0F, 0F);
      Bar1 = new ModelRenderer(this, 0, 25);
      Bar1.addBox(-0.5F, 0F, -2F, 2, 1, 3);
      Bar1.setRotationPoint(-0.5F, 16F, -1.866667F);
      Bar1.setTextureSize(64, 32);
      Bar1.mirror = true;
      setRotation(Bar1, -0.5410521F, 0F, 0F);
      Bar2 = new ModelRenderer(this, 0, 25);
      Bar2.addBox(-0.3F, 0F, -1F, 2, 1, 3);
      Bar2.setRotationPoint(1F, 16F, 2F);
      Bar2.setTextureSize(64, 32);
      Bar2.mirror = true;
      setRotation(Bar2, 0.5235988F, 0.9599311F, 0F);
      Bar3 = new ModelRenderer(this, 0, 25);
      Bar3.addBox(0.5F, 0F, -0.8F, 2, 1, 3);
      Bar3.setRotationPoint(-2F, 16.15F, 0F);
      Bar3.setTextureSize(64, 32);
      Bar3.mirror = true;
      setRotation(Bar3, 0.5061455F, -0.9599311F, 0F);
      Platform1 = new ModelRenderer(this, 12, 25);
      Platform1.addBox(-2.3F, 0F, -1.33F, 4, 2, 4);
      Platform1.setRotationPoint(4F, 15F, 3F);
      Platform1.setTextureSize(64, 32);
      Platform1.mirror = true;
      setRotation(Platform1, 0F, 0.9599311F, 0F);
      Platform2 = new ModelRenderer(this, 12, 25);
      Platform2.addBox(-1.7F, 0F, 3.55F, 4, 2, 4);
      Platform2.setRotationPoint(0F, 15.11F, 0F);
      Platform2.setTextureSize(64, 32);
      Platform2.mirror = true;
      setRotation(Platform2, 0F, -0.9599311F, 0F);
      Platform3 = new ModelRenderer(this, 12, 25);
      Platform3.addBox(-2F, 0F, -7.6F, 4, 2, 4);
      Platform3.setRotationPoint(0F, 15F, 0F);
      Platform3.setTextureSize(64, 32);
      Platform3.mirror = true;
      setRotation(Platform3, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Middle_Pole.render(f5);
    Base_Top.render(f5);
    Base_Bottom.render(f5);
    Bar1.render(f5);
    Bar2.render(f5);
    Bar3.render(f5);
    Platform1.render(f5);
    Platform2.render(f5);
    Platform3.render(f5);
  }
  
  public void renderModel(float f5){
	  Middle_Pole.render(f5);
	  Base_Top.render(f5);
	  Base_Bottom.render(f5);
	  Bar1.render(f5);
	  Bar2.render(f5);
	  Bar3.render(f5);
	  Platform1.render(f5);
	  Platform2.render(f5);
	  Platform3.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
