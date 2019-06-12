/*     */ package org.jfree.data.xy;
/*     */ 
/*     */ import org.jfree.data.ComparableObjectItem;
/*     */ import org.jfree.data.ComparableObjectSeries;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XIntervalSeries
/*     */   extends ComparableObjectSeries
/*     */ {
/*  66 */   public XIntervalSeries(Comparable key) { this(key, true, true); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  81 */   public XIntervalSeries(Comparable key, boolean autoSort, boolean allowDuplicateXValues) { super(key, autoSort, allowDuplicateXValues); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  94 */   public void add(double x, double xLow, double xHigh, double y) { add(new XIntervalDataItem(x, xLow, xHigh, y), true); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 107 */   public void add(XIntervalDataItem item, boolean notify) { add(item, notify); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Number getX(int index) {
/* 118 */     XIntervalDataItem item = (XIntervalDataItem)getDataItem(index);
/* 119 */     return item.getX();
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
/*     */   public double getXLowValue(int index) {
/* 132 */     XIntervalDataItem item = (XIntervalDataItem)getDataItem(index);
/* 133 */     return item.getXLowValue();
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
/*     */   public double getXHighValue(int index) {
/* 146 */     XIntervalDataItem item = (XIntervalDataItem)getDataItem(index);
/* 147 */     return item.getXHighValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getYValue(int index) {
/* 158 */     XIntervalDataItem item = (XIntervalDataItem)getDataItem(index);
/* 159 */     return item.getYValue();
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
/* 171 */   public ComparableObjectItem getDataItem(int index) { return super.getDataItem(index); }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/xy/XIntervalSeries.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */