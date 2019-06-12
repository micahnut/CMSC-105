/*     */ package org.jfree.data.xy;
/*     */ 
/*     */ import org.jfree.data.general.DatasetChangeEvent;
/*     */ import org.jfree.data.general.DatasetChangeListener;
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
/*     */ public class XYBarDataset
/*     */   extends AbstractIntervalXYDataset
/*     */   implements IntervalXYDataset, DatasetChangeListener, PublicCloneable
/*     */ {
/*     */   private XYDataset underlying;
/*     */   private double barWidth;
/*     */   
/*     */   public XYBarDataset(XYDataset underlying, double barWidth) {
/*  77 */     this.underlying = underlying;
/*  78 */     this.underlying.addChangeListener(this);
/*  79 */     this.barWidth = barWidth;
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
/*  90 */   public XYDataset getUnderlyingDataset() { return this.underlying; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 102 */   public double getBarWidth() { return this.barWidth; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBarWidth(double barWidth) {
/* 115 */     this.barWidth = barWidth;
/* 116 */     notifyListeners(new DatasetChangeEvent(this, this));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 126 */   public int getSeriesCount() { return this.underlying.getSeriesCount(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 139 */   public Comparable getSeriesKey(int series) { return this.underlying.getSeriesKey(series); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 151 */   public int getItemCount(int series) { return this.underlying.getItemCount(series); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 166 */   public Number getX(int series, int item) { return this.underlying.getX(series, item); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 181 */   public double getXValue(int series, int item) { return this.underlying.getXValue(series, item); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 196 */   public Number getY(int series, int item) { return this.underlying.getY(series, item); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 211 */   public double getYValue(int series, int item) { return this.underlying.getYValue(series, item); }
/*     */ 
/*     */ 
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
/* 224 */     Number result = null;
/* 225 */     Number xnum = this.underlying.getX(series, item);
/* 226 */     if (xnum != null) {
/* 227 */       result = new Double(xnum.doubleValue() - this.barWidth / 2.0D);
/*     */     }
/* 229 */     return result;
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
/* 245 */   public double getStartXValue(int series, int item) { return getXValue(series, item) - this.barWidth / 2.0D; }
/*     */ 
/*     */ 
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
/* 258 */     Number result = null;
/* 259 */     Number xnum = this.underlying.getX(series, item);
/* 260 */     if (xnum != null) {
/* 261 */       result = new Double(xnum.doubleValue() + this.barWidth / 2.0D);
/*     */     }
/* 263 */     return result;
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
/* 279 */   public double getEndXValue(int series, int item) { return getXValue(series, item) + this.barWidth / 2.0D; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 292 */   public Number getStartY(int series, int item) { return this.underlying.getY(series, item); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 308 */   public double getStartYValue(int series, int item) { return getYValue(series, item); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 321 */   public Number getEndY(int series, int item) { return this.underlying.getY(series, item); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 337 */   public double getEndYValue(int series, int item) { return getYValue(series, item); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 347 */   public void datasetChanged(DatasetChangeEvent event) { notifyListeners(event); }
/*     */ 
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
/* 359 */     if (obj == this) {
/* 360 */       return true;
/*     */     }
/* 362 */     if (!(obj instanceof XYBarDataset)) {
/* 363 */       return false;
/*     */     }
/* 365 */     XYBarDataset that = (XYBarDataset)obj;
/* 366 */     if (!this.underlying.equals(that.underlying)) {
/* 367 */       return false;
/*     */     }
/* 369 */     if (this.barWidth != that.barWidth) {
/* 370 */       return false;
/*     */     }
/* 372 */     return true;
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
/*     */   public Object clone() throws CloneNotSupportedException {
/* 391 */     XYBarDataset clone = (XYBarDataset)super.clone();
/* 392 */     if (this.underlying instanceof PublicCloneable) {
/* 393 */       PublicCloneable pc = (PublicCloneable)this.underlying;
/* 394 */       clone.underlying = (XYDataset)pc.clone();
/*     */     } 
/* 396 */     return clone;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/xy/XYBarDataset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */