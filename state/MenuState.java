/*    */ package state;
/*    */ 
/*    */ import gfx.Assets;
/*    */ import java.awt.Graphics;
/*    */ import main.Handler;
/*    */ import ui.ClickListener;
/*    */ import ui.UIImageButton;
/*    */ import ui.UIManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MenuState
/*    */   extends State
/*    */ {
/*    */   private UIManager uiManager;
/*    */   
/*    */   public MenuState(Handler handler, StateManager sm) {
/* 18 */     super(handler, sm);
/*    */     
/* 20 */     this.uiManager = new UIManager(handler);
/* 21 */     handler.getMouseManager().setUiManager(this.uiManager);
/*    */     
/* 23 */     this.uiManager.addObject(new UIImageButton(150.0F, 260.0F, 64, 64, Assets.controllers, new ClickListener(this, handler)
/*    */           {
/*    */             
/*    */             public void onClick()
/*    */             {
/* 28 */               handler.getMouseManager().setUiManager(null);
/* 29 */               handler.getMain().getStateManager().setState(2);
/*    */             }
/*    */           }));
/*    */ 
/*    */ 
/*    */     
/* 35 */     this.uiManager.addObject(new UIImageButton(400.0F, 15.0F, 48, 48, Assets.exit, new ClickListener(this)
/*    */           {
/*    */             public void onClick()
/*    */             {
/* 39 */               System.exit(0);
/*    */             }
/*    */           }));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/* 46 */   public void update() { this.uiManager.update(); }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(Graphics g) {
/* 53 */     g.drawImage(Assets.menu1, 0, 0, null);
/*    */ 
/*    */     
/* 56 */     this.uiManager.render(g);
/*    */   }
/*    */   
/*    */   public void init() {}
/*    */   
/*    */   public void handleInput() {}
/*    */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/state/MenuState.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.3
 */