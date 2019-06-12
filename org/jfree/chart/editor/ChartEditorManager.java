/*    */ package org.jfree.chart.editor;
/*    */ 
/*    */ import org.jfree.chart.JFreeChart;
/*    */ import org.jfree.chart.util.ParamChecks;
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
/*    */ public class ChartEditorManager
/*    */ {
/* 56 */   static ChartEditorFactory factory = new DefaultChartEditorFactory();
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
/* 71 */   public static ChartEditorFactory getChartEditorFactory() { return factory; }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void setChartEditorFactory(ChartEditorFactory f) {
/* 80 */     ParamChecks.nullNotPermitted(f, "f");
/* 81 */     factory = f;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 92 */   public static ChartEditor getChartEditor(JFreeChart chart) { return factory.createEditor(chart); }
/*    */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/editor/ChartEditorManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */