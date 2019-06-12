/*     */ package org.jfree.data.xy;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import org.jfree.data.DomainOrder;
/*     */ import org.jfree.data.general.DatasetChangeEvent;
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
/*     */ public class DefaultXYDataset
/*     */   extends AbstractXYDataset
/*     */   implements XYDataset, PublicCloneable
/*     */ {
/*     */   private List seriesKeys;
/*     */   private List seriesList;
/*     */   
/*     */   public DefaultXYDataset() {
/*  81 */     this.seriesKeys = new ArrayList();
/*  82 */     this.seriesList = new ArrayList();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  92 */   public int getSeriesCount() { return this.seriesList.size(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Comparable getSeriesKey(int series) {
/* 108 */     if (series < 0 || series >= getSeriesCount()) {
/* 109 */       throw new IllegalArgumentException("Series index out of bounds");
/*     */     }
/* 111 */     return (Comparable)this.seriesKeys.get(series);
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
/* 124 */   public int indexOf(Comparable seriesKey) { return this.seriesKeys.indexOf(seriesKey); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 136 */   public DomainOrder getDomainOrder() { return DomainOrder.NONE; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getItemCount(int series) {
/* 152 */     if (series < 0 || series >= getSeriesCount()) {
/* 153 */       throw new IllegalArgumentException("Series index out of bounds");
/*     */     }
/* 155 */     double[][] seriesArray = (double[][])this.seriesList.get(series);
/* 156 */     return seriesArray[0].length;
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
/*     */   public double getXValue(int series, int item) {
/* 178 */     double[][] seriesData = (double[][])this.seriesList.get(series);
/* 179 */     return seriesData[0][item];
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
/*     */   
/* 201 */   public Number getX(int series, int item) { return new Double(getXValue(series, item)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getYValue(int series, int item) {
/* 223 */     double[][] seriesData = (double[][])this.seriesList.get(series);
/* 224 */     return seriesData[1][item];
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
/*     */   
/* 246 */   public Number getY(int series, int item) { return new Double(getYValue(series, item)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addSeries(Comparable seriesKey, double[][] data) {
/* 260 */     if (seriesKey == null) {
/* 261 */       throw new IllegalArgumentException("The 'seriesKey' cannot be null.");
/*     */     }
/*     */     
/* 264 */     if (data == null) {
/* 265 */       throw new IllegalArgumentException("The 'data' is null.");
/*     */     }
/* 267 */     if (data.length != 2) {
/* 268 */       throw new IllegalArgumentException("The 'data' array must have length == 2.");
/*     */     }
/*     */     
/* 271 */     if (data[0].length != data[1].length) {
/* 272 */       throw new IllegalArgumentException("The 'data' array must contain two arrays with equal length.");
/*     */     }
/*     */     
/* 275 */     int seriesIndex = indexOf(seriesKey);
/* 276 */     if (seriesIndex == -1) {
/* 277 */       this.seriesKeys.add(seriesKey);
/* 278 */       this.seriesList.add(data);
/*     */     } else {
/*     */       
/* 281 */       this.seriesList.remove(seriesIndex);
/* 282 */       this.seriesList.add(seriesIndex, data);
/*     */     } 
/* 284 */     notifyListeners(new DatasetChangeEvent(this, this));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeSeries(Comparable seriesKey) {
/* 295 */     int seriesIndex = indexOf(seriesKey);
/* 296 */     if (seriesIndex >= 0) {
/* 297 */       this.seriesKeys.remove(seriesIndex);
/* 298 */       this.seriesList.remove(seriesIndex);
/* 299 */       notifyListeners(new DatasetChangeEvent(this, this));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object obj) {
/* 320 */     if (obj == this) {
/* 321 */       return true;
/*     */     }
/* 323 */     if (!(obj instanceof DefaultXYDataset)) {
/* 324 */       return false;
/*     */     }
/* 326 */     DefaultXYDataset that = (DefaultXYDataset)obj;
/* 327 */     if (!this.seriesKeys.equals(that.seriesKeys)) {
/* 328 */       return false;
/*     */     }
/* 330 */     for (int i = 0; i < this.seriesList.size(); i++) {
/* 331 */       double[][] d1 = (double[][])this.seriesList.get(i);
/* 332 */       double[][] d2 = (double[][])that.seriesList.get(i);
/* 333 */       double[] d1x = d1[0];
/* 334 */       double[] d2x = d2[0];
/* 335 */       if (!Arrays.equals(d1x, d2x)) {
/* 336 */         return false;
/*     */       }
/* 338 */       double[] d1y = d1[1];
/* 339 */       double[] d2y = d2[1];
/* 340 */       if (!Arrays.equals(d1y, d2y)) {
/* 341 */         return false;
/*     */       }
/*     */     } 
/* 344 */     return true;
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
/* 355 */     result = this.seriesKeys.hashCode();
/* 356 */     return 29 * result + this.seriesList.hashCode();
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
/*     */   public Object clone() throws CloneNotSupportedException {
/* 371 */     DefaultXYDataset clone = (DefaultXYDataset)super.clone();
/* 372 */     clone.seriesKeys = new ArrayList(this.seriesKeys);
/* 373 */     clone.seriesList = new ArrayList(this.seriesList.size());
/* 374 */     for (int i = 0; i < this.seriesList.size(); i++) {
/* 375 */       double[][] data = (double[][])this.seriesList.get(i);
/* 376 */       double[] x = data[0];
/* 377 */       double[] y = data[1];
/* 378 */       double[] xx = new double[x.length];
/* 379 */       double[] yy = new double[y.length];
/* 380 */       System.arraycopy(x, 0, xx, 0, x.length);
/* 381 */       System.arraycopy(y, 0, yy, 0, y.length);
/* 382 */       clone.seriesList.add(i, new double[][] { xx, yy });
/*     */     } 
/* 384 */     return clone;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/xy/DefaultXYDataset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */