/*     */ package org.jfree.chart;
/*     */ 
/*     */ import java.awt.Stroke;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.TreeMap;
/*     */ import org.jfree.chart.util.ParamChecks;
/*     */ import org.jfree.io.SerialUtilities;
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
/*     */ public class StrokeMap
/*     */   implements Cloneable, Serializable
/*     */ {
/*     */   static final long serialVersionUID = -8148916785963525169L;
/*     */   private Map store;
/*     */   
/*  80 */   public StrokeMap() { this.store = new TreeMap(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Stroke getStroke(Comparable key) {
/*  95 */     ParamChecks.nullNotPermitted(key, "key");
/*  96 */     return (Stroke)this.store.get(key);
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
/* 109 */   public boolean containsKey(Comparable key) { return this.store.containsKey(key); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void put(Comparable key, Stroke stroke) {
/* 120 */     ParamChecks.nullNotPermitted(key, "key");
/* 121 */     this.store.put(key, stroke);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 128 */   public void clear() { this.store.clear(); }
/*     */ 
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
/* 140 */     if (obj == this) {
/* 141 */       return true;
/*     */     }
/* 143 */     if (!(obj instanceof StrokeMap)) {
/* 144 */       return false;
/*     */     }
/* 146 */     StrokeMap that = (StrokeMap)obj;
/* 147 */     if (this.store.size() != that.store.size()) {
/* 148 */       return false;
/*     */     }
/* 150 */     Set keys = this.store.keySet();
/* 151 */     Iterator iterator = keys.iterator();
/* 152 */     while (iterator.hasNext()) {
/* 153 */       Comparable key = (Comparable)iterator.next();
/* 154 */       Stroke s1 = getStroke(key);
/* 155 */       Stroke s2 = that.getStroke(key);
/* 156 */       if (!ObjectUtilities.equal(s1, s2)) {
/* 157 */         return false;
/*     */       }
/*     */     } 
/* 160 */     return true;
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
/*     */   public Object clone() throws CloneNotSupportedException {
/* 172 */     StrokeMap clone = (StrokeMap)super.clone();
/* 173 */     clone.store = new TreeMap();
/* 174 */     clone.store.putAll(this.store);
/*     */ 
/*     */     
/* 177 */     return clone;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void writeObject(ObjectOutputStream stream) throws IOException {
/* 188 */     stream.defaultWriteObject();
/* 189 */     stream.writeInt(this.store.size());
/* 190 */     Set keys = this.store.keySet();
/* 191 */     Iterator iterator = keys.iterator();
/* 192 */     while (iterator.hasNext()) {
/* 193 */       Comparable key = (Comparable)iterator.next();
/* 194 */       stream.writeObject(key);
/* 195 */       Stroke stroke = getStroke(key);
/* 196 */       SerialUtilities.writeStroke(stroke, stream);
/*     */     } 
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
/*     */   private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
/* 210 */     stream.defaultReadObject();
/* 211 */     this.store = new TreeMap();
/* 212 */     int keyCount = stream.readInt();
/* 213 */     for (int i = 0; i < keyCount; i++) {
/* 214 */       Comparable key = (Comparable)stream.readObject();
/* 215 */       Stroke stroke = SerialUtilities.readStroke(stream);
/* 216 */       this.store.put(key, stroke);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/StrokeMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */