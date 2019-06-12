/*     */ package org.jfree.data.xy;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.jfree.chart.util.ParamChecks;
/*     */ import org.jfree.data.DomainInfo;
/*     */ import org.jfree.data.Range;
/*     */ import org.jfree.data.general.DatasetUtilities;
/*     */ import org.jfree.data.general.SeriesChangeEvent;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DefaultTableXYDataset
/*     */   extends AbstractIntervalXYDataset
/*     */   implements TableXYDataset, IntervalXYDataset, DomainInfo, PublicCloneable
/*     */ {
/*  92 */   private List data = null;
/*     */ 
/*     */   
/*  95 */   private HashSet xPoints = null;
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean propagateEvents = true;
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean autoPrune = false;
/*     */ 
/*     */   
/*     */   private IntervalXYDelegate intervalDelegate;
/*     */ 
/*     */ 
/*     */   
/* 110 */   public DefaultTableXYDataset() { this(false); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DefaultTableXYDataset(boolean autoPrune) {
/* 121 */     this.autoPrune = autoPrune;
/* 122 */     this.data = new ArrayList();
/* 123 */     this.xPoints = new HashSet();
/* 124 */     this.intervalDelegate = new IntervalXYDelegate(this, false);
/* 125 */     addChangeListener(this.intervalDelegate);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 135 */   public boolean isAutoPrune() { return this.autoPrune; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addSeries(XYSeries series) {
/* 146 */     ParamChecks.nullNotPermitted(series, "series");
/* 147 */     if (series.getAllowDuplicateXValues()) {
/* 148 */       throw new IllegalArgumentException("Cannot accept XYSeries that allow duplicate values. Use XYSeries(seriesName, <sort>, false) constructor.");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 153 */     updateXPoints(series);
/* 154 */     this.data.add(series);
/* 155 */     series.addChangeListener(this);
/* 156 */     fireDatasetChanged();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void updateXPoints(XYSeries series) {
/* 166 */     ParamChecks.nullNotPermitted(series, "series");
/* 167 */     HashSet seriesXPoints = new HashSet();
/* 168 */     boolean savedState = this.propagateEvents;
/* 169 */     this.propagateEvents = false;
/* 170 */     for (itemNo = 0; itemNo < series.getItemCount(); itemNo++) {
/* 171 */       Number xValue = series.getX(itemNo);
/* 172 */       seriesXPoints.add(xValue);
/* 173 */       if (!this.xPoints.contains(xValue)) {
/* 174 */         this.xPoints.add(xValue);
/* 175 */         int seriesCount = this.data.size();
/* 176 */         for (int seriesNo = 0; seriesNo < seriesCount; seriesNo++) {
/* 177 */           XYSeries dataSeries = (XYSeries)this.data.get(seriesNo);
/* 178 */           if (!dataSeries.equals(series)) {
/* 179 */             dataSeries.add(xValue, null);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 184 */     Iterator iterator = this.xPoints.iterator();
/* 185 */     while (iterator.hasNext()) {
/* 186 */       Number xPoint = (Number)iterator.next();
/* 187 */       if (!seriesXPoints.contains(xPoint)) {
/* 188 */         series.add(xPoint, null);
/*     */       }
/*     */     } 
/* 191 */     this.propagateEvents = savedState;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateXPoints() {
/* 198 */     this.propagateEvents = false;
/* 199 */     for (int s = 0; s < this.data.size(); s++) {
/* 200 */       updateXPoints((XYSeries)this.data.get(s));
/*     */     }
/* 202 */     if (this.autoPrune) {
/* 203 */       prune();
/*     */     }
/* 205 */     this.propagateEvents = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 215 */   public int getSeriesCount() { return this.data.size(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getItemCount() {
/* 225 */     if (this.xPoints == null) {
/* 226 */       return 0;
/*     */     }
/*     */     
/* 229 */     return this.xPoints.size();
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
/*     */   public XYSeries getSeries(int series) {
/* 241 */     if (series < 0 || series >= getSeriesCount()) {
/* 242 */       throw new IllegalArgumentException("Index outside valid range.");
/*     */     }
/* 244 */     return (XYSeries)this.data.get(series);
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
/* 257 */   public Comparable getSeriesKey(int series) { return getSeries(series).getKey(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 270 */   public int getItemCount(int series) { return getSeries(series).getItemCount(); }
/*     */ 
/*     */ 
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
/* 283 */     XYSeries s = (XYSeries)this.data.get(series);
/* 284 */     return s.getX(item);
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
/* 298 */   public Number getStartX(int series, int item) { return this.intervalDelegate.getStartX(series, item); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 311 */   public Number getEndX(int series, int item) { return this.intervalDelegate.getEndX(series, item); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Number getY(int series, int index) {
/* 325 */     XYSeries s = (XYSeries)this.data.get(series);
/* 326 */     return s.getY(index);
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
/* 339 */   public Number getStartY(int series, int item) { return getY(series, item); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 352 */   public Number getEndY(int series, int item) { return getY(series, item); }
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
/* 363 */     for (int i = 0; i < this.data.size(); i++) {
/* 364 */       XYSeries series = (XYSeries)this.data.get(i);
/* 365 */       series.removeChangeListener(this);
/*     */     } 
/*     */ 
/*     */     
/* 369 */     this.data.clear();
/* 370 */     this.xPoints.clear();
/* 371 */     fireDatasetChanged();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeSeries(XYSeries series) {
/* 381 */     ParamChecks.nullNotPermitted(series, "series");
/* 382 */     if (this.data.contains(series)) {
/* 383 */       series.removeChangeListener(this);
/* 384 */       this.data.remove(series);
/* 385 */       if (this.data.isEmpty()) {
/* 386 */         this.xPoints.clear();
/*     */       }
/* 388 */       fireDatasetChanged();
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
/*     */   public void removeSeries(int series) {
/* 401 */     if (series < 0 || series > getSeriesCount()) {
/* 402 */       throw new IllegalArgumentException("Index outside valid range.");
/*     */     }
/*     */ 
/*     */     
/* 406 */     XYSeries s = (XYSeries)this.data.get(series);
/* 407 */     s.removeChangeListener(this);
/* 408 */     this.data.remove(series);
/* 409 */     if (this.data.isEmpty()) {
/* 410 */       this.xPoints.clear();
/*     */     }
/* 412 */     else if (this.autoPrune) {
/* 413 */       prune();
/*     */     } 
/* 415 */     fireDatasetChanged();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeAllValuesForX(Number x) {
/* 425 */     ParamChecks.nullNotPermitted(x, "x");
/* 426 */     boolean savedState = this.propagateEvents;
/* 427 */     this.propagateEvents = false;
/* 428 */     for (int s = 0; s < this.data.size(); s++) {
/* 429 */       XYSeries series = (XYSeries)this.data.get(s);
/* 430 */       series.remove(x);
/*     */     } 
/* 432 */     this.propagateEvents = savedState;
/* 433 */     this.xPoints.remove(x);
/* 434 */     fireDatasetChanged();
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
/*     */   protected boolean canPrune(Number x) {
/* 446 */     for (int s = 0; s < this.data.size(); s++) {
/* 447 */       XYSeries series = (XYSeries)this.data.get(s);
/* 448 */       if (series.getY(series.indexOf(x)) != null) {
/* 449 */         return false;
/*     */       }
/*     */     } 
/* 452 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void prune() {
/* 459 */     HashSet hs = (HashSet)this.xPoints.clone();
/* 460 */     Iterator iterator = hs.iterator();
/* 461 */     while (iterator.hasNext()) {
/* 462 */       Number x = (Number)iterator.next();
/* 463 */       if (canPrune(x)) {
/* 464 */         removeAllValuesForX(x);
/*     */       }
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
/*     */   public void seriesChanged(SeriesChangeEvent event) {
/* 478 */     if (this.propagateEvents) {
/* 479 */       updateXPoints();
/* 480 */       fireDatasetChanged();
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
/*     */   public boolean equals(Object obj) {
/* 493 */     if (obj == this) {
/* 494 */       return true;
/*     */     }
/* 496 */     if (!(obj instanceof DefaultTableXYDataset)) {
/* 497 */       return false;
/*     */     }
/* 499 */     DefaultTableXYDataset that = (DefaultTableXYDataset)obj;
/* 500 */     if (this.autoPrune != that.autoPrune) {
/* 501 */       return false;
/*     */     }
/* 503 */     if (this.propagateEvents != that.propagateEvents) {
/* 504 */       return false;
/*     */     }
/* 506 */     if (!this.intervalDelegate.equals(that.intervalDelegate)) {
/* 507 */       return false;
/*     */     }
/* 509 */     if (!ObjectUtilities.equal(this.data, that.data)) {
/* 510 */       return false;
/*     */     }
/* 512 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 523 */     result = (this.data != null) ? this.data.hashCode() : 0;
/*     */     
/* 525 */     result = 29 * result + ((this.xPoints != null) ? this.xPoints.hashCode() : 0);
/* 526 */     result = 29 * result + (this.propagateEvents ? 1 : 0);
/* 527 */     return 29 * result + (this.autoPrune ? 1 : 0);
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
/*     */   public Object clone() throws CloneNotSupportedException {
/* 541 */     DefaultTableXYDataset clone = (DefaultTableXYDataset)super.clone();
/* 542 */     int seriesCount = this.data.size();
/* 543 */     clone.data = new ArrayList(seriesCount);
/* 544 */     for (int i = 0; i < seriesCount; i++) {
/* 545 */       XYSeries series = (XYSeries)this.data.get(i);
/* 546 */       clone.data.add(series.clone());
/*     */     } 
/*     */     
/* 549 */     clone.intervalDelegate = new IntervalXYDelegate(clone);
/*     */     
/* 551 */     clone.intervalDelegate.setFixedIntervalWidth(getIntervalWidth());
/* 552 */     clone.intervalDelegate.setAutoWidth(isAutoWidth());
/* 553 */     clone.intervalDelegate.setIntervalPositionFactor(
/* 554 */         getIntervalPositionFactor());
/* 555 */     clone.updateXPoints();
/* 556 */     return clone;
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
/* 569 */   public double getDomainLowerBound(boolean includeInterval) { return this.intervalDelegate.getDomainLowerBound(includeInterval); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 582 */   public double getDomainUpperBound(boolean includeInterval) { return this.intervalDelegate.getDomainUpperBound(includeInterval); }
/*     */ 
/*     */ 
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
/* 595 */     if (includeInterval) {
/* 596 */       return this.intervalDelegate.getDomainBounds(includeInterval);
/*     */     }
/*     */     
/* 599 */     return DatasetUtilities.iterateDomainBounds(this, includeInterval);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 609 */   public double getIntervalPositionFactor() { return this.intervalDelegate.getIntervalPositionFactor(); }
/*     */ 
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
/* 621 */     this.intervalDelegate.setIntervalPositionFactor(d);
/* 622 */     fireDatasetChanged();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 631 */   public double getIntervalWidth() { return this.intervalDelegate.getIntervalWidth(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIntervalWidth(double d) {
/* 641 */     this.intervalDelegate.setFixedIntervalWidth(d);
/* 642 */     fireDatasetChanged();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 652 */   public boolean isAutoWidth() { return this.intervalDelegate.isAutoWidth(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAutoWidth(boolean b) {
/* 662 */     this.intervalDelegate.setAutoWidth(b);
/* 663 */     fireDatasetChanged();
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/xy/DefaultTableXYDataset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */