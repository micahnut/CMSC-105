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
/*     */ public class YIntervalDataItem
/*     */   extends ComparableObjectItem
/*     */ {
/*  61 */   public YIntervalDataItem(double x, double y, double yLow, double yHigh) { super(new Double(x), new YInterval(y, yLow, yHigh)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  70 */   public Double getX() { return (Double)getComparable(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getYValue() {
/*  79 */     YInterval interval = (YInterval)getObject();
/*  80 */     if (interval != null) {
/*  81 */       return interval.getY();
/*     */     }
/*     */     
/*  84 */     return NaND;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getYLowValue() {
/*  94 */     YInterval interval = (YInterval)getObject();
/*  95 */     if (interval != null) {
/*  96 */       return interval.getYLow();
/*     */     }
/*     */     
/*  99 */     return NaND;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getYHighValue() {
/* 109 */     YInterval interval = (YInterval)getObject();
/* 110 */     if (interval != null) {
/* 111 */       return interval.getYHigh();
/*     */     }
/*     */     
/* 114 */     return NaND;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/xy/YIntervalDataItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */