/*     */ package org.jfree.experimental.chart.swt.editor;
/*     */ 
/*     */ import org.eclipse.swt.events.FocusEvent;
/*     */ import org.eclipse.swt.events.FocusListener;
/*     */ import org.eclipse.swt.events.SelectionAdapter;
/*     */ import org.eclipse.swt.events.SelectionEvent;
/*     */ import org.eclipse.swt.layout.GridData;
/*     */ import org.eclipse.swt.layout.GridLayout;
/*     */ import org.eclipse.swt.widgets.Button;
/*     */ import org.eclipse.swt.widgets.Composite;
/*     */ import org.eclipse.swt.widgets.Label;
/*     */ import org.eclipse.swt.widgets.TabItem;
/*     */ import org.eclipse.swt.widgets.Text;
/*     */ import org.jfree.chart.axis.Axis;
/*     */ import org.jfree.chart.axis.NumberAxis;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class SWTNumberAxisEditor
/*     */   extends SWTAxisEditor
/*     */   implements FocusListener
/*     */ {
/*     */   private boolean autoRange;
/*     */   private double minimumValue;
/*     */   private double maximumValue;
/*     */   private Button autoRangeCheckBox;
/*     */   private Text minimumRangeValue;
/*     */   private Text maximumRangeValue;
/*     */   
/*     */   public SWTNumberAxisEditor(Composite parent, int style, NumberAxis axis) {
/*  93 */     super(parent, style, axis);
/*  94 */     this.autoRange = axis.isAutoRange();
/*  95 */     this.minimumValue = axis.getLowerBound();
/*  96 */     this.maximumValue = axis.getUpperBound();
/*     */     
/*  98 */     TabItem item2 = new TabItem(getOtherTabs(), false);
/*  99 */     item2.setText(" " + localizationResources.getString("Range") + " ");
/* 100 */     Composite range = new Composite(getOtherTabs(), false);
/* 101 */     range.setLayout(new GridLayout(2, true));
/* 102 */     item2.setControl(range);
/*     */     
/* 104 */     this.autoRangeCheckBox = new Button(range, 32);
/* 105 */     this.autoRangeCheckBox.setText(localizationResources.getString("Auto-adjust_range"));
/*     */     
/* 107 */     this.autoRangeCheckBox.setLayoutData(new GridData(4, 16777216, true, false, 2, true));
/*     */     
/* 109 */     this.autoRangeCheckBox.setSelection(this.autoRange);
/* 110 */     this.autoRangeCheckBox.addSelectionListener(new SelectionAdapter() {
/*     */           public void widgetSelected(SelectionEvent e) {
/* 112 */             SWTNumberAxisEditor.this.toggleAutoRange();
/*     */           }
/*     */         });
/* 115 */     (new Label(range, false)).setText(localizationResources.getString("Minimum_range_value"));
/*     */     
/* 117 */     this.minimumRangeValue = new Text(range, 'ࠀ');
/* 118 */     this.minimumRangeValue.setText(String.valueOf(this.minimumValue));
/* 119 */     this.minimumRangeValue.setLayoutData(new GridData(4, 16777216, true, false));
/*     */     
/* 121 */     this.minimumRangeValue.setEnabled(!this.autoRange);
/*     */ 
/*     */     
/* 124 */     this.minimumRangeValue.addFocusListener(this);
/* 125 */     (new Label(range, false)).setText(localizationResources.getString("Maximum_range_value"));
/*     */     
/* 127 */     this.maximumRangeValue = new Text(range, 'ࠀ');
/* 128 */     this.maximumRangeValue.setText(String.valueOf(this.maximumValue));
/* 129 */     this.maximumRangeValue.setLayoutData(new GridData(4, 16777216, true, false));
/*     */     
/* 131 */     this.maximumRangeValue.setEnabled(!this.autoRange);
/*     */ 
/*     */     
/* 134 */     this.maximumRangeValue.addFocusListener(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void toggleAutoRange() {
/* 141 */     this.autoRange = this.autoRangeCheckBox.getSelection();
/* 142 */     if (this.autoRange) {
/* 143 */       this.minimumRangeValue.setText(Double.toString(this.minimumValue));
/* 144 */       this.minimumRangeValue.setEnabled(false);
/* 145 */       this.maximumRangeValue.setText(Double.toString(this.maximumValue));
/* 146 */       this.maximumRangeValue.setEnabled(false);
/*     */     } else {
/*     */       
/* 149 */       this.minimumRangeValue.setEnabled(true);
/* 150 */       this.maximumRangeValue.setEnabled(true);
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
/*     */   public boolean validateMinimum(String candidate) {
/* 164 */     boolean valid = true;
/*     */     try {
/* 166 */       if (Double.parseDouble(candidate) >= this.maximumValue) {
/* 167 */         valid = false;
/*     */       }
/*     */     }
/* 170 */     catch (NumberFormatException e) {
/* 171 */       valid = false;
/*     */     } 
/* 173 */     return valid;
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
/*     */   public boolean validateMaximum(String candidate) {
/* 186 */     boolean valid = true;
/*     */     try {
/* 188 */       if (Double.parseDouble(candidate) <= this.minimumValue) {
/* 189 */         valid = false;
/*     */       }
/*     */     }
/* 192 */     catch (NumberFormatException e) {
/* 193 */       valid = false;
/*     */     } 
/* 195 */     return valid;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void focusGained(FocusEvent e) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void focusLost(FocusEvent e) {
/* 211 */     if (e.getSource() == this.minimumRangeValue) {
/*     */       
/* 213 */       if (!validateMinimum(this.minimumRangeValue.getText())) {
/* 214 */         this.minimumRangeValue.setText(String.valueOf(this.minimumValue));
/*     */       } else {
/*     */         
/* 217 */         this.minimumValue = Double.parseDouble(this.minimumRangeValue
/* 218 */             .getText());
/*     */       } 
/* 220 */     } else if (e.getSource() == this.maximumRangeValue) {
/*     */       
/* 222 */       if (!validateMaximum(this.maximumRangeValue.getText())) {
/* 223 */         this.maximumRangeValue.setText(String.valueOf(this.maximumValue));
/*     */       } else {
/*     */         
/* 226 */         this.maximumValue = Double.parseDouble(this.maximumRangeValue
/* 227 */             .getText());
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAxisProperties(Axis axis) {
/* 238 */     super.setAxisProperties(axis);
/* 239 */     NumberAxis numberAxis = (NumberAxis)axis;
/* 240 */     numberAxis.setAutoRange(this.autoRange);
/* 241 */     if (!this.autoRange)
/* 242 */       numberAxis.setRange(this.minimumValue, this.maximumValue); 
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/experimental/chart/swt/editor/SWTNumberAxisEditor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */