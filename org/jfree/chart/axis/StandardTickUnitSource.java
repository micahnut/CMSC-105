/*     */ package org.jfree.chart.axis;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.text.DecimalFormat;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class StandardTickUnitSource
/*     */   implements TickUnitSource, Serializable
/*     */ {
/*  56 */   private static final double LOG_10_VALUE = Math.log(10.0D);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TickUnit getLargerTickUnit(TickUnit unit) {
/*  74 */     double x = unit.getSize();
/*  75 */     double log = Math.log(x) / LOG_10_VALUE;
/*  76 */     double higher = Math.ceil(log);
/*  77 */     return new NumberTickUnit(Math.pow(10.0D, higher), new DecimalFormat("0.0E0"));
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
/*  91 */   public TickUnit getCeilingTickUnit(TickUnit unit) { return getLargerTickUnit(unit); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TickUnit getCeilingTickUnit(double size) {
/* 104 */     double log = Math.log(size) / LOG_10_VALUE;
/* 105 */     double higher = Math.ceil(log);
/* 106 */     return new NumberTickUnit(Math.pow(10.0D, higher), new DecimalFormat("0.0E0"));
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
/*     */   public boolean equals(Object obj) {
/* 119 */     if (obj == this) {
/* 120 */       return true;
/*     */     }
/* 122 */     return obj instanceof StandardTickUnitSource;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 132 */   public int hashCode() { return 0; }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/axis/StandardTickUnitSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */