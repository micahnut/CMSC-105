/*     */ package org.jfree.experimental.chart.swt.editor;
/*     */ 
/*     */ import java.awt.BasicStroke;
/*     */ import java.awt.Stroke;
/*     */ import java.util.ResourceBundle;
/*     */ import org.eclipse.swt.events.SelectionAdapter;
/*     */ import org.eclipse.swt.events.SelectionEvent;
/*     */ import org.eclipse.swt.graphics.Color;
/*     */ import org.eclipse.swt.graphics.RGB;
/*     */ import org.eclipse.swt.layout.FillLayout;
/*     */ import org.eclipse.swt.layout.GridData;
/*     */ import org.eclipse.swt.layout.GridLayout;
/*     */ import org.eclipse.swt.widgets.Button;
/*     */ import org.eclipse.swt.widgets.ColorDialog;
/*     */ import org.eclipse.swt.widgets.Combo;
/*     */ import org.eclipse.swt.widgets.Composite;
/*     */ import org.eclipse.swt.widgets.Group;
/*     */ import org.eclipse.swt.widgets.Label;
/*     */ import org.eclipse.swt.widgets.Spinner;
/*     */ import org.jfree.chart.plot.CategoryPlot;
/*     */ import org.jfree.chart.plot.Plot;
/*     */ import org.jfree.chart.plot.PlotOrientation;
/*     */ import org.jfree.chart.plot.XYPlot;
/*     */ import org.jfree.chart.util.ResourceBundleWrapper;
/*     */ import org.jfree.experimental.swt.SWTPaintCanvas;
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
/*     */ 
/*     */ class SWTPlotAppearanceEditor
/*     */   extends Composite
/*     */ {
/*     */   private Spinner selectStroke;
/*     */   private SWTStrokeCanvas strokeCanvas;
/*     */   private SWTPaintCanvas backgroundPaintCanvas;
/*     */   private SWTPaintCanvas outlinePaintCanvas;
/*     */   private PlotOrientation plotOrientation;
/*     */   private Combo orientation;
/*  94 */   private static final String[] orientationNames = { "Vertical", "Horizontal" };
/*     */   
/*     */   private static final int ORIENTATION_VERTICAL = 0;
/*     */   
/*     */   private static final int ORIENTATION_HORIZONTAL = 1;
/*     */   
/* 100 */   protected static ResourceBundle localizationResources = ResourceBundleWrapper.getBundle("org.jfree.chart.editor.LocalizationBundle");
/*     */ 
/*     */   
/*     */   SWTPlotAppearanceEditor(Composite parent, int style, Plot plot) {
/* 104 */     super(parent, style);
/* 105 */     FillLayout layout = new FillLayout();
/* 106 */     layout.marginHeight = layout.marginWidth = 4;
/* 107 */     setLayout(layout);
/*     */     
/* 109 */     Group general = new Group(this, false);
/* 110 */     GridLayout groupLayout = new GridLayout(3, false);
/* 111 */     groupLayout.marginHeight = groupLayout.marginWidth = 4;
/* 112 */     general.setLayout(groupLayout);
/* 113 */     general.setText(localizationResources.getString("General"));
/*     */ 
/*     */     
/* 116 */     (new Label(general, false)).setText(localizationResources.getString("Outline_stroke"));
/*     */     
/* 118 */     this.strokeCanvas = new SWTStrokeCanvas(general, false);
/* 119 */     this.strokeCanvas.setStroke(plot.getOutlineStroke());
/* 120 */     GridData strokeGridData = new GridData(4, 16777216, true, false);
/*     */     
/* 122 */     strokeGridData.heightHint = 20;
/* 123 */     this.strokeCanvas.setLayoutData(strokeGridData);
/* 124 */     this.selectStroke = new Spinner(general, 'ࠀ');
/* 125 */     this.selectStroke.setMinimum(1);
/* 126 */     this.selectStroke.setMaximum(3);
/* 127 */     this.selectStroke.setLayoutData(new GridData(4, 16777216, false, false));
/*     */     
/* 129 */     this.selectStroke.addSelectionListener(new SelectionAdapter()
/*     */         {
/*     */           public void widgetSelected(SelectionEvent event)
/*     */           {
/* 133 */             int w = SWTPlotAppearanceEditor.this.selectStroke.getSelection();
/* 134 */             if (w > 0) {
/* 135 */               SWTPlotAppearanceEditor.this.strokeCanvas.setStroke(new BasicStroke(w));
/*     */               
/* 137 */               SWTPlotAppearanceEditor.this.strokeCanvas.redraw();
/*     */             } 
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 143 */     (new Label(general, false)).setText(localizationResources.getString("Outline_Paint"));
/*     */     
/* 145 */     this
/* 146 */       .outlinePaintCanvas = new SWTPaintCanvas(general, false, SWTUtils.toSwtColor(getDisplay(), plot.getOutlinePaint()));
/* 147 */     GridData outlineGridData = new GridData(4, 16777216, true, false);
/*     */     
/* 149 */     outlineGridData.heightHint = 20;
/* 150 */     this.outlinePaintCanvas.setLayoutData(outlineGridData);
/* 151 */     Button selectOutlineColor = new Button(general, 8);
/* 152 */     selectOutlineColor.setText(localizationResources.getString("Select..."));
/*     */     
/* 154 */     selectOutlineColor.setLayoutData(new GridData(16777216, 16777216, false, false));
/*     */     
/* 156 */     selectOutlineColor.addSelectionListener(new SelectionAdapter()
/*     */         {
/*     */           public void widgetSelected(SelectionEvent event) {
/* 159 */             ColorDialog dlg = new ColorDialog(SWTPlotAppearanceEditor.this.getShell());
/* 160 */             dlg.setText(SWTPlotAppearanceEditor.localizationResources.getString("Outline_Paint"));
/*     */             
/* 162 */             dlg.setRGB(SWTPlotAppearanceEditor.this
/* 163 */                 .outlinePaintCanvas.getColor().getRGB());
/* 164 */             RGB rgb = dlg.open();
/* 165 */             if (rgb != null) {
/* 166 */               SWTPlotAppearanceEditor.this.outlinePaintCanvas
/* 167 */                 .setColor(new Color(SWTPlotAppearanceEditor.this.getDisplay(), rgb));
/*     */             }
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 173 */     (new Label(general, false)).setText(localizationResources.getString("Background_paint"));
/*     */     
/* 175 */     this
/* 176 */       .backgroundPaintCanvas = new SWTPaintCanvas(general, false, SWTUtils.toSwtColor(getDisplay(), plot.getBackgroundPaint()));
/* 177 */     GridData bgGridData = new GridData(4, 16777216, true, false);
/* 178 */     bgGridData.heightHint = 20;
/* 179 */     this.backgroundPaintCanvas.setLayoutData(bgGridData);
/* 180 */     Button selectBgPaint = new Button(general, 8);
/* 181 */     selectBgPaint.setText(localizationResources.getString("Select..."));
/* 182 */     selectBgPaint.setLayoutData(new GridData(16777216, 16777216, false, false));
/*     */     
/* 184 */     selectBgPaint.addSelectionListener(new SelectionAdapter()
/*     */         {
/*     */           public void widgetSelected(SelectionEvent event) {
/* 187 */             ColorDialog dlg = new ColorDialog(SWTPlotAppearanceEditor.this.getShell());
/* 188 */             dlg.setText(SWTPlotAppearanceEditor.localizationResources.getString("Background_paint"));
/*     */             
/* 190 */             dlg.setRGB(SWTPlotAppearanceEditor.this
/* 191 */                 .backgroundPaintCanvas.getColor().getRGB());
/* 192 */             RGB rgb = dlg.open();
/* 193 */             if (rgb != null) {
/* 194 */               SWTPlotAppearanceEditor.this.backgroundPaintCanvas
/* 195 */                 .setColor(new Color(SWTPlotAppearanceEditor.this.getDisplay(), rgb));
/*     */             }
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 201 */     if (plot instanceof CategoryPlot) {
/* 202 */       this.plotOrientation = ((CategoryPlot)plot).getOrientation();
/*     */     }
/* 204 */     else if (plot instanceof XYPlot) {
/* 205 */       this.plotOrientation = ((XYPlot)plot).getOrientation();
/*     */     } 
/* 207 */     if (this.plotOrientation != null) {
/*     */       
/* 209 */       boolean isVertical = this.plotOrientation.equals(PlotOrientation.VERTICAL);
/* 210 */       int index = isVertical ? 0 : 1;
/*     */       
/* 212 */       (new Label(general, false)).setText(localizationResources
/* 213 */           .getString("Orientation"));
/* 214 */       this.orientation = new Combo(general, 4);
/* 215 */       this.orientation.setItems(orientationNames);
/* 216 */       this.orientation.select(index);
/* 217 */       this.orientation.setLayoutData(new GridData(131072, 16777216, true, false, 2, true));
/*     */       
/* 219 */       this.orientation.addSelectionListener(new SelectionAdapter()
/*     */           {
/*     */             public void widgetSelected(SelectionEvent event) {
/* 222 */               switch (SWTPlotAppearanceEditor.this.orientation
/* 223 */                 .getSelectionIndex()) {
/*     */                 case 0:
/* 225 */                   SWTPlotAppearanceEditor.this.plotOrientation = PlotOrientation.VERTICAL;
/*     */                   return;
/*     */                 
/*     */                 case 1:
/* 229 */                   SWTPlotAppearanceEditor.this.plotOrientation = PlotOrientation.HORIZONTAL;
/*     */                   return;
/*     */               } 
/*     */               
/* 233 */               SWTPlotAppearanceEditor.this.plotOrientation = PlotOrientation.VERTICAL;
/*     */             }
/*     */           });
/*     */     } 
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
/* 248 */   public PlotOrientation getPlotOrientation() { return this.plotOrientation; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 257 */   public Color getBackGroundPaint() { return this.backgroundPaintCanvas.getColor(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 266 */   public Color getOutlinePaint() { return this.outlinePaintCanvas.getColor(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 275 */   public Stroke getStroke() { return this.strokeCanvas.getStroke(); }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/experimental/chart/swt/editor/SWTPlotAppearanceEditor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */