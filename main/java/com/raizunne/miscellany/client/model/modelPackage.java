package com.raizunne.miscellany.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class modelPackage extends ModelBase
{
  //fields
    ModelRenderer Base;
    ModelRenderer TopHalf1;
    ModelRenderer TopHalf2;
    ModelRenderer LeftSide;
    ModelRenderer RightSide;
    ModelRenderer BackSide;
    ModelRenderer TopSide;
    ModelRenderer BaseTop;
    ModelRenderer BaseBottom;
    ModelRenderer Controls;
  
  public modelPackage()
  {
    textureWidth = 128;
    textureHeight = 128;
    
      Base = new ModelRenderer(this, 0, 0);
      Base.addBox(-6F, 0F, -6F, 8, 2, 14);
      Base.setRotationPoint(2F, 22F, -1F);
      Base.setTextureSize(128, 128);
      Base.mirror = true;
      setRotation(Base, 0F, 0F, 0F);
      TopHalf1 = new ModelRenderer(this, 46, 0);
      TopHalf1.addBox(0F, 0F, 0F, 14, 4, 11);
      TopHalf1.setRotationPoint(-7F, 9F, -4F);
      TopHalf1.setTextureSize(128, 128);
      TopHalf1.mirror = true;
      setRotation(TopHalf1, 0F, 0F, 0F);
      TopHalf2 = new ModelRenderer(this, 0, 17);
      TopHalf2.addBox(0F, -5F, 0F, 14, 5, 3);
      TopHalf2.setRotationPoint(-7F, 13F, -7F);
      TopHalf2.setTextureSize(128, 128);
      TopHalf2.mirror = true;
      setRotation(TopHalf2, -0.6457718F, 0F, 0F);
      LeftSide = new ModelRenderer(this, 46, 26);
      LeftSide.addBox(-6F, 0F, -6F, 3, 11, 14);
      LeftSide.setRotationPoint(-1F, 13F, -1F);
      LeftSide.setTextureSize(128, 128);
      LeftSide.mirror = true;
      setRotation(LeftSide, 0F, 0F, 0F);
      RightSide = new ModelRenderer(this, 46, 26);
      RightSide.addBox(-6F, 0F, -6F, 3, 11, 14);
      RightSide.setRotationPoint(10F, 13F, -1F);
      RightSide.setTextureSize(128, 128);
      RightSide.mirror = true;
      setRotation(RightSide, 0F, 0F, 0F);
      BackSide = new ModelRenderer(this, 0, 55);
      BackSide.addBox(-6F, 0F, -6F, 8, 7, 2);
      BackSide.setRotationPoint(2F, 15F, 11F);
      BackSide.setTextureSize(128, 128);
      BackSide.mirror = true;
      setRotation(BackSide, 0F, 0F, 0F);
      TopSide = new ModelRenderer(this, 0, 26);
      TopSide.addBox(-6F, 0F, -6F, 8, 2, 14);
      TopSide.setRotationPoint(2F, 13F, -1F);
      TopSide.setTextureSize(128, 128);
      TopSide.mirror = true;
      setRotation(TopSide, 0F, 0F, 0F);
      BaseTop = new ModelRenderer(this, 0, 43);
      BaseTop.addBox(0F, 0F, 0F, 6, 1, 6);
      BaseTop.setRotationPoint(-3F, 20F, -4F);
      BaseTop.setTextureSize(128, 128);
      BaseTop.mirror = true;
      setRotation(BaseTop, 0F, 0F, 0F);
      BaseBottom = new ModelRenderer(this, 0, 51);
      BaseBottom.addBox(0F, 0F, 0F, 2, 1, 2);
      BaseBottom.setRotationPoint(-1F, 21F, -2F);
      BaseBottom.setTextureSize(128, 128);
      BaseBottom.mirror = true;
      setRotation(BaseBottom, 0F, 0F, 0F);
      Controls = new ModelRenderer(this, 0, 66);
      Controls.addBox(0F, -4F, -0.5F, 10, 3, 3);
      Controls.setRotationPoint(-5F, 13F, -7F);
      Controls.setTextureSize(128, 128);
      Controls.mirror = true;
      setRotation(Controls, -0.6457718F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Base.render(f5);
    TopHalf1.render(f5);
    TopHalf2.render(f5);
    LeftSide.render(f5);
    RightSide.render(f5);
    BackSide.render(f5);
    TopSide.render(f5);
    BaseTop.render(f5);
    BaseBottom.render(f5);
    Controls.render(f5);
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
	  Base.render(f5);
	  TopHalf1.render(f5);
	  TopHalf2.render(f5);
	  LeftSide.render(f5);
	  RightSide.render(f5);
	  BackSide.render(f5);
	  TopSide.render(f5);
	  BaseTop.render(f5);
	  BaseBottom.render(f5);
	  Controls.render(f5);
	}

}
