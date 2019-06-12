/*     */ package org.jfree.data.category;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.List;
/*     */ import org.jfree.data.DefaultKeyedValues2D;
/*     */ import org.jfree.data.general.AbstractDataset;
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
/*     */ public class DefaultCategoryDataset
/*     */   extends AbstractDataset
/*     */   implements CategoryDataset, PublicCloneable, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -8168173757291644622L;
/*     */   private DefaultKeyedValues2D data;
/*     */   
/*  76 */   public DefaultCategoryDataset() { this.data = new DefaultKeyedValues2D(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  88 */   public int getRowCount() { return this.data.getRowCount(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 100 */   public int getColumnCount() { return this.data.getColumnCount(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 116 */   public Number getValue(int row, int column) { return this.data.getValue(row, column); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 132 */   public Comparable getRowKey(int row) { return this.data.getRowKey(row); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 147 */   public int getRowIndex(Comparable key) { return this.data.getRowIndex(key); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 159 */   public List getRowKeys() { return this.data.getRowKeys(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 173 */   public Comparable getColumnKey(int column) { return this.data.getColumnKey(column); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 188 */   public int getColumnIndex(Comparable key) { return this.data.getColumnIndex(key); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 200 */   public List getColumnKeys() { return this.data.getColumnKeys(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 217 */   public Number getValue(Comparable rowKey, Comparable columnKey) { return this.data.getValue(rowKey, columnKey); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addValue(Number value, Comparable rowKey, Comparable columnKey) {
/* 232 */     this.data.addValue(value, rowKey, columnKey);
/* 233 */     fireDatasetChanged();
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
/* 247 */   public void addValue(double value, Comparable rowKey, Comparable columnKey) { addValue(new Double(value), rowKey, columnKey); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(Number value, Comparable rowKey, Comparable columnKey) {
/* 262 */     this.data.setValue(value, rowKey, columnKey);
/* 263 */     fireDatasetChanged();
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
/* 278 */   public void setValue(double value, Comparable rowKey, Comparable columnKey) { setValue(new Double(value), rowKey, columnKey); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void incrementValue(double value, Comparable rowKey, Comparable columnKey) {
/* 294 */     double existing = 0.0D;
/* 295 */     Number n = getValue(rowKey, columnKey);
/* 296 */     if (n != null) {
/* 297 */       existing = n.doubleValue();
/*     */     }
/* 299 */     setValue(existing + value, rowKey, columnKey);
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
/*     */   public void removeValue(Comparable rowKey, Comparable columnKey) {
/* 312 */     this.data.removeValue(rowKey, columnKey);
/* 313 */     fireDatasetChanged();
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
/*     */   public void removeRow(int rowIndex) {
/* 325 */     this.data.removeRow(rowIndex);
/* 326 */     fireDatasetChanged();
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
/*     */   public void removeRow(Comparable rowKey) {
/* 338 */     this.data.removeRow(rowKey);
/* 339 */     fireDatasetChanged();
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
/*     */   public void removeColumn(int columnIndex) {
/* 351 */     this.data.removeColumn(columnIndex);
/* 352 */     fireDatasetChanged();
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
/*     */   public void removeColumn(Comparable columnKey) {
/* 367 */     this.data.removeColumn(columnKey);
/* 368 */     fireDatasetChanged();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 376 */     this.data.clear();
/* 377 */     fireDatasetChanged();
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
/* 389 */     if (obj == this) {
/* 390 */       return true;
/*     */     }
/* 392 */     if (!(obj instanceof CategoryDataset)) {
/* 393 */       return false;
/*     */     }
/* 395 */     CategoryDataset that = (CategoryDataset)obj;
/* 396 */     if (!getRowKeys().equals(that.getRowKeys())) {
/* 397 */       return false;
/*     */     }
/* 399 */     if (!getColumnKeys().equals(that.getColumnKeys())) {
/* 400 */       return false;
/*     */     }
/* 402 */     int rowCount = getRowCount();
/* 403 */     int colCount = getColumnCount();
/* 404 */     for (int r = 0; r < rowCount; r++) {
/* 405 */       for (int c = 0; c < colCount; c++) {
/* 406 */         Number v1 = getValue(r, c);
/* 407 */         Number v2 = that.getValue(r, c);
/* 408 */         if (v1 == null) {
/* 409 */           if (v2 != null) {
/* 410 */             return false;
/*     */           }
/*     */         }
/* 413 */         else if (!v1.equals(v2)) {
/* 414 */           return false;
/*     */         } 
/*     */       } 
/*     */     } 
/* 418 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 428 */   public int hashCode() { return this.data.hashCode(); }
/*     */ 
/*     */ 
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
/* 441 */     DefaultCategoryDataset clone = (DefaultCategoryDataset)super.clone();
/* 442 */     clone.data = (DefaultKeyedValues2D)this.data.clone();
/* 443 */     return clone;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/category/DefaultCategoryDataset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */