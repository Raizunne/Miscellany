package com.raizunne.miscellany.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class modelTrophyBase extends ModelBase
{
  //fields
    ModelRenderer Dot1;
    ModelRenderer Dot2;
    ModelRenderer Dot3;
    ModelRenderer Dot4;
    ModelRenderer Base1;
    ModelRenderer Base2;
    ModelRenderer Base3;
  
  public modelTrophyBase()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Dot1 = new ModelRenderer(this, 0, 0);
      Dot1.addBox(5F, -2F, 1F, 1, 1, 1);
      Dot1.setRotationPoint(0F, 0F, 0F);
      Dot1.setTextureSize(64, 32);
      Dot1.mirror = true;
      setRotation(Dot1, 0F, 0F, 0F);
      Dot2 = new ModelRenderer(this, 0, 0);
      Dot2.addBox(1F, -2F, 1F, 1, 1, 1);
      Dot2.setRotationPoint(0F, 0F, 0F);
      Dot2.setTextureSize(64, 32);
      Dot2.mirror = true;
      setRotation(Dot2, 0F, 0F, 0F);
      Dot3 = new ModelRenderer(this, 0, 0);
      Dot3.addBox(1F, -2F, 5F, 1, 1, 1);
      Dot3.setRotationPoint(0F, 0F, 0F);
      Dot3.setTextureSize(64, 32);
      Dot3.mirror = true;
      setRotation(Dot3, 0F, 0F, 0F);
      Dot4 = new ModelRenderer(this, 0, 0);
      Dot4.addBox(5F, -2F, 5F, 1, 1, 1);
      Dot4.setRotationPoint(0F, 0F, 0F);
      Dot4.setTextureSize(64, 32);
      Dot4.mirror = true;
      setRotation(Dot4, 0F, 0F, 0F);
      Base1 = new ModelRenderer(this, 0, 3);
      Base1.addBox(1F, -1F, 1F, 5, 1, 5);
      Base1.setRotationPoint(0F, 0F, 0F);
      Base1.setTextureSize(64, 32);
      Base1.mirror = true;
      setRotation(Base1, 0F, 0F, 0F);
      Base2 = new ModelRenderer(this, 0, 10);
      Base2.addBox(-3F, 0F, -3F, 7, 1, 7);
      Base2.setRotationPoint(3F, 0F, 3F);
      Base2.setTextureSize(64, 32);
      Base2.mirror = true;
      setRotation(Base2, 0F, 0F, 0F);
      Base3 = new ModelRenderer(this, 0, 19);
      Base3.addBox(-1F, 0F, -1F, 9, 1, 9);
      Base3.setRotationPoint(0F, 1F, 0F);
      Base3.setTextureSize(64, 32);
      Base3.mirror = true;
      setRotation(Base3, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Dot1.render(f5);
    Dot2.render(f5);
    Dot3.render(f5);
    Dot4.render(f5);
    Base1.render(f5);
    Base2.render(f5);
    Base3.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void renderModel(float f5) {
	  Dot1.render(f5);
	  Dot2.render(f5);
	  Dot3.render(f5);
	  Dot4.render(f5);
	  Base1.render(f5);
	  Base2.render(f5);
	  Base3.render(f5);
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
