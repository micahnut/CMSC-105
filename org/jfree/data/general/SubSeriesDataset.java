/*     */ package org.jfree.data.general;
/*     */ 
/*     */ import org.jfree.data.xy.AbstractIntervalXYDataset;
/*     */ import org.jfree.data.xy.IntervalXYDataset;
/*     */ import org.jfree.data.xy.OHLCDataset;
/*     */ import org.jfree.data.xy.XYDataset;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SubSeriesDataset
/*     */   extends AbstractIntervalXYDataset
/*     */   implements OHLCDataset, IntervalXYDataset, CombinationDataset
/*     */ {
/*  74 */   private SeriesDataset parent = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int[] map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SubSeriesDataset(SeriesDataset parent, int[] map) {
/*  87 */     this.parent = parent;
/*  88 */     this.map = map;
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
/*  99 */   public SubSeriesDataset(SeriesDataset parent, int series) { this(parent, new int[] { series }); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 119 */   public Number getHigh(int series, int item) { return ((OHLCDataset)this.parent).getHigh(this.map[series], item); }
/*     */ 
/*     */ 
/*     */ 
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
/* 133 */     double result = NaND;
/* 134 */     Number high = getHigh(series, item);
/* 135 */     if (high != null) {
/* 136 */       result = high.doubleValue();
/*     */     }
/* 138 */     return result;
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
/* 154 */   public Number getLow(int series, int item) { return ((OHLCDataset)this.parent).getLow(this.map[series], item); }
/*     */ 
/*     */ 
/*     */ 
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
/* 168 */     double result = NaND;
/* 169 */     Number low = getLow(series, item);
/* 170 */     if (low != null) {
/* 171 */       result = low.doubleValue();
/*     */     }
/* 173 */     return result;
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
/* 189 */   public Number getOpen(int series, int item) { return ((OHLCDataset)this.parent).getOpen(this.map[series], item); }
/*     */ 
/*     */ 
/*     */ 
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
/* 203 */     double result = NaND;
/* 204 */     Number open = getOpen(series, item);
/* 205 */     if (open != null) {
/* 206 */       result = open.doubleValue();
/*     */     }
/* 208 */     return result;
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
/* 224 */   public Number getClose(int series, int item) { return ((OHLCDataset)this.parent).getClose(this.map[series], item); }
/*     */ 
/*     */ 
/*     */ 
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
/* 238 */     double result = NaND;
/* 239 */     Number close = getClose(series, item);
/* 240 */     if (close != null) {
/* 241 */       result = close.doubleValue();
/*     */     }
/* 243 */     return result;
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
/* 259 */   public Number getVolume(int series, int item) { return ((OHLCDataset)this.parent).getVolume(this.map[series], item); }
/*     */ 
/*     */ 
/*     */ 
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
/* 273 */     double result = NaND;
/* 274 */     Number volume = getVolume(series, item);
/* 275 */     if (volume != null) {
/* 276 */       result = volume.doubleValue();
/*     */     }
/* 278 */     return result;
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
/* 298 */   public Number getX(int series, int item) { return ((XYDataset)this.parent).getX(this.map[series], item); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 314 */   public Number getY(int series, int item) { return ((XYDataset)this.parent).getY(this.map[series], item); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 329 */   public int getItemCount(int series) { return ((XYDataset)this.parent).getItemCount(this.map[series]); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 343 */   public int getSeriesCount() { return this.map.length; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 355 */   public Comparable getSeriesKey(int series) { return this.parent.getSeriesKey(this.map[series]); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 372 */     if (this.parent instanceof IntervalXYDataset) {
/* 373 */       return ((IntervalXYDataset)this.parent).getStartX(this.map[series], item);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 378 */     return getX(series, item);
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
/* 392 */     if (this.parent instanceof IntervalXYDataset) {
/* 393 */       return ((IntervalXYDataset)this.parent).getEndX(this.map[series], item);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 398 */     return getX(series, item);
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
/*     */   public Number getStartY(int series, int item) {
/* 412 */     if (this.parent instanceof IntervalXYDataset) {
/* 413 */       return ((IntervalXYDataset)this.parent).getStartY(this.map[series], item);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 418 */     return getY(series, item);
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
/*     */   public Number getEndY(int series, int item) {
/* 432 */     if (this.parent instanceof IntervalXYDataset) {
/* 433 */       return ((IntervalXYDataset)this.parent).getEndY(this.map[series], item);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 438 */     return getY(series, item);
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
/* 453 */   public SeriesDataset getParent() { return this.parent; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 463 */   public int[] getMap() { return (int[])this.map.clone(); }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/general/SubSeriesDataset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */