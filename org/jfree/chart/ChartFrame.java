/*    */ package org.jfree.chart;
/*    */ 
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JScrollPane;
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
/*    */ public class ChartFrame
/*    */   extends JFrame
/*    */ {
/*    */   private ChartPanel chartPanel;
/*    */   
/* 64 */   public ChartFrame(String title, JFreeChart chart) { this(title, chart, false); }
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
/*    */   public ChartFrame(String title, JFreeChart chart, boolean scrollPane) {
/* 76 */     super(title);
/* 77 */     setDefaultCloseOperation(2);
/* 78 */     this.chartPanel = new ChartPanel(chart);
/* 79 */     if (scrollPane) {
/* 80 */       setContentPane(new JScrollPane(this.chartPanel));
/*    */     } else {
/*    */       
/* 83 */       setContentPane(this.chartPanel);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 93 */   public ChartPanel getChartPanel() { return this.chartPanel; }
/*    */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/ChartFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */