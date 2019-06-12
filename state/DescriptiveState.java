/*    */ package state;
/*    */ 
/*    */ import gfx.Assets;
/*    */ import java.awt.Graphics;
/*    */ import lab3.Grouped;
/*    */ import lab3.Ungrouped;
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
/*    */ 
/*    */ 
/*    */ public class DescriptiveState
/*    */   extends State
/*    */ {
/*    */   private UIManager uiManager;
/*    */   
/*    */   public DescriptiveState(Handler handler, StateManager sm) {
/* 26 */     super(handler, sm);
/*    */     
/* 28 */     this.uiManager = new UIManager(handler);
/* 29 */     handler.getMouseManager().setUiManager(this.uiManager);
/*    */     
/* 31 */     this.uiManager.addObject(new UIImageButton(115.0F, 120.0F, 48, 48, Assets.data, new ClickListener(this)
/*    */           {
/*    */             
/*    */             public void onClick()
/*    */             {
/* 36 */               Grouped g = new Grouped();
/*    */             }
/*    */           }));
/*    */ 
/*    */     
/* 41 */     this.uiManager.addObject(new UIImageButton(115.0F, 220.0F, 48, 48, Assets.data2, new ClickListener(this)
/*    */           {
/*    */             public void onClick()
/*    */             {
/* 45 */               Ungrouped u = new Ungrouped();
/*    */             }
/*    */           }));
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 52 */     this.uiManager.addObject(new UIImageButton(115.0F, 295.0F, 48, 48, Assets.back, new ClickListener(this, handler)
/*    */           {
/*    */             public void onClick()
/*    */             {
/* 56 */               handler.getMain().getStateManager().setState(2);
/*    */             }
/*    */           }));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/* 63 */   public void update() { this.uiManager.update(); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(Graphics g) {
/* 69 */     g.drawImage(Assets.DS, 0, 0, null);
/*    */     
/* 71 */     this.uiManager.render(g);
/*    */   }
/*    */   
/*    */   public void init() {}
/*    */   
/*    */   public void handleInput() {}
/*    */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/state/DescriptiveState.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.3
 */