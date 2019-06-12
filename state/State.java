/*    */ package state;
/*    */ 
/*    */ import java.awt.Graphics;
/*    */ import main.Handler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class State
/*    */ {
/* 12 */   private static State currentState = null;
/*    */   protected Handler handler;
/*    */   
/* 15 */   public static void setState(State state) { currentState = state; }
/*    */ 
/*    */   
/*    */   protected StateManager sm;
/*    */   
/* 20 */   public static State getState() { return currentState; }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public State(Handler handler, StateManager sm) {
/* 28 */     this.handler = handler;
/* 29 */     this.sm = sm;
/*    */   }
/*    */   
/*    */   public abstract void update();
/*    */   
/*    */   public abstract void init();
/*    */   
/*    */   public abstract void handleInput();
/*    */   
/*    */   public abstract void render(Graphics paramGraphics);
/*    */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/state/State.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.3
 */