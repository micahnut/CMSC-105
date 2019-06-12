/*     */ package org.jfree.data;
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
/*     */ public class KeyedObject
/*     */   implements Cloneable, PublicCloneable, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 2677930479256885863L;
/*     */   private Comparable key;
/*     */   private Object object;
/*     */   
/*     */   public KeyedObject(Comparable key, Object object) {
/*  71 */     this.key = key;
/*  72 */     this.object = object;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  81 */   public Comparable getKey() { return this.key; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  90 */   public Object getObject() { return this.object; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  99 */   public void setObject(Object object) { this.object = object; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object clone() {
/* 114 */     KeyedObject clone = (KeyedObject)super.clone();
/* 115 */     if (this.object instanceof PublicCloneable) {
/* 116 */       PublicCloneable pc = (PublicCloneable)this.object;
/* 117 */       clone.object = pc.clone();
/*     */     } 
/* 119 */     return clone;
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
/* 132 */     if (obj == this) {
/* 133 */       return true;
/*     */     }
/*     */     
/* 136 */     if (!(obj instanceof KeyedObject)) {
/* 137 */       return false;
/*     */     }
/* 139 */     KeyedObject that = (KeyedObject)obj;
/* 140 */     if (!ObjectUtilities.equal(this.key, that.key)) {
/* 141 */       return false;
/*     */     }
/*     */     
/* 144 */     if (!ObjectUtilities.equal(this.object, that.object)) {
/* 145 */       return false;
/*     */     }
/*     */     
/* 148 */     return true;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/KeyedObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */