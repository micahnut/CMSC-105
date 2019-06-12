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
/*     */ public class YInterval
/*     */   implements Serializable
/*     */ {
/*     */   private double y;
/*     */   private double yLow;
/*     */   private double yHigh;
/*     */   
/*     */   public YInterval(double y, double yLow, double yHigh) {
/*  70 */     this.y = y;
/*  71 */     this.yLow = yLow;
/*  72 */     this.yHigh = yHigh;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  81 */   public double getY() { return this.y; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  90 */   public double getYLow() { return this.yLow; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  99 */   public double getYHigh() { return this.yHigh; }
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
/* 111 */     if (obj == this) {
/* 112 */       return true;
/*     */     }
/* 114 */     if (!(obj instanceof YInterval)) {
/* 115 */       return false;
/*     */     }
/* 117 */     YInterval that = (YInterval)obj;
/* 118 */     if (this.y != that.y) {
/* 119 */       return false;
/*     */     }
/* 121 */     if (this.yLow != that.yLow) {
/* 122 */       return false;
/*     */     }
/* 124 */     if (this.yHigh != that.yHigh) {
/* 125 */       return false;
/*     */     }
/* 127 */     return true;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/xy/YInterval.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */