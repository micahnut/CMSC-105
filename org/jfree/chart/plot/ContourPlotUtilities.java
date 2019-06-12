/*    */ package org.jfree.chart.plot;
/*    */ 
/*    */ import org.jfree.data.Range;
/*    */ import org.jfree.data.contour.ContourDataset;
/*    */ import org.jfree.data.contour.DefaultContourDataset;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class ContourPlotUtilities
/*    */ {
/*    */   public static Range visibleRange(ContourDataset data, Range x, Range y) {
/* 71 */     range = null;
/* 72 */     return ((DefaultContourDataset)data).getZValueRange(x, y);
/*    */   }
/*    */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/plot/ContourPlotUtilities.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */