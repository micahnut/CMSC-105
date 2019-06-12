/*     */ package org.jfree.chart.axis;
/*     */ 
/*     */ import org.jfree.text.TextBlock;
/*     */ import org.jfree.text.TextBlockAnchor;
/*     */ import org.jfree.ui.TextAnchor;
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
/*     */ public class CategoryTick
/*     */   extends Tick
/*     */ {
/*     */   private Comparable category;
/*     */   private TextBlock label;
/*     */   private TextBlockAnchor labelAnchor;
/*     */   
/*     */   public CategoryTick(Comparable category, TextBlock label, TextBlockAnchor labelAnchor, TextAnchor rotationAnchor, double angle) {
/*  78 */     super("", TextAnchor.CENTER, rotationAnchor, angle);
/*  79 */     this.category = category;
/*  80 */     this.label = label;
/*  81 */     this.labelAnchor = labelAnchor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  91 */   public Comparable getCategory() { return this.category; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 100 */   public TextBlock getLabel() { return this.label; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 109 */   public TextBlockAnchor getLabelAnchor() { return this.labelAnchor; }
/*     */ 
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
/* 121 */     if (this == obj) {
/* 122 */       return true;
/*     */     }
/* 124 */     if (obj instanceof CategoryTick && super.equals(obj)) {
/* 125 */       CategoryTick that = (CategoryTick)obj;
/* 126 */       if (!ObjectUtilities.equal(this.category, that.category)) {
/* 127 */         return false;
/*     */       }
/* 129 */       if (!ObjectUtilities.equal(this.label, that.label)) {
/* 130 */         return false;
/*     */       }
/* 132 */       if (!ObjectUtilities.equal(this.labelAnchor, that.labelAnchor)) {
/* 133 */         return false;
/*     */       }
/* 135 */       return true;
/*     */     } 
/* 137 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 147 */     result = 41;
/* 148 */     result = 37 * result + this.category.hashCode();
/* 149 */     result = 37 * result + this.label.hashCode();
/* 150 */     return 37 * result + this.labelAnchor.hashCode();
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/axis/CategoryTick.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */