/*     */ package org.jfree.chart;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Paint;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ChartColor
/*     */   extends Color
/*     */ {
/*  59 */   public static final Color VERY_DARK_RED = new Color('', false, false);
/*     */ 
/*     */   
/*  62 */   public static final Color DARK_RED = new Color('À', false, false);
/*     */ 
/*     */   
/*  65 */   public static final Color LIGHT_RED = new Color('ÿ', 64, 64);
/*     */ 
/*     */   
/*  68 */   public static final Color VERY_LIGHT_RED = new Color('ÿ', '', '');
/*     */ 
/*     */   
/*  71 */   public static final Color VERY_DARK_YELLOW = new Color('', '', false);
/*     */ 
/*     */   
/*  74 */   public static final Color DARK_YELLOW = new Color('À', 'À', false);
/*     */ 
/*     */   
/*  77 */   public static final Color LIGHT_YELLOW = new Color('ÿ', 'ÿ', 64);
/*     */ 
/*     */   
/*  80 */   public static final Color VERY_LIGHT_YELLOW = new Color('ÿ', 'ÿ', '');
/*     */ 
/*     */   
/*  83 */   public static final Color VERY_DARK_GREEN = new Color(false, '', false);
/*     */ 
/*     */   
/*  86 */   public static final Color DARK_GREEN = new Color(false, 'À', false);
/*     */ 
/*     */   
/*  89 */   public static final Color LIGHT_GREEN = new Color(64, 'ÿ', 64);
/*     */ 
/*     */   
/*  92 */   public static final Color VERY_LIGHT_GREEN = new Color('', 'ÿ', '');
/*     */ 
/*     */   
/*  95 */   public static final Color VERY_DARK_CYAN = new Color(false, '', '');
/*     */ 
/*     */   
/*  98 */   public static final Color DARK_CYAN = new Color(false, 'À', 'À');
/*     */ 
/*     */   
/* 101 */   public static final Color LIGHT_CYAN = new Color(64, 'ÿ', 'ÿ');
/*     */ 
/*     */   
/* 104 */   public static final Color VERY_LIGHT_CYAN = new Color('', 'ÿ', 'ÿ');
/*     */ 
/*     */   
/* 107 */   public static final Color VERY_DARK_BLUE = new Color(false, false, '');
/*     */ 
/*     */   
/* 110 */   public static final Color DARK_BLUE = new Color(false, false, 'À');
/*     */ 
/*     */   
/* 113 */   public static final Color LIGHT_BLUE = new Color(64, 64, 'ÿ');
/*     */ 
/*     */   
/* 116 */   public static final Color VERY_LIGHT_BLUE = new Color('', '', 'ÿ');
/*     */ 
/*     */   
/* 119 */   public static final Color VERY_DARK_MAGENTA = new Color('', false, '');
/*     */ 
/*     */   
/* 122 */   public static final Color DARK_MAGENTA = new Color('À', false, 'À');
/*     */ 
/*     */   
/* 125 */   public static final Color LIGHT_MAGENTA = new Color('ÿ', 64, 'ÿ');
/*     */ 
/*     */   
/* 128 */   public static final Color VERY_LIGHT_MAGENTA = new Color('ÿ', '', 'ÿ');
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 139 */   public ChartColor(int r, int g, int b) { super(r, g, b); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 151 */   public static Paint[] createDefaultPaintArray() { return new Paint[] { new Color('ÿ', 85, 85), new Color(85, 85, 'ÿ'), new Color(85, 'ÿ', 85), new Color('ÿ', 'ÿ', 85), new Color('ÿ', 85, 'ÿ'), new Color(85, 'ÿ', 'ÿ'), Color.pink, Color.gray, DARK_RED, DARK_BLUE, DARK_GREEN, DARK_YELLOW, DARK_MAGENTA, DARK_CYAN, Color.darkGray, LIGHT_RED, LIGHT_BLUE, LIGHT_GREEN, LIGHT_YELLOW, LIGHT_MAGENTA, LIGHT_CYAN, Color.lightGray, VERY_DARK_RED, VERY_DARK_BLUE, VERY_DARK_GREEN, VERY_DARK_YELLOW, VERY_DARK_MAGENTA, VERY_DARK_CYAN, VERY_LIGHT_RED, VERY_LIGHT_BLUE, VERY_LIGHT_GREEN, VERY_LIGHT_YELLOW, VERY_LIGHT_MAGENTA, VERY_LIGHT_CYAN }; }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/ChartColor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */