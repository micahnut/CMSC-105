/*     */ package org.jfree.chart.entity;
/*     */ 
/*     */ import java.awt.Shape;
/*     */ import java.io.Serializable;
/*     */ import org.jfree.chart.HashUtilities;
/*     */ import org.jfree.data.general.PieDataset;
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
/*     */ public class PieSectionEntity
/*     */   extends ChartEntity
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 9199892576531984162L;
/*     */   private PieDataset dataset;
/*     */   private int pieIndex;
/*     */   private int sectionIndex;
/*     */   private Comparable sectionKey;
/*     */   
/*     */   public PieSectionEntity(Shape area, PieDataset dataset, int pieIndex, int sectionIndex, Comparable sectionKey, String toolTipText, String urlText) {
/* 102 */     super(area, toolTipText, urlText);
/* 103 */     this.dataset = dataset;
/* 104 */     this.pieIndex = pieIndex;
/* 105 */     this.sectionIndex = sectionIndex;
/* 106 */     this.sectionKey = sectionKey;
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
/* 118 */   public PieDataset getDataset() { return this.dataset; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 129 */   public void setDataset(PieDataset dataset) { this.dataset = dataset; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 142 */   public int getPieIndex() { return this.pieIndex; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 153 */   public void setPieIndex(int index) { this.pieIndex = index; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 164 */   public int getSectionIndex() { return this.sectionIndex; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 175 */   public void setSectionIndex(int index) { this.sectionIndex = index; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 186 */   public Comparable getSectionKey() { return this.sectionKey; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 197 */   public void setSectionKey(Comparable key) { this.sectionKey = key; }
/*     */ 
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
/* 209 */     if (obj == this) {
/* 210 */       return true;
/*     */     }
/* 212 */     if (!(obj instanceof PieSectionEntity)) {
/* 213 */       return false;
/*     */     }
/* 215 */     PieSectionEntity that = (PieSectionEntity)obj;
/* 216 */     if (!ObjectUtilities.equal(this.dataset, that.dataset)) {
/* 217 */       return false;
/*     */     }
/* 219 */     if (this.pieIndex != that.pieIndex) {
/* 220 */       return false;
/*     */     }
/* 222 */     if (this.sectionIndex != that.sectionIndex) {
/* 223 */       return false;
/*     */     }
/* 225 */     if (!ObjectUtilities.equal(this.sectionKey, that.sectionKey)) {
/* 226 */       return false;
/*     */     }
/* 228 */     return super.equals(obj);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 238 */     result = super.hashCode();
/* 239 */     result = HashUtilities.hashCode(result, this.pieIndex);
/* 240 */     return HashUtilities.hashCode(result, this.sectionIndex);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 251 */     return "PieSection: " + this.pieIndex + ", " + this.sectionIndex + "(" + this.sectionKey
/* 252 */       .toString() + ")";
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/entity/PieSectionEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */