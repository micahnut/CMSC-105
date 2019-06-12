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
/*     */ public class DayOfWeekInMonthRule
/*     */   extends AnnualDateRule
/*     */ {
/*     */   private int count;
/*     */   private int dayOfWeek;
/*     */   private int month;
/*     */   
/*  68 */   public DayOfWeekInMonthRule() { this(1, 2, 1); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DayOfWeekInMonthRule(int count, int dayOfWeek, int month) {
/*  79 */     this.count = count;
/*  80 */     this.dayOfWeek = dayOfWeek;
/*  81 */     this.month = month;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  90 */   public int getCount() { return this.count; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  99 */   public void setCount(int count) { this.count = count; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 108 */   public int getDayOfWeek() { return this.dayOfWeek; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 117 */   public void setDayOfWeek(int dayOfWeek) { this.dayOfWeek = dayOfWeek; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 126 */   public int getMonth() { return this.month; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 135 */   public void setMonth(int month) { this.month = month; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SerialDate getDate(int year) {
/*     */     SerialDate result;
/* 147 */     if (this.count != 0) {
/*     */       
/* 149 */       result = SerialDate.createInstance(1, this.month, year);
/* 150 */       while (result.getDayOfWeek() != this.dayOfWeek) {
/* 151 */         result = SerialDate.addDays(1, result);
/*     */       }
/* 153 */       result = SerialDate.addDays(7 * (this.count - 1), result);
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 158 */       result = SerialDate.createInstance(1, this.month, year);
/* 159 */       result = result.getEndOfCurrentMonth(result);
/* 160 */       while (result.getDayOfWeek() != this.dayOfWeek) {
/* 161 */         result = SerialDate.addDays(-1, result);
/*     */       }
/*     */     } 
/*     */     
/* 165 */     return result;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/date/DayOfWeekInMonthRule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */