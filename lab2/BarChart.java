/*    */ package lab2;
/*    */ import java.awt.Dimension;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import java.text.DecimalFormat;
/*    */ import javax.swing.JFrame;
/*    */ import org.jfree.chart.ChartFactory;
/*    */ import org.jfree.chart.ChartPanel;
/*    */ import org.jfree.chart.JFreeChart;
/*    */ import org.jfree.chart.axis.CategoryAxis;
/*    */ import org.jfree.chart.plot.CategoryPlot;
/*    */ import org.jfree.chart.plot.PlotOrientation;
/*    */ import org.jfree.chart.renderer.category.BarRenderer;
/*    */ import org.jfree.data.category.CategoryDataset;
/*    */ import org.jfree.data.category.DefaultCategoryDataset;
/*    */ 
/*    */ public class BarChart extends JFrame implements ActionListener {
/*    */   public BarChart(String title, int[] freq, double[] cl, boolean core, int coll, DecimalFormat df) {
/* 19 */     super(title);
/* 20 */     CategoryDataset dataset = createDataset(freq, cl, core, coll, df);
/* 21 */     JFreeChart chart = createChart(dataset, title);
/* 22 */     ChartPanel chartPanel = new ChartPanel(chart);
/* 23 */     chartPanel.setPreferredSize(new Dimension('̠', 'Ɛ'));
/* 24 */     setContentPane(chartPanel);
/*    */   }
/*    */   
/*    */   private CategoryDataset createDataset(int[] freq, double[] cl, boolean core, int coll, DecimalFormat df) {
/* 28 */     DefaultCategoryDataset series = new DefaultCategoryDataset();
/* 29 */     for (int i = 0; i < freq.length; i++) {
/* 30 */       if (core) {
/* 31 */         if (coll == 1) {
/* 32 */           if (i == 0) {
/* 33 */             series.addValue(freq[i], "Frequency", "*-");
/*    */           } else {
/*    */             
/* 36 */             series.addValue(freq[i], "Frequency", String.valueOf(df.format(cl[i])));
/*    */           }
/*    */         
/*    */         }
/* 40 */         else if (i == freq.length - 1) {
/* 41 */           series.addValue(freq[i], "Frequency", "-*");
/*    */         } else {
/*    */           
/* 44 */           series.addValue(freq[i], "Frequency", String.valueOf(df.format(cl[i])));
/*    */         }
/*    */       
/*    */       } else {
/*    */         
/* 49 */         series.addValue(freq[i], "Frequency", String.valueOf(df.format(cl[i])));
/*    */       } 
/*    */     } 
/*    */     
/* 53 */     return series;
/*    */   }
/*    */   
/*    */   private JFreeChart createChart(CategoryDataset dataset, String title) {
/* 57 */     JFreeChart chart = ChartFactory.createBarChart(title, "Midpoints", "Frequency", dataset, PlotOrientation.VERTICAL, false, true, false);
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
/* 68 */     CategoryPlot p = chart.getCategoryPlot();
/* 69 */     CategoryAxis axis = p.getDomainAxis();
/* 70 */     axis.setLowerMargin(0.1D);
/* 71 */     axis.setUpperMargin(0.1D);
/* 72 */     axis.setCategoryMargin(0.0D);
/* 73 */     BarRenderer renderer = (BarRenderer)p.getRenderer();
/* 74 */     renderer.setItemMargin(0.1D);
/* 75 */     return chart;
/*    */   }
/*    */   
/*    */   public void actionPerformed(ActionEvent e) {}
/*    */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/lab2/BarChart.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.3
 */