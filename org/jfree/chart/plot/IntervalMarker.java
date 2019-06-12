/*     */ package org.jfree.chart.plot;
/*     */ 
/*     */ import java.awt.BasicStroke;
/*     */ import java.awt.Color;
/*     */ import java.awt.Paint;
/*     */ import java.awt.Stroke;
/*     */ import java.io.Serializable;
/*     */ import org.jfree.chart.event.MarkerChangeEvent;
/*     */ import org.jfree.ui.GradientPaintTransformer;
/*     */ import org.jfree.ui.LengthAdjustmentType;
/*     */ import org.jfree.util.ObjectUtilities;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IntervalMarker
/*     */   extends Marker
/*     */   implements Cloneable, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -1762344775267627916L;
/*     */   private double startValue;
/*     */   private double endValue;
/*     */   private GradientPaintTransformer gradientPaintTransformer;
/*     */   
/*  83 */   public IntervalMarker(double start, double end) { this(start, end, Color.gray, new BasicStroke(0.5F), Color.gray, new BasicStroke(0.5F), 0.8F); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  98 */   public IntervalMarker(double start, double end, Paint paint) { this(start, end, paint, new BasicStroke(0.5F), null, null, 0.8F); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IntervalMarker(double start, double end, Paint paint, Stroke stroke, Paint outlinePaint, Stroke outlineStroke, float alpha) {
/* 117 */     super(paint, stroke, outlinePaint, outlineStroke, alpha);
/* 118 */     this.startValue = start;
/* 119 */     this.endValue = end;
/* 120 */     this.gradientPaintTransformer = null;
/* 121 */     setLabelOffsetType(LengthAdjustmentType.CONTRACT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 131 */   public double getStartValue() { return this.startValue; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStartValue(double value) {
/* 143 */     this.startValue = value;
/* 144 */     notifyListeners(new MarkerChangeEvent(this));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 153 */   public double getEndValue() { return this.endValue; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEndValue(double value) {
/* 165 */     this.endValue = value;
/* 166 */     notifyListeners(new MarkerChangeEvent(this));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 175 */   public GradientPaintTransformer getGradientPaintTransformer() { return this.gradientPaintTransformer; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setGradientPaintTransformer(GradientPaintTransformer transformer) {
/* 186 */     this.gradientPaintTransformer = transformer;
/* 187 */     notifyListeners(new MarkerChangeEvent(this));
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
/* 199 */     if (obj == this) {
/* 200 */       return true;
/*     */     }
/* 202 */     if (!(obj instanceof IntervalMarker)) {
/* 203 */       return false;
/*     */     }
/* 205 */     if (!super.equals(obj)) {
/* 206 */       return false;
/*     */     }
/* 208 */     IntervalMarker that = (IntervalMarker)obj;
/* 209 */     if (this.startValue != that.startValue) {
/* 210 */       return false;
/*     */     }
/* 212 */     if (this.endValue != that.endValue) {
/* 213 */       return false;
/*     */     }
/* 215 */     if (!ObjectUtilities.equal(this.gradientPaintTransformer, that.gradientPaintTransformer))
/*     */     {
/* 217 */       return false;
/*     */     }
/* 219 */     return true;
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
/* 232 */   public Object clone() throws CloneNotSupportedException { return super.clone(); }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/plot/IntervalMarker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */