/*     */ package org.jfree.util;
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
/*     */ public final class TableOrder
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 525193294068177057L;
/*  59 */   public static final TableOrder BY_ROW = new TableOrder("TableOrder.BY_ROW");
/*     */ 
/*     */   
/*  62 */   public static final TableOrder BY_COLUMN = new TableOrder("TableOrder.BY_COLUMN");
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
/*  74 */   private TableOrder(String name) { this.name = name; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  83 */   public String toString() { return this.name; }
/*     */ 
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
/*  95 */     if (this == obj) {
/*  96 */       return true;
/*     */     }
/*  98 */     if (!(obj instanceof TableOrder)) {
/*  99 */       return false;
/*     */     }
/* 101 */     TableOrder that = (TableOrder)obj;
/* 102 */     if (!this.name.equals(that.name)) {
/* 103 */       return false;
/*     */     }
/* 105 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 114 */   public int hashCode() { return this.name.hashCode(); }
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
/* 125 */     if (equals(BY_ROW)) {
/* 126 */       return BY_ROW;
/*     */     }
/* 128 */     if (equals(BY_COLUMN)) {
/* 129 */       return BY_COLUMN;
/*     */     }
/* 131 */     return null;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/util/TableOrder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */