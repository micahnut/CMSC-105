/*     */ package org.jfree.chart.block;
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
/*     */ public final class LengthConstraintType
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -1156658804028142978L;
/*  55 */   public static final LengthConstraintType NONE = new LengthConstraintType("LengthConstraintType.NONE");
/*     */ 
/*     */ 
/*     */   
/*  59 */   public static final LengthConstraintType RANGE = new LengthConstraintType("RectangleConstraintType.RANGE");
/*     */ 
/*     */ 
/*     */   
/*  63 */   public static final LengthConstraintType FIXED = new LengthConstraintType("LengthConstraintType.FIXED");
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
/*  75 */   private LengthConstraintType(String name) { this.name = name; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  85 */   public String toString() { return this.name; }
/*     */ 
/*     */ 
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
/*  98 */     if (this == obj) {
/*  99 */       return true;
/*     */     }
/* 101 */     if (!(obj instanceof LengthConstraintType)) {
/* 102 */       return false;
/*     */     }
/* 104 */     LengthConstraintType that = (LengthConstraintType)obj;
/* 105 */     if (!this.name.equals(that.toString())) {
/* 106 */       return false;
/*     */     }
/* 108 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 118 */   public int hashCode() { return this.name.hashCode(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Object readResolve() throws ObjectStreamException {
/* 129 */     if (equals(NONE)) {
/* 130 */       return NONE;
/*     */     }
/* 132 */     if (equals(RANGE)) {
/* 133 */       return RANGE;
/*     */     }
/* 135 */     if (equals(FIXED)) {
/* 136 */       return FIXED;
/*     */     }
/* 138 */     return null;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/block/LengthConstraintType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */