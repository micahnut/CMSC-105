/*     */ package org.jfree.chart.annotations;
/*     */ 
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Image;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import org.jfree.chart.axis.AxisLocation;
/*     */ import org.jfree.chart.axis.ValueAxis;
/*     */ import org.jfree.chart.plot.Plot;
/*     */ import org.jfree.chart.plot.PlotOrientation;
/*     */ import org.jfree.chart.plot.PlotRenderingInfo;
/*     */ import org.jfree.chart.plot.XYPlot;
/*     */ import org.jfree.chart.util.ParamChecks;
/*     */ import org.jfree.data.Range;
/*     */ import org.jfree.ui.RectangleEdge;
/*     */ import org.jfree.util.ObjectUtilities;
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
/*     */ 
/*     */ 
/*     */ public class XYDataImageAnnotation
/*     */   extends AbstractXYAnnotation
/*     */   implements Cloneable, PublicCloneable, XYAnnotationBoundsInfo
/*     */ {
/*     */   private Image image;
/*     */   private double x;
/*     */   private double y;
/*     */   private double w;
/*     */   private double h;
/*     */   private boolean includeInDataBounds;
/*     */   
/* 116 */   public XYDataImageAnnotation(Image image, double x, double y, double w, double h) { this(image, x, y, w, h, false); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XYDataImageAnnotation(Image image, double x, double y, double w, double h, boolean includeInDataBounds) {
/* 136 */     ParamChecks.nullNotPermitted(image, "image");
/* 137 */     this.image = image;
/* 138 */     this.x = x;
/* 139 */     this.y = y;
/* 140 */     this.w = w;
/* 141 */     this.h = h;
/* 142 */     this.includeInDataBounds = includeInDataBounds;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 151 */   public Image getImage() { return this.image; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 160 */   public double getX() { return this.x; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 169 */   public double getY() { return this.y; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 179 */   public double getWidth() { return this.w; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 189 */   public double getHeight() { return this.h; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 202 */   public boolean getIncludeInDataBounds() { return this.includeInDataBounds; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 214 */   public Range getXRange() { return new Range(this.x, this.x + this.w); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 226 */   public Range getYRange() { return new Range(this.y, this.y + this.h); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 249 */     PlotOrientation orientation = plot.getOrientation();
/* 250 */     AxisLocation xAxisLocation = plot.getDomainAxisLocation();
/* 251 */     AxisLocation yAxisLocation = plot.getRangeAxisLocation();
/* 252 */     RectangleEdge xEdge = Plot.resolveDomainAxisLocation(xAxisLocation, orientation);
/*     */     
/* 254 */     RectangleEdge yEdge = Plot.resolveRangeAxisLocation(yAxisLocation, orientation);
/*     */     
/* 256 */     float j2DX0 = (float)domainAxis.valueToJava2D(this.x, dataArea, xEdge);
/* 257 */     float j2DY0 = (float)rangeAxis.valueToJava2D(this.y, dataArea, yEdge);
/* 258 */     float j2DX1 = (float)domainAxis.valueToJava2D(this.x + this.w, dataArea, xEdge);
/*     */     
/* 260 */     float j2DY1 = (float)rangeAxis.valueToJava2D(this.y + this.h, dataArea, yEdge);
/*     */     
/* 262 */     float xx0 = 0.0F;
/* 263 */     float yy0 = 0.0F;
/* 264 */     float xx1 = 0.0F;
/* 265 */     float yy1 = 0.0F;
/* 266 */     if (orientation == PlotOrientation.HORIZONTAL) {
/* 267 */       xx0 = j2DY0;
/* 268 */       xx1 = j2DY1;
/* 269 */       yy0 = j2DX0;
/* 270 */       yy1 = j2DX1;
/*     */     }
/* 272 */     else if (orientation == PlotOrientation.VERTICAL) {
/* 273 */       xx0 = j2DX0;
/* 274 */       xx1 = j2DX1;
/* 275 */       yy0 = j2DY0;
/* 276 */       yy1 = j2DY1;
/*     */     } 
/*     */     
/* 279 */     g2.drawImage(this.image, (int)xx0, (int)Math.min(yy0, yy1), (int)(xx1 - xx0), 
/* 280 */         (int)Math.abs(yy1 - yy0), null);
/* 281 */     String toolTip = getToolTipText();
/* 282 */     String url = getURL();
/* 283 */     if (toolTip != null || url != null) {
/* 284 */       addEntity(info, new Rectangle2D.Float(xx0, yy0, xx1 - xx0, yy1 - yy0), rendererIndex, toolTip, url);
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
/* 298 */     if (obj == this) {
/* 299 */       return true;
/*     */     }
/*     */     
/* 302 */     if (!super.equals(obj)) {
/* 303 */       return false;
/*     */     }
/* 305 */     if (!(obj instanceof XYDataImageAnnotation)) {
/* 306 */       return false;
/*     */     }
/* 308 */     XYDataImageAnnotation that = (XYDataImageAnnotation)obj;
/* 309 */     if (this.x != that.x) {
/* 310 */       return false;
/*     */     }
/* 312 */     if (this.y != that.y) {
/* 313 */       return false;
/*     */     }
/* 315 */     if (this.w != that.w) {
/* 316 */       return false;
/*     */     }
/* 318 */     if (this.h != that.h) {
/* 319 */       return false;
/*     */     }
/* 321 */     if (this.includeInDataBounds != that.includeInDataBounds) {
/* 322 */       return false;
/*     */     }
/* 324 */     if (!ObjectUtilities.equal(this.image, that.image)) {
/* 325 */       return false;
/*     */     }
/*     */     
/* 328 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 338 */   public int hashCode() { return this.image.hashCode(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 350 */   public Object clone() throws CloneNotSupportedException { return super.clone(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 361 */   private void writeObject(ObjectOutputStream stream) throws IOException { stream.defaultWriteObject(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 376 */   private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException { stream.defaultReadObject(); }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/annotations/XYDataImageAnnotation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */