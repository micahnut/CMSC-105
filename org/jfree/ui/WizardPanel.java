/*    */ package org.jfree.ui;
/*    */ 
/*    */ import java.awt.LayoutManager;
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
/*    */ public abstract class WizardPanel
/*    */   extends JPanel
/*    */ {
/*    */   private WizardDialog owner;
/*    */   
/* 65 */   protected WizardPanel(LayoutManager layout) { super(layout); }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 74 */   public WizardDialog getOwner() { return this.owner; }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 84 */   public void setOwner(WizardDialog owner) { this.owner = owner; }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 93 */   public Object getResult() { return null; }
/*    */   
/*    */   public abstract void returnFromLaterStep();
/*    */   
/*    */   public abstract boolean canRedisplayNextPanel();
/*    */   
/*    */   public abstract boolean hasNextPanel();
/*    */   
/*    */   public abstract boolean canFinish();
/*    */   
/*    */   public abstract WizardPanel getNextPanel();
/*    */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/ui/WizardPanel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */