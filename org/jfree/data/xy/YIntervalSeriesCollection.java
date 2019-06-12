/*     */ package org.jfree.data.xy;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.jfree.chart.util.ParamChecks;
/*     */ import org.jfree.util.ObjectUtilities;
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
/*     */ public class YIntervalSeriesCollection
/*     */   extends AbstractIntervalXYDataset
/*     */   implements IntervalXYDataset, PublicCloneable, Serializable
/*     */ {
/*     */   private List data;
/*     */   
/*  74 */   public YIntervalSeriesCollection() { this.data = new ArrayList(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addSeries(YIntervalSeries series) {
/*  84 */     ParamChecks.nullNotPermitted(series, "series");
/*  85 */     this.data.add(series);
/*  86 */     series.addChangeListener(this);
/*  87 */     fireDatasetChanged();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  97 */   public int getSeriesCount() { return this.data.size(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public YIntervalSeries getSeries(int series) {
/* 111 */     if (series < 0 || series >= getSeriesCount()) {
/* 112 */       throw new IllegalArgumentException("Series index out of bounds");
/*     */     }
/* 114 */     return (YIntervalSeries)this.data.get(series);
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
/*     */ 
/*     */ 
/*     */   
/* 131 */   public Comparable getSeriesKey(int series) { return getSeries(series).getKey(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 147 */   public int getItemCount(int series) { return getSeries(series).getItemCount(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Number getX(int series, int item) {
/* 160 */     YIntervalSeries s = (YIntervalSeries)this.data.get(series);
/* 161 */     return s.getX(item);
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
/*     */   public double getYValue(int series, int item) {
/* 175 */     YIntervalSeries s = (YIntervalSeries)this.data.get(series);
/* 176 */     return s.getYValue(item);
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
/*     */   public double getStartYValue(int series, int item) {
/* 190 */     YIntervalSeries s = (YIntervalSeries)this.data.get(series);
/* 191 */     return s.getYLowValue(item);
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
/*     */   public double getEndYValue(int series, int item) {
/* 205 */     YIntervalSeries s = (YIntervalSeries)this.data.get(series);
/* 206 */     return s.getYHighValue(item);
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
/*     */   public Number getY(int series, int item) {
/* 219 */     YIntervalSeries s = (YIntervalSeries)this.data.get(series);
/* 220 */     return new Double(s.getYValue(item));
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
/* 234 */   public Number getStartX(int series, int item) { return getX(series, item); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 248 */   public Number getEndX(int series, int item) { return getX(series, item); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Number getStartY(int series, int item) {
/* 261 */     YIntervalSeries s = (YIntervalSeries)this.data.get(series);
/* 262 */     return new Double(s.getYLowValue(item));
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
/*     */   public Number getEndY(int series, int item) {
/* 275 */     YIntervalSeries s = (YIntervalSeries)this.data.get(series);
/* 276 */     return new Double(s.getYHighValue(item));
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
/*     */   public void removeSeries(int series) {
/* 288 */     if (series < 0 || series >= getSeriesCount()) {
/* 289 */       throw new IllegalArgumentException("Series index out of bounds.");
/*     */     }
/* 291 */     YIntervalSeries ts = (YIntervalSeries)this.data.get(series);
/* 292 */     ts.removeChangeListener(this);
/* 293 */     this.data.remove(series);
/* 294 */     fireDatasetChanged();
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
/*     */   public void removeSeries(YIntervalSeries series) {
/* 306 */     ParamChecks.nullNotPermitted(series, "series");
/* 307 */     if (this.data.contains(series)) {
/* 308 */       series.removeChangeListener(this);
/* 309 */       this.data.remove(series);
/* 310 */       fireDatasetChanged();
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
/*     */   
/*     */   public void removeAllSeries() {
/* 323 */     for (int i = 0; i < this.data.size(); i++) {
/* 324 */       YIntervalSeries series = (YIntervalSeries)this.data.get(i);
/* 325 */       series.removeChangeListener(this);
/*     */     } 
/* 327 */     this.data.clear();
/* 328 */     fireDatasetChanged();
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
/* 340 */     if (obj == this) {
/* 341 */       return true;
/*     */     }
/* 343 */     if (!(obj instanceof YIntervalSeriesCollection)) {
/* 344 */       return false;
/*     */     }
/* 346 */     YIntervalSeriesCollection that = (YIntervalSeriesCollection)obj;
/* 347 */     return ObjectUtilities.equal(this.data, that.data);
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
/* 360 */     YIntervalSeriesCollection clone = (YIntervalSeriesCollection)super.clone();
/* 361 */     clone.data = (List)ObjectUtilities.deepClone(this.data);
/* 362 */     return clone;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/xy/YIntervalSeriesCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */