/*     */ package org.jfree.data.general;
/*     */ 
/*     */ import java.util.Set;
/*     */ import java.util.TreeSet;
/*     */ import org.jfree.data.DefaultKeyedValues2D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WaferMapDataset
/*     */   extends AbstractDataset
/*     */ {
/*     */   private DefaultKeyedValues2D data;
/*     */   private int maxChipX;
/*     */   private int maxChipY;
/*     */   private double chipSpace;
/*     */   private Double maxValue;
/*     */   private Double minValue;
/*     */   private static final double DEFAULT_CHIP_SPACE = 1.0D;
/*     */   
/*  88 */   public WaferMapDataset(int maxChipX, int maxChipY) { this(maxChipX, maxChipY, null); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WaferMapDataset(int maxChipX, int maxChipY, Number chipSpace) {
/* 100 */     this.maxValue = new Double(Double.NEGATIVE_INFINITY);
/* 101 */     this.minValue = new Double(Double.POSITIVE_INFINITY);
/* 102 */     this.data = new DefaultKeyedValues2D();
/*     */     
/* 104 */     this.maxChipX = maxChipX;
/* 105 */     this.maxChipY = maxChipY;
/* 106 */     if (chipSpace == null) {
/* 107 */       this.chipSpace = 1.0D;
/*     */     } else {
/*     */       
/* 110 */       this.chipSpace = chipSpace.doubleValue();
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
/* 123 */   public void addValue(Number value, Comparable chipx, Comparable chipy) { setValue(value, chipx, chipy); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 134 */   public void addValue(int v, int x, int y) { setValue(new Double(v), new Integer(x), new Integer(y)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(Number value, Comparable chipx, Comparable chipy) {
/* 145 */     this.data.setValue(value, chipx, chipy);
/* 146 */     if (isMaxValue(value)) {
/* 147 */       this.maxValue = (Double)value;
/*     */     }
/* 149 */     if (isMinValue(value)) {
/* 150 */       this.minValue = (Double)value;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 160 */   public int getUniqueValueCount() { return getUniqueValues().size(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set getUniqueValues() {
/* 169 */     Set unique = new TreeSet();
/*     */     
/* 171 */     for (int r = 0; r < this.data.getRowCount(); r++) {
/* 172 */       for (int c = 0; c < this.data.getColumnCount(); c++) {
/* 173 */         Number value = this.data.getValue(r, c);
/* 174 */         if (value != null) {
/* 175 */           unique.add(value);
/*     */         }
/*     */       } 
/*     */     } 
/* 179 */     return unique;
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
/* 191 */   public Number getChipValue(int chipx, int chipy) { return getChipValue(new Integer(chipx), new Integer(chipy)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Number getChipValue(Comparable chipx, Comparable chipy) {
/* 203 */     int rowIndex = this.data.getRowIndex(chipx);
/* 204 */     if (rowIndex < 0) {
/* 205 */       return null;
/*     */     }
/* 207 */     int colIndex = this.data.getColumnIndex(chipy);
/* 208 */     if (colIndex < 0) {
/* 209 */       return null;
/*     */     }
/* 211 */     return this.data.getValue(rowIndex, colIndex);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isMaxValue(Number check) {
/* 222 */     if (check.doubleValue() > this.maxValue.doubleValue()) {
/* 223 */       return true;
/*     */     }
/* 225 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isMinValue(Number check) {
/* 236 */     if (check.doubleValue() < this.minValue.doubleValue()) {
/* 237 */       return true;
/*     */     }
/* 239 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 248 */   public Number getMaxValue() { return this.maxValue; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 257 */   public Number getMinValue() { return this.minValue; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 266 */   public int getMaxChipX() { return this.maxChipX; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 275 */   public void setMaxChipX(int maxChipX) { this.maxChipX = maxChipX; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 284 */   public int getMaxChipY() { return this.maxChipY; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 293 */   public void setMaxChipY(int maxChipY) { this.maxChipY = maxChipY; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 302 */   public double getChipSpace() { return this.chipSpace; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 311 */   public void setChipSpace(double space) { this.chipSpace = space; }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/general/WaferMapDataset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */