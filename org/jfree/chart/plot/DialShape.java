/*     */ package org.jfree.chart.plot;
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
/*     */ 
/*     */ 
/*     */ public final class DialShape
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -3471933055190251131L;
/*  57 */   public static final DialShape CIRCLE = new DialShape("DialShape.CIRCLE");
/*     */ 
/*     */   
/*  60 */   public static final DialShape CHORD = new DialShape("DialShape.CHORD");
/*     */ 
/*     */   
/*  63 */   public static final DialShape PIE = new DialShape("DialShape.PIE");
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
/*  74 */   private DialShape(String name) { this.name = name; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  84 */   public String toString() { return this.name; }
/*     */ 
/*     */ 
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
/*  97 */     if (this == obj) {
/*  98 */       return true;
/*     */     }
/* 100 */     if (!(obj instanceof DialShape)) {
/* 101 */       return false;
/*     */     }
/* 103 */     DialShape shape = (DialShape)obj;
/* 104 */     if (!this.name.equals(shape.toString())) {
/* 105 */       return false;
/*     */     }
/* 107 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 117 */   public int hashCode() { return this.name.hashCode(); }
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
/* 128 */     if (equals(CIRCLE)) {
/* 129 */       return CIRCLE;
/*     */     }
/* 131 */     if (equals(CHORD)) {
/* 132 */       return CHORD;
/*     */     }
/* 134 */     if (equals(PIE)) {
/* 135 */       return PIE;
/*     */     }
/* 137 */     return null;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/plot/DialShape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */