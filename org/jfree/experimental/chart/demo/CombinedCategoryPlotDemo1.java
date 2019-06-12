/*     */ package org.jfree.experimental.chart.demo;
/*     */ 
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Font;
/*     */ import javax.swing.JPanel;
/*     */ import org.jfree.chart.ChartPanel;
/*     */ import org.jfree.chart.JFreeChart;
/*     */ import org.jfree.chart.axis.CategoryAxis;
/*     */ import org.jfree.chart.axis.NumberAxis;
/*     */ import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
/*     */ import org.jfree.chart.plot.CategoryPlot;
/*     */ import org.jfree.chart.renderer.category.BarRenderer;
/*     */ import org.jfree.chart.renderer.category.LineAndShapeRenderer;
/*     */ import org.jfree.data.category.CategoryDataset;
/*     */ import org.jfree.data.category.DefaultCategoryDataset;
/*     */ import org.jfree.experimental.chart.plot.CombinedCategoryPlot;
/*     */ import org.jfree.ui.ApplicationFrame;
/*     */ import org.jfree.ui.RefineryUtilities;
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
/*     */ public class CombinedCategoryPlotDemo1
/*     */   extends ApplicationFrame
/*     */ {
/*     */   public CombinedCategoryPlotDemo1(String title) {
/*  72 */     super(title);
/*  73 */     JPanel chartPanel = createDemoPanel();
/*  74 */     chartPanel.setPreferredSize(new Dimension('Ǵ', 'Ď'));
/*  75 */     setContentPane(chartPanel);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CategoryDataset createDataset1() {
/*  84 */     result = new DefaultCategoryDataset();
/*  85 */     String series1 = "First";
/*  86 */     String series2 = "Second";
/*  87 */     String type1 = "Type 1";
/*  88 */     String type2 = "Type 2";
/*  89 */     String type3 = "Type 3";
/*  90 */     String type4 = "Type 4";
/*  91 */     String type5 = "Type 5";
/*  92 */     String type6 = "Type 6";
/*  93 */     String type7 = "Type 7";
/*  94 */     String type8 = "Type 8";
/*     */     
/*  96 */     result.addValue(1.0D, series1, type1);
/*  97 */     result.addValue(4.0D, series1, type2);
/*  98 */     result.addValue(3.0D, series1, type3);
/*  99 */     result.addValue(5.0D, series1, type4);
/* 100 */     result.addValue(5.0D, series1, type5);
/* 101 */     result.addValue(7.0D, series1, type6);
/* 102 */     result.addValue(7.0D, series1, type7);
/* 103 */     result.addValue(8.0D, series1, type8);
/*     */     
/* 105 */     result.addValue(5.0D, series2, type1);
/* 106 */     result.addValue(7.0D, series2, type2);
/* 107 */     result.addValue(6.0D, series2, type3);
/* 108 */     result.addValue(8.0D, series2, type4);
/* 109 */     result.addValue(4.0D, series2, type5);
/* 110 */     result.addValue(4.0D, series2, type6);
/* 111 */     result.addValue(2.0D, series2, type7);
/* 112 */     result.addValue(1.0D, series2, type8);
/*     */     
/* 114 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CategoryDataset createDataset2() {
/* 124 */     result = new DefaultCategoryDataset();
/*     */     
/* 126 */     String series1 = "Third";
/* 127 */     String series2 = "Fourth";
/*     */     
/* 129 */     String type1 = "Type 1";
/* 130 */     String type2 = "Type 2";
/* 131 */     String type3 = "Type 3";
/* 132 */     String type4 = "Type 4";
/* 133 */     String type5 = "Type 5";
/* 134 */     String type6 = "Type 6";
/* 135 */     String type7 = "Type 7";
/* 136 */     String type8 = "Type 8";
/*     */     
/* 138 */     result.addValue(11.0D, series1, type1);
/* 139 */     result.addValue(14.0D, series1, type2);
/* 140 */     result.addValue(13.0D, series1, type3);
/* 141 */     result.addValue(15.0D, series1, type4);
/* 142 */     result.addValue(15.0D, series1, type5);
/* 143 */     result.addValue(17.0D, series1, type6);
/* 144 */     result.addValue(17.0D, series1, type7);
/* 145 */     result.addValue(18.0D, series1, type8);
/*     */     
/* 147 */     result.addValue(15.0D, series2, type1);
/* 148 */     result.addValue(17.0D, series2, type2);
/* 149 */     result.addValue(16.0D, series2, type3);
/* 150 */     result.addValue(18.0D, series2, type4);
/* 151 */     result.addValue(14.0D, series2, type5);
/* 152 */     result.addValue(14.0D, series2, type6);
/* 153 */     result.addValue(12.0D, series2, type7);
/* 154 */     result.addValue(11.0D, series2, type8);
/*     */     
/* 156 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static JFreeChart createChart() {
/* 167 */     dataset1 = createDataset1();
/* 168 */     NumberAxis rangeAxis1 = new NumberAxis("Value");
/* 169 */     rangeAxis1.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
/* 170 */     LineAndShapeRenderer renderer1 = new LineAndShapeRenderer();
/* 171 */     renderer1.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
/*     */     
/* 173 */     CategoryPlot subplot1 = new CategoryPlot(dataset1, null, rangeAxis1, renderer1);
/*     */     
/* 175 */     subplot1.setDomainGridlinesVisible(true);
/*     */     
/* 177 */     CategoryDataset dataset2 = createDataset2();
/* 178 */     NumberAxis rangeAxis2 = new NumberAxis("Value");
/* 179 */     rangeAxis2.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
/* 180 */     BarRenderer renderer2 = new BarRenderer();
/* 181 */     renderer2.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
/*     */     
/* 183 */     CategoryPlot subplot2 = new CategoryPlot(dataset2, null, rangeAxis2, renderer2);
/*     */     
/* 185 */     subplot2.setDomainGridlinesVisible(true);
/*     */     
/* 187 */     CategoryAxis domainAxis = new CategoryAxis("Category");
/* 188 */     CombinedCategoryPlot plot = new CombinedCategoryPlot(domainAxis, new NumberAxis("Range"));
/*     */     
/* 190 */     plot.add(subplot1, 2);
/* 191 */     plot.add(subplot2, 1);
/*     */     
/* 193 */     return new JFreeChart("Combined Domain Category Plot Demo", new Font("SansSerif", true, 12), plot, true);
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
/*     */   
/*     */   public static JPanel createDemoPanel() {
/* 206 */     chart = createChart();
/* 207 */     return new ChartPanel(chart);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/* 216 */     String title = "Combined Category Plot Demo 1";
/* 217 */     CombinedCategoryPlotDemo1 demo = new CombinedCategoryPlotDemo1(title);
/* 218 */     demo.pack();
/* 219 */     RefineryUtilities.centerFrameOnScreen(demo);
/* 220 */     demo.setVisible(true);
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/experimental/chart/demo/CombinedCategoryPlotDemo1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */