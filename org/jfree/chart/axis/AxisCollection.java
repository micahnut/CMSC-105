/*     */ package org.jfree.chart.axis;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.jfree.chart.util.ParamChecks;
/*     */ import org.jfree.ui.RectangleEdge;
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
/*     */ public class AxisCollection
/*     */ {
/*     */   private List axesAtTop;
/*     */   private List axesAtBottom;
/*     */   private List axesAtLeft;
/*     */   private List axesAtRight;
/*     */   
/*     */   public AxisCollection() {
/*  72 */     this.axesAtTop = new ArrayList();
/*  73 */     this.axesAtBottom = new ArrayList();
/*  74 */     this.axesAtLeft = new ArrayList();
/*  75 */     this.axesAtRight = new ArrayList();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  85 */   public List getAxesAtTop() { return this.axesAtTop; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  95 */   public List getAxesAtBottom() { return this.axesAtBottom; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 105 */   public List getAxesAtLeft() { return this.axesAtLeft; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 115 */   public List getAxesAtRight() { return this.axesAtRight; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(Axis axis, RectangleEdge edge) {
/* 126 */     ParamChecks.nullNotPermitted(axis, "axis");
/* 127 */     ParamChecks.nullNotPermitted(edge, "edge");
/* 128 */     if (edge == RectangleEdge.TOP) {
/* 129 */       this.axesAtTop.add(axis);
/*     */     }
/* 131 */     else if (edge == RectangleEdge.BOTTOM) {
/* 132 */       this.axesAtBottom.add(axis);
/*     */     }
/* 134 */     else if (edge == RectangleEdge.LEFT) {
/* 135 */       this.axesAtLeft.add(axis);
/*     */     }
/* 137 */     else if (edge == RectangleEdge.RIGHT) {
/* 138 */       this.axesAtRight.add(axis);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/axis/AxisCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */