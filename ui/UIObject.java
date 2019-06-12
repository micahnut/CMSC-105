/*    */ package ui;
/*    */ 
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Rectangle;
/*    */ import java.awt.event.MouseEvent;
/*    */ 
/*    */ 
/*    */ public abstract class UIObject
/*    */ {
/*    */   protected float x;
/*    */   protected float y;
/*    */   protected int width;
/*    */   
/*    */   public UIObject(float x, float y, int width, int height) {
/* 15 */     this.x = x;
/* 16 */     this.y = y;
/* 17 */     this.width = width;
/* 18 */     this.height = height;
/* 19 */     this.bounds = new Rectangle((int)x, (int)y, width, height);
/*    */   }
/*    */   protected int height; protected boolean hovering = false; protected Rectangle bounds;
/*    */   public abstract void update();
/*    */   
/*    */   public abstract void render(Graphics paramGraphics);
/*    */   
/*    */   public abstract void onClick();
/*    */   
/*    */   public void onMouseMove(MouseEvent e) {
/* 29 */     if (this.bounds.contains(e.getX(), e.getY())) {
/* 30 */       this.hovering = true;
/*    */     } else {
/* 32 */       this.hovering = false;
/*    */     } 
/*    */   }
/*    */   
/*    */   public void onMouseRelease(MouseEvent e) {
/* 37 */     if (this.hovering) {
/* 38 */       onClick();
/*    */     }
/*    */   }
/*    */ 
/*    */   
/* 43 */   public float getX() { return this.x; }
/*    */ 
/*    */ 
/*    */   
/* 47 */   public void setX(float x) { this.x = x; }
/*    */ 
/*    */ 
/*    */   
/* 51 */   public float getY() { return this.y; }
/*    */ 
/*    */ 
/*    */   
/* 55 */   public void setY(float y) { this.y = y; }
/*    */ 
/*    */ 
/*    */   
/* 59 */   public int getWidth() { return this.width; }
/*    */ 
/*    */ 
/*    */   
/* 63 */   public void setWidth(int width) { this.width = width; }
/*    */ 
/*    */ 
/*    */   
/* 67 */   public int getHeight() { return this.height; }
/*    */ 
/*    */ 
/*    */   
/* 71 */   public void setHeight(int height) { this.height = height; }
/*    */ 
/*    */ 
/*    */   
/* 75 */   public boolean isHovering() { return this.hovering; }
/*    */ 
/*    */ 
/*    */   
/* 79 */   public void setHovering(boolean hovering) { this.hovering = hovering; }
/*    */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/ui/UIObject.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.3
 */