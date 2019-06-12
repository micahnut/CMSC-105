/*     */ package org.jfree.data.time;
/*     */ 
/*     */ import java.beans.PropertyChangeEvent;
/*     */ import java.beans.PropertyVetoException;
/*     */ import java.beans.VetoableChangeListener;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.TimeZone;
/*     */ import org.jfree.chart.util.ParamChecks;
/*     */ import org.jfree.data.DomainInfo;
/*     */ import org.jfree.data.DomainOrder;
/*     */ import org.jfree.data.Range;
/*     */ import org.jfree.data.general.DatasetChangeEvent;
/*     */ import org.jfree.data.general.Series;
/*     */ import org.jfree.data.xy.AbstractIntervalXYDataset;
/*     */ import org.jfree.data.xy.IntervalXYDataset;
/*     */ import org.jfree.data.xy.XYDataset;
/*     */ import org.jfree.data.xy.XYDomainInfo;
/*     */ import org.jfree.data.xy.XYRangeInfo;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TimeSeriesCollection
/*     */   extends AbstractIntervalXYDataset
/*     */   implements XYDataset, IntervalXYDataset, DomainInfo, XYDomainInfo, XYRangeInfo, VetoableChangeListener, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 834149929022371137L;
/*     */   private List data;
/*     */   private Calendar workingCalendar;
/*     */   private TimePeriodAnchor xPosition;
/*     */   private boolean domainIsPointsInTime;
/*     */   
/* 154 */   public TimeSeriesCollection() { this(null, TimeZone.getDefault()); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 165 */   public TimeSeriesCollection(TimeZone zone) { this(null, zone); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 175 */   public TimeSeriesCollection(TimeSeries series) { this(series, TimeZone.getDefault()); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TimeSeriesCollection(TimeSeries series, TimeZone zone) {
/* 189 */     if (zone == null) {
/* 190 */       zone = TimeZone.getDefault();
/*     */     }
/* 192 */     this.workingCalendar = Calendar.getInstance(zone);
/* 193 */     this.data = new ArrayList();
/* 194 */     if (series != null) {
/* 195 */       this.data.add(series);
/* 196 */       series.addChangeListener(this);
/*     */     } 
/* 198 */     this.xPosition = TimePeriodAnchor.START;
/* 199 */     this.domainIsPointsInTime = true;
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
/* 215 */   public boolean getDomainIsPointsInTime() { return this.domainIsPointsInTime; }
/*     */ 
/*     */ 
/*     */ 
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
/* 229 */     this.domainIsPointsInTime = flag;
/* 230 */     notifyListeners(new DatasetChangeEvent(this, this));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 240 */   public DomainOrder getDomainOrder() { return DomainOrder.ASCENDING; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 251 */   public TimePeriodAnchor getXPosition() { return this.xPosition; }
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
/* 262 */     ParamChecks.nullNotPermitted(anchor, "anchor");
/* 263 */     this.xPosition = anchor;
/* 264 */     notifyListeners(new DatasetChangeEvent(this, this));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 273 */   public List getSeries() { return Collections.unmodifiableList(this.data); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 283 */   public int getSeriesCount() { return this.data.size(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int indexOf(TimeSeries series) {
/* 297 */     ParamChecks.nullNotPermitted(series, "series");
/* 298 */     return this.data.indexOf(series);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TimeSeries getSeries(int series) {
/* 309 */     if (series < 0 || series >= getSeriesCount()) {
/* 310 */       throw new IllegalArgumentException("The 'series' argument is out of bounds (" + series + ").");
/*     */     }
/*     */     
/* 313 */     return (TimeSeries)this.data.get(series);
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
/*     */   public TimeSeries getSeries(Comparable key) {
/* 325 */     TimeSeries result = null;
/* 326 */     Iterator iterator = this.data.iterator();
/* 327 */     while (iterator.hasNext()) {
/* 328 */       TimeSeries series = (TimeSeries)iterator.next();
/* 329 */       Comparable k = series.getKey();
/* 330 */       if (k != null && k.equals(key)) {
/* 331 */         result = series;
/*     */       }
/*     */     } 
/* 334 */     return result;
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
/* 348 */   public Comparable getSeriesKey(int series) { return getSeries(series).getKey(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSeriesIndex(Comparable key) {
/* 362 */     ParamChecks.nullNotPermitted(key, "key");
/* 363 */     int seriesCount = getSeriesCount();
/* 364 */     for (int i = 0; i < seriesCount; i++) {
/* 365 */       TimeSeries series = (TimeSeries)this.data.get(i);
/* 366 */       if (key.equals(series.getKey())) {
/* 367 */         return i;
/*     */       }
/*     */     } 
/* 370 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addSeries(TimeSeries series) {
/* 380 */     ParamChecks.nullNotPermitted(series, "series");
/* 381 */     this.data.add(series);
/* 382 */     series.addChangeListener(this);
/* 383 */     series.addVetoableChangeListener(this);
/* 384 */     fireDatasetChanged();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeSeries(TimeSeries series) {
/* 394 */     ParamChecks.nullNotPermitted(series, "series");
/* 395 */     this.data.remove(series);
/* 396 */     series.removeChangeListener(this);
/* 397 */     series.removeVetoableChangeListener(this);
/* 398 */     fireDatasetChanged();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeSeries(int index) {
/* 407 */     TimeSeries series = getSeries(index);
/* 408 */     if (series != null) {
/* 409 */       removeSeries(series);
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
/*     */   public void removeAllSeries() {
/* 421 */     for (int i = 0; i < this.data.size(); i++) {
/* 422 */       TimeSeries series = (TimeSeries)this.data.get(i);
/* 423 */       series.removeChangeListener(this);
/* 424 */       series.removeVetoableChangeListener(this);
/*     */     } 
/*     */ 
/*     */     
/* 428 */     this.data.clear();
/* 429 */     fireDatasetChanged();
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
/* 443 */   public int getItemCount(int series) { return getSeries(series).getItemCount(); }
/*     */ 
/*     */ 
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
/* 456 */     TimeSeries s = (TimeSeries)this.data.get(series);
/* 457 */     RegularTimePeriod period = s.getTimePeriod(item);
/* 458 */     return getX(period);
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
/*     */   public Number getX(int series, int item) {
/* 471 */     TimeSeries ts = (TimeSeries)this.data.get(series);
/* 472 */     RegularTimePeriod period = ts.getTimePeriod(item);
/* 473 */     return new Long(getX(period));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected long getX(RegularTimePeriod period) {
/* 484 */     long result = 0L;
/* 485 */     if (this.xPosition == TimePeriodAnchor.START) {
/* 486 */       result = period.getFirstMillisecond(this.workingCalendar);
/*     */     }
/* 488 */     else if (this.xPosition == TimePeriodAnchor.MIDDLE) {
/* 489 */       result = period.getMiddleMillisecond(this.workingCalendar);
/*     */     }
/* 491 */     else if (this.xPosition == TimePeriodAnchor.END) {
/* 492 */       result = period.getLastMillisecond(this.workingCalendar);
/*     */     } 
/* 494 */     return result;
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
/* 507 */     TimeSeries ts = (TimeSeries)this.data.get(series);
/* 508 */     return new Long(ts.getTimePeriod(item).getFirstMillisecond(this.workingCalendar));
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
/*     */   public Number getEndX(int series, int item) {
/* 522 */     TimeSeries ts = (TimeSeries)this.data.get(series);
/* 523 */     return new Long(ts.getTimePeriod(item).getLastMillisecond(this.workingCalendar));
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
/*     */   public Number getY(int series, int item) {
/* 537 */     TimeSeries ts = (TimeSeries)this.data.get(series);
/* 538 */     return ts.getValue(item);
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
/* 551 */   public Number getStartY(int series, int item) { return getY(series, item); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 564 */   public Number getEndY(int series, int item) { return getY(series, item); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int[] getSurroundingItems(int series, long milliseconds) {
/* 579 */     int[] result = { -1, -1 };
/* 580 */     TimeSeries timeSeries = getSeries(series);
/* 581 */     for (int i = 0; i < timeSeries.getItemCount(); i++) {
/* 582 */       Number x = getX(series, i);
/* 583 */       long m = x.longValue();
/* 584 */       if (m <= milliseconds) {
/* 585 */         result[0] = i;
/*     */       }
/* 587 */       if (m >= milliseconds) {
/* 588 */         result[1] = i;
/*     */         break;
/*     */       } 
/*     */     } 
/* 592 */     return result;
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
/* 605 */     double result = NaND;
/* 606 */     Range r = getDomainBounds(includeInterval);
/* 607 */     if (r != null) {
/* 608 */       result = r.getLowerBound();
/*     */     }
/* 610 */     return result;
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
/* 623 */     double result = NaND;
/* 624 */     Range r = getDomainBounds(includeInterval);
/* 625 */     if (r != null) {
/* 626 */       result = r.getUpperBound();
/*     */     }
/* 628 */     return result;
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
/* 641 */     Range result = null;
/* 642 */     Iterator iterator = this.data.iterator();
/* 643 */     while (iterator.hasNext()) {
/* 644 */       TimeSeries series = (TimeSeries)iterator.next();
/* 645 */       int count = series.getItemCount();
/* 646 */       if (count > 0) {
/* 647 */         Range temp; RegularTimePeriod start = series.getTimePeriod(0);
/* 648 */         RegularTimePeriod end = series.getTimePeriod(count - 1);
/*     */         
/* 650 */         if (!includeInterval) {
/* 651 */           temp = new Range(getX(start), getX(end));
/*     */         
/*     */         }
/*     */         else {
/*     */           
/* 656 */           temp = new Range(start.getFirstMillisecond(this.workingCalendar), end.getLastMillisecond(this.workingCalendar));
/*     */         } 
/* 658 */         result = Range.combine(result, temp);
/*     */       } 
/*     */     } 
/* 661 */     return result;
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
/*     */   public Range getDomainBounds(List visibleSeriesKeys, boolean includeInterval) {
/* 677 */     Range result = null;
/* 678 */     Iterator iterator = visibleSeriesKeys.iterator();
/* 679 */     while (iterator.hasNext()) {
/* 680 */       Comparable seriesKey = (Comparable)iterator.next();
/* 681 */       TimeSeries series = getSeries(seriesKey);
/* 682 */       int count = series.getItemCount();
/* 683 */       if (count > 0) {
/* 684 */         Range temp; RegularTimePeriod start = series.getTimePeriod(0);
/* 685 */         RegularTimePeriod end = series.getTimePeriod(count - 1);
/*     */         
/* 687 */         if (!includeInterval) {
/* 688 */           temp = new Range(getX(start), getX(end));
/*     */         
/*     */         }
/*     */         else {
/*     */           
/* 693 */           temp = new Range(start.getFirstMillisecond(this.workingCalendar), end.getLastMillisecond(this.workingCalendar));
/*     */         } 
/* 695 */         result = Range.combine(result, temp);
/*     */       } 
/*     */     } 
/* 698 */     return result;
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
/*     */   public Range getRangeBounds(boolean includeInterval) {
/* 711 */     Range result = null;
/* 712 */     Iterator iterator = this.data.iterator();
/* 713 */     while (iterator.hasNext()) {
/* 714 */       TimeSeries series = (TimeSeries)iterator.next();
/* 715 */       Range r = new Range(series.getMinY(), series.getMaxY());
/* 716 */       result = Range.combineIgnoringNaN(result, r);
/*     */     } 
/* 718 */     return result;
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
/*     */   public Range getRangeBounds(List visibleSeriesKeys, Range xRange, boolean includeInterval) {
/* 735 */     Range result = null;
/* 736 */     Iterator iterator = visibleSeriesKeys.iterator();
/* 737 */     while (iterator.hasNext()) {
/* 738 */       Comparable seriesKey = (Comparable)iterator.next();
/* 739 */       TimeSeries series = getSeries(seriesKey);
/* 740 */       Range r = series.findValueRange(xRange, this.xPosition, this.workingCalendar
/* 741 */           .getTimeZone());
/* 742 */       result = Range.combineIgnoringNaN(result, r);
/*     */     } 
/* 744 */     return result;
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
/*     */   public void vetoableChange(PropertyChangeEvent e) throws PropertyVetoException {
/* 760 */     if (!"Key".equals(e.getPropertyName())) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 766 */     Series s = (Series)e.getSource();
/* 767 */     if (getSeriesIndex(s.getKey()) == -1) {
/* 768 */       throw new IllegalStateException("Receiving events from a series that does not belong to this collection.");
/*     */     }
/*     */ 
/*     */     
/* 772 */     Comparable key = (Comparable)e.getNewValue();
/* 773 */     if (getSeriesIndex(key) >= 0) {
/* 774 */       throw new PropertyVetoException("Duplicate key2", e);
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
/* 787 */     if (obj == this) {
/* 788 */       return true;
/*     */     }
/* 790 */     if (!(obj instanceof TimeSeriesCollection)) {
/* 791 */       return false;
/*     */     }
/* 793 */     TimeSeriesCollection that = (TimeSeriesCollection)obj;
/* 794 */     if (this.xPosition != that.xPosition) {
/* 795 */       return false;
/*     */     }
/* 797 */     if (this.domainIsPointsInTime != that.domainIsPointsInTime) {
/* 798 */       return false;
/*     */     }
/* 800 */     if (!ObjectUtilities.equal(this.data, that.data)) {
/* 801 */       return false;
/*     */     }
/* 803 */     return true;
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
/* 814 */     result = this.data.hashCode();
/*     */     
/* 816 */     result = 29 * result + ((this.workingCalendar != null) ? this.workingCalendar.hashCode() : 0);
/*     */     
/* 818 */     result = 29 * result + ((this.xPosition != null) ? this.xPosition.hashCode() : 0);
/* 819 */     return 29 * result + (this.domainIsPointsInTime ? 1 : 0);
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
/* 833 */     TimeSeriesCollection clone = (TimeSeriesCollection)super.clone();
/* 834 */     clone.data = (List)ObjectUtilities.deepClone(this.data);
/* 835 */     clone.workingCalendar = (Calendar)this.workingCalendar.clone();
/* 836 */     return clone;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/time/TimeSeriesCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */