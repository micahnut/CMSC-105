/*      */ package org.jfree.experimental.swt;
/*      */ 
/*      */ import java.awt.AlphaComposite;
/*      */ import java.awt.BasicStroke;
/*      */ import java.awt.Color;
/*      */ import java.awt.Composite;
/*      */ import java.awt.Font;
/*      */ import java.awt.FontMetrics;
/*      */ import java.awt.GradientPaint;
/*      */ import java.awt.Graphics;
/*      */ import java.awt.Graphics2D;
/*      */ import java.awt.GraphicsConfiguration;
/*      */ import java.awt.Image;
/*      */ import java.awt.Paint;
/*      */ import java.awt.Rectangle;
/*      */ import java.awt.RenderingHints;
/*      */ import java.awt.Shape;
/*      */ import java.awt.Stroke;
/*      */ import java.awt.font.FontRenderContext;
/*      */ import java.awt.font.GlyphVector;
/*      */ import java.awt.geom.AffineTransform;
/*      */ import java.awt.geom.Area;
/*      */ import java.awt.geom.PathIterator;
/*      */ import java.awt.geom.Rectangle2D;
/*      */ import java.awt.image.BufferedImage;
/*      */ import java.awt.image.BufferedImageOp;
/*      */ import java.awt.image.ImageObserver;
/*      */ import java.awt.image.RenderedImage;
/*      */ import java.awt.image.renderable.RenderableImage;
/*      */ import java.text.AttributedCharacterIterator;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import org.eclipse.swt.graphics.Color;
/*      */ import org.eclipse.swt.graphics.Font;
/*      */ import org.eclipse.swt.graphics.FontData;
/*      */ import org.eclipse.swt.graphics.GC;
/*      */ import org.eclipse.swt.graphics.Image;
/*      */ import org.eclipse.swt.graphics.ImageData;
/*      */ import org.eclipse.swt.graphics.Path;
/*      */ import org.eclipse.swt.graphics.Rectangle;
/*      */ import org.eclipse.swt.graphics.Resource;
/*      */ import org.eclipse.swt.graphics.Transform;
/*      */ import org.jfree.chart.util.ParamChecks;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class SWTGraphics2D
/*      */   extends Graphics2D
/*      */ {
/*      */   private GC gc;
/*      */   private RenderingHints hints;
/*      */   private Composite composite;
/*  130 */   private Map colorsPool = new HashMap();
/*      */ 
/*      */   
/*  133 */   private Map fontsPool = new HashMap();
/*      */ 
/*      */   
/*  136 */   private Map transformsPool = new HashMap();
/*      */ 
/*      */   
/*  139 */   private List resourcePool = new ArrayList();
/*      */ 
/*      */ 
/*      */   
/*      */   private Color backgroundColor;
/*      */ 
/*      */ 
/*      */   
/*      */   public SWTGraphics2D(GC gc) {
/*  148 */     this.gc = gc;
/*  149 */     this.hints = new RenderingHints(null);
/*  150 */     this.composite = AlphaComposite.getInstance(2, 1.0F);
/*  151 */     setStroke(new BasicStroke());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  161 */   public Graphics create() { return null; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  171 */   public GraphicsConfiguration getDeviceConfiguration() { return null; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  185 */   public Object getRenderingHint(RenderingHints.Key hintKey) { return this.hints.get(hintKey); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  201 */   public void setRenderingHint(RenderingHints.Key hintKey, Object hintValue) { this.hints.put(hintKey, hintValue); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  210 */   public RenderingHints getRenderingHints() { return (RenderingHints)this.hints.clone(); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  222 */   public void addRenderingHints(Map hints) { this.hints.putAll(hints); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRenderingHints(Map hints) {
/*  234 */     if (hints == null) {
/*  235 */       throw new NullPointerException("Null 'hints' argument.");
/*      */     }
/*  237 */     this.hints = new RenderingHints(hints);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  251 */   public Paint getPaint() { return SWTUtils.toAwtColor(this.gc.getForeground()); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPaint(Paint paint) {
/*  267 */     if (paint == null) {
/*      */       return;
/*      */     }
/*  270 */     if (paint instanceof Color) {
/*  271 */       setColor((Color)paint);
/*      */     }
/*  273 */     else if (paint instanceof GradientPaint) {
/*  274 */       GradientPaint gp = (GradientPaint)paint;
/*  275 */       setColor(gp.getColor1());
/*      */     } else {
/*      */       
/*  278 */       throw new RuntimeException("Can only handle 'Color' at present.");
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  293 */   public Color getColor() { return SWTUtils.toAwtColor(this.gc.getForeground()); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setColor(Color color) {
/*  304 */     if (color == null) {
/*      */       return;
/*      */     }
/*  307 */     Color swtColor = getSwtColorFromPool(color);
/*  308 */     this.gc.setForeground(swtColor);
/*      */     
/*  310 */     if (this.composite instanceof AlphaComposite) {
/*  311 */       AlphaComposite acomp = (AlphaComposite)this.composite;
/*  312 */       switch (acomp.getRule()) {
/*      */         case 3:
/*  314 */           this.gc.setAlpha((int)(color.getAlpha() * acomp.getAlpha()));
/*      */           return;
/*      */       } 
/*  317 */       this.gc.setAlpha(color.getAlpha());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  332 */   public void setBackground(Color color) { this.backgroundColor = color; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  341 */   public Color getBackground() { return this.backgroundColor; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPaintMode() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setXORMode(Color color) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  368 */   public Composite getComposite() { return this.composite; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setComposite(Composite comp) {
/*  378 */     if (comp == null) {
/*  379 */       throw new IllegalArgumentException("Null 'comp' argument.");
/*      */     }
/*  381 */     this.composite = comp;
/*  382 */     if (comp instanceof AlphaComposite) {
/*  383 */       AlphaComposite acomp = (AlphaComposite)comp;
/*  384 */       int alpha = (int)(acomp.getAlpha() * 255.0F);
/*  385 */       this.gc.setAlpha(alpha);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Stroke getStroke() {
/*  397 */     return new BasicStroke(this.gc.getLineWidth(), 
/*  398 */         toAwtLineCap(this.gc.getLineCap()), 
/*  399 */         toAwtLineJoin(this.gc.getLineJoin()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setStroke(Stroke stroke) {
/*  411 */     if (stroke == null) {
/*  412 */       throw new IllegalArgumentException("Null 'stroke' argument.");
/*      */     }
/*  414 */     if (stroke instanceof BasicStroke) {
/*  415 */       BasicStroke bs = (BasicStroke)stroke;
/*  416 */       this.gc.setLineWidth((int)bs.getLineWidth());
/*  417 */       this.gc.setLineJoin(toSwtLineJoin(bs.getLineJoin()));
/*  418 */       this.gc.setLineCap(toSwtLineCap(bs.getEndCap()));
/*      */ 
/*      */       
/*  421 */       this.gc.setLineStyle(1);
/*      */ 
/*      */       
/*  424 */       float[] dashes = bs.getDashArray();
/*  425 */       if (dashes != null) {
/*  426 */         int[] swtDashes = new int[dashes.length];
/*  427 */         for (int i = 0; i < swtDashes.length; i++) {
/*  428 */           swtDashes[i] = (int)dashes[i];
/*      */         }
/*  430 */         this.gc.setLineDash(swtDashes);
/*      */       } 
/*      */     } else {
/*      */       
/*  434 */       throw new RuntimeException("Can only handle 'Basic Stroke' at present.");
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void clip(Shape s) {
/*  445 */     Path path = toSwtPath(s);
/*  446 */     this.gc.setClipping(path);
/*  447 */     path.dispose();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Rectangle getClipBounds() {
/*  456 */     Rectangle clip = this.gc.getClipping();
/*  457 */     return new Rectangle(clip.x, clip.y, clip.width, clip.height);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void clipRect(int x, int y, int width, int height) {
/*  470 */     Rectangle clip = this.gc.getClipping();
/*  471 */     Rectangle r = new Rectangle(x, y, width, height);
/*      */     
/*  473 */     clip.intersect(r);
/*  474 */     this.gc.setClipping(clip);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  483 */   public Shape getClip() { return SWTUtils.toAwtRectangle(this.gc.getClipping()); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setClip(Shape clip) {
/*  492 */     if (clip == null) {
/*      */       return;
/*      */     }
/*  495 */     Path clipPath = toSwtPath(clip);
/*  496 */     this.gc.setClipping(clipPath);
/*  497 */     clipPath.dispose();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  509 */   public void setClip(int x, int y, int width, int height) { this.gc.setClipping(x, y, width, height); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AffineTransform getTransform() {
/*  518 */     Transform swtTransform = new Transform(this.gc.getDevice());
/*  519 */     this.gc.getTransform(swtTransform);
/*  520 */     AffineTransform awtTransform = toAwtTransform(swtTransform);
/*  521 */     swtTransform.dispose();
/*  522 */     return awtTransform;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTransform(AffineTransform t) {
/*  531 */     Transform transform = getSwtTransformFromPool(t);
/*  532 */     this.gc.setTransform(transform);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void transform(AffineTransform t) {
/*  541 */     Transform swtTransform = new Transform(this.gc.getDevice());
/*  542 */     this.gc.getTransform(swtTransform);
/*  543 */     swtTransform.multiply(getSwtTransformFromPool(t));
/*  544 */     this.gc.setTransform(swtTransform);
/*  545 */     swtTransform.dispose();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void translate(int x, int y) {
/*  555 */     Transform swtTransform = new Transform(this.gc.getDevice());
/*  556 */     this.gc.getTransform(swtTransform);
/*  557 */     swtTransform.translate(x, y);
/*  558 */     this.gc.setTransform(swtTransform);
/*  559 */     swtTransform.dispose();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  569 */   public void translate(double tx, double ty) { translate((int)tx, (int)ty); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void rotate(double theta) {
/*  578 */     AffineTransform t = getTransform();
/*  579 */     t.rotate(theta);
/*  580 */     setTransform(t);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void rotate(double theta, double x, double y) {
/*  589 */     translate(x, y);
/*  590 */     rotate(theta);
/*  591 */     translate(-x, -y);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void scale(double scaleX, double scaleY) {
/*  601 */     Transform swtTransform = new Transform(this.gc.getDevice());
/*  602 */     this.gc.getTransform(swtTransform);
/*  603 */     swtTransform.scale((float)scaleX, (float)scaleY);
/*  604 */     this.gc.setTransform(swtTransform);
/*  605 */     swtTransform.dispose();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  615 */   public void shear(double shearX, double shearY) { transform(AffineTransform.getShearInstance(shearX, shearY)); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void draw(Shape shape) {
/*  629 */     Path path = toSwtPath(shape);
/*  630 */     this.gc.drawPath(path);
/*  631 */     path.dispose();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  646 */   public void drawLine(int x1, int y1, int x2, int y2) { this.gc.drawLine(x1, y1, x2, y2); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void drawPolygon(int[] xPoints, int[] yPoints, int npoints) {
/*  660 */     drawPolyline(xPoints, yPoints, npoints);
/*  661 */     if (npoints > 1) {
/*  662 */       this.gc.drawLine(xPoints[npoints - 1], yPoints[npoints - 1], xPoints[0], yPoints[0]);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void drawPolyline(int[] xPoints, int[] yPoints, int npoints) {
/*  678 */     if (npoints > 1) {
/*  679 */       int x0 = xPoints[0];
/*  680 */       int y0 = yPoints[0];
/*  681 */       int x1 = 0, y1 = 0;
/*  682 */       for (int i = 1; i < npoints; i++) {
/*  683 */         x1 = xPoints[i];
/*  684 */         y1 = yPoints[i];
/*  685 */         this.gc.drawLine(x0, y0, x1, y1);
/*  686 */         x0 = x1;
/*  687 */         y0 = y1;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  704 */   public void drawOval(int x, int y, int width, int height) { this.gc.drawOval(x, y, width - 1, height - 1); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  722 */   public void drawArc(int x, int y, int width, int height, int arcStart, int arcAngle) { this.gc.drawArc(x, y, width - 1, height - 1, arcStart, arcAngle); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  742 */   public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) { this.gc.drawRoundRectangle(x, y, width - 1, height - 1, arcWidth, arcHeight); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void fill(Shape shape) {
/*  755 */     Path path = toSwtPath(shape);
/*      */ 
/*      */ 
/*      */     
/*  759 */     switchColors();
/*  760 */     this.gc.fillPath(path);
/*  761 */     switchColors();
/*  762 */     path.dispose();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void fillRect(int x, int y, int width, int height) {
/*  772 */     switchColors();
/*  773 */     this.gc.fillRectangle(x, y, width, height);
/*  774 */     switchColors();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void clearRect(int x, int y, int width, int height) {
/*  788 */     Color bgcolor = getBackground();
/*  789 */     if (bgcolor == null) {
/*      */       return;
/*      */     }
/*  792 */     Paint saved = getPaint();
/*  793 */     setPaint(bgcolor);
/*  794 */     fillRect(x, y, width, height);
/*  795 */     setPaint(saved);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void fillPolygon(int[] xPoints, int[] yPoints, int npoints) {
/*  806 */     int[] pointArray = new int[npoints * 2];
/*  807 */     for (int i = 0; i < npoints; i++) {
/*  808 */       pointArray[2 * i] = xPoints[i];
/*  809 */       pointArray[2 * i + 1] = yPoints[i];
/*      */     } 
/*  811 */     switchColors();
/*  812 */     this.gc.fillPolygon(pointArray);
/*  813 */     switchColors();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
/*  833 */     switchColors();
/*  834 */     this.gc.fillRoundRectangle(x, y, width - 1, height - 1, arcWidth, arcHeight);
/*      */     
/*  836 */     switchColors();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void fillOval(int x, int y, int width, int height) {
/*  851 */     switchColors();
/*  852 */     this.gc.fillOval(x, y, width - 1, height - 1);
/*  853 */     switchColors();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void fillArc(int x, int y, int width, int height, int arcStart, int arcAngle) {
/*  871 */     switchColors();
/*  872 */     this.gc.fillArc(x, y, width - 1, height - 1, arcStart, arcAngle);
/*  873 */     switchColors();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Font getFont() {
/*  884 */     FontData[] fontData = this.gc.getFont().getFontData();
/*      */     
/*  886 */     return SWTUtils.toAwtFont(this.gc.getDevice(), fontData[0], true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFont(Font font) {
/*  896 */     Font swtFont = getSwtFontFromPool(font);
/*  897 */     this.gc.setFont(swtFont);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  908 */   public FontMetrics getFontMetrics(Font font) { return SWTUtils.DUMMY_PANEL.getFontMetrics(font); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  917 */   public FontRenderContext getFontRenderContext() { return new FontRenderContext(new AffineTransform(), true, true); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  930 */   public void drawGlyphVector(GlyphVector g, float x, float y) { fill(g.getOutline(x, y)); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  941 */   public void drawString(String text, int x, int y) { drawString(text, x, y); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void drawString(String text, float x, float y) {
/*  952 */     if (text == null) {
/*  953 */       throw new NullPointerException("Null 'text' argument.");
/*      */     }
/*  955 */     float fm = this.gc.getFontMetrics().getAscent();
/*  956 */     this.gc.drawString(text, (int)x, (int)(y - fm), true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void drawString(AttributedCharacterIterator iterator, int x, int y) {
/*  969 */     StringBuffer sb = new StringBuffer();
/*  970 */     int numChars = iterator.getEndIndex() - iterator.getBeginIndex();
/*  971 */     char c = iterator.first();
/*  972 */     for (int i = 0; i < numChars; i++) {
/*  973 */       sb.append(c);
/*  974 */       c = iterator.next();
/*      */     } 
/*  976 */     drawString(new String(sb), x, y);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  988 */   public void drawString(AttributedCharacterIterator iterator, float x, float y) { drawString(iterator, (int)x, (int)y); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hit(Rectangle rect, Shape s, boolean onStroke) {
/*      */     Shape ts;
/* 1004 */     AffineTransform transform = getTransform();
/*      */     
/* 1006 */     if (onStroke) {
/* 1007 */       Stroke stroke = getStroke();
/* 1008 */       ts = transform.createTransformedShape(stroke.createStrokedShape(s));
/*      */     } else {
/* 1010 */       ts = transform.createTransformedShape(s);
/*      */     } 
/* 1012 */     if (!rect.getBounds2D().intersects(ts.getBounds2D())) {
/* 1013 */       return false;
/*      */     }
/* 1015 */     Area a1 = new Area(rect);
/* 1016 */     Area a2 = new Area(ts);
/* 1017 */     a1.intersect(a2);
/* 1018 */     return !a1.isEmpty();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void copyArea(int x, int y, int width, int height, int dx, int dy) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1042 */   public boolean drawImage(Image image, AffineTransform xform, ImageObserver obs) { return false; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void drawImage(BufferedImage image, BufferedImageOp op, int x, int y) {
/* 1056 */     Image im = new Image(this.gc.getDevice(), SWTUtils.convertToSWT(image));
/* 1057 */     this.gc.drawImage(im, x, y);
/* 1058 */     im.dispose();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1070 */   public void drawImage(Image image, int x, int y) { this.gc.drawImage(image, x, y); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void drawRenderedImage(RenderedImage image, AffineTransform xform) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void drawRenderableImage(RenderableImage image, AffineTransform xform) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean drawImage(Image image, int x, int y, ImageObserver observer) {
/* 1109 */     ImageData data = SWTUtils.convertAWTImageToSWT(image);
/* 1110 */     if (data == null) {
/* 1111 */       return false;
/*      */     }
/*      */     
/* 1114 */     Image im = new Image(this.gc.getDevice(), data);
/* 1115 */     this.gc.drawImage(im, x, y);
/* 1116 */     im.dispose();
/* 1117 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean drawImage(Image image, int x, int y, int width, int height, ImageObserver observer) {
/* 1135 */     ImageData data = SWTUtils.convertAWTImageToSWT(image);
/* 1136 */     if (data == null) {
/* 1137 */       return false;
/*      */     }
/*      */     
/* 1140 */     Image im = new Image(this.gc.getDevice(), data);
/* 1141 */     Rectangle bounds = im.getBounds();
/* 1142 */     this.gc.drawImage(im, 0, 0, bounds.width, bounds.height, x, y, width, height);
/*      */     
/* 1144 */     im.dispose();
/* 1145 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean drawImage(Image image, int x, int y, Color bgcolor, ImageObserver observer) {
/* 1161 */     ParamChecks.nullNotPermitted(image, "image");
/* 1162 */     int w = image.getWidth(null);
/* 1163 */     int h = image.getHeight(null);
/* 1164 */     if (w == -1 || h == -1) {
/* 1165 */       return false;
/*      */     }
/* 1167 */     Paint savedPaint = getPaint();
/* 1168 */     fill(new Rectangle2D.Double(x, y, w, h));
/* 1169 */     setPaint(savedPaint);
/* 1170 */     return drawImage(image, x, y, observer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean drawImage(Image image, int x, int y, int width, int height, Color bgcolor, ImageObserver observer) {
/* 1188 */     ParamChecks.nullNotPermitted(image, "image");
/* 1189 */     int w = image.getWidth(null);
/* 1190 */     int h = image.getHeight(null);
/* 1191 */     if (w == -1 || h == -1) {
/* 1192 */       return false;
/*      */     }
/* 1194 */     Paint savedPaint = getPaint();
/* 1195 */     fill(new Rectangle2D.Double(x, y, w, h));
/* 1196 */     setPaint(savedPaint);
/* 1197 */     return drawImage(image, x, y, width, height, observer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1218 */   public boolean drawImage(Image image, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, ImageObserver observer) { return false; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1241 */   public boolean drawImage(Image image, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, Color bgcolor, ImageObserver observer) { return false; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1252 */   public void dispose() { disposeResourcePool(); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Resource addToResourcePool(Resource resource) {
/* 1263 */     this.resourcePool.add(resource);
/* 1264 */     return resource;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void disposeResourcePool() {
/* 1271 */     for (Iterator it = this.resourcePool.iterator(); it.hasNext(); ) {
/* 1272 */       Resource resource = (Resource)it.next();
/* 1273 */       resource.dispose();
/*      */     } 
/* 1275 */     this.fontsPool.clear();
/* 1276 */     this.colorsPool.clear();
/* 1277 */     this.transformsPool.clear();
/* 1278 */     this.resourcePool.clear();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Font getSwtFontFromPool(Font font) {
/* 1293 */     Font swtFont = (Font)this.fontsPool.get(font);
/* 1294 */     if (swtFont == null) {
/*      */       
/* 1296 */       swtFont = new Font(this.gc.getDevice(), SWTUtils.toSwtFontData(this.gc.getDevice(), font, true));
/* 1297 */       addToResourcePool(swtFont);
/* 1298 */       this.fontsPool.put(font, swtFont);
/*      */     } 
/* 1300 */     return swtFont;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Color getSwtColorFromPool(Color awtColor) {
/* 1319 */     Color swtColor = (Color)this.colorsPool.get(new Integer(awtColor.getRGB()));
/* 1320 */     if (swtColor == null) {
/* 1321 */       swtColor = SWTUtils.toSwtColor(this.gc.getDevice(), awtColor);
/* 1322 */       addToResourcePool(swtColor);
/*      */ 
/*      */       
/* 1325 */       this.colorsPool.put(new Integer(awtColor.getRGB()), swtColor);
/*      */     } 
/* 1327 */     return swtColor;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Transform getSwtTransformFromPool(AffineTransform awtTransform) {
/* 1341 */     Transform t = (Transform)this.transformsPool.get(awtTransform);
/* 1342 */     if (t == null) {
/* 1343 */       t = new Transform(this.gc.getDevice());
/* 1344 */       double[] matrix = new double[6];
/* 1345 */       awtTransform.getMatrix(matrix);
/* 1346 */       t.setElements((float)matrix[0], (float)matrix[1], (float)matrix[2], (float)matrix[3], (float)matrix[4], (float)matrix[5]);
/*      */ 
/*      */       
/* 1349 */       addToResourcePool(t);
/* 1350 */       this.transformsPool.put(awtTransform, t);
/*      */     } 
/* 1352 */     return t;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void switchColors() {
/* 1362 */     Color bg = this.gc.getBackground();
/* 1363 */     Color fg = this.gc.getForeground();
/* 1364 */     this.gc.setBackground(fg);
/* 1365 */     this.gc.setForeground(bg);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Path toSwtPath(Shape shape) {
/* 1377 */     float[] coords = new float[6];
/* 1378 */     Path path = new Path(this.gc.getDevice());
/* 1379 */     PathIterator pit = shape.getPathIterator(null);
/* 1380 */     while (!pit.isDone()) {
/* 1381 */       int type = pit.currentSegment(coords);
/* 1382 */       switch (type) {
/*      */         case 0:
/* 1384 */           path.moveTo(coords[0], coords[1]);
/*      */           break;
/*      */         case 1:
/* 1387 */           path.lineTo(coords[0], coords[1]);
/*      */           break;
/*      */         case 2:
/* 1390 */           path.quadTo(coords[0], coords[1], coords[2], coords[3]);
/*      */           break;
/*      */         case 3:
/* 1393 */           path.cubicTo(coords[0], coords[1], coords[2], coords[3], coords[4], coords[5]);
/*      */           break;
/*      */         
/*      */         case 4:
/* 1397 */           path.close();
/*      */           break;
/*      */       } 
/*      */ 
/*      */       
/* 1402 */       pit.next();
/*      */     } 
/* 1404 */     return path;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AffineTransform toAwtTransform(Transform swtTransform) {
/* 1415 */     float[] elements = new float[6];
/* 1416 */     swtTransform.getElements(elements);
/* 1417 */     return new AffineTransform(elements);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int toAwtLineCap(int swtLineCap) {
/* 1429 */     if (swtLineCap == 1) {
/* 1430 */       return 0;
/*      */     }
/* 1432 */     if (swtLineCap == 2) {
/* 1433 */       return 1;
/*      */     }
/* 1435 */     if (swtLineCap == 3) {
/* 1436 */       return 2;
/*      */     }
/*      */     
/* 1439 */     throw new IllegalArgumentException("SWT LineCap " + swtLineCap + " not recognised");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int toAwtLineJoin(int swtLineJoin) {
/* 1452 */     if (swtLineJoin == 3) {
/* 1453 */       return 2;
/*      */     }
/* 1455 */     if (swtLineJoin == 1) {
/* 1456 */       return 0;
/*      */     }
/* 1458 */     if (swtLineJoin == 2) {
/* 1459 */       return 1;
/*      */     }
/*      */     
/* 1462 */     throw new IllegalArgumentException("SWT LineJoin " + swtLineJoin + " not recognised");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int toSwtLineCap(int awtLineCap) {
/* 1475 */     if (awtLineCap == 0) {
/* 1476 */       return 1;
/*      */     }
/* 1478 */     if (awtLineCap == 1) {
/* 1479 */       return 2;
/*      */     }
/* 1481 */     if (awtLineCap == 2) {
/* 1482 */       return 3;
/*      */     }
/*      */     
/* 1485 */     throw new IllegalArgumentException("AWT LineCap " + awtLineCap + " not recognised");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int toSwtLineJoin(int awtLineJoin) {
/* 1498 */     if (awtLineJoin == 2) {
/* 1499 */       return 3;
/*      */     }
/* 1501 */     if (awtLineJoin == 0) {
/* 1502 */       return 1;
/*      */     }
/* 1504 */     if (awtLineJoin == 1) {
/* 1505 */       return 2;
/*      */     }
/*      */     
/* 1508 */     throw new IllegalArgumentException("AWT LineJoin " + awtLineJoin + " not recognised");
/*      */   }
/*      */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/experimental/swt/SWTGraphics2D.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */