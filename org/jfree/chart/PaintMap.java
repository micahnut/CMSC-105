/*     */ package org.jfree.chart;
/*     */ 
/*     */ import java.awt.Paint;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.jfree.chart.util.ParamChecks;
/*     */ import org.jfree.io.SerialUtilities;
/*     */ import org.jfree.util.PaintUtilities;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PaintMap
/*     */   implements Cloneable, Serializable
/*     */ {
/*     */   static final long serialVersionUID = -4639833772123069274L;
/*     */   private Map store;
/*     */   
/*  82 */   public PaintMap() { this.store = new HashMap(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Paint getPaint(Comparable key) {
/*  97 */     ParamChecks.nullNotPermitted(key, "key");
/*  98 */     return (Paint)this.store.get(key);
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
/* 111 */   public boolean containsKey(Comparable key) { return this.store.containsKey(key); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void put(Comparable key, Paint paint) {
/* 125 */     ParamChecks.nullNotPermitted(key, "key");
/* 126 */     this.store.put(key, paint);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 133 */   public void clear() { this.store.clear(); }
/*     */ 
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
/* 145 */     if (obj == this) {
/* 146 */       return true;
/*     */     }
/* 148 */     if (!(obj instanceof PaintMap)) {
/* 149 */       return false;
/*     */     }
/* 151 */     PaintMap that = (PaintMap)obj;
/* 152 */     if (this.store.size() != that.store.size()) {
/* 153 */       return false;
/*     */     }
/* 155 */     Set keys = this.store.keySet();
/* 156 */     Iterator iterator = keys.iterator();
/* 157 */     while (iterator.hasNext()) {
/* 158 */       Comparable key = (Comparable)iterator.next();
/* 159 */       Paint p1 = getPaint(key);
/* 160 */       Paint p2 = that.getPaint(key);
/* 161 */       if (!PaintUtilities.equal(p1, p2)) {
/* 162 */         return false;
/*     */       }
/*     */     } 
/* 165 */     return true;
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
/* 177 */     PaintMap clone = (PaintMap)super.clone();
/* 178 */     clone.store = new HashMap();
/* 179 */     clone.store.putAll(this.store);
/*     */ 
/*     */     
/* 182 */     return clone;
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
/* 193 */     stream.defaultWriteObject();
/* 194 */     stream.writeInt(this.store.size());
/* 195 */     Set keys = this.store.keySet();
/* 196 */     Iterator iterator = keys.iterator();
/* 197 */     while (iterator.hasNext()) {
/* 198 */       Comparable key = (Comparable)iterator.next();
/* 199 */       stream.writeObject(key);
/* 200 */       Paint paint = getPaint(key);
/* 201 */       SerialUtilities.writePaint(paint, stream);
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
/* 215 */     stream.defaultReadObject();
/* 216 */     this.store = new HashMap();
/* 217 */     int keyCount = stream.readInt();
/* 218 */     for (int i = 0; i < keyCount; i++) {
/* 219 */       Comparable key = (Comparable)stream.readObject();
/* 220 */       Paint paint = SerialUtilities.readPaint(stream);
/* 221 */       this.store.put(key, paint);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/PaintMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */