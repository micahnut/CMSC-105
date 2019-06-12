/*     */ package org.jfree.experimental.chart.swt.editor;
/*     */ 
/*     */ import java.awt.Font;
/*     */ import java.awt.Paint;
/*     */ import java.util.ResourceBundle;
/*     */ import org.eclipse.swt.events.SelectionAdapter;
/*     */ import org.eclipse.swt.events.SelectionEvent;
/*     */ import org.eclipse.swt.graphics.Color;
/*     */ import org.eclipse.swt.graphics.Font;
/*     */ import org.eclipse.swt.graphics.FontData;
/*     */ import org.eclipse.swt.graphics.RGB;
/*     */ import org.eclipse.swt.layout.FillLayout;
/*     */ import org.eclipse.swt.layout.GridData;
/*     */ import org.eclipse.swt.layout.GridLayout;
/*     */ import org.eclipse.swt.widgets.Button;
/*     */ import org.eclipse.swt.widgets.ColorDialog;
/*     */ import org.eclipse.swt.widgets.Composite;
/*     */ import org.eclipse.swt.widgets.FontDialog;
/*     */ import org.eclipse.swt.widgets.Group;
/*     */ import org.eclipse.swt.widgets.Label;
/*     */ import org.eclipse.swt.widgets.TabFolder;
/*     */ import org.eclipse.swt.widgets.TabItem;
/*     */ import org.eclipse.swt.widgets.Text;
/*     */ import org.jfree.chart.axis.Axis;
/*     */ import org.jfree.chart.axis.NumberAxis;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class SWTAxisEditor
/*     */   extends Composite
/*     */ {
/*     */   private Text label;
/*     */   private FontData labelFont;
/*     */   private Color labelPaintColor;
/*     */   private FontData tickLabelFont;
/*     */   private Color tickLabelPaintColor;
/*     */   private Text labelFontField;
/*     */   private Text tickLabelFontField;
/* 105 */   protected static ResourceBundle localizationResources = ResourceBundleWrapper.getBundle("org.jfree.chart.editor.LocalizationBundle");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Font font;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Button showTickLabelsCheckBox;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Button showTickMarksCheckBox;
/*     */ 
/*     */ 
/*     */   
/*     */   private TabFolder otherTabs;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SWTAxisEditor(Composite parent, int style, Axis axis) {
/* 130 */     super(parent, style);
/* 131 */     this.labelFont = SWTUtils.toSwtFontData(getDisplay(), axis
/* 132 */         .getLabelFont(), true);
/* 133 */     this.labelPaintColor = SWTUtils.toSwtColor(getDisplay(), axis
/* 134 */         .getLabelPaint());
/* 135 */     this.tickLabelFont = SWTUtils.toSwtFontData(getDisplay(), axis
/* 136 */         .getTickLabelFont(), true);
/* 137 */     this.tickLabelPaintColor = SWTUtils.toSwtColor(getDisplay(), axis
/* 138 */         .getTickLabelPaint());
/*     */     
/* 140 */     FillLayout layout = new FillLayout('Ȁ');
/* 141 */     layout.marginHeight = layout.marginWidth = 4;
/* 142 */     setLayout(layout);
/* 143 */     Group general = new Group(this, false);
/* 144 */     general.setLayout(new GridLayout(3, false));
/* 145 */     general.setText(localizationResources.getString("General"));
/*     */     
/* 147 */     (new Label(general, false)).setText(localizationResources.getString("Label"));
/*     */     
/* 149 */     this.label = new Text(general, 'ࠀ');
/* 150 */     if (axis.getLabel() != null) {
/* 151 */       this.label.setText(axis.getLabel());
/*     */     }
/* 153 */     this.label.setLayoutData(new GridData(4, 16777216, true, false));
/*     */     
/* 155 */     (new Label(general, false)).setText("");
/*     */     
/* 157 */     (new Label(general, false)).setText(localizationResources.getString("Font"));
/*     */     
/* 159 */     this.labelFontField = new Text(general, 'ࠀ');
/* 160 */     this.labelFontField.setText(this.labelFont.toString());
/* 161 */     this.labelFontField.setLayoutData(new GridData(4, 16777216, true, false));
/*     */     
/* 163 */     Button selectFontButton = new Button(general, 8);
/* 164 */     selectFontButton.setText(localizationResources.getString("Select..."));
/* 165 */     selectFontButton.addSelectionListener(new SelectionAdapter()
/*     */         {
/*     */           public void widgetSelected(SelectionEvent event)
/*     */           {
/* 169 */             FontDialog dlg = new FontDialog(SWTAxisEditor.this.getShell());
/* 170 */             dlg.setText(SWTAxisEditor.localizationResources.getString("Font_Selection"));
/*     */             
/* 172 */             dlg.setFontList(new FontData[] {
/* 173 */                   SWTAxisEditor.access$000(SWTAxisEditor.this) });
/* 174 */             if (dlg.open() != null) {
/*     */               
/* 176 */               if (SWTAxisEditor.this.font != null) {
/* 177 */                 SWTAxisEditor.this.font.dispose();
/*     */               }
/*     */ 
/*     */               
/* 181 */               SWTAxisEditor.this.font = new Font(SWTAxisEditor.this
/* 182 */                   .getShell().getDisplay(), dlg.getFontList());
/*     */               
/* 184 */               SWTAxisEditor.this.labelFontField.setText(SWTAxisEditor.this
/* 185 */                   .font.getFontData()[0]
/* 186 */                   .toString());
/* 187 */               SWTAxisEditor.this.labelFont = SWTAxisEditor.this
/* 188 */                 .font.getFontData()[0];
/*     */             } 
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 194 */     (new Label(general, false)).setText(localizationResources.getString("Paint"));
/*     */ 
/*     */     
/* 197 */     final SWTPaintCanvas colorCanvas = new SWTPaintCanvas(general, false, this.labelPaintColor);
/*     */     
/* 199 */     GridData canvasGridData = new GridData(4, 16777216, true, false);
/*     */     
/* 201 */     canvasGridData.heightHint = 20;
/* 202 */     colorCanvas.setLayoutData(canvasGridData);
/* 203 */     Button selectColorButton = new Button(general, 8);
/* 204 */     selectColorButton.setText(localizationResources.getString("Select..."));
/* 205 */     selectColorButton.addSelectionListener(new SelectionAdapter()
/*     */         {
/*     */           public void widgetSelected(SelectionEvent event)
/*     */           {
/* 209 */             ColorDialog dlg = new ColorDialog(SWTAxisEditor.this.getShell());
/* 210 */             dlg.setText(SWTAxisEditor.localizationResources.getString("Title_Color"));
/*     */             
/* 212 */             dlg.setRGB(SWTAxisEditor.this.labelPaintColor.getRGB());
/* 213 */             RGB rgb = dlg.open();
/* 214 */             if (rgb != null) {
/*     */ 
/*     */               
/* 217 */               SWTAxisEditor.this.labelPaintColor = new Color(SWTAxisEditor.this
/* 218 */                   .getDisplay(), rgb);
/* 219 */               colorCanvas.setColor(SWTAxisEditor.this
/* 220 */                   .labelPaintColor);
/*     */             } 
/*     */           }
/*     */         });
/*     */     
/* 225 */     Group other = new Group(this, false);
/* 226 */     FillLayout tabLayout = new FillLayout();
/* 227 */     tabLayout.marginHeight = tabLayout.marginWidth = 4;
/* 228 */     other.setLayout(tabLayout);
/* 229 */     other.setText(localizationResources.getString("Other"));
/*     */     
/* 231 */     this.otherTabs = new TabFolder(other, false);
/* 232 */     TabItem item1 = new TabItem(this.otherTabs, false);
/* 233 */     item1.setText(" " + localizationResources.getString("Ticks") + " ");
/* 234 */     Composite ticks = new Composite(this.otherTabs, false);
/* 235 */     ticks.setLayout(new GridLayout(3, false));
/* 236 */     this.showTickLabelsCheckBox = new Button(ticks, 32);
/* 237 */     this.showTickLabelsCheckBox.setText(localizationResources.getString("Show_tick_labels"));
/*     */     
/* 239 */     this.showTickLabelsCheckBox.setSelection(axis.isTickLabelsVisible());
/* 240 */     this.showTickLabelsCheckBox.setLayoutData(new GridData(4, 16777216, true, false, 3, true));
/*     */     
/* 242 */     (new Label(ticks, false)).setText(localizationResources.getString("Tick_label_font"));
/*     */     
/* 244 */     this.tickLabelFontField = new Text(ticks, 'ࠀ');
/* 245 */     this.tickLabelFontField.setText(this.tickLabelFont.toString());
/*     */ 
/*     */     
/* 248 */     this.tickLabelFontField.setLayoutData(new GridData(4, 16777216, true, false));
/*     */     
/* 250 */     Button selectTickLabelFontButton = new Button(ticks, 8);
/* 251 */     selectTickLabelFontButton.setText(localizationResources.getString("Select..."));
/*     */     
/* 253 */     selectTickLabelFontButton.addSelectionListener(new SelectionAdapter()
/*     */         {
/*     */           public void widgetSelected(SelectionEvent event)
/*     */           {
/* 257 */             FontDialog dlg = new FontDialog(SWTAxisEditor.this.getShell());
/* 258 */             dlg.setText(SWTAxisEditor.localizationResources.getString("Font_Selection"));
/*     */             
/* 260 */             dlg.setFontList(new FontData[] {
/* 261 */                   SWTAxisEditor.access$400(SWTAxisEditor.this) });
/* 262 */             if (dlg.open() != null) {
/*     */               
/* 264 */               if (SWTAxisEditor.this.font != null) {
/* 265 */                 SWTAxisEditor.this.font.dispose();
/*     */               }
/*     */ 
/*     */               
/* 269 */               SWTAxisEditor.this.font = new Font(SWTAxisEditor.this
/* 270 */                   .getShell().getDisplay(), dlg.getFontList());
/*     */               
/* 272 */               SWTAxisEditor.this.tickLabelFontField.setText(SWTAxisEditor.this
/* 273 */                   .font.getFontData()[0]
/* 274 */                   .toString());
/* 275 */               SWTAxisEditor.this.tickLabelFont = SWTAxisEditor.this
/* 276 */                 .font.getFontData()[0];
/*     */             } 
/*     */           }
/*     */         });
/*     */     
/* 281 */     this.showTickMarksCheckBox = new Button(ticks, 32);
/* 282 */     this.showTickMarksCheckBox.setText(localizationResources.getString("Show_tick_marks"));
/*     */     
/* 284 */     this.showTickMarksCheckBox.setSelection(axis.isTickMarksVisible());
/* 285 */     this.showTickMarksCheckBox.setLayoutData(new GridData(4, 16777216, true, false, 3, true));
/*     */     
/* 287 */     item1.setControl(ticks);
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
/*     */ 
/*     */   
/*     */   public static SWTAxisEditor getInstance(Composite parent, int style, Axis axis) {
/* 303 */     if (axis != null) {
/*     */       
/* 305 */       if (axis instanceof NumberAxis) {
/* 306 */         return new SWTNumberAxisEditor(parent, style, (NumberAxis)axis);
/*     */       }
/* 308 */       return new SWTAxisEditor(parent, style, axis);
/*     */     } 
/* 310 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 319 */   public TabFolder getOtherTabs() { return this.otherTabs; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 328 */   public String getLabel() { return this.label.getText(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 337 */   public Font getLabelFont() { return SWTUtils.toAwtFont(getDisplay(), this.labelFont, true); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 346 */   public Paint getTickLabelPaint() { return SWTUtils.toAwtColor(this.tickLabelPaintColor); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 355 */   public Font getTickLabelFont() { return SWTUtils.toAwtFont(getDisplay(), this.tickLabelFont, true); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 364 */   public Paint getLabelPaint() { return SWTUtils.toAwtColor(this.labelPaintColor); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAxisProperties(Axis axis) {
/* 374 */     axis.setLabel(getLabel());
/* 375 */     axis.setLabelFont(getLabelFont());
/* 376 */     axis.setLabelPaint(getLabelPaint());
/* 377 */     axis.setTickMarksVisible(this.showTickMarksCheckBox.getSelection());
/* 378 */     axis.setTickLabelsVisible(this.showTickLabelsCheckBox.getSelection());
/* 379 */     axis.setTickLabelFont(getTickLabelFont());
/* 380 */     axis.setTickLabelPaint(getTickLabelPaint());
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/experimental/chart/swt/editor/SWTAxisEditor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */