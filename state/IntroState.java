/*    */ package state;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.image.BufferedImage;
/*    */ import javax.imageio.ImageIO;
/*    */ import main.Handler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IntroState
/*    */   extends State
/*    */ {
/*    */   private BufferedImage logo;
/*    */   private int alpha;
/*    */   private int ticks;
/* 19 */   private final int FADE_IN = 60;
/* 20 */   private final int LENGTH = 60;
/* 21 */   private final int FADE_OUT = 60;
/*    */ 
/*    */   
/* 24 */   public IntroState(Handler handler, StateManager sm) { super(handler, sm); }
/*    */ 
/*    */   
/*    */   public void init() {
/* 28 */     this.ticks = 0;
/*    */     try {
/* 30 */       this.logo = ImageIO.read(getClass().getResourceAsStream("/textures/logo.jpg"));
/* 31 */     } catch (Exception e) {
/* 32 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   public void update() {
/* 37 */     handleInput();
/* 38 */     this.ticks++;
/* 39 */     if (this.ticks < 60) {
/* 40 */       this.alpha = (int)(255.0D - 255.0D * 1.0D * this.ticks / 60.0D);
/* 41 */       if (this.alpha < 0)
/* 42 */         this.alpha = 0; 
/*    */     } 
/* 44 */     if (this.ticks > 120) {
/* 45 */       this.alpha = (int)(255.0D * (1.0D * this.ticks - 60.0D - 60.0D) / 60.0D);
/* 46 */       if (this.alpha > 255)
/* 47 */         this.alpha = 255; 
/*    */     } 
/* 49 */     if (this.ticks > 180) {
/* 50 */       this.sm.setState(1);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(Graphics g) {
/* 58 */     g.setColor(Color.white);
/* 59 */     g.fillRect(0, 0, 450, 450);
/* 60 */     g.drawImage(this.logo, 0, 0, 450, 450, null);
/* 61 */     g.setColor(new Color(false, false, false, this.alpha));
/* 62 */     g.fillRect(0, 0, 450, 450);
/*    */   }
/*    */   
/*    */   public void handleInput() {}
/*    */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/state/IntroState.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.3
 */