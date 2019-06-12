/*     */ package org.jfree.experimental.chart.swt.demo;
/*     */ 
/*     */ import org.eclipse.swt.layout.FillLayout;
/*     */ import org.eclipse.swt.widgets.Display;
/*     */ import org.eclipse.swt.widgets.Shell;
/*     */ import org.jfree.chart.ChartFactory;
/*     */ import org.jfree.chart.JFreeChart;
/*     */ import org.jfree.chart.axis.CategoryAxis;
/*     */ import org.jfree.chart.axis.CategoryLabelPositions;
/*     */ import org.jfree.chart.axis.NumberAxis;
/*     */ import org.jfree.chart.plot.CategoryPlot;
/*     */ import org.jfree.chart.plot.PlotOrientation;
/*     */ import org.jfree.chart.renderer.category.BarRenderer;
/*     */ import org.jfree.chart.renderer.category.StandardBarPainter;
/*     */ import org.jfree.data.category.CategoryDataset;
/*     */ import org.jfree.data.category.DefaultCategoryDataset;
/*     */ import org.jfree.experimental.chart.swt.ChartComposite;
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
/*     */ public class SWTBarChartDemo1
/*     */ {
/*     */   private static CategoryDataset createDataset() {
/*  73 */     series1 = "First";
/*  74 */     String series2 = "Second";
/*  75 */     String series3 = "Third";
/*     */ 
/*     */     
/*  78 */     String category1 = "Category 1";
/*  79 */     String category2 = "Category 2";
/*  80 */     String category3 = "Category 3";
/*  81 */     String category4 = "Category 4";
/*  82 */     String category5 = "Category 5";
/*     */ 
/*     */     
/*  85 */     DefaultCategoryDataset dataset = new DefaultCategoryDataset();
/*     */     
/*  87 */     dataset.addValue(1.0D, series1, category1);
/*  88 */     dataset.addValue(4.0D, series1, category2);
/*  89 */     dataset.addValue(3.0D, series1, category3);
/*  90 */     dataset.addValue(5.0D, series1, category4);
/*  91 */     dataset.addValue(5.0D, series1, category5);
/*     */     
/*  93 */     dataset.addValue(5.0D, series2, category1);
/*  94 */     dataset.addValue(7.0D, series2, category2);
/*  95 */     dataset.addValue(6.0D, series2, category3);
/*  96 */     dataset.addValue(8.0D, series2, category4);
/*  97 */     dataset.addValue(4.0D, series2, category5);
/*     */     
/*  99 */     dataset.addValue(4.0D, series3, category1);
/* 100 */     dataset.addValue(3.0D, series3, category2);
/* 101 */     dataset.addValue(2.0D, series3, category3);
/* 102 */     dataset.addValue(3.0D, series3, category4);
/* 103 */     dataset.addValue(6.0D, series3, category5);
/*     */     
/* 105 */     return dataset;
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
/*     */   
/*     */   private static JFreeChart createChart(CategoryDataset dataset) {
/* 119 */     JFreeChart chart = ChartFactory.createBarChart("SWTBarChartDemo1", "Category", "Value", dataset, PlotOrientation.VERTICAL, true, true, false);
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
/* 133 */     CategoryPlot plot = (CategoryPlot)chart.getPlot();
/*     */ 
/*     */     
/* 136 */     NumberAxis rangeAxis = (NumberAxis)plot.getRangeAxis();
/* 137 */     rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
/*     */ 
/*     */     
/* 140 */     BarRenderer renderer = (BarRenderer)plot.getRenderer();
/* 141 */     renderer.setDrawBarOutline(false);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 146 */     renderer.setBarPainter(new StandardBarPainter());
/*     */     
/* 148 */     CategoryAxis domainAxis = plot.getDomainAxis();
/* 149 */     domainAxis.setCategoryLabelPositions(
/* 150 */         CategoryLabelPositions.createUpRotationLabelPositions(0.5235987755982988D));
/*     */ 
/*     */ 
/*     */     
/* 154 */     return chart;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/* 164 */     JFreeChart chart = createChart(createDataset());
/* 165 */     Display display = new Display();
/* 166 */     Shell shell = new Shell(display);
/* 167 */     shell.setSize(600, 300);
/* 168 */     shell.setLayout(new FillLayout());
/* 169 */     shell.setText("Test for jfreechart running with SWT");
/* 170 */     ChartComposite frame = new ChartComposite(shell, false, chart, true);
/*     */     
/* 172 */     frame.pack();
/* 173 */     shell.open();
/* 174 */     while (!shell.isDisposed()) {
/* 175 */       if (!display.readAndDispatch())
/* 176 */         display.sleep(); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/experimental/chart/swt/demo/SWTBarChartDemo1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */