/*     */ package org.jfree.data;
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
/*     */ public class ComparableObjectItem
/*     */   implements Cloneable, Comparable, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 2751513470325494890L;
/*     */   private Comparable x;
/*     */   private Object obj;
/*     */   
/*     */   public ComparableObjectItem(Comparable x, Object y) {
/*  74 */     ParamChecks.nullNotPermitted(x, "x");
/*  75 */     this.x = x;
/*  76 */     this.obj = y;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  85 */   protected Comparable getComparable() { return this.x; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  94 */   protected Object getObject() { return this.obj; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 104 */   protected void setObject(Object y) { this.obj = y; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 126 */     if (o1 instanceof ComparableObjectItem) {
/* 127 */       ComparableObjectItem that = (ComparableObjectItem)o1;
/* 128 */       return this.x.compareTo(that.x);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 135 */     return 1;
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
/* 152 */   public Object clone() { return super.clone(); }
/*     */ 
/*     */ 
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
/* 165 */     if (obj == this) {
/* 166 */       return true;
/*     */     }
/* 168 */     if (!(obj instanceof ComparableObjectItem)) {
/* 169 */       return false;
/*     */     }
/* 171 */     ComparableObjectItem that = (ComparableObjectItem)obj;
/* 172 */     if (!this.x.equals(that.x)) {
/* 173 */       return false;
/*     */     }
/* 175 */     if (!ObjectUtilities.equal(this.obj, that.obj)) {
/* 176 */       return false;
/*     */     }
/* 178 */     return true;
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
/* 189 */     result = this.x.hashCode();
/* 190 */     return 29 * result + ((this.obj != null) ? this.obj.hashCode() : 0);
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/ComparableObjectItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */