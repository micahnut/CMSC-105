/*    */ package state;
/*    */ 
/*    */ import gfx.Assets;
/*    */ import java.awt.Graphics;
/*    */ import lab2.DataPresentor;
/*    */ import lab2.Numerical;
/*    */ import main.Handler;
/*    */ import ui.ClickListener;
/*    */ import ui.UIImageButton;
/*    */ import ui.UIManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Summarizing
/*    */   extends State
/*    */ {
/*    */   private UIManager uiManager;
/*    */   
/*    */   public Summarizing(Handler handler, StateManager sm) {
/* 24 */     super(handler, sm);
/*    */     
/* 26 */     this.uiManager = new UIManager(handler);
/* 27 */     handler.getMouseManager().setUiManager(this.uiManager);
/*    */     
/* 29 */     this.uiManager.addObject(new UIImageButton(115.0F, 125.0F, 48, 48, Assets.piechart, new ClickListener(this)
/*    */           {
/*    */             
/*    */             public void onClick()
/*    */             {
/* 34 */               DataPresentor cate = new DataPresentor();
/*    */             }
/*    */           }));
/*    */ 
/*    */     
/* 39 */     this.uiManager.addObject(new UIImageButton(115.0F, 220.0F, 48, 48, Assets.chart, new ClickListener(this)
/*    */           {
/*    */             
/*    */             public void onClick()
/*    */             {
/* 44 */               Numerical nume = new Numerical();
/*    */             }
/*    */           }));
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 51 */     this.uiManager.addObject(new UIImageButton(120.0F, 305.0F, 48, 48, Assets.back, new ClickListener(this, handler)
/*    */           {
/*    */             public void onClick()
/*    */             {
/* 55 */               handler.getMain().getStateManager().setState(2);
/*    */             }
/*    */           }));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/* 62 */   public void update() { this.uiManager.update(); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(Graphics g) {
/* 68 */     g.drawImage(Assets.SP, 0, 0, null);
/*    */     
/* 70 */     this.uiManager.render(g);
/*    */   }
/*    */   
/*    */   public void init() {}
/*    */   
/*    */   public void handleInput() {}
/*    */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/state/Summarizing.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.3
 */