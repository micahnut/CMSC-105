/*     */ package org.jfree.chart.axis;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.text.NumberFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
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
/*     */ public class TickUnits
/*     */   implements TickUnitSource, Cloneable, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1134174035901467545L;
/*     */   private List tickUnits;
/*     */   
/*  80 */   public TickUnits() { this.tickUnits = new ArrayList(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(TickUnit unit) {
/*  90 */     if (unit == null) {
/*  91 */       throw new NullPointerException("Null 'unit' argument.");
/*     */     }
/*  93 */     this.tickUnits.add(unit);
/*  94 */     Collections.sort(this.tickUnits);
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
/* 105 */   public int size() { return this.tickUnits.size(); }
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
/* 118 */   public TickUnit get(int pos) { return (TickUnit)this.tickUnits.get(pos); }
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
/*     */   public TickUnit getLargerTickUnit(TickUnit unit) {
/* 130 */     int index = Collections.binarySearch(this.tickUnits, unit);
/* 131 */     if (index >= 0) {
/* 132 */       index++;
/*     */     } else {
/*     */       
/* 135 */       index = -index;
/*     */     } 
/*     */     
/* 138 */     return (TickUnit)this.tickUnits.get(Math.min(index, this.tickUnits
/* 139 */           .size() - 1));
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
/*     */   public TickUnit getCeilingTickUnit(TickUnit unit) {
/* 152 */     int index = Collections.binarySearch(this.tickUnits, unit);
/* 153 */     if (index >= 0) {
/* 154 */       return (TickUnit)this.tickUnits.get(index);
/*     */     }
/*     */     
/* 157 */     index = -(index + 1);
/* 158 */     return (TickUnit)this.tickUnits.get(Math.min(index, this.tickUnits
/* 159 */           .size() - 1));
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
/*     */   public TickUnit getCeilingTickUnit(double size) {
/* 173 */     return getCeilingTickUnit(new NumberTickUnit(size, 
/* 174 */           NumberFormat.getInstance()));
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
/*     */   public Object clone() throws CloneNotSupportedException {
/* 187 */     TickUnits clone = (TickUnits)super.clone();
/* 188 */     clone.tickUnits = new ArrayList(this.tickUnits);
/* 189 */     return clone;
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
/*     */   public boolean equals(Object obj) {
/* 201 */     if (obj == this) {
/* 202 */       return true;
/*     */     }
/* 204 */     if (!(obj instanceof TickUnits)) {
/* 205 */       return false;
/*     */     }
/* 207 */     TickUnits that = (TickUnits)obj;
/* 208 */     return that.tickUnits.equals(this.tickUnits);
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/axis/TickUnits.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */