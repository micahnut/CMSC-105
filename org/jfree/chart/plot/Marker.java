/*     */ package org.jfree.chart.plot;
/*     */ 
/*     */ import java.awt.BasicStroke;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.Paint;
/*     */ import java.awt.Stroke;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.EventListener;
/*     */ import javax.swing.event.EventListenerList;
/*     */ import org.jfree.chart.event.MarkerChangeEvent;
/*     */ import org.jfree.chart.event.MarkerChangeListener;
/*     */ import org.jfree.chart.util.ParamChecks;
/*     */ import org.jfree.io.SerialUtilities;
/*     */ import org.jfree.ui.LengthAdjustmentType;
/*     */ import org.jfree.ui.RectangleAnchor;
/*     */ import org.jfree.ui.RectangleInsets;
/*     */ import org.jfree.ui.TextAnchor;
/*     */ import org.jfree.util.ObjectUtilities;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class Marker
/*     */   implements Cloneable, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -734389651405327166L;
/*     */   private Paint paint;
/*     */   private Stroke stroke;
/*     */   private Paint outlinePaint;
/*     */   private Stroke outlineStroke;
/*     */   private float alpha;
/* 116 */   private String label = null;
/*     */ 
/*     */ 
/*     */   
/*     */   private Font labelFont;
/*     */ 
/*     */ 
/*     */   
/*     */   private Paint labelPaint;
/*     */ 
/*     */ 
/*     */   
/*     */   private Color labelBackgroundColor;
/*     */ 
/*     */ 
/*     */   
/*     */   private RectangleAnchor labelAnchor;
/*     */ 
/*     */   
/*     */   private TextAnchor labelTextAnchor;
/*     */ 
/*     */   
/*     */   private RectangleInsets labelOffset;
/*     */ 
/*     */   
/*     */   private LengthAdjustmentType labelOffsetType;
/*     */ 
/*     */   
/*     */   private EventListenerList listenerList;
/*     */ 
/*     */ 
/*     */   
/* 148 */   protected Marker() { this(Color.gray); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 157 */   protected Marker(Paint paint) { this(paint, new BasicStroke(0.5F), Color.gray, new BasicStroke(0.5F), 0.8F); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Marker(Paint paint, Stroke stroke, Paint outlinePaint, Stroke outlineStroke, float alpha) {
/* 178 */     ParamChecks.nullNotPermitted(paint, "paint");
/* 179 */     ParamChecks.nullNotPermitted(stroke, "stroke");
/* 180 */     if (alpha < 0.0F || alpha > 1.0F) {
/* 181 */       throw new IllegalArgumentException("The 'alpha' value must be in the range 0.0f to 1.0f");
/*     */     }
/*     */ 
/*     */     
/* 185 */     this.paint = paint;
/* 186 */     this.stroke = stroke;
/* 187 */     this.outlinePaint = outlinePaint;
/* 188 */     this.outlineStroke = outlineStroke;
/* 189 */     this.alpha = alpha;
/*     */     
/* 191 */     this.labelFont = new Font("SansSerif", false, 9);
/* 192 */     this.labelPaint = Color.black;
/* 193 */     this.labelBackgroundColor = new Color(100, 100, 100, 100);
/* 194 */     this.labelAnchor = RectangleAnchor.TOP_LEFT;
/* 195 */     this.labelOffset = new RectangleInsets(3.0D, 3.0D, 3.0D, 3.0D);
/* 196 */     this.labelOffsetType = LengthAdjustmentType.CONTRACT;
/* 197 */     this.labelTextAnchor = TextAnchor.CENTER;
/*     */     
/* 199 */     this.listenerList = new EventListenerList();
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
/* 210 */   public Paint getPaint() { return this.paint; }
/*     */ 
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
/* 222 */     ParamChecks.nullNotPermitted(paint, "paint");
/* 223 */     this.paint = paint;
/* 224 */     notifyListeners(new MarkerChangeEvent(this));
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
/* 235 */   public Stroke getStroke() { return this.stroke; }
/*     */ 
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
/* 247 */     ParamChecks.nullNotPermitted(stroke, "stroke");
/* 248 */     this.stroke = stroke;
/* 249 */     notifyListeners(new MarkerChangeEvent(this));
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
/* 260 */   public Paint getOutlinePaint() { return this.outlinePaint; }
/*     */ 
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
/* 272 */     this.outlinePaint = paint;
/* 273 */     notifyListeners(new MarkerChangeEvent(this));
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
/* 284 */   public Stroke getOutlineStroke() { return this.outlineStroke; }
/*     */ 
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
/* 296 */     this.outlineStroke = stroke;
/* 297 */     notifyListeners(new MarkerChangeEvent(this));
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
/* 308 */   public float getAlpha() { return this.alpha; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAlpha(float alpha) {
/* 326 */     if (alpha < 0.0F || alpha > 1.0F) {
/* 327 */       throw new IllegalArgumentException("The 'alpha' value must be in the range 0.0f to 1.0f");
/*     */     }
/*     */     
/* 330 */     this.alpha = alpha;
/* 331 */     notifyListeners(new MarkerChangeEvent(this));
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
/* 342 */   public String getLabel() { return this.label; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLabel(String label) {
/* 354 */     this.label = label;
/* 355 */     notifyListeners(new MarkerChangeEvent(this));
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
/* 366 */   public Font getLabelFont() { return this.labelFont; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLabelFont(Font font) {
/* 378 */     ParamChecks.nullNotPermitted(font, "font");
/* 379 */     this.labelFont = font;
/* 380 */     notifyListeners(new MarkerChangeEvent(this));
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
/* 391 */   public Paint getLabelPaint() { return this.labelPaint; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLabelPaint(Paint paint) {
/* 403 */     ParamChecks.nullNotPermitted(paint, "paint");
/* 404 */     this.labelPaint = paint;
/* 405 */     notifyListeners(new MarkerChangeEvent(this));
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
/* 417 */   public Color getLabelBackgroundColor() { return this.labelBackgroundColor; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLabelBackgroundColor(Color color) {
/* 428 */     ParamChecks.nullNotPermitted(color, "color");
/* 429 */     this.labelBackgroundColor = color;
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
/* 441 */   public RectangleAnchor getLabelAnchor() { return this.labelAnchor; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLabelAnchor(RectangleAnchor anchor) {
/* 454 */     ParamChecks.nullNotPermitted(anchor, "anchor");
/* 455 */     this.labelAnchor = anchor;
/* 456 */     notifyListeners(new MarkerChangeEvent(this));
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
/* 467 */   public RectangleInsets getLabelOffset() { return this.labelOffset; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLabelOffset(RectangleInsets offset) {
/* 479 */     ParamChecks.nullNotPermitted(offset, "offset");
/* 480 */     this.labelOffset = offset;
/* 481 */     notifyListeners(new MarkerChangeEvent(this));
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
/* 492 */   public LengthAdjustmentType getLabelOffsetType() { return this.labelOffsetType; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLabelOffsetType(LengthAdjustmentType adj) {
/* 504 */     ParamChecks.nullNotPermitted(adj, "adj");
/* 505 */     this.labelOffsetType = adj;
/* 506 */     notifyListeners(new MarkerChangeEvent(this));
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
/* 517 */   public TextAnchor getLabelTextAnchor() { return this.labelTextAnchor; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLabelTextAnchor(TextAnchor anchor) {
/* 529 */     ParamChecks.nullNotPermitted(anchor, "anchor");
/* 530 */     this.labelTextAnchor = anchor;
/* 531 */     notifyListeners(new MarkerChangeEvent(this));
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
/* 544 */   public void addChangeListener(MarkerChangeListener listener) { this.listenerList.add(MarkerChangeListener.class, listener); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 557 */   public void removeChangeListener(MarkerChangeListener listener) { this.listenerList.remove(MarkerChangeListener.class, listener); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void notifyListeners(MarkerChangeEvent event) {
/* 569 */     Object[] listeners = this.listenerList.getListenerList();
/* 570 */     for (int i = listeners.length - 2; i >= 0; i -= 2) {
/* 571 */       if (listeners[i] == MarkerChangeListener.class) {
/* 572 */         ((MarkerChangeListener)listeners[i + 1]).markerChanged(event);
/*     */       }
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
/*     */ 
/*     */   
/* 588 */   public EventListener[] getListeners(Class listenerType) { return this.listenerList.getListeners(listenerType); }
/*     */ 
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
/* 600 */     if (obj == this) {
/* 601 */       return true;
/*     */     }
/* 603 */     if (!(obj instanceof Marker)) {
/* 604 */       return false;
/*     */     }
/* 606 */     Marker that = (Marker)obj;
/* 607 */     if (!PaintUtilities.equal(this.paint, that.paint)) {
/* 608 */       return false;
/*     */     }
/* 610 */     if (!ObjectUtilities.equal(this.stroke, that.stroke)) {
/* 611 */       return false;
/*     */     }
/* 613 */     if (!PaintUtilities.equal(this.outlinePaint, that.outlinePaint)) {
/* 614 */       return false;
/*     */     }
/* 616 */     if (!ObjectUtilities.equal(this.outlineStroke, that.outlineStroke)) {
/* 617 */       return false;
/*     */     }
/* 619 */     if (this.alpha != that.alpha) {
/* 620 */       return false;
/*     */     }
/* 622 */     if (!ObjectUtilities.equal(this.label, that.label)) {
/* 623 */       return false;
/*     */     }
/* 625 */     if (!ObjectUtilities.equal(this.labelFont, that.labelFont)) {
/* 626 */       return false;
/*     */     }
/* 628 */     if (!PaintUtilities.equal(this.labelPaint, that.labelPaint)) {
/* 629 */       return false;
/*     */     }
/* 631 */     if (!this.labelBackgroundColor.equals(that.labelBackgroundColor)) {
/* 632 */       return false;
/*     */     }
/* 634 */     if (this.labelAnchor != that.labelAnchor) {
/* 635 */       return false;
/*     */     }
/* 637 */     if (this.labelTextAnchor != that.labelTextAnchor) {
/* 638 */       return false;
/*     */     }
/* 640 */     if (!ObjectUtilities.equal(this.labelOffset, that.labelOffset)) {
/* 641 */       return false;
/*     */     }
/* 643 */     if (!this.labelOffsetType.equals(that.labelOffsetType)) {
/* 644 */       return false;
/*     */     }
/* 646 */     return true;
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
/* 658 */   public Object clone() throws CloneNotSupportedException { return super.clone(); }
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
/* 669 */     stream.defaultWriteObject();
/* 670 */     SerialUtilities.writePaint(this.paint, stream);
/* 671 */     SerialUtilities.writeStroke(this.stroke, stream);
/* 672 */     SerialUtilities.writePaint(this.outlinePaint, stream);
/* 673 */     SerialUtilities.writeStroke(this.outlineStroke, stream);
/* 674 */     SerialUtilities.writePaint(this.labelPaint, stream);
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
/* 687 */     stream.defaultReadObject();
/* 688 */     this.paint = SerialUtilities.readPaint(stream);
/* 689 */     this.stroke = SerialUtilities.readStroke(stream);
/* 690 */     this.outlinePaint = SerialUtilities.readPaint(stream);
/* 691 */     this.outlineStroke = SerialUtilities.readStroke(stream);
/* 692 */     this.labelPaint = SerialUtilities.readPaint(stream);
/* 693 */     this.listenerList = new EventListenerList();
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/plot/Marker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */