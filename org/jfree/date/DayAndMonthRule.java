/*     */ package org.jfree.date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DayAndMonthRule
/*     */   extends AnnualDateRule
/*     */ {
/*     */   private int dayOfMonth;
/*     */   private int month;
/*     */   
/*  69 */   public DayAndMonthRule() { this(1, 1); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DayAndMonthRule(int dayOfMonth, int month) {
/*  86 */     setMonth(month);
/*  87 */     setDayOfMonth(dayOfMonth);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  97 */   public int getDayOfMonth() { return this.dayOfMonth; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDayOfMonth(int dayOfMonth) {
/* 108 */     if (dayOfMonth < 1 || dayOfMonth > SerialDate.LAST_DAY_OF_MONTH[this.month]) {
/* 109 */       throw new IllegalArgumentException("DayAndMonthRule(): dayOfMonth outside valid range.");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 114 */     this.dayOfMonth = dayOfMonth;
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
/* 128 */   public int getMonth() { return this.month; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMonth(int month) {
/* 139 */     if (!SerialDate.isValidMonthCode(month)) {
/* 140 */       throw new IllegalArgumentException("DayAndMonthRule(): month code not valid.");
/*     */     }
/*     */ 
/*     */     
/* 144 */     this.month = month;
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
/* 156 */   public SerialDate getDate(int yyyy) { return SerialDate.createInstance(this.dayOfMonth, this.month, yyyy); }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/date/DayAndMonthRule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */