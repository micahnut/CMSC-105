/*     */ package org.jfree.chart.annotations;
/*     */ 
/*     */ import java.awt.BasicStroke;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Paint;
/*     */ import java.awt.Shape;
/*     */ import java.awt.Stroke;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import org.jfree.chart.HashUtilities;
/*     */ import org.jfree.chart.axis.ValueAxis;
/*     */ import org.jfree.chart.plot.Plot;
/*     */ import org.jfree.chart.plot.PlotOrientation;
/*     */ import org.jfree.chart.plot.PlotRenderingInfo;
/*     */ import org.jfree.chart.plot.XYPlot;
/*     */ import org.jfree.chart.util.ParamChecks;
/*     */ import org.jfree.io.SerialUtilities;
/*     */ import org.jfree.text.TextUtilities;
/*     */ import org.jfree.ui.RectangleEdge;
/*     */ import org.jfree.ui.TextAnchor;
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
/*     */ public class XYTextAnnotation
/*     */   extends AbstractXYAnnotation
/*     */   implements Cloneable, PublicCloneable, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -2946063342782506328L;
/*  97 */   public static final Font DEFAULT_FONT = new Font("SansSerif", false, 10);
/*     */ 
/*     */ 
/*     */   
/* 101 */   public static final Paint DEFAULT_PAINT = Color.black;
/*     */ 
/*     */   
/* 104 */   public static final TextAnchor DEFAULT_TEXT_ANCHOR = TextAnchor.CENTER;
/*     */ 
/*     */   
/* 107 */   public static final TextAnchor DEFAULT_ROTATION_ANCHOR = TextAnchor.CENTER;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final double DEFAULT_ROTATION_ANGLE = 0.0D;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String text;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Font font;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Paint paint;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private double x;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private double y;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private TextAnchor textAnchor;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private TextAnchor rotationAnchor;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private double rotationAngle;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Paint backgroundPaint;
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean outlineVisible;
/*     */ 
/*     */ 
/*     */   
/*     */   private Paint outlinePaint;
/*     */ 
/*     */ 
/*     */   
/*     */   private Stroke outlineStroke;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XYTextAnnotation(String text, double x, double y) {
/* 175 */     ParamChecks.nullNotPermitted(text, "text");
/* 176 */     this.text = text;
/* 177 */     this.font = DEFAULT_FONT;
/* 178 */     this.paint = DEFAULT_PAINT;
/* 179 */     this.x = x;
/* 180 */     this.y = y;
/* 181 */     this.textAnchor = DEFAULT_TEXT_ANCHOR;
/* 182 */     this.rotationAnchor = DEFAULT_ROTATION_ANCHOR;
/* 183 */     this.rotationAngle = 0.0D;
/*     */ 
/*     */     
/* 186 */     this.backgroundPaint = null;
/* 187 */     this.outlineVisible = false;
/* 188 */     this.outlinePaint = Color.black;
/* 189 */     this.outlineStroke = new BasicStroke(0.5F);
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
/* 200 */   public String getText() { return this.text; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setText(String text) {
/* 211 */     ParamChecks.nullNotPermitted(text, "text");
/* 212 */     this.text = text;
/* 213 */     fireAnnotationChanged();
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
/* 224 */   public Font getFont() { return this.font; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFont(Font font) {
/* 236 */     ParamChecks.nullNotPermitted(font, "font");
/* 237 */     this.font = font;
/* 238 */     fireAnnotationChanged();
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
/* 249 */   public Paint getPaint() { return this.paint; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPaint(Paint paint) {
/* 261 */     ParamChecks.nullNotPermitted(paint, "paint");
/* 262 */     this.paint = paint;
/* 263 */     fireAnnotationChanged();
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
/* 274 */   public TextAnchor getTextAnchor() { return this.textAnchor; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTextAnchor(TextAnchor anchor) {
/* 287 */     ParamChecks.nullNotPermitted(anchor, "anchor");
/* 288 */     this.textAnchor = anchor;
/* 289 */     fireAnnotationChanged();
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
/* 300 */   public TextAnchor getRotationAnchor() { return this.rotationAnchor; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotationAnchor(TextAnchor anchor) {
/* 312 */     ParamChecks.nullNotPermitted(anchor, "anchor");
/* 313 */     this.rotationAnchor = anchor;
/* 314 */     fireAnnotationChanged();
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
/* 325 */   public double getRotationAngle() { return this.rotationAngle; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotationAngle(double angle) {
/* 337 */     this.rotationAngle = angle;
/* 338 */     fireAnnotationChanged();
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
/* 350 */   public double getX() { return this.x; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setX(double x) {
/* 363 */     this.x = x;
/* 364 */     fireAnnotationChanged();
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
/* 376 */   public double getY() { return this.y; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setY(double y) {
/* 389 */     this.y = y;
/* 390 */     fireAnnotationChanged();
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
/* 403 */   public Paint getBackgroundPaint() { return this.backgroundPaint; }
/*     */ 
/*     */ 
/*     */ 
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
/* 417 */     this.backgroundPaint = paint;
/* 418 */     fireAnnotationChanged();
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
/* 431 */   public Paint getOutlinePaint() { return this.outlinePaint; }
/*     */ 
/*     */ 
/*     */ 
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
/* 445 */     ParamChecks.nullNotPermitted(paint, "paint");
/* 446 */     this.outlinePaint = paint;
/* 447 */     fireAnnotationChanged();
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
/* 460 */   public Stroke getOutlineStroke() { return this.outlineStroke; }
/*     */ 
/*     */ 
/*     */ 
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
/* 474 */     ParamChecks.nullNotPermitted(stroke, "stroke");
/* 475 */     this.outlineStroke = stroke;
/* 476 */     fireAnnotationChanged();
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
/* 487 */   public boolean isOutlineVisible() { return this.outlineVisible; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOutlineVisible(boolean visible) {
/* 499 */     this.outlineVisible = visible;
/* 500 */     fireAnnotationChanged();
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void draw(Graphics2D g2, XYPlot plot, Rectangle2D dataArea, ValueAxis domainAxis, ValueAxis rangeAxis, int rendererIndex, PlotRenderingInfo info) {
/* 520 */     PlotOrientation orientation = plot.getOrientation();
/* 521 */     RectangleEdge domainEdge = Plot.resolveDomainAxisLocation(plot
/* 522 */         .getDomainAxisLocation(), orientation);
/* 523 */     RectangleEdge rangeEdge = Plot.resolveRangeAxisLocation(plot
/* 524 */         .getRangeAxisLocation(), orientation);
/*     */     
/* 526 */     float anchorX = (float)domainAxis.valueToJava2D(this.x, dataArea, domainEdge);
/*     */     
/* 528 */     float anchorY = (float)rangeAxis.valueToJava2D(this.y, dataArea, rangeEdge);
/*     */ 
/*     */     
/* 531 */     if (orientation == PlotOrientation.HORIZONTAL) {
/* 532 */       float tempAnchor = anchorX;
/* 533 */       anchorX = anchorY;
/* 534 */       anchorY = tempAnchor;
/*     */     } 
/*     */     
/* 537 */     g2.setFont(getFont());
/* 538 */     Shape hotspot = TextUtilities.calculateRotatedStringBounds(
/* 539 */         getText(), g2, anchorX, anchorY, getTextAnchor(), 
/* 540 */         getRotationAngle(), getRotationAnchor());
/* 541 */     if (this.backgroundPaint != null) {
/* 542 */       g2.setPaint(this.backgroundPaint);
/* 543 */       g2.fill(hotspot);
/*     */     } 
/* 545 */     g2.setPaint(getPaint());
/* 546 */     TextUtilities.drawRotatedString(getText(), g2, anchorX, anchorY, 
/* 547 */         getTextAnchor(), getRotationAngle(), getRotationAnchor());
/* 548 */     if (this.outlineVisible) {
/* 549 */       g2.setStroke(this.outlineStroke);
/* 550 */       g2.setPaint(this.outlinePaint);
/* 551 */       g2.draw(hotspot);
/*     */     } 
/*     */     
/* 554 */     String toolTip = getToolTipText();
/* 555 */     String url = getURL();
/* 556 */     if (toolTip != null || url != null) {
/* 557 */       addEntity(info, hotspot, rendererIndex, toolTip, url);
/*     */     }
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
/* 571 */     if (obj == this) {
/* 572 */       return true;
/*     */     }
/* 574 */     if (!(obj instanceof XYTextAnnotation)) {
/* 575 */       return false;
/*     */     }
/* 577 */     XYTextAnnotation that = (XYTextAnnotation)obj;
/* 578 */     if (!this.text.equals(that.text)) {
/* 579 */       return false;
/*     */     }
/* 581 */     if (this.x != that.x) {
/* 582 */       return false;
/*     */     }
/* 584 */     if (this.y != that.y) {
/* 585 */       return false;
/*     */     }
/* 587 */     if (!this.font.equals(that.font)) {
/* 588 */       return false;
/*     */     }
/* 590 */     if (!PaintUtilities.equal(this.paint, that.paint)) {
/* 591 */       return false;
/*     */     }
/* 593 */     if (!this.rotationAnchor.equals(that.rotationAnchor)) {
/* 594 */       return false;
/*     */     }
/* 596 */     if (this.rotationAngle != that.rotationAngle) {
/* 597 */       return false;
/*     */     }
/* 599 */     if (!this.textAnchor.equals(that.textAnchor)) {
/* 600 */       return false;
/*     */     }
/* 602 */     if (this.outlineVisible != that.outlineVisible) {
/* 603 */       return false;
/*     */     }
/* 605 */     if (!PaintUtilities.equal(this.backgroundPaint, that.backgroundPaint)) {
/* 606 */       return false;
/*     */     }
/* 608 */     if (!PaintUtilities.equal(this.outlinePaint, that.outlinePaint)) {
/* 609 */       return false;
/*     */     }
/* 611 */     if (!this.outlineStroke.equals(that.outlineStroke)) {
/* 612 */       return false;
/*     */     }
/* 614 */     return super.equals(obj);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 624 */     result = 193;
/* 625 */     result = 37 * result + this.text.hashCode();
/* 626 */     result = 37 * result + this.font.hashCode();
/* 627 */     result = 37 * result + HashUtilities.hashCodeForPaint(this.paint);
/* 628 */     long temp = Double.doubleToLongBits(this.x);
/* 629 */     result = 37 * result + (int)(temp ^ temp >>> 32);
/* 630 */     temp = Double.doubleToLongBits(this.y);
/* 631 */     result = 37 * result + (int)(temp ^ temp >>> 32);
/* 632 */     result = 37 * result + this.textAnchor.hashCode();
/* 633 */     result = 37 * result + this.rotationAnchor.hashCode();
/* 634 */     temp = Double.doubleToLongBits(this.rotationAngle);
/* 635 */     return 37 * result + (int)(temp ^ temp >>> 32);
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
/* 648 */   public Object clone() throws CloneNotSupportedException { return super.clone(); }
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
/* 659 */     stream.defaultWriteObject();
/* 660 */     SerialUtilities.writePaint(this.paint, stream);
/* 661 */     SerialUtilities.writePaint(this.backgroundPaint, stream);
/* 662 */     SerialUtilities.writePaint(this.outlinePaint, stream);
/* 663 */     SerialUtilities.writeStroke(this.outlineStroke, stream);
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
/* 676 */     stream.defaultReadObject();
/* 677 */     this.paint = SerialUtilities.readPaint(stream);
/* 678 */     this.backgroundPaint = SerialUtilities.readPaint(stream);
/* 679 */     this.outlinePaint = SerialUtilities.readPaint(stream);
/* 680 */     this.outlineStroke = SerialUtilities.readStroke(stream);
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/annotations/XYTextAnnotation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */