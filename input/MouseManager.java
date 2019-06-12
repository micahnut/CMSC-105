/*    */ package input;
/*    */ 
/*    */ import java.awt.event.MouseEvent;
/*    */ import java.awt.event.MouseListener;
/*    */ import java.awt.event.MouseMotionListener;
/*    */ import ui.UIManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MouseManager
/*    */   implements MouseListener, MouseMotionListener
/*    */ {
/*    */   private boolean leftPressed;
/*    */   private boolean rightPressed;
/*    */   private int mouseX;
/*    */   private int mouseY;
/*    */   private UIManager uiManager;
/*    */   
/* 21 */   public boolean isLeftPressed() { return this.leftPressed; }
/*    */ 
/*    */ 
/*    */   
/* 25 */   public boolean isRightPressed() { return this.rightPressed; }
/*    */ 
/*    */ 
/*    */   
/* 29 */   public int getMouseX() { return this.mouseX; }
/*    */ 
/*    */ 
/*    */   
/* 33 */   public int getMouseY() { return this.mouseY; }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void mouseDragged(MouseEvent e) {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void mouseMoved(MouseEvent e) {
/* 44 */     this.mouseX = e.getX();
/* 45 */     this.mouseY = e.getY();
/*    */     
/* 47 */     if (this.uiManager != null) {
/* 48 */       this.uiManager.onMouseMove(e);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void mouseClicked(MouseEvent e) {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void mouseEntered(MouseEvent e) {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void mouseExited(MouseEvent e) {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void mousePressed(MouseEvent e) {
/* 72 */     if (e.getButton() == 1) {
/* 73 */       this.leftPressed = true;
/* 74 */     } else if (e.getButton() == 3) {
/* 75 */       this.rightPressed = true;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void mouseReleased(MouseEvent e) {
/* 82 */     if (e.getButton() == 1) {
/* 83 */       this.leftPressed = false;
/* 84 */     } else if (e.getButton() == 3) {
/* 85 */       this.rightPressed = false;
/*    */     } 
/*    */     
/* 88 */     if (this.uiManager != null) {
/* 89 */       this.uiManager.onMouseRelease(e);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/* 94 */   public void setUiManager(UIManager uiManager) { this.uiManager = uiManager; }
/*    */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/input/MouseManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.3
 */