/*     */ package org.jfree.chart.renderer.category;
/*     */ 
/*     */ import org.jfree.chart.plot.CategoryCrosshairState;
/*     */ import org.jfree.chart.plot.PlotRenderingInfo;
/*     */ import org.jfree.chart.renderer.RendererState;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CategoryItemRendererState
/*     */   extends RendererState
/*     */ {
/*     */   private double barWidth;
/*     */   private double seriesRunningTotal;
/*     */   private int[] visibleSeries;
/*     */   private CategoryCrosshairState crosshairState;
/*     */   
/*     */   public CategoryItemRendererState(PlotRenderingInfo info) {
/*  82 */     super(info);
/*  83 */     this.barWidth = 0.0D;
/*  84 */     this.seriesRunningTotal = 0.0D;
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
/*  95 */   public double getBarWidth() { return this.barWidth; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 107 */   public void setBarWidth(double width) { this.barWidth = width; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 118 */   public double getSeriesRunningTotal() { return this.seriesRunningTotal; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 130 */   void setSeriesRunningTotal(double total) { this.seriesRunningTotal = total; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 143 */   public CategoryCrosshairState getCrosshairState() { return this.crosshairState; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 156 */   public void setCrosshairState(CategoryCrosshairState state) { this.crosshairState = state; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getVisibleSeriesIndex(int rowIndex) {
/* 172 */     if (this.visibleSeries == null) {
/* 173 */       return rowIndex;
/*     */     }
/* 175 */     int index = -1;
/* 176 */     for (int vRow = 0; vRow < this.visibleSeries.length; vRow++) {
/* 177 */       if (this.visibleSeries[vRow] == rowIndex) {
/* 178 */         index = vRow;
/*     */         break;
/*     */       } 
/*     */     } 
/* 182 */     return index;
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
/*     */   public int getVisibleSeriesCount() {
/* 194 */     if (this.visibleSeries == null) {
/* 195 */       return -1;
/*     */     }
/* 197 */     return this.visibleSeries.length;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int[] getVisibleSeriesArray() {
/* 208 */     if (this.visibleSeries == null) {
/* 209 */       return null;
/*     */     }
/* 211 */     int[] result = new int[this.visibleSeries.length];
/* 212 */     System.arraycopy(this.visibleSeries, 0, result, 0, this.visibleSeries.length);
/*     */     
/* 214 */     return result;
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
/* 225 */   public void setVisibleSeriesArray(int[] visibleSeries) { this.visibleSeries = visibleSeries; }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/renderer/category/CategoryItemRendererState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */