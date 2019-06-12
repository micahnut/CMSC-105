/*     */ package org.jfree.data.time;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.jfree.chart.util.ParamChecks;
/*     */ import org.jfree.data.DomainInfo;
/*     */ import org.jfree.data.Range;
/*     */ import org.jfree.data.xy.AbstractIntervalXYDataset;
/*     */ import org.jfree.data.xy.IntervalXYDataset;
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
/*     */ public class TimePeriodValuesCollection
/*     */   extends AbstractIntervalXYDataset
/*     */   implements IntervalXYDataset, DomainInfo, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -3077934065236454199L;
/*     */   private List data;
/*     */   private TimePeriodAnchor xPosition;
/*     */   private boolean domainIsPointsInTime;
/*     */   
/*  98 */   public TimePeriodValuesCollection() { this((TimePeriodValues)null); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TimePeriodValuesCollection(TimePeriodValues series) {
/* 108 */     this.data = new ArrayList();
/* 109 */     this.xPosition = TimePeriodAnchor.MIDDLE;
/* 110 */     this.domainIsPointsInTime = false;
/* 111 */     if (series != null) {
/* 112 */       this.data.add(series);
/* 113 */       series.addChangeListener(this);
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
/* 125 */   public TimePeriodAnchor getXPosition() { return this.xPosition; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setXPosition(TimePeriodAnchor position) {
/* 136 */     ParamChecks.nullNotPermitted(position, "position");
/* 137 */     this.xPosition = position;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 147 */   public int getSeriesCount() { return this.data.size(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TimePeriodValues getSeries(int series) {
/* 158 */     if (series < 0 || series >= getSeriesCount()) {
/* 159 */       throw new IllegalArgumentException("Index 'series' out of range.");
/*     */     }
/* 161 */     return (TimePeriodValues)this.data.get(series);
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
/* 174 */   public Comparable getSeriesKey(int series) { return getSeries(series).getKey(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addSeries(TimePeriodValues series) {
/* 185 */     ParamChecks.nullNotPermitted(series, "series");
/* 186 */     this.data.add(series);
/* 187 */     series.addChangeListener(this);
/* 188 */     fireDatasetChanged();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeSeries(TimePeriodValues series) {
/* 197 */     ParamChecks.nullNotPermitted(series, "series");
/* 198 */     this.data.remove(series);
/* 199 */     series.removeChangeListener(this);
/* 200 */     fireDatasetChanged();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeSeries(int index) {
/* 210 */     TimePeriodValues series = getSeries(index);
/* 211 */     if (series != null) {
/* 212 */       removeSeries(series);
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
/* 227 */   public int getItemCount(int series) { return getSeries(series).getItemCount(); }
/*     */ 
/*     */ 
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
/* 240 */     TimePeriodValues ts = (TimePeriodValues)this.data.get(series);
/* 241 */     TimePeriodValue dp = ts.getDataItem(item);
/* 242 */     TimePeriod period = dp.getPeriod();
/* 243 */     return new Long(getX(period));
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
/*     */   private long getX(TimePeriod period) {
/* 255 */     if (this.xPosition == TimePeriodAnchor.START) {
/* 256 */       return period.getStart().getTime();
/*     */     }
/* 258 */     if (this.xPosition == TimePeriodAnchor.MIDDLE)
/*     */     {
/* 260 */       return period.getStart().getTime() / 2L + period.getEnd().getTime() / 2L;
/*     */     }
/* 262 */     if (this.xPosition == TimePeriodAnchor.END) {
/* 263 */       return period.getEnd().getTime();
/*     */     }
/*     */     
/* 266 */     throw new IllegalStateException("TimePeriodAnchor unknown.");
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
/*     */   public Number getStartX(int series, int item) {
/* 281 */     TimePeriodValues ts = (TimePeriodValues)this.data.get(series);
/* 282 */     TimePeriodValue dp = ts.getDataItem(item);
/* 283 */     return new Long(dp.getPeriod().getStart().getTime());
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
/* 296 */     TimePeriodValues ts = (TimePeriodValues)this.data.get(series);
/* 297 */     TimePeriodValue dp = ts.getDataItem(item);
/* 298 */     return new Long(dp.getPeriod().getEnd().getTime());
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
/* 311 */     TimePeriodValues ts = (TimePeriodValues)this.data.get(series);
/* 312 */     TimePeriodValue dp = ts.getDataItem(item);
/* 313 */     return dp.getValue();
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
/* 326 */   public Number getStartY(int series, int item) { return getY(series, item); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 339 */   public Number getEndY(int series, int item) { return getY(series, item); }
/*     */ 
/*     */ 
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
/* 352 */     double result = NaND;
/* 353 */     Range r = getDomainBounds(includeInterval);
/* 354 */     if (r != null) {
/* 355 */       result = r.getLowerBound();
/*     */     }
/* 357 */     return result;
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
/* 370 */     double result = NaND;
/* 371 */     Range r = getDomainBounds(includeInterval);
/* 372 */     if (r != null) {
/* 373 */       result = r.getUpperBound();
/*     */     }
/* 375 */     return result;
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
/* 388 */     boolean interval = (includeInterval || this.domainIsPointsInTime);
/* 389 */     Range result = null;
/* 390 */     Range temp = null;
/* 391 */     Iterator iterator = this.data.iterator();
/* 392 */     while (iterator.hasNext()) {
/* 393 */       TimePeriodValues series = (TimePeriodValues)iterator.next();
/* 394 */       int count = series.getItemCount();
/* 395 */       if (count > 0) {
/* 396 */         TimePeriod start = series.getTimePeriod(series
/* 397 */             .getMinStartIndex());
/* 398 */         TimePeriod end = series.getTimePeriod(series.getMaxEndIndex());
/* 399 */         if (!interval) {
/* 400 */           if (this.xPosition == TimePeriodAnchor.START) {
/* 401 */             TimePeriod maxStart = series.getTimePeriod(series
/* 402 */                 .getMaxStartIndex());
/*     */             
/* 404 */             temp = new Range(start.getStart().getTime(), maxStart.getStart().getTime());
/*     */           }
/* 406 */           else if (this.xPosition == TimePeriodAnchor.MIDDLE) {
/* 407 */             TimePeriod minMiddle = series.getTimePeriod(series
/* 408 */                 .getMinMiddleIndex());
/* 409 */             long s1 = minMiddle.getStart().getTime();
/* 410 */             long e1 = minMiddle.getEnd().getTime();
/* 411 */             TimePeriod maxMiddle = series.getTimePeriod(series
/* 412 */                 .getMaxMiddleIndex());
/* 413 */             long s2 = maxMiddle.getStart().getTime();
/* 414 */             long e2 = maxMiddle.getEnd().getTime();
/* 415 */             temp = new Range((s1 + (e1 - s1) / 2L), (s2 + (e2 - s2) / 2L));
/*     */           
/*     */           }
/* 418 */           else if (this.xPosition == TimePeriodAnchor.END) {
/* 419 */             TimePeriod minEnd = series.getTimePeriod(series
/* 420 */                 .getMinEndIndex());
/*     */             
/* 422 */             temp = new Range(minEnd.getEnd().getTime(), end.getEnd().getTime());
/*     */           }
/*     */         
/*     */         } else {
/*     */           
/* 427 */           temp = new Range(start.getStart().getTime(), end.getEnd().getTime());
/*     */         } 
/* 429 */         result = Range.combine(result, temp);
/*     */       } 
/*     */     } 
/* 432 */     return result;
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
/* 444 */     if (obj == this) {
/* 445 */       return true;
/*     */     }
/* 447 */     if (!(obj instanceof TimePeriodValuesCollection)) {
/* 448 */       return false;
/*     */     }
/* 450 */     TimePeriodValuesCollection that = (TimePeriodValuesCollection)obj;
/* 451 */     if (this.domainIsPointsInTime != that.domainIsPointsInTime) {
/* 452 */       return false;
/*     */     }
/* 454 */     if (this.xPosition != that.xPosition) {
/* 455 */       return false;
/*     */     }
/* 457 */     if (!ObjectUtilities.equal(this.data, that.data)) {
/* 458 */       return false;
/*     */     }
/* 460 */     return true;
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
/*     */   
/* 478 */   public boolean getDomainIsPointsInTime() { return this.domainIsPointsInTime; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 491 */   public void setDomainIsPointsInTime(boolean flag) { this.domainIsPointsInTime = flag; }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/time/TimePeriodValuesCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */