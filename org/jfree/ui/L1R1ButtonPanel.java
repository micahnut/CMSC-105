/*    */ package org.jfree.ui;
/*    */ 
/*    */ import java.awt.BorderLayout;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JPanel;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class L1R1ButtonPanel
/*    */   extends JPanel
/*    */ {
/*    */   private JButton left;
/*    */   private JButton right;
/*    */   
/*    */   public L1R1ButtonPanel(String leftLabel, String rightLabel) {
/* 73 */     setLayout(new BorderLayout());
/* 74 */     this.left = new JButton(leftLabel);
/* 75 */     this.right = new JButton(rightLabel);
/* 76 */     add(this.left, "West");
/* 77 */     add(this.right, "East");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 87 */   public JButton getLeftButton() { return this.left; }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 96 */   public JButton getRightButton() { return this.right; }
/*    */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/ui/L1R1ButtonPanel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */