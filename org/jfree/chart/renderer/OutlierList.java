/*     */ package org.jfree.chart.renderer;
/*     */ 
/*     */ import java.awt.geom.Point2D;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class OutlierList
/*     */ {
/*     */   private List outliers;
/*     */   private Outlier averagedOutlier;
/*     */   private boolean multiple = false;
/*     */   
/*     */   public OutlierList(Outlier outlier) {
/*  86 */     this.outliers = new ArrayList();
/*  87 */     setAveragedOutlier(outlier);
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
/*  98 */   public boolean add(Outlier outlier) { return this.outliers.add(outlier); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 107 */   public int getItemCount() { return this.outliers.size(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 116 */   public Outlier getAveragedOutlier() { return this.averagedOutlier; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 125 */   public void setAveragedOutlier(Outlier averagedOutlier) { this.averagedOutlier = averagedOutlier; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 135 */   public boolean isMultiple() { return this.multiple; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 145 */   public void setMultiple(boolean multiple) { this.multiple = multiple; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isOverlapped(Outlier other) {
/* 158 */     if (other == null) {
/* 159 */       return false;
/*     */     }
/*     */     
/* 162 */     return other.overlaps(getAveragedOutlier());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateAveragedOutlier() {
/* 172 */     double totalXCoords = 0.0D;
/* 173 */     double totalYCoords = 0.0D;
/* 174 */     int size = getItemCount();
/* 175 */     Iterator iterator = this.outliers.iterator();
/* 176 */     while (iterator.hasNext()) {
/* 177 */       Outlier o = (Outlier)iterator.next();
/* 178 */       totalXCoords += o.getX();
/* 179 */       totalYCoords += o.getY();
/*     */     } 
/* 181 */     getAveragedOutlier().getPoint().setLocation(new Point2D.Double(totalXCoords / size, totalYCoords / size));
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/renderer/OutlierList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */