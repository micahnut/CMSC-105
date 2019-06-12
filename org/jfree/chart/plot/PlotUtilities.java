/*    */ package org.jfree.chart.plot;
/*    */ 
/*    */ import org.jfree.data.general.DatasetUtilities;
/*    */ import org.jfree.data.xy.XYDataset;
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
/*    */ public class PlotUtilities
/*    */ {
/*    */   public static boolean isEmptyOrNull(XYPlot plot) {
/* 65 */     if (plot != null) {
/* 66 */       for (int i = 0, n = plot.getDatasetCount(); i < n; i++) {
/* 67 */         XYDataset dataset = plot.getDataset(i);
/* 68 */         if (!DatasetUtilities.isEmptyOrNull(dataset)) {
/* 69 */           return false;
/*    */         }
/*    */       } 
/*    */     }
/* 73 */     return true;
/*    */   }
/*    */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/plot/PlotUtilities.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */