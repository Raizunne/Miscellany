package com.raizunne.miscellany.block.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class modelPresent extends ModelBase
{
  //fields
    ModelRenderer Stripe5;
    ModelRenderer Stripe6;
    ModelRenderer Box;
    ModelRenderer Cap;
    ModelRenderer Stipe1;
    ModelRenderer Stipe3;
    ModelRenderer Stipe4;
    ModelRenderer Stipe2;
  
  public modelPresent()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Stripe5 = new ModelRenderer(this, 49, 41);
      Stripe5.addBox(-1F, -4.5F, -7.5F, 3, 6, 17);
      Stripe5.setRotationPoint(0F, 0F, 0F);
      Stripe5.setTextureSize(128, 64);
      Stripe5.mirror = true;
      setRotation(Stripe5, 0F, 0F, 0F);
      Stripe6 = new ModelRenderer(this, 88, 55);
      Stripe6.addBox(-7.7F, -4.5F, -1F, 17, 6, 3);
      Stripe6.setRotationPoint(0F, 0F, 0F);
      Stripe6.setTextureSize(128, 64);
      Stripe6.mirror = true;
      setRotation(Stripe6, 0F, 0F, 0F);
      Box = new ModelRenderer(this, 0, 21);
      Box.addBox(-6F, 1F, -6F, 14, 11, 14);
      Box.setRotationPoint(0F, 0F, 0F);
      Box.setTextureSize(128, 64);
      Box.mirror = true;
      setRotation(Box, 0F, 0F, 0F);
      Cap = new ModelRenderer(this, 0, 0);
      Cap.addBox(-7F, 0F, -7F, 16, 5, 16);
      Cap.setRotationPoint(0F, -4F, 0F);
      Cap.setTextureSize(128, 64);
      Cap.mirror = true;
      setRotation(Cap, 0F, 0F, 0F);
      Stipe1 = new ModelRenderer(this, 0, 46);
      Stipe1.addBox(-6.3F, 1F, 0F, 1, 11, 3);
      Stipe1.setRotationPoint(0F, 0F, -1F);
      Stipe1.setTextureSize(128, 64);
      Stipe1.mirror = true;
      setRotation(Stipe1, 0F, 0F, 0F);
      Stipe3 = new ModelRenderer(this, 9, 46);
      Stipe3.addBox(-1F, 1F, -5.3F, 3, 11, 1);
      Stipe3.setRotationPoint(0F, 0F, -1F);
      Stipe3.setTextureSize(128, 64);
      Stipe3.mirror = true;
      setRotation(Stipe3, 0F, 0F, 0F);
      Stipe4 = new ModelRenderer(this, 9, 46);
      Stipe4.addBox(-1F, 1F, 8.3F, 3, 11, 1);
      Stipe4.setRotationPoint(0F, 0F, -1F);
      Stipe4.setTextureSize(128, 64);
      Stipe4.mirror = true;
      setRotation(Stipe4, 0F, 0F, 0F);
      Stipe2 = new ModelRenderer(this, 0, 46);
      Stipe2.addBox(7.3F, 1F, 0F, 1, 11, 3);
      Stipe2.setRotationPoint(0F, 0F, -1F);
      Stipe2.setTextureSize(128, 64);
      Stipe2.mirror = true;
      setRotation(Stipe2, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Stripe5.render(f5);
    Stripe6.render(f5);
    Box.render(f5);
    Cap.render(f5);
    Stipe1.render(f5);
    Stipe3.render(f5);
    Stipe4.render(f5);
    Stipe2.render(f5);
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

public void renderModel(float f5) {
	Stripe5.render(f5);
    Stripe6.render(f5);
    Box.render(f5);
    Cap.render(f5);
    Stipe1.render(f5);
    Stipe3.render(f5);
    Stipe4.render(f5);
    Stipe2.render(f5);
}

}
