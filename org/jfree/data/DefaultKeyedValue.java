/*     */ package org.jfree.data;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import org.jfree.chart.util.ParamChecks;
/*     */ import org.jfree.util.PublicCloneable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DefaultKeyedValue
/*     */   implements KeyedValue, Cloneable, PublicCloneable, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -7388924517460437712L;
/*     */   private Comparable key;
/*     */   private Number value;
/*     */   
/*     */   public DefaultKeyedValue(Comparable key, Number value) {
/*  81 */     ParamChecks.nullNotPermitted(key, "key");
/*  82 */     this.key = key;
/*  83 */     this.value = value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  93 */   public Comparable getKey() { return this.key; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 103 */   public Number getValue() { return this.value; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 112 */   public void setValue(Number value) { this.value = value; }
/*     */ 
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
/* 124 */     if (obj == this) {
/* 125 */       return true;
/*     */     }
/* 127 */     if (!(obj instanceof DefaultKeyedValue)) {
/* 128 */       return false;
/*     */     }
/* 130 */     DefaultKeyedValue that = (DefaultKeyedValue)obj;
/*     */     
/* 132 */     if (!this.key.equals(that.key)) {
/* 133 */       return false;
/*     */     }
/* 135 */     if ((this.value != null) ? 
/* 136 */       !this.value.equals(that.value) : (that.value != null)) {
/* 137 */       return false;
/*     */     }
/* 139 */     return true;
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
/* 150 */     result = (this.key != null) ? this.key.hashCode() : 0;
/* 151 */     return 29 * result + ((this.value != null) ? this.value.hashCode() : 0);
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
/* 167 */   public Object clone() throws CloneNotSupportedException { return (DefaultKeyedValue)super.clone(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 178 */   public String toString() { return "(" + this.key.toString() + ", " + this.value.toString() + ")"; }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/DefaultKeyedValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */