/*     */ package org.jfree.ui;
/*     */ 
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Stroke;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import javax.swing.DefaultComboBoxModel;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class StrokeChooserPanel
/*     */   extends JPanel
/*     */ {
/*     */   private JComboBox selector;
/*     */   
/*     */   public StrokeChooserPanel(StrokeSample current, StrokeSample[] available) {
/*  76 */     setLayout(new BorderLayout());
/*     */ 
/*     */ 
/*     */     
/*  80 */     DefaultComboBoxModel model = new DefaultComboBoxModel();
/*  81 */     for (int i = 0; i < available.length; i++) {
/*  82 */       model.addElement(available[i].getStroke());
/*     */     }
/*  84 */     this.selector = new JComboBox(model);
/*  85 */     this.selector.setSelectedItem(current.getStroke());
/*  86 */     this.selector.setRenderer(new StrokeSample(null));
/*  87 */     add(this.selector);
/*     */     
/*  89 */     this.selector.addActionListener(new ActionListener()
/*     */         {
/*  91 */           public void actionPerformed(ActionEvent evt) { StrokeChooserPanel.this.getSelector().transferFocus(); }
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
/*     */   
/* 103 */   protected final JComboBox getSelector() { return this.selector; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 112 */   public Stroke getSelectedStroke() { return (Stroke)this.selector.getSelectedItem(); }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/ui/StrokeChooserPanel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */