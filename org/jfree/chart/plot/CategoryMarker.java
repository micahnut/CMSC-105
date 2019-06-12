/*     */ package org.jfree.chart.plot;
/*     */ 
/*     */ import java.awt.BasicStroke;
/*     */ import java.awt.Color;
/*     */ import java.awt.Paint;
/*     */ import java.awt.Stroke;
/*     */ import java.io.Serializable;
/*     */ import org.jfree.chart.event.MarkerChangeEvent;
/*     */ import org.jfree.chart.util.ParamChecks;
/*     */ import org.jfree.ui.LengthAdjustmentType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CategoryMarker
/*     */   extends Marker
/*     */   implements Cloneable, Serializable
/*     */ {
/*     */   private Comparable key;
/*     */   private boolean drawAsLine = false;
/*     */   
/*  81 */   public CategoryMarker(Comparable key) { this(key, Color.gray, new BasicStroke(1.0F)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  92 */   public CategoryMarker(Comparable key, Paint paint, Stroke stroke) { this(key, paint, stroke, paint, stroke, 1.0F); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CategoryMarker(Comparable key, Paint paint, Stroke stroke, Paint outlinePaint, Stroke outlineStroke, float alpha) {
/* 108 */     super(paint, stroke, outlinePaint, outlineStroke, alpha);
/* 109 */     this.key = key;
/* 110 */     setLabelOffsetType(LengthAdjustmentType.EXPAND);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 119 */   public Comparable getKey() { return this.key; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setKey(Comparable key) {
/* 131 */     ParamChecks.nullNotPermitted(key, "key");
/* 132 */     this.key = key;
/* 133 */     notifyListeners(new MarkerChangeEvent(this));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 143 */   public boolean getDrawAsLine() { return this.drawAsLine; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDrawAsLine(boolean drawAsLine) {
/* 154 */     this.drawAsLine = drawAsLine;
/* 155 */     notifyListeners(new MarkerChangeEvent(this));
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
/*     */   public boolean equals(Object obj) {
/* 167 */     if (obj == null) {
/* 168 */       return false;
/*     */     }
/* 170 */     if (!(obj instanceof CategoryMarker)) {
/* 171 */       return false;
/*     */     }
/* 173 */     if (!super.equals(obj)) {
/* 174 */       return false;
/*     */     }
/* 176 */     CategoryMarker that = (CategoryMarker)obj;
/* 177 */     if (!this.key.equals(that.key)) {
/* 178 */       return false;
/*     */     }
/* 180 */     if (this.drawAsLine != that.drawAsLine) {
/* 181 */       return false;
/*     */     }
/* 183 */     return true;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/plot/CategoryMarker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */