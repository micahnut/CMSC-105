/*     */ package org.jfree.data.statistics;
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
/*     */ public class HistogramBin
/*     */   implements Cloneable, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 7614685080015589931L;
/*     */   private int count;
/*     */   private double startBoundary;
/*     */   private double endBoundary;
/*     */   
/*     */   public HistogramBin(double startBoundary, double endBoundary) {
/*  73 */     if (startBoundary > endBoundary) {
/*  74 */       throw new IllegalArgumentException("HistogramBin():  startBoundary > endBoundary.");
/*     */     }
/*     */     
/*  77 */     this.count = 0;
/*  78 */     this.startBoundary = startBoundary;
/*  79 */     this.endBoundary = endBoundary;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  88 */   public int getCount() { return this.count; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  95 */   public void incrementCount() { this.count++; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 104 */   public double getStartBoundary() { return this.startBoundary; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 113 */   public double getEndBoundary() { return this.endBoundary; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 122 */   public double getBinWidth() { return this.endBoundary - this.startBoundary; }
/*     */ 
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
/* 134 */     if (obj == null) {
/* 135 */       return false;
/*     */     }
/* 137 */     if (obj == this) {
/* 138 */       return true;
/*     */     }
/* 140 */     if (obj instanceof HistogramBin) {
/* 141 */       HistogramBin bin = (HistogramBin)obj;
/* 142 */       boolean b0 = (bin.startBoundary == this.startBoundary);
/* 143 */       boolean b1 = (bin.endBoundary == this.endBoundary);
/* 144 */       boolean b2 = (bin.count == this.count);
/* 145 */       return (b0 && b1 && b2);
/*     */     } 
/* 147 */     return false;
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
/* 159 */   public Object clone() throws CloneNotSupportedException { return super.clone(); }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/statistics/HistogramBin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */