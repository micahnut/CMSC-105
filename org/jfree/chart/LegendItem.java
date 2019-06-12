/*      */ package org.jfree.chart;
/*      */ 
/*      */ import java.awt.BasicStroke;
/*      */ import java.awt.Color;
/*      */ import java.awt.Font;
/*      */ import java.awt.Paint;
/*      */ import java.awt.Shape;
/*      */ import java.awt.Stroke;
/*      */ import java.awt.geom.Line2D;
/*      */ import java.awt.geom.Rectangle2D;
/*      */ import java.io.IOException;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.io.ObjectOutputStream;
/*      */ import java.io.Serializable;
/*      */ import java.text.AttributedString;
/*      */ import java.text.CharacterIterator;
/*      */ import org.jfree.chart.util.ParamChecks;
/*      */ import org.jfree.data.general.Dataset;
/*      */ import org.jfree.io.SerialUtilities;
/*      */ import org.jfree.ui.GradientPaintTransformer;
/*      */ import org.jfree.ui.StandardGradientPaintTransformer;
/*      */ import org.jfree.util.AttributedStringUtilities;
/*      */ import org.jfree.util.ObjectUtilities;
/*      */ import org.jfree.util.PaintUtilities;
/*      */ import org.jfree.util.PublicCloneable;
/*      */ import org.jfree.util.ShapeUtilities;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class LegendItem
/*      */   implements Cloneable, Serializable
/*      */ {
/*      */   private static final long serialVersionUID = -797214582948827144L;
/*      */   private Dataset dataset;
/*      */   private Comparable seriesKey;
/*      */   private int datasetIndex;
/*      */   private int series;
/*      */   private String label;
/*      */   private Font labelFont;
/*      */   private Paint labelPaint;
/*      */   private AttributedString attributedLabel;
/*      */   private String description;
/*      */   private String toolTipText;
/*      */   private String urlText;
/*      */   private boolean shapeVisible;
/*      */   private Shape shape;
/*      */   private boolean shapeFilled;
/*      */   private Paint fillPaint;
/*      */   private GradientPaintTransformer fillPaintTransformer;
/*      */   private boolean shapeOutlineVisible;
/*      */   private Paint outlinePaint;
/*      */   private Stroke outlineStroke;
/*      */   private boolean lineVisible;
/*      */   private Shape line;
/*      */   private Stroke lineStroke;
/*      */   private Paint linePaint;
/*  197 */   private static final Shape UNUSED_SHAPE = new Line2D.Float();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  203 */   private static final Stroke UNUSED_STROKE = new BasicStroke(0.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  214 */   public LegendItem(String label) { this(label, Color.black); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  227 */   public LegendItem(String label, Paint paint) { this(label, null, null, null, new Rectangle2D.Double(-4.0D, -4.0D, 8.0D, 8.0D), paint); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  247 */   public LegendItem(String label, String description, String toolTipText, String urlText, Shape shape, Paint fillPaint) { this(label, description, toolTipText, urlText, true, shape, true, fillPaint, false, Color.black, UNUSED_STROKE, false, UNUSED_SHAPE, UNUSED_STROKE, Color.black); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  275 */   public LegendItem(String label, String description, String toolTipText, String urlText, Shape shape, Paint fillPaint, Stroke outlineStroke, Paint outlinePaint) { this(label, description, toolTipText, urlText, true, shape, true, fillPaint, true, outlinePaint, outlineStroke, false, UNUSED_SHAPE, UNUSED_STROKE, Color.black); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  298 */   public LegendItem(String label, String description, String toolTipText, String urlText, Shape line, Stroke lineStroke, Paint linePaint) { this(label, description, toolTipText, urlText, false, UNUSED_SHAPE, false, Color.black, false, Color.black, UNUSED_STROKE, true, line, lineStroke, linePaint); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public LegendItem(String label, String description, String toolTipText, String urlText, boolean shapeVisible, Shape shape, boolean shapeFilled, Paint fillPaint, boolean shapeOutlineVisible, Paint outlinePaint, Stroke outlineStroke, boolean lineVisible, Shape line, Stroke lineStroke, Paint linePaint) {
/*  339 */     ParamChecks.nullNotPermitted(label, "label");
/*  340 */     ParamChecks.nullNotPermitted(fillPaint, "fillPaint");
/*  341 */     ParamChecks.nullNotPermitted(lineStroke, "lineStroke");
/*  342 */     ParamChecks.nullNotPermitted(outlinePaint, "outlinePaint");
/*  343 */     ParamChecks.nullNotPermitted(outlineStroke, "outlineStroke");
/*  344 */     this.label = label;
/*  345 */     this.labelPaint = null;
/*  346 */     this.attributedLabel = null;
/*  347 */     this.description = description;
/*  348 */     this.shapeVisible = shapeVisible;
/*  349 */     this.shape = shape;
/*  350 */     this.shapeFilled = shapeFilled;
/*  351 */     this.fillPaint = fillPaint;
/*  352 */     this.fillPaintTransformer = new StandardGradientPaintTransformer();
/*  353 */     this.shapeOutlineVisible = shapeOutlineVisible;
/*  354 */     this.outlinePaint = outlinePaint;
/*  355 */     this.outlineStroke = outlineStroke;
/*  356 */     this.lineVisible = lineVisible;
/*  357 */     this.line = line;
/*  358 */     this.lineStroke = lineStroke;
/*  359 */     this.linePaint = linePaint;
/*  360 */     this.toolTipText = toolTipText;
/*  361 */     this.urlText = urlText;
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
/*  380 */   public LegendItem(AttributedString label, String description, String toolTipText, String urlText, Shape shape, Paint fillPaint) { this(label, description, toolTipText, urlText, true, shape, true, fillPaint, false, Color.black, UNUSED_STROKE, false, UNUSED_SHAPE, UNUSED_STROKE, Color.black); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  409 */   public LegendItem(AttributedString label, String description, String toolTipText, String urlText, Shape shape, Paint fillPaint, Stroke outlineStroke, Paint outlinePaint) { this(label, description, toolTipText, urlText, true, shape, true, fillPaint, true, outlinePaint, outlineStroke, false, UNUSED_SHAPE, UNUSED_STROKE, Color.black); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  432 */   public LegendItem(AttributedString label, String description, String toolTipText, String urlText, Shape line, Stroke lineStroke, Paint linePaint) { this(label, description, toolTipText, urlText, false, UNUSED_SHAPE, false, Color.black, false, Color.black, UNUSED_STROKE, true, line, lineStroke, linePaint); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public LegendItem(AttributedString label, String description, String toolTipText, String urlText, boolean shapeVisible, Shape shape, boolean shapeFilled, Paint fillPaint, boolean shapeOutlineVisible, Paint outlinePaint, Stroke outlineStroke, boolean lineVisible, Shape line, Stroke lineStroke, Paint linePaint) {
/*  473 */     ParamChecks.nullNotPermitted(label, "label");
/*  474 */     ParamChecks.nullNotPermitted(fillPaint, "fillPaint");
/*  475 */     ParamChecks.nullNotPermitted(lineStroke, "lineStroke");
/*  476 */     ParamChecks.nullNotPermitted(line, "line");
/*  477 */     ParamChecks.nullNotPermitted(linePaint, "linePaint");
/*  478 */     ParamChecks.nullNotPermitted(outlinePaint, "outlinePaint");
/*  479 */     ParamChecks.nullNotPermitted(outlineStroke, "outlineStroke");
/*  480 */     this.label = characterIteratorToString(label.getIterator());
/*  481 */     this.attributedLabel = label;
/*  482 */     this.description = description;
/*  483 */     this.shapeVisible = shapeVisible;
/*  484 */     this.shape = shape;
/*  485 */     this.shapeFilled = shapeFilled;
/*  486 */     this.fillPaint = fillPaint;
/*  487 */     this.fillPaintTransformer = new StandardGradientPaintTransformer();
/*  488 */     this.shapeOutlineVisible = shapeOutlineVisible;
/*  489 */     this.outlinePaint = outlinePaint;
/*  490 */     this.outlineStroke = outlineStroke;
/*  491 */     this.lineVisible = lineVisible;
/*  492 */     this.line = line;
/*  493 */     this.lineStroke = lineStroke;
/*  494 */     this.linePaint = linePaint;
/*  495 */     this.toolTipText = toolTipText;
/*  496 */     this.urlText = urlText;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String characterIteratorToString(CharacterIterator iterator) {
/*  507 */     int endIndex = iterator.getEndIndex();
/*  508 */     int beginIndex = iterator.getBeginIndex();
/*  509 */     int count = endIndex - beginIndex;
/*  510 */     if (count <= 0) {
/*  511 */       return "";
/*      */     }
/*  513 */     char[] chars = new char[count];
/*  514 */     int i = 0;
/*  515 */     char c = iterator.first();
/*  516 */     while (c != Character.MAX_VALUE) {
/*  517 */       chars[i] = c;
/*  518 */       i++;
/*  519 */       c = iterator.next();
/*      */     } 
/*  521 */     return new String(chars);
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
/*  534 */   public Dataset getDataset() { return this.dataset; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  545 */   public void setDataset(Dataset dataset) { this.dataset = dataset; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  559 */   public int getDatasetIndex() { return this.datasetIndex; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  572 */   public void setDatasetIndex(int index) { this.datasetIndex = index; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  585 */   public Comparable getSeriesKey() { return this.seriesKey; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  596 */   public void setSeriesKey(Comparable key) { this.seriesKey = key; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  607 */   public int getSeriesIndex() { return this.series; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  618 */   public void setSeriesIndex(int index) { this.series = index; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  627 */   public String getLabel() { return this.label; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  638 */   public Font getLabelFont() { return this.labelFont; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  649 */   public void setLabelFont(Font font) { this.labelFont = font; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  660 */   public Paint getLabelPaint() { return this.labelPaint; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  671 */   public void setLabelPaint(Paint paint) { this.labelPaint = paint; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  680 */   public AttributedString getAttributedLabel() { return this.attributedLabel; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  691 */   public String getDescription() { return this.description; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  703 */   public void setDescription(String text) { this.description = text; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  714 */   public String getToolTipText() { return this.toolTipText; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  726 */   public void setToolTipText(String text) { this.toolTipText = text; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  737 */   public String getURLText() { return this.urlText; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  750 */   public void setURLText(String text) { this.urlText = text; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  761 */   public boolean isShapeVisible() { return this.shapeVisible; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  775 */   public void setShapeVisible(boolean visible) { this.shapeVisible = visible; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  787 */   public Shape getShape() { return this.shape; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setShape(Shape shape) {
/*  799 */     ParamChecks.nullNotPermitted(shape, "shape");
/*  800 */     this.shape = shape;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  809 */   public boolean isShapeFilled() { return this.shapeFilled; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  818 */   public Paint getFillPaint() { return this.fillPaint; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFillPaint(Paint paint) {
/*  829 */     ParamChecks.nullNotPermitted(paint, "paint");
/*  830 */     this.fillPaint = paint;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  840 */   public boolean isShapeOutlineVisible() { return this.shapeOutlineVisible; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  849 */   public Stroke getLineStroke() { return this.lineStroke; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLineStroke(Stroke stroke) {
/*  860 */     ParamChecks.nullNotPermitted(stroke, "stroke");
/*  861 */     this.lineStroke = stroke;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  870 */   public Paint getLinePaint() { return this.linePaint; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLinePaint(Paint paint) {
/*  881 */     ParamChecks.nullNotPermitted(paint, "paint");
/*  882 */     this.linePaint = paint;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  891 */   public Paint getOutlinePaint() { return this.outlinePaint; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOutlinePaint(Paint paint) {
/*  902 */     ParamChecks.nullNotPermitted(paint, "paint");
/*  903 */     this.outlinePaint = paint;
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
/*  914 */   public Stroke getOutlineStroke() { return this.outlineStroke; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOutlineStroke(Stroke stroke) {
/*  927 */     ParamChecks.nullNotPermitted(stroke, "stroke");
/*  928 */     this.outlineStroke = stroke;
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
/*  939 */   public boolean isLineVisible() { return this.lineVisible; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  952 */   public void setLineVisible(boolean visible) { this.lineVisible = visible; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  964 */   public Shape getLine() { return this.line; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLine(Shape line) {
/*  976 */     ParamChecks.nullNotPermitted(line, "line");
/*  977 */     this.line = line;
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
/*  991 */   public GradientPaintTransformer getFillPaintTransformer() { return this.fillPaintTransformer; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFillPaintTransformer(GradientPaintTransformer transformer) {
/* 1005 */     ParamChecks.nullNotPermitted(transformer, "transformer");
/* 1006 */     this.fillPaintTransformer = transformer;
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
/*      */   public boolean equals(Object obj) {
/* 1018 */     if (obj == this) {
/* 1019 */       return true;
/*      */     }
/* 1021 */     if (!(obj instanceof LegendItem)) {
/* 1022 */       return false;
/*      */     }
/* 1024 */     LegendItem that = (LegendItem)obj;
/* 1025 */     if (this.datasetIndex != that.datasetIndex) {
/* 1026 */       return false;
/*      */     }
/* 1028 */     if (this.series != that.series) {
/* 1029 */       return false;
/*      */     }
/* 1031 */     if (!this.label.equals(that.label)) {
/* 1032 */       return false;
/*      */     }
/* 1034 */     if (!AttributedStringUtilities.equal(this.attributedLabel, that.attributedLabel))
/*      */     {
/* 1036 */       return false;
/*      */     }
/* 1038 */     if (!ObjectUtilities.equal(this.description, that.description)) {
/* 1039 */       return false;
/*      */     }
/* 1041 */     if (this.shapeVisible != that.shapeVisible) {
/* 1042 */       return false;
/*      */     }
/* 1044 */     if (!ShapeUtilities.equal(this.shape, that.shape)) {
/* 1045 */       return false;
/*      */     }
/* 1047 */     if (this.shapeFilled != that.shapeFilled) {
/* 1048 */       return false;
/*      */     }
/* 1050 */     if (!PaintUtilities.equal(this.fillPaint, that.fillPaint)) {
/* 1051 */       return false;
/*      */     }
/* 1053 */     if (!ObjectUtilities.equal(this.fillPaintTransformer, that.fillPaintTransformer))
/*      */     {
/* 1055 */       return false;
/*      */     }
/* 1057 */     if (this.shapeOutlineVisible != that.shapeOutlineVisible) {
/* 1058 */       return false;
/*      */     }
/* 1060 */     if (!this.outlineStroke.equals(that.outlineStroke)) {
/* 1061 */       return false;
/*      */     }
/* 1063 */     if (!PaintUtilities.equal(this.outlinePaint, that.outlinePaint)) {
/* 1064 */       return false;
/*      */     }
/* 1066 */     if ((!this.lineVisible) == that.lineVisible) {
/* 1067 */       return false;
/*      */     }
/* 1069 */     if (!ShapeUtilities.equal(this.line, that.line)) {
/* 1070 */       return false;
/*      */     }
/* 1072 */     if (!this.lineStroke.equals(that.lineStroke)) {
/* 1073 */       return false;
/*      */     }
/* 1075 */     if (!PaintUtilities.equal(this.linePaint, that.linePaint)) {
/* 1076 */       return false;
/*      */     }
/* 1078 */     if (!ObjectUtilities.equal(this.labelFont, that.labelFont)) {
/* 1079 */       return false;
/*      */     }
/* 1081 */     if (!PaintUtilities.equal(this.labelPaint, that.labelPaint)) {
/* 1082 */       return false;
/*      */     }
/* 1084 */     return true;
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
/*      */   public Object clone() throws CloneNotSupportedException {
/* 1100 */     LegendItem clone = (LegendItem)super.clone();
/* 1101 */     if (this.seriesKey instanceof PublicCloneable) {
/* 1102 */       PublicCloneable pc = (PublicCloneable)this.seriesKey;
/* 1103 */       clone.seriesKey = (Comparable)pc.clone();
/*      */     } 
/*      */     
/* 1106 */     clone.shape = ShapeUtilities.clone(this.shape);
/* 1107 */     if (this.fillPaintTransformer instanceof PublicCloneable) {
/* 1108 */       PublicCloneable pc = (PublicCloneable)this.fillPaintTransformer;
/* 1109 */       clone.fillPaintTransformer = (GradientPaintTransformer)pc.clone();
/*      */     } 
/*      */     
/* 1112 */     clone.line = ShapeUtilities.clone(this.line);
/* 1113 */     return clone;
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
/* 1124 */     stream.defaultWriteObject();
/* 1125 */     SerialUtilities.writeAttributedString(this.attributedLabel, stream);
/* 1126 */     SerialUtilities.writeShape(this.shape, stream);
/* 1127 */     SerialUtilities.writePaint(this.fillPaint, stream);
/* 1128 */     SerialUtilities.writeStroke(this.outlineStroke, stream);
/* 1129 */     SerialUtilities.writePaint(this.outlinePaint, stream);
/* 1130 */     SerialUtilities.writeShape(this.line, stream);
/* 1131 */     SerialUtilities.writeStroke(this.lineStroke, stream);
/* 1132 */     SerialUtilities.writePaint(this.linePaint, stream);
/* 1133 */     SerialUtilities.writePaint(this.labelPaint, stream);
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
/*      */   private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
/* 1146 */     stream.defaultReadObject();
/* 1147 */     this.attributedLabel = SerialUtilities.readAttributedString(stream);
/* 1148 */     this.shape = SerialUtilities.readShape(stream);
/* 1149 */     this.fillPaint = SerialUtilities.readPaint(stream);
/* 1150 */     this.outlineStroke = SerialUtilities.readStroke(stream);
/* 1151 */     this.outlinePaint = SerialUtilities.readPaint(stream);
/* 1152 */     this.line = SerialUtilities.readShape(stream);
/* 1153 */     this.lineStroke = SerialUtilities.readStroke(stream);
/* 1154 */     this.linePaint = SerialUtilities.readPaint(stream);
/* 1155 */     this.labelPaint = SerialUtilities.readPaint(stream);
/*      */   }
/*      */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/LegendItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */