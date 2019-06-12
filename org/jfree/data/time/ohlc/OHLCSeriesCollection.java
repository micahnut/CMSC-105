/*     */ package org.jfree.data.time.ohlc;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.jfree.chart.HashUtilities;
/*     */ import org.jfree.chart.util.ParamChecks;
/*     */ import org.jfree.data.general.DatasetChangeEvent;
/*     */ import org.jfree.data.time.RegularTimePeriod;
/*     */ import org.jfree.data.time.TimePeriodAnchor;
/*     */ import org.jfree.data.xy.AbstractXYDataset;
/*     */ import org.jfree.data.xy.OHLCDataset;
/*     */ import org.jfree.util.ObjectUtilities;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class OHLCSeriesCollection
/*     */   extends AbstractXYDataset
/*     */   implements OHLCDataset, Serializable
/*     */ {
/*     */   private List data;
/*  73 */   private TimePeriodAnchor xPosition = TimePeriodAnchor.MIDDLE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  79 */   public OHLCSeriesCollection() { this.data = new ArrayList(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  91 */   public TimePeriodAnchor getXPosition() { return this.xPosition; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setXPosition(TimePeriodAnchor anchor) {
/* 104 */     ParamChecks.nullNotPermitted(anchor, "anchor");
/* 105 */     this.xPosition = anchor;
/* 106 */     notifyListeners(new DatasetChangeEvent(this, this));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addSeries(OHLCSeries series) {
/* 116 */     ParamChecks.nullNotPermitted(series, "series");
/* 117 */     this.data.add(series);
/* 118 */     series.addChangeListener(this);
/* 119 */     fireDatasetChanged();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 129 */   public int getSeriesCount() { return this.data.size(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OHLCSeries getSeries(int series) {
/* 143 */     if (series < 0 || series >= getSeriesCount()) {
/* 144 */       throw new IllegalArgumentException("Series index out of bounds");
/*     */     }
/* 146 */     return (OHLCSeries)this.data.get(series);
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
/* 163 */   public Comparable getSeriesKey(int series) { return getSeries(series).getKey(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 179 */   public int getItemCount(int series) { return getSeries(series).getItemCount(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected long getX(RegularTimePeriod period) {
/* 190 */     long result = 0L;
/* 191 */     if (this.xPosition == TimePeriodAnchor.START) {
/* 192 */       result = period.getFirstMillisecond();
/*     */     }
/* 194 */     else if (this.xPosition == TimePeriodAnchor.MIDDLE) {
/* 195 */       result = period.getMiddleMillisecond();
/*     */     }
/* 197 */     else if (this.xPosition == TimePeriodAnchor.END) {
/* 198 */       result = period.getLastMillisecond();
/*     */     } 
/* 200 */     return result;
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
/*     */   public double getXValue(int series, int item) {
/* 213 */     OHLCSeries s = (OHLCSeries)this.data.get(series);
/* 214 */     OHLCItem di = (OHLCItem)s.getDataItem(item);
/* 215 */     RegularTimePeriod period = di.getPeriod();
/* 216 */     return getX(period);
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
/* 229 */   public Number getX(int series, int item) { return new Double(getXValue(series, item)); }
/*     */ 
/*     */ 
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
/* 242 */     OHLCSeries s = (OHLCSeries)this.data.get(series);
/* 243 */     OHLCItem di = (OHLCItem)s.getDataItem(item);
/* 244 */     return new Double(di.getYValue());
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
/*     */   public double getOpenValue(int series, int item) {
/* 257 */     OHLCSeries s = (OHLCSeries)this.data.get(series);
/* 258 */     OHLCItem di = (OHLCItem)s.getDataItem(item);
/* 259 */     return di.getOpenValue();
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
/* 272 */   public Number getOpen(int series, int item) { return new Double(getOpenValue(series, item)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getCloseValue(int series, int item) {
/* 285 */     OHLCSeries s = (OHLCSeries)this.data.get(series);
/* 286 */     OHLCItem di = (OHLCItem)s.getDataItem(item);
/* 287 */     return di.getCloseValue();
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
/* 300 */   public Number getClose(int series, int item) { return new Double(getCloseValue(series, item)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getHighValue(int series, int item) {
/* 313 */     OHLCSeries s = (OHLCSeries)this.data.get(series);
/* 314 */     OHLCItem di = (OHLCItem)s.getDataItem(item);
/* 315 */     return di.getHighValue();
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
/* 328 */   public Number getHigh(int series, int item) { return new Double(getHighValue(series, item)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getLowValue(int series, int item) {
/* 341 */     OHLCSeries s = (OHLCSeries)this.data.get(series);
/* 342 */     OHLCItem di = (OHLCItem)s.getDataItem(item);
/* 343 */     return di.getLowValue();
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
/* 356 */   public Number getLow(int series, int item) { return new Double(getLowValue(series, item)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 370 */   public Number getVolume(int series, int item) { return null; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 384 */   public double getVolumeValue(int series, int item) { return NaND; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeSeries(int index) {
/* 396 */     OHLCSeries series = getSeries(index);
/* 397 */     if (series != null) {
/* 398 */       removeSeries(series);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeSeries(OHLCSeries series) {
/* 414 */     ParamChecks.nullNotPermitted(series, "series");
/* 415 */     boolean removed = this.data.remove(series);
/* 416 */     if (removed) {
/* 417 */       series.removeChangeListener(this);
/* 418 */       fireDatasetChanged();
/*     */     } 
/* 420 */     return removed;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeAllSeries() {
/* 431 */     if (this.data.isEmpty()) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 437 */     for (int i = 0; i < this.data.size(); i++) {
/* 438 */       OHLCSeries series = (OHLCSeries)this.data.get(i);
/* 439 */       series.removeChangeListener(this);
/*     */     } 
/*     */ 
/*     */     
/* 443 */     this.data.clear();
/* 444 */     fireDatasetChanged();
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
/*     */   public boolean equals(Object obj) {
/* 457 */     if (obj == this) {
/* 458 */       return true;
/*     */     }
/* 460 */     if (!(obj instanceof OHLCSeriesCollection)) {
/* 461 */       return false;
/*     */     }
/* 463 */     OHLCSeriesCollection that = (OHLCSeriesCollection)obj;
/* 464 */     if (!this.xPosition.equals(that.xPosition)) {
/* 465 */       return false;
/*     */     }
/* 467 */     return ObjectUtilities.equal(this.data, that.data);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 477 */     int result = 137;
/* 478 */     result = HashUtilities.hashCode(result, this.xPosition);
/* 479 */     for (int i = 0; i < this.data.size(); i++) {
/* 480 */       result = HashUtilities.hashCode(result, this.data.get(i));
/*     */     }
/* 482 */     return result;
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
/* 495 */     OHLCSeriesCollection clone = (OHLCSeriesCollection)super.clone();
/* 496 */     clone.data = (List)ObjectUtilities.deepClone(this.data);
/* 497 */     return clone;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/time/ohlc/OHLCSeriesCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */