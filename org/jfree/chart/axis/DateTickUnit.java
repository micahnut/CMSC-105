/*     */ package org.jfree.chart.axis;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.text.DateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.TimeZone;
/*     */ import org.jfree.chart.util.ParamChecks;
/*     */ import org.jfree.util.ObjectUtilities;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DateTickUnit
/*     */   extends TickUnit
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -7289292157229621901L;
/*     */   private DateTickUnitType unitType;
/*     */   private int count;
/*     */   private DateTickUnitType rollUnitType;
/*     */   private int rollCount;
/*     */   private DateFormat formatter;
/*     */   public static final int YEAR = 0;
/*     */   public static final int MONTH = 1;
/*     */   public static final int DAY = 2;
/*     */   public static final int HOUR = 3;
/*     */   public static final int MINUTE = 4;
/*     */   public static final int SECOND = 5;
/*     */   public static final int MILLISECOND = 6;
/*     */   private int unit;
/*     */   private int rollUnit;
/*     */   
/* 109 */   public DateTickUnit(DateTickUnitType unitType, int multiple) { this(unitType, multiple, DateFormat.getDateInstance(3)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 123 */   public DateTickUnit(DateTickUnitType unitType, int multiple, DateFormat formatter) { this(unitType, multiple, unitType, multiple, formatter); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DateTickUnit(DateTickUnitType unitType, int multiple, DateTickUnitType rollUnitType, int rollMultiple, DateFormat formatter) {
/* 140 */     super(getMillisecondCount(unitType, multiple));
/* 141 */     ParamChecks.nullNotPermitted(formatter, "formatter");
/* 142 */     if (multiple <= 0) {
/* 143 */       throw new IllegalArgumentException("Requires 'multiple' > 0.");
/*     */     }
/* 145 */     if (rollMultiple <= 0) {
/* 146 */       throw new IllegalArgumentException("Requires 'rollMultiple' > 0.");
/*     */     }
/* 148 */     this.unitType = unitType;
/* 149 */     this.count = multiple;
/* 150 */     this.rollUnitType = rollUnitType;
/* 151 */     this.rollCount = rollMultiple;
/* 152 */     this.formatter = formatter;
/*     */ 
/*     */     
/* 155 */     this.unit = unitTypeToInt(unitType);
/* 156 */     this.rollUnit = unitTypeToInt(rollUnitType);
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
/* 167 */   public DateTickUnitType getUnitType() { return this.unitType; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 176 */   public int getMultiple() { return this.count; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 187 */   public DateTickUnitType getRollUnitType() { return this.rollUnitType; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 198 */   public int getRollMultiple() { return this.rollCount; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 210 */   public String valueToString(double milliseconds) { return this.formatter.format(new Date((long)milliseconds)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 221 */   public String dateToString(Date date) { return this.formatter.format(date); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date addToDate(Date base, TimeZone zone) {
/* 239 */     Calendar calendar = Calendar.getInstance(zone);
/* 240 */     calendar.setTime(base);
/* 241 */     calendar.add(this.unitType.getCalendarField(), this.count);
/* 242 */     return calendar.getTime();
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
/* 256 */   public Date rollDate(Date base) { return rollDate(base, TimeZone.getDefault()); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date rollDate(Date base, TimeZone zone) {
/* 275 */     Calendar calendar = Calendar.getInstance(zone);
/* 276 */     calendar.setTime(base);
/* 277 */     calendar.add(this.rollUnitType.getCalendarField(), this.rollCount);
/* 278 */     return calendar.getTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 288 */   public int getCalendarField() { return this.unitType.getCalendarField(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static long getMillisecondCount(DateTickUnitType unit, int count) {
/* 307 */     if (unit.equals(DateTickUnitType.YEAR)) {
/* 308 */       return 31536000000L * count;
/*     */     }
/* 310 */     if (unit.equals(DateTickUnitType.MONTH)) {
/* 311 */       return 2678400000L * count;
/*     */     }
/* 313 */     if (unit.equals(DateTickUnitType.DAY)) {
/* 314 */       return 86400000L * count;
/*     */     }
/* 316 */     if (unit.equals(DateTickUnitType.HOUR)) {
/* 317 */       return 3600000L * count;
/*     */     }
/* 319 */     if (unit.equals(DateTickUnitType.MINUTE)) {
/* 320 */       return 60000L * count;
/*     */     }
/* 322 */     if (unit.equals(DateTickUnitType.SECOND)) {
/* 323 */       return 1000L * count;
/*     */     }
/* 325 */     if (unit.equals(DateTickUnitType.MILLISECOND)) {
/* 326 */       return count;
/*     */     }
/*     */     
/* 329 */     throw new IllegalArgumentException("The 'unit' argument has a value that is not recognised.");
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
/*     */   private static DateTickUnitType intToUnitType(int unit) {
/* 346 */     switch (unit) { case 0:
/* 347 */         return DateTickUnitType.YEAR;
/* 348 */       case 1: return DateTickUnitType.MONTH;
/* 349 */       case 2: return DateTickUnitType.DAY;
/* 350 */       case 3: return DateTickUnitType.HOUR;
/* 351 */       case 4: return DateTickUnitType.MINUTE;
/* 352 */       case 5: return DateTickUnitType.SECOND;
/* 353 */       case 6: return DateTickUnitType.MILLISECOND; }
/* 354 */      throw new IllegalArgumentException("Unrecognised 'unit' value " + unit + ".");
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
/*     */   private static int unitTypeToInt(DateTickUnitType unitType) {
/* 369 */     ParamChecks.nullNotPermitted(unitType, "unitType");
/* 370 */     if (unitType.equals(DateTickUnitType.YEAR)) {
/* 371 */       return 0;
/*     */     }
/* 373 */     if (unitType.equals(DateTickUnitType.MONTH)) {
/* 374 */       return 1;
/*     */     }
/* 376 */     if (unitType.equals(DateTickUnitType.DAY)) {
/* 377 */       return 2;
/*     */     }
/* 379 */     if (unitType.equals(DateTickUnitType.HOUR)) {
/* 380 */       return 3;
/*     */     }
/* 382 */     if (unitType.equals(DateTickUnitType.MINUTE)) {
/* 383 */       return 4;
/*     */     }
/* 385 */     if (unitType.equals(DateTickUnitType.SECOND)) {
/* 386 */       return 5;
/*     */     }
/* 388 */     if (unitType.equals(DateTickUnitType.MILLISECOND)) {
/* 389 */       return 6;
/*     */     }
/*     */     
/* 392 */     throw new IllegalArgumentException("The 'unitType' is not recognised");
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
/*     */   private static DateFormat notNull(DateFormat formatter) {
/* 406 */     if (formatter == null) {
/* 407 */       return DateFormat.getDateInstance(3);
/*     */     }
/*     */     
/* 410 */     return formatter;
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
/*     */   public boolean equals(Object obj) {
/* 423 */     if (obj == this) {
/* 424 */       return true;
/*     */     }
/* 426 */     if (!(obj instanceof DateTickUnit)) {
/* 427 */       return false;
/*     */     }
/* 429 */     if (!super.equals(obj)) {
/* 430 */       return false;
/*     */     }
/* 432 */     DateTickUnit that = (DateTickUnit)obj;
/* 433 */     if (!this.unitType.equals(that.unitType)) {
/* 434 */       return false;
/*     */     }
/* 436 */     if (this.count != that.count) {
/* 437 */       return false;
/*     */     }
/* 439 */     if (!ObjectUtilities.equal(this.formatter, that.formatter)) {
/* 440 */       return false;
/*     */     }
/* 442 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 452 */     result = 19;
/* 453 */     result = 37 * result + this.unitType.hashCode();
/* 454 */     result = 37 * result + this.count;
/* 455 */     return 37 * result + this.formatter.hashCode();
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
/* 467 */   public String toString() { return "DateTickUnit[" + this.unitType.toString() + ", " + this.count + "]"; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 547 */   public DateTickUnit(int unit, int count, DateFormat formatter) { this(unit, count, unit, count, formatter); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 561 */   public DateTickUnit(int unit, int count) { this(unit, count, null); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 578 */   public DateTickUnit(int unit, int count, int rollUnit, int rollCount, DateFormat formatter) { this(intToUnitType(unit), count, intToUnitType(rollUnit), rollCount, 
/* 579 */         notNull(formatter)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 595 */   public int getUnit() { return this.unit; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 606 */   public int getCount() { return this.count; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 620 */   public int getRollUnit() { return this.rollUnit; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 632 */   public int getRollCount() { return this.rollCount; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 649 */   public Date addToDate(Date base) { return addToDate(base, TimeZone.getDefault()); }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/axis/DateTickUnit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */