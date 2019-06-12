/*     */ package org.jfree.chart.axis;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class TickUnit
/*     */   implements Comparable, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 510179855057013974L;
/*     */   private double size;
/*     */   private int minorTickCount;
/*     */   
/*  84 */   public TickUnit(double size) { this.size = size; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TickUnit(double size, int minorTickCount) {
/*  96 */     this.size = size;
/*  97 */     this.minorTickCount = minorTickCount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 106 */   public double getSize() { return this.size; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 117 */   public int getMinorTickCount() { return this.minorTickCount; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 130 */   public String valueToString(double value) { return String.valueOf(value); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int compareTo(Object object) {
/* 145 */     if (object instanceof TickUnit) {
/* 146 */       TickUnit other = (TickUnit)object;
/* 147 */       if (this.size > other.getSize()) {
/* 148 */         return 1;
/*     */       }
/* 150 */       if (this.size < other.getSize()) {
/* 151 */         return -1;
/*     */       }
/*     */       
/* 154 */       return 0;
/*     */     } 
/*     */ 
/*     */     
/* 158 */     return -1;
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
/*     */   public boolean equals(Object obj) {
/* 172 */     if (obj == this) {
/* 173 */       return true;
/*     */     }
/* 175 */     if (!(obj instanceof TickUnit)) {
/* 176 */       return false;
/*     */     }
/* 178 */     TickUnit that = (TickUnit)obj;
/* 179 */     if (this.size != that.size) {
/* 180 */       return false;
/*     */     }
/* 182 */     if (this.minorTickCount != that.minorTickCount) {
/* 183 */       return false;
/*     */     }
/* 185 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 195 */     long temp = (this.size != 0.0D) ? Double.doubleToLongBits(this.size) : 0L;
/*     */     
/* 197 */     return (int)(temp ^ temp >>> 32);
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/axis/TickUnit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */