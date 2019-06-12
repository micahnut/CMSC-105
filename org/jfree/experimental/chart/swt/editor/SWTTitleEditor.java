/*     */ package org.jfree.experimental.chart.swt.editor;
/*     */ 
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
/*     */ import org.eclipse.swt.widgets.Text;
/*     */ import org.jfree.chart.JFreeChart;
/*     */ import org.jfree.chart.title.TextTitle;
/*     */ import org.jfree.chart.title.Title;
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
/*     */ class SWTTitleEditor
/*     */   extends Composite
/*     */ {
/*     */   private boolean showTitle;
/*     */   private Button showTitleCheckBox;
/*     */   private Text titleField;
/*     */   private FontData titleFont;
/*     */   private Text fontField;
/*     */   private Button selectFontButton;
/*     */   private Color titleColor;
/*     */   private Button selectColorButton;
/* 102 */   protected static ResourceBundle localizationResources = ResourceBundleWrapper.getBundle("org.jfree.chart.editor.LocalizationBundle");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Font font;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   SWTTitleEditor(Composite parent, int style, Title title) {
/* 118 */     super(parent, style);
/* 119 */     FillLayout layout = new FillLayout();
/* 120 */     layout.marginHeight = layout.marginWidth = 4;
/* 121 */     setLayout(layout);
/*     */ 
/*     */     
/* 124 */     TextTitle t = (title != null) ? (TextTitle)title : new TextTitle(localizationResources.getString("Title"));
/* 125 */     this.showTitle = (title != null);
/* 126 */     this.titleFont = SWTUtils.toSwtFontData(getDisplay(), t.getFont(), true);
/*     */     
/* 128 */     this.titleColor = SWTUtils.toSwtColor(getDisplay(), t.getPaint());
/*     */     
/* 130 */     Group general = new Group(this, false);
/* 131 */     general.setLayout(new GridLayout(3, false));
/* 132 */     general.setText(localizationResources.getString("General"));
/*     */     
/* 134 */     Label label = new Label(general, false);
/* 135 */     label.setText(localizationResources.getString("Show_Title"));
/* 136 */     GridData gridData = new GridData();
/* 137 */     gridData.horizontalSpan = 2;
/* 138 */     label.setLayoutData(gridData);
/* 139 */     this.showTitleCheckBox = new Button(general, 32);
/* 140 */     this.showTitleCheckBox.setSelection(this.showTitle);
/* 141 */     this.showTitleCheckBox.setLayoutData(new GridData(16777216, 16777216, false, false));
/*     */     
/* 143 */     this.showTitleCheckBox.addSelectionListener(new SelectionAdapter()
/*     */         {
/*     */           public void widgetSelected(SelectionEvent event) {
/* 146 */             SWTTitleEditor.this.showTitle = SWTTitleEditor.this
/* 147 */               .showTitleCheckBox.getSelection();
/*     */           }
/*     */         });
/*     */     
/* 151 */     (new Label(general, false)).setText(localizationResources.getString("Text"));
/*     */     
/* 153 */     this.titleField = new Text(general, 'ࠀ');
/* 154 */     this.titleField.setText(t.getText());
/* 155 */     this.titleField.setLayoutData(new GridData(4, 16777216, true, false));
/*     */     
/* 157 */     (new Label(general, false)).setText("");
/*     */     
/* 159 */     (new Label(general, false)).setText(localizationResources.getString("Font"));
/*     */     
/* 161 */     this.fontField = new Text(general, 'ࠀ');
/* 162 */     this.fontField.setText(this.titleFont.toString());
/* 163 */     this.fontField.setLayoutData(new GridData(4, 16777216, true, false));
/*     */     
/* 165 */     this.selectFontButton = new Button(general, 8);
/* 166 */     this.selectFontButton.setText(localizationResources.getString("Select..."));
/*     */     
/* 168 */     this.selectFontButton.addSelectionListener(new SelectionAdapter()
/*     */         {
/*     */           public void widgetSelected(SelectionEvent event)
/*     */           {
/* 172 */             FontDialog dlg = new FontDialog(SWTTitleEditor.this.getShell());
/* 173 */             dlg.setText(SWTTitleEditor.localizationResources.getString("Font_Selection"));
/*     */             
/* 175 */             dlg.setFontList(new FontData[] {
/* 176 */                   SWTTitleEditor.access$200(SWTTitleEditor.this) });
/* 177 */             if (dlg.open() != null) {
/*     */               
/* 179 */               if (SWTTitleEditor.this.font != null) {
/* 180 */                 SWTTitleEditor.this.font.dispose();
/*     */               }
/*     */ 
/*     */               
/* 184 */               SWTTitleEditor.this.font = new Font(SWTTitleEditor.this
/* 185 */                   .getShell().getDisplay(), dlg.getFontList());
/*     */               
/* 187 */               SWTTitleEditor.this.fontField.setText(SWTTitleEditor.this
/* 188 */                   .font.getFontData()[0]
/* 189 */                   .toString());
/* 190 */               SWTTitleEditor.this.titleFont = SWTTitleEditor.this
/* 191 */                 .font.getFontData()[0];
/*     */             } 
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 197 */     (new Label(general, false)).setText(localizationResources.getString("Color"));
/*     */ 
/*     */ 
/*     */     
/* 201 */     final SWTPaintCanvas colorCanvas = new SWTPaintCanvas(general, false, this.titleColor);
/*     */     
/* 203 */     GridData canvasGridData = new GridData(4, 16777216, true, false);
/*     */     
/* 205 */     canvasGridData.heightHint = 20;
/* 206 */     colorCanvas.setLayoutData(canvasGridData);
/* 207 */     this.selectColorButton = new Button(general, 8);
/* 208 */     this.selectColorButton.setText(localizationResources.getString("Select..."));
/*     */     
/* 210 */     this.selectColorButton.addSelectionListener(new SelectionAdapter()
/*     */         {
/*     */           public void widgetSelected(SelectionEvent event)
/*     */           {
/* 214 */             ColorDialog dlg = new ColorDialog(SWTTitleEditor.this.getShell());
/* 215 */             dlg.setText(SWTTitleEditor.localizationResources.getString("Title_Color"));
/*     */             
/* 217 */             dlg.setRGB(SWTTitleEditor.this.titleColor.getRGB());
/* 218 */             RGB rgb = dlg.open();
/* 219 */             if (rgb != null) {
/*     */ 
/*     */               
/* 222 */               SWTTitleEditor.this.titleColor = new Color(SWTTitleEditor.this
/* 223 */                   .getDisplay(), rgb);
/* 224 */               colorCanvas.setColor(SWTTitleEditor.this
/* 225 */                   .titleColor);
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
/*     */   
/* 238 */   public String getTitleText() { return this.titleField.getText(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 247 */   public FontData getTitleFont() { return this.titleFont; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 256 */   public Color getTitleColor() { return this.titleColor; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTitleProperties(JFreeChart chart) {
/* 266 */     if (this.showTitle) {
/* 267 */       TextTitle title = chart.getTitle();
/* 268 */       if (title == null) {
/* 269 */         title = new TextTitle();
/* 270 */         chart.setTitle(title);
/*     */       } 
/* 272 */       title.setText(getTitleText());
/* 273 */       title.setFont(SWTUtils.toAwtFont(getDisplay(), getTitleFont(), true));
/*     */       
/* 275 */       title.setPaint(SWTUtils.toAwtColor(getTitleColor()));
/*     */     } else {
/*     */       
/* 278 */       chart.setTitle((TextTitle)null);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/experimental/chart/swt/editor/SWTTitleEditor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */