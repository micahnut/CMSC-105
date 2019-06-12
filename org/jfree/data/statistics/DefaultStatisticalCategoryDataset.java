/*     */ package org.jfree.data.statistics;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.jfree.data.KeyedObjects2D;
/*     */ import org.jfree.data.Range;
/*     */ import org.jfree.data.RangeInfo;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DefaultStatisticalCategoryDataset
/*     */   extends AbstractDataset
/*     */   implements StatisticalCategoryDataset, RangeInfo, PublicCloneable
/*     */ {
/*     */   private KeyedObjects2D data;
/*     */   private double minimumRangeValue;
/*     */   private int minimumRangeValueRow;
/*     */   private int minimumRangeValueColumn;
/*     */   private double minimumRangeValueIncStdDev;
/*     */   private int minimumRangeValueIncStdDevRow;
/*     */   private int minimumRangeValueIncStdDevColumn;
/*     */   private double maximumRangeValue;
/*     */   private int maximumRangeValueRow;
/*     */   private int maximumRangeValueColumn;
/*     */   private double maximumRangeValueIncStdDev;
/*     */   private int maximumRangeValueIncStdDevRow;
/*     */   private int maximumRangeValueIncStdDevColumn;
/*     */   
/*     */   public DefaultStatisticalCategoryDataset() {
/* 131 */     this.data = new KeyedObjects2D();
/* 132 */     this.minimumRangeValue = NaND;
/* 133 */     this.minimumRangeValueRow = -1;
/* 134 */     this.minimumRangeValueColumn = -1;
/* 135 */     this.maximumRangeValue = NaND;
/* 136 */     this.maximumRangeValueRow = -1;
/* 137 */     this.maximumRangeValueColumn = -1;
/* 138 */     this.minimumRangeValueIncStdDev = NaND;
/* 139 */     this.minimumRangeValueIncStdDevRow = -1;
/* 140 */     this.minimumRangeValueIncStdDevColumn = -1;
/* 141 */     this.maximumRangeValueIncStdDev = NaND;
/* 142 */     this.maximumRangeValueIncStdDevRow = -1;
/* 143 */     this.maximumRangeValueIncStdDevColumn = -1;
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
/*     */   public Number getMeanValue(int row, int column) {
/* 156 */     Number result = null;
/*     */     
/* 158 */     MeanAndStandardDeviation masd = (MeanAndStandardDeviation)this.data.getObject(row, column);
/* 159 */     if (masd != null) {
/* 160 */       result = masd.getMean();
/*     */     }
/* 162 */     return result;
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
/* 176 */   public Number getValue(int row, int column) { return getMeanValue(row, column); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 190 */   public Number getValue(Comparable rowKey, Comparable columnKey) { return getMeanValue(rowKey, columnKey); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Number getMeanValue(Comparable rowKey, Comparable columnKey) {
/* 203 */     Number result = null;
/*     */     
/* 205 */     MeanAndStandardDeviation masd = (MeanAndStandardDeviation)this.data.getObject(rowKey, columnKey);
/* 206 */     if (masd != null) {
/* 207 */       result = masd.getMean();
/*     */     }
/* 209 */     return result;
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
/*     */   public Number getStdDevValue(int row, int column) {
/* 222 */     Number result = null;
/*     */     
/* 224 */     MeanAndStandardDeviation masd = (MeanAndStandardDeviation)this.data.getObject(row, column);
/* 225 */     if (masd != null) {
/* 226 */       result = masd.getStandardDeviation();
/*     */     }
/* 228 */     return result;
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
/*     */   public Number getStdDevValue(Comparable rowKey, Comparable columnKey) {
/* 241 */     Number result = null;
/*     */     
/* 243 */     MeanAndStandardDeviation masd = (MeanAndStandardDeviation)this.data.getObject(rowKey, columnKey);
/* 244 */     if (masd != null) {
/* 245 */       result = masd.getStandardDeviation();
/*     */     }
/* 247 */     return result;
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
/* 260 */   public int getColumnIndex(Comparable key) { return this.data.getColumnIndex(key); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 272 */   public Comparable getColumnKey(int column) { return this.data.getColumnKey(column); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 282 */   public List getColumnKeys() { return this.data.getColumnKeys(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 295 */   public int getRowIndex(Comparable key) { return this.data.getRowIndex(key); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 307 */   public Comparable getRowKey(int row) { return this.data.getRowKey(row); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 317 */   public List getRowKeys() { return this.data.getRowKeys(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 329 */   public int getRowCount() { return this.data.getRowCount(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 341 */   public int getColumnCount() { return this.data.getColumnCount(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 354 */   public void add(double mean, double standardDeviation, Comparable rowKey, Comparable columnKey) { add(new Double(mean), new Double(standardDeviation), rowKey, columnKey); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(Number mean, Number standardDeviation, Comparable rowKey, Comparable columnKey) {
/* 367 */     MeanAndStandardDeviation item = new MeanAndStandardDeviation(mean, standardDeviation);
/*     */     
/* 369 */     this.data.addObject(item, rowKey, columnKey);
/*     */     
/* 371 */     double m = NaND;
/* 372 */     double sd = NaND;
/* 373 */     if (mean != null) {
/* 374 */       m = mean.doubleValue();
/*     */     }
/* 376 */     if (standardDeviation != null) {
/* 377 */       sd = standardDeviation.doubleValue();
/*     */     }
/*     */ 
/*     */     
/* 381 */     int r = this.data.getColumnIndex(columnKey);
/* 382 */     int c = this.data.getRowIndex(rowKey);
/* 383 */     if ((r == this.maximumRangeValueRow && c == this.maximumRangeValueColumn) || (r == this.maximumRangeValueIncStdDevRow && c == this.maximumRangeValueIncStdDevColumn) || (r == this.minimumRangeValueRow && c == this.minimumRangeValueColumn) || (r == this.minimumRangeValueIncStdDevRow && c == this.minimumRangeValueIncStdDevColumn)) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 393 */       updateBounds();
/*     */     } else {
/*     */       
/* 396 */       if (!Double.isNaN(m) && (
/* 397 */         Double.isNaN(this.maximumRangeValue) || m > this.maximumRangeValue)) {
/*     */         
/* 399 */         this.maximumRangeValue = m;
/* 400 */         this.maximumRangeValueRow = r;
/* 401 */         this.maximumRangeValueColumn = c;
/*     */       } 
/*     */ 
/*     */       
/* 405 */       if (!Double.isNaN(m + sd) && (
/* 406 */         Double.isNaN(this.maximumRangeValueIncStdDev) || m + sd > this.maximumRangeValueIncStdDev)) {
/*     */         
/* 408 */         this.maximumRangeValueIncStdDev = m + sd;
/* 409 */         this.maximumRangeValueIncStdDevRow = r;
/* 410 */         this.maximumRangeValueIncStdDevColumn = c;
/*     */       } 
/*     */ 
/*     */       
/* 414 */       if (!Double.isNaN(m) && (
/* 415 */         Double.isNaN(this.minimumRangeValue) || m < this.minimumRangeValue)) {
/*     */         
/* 417 */         this.minimumRangeValue = m;
/* 418 */         this.minimumRangeValueRow = r;
/* 419 */         this.minimumRangeValueColumn = c;
/*     */       } 
/*     */ 
/*     */       
/* 423 */       if (!Double.isNaN(m - sd) && (
/* 424 */         Double.isNaN(this.minimumRangeValueIncStdDev) || m - sd < this.minimumRangeValueIncStdDev)) {
/*     */         
/* 426 */         this.minimumRangeValueIncStdDev = m - sd;
/* 427 */         this.minimumRangeValueIncStdDevRow = r;
/* 428 */         this.minimumRangeValueIncStdDevColumn = c;
/*     */       } 
/*     */     } 
/*     */     
/* 432 */     fireDatasetChanged();
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
/*     */   public void remove(Comparable rowKey, Comparable columnKey) {
/* 448 */     int r = getRowIndex(rowKey);
/* 449 */     int c = getColumnIndex(columnKey);
/* 450 */     this.data.removeObject(rowKey, columnKey);
/*     */ 
/*     */ 
/*     */     
/* 454 */     if ((r == this.maximumRangeValueRow && c == this.maximumRangeValueColumn) || (r == this.maximumRangeValueIncStdDevRow && c == this.maximumRangeValueIncStdDevColumn) || (r == this.minimumRangeValueRow && c == this.minimumRangeValueColumn) || (r == this.minimumRangeValueIncStdDevRow && c == this.minimumRangeValueIncStdDevColumn))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 464 */       updateBounds();
/*     */     }
/*     */     
/* 467 */     fireDatasetChanged();
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
/*     */   public void removeRow(int rowIndex) {
/* 482 */     this.data.removeRow(rowIndex);
/* 483 */     updateBounds();
/* 484 */     fireDatasetChanged();
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
/*     */   public void removeRow(Comparable rowKey) {
/* 498 */     this.data.removeRow(rowKey);
/* 499 */     updateBounds();
/* 500 */     fireDatasetChanged();
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
/*     */   public void removeColumn(int columnIndex) {
/* 514 */     this.data.removeColumn(columnIndex);
/* 515 */     updateBounds();
/* 516 */     fireDatasetChanged();
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
/*     */   public void removeColumn(Comparable columnKey) {
/* 530 */     this.data.removeColumn(columnKey);
/* 531 */     updateBounds();
/* 532 */     fireDatasetChanged();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 542 */     this.data.clear();
/* 543 */     updateBounds();
/* 544 */     fireDatasetChanged();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void updateBounds() {
/* 551 */     this.maximumRangeValue = NaND;
/* 552 */     this.maximumRangeValueRow = -1;
/* 553 */     this.maximumRangeValueColumn = -1;
/* 554 */     this.minimumRangeValue = NaND;
/* 555 */     this.minimumRangeValueRow = -1;
/* 556 */     this.minimumRangeValueColumn = -1;
/* 557 */     this.maximumRangeValueIncStdDev = NaND;
/* 558 */     this.maximumRangeValueIncStdDevRow = -1;
/* 559 */     this.maximumRangeValueIncStdDevColumn = -1;
/* 560 */     this.minimumRangeValueIncStdDev = NaND;
/* 561 */     this.minimumRangeValueIncStdDevRow = -1;
/* 562 */     this.minimumRangeValueIncStdDevColumn = -1;
/*     */     
/* 564 */     int rowCount = this.data.getRowCount();
/* 565 */     int columnCount = this.data.getColumnCount();
/* 566 */     for (int r = 0; r < rowCount; r++) {
/* 567 */       for (int c = 0; c < columnCount; c++) {
/*     */         
/* 569 */         MeanAndStandardDeviation masd = (MeanAndStandardDeviation)this.data.getObject(r, c);
/* 570 */         if (masd != null) {
/*     */ 
/*     */           
/* 573 */           double m = masd.getMeanValue();
/* 574 */           double sd = masd.getStandardDeviationValue();
/*     */           
/* 576 */           if (!Double.isNaN(m)) {
/*     */ 
/*     */             
/* 579 */             if (Double.isNaN(this.maximumRangeValue)) {
/* 580 */               this.maximumRangeValue = m;
/* 581 */               this.maximumRangeValueRow = r;
/* 582 */               this.maximumRangeValueColumn = c;
/*     */             
/*     */             }
/* 585 */             else if (m > this.maximumRangeValue) {
/* 586 */               this.maximumRangeValue = m;
/* 587 */               this.maximumRangeValueRow = r;
/* 588 */               this.maximumRangeValueColumn = c;
/*     */             } 
/*     */ 
/*     */ 
/*     */             
/* 593 */             if (Double.isNaN(this.minimumRangeValue)) {
/* 594 */               this.minimumRangeValue = m;
/* 595 */               this.minimumRangeValueRow = r;
/* 596 */               this.minimumRangeValueColumn = c;
/*     */             
/*     */             }
/* 599 */             else if (m < this.minimumRangeValue) {
/* 600 */               this.minimumRangeValue = m;
/* 601 */               this.minimumRangeValueRow = r;
/* 602 */               this.minimumRangeValueColumn = c;
/*     */             } 
/*     */ 
/*     */             
/* 606 */             if (!Double.isNaN(sd)) {
/*     */               
/* 608 */               if (Double.isNaN(this.maximumRangeValueIncStdDev)) {
/* 609 */                 this.maximumRangeValueIncStdDev = m + sd;
/* 610 */                 this.maximumRangeValueIncStdDevRow = r;
/* 611 */                 this.maximumRangeValueIncStdDevColumn = c;
/*     */               
/*     */               }
/* 614 */               else if (m + sd > this.maximumRangeValueIncStdDev) {
/* 615 */                 this.maximumRangeValueIncStdDev = m + sd;
/* 616 */                 this.maximumRangeValueIncStdDevRow = r;
/* 617 */                 this.maximumRangeValueIncStdDevColumn = c;
/*     */               } 
/*     */ 
/*     */ 
/*     */               
/* 622 */               if (Double.isNaN(this.minimumRangeValueIncStdDev)) {
/* 623 */                 this.minimumRangeValueIncStdDev = m - sd;
/* 624 */                 this.minimumRangeValueIncStdDevRow = r;
/* 625 */                 this.minimumRangeValueIncStdDevColumn = c;
/*     */               
/*     */               }
/* 628 */               else if (m - sd < this.minimumRangeValueIncStdDev) {
/* 629 */                 this.minimumRangeValueIncStdDev = m - sd;
/* 630 */                 this.minimumRangeValueIncStdDevRow = r;
/* 631 */                 this.minimumRangeValueIncStdDevColumn = c;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
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
/*     */   public double getRangeLowerBound(boolean includeInterval) {
/* 652 */     if (includeInterval && !Double.isNaN(this.minimumRangeValueIncStdDev)) {
/* 653 */       return this.minimumRangeValueIncStdDev;
/*     */     }
/*     */     
/* 656 */     return this.minimumRangeValue;
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
/*     */   public double getRangeUpperBound(boolean includeInterval) {
/* 672 */     if (includeInterval && !Double.isNaN(this.maximumRangeValueIncStdDev)) {
/* 673 */       return this.maximumRangeValueIncStdDev;
/*     */     }
/*     */     
/* 676 */     return this.maximumRangeValue;
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
/*     */   public Range getRangeBounds(boolean includeInterval) {
/* 690 */     double lower = getRangeLowerBound(includeInterval);
/* 691 */     double upper = getRangeUpperBound(includeInterval);
/* 692 */     if (Double.isNaN(lower) && Double.isNaN(upper)) {
/* 693 */       return null;
/*     */     }
/* 695 */     return new Range(lower, upper);
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
/* 707 */     if (obj == this) {
/* 708 */       return true;
/*     */     }
/* 710 */     if (!(obj instanceof DefaultStatisticalCategoryDataset)) {
/* 711 */       return false;
/*     */     }
/* 713 */     DefaultStatisticalCategoryDataset that = (DefaultStatisticalCategoryDataset)obj;
/*     */     
/* 715 */     if (!this.data.equals(that.data)) {
/* 716 */       return false;
/*     */     }
/* 718 */     return true;
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
/* 731 */     DefaultStatisticalCategoryDataset clone = (DefaultStatisticalCategoryDataset)super.clone();
/* 732 */     clone.data = (KeyedObjects2D)this.data.clone();
/* 733 */     return clone;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/statistics/DefaultStatisticalCategoryDataset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */