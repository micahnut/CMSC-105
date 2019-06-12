/*     */ package org.jfree.data.xy;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Date;
/*     */ import org.jfree.chart.util.ParamChecks;
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
/*     */ public class DefaultHighLowDataset
/*     */   extends AbstractXYDataset
/*     */   implements OHLCDataset, PublicCloneable
/*     */ {
/*     */   private Comparable seriesKey;
/*     */   private Date[] date;
/*     */   private Number[] high;
/*     */   private Number[] low;
/*     */   private Number[] open;
/*     */   private Number[] close;
/*     */   private Number[] volume;
/*     */   
/*     */   public DefaultHighLowDataset(Comparable seriesKey, Date[] date, double[] high, double[] low, double[] open, double[] close, double[] volume) {
/* 106 */     ParamChecks.nullNotPermitted(seriesKey, "seriesKey");
/* 107 */     ParamChecks.nullNotPermitted(date, "date");
/* 108 */     this.seriesKey = seriesKey;
/* 109 */     this.date = date;
/* 110 */     this.high = createNumberArray(high);
/* 111 */     this.low = createNumberArray(low);
/* 112 */     this.open = createNumberArray(open);
/* 113 */     this.close = createNumberArray(close);
/* 114 */     this.volume = createNumberArray(volume);
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
/* 128 */   public Comparable getSeriesKey(int series) { return this.seriesKey; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 147 */   public Number getX(int series, int item) { return new Long(this.date[item].getTime()); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 163 */   public Date getXDate(int series, int item) { return this.date[item]; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 181 */   public Number getY(int series, int item) { return getClose(series, item); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 196 */   public Number getHigh(int series, int item) { return this.high[item]; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 212 */     double result = NaND;
/* 213 */     Number h = getHigh(series, item);
/* 214 */     if (h != null) {
/* 215 */       result = h.doubleValue();
/*     */     }
/* 217 */     return result;
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
/* 232 */   public Number getLow(int series, int item) { return this.low[item]; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 248 */     double result = NaND;
/* 249 */     Number l = getLow(series, item);
/* 250 */     if (l != null) {
/* 251 */       result = l.doubleValue();
/*     */     }
/* 253 */     return result;
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
/* 268 */   public Number getOpen(int series, int item) { return this.open[item]; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 284 */     double result = NaND;
/* 285 */     Number open = getOpen(series, item);
/* 286 */     if (open != null) {
/* 287 */       result = open.doubleValue();
/*     */     }
/* 289 */     return result;
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
/* 304 */   public Number getClose(int series, int item) { return this.close[item]; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 320 */     double result = NaND;
/* 321 */     Number c = getClose(series, item);
/* 322 */     if (c != null) {
/* 323 */       result = c.doubleValue();
/*     */     }
/* 325 */     return result;
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
/* 340 */   public Number getVolume(int series, int item) { return this.volume[item]; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getVolumeValue(int series, int item) {
/* 356 */     double result = NaND;
/* 357 */     Number v = getVolume(series, item);
/* 358 */     if (v != null) {
/* 359 */       result = v.doubleValue();
/*     */     }
/* 361 */     return result;
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
/* 373 */   public int getSeriesCount() { return 1; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 385 */   public int getItemCount(int series) { return this.date.length; }
/*     */ 
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
/* 397 */     if (obj == this) {
/* 398 */       return true;
/*     */     }
/* 400 */     if (!(obj instanceof DefaultHighLowDataset)) {
/* 401 */       return false;
/*     */     }
/* 403 */     DefaultHighLowDataset that = (DefaultHighLowDataset)obj;
/* 404 */     if (!this.seriesKey.equals(that.seriesKey)) {
/* 405 */       return false;
/*     */     }
/* 407 */     if (!Arrays.equals(this.date, that.date)) {
/* 408 */       return false;
/*     */     }
/* 410 */     if (!Arrays.equals(this.open, that.open)) {
/* 411 */       return false;
/*     */     }
/* 413 */     if (!Arrays.equals(this.high, that.high)) {
/* 414 */       return false;
/*     */     }
/* 416 */     if (!Arrays.equals(this.low, that.low)) {
/* 417 */       return false;
/*     */     }
/* 419 */     if (!Arrays.equals(this.close, that.close)) {
/* 420 */       return false;
/*     */     }
/* 422 */     if (!Arrays.equals(this.volume, that.volume)) {
/* 423 */       return false;
/*     */     }
/* 425 */     return true;
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
/*     */   public static Number[] createNumberArray(double[] data) {
/* 437 */     Number[] result = new Number[data.length];
/* 438 */     for (int i = 0; i < data.length; i++) {
/* 439 */       result[i] = new Double(data[i]);
/*     */     }
/* 441 */     return result;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/xy/DefaultHighLowDataset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */