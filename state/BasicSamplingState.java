/*    */ package state;
/*    */ 
/*    */ import gfx.Assets;
/*    */ import java.awt.Graphics;
/*    */ import lab1.Simple;
/*    */ import lab1.Stratified;
/*    */ import lab1.Systematic;
/*    */ import main.Handler;
/*    */ import ui.ClickListener;
/*    */ import ui.UIImageButton;
/*    */ import ui.UIManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BasicSamplingState
/*    */   extends State
/*    */ {
/*    */   private UIManager uiManager;
/*    */   
/*    */   public BasicSamplingState(Handler handler, StateManager sm) {
/* 22 */     super(handler, sm);
/*    */     
/* 24 */     this.uiManager = new UIManager(handler);
/* 25 */     handler.getMouseManager().setUiManager(this.uiManager);
/*    */     
/* 27 */     this.uiManager.addObject(new UIImageButton(90.0F, 120.0F, 48, 48, Assets.simplerand, new ClickListener(this)
/*    */           {
/*    */             
/*    */             public void onClick()
/*    */             {
/* 32 */               Simple r = new Simple();
/*    */             }
/*    */           }));
/*    */ 
/*    */     
/* 37 */     this.uiManager.addObject(new UIImageButton(90.0F, 190.0F, 48, 48, Assets.sysrand, new ClickListener(this)
/*    */           {
/*    */             
/*    */             public void onClick()
/*    */             {
/* 42 */               Systematic sys = new Systematic();
/*    */             }
/*    */           }));
/*    */ 
/*    */     
/* 47 */     this.uiManager.addObject(new UIImageButton(90.0F, 260.0F, 48, 48, Assets.stratrand, new ClickListener(this)
/*    */           {
/*    */             public void onClick()
/*    */             {
/* 51 */               Stratified stra = new Stratified();
/*    */             }
/*    */           }));
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 58 */     this.uiManager.addObject(new UIImageButton(90.0F, 340.0F, 48, 48, Assets.back, new ClickListener(this, handler)
/*    */           {
/*    */             public void onClick()
/*    */             {
/* 62 */               handler.getMain().getStateManager().setState(2);
/*    */             }
/*    */           }));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/* 69 */   public void update() { this.uiManager.update(); }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(Graphics g) {
/* 76 */     g.drawImage(Assets.BS, 0, 0, null);
/*    */     
/* 78 */     this.uiManager.render(g);
/*    */   }
/*    */   
/*    */   public void init() {}
/*    */   
/*    */   public void handleInput() {}
/*    */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/state/BasicSamplingState.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.3
 */