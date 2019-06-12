/*     */ package org.jfree.chart;
/*     */ 
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.io.Serializable;
/*     */ import java.util.EventObject;
/*     */ import org.jfree.chart.entity.ChartEntity;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ChartMouseEvent
/*     */   extends EventObject
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -682393837314562149L;
/*     */   private JFreeChart chart;
/*     */   private MouseEvent trigger;
/*     */   private ChartEntity entity;
/*     */   
/*     */   public ChartMouseEvent(JFreeChart chart, MouseEvent trigger, ChartEntity entity) {
/*  85 */     super(chart);
/*  86 */     this.chart = chart;
/*  87 */     this.trigger = trigger;
/*  88 */     this.entity = entity;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  97 */   public JFreeChart getChart() { return this.chart; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 106 */   public MouseEvent getTrigger() { return this.trigger; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 115 */   public ChartEntity getEntity() { return this.entity; }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/ChartMouseEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */