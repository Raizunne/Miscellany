package com.raizunne.miscellany.block.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class modelAdvReactBrewer extends ModelBase
{
  //fields
    ModelRenderer Column;
    ModelRenderer Base_Bottom;
    ModelRenderer Base_Top;
    ModelRenderer Platform_Top;
    ModelRenderer Platform_1;
    ModelRenderer Platform_2;
    ModelRenderer Platform_3;
    ModelRenderer Ring_1;
    ModelRenderer Ring_2;
    ModelRenderer Notch;
    ModelRenderer Notch_1;
    ModelRenderer Notch_2;
    ModelRenderer Notch_3;
    ModelRenderer Bar_1;
    ModelRenderer Bar_2;
    ModelRenderer Bar_3;
  
  public modelAdvReactBrewer()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      Column = new ModelRenderer(this, 48, 0);
      Column.addBox(0F, 0F, 0F, 4, 9, 4);
      Column.setRotationPoint(-2F, 13F, -2F);
      Column.setTextureSize(64, 64);
      Column.mirror = true;
      setRotation(Column, 0F, 0F, 0F);
      Base_Bottom = new ModelRenderer(this, 0, 0);
      Base_Bottom.addBox(0F, 0F, 0F, 12, 1, 12);
      Base_Bottom.setRotationPoint(-6F, 23F, -6F);
      Base_Bottom.setTextureSize(64, 64);
      Base_Bottom.mirror = true;
      setRotation(Base_Bottom, 0F, 0F, 0F);
      Base_Top = new ModelRenderer(this, 0, 13);
      Base_Top.addBox(0F, 0F, 0F, 10, 1, 10);
      Base_Top.setRotationPoint(-5F, 22F, -5F);
      Base_Top.setTextureSize(64, 64);
      Base_Top.mirror = true;
      setRotation(Base_Top, 0F, 0F, 0F);
      Platform_Top = new ModelRenderer(this, 0, 24);
      Platform_Top.addBox(0F, 0F, 0F, 6, 1, 6);
      Platform_Top.setRotationPoint(-3F, 11F, -3F);
      Platform_Top.setTextureSize(64, 64);
      Platform_Top.mirror = true;
      setRotation(Platform_Top, 0F, 0F, 0F);
      Platform_1 = new ModelRenderer(this, 41, 15);
      Platform_1.addBox(-6.2F, -2F, -0.8F, 4, 1, 4);
      Platform_1.setRotationPoint(-0.5F, 16F, -2.5F);
      Platform_1.setTextureSize(64, 64);
      Platform_1.mirror = true;
      setRotation(Platform_1, 0F, -0.7853982F, 0F);
      Platform_2 = new ModelRenderer(this, 41, 15);
      Platform_2.addBox(0.7F, 0F, 0F, 4, 1, 4);
      Platform_2.setRotationPoint(3F, 14F, -2F);
      Platform_2.setTextureSize(64, 64);
      Platform_2.mirror = true;
      setRotation(Platform_2, 0F, 0F, 0F);
      Platform_3 = new ModelRenderer(this, 41, 15);
      Platform_3.addBox(-9.5F, -2F, 0.2F, 4, 1, 4);
      Platform_3.setRotationPoint(-0.5F, 16F, -2.5F);
      Platform_3.setTextureSize(64, 64);
      Platform_3.mirror = true;
      setRotation(Platform_3, 0F, 0.7853982F, 0F);
      Ring_1 = new ModelRenderer(this, 25, 24);
      Ring_1.addBox(0F, 0F, 0F, 6, 1, 6);
      Ring_1.setRotationPoint(-3F, 15F, -3F);
      Ring_1.setTextureSize(64, 64);
      Ring_1.mirror = true;
      setRotation(Ring_1, 0F, 0F, 0F);
      Ring_2 = new ModelRenderer(this, 25, 24);
      Ring_2.addBox(0F, 0F, 0F, 6, 1, 6);
      Ring_2.setRotationPoint(-3F, 20F, -3F);
      Ring_2.setTextureSize(64, 64);
      Ring_2.mirror = true;
      setRotation(Ring_2, 0F, 0F, 0F);
      Notch = new ModelRenderer(this, 51, 26);
      Notch.addBox(0F, 0F, 0F, 2, 1, 2);
      Notch.setRotationPoint(-1F, 12F, -1F);
      Notch.setTextureSize(64, 64);
      Notch.mirror = true;
      setRotation(Notch, 0F, 0F, 0F);
      Notch_1 = new ModelRenderer(this, 0, 32);
      Notch_1.addBox(0.7F, 0F, 0F, 2, 2, 2);
      Notch_1.setRotationPoint(4F, 15F, -1F);
      Notch_1.setTextureSize(64, 64);
      Notch_1.mirror = true;
      setRotation(Notch_1, 0F, 0F, 0F);
      Notch_2 = new ModelRenderer(this, 0, 32);
      Notch_2.addBox(-6F, -2F, 1.5F, 2, 2, 2);
      Notch_2.setRotationPoint(1F, 17F, -3F);
      Notch_2.setTextureSize(64, 64);
      Notch_2.mirror = true;
      setRotation(Notch_2, 0F, -0.7853982F, 0F);
      Notch_3 = new ModelRenderer(this, 0, 32);
      Notch_3.addBox(-10F, -2F, 0.5F, 2, 2, 2);
      Notch_3.setRotationPoint(1F, 17F, -3F);
      Notch_3.setTextureSize(64, 64);
      Notch_3.mirror = true;
      setRotation(Notch_3, 0F, 0.7853982F, 0F);
      Bar_1 = new ModelRenderer(this, 0, 38);
      Bar_1.addBox(-0.3F, 0F, 0F, 5, 2, 2);
      Bar_1.setRotationPoint(2F, 17F, -1F);
      Bar_1.setTextureSize(64, 64);
      Bar_1.mirror = true;
      setRotation(Bar_1, 0F, 0F, 0F);
      Bar_2 = new ModelRenderer(this, 0, 43);
      Bar_2.addBox(-6F, 0F, 1.5F, 6, 2, 2);
      Bar_2.setRotationPoint(1F, 17F, -3F);
      Bar_2.setTextureSize(64, 64);
      Bar_2.mirror = true;
      setRotation(Bar_2, 0F, -0.7853982F, 0F);
      Bar_3 = new ModelRenderer(this, 0, 43);
      Bar_3.addBox(-10F, 0F, 0.5F, 6, 2, 2);
      Bar_3.setRotationPoint(1F, 17F, -3F);
      Bar_3.setTextureSize(64, 64);
      Bar_3.mirror = true;
      setRotation(Bar_3, 0F, 0.7853982F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Column.render(f5);
    Base_Bottom.render(f5);
    Base_Top.render(f5);
    Platform_Top.render(f5);
    Platform_1.render(f5);
    Platform_2.render(f5);
    Platform_3.render(f5);
    Ring_1.render(f5);
    Ring_2.render(f5);
    Notch.render(f5);
    Notch_1.render(f5);
    Notch_2.render(f5);
    Notch_3.render(f5);
    Bar_1.render(f5);
    Bar_2.render(f5);
    Bar_3.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void renderModel(float f5){
	  Column.render(f5);
	  Base_Bottom.render(f5);
	  Base_Top.render(f5);
	  Platform_Top.render(f5);
	  Platform_1.render(f5);
	  Platform_2.render(f5);
	  Platform_3.render(f5);
	  Ring_1.render(f5);
	  Ring_2.render(f5);
	  Notch.render(f5);
	  Notch_1.render(f5);
	  Notch_2.render(f5);
	  Notch_3.render(f5);
	  Bar_1.render(f5);
	  Bar_2.render(f5);
	  Bar_3.render(f5);
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
