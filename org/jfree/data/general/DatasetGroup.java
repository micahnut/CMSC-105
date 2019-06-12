/*     */ package org.jfree.data.general;
/*     */ 
/*     */ import java.io.Serializable;
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
/*     */ public class DatasetGroup
/*     */   implements Cloneable, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -3640642179674185688L;
/*     */   private String id;
/*     */   
/*  66 */   public DatasetGroup() { this.id = "NOID"; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DatasetGroup(String id) {
/*  75 */     ParamChecks.nullNotPermitted(id, "id");
/*  76 */     this.id = id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  85 */   public String getID() { return this.id; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  97 */   public Object clone() throws CloneNotSupportedException { return super.clone(); }
/*     */ 
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
/* 109 */     if (obj == this) {
/* 110 */       return true;
/*     */     }
/* 112 */     if (!(obj instanceof DatasetGroup)) {
/* 113 */       return false;
/*     */     }
/* 115 */     DatasetGroup that = (DatasetGroup)obj;
/* 116 */     if (!this.id.equals(that.id)) {
/* 117 */       return false;
/*     */     }
/* 119 */     return true;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/general/DatasetGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */