/*     */ package org.jfree.experimental.chart.swt.demo;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import javax.swing.JPanel;
/*     */ import org.eclipse.swt.layout.FillLayout;
/*     */ import org.eclipse.swt.widgets.Display;
/*     */ import org.eclipse.swt.widgets.Shell;
/*     */ import org.jfree.chart.ChartFactory;
/*     */ import org.jfree.chart.ChartPanel;
/*     */ import org.jfree.chart.JFreeChart;
/*     */ import org.jfree.chart.axis.AxisLocation;
/*     */ import org.jfree.chart.axis.NumberAxis;
/*     */ import org.jfree.chart.plot.PlotOrientation;
/*     */ import org.jfree.chart.plot.XYPlot;
/*     */ import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
/*     */ import org.jfree.chart.renderer.xy.XYItemRenderer;
/*     */ import org.jfree.chart.title.TextTitle;
/*     */ import org.jfree.data.time.Minute;
/*     */ import org.jfree.data.time.RegularTimePeriod;
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
/*     */ public class SWTMultipleAxisDemo1
/*     */ {
/*     */   private static JFreeChart createChart() {
/*  81 */     dataset1 = createDataset("Series 1", 100.0D, new Minute(), 200);
/*     */ 
/*     */     
/*  84 */     JFreeChart chart = ChartFactory.createTimeSeriesChart("Multiple Axis Demo 3", "Time of Day", "Primary Range Axis", dataset1, true, true, false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  94 */     chart.setBackgroundPaint(Color.white);
/*  95 */     chart.setBorderVisible(true);
/*  96 */     chart.setBorderPaint(Color.BLACK);
/*  97 */     TextTitle subtitle = new TextTitle("Four datasets and four range axes.");
/*  98 */     chart.addSubtitle(subtitle);
/*  99 */     XYPlot plot = (XYPlot)chart.getPlot();
/* 100 */     plot.setOrientation(PlotOrientation.VERTICAL);
/* 101 */     plot.setBackgroundPaint(Color.lightGray);
/* 102 */     plot.setDomainGridlinePaint(Color.white);
/* 103 */     plot.setRangeGridlinePaint(Color.white);
/*     */     
/* 105 */     plot.setAxisOffset(new RectangleInsets(5.0D, 5.0D, 5.0D, 5.0D));
/* 106 */     XYItemRenderer renderer = plot.getRenderer();
/* 107 */     renderer.setSeriesPaint(0, Color.black);
/*     */ 
/*     */     
/* 110 */     NumberAxis axis2 = new NumberAxis("Range Axis 2");
/* 111 */     axis2.setAutoRangeIncludesZero(false);
/* 112 */     axis2.setLabelPaint(Color.red);
/* 113 */     axis2.setTickLabelPaint(Color.red);
/* 114 */     plot.setRangeAxis(1, axis2);
/* 115 */     plot.setRangeAxisLocation(1, AxisLocation.BOTTOM_OR_LEFT);
/*     */     
/* 117 */     XYDataset dataset2 = createDataset("Series 2", 1000.0D, new Minute(), 170);
/*     */     
/* 119 */     plot.setDataset(1, dataset2);
/* 120 */     plot.mapDatasetToRangeAxis(1, 1);
/* 121 */     StandardXYItemRenderer standardXYItemRenderer1 = new StandardXYItemRenderer();
/* 122 */     standardXYItemRenderer1.setSeriesPaint(0, Color.red);
/* 123 */     plot.setRenderer(1, standardXYItemRenderer1);
/*     */ 
/*     */     
/* 126 */     NumberAxis axis3 = new NumberAxis("Range Axis 3");
/* 127 */     axis3.setLabelPaint(Color.blue);
/* 128 */     axis3.setTickLabelPaint(Color.blue);
/*     */     
/* 130 */     plot.setRangeAxis(2, axis3);
/*     */     
/* 132 */     XYDataset dataset3 = createDataset("Series 3", 10000.0D, new Minute(), 170);
/*     */     
/* 134 */     plot.setDataset(2, dataset3);
/* 135 */     plot.mapDatasetToRangeAxis(2, 2);
/* 136 */     StandardXYItemRenderer standardXYItemRenderer2 = new StandardXYItemRenderer();
/* 137 */     standardXYItemRenderer2.setSeriesPaint(0, Color.blue);
/* 138 */     plot.setRenderer(2, standardXYItemRenderer2);
/*     */ 
/*     */     
/* 141 */     NumberAxis axis4 = new NumberAxis("Range Axis 4");
/* 142 */     axis4.setLabelPaint(Color.green);
/* 143 */     axis4.setTickLabelPaint(Color.green);
/* 144 */     plot.setRangeAxis(3, axis4);
/*     */     
/* 146 */     XYDataset dataset4 = createDataset("Series 4", 25.0D, new Minute(), 200);
/* 147 */     plot.setDataset(3, dataset4);
/* 148 */     plot.mapDatasetToRangeAxis(3, 3);
/*     */     
/* 150 */     StandardXYItemRenderer standardXYItemRenderer3 = new StandardXYItemRenderer();
/* 151 */     standardXYItemRenderer3.setSeriesPaint(0, Color.green);
/* 152 */     plot.setRenderer(3, standardXYItemRenderer3);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static XYDataset createDataset(String name, double base, RegularTimePeriod start, int count) {
/* 170 */     TimeSeries series = new TimeSeries(name);
/* 171 */     RegularTimePeriod period = start;
/* 172 */     double value = base;
/* 173 */     for (int i = 0; i < count; i++) {
/* 174 */       series.add(period, value);
/* 175 */       period = period.next();
/* 176 */       value *= (1.0D + (Math.random() - 0.495D) / 10.0D);
/*     */     } 
/*     */     
/* 179 */     TimeSeriesCollection dataset = new TimeSeriesCollection();
/* 180 */     dataset.addSeries(series);
/*     */     
/* 182 */     return dataset;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JPanel createDemoPanel() {
/* 192 */     chart = createChart();
/* 193 */     return new ChartPanel(chart);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/* 203 */     JFreeChart chart = createChart();
/* 204 */     Display display = new Display();
/* 205 */     Shell shell = new Shell(display);
/* 206 */     shell.setSize(600, 300);
/* 207 */     shell.setLayout(new FillLayout());
/* 208 */     shell.setText("Test for jfreechart running with SWT");
/* 209 */     ChartComposite frame = new ChartComposite(shell, false, chart, true);
/* 210 */     frame.setDisplayToolTips(false);
/* 211 */     frame.setHorizontalAxisTrace(true);
/* 212 */     frame.setVerticalAxisTrace(true);
/* 213 */     shell.open();
/* 214 */     while (!shell.isDisposed()) {
/* 215 */       if (!display.readAndDispatch())
/* 216 */         display.sleep(); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/experimental/chart/swt/demo/SWTMultipleAxisDemo1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */