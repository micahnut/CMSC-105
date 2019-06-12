/*     */ package org.jfree.chart;
/*     */ 
/*     */ import java.io.ObjectStreamException;
/*     */ import java.io.Serializable;
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
/*     */ public final class LegendRenderingOrder
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -3832486612685808616L;
/*  55 */   public static final LegendRenderingOrder STANDARD = new LegendRenderingOrder("LegendRenderingOrder.STANDARD");
/*     */ 
/*     */ 
/*     */   
/*  59 */   public static final LegendRenderingOrder REVERSE = new LegendRenderingOrder("LegendRenderingOrder.REVERSE");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String name;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  71 */   private LegendRenderingOrder(String name) { this.name = name; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  81 */   public String toString() { return this.name; }
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
/*     */   public boolean equals(Object obj) {
/*  94 */     if (this == obj) {
/*  95 */       return true;
/*     */     }
/*  97 */     if (!(obj instanceof LegendRenderingOrder)) {
/*  98 */       return false;
/*     */     }
/* 100 */     LegendRenderingOrder order = (LegendRenderingOrder)obj;
/* 101 */     if (!this.name.equals(order.toString())) {
/* 102 */       return false;
/*     */     }
/* 104 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Object readResolve() throws ObjectStreamException {
/* 115 */     if (equals(STANDARD)) {
/* 116 */       return STANDARD;
/*     */     }
/* 118 */     if (equals(REVERSE)) {
/* 119 */       return REVERSE;
/*     */     }
/* 121 */     return null;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/LegendRenderingOrder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */