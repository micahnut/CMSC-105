/*     */ package org.jfree.chart.plot.dial;
/*     */ 
/*     */ import java.awt.BasicStroke;
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Paint;
/*     */ import java.awt.Shape;
/*     */ import java.awt.Stroke;
/*     */ import java.awt.geom.Arc2D;
/*     */ import java.awt.geom.Area;
/*     */ import java.awt.geom.GeneralPath;
/*     */ import java.awt.geom.Point2D;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ArcDialFrame
/*     */   extends AbstractDialLayer
/*     */   implements DialFrame, Cloneable, PublicCloneable, Serializable
/*     */ {
/*     */   static final long serialVersionUID = -4089176959553523499L;
/*     */   private Paint backgroundPaint;
/*     */   private Paint foregroundPaint;
/*     */   private Stroke stroke;
/*     */   private double startAngle;
/*     */   private double extent;
/*     */   private double innerRadius;
/*     */   private double outerRadius;
/*     */   
/* 119 */   public ArcDialFrame() { this(0.0D, 180.0D); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArcDialFrame(double startAngle, double extent) {
/* 130 */     this.backgroundPaint = Color.gray;
/* 131 */     this.foregroundPaint = new Color(100, 100, '');
/* 132 */     this.stroke = new BasicStroke(2.0F);
/* 133 */     this.innerRadius = 0.25D;
/* 134 */     this.outerRadius = 0.75D;
/* 135 */     this.startAngle = startAngle;
/* 136 */     this.extent = extent;
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
/* 147 */   public Paint getBackgroundPaint() { return this.backgroundPaint; }
/*     */ 
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
/* 159 */     ParamChecks.nullNotPermitted(paint, "paint");
/* 160 */     this.backgroundPaint = paint;
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
/* 172 */   public Paint getForegroundPaint() { return this.foregroundPaint; }
/*     */ 
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
/* 184 */     ParamChecks.nullNotPermitted(paint, "paint");
/* 185 */     this.foregroundPaint = paint;
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
/* 197 */   public Stroke getStroke() { return this.stroke; }
/*     */ 
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
/* 209 */     ParamChecks.nullNotPermitted(stroke, "stroke");
/* 210 */     this.stroke = stroke;
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
/* 222 */   public double getInnerRadius() { return this.innerRadius; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInnerRadius(double radius) {
/* 234 */     if (radius < 0.0D) {
/* 235 */       throw new IllegalArgumentException("Negative 'radius' argument.");
/*     */     }
/* 237 */     this.innerRadius = radius;
/* 238 */     notifyListeners(new DialLayerChangeEvent(this));
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
/* 249 */   public double getOuterRadius() { return this.outerRadius; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOuterRadius(double radius) {
/* 261 */     if (radius < 0.0D) {
/* 262 */       throw new IllegalArgumentException("Negative 'radius' argument.");
/*     */     }
/* 264 */     this.outerRadius = radius;
/* 265 */     notifyListeners(new DialLayerChangeEvent(this));
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
/* 276 */   public double getStartAngle() { return this.startAngle; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStartAngle(double angle) {
/* 288 */     this.startAngle = angle;
/* 289 */     notifyListeners(new DialLayerChangeEvent(this));
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
/* 300 */   public double getExtent() { return this.extent; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExtent(double extent) {
/* 312 */     this.extent = extent;
/* 313 */     notifyListeners(new DialLayerChangeEvent(this));
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
/*     */   public Shape getWindow(Rectangle2D frame) {
/* 327 */     Rectangle2D innerFrame = DialPlot.rectangleByRadius(frame, this.innerRadius, this.innerRadius);
/*     */     
/* 329 */     Rectangle2D outerFrame = DialPlot.rectangleByRadius(frame, this.outerRadius, this.outerRadius);
/*     */     
/* 331 */     Arc2D inner = new Arc2D.Double(innerFrame, this.startAngle, this.extent, false);
/*     */     
/* 333 */     Arc2D outer = new Arc2D.Double(outerFrame, this.startAngle + this.extent, -this.extent, false);
/*     */     
/* 335 */     GeneralPath p = new GeneralPath();
/* 336 */     Point2D point1 = inner.getStartPoint();
/* 337 */     p.moveTo((float)point1.getX(), (float)point1.getY());
/* 338 */     p.append(inner, true);
/* 339 */     p.append(outer, true);
/* 340 */     p.closePath();
/* 341 */     return p;
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
/*     */   protected Shape getOuterWindow(Rectangle2D frame) {
/* 353 */     double radiusMargin = 0.02D;
/* 354 */     double angleMargin = 1.5D;
/* 355 */     Rectangle2D innerFrame = DialPlot.rectangleByRadius(frame, this.innerRadius - radiusMargin, this.innerRadius - radiusMargin);
/*     */ 
/*     */     
/* 358 */     Rectangle2D outerFrame = DialPlot.rectangleByRadius(frame, this.outerRadius + radiusMargin, this.outerRadius + radiusMargin);
/*     */ 
/*     */     
/* 361 */     Arc2D inner = new Arc2D.Double(innerFrame, this.startAngle - angleMargin, this.extent + 2.0D * angleMargin, false);
/*     */     
/* 363 */     Arc2D outer = new Arc2D.Double(outerFrame, this.startAngle + angleMargin + this.extent, -this.extent - 2.0D * angleMargin, false);
/*     */ 
/*     */     
/* 366 */     GeneralPath p = new GeneralPath();
/* 367 */     Point2D point1 = inner.getStartPoint();
/* 368 */     p.moveTo((float)point1.getX(), (float)point1.getY());
/* 369 */     p.append(inner, true);
/* 370 */     p.append(outer, true);
/* 371 */     p.closePath();
/* 372 */     return p;
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
/*     */   public void draw(Graphics2D g2, DialPlot plot, Rectangle2D frame, Rectangle2D view) {
/* 387 */     Shape window = getWindow(frame);
/* 388 */     Shape outerWindow = getOuterWindow(frame);
/*     */     
/* 390 */     Area area1 = new Area(outerWindow);
/* 391 */     Area area2 = new Area(window);
/* 392 */     area1.subtract(area2);
/* 393 */     g2.setPaint(Color.lightGray);
/* 394 */     g2.fill(area1);
/*     */     
/* 396 */     g2.setStroke(this.stroke);
/* 397 */     g2.setPaint(this.foregroundPaint);
/* 398 */     g2.draw(window);
/* 399 */     g2.draw(outerWindow);
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
/* 411 */   public boolean isClippedToWindow() { return false; }
/*     */ 
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
/* 423 */     if (obj == this) {
/* 424 */       return true;
/*     */     }
/* 426 */     if (!(obj instanceof ArcDialFrame)) {
/* 427 */       return false;
/*     */     }
/* 429 */     ArcDialFrame that = (ArcDialFrame)obj;
/* 430 */     if (!PaintUtilities.equal(this.backgroundPaint, that.backgroundPaint)) {
/* 431 */       return false;
/*     */     }
/* 433 */     if (!PaintUtilities.equal(this.foregroundPaint, that.foregroundPaint)) {
/* 434 */       return false;
/*     */     }
/* 436 */     if (this.startAngle != that.startAngle) {
/* 437 */       return false;
/*     */     }
/* 439 */     if (this.extent != that.extent) {
/* 440 */       return false;
/*     */     }
/* 442 */     if (this.innerRadius != that.innerRadius) {
/* 443 */       return false;
/*     */     }
/* 445 */     if (this.outerRadius != that.outerRadius) {
/* 446 */       return false;
/*     */     }
/* 448 */     if (!this.stroke.equals(that.stroke)) {
/* 449 */       return false;
/*     */     }
/* 451 */     return super.equals(obj);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 461 */     result = 193;
/* 462 */     long temp = Double.doubleToLongBits(this.startAngle);
/* 463 */     result = 37 * result + (int)(temp ^ temp >>> 32);
/* 464 */     temp = Double.doubleToLongBits(this.extent);
/* 465 */     result = 37 * result + (int)(temp ^ temp >>> 32);
/* 466 */     temp = Double.doubleToLongBits(this.innerRadius);
/* 467 */     result = 37 * result + (int)(temp ^ temp >>> 32);
/* 468 */     temp = Double.doubleToLongBits(this.outerRadius);
/* 469 */     result = 37 * result + (int)(temp ^ temp >>> 32);
/* 470 */     result = 37 * result + HashUtilities.hashCodeForPaint(this.backgroundPaint);
/*     */     
/* 472 */     result = 37 * result + HashUtilities.hashCodeForPaint(this.foregroundPaint);
/*     */     
/* 474 */     return 37 * result + this.stroke.hashCode();
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
/* 488 */   public Object clone() throws CloneNotSupportedException { return super.clone(); }
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
/* 499 */     stream.defaultWriteObject();
/* 500 */     SerialUtilities.writePaint(this.backgroundPaint, stream);
/* 501 */     SerialUtilities.writePaint(this.foregroundPaint, stream);
/* 502 */     SerialUtilities.writeStroke(this.stroke, stream);
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
/* 515 */     stream.defaultReadObject();
/* 516 */     this.backgroundPaint = SerialUtilities.readPaint(stream);
/* 517 */     this.foregroundPaint = SerialUtilities.readPaint(stream);
/* 518 */     this.stroke = SerialUtilities.readStroke(stream);
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/plot/dial/ArcDialFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */