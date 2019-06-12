/*     */ package org.jfree.chart.plot.dial;
/*     */ 
/*     */ import java.awt.BasicStroke;
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Paint;
/*     */ import java.awt.Shape;
/*     */ import java.awt.Stroke;
/*     */ import java.awt.geom.Area;
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
/*     */ public class StandardDialFrame
/*     */   extends AbstractDialLayer
/*     */   implements DialFrame, Cloneable, PublicCloneable, Serializable
/*     */ {
/*     */   static final long serialVersionUID = 1016585407507121596L;
/*     */   private double radius;
/*     */   private Paint backgroundPaint;
/*     */   private Paint foregroundPaint;
/*     */   private Stroke stroke;
/*     */   
/*     */   public StandardDialFrame() {
/* 102 */     this.backgroundPaint = Color.gray;
/* 103 */     this.foregroundPaint = Color.black;
/* 104 */     this.stroke = new BasicStroke(2.0F);
/* 105 */     this.radius = 0.95D;
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
/* 116 */   public double getRadius() { return this.radius; }
/*     */ 
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
/* 128 */     if (radius <= 0.0D) {
/* 129 */       throw new IllegalArgumentException("The 'radius' must be positive.");
/*     */     }
/*     */     
/* 132 */     this.radius = radius;
/* 133 */     notifyListeners(new DialLayerChangeEvent(this));
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
/* 144 */   public Paint getBackgroundPaint() { return this.backgroundPaint; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBackgroundPaint(Paint paint) {
/* 156 */     ParamChecks.nullNotPermitted(paint, "paint");
/* 157 */     this.backgroundPaint = paint;
/* 158 */     notifyListeners(new DialLayerChangeEvent(this));
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
/* 169 */   public Paint getForegroundPaint() { return this.foregroundPaint; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setForegroundPaint(Paint paint) {
/* 181 */     ParamChecks.nullNotPermitted(paint, "paint");
/* 182 */     this.foregroundPaint = paint;
/* 183 */     notifyListeners(new DialLayerChangeEvent(this));
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
/* 194 */   public Stroke getStroke() { return this.stroke; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStroke(Stroke stroke) {
/* 206 */     ParamChecks.nullNotPermitted(stroke, "stroke");
/* 207 */     this.stroke = stroke;
/* 208 */     notifyListeners(new DialLayerChangeEvent(this));
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
/*     */   public Shape getWindow(Rectangle2D frame) {
/* 221 */     Rectangle2D f = DialPlot.rectangleByRadius(frame, this.radius, this.radius);
/*     */     
/* 223 */     return new Ellipse2D.Double(f.getX(), f.getY(), f.getWidth(), f
/* 224 */         .getHeight());
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
/* 235 */   public boolean isClippedToWindow() { return false; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 251 */     Shape window = getWindow(frame);
/*     */     
/* 253 */     Rectangle2D f = DialPlot.rectangleByRadius(frame, this.radius + 0.02D, this.radius + 0.02D);
/*     */ 
/*     */     
/* 256 */     Ellipse2D e = new Ellipse2D.Double(f.getX(), f.getY(), f.getWidth(), f.getHeight());
/*     */     
/* 258 */     Area area = new Area(e);
/* 259 */     Area area2 = new Area(window);
/* 260 */     area.subtract(area2);
/* 261 */     g2.setPaint(this.backgroundPaint);
/* 262 */     g2.fill(area);
/*     */     
/* 264 */     g2.setStroke(this.stroke);
/* 265 */     g2.setPaint(this.foregroundPaint);
/* 266 */     g2.draw(window);
/* 267 */     g2.draw(e);
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
/* 279 */     if (obj == this) {
/* 280 */       return true;
/*     */     }
/* 282 */     if (!(obj instanceof StandardDialFrame)) {
/* 283 */       return false;
/*     */     }
/* 285 */     StandardDialFrame that = (StandardDialFrame)obj;
/* 286 */     if (!PaintUtilities.equal(this.backgroundPaint, that.backgroundPaint)) {
/* 287 */       return false;
/*     */     }
/* 289 */     if (!PaintUtilities.equal(this.foregroundPaint, that.foregroundPaint)) {
/* 290 */       return false;
/*     */     }
/* 292 */     if (this.radius != that.radius) {
/* 293 */       return false;
/*     */     }
/* 295 */     if (!this.stroke.equals(that.stroke)) {
/* 296 */       return false;
/*     */     }
/* 298 */     return super.equals(obj);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 308 */     result = 193;
/* 309 */     long temp = Double.doubleToLongBits(this.radius);
/* 310 */     result = 37 * result + (int)(temp ^ temp >>> 32);
/* 311 */     result = 37 * result + HashUtilities.hashCodeForPaint(this.backgroundPaint);
/*     */     
/* 313 */     result = 37 * result + HashUtilities.hashCodeForPaint(this.foregroundPaint);
/*     */     
/* 315 */     return 37 * result + this.stroke.hashCode();
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
/* 329 */   public Object clone() throws CloneNotSupportedException { return super.clone(); }
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
/* 340 */     stream.defaultWriteObject();
/* 341 */     SerialUtilities.writePaint(this.backgroundPaint, stream);
/* 342 */     SerialUtilities.writePaint(this.foregroundPaint, stream);
/* 343 */     SerialUtilities.writeStroke(this.stroke, stream);
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
/* 356 */     stream.defaultReadObject();
/* 357 */     this.backgroundPaint = SerialUtilities.readPaint(stream);
/* 358 */     this.foregroundPaint = SerialUtilities.readPaint(stream);
/* 359 */     this.stroke = SerialUtilities.readStroke(stream);
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/plot/dial/StandardDialFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */