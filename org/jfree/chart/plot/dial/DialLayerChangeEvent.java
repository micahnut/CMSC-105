/*    */ package org.jfree.chart.plot.dial;
/*    */ 
/*    */ import org.jfree.chart.event.ChartChangeEvent;
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
/*    */ 
/*    */ 
/*    */ public class DialLayerChangeEvent
/*    */   extends ChartChangeEvent
/*    */ {
/*    */   private DialLayer layer;
/*    */   
/*    */   public DialLayerChangeEvent(DialLayer layer) {
/* 62 */     super(layer);
/* 63 */     this.layer = layer;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 72 */   public DialLayer getDialLayer() { return this.layer; }
/*    */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/plot/dial/DialLayerChangeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */