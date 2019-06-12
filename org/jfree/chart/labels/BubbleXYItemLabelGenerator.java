/*     */ package org.jfree.chart.labels;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.text.DateFormat;
/*     */ import java.text.MessageFormat;
/*     */ import java.text.NumberFormat;
/*     */ import org.jfree.chart.HashUtilities;
/*     */ import org.jfree.chart.util.ParamChecks;
/*     */ import org.jfree.data.xy.XYDataset;
/*     */ import org.jfree.data.xy.XYZDataset;
/*     */ import org.jfree.util.ObjectUtilities;
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
/*     */ public class BubbleXYItemLabelGenerator
/*     */   extends AbstractXYItemLabelGenerator
/*     */   implements XYItemLabelGenerator, PublicCloneable, Serializable
/*     */ {
/*     */   static final long serialVersionUID = -8458568928021240922L;
/*     */   public static final String DEFAULT_FORMAT_STRING = "{3}";
/*     */   private NumberFormat zFormat;
/*     */   private DateFormat zDateFormat;
/*     */   
/*     */   public BubbleXYItemLabelGenerator() {
/*  93 */     this("{3}", NumberFormat.getNumberInstance(), 
/*  94 */         NumberFormat.getNumberInstance(), 
/*  95 */         NumberFormat.getNumberInstance());
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
/*     */   public BubbleXYItemLabelGenerator(String formatString, NumberFormat xFormat, NumberFormat yFormat, NumberFormat zFormat) {
/* 112 */     super(formatString, xFormat, yFormat);
/* 113 */     ParamChecks.nullNotPermitted(zFormat, "zFormat");
/* 114 */     this.zFormat = zFormat;
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
/*     */   public BubbleXYItemLabelGenerator(String formatString, DateFormat xFormat, DateFormat yFormat, DateFormat zFormat) {
/* 131 */     super(formatString, xFormat, yFormat);
/* 132 */     ParamChecks.nullNotPermitted(zFormat, "zFormat");
/* 133 */     this.zDateFormat = zFormat;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 142 */   public NumberFormat getZFormat() { return this.zFormat; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 151 */   public DateFormat getZDateFormat() { return this.zDateFormat; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 165 */   public String generateLabel(XYDataset dataset, int series, int item) { return generateLabelString(dataset, series, item); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String generateLabelString(XYDataset dataset, int series, int item) {
/*     */     Object[] items;
/* 181 */     if (dataset instanceof XYZDataset) {
/* 182 */       items = createItemArray((XYZDataset)dataset, series, item);
/*     */     } else {
/*     */       
/* 185 */       items = createItemArray(dataset, series, item);
/*     */     } 
/* 187 */     return MessageFormat.format(getFormatString(), items);
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
/*     */   protected Object[] createItemArray(XYZDataset dataset, int series, int item) {
/* 204 */     Object[] result = new Object[4];
/* 205 */     result[0] = dataset.getSeriesKey(series).toString();
/*     */     
/* 207 */     Number x = dataset.getX(series, item);
/* 208 */     DateFormat xf = getXDateFormat();
/* 209 */     if (xf != null) {
/* 210 */       result[1] = xf.format(x);
/*     */     } else {
/*     */       
/* 213 */       result[1] = getXFormat().format(x);
/*     */     } 
/*     */     
/* 216 */     Number y = dataset.getY(series, item);
/* 217 */     DateFormat yf = getYDateFormat();
/* 218 */     if (yf != null) {
/* 219 */       result[2] = yf.format(y);
/*     */     } else {
/*     */       
/* 222 */       result[2] = getYFormat().format(y);
/*     */     } 
/*     */     
/* 225 */     Number z = dataset.getZ(series, item);
/* 226 */     if (this.zDateFormat != null) {
/* 227 */       result[3] = this.zDateFormat.format(z);
/*     */     } else {
/*     */       
/* 230 */       result[3] = this.zFormat.format(z);
/*     */     } 
/*     */     
/* 233 */     return result;
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
/*     */   public boolean equals(Object obj) {
/* 246 */     if (obj == this) {
/* 247 */       return true;
/*     */     }
/* 249 */     if (!(obj instanceof BubbleXYItemLabelGenerator)) {
/* 250 */       return false;
/*     */     }
/* 252 */     if (!super.equals(obj)) {
/* 253 */       return false;
/*     */     }
/* 255 */     BubbleXYItemLabelGenerator that = (BubbleXYItemLabelGenerator)obj;
/* 256 */     if (!ObjectUtilities.equal(this.zFormat, that.zFormat)) {
/* 257 */       return false;
/*     */     }
/* 259 */     if (!ObjectUtilities.equal(this.zDateFormat, that.zDateFormat)) {
/* 260 */       return false;
/*     */     }
/* 262 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 272 */     h = super.hashCode();
/* 273 */     h = HashUtilities.hashCode(h, this.zFormat);
/* 274 */     return HashUtilities.hashCode(h, this.zDateFormat);
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/labels/BubbleXYItemLabelGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */