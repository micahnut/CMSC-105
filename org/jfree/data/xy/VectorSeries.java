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
/*     */ 
/*     */ 
/*     */ public class VectorSeries
/*     */   extends ComparableObjectSeries
/*     */ {
/*  68 */   public VectorSeries(Comparable key) { this(key, false, true); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  83 */   public VectorSeries(Comparable key, boolean autoSort, boolean allowDuplicateXValues) { super(key, autoSort, allowDuplicateXValues); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  95 */   public void add(double x, double y, double deltaX, double deltaY) { add(new VectorDataItem(x, y, deltaX, deltaY), true); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 108 */   public void add(VectorDataItem item, boolean notify) { add(item, notify); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ComparableObjectItem remove(int index) {
/* 121 */     VectorDataItem result = (VectorDataItem)this.data.remove(index);
/* 122 */     fireSeriesChanged();
/* 123 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getXValue(int index) {
/* 134 */     VectorDataItem item = (VectorDataItem)getDataItem(index);
/* 135 */     return item.getXValue();
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
/* 146 */     VectorDataItem item = (VectorDataItem)getDataItem(index);
/* 147 */     return item.getYValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getVectorXValue(int index) {
/* 158 */     VectorDataItem item = (VectorDataItem)getDataItem(index);
/* 159 */     return item.getVectorX();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getVectorYValue(int index) {
/* 170 */     VectorDataItem item = (VectorDataItem)getDataItem(index);
/* 171 */     return item.getVectorY();
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
/* 184 */   public ComparableObjectItem getDataItem(int index) { return super.getDataItem(index); }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/xy/VectorSeries.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */