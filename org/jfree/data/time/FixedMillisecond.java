/*     */ package org.jfree.data.time;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Calendar;
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
/*     */ public class FixedMillisecond
/*     */   extends RegularTimePeriod
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 7867521484545646931L;
/*     */   private long time;
/*     */   
/*  74 */   public FixedMillisecond() { this(new Date()); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  83 */   public FixedMillisecond(long millisecond) { this(new Date(millisecond)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  92 */   public FixedMillisecond(Date time) { this.time = time.getTime(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 101 */   public Date getTime() { return new Date(this.time); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void peg(Calendar calendar) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RegularTimePeriod previous() {
/* 123 */     RegularTimePeriod result = null;
/* 124 */     long t = this.time;
/* 125 */     if (t != Float.MIN_VALUE) {
/* 126 */       result = new FixedMillisecond(t - 1L);
/*     */     }
/* 128 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RegularTimePeriod next() {
/* 138 */     RegularTimePeriod result = null;
/* 139 */     long t = this.time;
/* 140 */     if (t != Float.MAX_VALUE) {
/* 141 */       result = new FixedMillisecond(t + 1L);
/*     */     }
/* 143 */     return result;
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
/*     */   public boolean equals(Object object) {
/* 155 */     if (object instanceof FixedMillisecond) {
/* 156 */       FixedMillisecond m = (FixedMillisecond)object;
/* 157 */       return (this.time == m.getFirstMillisecond());
/*     */     } 
/*     */     
/* 160 */     return false;
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
/* 172 */   public int hashCode() { return (int)this.time; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int compareTo(Object o1) {
/*     */     int result;
/* 192 */     if (o1 instanceof FixedMillisecond) {
/* 193 */       FixedMillisecond t1 = (FixedMillisecond)o1;
/* 194 */       long difference = this.time - t1.time;
/* 195 */       if (difference > 0L) {
/* 196 */         result = 1;
/*     */       
/*     */       }
/* 199 */       else if (difference < 0L) {
/* 200 */         result = -1;
/*     */       } else {
/*     */         
/* 203 */         result = 0;
/*     */ 
/*     */       
/*     */       }
/*     */ 
/*     */     
/*     */     }
/* 210 */     else if (o1 instanceof RegularTimePeriod) {
/*     */       
/* 212 */       result = 0;
/*     */ 
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */       
/* 219 */       result = 1;
/*     */     } 
/*     */     
/* 222 */     return result;
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
/* 233 */   public long getFirstMillisecond() { return this.time; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 246 */   public long getFirstMillisecond(Calendar calendar) { return this.time; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 256 */   public long getLastMillisecond() { return this.time; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 268 */   public long getLastMillisecond(Calendar calendar) { return this.time; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 278 */   public long getMiddleMillisecond() { return this.time; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 290 */   public long getMiddleMillisecond(Calendar calendar) { return this.time; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 300 */   public long getSerialIndex() { return this.time; }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/time/FixedMillisecond.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */