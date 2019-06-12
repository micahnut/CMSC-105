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
/*     */ public final class HorizontalAlignment
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -8249740987565309567L;
/*  60 */   public static final HorizontalAlignment LEFT = new HorizontalAlignment("HorizontalAlignment.LEFT");
/*     */ 
/*     */ 
/*     */   
/*  64 */   public static final HorizontalAlignment RIGHT = new HorizontalAlignment("HorizontalAlignment.RIGHT");
/*     */ 
/*     */ 
/*     */   
/*  68 */   public static final HorizontalAlignment CENTER = new HorizontalAlignment("HorizontalAlignment.CENTER");
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
/*  80 */   private HorizontalAlignment(String name) { this.name = name; }
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
/*     */   public boolean equals(Object obj) {
/* 101 */     if (this == obj) {
/* 102 */       return true;
/*     */     }
/* 104 */     if (!(obj instanceof HorizontalAlignment)) {
/* 105 */       return false;
/*     */     }
/* 107 */     HorizontalAlignment that = (HorizontalAlignment)obj;
/* 108 */     if (!this.name.equals(that.name)) {
/* 109 */       return false;
/*     */     }
/* 111 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 120 */   public int hashCode() { return this.name.hashCode(); }
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
/* 131 */     HorizontalAlignment result = null;
/* 132 */     if (equals(LEFT)) {
/* 133 */       result = LEFT;
/*     */     }
/* 135 */     else if (equals(RIGHT)) {
/* 136 */       result = RIGHT;
/*     */     }
/* 138 */     else if (equals(CENTER)) {
/* 139 */       result = CENTER;
/*     */     } 
/* 141 */     return result;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/ui/HorizontalAlignment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */