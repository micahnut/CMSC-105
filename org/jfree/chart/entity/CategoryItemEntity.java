/*     */ package org.jfree.chart.entity;
/*     */ 
/*     */ import java.awt.Shape;
/*     */ import java.io.Serializable;
/*     */ import org.jfree.chart.util.ParamChecks;
/*     */ import org.jfree.data.category.CategoryDataset;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CategoryItemEntity
/*     */   extends ChartEntity
/*     */   implements Cloneable, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -8657249457902337349L;
/*     */   private CategoryDataset dataset;
/*     */   private int series;
/*     */   private Object category;
/*     */   private int categoryIndex;
/*     */   private Comparable rowKey;
/*     */   private Comparable columnKey;
/*     */   
/*     */   public CategoryItemEntity(Shape area, String toolTipText, String urlText, CategoryDataset dataset, int series, Object category, int categoryIndex) {
/* 131 */     super(area, toolTipText, urlText);
/* 132 */     ParamChecks.nullNotPermitted(dataset, "dataset");
/* 133 */     this.dataset = dataset;
/* 134 */     this.series = series;
/* 135 */     this.category = category;
/* 136 */     this.categoryIndex = categoryIndex;
/* 137 */     this.rowKey = dataset.getRowKey(series);
/* 138 */     this.columnKey = dataset.getColumnKey(categoryIndex);
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
/*     */   public CategoryItemEntity(Shape area, String toolTipText, String urlText, CategoryDataset dataset, Comparable rowKey, Comparable columnKey) {
/* 155 */     super(area, toolTipText, urlText);
/* 156 */     ParamChecks.nullNotPermitted(dataset, "dataset");
/* 157 */     this.dataset = dataset;
/* 158 */     this.rowKey = rowKey;
/* 159 */     this.columnKey = columnKey;
/*     */ 
/*     */     
/* 162 */     this.series = dataset.getRowIndex(rowKey);
/* 163 */     this.category = columnKey;
/* 164 */     this.categoryIndex = dataset.getColumnIndex(columnKey);
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
/* 177 */   public CategoryDataset getDataset() { return this.dataset; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDataset(CategoryDataset dataset) {
/* 188 */     ParamChecks.nullNotPermitted(dataset, "dataset");
/* 189 */     this.dataset = dataset;
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
/* 202 */   public Comparable getRowKey() { return this.rowKey; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRowKey(Comparable rowKey) {
/* 215 */     this.rowKey = rowKey;
/*     */     
/* 217 */     this.series = this.dataset.getRowIndex(rowKey);
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
/* 230 */   public Comparable getColumnKey() { return this.columnKey; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setColumnKey(Comparable columnKey) {
/* 243 */     this.columnKey = columnKey;
/*     */     
/* 245 */     this.category = columnKey;
/* 246 */     this.categoryIndex = this.dataset.getColumnIndex(columnKey);
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
/* 260 */   public int getSeries() { return this.series; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 274 */   public void setSeries(int series) { this.series = series; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 289 */   public Object getCategory() { return this.category; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 302 */   public void setCategory(Object category) { this.category = category; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 316 */   public int getCategoryIndex() { return this.categoryIndex; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 330 */   public void setCategoryIndex(int index) { this.categoryIndex = index; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 341 */   public String toString() { return "CategoryItemEntity: rowKey=" + this.rowKey + ", columnKey=" + this.columnKey + ", dataset=" + this.dataset; }
/*     */ 
/*     */ 
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
/* 354 */     if (obj == this) {
/* 355 */       return true;
/*     */     }
/* 357 */     if (!(obj instanceof CategoryItemEntity)) {
/* 358 */       return false;
/*     */     }
/* 360 */     CategoryItemEntity that = (CategoryItemEntity)obj;
/* 361 */     if (!this.rowKey.equals(that.rowKey)) {
/* 362 */       return false;
/*     */     }
/* 364 */     if (!this.columnKey.equals(that.columnKey)) {
/* 365 */       return false;
/*     */     }
/* 367 */     if (!ObjectUtilities.equal(this.dataset, that.dataset)) {
/* 368 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 372 */     if (this.categoryIndex != that.categoryIndex) {
/* 373 */       return false;
/*     */     }
/* 375 */     if (this.series != that.series) {
/* 376 */       return false;
/*     */     }
/* 378 */     if (!ObjectUtilities.equal(this.category, that.category)) {
/* 379 */       return false;
/*     */     }
/* 381 */     return super.equals(obj);
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/entity/CategoryItemEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */