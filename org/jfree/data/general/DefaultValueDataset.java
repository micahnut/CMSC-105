/*     */ package org.jfree.data.general;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import org.jfree.util.ObjectUtilities;
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
/*     */ public class DefaultValueDataset
/*     */   extends AbstractDataset
/*     */   implements ValueDataset, Cloneable, PublicCloneable, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 8137521217249294891L;
/*     */   private Number value;
/*     */   
/*  70 */   public DefaultValueDataset() { this(null); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  79 */   public DefaultValueDataset(double value) { this(new Double(value)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  89 */   public DefaultValueDataset(Number value) { this.value = value; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  99 */   public Number getValue() { return this.value; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(Number value) {
/* 109 */     this.value = value;
/* 110 */     notifyListeners(new DatasetChangeEvent(this, this));
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
/* 122 */     if (obj == this) {
/* 123 */       return true;
/*     */     }
/* 125 */     if (obj instanceof ValueDataset) {
/* 126 */       ValueDataset vd = (ValueDataset)obj;
/* 127 */       return ObjectUtilities.equal(this.value, vd.getValue());
/*     */     } 
/* 129 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 139 */   public int hashCode() { return (this.value != null) ? this.value.hashCode() : 0; }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/general/DefaultValueDataset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */