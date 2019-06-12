/*    */ package org.jfree.chart.entity;
/*    */ 
/*    */ import java.awt.Shape;
/*    */ import java.io.Serializable;
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
/*    */ 
/*    */ public class TickLabelEntity
/*    */   extends ChartEntity
/*    */   implements Cloneable, Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 681583956588092095L;
/*    */   
/* 64 */   public TickLabelEntity(Shape area, String toolTipText, String urlText) { super(area, toolTipText, urlText); }
/*    */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/entity/TickLabelEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */