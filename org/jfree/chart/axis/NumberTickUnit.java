/*     */ package org.jfree.chart.axis;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.text.NumberFormat;
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
/*     */ public class NumberTickUnit
/*     */   extends TickUnit
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 3849459506627654442L;
/*     */   private NumberFormat formatter;
/*     */   
/*  73 */   public NumberTickUnit(double size) { this(size, NumberFormat.getNumberInstance()); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NumberTickUnit(double size, NumberFormat formatter) {
/*  84 */     super(size);
/*  85 */     ParamChecks.nullNotPermitted(formatter, "formatter");
/*  86 */     this.formatter = formatter;
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
/*     */   public NumberTickUnit(double size, NumberFormat formatter, int minorTickCount) {
/* 101 */     super(size, minorTickCount);
/* 102 */     ParamChecks.nullNotPermitted(formatter, "formatter");
/* 103 */     this.formatter = formatter;
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
/* 115 */   public String valueToString(double value) { return this.formatter.format(value); }
/*     */ 
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
/* 127 */     if (obj == this) {
/* 128 */       return true;
/*     */     }
/* 130 */     if (!(obj instanceof NumberTickUnit)) {
/* 131 */       return false;
/*     */     }
/* 133 */     if (!super.equals(obj)) {
/* 134 */       return false;
/*     */     }
/* 136 */     NumberTickUnit that = (NumberTickUnit)obj;
/* 137 */     if (!this.formatter.equals(that.formatter)) {
/* 138 */       return false;
/*     */     }
/* 140 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 150 */   public String toString() { return "[size=" + valueToString(getSize()) + "]"; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 160 */     result = super.hashCode();
/*     */     
/* 162 */     return 29 * result + ((this.formatter != null) ? this.formatter.hashCode() : 0);
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/axis/NumberTickUnit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */