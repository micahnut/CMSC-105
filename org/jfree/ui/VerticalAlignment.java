/*     */ package org.jfree.ui;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class VerticalAlignment
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 7272397034325429853L;
/*  60 */   public static final VerticalAlignment TOP = new VerticalAlignment("VerticalAlignment.TOP");
/*     */ 
/*     */ 
/*     */   
/*  64 */   public static final VerticalAlignment BOTTOM = new VerticalAlignment("VerticalAlignment.BOTTOM");
/*     */ 
/*     */ 
/*     */   
/*  68 */   public static final VerticalAlignment CENTER = new VerticalAlignment("VerticalAlignment.CENTER");
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
/*  80 */   private VerticalAlignment(String name) { this.name = name; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  89 */   public String toString() { return this.name; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 102 */     if (this == o) {
/* 103 */       return true;
/*     */     }
/* 105 */     if (!(o instanceof VerticalAlignment)) {
/* 106 */       return false;
/*     */     }
/*     */     
/* 109 */     VerticalAlignment alignment = (VerticalAlignment)o;
/* 110 */     if (!this.name.equals(alignment.name)) {
/* 111 */       return false;
/*     */     }
/*     */     
/* 114 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 123 */   public int hashCode() { return this.name.hashCode(); }
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
/* 134 */     if (equals(TOP)) {
/* 135 */       return TOP;
/*     */     }
/* 137 */     if (equals(BOTTOM)) {
/* 138 */       return BOTTOM;
/*     */     }
/* 140 */     if (equals(CENTER)) {
/* 141 */       return CENTER;
/*     */     }
/*     */     
/* 144 */     return null;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/ui/VerticalAlignment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */