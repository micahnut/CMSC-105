/*     */ package org.jfree.data.xy;
/*     */ 
/*     */ import org.jfree.data.ComparableObjectItem;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XYIntervalDataItem
/*     */   extends ComparableObjectItem
/*     */ {
/*  64 */   public XYIntervalDataItem(double x, double xLow, double xHigh, double y, double yLow, double yHigh) { super(new Double(x), new XYInterval(xLow, xHigh, y, yLow, yHigh)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  73 */   public Double getX() { return (Double)getComparable(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getYValue() {
/*  82 */     XYInterval interval = (XYInterval)getObject();
/*  83 */     if (interval != null) {
/*  84 */       return interval.getY();
/*     */     }
/*     */     
/*  87 */     return NaND;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getXLowValue() {
/*  97 */     XYInterval interval = (XYInterval)getObject();
/*  98 */     if (interval != null) {
/*  99 */       return interval.getXLow();
/*     */     }
/*     */     
/* 102 */     return NaND;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getXHighValue() {
/* 112 */     XYInterval interval = (XYInterval)getObject();
/* 113 */     if (interval != null) {
/* 114 */       return interval.getXHigh();
/*     */     }
/*     */     
/* 117 */     return NaND;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getYLowValue() {
/* 127 */     XYInterval interval = (XYInterval)getObject();
/* 128 */     if (interval != null) {
/* 129 */       return interval.getYLow();
/*     */     }
/*     */     
/* 132 */     return NaND;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getYHighValue() {
/* 142 */     XYInterval interval = (XYInterval)getObject();
/* 143 */     if (interval != null) {
/* 144 */       return interval.getYHigh();
/*     */     }
/*     */     
/* 147 */     return NaND;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/xy/XYIntervalDataItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */