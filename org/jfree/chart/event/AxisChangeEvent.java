/*    */ package org.jfree.chart.event;
/*    */ 
/*    */ import org.jfree.chart.axis.Axis;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AxisChangeEvent
/*    */   extends ChartChangeEvent
/*    */ {
/*    */   private Axis axis;
/*    */   
/*    */   public AxisChangeEvent(Axis axis) {
/* 60 */     super(axis);
/* 61 */     this.axis = axis;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 70 */   public Axis getAxis() { return this.axis; }
/*    */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/event/AxisChangeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */