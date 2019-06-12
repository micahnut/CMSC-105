/*     */ package org.jfree.ui;
/*     */ 
/*     */ import java.awt.geom.Dimension2D;
/*     */ import java.io.Serializable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FloatDimension
/*     */   extends Dimension2D
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 5367882923248086744L;
/*     */   private float width;
/*     */   private float height;
/*     */   
/*     */   public FloatDimension() {
/*  70 */     this.width = 0.0F;
/*  71 */     this.height = 0.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FloatDimension(FloatDimension fd) {
/*  80 */     this.width = fd.width;
/*  81 */     this.height = fd.height;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FloatDimension(float width, float height) {
/*  91 */     this.width = width;
/*  92 */     this.height = height;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 101 */   public double getWidth() { return this.width; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 110 */   public double getHeight() { return this.height; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 119 */   public void setWidth(double width) { this.width = (float)width; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 128 */   public void setHeight(double height) { this.height = (float)height; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSize(double width, double height) {
/* 141 */     setHeight((float)height);
/* 142 */     setWidth((float)width);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 152 */   public Object clone() { return super.clone(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 166 */     return getClass().getName() + ":={width=" + getWidth() + ", height=" + 
/* 167 */       getHeight() + "}";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 178 */     if (this == o) {
/* 179 */       return true;
/*     */     }
/* 181 */     if (!(o instanceof FloatDimension)) {
/* 182 */       return false;
/*     */     }
/*     */     
/* 185 */     FloatDimension floatDimension = (FloatDimension)o;
/*     */     
/* 187 */     if (this.height != floatDimension.height) {
/* 188 */       return false;
/*     */     }
/* 190 */     if (this.width != floatDimension.width) {
/* 191 */       return false;
/*     */     }
/*     */     
/* 194 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 204 */     result = Float.floatToIntBits(this.width);
/* 205 */     return 29 * result + Float.floatToIntBits(this.height);
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/ui/FloatDimension.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */