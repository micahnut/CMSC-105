/*     */ package org.jfree.data.time.ohlc;
/*     */ 
/*     */ import org.jfree.data.ComparableObjectItem;
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
/*     */ public class OHLCItem
/*     */   extends ComparableObjectItem
/*     */ {
/*  65 */   public OHLCItem(RegularTimePeriod period, double open, double high, double low, double close) { super(period, new OHLC(open, high, low, close)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  74 */   public RegularTimePeriod getPeriod() { return (RegularTimePeriod)getComparable(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  83 */   public double getYValue() { return getCloseValue(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getOpenValue() {
/*  92 */     OHLC ohlc = (OHLC)getObject();
/*  93 */     if (ohlc != null) {
/*  94 */       return ohlc.getOpen();
/*     */     }
/*     */     
/*  97 */     return NaND;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getHighValue() {
/* 107 */     OHLC ohlc = (OHLC)getObject();
/* 108 */     if (ohlc != null) {
/* 109 */       return ohlc.getHigh();
/*     */     }
/*     */     
/* 112 */     return NaND;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getLowValue() {
/* 122 */     OHLC ohlc = (OHLC)getObject();
/* 123 */     if (ohlc != null) {
/* 124 */       return ohlc.getLow();
/*     */     }
/*     */     
/* 127 */     return NaND;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getCloseValue() {
/* 137 */     OHLC ohlc = (OHLC)getObject();
/* 138 */     if (ohlc != null) {
/* 139 */       return ohlc.getClose();
/*     */     }
/*     */     
/* 142 */     return NaND;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/time/ohlc/OHLCItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */