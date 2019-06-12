/*     */ package org.jfree.chart.labels;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import org.jfree.chart.util.ParamChecks;
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
/*     */ public class ItemLabelPosition
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 5845390630157034499L;
/*     */   private ItemLabelAnchor itemLabelAnchor;
/*     */   private TextAnchor textAnchor;
/*     */   private TextAnchor rotationAnchor;
/*     */   private double angle;
/*     */   
/*  77 */   public ItemLabelPosition() { this(ItemLabelAnchor.OUTSIDE12, TextAnchor.BOTTOM_CENTER, TextAnchor.CENTER, 0.0D); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  90 */   public ItemLabelPosition(ItemLabelAnchor itemLabelAnchor, TextAnchor textAnchor) { this(itemLabelAnchor, textAnchor, TextAnchor.CENTER, 0.0D); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemLabelPosition(ItemLabelAnchor itemLabelAnchor, TextAnchor textAnchor, TextAnchor rotationAnchor, double angle) {
/* 109 */     ParamChecks.nullNotPermitted(itemLabelAnchor, "itemLabelAnchor");
/* 110 */     ParamChecks.nullNotPermitted(textAnchor, "textAnchor");
/* 111 */     ParamChecks.nullNotPermitted(rotationAnchor, "rotationAnchor");
/* 112 */     this.itemLabelAnchor = itemLabelAnchor;
/* 113 */     this.textAnchor = textAnchor;
/* 114 */     this.rotationAnchor = rotationAnchor;
/* 115 */     this.angle = angle;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 124 */   public ItemLabelAnchor getItemLabelAnchor() { return this.itemLabelAnchor; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 133 */   public TextAnchor getTextAnchor() { return this.textAnchor; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 142 */   public TextAnchor getRotationAnchor() { return this.rotationAnchor; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 151 */   public double getAngle() { return this.angle; }
/*     */ 
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
/* 163 */     if (obj == this) {
/* 164 */       return true;
/*     */     }
/* 166 */     if (!(obj instanceof ItemLabelPosition)) {
/* 167 */       return false;
/*     */     }
/* 169 */     ItemLabelPosition that = (ItemLabelPosition)obj;
/* 170 */     if (!this.itemLabelAnchor.equals(that.itemLabelAnchor)) {
/* 171 */       return false;
/*     */     }
/* 173 */     if (!this.textAnchor.equals(that.textAnchor)) {
/* 174 */       return false;
/*     */     }
/* 176 */     if (!this.rotationAnchor.equals(that.rotationAnchor)) {
/* 177 */       return false;
/*     */     }
/* 179 */     if (this.angle != that.angle) {
/* 180 */       return false;
/*     */     }
/* 182 */     return true;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/labels/ItemLabelPosition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */