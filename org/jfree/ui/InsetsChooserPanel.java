/*     */ package org.jfree.ui;
/*     */ 
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.GridBagConstraints;
/*     */ import java.awt.GridBagLayout;
/*     */ import java.awt.Insets;
/*     */ import java.util.ResourceBundle;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.border.TitledBorder;
/*     */ import org.jfree.util.ResourceBundleWrapper;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class InsetsChooserPanel
/*     */   extends JPanel
/*     */ {
/*     */   private JTextField topValueEditor;
/*     */   private JTextField leftValueEditor;
/*     */   private JTextField bottomValueEditor;
/*     */   private JTextField rightValueEditor;
/*  88 */   protected static ResourceBundle localizationResources = ResourceBundleWrapper.getBundle("org.jfree.ui.LocalizationBundle");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  96 */   public InsetsChooserPanel() { this(new Insets(false, false, false, false)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InsetsChooserPanel(Insets current) {
/* 106 */     current = (current == null) ? new Insets(false, false, false, false) : current;
/*     */     
/* 108 */     this.topValueEditor = new JTextField(new IntegerDocument(), "" + current.top, false);
/*     */     
/* 110 */     this.leftValueEditor = new JTextField(new IntegerDocument(), "" + current.left, false);
/*     */     
/* 112 */     this.bottomValueEditor = new JTextField(new IntegerDocument(), "" + current.bottom, false);
/*     */     
/* 114 */     this.rightValueEditor = new JTextField(new IntegerDocument(), "" + current.right, false);
/*     */ 
/*     */     
/* 117 */     JPanel panel = new JPanel(new GridBagLayout());
/* 118 */     panel.setBorder(new TitledBorder(localizationResources
/* 119 */           .getString("Insets")));
/*     */ 
/*     */     
/* 122 */     panel.add(new JLabel(localizationResources.getString("Top")), new GridBagConstraints(true, false, 3, true, 0.0D, 0.0D, 10, false, new Insets(false, false, false, false), false, false));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 128 */     panel.add(new JLabel(" "), new GridBagConstraints(true, true, true, true, 0.0D, 0.0D, 10, true, new Insets(false, 12, false, 12), 8, false));
/*     */ 
/*     */     
/* 131 */     panel.add(this.topValueEditor, new GridBagConstraints(2, true, true, true, 0.0D, 0.0D, 10, 2, new Insets(false, false, false, false), false, false));
/*     */ 
/*     */     
/* 134 */     panel.add(new JLabel(" "), new GridBagConstraints(3, true, true, true, 0.0D, 0.0D, 10, true, new Insets(false, 12, false, 11), 8, false));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 139 */     panel.add(new JLabel(localizationResources.getString("Left")), new GridBagConstraints(false, 2, true, true, 0.0D, 0.0D, 10, true, new Insets(false, 4, false, 4), false, false));
/*     */ 
/*     */ 
/*     */     
/* 143 */     panel.add(this.leftValueEditor, new GridBagConstraints(true, 2, true, true, 0.0D, 0.0D, 10, true, new Insets(false, false, false, false), false, false));
/*     */ 
/*     */     
/* 146 */     panel.add(new JLabel(" "), new GridBagConstraints(2, 2, true, true, 0.0D, 0.0D, 10, false, new Insets(false, 12, false, 12), 8, false));
/*     */ 
/*     */     
/* 149 */     panel.add(this.rightValueEditor, new GridBagConstraints(3, 2, true, true, 0.0D, 0.0D, 10, 2, new Insets(false, false, false, false), false, false));
/*     */ 
/*     */     
/* 152 */     panel.add(new JLabel(localizationResources.getString("Right")), new GridBagConstraints(4, 2, true, true, 0.0D, 0.0D, 10, false, new Insets(false, 4, false, 4), false, false));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 158 */     panel.add(this.bottomValueEditor, new GridBagConstraints(2, 3, true, true, 0.0D, 0.0D, 10, 2, new Insets(false, false, false, false), false, false));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 163 */     panel.add(new JLabel(localizationResources.getString("Bottom")), new GridBagConstraints(true, 4, 3, true, 0.0D, 0.0D, 10, false, new Insets(false, false, false, false), false, false));
/*     */ 
/*     */ 
/*     */     
/* 167 */     setLayout(new BorderLayout());
/* 168 */     add(panel, "Center");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Insets getInsetsValue() {
/* 179 */     return new Insets(
/* 180 */         Math.abs(stringToInt(this.topValueEditor.getText())), 
/* 181 */         Math.abs(stringToInt(this.leftValueEditor.getText())), 
/* 182 */         Math.abs(stringToInt(this.bottomValueEditor.getText())), 
/* 183 */         Math.abs(stringToInt(this.rightValueEditor.getText())));
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
/*     */   protected int stringToInt(String value) {
/* 196 */     value = value.trim();
/* 197 */     if (value.length() == 0) {
/* 198 */       return 0;
/*     */     }
/*     */     
/*     */     try {
/* 202 */       return Integer.parseInt(value);
/*     */     }
/* 204 */     catch (NumberFormatException e) {
/* 205 */       return 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeNotify() {
/* 214 */     super.removeNotify();
/* 215 */     removeAll();
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/ui/InsetsChooserPanel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */