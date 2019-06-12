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
/*     */ public class XYIntervalSeries
/*     */   extends ComparableObjectSeries
/*     */ {
/*  66 */   public XYIntervalSeries(Comparable key) { this(key, true, true); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  81 */   public XYIntervalSeries(Comparable key, boolean autoSort, boolean allowDuplicateXValues) { super(key, autoSort, allowDuplicateXValues); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  97 */   public void add(double x, double xLow, double xHigh, double y, double yLow, double yHigh) { add(new XYIntervalDataItem(x, xLow, xHigh, y, yLow, yHigh), true); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 110 */   public void add(XYIntervalDataItem item, boolean notify) { add(item, notify); }
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
/* 121 */     XYIntervalDataItem item = (XYIntervalDataItem)getDataItem(index);
/* 122 */     return item.getX();
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
/*     */   public double getXLowValue(int index) {
/* 136 */     XYIntervalDataItem item = (XYIntervalDataItem)getDataItem(index);
/* 137 */     return item.getXLowValue();
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
/*     */   public double getXHighValue(int index) {
/* 151 */     XYIntervalDataItem item = (XYIntervalDataItem)getDataItem(index);
/* 152 */     return item.getXHighValue();
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
/* 163 */     XYIntervalDataItem item = (XYIntervalDataItem)getDataItem(index);
/* 164 */     return item.getYValue();
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
/* 178 */     XYIntervalDataItem item = (XYIntervalDataItem)getDataItem(index);
/* 179 */     return item.getYLowValue();
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
/* 193 */     XYIntervalDataItem item = (XYIntervalDataItem)getDataItem(index);
/* 194 */     return item.getYHighValue();
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
/* 206 */   public ComparableObjectItem getDataItem(int index) { return super.getDataItem(index); }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/xy/XYIntervalSeries.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */