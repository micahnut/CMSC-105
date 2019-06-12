/*     */ package org.jfree.data.time;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.Locale;
/*     */ import java.util.TimeZone;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Year
/*     */   extends RegularTimePeriod
/*     */   implements Serializable
/*     */ {
/*     */   public static final int MINIMUM_YEAR = -9999;
/*     */   public static final int MAXIMUM_YEAR = 9999;
/*     */   private static final long serialVersionUID = -7659990929736074836L;
/*     */   private short year;
/*     */   private long firstMillisecond;
/*     */   private long lastMillisecond;
/*     */   
/* 107 */   public Year() { this(new Date()); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Year(int year) {
/* 116 */     if (year < -9999 || year > 9999) {
/* 117 */       throw new IllegalArgumentException("Year constructor: year (" + year + ") outside valid range.");
/*     */     }
/*     */     
/* 120 */     this.year = (short)year;
/* 121 */     peg(Calendar.getInstance());
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
/* 133 */   public Year(Date time) { this(time, TimeZone.getDefault()); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 146 */   public Year(Date time, TimeZone zone) { this(time, zone, Locale.getDefault()); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Year(Date time, TimeZone zone, Locale locale) {
/* 160 */     Calendar calendar = Calendar.getInstance(zone, locale);
/* 161 */     calendar.setTime(time);
/* 162 */     this.year = (short)calendar.get(1);
/* 163 */     peg(calendar);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 172 */   public int getYear() { return this.year; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 187 */   public long getFirstMillisecond() { return this.firstMillisecond; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 202 */   public long getLastMillisecond() { return this.lastMillisecond; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void peg(Calendar calendar) {
/* 215 */     this.firstMillisecond = getFirstMillisecond(calendar);
/* 216 */     this.lastMillisecond = getLastMillisecond(calendar);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RegularTimePeriod previous() {
/* 227 */     if (this.year > -9999) {
/* 228 */       return new Year(this.year - 1);
/*     */     }
/*     */     
/* 231 */     return null;
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
/*     */   public RegularTimePeriod next() {
/* 243 */     if (this.year < 9999) {
/* 244 */       return new Year(this.year + 1);
/*     */     }
/*     */     
/* 247 */     return null;
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
/* 260 */   public long getSerialIndex() { return this.year; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getFirstMillisecond(Calendar calendar) {
/* 276 */     calendar.set(this.year, 0, 1, 0, 0, 0);
/* 277 */     calendar.set(14, 0);
/* 278 */     return calendar.getTimeInMillis();
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
/*     */   public long getLastMillisecond(Calendar calendar) {
/* 294 */     calendar.set(this.year, 11, 31, 23, 59, 59);
/* 295 */     calendar.set(14, 999);
/* 296 */     return calendar.getTimeInMillis();
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
/*     */   public boolean equals(Object obj) {
/* 312 */     if (obj == this) {
/* 313 */       return true;
/*     */     }
/* 315 */     if (!(obj instanceof Year)) {
/* 316 */       return false;
/*     */     }
/* 318 */     Year that = (Year)obj;
/* 319 */     return (this.year == that.year);
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
/*     */   public int hashCode() {
/* 333 */     result = 17;
/* 334 */     int c = this.year;
/* 335 */     return 37 * result + c;
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
/*     */ 
/*     */ 
/*     */   
/*     */   public int compareTo(Object o1) {
/*     */     int result;
/* 356 */     if (o1 instanceof Year) {
/* 357 */       Year y = (Year)o1;
/* 358 */       result = this.year - y.getYear();
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 363 */     else if (o1 instanceof RegularTimePeriod) {
/*     */       
/* 365 */       result = 0;
/*     */ 
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */       
/* 372 */       result = 1;
/*     */     } 
/*     */     
/* 375 */     return result;
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
/* 386 */   public String toString() { return Integer.toString(this.year); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Year parseYear(String s) {
/*     */     int y;
/*     */     try {
/* 404 */       y = Integer.parseInt(s.trim());
/*     */     }
/* 406 */     catch (NumberFormatException e) {
/* 407 */       throw new TimePeriodFormatException("Cannot parse string.");
/*     */     } 
/*     */ 
/*     */     
/*     */     try {
/* 412 */       return new Year(y);
/*     */     }
/* 414 */     catch (IllegalArgumentException e) {
/* 415 */       throw new TimePeriodFormatException("Year outside valid range.");
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/time/Year.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */