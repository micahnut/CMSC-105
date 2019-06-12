/*     */ package org.jfree.experimental.chart.swt.demo;
/*     */ 
/*     */ import java.awt.Font;
/*     */ import org.eclipse.swt.layout.FillLayout;
/*     */ import org.eclipse.swt.widgets.Display;
/*     */ import org.eclipse.swt.widgets.Shell;
/*     */ import org.jfree.chart.ChartFactory;
/*     */ import org.jfree.chart.JFreeChart;
/*     */ import org.jfree.chart.plot.PiePlot;
/*     */ import org.jfree.data.general.DefaultPieDataset;
/*     */ import org.jfree.data.general.PieDataset;
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
/*     */ public class SWTPieChartDemo1
/*     */ {
/*     */   private static PieDataset createDataset() {
/*  67 */     dataset = new DefaultPieDataset();
/*  68 */     dataset.setValue("One", new Double(43.2D));
/*  69 */     dataset.setValue("Two", new Double(10.0D));
/*  70 */     dataset.setValue("Three", new Double(27.5D));
/*  71 */     dataset.setValue("Four", new Double(17.5D));
/*  72 */     dataset.setValue("Five", new Double(11.0D));
/*  73 */     dataset.setValue("Six", new Double(19.4D));
/*  74 */     return dataset;
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
/*     */   private static JFreeChart createChart(PieDataset dataset) {
/*  86 */     JFreeChart chart = ChartFactory.createPieChart("Pie Chart Demo 1", dataset, true, true, false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  94 */     PiePlot plot = (PiePlot)chart.getPlot();
/*  95 */     plot.setSectionOutlinesVisible(false);
/*  96 */     plot.setLabelFont(new Font("SansSerif", false, 12));
/*  97 */     plot.setNoDataMessage("No data available");
/*  98 */     plot.setCircular(false);
/*  99 */     plot.setLabelGap(0.02D);
/* 100 */     return chart;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/* 111 */     JFreeChart chart = createChart(createDataset());
/* 112 */     Display display = new Display();
/* 113 */     Shell shell = new Shell(display);
/* 114 */     shell.setSize(600, 400);
/* 115 */     shell.setLayout(new FillLayout());
/* 116 */     shell.setText("Test for jfreechart running with SWT");
/* 117 */     ChartComposite frame = new ChartComposite(shell, false, chart, true);
/*     */     
/* 119 */     frame.pack();
/* 120 */     shell.open();
/* 121 */     while (!shell.isDisposed()) {
/* 122 */       if (!display.readAndDispatch())
/* 123 */         display.sleep(); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/experimental/chart/swt/demo/SWTPieChartDemo1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */