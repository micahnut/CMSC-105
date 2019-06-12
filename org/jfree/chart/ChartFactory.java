/*      */ package org.jfree.chart;
/*      */ 
/*      */ import java.awt.Color;
/*      */ import java.awt.Font;
/*      */ import java.text.DateFormat;
/*      */ import java.text.NumberFormat;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Locale;
/*      */ import org.jfree.chart.axis.CategoryAxis;
/*      */ import org.jfree.chart.axis.CategoryAxis3D;
/*      */ import org.jfree.chart.axis.DateAxis;
/*      */ import org.jfree.chart.axis.NumberAxis;
/*      */ import org.jfree.chart.axis.NumberAxis3D;
/*      */ import org.jfree.chart.axis.Timeline;
/*      */ import org.jfree.chart.labels.BoxAndWhiskerToolTipGenerator;
/*      */ import org.jfree.chart.labels.HighLowItemLabelGenerator;
/*      */ import org.jfree.chart.labels.IntervalCategoryToolTipGenerator;
/*      */ import org.jfree.chart.labels.ItemLabelAnchor;
/*      */ import org.jfree.chart.labels.ItemLabelPosition;
/*      */ import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
/*      */ import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
/*      */ import org.jfree.chart.labels.StandardPieToolTipGenerator;
/*      */ import org.jfree.chart.labels.StandardXYToolTipGenerator;
/*      */ import org.jfree.chart.labels.StandardXYZToolTipGenerator;
/*      */ import org.jfree.chart.plot.CategoryPlot;
/*      */ import org.jfree.chart.plot.MultiplePiePlot;
/*      */ import org.jfree.chart.plot.PiePlot;
/*      */ import org.jfree.chart.plot.PiePlot3D;
/*      */ import org.jfree.chart.plot.PlotOrientation;
/*      */ import org.jfree.chart.plot.PolarPlot;
/*      */ import org.jfree.chart.plot.RingPlot;
/*      */ import org.jfree.chart.plot.ValueMarker;
/*      */ import org.jfree.chart.plot.WaferMapPlot;
/*      */ import org.jfree.chart.plot.XYPlot;
/*      */ import org.jfree.chart.renderer.DefaultPolarItemRenderer;
/*      */ import org.jfree.chart.renderer.WaferMapRenderer;
/*      */ import org.jfree.chart.renderer.category.AreaRenderer;
/*      */ import org.jfree.chart.renderer.category.BarRenderer;
/*      */ import org.jfree.chart.renderer.category.BarRenderer3D;
/*      */ import org.jfree.chart.renderer.category.BoxAndWhiskerRenderer;
/*      */ import org.jfree.chart.renderer.category.GanttRenderer;
/*      */ import org.jfree.chart.renderer.category.GradientBarPainter;
/*      */ import org.jfree.chart.renderer.category.LineAndShapeRenderer;
/*      */ import org.jfree.chart.renderer.category.LineRenderer3D;
/*      */ import org.jfree.chart.renderer.category.StackedAreaRenderer;
/*      */ import org.jfree.chart.renderer.category.StackedBarRenderer;
/*      */ import org.jfree.chart.renderer.category.StackedBarRenderer3D;
/*      */ import org.jfree.chart.renderer.category.StandardBarPainter;
/*      */ import org.jfree.chart.renderer.category.WaterfallBarRenderer;
/*      */ import org.jfree.chart.renderer.xy.CandlestickRenderer;
/*      */ import org.jfree.chart.renderer.xy.GradientXYBarPainter;
/*      */ import org.jfree.chart.renderer.xy.HighLowRenderer;
/*      */ import org.jfree.chart.renderer.xy.StackedXYAreaRenderer2;
/*      */ import org.jfree.chart.renderer.xy.StandardXYBarPainter;
/*      */ import org.jfree.chart.renderer.xy.WindItemRenderer;
/*      */ import org.jfree.chart.renderer.xy.XYAreaRenderer;
/*      */ import org.jfree.chart.renderer.xy.XYBarRenderer;
/*      */ import org.jfree.chart.renderer.xy.XYBoxAndWhiskerRenderer;
/*      */ import org.jfree.chart.renderer.xy.XYBubbleRenderer;
/*      */ import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
/*      */ import org.jfree.chart.renderer.xy.XYStepAreaRenderer;
/*      */ import org.jfree.chart.renderer.xy.XYStepRenderer;
/*      */ import org.jfree.chart.title.TextTitle;
/*      */ import org.jfree.chart.urls.StandardCategoryURLGenerator;
/*      */ import org.jfree.chart.urls.StandardPieURLGenerator;
/*      */ import org.jfree.chart.urls.StandardXYURLGenerator;
/*      */ import org.jfree.chart.urls.StandardXYZURLGenerator;
/*      */ import org.jfree.chart.util.ParamChecks;
/*      */ import org.jfree.data.category.CategoryDataset;
/*      */ import org.jfree.data.category.IntervalCategoryDataset;
/*      */ import org.jfree.data.general.DefaultPieDataset;
/*      */ import org.jfree.data.general.PieDataset;
/*      */ import org.jfree.data.general.WaferMapDataset;
/*      */ import org.jfree.data.statistics.BoxAndWhiskerCategoryDataset;
/*      */ import org.jfree.data.statistics.BoxAndWhiskerXYDataset;
/*      */ import org.jfree.data.xy.IntervalXYDataset;
/*      */ import org.jfree.data.xy.OHLCDataset;
/*      */ import org.jfree.data.xy.TableXYDataset;
/*      */ import org.jfree.data.xy.WindDataset;
/*      */ import org.jfree.data.xy.XYDataset;
/*      */ import org.jfree.data.xy.XYZDataset;
/*      */ import org.jfree.ui.Layer;
/*      */ import org.jfree.ui.RectangleEdge;
/*      */ import org.jfree.ui.RectangleInsets;
/*      */ import org.jfree.ui.TextAnchor;
/*      */ import org.jfree.util.SortOrder;
/*      */ import org.jfree.util.TableOrder;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public abstract class ChartFactory
/*      */ {
/*  231 */   private static ChartTheme currentTheme = new StandardChartTheme("JFree");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  244 */   public static ChartTheme getChartTheme() { return currentTheme; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void setChartTheme(ChartTheme theme) {
/*  259 */     ParamChecks.nullNotPermitted(theme, "theme");
/*  260 */     currentTheme = theme;
/*      */ 
/*      */ 
/*      */     
/*  264 */     if (theme instanceof StandardChartTheme) {
/*  265 */       StandardChartTheme sct = (StandardChartTheme)theme;
/*  266 */       if (sct.getName().equals("Legacy")) {
/*  267 */         BarRenderer.setDefaultBarPainter(new StandardBarPainter());
/*  268 */         XYBarRenderer.setDefaultBarPainter(new StandardXYBarPainter());
/*      */       } else {
/*      */         
/*  271 */         BarRenderer.setDefaultBarPainter(new GradientBarPainter());
/*  272 */         XYBarRenderer.setDefaultBarPainter(new GradientXYBarPainter());
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static JFreeChart createPieChart(String title, PieDataset dataset, boolean legend, boolean tooltips, Locale locale) {
/*  296 */     PiePlot plot = new PiePlot(dataset);
/*  297 */     plot.setLabelGenerator(new StandardPieSectionLabelGenerator(locale));
/*  298 */     plot.setInsets(new RectangleInsets(0.0D, 5.0D, 5.0D, 5.0D));
/*  299 */     if (tooltips) {
/*  300 */       plot.setToolTipGenerator(new StandardPieToolTipGenerator(locale));
/*      */     }
/*  302 */     JFreeChart chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT, plot, legend);
/*      */     
/*  304 */     currentTheme.apply(chart);
/*  305 */     return chart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  323 */   public static JFreeChart createPieChart(String title, PieDataset dataset) { return createPieChart(title, dataset, true, true, false); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static JFreeChart createPieChart(String title, PieDataset dataset, boolean legend, boolean tooltips, boolean urls) {
/*  343 */     PiePlot plot = new PiePlot(dataset);
/*  344 */     plot.setLabelGenerator(new StandardPieSectionLabelGenerator());
/*  345 */     plot.setInsets(new RectangleInsets(0.0D, 5.0D, 5.0D, 5.0D));
/*  346 */     if (tooltips) {
/*  347 */       plot.setToolTipGenerator(new StandardPieToolTipGenerator());
/*      */     }
/*  349 */     if (urls) {
/*  350 */       plot.setURLGenerator(new StandardPieURLGenerator());
/*      */     }
/*  352 */     JFreeChart chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT, plot, legend);
/*      */     
/*  354 */     currentTheme.apply(chart);
/*  355 */     return chart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static JFreeChart createPieChart(String title, PieDataset dataset, PieDataset previousDataset, int percentDiffForMaxScale, boolean greenForIncrease, boolean legend, boolean tooltips, Locale locale, boolean subTitle, boolean showDifference) {
/*  403 */     PiePlot plot = new PiePlot(dataset);
/*  404 */     plot.setLabelGenerator(new StandardPieSectionLabelGenerator(locale));
/*  405 */     plot.setInsets(new RectangleInsets(0.0D, 5.0D, 5.0D, 5.0D));
/*      */     
/*  407 */     if (tooltips) {
/*  408 */       plot.setToolTipGenerator(new StandardPieToolTipGenerator(locale));
/*      */     }
/*      */     
/*  411 */     List keys = dataset.getKeys();
/*  412 */     DefaultPieDataset series = null;
/*  413 */     if (showDifference) {
/*  414 */       series = new DefaultPieDataset();
/*      */     }
/*      */     
/*  417 */     double colorPerPercent = 255.0D / percentDiffForMaxScale;
/*  418 */     for (it = keys.iterator(); it.hasNext(); ) {
/*  419 */       Comparable key = (Comparable)it.next();
/*  420 */       Number newValue = dataset.getValue(key);
/*  421 */       Number oldValue = previousDataset.getValue(key);
/*      */       
/*  423 */       if (oldValue == null) {
/*  424 */         if (greenForIncrease) {
/*  425 */           plot.setSectionPaint(key, Color.green);
/*      */         } else {
/*      */           
/*  428 */           plot.setSectionPaint(key, Color.red);
/*      */         } 
/*  430 */         if (showDifference) {
/*  431 */           assert series != null;
/*  432 */           series.setValue(key + " (+100%)", newValue);
/*      */         } 
/*      */         
/*      */         continue;
/*      */       } 
/*  437 */       double percentChange = (newValue.doubleValue() / oldValue.doubleValue() - 1.0D) * 100.0D;
/*      */ 
/*      */       
/*  440 */       double shade = (Math.abs(percentChange) >= percentDiffForMaxScale) ? 255.0D : (Math.abs(percentChange) * colorPerPercent);
/*  441 */       if ((greenForIncrease && newValue
/*  442 */         .doubleValue() > oldValue.doubleValue()) || (!greenForIncrease && newValue
/*  443 */         .doubleValue() < oldValue
/*  444 */         .doubleValue())) {
/*  445 */         plot.setSectionPaint(key, new Color(false, (int)shade, false));
/*      */       } else {
/*      */         
/*  448 */         plot.setSectionPaint(key, new Color((int)shade, false, false));
/*      */       } 
/*  450 */       if (showDifference) {
/*  451 */         assert series != null;
/*  452 */         series.setValue(key + " (" + ((percentChange >= 0.0D) ? "+" : "") + 
/*  453 */             NumberFormat.getPercentInstance().format(percentChange / 100.0D) + ")", newValue);
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  459 */     if (showDifference) {
/*  460 */       plot.setDataset(series);
/*      */     }
/*      */     
/*  463 */     JFreeChart chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT, plot, legend);
/*      */ 
/*      */     
/*  466 */     if (subTitle) {
/*  467 */       TextTitle subtitle = new TextTitle("Bright " + (greenForIncrease ? "red" : "green") + "=change >=-" + percentDiffForMaxScale + "%, Bright " + (!greenForIncrease ? "red" : "green") + "=change >=+" + percentDiffForMaxScale + "%", new Font("SansSerif", false, 10));
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  472 */       chart.addSubtitle(subtitle);
/*      */     } 
/*  474 */     currentTheme.apply(chart);
/*  475 */     return chart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static JFreeChart createPieChart(String title, PieDataset dataset, PieDataset previousDataset, int percentDiffForMaxScale, boolean greenForIncrease, boolean legend, boolean tooltips, boolean urls, boolean subTitle, boolean showDifference) {
/*  521 */     PiePlot plot = new PiePlot(dataset);
/*  522 */     plot.setLabelGenerator(new StandardPieSectionLabelGenerator());
/*  523 */     plot.setInsets(new RectangleInsets(0.0D, 5.0D, 5.0D, 5.0D));
/*      */     
/*  525 */     if (tooltips) {
/*  526 */       plot.setToolTipGenerator(new StandardPieToolTipGenerator());
/*      */     }
/*  528 */     if (urls) {
/*  529 */       plot.setURLGenerator(new StandardPieURLGenerator());
/*      */     }
/*      */     
/*  532 */     List keys = dataset.getKeys();
/*  533 */     DefaultPieDataset series = null;
/*  534 */     if (showDifference) {
/*  535 */       series = new DefaultPieDataset();
/*      */     }
/*      */     
/*  538 */     double colorPerPercent = 255.0D / percentDiffForMaxScale;
/*  539 */     for (it = keys.iterator(); it.hasNext(); ) {
/*  540 */       Comparable key = (Comparable)it.next();
/*  541 */       Number newValue = dataset.getValue(key);
/*  542 */       Number oldValue = previousDataset.getValue(key);
/*      */       
/*  544 */       if (oldValue == null) {
/*  545 */         if (greenForIncrease) {
/*  546 */           plot.setSectionPaint(key, Color.green);
/*      */         } else {
/*      */           
/*  549 */           plot.setSectionPaint(key, Color.red);
/*      */         } 
/*  551 */         if (showDifference) {
/*  552 */           assert series != null;
/*  553 */           series.setValue(key + " (+100%)", newValue);
/*      */         } 
/*      */         
/*      */         continue;
/*      */       } 
/*  558 */       double percentChange = (newValue.doubleValue() / oldValue.doubleValue() - 1.0D) * 100.0D;
/*      */ 
/*      */       
/*  561 */       double shade = (Math.abs(percentChange) >= percentDiffForMaxScale) ? 255.0D : (Math.abs(percentChange) * colorPerPercent);
/*  562 */       if ((greenForIncrease && newValue
/*  563 */         .doubleValue() > oldValue.doubleValue()) || (!greenForIncrease && newValue
/*  564 */         .doubleValue() < oldValue
/*  565 */         .doubleValue())) {
/*  566 */         plot.setSectionPaint(key, new Color(false, (int)shade, false));
/*      */       } else {
/*      */         
/*  569 */         plot.setSectionPaint(key, new Color((int)shade, false, false));
/*      */       } 
/*  571 */       if (showDifference) {
/*  572 */         assert series != null;
/*  573 */         series.setValue(key + " (" + ((percentChange >= 0.0D) ? "+" : "") + 
/*  574 */             NumberFormat.getPercentInstance().format(percentChange / 100.0D) + ")", newValue);
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  580 */     if (showDifference) {
/*  581 */       plot.setDataset(series);
/*      */     }
/*      */     
/*  584 */     JFreeChart chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT, plot, legend);
/*      */ 
/*      */     
/*  587 */     if (subTitle) {
/*  588 */       TextTitle subtitle = new TextTitle("Bright " + (greenForIncrease ? "red" : "green") + "=change >=-" + percentDiffForMaxScale + "%, Bright " + (!greenForIncrease ? "red" : "green") + "=change >=+" + percentDiffForMaxScale + "%", new Font("SansSerif", false, 10));
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  593 */       chart.addSubtitle(subtitle);
/*      */     } 
/*  595 */     currentTheme.apply(chart);
/*  596 */     return chart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static JFreeChart createRingChart(String title, PieDataset dataset, boolean legend, boolean tooltips, Locale locale) {
/*  618 */     RingPlot plot = new RingPlot(dataset);
/*  619 */     plot.setLabelGenerator(new StandardPieSectionLabelGenerator(locale));
/*  620 */     plot.setInsets(new RectangleInsets(0.0D, 5.0D, 5.0D, 5.0D));
/*  621 */     if (tooltips) {
/*  622 */       plot.setToolTipGenerator(new StandardPieToolTipGenerator(locale));
/*      */     }
/*  624 */     JFreeChart chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT, plot, legend);
/*      */     
/*  626 */     currentTheme.apply(chart);
/*  627 */     return chart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static JFreeChart createRingChart(String title, PieDataset dataset, boolean legend, boolean tooltips, boolean urls) {
/*  647 */     RingPlot plot = new RingPlot(dataset);
/*  648 */     plot.setLabelGenerator(new StandardPieSectionLabelGenerator());
/*  649 */     plot.setInsets(new RectangleInsets(0.0D, 5.0D, 5.0D, 5.0D));
/*  650 */     if (tooltips) {
/*  651 */       plot.setToolTipGenerator(new StandardPieToolTipGenerator());
/*      */     }
/*  653 */     if (urls) {
/*  654 */       plot.setURLGenerator(new StandardPieURLGenerator());
/*      */     }
/*  656 */     JFreeChart chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT, plot, legend);
/*      */     
/*  658 */     currentTheme.apply(chart);
/*  659 */     return chart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static JFreeChart createMultiplePieChart(String title, CategoryDataset dataset, TableOrder order, boolean legend, boolean tooltips, boolean urls) {
/*  682 */     ParamChecks.nullNotPermitted(order, "order");
/*  683 */     MultiplePiePlot plot = new MultiplePiePlot(dataset);
/*  684 */     plot.setDataExtractOrder(order);
/*  685 */     plot.setBackgroundPaint(null);
/*  686 */     plot.setOutlineStroke(null);
/*      */     
/*  688 */     if (tooltips) {
/*  689 */       StandardPieToolTipGenerator standardPieToolTipGenerator = new StandardPieToolTipGenerator();
/*      */       
/*  691 */       PiePlot pp = (PiePlot)plot.getPieChart().getPlot();
/*  692 */       pp.setToolTipGenerator(standardPieToolTipGenerator);
/*      */     } 
/*      */     
/*  695 */     if (urls) {
/*  696 */       StandardPieURLGenerator standardPieURLGenerator = new StandardPieURLGenerator();
/*  697 */       PiePlot pp = (PiePlot)plot.getPieChart().getPlot();
/*  698 */       pp.setURLGenerator(standardPieURLGenerator);
/*      */     } 
/*      */     
/*  701 */     JFreeChart chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT, plot, legend);
/*      */     
/*  703 */     currentTheme.apply(chart);
/*  704 */     return chart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static JFreeChart createPieChart3D(String title, PieDataset dataset, boolean legend, boolean tooltips, Locale locale) {
/*  726 */     ParamChecks.nullNotPermitted(locale, "locale");
/*  727 */     PiePlot3D plot = new PiePlot3D(dataset);
/*  728 */     plot.setInsets(new RectangleInsets(0.0D, 5.0D, 5.0D, 5.0D));
/*  729 */     if (tooltips) {
/*  730 */       plot.setToolTipGenerator(new StandardPieToolTipGenerator(locale));
/*      */     }
/*  732 */     JFreeChart chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT, plot, legend);
/*      */     
/*  734 */     currentTheme.apply(chart);
/*  735 */     return chart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  753 */   public static JFreeChart createPieChart3D(String title, PieDataset dataset) { return createPieChart3D(title, dataset, true, true, false); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static JFreeChart createPieChart3D(String title, PieDataset dataset, boolean legend, boolean tooltips, boolean urls) {
/*  772 */     PiePlot3D plot = new PiePlot3D(dataset);
/*  773 */     plot.setInsets(new RectangleInsets(0.0D, 5.0D, 5.0D, 5.0D));
/*  774 */     if (tooltips) {
/*  775 */       plot.setToolTipGenerator(new StandardPieToolTipGenerator());
/*      */     }
/*  777 */     if (urls) {
/*  778 */       plot.setURLGenerator(new StandardPieURLGenerator());
/*      */     }
/*  780 */     JFreeChart chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT, plot, legend);
/*      */     
/*  782 */     currentTheme.apply(chart);
/*  783 */     return chart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static JFreeChart createMultiplePieChart3D(String title, CategoryDataset dataset, TableOrder order, boolean legend, boolean tooltips, boolean urls) {
/*  806 */     ParamChecks.nullNotPermitted(order, "order");
/*  807 */     MultiplePiePlot plot = new MultiplePiePlot(dataset);
/*  808 */     plot.setDataExtractOrder(order);
/*  809 */     plot.setBackgroundPaint(null);
/*  810 */     plot.setOutlineStroke(null);
/*      */     
/*  812 */     JFreeChart pieChart = new JFreeChart(new PiePlot3D(null));
/*  813 */     TextTitle seriesTitle = new TextTitle("Series Title", new Font("SansSerif", true, 12));
/*      */     
/*  815 */     seriesTitle.setPosition(RectangleEdge.BOTTOM);
/*  816 */     pieChart.setTitle(seriesTitle);
/*  817 */     pieChart.removeLegend();
/*  818 */     pieChart.setBackgroundPaint(null);
/*  819 */     plot.setPieChart(pieChart);
/*      */     
/*  821 */     if (tooltips) {
/*  822 */       StandardPieToolTipGenerator standardPieToolTipGenerator = new StandardPieToolTipGenerator();
/*      */       
/*  824 */       PiePlot pp = (PiePlot)plot.getPieChart().getPlot();
/*  825 */       pp.setToolTipGenerator(standardPieToolTipGenerator);
/*      */     } 
/*      */     
/*  828 */     if (urls) {
/*  829 */       StandardPieURLGenerator standardPieURLGenerator = new StandardPieURLGenerator();
/*  830 */       PiePlot pp = (PiePlot)plot.getPieChart().getPlot();
/*  831 */       pp.setURLGenerator(standardPieURLGenerator);
/*      */     } 
/*      */     
/*  834 */     JFreeChart chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT, plot, legend);
/*      */     
/*  836 */     currentTheme.apply(chart);
/*  837 */     return chart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  862 */   public static JFreeChart createBarChart(String title, String categoryAxisLabel, String valueAxisLabel, CategoryDataset dataset) { return createBarChart(title, categoryAxisLabel, valueAxisLabel, dataset, PlotOrientation.VERTICAL, true, true, false); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static JFreeChart createBarChart(String title, String categoryAxisLabel, String valueAxisLabel, CategoryDataset dataset, PlotOrientation orientation, boolean legend, boolean tooltips, boolean urls) {
/*  891 */     ParamChecks.nullNotPermitted(orientation, "orientation");
/*  892 */     CategoryAxis categoryAxis = new CategoryAxis(categoryAxisLabel);
/*  893 */     NumberAxis numberAxis = new NumberAxis(valueAxisLabel);
/*      */     
/*  895 */     BarRenderer renderer = new BarRenderer();
/*  896 */     if (orientation == PlotOrientation.HORIZONTAL) {
/*  897 */       ItemLabelPosition position1 = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE3, TextAnchor.CENTER_LEFT);
/*      */       
/*  899 */       renderer.setBasePositiveItemLabelPosition(position1);
/*  900 */       ItemLabelPosition position2 = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE9, TextAnchor.CENTER_RIGHT);
/*      */       
/*  902 */       renderer.setBaseNegativeItemLabelPosition(position2);
/*  903 */     } else if (orientation == PlotOrientation.VERTICAL) {
/*  904 */       ItemLabelPosition position1 = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BOTTOM_CENTER);
/*      */       
/*  906 */       renderer.setBasePositiveItemLabelPosition(position1);
/*  907 */       ItemLabelPosition position2 = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE6, TextAnchor.TOP_CENTER);
/*      */       
/*  909 */       renderer.setBaseNegativeItemLabelPosition(position2);
/*      */     } 
/*  911 */     if (tooltips) {
/*  912 */       renderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
/*      */     }
/*      */     
/*  915 */     if (urls) {
/*  916 */       renderer.setBaseItemURLGenerator(new StandardCategoryURLGenerator());
/*      */     }
/*      */ 
/*      */     
/*  920 */     CategoryPlot plot = new CategoryPlot(dataset, categoryAxis, numberAxis, renderer);
/*      */     
/*  922 */     plot.setOrientation(orientation);
/*  923 */     JFreeChart chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT, plot, legend);
/*      */     
/*  925 */     currentTheme.apply(chart);
/*  926 */     return chart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  951 */   public static JFreeChart createStackedBarChart(String title, String domainAxisLabel, String rangeAxisLabel, CategoryDataset dataset) { return createStackedBarChart(title, domainAxisLabel, rangeAxisLabel, dataset, PlotOrientation.VERTICAL, true, true, false); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static JFreeChart createStackedBarChart(String title, String domainAxisLabel, String rangeAxisLabel, CategoryDataset dataset, PlotOrientation orientation, boolean legend, boolean tooltips, boolean urls) {
/*  981 */     ParamChecks.nullNotPermitted(orientation, "orientation");
/*      */     
/*  983 */     CategoryAxis categoryAxis = new CategoryAxis(domainAxisLabel);
/*  984 */     NumberAxis numberAxis = new NumberAxis(rangeAxisLabel);
/*      */     
/*  986 */     StackedBarRenderer renderer = new StackedBarRenderer();
/*  987 */     if (tooltips) {
/*  988 */       renderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
/*      */     }
/*      */     
/*  991 */     if (urls) {
/*  992 */       renderer.setBaseItemURLGenerator(new StandardCategoryURLGenerator());
/*      */     }
/*      */ 
/*      */     
/*  996 */     CategoryPlot plot = new CategoryPlot(dataset, categoryAxis, numberAxis, renderer);
/*      */     
/*  998 */     plot.setOrientation(orientation);
/*  999 */     JFreeChart chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT, plot, legend);
/*      */     
/* 1001 */     currentTheme.apply(chart);
/* 1002 */     return chart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1026 */   public static JFreeChart createBarChart3D(String title, String categoryAxisLabel, String valueAxisLabel, CategoryDataset dataset) { return createBarChart3D(title, categoryAxisLabel, valueAxisLabel, dataset, PlotOrientation.VERTICAL, true, true, false); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static JFreeChart createBarChart3D(String title, String categoryAxisLabel, String valueAxisLabel, CategoryDataset dataset, PlotOrientation orientation, boolean legend, boolean tooltips, boolean urls) {
/* 1055 */     ParamChecks.nullNotPermitted(orientation, "orientation");
/* 1056 */     CategoryAxis3D categoryAxis3D = new CategoryAxis3D(categoryAxisLabel);
/* 1057 */     NumberAxis3D numberAxis3D = new NumberAxis3D(valueAxisLabel);
/*      */     
/* 1059 */     BarRenderer3D renderer = new BarRenderer3D();
/* 1060 */     if (tooltips) {
/* 1061 */       renderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
/*      */     }
/*      */     
/* 1064 */     if (urls) {
/* 1065 */       renderer.setBaseItemURLGenerator(new StandardCategoryURLGenerator());
/*      */     }
/*      */ 
/*      */     
/* 1069 */     CategoryPlot plot = new CategoryPlot(dataset, categoryAxis3D, numberAxis3D, renderer);
/*      */     
/* 1071 */     plot.setOrientation(orientation);
/* 1072 */     if (orientation == PlotOrientation.HORIZONTAL) {
/*      */ 
/*      */       
/* 1075 */       plot.setRowRenderingOrder(SortOrder.DESCENDING);
/* 1076 */       plot.setColumnRenderingOrder(SortOrder.DESCENDING);
/*      */     } 
/* 1078 */     plot.setForegroundAlpha(0.75F);
/*      */     
/* 1080 */     JFreeChart chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT, plot, legend);
/*      */     
/* 1082 */     currentTheme.apply(chart);
/* 1083 */     return chart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1108 */   public static JFreeChart createStackedBarChart3D(String title, String categoryAxisLabel, String valueAxisLabel, CategoryDataset dataset) { return createStackedBarChart3D(title, categoryAxisLabel, valueAxisLabel, dataset, PlotOrientation.VERTICAL, true, true, false); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static JFreeChart createStackedBarChart3D(String title, String categoryAxisLabel, String valueAxisLabel, CategoryDataset dataset, PlotOrientation orientation, boolean legend, boolean tooltips, boolean urls) {
/* 1138 */     ParamChecks.nullNotPermitted(orientation, "orientation");
/* 1139 */     CategoryAxis3D categoryAxis3D = new CategoryAxis3D(categoryAxisLabel);
/* 1140 */     NumberAxis3D numberAxis3D = new NumberAxis3D(valueAxisLabel);
/*      */ 
/*      */     
/* 1143 */     StackedBarRenderer3D stackedBarRenderer3D = new StackedBarRenderer3D();
/* 1144 */     if (tooltips) {
/* 1145 */       stackedBarRenderer3D.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
/*      */     }
/*      */     
/* 1148 */     if (urls) {
/* 1149 */       stackedBarRenderer3D.setBaseItemURLGenerator(new StandardCategoryURLGenerator());
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 1154 */     CategoryPlot plot = new CategoryPlot(dataset, categoryAxis3D, numberAxis3D, stackedBarRenderer3D);
/*      */     
/* 1156 */     plot.setOrientation(orientation);
/* 1157 */     if (orientation == PlotOrientation.HORIZONTAL)
/*      */     {
/*      */       
/* 1160 */       plot.setColumnRenderingOrder(SortOrder.DESCENDING);
/*      */     }
/*      */ 
/*      */     
/* 1164 */     JFreeChart chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT, plot, legend);
/*      */     
/* 1166 */     currentTheme.apply(chart);
/* 1167 */     return chart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1191 */   public static JFreeChart createAreaChart(String title, String categoryAxisLabel, String valueAxisLabel, CategoryDataset dataset) { return createAreaChart(title, categoryAxisLabel, valueAxisLabel, dataset, PlotOrientation.VERTICAL, true, true, false); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static JFreeChart createAreaChart(String title, String categoryAxisLabel, String valueAxisLabel, CategoryDataset dataset, PlotOrientation orientation, boolean legend, boolean tooltips, boolean urls) {
/* 1220 */     ParamChecks.nullNotPermitted(orientation, "orientation");
/* 1221 */     CategoryAxis categoryAxis = new CategoryAxis(categoryAxisLabel);
/* 1222 */     categoryAxis.setCategoryMargin(0.0D);
/*      */     
/* 1224 */     NumberAxis numberAxis = new NumberAxis(valueAxisLabel);
/*      */     
/* 1226 */     AreaRenderer renderer = new AreaRenderer();
/* 1227 */     if (tooltips) {
/* 1228 */       renderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
/*      */     }
/*      */     
/* 1231 */     if (urls) {
/* 1232 */       renderer.setBaseItemURLGenerator(new StandardCategoryURLGenerator());
/*      */     }
/*      */ 
/*      */     
/* 1236 */     CategoryPlot plot = new CategoryPlot(dataset, categoryAxis, numberAxis, renderer);
/*      */     
/* 1238 */     plot.setOrientation(orientation);
/* 1239 */     JFreeChart chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT, plot, legend);
/*      */     
/* 1241 */     currentTheme.apply(chart);
/* 1242 */     return chart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1267 */   public static JFreeChart createStackedAreaChart(String title, String categoryAxisLabel, String valueAxisLabel, CategoryDataset dataset) { return createStackedAreaChart(title, categoryAxisLabel, valueAxisLabel, dataset, PlotOrientation.VERTICAL, true, true, false); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static JFreeChart createStackedAreaChart(String title, String categoryAxisLabel, String valueAxisLabel, CategoryDataset dataset, PlotOrientation orientation, boolean legend, boolean tooltips, boolean urls) {
/* 1297 */     ParamChecks.nullNotPermitted(orientation, "orientation");
/* 1298 */     CategoryAxis categoryAxis = new CategoryAxis(categoryAxisLabel);
/* 1299 */     categoryAxis.setCategoryMargin(0.0D);
/* 1300 */     NumberAxis numberAxis = new NumberAxis(valueAxisLabel);
/*      */     
/* 1302 */     StackedAreaRenderer renderer = new StackedAreaRenderer();
/* 1303 */     if (tooltips) {
/* 1304 */       renderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
/*      */     }
/*      */     
/* 1307 */     if (urls) {
/* 1308 */       renderer.setBaseItemURLGenerator(new StandardCategoryURLGenerator());
/*      */     }
/*      */ 
/*      */     
/* 1312 */     CategoryPlot plot = new CategoryPlot(dataset, categoryAxis, numberAxis, renderer);
/*      */     
/* 1314 */     plot.setOrientation(orientation);
/* 1315 */     JFreeChart chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT, plot, legend);
/*      */     
/* 1317 */     currentTheme.apply(chart);
/* 1318 */     return chart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1342 */   public static JFreeChart createLineChart(String title, String categoryAxisLabel, String valueAxisLabel, CategoryDataset dataset) { return createLineChart(title, categoryAxisLabel, valueAxisLabel, dataset, PlotOrientation.VERTICAL, true, true, false); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static JFreeChart createLineChart(String title, String categoryAxisLabel, String valueAxisLabel, CategoryDataset dataset, PlotOrientation orientation, boolean legend, boolean tooltips, boolean urls) {
/* 1371 */     ParamChecks.nullNotPermitted(orientation, "orientation");
/* 1372 */     CategoryAxis categoryAxis = new CategoryAxis(categoryAxisLabel);
/* 1373 */     NumberAxis numberAxis = new NumberAxis(valueAxisLabel);
/*      */     
/* 1375 */     LineAndShapeRenderer renderer = new LineAndShapeRenderer(true, false);
/* 1376 */     if (tooltips) {
/* 1377 */       renderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
/*      */     }
/*      */     
/* 1380 */     if (urls) {
/* 1381 */       renderer.setBaseItemURLGenerator(new StandardCategoryURLGenerator());
/*      */     }
/*      */     
/* 1384 */     CategoryPlot plot = new CategoryPlot(dataset, categoryAxis, numberAxis, renderer);
/*      */     
/* 1386 */     plot.setOrientation(orientation);
/* 1387 */     JFreeChart chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT, plot, legend);
/*      */     
/* 1389 */     currentTheme.apply(chart);
/* 1390 */     return chart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1414 */   public static JFreeChart createLineChart3D(String title, String categoryAxisLabel, String valueAxisLabel, CategoryDataset dataset) { return createLineChart3D(title, categoryAxisLabel, valueAxisLabel, dataset, PlotOrientation.VERTICAL, true, true, false); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static JFreeChart createLineChart3D(String title, String categoryAxisLabel, String valueAxisLabel, CategoryDataset dataset, PlotOrientation orientation, boolean legend, boolean tooltips, boolean urls) {
/* 1443 */     ParamChecks.nullNotPermitted(orientation, "orientation");
/* 1444 */     CategoryAxis3D categoryAxis3D = new CategoryAxis3D(categoryAxisLabel);
/* 1445 */     NumberAxis3D numberAxis3D = new NumberAxis3D(valueAxisLabel);
/*      */     
/* 1447 */     LineRenderer3D renderer = new LineRenderer3D();
/* 1448 */     if (tooltips) {
/* 1449 */       renderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
/*      */     }
/*      */     
/* 1452 */     if (urls) {
/* 1453 */       renderer.setBaseItemURLGenerator(new StandardCategoryURLGenerator());
/*      */     }
/*      */     
/* 1456 */     CategoryPlot plot = new CategoryPlot(dataset, categoryAxis3D, numberAxis3D, renderer);
/*      */     
/* 1458 */     plot.setOrientation(orientation);
/* 1459 */     JFreeChart chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT, plot, legend);
/*      */     
/* 1461 */     currentTheme.apply(chart);
/* 1462 */     return chart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1487 */   public static JFreeChart createGanttChart(String title, String categoryAxisLabel, String dateAxisLabel, IntervalCategoryDataset dataset) { return createGanttChart(title, categoryAxisLabel, dateAxisLabel, dataset, true, true, false); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static JFreeChart createGanttChart(String title, String categoryAxisLabel, String dateAxisLabel, IntervalCategoryDataset dataset, boolean legend, boolean tooltips, boolean urls) {
/* 1515 */     CategoryAxis categoryAxis = new CategoryAxis(categoryAxisLabel);
/* 1516 */     DateAxis dateAxis = new DateAxis(dateAxisLabel);
/*      */     
/* 1518 */     GanttRenderer ganttRenderer = new GanttRenderer();
/* 1519 */     if (tooltips) {
/* 1520 */       ganttRenderer.setBaseToolTipGenerator(new IntervalCategoryToolTipGenerator("{3} - {4}", 
/*      */             
/* 1522 */             DateFormat.getDateInstance()));
/*      */     }
/* 1524 */     if (urls) {
/* 1525 */       ganttRenderer.setBaseItemURLGenerator(new StandardCategoryURLGenerator());
/*      */     }
/*      */ 
/*      */     
/* 1529 */     CategoryPlot plot = new CategoryPlot(dataset, categoryAxis, dateAxis, ganttRenderer);
/*      */     
/* 1531 */     plot.setOrientation(PlotOrientation.HORIZONTAL);
/* 1532 */     JFreeChart chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT, plot, legend);
/*      */     
/* 1534 */     currentTheme.apply(chart);
/* 1535 */     return chart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static JFreeChart createWaterfallChart(String title, String categoryAxisLabel, String valueAxisLabel, CategoryDataset dataset, PlotOrientation orientation, boolean legend, boolean tooltips, boolean urls) {
/* 1564 */     ParamChecks.nullNotPermitted(orientation, "orientation");
/* 1565 */     CategoryAxis categoryAxis = new CategoryAxis(categoryAxisLabel);
/* 1566 */     categoryAxis.setCategoryMargin(0.0D);
/*      */     
/* 1568 */     NumberAxis numberAxis = new NumberAxis(valueAxisLabel);
/*      */     
/* 1570 */     WaterfallBarRenderer renderer = new WaterfallBarRenderer();
/* 1571 */     if (orientation == PlotOrientation.HORIZONTAL) {
/* 1572 */       ItemLabelPosition position = new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER, TextAnchor.CENTER, 1.5707963267948966D);
/*      */ 
/*      */       
/* 1575 */       renderer.setBasePositiveItemLabelPosition(position);
/* 1576 */       renderer.setBaseNegativeItemLabelPosition(position);
/*      */     }
/* 1578 */     else if (orientation == PlotOrientation.VERTICAL) {
/* 1579 */       ItemLabelPosition position = new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER, TextAnchor.CENTER, 0.0D);
/*      */ 
/*      */       
/* 1582 */       renderer.setBasePositiveItemLabelPosition(position);
/* 1583 */       renderer.setBaseNegativeItemLabelPosition(position);
/*      */     } 
/* 1585 */     if (tooltips) {
/* 1586 */       StandardCategoryToolTipGenerator generator = new StandardCategoryToolTipGenerator();
/*      */       
/* 1588 */       renderer.setBaseToolTipGenerator(generator);
/*      */     } 
/* 1590 */     if (urls) {
/* 1591 */       renderer.setBaseItemURLGenerator(new StandardCategoryURLGenerator());
/*      */     }
/*      */ 
/*      */     
/* 1595 */     CategoryPlot plot = new CategoryPlot(dataset, categoryAxis, numberAxis, renderer);
/*      */     
/* 1597 */     plot.clearRangeMarkers();
/* 1598 */     ValueMarker valueMarker = new ValueMarker(0.0D);
/* 1599 */     valueMarker.setPaint(Color.black);
/* 1600 */     plot.addRangeMarker(valueMarker, Layer.FOREGROUND);
/* 1601 */     plot.setOrientation(orientation);
/* 1602 */     JFreeChart chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT, plot, legend);
/*      */     
/* 1604 */     currentTheme.apply(chart);
/* 1605 */     return chart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static JFreeChart createPolarChart(String title, XYDataset dataset, boolean legend, boolean tooltips, boolean urls) {
/* 1626 */     PolarPlot plot = new PolarPlot();
/* 1627 */     plot.setDataset(dataset);
/* 1628 */     NumberAxis rangeAxis = new NumberAxis();
/* 1629 */     rangeAxis.setAxisLineVisible(false);
/* 1630 */     rangeAxis.setTickMarksVisible(false);
/* 1631 */     rangeAxis.setTickLabelInsets(new RectangleInsets(0.0D, 0.0D, 0.0D, 0.0D));
/* 1632 */     plot.setAxis(rangeAxis);
/* 1633 */     plot.setRenderer(new DefaultPolarItemRenderer());
/* 1634 */     JFreeChart chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT, plot, legend);
/*      */     
/* 1636 */     currentTheme.apply(chart);
/* 1637 */     return chart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1659 */   public static JFreeChart createScatterPlot(String title, String xAxisLabel, String yAxisLabel, XYDataset dataset) { return createScatterPlot(title, xAxisLabel, yAxisLabel, dataset, PlotOrientation.VERTICAL, true, true, false); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static JFreeChart createScatterPlot(String title, String xAxisLabel, String yAxisLabel, XYDataset dataset, PlotOrientation orientation, boolean legend, boolean tooltips, boolean urls) {
/* 1686 */     ParamChecks.nullNotPermitted(orientation, "orientation");
/* 1687 */     NumberAxis xAxis = new NumberAxis(xAxisLabel);
/* 1688 */     xAxis.setAutoRangeIncludesZero(false);
/* 1689 */     NumberAxis yAxis = new NumberAxis(yAxisLabel);
/* 1690 */     yAxis.setAutoRangeIncludesZero(false);
/*      */     
/* 1692 */     XYPlot plot = new XYPlot(dataset, xAxis, yAxis, null);
/*      */     
/* 1694 */     StandardXYToolTipGenerator standardXYToolTipGenerator = null;
/* 1695 */     if (tooltips) {
/* 1696 */       standardXYToolTipGenerator = new StandardXYToolTipGenerator();
/*      */     }
/*      */     
/* 1699 */     StandardXYURLGenerator standardXYURLGenerator = null;
/* 1700 */     if (urls) {
/* 1701 */       standardXYURLGenerator = new StandardXYURLGenerator();
/*      */     }
/* 1703 */     XYLineAndShapeRenderer xYLineAndShapeRenderer = new XYLineAndShapeRenderer(false, true);
/* 1704 */     xYLineAndShapeRenderer.setBaseToolTipGenerator(standardXYToolTipGenerator);
/* 1705 */     xYLineAndShapeRenderer.setURLGenerator(standardXYURLGenerator);
/* 1706 */     plot.setRenderer(xYLineAndShapeRenderer);
/* 1707 */     plot.setOrientation(orientation);
/*      */     
/* 1709 */     JFreeChart chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT, plot, legend);
/*      */     
/* 1711 */     currentTheme.apply(chart);
/* 1712 */     return chart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1736 */   public static JFreeChart createXYBarChart(String title, String xAxisLabel, boolean dateAxis, String yAxisLabel, IntervalXYDataset dataset) { return createXYBarChart(title, xAxisLabel, dateAxis, yAxisLabel, dataset, PlotOrientation.VERTICAL, true, true, false); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static JFreeChart createXYBarChart(String title, String xAxisLabel, boolean dateAxis, String yAxisLabel, IntervalXYDataset dataset, PlotOrientation orientation, boolean legend, boolean tooltips, boolean urls) {
/*      */     NumberAxis numberAxis1;
/* 1766 */     ParamChecks.nullNotPermitted(orientation, "orientation");
/*      */     
/* 1768 */     if (dateAxis) {
/* 1769 */       numberAxis1 = new DateAxis(xAxisLabel);
/*      */     } else {
/*      */       
/* 1772 */       NumberAxis axis = new NumberAxis(xAxisLabel);
/* 1773 */       axis.setAutoRangeIncludesZero(false);
/* 1774 */       numberAxis1 = axis;
/*      */     } 
/* 1776 */     NumberAxis numberAxis2 = new NumberAxis(yAxisLabel);
/*      */     
/* 1778 */     XYBarRenderer renderer = new XYBarRenderer();
/* 1779 */     if (tooltips) {
/*      */       StandardXYToolTipGenerator standardXYToolTipGenerator;
/* 1781 */       if (dateAxis) {
/* 1782 */         standardXYToolTipGenerator = StandardXYToolTipGenerator.getTimeSeriesInstance();
/*      */       } else {
/*      */         
/* 1785 */         standardXYToolTipGenerator = new StandardXYToolTipGenerator();
/*      */       } 
/* 1787 */       renderer.setBaseToolTipGenerator(standardXYToolTipGenerator);
/*      */     } 
/* 1789 */     if (urls) {
/* 1790 */       renderer.setURLGenerator(new StandardXYURLGenerator());
/*      */     }
/*      */     
/* 1793 */     XYPlot plot = new XYPlot(dataset, numberAxis1, numberAxis2, renderer);
/* 1794 */     plot.setOrientation(orientation);
/*      */     
/* 1796 */     JFreeChart chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT, plot, legend);
/*      */     
/* 1798 */     currentTheme.apply(chart);
/* 1799 */     return chart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1822 */   public static JFreeChart createXYAreaChart(String title, String xAxisLabel, String yAxisLabel, XYDataset dataset) { return createXYAreaChart(title, xAxisLabel, yAxisLabel, dataset, PlotOrientation.VERTICAL, true, true, false); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static JFreeChart createXYAreaChart(String title, String xAxisLabel, String yAxisLabel, XYDataset dataset, PlotOrientation orientation, boolean legend, boolean tooltips, boolean urls) {
/* 1850 */     ParamChecks.nullNotPermitted(orientation, "orientation");
/* 1851 */     NumberAxis xAxis = new NumberAxis(xAxisLabel);
/* 1852 */     xAxis.setAutoRangeIncludesZero(false);
/* 1853 */     NumberAxis yAxis = new NumberAxis(yAxisLabel);
/* 1854 */     XYPlot plot = new XYPlot(dataset, xAxis, yAxis, null);
/* 1855 */     plot.setOrientation(orientation);
/* 1856 */     plot.setForegroundAlpha(0.5F);
/*      */     
/* 1858 */     StandardXYToolTipGenerator standardXYToolTipGenerator = null;
/* 1859 */     if (tooltips) {
/* 1860 */       standardXYToolTipGenerator = new StandardXYToolTipGenerator();
/*      */     }
/*      */     
/* 1863 */     StandardXYURLGenerator standardXYURLGenerator = null;
/* 1864 */     if (urls) {
/* 1865 */       standardXYURLGenerator = new StandardXYURLGenerator();
/*      */     }
/*      */     
/* 1868 */     plot.setRenderer(new XYAreaRenderer(4, standardXYToolTipGenerator, standardXYURLGenerator));
/*      */     
/* 1870 */     JFreeChart chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT, plot, legend);
/*      */     
/* 1872 */     currentTheme.apply(chart);
/* 1873 */     return chart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1894 */   public static JFreeChart createStackedXYAreaChart(String title, String xAxisLabel, String yAxisLabel, TableXYDataset dataset) { return createStackedXYAreaChart(title, xAxisLabel, yAxisLabel, dataset, PlotOrientation.VERTICAL, true, true, false); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static JFreeChart createStackedXYAreaChart(String title, String xAxisLabel, String yAxisLabel, TableXYDataset dataset, PlotOrientation orientation, boolean legend, boolean tooltips, boolean urls) {
/* 1921 */     ParamChecks.nullNotPermitted(orientation, "orientation");
/* 1922 */     NumberAxis xAxis = new NumberAxis(xAxisLabel);
/* 1923 */     xAxis.setAutoRangeIncludesZero(false);
/* 1924 */     xAxis.setLowerMargin(0.0D);
/* 1925 */     xAxis.setUpperMargin(0.0D);
/* 1926 */     NumberAxis yAxis = new NumberAxis(yAxisLabel);
/* 1927 */     StandardXYToolTipGenerator standardXYToolTipGenerator = null;
/* 1928 */     if (tooltips) {
/* 1929 */       standardXYToolTipGenerator = new StandardXYToolTipGenerator();
/*      */     }
/*      */     
/* 1932 */     StandardXYURLGenerator standardXYURLGenerator = null;
/* 1933 */     if (urls) {
/* 1934 */       standardXYURLGenerator = new StandardXYURLGenerator();
/*      */     }
/* 1936 */     StackedXYAreaRenderer2 renderer = new StackedXYAreaRenderer2(standardXYToolTipGenerator, standardXYURLGenerator);
/*      */     
/* 1938 */     renderer.setOutline(true);
/* 1939 */     XYPlot plot = new XYPlot(dataset, xAxis, yAxis, renderer);
/* 1940 */     plot.setOrientation(orientation);
/*      */     
/* 1942 */     plot.setRangeAxis(yAxis);
/*      */     
/* 1944 */     JFreeChart chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT, plot, legend);
/*      */     
/* 1946 */     currentTheme.apply(chart);
/* 1947 */     return chart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1964 */   public static JFreeChart createXYLineChart(String title, String xAxisLabel, String yAxisLabel, XYDataset dataset) { return createXYLineChart(title, xAxisLabel, yAxisLabel, dataset, PlotOrientation.VERTICAL, true, true, false); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static JFreeChart createXYLineChart(String title, String xAxisLabel, String yAxisLabel, XYDataset dataset, PlotOrientation orientation, boolean legend, boolean tooltips, boolean urls) {
/* 1988 */     ParamChecks.nullNotPermitted(orientation, "orientation");
/* 1989 */     NumberAxis xAxis = new NumberAxis(xAxisLabel);
/* 1990 */     xAxis.setAutoRangeIncludesZero(false);
/* 1991 */     NumberAxis yAxis = new NumberAxis(yAxisLabel);
/* 1992 */     XYLineAndShapeRenderer xYLineAndShapeRenderer = new XYLineAndShapeRenderer(true, false);
/* 1993 */     XYPlot plot = new XYPlot(dataset, xAxis, yAxis, xYLineAndShapeRenderer);
/* 1994 */     plot.setOrientation(orientation);
/* 1995 */     if (tooltips) {
/* 1996 */       xYLineAndShapeRenderer.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
/*      */     }
/* 1998 */     if (urls) {
/* 1999 */       xYLineAndShapeRenderer.setURLGenerator(new StandardXYURLGenerator());
/*      */     }
/*      */     
/* 2002 */     JFreeChart chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT, plot, legend);
/*      */     
/* 2004 */     currentTheme.apply(chart);
/* 2005 */     return chart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 2023 */   public static JFreeChart createXYStepChart(String title, String xAxisLabel, String yAxisLabel, XYDataset dataset) { return createXYStepChart(title, xAxisLabel, yAxisLabel, dataset, PlotOrientation.VERTICAL, true, true, false); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static JFreeChart createXYStepChart(String title, String xAxisLabel, String yAxisLabel, XYDataset dataset, PlotOrientation orientation, boolean legend, boolean tooltips, boolean urls) {
/* 2046 */     ParamChecks.nullNotPermitted(orientation, "orientation");
/* 2047 */     DateAxis xAxis = new DateAxis(xAxisLabel);
/* 2048 */     NumberAxis yAxis = new NumberAxis(yAxisLabel);
/* 2049 */     yAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
/*      */     
/* 2051 */     StandardXYToolTipGenerator standardXYToolTipGenerator = null;
/* 2052 */     if (tooltips) {
/* 2053 */       standardXYToolTipGenerator = new StandardXYToolTipGenerator();
/*      */     }
/*      */     
/* 2056 */     StandardXYURLGenerator standardXYURLGenerator = null;
/* 2057 */     if (urls) {
/* 2058 */       standardXYURLGenerator = new StandardXYURLGenerator();
/*      */     }
/* 2060 */     XYStepRenderer xYStepRenderer = new XYStepRenderer(standardXYToolTipGenerator, standardXYURLGenerator);
/*      */ 
/*      */     
/* 2063 */     XYPlot plot = new XYPlot(dataset, xAxis, yAxis, null);
/* 2064 */     plot.setRenderer(xYStepRenderer);
/* 2065 */     plot.setOrientation(orientation);
/* 2066 */     plot.setDomainCrosshairVisible(false);
/* 2067 */     plot.setRangeCrosshairVisible(false);
/* 2068 */     JFreeChart chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT, plot, legend);
/*      */     
/* 2070 */     currentTheme.apply(chart);
/* 2071 */     return chart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 2089 */   public static JFreeChart createXYStepAreaChart(String title, String xAxisLabel, String yAxisLabel, XYDataset dataset) { return createXYStepAreaChart(title, xAxisLabel, yAxisLabel, dataset, PlotOrientation.VERTICAL, true, true, false); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static JFreeChart createXYStepAreaChart(String title, String xAxisLabel, String yAxisLabel, XYDataset dataset, PlotOrientation orientation, boolean legend, boolean tooltips, boolean urls) {
/* 2113 */     ParamChecks.nullNotPermitted(orientation, "orientation");
/* 2114 */     NumberAxis xAxis = new NumberAxis(xAxisLabel);
/* 2115 */     xAxis.setAutoRangeIncludesZero(false);
/* 2116 */     NumberAxis yAxis = new NumberAxis(yAxisLabel);
/*      */     
/* 2118 */     StandardXYToolTipGenerator standardXYToolTipGenerator = null;
/* 2119 */     if (tooltips) {
/* 2120 */       standardXYToolTipGenerator = new StandardXYToolTipGenerator();
/*      */     }
/*      */     
/* 2123 */     StandardXYURLGenerator standardXYURLGenerator = null;
/* 2124 */     if (urls) {
/* 2125 */       standardXYURLGenerator = new StandardXYURLGenerator();
/*      */     }
/* 2127 */     XYStepAreaRenderer xYStepAreaRenderer = new XYStepAreaRenderer(3, standardXYToolTipGenerator, standardXYURLGenerator);
/*      */ 
/*      */ 
/*      */     
/* 2131 */     XYPlot plot = new XYPlot(dataset, xAxis, yAxis, null);
/* 2132 */     plot.setRenderer(xYStepAreaRenderer);
/* 2133 */     plot.setOrientation(orientation);
/* 2134 */     plot.setDomainCrosshairVisible(false);
/* 2135 */     plot.setRangeCrosshairVisible(false);
/* 2136 */     JFreeChart chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT, plot, legend);
/*      */     
/* 2138 */     currentTheme.apply(chart);
/* 2139 */     return chart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 2164 */   public static JFreeChart createTimeSeriesChart(String title, String timeAxisLabel, String valueAxisLabel, XYDataset dataset) { return createTimeSeriesChart(title, timeAxisLabel, valueAxisLabel, dataset, true, true, false); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static JFreeChart createTimeSeriesChart(String title, String timeAxisLabel, String valueAxisLabel, XYDataset dataset, boolean legend, boolean tooltips, boolean urls) {
/* 2193 */     DateAxis dateAxis = new DateAxis(timeAxisLabel);
/* 2194 */     dateAxis.setLowerMargin(0.02D);
/* 2195 */     dateAxis.setUpperMargin(0.02D);
/* 2196 */     NumberAxis valueAxis = new NumberAxis(valueAxisLabel);
/* 2197 */     valueAxis.setAutoRangeIncludesZero(false);
/* 2198 */     XYPlot plot = new XYPlot(dataset, dateAxis, valueAxis, null);
/*      */     
/* 2200 */     StandardXYToolTipGenerator standardXYToolTipGenerator = null;
/* 2201 */     if (tooltips)
/*      */     {
/* 2203 */       standardXYToolTipGenerator = StandardXYToolTipGenerator.getTimeSeriesInstance();
/*      */     }
/*      */     
/* 2206 */     StandardXYURLGenerator standardXYURLGenerator = null;
/* 2207 */     if (urls) {
/* 2208 */       standardXYURLGenerator = new StandardXYURLGenerator();
/*      */     }
/*      */     
/* 2211 */     XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer(true, false);
/*      */     
/* 2213 */     renderer.setBaseToolTipGenerator(standardXYToolTipGenerator);
/* 2214 */     renderer.setURLGenerator(standardXYURLGenerator);
/* 2215 */     plot.setRenderer(renderer);
/*      */     
/* 2217 */     JFreeChart chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT, plot, legend);
/*      */     
/* 2219 */     currentTheme.apply(chart);
/* 2220 */     return chart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static JFreeChart createCandlestickChart(String title, String timeAxisLabel, String valueAxisLabel, OHLCDataset dataset, boolean legend) {
/* 2241 */     DateAxis dateAxis = new DateAxis(timeAxisLabel);
/* 2242 */     NumberAxis valueAxis = new NumberAxis(valueAxisLabel);
/* 2243 */     XYPlot plot = new XYPlot(dataset, dateAxis, valueAxis, null);
/* 2244 */     plot.setRenderer(new CandlestickRenderer());
/* 2245 */     JFreeChart chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT, plot, legend);
/*      */     
/* 2247 */     currentTheme.apply(chart);
/* 2248 */     return chart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static JFreeChart createHighLowChart(String title, String timeAxisLabel, String valueAxisLabel, OHLCDataset dataset, boolean legend) {
/* 2269 */     DateAxis dateAxis = new DateAxis(timeAxisLabel);
/* 2270 */     NumberAxis valueAxis = new NumberAxis(valueAxisLabel);
/* 2271 */     HighLowRenderer renderer = new HighLowRenderer();
/* 2272 */     renderer.setBaseToolTipGenerator(new HighLowItemLabelGenerator());
/* 2273 */     XYPlot plot = new XYPlot(dataset, dateAxis, valueAxis, renderer);
/* 2274 */     JFreeChart chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT, plot, legend);
/*      */     
/* 2276 */     currentTheme.apply(chart);
/* 2277 */     return chart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static JFreeChart createHighLowChart(String title, String timeAxisLabel, String valueAxisLabel, OHLCDataset dataset, Timeline timeline, boolean legend) {
/* 2303 */     DateAxis timeAxis = new DateAxis(timeAxisLabel);
/* 2304 */     timeAxis.setTimeline(timeline);
/* 2305 */     NumberAxis valueAxis = new NumberAxis(valueAxisLabel);
/* 2306 */     HighLowRenderer renderer = new HighLowRenderer();
/* 2307 */     renderer.setBaseToolTipGenerator(new HighLowItemLabelGenerator());
/* 2308 */     XYPlot plot = new XYPlot(dataset, timeAxis, valueAxis, renderer);
/* 2309 */     JFreeChart chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT, plot, legend);
/*      */     
/* 2311 */     currentTheme.apply(chart);
/* 2312 */     return chart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 2333 */   public static JFreeChart createBubbleChart(String title, String xAxisLabel, String yAxisLabel, XYZDataset dataset) { return createBubbleChart(title, xAxisLabel, yAxisLabel, dataset, PlotOrientation.VERTICAL, true, true, false); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static JFreeChart createBubbleChart(String title, String xAxisLabel, String yAxisLabel, XYZDataset dataset, PlotOrientation orientation, boolean legend, boolean tooltips, boolean urls) {
/* 2359 */     ParamChecks.nullNotPermitted(orientation, "orientation");
/* 2360 */     NumberAxis xAxis = new NumberAxis(xAxisLabel);
/* 2361 */     xAxis.setAutoRangeIncludesZero(false);
/* 2362 */     NumberAxis yAxis = new NumberAxis(yAxisLabel);
/* 2363 */     yAxis.setAutoRangeIncludesZero(false);
/*      */     
/* 2365 */     XYPlot plot = new XYPlot(dataset, xAxis, yAxis, null);
/*      */     
/* 2367 */     XYBubbleRenderer xYBubbleRenderer = new XYBubbleRenderer(2);
/*      */     
/* 2369 */     if (tooltips) {
/* 2370 */       xYBubbleRenderer.setBaseToolTipGenerator(new StandardXYZToolTipGenerator());
/*      */     }
/* 2372 */     if (urls) {
/* 2373 */       xYBubbleRenderer.setURLGenerator(new StandardXYZURLGenerator());
/*      */     }
/* 2375 */     plot.setRenderer(xYBubbleRenderer);
/* 2376 */     plot.setOrientation(orientation);
/*      */     
/* 2378 */     JFreeChart chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT, plot, legend);
/*      */     
/* 2380 */     currentTheme.apply(chart);
/* 2381 */     return chart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static JFreeChart createHistogram(String title, String xAxisLabel, String yAxisLabel, IntervalXYDataset dataset, PlotOrientation orientation, boolean legend, boolean tooltips, boolean urls) {
/* 2407 */     ParamChecks.nullNotPermitted(orientation, "orientation");
/* 2408 */     NumberAxis xAxis = new NumberAxis(xAxisLabel);
/* 2409 */     xAxis.setAutoRangeIncludesZero(false);
/* 2410 */     NumberAxis numberAxis = new NumberAxis(yAxisLabel);
/*      */     
/* 2412 */     XYBarRenderer xYBarRenderer = new XYBarRenderer();
/* 2413 */     if (tooltips) {
/* 2414 */       xYBarRenderer.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
/*      */     }
/* 2416 */     if (urls) {
/* 2417 */       xYBarRenderer.setURLGenerator(new StandardXYURLGenerator());
/*      */     }
/*      */     
/* 2420 */     XYPlot plot = new XYPlot(dataset, xAxis, numberAxis, xYBarRenderer);
/* 2421 */     plot.setOrientation(orientation);
/* 2422 */     plot.setDomainZeroBaselineVisible(true);
/* 2423 */     plot.setRangeZeroBaselineVisible(true);
/* 2424 */     JFreeChart chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT, plot, legend);
/*      */     
/* 2426 */     currentTheme.apply(chart);
/* 2427 */     return chart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static JFreeChart createBoxAndWhiskerChart(String title, String categoryAxisLabel, String valueAxisLabel, BoxAndWhiskerCategoryDataset dataset, boolean legend) {
/* 2451 */     CategoryAxis categoryAxis = new CategoryAxis(categoryAxisLabel);
/* 2452 */     NumberAxis valueAxis = new NumberAxis(valueAxisLabel);
/* 2453 */     valueAxis.setAutoRangeIncludesZero(false);
/*      */     
/* 2455 */     BoxAndWhiskerRenderer renderer = new BoxAndWhiskerRenderer();
/* 2456 */     renderer.setBaseToolTipGenerator(new BoxAndWhiskerToolTipGenerator());
/*      */     
/* 2458 */     CategoryPlot plot = new CategoryPlot(dataset, categoryAxis, valueAxis, renderer);
/*      */     
/* 2460 */     JFreeChart chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT, plot, legend);
/*      */     
/* 2462 */     currentTheme.apply(chart);
/* 2463 */     return chart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static JFreeChart createBoxAndWhiskerChart(String title, String timeAxisLabel, String valueAxisLabel, BoxAndWhiskerXYDataset dataset, boolean legend) {
/* 2483 */     DateAxis dateAxis = new DateAxis(timeAxisLabel);
/* 2484 */     NumberAxis valueAxis = new NumberAxis(valueAxisLabel);
/* 2485 */     valueAxis.setAutoRangeIncludesZero(false);
/* 2486 */     XYBoxAndWhiskerRenderer renderer = new XYBoxAndWhiskerRenderer(10.0D);
/* 2487 */     XYPlot plot = new XYPlot(dataset, dateAxis, valueAxis, renderer);
/* 2488 */     JFreeChart chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT, plot, legend);
/*      */     
/* 2490 */     currentTheme.apply(chart);
/* 2491 */     return chart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static JFreeChart createWindPlot(String title, String xAxisLabel, String yAxisLabel, WindDataset dataset, boolean legend, boolean tooltips, boolean urls) {
/* 2513 */     DateAxis dateAxis = new DateAxis(xAxisLabel);
/* 2514 */     NumberAxis numberAxis = new NumberAxis(yAxisLabel);
/* 2515 */     numberAxis.setRange(-12.0D, 12.0D);
/*      */     
/* 2517 */     WindItemRenderer renderer = new WindItemRenderer();
/* 2518 */     if (tooltips) {
/* 2519 */       renderer.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
/*      */     }
/* 2521 */     if (urls) {
/* 2522 */       renderer.setURLGenerator(new StandardXYURLGenerator());
/*      */     }
/* 2524 */     XYPlot plot = new XYPlot(dataset, dateAxis, numberAxis, renderer);
/* 2525 */     JFreeChart chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT, plot, legend);
/*      */     
/* 2527 */     currentTheme.apply(chart);
/* 2528 */     return chart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static JFreeChart createWaferMapChart(String title, WaferMapDataset dataset, PlotOrientation orientation, boolean legend, boolean tooltips, boolean urls) {
/* 2549 */     ParamChecks.nullNotPermitted(orientation, "orientation");
/* 2550 */     WaferMapPlot plot = new WaferMapPlot(dataset);
/* 2551 */     WaferMapRenderer renderer = new WaferMapRenderer();
/* 2552 */     plot.setRenderer(renderer);
/*      */     
/* 2554 */     JFreeChart chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT, plot, legend);
/*      */     
/* 2556 */     currentTheme.apply(chart);
/* 2557 */     return chart;
/*      */   }
/*      */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/ChartFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */