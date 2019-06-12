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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RelativeDayOfWeekRule
/*     */   extends AnnualDateRule
/*     */ {
/*     */   private AnnualDateRule subrule;
/*     */   private int dayOfWeek;
/*     */   private int relative;
/*     */   
/*  73 */   public RelativeDayOfWeekRule() { this(new DayAndMonthRule(), 2, 1); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RelativeDayOfWeekRule(AnnualDateRule subrule, int dayOfWeek, int relative) {
/*  86 */     this.subrule = subrule;
/*  87 */     this.dayOfWeek = dayOfWeek;
/*  88 */     this.relative = relative;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  98 */   public AnnualDateRule getSubrule() { return this.subrule; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 108 */   public void setSubrule(AnnualDateRule subrule) { this.subrule = subrule; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 117 */   public int getDayOfWeek() { return this.dayOfWeek; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 127 */   public void setDayOfWeek(int dayOfWeek) { this.dayOfWeek = dayOfWeek; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 138 */   public int getRelative() { return this.relative; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 149 */   public void setRelative(int relative) { this.relative = relative; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object clone() throws CloneNotSupportedException {
/* 161 */     RelativeDayOfWeekRule duplicate = (RelativeDayOfWeekRule)super.clone();
/* 162 */     duplicate.subrule = (AnnualDateRule)duplicate.getSubrule().clone();
/* 163 */     return duplicate;
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
/*     */   public SerialDate getDate(int year) {
/* 177 */     if (year < 1900 || year > 9999)
/*     */     {
/* 179 */       throw new IllegalArgumentException("RelativeDayOfWeekRule.getDate(): year outside valid range.");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 184 */     SerialDate result = null;
/* 185 */     SerialDate base = this.subrule.getDate(year);
/*     */     
/* 187 */     if (base != null) {
/* 188 */       switch (this.relative) {
/*     */         case -1:
/* 190 */           result = SerialDate.getPreviousDayOfWeek(this.dayOfWeek, base);
/*     */           break;
/*     */         
/*     */         case 0:
/* 194 */           result = SerialDate.getNearestDayOfWeek(this.dayOfWeek, base);
/*     */           break;
/*     */         
/*     */         case 1:
/* 198 */           result = SerialDate.getFollowingDayOfWeek(this.dayOfWeek, base);
/*     */           break;
/*     */       } 
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 205 */     return result;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/date/RelativeDayOfWeekRule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */