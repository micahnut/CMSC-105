/*     */ package org.jfree.chart.block;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Paint;
/*     */ import java.awt.Shape;
/*     */ import java.awt.geom.Point2D;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import org.jfree.chart.entity.ChartEntity;
/*     */ import org.jfree.chart.entity.StandardEntityCollection;
/*     */ import org.jfree.chart.util.ParamChecks;
/*     */ import org.jfree.io.SerialUtilities;
/*     */ import org.jfree.text.TextBlock;
/*     */ import org.jfree.text.TextBlockAnchor;
/*     */ import org.jfree.text.TextUtilities;
/*     */ import org.jfree.ui.RectangleAnchor;
/*     */ import org.jfree.ui.Size2D;
/*     */ import org.jfree.util.ObjectUtilities;
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
/*     */ public class LabelBlock
/*     */   extends AbstractBlock
/*     */   implements Block, PublicCloneable
/*     */ {
/*     */   static final long serialVersionUID = 249626098864178017L;
/*     */   private String text;
/*     */   private TextBlock label;
/*     */   private Font font;
/*     */   private String toolTipText;
/*     */   private String urlText;
/* 106 */   public static final Paint DEFAULT_PAINT = Color.black;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Paint paint;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private TextBlockAnchor contentAlignmentPoint;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private RectangleAnchor textAnchor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 131 */   public LabelBlock(String label) { this(label, new Font("SansSerif", false, 10), DEFAULT_PAINT); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 141 */   public LabelBlock(String text, Font font) { this(text, font, DEFAULT_PAINT); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LabelBlock(String text, Font font, Paint paint) {
/* 152 */     this.text = text;
/* 153 */     this.paint = paint;
/* 154 */     this.label = TextUtilities.createTextBlock(text, font, this.paint);
/* 155 */     this.font = font;
/* 156 */     this.toolTipText = null;
/* 157 */     this.urlText = null;
/* 158 */     this.contentAlignmentPoint = TextBlockAnchor.CENTER;
/* 159 */     this.textAnchor = RectangleAnchor.CENTER;
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
/* 170 */   public Font getFont() { return this.font; }
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
/* 181 */     ParamChecks.nullNotPermitted(font, "font");
/* 182 */     this.font = font;
/* 183 */     this.label = TextUtilities.createTextBlock(this.text, font, this.paint);
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
/* 194 */   public Paint getPaint() { return this.paint; }
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
/* 205 */     ParamChecks.nullNotPermitted(paint, "paint");
/* 206 */     this.paint = paint;
/* 207 */     this.label = TextUtilities.createTextBlock(this.text, this.font, this.paint);
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
/* 219 */   public String getToolTipText() { return this.toolTipText; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 230 */   public void setToolTipText(String text) { this.toolTipText = text; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 241 */   public String getURLText() { return this.urlText; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 252 */   public void setURLText(String text) { this.urlText = text; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 263 */   public TextBlockAnchor getContentAlignmentPoint() { return this.contentAlignmentPoint; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setContentAlignmentPoint(TextBlockAnchor anchor) {
/* 275 */     ParamChecks.nullNotPermitted(anchor, "anchor");
/* 276 */     this.contentAlignmentPoint = anchor;
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
/* 287 */   public RectangleAnchor getTextAnchor() { return this.textAnchor; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 298 */   public void setTextAnchor(RectangleAnchor anchor) { this.textAnchor = anchor; }
/*     */ 
/*     */ 
/*     */ 
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
/* 312 */     g2.setFont(this.font);
/* 313 */     Size2D s = this.label.calculateDimensions(g2);
/* 314 */     return new Size2D(calculateTotalWidth(s.getWidth()), 
/* 315 */         calculateTotalHeight(s.getHeight()));
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
/* 326 */   public void draw(Graphics2D g2, Rectangle2D area) { draw(g2, area, null); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object draw(Graphics2D g2, Rectangle2D area, Object params) {
/* 340 */     area = trimMargin(area);
/* 341 */     drawBorder(g2, area);
/* 342 */     area = trimBorder(area);
/* 343 */     area = trimPadding(area);
/*     */ 
/*     */     
/* 346 */     EntityBlockParams ebp = null;
/* 347 */     StandardEntityCollection sec = null;
/* 348 */     Shape entityArea = null;
/* 349 */     if (params instanceof EntityBlockParams) {
/* 350 */       ebp = (EntityBlockParams)params;
/* 351 */       if (ebp.getGenerateEntities()) {
/* 352 */         sec = new StandardEntityCollection();
/* 353 */         entityArea = (Shape)area.clone();
/*     */       } 
/*     */     } 
/* 356 */     g2.setPaint(this.paint);
/* 357 */     g2.setFont(this.font);
/* 358 */     Point2D pt = RectangleAnchor.coordinates(area, this.textAnchor);
/* 359 */     this.label.draw(g2, (float)pt.getX(), (float)pt.getY(), this.contentAlignmentPoint);
/*     */     
/* 361 */     BlockResult result = null;
/* 362 */     if (ebp != null && sec != null && (
/* 363 */       this.toolTipText != null || this.urlText != null)) {
/* 364 */       ChartEntity entity = new ChartEntity(entityArea, this.toolTipText, this.urlText);
/*     */       
/* 366 */       sec.add(entity);
/* 367 */       result = new BlockResult();
/* 368 */       result.setEntityCollection(sec);
/*     */     } 
/*     */     
/* 371 */     return result;
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
/* 384 */     if (!(obj instanceof LabelBlock)) {
/* 385 */       return false;
/*     */     }
/* 387 */     LabelBlock that = (LabelBlock)obj;
/* 388 */     if (!this.text.equals(that.text)) {
/* 389 */       return false;
/*     */     }
/* 391 */     if (!this.font.equals(that.font)) {
/* 392 */       return false;
/*     */     }
/* 394 */     if (!PaintUtilities.equal(this.paint, that.paint)) {
/* 395 */       return false;
/*     */     }
/* 397 */     if (!ObjectUtilities.equal(this.toolTipText, that.toolTipText)) {
/* 398 */       return false;
/*     */     }
/* 400 */     if (!ObjectUtilities.equal(this.urlText, that.urlText)) {
/* 401 */       return false;
/*     */     }
/* 403 */     if (!this.contentAlignmentPoint.equals(that.contentAlignmentPoint)) {
/* 404 */       return false;
/*     */     }
/* 406 */     if (!this.textAnchor.equals(that.textAnchor)) {
/* 407 */       return false;
/*     */     }
/* 409 */     return super.equals(obj);
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
/* 421 */   public Object clone() throws CloneNotSupportedException { return super.clone(); }
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
/* 432 */     stream.defaultWriteObject();
/* 433 */     SerialUtilities.writePaint(this.paint, stream);
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
/* 446 */     stream.defaultReadObject();
/* 447 */     this.paint = SerialUtilities.readPaint(stream);
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/block/LabelBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */