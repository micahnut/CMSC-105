/*     */ package org.jfree.chart.plot.dial;
/*     */ 
/*     */ import java.awt.BasicStroke;
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Paint;
/*     */ import java.awt.Stroke;
/*     */ import java.awt.geom.Ellipse2D;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import org.jfree.chart.HashUtilities;
/*     */ import org.jfree.chart.util.ParamChecks;
/*     */ import org.jfree.io.SerialUtilities;
/*     */ import org.jfree.util.PaintUtilities;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DialCap
/*     */   extends AbstractDialLayer
/*     */   implements DialLayer, Cloneable, PublicCloneable, Serializable
/*     */ {
/*     */   static final long serialVersionUID = -2929484264982524463L;
/*     */   private double radius;
/*     */   private Paint fillPaint;
/*     */   private Paint outlinePaint;
/*     */   private Stroke outlineStroke;
/*     */   
/*     */   public DialCap() {
/* 104 */     this.radius = 0.05D;
/* 105 */     this.fillPaint = Color.white;
/* 106 */     this.outlinePaint = Color.black;
/* 107 */     this.outlineStroke = new BasicStroke(2.0F);
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
/* 119 */   public double getRadius() { return this.radius; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRadius(double radius) {
/* 132 */     if (radius <= 0.0D) {
/* 133 */       throw new IllegalArgumentException("Requires radius > 0.0.");
/*     */     }
/* 135 */     this.radius = radius;
/* 136 */     notifyListeners(new DialLayerChangeEvent(this));
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
/* 147 */   public Paint getFillPaint() { return this.fillPaint; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFillPaint(Paint paint) {
/* 159 */     ParamChecks.nullNotPermitted(paint, "paint");
/* 160 */     this.fillPaint = paint;
/* 161 */     notifyListeners(new DialLayerChangeEvent(this));
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
/* 172 */   public Paint getOutlinePaint() { return this.outlinePaint; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOutlinePaint(Paint paint) {
/* 184 */     ParamChecks.nullNotPermitted(paint, "paint");
/* 185 */     this.outlinePaint = paint;
/* 186 */     notifyListeners(new DialLayerChangeEvent(this));
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
/* 197 */   public Stroke getOutlineStroke() { return this.outlineStroke; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOutlineStroke(Stroke stroke) {
/* 209 */     ParamChecks.nullNotPermitted(stroke, "stroke");
/* 210 */     this.outlineStroke = stroke;
/* 211 */     notifyListeners(new DialLayerChangeEvent(this));
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
/* 222 */   public boolean isClippedToWindow() { return true; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void draw(Graphics2D g2, DialPlot plot, Rectangle2D frame, Rectangle2D view) {
/* 239 */     g2.setPaint(this.fillPaint);
/*     */     
/* 241 */     Rectangle2D f = DialPlot.rectangleByRadius(frame, this.radius, this.radius);
/*     */ 
/*     */     
/* 244 */     Ellipse2D e = new Ellipse2D.Double(f.getX(), f.getY(), f.getWidth(), f.getHeight());
/* 245 */     g2.fill(e);
/* 246 */     g2.setPaint(this.outlinePaint);
/* 247 */     g2.setStroke(this.outlineStroke);
/* 248 */     g2.draw(e);
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
/* 261 */     if (obj == this) {
/* 262 */       return true;
/*     */     }
/* 264 */     if (!(obj instanceof DialCap)) {
/* 265 */       return false;
/*     */     }
/* 267 */     DialCap that = (DialCap)obj;
/* 268 */     if (this.radius != that.radius) {
/* 269 */       return false;
/*     */     }
/* 271 */     if (!PaintUtilities.equal(this.fillPaint, that.fillPaint)) {
/* 272 */       return false;
/*     */     }
/* 274 */     if (!PaintUtilities.equal(this.outlinePaint, that.outlinePaint)) {
/* 275 */       return false;
/*     */     }
/* 277 */     if (!this.outlineStroke.equals(that.outlineStroke)) {
/* 278 */       return false;
/*     */     }
/* 280 */     return super.equals(obj);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 290 */     result = 193;
/* 291 */     result = 37 * result + HashUtilities.hashCodeForPaint(this.fillPaint);
/* 292 */     result = 37 * result + HashUtilities.hashCodeForPaint(this.outlinePaint);
/*     */     
/* 294 */     return 37 * result + this.outlineStroke.hashCode();
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
/* 308 */   public Object clone() throws CloneNotSupportedException { return super.clone(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void writeObject(ObjectOutputStream stream) throws IOException {
/* 319 */     stream.defaultWriteObject();
/* 320 */     SerialUtilities.writePaint(this.fillPaint, stream);
/* 321 */     SerialUtilities.writePaint(this.outlinePaint, stream);
/* 322 */     SerialUtilities.writeStroke(this.outlineStroke, stream);
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
/*     */   private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
/* 335 */     stream.defaultReadObject();
/* 336 */     this.fillPaint = SerialUtilities.readPaint(stream);
/* 337 */     this.outlinePaint = SerialUtilities.readPaint(stream);
/* 338 */     this.outlineStroke = SerialUtilities.readStroke(stream);
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/plot/dial/DialCap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */