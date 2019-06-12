/*     */ package org.jfree.data.xy;
/*     */ 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XYInterval
/*     */   implements Serializable
/*     */ {
/*     */   private double xLow;
/*     */   private double xHigh;
/*     */   private double y;
/*     */   private double yLow;
/*     */   private double yHigh;
/*     */   
/*     */   public XYInterval(double xLow, double xHigh, double y, double yLow, double yHigh) {
/*  79 */     this.xLow = xLow;
/*  80 */     this.xHigh = xHigh;
/*  81 */     this.y = y;
/*  82 */     this.yLow = yLow;
/*  83 */     this.yHigh = yHigh;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  92 */   public double getXLow() { return this.xLow; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 101 */   public double getXHigh() { return this.xHigh; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 110 */   public double getY() { return this.y; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 119 */   public double getYLow() { return this.yLow; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 128 */   public double getYHigh() { return this.yHigh; }
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
/* 140 */     if (obj == this) {
/* 141 */       return true;
/*     */     }
/* 143 */     if (!(obj instanceof XYInterval)) {
/* 144 */       return false;
/*     */     }
/* 146 */     XYInterval that = (XYInterval)obj;
/* 147 */     if (this.xLow != that.xLow) {
/* 148 */       return false;
/*     */     }
/* 150 */     if (this.xHigh != that.xHigh) {
/* 151 */       return false;
/*     */     }
/* 153 */     if (this.y != that.y) {
/* 154 */       return false;
/*     */     }
/* 156 */     if (this.yLow != that.yLow) {
/* 157 */       return false;
/*     */     }
/* 159 */     if (this.yHigh != that.yHigh) {
/* 160 */       return false;
/*     */     }
/* 162 */     return true;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/xy/XYInterval.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */