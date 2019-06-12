/*     */ package org.jfree.chart.plot;
/*     */ 
/*     */ import java.awt.geom.Point2D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CrosshairState
/*     */ {
/*     */   private boolean calculateDistanceInDataSpace = false;
/*     */   private double anchorX;
/*     */   private double anchorY;
/*     */   private Point2D anchor;
/*     */   private double crosshairX;
/*     */   private double crosshairY;
/*     */   private int datasetIndex;
/*     */   private int domainAxisIndex;
/*     */   private int rangeAxisIndex;
/*     */   private double distance;
/*     */   
/* 119 */   public CrosshairState() { this(false); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 130 */   public CrosshairState(boolean calculateDistanceInDataSpace) { this.calculateDistanceInDataSpace = calculateDistanceInDataSpace; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 143 */   public double getCrosshairDistance() { return this.distance; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 157 */   public void setCrosshairDistance(double distance) { this.distance = distance; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 182 */   public void updateCrosshairPoint(double x, double y, double transX, double transY, PlotOrientation orientation) { updateCrosshairPoint(x, y, 0, 0, transX, transY, orientation); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateCrosshairPoint(double x, double y, int domainAxisIndex, int rangeAxisIndex, double transX, double transY, PlotOrientation orientation) {
/* 209 */     if (this.anchor != null) {
/* 210 */       double d = 0.0D;
/* 211 */       if (this.calculateDistanceInDataSpace) {
/* 212 */         d = (x - this.anchorX) * (x - this.anchorX) + (y - this.anchorY) * (y - this.anchorY);
/*     */       }
/*     */       else {
/*     */         
/* 216 */         double xx = this.anchor.getX();
/* 217 */         double yy = this.anchor.getY();
/* 218 */         if (orientation == PlotOrientation.HORIZONTAL) {
/* 219 */           double temp = yy;
/* 220 */           yy = xx;
/* 221 */           xx = temp;
/*     */         } 
/* 223 */         d = (transX - xx) * (transX - xx) + (transY - yy) * (transY - yy);
/*     */       } 
/*     */ 
/*     */       
/* 227 */       if (d < this.distance) {
/* 228 */         this.crosshairX = x;
/* 229 */         this.crosshairY = y;
/* 230 */         this.domainAxisIndex = domainAxisIndex;
/* 231 */         this.rangeAxisIndex = rangeAxisIndex;
/* 232 */         this.distance = d;
/*     */       } 
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
/* 251 */   public void updateCrosshairX(double candidateX) { updateCrosshairX(candidateX, 0); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateCrosshairX(double candidateX, int domainAxisIndex) {
/* 268 */     double d = Math.abs(candidateX - this.anchorX);
/* 269 */     if (d < this.distance) {
/* 270 */       this.crosshairX = candidateX;
/* 271 */       this.domainAxisIndex = domainAxisIndex;
/* 272 */       this.distance = d;
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
/* 290 */   public void updateCrosshairY(double candidateY) { updateCrosshairY(candidateY, 0); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateCrosshairY(double candidateY, int rangeAxisIndex) {
/* 306 */     double d = Math.abs(candidateY - this.anchorY);
/* 307 */     if (d < this.distance) {
/* 308 */       this.crosshairY = candidateY;
/* 309 */       this.rangeAxisIndex = rangeAxisIndex;
/* 310 */       this.distance = d;
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
/* 325 */   public Point2D getAnchor() { return this.anchor; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 342 */   public void setAnchor(Point2D anchor) { this.anchor = anchor; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 353 */   public double getAnchorX() { return this.anchorX; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 366 */   public void setAnchorX(double x) { this.anchorX = x; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 377 */   public double getAnchorY() { return this.anchorY; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 390 */   public void setAnchorY(double y) { this.anchorY = y; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 401 */   public double getCrosshairX() { return this.crosshairX; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 416 */   public void setCrosshairX(double x) { this.crosshairX = x; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 428 */   public double getCrosshairY() { return this.crosshairY; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 442 */   public void setCrosshairY(double y) { this.crosshairY = y; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 457 */   public int getDatasetIndex() { return this.datasetIndex; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 470 */   public void setDatasetIndex(int index) { this.datasetIndex = index; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 484 */   public int getDomainAxisIndex() { return this.domainAxisIndex; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 498 */   public int getRangeAxisIndex() { return this.rangeAxisIndex; }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/plot/CrosshairState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */