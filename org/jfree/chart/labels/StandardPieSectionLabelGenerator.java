/*     */ package org.jfree.chart.labels;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.text.AttributedString;
/*     */ import java.text.NumberFormat;
/*     */ import java.util.HashMap;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import org.jfree.data.general.PieDataset;
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
/*     */ public class StandardPieSectionLabelGenerator
/*     */   extends AbstractPieItemLabelGenerator
/*     */   implements PieSectionLabelGenerator, Cloneable, PublicCloneable, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 3064190563760203668L;
/*     */   public static final String DEFAULT_SECTION_LABEL_FORMAT = "{0}";
/*     */   private Map attributedLabels;
/*     */   
/*     */   public StandardPieSectionLabelGenerator() {
/*  95 */     this("{0}", NumberFormat.getNumberInstance(), 
/*  96 */         NumberFormat.getPercentInstance());
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
/* 107 */   public StandardPieSectionLabelGenerator(Locale locale) { this("{0}", locale); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StandardPieSectionLabelGenerator(String labelFormat) {
/* 117 */     this(labelFormat, NumberFormat.getNumberInstance(), 
/* 118 */         NumberFormat.getPercentInstance());
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
/* 130 */   public StandardPieSectionLabelGenerator(String labelFormat, Locale locale) { this(labelFormat, NumberFormat.getNumberInstance(locale), 
/* 131 */         NumberFormat.getPercentInstance(locale)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StandardPieSectionLabelGenerator(String labelFormat, NumberFormat numberFormat, NumberFormat percentFormat) {
/* 146 */     super(labelFormat, numberFormat, percentFormat);
/* 147 */     this.attributedLabels = new HashMap();
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
/* 159 */   public AttributedString getAttributedLabel(int section) { return (AttributedString)this.attributedLabels.get(Integer.valueOf(section)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 169 */   public void setAttributedLabel(int section, AttributedString label) { this.attributedLabels.put(Integer.valueOf(section), label); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 182 */   public String generateSectionLabel(PieDataset dataset, Comparable key) { return super.generateSectionLabel(dataset, key); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 215 */   public AttributedString generateAttributedSectionLabel(PieDataset dataset, Comparable key) { return getAttributedLabel(dataset.getIndex(key)); }
/*     */ 
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
/* 227 */     if (obj == this) {
/* 228 */       return true;
/*     */     }
/* 230 */     if (!(obj instanceof StandardPieSectionLabelGenerator)) {
/* 231 */       return false;
/*     */     }
/* 233 */     StandardPieSectionLabelGenerator that = (StandardPieSectionLabelGenerator)obj;
/*     */     
/* 235 */     if (!this.attributedLabels.equals(that.attributedLabels)) {
/* 236 */       return false;
/*     */     }
/* 238 */     return super.equals(obj);
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
/* 251 */     StandardPieSectionLabelGenerator clone = (StandardPieSectionLabelGenerator)super.clone();
/* 252 */     clone.attributedLabels = new HashMap();
/* 253 */     clone.attributedLabels.putAll(this.attributedLabels);
/* 254 */     return clone;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/labels/StandardPieSectionLabelGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */