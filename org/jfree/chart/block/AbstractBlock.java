/*     */ package org.jfree.chart.block;
/*     */ 
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import org.jfree.chart.util.ParamChecks;
/*     */ import org.jfree.data.Range;
/*     */ import org.jfree.io.SerialUtilities;
/*     */ import org.jfree.ui.RectangleInsets;
/*     */ import org.jfree.ui.Size2D;
/*     */ import org.jfree.util.ObjectUtilities;
/*     */ import org.jfree.util.PublicCloneable;
/*     */ import org.jfree.util.ShapeUtilities;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AbstractBlock
/*     */   implements Cloneable, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 7689852412141274563L;
/*     */   private String id;
/*     */   private RectangleInsets margin;
/*     */   private BlockFrame frame;
/*     */   private RectangleInsets padding;
/*     */   private double width;
/*     */   private double height;
/*     */   private Rectangle2D bounds;
/*     */   
/*     */   protected AbstractBlock() {
/* 110 */     this.id = null;
/* 111 */     this.width = 0.0D;
/* 112 */     this.height = 0.0D;
/* 113 */     this.bounds = new Rectangle2D.Float();
/* 114 */     this.margin = RectangleInsets.ZERO_INSETS;
/* 115 */     this.frame = BlockBorder.NONE;
/* 116 */     this.padding = RectangleInsets.ZERO_INSETS;
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
/* 127 */   public String getID() { return this.id; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 138 */   public void setID(String id) { this.id = id; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 151 */   public double getWidth() { return this.width; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 162 */   public void setWidth(double width) { this.width = width; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 175 */   public double getHeight() { return this.height; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 186 */   public void setHeight(double height) { this.height = height; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 197 */   public RectangleInsets getMargin() { return this.margin; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMargin(RectangleInsets margin) {
/* 209 */     ParamChecks.nullNotPermitted(margin, "margin");
/* 210 */     this.margin = margin;
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
/* 225 */   public void setMargin(double top, double left, double bottom, double right) { setMargin(new RectangleInsets(top, left, bottom, right)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BlockBorder getBorder() {
/* 236 */     if (this.frame instanceof BlockBorder) {
/* 237 */       return (BlockBorder)this.frame;
/*     */     }
/*     */     
/* 240 */     return null;
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
/* 255 */   public void setBorder(BlockBorder border) { setFrame(border); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 268 */   public void setBorder(double top, double left, double bottom, double right) { setFrame(new BlockBorder(top, left, bottom, right)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 280 */   public BlockFrame getFrame() { return this.frame; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFrame(BlockFrame frame) {
/* 292 */     ParamChecks.nullNotPermitted(frame, "frame");
/* 293 */     this.frame = frame;
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
/* 304 */   public RectangleInsets getPadding() { return this.padding; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPadding(RectangleInsets padding) {
/* 316 */     ParamChecks.nullNotPermitted(padding, "padding");
/* 317 */     this.padding = padding;
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
/* 330 */   public void setPadding(double top, double left, double bottom, double right) { setPadding(new RectangleInsets(top, left, bottom, right)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 342 */   public double getContentXOffset() { return this.margin.getLeft() + this.frame.getInsets().getLeft() + this.padding.getLeft(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 354 */   public double getContentYOffset() { return this.margin.getTop() + this.frame.getInsets().getTop() + this.padding.getTop(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 366 */   public Size2D arrange(Graphics2D g2) { return arrange(g2, RectangleConstraint.NONE); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Size2D arrange(Graphics2D g2, RectangleConstraint constraint) {
/* 379 */     Size2D base = new Size2D(getWidth(), getHeight());
/* 380 */     return constraint.calculateConstrainedSize(base);
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
/* 391 */   public Rectangle2D getBounds() { return this.bounds; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBounds(Rectangle2D bounds) {
/* 402 */     ParamChecks.nullNotPermitted(bounds, "bounds");
/* 403 */     this.bounds = bounds;
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
/*     */   protected double trimToContentWidth(double fixedWidth) {
/* 418 */     double result = this.margin.trimWidth(fixedWidth);
/* 419 */     result = this.frame.getInsets().trimWidth(result);
/* 420 */     result = this.padding.trimWidth(result);
/* 421 */     return Math.max(result, 0.0D);
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
/*     */   protected double trimToContentHeight(double fixedHeight) {
/* 436 */     double result = this.margin.trimHeight(fixedHeight);
/* 437 */     result = this.frame.getInsets().trimHeight(result);
/* 438 */     result = this.padding.trimHeight(result);
/* 439 */     return Math.max(result, 0.0D);
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
/*     */   protected RectangleConstraint toContentConstraint(RectangleConstraint c) {
/* 451 */     ParamChecks.nullNotPermitted(c, "c");
/* 452 */     if (c.equals(RectangleConstraint.NONE)) {
/* 453 */       return c;
/*     */     }
/* 455 */     double w = c.getWidth();
/* 456 */     Range wr = c.getWidthRange();
/* 457 */     double h = c.getHeight();
/* 458 */     Range hr = c.getHeightRange();
/* 459 */     double ww = trimToContentWidth(w);
/* 460 */     double hh = trimToContentHeight(h);
/* 461 */     Range wwr = trimToContentWidth(wr);
/* 462 */     Range hhr = trimToContentHeight(hr);
/* 463 */     return new RectangleConstraint(ww, wwr, c.getWidthConstraintType(), hh, hhr, c
/* 464 */         .getHeightConstraintType());
/*     */   }
/*     */   
/*     */   private Range trimToContentWidth(Range r) {
/* 468 */     if (r == null) {
/* 469 */       return null;
/*     */     }
/* 471 */     double lowerBound = 0.0D;
/* 472 */     double upperBound = Double.POSITIVE_INFINITY;
/* 473 */     if (r.getLowerBound() > 0.0D) {
/* 474 */       lowerBound = trimToContentWidth(r.getLowerBound());
/*     */     }
/* 476 */     if (r.getUpperBound() < Double.POSITIVE_INFINITY) {
/* 477 */       upperBound = trimToContentWidth(r.getUpperBound());
/*     */     }
/* 479 */     return new Range(lowerBound, upperBound);
/*     */   }
/*     */   
/*     */   private Range trimToContentHeight(Range r) {
/* 483 */     if (r == null) {
/* 484 */       return null;
/*     */     }
/* 486 */     double lowerBound = 0.0D;
/* 487 */     double upperBound = Double.POSITIVE_INFINITY;
/* 488 */     if (r.getLowerBound() > 0.0D) {
/* 489 */       lowerBound = trimToContentHeight(r.getLowerBound());
/*     */     }
/* 491 */     if (r.getUpperBound() < Double.POSITIVE_INFINITY) {
/* 492 */       upperBound = trimToContentHeight(r.getUpperBound());
/*     */     }
/* 494 */     return new Range(lowerBound, upperBound);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected double calculateTotalWidth(double contentWidth) {
/* 505 */     result = contentWidth;
/* 506 */     result = this.padding.extendWidth(result);
/* 507 */     result = this.frame.getInsets().extendWidth(result);
/* 508 */     return this.margin.extendWidth(result);
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
/*     */   protected double calculateTotalHeight(double contentHeight) {
/* 520 */     result = contentHeight;
/* 521 */     result = this.padding.extendHeight(result);
/* 522 */     result = this.frame.getInsets().extendHeight(result);
/* 523 */     return this.margin.extendHeight(result);
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
/*     */   protected Rectangle2D trimMargin(Rectangle2D area) {
/* 537 */     this.margin.trim(area);
/* 538 */     return area;
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
/*     */   protected Rectangle2D trimBorder(Rectangle2D area) {
/* 551 */     this.frame.getInsets().trim(area);
/* 552 */     return area;
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
/*     */   protected Rectangle2D trimPadding(Rectangle2D area) {
/* 565 */     this.padding.trim(area);
/* 566 */     return area;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 576 */   protected void drawBorder(Graphics2D g2, Rectangle2D area) { this.frame.draw(g2, area); }
/*     */ 
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
/* 588 */     if (obj == this) {
/* 589 */       return true;
/*     */     }
/* 591 */     if (!(obj instanceof AbstractBlock)) {
/* 592 */       return false;
/*     */     }
/* 594 */     AbstractBlock that = (AbstractBlock)obj;
/* 595 */     if (!ObjectUtilities.equal(this.id, that.id)) {
/* 596 */       return false;
/*     */     }
/* 598 */     if (!this.frame.equals(that.frame)) {
/* 599 */       return false;
/*     */     }
/* 601 */     if (!this.bounds.equals(that.bounds)) {
/* 602 */       return false;
/*     */     }
/* 604 */     if (!this.margin.equals(that.margin)) {
/* 605 */       return false;
/*     */     }
/* 607 */     if (!this.padding.equals(that.padding)) {
/* 608 */       return false;
/*     */     }
/* 610 */     if (this.height != that.height) {
/* 611 */       return false;
/*     */     }
/* 613 */     if (this.width != that.width) {
/* 614 */       return false;
/*     */     }
/* 616 */     return true;
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
/*     */   public Object clone() throws CloneNotSupportedException {
/* 629 */     AbstractBlock clone = (AbstractBlock)super.clone();
/* 630 */     clone.bounds = (Rectangle2D)ShapeUtilities.clone(this.bounds);
/* 631 */     if (this.frame instanceof PublicCloneable) {
/* 632 */       PublicCloneable pc = (PublicCloneable)this.frame;
/* 633 */       clone.frame = (BlockFrame)pc.clone();
/*     */     } 
/* 635 */     return clone;
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
/* 646 */     stream.defaultWriteObject();
/* 647 */     SerialUtilities.writeShape(this.bounds, stream);
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
/* 660 */     stream.defaultReadObject();
/* 661 */     this.bounds = (Rectangle2D)SerialUtilities.readShape(stream);
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/block/AbstractBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */