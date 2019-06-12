/*     */ package org.jfree.chart.axis;
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
/*     */ public final class CategoryAnchor
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -2604142742210173810L;
/*  56 */   public static final CategoryAnchor START = new CategoryAnchor("CategoryAnchor.START");
/*     */ 
/*     */ 
/*     */   
/*  60 */   public static final CategoryAnchor MIDDLE = new CategoryAnchor("CategoryAnchor.MIDDLE");
/*     */ 
/*     */ 
/*     */   
/*  64 */   public static final CategoryAnchor END = new CategoryAnchor("CategoryAnchor.END");
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
/*  76 */   private CategoryAnchor(String name) { this.name = name; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  86 */   public String toString() { return this.name; }
/*     */ 
/*     */ 
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
/*  99 */     if (this == obj) {
/* 100 */       return true;
/*     */     }
/* 102 */     if (!(obj instanceof CategoryAnchor)) {
/* 103 */       return false;
/*     */     }
/* 105 */     CategoryAnchor position = (CategoryAnchor)obj;
/* 106 */     if (!this.name.equals(position.toString())) {
/* 107 */       return false;
/*     */     }
/* 109 */     return true;
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
/* 120 */     if (equals(START)) {
/* 121 */       return START;
/*     */     }
/* 123 */     if (equals(MIDDLE)) {
/* 124 */       return MIDDLE;
/*     */     }
/* 126 */     if (equals(END)) {
/* 127 */       return END;
/*     */     }
/* 129 */     return null;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/axis/CategoryAnchor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */