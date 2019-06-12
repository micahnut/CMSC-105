/*     */ package org.jfree.chart.axis;
/*     */ 
/*     */ import java.text.FieldPosition;
/*     */ import java.text.NumberFormat;
/*     */ import java.text.ParsePosition;
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
/*     */ public class CompassFormat
/*     */   extends NumberFormat
/*     */ {
/*     */   public final String[] directions;
/*     */   
/*  62 */   public CompassFormat() { this("N", "E", "S", "W"); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  77 */   public CompassFormat(String n, String e, String s, String w) { this(new String[] { n, n + n + e, n + e, e + n + e, e, e + s + e, s + e, s + s + e, s, s + s + w, s + w, w + s + w, w, w + n + w, n + w, n + n + w }); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CompassFormat(String[] directions) {
/*  93 */     ParamChecks.nullNotPermitted(directions, "directions");
/*  94 */     if (directions.length != 16) {
/*  95 */       throw new IllegalArgumentException("The 'directions' array must contain exactly 16 elements");
/*     */     }
/*     */     
/*  98 */     this.directions = directions;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDirectionCode(double direction) {
/* 109 */     direction %= 360.0D;
/* 110 */     if (direction < 0.0D) {
/* 111 */       direction += 360.0D;
/*     */     }
/* 113 */     int index = ((int)Math.floor(direction / 11.25D) + 1) / 2;
/* 114 */     return this.directions[index];
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
/* 129 */   public StringBuffer format(double number, StringBuffer toAppendTo, FieldPosition pos) { return toAppendTo.append(getDirectionCode(number)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 144 */   public StringBuffer format(long number, StringBuffer toAppendTo, FieldPosition pos) { return toAppendTo.append(getDirectionCode(number)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 158 */   public Number parse(String source, ParsePosition parsePosition) { return null; }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/axis/CompassFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */