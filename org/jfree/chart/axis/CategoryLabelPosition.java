/*     */ package org.jfree.chart.axis;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import org.jfree.chart.util.ParamChecks;
/*     */ import org.jfree.text.TextBlockAnchor;
/*     */ import org.jfree.ui.RectangleAnchor;
/*     */ import org.jfree.ui.TextAnchor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CategoryLabelPosition
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 5168681143844183864L;
/*     */   private RectangleAnchor categoryAnchor;
/*     */   private TextBlockAnchor labelAnchor;
/*     */   private TextAnchor rotationAnchor;
/*     */   private double angle;
/*     */   private CategoryLabelWidthType widthType;
/*     */   private float widthRatio;
/*     */   
/*  91 */   public CategoryLabelPosition() { this(RectangleAnchor.CENTER, TextBlockAnchor.BOTTOM_CENTER, TextAnchor.CENTER, 0.0D, CategoryLabelWidthType.CATEGORY, 0.95F); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 105 */   public CategoryLabelPosition(RectangleAnchor categoryAnchor, TextBlockAnchor labelAnchor) { this(categoryAnchor, labelAnchor, TextAnchor.CENTER, 0.0D, CategoryLabelWidthType.CATEGORY, 0.95F); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 123 */   public CategoryLabelPosition(RectangleAnchor categoryAnchor, TextBlockAnchor labelAnchor, CategoryLabelWidthType widthType, float widthRatio) { this(categoryAnchor, labelAnchor, TextAnchor.CENTER, 0.0D, widthType, widthRatio); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CategoryLabelPosition(RectangleAnchor categoryAnchor, TextBlockAnchor labelAnchor, TextAnchor rotationAnchor, double angle, CategoryLabelWidthType widthType, float widthRatio) {
/* 147 */     ParamChecks.nullNotPermitted(categoryAnchor, "categoryAnchor");
/* 148 */     ParamChecks.nullNotPermitted(labelAnchor, "labelAnchor");
/* 149 */     ParamChecks.nullNotPermitted(rotationAnchor, "rotationAnchor");
/* 150 */     ParamChecks.nullNotPermitted(widthType, "widthType");
/*     */     
/* 152 */     this.categoryAnchor = categoryAnchor;
/* 153 */     this.labelAnchor = labelAnchor;
/* 154 */     this.rotationAnchor = rotationAnchor;
/* 155 */     this.angle = angle;
/* 156 */     this.widthType = widthType;
/* 157 */     this.widthRatio = widthRatio;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 167 */   public RectangleAnchor getCategoryAnchor() { return this.categoryAnchor; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 176 */   public TextBlockAnchor getLabelAnchor() { return this.labelAnchor; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 185 */   public TextAnchor getRotationAnchor() { return this.rotationAnchor; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 194 */   public double getAngle() { return this.angle; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 203 */   public CategoryLabelWidthType getWidthType() { return this.widthType; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 212 */   public float getWidthRatio() { return this.widthRatio; }
/*     */ 
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
/* 224 */     if (obj == this) {
/* 225 */       return true;
/*     */     }
/* 227 */     if (!(obj instanceof CategoryLabelPosition)) {
/* 228 */       return false;
/*     */     }
/* 230 */     CategoryLabelPosition that = (CategoryLabelPosition)obj;
/* 231 */     if (!this.categoryAnchor.equals(that.categoryAnchor)) {
/* 232 */       return false;
/*     */     }
/* 234 */     if (!this.labelAnchor.equals(that.labelAnchor)) {
/* 235 */       return false;
/*     */     }
/* 237 */     if (!this.rotationAnchor.equals(that.rotationAnchor)) {
/* 238 */       return false;
/*     */     }
/* 240 */     if (this.angle != that.angle) {
/* 241 */       return false;
/*     */     }
/* 243 */     if (this.widthType != that.widthType) {
/* 244 */       return false;
/*     */     }
/* 246 */     if (this.widthRatio != that.widthRatio) {
/* 247 */       return false;
/*     */     }
/* 249 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 259 */     result = 19;
/* 260 */     result = 37 * result + this.categoryAnchor.hashCode();
/* 261 */     result = 37 * result + this.labelAnchor.hashCode();
/* 262 */     return 37 * result + this.rotationAnchor.hashCode();
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/axis/CategoryLabelPosition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */