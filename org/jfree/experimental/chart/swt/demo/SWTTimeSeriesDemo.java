/*     */ package org.jfree.experimental.chart.swt.demo;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.text.SimpleDateFormat;
/*     */ import org.eclipse.swt.layout.FillLayout;
/*     */ import org.eclipse.swt.widgets.Display;
/*     */ import org.eclipse.swt.widgets.Shell;
/*     */ import org.jfree.chart.ChartFactory;
/*     */ import org.jfree.chart.JFreeChart;
/*     */ import org.jfree.chart.axis.DateAxis;
/*     */ import org.jfree.chart.plot.XYPlot;
/*     */ import org.jfree.chart.renderer.xy.XYItemRenderer;
/*     */ import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
/*     */ import org.jfree.data.time.Month;
/*     */ import org.jfree.data.time.TimeSeries;
/*     */ import org.jfree.data.time.TimeSeriesCollection;
/*     */ import org.jfree.data.xy.XYDataset;
/*     */ import org.jfree.experimental.chart.swt.ChartComposite;
/*     */ import org.jfree.ui.RectangleInsets;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SWTTimeSeriesDemo
/*     */ {
/*     */   private static JFreeChart createChart(XYDataset dataset) {
/*  79 */     JFreeChart chart = ChartFactory.createTimeSeriesChart("Legal & General Unit Trust Prices", "Date", "Price Per Unit", dataset, true, true, false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  89 */     chart.setBackgroundPaint(Color.white);
/*     */     
/*  91 */     XYPlot plot = (XYPlot)chart.getPlot();
/*  92 */     plot.setBackgroundPaint(Color.lightGray);
/*  93 */     plot.setDomainGridlinePaint(Color.white);
/*  94 */     plot.setRangeGridlinePaint(Color.white);
/*  95 */     plot.setAxisOffset(new RectangleInsets(5.0D, 5.0D, 5.0D, 5.0D));
/*  96 */     plot.setDomainCrosshairVisible(true);
/*  97 */     plot.setRangeCrosshairVisible(true);
/*     */     
/*  99 */     XYItemRenderer r = plot.getRenderer();
/* 100 */     if (r instanceof XYLineAndShapeRenderer) {
/* 101 */       XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer)r;
/* 102 */       renderer.setBaseShapesVisible(true);
/* 103 */       renderer.setBaseShapesFilled(true);
/*     */     } 
/*     */     
/* 106 */     DateAxis axis = (DateAxis)plot.getDomainAxis();
/* 107 */     axis.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"));
/*     */     
/* 109 */     return chart;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static XYDataset createDataset() {
/* 120 */     s1 = new TimeSeries("L&G European Index Trust");
/* 121 */     s1.add(new Month(2, 'ߑ'), 181.8D);
/* 122 */     s1.add(new Month(3, 'ߑ'), 167.3D);
/* 123 */     s1.add(new Month(4, 'ߑ'), 153.8D);
/* 124 */     s1.add(new Month(5, 'ߑ'), 167.6D);
/* 125 */     s1.add(new Month(6, 'ߑ'), 158.8D);
/* 126 */     s1.add(new Month(7, 'ߑ'), 148.3D);
/* 127 */     s1.add(new Month(8, 'ߑ'), 153.9D);
/* 128 */     s1.add(new Month(9, 'ߑ'), 142.7D);
/* 129 */     s1.add(new Month(10, 'ߑ'), 123.2D);
/* 130 */     s1.add(new Month(11, 'ߑ'), 131.8D);
/* 131 */     s1.add(new Month(12, 'ߑ'), 139.6D);
/* 132 */     s1.add(new Month(true, 'ߒ'), 142.9D);
/* 133 */     s1.add(new Month(2, 'ߒ'), 138.7D);
/* 134 */     s1.add(new Month(3, 'ߒ'), 137.3D);
/* 135 */     s1.add(new Month(4, 'ߒ'), 143.9D);
/* 136 */     s1.add(new Month(5, 'ߒ'), 139.8D);
/* 137 */     s1.add(new Month(6, 'ߒ'), 137.0D);
/* 138 */     s1.add(new Month(7, 'ߒ'), 132.8D);
/*     */     
/* 140 */     TimeSeries s2 = new TimeSeries("L&G UK Index Trust");
/* 141 */     s2.add(new Month(2, 'ߑ'), 129.6D);
/* 142 */     s2.add(new Month(3, 'ߑ'), 123.2D);
/* 143 */     s2.add(new Month(4, 'ߑ'), 117.2D);
/* 144 */     s2.add(new Month(5, 'ߑ'), 124.1D);
/* 145 */     s2.add(new Month(6, 'ߑ'), 122.6D);
/* 146 */     s2.add(new Month(7, 'ߑ'), 119.2D);
/* 147 */     s2.add(new Month(8, 'ߑ'), 116.5D);
/* 148 */     s2.add(new Month(9, 'ߑ'), 112.7D);
/* 149 */     s2.add(new Month(10, 'ߑ'), 101.5D);
/* 150 */     s2.add(new Month(11, 'ߑ'), 106.1D);
/* 151 */     s2.add(new Month(12, 'ߑ'), 110.3D);
/* 152 */     s2.add(new Month(true, 'ߒ'), 111.7D);
/* 153 */     s2.add(new Month(2, 'ߒ'), 111.0D);
/* 154 */     s2.add(new Month(3, 'ߒ'), 109.6D);
/* 155 */     s2.add(new Month(4, 'ߒ'), 113.2D);
/* 156 */     s2.add(new Month(5, 'ߒ'), 111.6D);
/* 157 */     s2.add(new Month(6, 'ߒ'), 108.8D);
/* 158 */     s2.add(new Month(7, 'ߒ'), 101.6D);
/*     */     
/* 160 */     TimeSeriesCollection dataset = new TimeSeriesCollection();
/* 161 */     dataset.addSeries(s1);
/* 162 */     dataset.addSeries(s2);
/*     */     
/* 164 */     return dataset;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/* 173 */     JFreeChart chart = createChart(createDataset());
/* 174 */     Display display = new Display();
/* 175 */     Shell shell = new Shell(display);
/* 176 */     shell.setSize(600, 300);
/* 177 */     shell.setLayout(new FillLayout());
/* 178 */     shell.setText("Time series demo for jfreechart running with SWT");
/* 179 */     ChartComposite frame = new ChartComposite(shell, false, chart, true);
/* 180 */     frame.setDisplayToolTips(true);
/* 181 */     frame.setHorizontalAxisTrace(false);
/* 182 */     frame.setVerticalAxisTrace(false);
/* 183 */     shell.open();
/* 184 */     while (!shell.isDisposed()) {
/* 185 */       if (!display.readAndDispatch())
/* 186 */         display.sleep(); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/experimental/chart/swt/demo/SWTTimeSeriesDemo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */