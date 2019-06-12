/*     */ package org.jfree.experimental.chart.swt.editor;
/*     */ 
/*     */ import java.awt.Stroke;
/*     */ import java.util.ResourceBundle;
/*     */ import org.eclipse.swt.graphics.Color;
/*     */ import org.eclipse.swt.layout.FillLayout;
/*     */ import org.eclipse.swt.widgets.Composite;
/*     */ import org.eclipse.swt.widgets.Group;
/*     */ import org.eclipse.swt.widgets.TabFolder;
/*     */ import org.eclipse.swt.widgets.TabItem;
/*     */ import org.jfree.chart.axis.CategoryAxis;
/*     */ import org.jfree.chart.axis.ValueAxis;
/*     */ import org.jfree.chart.plot.CategoryPlot;
/*     */ import org.jfree.chart.plot.Plot;
/*     */ import org.jfree.chart.plot.XYPlot;
/*     */ import org.jfree.chart.util.ResourceBundleWrapper;
/*     */ import org.jfree.experimental.swt.SWTUtils;
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
/*     */ 
/*     */ class SWTPlotEditor
/*     */   extends Composite
/*     */ {
/*     */   private SWTAxisEditor domainAxisPropertyPanel;
/*     */   private SWTAxisEditor rangeAxisPropertyPanel;
/*     */   private SWTPlotAppearanceEditor plotAppearance;
/*  81 */   protected static ResourceBundle localizationResources = ResourceBundleWrapper.getBundle("org.jfree.chart.editor.LocalizationBundle");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SWTPlotEditor(Composite parent, int style, Plot plot) {
/*  92 */     super(parent, style);
/*  93 */     FillLayout layout = new FillLayout();
/*  94 */     layout.marginHeight = layout.marginWidth = 4;
/*  95 */     setLayout(layout);
/*     */     
/*  97 */     Group plotType = new Group(this, false);
/*  98 */     FillLayout plotTypeLayout = new FillLayout();
/*  99 */     plotTypeLayout.marginHeight = plotTypeLayout.marginWidth = 4;
/* 100 */     plotType.setLayout(plotTypeLayout);
/* 101 */     plotType.setText(plot.getPlotType() + localizationResources.getString(":"));
/*     */ 
/*     */     
/* 104 */     TabFolder tabs = new TabFolder(plotType, false);
/*     */ 
/*     */     
/* 107 */     TabItem item1 = new TabItem(tabs, false);
/* 108 */     item1.setText(localizationResources.getString("Domain_Axis"));
/* 109 */     ValueAxis valueAxis1 = null;
/* 110 */     if (plot instanceof CategoryPlot) {
/* 111 */       CategoryAxis categoryAxis = ((CategoryPlot)plot).getDomainAxis();
/*     */     }
/* 113 */     else if (plot instanceof XYPlot) {
/* 114 */       valueAxis1 = ((XYPlot)plot).getDomainAxis();
/*     */     } 
/* 116 */     this.domainAxisPropertyPanel = SWTAxisEditor.getInstance(tabs, 0, valueAxis1);
/*     */     
/* 118 */     item1.setControl(this.domainAxisPropertyPanel);
/*     */ 
/*     */     
/* 121 */     TabItem item2 = new TabItem(tabs, false);
/* 122 */     item2.setText(localizationResources.getString("Range_Axis"));
/* 123 */     ValueAxis valueAxis2 = null;
/* 124 */     if (plot instanceof CategoryPlot) {
/* 125 */       ValueAxis valueAxis = ((CategoryPlot)plot).getRangeAxis();
/*     */     }
/* 127 */     else if (plot instanceof XYPlot) {
/* 128 */       valueAxis2 = ((XYPlot)plot).getRangeAxis();
/*     */     } 
/* 130 */     this.rangeAxisPropertyPanel = SWTAxisEditor.getInstance(tabs, 0, valueAxis2);
/*     */     
/* 132 */     item2.setControl(this.rangeAxisPropertyPanel);
/*     */ 
/*     */     
/* 135 */     TabItem item3 = new TabItem(tabs, false);
/* 136 */     item3.setText(localizationResources.getString("Appearance"));
/* 137 */     this.plotAppearance = new SWTPlotAppearanceEditor(tabs, false, plot);
/* 138 */     item3.setControl(this.plotAppearance);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 147 */   public Color getBackgroundPaint() { return this.plotAppearance.getBackGroundPaint(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 156 */   public Color getOutlinePaint() { return this.plotAppearance.getOutlinePaint(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 165 */   public Stroke getOutlineStroke() { return this.plotAppearance.getStroke(); }
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
/*     */   public void updatePlotProperties(Plot plot) {
/* 177 */     plot.setBackgroundPaint(SWTUtils.toAwtColor(getBackgroundPaint()));
/* 178 */     plot.setOutlinePaint(SWTUtils.toAwtColor(getOutlinePaint()));
/* 179 */     plot.setOutlineStroke(getOutlineStroke());
/*     */ 
/*     */     
/* 182 */     if (this.domainAxisPropertyPanel != null) {
/* 183 */       ValueAxis valueAxis = null;
/* 184 */       if (plot instanceof CategoryPlot) {
/* 185 */         CategoryPlot p = (CategoryPlot)plot;
/* 186 */         CategoryAxis categoryAxis = p.getDomainAxis();
/*     */       }
/* 188 */       else if (plot instanceof XYPlot) {
/* 189 */         XYPlot p = (XYPlot)plot;
/* 190 */         valueAxis = p.getDomainAxis();
/*     */       } 
/* 192 */       if (valueAxis != null)
/* 193 */         this.domainAxisPropertyPanel.setAxisProperties(valueAxis); 
/*     */     } 
/* 195 */     if (this.rangeAxisPropertyPanel != null) {
/* 196 */       ValueAxis valueAxis = null;
/* 197 */       if (plot instanceof CategoryPlot) {
/* 198 */         CategoryPlot p = (CategoryPlot)plot;
/* 199 */         ValueAxis valueAxis1 = p.getRangeAxis();
/*     */       }
/* 201 */       else if (plot instanceof XYPlot) {
/* 202 */         XYPlot p = (XYPlot)plot;
/* 203 */         valueAxis = p.getRangeAxis();
/*     */       } 
/* 205 */       if (valueAxis != null)
/* 206 */         this.rangeAxisPropertyPanel.setAxisProperties(valueAxis); 
/*     */     } 
/* 208 */     if (this.plotAppearance.getPlotOrientation() != null)
/* 209 */       if (plot instanceof CategoryPlot) {
/* 210 */         CategoryPlot p = (CategoryPlot)plot;
/* 211 */         p.setOrientation(this.plotAppearance.getPlotOrientation());
/*     */       }
/* 213 */       else if (plot instanceof XYPlot) {
/* 214 */         XYPlot p = (XYPlot)plot;
/* 215 */         p.setOrientation(this.plotAppearance.getPlotOrientation());
/*     */       }  
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/experimental/chart/swt/editor/SWTPlotEditor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */