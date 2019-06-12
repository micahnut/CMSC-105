/*     */ package org.jfree.ui;
/*     */ 
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.GridLayout;
/*     */ import javax.swing.JButton;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class L1R2ButtonPanel
/*     */   extends JPanel
/*     */ {
/*     */   private JButton left;
/*     */   private JButton right1;
/*     */   private JButton right2;
/*     */   
/*     */   public L1R2ButtonPanel(String label1, String label2, String label3) {
/*  78 */     setLayout(new BorderLayout());
/*     */ 
/*     */     
/*  81 */     this.left = new JButton(label1);
/*     */     
/*  83 */     JPanel rightButtonPanel = new JPanel(new GridLayout(true, 2));
/*  84 */     this.right1 = new JButton(label2);
/*  85 */     this.right2 = new JButton(label3);
/*  86 */     rightButtonPanel.add(this.right1);
/*  87 */     rightButtonPanel.add(this.right2);
/*     */ 
/*     */     
/*  90 */     add(this.left, "West");
/*  91 */     add(rightButtonPanel, "East");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 101 */   public JButton getLeftButton() { return this.left; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 110 */   public JButton getRightButton1() { return this.right1; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 119 */   public JButton getRightButton2() { return this.right2; }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/ui/L1R2ButtonPanel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */