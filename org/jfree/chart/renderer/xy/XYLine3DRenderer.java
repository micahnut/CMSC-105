/*     */ package org.jfree.chart.renderer.xy;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Paint;
/*     */ import java.awt.Shape;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import org.jfree.chart.Effect3D;
/*     */ import org.jfree.io.SerialUtilities;
/*     */ import org.jfree.util.PaintUtilities;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XYLine3DRenderer
/*     */   extends XYLineAndShapeRenderer
/*     */   implements Effect3D, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 588933208243446087L;
/*     */   public static final double DEFAULT_X_OFFSET = 12.0D;
/*     */   public static final double DEFAULT_Y_OFFSET = 8.0D;
/*  75 */   public static final Paint DEFAULT_WALL_PAINT = new Color('Ý', 'Ý', 'Ý');
/*     */ 
/*     */ 
/*     */   
/*     */   private double xOffset;
/*     */ 
/*     */   
/*     */   private double yOffset;
/*     */ 
/*     */   
/*     */   private Paint wallPaint;
/*     */ 
/*     */ 
/*     */   
/*     */   public XYLine3DRenderer() {
/*  90 */     this.wallPaint = DEFAULT_WALL_PAINT;
/*  91 */     this.xOffset = 12.0D;
/*  92 */     this.yOffset = 8.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 102 */   public double getXOffset() { return this.xOffset; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 112 */   public double getYOffset() { return this.yOffset; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setXOffset(double xOffset) {
/* 122 */     this.xOffset = xOffset;
/* 123 */     fireChangeEvent();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setYOffset(double yOffset) {
/* 133 */     this.yOffset = yOffset;
/* 134 */     fireChangeEvent();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 144 */   public Paint getWallPaint() { return this.wallPaint; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWallPaint(Paint paint) {
/* 155 */     this.wallPaint = paint;
/* 156 */     fireChangeEvent();
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
/* 168 */   public int getPassCount() { return 3; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 180 */   protected boolean isLinePass(int pass) { return (pass == 0 || pass == 1); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 192 */   protected boolean isItemPass(int pass) { return (pass == 2); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 203 */   protected boolean isShadowPass(int pass) { return (pass == 0); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void drawFirstPassShape(Graphics2D g2, int pass, int series, int item, Shape shape) {
/* 218 */     if (isShadowPass(pass)) {
/* 219 */       if (getWallPaint() != null) {
/* 220 */         g2.setStroke(getItemStroke(series, item));
/* 221 */         g2.setPaint(getWallPaint());
/* 222 */         g2.translate(getXOffset(), getYOffset());
/* 223 */         g2.draw(shape);
/* 224 */         g2.translate(-getXOffset(), -getYOffset());
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 229 */       super.drawFirstPassShape(g2, pass, series, item, shape);
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
/*     */   public boolean equals(Object obj) {
/* 242 */     if (obj == this) {
/* 243 */       return true;
/*     */     }
/* 245 */     if (!(obj instanceof XYLine3DRenderer)) {
/* 246 */       return false;
/*     */     }
/* 248 */     XYLine3DRenderer that = (XYLine3DRenderer)obj;
/* 249 */     if (this.xOffset != that.xOffset) {
/* 250 */       return false;
/*     */     }
/* 252 */     if (this.yOffset != that.yOffset) {
/* 253 */       return false;
/*     */     }
/* 255 */     if (!PaintUtilities.equal(this.wallPaint, that.wallPaint)) {
/* 256 */       return false;
/*     */     }
/* 258 */     return super.equals(obj);
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
/* 271 */     stream.defaultReadObject();
/* 272 */     this.wallPaint = SerialUtilities.readPaint(stream);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void writeObject(ObjectOutputStream stream) throws IOException {
/* 283 */     stream.defaultWriteObject();
/* 284 */     SerialUtilities.writePaint(this.wallPaint, stream);
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/renderer/xy/XYLine3DRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */