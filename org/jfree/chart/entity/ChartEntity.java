/*     */ package org.jfree.chart.entity;
/*     */ 
/*     */ import java.awt.Shape;
/*     */ import java.awt.geom.PathIterator;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import org.jfree.chart.HashUtilities;
/*     */ import org.jfree.chart.imagemap.ToolTipTagFragmentGenerator;
/*     */ import org.jfree.chart.imagemap.URLTagFragmentGenerator;
/*     */ import org.jfree.chart.util.ParamChecks;
/*     */ import org.jfree.io.SerialUtilities;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ChartEntity
/*     */   implements Cloneable, PublicCloneable, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -4445994133561919083L;
/*     */   private Shape area;
/*     */   private String toolTipText;
/*     */   private String urlText;
/*     */   
/* 117 */   public ChartEntity(Shape area) { this(area, null); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 128 */   public ChartEntity(Shape area, String toolTipText) { this(area, toolTipText, null); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ChartEntity(Shape area, String toolTipText, String urlText) {
/* 140 */     ParamChecks.nullNotPermitted(area, "area");
/* 141 */     this.area = area;
/* 142 */     this.toolTipText = toolTipText;
/* 143 */     this.urlText = urlText;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 152 */   public Shape getArea() { return this.area; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setArea(Shape area) {
/* 165 */     ParamChecks.nullNotPermitted(area, "area");
/* 166 */     this.area = area;
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
/* 178 */   public String getToolTipText() { return this.toolTipText; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 187 */   public void setToolTipText(String text) { this.toolTipText = text; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 198 */   public String getURLText() { return this.urlText; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 207 */   public void setURLText(String text) { this.urlText = text; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getShapeType() {
/* 217 */     if (this.area instanceof Rectangle2D) {
/* 218 */       return "rect";
/*     */     }
/*     */     
/* 221 */     return "poly";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getShapeCoords() {
/* 231 */     if (this.area instanceof Rectangle2D) {
/* 232 */       return getRectCoords((Rectangle2D)this.area);
/*     */     }
/*     */     
/* 235 */     return getPolyCoords(this.area);
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
/*     */   private String getRectCoords(Rectangle2D rectangle) {
/* 248 */     ParamChecks.nullNotPermitted(rectangle, "rectangle");
/* 249 */     int x1 = (int)rectangle.getX();
/* 250 */     int y1 = (int)rectangle.getY();
/* 251 */     int x2 = x1 + (int)rectangle.getWidth();
/* 252 */     int y2 = y1 + (int)rectangle.getHeight();
/*     */     
/* 254 */     if (x2 == x1) {
/* 255 */       x2++;
/*     */     }
/* 257 */     if (y2 == y1) {
/* 258 */       y2++;
/*     */     }
/*     */     
/* 261 */     return x1 + "," + y1 + "," + x2 + "," + y2;
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
/*     */   private String getPolyCoords(Shape shape) {
/* 273 */     ParamChecks.nullNotPermitted(shape, "shape");
/* 274 */     StringBuilder result = new StringBuilder();
/* 275 */     boolean first = true;
/* 276 */     float[] coords = new float[6];
/* 277 */     PathIterator pi = shape.getPathIterator(null, 1.0D);
/* 278 */     while (!pi.isDone()) {
/* 279 */       pi.currentSegment(coords);
/* 280 */       if (first) {
/* 281 */         first = false;
/* 282 */         result.append((int)coords[0]);
/* 283 */         result.append(",").append((int)coords[1]);
/*     */       } else {
/*     */         
/* 286 */         result.append(",");
/* 287 */         result.append((int)coords[0]);
/* 288 */         result.append(",");
/* 289 */         result.append((int)coords[1]);
/*     */       } 
/* 291 */       pi.next();
/*     */     } 
/* 293 */     return result.toString();
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
/*     */   public String getImageMapAreaTag(ToolTipTagFragmentGenerator toolTipTagFragmentGenerator, URLTagFragmentGenerator urlTagFragmentGenerator) {
/* 313 */     StringBuilder tag = new StringBuilder();
/*     */     
/* 315 */     boolean hasURL = (this.urlText == null) ? false : (!this.urlText.equals(""));
/*     */     
/* 317 */     boolean hasToolTip = (this.toolTipText == null) ? false : (!this.toolTipText.equals(""));
/* 318 */     if (hasURL || hasToolTip) {
/* 319 */       tag.append("<area shape=\"").append(getShapeType()).append("\"")
/* 320 */         .append(" coords=\"").append(getShapeCoords()).append("\"");
/* 321 */       if (hasToolTip) {
/* 322 */         tag.append(toolTipTagFragmentGenerator.generateToolTipFragment(this.toolTipText));
/*     */       }
/*     */       
/* 325 */       if (hasURL) {
/* 326 */         tag.append(urlTagFragmentGenerator.generateURLFragment(this.urlText));
/*     */       }
/*     */       else {
/*     */         
/* 330 */         tag.append(" nohref=\"nohref\"");
/*     */       } 
/*     */ 
/*     */       
/* 334 */       if (!hasToolTip) {
/* 335 */         tag.append(" alt=\"\"");
/*     */       }
/* 337 */       tag.append("/>");
/*     */     } 
/* 339 */     return tag.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 350 */     StringBuilder sb = new StringBuilder("ChartEntity: ");
/* 351 */     sb.append("tooltip = ");
/* 352 */     sb.append(this.toolTipText);
/* 353 */     return sb.toString();
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
/* 365 */     if (obj == this) {
/* 366 */       return true;
/*     */     }
/* 368 */     if (!(obj instanceof ChartEntity)) {
/* 369 */       return false;
/*     */     }
/* 371 */     ChartEntity that = (ChartEntity)obj;
/* 372 */     if (!this.area.equals(that.area)) {
/* 373 */       return false;
/*     */     }
/* 375 */     if (!ObjectUtilities.equal(this.toolTipText, that.toolTipText)) {
/* 376 */       return false;
/*     */     }
/* 378 */     if (!ObjectUtilities.equal(this.urlText, that.urlText)) {
/* 379 */       return false;
/*     */     }
/* 381 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 391 */     result = 37;
/* 392 */     result = HashUtilities.hashCode(result, this.toolTipText);
/* 393 */     return HashUtilities.hashCode(result, this.urlText);
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
/* 407 */   public Object clone() throws CloneNotSupportedException { return super.clone(); }
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
/* 418 */     stream.defaultWriteObject();
/* 419 */     SerialUtilities.writeShape(this.area, stream);
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
/* 432 */     stream.defaultReadObject();
/* 433 */     this.area = SerialUtilities.readShape(stream);
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/entity/ChartEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */