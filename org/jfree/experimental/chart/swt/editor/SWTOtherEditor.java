/*     */ package org.jfree.experimental.chart.swt.editor;
/*     */ 
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
/*     */ import org.eclipse.swt.widgets.Composite;
/*     */ import org.eclipse.swt.widgets.Group;
/*     */ import org.eclipse.swt.widgets.Label;
/*     */ import org.jfree.chart.JFreeChart;
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
/*     */ class SWTOtherEditor
/*     */   extends Composite
/*     */ {
/*     */   private Button antialias;
/*     */   private SWTPaintCanvas backgroundPaintCanvas;
/*  79 */   protected static ResourceBundle localizationResources = ResourceBundleWrapper.getBundle("org.jfree.chart.editor.LocalizationBundle");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SWTOtherEditor(Composite parent, int style, JFreeChart chart) {
/*  90 */     super(parent, style);
/*  91 */     FillLayout layout = new FillLayout();
/*  92 */     layout.marginHeight = layout.marginWidth = 4;
/*  93 */     setLayout(layout);
/*     */     
/*  95 */     Group general = new Group(this, false);
/*  96 */     general.setLayout(new GridLayout(3, false));
/*  97 */     general.setText(localizationResources.getString("General"));
/*     */ 
/*     */     
/* 100 */     this.antialias = new Button(general, 32);
/* 101 */     this.antialias.setText(localizationResources.getString("Draw_anti-aliased"));
/*     */     
/* 103 */     this.antialias.setLayoutData(new GridData('䀀', 16777216, true, false, 3, true));
/*     */     
/* 105 */     this.antialias.setSelection(chart.getAntiAlias());
/*     */ 
/*     */     
/* 108 */     (new Label(general, false)).setText(localizationResources.getString("Background_paint"));
/*     */     
/* 110 */     this
/* 111 */       .backgroundPaintCanvas = new SWTPaintCanvas(general, false, SWTUtils.toSwtColor(getDisplay(), chart.getBackgroundPaint()));
/* 112 */     GridData bgGridData = new GridData(4, 16777216, true, false);
/* 113 */     bgGridData.heightHint = 20;
/* 114 */     this.backgroundPaintCanvas.setLayoutData(bgGridData);
/* 115 */     Button selectBgPaint = new Button(general, 8);
/* 116 */     selectBgPaint.setText(localizationResources.getString("Select..."));
/* 117 */     selectBgPaint.setLayoutData(new GridData(16777216, 16777216, false, false));
/*     */     
/* 119 */     selectBgPaint.addSelectionListener(new SelectionAdapter()
/*     */         {
/*     */           public void widgetSelected(SelectionEvent event) {
/* 122 */             ColorDialog dlg = new ColorDialog(SWTOtherEditor.this.getShell());
/* 123 */             dlg.setText(SWTOtherEditor.localizationResources.getString("Background_paint"));
/*     */             
/* 125 */             dlg.setRGB(SWTOtherEditor.this.backgroundPaintCanvas
/* 126 */                 .getColor().getRGB());
/* 127 */             RGB rgb = dlg.open();
/* 128 */             if (rgb != null) {
/* 129 */               SWTOtherEditor.this.backgroundPaintCanvas.setColor(new Color(SWTOtherEditor.this
/* 130 */                     .getDisplay(), rgb));
/*     */             }
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateChartProperties(JFreeChart chart) {
/* 143 */     chart.setAntiAlias(this.antialias.getSelection());
/* 144 */     chart.setBackgroundPaint(SWTUtils.toAwtColor(this.backgroundPaintCanvas
/* 145 */           .getColor()));
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/experimental/chart/swt/editor/SWTOtherEditor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */