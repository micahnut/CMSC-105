/*     */ package org.jfree.experimental.chart.swt.editor;
/*     */ 
/*     */ import java.awt.BasicStroke;
/*     */ import java.awt.Stroke;
/*     */ import org.eclipse.swt.events.PaintEvent;
/*     */ import org.eclipse.swt.events.PaintListener;
/*     */ import org.eclipse.swt.graphics.Image;
/*     */ import org.eclipse.swt.graphics.Rectangle;
/*     */ import org.eclipse.swt.graphics.Transform;
/*     */ import org.eclipse.swt.widgets.Canvas;
/*     */ import org.eclipse.swt.widgets.Composite;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class SWTStrokeCanvas
/*     */   extends Canvas
/*     */ {
/*  68 */   public SWTStrokeCanvas(Composite parent, int style, Image image) { this(parent, style); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SWTStrokeCanvas(Composite parent, int style) {
/*  78 */     super(parent, style);
/*  79 */     addPaintListener(new PaintListener() {
/*     */           public void paintControl(PaintEvent e) {
/*  81 */             BasicStroke stroke = SWTStrokeCanvas.this.getStroke();
/*  82 */             if (stroke != null) {
/*     */               
/*  84 */               Rectangle rect = SWTStrokeCanvas.this.getClientArea();
/*  85 */               int x = (rect.width - 100) / 2;
/*  86 */               int y = (rect.height - 16) / 2;
/*  87 */               Transform swtTransform = new Transform(e.gc.getDevice());
/*  88 */               e.gc.getTransform(swtTransform);
/*  89 */               swtTransform.translate(x, y);
/*  90 */               e.gc.setTransform(swtTransform);
/*  91 */               swtTransform.dispose();
/*  92 */               e.gc.setBackground(SWTStrokeCanvas.this.getDisplay().getSystemColor(2));
/*     */               
/*  94 */               e.gc.setLineWidth((int)stroke.getLineWidth());
/*  95 */               e.gc.drawLine(10, 8, 90, 8);
/*     */             } 
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStroke(Stroke stroke) {
/* 107 */     if (stroke instanceof BasicStroke) {
/* 108 */       setData(stroke);
/*     */     } else {
/*     */       
/* 111 */       throw new RuntimeException("Can only handle 'Basic Stroke' at present.");
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
/* 122 */   public BasicStroke getStroke() { return (BasicStroke)getData(); }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/experimental/chart/swt/editor/SWTStrokeCanvas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */