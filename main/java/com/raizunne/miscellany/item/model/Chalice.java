package com.raizunne.miscellany.item.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class Chalice extends ModelBase
{
  //fields
    ModelRenderer water;
    ModelRenderer Base2;
    ModelRenderer Base1;
    ModelRenderer Shaft;
    ModelRenderer Side1;
    ModelRenderer Side2;
    ModelRenderer Side3;
    ModelRenderer Side4;
    ModelRenderer Gem1;
    ModelRenderer Gem2;
    ModelRenderer Gem3;
    ModelRenderer Gem4;
    ModelRenderer Gem5;
    ModelRenderer Gem7;
    ModelRenderer Base3;
  
  public Chalice()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      water = new ModelRenderer(this, 14, 16);
      water.addBox(0F, 0F, 0F, 6, 4, 6);
      water.setRotationPoint(-3F, 7F, -3F);
      water.setTextureSize(64, 64);
      water.mirror = true;
      setRotation(water, 0F, 0F, 0F);
      Base2 = new ModelRenderer(this, 0, 9);
      Base2.addBox(0F, 0F, 0F, 6, 1, 6);
      Base2.setRotationPoint(-3F, 15F, -3F);
      Base2.setTextureSize(64, 64);
      Base2.mirror = true;
      setRotation(Base2, 0F, 0F, 0F);
      Base1 = new ModelRenderer(this, 0, 0);
      Base1.addBox(0F, 0F, 0F, 8, 1, 8);
      Base1.setRotationPoint(-4F, 16F, -4F);
      Base1.setTextureSize(64, 64);
      Base1.mirror = true;
      setRotation(Base1, 0F, 0F, 0F);
      Shaft = new ModelRenderer(this, 32, 0);
      Shaft.addBox(-2F, 0F, -2F, 4, 3, 4);
      Shaft.setRotationPoint(0F, 12F, 0F);
      Shaft.setTextureSize(64, 64);
      Shaft.mirror = true;
      setRotation(Shaft, 0F, 0F, 0F);
      Side1 = new ModelRenderer(this, 0, 16);
      Side1.addBox(0F, 0F, 0F, 6, 5, 1);
      Side1.setRotationPoint(-3F, 6F, 3F);
      Side1.setTextureSize(64, 64);
      Side1.mirror = true;
      setRotation(Side1, 0F, 0F, 0F);
      Side2 = new ModelRenderer(this, 0, 16);
      Side2.addBox(0F, 0F, 0F, 6, 5, 1);
      Side2.setRotationPoint(-3F, 6F, -4F);
      Side2.setTextureSize(64, 64);
      Side2.mirror = true;
      setRotation(Side2, 0F, 0F, 0F);
      Side3 = new ModelRenderer(this, 0, 22);
      Side3.addBox(0F, 0F, 0F, 1, 5, 6);
      Side3.setRotationPoint(-4F, 6F, -3F);
      Side3.setTextureSize(64, 64);
      Side3.mirror = true;
      setRotation(Side3, 0F, 0F, 0F);
      Side4 = new ModelRenderer(this, 0, 22);
      Side4.addBox(0F, 0F, 0F, 1, 5, 6);
      Side4.setRotationPoint(3F, 6F, -3F);
      Side4.setTextureSize(64, 64);
      Side4.mirror = true;
      setRotation(Side4, 0F, 0F, 0F);
      Gem1 = new ModelRenderer(this, 25, 10);
      Gem1.addBox(0F, 0F, 0F, 1, 1, 1);
      Gem1.setRotationPoint(3.4F, 7F, -2.5F);
      Gem1.setTextureSize(64, 64);
      Gem1.mirror = true;
      setRotation(Gem1, 0F, 0F, 0F);
      Gem2 = new ModelRenderer(this, 25, 13);
      Gem2.addBox(0F, 0F, 0F, 1, 1, 1);
      Gem2.setRotationPoint(3.4F, 7F, -0.5F);
      Gem2.setTextureSize(64, 64);
      Gem2.mirror = true;
      setRotation(Gem2, 0F, 0F, 0F);
      Gem3 = new ModelRenderer(this, 25, 10);
      Gem3.addBox(0F, 0F, 0F, 1, 1, 1);
      Gem3.setRotationPoint(3.4F, 7F, 1.5F);
      Gem3.setTextureSize(64, 64);
      Gem3.mirror = true;
      setRotation(Gem3, 0F, 0F, 0F);
      Gem4 = new ModelRenderer(this, 25, 10);
      Gem4.addBox(0F, 0F, 0F, 1, 1, 1);
      Gem4.setRotationPoint(-4.4F, 7F, 1.5F);
      Gem4.setTextureSize(64, 64);
      Gem4.mirror = true;
      setRotation(Gem4, 0F, 0F, 0F);
      Gem5 = new ModelRenderer(this, 25, 13);
      Gem5.addBox(0F, 0F, 0F, 1, 1, 1);
      Gem5.setRotationPoint(-4.4F, 7F, -0.5F);
      Gem5.setTextureSize(64, 64);
      Gem5.mirror = true;
      setRotation(Gem5, 0F, 0F, 0F);
      Gem7 = new ModelRenderer(this, 25, 10);
      Gem7.addBox(0F, 0F, 0F, 1, 1, 1);
      Gem7.setRotationPoint(-4.4F, 7F, -2.5F);
      Gem7.setTextureSize(64, 64);
      Gem7.mirror = true;
      setRotation(Gem7, 0F, 0F, 0F);
      Base3 = new ModelRenderer(this, 0, 33);
      Base3.addBox(0F, 0F, 0F, 6, 1, 6);
      Base3.setRotationPoint(-3F, 11F, -3F);
      Base3.setTextureSize(64, 64);
      Base3.mirror = true;
      setRotation(water, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    water.render(f5);
    Base2.render(f5);
    Base1.render(f5);
    Shaft.render(f5);
    Side1.render(f5);
    Side2.render(f5);
    Side3.render(f5);
    Side4.render(f5);
    Gem1.render(f5);
    Gem2.render(f5);
    Gem3.render(f5);
    Gem4.render(f5);
    Gem5.render(f5);
    Gem7.render(f5);
    Base3.render(f5);
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
