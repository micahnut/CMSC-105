/*     */ package org.jfree.data.time;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import org.jfree.chart.util.ParamChecks;
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
/*     */ public class TimeSeriesDataItem
/*     */   implements Cloneable, Comparable, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -2235346966016401302L;
/*     */   private RegularTimePeriod period;
/*     */   private Number value;
/*     */   
/*     */   public TimeSeriesDataItem(RegularTimePeriod period, Number value) {
/*  99 */     ParamChecks.nullNotPermitted(period, "period");
/* 100 */     this.period = period;
/* 101 */     this.value = value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 111 */   public TimeSeriesDataItem(RegularTimePeriod period, double value) { this(period, new Double(value)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 120 */   public RegularTimePeriod getPeriod() { return this.period; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 131 */   public Number getValue() { return this.value; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 142 */   public void setValue(Number value) { this.value = value; }
/*     */ 
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
/* 154 */     if (this == obj) {
/* 155 */       return true;
/*     */     }
/* 157 */     if (!(obj instanceof TimeSeriesDataItem)) {
/* 158 */       return false;
/*     */     }
/* 160 */     TimeSeriesDataItem that = (TimeSeriesDataItem)obj;
/* 161 */     if (!ObjectUtilities.equal(this.period, that.period)) {
/* 162 */       return false;
/*     */     }
/* 164 */     if (!ObjectUtilities.equal(this.value, that.value)) {
/* 165 */       return false;
/*     */     }
/* 167 */     return true;
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
/* 178 */     result = (this.period != null) ? this.period.hashCode() : 0;
/* 179 */     return 29 * result + ((this.value != null) ? this.value.hashCode() : 0);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public int compareTo(Object o1) {
/*     */     int result;
/* 202 */     if (o1 instanceof TimeSeriesDataItem) {
/* 203 */       TimeSeriesDataItem datapair = (TimeSeriesDataItem)o1;
/* 204 */       result = getPeriod().compareTo(datapair.getPeriod());
/*     */ 
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */       
/* 211 */       result = 1;
/*     */     } 
/*     */     
/* 214 */     return result;
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
/*     */   public Object clone() {
/* 226 */     Object clone = null;
/*     */     try {
/* 228 */       clone = super.clone();
/*     */     }
/* 230 */     catch (CloneNotSupportedException e) {
/* 231 */       e.printStackTrace();
/*     */     } 
/* 233 */     return clone;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/time/TimeSeriesDataItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */