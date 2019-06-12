/*     */ package org.jfree.chart.axis;
/*     */ 
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.io.Serializable;
/*     */ import org.jfree.chart.util.ParamChecks;
/*     */ import org.jfree.ui.RectangleEdge;
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
/*     */ public class AxisSpace
/*     */   implements Cloneable, PublicCloneable, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -2490732595134766305L;
/*     */   private double top;
/*     */   private double bottom;
/*     */   private double left;
/*     */   private double right;
/*     */   
/*     */   public AxisSpace() {
/*  81 */     this.top = 0.0D;
/*  82 */     this.bottom = 0.0D;
/*  83 */     this.left = 0.0D;
/*  84 */     this.right = 0.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  93 */   public double getTop() { return this.top; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 102 */   public void setTop(double space) { this.top = space; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 111 */   public double getBottom() { return this.bottom; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 120 */   public void setBottom(double space) { this.bottom = space; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 129 */   public double getLeft() { return this.left; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 138 */   public void setLeft(double space) { this.left = space; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 147 */   public double getRight() { return this.right; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 156 */   public void setRight(double space) { this.right = space; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(double space, RectangleEdge edge) {
/* 166 */     ParamChecks.nullNotPermitted(edge, "edge");
/* 167 */     if (edge == RectangleEdge.TOP) {
/* 168 */       this.top += space;
/*     */     }
/* 170 */     else if (edge == RectangleEdge.BOTTOM) {
/* 171 */       this.bottom += space;
/*     */     }
/* 173 */     else if (edge == RectangleEdge.LEFT) {
/* 174 */       this.left += space;
/*     */     }
/* 176 */     else if (edge == RectangleEdge.RIGHT) {
/* 177 */       this.right += space;
/*     */     } else {
/*     */       
/* 180 */       throw new IllegalStateException("Unrecognised 'edge' argument.");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ensureAtLeast(AxisSpace space) {
/* 190 */     this.top = Math.max(this.top, space.top);
/* 191 */     this.bottom = Math.max(this.bottom, space.bottom);
/* 192 */     this.left = Math.max(this.left, space.left);
/* 193 */     this.right = Math.max(this.right, space.right);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ensureAtLeast(double space, RectangleEdge edge) {
/* 204 */     if (edge == RectangleEdge.TOP) {
/* 205 */       if (this.top < space) {
/* 206 */         this.top = space;
/*     */       }
/*     */     }
/* 209 */     else if (edge == RectangleEdge.BOTTOM) {
/* 210 */       if (this.bottom < space) {
/* 211 */         this.bottom = space;
/*     */       }
/*     */     }
/* 214 */     else if (edge == RectangleEdge.LEFT) {
/* 215 */       if (this.left < space) {
/* 216 */         this.left = space;
/*     */       }
/*     */     }
/* 219 */     else if (edge == RectangleEdge.RIGHT) {
/* 220 */       if (this.right < space) {
/* 221 */         this.right = space;
/*     */       }
/*     */     } else {
/*     */       
/* 225 */       throw new IllegalStateException("AxisSpace.ensureAtLeast(): unrecognised AxisLocation.");
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
/*     */   public Rectangle2D shrink(Rectangle2D area, Rectangle2D result) {
/* 240 */     if (result == null) {
/* 241 */       result = new Rectangle2D.Double();
/*     */     }
/* 243 */     result.setRect(area
/* 244 */         .getX() + this.left, area
/* 245 */         .getY() + this.top, area
/* 246 */         .getWidth() - this.left - this.right, area
/* 247 */         .getHeight() - this.top - this.bottom);
/*     */     
/* 249 */     return result;
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
/*     */   public Rectangle2D expand(Rectangle2D area, Rectangle2D result) {
/* 261 */     if (result == null) {
/* 262 */       result = new Rectangle2D.Double();
/*     */     }
/* 264 */     result.setRect(area
/* 265 */         .getX() - this.left, area
/* 266 */         .getY() - this.top, area
/* 267 */         .getWidth() + this.left + this.right, area
/* 268 */         .getHeight() + this.top + this.bottom);
/*     */     
/* 270 */     return result;
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
/*     */   public Rectangle2D reserved(Rectangle2D area, RectangleEdge edge) {
/* 282 */     Rectangle2D result = null;
/* 283 */     if (edge == RectangleEdge.TOP) {
/*     */       
/* 285 */       result = new Rectangle2D.Double(area.getX(), area.getY(), area.getWidth(), this.top);
/*     */     
/*     */     }
/* 288 */     else if (edge == RectangleEdge.BOTTOM) {
/*     */ 
/*     */       
/* 291 */       result = new Rectangle2D.Double(area.getX(), area.getMaxY() - this.top, area.getWidth(), this.bottom);
/*     */     
/*     */     }
/* 294 */     else if (edge == RectangleEdge.LEFT) {
/*     */       
/* 296 */       result = new Rectangle2D.Double(area.getX(), area.getY(), this.left, area.getHeight());
/*     */     
/*     */     }
/* 299 */     else if (edge == RectangleEdge.RIGHT) {
/*     */ 
/*     */       
/* 302 */       result = new Rectangle2D.Double(area.getMaxX() - this.right, area.getY(), this.right, area.getHeight());
/*     */     } 
/*     */     
/* 305 */     return result;
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
/* 318 */   public Object clone() throws CloneNotSupportedException { return super.clone(); }
/*     */ 
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
/* 330 */     if (obj == this) {
/* 331 */       return true;
/*     */     }
/* 333 */     if (!(obj instanceof AxisSpace)) {
/* 334 */       return false;
/*     */     }
/* 336 */     AxisSpace that = (AxisSpace)obj;
/* 337 */     if (this.top != that.top) {
/* 338 */       return false;
/*     */     }
/* 340 */     if (this.bottom != that.bottom) {
/* 341 */       return false;
/*     */     }
/* 343 */     if (this.left != that.left) {
/* 344 */       return false;
/*     */     }
/* 346 */     if (this.right != that.right) {
/* 347 */       return false;
/*     */     }
/* 349 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 359 */     result = 23;
/* 360 */     long l = Double.doubleToLongBits(this.top);
/* 361 */     result = 37 * result + (int)(l ^ l >>> 32);
/* 362 */     l = Double.doubleToLongBits(this.bottom);
/* 363 */     result = 37 * result + (int)(l ^ l >>> 32);
/* 364 */     l = Double.doubleToLongBits(this.left);
/* 365 */     result = 37 * result + (int)(l ^ l >>> 32);
/* 366 */     l = Double.doubleToLongBits(this.right);
/* 367 */     return 37 * result + (int)(l ^ l >>> 32);
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
/* 378 */   public String toString() { return super.toString() + "[left=" + this.left + ",right=" + this.right + ",top=" + this.top + ",bottom=" + this.bottom + "]"; }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/axis/AxisSpace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */