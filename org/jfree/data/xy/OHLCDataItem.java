/*     */ package org.jfree.data.xy;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import org.jfree.chart.util.ParamChecks;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class OHLCDataItem
/*     */   implements Comparable, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 7753817154401169901L;
/*     */   private Date date;
/*     */   private Number open;
/*     */   private Number high;
/*     */   private Number low;
/*     */   private Number close;
/*     */   private Number volume;
/*     */   
/*     */   public OHLCDataItem(Date date, double open, double high, double low, double close, double volume) {
/*  90 */     ParamChecks.nullNotPermitted(date, "date");
/*  91 */     this.date = date;
/*  92 */     this.open = new Double(open);
/*  93 */     this.high = new Double(high);
/*  94 */     this.low = new Double(low);
/*  95 */     this.close = new Double(close);
/*  96 */     this.volume = new Double(volume);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 105 */   public Date getDate() { return this.date; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 114 */   public Number getOpen() { return this.open; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 123 */   public Number getHigh() { return this.high; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 132 */   public Number getLow() { return this.low; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 141 */   public Number getClose() { return this.close; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 150 */   public Number getVolume() { return this.volume; }
/*     */ 
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
/* 162 */     if (obj == this) {
/* 163 */       return true;
/*     */     }
/* 165 */     if (!(obj instanceof OHLCDataItem)) {
/* 166 */       return false;
/*     */     }
/* 168 */     OHLCDataItem that = (OHLCDataItem)obj;
/* 169 */     if (!this.date.equals(that.date)) {
/* 170 */       return false;
/*     */     }
/* 172 */     if (!this.high.equals(that.high)) {
/* 173 */       return false;
/*     */     }
/* 175 */     if (!this.low.equals(that.low)) {
/* 176 */       return false;
/*     */     }
/* 178 */     if (!this.open.equals(that.open)) {
/* 179 */       return false;
/*     */     }
/* 181 */     if (!this.close.equals(that.close)) {
/* 182 */       return false;
/*     */     }
/* 184 */     return true;
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
/*     */   public int compareTo(Object object) {
/* 199 */     if (object instanceof OHLCDataItem) {
/* 200 */       OHLCDataItem item = (OHLCDataItem)object;
/* 201 */       return this.date.compareTo(item.date);
/*     */     } 
/*     */     
/* 204 */     throw new ClassCastException("OHLCDataItem.compareTo().");
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/xy/OHLCDataItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */