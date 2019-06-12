/*     */ package org.jfree.data;
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
/*     */ public final class DomainOrder
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 4902774943512072627L;
/*  55 */   public static final DomainOrder NONE = new DomainOrder("DomainOrder.NONE");
/*     */ 
/*     */   
/*  58 */   public static final DomainOrder ASCENDING = new DomainOrder("DomainOrder.ASCENDING");
/*     */ 
/*     */ 
/*     */   
/*  62 */   public static final DomainOrder DESCENDING = new DomainOrder("DomainOrder.DESCENDING");
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
/*  74 */   private DomainOrder(String name) { this.name = name; }
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
/* 100 */     if (!(obj instanceof DomainOrder)) {
/* 101 */       return false;
/*     */     }
/* 103 */     DomainOrder that = (DomainOrder)obj;
/* 104 */     if (!this.name.equals(that.toString())) {
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
/* 128 */     if (equals(ASCENDING)) {
/* 129 */       return ASCENDING;
/*     */     }
/* 131 */     if (equals(DESCENDING)) {
/* 132 */       return DESCENDING;
/*     */     }
/* 134 */     if (equals(NONE)) {
/* 135 */       return NONE;
/*     */     }
/* 137 */     return null;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/DomainOrder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */