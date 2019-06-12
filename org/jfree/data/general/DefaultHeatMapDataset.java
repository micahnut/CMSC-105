/*     */ package org.jfree.data.general;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import org.jfree.data.DataUtilities;
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
/*     */ public class DefaultHeatMapDataset
/*     */   extends AbstractDataset
/*     */   implements HeatMapDataset, Cloneable, PublicCloneable, Serializable
/*     */ {
/*     */   private int xSamples;
/*     */   private int ySamples;
/*     */   private double minX;
/*     */   private double maxX;
/*     */   private double minY;
/*     */   private double maxY;
/*     */   private double[][] zValues;
/*     */   
/*     */   public DefaultHeatMapDataset(int xSamples, int ySamples, double minX, double maxX, double minY, double maxY) {
/*  90 */     if (xSamples < 1) {
/*  91 */       throw new IllegalArgumentException("Requires 'xSamples' > 0");
/*     */     }
/*  93 */     if (ySamples < 1) {
/*  94 */       throw new IllegalArgumentException("Requires 'ySamples' > 0");
/*     */     }
/*  96 */     if (Double.isInfinite(minX) || Double.isNaN(minX)) {
/*  97 */       throw new IllegalArgumentException("'minX' cannot be INF or NaN.");
/*     */     }
/*  99 */     if (Double.isInfinite(maxX) || Double.isNaN(maxX)) {
/* 100 */       throw new IllegalArgumentException("'maxX' cannot be INF or NaN.");
/*     */     }
/* 102 */     if (Double.isInfinite(minY) || Double.isNaN(minY)) {
/* 103 */       throw new IllegalArgumentException("'minY' cannot be INF or NaN.");
/*     */     }
/* 105 */     if (Double.isInfinite(maxY) || Double.isNaN(maxY)) {
/* 106 */       throw new IllegalArgumentException("'maxY' cannot be INF or NaN.");
/*     */     }
/*     */     
/* 109 */     this.xSamples = xSamples;
/* 110 */     this.ySamples = ySamples;
/* 111 */     this.minX = minX;
/* 112 */     this.maxX = maxX;
/* 113 */     this.minY = minY;
/* 114 */     this.maxY = maxY;
/* 115 */     this.zValues = new double[xSamples][];
/* 116 */     for (int x = 0; x < xSamples; x++) {
/* 117 */       this.zValues[x] = new double[ySamples];
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
/* 130 */   public int getXSampleCount() { return this.xSamples; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 142 */   public int getYSampleCount() { return this.ySamples; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 154 */   public double getMinimumXValue() { return this.minX; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 166 */   public double getMaximumXValue() { return this.maxX; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 178 */   public double getMinimumYValue() { return this.minY; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 190 */   public double getMaximumYValue() { return this.maxY; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 202 */   public double getXValue(int xIndex) { return this.minX + (this.maxX - this.minX) * xIndex / this.xSamples; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 216 */   public double getYValue(int yIndex) { return this.minY + (this.maxY - this.minY) * yIndex / this.ySamples; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 232 */   public double getZValue(int xIndex, int yIndex) { return this.zValues[xIndex][yIndex]; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 248 */   public Number getZ(int xIndex, int yIndex) { return new Double(getZValue(xIndex, yIndex)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 260 */   public void setZValue(int xIndex, int yIndex, double z) { setZValue(xIndex, yIndex, z, true); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setZValue(int xIndex, int yIndex, double z, boolean notify) {
/* 273 */     this.zValues[xIndex][yIndex] = z;
/* 274 */     if (notify) {
/* 275 */       fireDatasetChanged();
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
/* 288 */     if (obj == this) {
/* 289 */       return true;
/*     */     }
/* 291 */     if (!(obj instanceof DefaultHeatMapDataset)) {
/* 292 */       return false;
/*     */     }
/* 294 */     DefaultHeatMapDataset that = (DefaultHeatMapDataset)obj;
/* 295 */     if (this.xSamples != that.xSamples) {
/* 296 */       return false;
/*     */     }
/* 298 */     if (this.ySamples != that.ySamples) {
/* 299 */       return false;
/*     */     }
/* 301 */     if (this.minX != that.minX) {
/* 302 */       return false;
/*     */     }
/* 304 */     if (this.maxX != that.maxX) {
/* 305 */       return false;
/*     */     }
/* 307 */     if (this.minY != that.minY) {
/* 308 */       return false;
/*     */     }
/* 310 */     if (this.maxY != that.maxY) {
/* 311 */       return false;
/*     */     }
/* 313 */     if (!DataUtilities.equal(this.zValues, that.zValues)) {
/* 314 */       return false;
/*     */     }
/*     */     
/* 317 */     return true;
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
/*     */   public Object clone() throws CloneNotSupportedException {
/* 330 */     DefaultHeatMapDataset clone = (DefaultHeatMapDataset)super.clone();
/* 331 */     clone.zValues = DataUtilities.clone(this.zValues);
/* 332 */     return clone;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/general/DefaultHeatMapDataset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */