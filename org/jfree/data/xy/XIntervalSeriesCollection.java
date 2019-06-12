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
/*     */ public class XIntervalSeriesCollection
/*     */   extends AbstractIntervalXYDataset
/*     */   implements IntervalXYDataset, PublicCloneable, Serializable
/*     */ {
/*     */   private List data;
/*     */   
/*  72 */   public XIntervalSeriesCollection() { this.data = new ArrayList(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addSeries(XIntervalSeries series) {
/*  82 */     ParamChecks.nullNotPermitted(series, "series");
/*  83 */     this.data.add(series);
/*  84 */     series.addChangeListener(this);
/*  85 */     fireDatasetChanged();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  95 */   public int getSeriesCount() { return this.data.size(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XIntervalSeries getSeries(int series) {
/* 109 */     if (series < 0 || series >= getSeriesCount()) {
/* 110 */       throw new IllegalArgumentException("Series index out of bounds");
/*     */     }
/* 112 */     return (XIntervalSeries)this.data.get(series);
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
/* 129 */   public Comparable getSeriesKey(int series) { return getSeries(series).getKey(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 145 */   public int getItemCount(int series) { return getSeries(series).getItemCount(); }
/*     */ 
/*     */ 
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
/* 158 */     XIntervalSeries s = (XIntervalSeries)this.data.get(series);
/* 159 */     XIntervalDataItem di = (XIntervalDataItem)s.getDataItem(item);
/* 160 */     return di.getX();
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
/* 174 */     XIntervalSeries s = (XIntervalSeries)this.data.get(series);
/* 175 */     return s.getXLowValue(item);
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
/* 189 */     XIntervalSeries s = (XIntervalSeries)this.data.get(series);
/* 190 */     return s.getXHighValue(item);
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
/* 204 */     XIntervalSeries s = (XIntervalSeries)this.data.get(series);
/* 205 */     return s.getYValue(item);
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
/* 218 */     XIntervalSeries s = (XIntervalSeries)this.data.get(series);
/* 219 */     XIntervalDataItem di = (XIntervalDataItem)s.getDataItem(item);
/* 220 */     return new Double(di.getYValue());
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
/*     */   public Number getStartX(int series, int item) {
/* 233 */     XIntervalSeries s = (XIntervalSeries)this.data.get(series);
/* 234 */     XIntervalDataItem di = (XIntervalDataItem)s.getDataItem(item);
/* 235 */     return new Double(di.getXLowValue());
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
/*     */   public Number getEndX(int series, int item) {
/* 248 */     XIntervalSeries s = (XIntervalSeries)this.data.get(series);
/* 249 */     XIntervalDataItem di = (XIntervalDataItem)s.getDataItem(item);
/* 250 */     return new Double(di.getXHighValue());
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
/*     */   
/* 278 */   public Number getEndY(int series, int item) { return getY(series, item); }
/*     */ 
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
/* 290 */     if (series < 0 || series >= getSeriesCount()) {
/* 291 */       throw new IllegalArgumentException("Series index out of bounds.");
/*     */     }
/* 293 */     XIntervalSeries ts = (XIntervalSeries)this.data.get(series);
/* 294 */     ts.removeChangeListener(this);
/* 295 */     this.data.remove(series);
/* 296 */     fireDatasetChanged();
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
/*     */   public void removeSeries(XIntervalSeries series) {
/* 308 */     ParamChecks.nullNotPermitted(series, "series");
/* 309 */     if (this.data.contains(series)) {
/* 310 */       series.removeChangeListener(this);
/* 311 */       this.data.remove(series);
/* 312 */       fireDatasetChanged();
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
/* 325 */     for (int i = 0; i < this.data.size(); i++) {
/* 326 */       XIntervalSeries series = (XIntervalSeries)this.data.get(i);
/* 327 */       series.removeChangeListener(this);
/*     */     } 
/* 329 */     this.data.clear();
/* 330 */     fireDatasetChanged();
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
/* 342 */     if (obj == this) {
/* 343 */       return true;
/*     */     }
/* 345 */     if (!(obj instanceof XIntervalSeriesCollection)) {
/* 346 */       return false;
/*     */     }
/* 348 */     XIntervalSeriesCollection that = (XIntervalSeriesCollection)obj;
/* 349 */     return ObjectUtilities.equal(this.data, that.data);
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
/* 362 */     XIntervalSeriesCollection clone = (XIntervalSeriesCollection)super.clone();
/* 363 */     clone.data = (List)ObjectUtilities.deepClone(this.data);
/* 364 */     return clone;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/xy/XIntervalSeriesCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */