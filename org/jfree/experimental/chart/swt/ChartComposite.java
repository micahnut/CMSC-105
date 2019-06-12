/*      */ package org.jfree.experimental.chart.swt;
/*      */ 
/*      */ import java.awt.Graphics;
/*      */ import java.awt.Point;
/*      */ import java.awt.RenderingHints;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.awt.geom.Point2D;
/*      */ import java.awt.geom.Rectangle2D;
/*      */ import java.awt.print.PageFormat;
/*      */ import java.awt.print.Printable;
/*      */ import java.awt.print.PrinterException;
/*      */ import java.io.File;
/*      */ import java.io.IOException;
/*      */ import java.util.EventListener;
/*      */ import java.util.ResourceBundle;
/*      */ import javax.swing.event.EventListenerList;
/*      */ import org.eclipse.swt.events.ControlListener;
/*      */ import org.eclipse.swt.events.DisposeEvent;
/*      */ import org.eclipse.swt.events.DisposeListener;
/*      */ import org.eclipse.swt.events.FocusListener;
/*      */ import org.eclipse.swt.events.HelpListener;
/*      */ import org.eclipse.swt.events.KeyListener;
/*      */ import org.eclipse.swt.events.MouseEvent;
/*      */ import org.eclipse.swt.events.MouseListener;
/*      */ import org.eclipse.swt.events.MouseMoveListener;
/*      */ import org.eclipse.swt.events.MouseTrackListener;
/*      */ import org.eclipse.swt.events.PaintEvent;
/*      */ import org.eclipse.swt.events.PaintListener;
/*      */ import org.eclipse.swt.events.SelectionEvent;
/*      */ import org.eclipse.swt.events.SelectionListener;
/*      */ import org.eclipse.swt.events.TraverseListener;
/*      */ import org.eclipse.swt.graphics.GC;
/*      */ import org.eclipse.swt.graphics.Image;
/*      */ import org.eclipse.swt.graphics.Point;
/*      */ import org.eclipse.swt.graphics.Rectangle;
/*      */ import org.eclipse.swt.layout.FillLayout;
/*      */ import org.eclipse.swt.widgets.Canvas;
/*      */ import org.eclipse.swt.widgets.Composite;
/*      */ import org.eclipse.swt.widgets.Event;
/*      */ import org.eclipse.swt.widgets.FileDialog;
/*      */ import org.eclipse.swt.widgets.Menu;
/*      */ import org.eclipse.swt.widgets.MenuItem;
/*      */ import org.jfree.chart.ChartMouseEvent;
/*      */ import org.jfree.chart.ChartMouseListener;
/*      */ import org.jfree.chart.ChartRenderingInfo;
/*      */ import org.jfree.chart.ChartUtilities;
/*      */ import org.jfree.chart.JFreeChart;
/*      */ import org.jfree.chart.entity.ChartEntity;
/*      */ import org.jfree.chart.entity.EntityCollection;
/*      */ import org.jfree.chart.event.ChartChangeEvent;
/*      */ import org.jfree.chart.event.ChartChangeListener;
/*      */ import org.jfree.chart.event.ChartProgressEvent;
/*      */ import org.jfree.chart.event.ChartProgressListener;
/*      */ import org.jfree.chart.plot.Plot;
/*      */ import org.jfree.chart.plot.PlotOrientation;
/*      */ import org.jfree.chart.plot.PlotRenderingInfo;
/*      */ import org.jfree.chart.plot.Zoomable;
/*      */ import org.jfree.chart.util.ResourceBundleWrapper;
/*      */ import org.jfree.experimental.chart.swt.editor.SWTChartEditor;
/*      */ import org.jfree.experimental.swt.SWTGraphics2D;
/*      */ import org.jfree.experimental.swt.SWTUtils;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class ChartComposite
/*      */   extends Composite
/*      */   implements ChartChangeListener, ChartProgressListener, PaintListener, SelectionListener, MouseListener, MouseMoveListener, Printable
/*      */ {
/*      */   public static final boolean DEFAULT_BUFFER_USED = false;
/*      */   public static final int DEFAULT_WIDTH = 680;
/*      */   public static final int DEFAULT_HEIGHT = 420;
/*      */   public static final int DEFAULT_MINIMUM_DRAW_WIDTH = 300;
/*      */   public static final int DEFAULT_MINIMUM_DRAW_HEIGHT = 200;
/*      */   public static final int DEFAULT_MAXIMUM_DRAW_WIDTH = 800;
/*      */   public static final int DEFAULT_MAXIMUM_DRAW_HEIGHT = 600;
/*      */   public static final int DEFAULT_ZOOM_TRIGGER_DISTANCE = 10;
/*      */   public static final String PROPERTIES_COMMAND = "PROPERTIES";
/*      */   public static final String SAVE_COMMAND = "SAVE";
/*      */   public static final String PRINT_COMMAND = "PRINT";
/*      */   public static final String ZOOM_IN_BOTH_COMMAND = "ZOOM_IN_BOTH";
/*      */   public static final String ZOOM_IN_DOMAIN_COMMAND = "ZOOM_IN_DOMAIN";
/*      */   public static final String ZOOM_IN_RANGE_COMMAND = "ZOOM_IN_RANGE";
/*      */   public static final String ZOOM_OUT_BOTH_COMMAND = "ZOOM_OUT_BOTH";
/*      */   public static final String ZOOM_OUT_DOMAIN_COMMAND = "ZOOM_DOMAIN_BOTH";
/*      */   public static final String ZOOM_OUT_RANGE_COMMAND = "ZOOM_RANGE_BOTH";
/*      */   public static final String ZOOM_RESET_BOTH_COMMAND = "ZOOM_RESET_BOTH";
/*      */   public static final String ZOOM_RESET_DOMAIN_COMMAND = "ZOOM_RESET_DOMAIN";
/*      */   public static final String ZOOM_RESET_RANGE_COMMAND = "ZOOM_RESET_RANGE";
/*      */   private JFreeChart chart;
/*      */   private Canvas canvas;
/*      */   private EventListenerList chartMouseListeners;
/*      */   private boolean useBuffer;
/*      */   private boolean refreshBuffer;
/*      */   private boolean displayToolTips;
/*      */   private Image chartBuffer;
/*      */   private int chartBufferHeight;
/*      */   private int chartBufferWidth;
/*      */   private int minimumDrawWidth;
/*      */   private int minimumDrawHeight;
/*      */   private int maximumDrawWidth;
/*      */   private int maximumDrawHeight;
/*      */   private Menu popup;
/*      */   private ChartRenderingInfo info;
/*      */   private Point2D anchor;
/*      */   private double scaleX;
/*      */   private double scaleY;
/*  282 */   private PlotOrientation orientation = PlotOrientation.VERTICAL;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean domainZoomable = false;
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean rangeZoomable = false;
/*      */ 
/*      */ 
/*      */   
/*  295 */   private Point zoomPoint = null;
/*      */ 
/*      */   
/*  298 */   private Rectangle zoomRectangle = null;
/*      */ 
/*      */ 
/*      */   
/*      */   private int zoomTriggerDistance;
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean horizontalAxisTrace = false;
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean verticalAxisTrace = false;
/*      */ 
/*      */   
/*      */   private int verticalTraceLineX;
/*      */ 
/*      */   
/*      */   private int horizontalTraceLineY;
/*      */ 
/*      */   
/*      */   private MenuItem zoomInBothMenuItem;
/*      */ 
/*      */   
/*      */   private MenuItem zoomInDomainMenuItem;
/*      */ 
/*      */   
/*      */   private MenuItem zoomInRangeMenuItem;
/*      */ 
/*      */   
/*      */   private MenuItem zoomOutBothMenuItem;
/*      */ 
/*      */   
/*      */   private MenuItem zoomOutDomainMenuItem;
/*      */ 
/*      */   
/*      */   private MenuItem zoomOutRangeMenuItem;
/*      */ 
/*      */   
/*      */   private MenuItem zoomResetBothMenuItem;
/*      */ 
/*      */   
/*      */   private MenuItem zoomResetDomainMenuItem;
/*      */ 
/*      */   
/*      */   private MenuItem zoomResetRangeMenuItem;
/*      */ 
/*      */   
/*      */   private boolean enforceFileExtensions;
/*      */ 
/*      */   
/*  349 */   private double zoomInFactor = 0.5D;
/*      */ 
/*      */   
/*  352 */   private double zoomOutFactor = 2.0D;
/*      */ 
/*      */ 
/*      */   
/*  356 */   protected static ResourceBundle localizationResources = ResourceBundleWrapper.getBundle("org.jfree.chart.LocalizationBundle");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  366 */   public ChartComposite(Composite comp, int style) { this(comp, style, null, 680, 420, 300, 200, 800, 600, false, true, true, true, true, true); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  392 */   public ChartComposite(Composite comp, int style, JFreeChart chart) { this(comp, style, chart, 680, 420, 300, 200, 800, 600, false, true, true, true, true, true); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  422 */   public ChartComposite(Composite comp, int style, JFreeChart chart, boolean useBuffer) { this(comp, style, chart, 680, 420, 300, 200, 800, 600, useBuffer, true, true, true, true, true); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  464 */   public ChartComposite(Composite comp, int style, JFreeChart chart, boolean properties, boolean save, boolean print, boolean zoom, boolean tooltips) { this(comp, style, chart, 680, 420, 300, 200, 800, 600, false, properties, save, print, zoom, tooltips); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ChartComposite(Composite comp, int style, JFreeChart jfreechart, int width, int height, int minimumDrawW, int minimumDrawH, int maximumDrawW, int maximumDrawH, boolean usingBuffer, boolean properties, boolean save, boolean print, boolean zoom, boolean tooltips) {
/*  524 */     super(comp, style);
/*  525 */     setChart(jfreechart);
/*  526 */     this.chartMouseListeners = new EventListenerList();
/*  527 */     setLayout(new FillLayout());
/*  528 */     this.info = new ChartRenderingInfo();
/*  529 */     this.useBuffer = usingBuffer;
/*  530 */     this.refreshBuffer = false;
/*  531 */     this.minimumDrawWidth = minimumDrawW;
/*  532 */     this.minimumDrawHeight = minimumDrawH;
/*  533 */     this.maximumDrawWidth = maximumDrawW;
/*  534 */     this.maximumDrawHeight = maximumDrawH;
/*  535 */     this.zoomTriggerDistance = 10;
/*  536 */     setDisplayToolTips(tooltips);
/*      */     
/*  538 */     this.canvas = new Canvas(this, 537133056);
/*  539 */     this.canvas.addPaintListener(this);
/*  540 */     this.canvas.addMouseListener(this);
/*  541 */     this.canvas.addMouseMoveListener(this);
/*  542 */     this.canvas.addDisposeListener(new DisposeListener()
/*      */         {
/*      */           public void widgetDisposed(DisposeEvent e) {
/*  545 */             Image img = (Image)ChartComposite.this.canvas.getData("double-buffer-image");
/*  546 */             if (img != null) {
/*  547 */               img.dispose();
/*      */             }
/*      */           }
/*      */         });
/*      */ 
/*      */     
/*  553 */     this.popup = null;
/*  554 */     if (properties || save || print || zoom) {
/*  555 */       this.popup = createPopupMenu(properties, save, print, zoom);
/*      */     }
/*  557 */     this.enforceFileExtensions = true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  567 */   public double getScaleX() { return this.scaleX; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  577 */   public double getScaleY() { return this.scaleY; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  586 */   public Point2D getAnchor() { return this.anchor; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  596 */   protected void setAnchor(Point2D anchor) { this.anchor = anchor; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  605 */   public JFreeChart getChart() { return this.chart; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setChart(JFreeChart chart) {
/*  615 */     if (this.chart != null) {
/*  616 */       this.chart.removeChangeListener(this);
/*  617 */       this.chart.removeProgressListener(this);
/*      */     } 
/*      */ 
/*      */     
/*  621 */     this.chart = chart;
/*  622 */     if (chart != null) {
/*  623 */       this.chart.addChangeListener(this);
/*  624 */       this.chart.addProgressListener(this);
/*  625 */       Plot plot = chart.getPlot();
/*  626 */       this.domainZoomable = false;
/*  627 */       this.rangeZoomable = false;
/*  628 */       if (plot instanceof Zoomable) {
/*  629 */         Zoomable z = (Zoomable)plot;
/*  630 */         this.domainZoomable = z.isDomainZoomable();
/*  631 */         this.rangeZoomable = z.isRangeZoomable();
/*  632 */         this.orientation = z.getOrientation();
/*      */       } 
/*      */     } else {
/*      */       
/*  636 */       this.domainZoomable = false;
/*  637 */       this.rangeZoomable = false;
/*      */     } 
/*  639 */     if (this.useBuffer) {
/*  640 */       this.refreshBuffer = true;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  650 */   public ChartRenderingInfo getChartRenderingInfo() { return this.info; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  660 */   public boolean isDomainZoomable() { return this.domainZoomable; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDomainZoomable(boolean flag) {
/*  671 */     if (flag) {
/*  672 */       Plot plot = this.chart.getPlot();
/*  673 */       if (plot instanceof Zoomable) {
/*  674 */         Zoomable z = (Zoomable)plot;
/*  675 */         this.domainZoomable = (flag && z.isDomainZoomable());
/*      */       } 
/*      */     } else {
/*      */       
/*  679 */       this.domainZoomable = false;
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
/*  690 */   public boolean isRangeZoomable() { return this.rangeZoomable; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRangeZoomable(boolean flag) {
/*  699 */     if (flag) {
/*  700 */       Plot plot = this.chart.getPlot();
/*  701 */       if (plot instanceof Zoomable) {
/*  702 */         Zoomable z = (Zoomable)plot;
/*  703 */         this.rangeZoomable = (flag && z.isRangeZoomable());
/*      */       } 
/*      */     } else {
/*      */       
/*  707 */       this.rangeZoomable = false;
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
/*  719 */   public double getZoomInFactor() { return this.zoomInFactor; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  730 */   public void setZoomInFactor(double factor) { this.zoomInFactor = factor; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  741 */   public double getZoomOutFactor() { return this.zoomOutFactor; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  752 */   public void setZoomOutFactor(double factor) { this.zoomOutFactor = factor; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void attemptEditChartProperties() {
/*  760 */     SWTChartEditor editor = new SWTChartEditor(this.canvas.getDisplay(), this.chart);
/*      */ 
/*      */     
/*  763 */     editor.open();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  773 */   public boolean isEnforceFileExtensions() { return this.enforceFileExtensions; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  782 */   public void setEnforceFileExtensions(boolean enforce) { this.enforceFileExtensions = enforce; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void doSaveAs() {
/*  792 */     FileDialog fileDialog = new FileDialog(this.canvas.getShell(), ' ');
/*      */     
/*  794 */     String[] extensions = { "*.png" };
/*  795 */     fileDialog.setFilterExtensions(extensions);
/*  796 */     String filename = fileDialog.open();
/*  797 */     if (filename != null) {
/*  798 */       if (isEnforceFileExtensions() && 
/*  799 */         !filename.endsWith(".png")) {
/*  800 */         filename = filename + ".png";
/*      */       }
/*      */ 
/*      */       
/*  804 */       ChartUtilities.saveChartAsPNG(new File(filename), this.chart, 
/*  805 */           (this.canvas.getSize()).x, (this.canvas.getSize()).y);
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
/*      */   private Point getPointInRectangle(int x, int y, Rectangle area) {
/*  821 */     x = Math.max(area.x, Math.min(x, area.x + area.width));
/*  822 */     y = Math.max(area.y, Math.min(y, area.y + area.height));
/*  823 */     return new Point(x, y);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void zoomInBoth(double x, double y) {
/*  833 */     zoomInDomain(x, y);
/*  834 */     zoomInRange(x, y);
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
/*      */   public void zoomInDomain(double x, double y) {
/*  846 */     Plot p = this.chart.getPlot();
/*  847 */     if (p instanceof Zoomable) {
/*      */       
/*  849 */       Zoomable plot = (Zoomable)p;
/*  850 */       plot.zoomDomainAxes(this.zoomInFactor, this.info.getPlotInfo(), 
/*  851 */           translateScreenToJava2D(new Point((int)x, (int)y)));
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
/*      */   public void zoomInRange(double x, double y) {
/*  864 */     Plot p = this.chart.getPlot();
/*  865 */     if (p instanceof Zoomable) {
/*  866 */       Zoomable z = (Zoomable)p;
/*  867 */       z.zoomRangeAxes(this.zoomInFactor, this.info.getPlotInfo(), 
/*  868 */           translateScreenToJava2D(new Point((int)x, (int)y)));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void zoomOutBoth(double x, double y) {
/*  879 */     zoomOutDomain(x, y);
/*  880 */     zoomOutRange(x, y);
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
/*      */   public void zoomOutDomain(double x, double y) {
/*  892 */     Plot p = this.chart.getPlot();
/*  893 */     if (p instanceof Zoomable) {
/*  894 */       Zoomable z = (Zoomable)p;
/*  895 */       z.zoomDomainAxes(this.zoomOutFactor, this.info.getPlotInfo(), 
/*  896 */           translateScreenToJava2D(new Point((int)x, (int)y)));
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
/*      */   public void zoomOutRange(double x, double y) {
/*  909 */     Plot p = this.chart.getPlot();
/*  910 */     if (p instanceof Zoomable) {
/*  911 */       Zoomable z = (Zoomable)p;
/*  912 */       z.zoomRangeAxes(this.zoomOutFactor, this.info.getPlotInfo(), 
/*  913 */           translateScreenToJava2D(new Point((int)x, (int)y)));
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
/*      */   public void zoom(Rectangle selection) {
/*  926 */     Point2D selectOrigin = translateScreenToJava2D(new Point(selection.x, selection.y));
/*      */     
/*  928 */     PlotRenderingInfo plotInfo = this.info.getPlotInfo();
/*  929 */     Rectangle scaledDataArea = getScreenDataArea(selection.x + selection.width / 2, selection.y + selection.height / 2);
/*      */ 
/*      */     
/*  932 */     if (selection.height > 0 && selection.width > 0) {
/*      */       
/*  934 */       double hLower = (selection.x - scaledDataArea.x) / scaledDataArea.width;
/*      */       
/*  936 */       double hUpper = (selection.x + selection.width - scaledDataArea.x) / scaledDataArea.width;
/*      */       
/*  938 */       double vLower = (scaledDataArea.y + scaledDataArea.height - selection.y - selection.height) / scaledDataArea.height;
/*      */ 
/*      */       
/*  941 */       double vUpper = (scaledDataArea.y + scaledDataArea.height - selection.y) / scaledDataArea.height;
/*      */       
/*  943 */       Plot p = this.chart.getPlot();
/*  944 */       if (p instanceof Zoomable) {
/*  945 */         Zoomable z = (Zoomable)p;
/*  946 */         if (z.getOrientation() == PlotOrientation.HORIZONTAL) {
/*  947 */           z.zoomDomainAxes(vLower, vUpper, plotInfo, selectOrigin);
/*  948 */           z.zoomRangeAxes(hLower, hUpper, plotInfo, selectOrigin);
/*      */         } else {
/*      */           
/*  951 */           z.zoomDomainAxes(hLower, hUpper, plotInfo, selectOrigin);
/*  952 */           z.zoomRangeAxes(vLower, vUpper, plotInfo, selectOrigin);
/*      */         } 
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
/*      */   public void chartChanged(ChartChangeEvent event) {
/*  966 */     this.refreshBuffer = true;
/*  967 */     Plot plot = this.chart.getPlot();
/*  968 */     if (plot instanceof Zoomable) {
/*  969 */       Zoomable z = (Zoomable)plot;
/*  970 */       this.orientation = z.getOrientation();
/*      */     } 
/*  972 */     this.canvas.redraw();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void forceRedraw() {
/*  979 */     Event ev = new Event();
/*  980 */     ev.gc = new GC(this.canvas);
/*  981 */     ev.x = 0;
/*  982 */     ev.y = 0;
/*  983 */     ev.width = (this.canvas.getBounds()).width;
/*  984 */     ev.height = (this.canvas.getBounds()).height;
/*  985 */     ev.count = 0;
/*  986 */     this.canvas.notifyListeners(9, ev);
/*  987 */     ev.gc.dispose();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  996 */   public void addChartMouseListener(ChartMouseListener listener) { this.chartMouseListeners.add(ChartMouseListener.class, listener); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1006 */   public void removeChartMouseListener(ChartMouseListener listener) { this.chartMouseListeners.remove(ChartMouseListener.class, listener); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void chartProgress(ChartProgressEvent event) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void restoreAutoBounds() {
/* 1022 */     restoreAutoDomainBounds();
/* 1023 */     restoreAutoRangeBounds();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void restoreAutoDomainBounds() {
/* 1030 */     Plot p = this.chart.getPlot();
/* 1031 */     if (p instanceof Zoomable) {
/* 1032 */       Zoomable z = (Zoomable)p;
/*      */       
/* 1034 */       Point zp = (this.zoomPoint != null) ? this.zoomPoint : new Point(false, false);
/*      */ 
/*      */       
/* 1037 */       z.zoomDomainAxes(0.0D, this.info.getPlotInfo(), 
/* 1038 */           SWTUtils.toAwtPoint(zp));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void restoreAutoRangeBounds() {
/* 1046 */     Plot p = this.chart.getPlot();
/* 1047 */     if (p instanceof org.jfree.chart.plot.ValueAxisPlot) {
/* 1048 */       Zoomable z = (Zoomable)p;
/*      */       
/* 1050 */       Point zp = (this.zoomPoint != null) ? this.zoomPoint : new Point(false, false);
/*      */ 
/*      */       
/* 1053 */       z.zoomRangeAxes(0.0D, this.info.getPlotInfo(), 
/* 1054 */           SWTUtils.toAwtPoint(zp));
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
/*      */   public Rectangle scale(Rectangle2D rect) {
/* 1067 */     Rectangle insets = getClientArea();
/* 1068 */     int x = (int)Math.round(rect.getX() * getScaleX()) + insets.x;
/* 1069 */     int y = (int)Math.round(rect.getY() * getScaleY()) + insets.y;
/* 1070 */     int w = (int)Math.round(rect.getWidth() * getScaleX());
/* 1071 */     int h = (int)Math.round(rect.getHeight() * getScaleY());
/* 1072 */     return new Rectangle(x, y, w, h);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Rectangle getScreenDataArea() {
/* 1082 */     Rectangle2D dataArea = this.info.getPlotInfo().getDataArea();
/* 1083 */     Rectangle clientArea = getClientArea();
/* 1084 */     int x = (int)(dataArea.getX() * this.scaleX + clientArea.x);
/* 1085 */     int y = (int)(dataArea.getY() * this.scaleY + clientArea.y);
/* 1086 */     int w = (int)(dataArea.getWidth() * this.scaleX);
/* 1087 */     int h = (int)(dataArea.getHeight() * this.scaleY);
/* 1088 */     return new Rectangle(x, y, w, h);
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
/*      */   public Rectangle getScreenDataArea(int x, int y) {
/*      */     Rectangle result;
/* 1101 */     PlotRenderingInfo plotInfo = this.info.getPlotInfo();
/*      */     
/* 1103 */     if (plotInfo.getSubplotCount() == 0) {
/* 1104 */       result = getScreenDataArea();
/*      */     }
/*      */     else {
/*      */       
/* 1108 */       Point2D selectOrigin = translateScreenToJava2D(new Point(x, y));
/* 1109 */       int subplotIndex = plotInfo.getSubplotIndex(selectOrigin);
/* 1110 */       if (subplotIndex == -1) {
/* 1111 */         return null;
/*      */       }
/* 1113 */       result = scale(plotInfo.getSubplotInfo(subplotIndex).getDataArea());
/*      */     } 
/* 1115 */     return result;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Point translateJava2DToScreen(Point2D java2DPoint) {
/* 1126 */     Rectangle insets = getClientArea();
/* 1127 */     int x = (int)(java2DPoint.getX() * this.scaleX + insets.x);
/* 1128 */     int y = (int)(java2DPoint.getY() * this.scaleY + insets.y);
/* 1129 */     return new Point(x, y);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Point translateScreenToJavaSWT(Point screenPoint) {
/* 1140 */     Rectangle insets = getClientArea();
/* 1141 */     int x = (int)((screenPoint.x - insets.x) / this.scaleX);
/* 1142 */     int y = (int)((screenPoint.y - insets.y) / this.scaleY);
/* 1143 */     return new Point(x, y);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Point2D translateScreenToJava2D(Point screenPoint) {
/* 1154 */     Rectangle insets = getClientArea();
/* 1155 */     int x = (int)((screenPoint.x - insets.x) / this.scaleX);
/* 1156 */     int y = (int)((screenPoint.y - insets.y) / this.scaleY);
/* 1157 */     return new Point2D.Double(x, y);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1167 */   public boolean getHorizontalAxisTrace() { return this.horizontalAxisTrace; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1177 */   public void setHorizontalAxisTrace(boolean flag) { this.horizontalAxisTrace = flag; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1187 */   public boolean getVerticalAxisTrace() { return this.verticalAxisTrace; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1197 */   public void setVerticalAxisTrace(boolean flag) { this.verticalAxisTrace = flag; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1204 */   public void setDisplayToolTips(boolean displayToolTips) { this.displayToolTips = displayToolTips; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getToolTipText(MouseEvent e) {
/* 1215 */     String result = null;
/* 1216 */     if (this.info != null) {
/* 1217 */       EntityCollection entities = this.info.getEntityCollection();
/* 1218 */       if (entities != null) {
/* 1219 */         Rectangle insets = getClientArea();
/* 1220 */         ChartEntity entity = entities.getEntity((int)((e.x - insets.x) / this.scaleX), (int)((e.y - insets.y) / this.scaleY));
/*      */ 
/*      */         
/* 1223 */         if (entity != null) {
/* 1224 */           result = entity.getToolTipText();
/*      */         }
/*      */       } 
/*      */     } 
/* 1228 */     return result;
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
/*      */   protected void displayPopupMenu(int x, int y) {
/* 1240 */     if (this.popup != null) {
/*      */ 
/*      */       
/* 1243 */       Plot plot = this.chart.getPlot();
/* 1244 */       boolean isDomainZoomable = false;
/* 1245 */       boolean isRangeZoomable = false;
/* 1246 */       if (plot instanceof Zoomable) {
/* 1247 */         Zoomable z = (Zoomable)plot;
/* 1248 */         isDomainZoomable = z.isDomainZoomable();
/* 1249 */         isRangeZoomable = z.isRangeZoomable();
/*      */       } 
/* 1251 */       if (this.zoomInDomainMenuItem != null) {
/* 1252 */         this.zoomInDomainMenuItem.setEnabled(isDomainZoomable);
/*      */       }
/* 1254 */       if (this.zoomOutDomainMenuItem != null) {
/* 1255 */         this.zoomOutDomainMenuItem.setEnabled(isDomainZoomable);
/*      */       }
/* 1257 */       if (this.zoomResetDomainMenuItem != null) {
/* 1258 */         this.zoomResetDomainMenuItem.setEnabled(isDomainZoomable);
/*      */       }
/*      */       
/* 1261 */       if (this.zoomInRangeMenuItem != null) {
/* 1262 */         this.zoomInRangeMenuItem.setEnabled(isRangeZoomable);
/*      */       }
/* 1264 */       if (this.zoomOutRangeMenuItem != null) {
/* 1265 */         this.zoomOutRangeMenuItem.setEnabled(isRangeZoomable);
/*      */       }
/*      */       
/* 1268 */       if (this.zoomResetRangeMenuItem != null) {
/* 1269 */         this.zoomResetRangeMenuItem.setEnabled(isRangeZoomable);
/*      */       }
/*      */       
/* 1272 */       if (this.zoomInBothMenuItem != null) {
/* 1273 */         this.zoomInBothMenuItem.setEnabled(isDomainZoomable & isRangeZoomable);
/*      */       }
/*      */       
/* 1276 */       if (this.zoomOutBothMenuItem != null) {
/* 1277 */         this.zoomOutBothMenuItem.setEnabled(isDomainZoomable & isRangeZoomable);
/*      */       }
/*      */       
/* 1280 */       if (this.zoomResetBothMenuItem != null) {
/* 1281 */         this.zoomResetBothMenuItem.setEnabled(isDomainZoomable & isRangeZoomable);
/*      */       }
/*      */ 
/*      */       
/* 1285 */       this.popup.setLocation(x, y);
/* 1286 */       this.popup.setVisible(true);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1295 */   public void createChartPrintJob() { (new ChartPrintJob("PlotPrint")).print(this); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Menu createPopupMenu(boolean properties, boolean save, boolean print, boolean zoom) {
/* 1311 */     Menu result = new Menu(this);
/* 1312 */     boolean separator = false;
/*      */     
/* 1314 */     if (properties) {
/* 1315 */       MenuItem propertiesItem = new MenuItem(result, 8);
/* 1316 */       propertiesItem.setText(localizationResources.getString("Properties..."));
/*      */       
/* 1318 */       propertiesItem.setData("PROPERTIES");
/* 1319 */       propertiesItem.addSelectionListener(this);
/* 1320 */       separator = true;
/*      */     } 
/* 1322 */     if (save) {
/* 1323 */       if (separator) {
/* 1324 */         new MenuItem(result, 2);
/* 1325 */         separator = false;
/*      */       } 
/* 1327 */       MenuItem saveItem = new MenuItem(result, false);
/* 1328 */       saveItem.setText(localizationResources.getString("Save_as..."));
/* 1329 */       saveItem.setData("SAVE");
/* 1330 */       saveItem.addSelectionListener(this);
/* 1331 */       separator = true;
/*      */     } 
/* 1333 */     if (print) {
/* 1334 */       if (separator) {
/* 1335 */         new MenuItem(result, 2);
/* 1336 */         separator = false;
/*      */       } 
/* 1338 */       MenuItem printItem = new MenuItem(result, false);
/* 1339 */       printItem.setText(localizationResources.getString("Print..."));
/* 1340 */       printItem.setData("PRINT");
/* 1341 */       printItem.addSelectionListener(this);
/* 1342 */       separator = true;
/*      */     } 
/* 1344 */     if (zoom) {
/* 1345 */       if (separator) {
/* 1346 */         new MenuItem(result, 2);
/* 1347 */         separator = false;
/*      */       } 
/*      */       
/* 1350 */       Menu zoomInMenu = new Menu(result);
/* 1351 */       MenuItem zoomInMenuItem = new MenuItem(result, 64);
/* 1352 */       zoomInMenuItem.setText(localizationResources.getString("Zoom_In"));
/* 1353 */       zoomInMenuItem.setMenu(zoomInMenu);
/*      */       
/* 1355 */       this.zoomInBothMenuItem = new MenuItem(zoomInMenu, 8);
/* 1356 */       this.zoomInBothMenuItem.setText(localizationResources.getString("All_Axes"));
/*      */       
/* 1358 */       this.zoomInBothMenuItem.setData("ZOOM_IN_BOTH");
/* 1359 */       this.zoomInBothMenuItem.addSelectionListener(this);
/*      */       
/* 1361 */       new MenuItem(zoomInMenu, 2);
/*      */       
/* 1363 */       this.zoomInDomainMenuItem = new MenuItem(zoomInMenu, 8);
/* 1364 */       this.zoomInDomainMenuItem.setText(localizationResources.getString("Domain_Axis"));
/*      */       
/* 1366 */       this.zoomInDomainMenuItem.setData("ZOOM_IN_DOMAIN");
/* 1367 */       this.zoomInDomainMenuItem.addSelectionListener(this);
/*      */       
/* 1369 */       this.zoomInRangeMenuItem = new MenuItem(zoomInMenu, 8);
/* 1370 */       this.zoomInRangeMenuItem.setText(localizationResources.getString("Range_Axis"));
/*      */       
/* 1372 */       this.zoomInRangeMenuItem.setData("ZOOM_IN_RANGE");
/* 1373 */       this.zoomInRangeMenuItem.addSelectionListener(this);
/*      */       
/* 1375 */       Menu zoomOutMenu = new Menu(result);
/* 1376 */       MenuItem zoomOutMenuItem = new MenuItem(result, 64);
/* 1377 */       zoomOutMenuItem.setText(localizationResources.getString("Zoom_Out"));
/*      */       
/* 1379 */       zoomOutMenuItem.setMenu(zoomOutMenu);
/*      */       
/* 1381 */       this.zoomOutBothMenuItem = new MenuItem(zoomOutMenu, 8);
/* 1382 */       this.zoomOutBothMenuItem.setText(localizationResources.getString("All_Axes"));
/*      */       
/* 1384 */       this.zoomOutBothMenuItem.setData("ZOOM_OUT_BOTH");
/* 1385 */       this.zoomOutBothMenuItem.addSelectionListener(this);
/*      */       
/* 1387 */       new MenuItem(zoomOutMenu, 2);
/*      */       
/* 1389 */       this.zoomOutDomainMenuItem = new MenuItem(zoomOutMenu, 8);
/* 1390 */       this.zoomOutDomainMenuItem.setText(localizationResources.getString("Domain_Axis"));
/*      */       
/* 1392 */       this.zoomOutDomainMenuItem.setData("ZOOM_DOMAIN_BOTH");
/* 1393 */       this.zoomOutDomainMenuItem.addSelectionListener(this);
/*      */       
/* 1395 */       this.zoomOutRangeMenuItem = new MenuItem(zoomOutMenu, 8);
/* 1396 */       this.zoomOutRangeMenuItem.setText(localizationResources
/* 1397 */           .getString("Range_Axis"));
/* 1398 */       this.zoomOutRangeMenuItem.setData("ZOOM_RANGE_BOTH");
/* 1399 */       this.zoomOutRangeMenuItem.addSelectionListener(this);
/*      */       
/* 1401 */       Menu autoRangeMenu = new Menu(result);
/* 1402 */       MenuItem autoRangeMenuItem = new MenuItem(result, 64);
/* 1403 */       autoRangeMenuItem.setText(localizationResources.getString("Auto_Range"));
/*      */       
/* 1405 */       autoRangeMenuItem.setMenu(autoRangeMenu);
/*      */       
/* 1407 */       this.zoomResetBothMenuItem = new MenuItem(autoRangeMenu, 8);
/* 1408 */       this.zoomResetBothMenuItem.setText(localizationResources.getString("All_Axes"));
/*      */       
/* 1410 */       this.zoomResetBothMenuItem.setData("ZOOM_RESET_BOTH");
/* 1411 */       this.zoomResetBothMenuItem.addSelectionListener(this);
/*      */       
/* 1413 */       new MenuItem(autoRangeMenu, 2);
/*      */       
/* 1415 */       this.zoomResetDomainMenuItem = new MenuItem(autoRangeMenu, 8);
/*      */       
/* 1417 */       this.zoomResetDomainMenuItem.setText(localizationResources
/* 1418 */           .getString("Domain_Axis"));
/* 1419 */       this.zoomResetDomainMenuItem.setData("ZOOM_RESET_DOMAIN");
/* 1420 */       this.zoomResetDomainMenuItem.addSelectionListener(this);
/*      */       
/* 1422 */       this.zoomResetRangeMenuItem = new MenuItem(autoRangeMenu, 8);
/* 1423 */       this.zoomResetRangeMenuItem.setText(localizationResources
/* 1424 */           .getString("Range_Axis"));
/* 1425 */       this.zoomResetRangeMenuItem.setData("ZOOM_RESET_RANGE");
/* 1426 */       this.zoomResetRangeMenuItem.addSelectionListener(this);
/*      */     } 
/*      */     
/* 1429 */     return result;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1439 */   public void widgetDefaultSelected(SelectionEvent e) { widgetSelected(e); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void widgetSelected(SelectionEvent e) {
/* 1449 */     String command = (String)((MenuItem)e.getSource()).getData();
/* 1450 */     if (command.equals("PROPERTIES")) {
/* 1451 */       attemptEditChartProperties();
/*      */     }
/* 1453 */     else if (command.equals("SAVE")) {
/*      */       try {
/* 1455 */         doSaveAs();
/*      */       }
/* 1457 */       catch (IOException ex) {
/* 1458 */         ex.printStackTrace();
/*      */       }
/*      */     
/* 1461 */     } else if (command.equals("PRINT")) {
/* 1462 */       createChartPrintJob();
/*      */ 
/*      */ 
/*      */     
/*      */     }
/* 1467 */     else if (command.equals("ZOOM_IN_BOTH")) {
/* 1468 */       zoomInBoth(e.x, e.y);
/*      */     }
/* 1470 */     else if (command.equals("ZOOM_IN_DOMAIN")) {
/* 1471 */       zoomInDomain(e.x, e.y);
/*      */     }
/* 1473 */     else if (command.equals("ZOOM_IN_RANGE")) {
/* 1474 */       zoomInRange(e.x, e.y);
/*      */     }
/* 1476 */     else if (command.equals("ZOOM_OUT_BOTH")) {
/* 1477 */       zoomOutBoth(e.x, e.y);
/*      */     }
/* 1479 */     else if (command.equals("ZOOM_DOMAIN_BOTH")) {
/* 1480 */       zoomOutDomain(e.x, e.y);
/*      */     }
/* 1482 */     else if (command.equals("ZOOM_RANGE_BOTH")) {
/* 1483 */       zoomOutRange(e.x, e.y);
/*      */     }
/* 1485 */     else if (command.equals("ZOOM_RESET_BOTH")) {
/* 1486 */       restoreAutoBounds();
/*      */     }
/* 1488 */     else if (command.equals("ZOOM_RESET_DOMAIN")) {
/* 1489 */       restoreAutoDomainBounds();
/*      */     }
/* 1491 */     else if (command.equals("ZOOM_RESET_RANGE")) {
/* 1492 */       restoreAutoRangeBounds();
/*      */     } 
/* 1494 */     forceRedraw();
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
/*      */   public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
/* 1510 */     if (pageIndex != 0) {
/* 1511 */       return 1;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1525 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addSWTListener(EventListener listener) {
/* 1535 */     if (listener instanceof ControlListener) {
/* 1536 */       this.canvas.addControlListener((ControlListener)listener);
/*      */     }
/* 1538 */     else if (listener instanceof DisposeListener) {
/* 1539 */       this.canvas.addDisposeListener((DisposeListener)listener);
/*      */ 
/*      */ 
/*      */     
/*      */     }
/* 1544 */     else if (listener instanceof FocusListener) {
/* 1545 */       this.canvas.addFocusListener((FocusListener)listener);
/*      */     }
/* 1547 */     else if (listener instanceof HelpListener) {
/* 1548 */       this.canvas.addHelpListener((HelpListener)listener);
/*      */     }
/* 1550 */     else if (listener instanceof KeyListener) {
/* 1551 */       this.canvas.addKeyListener((KeyListener)listener);
/*      */ 
/*      */ 
/*      */     
/*      */     }
/* 1556 */     else if (listener instanceof MouseListener) {
/* 1557 */       this.canvas.addMouseListener((MouseListener)listener);
/*      */     }
/* 1559 */     else if (listener instanceof MouseMoveListener) {
/* 1560 */       this.canvas.addMouseMoveListener((MouseMoveListener)listener);
/*      */     }
/* 1562 */     else if (listener instanceof MouseTrackListener) {
/* 1563 */       this.canvas.addMouseTrackListener((MouseTrackListener)listener);
/*      */ 
/*      */     
/*      */     }
/* 1567 */     else if (listener instanceof PaintListener) {
/* 1568 */       this.canvas.addPaintListener((PaintListener)listener);
/*      */     }
/* 1570 */     else if (listener instanceof TraverseListener) {
/* 1571 */       this.canvas.addTraverseListener((TraverseListener)listener);
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
/*      */   public void mouseDoubleClick(MouseEvent event) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void mouseDown(MouseEvent event) {
/* 1591 */     Rectangle scaledDataArea = getScreenDataArea(event.x, event.y);
/* 1592 */     if (scaledDataArea == null)
/* 1593 */       return;  this.zoomPoint = getPointInRectangle(event.x, event.y, scaledDataArea);
/* 1594 */     int x = (int)((event.x - (getClientArea()).x) / this.scaleX);
/* 1595 */     int y = (int)((event.y - (getClientArea()).y) / this.scaleY);
/*      */     
/* 1597 */     this.anchor = new Point2D.Double(x, y);
/* 1598 */     this.chart.setNotify(true);
/* 1599 */     this.canvas.redraw();
/*      */ 
/*      */     
/* 1602 */     ChartEntity entity = null;
/* 1603 */     if (this.info != null) {
/* 1604 */       EntityCollection entities = this.info.getEntityCollection();
/* 1605 */       if (entities != null) {
/* 1606 */         entity = entities.getEntity(x, y);
/*      */       }
/*      */     } 
/*      */     
/* 1610 */     EventListener[] arrayOfEventListener = this.chartMouseListeners.getListeners(ChartMouseListener.class);
/*      */     
/* 1612 */     if (arrayOfEventListener.length == 0) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/* 1617 */     MouseEvent mouseEvent = SWTUtils.toAwtMouseEvent(event);
/* 1618 */     ChartMouseEvent chartEvent = new ChartMouseEvent(getChart(), mouseEvent, entity);
/*      */     
/* 1620 */     for (int i = arrayOfEventListener.length - 1; i >= 0; i--) {
/* 1621 */       ((ChartMouseListener)arrayOfEventListener[i]).chartMouseClicked(chartEvent);
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
/*      */   public void mouseUp(MouseEvent event) {
/* 1633 */     if (this.zoomRectangle == null) {
/* 1634 */       Rectangle screenDataArea = getScreenDataArea(event.x, event.y);
/* 1635 */       if (screenDataArea != null) {
/* 1636 */         this.zoomPoint = getPointInRectangle(event.x, event.y, screenDataArea);
/*      */       }
/*      */       
/* 1639 */       if (this.popup != null && event.button == 3) {
/* 1640 */         Point pt = this.canvas.toDisplay(event.x, event.y);
/*      */         
/* 1642 */         displayPopupMenu(pt.x, pt.y);
/*      */       } 
/*      */     } else {
/*      */       
/* 1646 */       boolean hZoom = false;
/* 1647 */       boolean vZoom = false;
/* 1648 */       if (this.orientation == PlotOrientation.HORIZONTAL) {
/* 1649 */         hZoom = this.rangeZoomable;
/* 1650 */         vZoom = this.domainZoomable;
/*      */       } else {
/*      */         
/* 1653 */         hZoom = this.domainZoomable;
/* 1654 */         vZoom = this.rangeZoomable;
/*      */       } 
/* 1656 */       boolean zoomTrigger1 = (hZoom && Math.abs(this.zoomRectangle.width) >= this.zoomTriggerDistance);
/*      */ 
/*      */       
/* 1659 */       boolean zoomTrigger2 = (vZoom && Math.abs(this.zoomRectangle.height) >= this.zoomTriggerDistance);
/*      */       
/* 1661 */       if (zoomTrigger1 || zoomTrigger2) {
/*      */         
/* 1663 */         if ((hZoom && this.zoomRectangle.x + this.zoomRectangle.width < this.zoomPoint.x) || (vZoom && this.zoomRectangle.y + this.zoomRectangle.height < this.zoomPoint.y)) {
/*      */ 
/*      */           
/* 1666 */           restoreAutoBounds();
/*      */         } else {
/* 1668 */           zoom(this.zoomRectangle);
/*      */         } 
/* 1670 */         this.canvas.redraw();
/*      */       } 
/*      */     } 
/* 1673 */     this.zoomPoint = null;
/* 1674 */     this.zoomRectangle = null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void mouseMove(MouseEvent event) {
/* 1685 */     if (this.horizontalAxisTrace || this.verticalAxisTrace) {
/* 1686 */       this.horizontalTraceLineY = event.y;
/* 1687 */       this.verticalTraceLineX = event.x;
/* 1688 */       this.canvas.redraw();
/*      */     } 
/*      */ 
/*      */     
/* 1692 */     if (this.displayToolTips) {
/* 1693 */       String s = getToolTipText(event);
/* 1694 */       if ((s == null && this.canvas.getToolTipText() != null) || (s != null && 
/* 1695 */         !s.equals(this.canvas.getToolTipText()))) {
/* 1696 */         this.canvas.setToolTipText(s);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1701 */     if (this.zoomPoint != null) {
/* 1702 */       boolean vZoom, hZoom; Rectangle scaledDataArea = getScreenDataArea(this.zoomPoint.x, this.zoomPoint.y);
/*      */ 
/*      */       
/* 1705 */       Point movingPoint = getPointInRectangle(event.x, event.y, scaledDataArea);
/* 1706 */       if (this.orientation == PlotOrientation.HORIZONTAL) {
/* 1707 */         hZoom = this.rangeZoomable;
/* 1708 */         vZoom = this.domainZoomable;
/*      */       } else {
/*      */         
/* 1711 */         hZoom = this.domainZoomable;
/* 1712 */         vZoom = this.rangeZoomable;
/*      */       } 
/* 1714 */       if (hZoom && vZoom) {
/*      */         
/* 1716 */         this.zoomRectangle = new Rectangle(this.zoomPoint.x, this.zoomPoint.y, movingPoint.x - this.zoomPoint.x, movingPoint.y - this.zoomPoint.y);
/*      */ 
/*      */       
/*      */       }
/* 1720 */       else if (hZoom) {
/* 1721 */         this.zoomRectangle = new Rectangle(this.zoomPoint.x, scaledDataArea.y, movingPoint.x - this.zoomPoint.x, scaledDataArea.height);
/*      */ 
/*      */       
/*      */       }
/* 1725 */       else if (vZoom) {
/* 1726 */         int ymax = Math.max(movingPoint.y, scaledDataArea.y);
/* 1727 */         this.zoomRectangle = new Rectangle(scaledDataArea.x, this.zoomPoint.y, scaledDataArea.width, ymax - this.zoomPoint.y);
/*      */       } 
/*      */ 
/*      */       
/* 1731 */       this.canvas.redraw();
/*      */     } 
/*      */ 
/*      */     
/* 1735 */     ChartEntity entity = null;
/* 1736 */     int x = (int)((event.x - (getClientArea()).x) / this.scaleX);
/* 1737 */     int y = (int)((event.y - (getClientArea()).y) / this.scaleY);
/*      */     
/* 1739 */     if (this.info != null) {
/* 1740 */       EntityCollection entities = this.info.getEntityCollection();
/* 1741 */       if (entities != null) {
/* 1742 */         entity = entities.getEntity(x, y);
/*      */       }
/*      */     } 
/*      */     
/* 1746 */     EventListener[] arrayOfEventListener = this.chartMouseListeners.getListeners(ChartMouseListener.class);
/*      */     
/* 1748 */     if (arrayOfEventListener.length == 0) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/* 1753 */     MouseEvent mouseEvent = SWTUtils.toAwtMouseEvent(event);
/* 1754 */     ChartMouseEvent chartEvent = new ChartMouseEvent(getChart(), mouseEvent, entity);
/*      */     
/* 1756 */     for (int i = arrayOfEventListener.length - 1; i >= 0; i--) {
/* 1757 */       ((ChartMouseListener)arrayOfEventListener[i]).chartMouseMoved(chartEvent);
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
/*      */   public void paintControl(PaintEvent e) {
/* 1769 */     Rectangle available = getBounds();
/*      */     
/* 1771 */     if (this.chart == null) {
/* 1772 */       this.canvas.drawBackground(e.gc, available.x, available.y, available.width, available.height);
/*      */       
/*      */       return;
/*      */     } 
/* 1776 */     SWTGraphics2D sg2 = new SWTGraphics2D(e.gc);
/*      */ 
/*      */     
/* 1779 */     boolean scale = false;
/* 1780 */     int drawWidth = available.width;
/* 1781 */     int drawHeight = available.height;
/* 1782 */     if (drawWidth == 0.0D || drawHeight == 0.0D)
/* 1783 */       return;  this.scaleX = 1.0D;
/* 1784 */     this.scaleY = 1.0D;
/* 1785 */     if (drawWidth < this.minimumDrawWidth) {
/* 1786 */       this.scaleX = drawWidth / this.minimumDrawWidth;
/* 1787 */       drawWidth = this.minimumDrawWidth;
/* 1788 */       scale = true;
/*      */     }
/* 1790 */     else if (drawWidth > this.maximumDrawWidth) {
/* 1791 */       this.scaleX = drawWidth / this.maximumDrawWidth;
/* 1792 */       drawWidth = this.maximumDrawWidth;
/* 1793 */       scale = true;
/*      */     } 
/* 1795 */     if (drawHeight < this.minimumDrawHeight) {
/* 1796 */       this.scaleY = drawHeight / this.minimumDrawHeight;
/* 1797 */       drawHeight = this.minimumDrawHeight;
/* 1798 */       scale = true;
/*      */     }
/* 1800 */     else if (drawHeight > this.maximumDrawHeight) {
/* 1801 */       this.scaleY = drawHeight / this.maximumDrawHeight;
/* 1802 */       drawHeight = this.maximumDrawHeight;
/* 1803 */       scale = true;
/*      */     } 
/*      */     
/* 1806 */     if (this.useBuffer) {
/*      */       
/* 1808 */       this
/* 1809 */         .chartBuffer = (Image)this.canvas.getData("double-buffer-image");
/*      */       
/* 1811 */       if (this.chartBuffer == null || this.chartBufferWidth != available.width || this.chartBufferHeight != available.height) {
/*      */ 
/*      */         
/* 1814 */         this.chartBufferWidth = available.width;
/* 1815 */         this.chartBufferHeight = available.height;
/* 1816 */         if (this.chartBuffer != null) {
/* 1817 */           this.chartBuffer.dispose();
/*      */         }
/* 1819 */         this
/* 1820 */           .chartBuffer = new Image(getDisplay(), this.chartBufferWidth, this.chartBufferHeight);
/*      */         
/* 1822 */         this.refreshBuffer = true;
/*      */       } 
/*      */ 
/*      */       
/* 1826 */       if (this.refreshBuffer) {
/*      */         
/* 1828 */         GC gci = new GC(this.chartBuffer);
/*      */         
/* 1830 */         if (this.chart.getAntiAlias()) {
/* 1831 */           gci.setAntialias(1);
/*      */         }
/* 1833 */         if (this.chart.getTextAntiAlias() == RenderingHints.KEY_TEXT_ANTIALIASING)
/*      */         {
/* 1835 */           gci.setTextAntialias(1);
/*      */         }
/* 1837 */         SWTGraphics2D sg2d = new SWTGraphics2D(gci);
/* 1838 */         if (scale) {
/* 1839 */           sg2d.scale(this.scaleX, this.scaleY);
/* 1840 */           this.chart.draw(sg2d, new Rectangle2D.Double(0.0D, 0.0D, drawWidth, drawHeight), 
/* 1841 */               getAnchor(), this.info);
/*      */         } else {
/*      */           
/* 1844 */           this.chart.draw(sg2d, new Rectangle2D.Double(0.0D, 0.0D, drawWidth, drawHeight), 
/* 1845 */               getAnchor(), this.info);
/*      */         } 
/* 1847 */         this.canvas.setData("double-buffer-image", this.chartBuffer);
/* 1848 */         sg2d.dispose();
/* 1849 */         gci.dispose();
/* 1850 */         this.refreshBuffer = false;
/*      */       } 
/*      */ 
/*      */       
/* 1854 */       sg2.drawImage(this.chartBuffer, 0, 0);
/*      */     }
/*      */     else {
/*      */       
/* 1858 */       if (this.chart.getAntiAlias()) {
/* 1859 */         e.gc.setAntialias(1);
/*      */       }
/* 1861 */       if (this.chart.getTextAntiAlias() == RenderingHints.KEY_TEXT_ANTIALIASING)
/*      */       {
/* 1863 */         e.gc.setTextAntialias(1);
/*      */       }
/* 1865 */       this.chart.draw(sg2, new Rectangle2D.Double(0.0D, 0.0D, 
/* 1866 */             (getBounds()).width, (getBounds()).height), getAnchor(), this.info);
/*      */     } 
/*      */     
/* 1869 */     Rectangle area = getScreenDataArea();
/*      */ 
/*      */     
/* 1872 */     if (this.horizontalAxisTrace && area.x < this.verticalTraceLineX && area.x + area.width > this.verticalTraceLineX)
/*      */     {
/* 1874 */       e.gc.drawLine(this.verticalTraceLineX, area.y, this.verticalTraceLineX, area.y + area.height);
/*      */     }
/*      */     
/* 1877 */     if (this.verticalAxisTrace && area.y < this.horizontalTraceLineY && area.y + area.height > this.horizontalTraceLineY)
/*      */     {
/* 1879 */       e.gc.drawLine(area.x, this.horizontalTraceLineY, area.x + area.width, this.horizontalTraceLineY);
/*      */     }
/*      */     
/* 1882 */     this.verticalTraceLineX = 0;
/* 1883 */     this.horizontalTraceLineY = 0;
/* 1884 */     if (this.zoomRectangle != null) {
/* 1885 */       e.gc.drawRectangle(this.zoomRectangle);
/*      */     }
/* 1887 */     sg2.dispose();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void dispose() {
/* 1895 */     if (this.chart != null) {
/* 1896 */       this.chart.removeChangeListener(this);
/* 1897 */       this.chart.removeProgressListener(this);
/*      */     } 
/*      */     
/* 1900 */     if (this.chartBuffer != null) {
/* 1901 */       this.chartBuffer.dispose();
/*      */     }
/*      */     
/* 1904 */     if (this.popup != null) {
/* 1905 */       this.popup.dispose();
/*      */     }
/* 1907 */     super.dispose();
/*      */   }
/*      */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/experimental/chart/swt/ChartComposite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */