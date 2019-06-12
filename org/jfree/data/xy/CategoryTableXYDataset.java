/*     */ package org.jfree.data.xy;
/*     */ 
/*     */ import org.jfree.data.DefaultKeyedValues2D;
/*     */ import org.jfree.data.DomainInfo;
/*     */ import org.jfree.data.Range;
/*     */ import org.jfree.data.general.DatasetUtilities;
/*     */ import org.jfree.util.PublicCloneable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CategoryTableXYDataset
/*     */   extends AbstractIntervalXYDataset
/*     */   implements TableXYDataset, IntervalXYDataset, DomainInfo, PublicCloneable
/*     */ {
/*     */   private DefaultKeyedValues2D values;
/*     */   private IntervalXYDelegate intervalDelegate;
/*     */   
/*     */   public CategoryTableXYDataset() {
/*  88 */     this.values = new DefaultKeyedValues2D(true);
/*  89 */     this.intervalDelegate = new IntervalXYDelegate(this);
/*  90 */     addChangeListener(this.intervalDelegate);
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
/* 102 */   public void add(double x, double y, String seriesName) { add(new Double(x), new Double(y), seriesName, true); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(Number x, Number y, String seriesName, boolean notify) {
/* 115 */     this.values.addValue(y, (Comparable)x, seriesName);
/* 116 */     if (notify) {
/* 117 */       fireDatasetChanged();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 128 */   public void remove(double x, String seriesName) { remove(new Double(x), seriesName, true); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove(Number x, String seriesName, boolean notify) {
/* 139 */     this.values.removeValue((Comparable)x, seriesName);
/* 140 */     if (notify) {
/* 141 */       fireDatasetChanged();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 152 */     this.values.clear();
/* 153 */     fireDatasetChanged();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 163 */   public int getSeriesCount() { return this.values.getColumnCount(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 175 */   public Comparable getSeriesKey(int series) { return this.values.getColumnKey(series); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 185 */   public int getItemCount() { return this.values.getRowCount(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 198 */   public int getItemCount(int series) { return getItemCount(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 212 */   public Number getX(int series, int item) { return (Number)this.values.getRowKey(item); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 225 */   public Number getStartX(int series, int item) { return this.intervalDelegate.getStartX(series, item); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 238 */   public Number getEndX(int series, int item) { return this.intervalDelegate.getEndX(series, item); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 251 */   public Number getY(int series, int item) { return this.values.getValue(item, series); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 264 */   public Number getStartY(int series, int item) { return getY(series, item); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 277 */   public Number getEndY(int series, int item) { return getY(series, item); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 290 */   public double getDomainLowerBound(boolean includeInterval) { return this.intervalDelegate.getDomainLowerBound(includeInterval); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 303 */   public double getDomainUpperBound(boolean includeInterval) { return this.intervalDelegate.getDomainUpperBound(includeInterval); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Range getDomainBounds(boolean includeInterval) {
/* 316 */     if (includeInterval) {
/* 317 */       return this.intervalDelegate.getDomainBounds(includeInterval);
/*     */     }
/*     */     
/* 320 */     return DatasetUtilities.iterateDomainBounds(this, includeInterval);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 330 */   public double getIntervalPositionFactor() { return this.intervalDelegate.getIntervalPositionFactor(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIntervalPositionFactor(double d) {
/* 342 */     this.intervalDelegate.setIntervalPositionFactor(d);
/* 343 */     fireDatasetChanged();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 352 */   public double getIntervalWidth() { return this.intervalDelegate.getIntervalWidth(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIntervalWidth(double d) {
/* 362 */     this.intervalDelegate.setFixedIntervalWidth(d);
/* 363 */     fireDatasetChanged();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 372 */   public boolean isAutoWidth() { return this.intervalDelegate.isAutoWidth(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAutoWidth(boolean b) {
/* 382 */     this.intervalDelegate.setAutoWidth(b);
/* 383 */     fireDatasetChanged();
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
/*     */   public boolean equals(Object obj) {
/* 395 */     if (!(obj instanceof CategoryTableXYDataset)) {
/* 396 */       return false;
/*     */     }
/* 398 */     CategoryTableXYDataset that = (CategoryTableXYDataset)obj;
/* 399 */     if (!this.intervalDelegate.equals(that.intervalDelegate)) {
/* 400 */       return false;
/*     */     }
/* 402 */     if (!this.values.equals(that.values)) {
/* 403 */       return false;
/*     */     }
/* 405 */     return true;
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
/*     */   public Object clone() throws CloneNotSupportedException {
/* 418 */     CategoryTableXYDataset clone = (CategoryTableXYDataset)super.clone();
/* 419 */     clone.values = (DefaultKeyedValues2D)this.values.clone();
/* 420 */     clone.intervalDelegate = new IntervalXYDelegate(clone);
/*     */     
/* 422 */     clone.intervalDelegate.setFixedIntervalWidth(getIntervalWidth());
/* 423 */     clone.intervalDelegate.setAutoWidth(isAutoWidth());
/* 424 */     clone.intervalDelegate.setIntervalPositionFactor(
/* 425 */         getIntervalPositionFactor());
/* 426 */     return clone;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/xy/CategoryTableXYDataset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */