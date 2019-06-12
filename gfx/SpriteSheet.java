/*    */ package gfx;
/*    */ 
/*    */ import java.awt.image.BufferedImage;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SpriteSheet
/*    */ {
/*    */   private BufferedImage sheet;
/*    */   
/* 11 */   public SpriteSheet(BufferedImage sheet) { this.sheet = sheet; }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 16 */   public BufferedImage crop(int x, int y, int width, int height) { return this.sheet.getSubimage(x, y, width, height); }
/*    */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/gfx/SpriteSheet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.3
 */