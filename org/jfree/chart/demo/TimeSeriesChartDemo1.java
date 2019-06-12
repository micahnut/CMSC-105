/*     */ package org.jfree.chart.demo;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.text.SimpleDateFormat;
/*     */ import javax.swing.JPanel;
/*     */ import org.jfree.chart.ChartFactory;
/*     */ import org.jfree.chart.ChartPanel;
/*     */ import org.jfree.chart.JFreeChart;
/*     */ import org.jfree.chart.StandardChartTheme;
/*     */ import org.jfree.chart.axis.DateAxis;
/*     */ import org.jfree.chart.plot.XYPlot;
/*     */ import org.jfree.chart.renderer.xy.XYItemRenderer;
/*     */ import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
/*     */ import org.jfree.data.time.Month;
/*     */ import org.jfree.data.time.TimeSeries;
/*     */ import org.jfree.data.time.TimeSeriesCollection;
/*     */ import org.jfree.data.xy.XYDataset;
/*     */ import org.jfree.ui.ApplicationFrame;
/*     */ import org.jfree.ui.RectangleInsets;
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
/*     */ public class TimeSeriesChartDemo1
/*     */   extends ApplicationFrame
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   static  {
/*  77 */     ChartFactory.setChartTheme(new StandardChartTheme("JFree/Shadow", true));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TimeSeriesChartDemo1(String title) {
/*  88 */     super(title);
/*  89 */     ChartPanel chartPanel = (ChartPanel)createDemoPanel();
/*  90 */     chartPanel.setPreferredSize(new Dimension('Ǵ', 'Ď'));
/*  91 */     setContentPane(chartPanel);
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
/*     */   private static JFreeChart createChart(XYDataset dataset) {
/* 103 */     JFreeChart chart = ChartFactory.createTimeSeriesChart("Legal & General Unit Trust Prices", "Date", "Price Per Unit", dataset, true, true, false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 113 */     chart.setBackgroundPaint(Color.white);
/*     */     
/* 115 */     XYPlot plot = (XYPlot)chart.getPlot();
/* 116 */     plot.setBackgroundPaint(Color.lightGray);
/* 117 */     plot.setDomainGridlinePaint(Color.white);
/* 118 */     plot.setRangeGridlinePaint(Color.white);
/* 119 */     plot.setAxisOffset(new RectangleInsets(5.0D, 5.0D, 5.0D, 5.0D));
/* 120 */     plot.setDomainCrosshairVisible(true);
/* 121 */     plot.setRangeCrosshairVisible(true);
/*     */     
/* 123 */     XYItemRenderer r = plot.getRenderer();
/* 124 */     if (r instanceof XYLineAndShapeRenderer) {
/* 125 */       XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer)r;
/* 126 */       renderer.setBaseShapesVisible(true);
/* 127 */       renderer.setBaseShapesFilled(true);
/* 128 */       renderer.setDrawSeriesLineAsPath(true);
/*     */     } 
/*     */     
/* 131 */     DateAxis axis = (DateAxis)plot.getDomainAxis();
/* 132 */     axis.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"));
/*     */     
/* 134 */     return chart;
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
/* 145 */     s1 = new TimeSeries("L&G European Index Trust");
/* 146 */     s1.add(new Month(2, 'ߑ'), 181.8D);
/* 147 */     s1.add(new Month(3, 'ߑ'), 167.3D);
/* 148 */     s1.add(new Month(4, 'ߑ'), 153.8D);
/* 149 */     s1.add(new Month(5, 'ߑ'), 167.6D);
/* 150 */     s1.add(new Month(6, 'ߑ'), 158.8D);
/* 151 */     s1.add(new Month(7, 'ߑ'), 148.3D);
/* 152 */     s1.add(new Month(8, 'ߑ'), 153.9D);
/* 153 */     s1.add(new Month(9, 'ߑ'), 142.7D);
/* 154 */     s1.add(new Month(10, 'ߑ'), 123.2D);
/* 155 */     s1.add(new Month(11, 'ߑ'), 131.8D);
/* 156 */     s1.add(new Month(12, 'ߑ'), 139.6D);
/* 157 */     s1.add(new Month(true, 'ߒ'), 142.9D);
/* 158 */     s1.add(new Month(2, 'ߒ'), 138.7D);
/* 159 */     s1.add(new Month(3, 'ߒ'), 137.3D);
/* 160 */     s1.add(new Month(4, 'ߒ'), 143.9D);
/* 161 */     s1.add(new Month(5, 'ߒ'), 139.8D);
/* 162 */     s1.add(new Month(6, 'ߒ'), 137.0D);
/* 163 */     s1.add(new Month(7, 'ߒ'), 132.8D);
/*     */     
/* 165 */     TimeSeries s2 = new TimeSeries("L&G UK Index Trust");
/* 166 */     s2.add(new Month(2, 'ߑ'), 129.6D);
/* 167 */     s2.add(new Month(3, 'ߑ'), 123.2D);
/* 168 */     s2.add(new Month(4, 'ߑ'), 117.2D);
/* 169 */     s2.add(new Month(5, 'ߑ'), 124.1D);
/* 170 */     s2.add(new Month(6, 'ߑ'), 122.6D);
/* 171 */     s2.add(new Month(7, 'ߑ'), 119.2D);
/* 172 */     s2.add(new Month(8, 'ߑ'), 116.5D);
/* 173 */     s2.add(new Month(9, 'ߑ'), 112.7D);
/* 174 */     s2.add(new Month(10, 'ߑ'), 101.5D);
/* 175 */     s2.add(new Month(11, 'ߑ'), 106.1D);
/* 176 */     s2.add(new Month(12, 'ߑ'), 110.3D);
/* 177 */     s2.add(new Month(true, 'ߒ'), 111.7D);
/* 178 */     s2.add(new Month(2, 'ߒ'), 111.0D);
/* 179 */     s2.add(new Month(3, 'ߒ'), 109.6D);
/* 180 */     s2.add(new Month(4, 'ߒ'), 113.2D);
/* 181 */     s2.add(new Month(5, 'ߒ'), 111.6D);
/* 182 */     s2.add(new Month(6, 'ߒ'), 108.8D);
/* 183 */     s2.add(new Month(7, 'ߒ'), 101.6D);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 193 */     TimeSeriesCollection dataset = new TimeSeriesCollection();
/* 194 */     dataset.addSeries(s1);
/* 195 */     dataset.addSeries(s2);
/*     */     
/* 197 */     return dataset;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JPanel createDemoPanel() {
/* 207 */     chart = createChart(createDataset());
/* 208 */     ChartPanel panel = new ChartPanel(chart);
/* 209 */     panel.setFillZoomRectangle(true);
/* 210 */     panel.setMouseWheelEnabled(true);
/* 211 */     return panel;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/* 221 */     TimeSeriesChartDemo1 demo = new TimeSeriesChartDemo1("Time Series Chart Demo 1");
/*     */     
/* 223 */     demo.pack();
/* 224 */     RefineryUtilities.centerFrameOnScreen(demo);
/* 225 */     demo.setVisible(true);
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/demo/TimeSeriesChartDemo1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */