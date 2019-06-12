/*    */ package gfx;
/*    */ 
/*    */ import java.awt.image.BufferedImage;
/*    */ 
/*    */ 
/*    */ public class Animation
/*    */ {
/*    */   private int speed;
/*    */   private int index;
/*    */   
/*    */   public Animation(int speed, BufferedImage[] frames) {
/* 12 */     this.speed = speed;
/* 13 */     this.frames = frames;
/* 14 */     this.index = 0;
/* 15 */     this.timer = 0L;
/* 16 */     this.lastTime = System.currentTimeMillis();
/*    */   }
/*    */   private long lastTime; private long timer; private BufferedImage[] frames;
/*    */   public void update() {
/* 20 */     this.timer += System.currentTimeMillis() - this.lastTime;
/* 21 */     this.lastTime = System.currentTimeMillis();
/*    */     
/* 23 */     if (this.timer > this.speed) {
/* 24 */       this.index++;
/* 25 */       this.timer = 0L;
/* 26 */       if (this.index >= this.frames.length) {
/* 27 */         this.index = 0;
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/* 33 */   public BufferedImage getCurrentFrame() { return this.frames[this.index]; }
/*    */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/gfx/Animation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.3
 */