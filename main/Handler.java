/*    */ package main;
/*    */ 
/*    */ import input.MouseManager;
/*    */ import state.StateManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Handler
/*    */ {
/*    */   private Main main;
/*    */   
/* 12 */   public Handler(Main main) { this.main = main; }
/*    */ 
/*    */ 
/*    */   
/* 16 */   public MouseManager getMouseManager() { return this.main.getMouseManager(); }
/*    */ 
/*    */ 
/*    */   
/* 20 */   public StateManager getStateManager() { return this.main.getStateManager(); }
/*    */ 
/*    */ 
/*    */   
/* 24 */   public int getWidth() { return this.main.getWidth(); }
/*    */ 
/*    */ 
/*    */   
/* 28 */   public int getHeight() { return this.main.getHeight(); }
/*    */ 
/*    */ 
/*    */   
/* 32 */   public Main getMain() { return this.main; }
/*    */ 
/*    */ 
/*    */   
/* 36 */   public void setMain(Main main) { this.main = main; }
/*    */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/main/Handler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.3
 */