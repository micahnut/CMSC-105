/*     */ package org.jfree.chart.block;
/*     */ 
/*     */ import org.jfree.chart.util.ParamChecks;
/*     */ import org.jfree.data.Range;
/*     */ import org.jfree.ui.Size2D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RectangleConstraint
/*     */ {
/*  60 */   public static final RectangleConstraint NONE = new RectangleConstraint(0.0D, null, LengthConstraintType.NONE, 0.0D, null, LengthConstraintType.NONE);
/*     */ 
/*     */ 
/*     */   
/*     */   private double width;
/*     */ 
/*     */ 
/*     */   
/*     */   private Range widthRange;
/*     */ 
/*     */ 
/*     */   
/*     */   private LengthConstraintType widthConstraintType;
/*     */ 
/*     */ 
/*     */   
/*     */   private double height;
/*     */ 
/*     */ 
/*     */   
/*     */   private Range heightRange;
/*     */ 
/*     */ 
/*     */   
/*     */   private LengthConstraintType heightConstraintType;
/*     */ 
/*     */ 
/*     */   
/*  88 */   public RectangleConstraint(double w, double h) { this(w, null, LengthConstraintType.FIXED, h, null, LengthConstraintType.FIXED); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  99 */   public RectangleConstraint(Range w, Range h) { this(0.0D, w, LengthConstraintType.RANGE, 0.0D, h, LengthConstraintType.RANGE); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 111 */   public RectangleConstraint(Range w, double h) { this(0.0D, w, LengthConstraintType.RANGE, h, null, LengthConstraintType.FIXED); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 123 */   public RectangleConstraint(double w, Range h) { this(w, null, LengthConstraintType.FIXED, 0.0D, h, LengthConstraintType.RANGE); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RectangleConstraint(double w, Range widthRange, LengthConstraintType widthConstraintType, double h, Range heightRange, LengthConstraintType heightConstraintType) {
/* 141 */     ParamChecks.nullNotPermitted(widthConstraintType, "widthConstraintType");
/* 142 */     ParamChecks.nullNotPermitted(heightConstraintType, "heightConstraintType");
/* 143 */     this.width = w;
/* 144 */     this.widthRange = widthRange;
/* 145 */     this.widthConstraintType = widthConstraintType;
/* 146 */     this.height = h;
/* 147 */     this.heightRange = heightRange;
/* 148 */     this.heightConstraintType = heightConstraintType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 157 */   public double getWidth() { return this.width; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 166 */   public Range getWidthRange() { return this.widthRange; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 175 */   public LengthConstraintType getWidthConstraintType() { return this.widthConstraintType; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 184 */   public double getHeight() { return this.height; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 193 */   public Range getHeightRange() { return this.heightRange; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 202 */   public LengthConstraintType getHeightConstraintType() { return this.heightConstraintType; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RectangleConstraint toUnconstrainedWidth() {
/* 212 */     if (this.widthConstraintType == LengthConstraintType.NONE) {
/* 213 */       return this;
/*     */     }
/*     */     
/* 216 */     return new RectangleConstraint(this.width, this.widthRange, LengthConstraintType.NONE, this.height, this.heightRange, this.heightConstraintType);
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
/*     */   public RectangleConstraint toUnconstrainedHeight() {
/* 229 */     if (this.heightConstraintType == LengthConstraintType.NONE) {
/* 230 */       return this;
/*     */     }
/*     */     
/* 233 */     return new RectangleConstraint(this.width, this.widthRange, this.widthConstraintType, 0.0D, this.heightRange, LengthConstraintType.NONE);
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
/* 248 */   public RectangleConstraint toFixedWidth(double width) { return new RectangleConstraint(width, this.widthRange, LengthConstraintType.FIXED, this.height, this.heightRange, this.heightConstraintType); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 262 */   public RectangleConstraint toFixedHeight(double height) { return new RectangleConstraint(this.width, this.widthRange, this.widthConstraintType, height, this.heightRange, LengthConstraintType.FIXED); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RectangleConstraint toRangeWidth(Range range) {
/* 276 */     ParamChecks.nullNotPermitted(range, "range");
/* 277 */     return new RectangleConstraint(range.getUpperBound(), range, LengthConstraintType.RANGE, this.height, this.heightRange, this.heightConstraintType);
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
/*     */   public RectangleConstraint toRangeHeight(Range range) {
/* 291 */     ParamChecks.nullNotPermitted(range, "range");
/* 292 */     return new RectangleConstraint(this.width, this.widthRange, this.widthConstraintType, range
/* 293 */         .getUpperBound(), range, LengthConstraintType.RANGE);
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
/*     */   public String toString() {
/* 305 */     return "RectangleConstraint[" + this.widthConstraintType
/* 306 */       .toString() + ": width=" + this.width + ", height=" + this.height + "]";
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
/*     */   public Size2D calculateConstrainedSize(Size2D base) {
/* 319 */     Size2D result = new Size2D();
/* 320 */     if (this.widthConstraintType == LengthConstraintType.NONE) {
/* 321 */       result.width = base.width;
/* 322 */       if (this.heightConstraintType == LengthConstraintType.NONE) {
/* 323 */         result.height = base.height;
/*     */       }
/* 325 */       else if (this.heightConstraintType == LengthConstraintType.RANGE) {
/* 326 */         result.height = this.heightRange.constrain(base.height);
/*     */       }
/* 328 */       else if (this.heightConstraintType == LengthConstraintType.FIXED) {
/* 329 */         result.height = this.height;
/*     */       }
/*     */     
/* 332 */     } else if (this.widthConstraintType == LengthConstraintType.RANGE) {
/* 333 */       result.width = this.widthRange.constrain(base.width);
/* 334 */       if (this.heightConstraintType == LengthConstraintType.NONE) {
/* 335 */         result.height = base.height;
/*     */       }
/* 337 */       else if (this.heightConstraintType == LengthConstraintType.RANGE) {
/* 338 */         result.height = this.heightRange.constrain(base.height);
/*     */       }
/* 340 */       else if (this.heightConstraintType == LengthConstraintType.FIXED) {
/* 341 */         result.height = this.height;
/*     */       }
/*     */     
/* 344 */     } else if (this.widthConstraintType == LengthConstraintType.FIXED) {
/* 345 */       result.width = this.width;
/* 346 */       if (this.heightConstraintType == LengthConstraintType.NONE) {
/* 347 */         result.height = base.height;
/*     */       }
/* 349 */       else if (this.heightConstraintType == LengthConstraintType.RANGE) {
/* 350 */         result.height = this.heightRange.constrain(base.height);
/*     */       }
/* 352 */       else if (this.heightConstraintType == LengthConstraintType.FIXED) {
/* 353 */         result.height = this.height;
/*     */       } 
/*     */     } 
/* 356 */     return result;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/block/RectangleConstraint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */