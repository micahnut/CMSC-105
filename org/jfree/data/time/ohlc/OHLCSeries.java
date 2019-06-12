/*     */ package org.jfree.data.time.ohlc;
/*     */ 
/*     */ import org.jfree.chart.util.ParamChecks;
/*     */ import org.jfree.data.ComparableObjectItem;
/*     */ import org.jfree.data.ComparableObjectSeries;
/*     */ import org.jfree.data.time.RegularTimePeriod;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class OHLCSeries
/*     */   extends ComparableObjectSeries
/*     */ {
/*  67 */   public OHLCSeries(Comparable key) { super(key, true, false); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RegularTimePeriod getPeriod(int index) {
/*  78 */     OHLCItem item = (OHLCItem)getDataItem(index);
/*  79 */     return item.getPeriod();
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
/*  91 */   public ComparableObjectItem getDataItem(int index) { return super.getDataItem(index); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(RegularTimePeriod period, double open, double high, double low, double close) {
/* 105 */     if (getItemCount() > 0) {
/* 106 */       OHLCItem item0 = (OHLCItem)getDataItem(0);
/* 107 */       if (!period.getClass().equals(item0.getPeriod().getClass())) {
/* 108 */         throw new IllegalArgumentException("Can't mix RegularTimePeriod class types.");
/*     */       }
/*     */     } 
/*     */     
/* 112 */     add(new OHLCItem(period, open, high, low, close), true);
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
/*     */   public void add(OHLCItem item) {
/* 124 */     ParamChecks.nullNotPermitted(item, "item");
/* 125 */     add(item.getPeriod(), item.getOpenValue(), item.getHighValue(), item
/* 126 */         .getLowValue(), item.getCloseValue());
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
/* 138 */   public ComparableObjectItem remove(int index) { return super.remove(index); }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/time/ohlc/OHLCSeries.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */