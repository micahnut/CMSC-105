/*    */ package state;
/*    */ 
/*    */ import java.awt.Graphics;
/*    */ import main.Handler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class StateManager
/*    */ {
/*    */   private State[] States;
/*    */   private int currentState;
/*    */   private int previousState;
/*    */   private Handler handler;
/*    */   public static final int NUM_STATES = 7;
/*    */   public static final int INTRO = 0;
/*    */   public static final int MENU = 1;
/*    */   public static final int LABACT = 2;
/*    */   public static final int BS = 3;
/*    */   public static final int DS = 4;
/*    */   public static final int SP = 5;
/*    */   
/*    */   public StateManager(Handler handler) {
/* 27 */     this.handler = handler;
/* 28 */     this.States = new State[7];
/* 29 */     setState(0);
/*    */   }
/*    */   
/*    */   public void setState(int i) {
/* 33 */     this.previousState = this.currentState;
/* 34 */     unloadState(this.previousState);
/* 35 */     this.currentState = i;
/* 36 */     if (i == 0) {
/* 37 */       this.States[i] = new IntroState(this.handler, this);
/* 38 */       this.States[i].init();
/* 39 */     } else if (i == 1) {
/* 40 */       this.States[i] = new MenuState(this.handler, this);
/*    */     }
/* 42 */     else if (i == 2) {
/* 43 */       this.States[i] = new LabActivitiesState(this.handler, this);
/*    */     }
/* 45 */     else if (i == 3) {
/* 46 */       this.States[i] = new BasicSamplingState(this.handler, this);
/* 47 */     } else if (i == 4) {
/* 48 */       this.States[i] = new DescriptiveState(this.handler, this);
/* 49 */     } else if (i == 5) {
/* 50 */       this.States[i] = new Summarizing(this.handler, this);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 57 */   public void unloadState(int i) { this.States[i] = null; }
/*    */ 
/*    */   
/*    */   public void update() {
/* 61 */     if (this.States[this.currentState] != null) {
/* 62 */       this.States[this.currentState].update();
/*    */     }
/*    */   }
/*    */   
/*    */   public void render(Graphics g) {
/* 67 */     if (this.States[this.currentState] != null)
/* 68 */       this.States[this.currentState].render(g); 
/*    */   }
/*    */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/state/StateManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.3
 */