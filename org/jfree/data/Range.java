/*     */ package org.jfree.data;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import org.jfree.chart.util.ParamChecks;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Range
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -906333695431863380L;
/*     */   private double lower;
/*     */   private double upper;
/*     */   
/*     */   public Range(double lower, double upper) {
/*  90 */     if (lower > upper) {
/*  91 */       String msg = "Range(double, double): require lower (" + lower + ") <= upper (" + upper + ").";
/*     */       
/*  93 */       throw new IllegalArgumentException(msg);
/*     */     } 
/*  95 */     this.lower = lower;
/*  96 */     this.upper = upper;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 105 */   public double getLowerBound() { return this.lower; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 114 */   public double getUpperBound() { return this.upper; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 123 */   public double getLength() { return this.upper - this.lower; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 132 */   public double getCentralValue() { return this.lower / 2.0D + this.upper / 2.0D; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 144 */   public boolean contains(double value) { return (value >= this.lower && value <= this.upper); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean intersects(double b0, double b1) {
/* 157 */     if (b0 <= this.lower) {
/* 158 */       return (b1 > this.lower);
/*     */     }
/*     */     
/* 161 */     return (b0 < this.upper && b1 >= b0);
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
/* 176 */   public boolean intersects(Range range) { return intersects(range.getLowerBound(), range.getUpperBound()); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double constrain(double value) {
/* 188 */     double result = value;
/* 189 */     if (!contains(value)) {
/* 190 */       if (value > this.upper) {
/* 191 */         result = this.upper;
/*     */       }
/* 193 */       else if (value < this.lower) {
/* 194 */         result = this.lower;
/*     */       } 
/*     */     }
/* 197 */     return result;
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
/*     */   public static Range combine(Range range1, Range range2) {
/* 217 */     if (range1 == null) {
/* 218 */       return range2;
/*     */     }
/* 220 */     if (range2 == null) {
/* 221 */       return range1;
/*     */     }
/* 223 */     double l = Math.min(range1.getLowerBound(), range2.getLowerBound());
/* 224 */     double u = Math.max(range1.getUpperBound(), range2.getUpperBound());
/* 225 */     return new Range(l, u);
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
/*     */   public static Range combineIgnoringNaN(Range range1, Range range2) {
/* 241 */     if (range1 == null) {
/* 242 */       if (range2 != null && range2.isNaNRange()) {
/* 243 */         return null;
/*     */       }
/* 245 */       return range2;
/*     */     } 
/* 247 */     if (range2 == null) {
/* 248 */       if (range1.isNaNRange()) {
/* 249 */         return null;
/*     */       }
/* 251 */       return range1;
/*     */     } 
/* 253 */     double l = min(range1.getLowerBound(), range2.getLowerBound());
/* 254 */     double u = max(range1.getUpperBound(), range2.getUpperBound());
/* 255 */     if (Double.isNaN(l) && Double.isNaN(u)) {
/* 256 */       return null;
/*     */     }
/* 258 */     return new Range(l, u);
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
/*     */   private static double min(double d1, double d2) {
/* 271 */     if (Double.isNaN(d1)) {
/* 272 */       return d2;
/*     */     }
/* 274 */     if (Double.isNaN(d2)) {
/* 275 */       return d1;
/*     */     }
/* 277 */     return Math.min(d1, d2);
/*     */   }
/*     */   
/*     */   private static double max(double d1, double d2) {
/* 281 */     if (Double.isNaN(d1)) {
/* 282 */       return d2;
/*     */     }
/* 284 */     if (Double.isNaN(d2)) {
/* 285 */       return d1;
/*     */     }
/* 287 */     return Math.max(d1, d2);
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
/*     */   public static Range expandToInclude(Range range, double value) {
/* 302 */     if (range == null) {
/* 303 */       return new Range(value, value);
/*     */     }
/* 305 */     if (value < range.getLowerBound()) {
/* 306 */       return new Range(value, range.getUpperBound());
/*     */     }
/* 308 */     if (value > range.getUpperBound()) {
/* 309 */       return new Range(range.getLowerBound(), value);
/*     */     }
/*     */     
/* 312 */     return range;
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
/*     */   public static Range expand(Range range, double lowerMargin, double upperMargin) {
/* 329 */     ParamChecks.nullNotPermitted(range, "range");
/* 330 */     double length = range.getLength();
/* 331 */     double lower = range.getLowerBound() - length * lowerMargin;
/* 332 */     double upper = range.getUpperBound() + length * upperMargin;
/* 333 */     if (lower > upper) {
/* 334 */       lower = lower / 2.0D + upper / 2.0D;
/* 335 */       upper = lower;
/*     */     } 
/* 337 */     return new Range(lower, upper);
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
/* 349 */   public static Range shift(Range base, double delta) { return shift(base, delta, false); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Range shift(Range base, double delta, boolean allowZeroCrossing) {
/* 365 */     ParamChecks.nullNotPermitted(base, "base");
/* 366 */     if (allowZeroCrossing) {
/* 367 */       return new Range(base.getLowerBound() + delta, base
/* 368 */           .getUpperBound() + delta);
/*     */     }
/*     */     
/* 371 */     return new Range(shiftWithNoZeroCrossing(base.getLowerBound(), delta), 
/* 372 */         shiftWithNoZeroCrossing(base.getUpperBound(), delta));
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
/*     */   private static double shiftWithNoZeroCrossing(double value, double delta) {
/* 387 */     if (value > 0.0D) {
/* 388 */       return Math.max(value + delta, 0.0D);
/*     */     }
/* 390 */     if (value < 0.0D) {
/* 391 */       return Math.min(value + delta, 0.0D);
/*     */     }
/*     */     
/* 394 */     return value + delta;
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
/*     */   public static Range scale(Range base, double factor) {
/* 409 */     ParamChecks.nullNotPermitted(base, "base");
/* 410 */     if (factor < 0.0D) {
/* 411 */       throw new IllegalArgumentException("Negative 'factor' argument.");
/*     */     }
/* 413 */     return new Range(base.getLowerBound() * factor, base
/* 414 */         .getUpperBound() * factor);
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
/*     */   public boolean equals(Object obj) {
/* 426 */     if (!(obj instanceof Range)) {
/* 427 */       return false;
/*     */     }
/* 429 */     Range range = (Range)obj;
/* 430 */     if (this.lower != range.lower) {
/* 431 */       return false;
/*     */     }
/* 433 */     if (this.upper != range.upper) {
/* 434 */       return false;
/*     */     }
/* 436 */     return true;
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
/* 448 */   public boolean isNaNRange() { return (Double.isNaN(this.lower) && Double.isNaN(this.upper)); }
/*     */ 
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
/* 460 */     long temp = Double.doubleToLongBits(this.lower);
/* 461 */     result = (int)(temp ^ temp >>> 32);
/* 462 */     temp = Double.doubleToLongBits(this.upper);
/* 463 */     return 29 * result + (int)(temp ^ temp >>> 32);
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
/* 475 */   public String toString() { return "Range[" + this.lower + "," + this.upper + "]"; }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/Range.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */