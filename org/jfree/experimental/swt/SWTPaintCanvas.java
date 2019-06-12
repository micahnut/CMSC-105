/*     */ package org.jfree.experimental.swt;
/*     */ 
/*     */ import org.eclipse.swt.events.PaintEvent;
/*     */ import org.eclipse.swt.events.PaintListener;
/*     */ import org.eclipse.swt.graphics.Color;
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
/*     */ public class SWTPaintCanvas
/*     */   extends Canvas
/*     */ {
/*     */   private Color myColor;
/*     */   
/*     */   public SWTPaintCanvas(Composite parent, int style, Color color) {
/*  65 */     this(parent, style);
/*  66 */     setColor(color);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SWTPaintCanvas(Composite parent, int style) {
/*  76 */     super(parent, style);
/*  77 */     addPaintListener(new PaintListener() {
/*     */           public void paintControl(PaintEvent e) {
/*  79 */             e.gc.setForeground(e.gc.getDevice().getSystemColor(2));
/*     */             
/*  81 */             e.gc.setBackground(SWTPaintCanvas.this.myColor);
/*  82 */             e.gc.fillRectangle(SWTPaintCanvas.this.getClientArea());
/*  83 */             e.gc.drawRectangle((this.this$0.getClientArea()).x, (this.this$0.getClientArea()).y, 
/*  84 */                 (this.this$0.getClientArea()).width - 1, (this.this$0.getClientArea()).height - 1);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setColor(Color color) {
/*  95 */     if (this.myColor != null) {
/*  96 */       this.myColor.dispose();
/*     */     }
/*     */     
/*  99 */     this.myColor = color;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 108 */   public Color getColor() { return this.myColor; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBackground(Color c) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setForeground(Color c) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 133 */   public void dispose() { this.myColor.dispose(); }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/experimental/swt/SWTPaintCanvas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */