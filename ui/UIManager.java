/*    */ package ui;
/*    */ 
/*    */ import java.awt.Graphics;
/*    */ import java.awt.event.MouseEvent;
/*    */ import java.util.ArrayList;
/*    */ import main.Handler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UIManager
/*    */ {
/*    */   private Handler handler;
/*    */   private ArrayList<UIObject> objects;
/*    */   
/*    */   public UIManager(Handler handler) {
/* 17 */     this.handler = handler;
/* 18 */     this.objects = new ArrayList();
/*    */   }
/*    */   
/*    */   public void update() {
/* 22 */     for (UIObject o : this.objects) {
/* 23 */       o.update();
/*    */     }
/*    */   }
/*    */   
/*    */   public void render(Graphics g) {
/* 28 */     for (UIObject o : this.objects) {
/* 29 */       o.render(g);
/*    */     }
/*    */   }
/*    */   
/*    */   public void onMouseMove(MouseEvent e) {
/* 34 */     for (UIObject o : this.objects) {
/* 35 */       o.onMouseMove(e);
/*    */     }
/*    */   }
/*    */   
/*    */   public void onMouseRelease(MouseEvent e) {
/* 40 */     for (UIObject o : this.objects) {
/* 41 */       o.onMouseRelease(e);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/* 46 */   public void addObject(UIObject o) { this.objects.add(o); }
/*    */ 
/*    */ 
/*    */   
/* 50 */   public void removeObject(UIObject o) { this.objects.remove(o); }
/*    */ 
/*    */ 
/*    */   
/* 54 */   public Handler getHandler() { return this.handler; }
/*    */ 
/*    */ 
/*    */   
/* 58 */   public void setHandler(Handler handler) { this.handler = handler; }
/*    */ 
/*    */ 
/*    */   
/* 62 */   public ArrayList<UIObject> getObjects() { return this.objects; }
/*    */ 
/*    */ 
/*    */   
/* 66 */   public void setObjects(ArrayList<UIObject> objects) { this.objects = objects; }
/*    */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/ui/UIManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.3
 */