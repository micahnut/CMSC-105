/*     */ package org.jfree.data;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import org.jfree.chart.util.ParamChecks;
/*     */ import org.jfree.util.PublicCloneable;
/*     */ import org.jfree.util.SortOrder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DefaultKeyedValues
/*     */   implements KeyedValues, Cloneable, PublicCloneable, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 8468154364608194797L;
/*     */   private ArrayList keys;
/*     */   private ArrayList values;
/*     */   private HashMap indexMap;
/*     */   
/*     */   public DefaultKeyedValues() {
/* 100 */     this.keys = new ArrayList();
/* 101 */     this.values = new ArrayList();
/* 102 */     this.indexMap = new HashMap();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 112 */   public int getItemCount() { return this.indexMap.size(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 126 */   public Number getValue(int item) { return (Number)this.values.get(item); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 140 */   public Comparable getKey(int index) { return (Comparable)this.keys.get(index); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getIndex(Comparable key) {
/* 155 */     ParamChecks.nullNotPermitted(key, "key");
/* 156 */     Integer i = (Integer)this.indexMap.get(key);
/* 157 */     if (i == null) {
/* 158 */       return -1;
/*     */     }
/* 160 */     return i.intValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 170 */   public List getKeys() { return (List)this.keys.clone(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Number getValue(Comparable key) {
/* 186 */     int index = getIndex(key);
/* 187 */     if (index < 0) {
/* 188 */       throw new UnknownKeyException("Key not found: " + key);
/*     */     }
/* 190 */     return getValue(index);
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
/* 202 */   public void addValue(Comparable key, double value) { addValue(key, new Double(value)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 214 */   public void addValue(Comparable key, Number value) { setValue(key, value); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 224 */   public void setValue(Comparable key, double value) { setValue(key, new Double(value)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(Comparable key, Number value) {
/* 234 */     ParamChecks.nullNotPermitted(key, "key");
/* 235 */     int keyIndex = getIndex(key);
/* 236 */     if (keyIndex >= 0) {
/* 237 */       this.keys.set(keyIndex, key);
/* 238 */       this.values.set(keyIndex, value);
/*     */     } else {
/*     */       
/* 241 */       this.keys.add(key);
/* 242 */       this.values.add(value);
/* 243 */       this.indexMap.put(key, new Integer(this.keys.size() - 1));
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
/*     */ 
/*     */ 
/*     */   
/* 259 */   public void insertValue(int position, Comparable key, double value) { insertValue(position, key, new Double(value)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void insertValue(int position, Comparable key, Number value) {
/* 274 */     if (position < 0 || position > getItemCount()) {
/* 275 */       throw new IllegalArgumentException("'position' out of bounds.");
/*     */     }
/* 277 */     ParamChecks.nullNotPermitted(key, "key");
/* 278 */     int pos = getIndex(key);
/* 279 */     if (pos == position) {
/* 280 */       this.keys.set(pos, key);
/* 281 */       this.values.set(pos, value);
/*     */     } else {
/*     */       
/* 284 */       if (pos >= 0) {
/* 285 */         this.keys.remove(pos);
/* 286 */         this.values.remove(pos);
/*     */       } 
/*     */       
/* 289 */       this.keys.add(position, key);
/* 290 */       this.values.add(position, value);
/* 291 */       rebuildIndex();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void rebuildIndex() {
/* 300 */     this.indexMap.clear();
/* 301 */     for (int i = 0; i < this.keys.size(); i++) {
/* 302 */       Object key = this.keys.get(i);
/* 303 */       this.indexMap.put(key, new Integer(i));
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
/*     */   public void removeValue(int index) {
/* 317 */     this.keys.remove(index);
/* 318 */     this.values.remove(index);
/* 319 */     rebuildIndex();
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
/*     */   public void removeValue(Comparable key) {
/* 332 */     int index = getIndex(key);
/* 333 */     if (index < 0) {
/* 334 */       throw new UnknownKeyException("The key (" + key + ") is not recognised.");
/*     */     }
/*     */     
/* 337 */     removeValue(index);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 346 */     this.keys.clear();
/* 347 */     this.values.clear();
/* 348 */     this.indexMap.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void sortByKeys(SortOrder order) {
/* 357 */     int size = this.keys.size();
/* 358 */     DefaultKeyedValue[] data = new DefaultKeyedValue[size];
/*     */     
/* 360 */     for (int i = 0; i < size; i++) {
/* 361 */       data[i] = new DefaultKeyedValue((Comparable)this.keys.get(i), (Number)this.values
/* 362 */           .get(i));
/*     */     }
/*     */     
/* 365 */     Comparator comparator = new KeyedValueComparator(KeyedValueComparatorType.BY_KEY, order);
/*     */     
/* 367 */     Arrays.sort(data, comparator);
/* 368 */     clear();
/*     */     
/* 370 */     for (int i = 0; i < data.length; i++) {
/* 371 */       DefaultKeyedValue value = data[i];
/* 372 */       addValue(value.getKey(), value.getValue());
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
/*     */   public void sortByValues(SortOrder order) {
/* 384 */     int size = this.keys.size();
/* 385 */     DefaultKeyedValue[] data = new DefaultKeyedValue[size];
/* 386 */     for (int i = 0; i < size; i++) {
/* 387 */       data[i] = new DefaultKeyedValue((Comparable)this.keys.get(i), (Number)this.values
/* 388 */           .get(i));
/*     */     }
/*     */     
/* 391 */     Comparator comparator = new KeyedValueComparator(KeyedValueComparatorType.BY_VALUE, order);
/*     */     
/* 393 */     Arrays.sort(data, comparator);
/*     */     
/* 395 */     clear();
/* 396 */     for (int i = 0; i < data.length; i++) {
/* 397 */       DefaultKeyedValue value = data[i];
/* 398 */       addValue(value.getKey(), value.getValue());
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
/*     */   public boolean equals(Object obj) {
/* 411 */     if (obj == this) {
/* 412 */       return true;
/*     */     }
/*     */     
/* 415 */     if (!(obj instanceof KeyedValues)) {
/* 416 */       return false;
/*     */     }
/*     */     
/* 419 */     KeyedValues that = (KeyedValues)obj;
/* 420 */     int count = getItemCount();
/* 421 */     if (count != that.getItemCount()) {
/* 422 */       return false;
/*     */     }
/*     */     
/* 425 */     for (int i = 0; i < count; i++) {
/* 426 */       Comparable k1 = getKey(i);
/* 427 */       Comparable k2 = that.getKey(i);
/* 428 */       if (!k1.equals(k2)) {
/* 429 */         return false;
/*     */       }
/* 431 */       Number v1 = getValue(i);
/* 432 */       Number v2 = that.getValue(i);
/* 433 */       if (v1 == null) {
/* 434 */         if (v2 != null) {
/* 435 */           return false;
/*     */         
/*     */         }
/*     */       }
/* 439 */       else if (!v1.equals(v2)) {
/* 440 */         return false;
/*     */       } 
/*     */     } 
/*     */     
/* 444 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 454 */   public int hashCode() { return (this.keys != null) ? this.keys.hashCode() : 0; }
/*     */ 
/*     */ 
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
/* 467 */     DefaultKeyedValues clone = (DefaultKeyedValues)super.clone();
/* 468 */     clone.keys = (ArrayList)this.keys.clone();
/* 469 */     clone.values = (ArrayList)this.values.clone();
/* 470 */     clone.indexMap = (HashMap)this.indexMap.clone();
/* 471 */     return clone;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/DefaultKeyedValues.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */