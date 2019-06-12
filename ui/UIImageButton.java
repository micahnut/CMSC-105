/*    */ package ui;
/*    */ 
/*    */ import java.awt.Graphics;
/*    */ import java.awt.image.BufferedImage;
/*    */ 
/*    */ public class UIImageButton
/*    */   extends UIObject {
/*    */   private BufferedImage[] images;
/*    */   private ClickListener clicker;
/*    */   
/*    */   public UIImageButton(float x, float y, int width, int height, BufferedImage[] images, ClickListener clicker) {
/* 12 */     super(x, y, width, height);
/* 13 */     this.images = images;
/* 14 */     this.clicker = clicker;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void update() {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(Graphics g) {
/* 26 */     if (this.hovering) {
/* 27 */       g.drawImage(this.images[1], (int)this.x, (int)this.y, this.width, this.height, null);
/*    */     } else {
/* 29 */       g.drawImage(this.images[0], (int)this.x, (int)this.y, this.width, this.height, null);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 36 */   public void onClick() { this.clicker.onClick(); }
/*    */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/ui/UIImageButton.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.3
 */