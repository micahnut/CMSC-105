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
/*     */ public class XYIntervalSeriesCollection
/*     */   extends AbstractIntervalXYDataset
/*     */   implements IntervalXYDataset, PublicCloneable, Serializable
/*     */ {
/*     */   private List data;
/*     */   
/*  74 */   public XYIntervalSeriesCollection() { this.data = new ArrayList(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addSeries(XYIntervalSeries series) {
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
/*     */   public XYIntervalSeries getSeries(int series) {
/* 111 */     if (series < 0 || series >= getSeriesCount()) {
/* 112 */       throw new IllegalArgumentException("Series index out of bounds");
/*     */     }
/* 114 */     return (XYIntervalSeries)this.data.get(series);
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
/* 160 */     XYIntervalSeries s = (XYIntervalSeries)this.data.get(series);
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
/*     */   public double getStartXValue(int series, int item) {
/* 175 */     XYIntervalSeries s = (XYIntervalSeries)this.data.get(series);
/* 176 */     return s.getXLowValue(item);
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
/*     */   public double getEndXValue(int series, int item) {
/* 190 */     XYIntervalSeries s = (XYIntervalSeries)this.data.get(series);
/* 191 */     return s.getXHighValue(item);
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
/* 205 */     XYIntervalSeries s = (XYIntervalSeries)this.data.get(series);
/* 206 */     return s.getYValue(item);
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
/* 220 */     XYIntervalSeries s = (XYIntervalSeries)this.data.get(series);
/* 221 */     return s.getYLowValue(item);
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
/* 235 */     XYIntervalSeries s = (XYIntervalSeries)this.data.get(series);
/* 236 */     return s.getYHighValue(item);
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
/* 249 */   public Number getY(int series, int item) { return new Double(getYValue(series, item)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 262 */   public Number getStartX(int series, int item) { return new Double(getStartXValue(series, item)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 275 */   public Number getEndX(int series, int item) { return new Double(getEndXValue(series, item)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 289 */   public Number getStartY(int series, int item) { return new Double(getStartYValue(series, item)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 303 */   public Number getEndY(int series, int item) { return new Double(getEndYValue(series, item)); }
/*     */ 
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
/* 315 */     if (series < 0 || series >= getSeriesCount()) {
/* 316 */       throw new IllegalArgumentException("Series index out of bounds.");
/*     */     }
/* 318 */     XYIntervalSeries ts = (XYIntervalSeries)this.data.get(series);
/* 319 */     ts.removeChangeListener(this);
/* 320 */     this.data.remove(series);
/* 321 */     fireDatasetChanged();
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
/*     */   public void removeSeries(XYIntervalSeries series) {
/* 333 */     ParamChecks.nullNotPermitted(series, "series");
/* 334 */     if (this.data.contains(series)) {
/* 335 */       series.removeChangeListener(this);
/* 336 */       this.data.remove(series);
/* 337 */       fireDatasetChanged();
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
/* 350 */     for (int i = 0; i < this.data.size(); i++) {
/* 351 */       XYIntervalSeries series = (XYIntervalSeries)this.data.get(i);
/* 352 */       series.removeChangeListener(this);
/*     */     } 
/* 354 */     this.data.clear();
/* 355 */     fireDatasetChanged();
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
/* 367 */     if (obj == this) {
/* 368 */       return true;
/*     */     }
/* 370 */     if (!(obj instanceof XYIntervalSeriesCollection)) {
/* 371 */       return false;
/*     */     }
/* 373 */     XYIntervalSeriesCollection that = (XYIntervalSeriesCollection)obj;
/* 374 */     return ObjectUtilities.equal(this.data, that.data);
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
/* 387 */     XYIntervalSeriesCollection clone = (XYIntervalSeriesCollection)super.clone();
/* 388 */     int seriesCount = getSeriesCount();
/* 389 */     clone.data = new ArrayList(seriesCount);
/* 390 */     for (int i = 0; i < this.data.size(); i++) {
/* 391 */       clone.data.set(i, getSeries(i).clone());
/*     */     }
/* 393 */     return clone;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/xy/XYIntervalSeriesCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */