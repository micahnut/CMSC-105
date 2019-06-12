/*      */ package org.jfree.chart.renderer.xy;
/*      */ 
/*      */ import java.awt.Graphics2D;
/*      */ import java.awt.Image;
/*      */ import java.awt.Paint;
/*      */ import java.awt.Point;
/*      */ import java.awt.Shape;
/*      */ import java.awt.Stroke;
/*      */ import java.awt.geom.GeneralPath;
/*      */ import java.awt.geom.Line2D;
/*      */ import java.awt.geom.Rectangle2D;
/*      */ import java.io.IOException;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.io.ObjectOutputStream;
/*      */ import java.io.Serializable;
/*      */ import org.jfree.chart.LegendItem;
/*      */ import org.jfree.chart.axis.ValueAxis;
/*      */ import org.jfree.chart.entity.EntityCollection;
/*      */ import org.jfree.chart.labels.XYToolTipGenerator;
/*      */ import org.jfree.chart.plot.CrosshairState;
/*      */ import org.jfree.chart.plot.Plot;
/*      */ import org.jfree.chart.plot.PlotOrientation;
/*      */ import org.jfree.chart.plot.PlotRenderingInfo;
/*      */ import org.jfree.chart.plot.XYPlot;
/*      */ import org.jfree.chart.urls.XYURLGenerator;
/*      */ import org.jfree.chart.util.ParamChecks;
/*      */ import org.jfree.data.xy.XYDataset;
/*      */ import org.jfree.io.SerialUtilities;
/*      */ import org.jfree.ui.RectangleEdge;
/*      */ import org.jfree.util.BooleanList;
/*      */ import org.jfree.util.BooleanUtilities;
/*      */ import org.jfree.util.ObjectUtilities;
/*      */ import org.jfree.util.PublicCloneable;
/*      */ import org.jfree.util.ShapeUtilities;
/*      */ import org.jfree.util.UnitType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class StandardXYItemRenderer
/*      */   extends AbstractXYItemRenderer
/*      */   implements XYItemRenderer, Cloneable, PublicCloneable, Serializable
/*      */ {
/*      */   private static final long serialVersionUID = -3271351259436865995L;
/*      */   public static final int SHAPES = 1;
/*      */   public static final int LINES = 2;
/*      */   public static final int SHAPES_AND_LINES = 3;
/*      */   public static final int IMAGES = 4;
/*      */   public static final int DISCONTINUOUS = 8;
/*      */   public static final int DISCONTINUOUS_LINES = 10;
/*      */   private boolean baseShapesVisible;
/*      */   private boolean plotLines;
/*      */   private boolean plotImages;
/*      */   private boolean plotDiscontinuous;
/*  194 */   private UnitType gapThresholdType = UnitType.RELATIVE;
/*      */ 
/*      */   
/*  197 */   private double gapThreshold = 1.0D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Boolean shapesFilled;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private BooleanList seriesShapesFilled;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean baseShapesFilled;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean drawSeriesLineAsPath;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Shape legendLine;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  231 */   public StandardXYItemRenderer() { this(2, null); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  242 */   public StandardXYItemRenderer(int type) { this(type, null); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  256 */   public StandardXYItemRenderer(int type, XYToolTipGenerator toolTipGenerator) { this(type, toolTipGenerator, null); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StandardXYItemRenderer(int type, XYToolTipGenerator toolTipGenerator, XYURLGenerator urlGenerator) {
/*  274 */     setBaseToolTipGenerator(toolTipGenerator);
/*  275 */     setURLGenerator(urlGenerator);
/*  276 */     if ((type & true) != 0) {
/*  277 */       this.baseShapesVisible = true;
/*      */     }
/*  279 */     if ((type & 0x2) != 0) {
/*  280 */       this.plotLines = true;
/*      */     }
/*  282 */     if ((type & 0x4) != 0) {
/*  283 */       this.plotImages = true;
/*      */     }
/*  285 */     if ((type & 0x8) != 0) {
/*  286 */       this.plotDiscontinuous = true;
/*      */     }
/*      */     
/*  289 */     this.shapesFilled = null;
/*  290 */     this.seriesShapesFilled = new BooleanList();
/*  291 */     this.baseShapesFilled = true;
/*  292 */     this.legendLine = new Line2D.Double(-7.0D, 0.0D, 7.0D, 0.0D);
/*  293 */     this.drawSeriesLineAsPath = false;
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
/*  304 */   public boolean getBaseShapesVisible() { return this.baseShapesVisible; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBaseShapesVisible(boolean flag) {
/*  316 */     if (this.baseShapesVisible != flag) {
/*  317 */       this.baseShapesVisible = flag;
/*  318 */       fireChangeEvent();
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
/*      */   public boolean getItemShapeFilled(int series, int item) {
/*  341 */     if (this.shapesFilled != null) {
/*  342 */       return this.shapesFilled.booleanValue();
/*      */     }
/*      */ 
/*      */     
/*  346 */     Boolean flag = this.seriesShapesFilled.getBoolean(series);
/*  347 */     if (flag != null) {
/*  348 */       return flag.booleanValue();
/*      */     }
/*      */     
/*  351 */     return this.baseShapesFilled;
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
/*  368 */   public Boolean getShapesFilled() { return this.shapesFilled; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  387 */   public void setShapesFilled(boolean filled) { setShapesFilled(BooleanUtilities.valueOf(filled)); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setShapesFilled(Boolean filled) {
/*  405 */     this.shapesFilled = filled;
/*  406 */     fireChangeEvent();
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
/*  418 */   public Boolean getSeriesShapesFilled(int series) { return this.seriesShapesFilled.getBoolean(series); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSeriesShapesFilled(int series, Boolean flag) {
/*  431 */     this.seriesShapesFilled.setBoolean(series, flag);
/*  432 */     fireChangeEvent();
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
/*  443 */   public boolean getBaseShapesFilled() { return this.baseShapesFilled; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  455 */   public void setBaseShapesFilled(boolean flag) { this.baseShapesFilled = flag; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  466 */   public boolean getPlotLines() { return this.plotLines; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPlotLines(boolean flag) {
/*  479 */     if (this.plotLines != flag) {
/*  480 */       this.plotLines = flag;
/*  481 */       fireChangeEvent();
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
/*  493 */   public UnitType getGapThresholdType() { return this.gapThresholdType; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setGapThresholdType(UnitType thresholdType) {
/*  505 */     ParamChecks.nullNotPermitted(thresholdType, "thresholdType");
/*  506 */     this.gapThresholdType = thresholdType;
/*  507 */     fireChangeEvent();
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
/*  518 */   public double getGapThreshold() { return this.gapThreshold; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setGapThreshold(double t) {
/*  530 */     this.gapThreshold = t;
/*  531 */     fireChangeEvent();
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
/*  542 */   public boolean getPlotImages() { return this.plotImages; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPlotImages(boolean flag) {
/*  555 */     if (this.plotImages != flag) {
/*  556 */       this.plotImages = flag;
/*  557 */       fireChangeEvent();
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
/*  568 */   public boolean getPlotDiscontinuous() { return this.plotDiscontinuous; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPlotDiscontinuous(boolean flag) {
/*  581 */     if (this.plotDiscontinuous != flag) {
/*  582 */       this.plotDiscontinuous = flag;
/*  583 */       fireChangeEvent();
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
/*  596 */   public boolean getDrawSeriesLineAsPath() { return this.drawSeriesLineAsPath; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  608 */   public void setDrawSeriesLineAsPath(boolean flag) { this.drawSeriesLineAsPath = flag; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  619 */   public Shape getLegendLine() { return this.legendLine; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLegendLine(Shape line) {
/*  631 */     ParamChecks.nullNotPermitted(line, "line");
/*  632 */     this.legendLine = line;
/*  633 */     fireChangeEvent();
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
/*      */   public LegendItem getLegendItem(int datasetIndex, int series) {
/*  646 */     XYPlot plot = getPlot();
/*  647 */     if (plot == null) {
/*  648 */       return null;
/*      */     }
/*  650 */     LegendItem result = null;
/*  651 */     XYDataset dataset = plot.getDataset(datasetIndex);
/*  652 */     if (dataset != null && 
/*  653 */       getItemVisible(series, 0)) {
/*  654 */       String label = getLegendItemLabelGenerator().generateLabel(dataset, series);
/*      */       
/*  656 */       String description = label;
/*  657 */       String toolTipText = null;
/*  658 */       if (getLegendItemToolTipGenerator() != null) {
/*  659 */         toolTipText = getLegendItemToolTipGenerator().generateLabel(dataset, series);
/*      */       }
/*      */       
/*  662 */       String urlText = null;
/*  663 */       if (getLegendItemURLGenerator() != null) {
/*  664 */         urlText = getLegendItemURLGenerator().generateLabel(dataset, series);
/*      */       }
/*      */       
/*  667 */       Shape shape = lookupLegendShape(series);
/*  668 */       boolean shapeFilled = getItemShapeFilled(series, 0);
/*  669 */       Paint paint = lookupSeriesPaint(series);
/*  670 */       Paint linePaint = paint;
/*  671 */       Stroke lineStroke = lookupSeriesStroke(series);
/*  672 */       result = new LegendItem(label, description, toolTipText, urlText, this.baseShapesVisible, shape, shapeFilled, paint, !shapeFilled ? 1 : 0, paint, lineStroke, this.plotLines, this.legendLine, lineStroke, linePaint);
/*      */ 
/*      */ 
/*      */       
/*  676 */       result.setLabelFont(lookupLegendTextFont(series));
/*  677 */       Paint labelPaint = lookupLegendTextPaint(series);
/*  678 */       if (labelPaint != null) {
/*  679 */         result.setLabelPaint(labelPaint);
/*      */       }
/*  681 */       result.setDataset(dataset);
/*  682 */       result.setDatasetIndex(datasetIndex);
/*  683 */       result.setSeriesKey(dataset.getSeriesKey(series));
/*  684 */       result.setSeriesIndex(series);
/*      */     } 
/*      */     
/*  687 */     return result;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class State
/*      */     extends XYItemRendererState
/*      */   {
/*      */     public GeneralPath seriesPath;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private int seriesIndex;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private boolean lastPointGood;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  715 */     public State(PlotRenderingInfo info) { super(info); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  725 */     public boolean isLastPointGood() { return this.lastPointGood; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  735 */     public void setLastPointGood(boolean good) { this.lastPointGood = good; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  744 */     public int getSeriesIndex() { return this.seriesIndex; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  753 */     public void setSeriesIndex(int index) { this.seriesIndex = index; }
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
/*      */   public XYItemRendererState initialise(Graphics2D g2, Rectangle2D dataArea, XYPlot plot, XYDataset data, PlotRenderingInfo info) {
/*  777 */     State state = new State(info);
/*  778 */     state.seriesPath = new GeneralPath();
/*  779 */     state.seriesIndex = -1;
/*  780 */     return state;
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
/*      */   public void drawItem(Graphics2D g2, XYItemRendererState state, Rectangle2D dataArea, PlotRenderingInfo info, XYPlot plot, ValueAxis domainAxis, ValueAxis rangeAxis, XYDataset dataset, int series, int item, CrosshairState crosshairState, int pass) {
/*  808 */     boolean itemVisible = getItemVisible(series, item);
/*      */ 
/*      */     
/*  811 */     Shape entityArea = null;
/*  812 */     EntityCollection entities = null;
/*  813 */     if (info != null) {
/*  814 */       entities = info.getOwner().getEntityCollection();
/*      */     }
/*      */     
/*  817 */     PlotOrientation orientation = plot.getOrientation();
/*  818 */     Paint paint = getItemPaint(series, item);
/*  819 */     Stroke seriesStroke = getItemStroke(series, item);
/*  820 */     g2.setPaint(paint);
/*  821 */     g2.setStroke(seriesStroke);
/*      */ 
/*      */     
/*  824 */     double x1 = dataset.getXValue(series, item);
/*  825 */     double y1 = dataset.getYValue(series, item);
/*  826 */     if (Double.isNaN(x1) || Double.isNaN(y1)) {
/*  827 */       itemVisible = false;
/*      */     }
/*      */     
/*  830 */     RectangleEdge xAxisLocation = plot.getDomainAxisEdge();
/*  831 */     RectangleEdge yAxisLocation = plot.getRangeAxisEdge();
/*  832 */     double transX1 = domainAxis.valueToJava2D(x1, dataArea, xAxisLocation);
/*  833 */     double transY1 = rangeAxis.valueToJava2D(y1, dataArea, yAxisLocation);
/*      */     
/*  835 */     if (getPlotLines()) {
/*  836 */       if (this.drawSeriesLineAsPath) {
/*  837 */         State s = (State)state;
/*  838 */         if (s.getSeriesIndex() != series) {
/*      */           
/*  840 */           s.seriesPath.reset();
/*  841 */           s.lastPointGood = false;
/*  842 */           s.setSeriesIndex(series);
/*      */         } 
/*      */ 
/*      */         
/*  846 */         if (itemVisible && !Double.isNaN(transX1) && 
/*  847 */           !Double.isNaN(transY1)) {
/*  848 */           float x = (float)transX1;
/*  849 */           float y = (float)transY1;
/*  850 */           if (orientation == PlotOrientation.HORIZONTAL) {
/*  851 */             x = (float)transY1;
/*  852 */             y = (float)transX1;
/*      */           } 
/*  854 */           if (s.isLastPointGood()) {
/*      */             
/*  856 */             s.seriesPath.lineTo(x, y);
/*      */           } else {
/*      */             
/*  859 */             s.seriesPath.moveTo(x, y);
/*      */           } 
/*  861 */           s.setLastPointGood(true);
/*      */         } else {
/*      */           
/*  864 */           s.setLastPointGood(false);
/*      */         } 
/*  866 */         if (item == dataset.getItemCount(series) - 1 && 
/*  867 */           s.seriesIndex == series)
/*      */         {
/*  869 */           g2.setStroke(lookupSeriesStroke(series));
/*  870 */           g2.setPaint(lookupSeriesPaint(series));
/*  871 */           g2.draw(s.seriesPath);
/*      */         
/*      */         }
/*      */       
/*      */       }
/*  876 */       else if (item != 0 && itemVisible) {
/*      */         
/*  878 */         double x0 = dataset.getXValue(series, item - 1);
/*  879 */         double y0 = dataset.getYValue(series, item - 1);
/*  880 */         if (!Double.isNaN(x0) && !Double.isNaN(y0)) {
/*  881 */           boolean drawLine = true;
/*  882 */           if (getPlotDiscontinuous()) {
/*      */ 
/*      */             
/*  885 */             int numX = dataset.getItemCount(series);
/*  886 */             double minX = dataset.getXValue(series, 0);
/*  887 */             double maxX = dataset.getXValue(series, numX - 1);
/*  888 */             if (this.gapThresholdType == UnitType.ABSOLUTE) {
/*  889 */               drawLine = (Math.abs(x1 - x0) <= this.gapThreshold);
/*      */             }
/*      */             else {
/*      */               
/*  893 */               drawLine = (Math.abs(x1 - x0) <= (maxX - minX) / numX * getGapThreshold());
/*      */             } 
/*      */           } 
/*  896 */           if (drawLine) {
/*  897 */             double transX0 = domainAxis.valueToJava2D(x0, dataArea, xAxisLocation);
/*      */             
/*  899 */             double transY0 = rangeAxis.valueToJava2D(y0, dataArea, yAxisLocation);
/*      */ 
/*      */ 
/*      */             
/*  903 */             if (Double.isNaN(transX0) || Double.isNaN(transY0) || 
/*  904 */               Double.isNaN(transX1) || Double.isNaN(transY1)) {
/*      */               return;
/*      */             }
/*      */             
/*  908 */             if (orientation == PlotOrientation.HORIZONTAL) {
/*  909 */               state.workingLine.setLine(transY0, transX0, transY1, transX1);
/*      */             
/*      */             }
/*  912 */             else if (orientation == PlotOrientation.VERTICAL) {
/*  913 */               state.workingLine.setLine(transX0, transY0, transX1, transY1);
/*      */             } 
/*      */ 
/*      */             
/*  917 */             if (state.workingLine.intersects(dataArea)) {
/*  918 */               g2.draw(state.workingLine);
/*      */             }
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  928 */     if (!itemVisible) {
/*      */       return;
/*      */     }
/*      */     
/*  932 */     if (getBaseShapesVisible()) {
/*      */       
/*  934 */       Shape shape = getItemShape(series, item);
/*  935 */       if (orientation == PlotOrientation.HORIZONTAL) {
/*  936 */         shape = ShapeUtilities.createTranslatedShape(shape, transY1, transX1);
/*      */       
/*      */       }
/*  939 */       else if (orientation == PlotOrientation.VERTICAL) {
/*  940 */         shape = ShapeUtilities.createTranslatedShape(shape, transX1, transY1);
/*      */       } 
/*      */       
/*  943 */       if (shape.intersects(dataArea)) {
/*  944 */         if (getItemShapeFilled(series, item)) {
/*  945 */           g2.fill(shape);
/*      */         } else {
/*      */           
/*  948 */           g2.draw(shape);
/*      */         } 
/*      */       }
/*  951 */       entityArea = shape;
/*      */     } 
/*      */ 
/*      */     
/*  955 */     if (getPlotImages()) {
/*  956 */       Image image = getImage(plot, series, item, transX1, transY1);
/*  957 */       if (image != null) {
/*  958 */         Point hotspot = getImageHotspot(plot, series, item, transX1, transY1, image);
/*      */         
/*  960 */         g2.drawImage(image, (int)(transX1 - hotspot.getX()), 
/*  961 */             (int)(transY1 - hotspot.getY()), null);
/*      */ 
/*      */         
/*  964 */         entityArea = new Rectangle2D.Double(transX1 - hotspot.getX(), transY1 - hotspot.getY(), image.getWidth(null), image.getHeight(null));
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  969 */     double xx = transX1;
/*  970 */     double yy = transY1;
/*  971 */     if (orientation == PlotOrientation.HORIZONTAL) {
/*  972 */       xx = transY1;
/*  973 */       yy = transX1;
/*      */     } 
/*      */ 
/*      */     
/*  977 */     if (isItemLabelVisible(series, item)) {
/*  978 */       drawItemLabel(g2, orientation, dataset, series, item, xx, yy, (y1 < 0.0D));
/*      */     }
/*      */ 
/*      */     
/*  982 */     int domainAxisIndex = plot.getDomainAxisIndex(domainAxis);
/*  983 */     int rangeAxisIndex = plot.getRangeAxisIndex(rangeAxis);
/*  984 */     updateCrosshairValues(crosshairState, x1, y1, domainAxisIndex, rangeAxisIndex, transX1, transY1, orientation);
/*      */ 
/*      */ 
/*      */     
/*  988 */     if (entities != null && isPointInRect(dataArea, xx, yy)) {
/*  989 */       addEntity(entities, entityArea, dataset, series, item, xx, yy);
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
/*      */   public boolean equals(Object obj) {
/* 1004 */     if (obj == this) {
/* 1005 */       return true;
/*      */     }
/* 1007 */     if (!(obj instanceof StandardXYItemRenderer)) {
/* 1008 */       return false;
/*      */     }
/* 1010 */     StandardXYItemRenderer that = (StandardXYItemRenderer)obj;
/* 1011 */     if (this.baseShapesVisible != that.baseShapesVisible) {
/* 1012 */       return false;
/*      */     }
/* 1014 */     if (this.plotLines != that.plotLines) {
/* 1015 */       return false;
/*      */     }
/* 1017 */     if (this.plotImages != that.plotImages) {
/* 1018 */       return false;
/*      */     }
/* 1020 */     if (this.plotDiscontinuous != that.plotDiscontinuous) {
/* 1021 */       return false;
/*      */     }
/* 1023 */     if (this.gapThresholdType != that.gapThresholdType) {
/* 1024 */       return false;
/*      */     }
/* 1026 */     if (this.gapThreshold != that.gapThreshold) {
/* 1027 */       return false;
/*      */     }
/* 1029 */     if (!ObjectUtilities.equal(this.shapesFilled, that.shapesFilled)) {
/* 1030 */       return false;
/*      */     }
/* 1032 */     if (!this.seriesShapesFilled.equals(that.seriesShapesFilled)) {
/* 1033 */       return false;
/*      */     }
/* 1035 */     if (this.baseShapesFilled != that.baseShapesFilled) {
/* 1036 */       return false;
/*      */     }
/* 1038 */     if (this.drawSeriesLineAsPath != that.drawSeriesLineAsPath) {
/* 1039 */       return false;
/*      */     }
/* 1041 */     if (!ShapeUtilities.equal(this.legendLine, that.legendLine)) {
/* 1042 */       return false;
/*      */     }
/* 1044 */     return super.equals(obj);
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
/*      */   public Object clone() throws CloneNotSupportedException {
/* 1057 */     StandardXYItemRenderer clone = (StandardXYItemRenderer)super.clone();
/* 1058 */     clone
/* 1059 */       .seriesShapesFilled = (BooleanList)this.seriesShapesFilled.clone();
/* 1060 */     clone.legendLine = ShapeUtilities.clone(this.legendLine);
/* 1061 */     return clone;
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
/* 1087 */   protected Image getImage(Plot plot, int series, int item, double x, double y) { return null; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Point getImageHotspot(Plot plot, int series, int item, double x, double y, Image image) {
/* 1110 */     int height = image.getHeight(null);
/* 1111 */     int width = image.getWidth(null);
/* 1112 */     return new Point(width / 2, height / 2);
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
/*      */   private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
/* 1126 */     stream.defaultReadObject();
/* 1127 */     this.legendLine = SerialUtilities.readShape(stream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void writeObject(ObjectOutputStream stream) throws IOException {
/* 1138 */     stream.defaultWriteObject();
/* 1139 */     SerialUtilities.writeShape(this.legendLine, stream);
/*      */   }
/*      */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/renderer/xy/StandardXYItemRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */