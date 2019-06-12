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
/*    */ public class LabActivitiesState
/*    */   extends State
/*    */ {
/*    */   private UIManager uiManager;
/*    */   
/*    */   public LabActivitiesState(Handler handler, StateManager gsm) {
/* 18 */     super(handler, gsm);
/*    */     
/* 20 */     this.uiManager = new UIManager(handler);
/* 21 */     handler.getMouseManager().setUiManager(this.uiManager);
/*    */     
/* 23 */     this.uiManager.addObject(new UIImageButton(90.0F, 120.0F, 48, 48, Assets.controllers, new ClickListener(this, handler)
/*    */           {
/*    */             public void onClick()
/*    */             {
/* 27 */               handler.getMouseManager().setUiManager(null);
/* 28 */               handler.getMain().getStateManager().setState(3);
/*    */             }
/*    */           }));
/*    */     
/* 32 */     this.uiManager.addObject(new UIImageButton(90.0F, 190.0F, 48, 48, Assets.controllers, new ClickListener(this, handler)
/*    */           {
/*    */             public void onClick()
/*    */             {
/* 36 */               handler.getMain().getStateManager().setState(5);
/*    */             }
/*    */           }));
/*    */ 
/*    */     
/* 41 */     this.uiManager.addObject(new UIImageButton(90.0F, 265.0F, 48, 48, Assets.controllers, new ClickListener(this, handler)
/*    */           {
/*    */             public void onClick()
/*    */             {
/* 45 */               handler.getMain().getStateManager().setState(4);
/*    */             }
/*    */           }));
/*    */ 
/*    */ 
/*    */     
/* 51 */     this.uiManager.addObject(new UIImageButton(90.0F, 340.0F, 48, 48, Assets.exit, new ClickListener(this)
/*    */           {
/*    */             public void onClick()
/*    */             {
/* 55 */               System.exit(0);
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
/*    */   
/*    */   public void render(Graphics g) {
/* 69 */     g.drawImage(Assets.menu2, 0, 0, null);
/*    */ 
/*    */     
/* 72 */     this.uiManager.render(g);
/*    */   }
/*    */   
/*    */   public void init() {}
/*    */   
/*    */   public void handleInput() {}
/*    */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/state/LabActivitiesState.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.3
 */