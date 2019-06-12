/*     */ package org.jfree.data.xy;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Date;
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
/*     */ public class DefaultOHLCDataset
/*     */   extends AbstractXYDataset
/*     */   implements OHLCDataset, PublicCloneable
/*     */ {
/*     */   private Comparable key;
/*     */   private OHLCDataItem[] data;
/*     */   
/*     */   public DefaultOHLCDataset(Comparable key, OHLCDataItem[] data) {
/*  73 */     this.key = key;
/*  74 */     this.data = data;
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
/*  86 */   public Comparable getSeriesKey(int series) { return this.key; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  99 */   public Number getX(int series, int item) { return new Long(this.data[item].getDate().getTime()); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 111 */   public Date getXDate(int series, int item) { return this.data[item].getDate(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 124 */   public Number getY(int series, int item) { return getClose(series, item); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 137 */   public Number getHigh(int series, int item) { return this.data[item].getHigh(); }
/*     */ 
/*     */ 
/*     */ 
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
/* 151 */     double result = NaND;
/* 152 */     Number high = getHigh(series, item);
/* 153 */     if (high != null) {
/* 154 */       result = high.doubleValue();
/*     */     }
/* 156 */     return result;
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
/* 169 */   public Number getLow(int series, int item) { return this.data[item].getLow(); }
/*     */ 
/*     */ 
/*     */ 
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
/* 183 */     double result = NaND;
/* 184 */     Number low = getLow(series, item);
/* 185 */     if (low != null) {
/* 186 */       result = low.doubleValue();
/*     */     }
/* 188 */     return result;
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
/* 201 */   public Number getOpen(int series, int item) { return this.data[item].getOpen(); }
/*     */ 
/*     */ 
/*     */ 
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
/* 215 */     double result = NaND;
/* 216 */     Number open = getOpen(series, item);
/* 217 */     if (open != null) {
/* 218 */       result = open.doubleValue();
/*     */     }
/* 220 */     return result;
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
/* 233 */   public Number getClose(int series, int item) { return this.data[item].getClose(); }
/*     */ 
/*     */ 
/*     */ 
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
/* 247 */     double result = NaND;
/* 248 */     Number close = getClose(series, item);
/* 249 */     if (close != null) {
/* 250 */       result = close.doubleValue();
/*     */     }
/* 252 */     return result;
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
/* 265 */   public Number getVolume(int series, int item) { return this.data[item].getVolume(); }
/*     */ 
/*     */ 
/*     */ 
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
/* 279 */     double result = NaND;
/* 280 */     Number volume = getVolume(series, item);
/* 281 */     if (volume != null) {
/* 282 */       result = volume.doubleValue();
/*     */     }
/* 284 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 294 */   public int getSeriesCount() { return 1; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 306 */   public int getItemCount(int series) { return this.data.length; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 313 */   public void sortDataByDate() { Arrays.sort(this.data); }
/*     */ 
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
/* 325 */     if (this == obj) {
/* 326 */       return true;
/*     */     }
/* 328 */     if (!(obj instanceof DefaultOHLCDataset)) {
/* 329 */       return false;
/*     */     }
/* 331 */     DefaultOHLCDataset that = (DefaultOHLCDataset)obj;
/* 332 */     if (!this.key.equals(that.key)) {
/* 333 */       return false;
/*     */     }
/* 335 */     if (!Arrays.equals(this.data, that.data)) {
/* 336 */       return false;
/*     */     }
/* 338 */     return true;
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
/* 350 */     DefaultOHLCDataset clone = (DefaultOHLCDataset)super.clone();
/* 351 */     clone.data = new OHLCDataItem[this.data.length];
/* 352 */     System.arraycopy(this.data, 0, clone.data, 0, this.data.length);
/* 353 */     return clone;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/xy/DefaultOHLCDataset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */