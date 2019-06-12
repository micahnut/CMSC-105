/*    */ package org.jfree.chart.renderer;
/*    */ 
/*    */ import org.jfree.chart.ChartRenderingInfo;
/*    */ import org.jfree.chart.entity.EntityCollection;
/*    */ import org.jfree.chart.plot.PlotRenderingInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RendererState
/*    */ {
/*    */   private PlotRenderingInfo info;
/*    */   
/* 63 */   public RendererState(PlotRenderingInfo info) { this.info = info; }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 72 */   public PlotRenderingInfo getInfo() { return this.info; }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public EntityCollection getEntityCollection() {
/* 83 */     EntityCollection result = null;
/* 84 */     if (this.info != null) {
/* 85 */       ChartRenderingInfo owner = this.info.getOwner();
/* 86 */       if (owner != null) {
/* 87 */         result = owner.getEntityCollection();
/*    */       }
/*    */     } 
/* 90 */     return result;
/*    */   }
/*    */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/renderer/RendererState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */