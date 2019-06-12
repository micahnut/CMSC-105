/*     */ package org.jfree.data.time;
/*     */ 
/*     */ import java.util.Calendar;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.TimeZone;
/*     */ import org.jfree.chart.util.ParamChecks;
/*     */ import org.jfree.data.DefaultKeyedValues2D;
/*     */ import org.jfree.data.DomainInfo;
/*     */ import org.jfree.data.Range;
/*     */ import org.jfree.data.general.DatasetChangeEvent;
/*     */ import org.jfree.data.xy.AbstractIntervalXYDataset;
/*     */ import org.jfree.data.xy.IntervalXYDataset;
/*     */ import org.jfree.data.xy.TableXYDataset;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TimeTableXYDataset
/*     */   extends AbstractIntervalXYDataset
/*     */   implements Cloneable, PublicCloneable, IntervalXYDataset, DomainInfo, TableXYDataset
/*     */ {
/*     */   private DefaultKeyedValues2D values;
/*     */   private boolean domainIsPointsInTime;
/*     */   private TimePeriodAnchor xPosition;
/*     */   private Calendar workingCalendar;
/*     */   
/* 120 */   public TimeTableXYDataset() { this(TimeZone.getDefault(), Locale.getDefault()); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 130 */   public TimeTableXYDataset(TimeZone zone) { this(zone, Locale.getDefault()); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TimeTableXYDataset(TimeZone zone, Locale locale) {
/* 140 */     ParamChecks.nullNotPermitted(zone, "zone");
/* 141 */     ParamChecks.nullNotPermitted(locale, "locale");
/* 142 */     this.values = new DefaultKeyedValues2D(true);
/* 143 */     this.workingCalendar = Calendar.getInstance(zone, locale);
/* 144 */     this.xPosition = TimePeriodAnchor.START;
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
/* 161 */   public boolean getDomainIsPointsInTime() { return this.domainIsPointsInTime; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDomainIsPointsInTime(boolean flag) {
/* 174 */     this.domainIsPointsInTime = flag;
/* 175 */     notifyListeners(new DatasetChangeEvent(this, this));
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
/* 187 */   public TimePeriodAnchor getXPosition() { return this.xPosition; }
/*     */ 
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
/* 199 */     ParamChecks.nullNotPermitted(anchor, "anchor");
/* 200 */     this.xPosition = anchor;
/* 201 */     notifyListeners(new DatasetChangeEvent(this, this));
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
/* 215 */   public void add(TimePeriod period, double y, Comparable seriesName) { add(period, new Double(y), seriesName, true); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(TimePeriod period, Number y, Comparable seriesName, boolean notify) {
/* 236 */     if (period instanceof RegularTimePeriod) {
/* 237 */       RegularTimePeriod p = (RegularTimePeriod)period;
/* 238 */       p.peg(this.workingCalendar);
/*     */     } 
/* 240 */     this.values.addValue(y, period, seriesName);
/* 241 */     if (notify) {
/* 242 */       fireDatasetChanged();
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
/* 257 */   public void remove(TimePeriod period, Comparable seriesName) { remove(period, seriesName, true); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove(TimePeriod period, Comparable seriesName, boolean notify) {
/* 274 */     this.values.removeValue(period, seriesName);
/* 275 */     if (notify) {
/* 276 */       fireDatasetChanged();
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
/* 287 */     if (this.values.getRowCount() > 0) {
/* 288 */       this.values.clear();
/* 289 */       fireDatasetChanged();
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
/* 302 */   public TimePeriod getTimePeriod(int item) { return (TimePeriod)this.values.getRowKey(item); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 312 */   public int getItemCount() { return this.values.getRowCount(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 326 */   public int getItemCount(int series) { return getItemCount(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 336 */   public int getSeriesCount() { return this.values.getColumnCount(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 348 */   public Comparable getSeriesKey(int series) { return this.values.getColumnKey(series); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 363 */   public Number getX(int series, int item) { return new Double(getXValue(series, item)); }
/*     */ 
/*     */ 
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
/* 376 */     TimePeriod period = (TimePeriod)this.values.getRowKey(item);
/* 377 */     return getXValue(period);
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
/* 392 */   public Number getStartX(int series, int item) { return new Double(getStartXValue(series, item)); }
/*     */ 
/*     */ 
/*     */ 
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
/* 406 */     TimePeriod period = (TimePeriod)this.values.getRowKey(item);
/* 407 */     return period.getStart().getTime();
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
/* 422 */   public Number getEndX(int series, int item) { return new Double(getEndXValue(series, item)); }
/*     */ 
/*     */ 
/*     */ 
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
/* 436 */     TimePeriod period = (TimePeriod)this.values.getRowKey(item);
/* 437 */     return period.getEnd().getTime();
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
/* 450 */   public Number getY(int series, int item) { return this.values.getValue(item, series); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 463 */   public Number getStartY(int series, int item) { return getY(series, item); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 476 */   public Number getEndY(int series, int item) { return getY(series, item); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private long getXValue(TimePeriod period) {
/* 487 */     long result = 0L;
/* 488 */     if (this.xPosition == TimePeriodAnchor.START) {
/* 489 */       result = period.getStart().getTime();
/*     */     }
/* 491 */     else if (this.xPosition == TimePeriodAnchor.MIDDLE) {
/* 492 */       long t0 = period.getStart().getTime();
/* 493 */       long t1 = period.getEnd().getTime();
/* 494 */       result = t0 + (t1 - t0) / 2L;
/*     */     }
/* 496 */     else if (this.xPosition == TimePeriodAnchor.END) {
/* 497 */       result = period.getEnd().getTime();
/*     */     } 
/* 499 */     return result;
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
/*     */   public double getDomainLowerBound(boolean includeInterval) {
/* 512 */     double result = NaND;
/* 513 */     Range r = getDomainBounds(includeInterval);
/* 514 */     if (r != null) {
/* 515 */       result = r.getLowerBound();
/*     */     }
/* 517 */     return result;
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
/*     */   public double getDomainUpperBound(boolean includeInterval) {
/* 530 */     double result = NaND;
/* 531 */     Range r = getDomainBounds(includeInterval);
/* 532 */     if (r != null) {
/* 533 */       result = r.getUpperBound();
/*     */     }
/* 535 */     return result;
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
/*     */   public Range getDomainBounds(boolean includeInterval) {
/* 548 */     List keys = this.values.getRowKeys();
/* 549 */     if (keys.isEmpty()) {
/* 550 */       return null;
/*     */     }
/*     */     
/* 553 */     TimePeriod first = (TimePeriod)keys.get(0);
/* 554 */     TimePeriod last = (TimePeriod)keys.get(keys.size() - 1);
/*     */     
/* 556 */     if (!includeInterval || this.domainIsPointsInTime) {
/* 557 */       return new Range(getXValue(first), getXValue(last));
/*     */     }
/*     */     
/* 560 */     return new Range(first.getStart().getTime(), last
/* 561 */         .getEnd().getTime());
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
/* 574 */     if (obj == this) {
/* 575 */       return true;
/*     */     }
/* 577 */     if (!(obj instanceof TimeTableXYDataset)) {
/* 578 */       return false;
/*     */     }
/* 580 */     TimeTableXYDataset that = (TimeTableXYDataset)obj;
/* 581 */     if (this.domainIsPointsInTime != that.domainIsPointsInTime) {
/* 582 */       return false;
/*     */     }
/* 584 */     if (this.xPosition != that.xPosition) {
/* 585 */       return false;
/*     */     }
/* 587 */     if (!this.workingCalendar.getTimeZone().equals(that.workingCalendar
/* 588 */         .getTimeZone()))
/*     */     {
/* 590 */       return false;
/*     */     }
/* 592 */     if (!this.values.equals(that.values)) {
/* 593 */       return false;
/*     */     }
/* 595 */     return true;
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
/*     */   public Object clone() throws CloneNotSupportedException {
/* 607 */     TimeTableXYDataset clone = (TimeTableXYDataset)super.clone();
/* 608 */     clone.values = (DefaultKeyedValues2D)this.values.clone();
/* 609 */     clone.workingCalendar = (Calendar)this.workingCalendar.clone();
/* 610 */     return clone;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/time/TimeTableXYDataset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */