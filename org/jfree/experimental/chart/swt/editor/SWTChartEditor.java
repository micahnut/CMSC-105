/*     */ package org.jfree.experimental.chart.swt.editor;
/*     */ 
/*     */ import java.util.ResourceBundle;
/*     */ import org.eclipse.swt.events.SelectionAdapter;
/*     */ import org.eclipse.swt.events.SelectionEvent;
/*     */ import org.eclipse.swt.layout.FillLayout;
/*     */ import org.eclipse.swt.layout.GridData;
/*     */ import org.eclipse.swt.layout.GridLayout;
/*     */ import org.eclipse.swt.widgets.Button;
/*     */ import org.eclipse.swt.widgets.Composite;
/*     */ import org.eclipse.swt.widgets.Display;
/*     */ import org.eclipse.swt.widgets.Shell;
/*     */ import org.eclipse.swt.widgets.TabFolder;
/*     */ import org.eclipse.swt.widgets.TabItem;
/*     */ import org.jfree.chart.JFreeChart;
/*     */ import org.jfree.chart.editor.ChartEditor;
/*     */ import org.jfree.chart.util.ResourceBundleWrapper;
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
/*     */ 
/*     */ public class SWTChartEditor
/*     */   implements ChartEditor
/*     */ {
/*     */   private Shell shell;
/*     */   private JFreeChart chart;
/*     */   private SWTTitleEditor titleEditor;
/*     */   private SWTPlotEditor plotEditor;
/*     */   private SWTOtherEditor otherEditor;
/*  85 */   protected static ResourceBundle localizationResources = ResourceBundleWrapper.getBundle("org.jfree.chart.editor.LocalizationBundle");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SWTChartEditor(Display display, JFreeChart chart2edit) {
/*  95 */     this.shell = new Shell(display, 'ࡠ');
/*  96 */     this.shell.setSize(400, 500);
/*  97 */     this.chart = chart2edit;
/*  98 */     this.shell.setText(ResourceBundleWrapper.getBundle("org.jfree.chart.LocalizationBundle")
/*  99 */         .getString("Chart_Properties"));
/*     */     
/* 101 */     GridLayout layout = new GridLayout(2, true);
/* 102 */     layout.marginLeft = layout.marginTop = layout.marginRight = layout.marginBottom = 5;
/*     */     
/* 104 */     this.shell.setLayout(layout);
/* 105 */     Composite main = new Composite(this.shell, false);
/* 106 */     main.setLayout(new FillLayout());
/* 107 */     main.setLayoutData(new GridData(4, 4, true, true, 2, true));
/*     */     
/* 109 */     TabFolder tab = new TabFolder(main, 'ࠀ');
/*     */     
/* 111 */     TabItem item1 = new TabItem(tab, false);
/* 112 */     item1.setText(" " + localizationResources.getString("Title") + " ");
/* 113 */     this
/* 114 */       .titleEditor = new SWTTitleEditor(tab, false, this.chart.getTitle());
/* 115 */     item1.setControl(this.titleEditor);
/*     */     
/* 117 */     TabItem item2 = new TabItem(tab, false);
/* 118 */     item2.setText(" " + localizationResources.getString("Plot") + " ");
/* 119 */     this
/* 120 */       .plotEditor = new SWTPlotEditor(tab, false, this.chart.getPlot());
/* 121 */     item2.setControl(this.plotEditor);
/*     */     
/* 123 */     TabItem item3 = new TabItem(tab, false);
/* 124 */     item3.setText(" " + localizationResources.getString("Other") + " ");
/* 125 */     this.otherEditor = new SWTOtherEditor(tab, false, this.chart);
/* 126 */     item3.setControl(this.otherEditor);
/*     */ 
/*     */     
/* 129 */     Button ok = new Button(this.shell, 40);
/* 130 */     ok.setText(" Ok ");
/* 131 */     ok.setLayoutData(new GridData(4, 4, false, false));
/* 132 */     ok.addSelectionListener(new SelectionAdapter() {
/*     */           public void widgetSelected(SelectionEvent e) {
/* 134 */             SWTChartEditor.this.updateChart(SWTChartEditor.this.chart);
/* 135 */             SWTChartEditor.this.shell.dispose();
/*     */           }
/*     */         });
/* 138 */     Button cancel = new Button(this.shell, 8);
/* 139 */     cancel.setText(" Cancel ");
/* 140 */     cancel.setLayoutData(new GridData(4, 4, false, false));
/* 141 */     cancel.addSelectionListener(new SelectionAdapter()
/*     */         {
/* 143 */           public void widgetSelected(SelectionEvent e) { SWTChartEditor.this.shell.dispose(); }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void open() {
/* 152 */     this.shell.open();
/* 153 */     this.shell.layout();
/* 154 */     while (!this.shell.isDisposed()) {
/* 155 */       if (!this.shell.getDisplay().readAndDispatch()) {
/* 156 */         this.shell.getDisplay().sleep();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateChart(JFreeChart chart) {
/* 168 */     this.titleEditor.setTitleProperties(chart);
/* 169 */     this.plotEditor.updatePlotProperties(chart.getPlot());
/* 170 */     this.otherEditor.updateChartProperties(chart);
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/experimental/chart/swt/editor/SWTChartEditor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */