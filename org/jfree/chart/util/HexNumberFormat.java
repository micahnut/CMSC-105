/*     */ package org.jfree.chart.util;
/*     */ 
/*     */ import java.text.FieldPosition;
/*     */ import java.text.NumberFormat;
/*     */ import java.text.ParsePosition;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HexNumberFormat
/*     */   extends NumberFormat
/*     */ {
/*     */   public static final int BYTE = 2;
/*     */   public static final int WORD = 4;
/*     */   public static final int DWORD = 8;
/*     */   public static final int QWORD = 16;
/*  68 */   private int m_numDigits = 8;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  74 */   public HexNumberFormat() { this(8); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  84 */   public HexNumberFormat(int digits) { this.m_numDigits = digits; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  93 */   public final int getNumberOfDigits() { return this.m_numDigits; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 102 */   public void setNumberOfDigits(int digits) { this.m_numDigits = digits; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 118 */   public StringBuffer format(double number, StringBuffer toAppendTo, FieldPosition pos) { return format((long)number, toAppendTo, pos); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StringBuffer format(long number, StringBuffer toAppendTo, FieldPosition pos) {
/* 134 */     String l_hex = Long.toHexString(number).toUpperCase();
/*     */     
/* 136 */     int l_pad = this.m_numDigits - l_hex.length();
/* 137 */     l_pad = (0 < l_pad) ? l_pad : 0;
/*     */     
/* 139 */     StringBuffer l_extended = new StringBuffer("0x");
/* 140 */     for (int i = 0; i < l_pad; i++) {
/* 141 */       l_extended.append(0);
/*     */     }
/* 143 */     l_extended.append(l_hex);
/*     */     
/* 145 */     return l_extended;
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
/* 159 */   public Number parse(String source, ParsePosition parsePosition) { return null; }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/util/HexNumberFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */