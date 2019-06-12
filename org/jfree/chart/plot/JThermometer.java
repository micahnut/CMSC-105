/*     */ package org.jfree.chart.plot;
/*     */ 
/*     */ import java.awt.CardLayout;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.Paint;
/*     */ import java.io.Serializable;
/*     */ import java.text.DecimalFormat;
/*     */ import javax.swing.JPanel;
/*     */ import org.jfree.chart.ChartPanel;
/*     */ import org.jfree.chart.JFreeChart;
/*     */ import org.jfree.chart.axis.ValueAxis;
/*     */ import org.jfree.chart.title.TextTitle;
/*     */ import org.jfree.chart.title.Title;
/*     */ import org.jfree.data.general.DefaultValueDataset;
/*     */ import org.jfree.ui.RectangleInsets;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JThermometer
/*     */   extends JPanel
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1079905665515589820L;
/*     */   private DefaultValueDataset data;
/*     */   private JFreeChart chart;
/*     */   private ChartPanel panel;
/*  85 */   private ThermometerPlot plot = new ThermometerPlot();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JThermometer() {
/*  91 */     super(new CardLayout());
/*  92 */     this.plot.setInsets(new RectangleInsets(5.0D, 5.0D, 5.0D, 5.0D));
/*  93 */     this.data = new DefaultValueDataset();
/*  94 */     this.plot.setDataset(this.data);
/*  95 */     this.chart = new JFreeChart(null, JFreeChart.DEFAULT_TITLE_FONT, this.plot, false);
/*     */     
/*  97 */     this.panel = new ChartPanel(this.chart);
/*  98 */     add(this.panel, "Panel");
/*  99 */     setBackground(getBackground());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 108 */   public void addSubtitle(Title subtitle) { this.chart.addSubtitle(subtitle); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 117 */   public void addSubtitle(String subtitle) { this.chart.addSubtitle(new TextTitle(subtitle)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 127 */   public void addSubtitle(String subtitle, Font font) { this.chart.addSubtitle(new TextTitle(subtitle, font)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 136 */   public void setValueFormat(DecimalFormat df) { this.plot.setValueFormat(df); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 146 */   public void setRange(double lower, double upper) { this.plot.setRange(lower, upper); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 158 */   public void setSubrangeInfo(int range, double displayLow, double displayHigh) { this.plot.setSubrangeInfo(range, displayLow, displayHigh); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 174 */   public void setSubrangeInfo(int range, double rangeLow, double rangeHigh, double displayLow, double displayHigh) { this.plot.setSubrangeInfo(range, rangeLow, rangeHigh, displayLow, displayHigh); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValueLocation(int loc) {
/* 185 */     this.plot.setValueLocation(loc);
/* 186 */     this.panel.repaint();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 195 */   public void setValuePaint(Paint paint) { this.plot.setValuePaint(paint); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Number getValue() {
/* 204 */     if (this.data != null) {
/* 205 */       return this.data.getValue();
/*     */     }
/*     */     
/* 208 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 218 */   public void setValue(double value) { setValue(new Double(value)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(Number value) {
/* 227 */     if (this.data != null) {
/* 228 */       this.data.setValue(value);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUnits(int i) {
/* 238 */     if (this.plot != null) {
/* 239 */       this.plot.setUnits(i);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOutlinePaint(Paint p) {
/* 249 */     if (this.plot != null) {
/* 250 */       this.plot.setOutlinePaint(p);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setForeground(Color fg) {
/* 261 */     super.setForeground(fg);
/* 262 */     if (this.plot != null) {
/* 263 */       this.plot.setThermometerPaint(fg);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBackground(Color bg) {
/* 274 */     super.setBackground(bg);
/* 275 */     if (this.plot != null) {
/* 276 */       this.plot.setBackgroundPaint(bg);
/*     */     }
/* 278 */     if (this.chart != null) {
/* 279 */       this.chart.setBackgroundPaint(bg);
/*     */     }
/* 281 */     if (this.panel != null) {
/* 282 */       this.panel.setBackground(bg);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValueFont(Font f) {
/* 292 */     if (this.plot != null) {
/* 293 */       this.plot.setValueFont(f);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Font getTickLabelFont() {
/* 303 */     ValueAxis axis = this.plot.getRangeAxis();
/* 304 */     return axis.getTickLabelFont();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTickLabelFont(Font font) {
/* 313 */     ValueAxis axis = this.plot.getRangeAxis();
/* 314 */     axis.setTickLabelFont(font);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void changeTickFontSize(int delta) {
/* 323 */     Font f = getTickLabelFont();
/* 324 */     String fName = f.getFontName();
/* 325 */     Font newFont = new Font(fName, f.getStyle(), f.getSize() + delta);
/* 326 */     setTickLabelFont(newFont);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTickFontStyle(int style) {
/* 335 */     Font f = getTickLabelFont();
/* 336 */     String fName = f.getFontName();
/* 337 */     Font newFont = new Font(fName, style, f.getSize());
/* 338 */     setTickLabelFont(newFont);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 348 */   public void setFollowDataInSubranges(boolean flag) { this.plot.setFollowDataInSubranges(flag); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 357 */   public void setShowValueLines(boolean b) { this.plot.setShowValueLines(b); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 366 */   public void setShowAxisLocation(int location) { this.plot.setAxisLocation(location); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 375 */   public int getShowAxisLocation() { return this.plot.getAxisLocation(); }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/plot/JThermometer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */