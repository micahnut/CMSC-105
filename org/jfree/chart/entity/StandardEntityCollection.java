/*     */ package org.jfree.chart.entity;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.jfree.chart.util.ParamChecks;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class StandardEntityCollection
/*     */   implements EntityCollection, Cloneable, PublicCloneable, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 5384773031184897047L;
/*     */   private List entities;
/*     */   
/*  79 */   public StandardEntityCollection() { this.entities = new ArrayList(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  89 */   public int getEntityCount() { return this.entities.size(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 103 */   public ChartEntity getEntity(int index) { return (ChartEntity)this.entities.get(index); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 111 */   public void clear() { this.entities.clear(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(ChartEntity entity) {
/* 121 */     ParamChecks.nullNotPermitted(entity, "entity");
/* 122 */     this.entities.add(entity);
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
/* 133 */   public void addAll(EntityCollection collection) { this.entities.addAll(collection.getEntities()); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ChartEntity getEntity(double x, double y) {
/* 147 */     int entityCount = this.entities.size();
/* 148 */     for (int i = entityCount - 1; i >= 0; i--) {
/* 149 */       ChartEntity entity = (ChartEntity)this.entities.get(i);
/* 150 */       if (entity.getArea().contains(x, y)) {
/* 151 */         return entity;
/*     */       }
/*     */     } 
/* 154 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 164 */   public Collection getEntities() { return Collections.unmodifiableCollection(this.entities); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 174 */   public Iterator iterator() { return this.entities.iterator(); }
/*     */ 
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
/* 186 */     if (obj == this) {
/* 187 */       return true;
/*     */     }
/* 189 */     if (obj instanceof StandardEntityCollection) {
/* 190 */       StandardEntityCollection that = (StandardEntityCollection)obj;
/* 191 */       return ObjectUtilities.equal(this.entities, that.entities);
/*     */     } 
/* 193 */     return false;
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
/*     */   public Object clone() throws CloneNotSupportedException {
/* 206 */     StandardEntityCollection clone = (StandardEntityCollection)super.clone();
/* 207 */     clone.entities = new ArrayList(this.entities.size());
/* 208 */     for (int i = 0; i < this.entities.size(); i++) {
/* 209 */       ChartEntity entity = (ChartEntity)this.entities.get(i);
/* 210 */       clone.entities.add(entity.clone());
/*     */     } 
/* 212 */     return clone;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/entity/StandardEntityCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */