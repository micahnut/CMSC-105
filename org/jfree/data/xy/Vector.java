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
/*     */ public class Vector
/*     */   implements Serializable
/*     */ {
/*     */   private double x;
/*     */   private double y;
/*     */   
/*     */   public Vector(double x, double y) {
/*  68 */     this.x = x;
/*  69 */     this.y = y;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  78 */   public double getX() { return this.x; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  87 */   public double getY() { return this.y; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  96 */   public double getLength() { return Math.sqrt(this.x * this.x + this.y * this.y); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 105 */   public double getAngle() { return Math.atan2(this.y, this.x); }
/*     */ 
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
/* 117 */     if (obj == this) {
/* 118 */       return true;
/*     */     }
/* 120 */     if (!(obj instanceof Vector)) {
/* 121 */       return false;
/*     */     }
/* 123 */     Vector that = (Vector)obj;
/* 124 */     if (this.x != that.x) {
/* 125 */       return false;
/*     */     }
/* 127 */     if (this.y != that.y) {
/* 128 */       return false;
/*     */     }
/* 130 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 140 */     result = 193;
/* 141 */     long temp = Double.doubleToLongBits(this.x);
/* 142 */     result = 37 * result + (int)(temp ^ temp >>> 32);
/* 143 */     temp = Double.doubleToLongBits(this.y);
/* 144 */     return 37 * result + (int)(temp ^ temp >>> 32);
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/xy/Vector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */