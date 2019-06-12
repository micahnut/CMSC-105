/*     */ package org.jfree.chart.renderer;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Paint;
/*     */ import java.io.Serializable;
/*     */ import org.jfree.chart.HashUtilities;
/*     */ import org.jfree.util.PublicCloneable;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GrayPaintScale
/*     */   implements PaintScale, PublicCloneable, Serializable
/*     */ {
/*     */   private double lowerBound;
/*     */   private double upperBound;
/*     */   private int alpha;
/*     */   
/*  78 */   public GrayPaintScale() { this(0.0D, 1.0D); }
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
/*  91 */   public GrayPaintScale(double lowerBound, double upperBound) { this(lowerBound, upperBound, 255); }
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
/*     */   public GrayPaintScale(double lowerBound, double upperBound, int alpha) {
/* 108 */     if (lowerBound >= upperBound) {
/* 109 */       throw new IllegalArgumentException("Requires lowerBound < upperBound.");
/*     */     }
/*     */     
/* 112 */     if (alpha < 0 || alpha > 255) {
/* 113 */       throw new IllegalArgumentException("Requires alpha in the range 0 to 255.");
/*     */     }
/*     */ 
/*     */     
/* 117 */     this.lowerBound = lowerBound;
/* 118 */     this.upperBound = upperBound;
/* 119 */     this.alpha = alpha;
/*     */   }
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
/* 131 */   public double getLowerBound() { return this.lowerBound; }
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
/* 143 */   public double getUpperBound() { return this.upperBound; }
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
/* 154 */   public int getAlpha() { return this.alpha; }
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
/*     */   public Paint getPaint(double value) {
/* 167 */     double v = Math.max(value, this.lowerBound);
/* 168 */     v = Math.min(v, this.upperBound);
/* 169 */     int g = (int)((v - this.lowerBound) / (this.upperBound - this.lowerBound) * 255.0D);
/*     */ 
/*     */ 
/*     */     
/* 173 */     return new Color(g, g, g, this.alpha);
/*     */   }
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
/*     */   public boolean equals(Object obj) {
/* 191 */     if (obj == this) {
/* 192 */       return true;
/*     */     }
/* 194 */     if (!(obj instanceof GrayPaintScale)) {
/* 195 */       return false;
/*     */     }
/* 197 */     GrayPaintScale that = (GrayPaintScale)obj;
/* 198 */     if (this.lowerBound != that.lowerBound) {
/* 199 */       return false;
/*     */     }
/* 201 */     if (this.upperBound != that.upperBound) {
/* 202 */       return false;
/*     */     }
/* 204 */     if (this.alpha != that.alpha) {
/* 205 */       return false;
/*     */     }
/* 207 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 217 */     hash = 7;
/* 218 */     hash = HashUtilities.hashCode(hash, this.lowerBound);
/* 219 */     hash = HashUtilities.hashCode(hash, this.upperBound);
/* 220 */     return 43 * hash + this.alpha;
/*     */   }
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
/* 234 */   public Object clone() throws CloneNotSupportedException { return super.clone(); }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/renderer/GrayPaintScale.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */