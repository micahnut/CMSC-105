/*     */ package org.jfree.data.time;
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
/*     */ public final class TimePeriodAnchor
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 2011955697457548862L;
/*  57 */   public static final TimePeriodAnchor START = new TimePeriodAnchor("TimePeriodAnchor.START");
/*     */ 
/*     */ 
/*     */   
/*  61 */   public static final TimePeriodAnchor MIDDLE = new TimePeriodAnchor("TimePeriodAnchor.MIDDLE");
/*     */ 
/*     */ 
/*     */   
/*  65 */   public static final TimePeriodAnchor END = new TimePeriodAnchor("TimePeriodAnchor.END");
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
/*  77 */   private TimePeriodAnchor(String name) { this.name = name; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  87 */   public String toString() { return this.name; }
/*     */ 
/*     */ 
/*     */ 
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
/* 104 */     if (!(obj instanceof TimePeriodAnchor)) {
/* 105 */       return false;
/*     */     }
/*     */     
/* 108 */     TimePeriodAnchor position = (TimePeriodAnchor)obj;
/* 109 */     if (!this.name.equals(position.name)) {
/* 110 */       return false;
/*     */     }
/*     */     
/* 113 */     return true;
/*     */   }
/*     */ 
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
/* 134 */     if (equals(START)) {
/* 135 */       return START;
/*     */     }
/* 137 */     if (equals(MIDDLE)) {
/* 138 */       return MIDDLE;
/*     */     }
/* 140 */     if (equals(END)) {
/* 141 */       return END;
/*     */     }
/* 143 */     return null;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/time/TimePeriodAnchor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */