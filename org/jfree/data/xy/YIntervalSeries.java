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
/*     */ public class YIntervalSeries
/*     */   extends ComparableObjectSeries
/*     */ {
/*  66 */   public YIntervalSeries(Comparable key) { this(key, true, true); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  81 */   public YIntervalSeries(Comparable key, boolean autoSort, boolean allowDuplicateXValues) { super(key, autoSort, allowDuplicateXValues); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  94 */   public void add(double x, double y, double yLow, double yHigh) { add(new YIntervalDataItem(x, y, yLow, yHigh), true); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 107 */   public void add(YIntervalDataItem item, boolean notify) { add(item, notify); }
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
/* 118 */     YIntervalDataItem item = (YIntervalDataItem)getDataItem(index);
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
/*     */   public double getYValue(int index) {
/* 130 */     YIntervalDataItem item = (YIntervalDataItem)getDataItem(index);
/* 131 */     return item.getYValue();
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
/*     */   public double getYLowValue(int index) {
/* 145 */     YIntervalDataItem item = (YIntervalDataItem)getDataItem(index);
/* 146 */     return item.getYLowValue();
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
/*     */   public double getYHighValue(int index) {
/* 160 */     YIntervalDataItem item = (YIntervalDataItem)getDataItem(index);
/* 161 */     return item.getYHighValue();
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
/* 173 */   public ComparableObjectItem getDataItem(int index) { return super.getDataItem(index); }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/xy/YIntervalSeries.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */