/*     */ package org.jfree.chart.title;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.Paint;
/*     */ import java.io.Serializable;
/*     */ import java.text.DateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.Locale;
/*     */ import org.jfree.ui.HorizontalAlignment;
/*     */ import org.jfree.ui.RectangleEdge;
/*     */ import org.jfree.ui.RectangleInsets;
/*     */ import org.jfree.ui.VerticalAlignment;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DateTitle
/*     */   extends TextTitle
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -465434812763159881L;
/*     */   
/*  89 */   public DateTitle() { this(1); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 103 */   public DateTitle(int style) { this(style, Locale.getDefault(), new Font("Dialog", false, 12), Color.black); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 123 */   public DateTitle(int style, Locale locale, Font font, Paint paint) { this(style, locale, font, paint, RectangleEdge.BOTTOM, HorizontalAlignment.RIGHT, VerticalAlignment.CENTER, Title.DEFAULT_PADDING); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 154 */   public DateTitle(int style, Locale locale, Font font, Paint paint, RectangleEdge position, HorizontalAlignment horizontalAlignment, VerticalAlignment verticalAlignment, RectangleInsets padding) { super(DateFormat.getDateInstance(style, locale).format(new Date()), font, paint, position, horizontalAlignment, verticalAlignment, padding); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 173 */   public void setDateFormat(int style, Locale locale) { setText(DateFormat.getDateInstance(style, locale).format(new Date())); }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/title/DateTitle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */