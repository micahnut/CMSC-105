/*     */ package org.jfree.data.function;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import org.jfree.chart.HashUtilities;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PowerFunction2D
/*     */   implements Function2D, Serializable
/*     */ {
/*     */   private double a;
/*     */   private double b;
/*     */   
/*     */   public PowerFunction2D(double a, double b) {
/*  66 */     this.a = a;
/*  67 */     this.b = b;
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
/*  78 */   public double getA() { return this.a; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  89 */   public double getB() { return this.b; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 101 */   public double getValue(double x) { return this.a * Math.pow(x, this.b); }
/*     */ 
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
/* 113 */     if (!(obj instanceof PowerFunction2D)) {
/* 114 */       return false;
/*     */     }
/* 116 */     PowerFunction2D that = (PowerFunction2D)obj;
/* 117 */     if (this.a != that.a) {
/* 118 */       return false;
/*     */     }
/* 120 */     if (this.b != that.b) {
/* 121 */       return false;
/*     */     }
/* 123 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 133 */     result = 29;
/* 134 */     result = HashUtilities.hashCode(result, this.a);
/* 135 */     return HashUtilities.hashCode(result, this.b);
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/function/PowerFunction2D.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */