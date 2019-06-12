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
/*     */ public class XIntervalDataItem
/*     */   extends ComparableObjectItem
/*     */ {
/*  61 */   public XIntervalDataItem(double x, double xLow, double xHigh, double y) { super(new Double(x), new YWithXInterval(y, xLow, xHigh)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  70 */   public Number getX() { return (Number)getComparable(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getYValue() {
/*  79 */     YWithXInterval interval = (YWithXInterval)getObject();
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
/*     */   public double getXLowValue() {
/*  94 */     YWithXInterval interval = (YWithXInterval)getObject();
/*  95 */     if (interval != null) {
/*  96 */       return interval.getXLow();
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
/*     */   public double getXHighValue() {
/* 109 */     YWithXInterval interval = (YWithXInterval)getObject();
/* 110 */     if (interval != null) {
/* 111 */       return interval.getXHigh();
/*     */     }
/*     */     
/* 114 */     return NaND;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/xy/XIntervalDataItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */