/*      */ package org.jfree.chart.renderer;
/*      */ 
/*      */ import java.awt.BasicStroke;
/*      */ import java.awt.Color;
/*      */ import java.awt.Font;
/*      */ import java.awt.Paint;
/*      */ import java.awt.Shape;
/*      */ import java.awt.Stroke;
/*      */ import java.awt.geom.Point2D;
/*      */ import java.awt.geom.Rectangle2D;
/*      */ import java.io.IOException;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.io.ObjectOutputStream;
/*      */ import java.io.Serializable;
/*      */ import java.util.Arrays;
/*      */ import java.util.EventListener;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import javax.swing.event.EventListenerList;
/*      */ import org.jfree.chart.HashUtilities;
/*      */ import org.jfree.chart.event.RendererChangeEvent;
/*      */ import org.jfree.chart.event.RendererChangeListener;
/*      */ import org.jfree.chart.labels.ItemLabelAnchor;
/*      */ import org.jfree.chart.labels.ItemLabelPosition;
/*      */ import org.jfree.chart.plot.DrawingSupplier;
/*      */ import org.jfree.chart.plot.PlotOrientation;
/*      */ import org.jfree.chart.util.CloneUtils;
/*      */ import org.jfree.chart.util.ParamChecks;
/*      */ import org.jfree.io.SerialUtilities;
/*      */ import org.jfree.ui.TextAnchor;
/*      */ import org.jfree.util.BooleanList;
/*      */ import org.jfree.util.ObjectUtilities;
/*      */ import org.jfree.util.PaintList;
/*      */ import org.jfree.util.PaintUtilities;
/*      */ import org.jfree.util.ShapeList;
/*      */ import org.jfree.util.ShapeUtilities;
/*      */ import org.jfree.util.StrokeList;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public abstract class AbstractRenderer
/*      */   implements Cloneable, Serializable
/*      */ {
/*      */   private static final long serialVersionUID = -828267569428206075L;
/*  152 */   public static final Double ZERO = new Double(0.0D);
/*      */ 
/*      */   
/*  155 */   public static final Paint DEFAULT_PAINT = Color.blue;
/*      */ 
/*      */   
/*  158 */   public static final Paint DEFAULT_OUTLINE_PAINT = Color.gray;
/*      */ 
/*      */   
/*  161 */   public static final Stroke DEFAULT_STROKE = new BasicStroke(1.0F);
/*      */ 
/*      */   
/*  164 */   public static final Stroke DEFAULT_OUTLINE_STROKE = new BasicStroke(1.0F);
/*      */ 
/*      */   
/*  167 */   public static final Shape DEFAULT_SHAPE = new Rectangle2D.Double(-3.0D, -3.0D, 6.0D, 6.0D);
/*      */ 
/*      */ 
/*      */   
/*  171 */   public static final Font DEFAULT_VALUE_LABEL_FONT = new Font("SansSerif", false, 10);
/*      */ 
/*      */ 
/*      */   
/*  175 */   public static final Paint DEFAULT_VALUE_LABEL_PAINT = Color.black;
/*      */ 
/*      */ 
/*      */   
/*      */   private BooleanList seriesVisibleList;
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean baseSeriesVisible;
/*      */ 
/*      */ 
/*      */   
/*      */   private BooleanList seriesVisibleInLegendList;
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean baseSeriesVisibleInLegend;
/*      */ 
/*      */ 
/*      */   
/*      */   private PaintList paintList;
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean autoPopulateSeriesPaint;
/*      */ 
/*      */ 
/*      */   
/*      */   private Paint basePaint;
/*      */ 
/*      */ 
/*      */   
/*      */   private PaintList fillPaintList;
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean autoPopulateSeriesFillPaint;
/*      */ 
/*      */ 
/*      */   
/*      */   private Paint baseFillPaint;
/*      */ 
/*      */ 
/*      */   
/*      */   private PaintList outlinePaintList;
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean autoPopulateSeriesOutlinePaint;
/*      */ 
/*      */ 
/*      */   
/*      */   private Paint baseOutlinePaint;
/*      */ 
/*      */ 
/*      */   
/*      */   private StrokeList strokeList;
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean autoPopulateSeriesStroke;
/*      */ 
/*      */ 
/*      */   
/*      */   private Stroke baseStroke;
/*      */ 
/*      */ 
/*      */   
/*      */   private StrokeList outlineStrokeList;
/*      */ 
/*      */ 
/*      */   
/*      */   private Stroke baseOutlineStroke;
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean autoPopulateSeriesOutlineStroke;
/*      */ 
/*      */ 
/*      */   
/*      */   private ShapeList shapeList;
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean autoPopulateSeriesShape;
/*      */ 
/*      */ 
/*      */   
/*      */   private Shape baseShape;
/*      */ 
/*      */ 
/*      */   
/*      */   private BooleanList itemLabelsVisibleList;
/*      */ 
/*      */ 
/*      */   
/*      */   private Boolean baseItemLabelsVisible;
/*      */ 
/*      */ 
/*      */   
/*      */   private Map<Integer, Font> itemLabelFontMap;
/*      */ 
/*      */ 
/*      */   
/*      */   private Font baseItemLabelFont;
/*      */ 
/*      */ 
/*      */   
/*      */   private PaintList itemLabelPaintList;
/*      */ 
/*      */ 
/*      */   
/*      */   private Paint baseItemLabelPaint;
/*      */ 
/*      */ 
/*      */   
/*      */   private Map<Integer, ItemLabelPosition> positiveItemLabelPositionMap;
/*      */ 
/*      */ 
/*      */   
/*      */   private ItemLabelPosition basePositiveItemLabelPosition;
/*      */ 
/*      */ 
/*      */   
/*      */   private Map<Integer, ItemLabelPosition> negativeItemLabelPositionMap;
/*      */ 
/*      */ 
/*      */   
/*      */   private ItemLabelPosition baseNegativeItemLabelPosition;
/*      */ 
/*      */ 
/*      */   
/*  307 */   private double itemLabelAnchorOffset = 2.0D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private BooleanList createEntitiesList;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean baseCreateEntities;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private ShapeList legendShapeList;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Shape baseLegendShape;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean treatLegendShapeAsLine;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Map<Integer, Font> legendTextFontMap;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Font baseLegendTextFont;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private PaintList legendTextPaint;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Paint baseLegendTextPaint;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean dataBoundsIncludesVisibleSeriesOnly = true;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int defaultEntityRadius;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private EventListenerList listenerList;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private RendererChangeEvent event;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AbstractRenderer() {
/*  395 */     this.seriesVisible = null;
/*  396 */     this.seriesVisibleList = new BooleanList();
/*  397 */     this.baseSeriesVisible = true;
/*      */     
/*  399 */     this.seriesVisibleInLegend = null;
/*  400 */     this.seriesVisibleInLegendList = new BooleanList();
/*  401 */     this.baseSeriesVisibleInLegend = true;
/*      */     
/*  403 */     this.paint = null;
/*  404 */     this.paintList = new PaintList();
/*  405 */     this.basePaint = DEFAULT_PAINT;
/*  406 */     this.autoPopulateSeriesPaint = true;
/*      */     
/*  408 */     this.fillPaint = null;
/*  409 */     this.fillPaintList = new PaintList();
/*  410 */     this.baseFillPaint = Color.white;
/*  411 */     this.autoPopulateSeriesFillPaint = false;
/*      */     
/*  413 */     this.outlinePaint = null;
/*  414 */     this.outlinePaintList = new PaintList();
/*  415 */     this.baseOutlinePaint = DEFAULT_OUTLINE_PAINT;
/*  416 */     this.autoPopulateSeriesOutlinePaint = false;
/*      */     
/*  418 */     this.stroke = null;
/*  419 */     this.strokeList = new StrokeList();
/*  420 */     this.baseStroke = DEFAULT_STROKE;
/*  421 */     this.autoPopulateSeriesStroke = true;
/*      */     
/*  423 */     this.outlineStroke = null;
/*  424 */     this.outlineStrokeList = new StrokeList();
/*  425 */     this.baseOutlineStroke = DEFAULT_OUTLINE_STROKE;
/*  426 */     this.autoPopulateSeriesOutlineStroke = false;
/*      */     
/*  428 */     this.shape = null;
/*  429 */     this.shapeList = new ShapeList();
/*  430 */     this.baseShape = DEFAULT_SHAPE;
/*  431 */     this.autoPopulateSeriesShape = true;
/*      */     
/*  433 */     this.itemLabelsVisible = null;
/*  434 */     this.itemLabelsVisibleList = new BooleanList();
/*  435 */     this.baseItemLabelsVisible = Boolean.FALSE;
/*      */     
/*  437 */     this.itemLabelFont = null;
/*  438 */     this.itemLabelFontMap = new HashMap();
/*  439 */     this.baseItemLabelFont = new Font("SansSerif", false, 10);
/*      */     
/*  441 */     this.itemLabelPaint = null;
/*  442 */     this.itemLabelPaintList = new PaintList();
/*  443 */     this.baseItemLabelPaint = Color.black;
/*      */     
/*  445 */     this.positiveItemLabelPosition = null;
/*  446 */     this.positiveItemLabelPositionMap = new HashMap();
/*      */     
/*  448 */     this.basePositiveItemLabelPosition = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BOTTOM_CENTER);
/*      */ 
/*      */     
/*  451 */     this.negativeItemLabelPosition = null;
/*  452 */     this.negativeItemLabelPositionMap = new HashMap();
/*      */     
/*  454 */     this.baseNegativeItemLabelPosition = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE6, TextAnchor.TOP_CENTER);
/*      */ 
/*      */     
/*  457 */     this.createEntities = null;
/*  458 */     this.createEntitiesList = new BooleanList();
/*  459 */     this.baseCreateEntities = true;
/*      */     
/*  461 */     this.defaultEntityRadius = 3;
/*      */     
/*  463 */     this.legendShapeList = new ShapeList();
/*  464 */     this.baseLegendShape = null;
/*      */     
/*  466 */     this.treatLegendShapeAsLine = false;
/*      */     
/*  468 */     this.legendTextFontMap = new HashMap();
/*  469 */     this.baseLegendTextFont = null;
/*      */     
/*  471 */     this.legendTextPaint = new PaintList();
/*  472 */     this.baseLegendTextPaint = null;
/*      */     
/*  474 */     this.listenerList = new EventListenerList();
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
/*      */   public abstract DrawingSupplier getDrawingSupplier();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  496 */   public boolean getItemVisible(int series, int item) { return isSeriesVisible(series); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSeriesVisible(int series) {
/*  510 */     boolean result = this.baseSeriesVisible;
/*  511 */     if (this.seriesVisible != null) {
/*  512 */       result = this.seriesVisible.booleanValue();
/*      */     } else {
/*      */       
/*  515 */       Boolean b = this.seriesVisibleList.getBoolean(series);
/*  516 */       if (b != null) {
/*  517 */         result = b.booleanValue();
/*      */       }
/*      */     } 
/*  520 */     return result;
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
/*  533 */   public Boolean getSeriesVisible(int series) { return this.seriesVisibleList.getBoolean(series); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  546 */   public void setSeriesVisible(int series, Boolean visible) { setSeriesVisible(series, visible, true); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSeriesVisible(int series, Boolean visible, boolean notify) {
/*  561 */     this.seriesVisibleList.setBoolean(series, visible);
/*  562 */     if (notify) {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  567 */       RendererChangeEvent e = new RendererChangeEvent(this, true);
/*  568 */       notifyListeners(e);
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
/*  580 */   public boolean getBaseSeriesVisible() { return this.baseSeriesVisible; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  593 */   public void setBaseSeriesVisible(boolean visible) { setBaseSeriesVisible(visible, true); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBaseSeriesVisible(boolean visible, boolean notify) {
/*  606 */     this.baseSeriesVisible = visible;
/*  607 */     if (notify) {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  612 */       RendererChangeEvent e = new RendererChangeEvent(this, true);
/*  613 */       notifyListeners(e);
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
/*      */   public boolean isSeriesVisibleInLegend(int series) {
/*  628 */     boolean result = this.baseSeriesVisibleInLegend;
/*  629 */     if (this.seriesVisibleInLegend != null) {
/*  630 */       result = this.seriesVisibleInLegend.booleanValue();
/*      */     } else {
/*      */       
/*  633 */       Boolean b = this.seriesVisibleInLegendList.getBoolean(series);
/*  634 */       if (b != null) {
/*  635 */         result = b.booleanValue();
/*      */       }
/*      */     } 
/*  638 */     return result;
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
/*  654 */   public Boolean getSeriesVisibleInLegend(int series) { return this.seriesVisibleInLegendList.getBoolean(series); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  667 */   public void setSeriesVisibleInLegend(int series, Boolean visible) { setSeriesVisibleInLegend(series, visible, true); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSeriesVisibleInLegend(int series, Boolean visible, boolean notify) {
/*  683 */     this.seriesVisibleInLegendList.setBoolean(series, visible);
/*  684 */     if (notify) {
/*  685 */       fireChangeEvent();
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
/*  697 */   public boolean getBaseSeriesVisibleInLegend() { return this.baseSeriesVisibleInLegend; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  710 */   public void setBaseSeriesVisibleInLegend(boolean visible) { setBaseSeriesVisibleInLegend(visible, true); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBaseSeriesVisibleInLegend(boolean visible, boolean notify) {
/*  723 */     this.baseSeriesVisibleInLegend = visible;
/*  724 */     if (notify) {
/*  725 */       fireChangeEvent();
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
/*  744 */   public Paint getItemPaint(int row, int column) { return lookupSeriesPaint(row); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Paint lookupSeriesPaint(int series) {
/*  759 */     if (this.paint != null) {
/*  760 */       return this.paint;
/*      */     }
/*      */ 
/*      */     
/*  764 */     Paint seriesPaint = getSeriesPaint(series);
/*  765 */     if (seriesPaint == null && this.autoPopulateSeriesPaint) {
/*  766 */       DrawingSupplier supplier = getDrawingSupplier();
/*  767 */       if (supplier != null) {
/*  768 */         seriesPaint = supplier.getNextPaint();
/*  769 */         setSeriesPaint(series, seriesPaint, false);
/*      */       } 
/*      */     } 
/*  772 */     if (seriesPaint == null) {
/*  773 */       seriesPaint = this.basePaint;
/*      */     }
/*  775 */     return seriesPaint;
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
/*  789 */   public Paint getSeriesPaint(int series) { return this.paintList.getPaint(series); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  802 */   public void setSeriesPaint(int series, Paint paint) { setSeriesPaint(series, paint, true); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSeriesPaint(int series, Paint paint, boolean notify) {
/*  816 */     this.paintList.setPaint(series, paint);
/*  817 */     if (notify) {
/*  818 */       fireChangeEvent();
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
/*      */   public void clearSeriesPaints(boolean notify) {
/*  831 */     this.paintList.clear();
/*  832 */     if (notify) {
/*  833 */       fireChangeEvent();
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
/*  845 */   public Paint getBasePaint() { return this.basePaint; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  858 */   public void setBasePaint(Paint paint) { setBasePaint(paint, true); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBasePaint(Paint paint, boolean notify) {
/*  871 */     this.basePaint = paint;
/*  872 */     if (notify) {
/*  873 */       fireChangeEvent();
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
/*  888 */   public boolean getAutoPopulateSeriesPaint() { return this.autoPopulateSeriesPaint; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  902 */   public void setAutoPopulateSeriesPaint(boolean auto) { this.autoPopulateSeriesPaint = auto; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  919 */   public Paint getItemFillPaint(int row, int column) { return lookupSeriesFillPaint(row); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Paint lookupSeriesFillPaint(int series) {
/*  934 */     if (this.fillPaint != null) {
/*  935 */       return this.fillPaint;
/*      */     }
/*      */ 
/*      */     
/*  939 */     Paint seriesFillPaint = getSeriesFillPaint(series);
/*  940 */     if (seriesFillPaint == null && this.autoPopulateSeriesFillPaint) {
/*  941 */       DrawingSupplier supplier = getDrawingSupplier();
/*  942 */       if (supplier != null) {
/*  943 */         seriesFillPaint = supplier.getNextFillPaint();
/*  944 */         setSeriesFillPaint(series, seriesFillPaint, false);
/*      */       } 
/*      */     } 
/*  947 */     if (seriesFillPaint == null) {
/*  948 */       seriesFillPaint = this.baseFillPaint;
/*      */     }
/*  950 */     return seriesFillPaint;
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
/*  964 */   public Paint getSeriesFillPaint(int series) { return this.fillPaintList.getPaint(series); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  977 */   public void setSeriesFillPaint(int series, Paint paint) { setSeriesFillPaint(series, paint, true); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSeriesFillPaint(int series, Paint paint, boolean notify) {
/*  991 */     this.fillPaintList.setPaint(series, paint);
/*  992 */     if (notify) {
/*  993 */       fireChangeEvent();
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
/* 1005 */   public Paint getBaseFillPaint() { return this.baseFillPaint; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1018 */   public void setBaseFillPaint(Paint paint) { setBaseFillPaint(paint, true); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBaseFillPaint(Paint paint, boolean notify) {
/* 1031 */     ParamChecks.nullNotPermitted(paint, "paint");
/* 1032 */     this.baseFillPaint = paint;
/* 1033 */     if (notify) {
/* 1034 */       fireChangeEvent();
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
/* 1050 */   public boolean getAutoPopulateSeriesFillPaint() { return this.autoPopulateSeriesFillPaint; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1065 */   public void setAutoPopulateSeriesFillPaint(boolean auto) { this.autoPopulateSeriesFillPaint = auto; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1083 */   public Paint getItemOutlinePaint(int row, int column) { return lookupSeriesOutlinePaint(row); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Paint lookupSeriesOutlinePaint(int series) {
/* 1098 */     if (this.outlinePaint != null) {
/* 1099 */       return this.outlinePaint;
/*      */     }
/*      */ 
/*      */     
/* 1103 */     Paint seriesOutlinePaint = getSeriesOutlinePaint(series);
/* 1104 */     if (seriesOutlinePaint == null && this.autoPopulateSeriesOutlinePaint) {
/* 1105 */       DrawingSupplier supplier = getDrawingSupplier();
/* 1106 */       if (supplier != null) {
/* 1107 */         seriesOutlinePaint = supplier.getNextOutlinePaint();
/* 1108 */         setSeriesOutlinePaint(series, seriesOutlinePaint, false);
/*      */       } 
/*      */     } 
/* 1111 */     if (seriesOutlinePaint == null) {
/* 1112 */       seriesOutlinePaint = this.baseOutlinePaint;
/*      */     }
/* 1114 */     return seriesOutlinePaint;
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
/* 1128 */   public Paint getSeriesOutlinePaint(int series) { return this.outlinePaintList.getPaint(series); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1141 */   public void setSeriesOutlinePaint(int series, Paint paint) { setSeriesOutlinePaint(series, paint, true); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSeriesOutlinePaint(int series, Paint paint, boolean notify) {
/* 1155 */     this.outlinePaintList.setPaint(series, paint);
/* 1156 */     if (notify) {
/* 1157 */       fireChangeEvent();
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
/* 1169 */   public Paint getBaseOutlinePaint() { return this.baseOutlinePaint; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1182 */   public void setBaseOutlinePaint(Paint paint) { setBaseOutlinePaint(paint, true); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBaseOutlinePaint(Paint paint, boolean notify) {
/* 1195 */     ParamChecks.nullNotPermitted(paint, "paint");
/* 1196 */     this.baseOutlinePaint = paint;
/* 1197 */     if (notify) {
/* 1198 */       fireChangeEvent();
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
/* 1214 */   public boolean getAutoPopulateSeriesOutlinePaint() { return this.autoPopulateSeriesOutlinePaint; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1229 */   public void setAutoPopulateSeriesOutlinePaint(boolean auto) { this.autoPopulateSeriesOutlinePaint = auto; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1246 */   public Stroke getItemStroke(int row, int column) { return lookupSeriesStroke(row); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Stroke lookupSeriesStroke(int series) {
/* 1261 */     if (this.stroke != null) {
/* 1262 */       return this.stroke;
/*      */     }
/*      */ 
/*      */     
/* 1266 */     Stroke result = getSeriesStroke(series);
/* 1267 */     if (result == null && this.autoPopulateSeriesStroke) {
/* 1268 */       DrawingSupplier supplier = getDrawingSupplier();
/* 1269 */       if (supplier != null) {
/* 1270 */         result = supplier.getNextStroke();
/* 1271 */         setSeriesStroke(series, result, false);
/*      */       } 
/*      */     } 
/* 1274 */     if (result == null) {
/* 1275 */       result = this.baseStroke;
/*      */     }
/* 1277 */     return result;
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
/* 1291 */   public Stroke getSeriesStroke(int series) { return this.strokeList.getStroke(series); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1304 */   public void setSeriesStroke(int series, Stroke stroke) { setSeriesStroke(series, stroke, true); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSeriesStroke(int series, Stroke stroke, boolean notify) {
/* 1318 */     this.strokeList.setStroke(series, stroke);
/* 1319 */     if (notify) {
/* 1320 */       fireChangeEvent();
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
/*      */   public void clearSeriesStrokes(boolean notify) {
/* 1333 */     this.strokeList.clear();
/* 1334 */     if (notify) {
/* 1335 */       fireChangeEvent();
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
/* 1347 */   public Stroke getBaseStroke() { return this.baseStroke; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1360 */   public void setBaseStroke(Stroke stroke) { setBaseStroke(stroke, true); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBaseStroke(Stroke stroke, boolean notify) {
/* 1373 */     ParamChecks.nullNotPermitted(stroke, "stroke");
/* 1374 */     this.baseStroke = stroke;
/* 1375 */     if (notify) {
/* 1376 */       fireChangeEvent();
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
/* 1391 */   public boolean getAutoPopulateSeriesStroke() { return this.autoPopulateSeriesStroke; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1405 */   public void setAutoPopulateSeriesStroke(boolean auto) { this.autoPopulateSeriesStroke = auto; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1422 */   public Stroke getItemOutlineStroke(int row, int column) { return lookupSeriesOutlineStroke(row); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Stroke lookupSeriesOutlineStroke(int series) {
/* 1437 */     if (this.outlineStroke != null) {
/* 1438 */       return this.outlineStroke;
/*      */     }
/*      */ 
/*      */     
/* 1442 */     Stroke result = getSeriesOutlineStroke(series);
/* 1443 */     if (result == null && this.autoPopulateSeriesOutlineStroke) {
/* 1444 */       DrawingSupplier supplier = getDrawingSupplier();
/* 1445 */       if (supplier != null) {
/* 1446 */         result = supplier.getNextOutlineStroke();
/* 1447 */         setSeriesOutlineStroke(series, result, false);
/*      */       } 
/*      */     } 
/* 1450 */     if (result == null) {
/* 1451 */       result = this.baseOutlineStroke;
/*      */     }
/* 1453 */     return result;
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
/* 1467 */   public Stroke getSeriesOutlineStroke(int series) { return this.outlineStrokeList.getStroke(series); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1480 */   public void setSeriesOutlineStroke(int series, Stroke stroke) { setSeriesOutlineStroke(series, stroke, true); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSeriesOutlineStroke(int series, Stroke stroke, boolean notify) {
/* 1495 */     this.outlineStrokeList.setStroke(series, stroke);
/* 1496 */     if (notify) {
/* 1497 */       fireChangeEvent();
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
/* 1509 */   public Stroke getBaseOutlineStroke() { return this.baseOutlineStroke; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1521 */   public void setBaseOutlineStroke(Stroke stroke) { setBaseOutlineStroke(stroke, true); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBaseOutlineStroke(Stroke stroke, boolean notify) {
/* 1535 */     ParamChecks.nullNotPermitted(stroke, "stroke");
/* 1536 */     this.baseOutlineStroke = stroke;
/* 1537 */     if (notify) {
/* 1538 */       fireChangeEvent();
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
/* 1554 */   public boolean getAutoPopulateSeriesOutlineStroke() { return this.autoPopulateSeriesOutlineStroke; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1569 */   public void setAutoPopulateSeriesOutlineStroke(boolean auto) { this.autoPopulateSeriesOutlineStroke = auto; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1587 */   public Shape getItemShape(int row, int column) { return lookupSeriesShape(row); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Shape lookupSeriesShape(int series) {
/* 1602 */     if (this.shape != null) {
/* 1603 */       return this.shape;
/*      */     }
/*      */ 
/*      */     
/* 1607 */     Shape result = getSeriesShape(series);
/* 1608 */     if (result == null && this.autoPopulateSeriesShape) {
/* 1609 */       DrawingSupplier supplier = getDrawingSupplier();
/* 1610 */       if (supplier != null) {
/* 1611 */         result = supplier.getNextShape();
/* 1612 */         setSeriesShape(series, result, false);
/*      */       } 
/*      */     } 
/* 1615 */     if (result == null) {
/* 1616 */       result = this.baseShape;
/*      */     }
/* 1618 */     return result;
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
/* 1632 */   public Shape getSeriesShape(int series) { return this.shapeList.getShape(series); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1645 */   public void setSeriesShape(int series, Shape shape) { setSeriesShape(series, shape, true); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSeriesShape(int series, Shape shape, boolean notify) {
/* 1659 */     this.shapeList.setShape(series, shape);
/* 1660 */     if (notify) {
/* 1661 */       fireChangeEvent();
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
/* 1673 */   public Shape getBaseShape() { return this.baseShape; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1686 */   public void setBaseShape(Shape shape) { setBaseShape(shape, true); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBaseShape(Shape shape, boolean notify) {
/* 1699 */     ParamChecks.nullNotPermitted(shape, "shape");
/* 1700 */     this.baseShape = shape;
/* 1701 */     if (notify) {
/* 1702 */       fireChangeEvent();
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
/* 1717 */   public boolean getAutoPopulateSeriesShape() { return this.autoPopulateSeriesShape; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1731 */   public void setAutoPopulateSeriesShape(boolean auto) { this.autoPopulateSeriesShape = auto; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1746 */   public boolean isItemLabelVisible(int row, int column) { return isSeriesItemLabelsVisible(row); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSeriesItemLabelsVisible(int series) {
/* 1760 */     if (this.itemLabelsVisible != null) {
/* 1761 */       return this.itemLabelsVisible.booleanValue();
/*      */     }
/*      */ 
/*      */     
/* 1765 */     Boolean b = this.itemLabelsVisibleList.getBoolean(series);
/* 1766 */     if (b == null) {
/* 1767 */       b = this.baseItemLabelsVisible;
/*      */     }
/* 1769 */     if (b == null) {
/* 1770 */       b = Boolean.FALSE;
/*      */     }
/* 1772 */     return b.booleanValue();
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
/* 1784 */   public void setSeriesItemLabelsVisible(int series, boolean visible) { setSeriesItemLabelsVisible(series, Boolean.valueOf(visible)); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1795 */   public void setSeriesItemLabelsVisible(int series, Boolean visible) { setSeriesItemLabelsVisible(series, visible, true); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSeriesItemLabelsVisible(int series, Boolean visible, boolean notify) {
/* 1809 */     this.itemLabelsVisibleList.setBoolean(series, visible);
/* 1810 */     if (notify) {
/* 1811 */       fireChangeEvent();
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
/* 1827 */   public Boolean getBaseItemLabelsVisible() { return this.baseItemLabelsVisible; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1839 */   public void setBaseItemLabelsVisible(boolean visible) { setBaseItemLabelsVisible(Boolean.valueOf(visible)); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1850 */   public void setBaseItemLabelsVisible(Boolean visible) { setBaseItemLabelsVisible(visible, true); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBaseItemLabelsVisible(Boolean visible, boolean notify) {
/* 1865 */     this.baseItemLabelsVisible = visible;
/* 1866 */     if (notify) {
/* 1867 */       fireChangeEvent();
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
/*      */   public Font getItemLabelFont(int row, int column) {
/* 1882 */     Font result = this.itemLabelFont;
/* 1883 */     if (result == null) {
/* 1884 */       result = getSeriesItemLabelFont(row);
/* 1885 */       if (result == null) {
/* 1886 */         result = this.baseItemLabelFont;
/*      */       }
/*      */     } 
/* 1889 */     return result;
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
/* 1902 */   public Font getSeriesItemLabelFont(int series) { return (Font)this.itemLabelFontMap.get(Integer.valueOf(series)); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1915 */   public void setSeriesItemLabelFont(int series, Font font) { setSeriesItemLabelFont(series, font, true); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSeriesItemLabelFont(int series, Font font, boolean notify) {
/* 1930 */     this.itemLabelFontMap.put(Integer.valueOf(series), font);
/* 1931 */     if (notify) {
/* 1932 */       fireChangeEvent();
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
/* 1945 */   public Font getBaseItemLabelFont() { return this.baseItemLabelFont; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBaseItemLabelFont(Font font) {
/* 1957 */     ParamChecks.nullNotPermitted(font, "font");
/* 1958 */     setBaseItemLabelFont(font, true);
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
/*      */   public void setBaseItemLabelFont(Font font, boolean notify) {
/* 1972 */     this.baseItemLabelFont = font;
/* 1973 */     if (notify) {
/* 1974 */       fireChangeEvent();
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
/*      */   public Paint getItemLabelPaint(int row, int column) {
/* 1989 */     Paint result = this.itemLabelPaint;
/* 1990 */     if (result == null) {
/* 1991 */       result = getSeriesItemLabelPaint(row);
/* 1992 */       if (result == null) {
/* 1993 */         result = this.baseItemLabelPaint;
/*      */       }
/*      */     } 
/* 1996 */     return result;
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
/* 2009 */   public Paint getSeriesItemLabelPaint(int series) { return this.itemLabelPaintList.getPaint(series); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 2022 */   public void setSeriesItemLabelPaint(int series, Paint paint) { setSeriesItemLabelPaint(series, paint, true); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSeriesItemLabelPaint(int series, Paint paint, boolean notify) {
/* 2038 */     this.itemLabelPaintList.setPaint(series, paint);
/* 2039 */     if (notify) {
/* 2040 */       fireChangeEvent();
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
/* 2052 */   public Paint getBaseItemLabelPaint() { return this.baseItemLabelPaint; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 2065 */   public void setBaseItemLabelPaint(Paint paint) { setBaseItemLabelPaint(paint, true); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBaseItemLabelPaint(Paint paint, boolean notify) {
/* 2079 */     ParamChecks.nullNotPermitted(paint, "paint");
/* 2080 */     this.baseItemLabelPaint = paint;
/* 2081 */     if (notify) {
/* 2082 */       fireChangeEvent();
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
/* 2099 */   public ItemLabelPosition getPositiveItemLabelPosition(int row, int column) { return getSeriesPositiveItemLabelPosition(row); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ItemLabelPosition getSeriesPositiveItemLabelPosition(int series) {
/* 2113 */     if (this.positiveItemLabelPosition != null) {
/* 2114 */       return this.positiveItemLabelPosition;
/*      */     }
/*      */ 
/*      */     
/* 2118 */     ItemLabelPosition position = (ItemLabelPosition)this.positiveItemLabelPositionMap.get(Integer.valueOf(series));
/* 2119 */     if (position == null) {
/* 2120 */       position = this.basePositiveItemLabelPosition;
/*      */     }
/* 2122 */     return position;
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
/* 2136 */   public void setSeriesPositiveItemLabelPosition(int series, ItemLabelPosition position) { setSeriesPositiveItemLabelPosition(series, position, true); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSeriesPositiveItemLabelPosition(int series, ItemLabelPosition position, boolean notify) {
/* 2152 */     this.positiveItemLabelPositionMap.put(Integer.valueOf(series), position);
/* 2153 */     if (notify) {
/* 2154 */       fireChangeEvent();
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
/* 2166 */   public ItemLabelPosition getBasePositiveItemLabelPosition() { return this.basePositiveItemLabelPosition; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 2178 */   public void setBasePositiveItemLabelPosition(ItemLabelPosition position) { setBasePositiveItemLabelPosition(position, true); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBasePositiveItemLabelPosition(ItemLabelPosition position, boolean notify) {
/* 2192 */     ParamChecks.nullNotPermitted(position, "position");
/* 2193 */     this.basePositiveItemLabelPosition = position;
/* 2194 */     if (notify) {
/* 2195 */       fireChangeEvent();
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
/* 2214 */   public ItemLabelPosition getNegativeItemLabelPosition(int row, int column) { return getSeriesNegativeItemLabelPosition(row); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ItemLabelPosition getSeriesNegativeItemLabelPosition(int series) {
/* 2228 */     if (this.negativeItemLabelPosition != null) {
/* 2229 */       return this.negativeItemLabelPosition;
/*      */     }
/*      */ 
/*      */     
/* 2233 */     ItemLabelPosition position = (ItemLabelPosition)this.negativeItemLabelPositionMap.get(Integer.valueOf(series));
/* 2234 */     if (position == null) {
/* 2235 */       position = this.baseNegativeItemLabelPosition;
/*      */     }
/* 2237 */     return position;
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
/* 2251 */   public void setSeriesNegativeItemLabelPosition(int series, ItemLabelPosition position) { setSeriesNegativeItemLabelPosition(series, position, true); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSeriesNegativeItemLabelPosition(int series, ItemLabelPosition position, boolean notify) {
/* 2267 */     this.negativeItemLabelPositionMap.put(Integer.valueOf(series), position);
/* 2268 */     if (notify) {
/* 2269 */       fireChangeEvent();
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
/* 2281 */   public ItemLabelPosition getBaseNegativeItemLabelPosition() { return this.baseNegativeItemLabelPosition; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 2293 */   public void setBaseNegativeItemLabelPosition(ItemLabelPosition position) { setBaseNegativeItemLabelPosition(position, true); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBaseNegativeItemLabelPosition(ItemLabelPosition position, boolean notify) {
/* 2307 */     ParamChecks.nullNotPermitted(position, "position");
/* 2308 */     this.baseNegativeItemLabelPosition = position;
/* 2309 */     if (notify) {
/* 2310 */       fireChangeEvent();
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
/* 2322 */   public double getItemLabelAnchorOffset() { return this.itemLabelAnchorOffset; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setItemLabelAnchorOffset(double offset) {
/* 2333 */     this.itemLabelAnchorOffset = offset;
/* 2334 */     fireChangeEvent();
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
/*      */   public boolean getItemCreateEntity(int series, int item) {
/* 2347 */     if (this.createEntities != null) {
/* 2348 */       return this.createEntities.booleanValue();
/*      */     }
/*      */     
/* 2351 */     Boolean b = getSeriesCreateEntities(series);
/* 2352 */     if (b != null) {
/* 2353 */       return b.booleanValue();
/*      */     }
/*      */     
/* 2356 */     return this.baseCreateEntities;
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
/* 2372 */   public Boolean getSeriesCreateEntities(int series) { return this.createEntitiesList.getBoolean(series); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 2385 */   public void setSeriesCreateEntities(int series, Boolean create) { setSeriesCreateEntities(series, create, true); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSeriesCreateEntities(int series, Boolean create, boolean notify) {
/* 2401 */     this.createEntitiesList.setBoolean(series, create);
/* 2402 */     if (notify) {
/* 2403 */       fireChangeEvent();
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
/* 2415 */   public boolean getBaseCreateEntities() { return this.baseCreateEntities; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 2429 */   public void setBaseCreateEntities(boolean create) { setBaseCreateEntities(create, true); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBaseCreateEntities(boolean create, boolean notify) {
/* 2443 */     this.baseCreateEntities = create;
/* 2444 */     if (notify) {
/* 2445 */       fireChangeEvent();
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
/* 2458 */   public int getDefaultEntityRadius() { return this.defaultEntityRadius; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 2470 */   public void setDefaultEntityRadius(int radius) { this.defaultEntityRadius = radius; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Shape lookupLegendShape(int series) {
/* 2483 */     Shape result = getLegendShape(series);
/* 2484 */     if (result == null) {
/* 2485 */       result = this.baseLegendShape;
/*      */     }
/* 2487 */     if (result == null) {
/* 2488 */       result = lookupSeriesShape(series);
/*      */     }
/* 2490 */     return result;
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
/* 2506 */   public Shape getLegendShape(int series) { return this.legendShapeList.getShape(series); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLegendShape(int series, Shape shape) {
/* 2519 */     this.legendShapeList.setShape(series, shape);
/* 2520 */     fireChangeEvent();
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
/* 2531 */   public Shape getBaseLegendShape() { return this.baseLegendShape; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBaseLegendShape(Shape shape) {
/* 2543 */     this.baseLegendShape = shape;
/* 2544 */     fireChangeEvent();
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
/* 2556 */   protected boolean getTreatLegendShapeAsLine() { return this.treatLegendShapeAsLine; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setTreatLegendShapeAsLine(boolean treatAsLine) {
/* 2568 */     if (this.treatLegendShapeAsLine != treatAsLine) {
/* 2569 */       this.treatLegendShapeAsLine = treatAsLine;
/* 2570 */       fireChangeEvent();
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
/*      */   public Font lookupLegendTextFont(int series) {
/* 2584 */     Font result = getLegendTextFont(series);
/* 2585 */     if (result == null) {
/* 2586 */       result = this.baseLegendTextFont;
/*      */     }
/* 2588 */     return result;
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
/* 2604 */   public Font getLegendTextFont(int series) { return (Font)this.legendTextFontMap.get(Integer.valueOf(series)); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLegendTextFont(int series, Font font) {
/* 2617 */     this.legendTextFontMap.put(Integer.valueOf(series), font);
/* 2618 */     fireChangeEvent();
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
/* 2629 */   public Font getBaseLegendTextFont() { return this.baseLegendTextFont; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBaseLegendTextFont(Font font) {
/* 2641 */     this.baseLegendTextFont = font;
/* 2642 */     fireChangeEvent();
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
/*      */   public Paint lookupLegendTextPaint(int series) {
/* 2655 */     Paint result = getLegendTextPaint(series);
/* 2656 */     if (result == null) {
/* 2657 */       result = this.baseLegendTextPaint;
/*      */     }
/* 2659 */     return result;
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
/* 2675 */   public Paint getLegendTextPaint(int series) { return this.legendTextPaint.getPaint(series); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLegendTextPaint(int series, Paint paint) {
/* 2688 */     this.legendTextPaint.setPaint(series, paint);
/* 2689 */     fireChangeEvent();
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
/* 2700 */   public Paint getBaseLegendTextPaint() { return this.baseLegendTextPaint; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBaseLegendTextPaint(Paint paint) {
/* 2712 */     this.baseLegendTextPaint = paint;
/* 2713 */     fireChangeEvent();
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
/* 2725 */   public boolean getDataBoundsIncludesVisibleSeriesOnly() { return this.dataBoundsIncludesVisibleSeriesOnly; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDataBoundsIncludesVisibleSeriesOnly(boolean visibleOnly) {
/* 2738 */     this.dataBoundsIncludesVisibleSeriesOnly = visibleOnly;
/* 2739 */     notifyListeners(new RendererChangeEvent(this, true));
/*      */   }
/*      */ 
/*      */   
/* 2743 */   private static final double ADJ = Math.cos(0.5235987755982988D);
/*      */ 
/*      */   
/* 2746 */   private static final double OPP = Math.sin(0.5235987755982988D);
/*      */   
/*      */   private Boolean seriesVisible;
/*      */   
/*      */   private Boolean seriesVisibleInLegend;
/*      */   
/*      */   private Paint paint;
/*      */   
/*      */   private Paint fillPaint;
/*      */   private Paint outlinePaint;
/*      */   private Stroke stroke;
/*      */   private Stroke outlineStroke;
/*      */   
/*      */   protected Point2D calculateLabelAnchorPoint(ItemLabelAnchor anchor, double x, double y, PlotOrientation orientation) {
/* 2760 */     Point2D result = null;
/* 2761 */     if (anchor == ItemLabelAnchor.CENTER) {
/* 2762 */       result = new Point2D.Double(x, y);
/*      */     }
/* 2764 */     else if (anchor == ItemLabelAnchor.INSIDE1) {
/* 2765 */       result = new Point2D.Double(x + OPP * this.itemLabelAnchorOffset, y - ADJ * this.itemLabelAnchorOffset);
/*      */     
/*      */     }
/* 2768 */     else if (anchor == ItemLabelAnchor.INSIDE2) {
/* 2769 */       result = new Point2D.Double(x + ADJ * this.itemLabelAnchorOffset, y - OPP * this.itemLabelAnchorOffset);
/*      */     
/*      */     }
/* 2772 */     else if (anchor == ItemLabelAnchor.INSIDE3) {
/* 2773 */       result = new Point2D.Double(x + this.itemLabelAnchorOffset, y);
/*      */     }
/* 2775 */     else if (anchor == ItemLabelAnchor.INSIDE4) {
/* 2776 */       result = new Point2D.Double(x + ADJ * this.itemLabelAnchorOffset, y + OPP * this.itemLabelAnchorOffset);
/*      */     
/*      */     }
/* 2779 */     else if (anchor == ItemLabelAnchor.INSIDE5) {
/* 2780 */       result = new Point2D.Double(x + OPP * this.itemLabelAnchorOffset, y + ADJ * this.itemLabelAnchorOffset);
/*      */     
/*      */     }
/* 2783 */     else if (anchor == ItemLabelAnchor.INSIDE6) {
/* 2784 */       result = new Point2D.Double(x, y + this.itemLabelAnchorOffset);
/*      */     }
/* 2786 */     else if (anchor == ItemLabelAnchor.INSIDE7) {
/* 2787 */       result = new Point2D.Double(x - OPP * this.itemLabelAnchorOffset, y + ADJ * this.itemLabelAnchorOffset);
/*      */     
/*      */     }
/* 2790 */     else if (anchor == ItemLabelAnchor.INSIDE8) {
/* 2791 */       result = new Point2D.Double(x - ADJ * this.itemLabelAnchorOffset, y + OPP * this.itemLabelAnchorOffset);
/*      */     
/*      */     }
/* 2794 */     else if (anchor == ItemLabelAnchor.INSIDE9) {
/* 2795 */       result = new Point2D.Double(x - this.itemLabelAnchorOffset, y);
/*      */     }
/* 2797 */     else if (anchor == ItemLabelAnchor.INSIDE10) {
/* 2798 */       result = new Point2D.Double(x - ADJ * this.itemLabelAnchorOffset, y - OPP * this.itemLabelAnchorOffset);
/*      */     
/*      */     }
/* 2801 */     else if (anchor == ItemLabelAnchor.INSIDE11) {
/* 2802 */       result = new Point2D.Double(x - OPP * this.itemLabelAnchorOffset, y - ADJ * this.itemLabelAnchorOffset);
/*      */     
/*      */     }
/* 2805 */     else if (anchor == ItemLabelAnchor.INSIDE12) {
/* 2806 */       result = new Point2D.Double(x, y - this.itemLabelAnchorOffset);
/*      */     }
/* 2808 */     else if (anchor == ItemLabelAnchor.OUTSIDE1) {
/* 2809 */       result = new Point2D.Double(x + 2.0D * OPP * this.itemLabelAnchorOffset, y - 2.0D * ADJ * this.itemLabelAnchorOffset);
/*      */ 
/*      */     
/*      */     }
/* 2813 */     else if (anchor == ItemLabelAnchor.OUTSIDE2) {
/* 2814 */       result = new Point2D.Double(x + 2.0D * ADJ * this.itemLabelAnchorOffset, y - 2.0D * OPP * this.itemLabelAnchorOffset);
/*      */ 
/*      */     
/*      */     }
/* 2818 */     else if (anchor == ItemLabelAnchor.OUTSIDE3) {
/* 2819 */       result = new Point2D.Double(x + 2.0D * this.itemLabelAnchorOffset, y);
/*      */     
/*      */     }
/* 2822 */     else if (anchor == ItemLabelAnchor.OUTSIDE4) {
/* 2823 */       result = new Point2D.Double(x + 2.0D * ADJ * this.itemLabelAnchorOffset, y + 2.0D * OPP * this.itemLabelAnchorOffset);
/*      */ 
/*      */     
/*      */     }
/* 2827 */     else if (anchor == ItemLabelAnchor.OUTSIDE5) {
/* 2828 */       result = new Point2D.Double(x + 2.0D * OPP * this.itemLabelAnchorOffset, y + 2.0D * ADJ * this.itemLabelAnchorOffset);
/*      */ 
/*      */     
/*      */     }
/* 2832 */     else if (anchor == ItemLabelAnchor.OUTSIDE6) {
/* 2833 */       result = new Point2D.Double(x, y + 2.0D * this.itemLabelAnchorOffset);
/*      */     
/*      */     }
/* 2836 */     else if (anchor == ItemLabelAnchor.OUTSIDE7) {
/* 2837 */       result = new Point2D.Double(x - 2.0D * OPP * this.itemLabelAnchorOffset, y + 2.0D * ADJ * this.itemLabelAnchorOffset);
/*      */ 
/*      */     
/*      */     }
/* 2841 */     else if (anchor == ItemLabelAnchor.OUTSIDE8) {
/* 2842 */       result = new Point2D.Double(x - 2.0D * ADJ * this.itemLabelAnchorOffset, y + 2.0D * OPP * this.itemLabelAnchorOffset);
/*      */ 
/*      */     
/*      */     }
/* 2846 */     else if (anchor == ItemLabelAnchor.OUTSIDE9) {
/* 2847 */       result = new Point2D.Double(x - 2.0D * this.itemLabelAnchorOffset, y);
/*      */     
/*      */     }
/* 2850 */     else if (anchor == ItemLabelAnchor.OUTSIDE10) {
/* 2851 */       result = new Point2D.Double(x - 2.0D * ADJ * this.itemLabelAnchorOffset, y - 2.0D * OPP * this.itemLabelAnchorOffset);
/*      */ 
/*      */     
/*      */     }
/* 2855 */     else if (anchor == ItemLabelAnchor.OUTSIDE11) {
/* 2856 */       result = new Point2D.Double(x - 2.0D * OPP * this.itemLabelAnchorOffset, y - 2.0D * ADJ * this.itemLabelAnchorOffset);
/*      */ 
/*      */     
/*      */     }
/* 2860 */     else if (anchor == ItemLabelAnchor.OUTSIDE12) {
/* 2861 */       result = new Point2D.Double(x, y - 2.0D * this.itemLabelAnchorOffset);
/*      */     } 
/*      */     
/* 2864 */     return result;
/*      */   }
/*      */ 
/*      */   
/*      */   private Shape shape;
/*      */   
/*      */   private Boolean itemLabelsVisible;
/*      */   
/*      */   private Font itemLabelFont;
/*      */   
/*      */   public void addChangeListener(RendererChangeListener listener) {
/* 2875 */     ParamChecks.nullNotPermitted(listener, "listener");
/* 2876 */     this.listenerList.add(RendererChangeListener.class, listener);
/*      */   }
/*      */ 
/*      */   
/*      */   private Paint itemLabelPaint;
/*      */   
/*      */   private ItemLabelPosition positiveItemLabelPosition;
/*      */   
/*      */   private ItemLabelPosition negativeItemLabelPosition;
/*      */   private Boolean createEntities;
/*      */   
/*      */   public void removeChangeListener(RendererChangeListener listener) {
/* 2888 */     ParamChecks.nullNotPermitted(listener, "listener");
/* 2889 */     this.listenerList.remove(RendererChangeListener.class, listener);
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
/*      */   public boolean hasListener(EventListener listener) {
/* 2902 */     List list = Arrays.asList(this.listenerList.getListenerList());
/* 2903 */     return list.contains(listener);
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
/* 2922 */   protected void fireChangeEvent() { notifyListeners(new RendererChangeEvent(this)); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void notifyListeners(RendererChangeEvent event) {
/* 2931 */     Object[] ls = this.listenerList.getListenerList();
/* 2932 */     for (int i = ls.length - 2; i >= 0; i -= 2) {
/* 2933 */       if (ls[i] == RendererChangeListener.class) {
/* 2934 */         ((RendererChangeListener)ls[i + 1]).rendererChanged(event);
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
/*      */   public boolean equals(Object obj) {
/* 2948 */     if (obj == this) {
/* 2949 */       return true;
/*      */     }
/* 2951 */     if (!(obj instanceof AbstractRenderer)) {
/* 2952 */       return false;
/*      */     }
/* 2954 */     AbstractRenderer that = (AbstractRenderer)obj;
/* 2955 */     if (this.dataBoundsIncludesVisibleSeriesOnly != that.dataBoundsIncludesVisibleSeriesOnly)
/*      */     {
/* 2957 */       return false;
/*      */     }
/* 2959 */     if (this.treatLegendShapeAsLine != that.treatLegendShapeAsLine) {
/* 2960 */       return false;
/*      */     }
/* 2962 */     if (this.defaultEntityRadius != that.defaultEntityRadius) {
/* 2963 */       return false;
/*      */     }
/* 2965 */     if (!ObjectUtilities.equal(this.seriesVisible, that.seriesVisible)) {
/* 2966 */       return false;
/*      */     }
/* 2968 */     if (!this.seriesVisibleList.equals(that.seriesVisibleList)) {
/* 2969 */       return false;
/*      */     }
/* 2971 */     if (this.baseSeriesVisible != that.baseSeriesVisible) {
/* 2972 */       return false;
/*      */     }
/* 2974 */     if (!ObjectUtilities.equal(this.seriesVisibleInLegend, that.seriesVisibleInLegend))
/*      */     {
/* 2976 */       return false;
/*      */     }
/* 2978 */     if (!this.seriesVisibleInLegendList.equals(that.seriesVisibleInLegendList))
/*      */     {
/* 2980 */       return false;
/*      */     }
/* 2982 */     if (this.baseSeriesVisibleInLegend != that.baseSeriesVisibleInLegend) {
/* 2983 */       return false;
/*      */     }
/* 2985 */     if (!PaintUtilities.equal(this.paint, that.paint)) {
/* 2986 */       return false;
/*      */     }
/* 2988 */     if (!ObjectUtilities.equal(this.paintList, that.paintList)) {
/* 2989 */       return false;
/*      */     }
/* 2991 */     if (!PaintUtilities.equal(this.basePaint, that.basePaint)) {
/* 2992 */       return false;
/*      */     }
/* 2994 */     if (!PaintUtilities.equal(this.fillPaint, that.fillPaint)) {
/* 2995 */       return false;
/*      */     }
/* 2997 */     if (!ObjectUtilities.equal(this.fillPaintList, that.fillPaintList)) {
/* 2998 */       return false;
/*      */     }
/* 3000 */     if (!PaintUtilities.equal(this.baseFillPaint, that.baseFillPaint)) {
/* 3001 */       return false;
/*      */     }
/* 3003 */     if (!PaintUtilities.equal(this.outlinePaint, that.outlinePaint)) {
/* 3004 */       return false;
/*      */     }
/* 3006 */     if (!ObjectUtilities.equal(this.outlinePaintList, that.outlinePaintList))
/*      */     {
/* 3008 */       return false;
/*      */     }
/* 3010 */     if (!PaintUtilities.equal(this.baseOutlinePaint, that.baseOutlinePaint))
/*      */     {
/* 3012 */       return false;
/*      */     }
/* 3014 */     if (!ObjectUtilities.equal(this.stroke, that.stroke)) {
/* 3015 */       return false;
/*      */     }
/* 3017 */     if (!ObjectUtilities.equal(this.strokeList, that.strokeList)) {
/* 3018 */       return false;
/*      */     }
/* 3020 */     if (!ObjectUtilities.equal(this.baseStroke, that.baseStroke)) {
/* 3021 */       return false;
/*      */     }
/* 3023 */     if (!ObjectUtilities.equal(this.outlineStroke, that.outlineStroke)) {
/* 3024 */       return false;
/*      */     }
/* 3026 */     if (!ObjectUtilities.equal(this.outlineStrokeList, that.outlineStrokeList))
/*      */     {
/* 3028 */       return false;
/*      */     }
/* 3030 */     if (!ObjectUtilities.equal(this.baseOutlineStroke, that.baseOutlineStroke))
/*      */     {
/*      */       
/* 3033 */       return false;
/*      */     }
/* 3035 */     if (!ShapeUtilities.equal(this.shape, that.shape)) {
/* 3036 */       return false;
/*      */     }
/* 3038 */     if (!ObjectUtilities.equal(this.shapeList, that.shapeList)) {
/* 3039 */       return false;
/*      */     }
/* 3041 */     if (!ShapeUtilities.equal(this.baseShape, that.baseShape)) {
/* 3042 */       return false;
/*      */     }
/* 3044 */     if (!ObjectUtilities.equal(this.itemLabelsVisible, that.itemLabelsVisible))
/*      */     {
/* 3046 */       return false;
/*      */     }
/* 3048 */     if (!ObjectUtilities.equal(this.itemLabelsVisibleList, that.itemLabelsVisibleList))
/*      */     {
/* 3050 */       return false;
/*      */     }
/* 3052 */     if (!ObjectUtilities.equal(this.baseItemLabelsVisible, that.baseItemLabelsVisible))
/*      */     {
/* 3054 */       return false;
/*      */     }
/* 3056 */     if (!ObjectUtilities.equal(this.itemLabelFont, that.itemLabelFont)) {
/* 3057 */       return false;
/*      */     }
/* 3059 */     if (!ObjectUtilities.equal(this.itemLabelFontMap, that.itemLabelFontMap))
/*      */     {
/* 3061 */       return false;
/*      */     }
/* 3063 */     if (!ObjectUtilities.equal(this.baseItemLabelFont, that.baseItemLabelFont))
/*      */     {
/* 3065 */       return false;
/*      */     }
/*      */     
/* 3068 */     if (!PaintUtilities.equal(this.itemLabelPaint, that.itemLabelPaint)) {
/* 3069 */       return false;
/*      */     }
/* 3071 */     if (!ObjectUtilities.equal(this.itemLabelPaintList, that.itemLabelPaintList))
/*      */     {
/* 3073 */       return false;
/*      */     }
/* 3075 */     if (!PaintUtilities.equal(this.baseItemLabelPaint, that.baseItemLabelPaint))
/*      */     {
/* 3077 */       return false;
/*      */     }
/*      */     
/* 3080 */     if (!ObjectUtilities.equal(this.positiveItemLabelPosition, that.positiveItemLabelPosition))
/*      */     {
/* 3082 */       return false;
/*      */     }
/* 3084 */     if (!ObjectUtilities.equal(this.positiveItemLabelPositionMap, that.positiveItemLabelPositionMap))
/*      */     {
/* 3086 */       return false;
/*      */     }
/* 3088 */     if (!ObjectUtilities.equal(this.basePositiveItemLabelPosition, that.basePositiveItemLabelPosition))
/*      */     {
/* 3090 */       return false;
/*      */     }
/*      */     
/* 3093 */     if (!ObjectUtilities.equal(this.negativeItemLabelPosition, that.negativeItemLabelPosition))
/*      */     {
/* 3095 */       return false;
/*      */     }
/* 3097 */     if (!ObjectUtilities.equal(this.negativeItemLabelPositionMap, that.negativeItemLabelPositionMap))
/*      */     {
/* 3099 */       return false;
/*      */     }
/* 3101 */     if (!ObjectUtilities.equal(this.baseNegativeItemLabelPosition, that.baseNegativeItemLabelPosition))
/*      */     {
/* 3103 */       return false;
/*      */     }
/* 3105 */     if (this.itemLabelAnchorOffset != that.itemLabelAnchorOffset) {
/* 3106 */       return false;
/*      */     }
/* 3108 */     if (!ObjectUtilities.equal(this.createEntities, that.createEntities)) {
/* 3109 */       return false;
/*      */     }
/* 3111 */     if (!ObjectUtilities.equal(this.createEntitiesList, that.createEntitiesList))
/*      */     {
/* 3113 */       return false;
/*      */     }
/* 3115 */     if (this.baseCreateEntities != that.baseCreateEntities) {
/* 3116 */       return false;
/*      */     }
/* 3118 */     if (!ObjectUtilities.equal(this.legendShapeList, that.legendShapeList))
/*      */     {
/* 3120 */       return false;
/*      */     }
/* 3122 */     if (!ShapeUtilities.equal(this.baseLegendShape, that.baseLegendShape))
/*      */     {
/* 3124 */       return false;
/*      */     }
/* 3126 */     if (!ObjectUtilities.equal(this.legendTextFontMap, that.legendTextFontMap))
/*      */     {
/* 3128 */       return false;
/*      */     }
/* 3130 */     if (!ObjectUtilities.equal(this.baseLegendTextFont, that.baseLegendTextFont))
/*      */     {
/* 3132 */       return false;
/*      */     }
/* 3134 */     if (!ObjectUtilities.equal(this.legendTextPaint, that.legendTextPaint))
/*      */     {
/* 3136 */       return false;
/*      */     }
/* 3138 */     if (!PaintUtilities.equal(this.baseLegendTextPaint, that.baseLegendTextPaint))
/*      */     {
/* 3140 */       return false;
/*      */     }
/* 3142 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int hashCode() {
/* 3152 */     result = 193;
/* 3153 */     result = HashUtilities.hashCode(result, this.seriesVisibleList);
/* 3154 */     result = HashUtilities.hashCode(result, this.baseSeriesVisible);
/* 3155 */     result = HashUtilities.hashCode(result, this.seriesVisibleInLegendList);
/* 3156 */     result = HashUtilities.hashCode(result, this.baseSeriesVisibleInLegend);
/* 3157 */     result = HashUtilities.hashCode(result, this.paintList);
/* 3158 */     result = HashUtilities.hashCode(result, this.basePaint);
/* 3159 */     result = HashUtilities.hashCode(result, this.fillPaintList);
/* 3160 */     result = HashUtilities.hashCode(result, this.baseFillPaint);
/* 3161 */     result = HashUtilities.hashCode(result, this.outlinePaintList);
/* 3162 */     result = HashUtilities.hashCode(result, this.baseOutlinePaint);
/* 3163 */     result = HashUtilities.hashCode(result, this.strokeList);
/* 3164 */     result = HashUtilities.hashCode(result, this.baseStroke);
/* 3165 */     result = HashUtilities.hashCode(result, this.outlineStrokeList);
/* 3166 */     result = HashUtilities.hashCode(result, this.baseOutlineStroke);
/*      */ 
/*      */     
/* 3169 */     result = HashUtilities.hashCode(result, this.itemLabelsVisibleList);
/* 3170 */     return HashUtilities.hashCode(result, this.baseItemLabelsVisible);
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
/*      */   protected Object clone() throws CloneNotSupportedException {
/* 3195 */     AbstractRenderer clone = (AbstractRenderer)super.clone();
/*      */     
/* 3197 */     if (this.seriesVisibleList != null) {
/* 3198 */       clone
/* 3199 */         .seriesVisibleList = (BooleanList)this.seriesVisibleList.clone();
/*      */     }
/*      */     
/* 3202 */     if (this.seriesVisibleInLegendList != null) {
/* 3203 */       clone
/* 3204 */         .seriesVisibleInLegendList = (BooleanList)this.seriesVisibleInLegendList.clone();
/*      */     }
/*      */ 
/*      */     
/* 3208 */     if (this.paintList != null) {
/* 3209 */       clone.paintList = (PaintList)this.paintList.clone();
/*      */     }
/*      */ 
/*      */     
/* 3213 */     if (this.fillPaintList != null) {
/* 3214 */       clone.fillPaintList = (PaintList)this.fillPaintList.clone();
/*      */     }
/*      */     
/* 3217 */     if (this.outlinePaintList != null) {
/* 3218 */       clone.outlinePaintList = (PaintList)this.outlinePaintList.clone();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 3223 */     if (this.strokeList != null) {
/* 3224 */       clone.strokeList = (StrokeList)this.strokeList.clone();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 3229 */     if (this.outlineStrokeList != null) {
/* 3230 */       clone
/* 3231 */         .outlineStrokeList = (StrokeList)this.outlineStrokeList.clone();
/*      */     }
/*      */ 
/*      */     
/* 3235 */     if (this.shape != null) {
/* 3236 */       clone.shape = ShapeUtilities.clone(this.shape);
/*      */     }
/* 3238 */     if (this.shapeList != null) {
/* 3239 */       clone.shapeList = (ShapeList)this.shapeList.clone();
/*      */     }
/* 3241 */     if (this.baseShape != null) {
/* 3242 */       clone.baseShape = ShapeUtilities.clone(this.baseShape);
/*      */     }
/*      */ 
/*      */     
/* 3246 */     if (this.itemLabelsVisibleList != null) {
/* 3247 */       clone
/* 3248 */         .itemLabelsVisibleList = (BooleanList)this.itemLabelsVisibleList.clone();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 3253 */     if (this.itemLabelFontMap != null) {
/* 3254 */       clone
/* 3255 */         .itemLabelFontMap = CloneUtils.cloneMapValues(this.itemLabelFontMap);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 3260 */     if (this.itemLabelPaintList != null) {
/* 3261 */       clone
/* 3262 */         .itemLabelPaintList = (PaintList)this.itemLabelPaintList.clone();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 3267 */     if (this.positiveItemLabelPositionMap != null) {
/* 3268 */       clone.positiveItemLabelPositionMap = CloneUtils.cloneMapValues(this.positiveItemLabelPositionMap);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3274 */     if (this.negativeItemLabelPositionMap != null) {
/* 3275 */       clone.negativeItemLabelPositionMap = CloneUtils.cloneMapValues(this.negativeItemLabelPositionMap);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 3280 */     if (this.createEntitiesList != null) {
/* 3281 */       clone
/* 3282 */         .createEntitiesList = (BooleanList)this.createEntitiesList.clone();
/*      */     }
/*      */     
/* 3285 */     if (this.legendShapeList != null) {
/* 3286 */       clone.legendShapeList = (ShapeList)this.legendShapeList.clone();
/*      */     }
/* 3288 */     if (this.legendTextFontMap != null) {
/* 3289 */       clone.legendTextFontMap = CloneUtils.cloneMapValues(this.legendTextFontMap);
/*      */     }
/*      */     
/* 3292 */     if (this.legendTextPaint != null) {
/* 3293 */       clone.legendTextPaint = (PaintList)this.legendTextPaint.clone();
/*      */     }
/* 3295 */     clone.listenerList = new EventListenerList();
/* 3296 */     clone.event = null;
/* 3297 */     return clone;
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
/*      */   private void writeObject(ObjectOutputStream stream) throws IOException {
/* 3309 */     stream.defaultWriteObject();
/* 3310 */     SerialUtilities.writePaint(this.paint, stream);
/* 3311 */     SerialUtilities.writePaint(this.basePaint, stream);
/* 3312 */     SerialUtilities.writePaint(this.fillPaint, stream);
/* 3313 */     SerialUtilities.writePaint(this.baseFillPaint, stream);
/* 3314 */     SerialUtilities.writePaint(this.outlinePaint, stream);
/* 3315 */     SerialUtilities.writePaint(this.baseOutlinePaint, stream);
/* 3316 */     SerialUtilities.writeStroke(this.stroke, stream);
/* 3317 */     SerialUtilities.writeStroke(this.baseStroke, stream);
/* 3318 */     SerialUtilities.writeStroke(this.outlineStroke, stream);
/* 3319 */     SerialUtilities.writeStroke(this.baseOutlineStroke, stream);
/* 3320 */     SerialUtilities.writeShape(this.shape, stream);
/* 3321 */     SerialUtilities.writeShape(this.baseShape, stream);
/* 3322 */     SerialUtilities.writePaint(this.itemLabelPaint, stream);
/* 3323 */     SerialUtilities.writePaint(this.baseItemLabelPaint, stream);
/* 3324 */     SerialUtilities.writeShape(this.baseLegendShape, stream);
/* 3325 */     SerialUtilities.writePaint(this.baseLegendTextPaint, stream);
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
/*      */   private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
/* 3340 */     stream.defaultReadObject();
/* 3341 */     this.paint = SerialUtilities.readPaint(stream);
/* 3342 */     this.basePaint = SerialUtilities.readPaint(stream);
/* 3343 */     this.fillPaint = SerialUtilities.readPaint(stream);
/* 3344 */     this.baseFillPaint = SerialUtilities.readPaint(stream);
/* 3345 */     this.outlinePaint = SerialUtilities.readPaint(stream);
/* 3346 */     this.baseOutlinePaint = SerialUtilities.readPaint(stream);
/* 3347 */     this.stroke = SerialUtilities.readStroke(stream);
/* 3348 */     this.baseStroke = SerialUtilities.readStroke(stream);
/* 3349 */     this.outlineStroke = SerialUtilities.readStroke(stream);
/* 3350 */     this.baseOutlineStroke = SerialUtilities.readStroke(stream);
/* 3351 */     this.shape = SerialUtilities.readShape(stream);
/* 3352 */     this.baseShape = SerialUtilities.readShape(stream);
/* 3353 */     this.itemLabelPaint = SerialUtilities.readPaint(stream);
/* 3354 */     this.baseItemLabelPaint = SerialUtilities.readPaint(stream);
/* 3355 */     this.baseLegendShape = SerialUtilities.readShape(stream);
/* 3356 */     this.baseLegendTextPaint = SerialUtilities.readPaint(stream);
/*      */ 
/*      */ 
/*      */     
/* 3360 */     this.listenerList = new EventListenerList();
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 3498 */   public Boolean getSeriesVisible() { return this.seriesVisible; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 3516 */   public void setSeriesVisible(Boolean visible) { setSeriesVisible(visible, true); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSeriesVisible(Boolean visible, boolean notify) {
/* 3535 */     this.seriesVisible = visible;
/* 3536 */     if (notify) {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3541 */       RendererChangeEvent e = new RendererChangeEvent(this, true);
/* 3542 */       notifyListeners(e);
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
/* 3561 */   public Boolean getSeriesVisibleInLegend() { return this.seriesVisibleInLegend; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 3579 */   public void setSeriesVisibleInLegend(Boolean visible) { setSeriesVisibleInLegend(visible, true); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSeriesVisibleInLegend(Boolean visible, boolean notify) {
/* 3599 */     this.seriesVisibleInLegend = visible;
/* 3600 */     if (notify) {
/* 3601 */       fireChangeEvent();
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
/* 3617 */   public void setPaint(Paint paint) { setPaint(paint, true); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPaint(Paint paint, boolean notify) {
/* 3632 */     this.paint = paint;
/* 3633 */     if (notify) {
/* 3634 */       fireChangeEvent();
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
/* 3648 */   public void setFillPaint(Paint paint) { setFillPaint(paint, true); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFillPaint(Paint paint, boolean notify) {
/* 3663 */     this.fillPaint = paint;
/* 3664 */     if (notify) {
/* 3665 */       fireChangeEvent();
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
/* 3680 */   public void setOutlinePaint(Paint paint) { setOutlinePaint(paint, true); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOutlinePaint(Paint paint, boolean notify) {
/* 3695 */     this.outlinePaint = paint;
/* 3696 */     if (notify) {
/* 3697 */       fireChangeEvent();
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
/* 3712 */   public void setStroke(Stroke stroke) { setStroke(stroke, true); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setStroke(Stroke stroke, boolean notify) {
/* 3727 */     this.stroke = stroke;
/* 3728 */     if (notify) {
/* 3729 */       fireChangeEvent();
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
/* 3744 */   public void setOutlineStroke(Stroke stroke) { setOutlineStroke(stroke, true); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOutlineStroke(Stroke stroke, boolean notify) {
/* 3759 */     this.outlineStroke = stroke;
/* 3760 */     if (notify) {
/* 3761 */       fireChangeEvent();
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
/* 3776 */   public void setShape(Shape shape) { setShape(shape, true); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setShape(Shape shape, boolean notify) {
/* 3791 */     this.shape = shape;
/* 3792 */     if (notify) {
/* 3793 */       fireChangeEvent();
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
/* 3807 */   public void setItemLabelsVisible(boolean visible) { setItemLabelsVisible(Boolean.valueOf(visible)); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 3823 */   public void setItemLabelsVisible(Boolean visible) { setItemLabelsVisible(visible, true); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setItemLabelsVisible(Boolean visible, boolean notify) {
/* 3841 */     this.itemLabelsVisible = visible;
/* 3842 */     if (notify) {
/* 3843 */       fireChangeEvent();
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
/* 3858 */   public Font getItemLabelFont() { return this.itemLabelFont; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 3874 */   public void setItemLabelFont(Font font) { setItemLabelFont(font, true); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setItemLabelFont(Font font, boolean notify) {
/* 3890 */     this.itemLabelFont = font;
/* 3891 */     if (notify) {
/* 3892 */       fireChangeEvent();
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
/* 3908 */   public Paint getItemLabelPaint() { return this.itemLabelPaint; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 3922 */   public void setItemLabelPaint(Paint paint) { setItemLabelPaint(paint, true); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setItemLabelPaint(Paint paint, boolean notify) {
/* 3938 */     this.itemLabelPaint = paint;
/* 3939 */     if (notify) {
/* 3940 */       fireChangeEvent();
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
/* 3957 */   public ItemLabelPosition getPositiveItemLabelPosition() { return this.positiveItemLabelPosition; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 3976 */   public void setPositiveItemLabelPosition(ItemLabelPosition position) { setPositiveItemLabelPosition(position, true); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPositiveItemLabelPosition(ItemLabelPosition position, boolean notify) {
/* 3996 */     this.positiveItemLabelPosition = position;
/* 3997 */     if (notify) {
/* 3998 */       fireChangeEvent();
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
/* 4015 */   public ItemLabelPosition getNegativeItemLabelPosition() { return this.negativeItemLabelPosition; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 4034 */   public void setNegativeItemLabelPosition(ItemLabelPosition position) { setNegativeItemLabelPosition(position, true); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setNegativeItemLabelPosition(ItemLabelPosition position, boolean notify) {
/* 4055 */     this.negativeItemLabelPosition = position;
/* 4056 */     if (notify) {
/* 4057 */       fireChangeEvent();
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
/* 4074 */   public Boolean getCreateEntities() { return this.createEntities; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 4091 */   public void setCreateEntities(Boolean create) { setCreateEntities(create, true); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateEntities(Boolean create, boolean notify) {
/* 4109 */     this.createEntities = create;
/* 4110 */     if (notify)
/* 4111 */       fireChangeEvent(); 
/*      */   }
/*      */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/renderer/AbstractRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */