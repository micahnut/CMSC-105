/*     */ package org.jfree.data.xy;
/*     */ 
/*     */ import java.io.Serializable;
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
/*     */ public class XYDataItem
/*     */   implements Cloneable, Comparable, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 2751513470325494890L;
/*     */   private Number x;
/*     */   private Number y;
/*     */   
/*     */   public XYDataItem(Number x, Number y) {
/*  77 */     ParamChecks.nullNotPermitted(x, "x");
/*  78 */     this.x = x;
/*  79 */     this.y = y;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  89 */   public XYDataItem(double x, double y) { this(new Double(x), new Double(y)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  98 */   public Number getX() { return this.x; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 113 */   public double getXValue() { return this.x.doubleValue(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 122 */   public Number getY() { return this.y; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getYValue() {
/* 136 */     double result = NaND;
/* 137 */     if (this.y != null) {
/* 138 */       result = this.y.doubleValue();
/*     */     }
/* 140 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 150 */   public void setY(double y) { setY(new Double(y)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 160 */   public void setY(Number y) { this.y = y; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 182 */     if (o1 instanceof XYDataItem) {
/* 183 */       XYDataItem dataItem = (XYDataItem)o1;
/*     */       
/* 185 */       double compare = this.x.doubleValue() - dataItem.getX().doubleValue();
/* 186 */       if (compare > 0.0D) {
/* 187 */         result = 1;
/*     */       
/*     */       }
/* 190 */       else if (compare < 0.0D) {
/* 191 */         result = -1;
/*     */       } else {
/*     */         
/* 194 */         result = 0;
/*     */       
/*     */       }
/*     */ 
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */       
/* 203 */       result = 1;
/*     */     } 
/*     */     
/* 206 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object clone() {
/* 217 */     Object clone = null;
/*     */     try {
/* 219 */       clone = super.clone();
/*     */     }
/* 221 */     catch (CloneNotSupportedException e) {
/* 222 */       e.printStackTrace();
/*     */     } 
/* 224 */     return clone;
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
/* 237 */     if (obj == this) {
/* 238 */       return true;
/*     */     }
/* 240 */     if (!(obj instanceof XYDataItem)) {
/* 241 */       return false;
/*     */     }
/* 243 */     XYDataItem that = (XYDataItem)obj;
/* 244 */     if (!this.x.equals(that.x)) {
/* 245 */       return false;
/*     */     }
/* 247 */     if (!ObjectUtilities.equal(this.y, that.y)) {
/* 248 */       return false;
/*     */     }
/* 250 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 261 */     result = this.x.hashCode();
/* 262 */     return 29 * result + ((this.y != null) ? this.y.hashCode() : 0);
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
/* 274 */   public String toString() { return "[" + getXValue() + ", " + getYValue() + "]"; }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/xy/XYDataItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */