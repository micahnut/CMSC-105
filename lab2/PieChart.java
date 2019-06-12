/*    */ package lab2;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JPanel;
/*    */ import org.jfree.chart.ChartFactory;
/*    */ import org.jfree.chart.ChartPanel;
/*    */ import org.jfree.chart.JFreeChart;
/*    */ import org.jfree.data.general.DefaultPieDataset;
/*    */ import org.jfree.data.general.PieDataset;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PieChart
/*    */   extends JFrame
/*    */ {
/*    */   ArrayList<Cat> x;
/*    */   String t;
/*    */   
/*    */   public PieChart(String title, ArrayList<Cat> val) {
/* 22 */     super("Pie Chart");
/* 23 */     this.t = title;
/* 24 */     this.x = val;
/* 25 */     setContentPane(createPanel());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private JPanel createPanel() {
/* 31 */     JFreeChart chart = createChart(createDataset(this.x));
/* 32 */     return new ChartPanel(chart);
/*    */   }
/*    */   
/*    */   private JFreeChart createChart(Object createDataset) {
/* 36 */     return ChartFactory.createPieChart(this.t, (PieDataset)
/* 37 */         createDataset(this.x), true, true, false);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private Object createDataset(ArrayList<Cat> val) {
/* 47 */     DefaultPieDataset dataset = new DefaultPieDataset();
/* 48 */     for (Cat c : val) {
/* 49 */       dataset.setValue(c.description, c.tPercentage());
/*    */     }
/*    */ 
/*    */     
/* 53 */     return dataset;
/*    */   }
/*    */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/lab2/PieChart.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.3
 */