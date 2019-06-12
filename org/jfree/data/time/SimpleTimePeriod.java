/*     */ package org.jfree.data.time;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SimpleTimePeriod
/*     */   implements TimePeriod, Comparable, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 8684672361131829554L;
/*     */   private long start;
/*     */   private long end;
/*     */   
/*     */   public SimpleTimePeriod(long start, long end) {
/*  77 */     if (start > end) {
/*  78 */       throw new IllegalArgumentException("Requires start <= end.");
/*     */     }
/*  80 */     this.start = start;
/*  81 */     this.end = end;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  91 */   public SimpleTimePeriod(Date start, Date end) { this(start.getTime(), end.getTime()); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 101 */   public Date getStart() { return new Date(this.start); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 112 */   public long getStartMillis() { return this.start; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 122 */   public Date getEnd() { return new Date(this.end); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 133 */   public long getEndMillis() { return this.end; }
/*     */ 
/*     */ 
/*     */ 
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
/* 147 */     if (obj == this) {
/* 148 */       return true;
/*     */     }
/* 150 */     if (!(obj instanceof TimePeriod)) {
/* 151 */       return false;
/*     */     }
/* 153 */     TimePeriod that = (TimePeriod)obj;
/* 154 */     if (!getStart().equals(that.getStart())) {
/* 155 */       return false;
/*     */     }
/* 157 */     if (!getEnd().equals(that.getEnd())) {
/* 158 */       return false;
/*     */     }
/* 160 */     return true;
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
/*     */ 
/*     */   
/*     */   public int compareTo(Object obj) {
/* 176 */     TimePeriod that = (TimePeriod)obj;
/* 177 */     long t0 = getStart().getTime();
/* 178 */     long t1 = getEnd().getTime();
/* 179 */     long m0 = t0 + (t1 - t0) / 2L;
/* 180 */     long t2 = that.getStart().getTime();
/* 181 */     long t3 = that.getEnd().getTime();
/* 182 */     long m1 = t2 + (t3 - t2) / 2L;
/* 183 */     if (m0 < m1) {
/* 184 */       return -1;
/*     */     }
/* 186 */     if (m0 > m1) {
/* 187 */       return 1;
/*     */     }
/*     */     
/* 190 */     if (t0 < t2) {
/* 191 */       return -1;
/*     */     }
/* 193 */     if (t0 > t2) {
/* 194 */       return 1;
/*     */     }
/*     */     
/* 197 */     if (t1 < t3) {
/* 198 */       return -1;
/*     */     }
/* 200 */     if (t1 > t3) {
/* 201 */       return 1;
/*     */     }
/*     */     
/* 204 */     return 0;
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
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 221 */     result = 17;
/* 222 */     result = 37 * result + (int)this.start;
/* 223 */     return 37 * result + (int)this.end;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/time/SimpleTimePeriod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */