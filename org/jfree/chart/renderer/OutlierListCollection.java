/*     */ package org.jfree.chart.renderer;
/*     */ 
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
/*     */ public class OutlierListCollection
/*     */ {
/*     */   private List outlierLists;
/*     */   private boolean highFarOut = false;
/*     */   private boolean lowFarOut = false;
/*     */   
/*  82 */   public OutlierListCollection() { this.outlierLists = new ArrayList(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  92 */   public boolean isHighFarOut() { return this.highFarOut; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 102 */   public void setHighFarOut(boolean farOut) { this.highFarOut = farOut; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 112 */   public boolean isLowFarOut() { return this.lowFarOut; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 122 */   public void setLowFarOut(boolean farOut) { this.lowFarOut = farOut; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean add(Outlier outlier) {
/* 137 */     if (this.outlierLists.isEmpty()) {
/* 138 */       return this.outlierLists.add(new OutlierList(outlier));
/*     */     }
/*     */     
/* 141 */     boolean updated = false;
/* 142 */     Iterator iterator = this.outlierLists.iterator();
/* 143 */     while (iterator.hasNext()) {
/* 144 */       OutlierList list = (OutlierList)iterator.next();
/* 145 */       if (list.isOverlapped(outlier)) {
/* 146 */         updated = updateOutlierList(list, outlier);
/*     */       }
/*     */     } 
/* 149 */     if (!updated)
/*     */     {
/* 151 */       updated = this.outlierLists.add(new OutlierList(outlier));
/*     */     }
/* 153 */     return updated;
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
/* 164 */   public Iterator iterator() { return this.outlierLists.iterator(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean updateOutlierList(OutlierList list, Outlier outlier) {
/* 179 */     boolean result = false;
/* 180 */     result = list.add(outlier);
/* 181 */     list.updateAveragedOutlier();
/* 182 */     list.setMultiple(true);
/* 183 */     return result;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/renderer/OutlierListCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */