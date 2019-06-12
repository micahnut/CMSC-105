/*     */ package org.jfree.data.time.ohlc;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import org.jfree.chart.HashUtilities;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class OHLC
/*     */   implements Serializable
/*     */ {
/*     */   private double open;
/*     */   private double close;
/*     */   private double high;
/*     */   private double low;
/*     */   
/*     */   public OHLC(double open, double high, double low, double close) {
/*  76 */     this.open = open;
/*  77 */     this.close = close;
/*  78 */     this.high = high;
/*  79 */     this.low = low;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  88 */   public double getOpen() { return this.open; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  97 */   public double getClose() { return this.close; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 106 */   public double getHigh() { return this.high; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 115 */   public double getLow() { return this.low; }
/*     */ 
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
/* 127 */     if (obj == this) {
/* 128 */       return true;
/*     */     }
/* 130 */     if (!(obj instanceof OHLC)) {
/* 131 */       return false;
/*     */     }
/* 133 */     OHLC that = (OHLC)obj;
/* 134 */     if (this.open != that.open) {
/* 135 */       return false;
/*     */     }
/* 137 */     if (this.close != that.close) {
/* 138 */       return false;
/*     */     }
/* 140 */     if (this.high != that.high) {
/* 141 */       return false;
/*     */     }
/* 143 */     if (this.low != that.low) {
/* 144 */       return false;
/*     */     }
/* 146 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 156 */     result = 193;
/* 157 */     result = HashUtilities.hashCode(result, this.open);
/* 158 */     result = HashUtilities.hashCode(result, this.high);
/* 159 */     result = HashUtilities.hashCode(result, this.low);
/* 160 */     return HashUtilities.hashCode(result, this.close);
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/time/ohlc/OHLC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */