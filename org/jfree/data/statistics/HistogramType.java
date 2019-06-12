/*     */ package org.jfree.data.statistics;
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
/*     */ public class HistogramType
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 2618927186251997727L;
/*  56 */   public static final HistogramType FREQUENCY = new HistogramType("FREQUENCY");
/*     */ 
/*     */ 
/*     */   
/*  60 */   public static final HistogramType RELATIVE_FREQUENCY = new HistogramType("RELATIVE_FREQUENCY");
/*     */ 
/*     */ 
/*     */   
/*  64 */   public static final HistogramType SCALE_AREA_TO_1 = new HistogramType("SCALE_AREA_TO_1");
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
/*  76 */   private HistogramType(String name) { this.name = name; }
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
/*  99 */     if (obj == null) {
/* 100 */       return false;
/*     */     }
/*     */     
/* 103 */     if (obj == this) {
/* 104 */       return true;
/*     */     }
/*     */     
/* 107 */     if (!(obj instanceof HistogramType)) {
/* 108 */       return false;
/*     */     }
/*     */     
/* 111 */     HistogramType t = (HistogramType)obj;
/* 112 */     if (!this.name.equals(t.name)) {
/* 113 */       return false;
/*     */     }
/*     */     
/* 116 */     return true;
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
/* 127 */   public int hashCode() { return this.name.hashCode(); }
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
/* 138 */     if (equals(FREQUENCY)) {
/* 139 */       return FREQUENCY;
/*     */     }
/* 141 */     if (equals(RELATIVE_FREQUENCY)) {
/* 142 */       return RELATIVE_FREQUENCY;
/*     */     }
/* 144 */     if (equals(SCALE_AREA_TO_1)) {
/* 145 */       return SCALE_AREA_TO_1;
/*     */     }
/* 147 */     return null;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/statistics/HistogramType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */