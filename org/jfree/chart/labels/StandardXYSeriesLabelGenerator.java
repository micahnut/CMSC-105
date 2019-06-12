/*     */ package org.jfree.chart.labels;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.text.MessageFormat;
/*     */ import org.jfree.chart.HashUtilities;
/*     */ import org.jfree.chart.util.ParamChecks;
/*     */ import org.jfree.data.xy.XYDataset;
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
/*     */ public class StandardXYSeriesLabelGenerator
/*     */   implements XYSeriesLabelGenerator, Cloneable, PublicCloneable, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1916017081848400024L;
/*     */   public static final String DEFAULT_LABEL_FORMAT = "{0}";
/*     */   private String formatPattern;
/*     */   
/*  79 */   public StandardXYSeriesLabelGenerator() { this("{0}"); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StandardXYSeriesLabelGenerator(String format) {
/*  88 */     ParamChecks.nullNotPermitted(format, "format");
/*  89 */     this.formatPattern = format;
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
/*     */   public String generateLabel(XYDataset dataset, int series) {
/* 103 */     ParamChecks.nullNotPermitted(dataset, "dataset");
/* 104 */     return MessageFormat.format(this.formatPattern, 
/* 105 */         createItemArray(dataset, series));
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
/*     */   protected Object[] createItemArray(XYDataset dataset, int series) {
/* 120 */     Object[] result = new Object[1];
/* 121 */     result[0] = dataset.getSeriesKey(series).toString();
/* 122 */     return result;
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
/* 136 */   public Object clone() throws CloneNotSupportedException { return super.clone(); }
/*     */ 
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
/* 148 */     if (obj == this) {
/* 149 */       return true;
/*     */     }
/* 151 */     if (!(obj instanceof StandardXYSeriesLabelGenerator)) {
/* 152 */       return false;
/*     */     }
/* 154 */     StandardXYSeriesLabelGenerator that = (StandardXYSeriesLabelGenerator)obj;
/*     */     
/* 156 */     if (!this.formatPattern.equals(that.formatPattern)) {
/* 157 */       return false;
/*     */     }
/* 159 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 169 */     result = 127;
/* 170 */     return HashUtilities.hashCode(result, this.formatPattern);
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/labels/StandardXYSeriesLabelGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */