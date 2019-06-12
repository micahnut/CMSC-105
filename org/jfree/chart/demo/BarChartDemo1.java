/*     */ package org.jfree.chart.demo;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import org.jfree.chart.ChartFactory;
/*     */ import org.jfree.chart.ChartPanel;
/*     */ import org.jfree.chart.JFreeChart;
/*     */ import org.jfree.chart.StandardChartTheme;
/*     */ import org.jfree.chart.axis.NumberAxis;
/*     */ import org.jfree.chart.block.BlockBorder;
/*     */ import org.jfree.chart.plot.CategoryPlot;
/*     */ import org.jfree.chart.renderer.category.BarRenderer;
/*     */ import org.jfree.chart.title.TextTitle;
/*     */ import org.jfree.data.category.CategoryDataset;
/*     */ import org.jfree.data.category.DefaultCategoryDataset;
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
/*     */ public class BarChartDemo1
/*     */   extends ApplicationFrame
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   static  {
/*  72 */     ChartFactory.setChartTheme(new StandardChartTheme("JFree/Shadow", true));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BarChartDemo1(String title) {
/*  82 */     super(title);
/*  83 */     CategoryDataset dataset = createDataset();
/*  84 */     JFreeChart chart = createChart(dataset);
/*  85 */     ChartPanel chartPanel = new ChartPanel(chart);
/*  86 */     chartPanel.setFillZoomRectangle(true);
/*  87 */     chartPanel.setMouseWheelEnabled(true);
/*  88 */     chartPanel.setPreferredSize(new Dimension('Ǵ', 'Ď'));
/*  89 */     setContentPane(chartPanel);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static CategoryDataset createDataset() {
/*  98 */     dataset = new DefaultCategoryDataset();
/*  99 */     dataset.addValue(7445.0D, "JFreeSVG", "Warm-up");
/* 100 */     dataset.addValue(24448.0D, "Batik", "Warm-up");
/* 101 */     dataset.addValue(4297.0D, "JFreeSVG", "Test");
/* 102 */     dataset.addValue(21022.0D, "Batik", "Test");
/* 103 */     return dataset;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static JFreeChart createChart(CategoryDataset dataset) {
/* 114 */     JFreeChart chart = ChartFactory.createBarChart("Performance: JFreeSVG vs Batik", null, "Milliseconds", dataset);
/*     */ 
/*     */     
/* 117 */     chart.addSubtitle(new TextTitle("Time to generate 1000 charts in SVG format (lower bars = better performance)"));
/*     */     
/* 119 */     chart.setBackgroundPaint(Color.white);
/* 120 */     CategoryPlot plot = (CategoryPlot)chart.getPlot();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 130 */     NumberAxis rangeAxis = (NumberAxis)plot.getRangeAxis();
/* 131 */     rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
/* 132 */     BarRenderer renderer = (BarRenderer)plot.getRenderer();
/* 133 */     renderer.setDrawBarOutline(false);
/* 134 */     chart.getLegend().setFrame(BlockBorder.NONE);
/* 135 */     return chart;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/* 144 */     BarChartDemo1 demo = new BarChartDemo1("JFreeChart: BarChartDemo1.java");
/* 145 */     demo.pack();
/* 146 */     RefineryUtilities.centerFrameOnScreen(demo);
/* 147 */     demo.setVisible(true);
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/demo/BarChartDemo1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */