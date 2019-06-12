/*     */ package org.jfree.chart.axis;
/*     */ 
/*     */ import org.jfree.ui.TextAnchor;
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
/*     */ public abstract class ValueTick
/*     */   extends Tick
/*     */ {
/*     */   private double value;
/*     */   private TickType tickType;
/*     */   
/*     */   public ValueTick(double value, String label, TextAnchor textAnchor, TextAnchor rotationAnchor, double angle) {
/*  75 */     this(TickType.MAJOR, value, label, textAnchor, rotationAnchor, angle);
/*  76 */     this.value = value;
/*     */   }
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
/*     */   public ValueTick(TickType tickType, double value, String label, TextAnchor textAnchor, TextAnchor rotationAnchor, double angle) {
/*  98 */     super(label, textAnchor, rotationAnchor, angle);
/*  99 */     this.value = value;
/* 100 */     this.tickType = tickType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 109 */   public double getValue() { return this.value; }
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
/* 120 */   public TickType getTickType() { return this.tickType; }
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
/* 132 */     if (obj == this) {
/* 133 */       return true;
/*     */     }
/* 135 */     if (!(obj instanceof ValueTick)) {
/* 136 */       return false;
/*     */     }
/* 138 */     ValueTick that = (ValueTick)obj;
/* 139 */     if (this.value != that.value) {
/* 140 */       return false;
/*     */     }
/* 142 */     if (!this.tickType.equals(that.tickType)) {
/* 143 */       return false;
/*     */     }
/* 145 */     return super.equals(obj);
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/axis/ValueTick.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */