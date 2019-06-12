/*     */ package org.jfree.experimental.chart.demo;
/*     */ 
/*     */ import java.awt.BasicStroke;
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Paint;
/*     */ import java.text.DecimalFormat;
/*     */ import java.text.SimpleDateFormat;
/*     */ import javax.swing.JPanel;
/*     */ import org.jfree.chart.ChartPanel;
/*     */ import org.jfree.chart.JFreeChart;
/*     */ import org.jfree.chart.axis.DateAxis;
/*     */ import org.jfree.chart.axis.NumberAxis;
/*     */ import org.jfree.chart.labels.StandardXYToolTipGenerator;
/*     */ import org.jfree.chart.plot.XYPlot;
/*     */ import org.jfree.chart.renderer.xy.XYBarRenderer;
/*     */ import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
/*     */ import org.jfree.chart.title.LegendTitle;
/*     */ import org.jfree.data.time.Month;
/*     */ import org.jfree.data.time.TimeSeries;
/*     */ import org.jfree.data.time.TimeSeriesCollection;
/*     */ import org.jfree.data.xy.IntervalXYDataset;
/*     */ import org.jfree.data.xy.XYDataset;
/*     */ import org.jfree.experimental.chart.plot.CombinedXYPlot;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CombinedXYPlotDemo1
/*     */   extends ApplicationFrame
/*     */ {
/*     */   public CombinedXYPlotDemo1(String title) {
/*  83 */     super(title);
/*  84 */     JPanel panel = createDemoPanel();
/*  85 */     panel.setPreferredSize(new Dimension('Ǵ', 'Ď'));
/*  86 */     setContentPane(panel);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static JFreeChart createCombinedChart() {
/*  97 */     data1 = createDataset1();
/*  98 */     XYLineAndShapeRenderer xYLineAndShapeRenderer = new XYLineAndShapeRenderer(true, false);
/*  99 */     xYLineAndShapeRenderer.setBaseToolTipGenerator(new StandardXYToolTipGenerator("{0}: ({1}, {2})", new SimpleDateFormat("d-MMM-yyyy"), new DecimalFormat("0.00")));
/*     */ 
/*     */     
/* 102 */     xYLineAndShapeRenderer.setSeriesStroke(0, new BasicStroke(4.0F, true, 2));
/*     */     
/* 104 */     xYLineAndShapeRenderer.setSeriesPaint(0, Color.blue);
/*     */     
/* 106 */     DateAxis domainAxis = new DateAxis("Year");
/* 107 */     domainAxis.setLowerMargin(0.0D);
/* 108 */     domainAxis.setUpperMargin(0.02D);
/* 109 */     NumberAxis numberAxis = new NumberAxis("$billion");
/* 110 */     XYPlot plot1 = new XYPlot(data1, null, numberAxis, xYLineAndShapeRenderer);
/* 111 */     plot1.setBackgroundPaint(Color.lightGray);
/* 112 */     plot1.setDomainGridlinePaint(Color.white);
/* 113 */     plot1.setRangeGridlinePaint(Color.white);
/*     */ 
/*     */     
/* 116 */     IntervalXYDataset data2 = createDataset2();
/* 117 */     XYBarRenderer renderer2 = new XYBarRenderer() {
/*     */         public Paint getItemPaint(int series, int item) {
/* 119 */           XYDataset dataset = getPlot().getDataset();
/* 120 */           if (dataset.getYValue(series, item) >= 0.0D) {
/* 121 */             return Color.red;
/*     */           }
/*     */           
/* 124 */           return Color.green;
/*     */         }
/*     */       };
/*     */     
/* 128 */     renderer2.setSeriesPaint(0, Color.red);
/* 129 */     renderer2.setDrawBarOutline(false);
/* 130 */     renderer2.setBaseToolTipGenerator(new StandardXYToolTipGenerator("{0}: ({1}, {2})", new SimpleDateFormat("d-MMM-yyyy"), new DecimalFormat("0.00")));
/*     */ 
/*     */ 
/*     */     
/* 134 */     XYPlot plot2 = new XYPlot(data2, null, new NumberAxis("$billion"), renderer2);
/*     */     
/* 136 */     plot2.setBackgroundPaint(Color.lightGray);
/* 137 */     plot2.setDomainGridlinePaint(Color.white);
/* 138 */     plot2.setRangeGridlinePaint(Color.white);
/*     */     
/* 140 */     CombinedXYPlot cplot = new CombinedXYPlot(domainAxis, numberAxis);
/* 141 */     cplot.add(plot1, 3);
/* 142 */     cplot.add(plot2, 2);
/* 143 */     cplot.setGap(8.0D);
/* 144 */     cplot.setDomainGridlinePaint(Color.white);
/* 145 */     cplot.setDomainGridlinesVisible(true);
/*     */ 
/*     */     
/* 148 */     JFreeChart chart = new JFreeChart("CombinedXYPlotDemo1", JFreeChart.DEFAULT_TITLE_FONT, cplot, false);
/*     */     
/* 150 */     chart.setBackgroundPaint(Color.white);
/* 151 */     LegendTitle legend = new LegendTitle(cplot);
/* 152 */     chart.addSubtitle(legend);
/* 153 */     return chart;
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
/*     */   private static IntervalXYDataset createDataset1() {
/* 167 */     series1 = new TimeSeries("Series 1");
/* 168 */     series1.add(new Month(true, 'ߕ'), 7627.743D);
/* 169 */     series1.add(new Month(2, 'ߕ'), 7713.138D);
/* 170 */     series1.add(new Month(3, 'ߕ'), 6776.939D);
/* 171 */     series1.add(new Month(4, 'ߕ'), 5764.537D);
/* 172 */     series1.add(new Month(5, 'ߕ'), 4777.88D);
/* 173 */     series1.add(new Month(6, 'ߕ'), 4836.496D);
/* 174 */     series1.add(new Month(7, 'ߕ'), 3887.618D);
/* 175 */     series1.add(new Month(8, 'ߕ'), 3926.933D);
/* 176 */     series1.add(new Month(9, 'ߕ'), 4932.71D);
/* 177 */     series1.add(new Month(10, 'ߕ'), 4027.123D);
/* 178 */     series1.add(new Month(11, 'ߕ'), 8092.322D);
/* 179 */     series1.add(new Month(12, 'ߕ'), 8170.414D);
/* 180 */     series1.add(new Month(true, 'ߖ'), 8196.07D);
/* 181 */     series1.add(new Month(2, 'ߖ'), 8269.886D);
/* 182 */     series1.add(new Month(3, 'ߖ'), 5371.156D);
/* 183 */     series1.add(new Month(4, 'ߖ'), 5355.718D);
/* 184 */     series1.add(new Month(5, 'ߖ'), 5356.777D);
/* 185 */     series1.add(new Month(6, 'ߖ'), 8420.042D);
/* 186 */     series1.add(new Month(7, 'ߖ'), 8444.347D);
/* 187 */     series1.add(new Month(8, 'ߖ'), 8515.034D);
/* 188 */     series1.add(new Month(9, 'ߖ'), 8506.974D);
/* 189 */     series1.add(new Month(10, 'ߖ'), 8584.329D);
/* 190 */     series1.add(new Month(11, 'ߖ'), 8633.246D);
/* 191 */     series1.add(new Month(12, 'ߖ'), 8680.224D);
/* 192 */     series1.add(new Month(true, 'ߗ'), 8707.561D);
/* 193 */     return new TimeSeriesCollection(series1);
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
/*     */   private static IntervalXYDataset createDataset2() {
/* 206 */     dataset = new TimeSeriesCollection();
/*     */     
/* 208 */     TimeSeries series1 = new TimeSeries("Series 2");
/* 209 */     series1.add(new Month(true, 'ߕ'), 1200.0D);
/* 210 */     series1.add(new Month(2, 'ߕ'), 1400.0D);
/* 211 */     series1.add(new Month(3, 'ߕ'), 1500.0D);
/* 212 */     series1.add(new Month(4, 'ߕ'), 1700.0D);
/* 213 */     series1.add(new Month(5, 'ߕ'), 1600.0D);
/* 214 */     series1.add(new Month(6, 'ߕ'), 2400.0D);
/* 215 */     series1.add(new Month(7, 'ߕ'), 2100.0D);
/* 216 */     series1.add(new Month(8, 'ߕ'), 2200.0D);
/* 217 */     series1.add(new Month(9, 'ߕ'), 800.0D);
/* 218 */     series1.add(new Month(10, 'ߕ'), 2350.0D);
/* 219 */     series1.add(new Month(11, 'ߕ'), 500.0D);
/* 220 */     series1.add(new Month(12, 'ߕ'), 700.0D);
/* 221 */     series1.add(new Month(true, 'ߖ'), 900.0D);
/* 222 */     series1.add(new Month(2, 'ߖ'), 1500.0D);
/* 223 */     series1.add(new Month(3, 'ߖ'), 2100.0D);
/* 224 */     series1.add(new Month(4, 'ߖ'), 2200.0D);
/* 225 */     series1.add(new Month(5, 'ߖ'), 1900.0D);
/* 226 */     series1.add(new Month(6, 'ߖ'), 3000.0D);
/* 227 */     series1.add(new Month(7, 'ߖ'), 3780.0D);
/* 228 */     series1.add(new Month(8, 'ߖ'), 4000.0D);
/* 229 */     series1.add(new Month(9, 'ߖ'), 4500.0D);
/* 230 */     series1.add(new Month(10, 'ߖ'), 7000.0D);
/* 231 */     series1.add(new Month(11, 'ߖ'), 5500.0D);
/* 232 */     series1.add(new Month(12, 'ߖ'), 6000.0D);
/* 233 */     series1.add(new Month(true, 'ߗ'), 6500.0D);
/* 234 */     dataset.addSeries(series1);
/* 235 */     return dataset;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JPanel createDemoPanel() {
/* 245 */     chart = createCombinedChart();
/* 246 */     return new ChartPanel(chart);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/* 255 */     CombinedXYPlotDemo1 demo = new CombinedXYPlotDemo1("JFreeChart : CombinedXYPlotDemo1");
/*     */     
/* 257 */     demo.pack();
/* 258 */     RefineryUtilities.centerFrameOnScreen(demo);
/* 259 */     demo.setVisible(true);
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/experimental/chart/demo/CombinedXYPlotDemo1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */