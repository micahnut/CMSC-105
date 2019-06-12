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
/*     */ public class YWithXInterval
/*     */   implements Serializable
/*     */ {
/*     */   private double y;
/*     */   private double xLow;
/*     */   private double xHigh;
/*     */   
/*     */   public YWithXInterval(double y, double xLow, double xHigh) {
/*  74 */     this.y = y;
/*  75 */     this.xLow = xLow;
/*  76 */     this.xHigh = xHigh;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  85 */   public double getY() { return this.y; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  94 */   public double getXLow() { return this.xLow; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 103 */   public double getXHigh() { return this.xHigh; }
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
/* 115 */     if (obj == this) {
/* 116 */       return true;
/*     */     }
/* 118 */     if (!(obj instanceof YWithXInterval)) {
/* 119 */       return false;
/*     */     }
/* 121 */     YWithXInterval that = (YWithXInterval)obj;
/* 122 */     if (this.y != that.y) {
/* 123 */       return false;
/*     */     }
/* 125 */     if (this.xLow != that.xLow) {
/* 126 */       return false;
/*     */     }
/* 128 */     if (this.xHigh != that.xHigh) {
/* 129 */       return false;
/*     */     }
/* 131 */     return true;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/xy/YWithXInterval.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */